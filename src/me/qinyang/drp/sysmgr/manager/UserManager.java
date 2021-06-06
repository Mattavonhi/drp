package me.qinyang.drp.sysmgr.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import me.qinyang.drp.sysmgr.domain.User;
import me.qinyang.drp.util.DbUtil;

public class UserManager {
	private static UserManager instance = null;
	
	private UserManager(){
		
	}
	
	public static synchronized UserManager getInstance(){
		if(instance == null){
			instance = new UserManager();
		}
		return instance;
	}
	
	//ÃÌº””√ªß
	public void addUser(User user){
		String sql = "insert into t_user(user_id, user_name, password, conact_tel, email, create_time)"
 + " values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getContactTel());
			pstmt.setString(5, user.getEmail());
			pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
			DbUtil.close(pstmt);
		}
	}
}
