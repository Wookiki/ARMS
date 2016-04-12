package arms.web.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.board.svc.BoardListService;
import arms.web.board.vo.Article;
import arms.web.board.vo.PageInfo;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageSize = 10;
		String boardName="";
		String pageNum = request.getParameter("pageNum");
		String bName = request.getParameter("bName");
		System.out.println(bName);
		if(pageNum==null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		//해당 페이지에 첫번째로 출력되는 글의 레코드 번호구하기
		int startRow = (currentPage -1)*pageSize +1;
		//현재페이지 1
		//(1-1)*10 +1
		// startRow = 1
		
		int count = 0;
		//전체 글의 갯수를 저장할 변수
		
		int number = 0;
		//해당 페이지에 첫번째로 출력되는 글의 번호
		
		BoardListService boardListService = new BoardListService();
		
		ArrayList<Article> articleList = null;
		//해당 페이지에 출력될 글의 정보를 저장할 컬렉션 객체
		
		count = boardListService.getArticleCount(bName);
		if(count>0){
			articleList = boardListService.getArticleList(startRow,pageSize,bName);
		}
		number = count - (currentPage - 1) * pageSize;
		//전체 글의 개수 : 134
		//현재 페이지 : 1
		//number : 134 - (1 - 1) * 10
		int pageCount = count / pageSize + ((count % pageSize) == 0 ? 0 : 1);
		
		//해당 페이지 그룹에서 시작 페이지
		int startPage = ((currentPage -1) / 10) * 10 + 1;
		
		//한 페이지당 출력될 페이지 개수
		int pageBlock = 10;
		
		//해당 페이지 그룹에서 마지막 페이지
		int endPage = startPage + pageBlock - 1;
		
		if(endPage > pageCount) endPage = pageCount;
		
		if(bName.equals("notice")){
			boardName = "공지사항 게시판";			
		}
		else if(bName.equals("facility")){
			boardName = "부대시설 게시판";
		}
		else if(bName.equals("volunteer")){
			boardName = "봉사활동 게시판";
		}
		else if(bName.equals("suggestion")){
			boardName = "건의사항 게시판";
		}
		else if(bName.equals("calendar")){
			boardName = "아파트일정 게시판";
		}
		HttpSession session = request.getSession();
		request.setAttribute("articleList", articleList);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCount(count);
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setNumber(number);
		pageInfo.setPageCount(pageCount);
		pageInfo.setStartPage(startPage);		
		
		request.setAttribute("pageInfo", pageInfo);
		session.setAttribute("boardName", boardName);
		session.setAttribute("bName", bName);
		ActionForward forward = new ActionForward();
		forward.setUrl("userListBoard.jsp");			
		return forward;

	}
}
