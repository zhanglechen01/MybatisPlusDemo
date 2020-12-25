package com.yitao.notice.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.yitao.notice.dao.source1.NoticeManageMapper;
import com.yitao.notice.dao.source1.UserAuthoBuyerMapper;
import com.yitao.notice.dao.source1.UserMapper;
import com.yitao.notice.entity.NoticeInfoEntity;
import com.yitao.notice.entity.User;
import com.yitao.notice.entity.UserAuthoBuyer;
import com.yitao.utils.tools.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;


/**
 * 用户service
 */

@Slf4j
@Service
public class UserService {
	@Autowired
	private  UserMapper userMapper;
	@Autowired
	private UserAuthoBuyerMapper userAuthoBuyerMapper;

	@Autowired
	private NoticeManageMapper noticeManageMapper;

	@Value("${app.loanurl}")
	private String loanurl ;

	@Value("${app.syndate}")
	private int synDate ;

	private ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-mqRun-runner-%d").build();
	private ExecutorService poolExecutor = new ThreadPoolExecutor(5,30,200L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1000),namedThreadFactory);
	private static boolean flag = false;

	//查询过期时间
	public void getExpireData(){
			//前7天
			String preSevDay = DateUtils.formatDate(DateUtils.getdayForNum(synDate));
			List<User> users = userMapper.selectList(Wrappers.<User>lambdaQuery().select(User::getUNick,User::getUExpireDate).apply("date_format(uExpireDate,'%Y-%m-%d') = {0}", preSevDay));
			if(users != null && users.size() > 0){
				for (int i = 0; i < users.size(); i++) {
					saveNoticeInfo(users.get(i));
				}
			}
	}

	public void saveNoticeInfo(User user){
		poolExecutor.execute(new Runnable() {
			@Override
			public void run() {
				List<UserAuthoBuyer> userAuthoBuyers = userAuthoBuyerMapper.selectList(Wrappers.<UserAuthoBuyer>lambdaQuery().eq(UserAuthoBuyer::getNick, user.getUNick()));
				if(userAuthoBuyers !=null && userAuthoBuyers.size() > 0){
					List<String> tonicks = userAuthoBuyers.stream().map(UserAuthoBuyer::getToNick).collect(Collectors.toList());
					for (String tonick : tonicks) {
						NoticeInfoEntity nti = new NoticeInfoEntity();
						nti.setCreateTime(DateUtils.getDateTime());
						nti.setNoticeInfo("店铺 : "+user.getUNick()+", 即将在"+user.getUExpireDate()+"到期，请及时充值！");
						nti.setType(1);//用户过期提醒
						nti.setOpenUrl(loanurl);
						nti.setUnick(tonick);
						noticeManageMapper.insertNotice(nti);
					}
				}
			}
		});
	}

}
