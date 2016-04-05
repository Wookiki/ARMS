package arms.web.login.svc;

import java.sql.Connection;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;

import static arms.db.jdbcUtil.*;

public class LoginMainService {

	

	public UserInfo checkLogin(String id, String passwd) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		UserInfo loginUser = loginDAO.checkLogin(id, passwd);
		return loginUser;
	}

	

}
