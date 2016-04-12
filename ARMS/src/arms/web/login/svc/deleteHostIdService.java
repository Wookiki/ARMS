package arms.web.login.svc;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;
import static arms.db.jdbcUtil.*;

import java.sql.Connection;

public class deleteHostIdService {

	public boolean deleteHostId(UserInfo userInfo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		boolean deleteSuccess = false;
		int deleteCount = loginDAO.selectDeleteeHost(userInfo);
		if(deleteCount > 0){
			deleteSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		return deleteSuccess;
	}

}
