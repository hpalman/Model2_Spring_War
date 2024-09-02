package com.model2.spring.jdbctemplate.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.model2.spring.jdbc.comm.dao.Dao_People;
import com.model2.spring.jdbc.comm.vo.Vo_People;
import com.model2.spring.jdbctemplate.dao.Dao_jt_People;

@Service
public class Sv_jt_People implements Sv_jt_IfPeople {

	Dao_jt_People dao_jt_People;
	
	//@Autowired
	public Sv_jt_People(Dao_jt_People dao_jt_People) {
		this.dao_jt_People = dao_jt_People;
	}
	
	// People의 값을 전부 가져오는 메서드
	@Override
	public List<Vo_People> doReadList() {
		List<Vo_People> list = dao_jt_People.doReadList();
		return list;
	}

	// 특정 Id 값을 가져오는 메서드
	@Override
	public Vo_People doReadId(String id) {
		Vo_People vo_People = null;

		// data 유효성 검증
		if ( id != null ) {
			// vo_People = dao_jt_People.doReadId(id);
		} else {
			vo_People = null;
		}
		return vo_People;
	}

	// Id를 생성하는 메서드
	@Override
	public int doCreate(Vo_People vo_PeoPle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdate(Vo_People vo_PeoPle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
