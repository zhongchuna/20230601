package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import cn.key.mapping.UserInfoMapping;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.entity.UserInfoHobby;

public class UserInfoDAO {
	private JdbcTemplate template = new JdbcTemplate();
	// 注册学生信息 
	public boolean save(UserInfo userinfo) {
		int row = 0;
		String sql = "insert into userinfo(username,password,sex,major,intro)"+
						"values(?,?,?,?,?)";
		
		Object[] values = new Object[]{ 
		userinfo.getUsername(),
		userinfo.getPassword(),
		userinfo.getSex(),
		userinfo.getMajor(),
		userinfo.getIntro()};
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	//  更新学生信息之前 先伦理删除
	public boolean delUserInfo(String username) {
		int row = 0;
		String sql = "update userinfo set delFlg='1'  where username = ?";
		
		Object[] values = new Object[]{ 
		           username};
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	//  自己确认后  手动后加的  不知道对不对 
	public List<UserInfo> findUserInfo(String username,String sex,String major){
		String sql = "select * from userinfo where delflg = '0'and";
		
		// 如果username存在，那么就把username放入sql文当中作为筛选条件
		if(!"".equals(username)) {
			sql =sql + " userinfo.username ='" +username +  "'and";
		}
		
		// sex为前台必传的，那么不用判断是否为空字符串，直接放入sql文当中作为筛选条件
		sql =sql + " sex ='" +  sex + "'";
		
		// 如果major存在，那么就把major放入sql文当中作为筛选条件
		if(!"".equals(major)) {
			sql =sql + " and major ='" +  major +  "'";
		}
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			list = template.selete(sql, new UserInfoMapping ());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//这里没整明白  
		return list;
	}
	// 通过姓名性别专业  查询学生信息  性别默认为男  
	public List<UserInfoHobby > findUserInfoAndHobby(String username,String sex,String major) {
	
		System.out.println(username);
		System.out.println(sex);
		System.out.println(major);
		String sql = "select userinfo.username,password,sex,major,intro,hobby from userinfo "
				+ "left join hobby on userinfo.username = hobby.username where ";
		
		// 如果username存在，那么就把username放入sql文当中作为筛选条件
		if(!"".equals(username)) {
			sql =sql + " userinfo.username ='" +username +  "'and";
		}
		
		// sex为前台必传的，那么不用判断是否为空字符串，直接放入sql文当中作为筛选条件
		sql =sql + " sex ='" +  sex + "'";
	
		// 如果major存在，那么就把major放入sql文当中作为筛选条件
		if(!"".equals(major)) {
			sql =sql + " and major ='" +  major +  "'";
		}
		sql =sql + "and userinfo.delFlg = '0'and hobby.delFlg='0'";
		// 接收检索出来的所有数据，预备着
		List<UserInfoHobby> list = new ArrayList<UserInfoHobby>();
		try {
			list = template.selete(sql, new UserInfoMapping ());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	// 通过姓名查询学生信息  
	public List<UserInfoHobby> findUserInfoAndHobby(String username) {
		//
		System.out.println(username);
		String sql = "select userinfo.username,password,sex,major,intro,hobby from userinfo "
				+ "left join hobby on userinfo.username = hobby.username where userinfo.username ='";
		
		// 如果username存在，那么就把username放入sql文当中作为筛选条件
		
			sql =sql  +username + "'and userinfo.delFlg = '0'and hobby.delFlg='0'";
		
		// 接收检索出来的所有数据，预备着
		List<UserInfoHobby> list = new ArrayList<UserInfoHobby>();
		try {
			list = template.selete(sql, new UserInfoMapping ());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
}

