package com.model2.spring.jdbc.comm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.model2.spring.jdbc.comm.DbConn;
import com.model2.spring.vo.Vo_People;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Dao_People {

	Connection conn = null; // DB에 connection 된 객체를 저장
	PreparedStatement ps = null; // connection 객체에 실행문을 던지는 역할(창수)
	ResultSet rs = null;
	
	// People의 값을 전부 가져오는 메서드
	public List<Vo_People> doReadList() {
		String qry = "";
		DbConn dbConn = new DbConn();
		conn = dbConn.getConn();
		
		List<Vo_People> list = new ArrayList<>();
		
		try {
			// Result set, Print
			qry = " SELECT ID, NAME, AGE, TO_CHAR(REG_DATE,'yyyy.mm.dd') as DATI"
					+ "FROM PEOPLE"
					+ "ORDER BY ID ";
			ps = conn.prepareStatement(qry);
			log.info(qry);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				// People 생성자를 이용하여 값을 입력
				Vo_People vo_People = new Vo_People(
						  rs.getString("id")
						, rs.getString("name")
						, rs.getString("age")
						, rs.getString("")
						);
				list.add(vo_People);
			}
		} catch(Exception e) {
			System.out.println("Error => " + e);
		} finally {
			// Close
			try {
				if ( rs != null) rs.close();
				if ( ps != null) ps.close();
				if ( conn != null) conn.close();
				
			} catch(Exception e) {
				
			}
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
			
			// vo_People = template.queryForObject(qry, new BeanPropertyRowMapper<Vo_People>(Vo_People.class), id);
			
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
		DbConn dbConn = new DbConn();
		conn = dbConn.getConn();
		
		int intI = 0;
		try {
			// Rewult Set, Print
			qry = " INSERT INTO PEOPLE(ID,NAME,AGE) "
			     + "VALUES(?, ?, TO_NUMBER(?))";
			ps = conn.prepareStatement(qry);
			ps.setString(1,  vo_People.getId());
			ps.setString(2,  vo_People.getName());
			ps.setString(3,  vo_People.getAge());

			log.info(qry);
			
			intI = ps.executeUpdate();
			
		} catch(Exception e) {
			intI = 1;
			System.out.println("Error => " + e);
		} finally {
			// Close
			try {
				if ( rs != null) rs.close();
				if ( ps != null) ps.close();
				if ( conn != null) conn.close();
				
			} catch(Exception e) {
				
			}
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
			
			// intI = template.update(qry, vo_People.getName(), vo_People.getAge(), vo_People.getId() );
			
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
			
			//intI = template.update(qry, vo_People.getName(), vo_People.getAge(), vo_People.getId() );
			
		} catch(Exception e) {
			intI = -1;
			System.out.println("Error => " + e);
		} finally {
			// Close
		}
		return intI;
	}
	
}
