package arms.web.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
	
	public int insertArticle(Article article, String bName){	
		String boardName = bName + "board";
		String seq = "seq_"+bName+".nextval";
		Statement stmt = null;
		ResultSet rs = null;
		int insertCount = 0;
		int seqNum = 0;
		
		//응답글 처리에 필요한 값들 얻어오기
		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		
		int number = 0;
		//작성한 글이 원글이면 새로운 관련글 번호가 부여되어야 한다.
		//새로구한 관련글 번호를 저장할 변수
		String sql = "";
		
		try {
			
			
			
			
			//새로운 관련글 번호 구하기
			//기존 값과 중복되지 않는 값으로
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT MAX(num) FROM "+boardName+"");
			
			if(rs.next()){
				//기존에 작성된 글이 있으면.
				number = rs.getInt(1) + 1;
			
			}
			else{
				number = 1;
				
			}
			
			if(num != 0){
				//답글이면
				sql = "UPDATE "+boardName+" SET re_step = re_step WHERE ref = ? AND re_step > ?";
				stmt = con.createStatement();
				stmt.executeUpdate(sql);
				re_step = re_step +1;
				re_level = re_level +1;					
			}
			else{
				//원글이면
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			
			//-----------------시퀀스 값 받아오기--------------------
//			if(bName.equals("notice")){
//				//sequence 처리하는 문장
//				stmt = con.createStatement();
//				rs = stmt.executeQuery("select seq_notice.nextval from "+boardName+"");
//					if(rs.next()){
//						seqNum=rs.getInt(1);
//					}
//				}
//				else if (bName.equals("suggestion")) {
//					stmt = con.createStatement();
//					rs = stmt.executeQuery("select seq_suggestion.nextval from "+boardName+"");
//						if(rs.next()){
//							seqNum=rs.getInt(1);
//						}
//				}
//				else if (bName.equals("facility")) {
//					stmt = con.createStatement();
//					rs = stmt.executeQuery("select seq_facility.nextval from "+boardName+"");
//						if(rs.next()){
//							seqNum=rs.getInt(1);
//						}
//				}
//				else if (bName.equals("volunteer")) {
//					stmt = con.createStatement();
//					rs = stmt.executeQuery("select seq_volunteer.nextval from "+boardName+"");
//						if(rs.next()){
//							seqNum=rs.getInt(1);
//						}
//				}
//				else if (bName.equals("calendar")) {
//					stmt = con.createStatement();
//					rs = stmt.executeQuery("select seq_calendar.nextval from "+boardName+"");
//						if(rs.next()){
//							seqNum=rs.getInt(1);
//						}
//				}
			//-----------------시퀀스 값 받아오기--------------------
			
			sql = "INSERT INTO "+boardName+" (num,writerid,subject,passwd,writedate,ref,re_step,re_level,content,readcount)"
					+" VALUES("+seq+" , '"+article.getWriteID()+"' , '"+article.getSubject()+"' , "+article.getPasswd()+" , SYSDATE , "+ref+" , "+re_step+" , "+re_level+" , '"+article.getContent()+"',0)";
			stmt = con.createStatement();			
			System.out.println(seqNum);
			System.out.println(sql);
			insertCount = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(stmt);			
		}
		return insertCount;
	}
	
	//----------------------------------------글입력
	
	
	public int selectNoticeArticleCount(String bName){
		String boardName = bName + "board";
		System.out.println(boardName);
		int articleCount = 0;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM "+boardName+"");
			if(rs.next()){
				articleCount = rs.getInt(1);
				System.out.println(articleCount);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(stmt);
		}
		return articleCount;
	}
	public ArrayList<Article> selectNoticeArticleList(int startRow,int pageSize, String bName){
		String boardName = bName + "board";
		ArrayList<Article> articleList = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {		
			stmt = con.createStatement();			
			//rownum : SELECT 구분 실행 시 각 레코드의 번호를 부여해 줌.
			//해당 페이지에 출력될 글 레코드들을 가져옴
			//메인 쿼리 안에 "()" 로 묶여서 독립적으로 실행되는 쿼리를 서브쿼리라고 한다.
			//서브쿼리 중 FROM 절에 오는 서브쿼리를 인라인뷰라고 한다.
			rs = stmt.executeQuery("SELECT list2.* FROM (SELECT rownum r, list1.* FROM(SELECT * FROM "+boardName+" ORDER BY ref DESC ,re_step ASC) list1) list2 WHERE r BETWEEN "+startRow+" AND "+(startRow+pageSize-1)+"");
			
			if(rs.next()){
				System.out.println(rs.getInt("re_level"));
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
			close(stmt);
		}
		return articleList;
	}
	
	public Article selectArticle(int board_Num, String bName){
		String boardName = bName + "board";
		Article article = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();	
			int updateCount = stmt.executeUpdate("UPDATE "+boardName+" SET readcount = readcount+1 WHERE num = "+board_Num+"");
			if(updateCount>0){
				commit(con);
			}
			else{
				rollback(con);
			}
			stmt = con.createStatement
					();
			rs = stmt.executeQuery("SELECT * FROM "+boardName+" WHERE num = "+board_Num+"");
			
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
			close(stmt);
		}
		
		return article;
		
	}
	
	public Article selectOldArticle(int num, String bName){		
		String boardName = bName + "board";
		Article article = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM "+boardName+" WHERE num = "+num+"");
			
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
			close(stmt);
		}
		
		return article;	

	}
	
	public int updateArticle(Article article, String bName){
		String boardName = bName + "board";
		Statement stmt = null;
		ResultSet rs = null;
		
		int dbPasswd = 0;
		String sql ="";
		int updateCount = 0;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT passwd FROM "+boardName+" WHERE num = "+article.getNum()+"");
			if(rs.next()){
				dbPasswd = rs.getInt("passwd");
				if(dbPasswd == article.getPasswd()){
					sql = "UPDATE "+boardName+" SET subject='"+article.getSubject()+"',content='"+article.getContent()+"' WHERE num = "+article.getNum()+"";
					stmt = con.createStatement();					
					updateCount = stmt.executeUpdate(sql);
					
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(stmt);
		}		
		return updateCount;
	}
	
	public int deleteArticle(int num , int passwd, String bName){
		String boardName = bName + "board";
		System.out.println(boardName);
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println(num);
		
		int dbPasswd = 0;
		String sql ="";
		int deleteCount = 0;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT passwd FROM "+boardName+" WHERE num = "+num+"");
			if(rs.next()){
				dbPasswd = rs.getInt("passwd");
				if(dbPasswd == passwd){
					sql = "DELETE FROM "+boardName+" WHERE num = "+num+"";
					stmt = con.createStatement();
					deleteCount = stmt.executeUpdate(sql);
					
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(stmt);
		}		
		return deleteCount;
	}
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;		
	}
}
