package arms.web.login.svc;

import static arms.db.jdbcUtil.*;

import java.sql.Connection;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;

public class IdCheckService {

	public boolean existsId(String id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		
		boolean idExists = false;
		int idCount = loginDAO.selectIdCount(id);
		if(idCount > 0){
			idExists = true;
		}
		close(con);
		return idExists;
	}

}
