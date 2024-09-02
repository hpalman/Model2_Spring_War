package com.model2.spring.jdbctemplate.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//import com.model2.spring.jdbc.comm.DbConn;
import com.model2.spring.jdbc.comm.vo.Vo_People;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Dao_jt_People {

	@Autowired
	JdbcTemplate template;
	
	// People의 값을 전부 가져오는 메서드
	public List<Vo_People> doReadList() {
		String qry = "";
		
		List<Vo_People> list = new ArrayList<>();
		
		try {
			// Result set, Print
			qry = " SELECT ID, NAME, AGE, TO_CHAR(REG_DATE,'yyyy.mm.dd') as DATI" 
					+ "FROM PEOPLE" 
					+ "ORDER BY ID ";
			log.info(qry);
			
			list = template.query(qry, new BeanPropertyRowMapper<Vo_People>(Vo_People.class));
			
			log.info("doReadList " + list.size());

		} catch(Exception e) {
			System.out.println("Error => " + e);
		} finally {
			// Close
		}
		return list;
	}

	// 특정 Id 값을 가져오는 메서드
	public Vo_People doReadId(String id) {
		String qry = "";
		
		Vo_People vo_People = null;
		
		try {
			// Result set, Print
			qry = " SELECT ID, NAME, AGE, TO_CHAR(REG_DATE,'yyyy.mm.dd') as DATI" 
					+ "FROM PEOPLE " 
					+ "WHERE ID = ?";
			log.info(qry);
			
			vo_People = template.queryForObject(qry, new BeanPropertyRowMapper<Vo_People>(Vo_People.class), id);
			
		} catch(Exception e) {
			System.out.println("Error => " + e);
		} finally {
			// Close
		}
		return vo_People;
	}
	
	// Id를 생성하는메서드
	public int doCreate(Vo_People vo_People) {
		String qry = "";
		int intI = 0;
		try {
			// Rewult Set, Print
			qry = " INSERT INTO PEOPLE(ID,NAME,AGE) "
			     + "VALUES(?, ?, TO_NUMBER(?))";

			log.info(qry);
			
			intI = template.update(qry, vo_People.getId(), vo_People.getName(), vo_People.getAge());
			
		} catch(Exception e) {
			intI = 1;
			System.out.println("Error => " + e);
		} finally {
			// Close
		}
		return intI;
	}

	// Id를 수정하는메서드
	public int doUpdate(Vo_People vo_People) {
		String qry = "";
		int intI = 0;
		try {
			// Rewult Set, Print
			qry = " UPDATE PEOPLE "
				+ " SET "
				+ " NAME = ?, AGE=?"
  		        + " WHERE ID = ?";

			log.info(qry);
			
			intI = template.update(qry, vo_People.getName(), vo_People.getAge(), vo_People.getId() );
			
		} catch(Exception e) {
			intI = 1;
			System.out.println("Error => " + e);
		} finally {
			// Close
		}
		return intI;
	}

	// Id를 삭제하는메서드
	public int doDelete(Vo_People vo_People) {
		String qry = "";
		int intI = 0;
		try {
			// Rewult Set, Print
			qry = " DELETE FROM PEOPLE "
  		        + " WHERE ID = ?";

			log.info(qry);
			
			intI = template.update(qry, vo_People.getName(), vo_People.getAge(), vo_People.getId() );
			
		} catch(Exception e) {
			intI = -1;
			System.out.println("Error => " + e);
		} finally {
			// Close
		}
		return intI;
	}
}
