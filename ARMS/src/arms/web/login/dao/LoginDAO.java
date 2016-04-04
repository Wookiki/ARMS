package arms.web.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import arms.web.login.vo.UserInfo;

public class LoginDAO {
	private static LoginDAO loginDAO;
	private Connection con;
	
	private LoginDAO() {
		// TODO Auto-generated constructor stub
	}
	public static LoginDAO getInstance(){
		if(loginDAO==null){
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}
	public void setConnection(Connection con){
		this.con = con;
	}
	public UserInfo selectLoginUser(String u_id, String u_passwd) {
		// TODO Auto-generated method stub
		UserInfo loginUser = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM USERINFO WHERE u_id = ? AND u_passwd = ?";
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);
			pstmt.setString(2, u_passwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				loginUser = new UserInfo();
				loginUser.setU_id(u_id);
				loginUser.setU_passwd(u_passwd);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginUser;
	}
}
