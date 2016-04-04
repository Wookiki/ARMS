package arms.web.login.dao;

import java.sql.Connection;

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
}
