package com.mycompany.myapp.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sm;
	
	List<MemberDto> getList(MemberDto dto){
		return sm.selectList("Member_list", dto);
	}
	
	void insert(MemberDto dto) {
		sm.insert("Member_insert", dto);
	}
	
	MemberDto view(MemberDto dto) {
		return sm.selectOne("Member_view", dto);
	}
}
