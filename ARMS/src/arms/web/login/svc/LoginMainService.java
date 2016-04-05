package arms.web.login.svc;

import java.sql.Connection;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;

import static arms.db.jdbcUtil.*;

public class LoginMainService {

	public UserInfo getLoginUser(String u_id) {
		// TODO Auto-generated method stub
		boolean registSuccess = false;
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		UserInfo loginUser = loginDAO.selectLoginUser(u_id);
		return loginUser;
	}

	

}
