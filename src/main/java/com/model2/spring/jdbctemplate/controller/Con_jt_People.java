package com.model2.spring.jdbctemplate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model2.spring.vo.Vo_People;
import com.model2.spring.jdbctemplate.service.Sv_jt_People;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/jdbctemplate")
public class Con_jt_People {
	
	Sv_jt_People sv_jt_People;
	
	/* 생성자를 통한 DI */
	@Autowired
	public Con_jt_People(Sv_jt_People sv_jt_People) {
		this.sv_jt_People = sv_jt_People;
	}

	/* People의 값을 전부 가져오는 메서드 */
	@RequestMapping("/PeopleList")
	public String getPeopleList(Model model) {
		//
		List<Vo_People> list = new ArrayList<>();
		
		list = sv_jt_People.doReadList();
		
		model.addAttribute("people", list);
		model.addAttribute("path",  "jdbctemplate");

		return "jdbc/list";
	}
	
	/* 특정 Id값을 가져오은 메서드 */
	@RequestMapping("/PeopleId")
	public String getPeopleId(HttpServletRequest request, Model model) {
		String strId = request.getParameter("id");
		Vo_People vo_People = sv_jt_People.doReadId(strId);
		model.addAttribute("vo_people", vo_People);

		return "jdbc/list_id";
	}

	/* Id를 생성하는 메서드 */
	@RequestMapping("/PeopleCreate")
	public String getPeopleCreate(HttpServletRequest request, Vo_People vo_People) {
		
		int int_result = sv_jt_People.doCreate(vo_People);

		return "redirect:/jdbc/PeopleList";
	}
	

	/* Id를 수정하는 메서드 */
	@RequestMapping("/PeopleUpdate")
	public String getPeopleUpdate(HttpServletRequest request, Vo_People vo_People) {
		
		int int_result = sv_jt_People.doUpdate(vo_People);

		return "redirect:/jdbc/PeopleList";
	}

	/* Id를 삭제하는 메서드 */
	@RequestMapping("/PeopleDelete")
	public String getPeopleDelete(HttpServletRequest request) {
		String strId = request.getParameter("id");

		int int_result = sv_jt_People.doDelete(strId);

		return "redirect:/jdbc/PeopleList";
	}
}
