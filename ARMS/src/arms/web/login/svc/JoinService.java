package arms.web.login.svc;

import java.sql.Connection;
import static arms.db.jdbcUtil.*;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;

public class JoinService {

	public boolean joinUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		boolean registSuccess = false;
		int insertCount = loginDAO.inserUserInfo(userInfo);
		if(insertCount > 0){
			commit(con);
			registSuccess = true;
		}else{
			rollback(con);
		}
		return registSuccess;
	}

}
