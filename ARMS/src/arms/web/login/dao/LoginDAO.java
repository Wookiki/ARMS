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
		if(loginDAO == null){
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}
	public UserInfo selectLoginUser(String u_id) {
		// TODO Auto-generated method stub
		UserInfo loginUser = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM USERINFO WHERE u_id=?";
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				loginUser = new UserInfo();
				loginUser.setU_id(rs.getString("u_id"));
				loginUser.setU_passwd(rs.getString("u_passwd"));
				loginUser.setU_name(rs.getString("u_name"));
				loginUser.setU_dong(rs.getString("u_dong"));
				loginUser.setU_ho(rs.getInt("u_ho"));
				loginUser.setU_tel(rs.getString("u_tel"));
				loginUser.setU_car(rs.getInt("u_car"));
				loginUser.setU_hostId(rs.getString("u_hostId"));
				loginUser.setU_adminId(rs.getString("u_adminId"));
				loginUser.setU_presidentId(rs.getString("u_presidentId"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return loginUser;
	}
	
	
}
