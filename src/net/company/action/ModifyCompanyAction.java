package net.company.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyDetail;
import net.company.dto.CompanyFile;

// 태훈 추가 - 기업등록
public class ModifyCompanyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		char comma = ',';
		char remark = '/';

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		CompanyDetail companyDetail = new CompanyDetail();

		int result = 0;
		String cp_idx_string = request.getParameter("cp_idx");
		Integer cp_idx = 0;

		try {
			cp_idx = Integer.parseInt(cp_idx_string);
		} catch (NumberFormatException nfe) {
			// error 처리
		}

		// 2019-09-09 추가//
		String cp_open_datetime = request.getParameter("cp_open_datetime");
		System.out.println(cp_open_datetime);
		String iv_appl_start_date_time = request.getParameter("iv_appl_start_date_time");
		String iv_appl_stop_date_time = request.getParameter("iv_appl_stop_date_time");

		companyDetail.setCp_open_datetime(new java.sql.Date(transFormat.parse(cp_open_datetime).getTime()));
		companyDetail.setIv_appl_start_date_time(new java.sql.Date(transFormat.parse(iv_appl_start_date_time).getTime()));
		companyDetail.setIv_appl_stop_date_time(new java.sql.Date(transFormat.parse(iv_appl_stop_date_time).getTime()));

		// 리워드
		String cp_reward_main_title = request.getParameter("cp_reward_main_title");
		String cp_reward_sub_title = request.getParameter("cp_reward_sub_title");
		String cp_reward_content = request.getParameter("cp_reward_content");
		companyDetail.setCp_reward_main_title(cp_reward_main_title);
		companyDetail.setCp_reward_sub_title(cp_reward_sub_title);
		companyDetail.setCp_reward_content(cp_reward_content);

		// 기업 소개
		String cp_intro_headline = request.getParameter("cp_intro_headline");
		String cp_intro_content = request.getParameter("cp_intro_content");
		companyDetail.setCp_intro_headline(cp_intro_headline);
		companyDetail.setCp_intro_content(cp_intro_content);

		// 투자노트
		String cp_point_title_array[] = request.getParameterValues("cp_point_title");
		String cp_point_content_array[] = request.getParameterValues("cp_point_content");
		
		String cp_point_title = "";
		String cp_point_content = "";
		
		for (int i = 0; i < cp_point_title_array.length; i++) {
			if (i == cp_point_title_array.length -1) {
				cp_point_title += cp_point_title_array[i];
			}else {
				cp_point_title += cp_point_title_array[i] +"/**/";
			}
		}
		
		for (int i = 0; i < cp_point_content_array.length; i++) {
			if (i == cp_point_content_array.length -1) {
				cp_point_content += cp_point_content_array[i];
			}else {
				cp_point_content += cp_point_content_array[i] +"/**/";
			}
		}
		
		//투자시 유의 사항
		String cp_notice_title_array[] = request.getParameterValues("cp_notice_title");
		String cp_notice_content_array[] = request.getParameterValues("cp_notice_content");
		
		String cp_notice_title = makeStringPattern(cp_notice_title_array,"/**/");
		String cp_notice_content = makeStringPattern(cp_notice_content_array,"/**/");
		
		// 예상지급 스케줄
		String cp_pay_count_array[] = request.getParameterValues("sum1");					//지급회차
		String cp_pay_expected_payment_date_array[] = request.getParameterValues("sum2"); //예상지급일
		String cp_pay_principal_array[] = request.getParameterValues("sum3");				//월급
		String cp_pay_interest_paid_array[] = request.getParameterValues("sum4");			//지급이자
		String cp_pay_fees_array[] = request.getParameterValues("sum5");					//플랫폼 이용료
		String cp_pay_actual_payment_amout_array[] = request.getParameterValues("sum6");	//실 지급금액
		String cp_pay_actual_rate_return_array[] = request.getParameterValues("sum7");
		
		String cp_pay_count = makeStringPattern(cp_pay_count_array,"/**/");				//지급회차
		String cp_pay_expected_payment_date= makeStringPattern(cp_pay_expected_payment_date_array,"/**/");
		String cp_pay_principal= makeStringPattern(cp_pay_principal_array,"/**/");
		String cp_pay_interest_paid= makeStringPattern(cp_pay_interest_paid_array,"/**/");
		String cp_pay_fees= makeStringPattern(cp_pay_fees_array,"/**/");
		String cp_pay_actual_payment_amout= makeStringPattern(cp_pay_actual_payment_amout_array,"/**/");
		String cp_pay_actual_rate_return= makeStringPattern(cp_pay_actual_rate_return_array,"/**/");
		
		companyDetail.setCp_pay_count(cp_pay_count);
		companyDetail.setCp_pay_expected_payment_date(cp_pay_expected_payment_date);
		companyDetail.setCp_pay_principal(cp_pay_principal);
		companyDetail.setCp_pay_interest_paid(cp_pay_interest_paid);
		companyDetail.setCp_pay_fees(cp_pay_fees);
		companyDetail.setCp_pay_actual_payment_amout(cp_pay_actual_payment_amout);
		companyDetail.setCp_pay_actual_rate_return(cp_pay_actual_rate_return);
		
		
		
		companyDetail.setCp_notice_title(cp_notice_title);
		companyDetail.setCp_notice_content(cp_notice_content);
		
		companyDetail.setCp_point_title(cp_point_title);
		companyDetail.setCp_point_content(cp_point_content);
		// 2019-09-09 추가//

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
		
		//본사주소
		String cp_address = request.getParameter("cp_address");
		companyDetail.setCp_address(cp_address);
		
		String cp_add_num = request.getParameter("cp_add_num");
		companyDetail.setCp_add_num(cp_add_num);
		String cp_add_ch = request.getParameter("cp_add_ch");
		companyDetail.setCp_add_ch(cp_add_ch);
		String cp_add_more = request.getParameter("cp_add_more");
		companyDetail.setCp_add_more(cp_add_more);
		String cp_add_extra = request.getParameter("cp_add_extra");
		companyDetail.setCp_add_extra(cp_add_extra);

		
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
		/*
		String cp_point_title = request.getParameter("cp_point_title");
		companyDetail.setCp_point_title(cp_point_title);

		String cp_point_content = request.getParameter("cp_point_content");
		companyDetail.setCp_point_content(cp_point_content);
		*/
		String pl_year = request.getParameter("pl_year");
		companyDetail.setPl_year(pl_year);

		String pl_month = request.getParameter("pl_month");
		pl_month = pl_month.replaceAll(",", "");
		companyDetail.setPl_month(pl_month);

		String calA = request.getParameter("calA");
		calA = calA.replaceAll(",", "");
		companyDetail.setPl_sales(calA);

		String calB = request.getParameter("calB");
		calB = calB.replaceAll(",", "");
		companyDetail.setPl_material(calB);

		String calC = request.getParameter("calC");
		calC = calC.replaceAll(",", "");
		companyDetail.setPl_person_pay(calC);

		String calD = request.getParameter("calD");
		calD = calD.replaceAll(",", "");
		companyDetail.setPl_rent_building(calD);

		String calE = request.getParameter("calE");
		calE = calE.replaceAll(",", "");
		companyDetail.setPl_operating_pay(calE);

		String calT = request.getParameter("calT");
		calT = calT.replaceAll(",", "");
		companyDetail.setPl_net_revenue(calT);

		String cal1 = request.getParameter("cal1");
		companyDetail.setMa_odds_percent(cal1);

		String cal2 = request.getParameter("cal2");
		cal2 = cal2.replaceAll(",", "");
		companyDetail.setMa_odds_money(cal2);

		String cal3 = request.getParameter("cal3");
		companyDetail.setMa_share_percent(cal3);

		String cal4 = request.getParameter("cal4");
		cal4 = cal4.replaceAll(",", "");
		companyDetail.setMa_share_money(cal4);

		String cal5 = request.getParameter("cal5");
		cal5 = cal5.replaceAll(",", "");
		companyDetail.setMa_platform_pay(cal5);

		String cal6 = request.getParameter("cal6");
		cal6 = cal6.replaceAll(",", "");
		companyDetail.setMa_estimated_revenue(cal6);

		String cal7 = request.getParameter("cal7");
		cal7 = cal7.replaceAll(",", "");
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

		// 파일들//
		String cf_thumbnail = "";
		String cf_alias_thumbnail = "";

		String cf_business_plan = "";
		String cf_alias_business_plan = "";

		String cf_pr_background = "";
		String cf_alias_pr_background = "";

		String cf_store_images = "";
		String cf_business_plan_images = "";
		String cf_etc_files = "";

		String cf_alias_store_images = "";
		String cf_alias_business_plan_images = "";
		String cf_alias_etc_files = "";

		CompanyDAO companydao = new CompanyDAO();
		String companyFileFolder = companydao.getFileDirectory(cp_idx, 1);
		companydao = new CompanyDAO();
		String companyImageFolder = companydao.getFileDirectory(cp_idx, 2);

		// FileDeleter.deleteDirectoryFile(companyFileFolder);
		// FileDeleter.deleteDirectoryFile(companyImageFolder);

		companydao = new CompanyDAO();
		CompanyFile companyFile = new CompanyFile();
		companydao.getCompanyFile(cp_idx, companyFile);

		for (Part part : request.getParts()) {
			if (part.getContentType() != null) {
				String fileName = extractFileName(part);
				if (fileName.equals("")) {
					continue;
				}
				String alias = UUID.randomUUID().toString().substring(0, 9);
				String fileFormat = getFileFormat(part);
				switch (part.getName()) {
				case "cf_business_plan":
					cf_business_plan = fileName + ",";
					cf_alias_business_plan += alias + "cf_business_plan" + fileFormat;
					companyDetail.setCf_business_plan(cf_business_plan);
					companyDetail.setCf_alias_business_plan(cf_alias_business_plan);
					// part.write(companyFileFolder + cf_alias_business_plan);
					break;
				case "cf_pr_background":
					cf_pr_background = fileName + ",";
					cf_alias_pr_background += alias + "cf_pr_background" + fileFormat;
					companyDetail.setCf_pr_background(cf_pr_background);
					companyDetail.setCf_alias_pr_background(cf_alias_pr_background);
					// part.write(companyImageFolder + cf_alias_pr_background);
					break;
				case "cf_thumbnail":
					cf_thumbnail = fileName + ",";
					cf_alias_thumbnail += alias + "cf_thumbnail" + fileFormat;
					companyDetail.setCf_alias_thumbnail(cf_alias_thumbnail);
					companyDetail.setCf_thumbnail(cf_thumbnail);
					// part.write(companyImageFolder + cf_alias_thumbnail);
					break;
				case "cf_store_images":
					cf_store_images += fileName + ",";
					cf_alias_store_images += alias + "cf_store_images" + fileFormat + ",";
					// part.write(companyImageFolder + cf_alias_store_images);
					break;
				case "cf_business_plan_images":
					cf_business_plan_images += fileName + ",";
					cf_alias_business_plan_images += alias + "cf_business_plan_images" + fileFormat + ",";
					// part.write(companyImageFolder + cf_alias_business_plan_images);
					break;
				case "cf_etc_files":
					cf_etc_files += fileName + ",";
					cf_alias_etc_files += alias + "cf_etc_files" + fileFormat + ",";
					// part.write(companyFileFolder + cf_alias_etc_files);
					break;
				default:
					break;
				}
			}
		}

		if (!cf_store_images.equals("") && cf_store_images.charAt(cf_store_images.length() - 1) == comma) {
			cf_store_images = cf_store_images.substring(0, cf_store_images.length() - 1);
			companyDetail.setCf_store_images(cf_store_images);
		}
		if (!cf_alias_store_images.equals("")
				&& cf_alias_store_images.charAt(cf_alias_store_images.length() - 1) == comma) {
			cf_alias_store_images = cf_alias_store_images.substring(0, cf_alias_store_images.length() - 1);
			companyDetail.setCf_alias_store_images(cf_alias_store_images);
		}
		if (!cf_business_plan_images.equals("")
				&& cf_business_plan_images.charAt(cf_business_plan_images.length() - 1) == comma) {
			cf_business_plan_images = cf_business_plan_images.substring(0, cf_business_plan_images.length() - 1);
			companyDetail.setCf_business_plan(cf_business_plan_images);
		}
		if (!cf_alias_business_plan_images.equals("")
				&& cf_alias_business_plan_images.charAt(cf_alias_business_plan_images.length() - 1) == comma) {
			cf_alias_business_plan_images = cf_alias_business_plan_images.substring(0,
					cf_alias_business_plan_images.length() - 1);
			companyDetail.setCf_alias_business_plan_images(cf_alias_business_plan_images);
		}
		if (!cf_etc_files.equals("") && cf_etc_files.charAt(cf_etc_files.length() - 1) == comma) {
			cf_etc_files = cf_etc_files.substring(0, cf_etc_files.length() - 1);
			companyDetail.setCf_etc_files(cf_etc_files);
		}
		if (!cf_alias_etc_files.equals("") && cf_alias_etc_files.charAt(cf_alias_etc_files.length() - 1) == comma) {
			cf_alias_etc_files = cf_alias_etc_files.substring(0, cf_alias_etc_files.length() - 1);
			companyDetail.setCf_alias_etc_files(cf_alias_etc_files);
		}

		companyDetail.setCf_store_images(cf_store_images);
		companyDetail.setCf_alias_store_images(cf_alias_store_images);

		companyDetail.setCf_business_plan_images(cf_business_plan_images);
		companyDetail.setCf_alias_business_plan_images(cf_alias_business_plan_images);

		companyDetail.setCf_etc_files(cf_etc_files);
		companyDetail.setCf_alias_etc_files(cf_alias_etc_files);

		// 파일 존재하지 않을 시 기존 파일로 새로 업데이트//
		if (companyDetail.getCf_business_plan() == null || companyDetail.getCf_business_plan().equals("")) {
			companyDetail.setCf_business_plan(companyFile.getCf_business_plan());
			companyDetail.setCf_alias_business_plan(companyFile.getCf_alias_business_plan());
		}
		if (companyDetail.getCf_pr_background() == null || companyDetail.getCf_pr_background().equals("")) {
			companyDetail.setCf_pr_background(companyFile.getCf_pr_background());
			companyDetail.setCf_alias_pr_background(companyFile.getCf_alias_pr_background());
		}
		if (companyDetail.getCf_thumbnail() == null || companyDetail.getCf_thumbnail().equals("")) {
			companyDetail.setCf_thumbnail(companyFile.getCf_thumbnail());
			companyDetail.setCf_alias_thumbnail(companyFile.getCf_alias_thumbnail());
		}
		if (companyDetail.getCf_store_images() == null || companyDetail.getCf_store_images().equals("")) {
			companyDetail.setCf_store_images(companyFile.getCf_store_images());
			companyDetail.setCf_alias_store_images(companyFile.getCf_alias_store_images());
		}
		if (companyDetail.getCf_business_plan_images() == null
				|| companyDetail.getCf_business_plan_images().equals("")) {
			companyDetail.setCf_business_plan_images(companyFile.getCf_business_plan_images());
			companyDetail.setCf_alias_business_plan_images(companyFile.getCf_alias_business_plan_images());
		}
		if (companyDetail.getCf_etc_files() == null || companyDetail.getCf_etc_files().equals("")) {
			companyDetail.setCf_etc_files(companyFile.getCf_etc_files());
			companyDetail.setCf_alias_etc_files(companyFile.getCf_alias_etc_files());
		}

		companydao = new CompanyDAO();
		result = companydao.CompanyUpdate(companyDetail);

		if (result == 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('기업수정에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./companyInvestedDetail.cp?" + cp_idx + "';");
			out.println("</script>");
			out.close();
			return null;
		} else if (result == 1) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('기업수정이 완료되었습니다.');");
			out.println("window.close();");
			out.println("</script>");
			out.close();
		}
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
		return "";
	}

	private String getFileFormat(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return "." + s.substring(s.lastIndexOf(".") + 1, s.length() - 1);
			}
		}
		return "";
	}
	
	private String makeStringPattern(String[] array,String pattern) {
		String string = "";
		for (int i = 0; i < array.length; i++) {
			if (i == array.length -1) {
				string += array[i];
			}else {
				string += array[i] +pattern;
			}
		}
		return string;
	}
}
