package arms.web.login.svc;


import java.sql.Connection;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;
import static arms.db.jdbcUtil.* ;

public class LoginMainService {

	public UserInfo getLogin(String u_id, String u_passwd) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		UserInfo loginUser = loginDAO.selectLoginUser(u_id, u_passwd);
		boolean loginSuccess = DAO
		
		close(con);
		return loginUser;
	}

}
