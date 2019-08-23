package net.company.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyPopularityList;

// 태훈 - 실시간 수동 데이터 입력
public class companyPopularityManagementUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		
		String[] values = request.getParameterValues("tdArr[]");
		List<String> popuValue = new ArrayList<String>();
		List<String> value01 = new ArrayList<String>();
		List<String> value02 = new ArrayList<String>();
		List<String> value03 = new ArrayList<String>();
		List<String> value04 = new ArrayList<String>();
		List<String> value05 = new ArrayList<String>();
		List<String> value06 = new ArrayList<String>();
		List<String> value07 = new ArrayList<String>();
		List<String> value08 = new ArrayList<String>();
		List<String> value09 = new ArrayList<String>();
		List<String> value10 = new ArrayList<String>();
				
		if(values != null) {
			popuValue = Arrays.asList(values);
			System.out.println(">>>"+popuValue);
			value01.add(popuValue.get(1));
			value01.add(popuValue.get(2));
			value01.add(popuValue.get(3));
			System.out.println(">>>1"+value01);
			value02.add(popuValue.get(5));
			value02.add(popuValue.get(6));
			value02.add(popuValue.get(7));
			System.out.println(">>>2"+value02);
			value03.add(popuValue.get(9));
			value03.add(popuValue.get(10));
			value03.add(popuValue.get(11));
			System.out.println(">>>3"+value03);
			value04.add(popuValue.get(13));
			value04.add(popuValue.get(14));
			value04.add(popuValue.get(15));
			System.out.println(">>>4"+value04);
			value05.add(popuValue.get(17));
			value05.add(popuValue.get(18));
			value05.add(popuValue.get(19));
			System.out.println(">>>5"+value05);
			value06.add(popuValue.get(21));
			value06.add(popuValue.get(22));
			value06.add(popuValue.get(23));
			System.out.println(">>>6"+value06);
			value07.add(popuValue.get(25));
			value07.add(popuValue.get(26));
			value07.add(popuValue.get(27));
			System.out.println(">>>7"+value07);
			value08.add(popuValue.get(29));
			value08.add(popuValue.get(30));
			value08.add(popuValue.get(31));
			System.out.println(">>>8"+value08);
			value09.add(popuValue.get(33));
			value09.add(popuValue.get(34));
			value09.add(popuValue.get(35));
			System.out.println(">>>9"+value09);
			value10.add(popuValue.get(37));
			value10.add(popuValue.get(38));
			value10.add(popuValue.get(39));
			System.out.println(">>>10"+value10);
			
		}
		
		forward.setRedirect(false);
		forward.setPath("./company/companyPopularityManagement.jsp");
		return forward;
	}

}
