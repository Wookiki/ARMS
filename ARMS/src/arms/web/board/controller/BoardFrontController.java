package arms.web.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.board.action.BoardContentViewAction;
import arms.web.board.action.BoardListAction;
import arms.web.board.action.BoardUpdateFormAction;
import arms.web.board.action.BoardWriteFormAction;
import arms.web.board.action.BoardWriteProAction;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. ¿äÃ»ÆÄ¾Ç
		String requestURI = request.getRequestURI();
		//¿äÃ» URL : http://localhost.8088/boardProject/boardWriteForm.bo
		//requestURI : //boardProject/boardWriteform.bo
		
		String contextPath = request.getContextPath();
		// /boardProject °¡Á®¿È
		
		String command = requestURI.substring(contextPath.length());
		// boardWriteform.bo
		
		Action action = null;
		ActionForward forward = null;
		if(command.equals("/userListBoard.bo")){
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardContentView.bo")){
			action = new BoardContentViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardWriteForm.bo")){
			action = new BoardWriteFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardWritePro.bo")){
			action = new BoardWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardUpdateForm.bo")){
			action = new BoardUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getUrl());
			}
			else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

}
