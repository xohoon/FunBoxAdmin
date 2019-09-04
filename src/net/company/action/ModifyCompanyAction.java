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
import net.company.dto.CompanyDetail;
import net.company.dto.CompanyFilePath;

// 태훈 추가 - 기업등록
public class ModifyCompanyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CompanyDetail companyDetail = new CompanyDetail();
		int cp_idx = 13;
		String cp_sector = request.getParameter("cp_sector");
		System.out.println("test : " + cp_sector);
		String cp_name;
		String cp_branch;
		String cp_manager;
		String cp_number;
		String cp_capital;
		String cp_address;
		String cp_monthly_profit;
		String iv_contraction_during;
		String iv_min_amount;
		String iv_appl_stock;
		String iv_goal_amount;
		String iv_appl_day;
		String cf_thumbnail;
		//String[] cf_store_images;
		String cf_pr_background;
		String cp_point_title;
		String cp_point_content;
		//String[] cf_business_plan_images;
		String pl_year;
		String pl_month;
		String calA;
		String calB;
		String calC;
		String calD;
		String calE;
		String calT;
		String cal1;
		String cal2;
		String cal3;
		String cal4;
		String cal5;
		String cal6;
		String cal7;
		String tot1;
		String tot2;
		String tot3;
		String tot4;
		String tot5;
		
		
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
