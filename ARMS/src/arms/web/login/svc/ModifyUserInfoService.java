package arms.web.login.svc;

import static arms.db.jdbcUtil.*;

import java.sql.Connection;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;

public class ModifyUserInfoService {

	public boolean modifyUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		
		boolean modifySuccess = false;
		int updateCount = loginDAO.selectUpdateUser(userInfo);
		if(updateCount > 0){
			modifySuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		return modifySuccess;
	}

	
}
