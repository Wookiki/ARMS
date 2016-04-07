package arms.web.login.svc;

import java.sql.Connection;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;

import static arms.db.jdbcUtil.*;

public class LoginMainService {

	

	public UserInfo checkLogin(String id, String passwd) {
		// TODO Auto-generated method stub
		UserInfo loginUser = null;
 		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		loginUser = loginDAO.checkLogin(id, passwd);
		close(con);
		return loginUser;
	}

	

}
