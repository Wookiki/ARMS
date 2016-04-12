package arms.web.login.svc;

import java.sql.Connection;
import static arms.db.jdbcUtil.*;

import arms.web.login.dao.LoginDAO;

public class DeleteResidentService {
	
	public boolean removeResident(String id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		boolean removeSuccess = false;
		int deleteCount = loginDAO.deleteResident(id);
		
		
		if(deleteCount > 0){
			commit(con);
			removeSuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return removeSuccess;
	}

	

}
