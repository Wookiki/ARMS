package arms.web.login.svc;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;
import static arms.db.jdbcUtil.*;

import java.sql.Connection;

public class modifyHostIdService {

	public static boolean modifyHostId(UserInfo userInfo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		boolean modifySuccess = false;
		int updateCount = loginDAO.selectUpdateHost(userInfo);
		if(updateCount > 0){
			modifySuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		return modifySuccess;
	}

}
