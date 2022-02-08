package com.airdays.log;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.airdays.dto.memberDTO;
import com.airdays.service.memberService;
@Controller
@RequestMapping("/user") public class HomeController {
	@Autowired private memberService service;
	// 로그인 페이지
	@RequestMapping("/loginPage") public String userLoginPage() { return "/user/UserLogin"; }
	// 로그인
	@RequestMapping("/login") public ModelAndView userLogin(@ModelAttribute memberDTO dto, HttpSession session) throws Exception {
		boolean result = service.userLogin(dto, session); ModelAndView mav = new ModelAndView(); if (result == true) { mav.setViewName("redirect:/board/list"); } else { mav.setViewName("/user/UserLogin"); } return mav; }
	// 회원가입 페이지
	@RequestMapping("/joinPage") public String userJoinPage() { return "/user/UserJoin"; }
	// 회원가입
	@RequestMapping("/join") public String userJoin(@ModelAttribute memberDTO dto) throws Exception {
		service.userJoin(dto); return "redirect:/user/loginPage"; }
	// 아이디 중복 검사
	@RequestMapping("/idCheck") public void idCheck(@RequestParam String id, HttpServletResponse res) throws Exception {
		int result = 0; if (service.idCheck(id) != 0) { result = 1; } res.getWriter().print(result); }
	// 회원 정보
	@RequestMapping("/detail") public ModelAndView userDetail(@RequestParam String id) throws Exception {
		ModelAndView mav = new ModelAndView(); mav.setViewName("/user/UserDetail"); mav.addObject("userDetail", service.userDetail(id)); return mav; }
	// 정보 수정 페이지
	@RequestMapping("/editPage") public ModelAndView userEditPage(@RequestParam String id) throws Exception {
		ModelAndView mav = new ModelAndView(); mav.setViewName("/user/UserEdit"); mav.addObject("userEdit", service.userDetail(id)); return mav; }
	// 정보 수정
	@RequestMapping("/edit") public String userEdit(@ModelAttribute memberDTO dto) throws Exception {
		service.userEdit(dto); return "redirect:/user/detail?id=" + dto.getId(); }
	// 회원 삭제
	@RequestMapping("delete") public String userDelete(@RequestParam String id, HttpSession session) throws Exception {
		service.userDelete(id, session); return "redirect:/user/loginPage"; }
	// 로그아웃
	@RequestMapping("/logout") public String userLogout(HttpSession session) throws Exception {
		service.userLogout(session); return "redirect:/user/loginPage"; }
	// 회원 정보 찾기 페이지
	@RequestMapping("/findPage") public String userFindPage() { return "/user/UserFind"; }
	// 아이디 찾기 페이지
	@RequestMapping("/findIdPage") public String userFindIdPage() { return "/user/UserFindId"; }
	// 비밀번호 찾기 페이지
	@RequestMapping("/findPwPage") public String userFindPwPage() { return "/user/UserFindPw"; }
	// 아이디 찾기
	@RequestMapping("/findId") public ModelAndView userFindId(@ModelAttribute memberDTO dto) throws Exception {
		ModelAndView mav = new ModelAndView(); List<memberDTO> userList = service.userFindId(dto); System.out.println(userList); mav.setViewName("/user/UserId"); mav.addObject("userFindId", userList); return mav; }
	// 비밀번호 찾기
	@RequestMapping("/findPw") public ModelAndView userFindPw(@ModelAttribute memberDTO dto) throws Exception {
		ModelAndView mav = new ModelAndView(); String pw = service.userFindPw(dto); mav.setViewName("/user/UserPw"); mav.addObject("userFindPw", pw); return mav; } }
}
