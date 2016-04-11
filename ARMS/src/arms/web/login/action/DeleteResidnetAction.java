package arms.web.login.action;

import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arms.action.Action;
import arms.vo.ActionForward;
import arms.web.login.svc.DeleteResidentService;
import arms.web.login.vo.UserInfo;

public class DeleteResidnetAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		DeleteResidentService deleteResidentService = new DeleteResidentService();
		boolean deleteSuccess = deleteResidentService.removeResident(id);
		ActionForward forward = null;
		if(deleteSuccess){
			forward = new ActionForward();
			forward.setUrl("residentMange.arms");
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
