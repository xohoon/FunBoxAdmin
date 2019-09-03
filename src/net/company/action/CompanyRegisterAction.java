package net.company.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyRegister;
import net.company.dto.CompnayFilePath;

// 태훈 추가 - 기업등록
public class CompanyRegisterAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CompanyRegister register = new CompanyRegister();
		CompanyDAO companyDAO = new CompanyDAO();
		char comma = ',';
		
		//기업 이름
		String cp_sector = request.getParameter("cp_sector");
		String cp_name = request.getParameter("cp_name");
		String cp_branch = request.getParameter("cp_branch");
		register.setCp_sector("cp_sector");
		register.setCp_name("cp_name");
		register.setCp_branch("cp_branch");
		
		// 기본 정보
		String cp_manager = request.getParameter("cp_manager");
		String cp_number = request.getParameter("cp_number");
		String cp_capital = request.getParameter("cp_capital");
		String cp_address = request.getParameter("cp_address");
		String cp_add_ch = request.getParameter("cp_add_ch");
		String cp_add_more = request.getParameter("cp_add_more");
		String cp_add_num = request.getParameter("cp_add_num");
		register.setCp_manager("cp_manager");
		register.setCp_number("cp_number");
		register.setCp_capital("cp_capital");
		register.setCp_address("cp_address");
		register.setCp_add_ch("cp_add_ch");
		register.setCp_add_more("cp_add_more");
		register.setCp_add_num("cp_add_num");
		
		//투자정보
		String cp_monthly_profit = request.getParameter("cp_monthly_profit");
		String iv_contraction_during = request.getParameter("iv_contraction_during");
		String iv_min_amount = request.getParameter("iv_min_amount");
		String iv_appl_stock = request.getParameter("iv_appl_stock");
		String iv_goal_amount = request.getParameter("iv_goal_amount");
		String iv_appl_day = request.getParameter("iv_appl_day");
		register.setCp_monthly_profit("cp_monthly_profit");
		register.setIv_contraction_during("iv_contraction_during");
		register.setIv_min_amount("iv_min_amount");
		register.setIv_appl_stock("iv_appl_stock");
		register.setIv_goal_amount("iv_goal_amount");
		register.setIv_appl_day("iv_appl_day");
		
		// 리워드
		String cp_reward_main_title = request.getParameter("cp_reward_main_title");
		String cp_reward_sub_title = request.getParameter("cp_reward_sub_title");
		String cp_reward_content = request.getParameter("cp_reward_content");
		register.setCp_reward_main_title("cp_reward_main_title");
		register.setCp_reward_sub_title("cp_reward_sub_title");
		register.setCp_reward_content("cp_reward_content");
		
		// 기업 소개
		String cp_intro_headline = request.getParameter("cp_intro_headline");
		String cp_intro_content = request.getParameter("cp_intro_content");
		register.setCp_intro_headline("cp_intro_headline");
		register.setCp_intro_headline("cp_intro_headline");
		
		// 투자노트
		String cp_point_title[] = request.getParameterValues("cp_point_title");
		String cp_point_content[] = request.getParameterValues("cp_point_content");
		List<String> point_title = new ArrayList<String>();
		List<String> point_content = new ArrayList<String>();
		String point_title_string = "";
		String point_content_string = "";
		
		// point title , 구분 data isnert
		for(int i=0; i<cp_point_title.length; i++) {
			point_title.add(cp_point_title[i]);
		}
		for(int i = 0; i<point_title.size(); i++) {
			point_title_string += point_title.get(i) + "/**/";
		}
		if (point_title_string.charAt(point_title_string.length()-1) == comma) {
			point_title_string.substring(0, point_title_string.length()-2); 
		}
		// point content , 구분 data isnert
		for(int i=0; i<cp_point_content.length; i++) {
			point_content.add(cp_point_content[i]);
		}
		for(int i = 0; i<point_content.size(); i++) {
			point_content_string += point_content.get(i) + "/**/";
		}
		if (point_content_string.charAt(point_content_string.length()-1) == comma) {
			point_content_string.substring(0, point_content_string.length()-2); 
		}
		register.setPoint_content_string("point_content_string");
		register.setPoint_title_string("point_title_string");
		
		// 손익상세
		String pl_year = request.getParameter("pl_year");		//기준년
		String pl_month = request.getParameter("pl_month");		//기준월
		String pl_sales = request.getParameter("calA");			//매출
		String pl_material = request.getParameter("calB");		//원재료
		String pl_person_pay = request.getParameter("calC");	//인건비
		String pl_rent_building = request.getParameter("calD");	//임대비
		String pl_operating_pay = request.getParameter("calE");	//운영비
		String pl_net_revenue = request.getParameter("calT");	//손수익
		register.setPl_year("pl_year");
		register.setPl_month("pl_month");
		register.setPl_sales("pl_sales");
		register.setPl_material("pl_material");
		register.setPl_person_pay("pl_person_pay");
		register.setPl_rent_building("pl_rent_building");
		register.setPl_operating_pay("pl_operating_pay");
		register.setPl_net_revenue("pl_net_revenue");
		
		// 월 평균 수익금(1구좌당)
		String ma_odds_percent = request.getParameter("cal1");		//배당률 %
		String ma_odds_money = request.getParameter("cal2");		//배당률 원
		String ma_share_percent = request.getParameter("cal3");		//지분 %
		String ma_share_money = request.getParameter("cal4");		//지분 원
		String ma_platform_pay = request.getParameter("cal5");		//플랫폼 이용료
		String ma_estimated_revenue = request.getParameter("cal6");	//예상수익금
		String ma_monthly_average = request.getParameter("cal7");	//월평균
		register.setMa_odds_percent("ma_odds_percent");
		register.setMa_odds_money("ma_odds_money");
		register.setMa_share_percent("ma_share_percent");
		register.setMa_share_money("ma_share_money");
		register.setMa_platform_pay("ma_platform_pay");
		register.setMa_estimated_revenue("ma_estimated_revenue");
		register.setMa_monthly_average("ma_monthly_average");
		
		// 예상지급 스케줄
		String cp_pay_count[] = request.getParameterValues("sum1");					//지급회차
		String cp_pay_expected_payment_date[] = request.getParameterValues("sum2"); //예상지급일
		String cp_pay_principal[] = request.getParameterValues("sum3");				//월급
		String cp_pay_interest_paid[] = request.getParameterValues("sum4");			//지급이자
		String cp_pay_fees[] = request.getParameterValues("sum5");					//플랫폼 이용료
		String cp_pay_actual_payment_amout[] = request.getParameterValues("sum6");	//실 지급금액
		String cp_pay_actual_rate_return[] = request.getParameterValues("sum7");	//실 수익률
		List<String> pay_count = new ArrayList<String>();
		List<String> pay_expected = new ArrayList<String>();
		List<String> pay_principal = new ArrayList<String>();
		List<String> pay_interest_paid = new ArrayList<String>();
		List<String> pay_fees = new ArrayList<String>();
		List<String> pay_actual_payment = new ArrayList<String>();
		List<String> pay_actual_rate = new ArrayList<String>();
		
		// 예상지급스케줄 String[] 을 List에 insert
		for(int i=0; i<cp_pay_count.length; i++) {
			pay_count.add(cp_pay_count[i]);
		}
		for(int i=0; i<cp_pay_expected_payment_date.length; i++) {
			pay_expected.add(cp_pay_expected_payment_date[i]);
		}
		for(int i=0; i<cp_pay_principal.length; i++) {
			pay_principal.add(cp_pay_principal[i]);
		}
		for(int i=0; i<cp_pay_interest_paid.length; i++) {
			pay_interest_paid.add(cp_pay_interest_paid[i]);
		}
		for(int i=0; i<cp_pay_fees.length; i++) {
			pay_fees.add(cp_pay_fees[i]);
		}
		for(int i=0; i<cp_pay_actual_payment_amout.length; i++) {
			pay_actual_payment.add(cp_pay_actual_payment_amout[i]);
		}
		for(int i=0; i<cp_pay_actual_rate_return.length; i++) {
			pay_actual_rate.add(cp_pay_actual_rate_return[i]);
		}
		// 예상지급스케줄 List를 String 으로 insert
		String pay_count_string = "";
		for(int i = 0; i<pay_count.size(); i++) {
			pay_count_string += pay_count.get(i) + "/**/";
		}
		if (pay_count_string.charAt(pay_count_string.length()-1) == comma) {
			pay_count_string.substring(0, pay_count_string.length()-2); 
		}
		String pay_payment_date_string = "";
		for(int i = 0; i<pay_expected.size(); i++) {
			pay_payment_date_string += pay_expected.get(i) + "/**/";
		}
		if (pay_payment_date_string.charAt(pay_payment_date_string.length()-1) == comma) {
			pay_payment_date_string.substring(0, pay_payment_date_string.length()-2); 
		}
		String pay_principal_string = "";
		for(int i = 0; i<pay_principal.size(); i++) {
			pay_principal_string += pay_principal.get(i) + "/**/";
		}
		if (pay_principal_string.charAt(pay_principal_string.length()-1) == comma) {
			pay_principal_string.substring(0, pay_principal_string.length()-2); 
		}
		String pay_interest_string = "";
		for(int i = 0; i<pay_interest_paid.size(); i++) {
			pay_interest_string += pay_interest_paid.get(i) + "/**/";
		}
		if (pay_interest_string.charAt(pay_interest_string.length()-1) == comma) {
			pay_interest_string.substring(0, pay_interest_string.length()-2); 
		}
		String pay_fees_string = "";
		for(int i = 0; i<pay_fees.size(); i++) {
			pay_fees_string += pay_fees.get(i) + "/**/";
		}
		if (pay_fees_string.charAt(pay_fees_string.length()-1) == comma) {
			pay_fees_string.substring(0, pay_fees_string.length()-2); 
		}
		String pay_actual_apyment_string = "";
		for(int i = 0; i<pay_actual_payment.size(); i++) {
			pay_actual_apyment_string += pay_actual_payment.get(i) + "/**/";
		}
		if (pay_actual_apyment_string.charAt(pay_actual_apyment_string.length()-1) == comma) {
			pay_actual_apyment_string.substring(0, pay_actual_apyment_string.length()-2); 
		}
		String pay_actual_rate_string = "";
		for(int i = 0; i<pay_actual_rate.size(); i++) {
			pay_actual_rate_string += pay_actual_rate.get(i) + "/**/";
		}
		if (pay_actual_rate_string.charAt(pay_actual_rate_string.length()-1) == comma) {
			pay_actual_rate_string.substring(0, pay_actual_rate_string.length()-2); 
		}
		
		// 유의사항
		String cp_notice_title[] = request.getParameterValues("notice_title");
		String cp_notice_content[] = request.getParameterValues("notice_content");
		List<String> notice_title = new ArrayList<String>();
		List<String> notice_content = new ArrayList<String>();
		// 유의사항 String[] -> List insert
		for(int i=0; i<cp_notice_title.length; i++) {
			notice_title.add(cp_notice_title[i]);
		}
		for(int i=0; i<cp_notice_content.length; i++) {
			notice_content.add(cp_notice_content[i]);
		}
		// 유의사항 List -> String insert
		String notice_title_string = "";
		for(int i = 0; i<notice_title.size(); i++) {
			notice_title_string += notice_title.get(i) + "/**/";
		}
		if (notice_title_string.charAt(notice_title_string.length()-1) == comma) {
			notice_title_string.substring(0, notice_title_string.length()-2); 
		}
		String notice_content_string = "";
		for(int i = 0; i<notice_content.size(); i++) {
			notice_content_string += notice_content.get(i) + "/**/";
		}
		if (notice_content_string.charAt(notice_content_string.length()-1) == comma) {
			notice_content_string.substring(0, notice_content_string.length()-2); 
		}
		
		// 날짜변환 기능
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String now = format.format(date);
		
		// 폴더이름 변수
		String rand_num = UUID.randomUUID().toString().substring(0, 17);
		String cp_folder = rand_num + "_" + now + "/";
		// company 기본경로 + 폴더 이름 -> 폴더 경로에 파일삽입위해서
		CompnayFilePath companyFilePath = new CompnayFilePath();
		companyDAO.getUploadFilePath(companyFilePath, cp_folder);
		
		// 파일디렉토리
		File fileFolder = new File(companyFilePath.getApp_cp_file_path());
		if (!fileFolder.exists()) {
			fileFolder.mkdirs();
		}
		File imageFolder = new File(companyFilePath.getApp_cp_image_path());
		if (!imageFolder.exists()) {
			imageFolder.mkdirs();
		}
		
		ArrayList<String> cf_store_images = new ArrayList<String>();
		ArrayList<String> cf_alias_store_images = new ArrayList<String>();
		ArrayList<String> cf_business_plan_images = new ArrayList<String>();
		ArrayList<String> cf_alias_business_plan_images = new ArrayList<String>();
		ArrayList<String> cf_etc_files = new ArrayList<String>();
		ArrayList<String> cf_alias_etc_files = new ArrayList<String>();
		ArrayList<String> cf_info_banner = new ArrayList<String>();
		ArrayList<String> cf_alias_info_banner = new ArrayList<String>();
		
		String store_images = "";
		String business_plan = "";
		String etc_files = "";
		
		for(Part part : request.getParts()) {
			if (part.getContentType() != null) {
				String fileName = extractFileName(part);
				String alias = UUID.randomUUID().toString().substring(0, 9);
				String fileFormat = getFileFormat(part);
				
				
				switch(part.getName()) {
				case "cf_thumbnail":
					register.setCf_thumbnail(fileName);
					register.setCf_alias_thumbnail(alias + "cf_thumbnail" + fileFormat);
					part.write(companyFilePath.getApp_cp_image_path() + alias + "cf_thumbnail" + fileFormat);
					break;
				case "cf_info_banner":
					register.setCf_info_banner(fileName);
					register.setCf_alias_info_banner(alias + "cf_info_banner" + fileFormat);
					part.write(companyFilePath.getApp_cp_image_path() + alias + "cf_info_banner" + fileFormat);
					break;
				case "cf_store_images":
					cf_store_images.add(fileName);
					store_images += fileName + ",";
					cf_alias_store_images.add(alias + "cf_store_images" + fileFormat);
					part.write(companyFilePath.getApp_cp_image_path() + alias + "cf_store_images" + fileFormat);
					break;
				case "cf_pr_background":
					register.setCf_pr_background(fileName);
					register.setCf_alias_pr_background(alias + "cf_pr_background" + fileFormat);
					part.write(companyFilePath.getApp_cp_image_path() + alias + "cf_pr_background" + fileFormat);
					break;
				case "cf_business_plan_images":
					cf_business_plan_images.add(fileName);
					business_plan += fileName + ",";
					cf_alias_business_plan_images.add(alias + "cf_business_plan_images" + fileFormat);
					part.write(companyFilePath.getApp_cp_image_path() + alias + "cf_business_plan_images" + fileFormat);
					break;
				case "cf_business_plan":
					register.setCf_business_plan(fileName);
					register.setCf_alias_business_plan(alias + "cf_business_plan" + fileFormat);
					part.write(companyFilePath.getApp_cp_file_path() + alias + "cf_business_plan" + fileFormat);
					break;
				case "cf_funding_contract":
					register.setCf_funding_contract(fileName);
					register.setCf_alias_funding_contract(alias + "cf_funding_contract" + fileFormat);
					part.write(companyFilePath.getApp_cp_file_path() + alias + "cf_funding_contract" + fileFormat);
					break;
				case "cf_etc_files":
					cf_etc_files.add(fileName);
					etc_files += fileName + ",";
					cf_alias_etc_files.add(alias + "cf_etc_files" + fileFormat);
					part.write(companyFilePath.getApp_cp_file_path() + alias + "cf_etc_files" + fileFormat);
					break;
				default:
					break;
				}
			}
		}
		
		if (store_images.charAt(store_images.length()-1) == comma) {
			store_images.substring(0, store_images.length()-2); 
		}
		
		if (business_plan.charAt(business_plan.length()-1) == comma) {
			business_plan.substring(0, business_plan.length()-2); 
		}
		if (etc_files.charAt(etc_files.length()-1) == comma) {
			etc_files.substring(0, etc_files.length()-2); 
		}
		
		int result = -1;
		result = companyDAO.ComapnyRegister(register);
		
		// return null;
		if (result == 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('기업신청에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./companyRegisterForm.cp';");
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
