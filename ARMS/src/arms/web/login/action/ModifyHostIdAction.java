package arms.web.login.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.modifyHostIdService;
import arms.web.login.vo.UserInfo;

public class ModifyHostIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UserInfo userInfo = new UserInfo();
		System.out.println(request.getParameter("hostId"));
		userInfo.setU_id(request.getParameter("hostId"));
		modifyHostIdService modifyHostIdService = new modifyHostIdService(); 
		boolean modifySuccess =  modifyHostIdService.modifyHostId(userInfo);
		
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		if(modifySuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정성공')");
			out.println("</script>");
			session.setAttribute("loginUser", userInfo);
			forward.setRedirect(true);
			forward.setUrl("residentMange.arms");
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
