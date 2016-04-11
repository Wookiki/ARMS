package arms.web.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
				loginInfo= new UserInfo();
				loginInfo.setU_adminId(rs.getString("u_adminid"));
				loginInfo.setU_car(Integer.parseInt(rs.getString("u_car")));
				loginInfo.setU_dong(rs.getString("u_dong"));
				loginInfo.setU_ho(Integer.parseInt(rs.getString("u_ho")));
				loginInfo.setU_hostId(rs.getString("u_hostId"));
				loginInfo.setU_id(rs.getString("u_id"));
				loginInfo.setU_name(rs.getString("u_name"));
				loginInfo.setU_passwd(rs.getString("u_passwd"));
				loginInfo.setU_presidentId(rs.getString("u_presidentId"));
				loginInfo.setU_tel(rs.getString("u_tel"));
				
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
	
	public UserInfo getUserInfo(String id) {
		// TODO Auto-generated method stub
		UserInfo userInfoView = null;
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM USERINFO WHERE u_id = ?");
			pstmt.setString(1, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public int selectUpdateUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int updateCount = 0 ;
		try {
			pstmt = con.prepareStatement("UPDATE USERINFO SET u_dong = ?, u_ho = ?, u_car = ?, u_tel = ? WHERE u_id = ?" );
			pstmt.setString(1, userInfo.getU_dong());
			pstmt.setInt(2, userInfo.getU_ho());
			pstmt.setInt(3, userInfo.getU_car());
			pstmt.setString(4, userInfo.getU_tel());
			pstmt.setString(5, userInfo.getU_id());
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateCount;
	}
	public int modifyPasswd(UserInfo userInfo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int updateCount =0;
		try {
			pstmt = con.prepareStatement("UPDATE USERINFO SET u_passwd = ? WHERE u_id = ?");
			pstmt.setString(1, userInfo.getU_passwd());
			pstmt.setString(2, userInfo.getU_id());
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateCount;
	}
	public int selectIdCount(String id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int idCount = 0;
		try {
			pstmt = con.prepareStatement("SELECT COUNT(*) FROM USERINFO WHERE u_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				idCount = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return idCount;
	}
	public ArrayList<UserInfo> selectResidentList() {
		// TODO Auto-generated method stub
		ArrayList<UserInfo> residentList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT u_id, u_name, u_dong, u_ho, u_tel, u_car FROM USERINFO");
			rs = pstmt.executeQuery();
			if(rs.next()){
				UserInfo userInfo = null;
				residentList = new ArrayList<UserInfo>();
				do{
					userInfo = new UserInfo();
					userInfo.setU_adminId(rs.getString("u_adminId"));
					userInfo.setU_car(rs.getShort("u_car"));
					userInfo.setU_dong(rs.getString("u_dong"));
					userInfo.setU_ho(Integer.parseInt(rs.getString("u_ho")));
					userInfo.setU_hostId(rs.getString("u_hostId"));
					userInfo.setU_id(rs.getString("u_id"));
					userInfo.setU_name(rs.getString("u_name"));
					userInfo.setU_passwd(rs.getString("u_passwd"));
					userInfo.setU_presidentId(rs.getString("u_presidentId"));
					userInfo.setU_tel(rs.getString("u_tel"));
					residentList.add(userInfo);
				}while(rs.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return residentList;
	}
	
	
	
	
}
