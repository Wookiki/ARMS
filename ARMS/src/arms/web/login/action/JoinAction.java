package arms.web.login.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.JoinService;
import arms.web.login.vo.UserInfo;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserInfo userInfo = new UserInfo();
		userInfo.setU_id(request.getParameter("id"));
		userInfo.setU_passwd(request.getParameter("passwd"));;
		userInfo.setU_name(request.getParameter("name"));
		userInfo.setU_dong(request.getParameter("dong"));
		userInfo.setU_ho(Integer.parseInt(request.getParameter("ho")));
		userInfo.setU_tel(request.getParameter("tel"));
		userInfo.setU_car(Integer.parseInt(request.getParameter("car")));
		
		JoinService joinService = new JoinService();
		boolean joinSuccess = joinService.joinUserInfo(userInfo);
		
		ActionForward forward = new ActionForward();
		
		if(joinSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입성공')");
			out.println("history.back()");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setUrl("index.jsp");
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
