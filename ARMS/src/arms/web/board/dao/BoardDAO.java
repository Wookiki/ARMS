package arms.web.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static arms.db.jdbcUtil.*;

import arms.web.board.vo.Article;

public class BoardDAO {
	private static BoardDAO boardDAO;
	private Connection con;
	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	public static BoardDAO getInstance() {
		if(boardDAO == null){
			boardDAO = new BoardDAO();
		}
		
		return boardDAO;
		
	}
	
	public int insertArticle(Article article){		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertCount = 0;
		
		//����� ó���� �ʿ��� ���� ������
		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		
		int number = 0;
		//�ۼ��� ���� �����̸� ���ο� ���ñ� ��ȣ�� �ο��Ǿ�� �Ѵ�.
		//���α��� ���ñ� ��ȣ�� ������ ����
		String sql = "";
		
		try {
						
			//���ο� ���ñ� ��ȣ ���ϱ�
			//���� ���� �ߺ����� �ʴ� ������
			pstmt = con.prepareStatement("SELECT MAX(num) FROM noticeboard");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				//������ �ۼ��� ���� ������.
				number = rs.getInt(1) + 1;
			
			}
			else{
				number = 1;
				
			}
			
			if(num != 0){
				//����̸�
				sql = "UPDATE noticeboard SET re_step = re_step WHERE ref = ? AND re_step > ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,ref);
				pstmt.setInt(2,re_step);
				pstmt.executeUpdate();
				re_step = re_step +1;
				re_level = re_level +1;					
			}
			else{
				//�����̸�
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			
			sql = "INSERT INTO noticeboard (num,writer,subject,passwd,reg_date"
					+",ref,re_step,re_level,content)"
					+" VALUES(board_seq.nextval,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getWriteID());
			pstmt.setString(3, article.getSubject());
			pstmt.setInt(4, article.getPasswd());
			pstmt.setTimestamp(5, article.getWriteDate());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, re_step);
			pstmt.setInt(8, re_level);
			pstmt.setString(9, article.getContent());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);			
		}
		return insertCount;
	}
	
	
	public int selectNoticeArticleCount(){
		int articleCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT COUNT(*) FROM noticeboard");
			rs = pstmt.executeQuery();
			if(rs.next()){
				articleCount = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return articleCount;
	}
	public ArrayList<Article> selectNoticeArticleList(int startRow,int pageSize){
		ArrayList<Article> articleList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement
					("SELECT list2.* FROM (SELECT rownum r, list1.*"
							+ "FROM(SELECT * FROM noticeboard ORDER BY ref DESC,re_step ASC) list1)"
							+ "list2 WHERE r BETWEEN ? AND ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, startRow+pageSize-1);
			//rownum : SELECT ���� ���� �� �� ���ڵ��� ��ȣ�� �ο��� ��.
			//�ش� �������� ��µ� �� ���ڵ���� ������
			//���� ���� �ȿ� "()" �� ������ ���������� ����Ǵ� ������ ����������� �Ѵ�.
			//�������� �� FROM ���� ���� ���������� �ζ��κ��� �Ѵ�.
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				Article article = null;
				articleList = new ArrayList<Article>();
				do{
					article = new Article();
					article.setNum(rs.getInt("num"));
					article.setContent(rs.getString("content"));
					article.setPasswd(rs.getInt("passwd"));
					article.setRe_level(rs.getInt("re_level"));
					article.setRe_step(rs.getInt("re_step"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setWriteDate(rs.getTimestamp("writedate"));
					article.setSubject(rs.getString("subject"));
					article.setWriteID(rs.getString("writerid"));					
					articleList.add(article); 
					
				}while(rs.next());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	
	public Article selectArticle(int board_Num){
		Article article = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement
					("UPDATE noticeboard SET readcount = readcount+1 WHERE num = ?");	
			pstmt.setInt(1, board_Num);
			int updateCount = pstmt.executeUpdate();
			if(updateCount>0){
				commit(con);
			}
			else{
				rollback(con);
			}
			pstmt = con.prepareStatement
					("SELECT * FROM noticeboard WHERE num = ?");
			pstmt.setInt(1, board_Num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
					article = new Article();
					article.setNum(rs.getInt("num"));
					article.setContent(rs.getString("content"));
					article.setPasswd(rs.getInt("passwd"));
					article.setRe_level(rs.getInt("re_level"));
					article.setRe_step(rs.getInt("re_step"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setWriteDate(rs.getTimestamp("writedate"));
					article.setSubject(rs.getString("subject"));
					article.setWriteID(rs.getString("writerid"));		
					
				}		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return article;
		
	}
	
	public Article selectOldArticle(int num){
		Article article = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement
					("SELECT * FROM board WHERE num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
					article = new Article();
					article.setNum(rs.getInt("num"));
					article.setContent(rs.getString("content"));
					article.setPasswd(rs.getInt("passwd"));
					article.setRe_level(rs.getInt("re_level"));
					article.setRe_step(rs.getInt("re_step"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setWriteDate(rs.getTimestamp("writedate"));
					article.setSubject(rs.getString("subject"));
					article.setWriteID(rs.getString("writerid"));		
					
				}		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return article;	

	}
	
	public int updateArticle(Article article){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int dbPasswd = 0;
		String sql ="";
		int updateCount = 0;
		try {
			pstmt = con.prepareStatement("SELECT passwd FROM noticeboard WHERE num = ?");
			pstmt.setInt(1,  article.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()){
				dbPasswd = rs.getInt("passwd");
				if(dbPasswd == article.getPasswd()){
					sql = "UPDATE noticeboard SET writerid=?,subject=?,content=? WHERE num = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, article.getWriteID());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());
					
					updateCount = pstmt.executeUpdate();
					
					if(updateCount >0) {
						commit(con);
					}
					else{
						rollback(con);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}		
		return updateCount;
	}
	
	public int deleteArticle(int num , int passwd){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int dbPasswd = 0;
		String sql ="";
		int deleteCount = 0;
		try {
			pstmt = con.prepareStatement("SELECT passwd FROM noticeboard WHERE num = ?");
			pstmt.setInt(1,  num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dbPasswd = rs.getInt("passwd");
				if(dbPasswd == passwd){
					sql = "DELETE board WHERE num = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);		
					
					deleteCount = pstmt.executeUpdate();
					
					if(deleteCount >0) {
						commit(con);
					}
					else{
						rollback(con);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}		
		return deleteCount;
	}
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;		
	}
}
