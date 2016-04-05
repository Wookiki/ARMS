package arms.web.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static arms.db.jdbcUtil.*;

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
	
	public UserInfo checkLogin(String id, String passwd) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo loginInfo= null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM USERINFO WHERE u_id=? AND u_passwd=?");
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				loginInfo.setU_adminId(rs.getString("adminId"));
				loginInfo.setU_car(Integer.parseInt(rs.getString("car")));
				loginInfo.setU_dong(rs.getString("dong"));
				loginInfo.setU_ho(Integer.parseInt(rs.getString("ho")));
				loginInfo.setU_hostId(rs.getString("hostId"));
				loginInfo.setU_id(rs.getString("id"));
				loginInfo.setU_name(rs.getString("name"));
				loginInfo.setU_passwd(rs.getString("passwd"));
				loginInfo.setU_presidentId(rs.getString("presidentId"));
				loginInfo.setU_tel(rs.getString("tel"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginInfo;
	}
	
	public int inserUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO USERINFO VALUES (?, ?, ?, ?, ? , ? ,?, 'Yong', 'Wookiki', 'Rock')";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userInfo.getU_id());
			pstmt.setString(2, userInfo.getU_passwd());
			pstmt.setString(3, userInfo.getU_name());
			pstmt.setString(4, userInfo.getU_dong());
			pstmt.setInt(5, userInfo.getU_ho());
			pstmt.setString(6, userInfo.getU_tel());
			pstmt.setInt(7, userInfo.getU_car());
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	
	
}
