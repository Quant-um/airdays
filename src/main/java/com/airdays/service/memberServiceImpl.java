package com.airdays.service;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airdays.dao.memberDAO;
import com.airdays.dto.memberDTO;
@Service public class UserServiceImpl
implements UserService {
@Autowired
private memberDAO dao;
@Autowired
private static Hashtable<String, String>
loginUsers = new Hashtable<String, String>();
@Override
public boolean userLogin(memberDTO dto, HttpSession session) throws Exception {
	boolean isLogin = isLogin(dto.getId());
	if (!isLogin) {
		boolean result = dao.userLogin(dto);
		if (result) {
			setSession(session, dto);
			}
		return result;
		}
	return !isLogin; }
@Override
public void userJoin(memberDTO dto) throws Exception {
	dto.setId(dto.getId()); dto.setPw(dto.getPw()); dto.setName(dto.getName()); dto.setZipcode(dto.getZipcode()); dto.setAddr1(dto.getAddr1()); dto.setAddr2(dto.getAddr2()); dto.setPhone(dto.getPhone()); dto.setEmail(dto.getEmail()); dao.userJoin(dto); }
@Override
public memberDTO userDetail(String id) throws Exception {
	return dao.userDetail(id); }
@Override
public void userEdit(memberDTO dto) throws Exception {
	dao.userEdit(dto); }
@Override
public void userDelete(String id, HttpSession session) throws Exception {
	session.invalidate(); dao.userDelete(id); }
@Override
public void userLogout(HttpSession session) throws Exception {
	loginUsers.remove(session.getId()); session.invalidate(); }
// 로그인이 되어있는지 확인
public boolean isLogin(String id) {
	boolean isLogin = false;
	Enumeration<String> e = loginUsers.keys(); String key = "";
	while (e.hasMoreElements()) { key = (String) e.nextElement();
	if (id.equals(loginUsers.get(key))) isLogin = true; } return isLogin; }
public boolean isUsing(String sessionId) {
	boolean isUsing = false;
	Enumeration<String> e = loginUsers.keys(); String key = "";
	while (e.hasMoreElements()) { key = (String) e.nextElement();
	if (sessionId.equals(loginUsers.get(key))) isUsing = true; }
	return isUsing; }
public void setSession(HttpSession session, memberDTO dto) {
	loginUsers.put(session.getId(), dto.getId()); session.setAttribute("id", dto.getId()); }
@Override
public List<UserDTO> userFindId(memberDTO dto) throws Exception {
	return dao.userFindId(dto); }
@Override
public String userFindPw(memberDTO dto) throws Exception {
	return dao.userFindPw(dto); }
@Override
public int idCheck(String id) throws Exception {
	return dao.idCheck(id); } }
}
