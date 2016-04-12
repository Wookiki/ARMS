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
		
		count = boardListService.getArticleCount(bName);
		if(count>0){
			articleList = boardListService.getArticleList(startRow,pageSize,bName);
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
		
		if(bName.equals("notice")){
			boardName = "�������� �Խ���";			
		}
		else if(bName.equals("facility")){
			boardName = "�δ�ü� �Խ���";
		}
		else if(bName.equals("volunteer")){
			boardName = "����Ȱ�� �Խ���";
		}
		else if(bName.equals("suggestion")){
			boardName = "���ǻ��� �Խ���";
		}
		else if(bName.equals("calendar")){
			boardName = "����Ʈ���� �Խ���";
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
