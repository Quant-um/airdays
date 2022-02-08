package com.airdays.dao;
import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class memberDAOImpl implements memberDAO {
	@Autowired SqlSession sqlSession; private static final String nameSpace = "com.user.mapper.userMapper";
	@Override public boolean userLogin(memberDTO dto) throws Exception {
		String name = sqlSession.selectOne(nameSpace + ".userLogin", dto); return (name == null) ? false : true; }
	@Override public void userJoin(memberDTO dto) throws Exception {
		sqlSession.insert(nameSpace + ".userJoin", dto); }
	@Override public memberDTO userDetail(String id) throws Exception {
		return sqlSession.selectOne(nameSpace + ".userDetail", id); }
	@Override
	public void userEdit(memberDTO dto) throws Exception {
		sqlSession.update(nameSpace + ".userEdit", dto); }
	@Override
	public void userDelete(String id) throws Exception {
		sqlSession.delete(nameSpace + ".userDelete", id); }
	@Override
	public List<memberDTO> userFindId(memberDTO dto) throws Exception {
		return sqlSession.selectList(nameSpace + ".userFindId", dto); }
	@Override
	public String userFindPw(memberDTO dto) throws Exception {
		return sqlSession.selectOne(nameSpace + ".userFindPw", dto); }
	@Override
	public int idCheck(String id) throws Exception {
		return sqlSession.selectOne(nameSpace + ".idCheck", id); } }
