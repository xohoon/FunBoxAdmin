package net.finance.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.finance.dao.FinanceDAO;
import net.finance.dto.Invest;
import net.finance.dto.Token;
import net.util.Paging;

public class MemberInvestedListAction implements Action {
	
	String categroyFlag = "";
	String searchID = "";
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		String category = request.getParameter("category");
		String searchid = request.getParameter("searchID");
		System.out.println("searchID:"  +searchid);
		try {
			if(category.equals(null)) {
				category = "0";
			}
		}catch(NullPointerException e) {
			category = "0";			
		}
		try {
			if(searchid.equals(null)) {
				searchid = "";
			}
		}catch(NullPointerException e) {
			searchid = "";			
		}
		// 페이징 처리 구문
		int pageSize = 10; // 한페이지에 보여줄 List		
		int pageGroupSize = 5; // 페이지 단위 [◀] 1 2 3 4 5 [▶]
		String pageNum = request.getParameter("pageNum");// 페이지 번호 / 1		
		
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호 / 1
		
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호 / 10
		
		int count = 0;
		int number = 0;
		categroyFlag = category;
		searchID = searchid;

		FinanceDAO fiance_dao_count = new FinanceDAO();
		count = fiance_dao_count.investCount(category, searchid);		
		System.out.println("count 개수 :" + count);
		if(count > 0) {
			if (endRow > count) {
				endRow = count;
			}
			FinanceDAO fiance_dao = new FinanceDAO();
			ArrayList<Invest> investTransfer = new ArrayList<Invest>();
			investTransfer = fiance_dao.getInvestList(startRow - 1, pageSize, category, searchid);
			System.out.println("investTransfer : " + investTransfer.toString());		
			request.setAttribute("investTransfer", investTransfer);
		}else {
			FinanceDAO fiance_dao = new FinanceDAO();
			ArrayList<Invest> investTransfer = new ArrayList<Invest>();
			investTransfer = fiance_dao.getInvestList(startRow - 1, pageSize, category, searchid);
			System.out.println("investTransfer : " + investTransfer.toString());		
			request.setAttribute("investTransfer", investTransfer);
		}
		
		number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
		//페이지그룹의 갯수
		//ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.
		int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
		//페이지 그룹 번호
		//ex) pageGroupSize가 3일 경우 '[1][2][3]'의 페이지그룹번호는 1 이고 '[2][3][4]'의 페이지그룹번호는 2
		//이다.
		int numPageGroup = (int) Math.ceil((double) currentPage / pageGroupSize);
		
		request.setAttribute("currentPage", new Integer(currentPage));
		
		request.setAttribute("startRow", new Integer(startRow));
		
		request.setAttribute("endRow", new Integer(endRow));
		
		request.setAttribute("count", new Integer(count));
		
		request.setAttribute("pageSize", new Integer(pageSize));

		request.setAttribute("number", new Integer(number));
		
		request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
		
		request.setAttribute("numPageGroup", new Integer(numPageGroup));
		
		request.setAttribute("pageGroupCount", new Integer(pageGroupCount));		
		request.setAttribute("categroyFlag", categroyFlag);
		request.setAttribute("searchID", searchID);
		request.setAttribute("category", category);
		
		forward.setRedirect(false);
		forward.setPath("./finance/memberInvestedList.jsp");
		return forward;
	}

}
