package arms.web.login.svc;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;
import static arms.db.jdbcUtil.*;

import java.sql.Connection;

public class UserInfoDetailService {

	public UserInfo getUserInfo(String id) {
		// TODO Auto-generated method stub
		UserInfo userInfoView = null;
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		userInfoView = loginDAO.getUserInfo(id);
		close(con);
		return userInfoView;
	}

}
