package arms.web.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.board.svc.BoardListService;
import arms.web.board.vo.Article;
import arms.web.board.vo.PageInfo;

public class VolunteerUserListBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		//�ش� �������� ù��°�� ��µǴ� ���� ���ڵ� ��ȣ���ϱ�
		int startRow = (currentPage -1)*pageSize +1;
		//���������� 1
		//(1-1)*10 +1
		// startRow = 1
		
		int count = 0;
		//��ü ���� ������ ������ ����
		
		int number = 0;
		//�ش� �������� ù��°�� ��µǴ� ���� ��ȣ
		
		BoardListService boardListService = new BoardListService();
		
		ArrayList<Article> articleList = null;
		//�ش� �������� ��µ� ���� ������ ������ �÷��� ��ü
		
		count = boardListService.getVolunteerArticleCount();
		if(count>0){
			articleList = boardListService.getVolunteerArticleList(startRow,pageSize);
		}
		number = count - (currentPage - 1) * pageSize;
		//��ü ���� ���� : 134
		//���� ������ : 1
		//number : 134 - (1 - 1) * 10
		int pageCount = count / pageSize + ((count % pageSize) == 0 ? 0 : 1);
		
		//�ش� ������ �׷쿡�� ���� ������
		int startPage = ((currentPage -1) / 10) * 10 + 1;
		
		//�� �������� ��µ� ������ ����
		int pageBlock = 10;
		
		//�ش� ������ �׷쿡�� ������ ������
		int endPage = startPage + pageBlock - 1;
		
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("articleList", articleList);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCount(count);
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setNumber(number);
		pageInfo.setPageCount(pageCount);
		pageInfo.setStartPage(startPage);
		
		request.setAttribute("pageInfo", pageInfo);
		ActionForward forward = new ActionForward();
		forward.setUrl("volunteerUserListBoard.jsp");			
		return forward;

	}

}
