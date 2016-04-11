package arms.web.login.svc;

import java.sql.Connection;
import java.util.ArrayList;
import static arms.db.jdbcUtil.*;

import arms.web.login.dao.LoginDAO;
import arms.web.login.vo.UserInfo;

public class ResidentListService {

	public ArrayList<UserInfo> getResidentList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		ArrayList<UserInfo> residentList = loginDAO.selectResidentList();
		close(con);
		return residentList;
	}

}
