package com.model2.spring.mybatis.controller;

import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model2.spring.mybatis.service.Sv_mbt_IfPeople;
import com.model2.spring.vo.Vo_People;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mybatis")
public class Con_mbt_People {
	
	Sv_mbt_IfPeople sv_People;
	
	/* 생성자를 통한 DI */
	@Autowired
	public Con_mbt_People(Sv_mbt_IfPeople sv_People) {
		this.sv_People = sv_People;
	}

	/* People의 값을 전부 가져오는 메서드 */
	@RequestMapping("/PeopleList")
	public String getPeopleList(Model model) {
		//
		System.out.println("Hi Spring - mybatis -  getPeopleList - Model2_Spring_War");	
		List<Vo_People> list = new ArrayList<>();
		
		list = sv_People.doReadList();
		
		System.out.println("2. list size"+ list.size());	
		model.addAttribute("people", list);
		model.addAttribute("path","mybatis");

		return "jdbc/list";
	}
	
	/* 특정 Id값을 가져오은 메서드 */
	@RequestMapping("/PeopleId")
	public String getPeopleId(HttpServletRequest request, Model model) {
		System.out.println("Hi Spring -  mybatis -  getPeopleId - Model2_Spring_War");	
		String strId = request.getParameter("id");
		Vo_People vo_People = sv_People.doReadId(strId);
		model.addAttribute("vo_people", vo_People);
		model.addAttribute("path","mybatis");

		return "jdbc/list_id";
	}

	/* Id를 생성하는 메서드 */
	@RequestMapping("/PeopleCreate")
	public String getPeopleCreate(@ModelAttribute Vo_People vo_People) {
		
		System.out.println("Hi Spring -  mybatis - getPeopleCreate - Model2_Spring_War");	
		int int_result = sv_People.doCreate(vo_People.getId(), vo_People.getName(), vo_People.getAge());

		return "redirect:/mybatis/PeopleList";
	}
	

	/* Id를 수정하는 메서드 */
	@RequestMapping("/PeopleUpdate")
	public String getPeopleUpdate(@ModelAttribute Vo_People vo_People) {
		
		System.out.println("Hi Spring -  mybatis - getPeopleUpdate - Model2_Spring_War");	
		int int_result = sv_People.doUpdate(vo_People);

		return "redirect:/mybatis/PeopleList";
		//return "/WEB-INF/view/list.jsp";	
	}

	/* Id를 삭제하는 메서드 */
	@RequestMapping("/PeopleDelete")
	public String getPeopleDelete(HttpServletRequest request) {
		System.out.println("Hi Spring -  mybatis - getPeopleDelete - Model2_Spring_War");	
		String strId = request.getParameter("id");

		int int_result = sv_People.doDelete(strId);

		return "redirect:/mybatis/PeopleList";
	}
}
