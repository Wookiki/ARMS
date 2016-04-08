package arms.web.login.svc;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;
import static arms.db.jdbcUtil.*;

import java.sql.Connection;

public class ModifyPasswdService {

	public boolean modifyPasswd(UserInfo userInfo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		boolean modifyPasswdSuccess = false;
		int updateCount = loginDAO.modifyPasswd(userInfo);
		if(updateCount > 0){
			modifyPasswdSuccess = true;
			commit(con);
		}else{
			rollback(con);
		}
		
		return modifyPasswdSuccess;
	}

}
