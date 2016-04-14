package arms.web.board.svc;

import java.sql.Connection;

import arms.web.board.dao.BoardDAO;

import static arms.db.jdbcUtil.*;

public class BoardDeleteProService {
	public int getDeleteArticle(int num, int passwd, String bName) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int deleteCount = boardDAO.deleteArticle(num, passwd,bName);
			if(deleteCount>0){
					commit(con);
					close(con);			
					return deleteCount;
			}
				else{
					rollback(con);
					close(con);			
					return deleteCount;
				}		
	}
}
