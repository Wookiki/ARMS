package arms.web.login.svc;

import java.sql.Connection;

import arms.web.login.dao.LoginDAO;

import static arms.db.jdbcUtil.*;

public class IdCheckService {

	public boolean existId(String id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		
		boolean idExists = false;
		int iCount = loginDAO.selectIdCount(id);
		if(iCount > 0){
			idExists = true;
		}
		close(con);
		return idExists;
	}

}
