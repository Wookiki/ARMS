package arms.web.login.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.LoginMainService;
import arms.web.login.vo.UserInfo;

public class LoginMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserInfo loginUser = null;
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		
		LoginMainService loginMainService = new LoginMainService();
		loginUser = loginMainService.checkLogin(id, passwd);
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		
		if(loginUser !=null){
			session.setAttribute("loginUser", loginUser);
			forward.setRedirect(true);

			if(id.equals(loginUser.getU_adminId())){
				forward.setUrl("adminMain.jsp");
			}else if(id.equals(loginUser.getU_presidentId())){
				forward.setUrl("presidentMain.jsp");
			}else if(id.equals(loginUser.getU_hostId())){
				forward.setUrl("hostMain.jsp");
			}
			else{
			forward.setUrl("ResidentMain.jsp");
			}
		}
		else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
