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
		int modifyCount = loginDAO.modifyPasswd(userInfo);
		if(modifyCount > 0){
			commit(con);
			modifyPasswdSuccess = true;
		}else{
			rollback(con);
		}
		
		return modifyPasswdSuccess;
	}

}
