package net.company.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyApplication;
import net.company.dto.CompanyDetail;
import net.company.dto.CompanyFilePath;

// 태훈 추가 - 기업등록
public class ModifyCompanyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CompanyDetail companyDetail = new CompanyDetail();
		int result = 0;
		
		int cp_idx = 13;
		companyDetail.setCp_idx(cp_idx);
		
		String cp_sector = request.getParameter("cp_sector");
		companyDetail.setCp_sector(cp_sector);
		
		String cp_name = request.getParameter("cp_name");
		companyDetail.setCp_name(cp_name);
		
		String cp_branch = request.getParameter("cp_branch");
		companyDetail.setCp_branch(cp_branch);
		
		String cp_manager = request.getParameter("cp_manager");
		companyDetail.setCp_manager(cp_manager);
		
		String cp_number = request.getParameter("cp_number");
		companyDetail.setCp_number(cp_number);
		
		String cp_capital = request.getParameter("cp_capital");
		companyDetail.setCp_capital(cp_capital);
		
		String cp_address = request.getParameter("cp_address");		
		companyDetail.setCp_address(cp_address);
		
		String cp_monthly_profit = request.getParameter("cp_monthly_profit");
		companyDetail.setCp_monthly_profit(cp_monthly_profit);
		
		String iv_contraction_during = request.getParameter("iv_contraction_during");
		companyDetail.setIv_contraction_during(iv_contraction_during);
		
		String iv_min_amount = request.getParameter("iv_min_amount");
		companyDetail.setIv_min_amount(iv_min_amount);
				
		String iv_appl_stock = request.getParameter("iv_appl_stock");
		companyDetail.setIv_appl_stock(iv_appl_stock);
		
		String iv_goal_amount = request.getParameter("iv_goal_amount");
		companyDetail.setIv_goal_amount(iv_goal_amount);
		
		String iv_appl_day = request.getParameter("iv_appl_day");
		companyDetail.setIv_appl_day(iv_appl_day);
		
		String cf_thumbnail = request.getParameter("cf_thumbnail");
		companyDetail.setCf_thumbnail(cf_thumbnail);
				
		//String[] cf_store_images;
		
		String cf_pr_background = request.getParameter("cf_pr_background");
		companyDetail.setCf_pr_background(cf_pr_background);
		
		String cp_point_title = request.getParameter("cp_point_title");
		companyDetail.setPoint_title_string(cp_point_title);
		
		String cp_point_content = request.getParameter("cp_point_content");
		companyDetail.setPoint_content_string(cp_point_content);
		
		//String[] cf_business_plan_images;
		
		String pl_year = request.getParameter("pl_year");
		companyDetail.setPl_year(pl_year);
		
		String pl_month = request.getParameter("pl_month");
		companyDetail.setPl_month(pl_month);
		
		String calA = request.getParameter("calA");
		companyDetail.setPl_sales(calA);
		
		String calB = request.getParameter("calB");
		companyDetail.setPl_material(calB);
		
		String calC = request.getParameter("calC");
		companyDetail.setPl_person_pay(calC);
		
		String calD = request.getParameter("calD");
		companyDetail.setPl_rent_building(calD);
		
		String calE = request.getParameter("calE");
		companyDetail.setPl_operating_pay(calE);
		
		String calT = request.getParameter("calT");
		companyDetail.setPl_net_revenue(calT);
		
		String cal1 = request.getParameter("cal1");
		companyDetail.setMa_odds_percent(cal1);
		
		String cal2 = request.getParameter("cal2");
		companyDetail.setMa_odds_money(cal2);
		
		String cal3 = request.getParameter("cal3");
		companyDetail.setMa_share_percent(cal3);
		
		String cal4 = request.getParameter("cal4");
		companyDetail.setMa_share_money(cal4);
		
		String cal5 = request.getParameter("cal5");
		companyDetail.setMa_platform_pay(cal5);
		
		String cal6 = request.getParameter("cal6");
		companyDetail.setMa_estimated_revenue(cal6);
		
		String cal7 = request.getParameter("cal7");
		companyDetail.setMa_monthly_average(cal7);
		
		String tot1 = request.getParameter("tot1");
		companyDetail.setCp_pay_principal(tot1);
		
		String tot2 = request.getParameter("tot2");
		companyDetail.setCp_pay_interest_paid(tot2);
		
		String tot3 = request.getParameter("tot3");
		companyDetail.setCp_pay_fees(tot3);
		
		String tot4 = request.getParameter("tot4");
		companyDetail.setCp_pay_actual_payment_amout(tot4);
		
		String tot5 = request.getParameter("tot5");
		companyDetail.setCp_pay_actual_rate_return(tot5);
		
		CompanyDAO companydao = new CompanyDAO();
		System.out.println(companyDetail.toString());
		result = companydao.CompanyUpdate(companyDetail);
		System.out.println("result : " + result);
		/*
		 * List<CompanyDetail> companydetail = new ArrayList<CompanyDetail>();
		 * CompanyDAO companyDAO = new CompanyDAO();
		 */
		
		// return null;
		/*
		if (result == 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('기업신청에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./companycompanyDetailForm.cp';");
			out.println("</script>");
			out.close();
			return null;
		}else if(result == 1) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('기업신청이 완료되었습니다.');");
			out.println("location.href='./index.jsp';");
			out.println("</script>");
			out.close();
		}*/
		return null;	
	}
	
	// filenName get
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "NULL";
	}

	private String getFileFormat(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return "." + s.substring(s.lastIndexOf(".") + 1,s.length()-1);
			}
		}
		return "";
	}

}
