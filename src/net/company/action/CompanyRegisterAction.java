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
		String cp_point_comment[] = request.getParameterValues("cp_point_comment");
		List<String> point_title = new ArrayList<String>();
		List<String> point_comment = new ArrayList<String>();
		
		for(int i=0; i<cp_point_title.length; i++) {
			point_title.add(cp_point_title[i]);
		}
		for(int i=0; i<cp_point_comment.length; i++) {
			point_comment.add(cp_point_comment[i]);
		}
		
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
		List<String> pat_expected = new ArrayList<String>();
		List<String> pay_principal = new ArrayList<String>();
		List<String> pay_interest_paid = new ArrayList<String>();
		List<String> pay_fees = new ArrayList<String>();
		List<String> pay_actual_apyment = new ArrayList<String>();
		List<String> pay_actual_rate = new ArrayList<String>();
		
		for(int i=0; i<cp_pay_count.length; i++) {
			pay_count.add(cp_pay_count[i]);
		}
		for(int i=0; i<cp_pay_expected_payment_date.length; i++) {
			pat_expected.add(cp_pay_expected_payment_date[i]);
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
			pay_actual_apyment.add(cp_pay_actual_payment_amout[i]);
		}
		for(int i=0; i<cp_pay_actual_rate_return.length; i++) {
			pay_actual_rate.add(cp_pay_actual_rate_return[i]);
		}
		
		
		// 유의사항
		String cp_notice_title[] = request.getParameterValues("notice_title");
		String cp_notice_content[] = request.getParameterValues("notice_content");
		List<String> notice_title = new ArrayList<String>();
		List<String> notice_content = new ArrayList<String>();
		for(int i=0; i<cp_notice_title.length; i++) {
			notice_title.add(cp_notice_title[i]);
		}
		for(int i=0; i<cp_notice_content.length; i++) {
			notice_content.add(cp_notice_content[i]);
		}
		
		// 날짜변환 기능
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String now = format.format(date);
		
		// 폴더이름 변수
		String cp_folder = cp_manager + "_" + cp_name + "_" + now + "/";
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
		
		int store_count = 0;
		int business_count = 0;
		int etc_count = 0;
		for(Part part : request.getParts()) {
			if (part.getContentType() != null) {
				String fileName = extractFileName(part);
				String alias = UUID.randomUUID().toString().substring(0, 9);
				String fileFormat = getFileFormat(part);

				switch(part.getName()) {
				case "cf_thumbnail":
					register.setCf_thumbnail(fileName);
					register.setCf_alias_thumbnail(alias + "cf_thumbnail" + fileFormat);
					part.write(companyFilePath.getApp_cp_file_path() + alias + "cf_thumbnail" + fileFormat);
					break;
				case "cf_info_banner":
					register.setCf_info_banner(fileName);
					register.setCf_alias_info_banner(alias + "cf_info_banner" + fileFormat);
					part.write(companyFilePath.getApp_cp_file_path() + alias + "cf_info_banner" + fileFormat);
					break;
				case "cf_store_images":
					store_count++;
					cf_store_images.add(fileName);
					cf_alias_store_images.add(alias + "cf_store_images" + store_count + fileFormat);
					part.write(companyFilePath.getApp_cp_file_path() + alias + "cf_store_images" + store_count + fileFormat);
					break;
				case "cf_pr_background":
					register.setCf_pr_background(fileName);
					register.setCf_alias_pr_background(alias + "cf_pr_background" + fileFormat);
					part.write(companyFilePath.getApp_cp_file_path() + alias + "cf_pr_background" + fileFormat);
					break;
				case "cf_business_plan_images":
					business_count++;
					cf_business_plan_images.add(fileName);
					cf_alias_business_plan_images.add(alias + "cf_business_plan_images" + business_count + fileFormat);
					part.write(companyFilePath.getApp_cp_file_path() + alias + "cf_business_plan_images" + business_count + fileFormat);
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
					etc_count++;
					cf_etc_files.add(fileName);
					cf_alias_etc_files.add(alias + "cf_etc_files" + store_count + fileFormat);
					part.write(companyFilePath.getApp_cp_file_path() + alias + "cf_etc_files" + etc_count + fileFormat);
					break;
				default:
					break;
				}
			}
		}
		int result = -1;
		result = companyDAO.ComapnyRegister(register, cf_store_images, cf_alias_store_images, cf_business_plan_images, cf_alias_business_plan_images, 
				cf_etc_files, cf_alias_etc_files, cf_info_banner, cf_alias_info_banner, notice_title, notice_content, pay_count, pat_expected, 
				pay_principal, pay_interest_paid, pay_fees, pay_actual_apyment, pay_actual_rate, point_title, point_comment);
		
		// return null;
		if (result == 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('기업신청에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./Application1.cp';");
			out.println("</script>");
			out.close();
			return null;
		}else if(result == 1) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('기업신청이 완료되었습니다.');");
			out.println("location.href='./Index.mb';");
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
