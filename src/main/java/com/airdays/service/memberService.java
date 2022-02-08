package com.airdays.service;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.user.db.UserDTO;
public interface memberService {
	public boolean userLogin(memberDTO dto, HttpSession session) throws Exception;
	public void userJoin(memberDTO dto) throws Exception;
	public UserDTO userDetail(String id) throws Exception;
	public void userEdit(memberDTO dto) throws Exception;
	public void userDelete(String id, HttpSession session) throws Exception;
	public void userLogout(HttpSession session) throws Exception;
	public List<memberDTO> userFindId(memberDTO dto) throws Exception;
	public String userFindPw(memberDTO dto) throws Exception;
	public int idCheck(String id) throws Exception; }
