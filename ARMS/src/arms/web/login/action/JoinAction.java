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
		String u_id = request.getParameter("id");
		String u_passwd = request.getParameter("passwd");
		String u_name = request.getParameter("name");
		String u_dong = request.getParameter("dong");
		int u_ho = Integer.parseInt(request.getParameter("ho")); 
		String u_tel = request.getParameter("tel");
		int u_car = Integer.parseInt(request.getParameter("car"));
		
		JoinService joinService = new JoinService();
		boolean joinSuccess = joinService.joinUserInfo(userInfo);
		
		ActionForward forward = new ActionForward();
		if(joinSuccess){
			forward.setRedirect(true);
			forward.setUrl("login.arms");
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
