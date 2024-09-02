package com.model2.spring.vo;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* People DB에서 값을 받아 저장하고, View에 던져주는 매개체 역할을 한다. */

@Getter
@Setter
@ToString
@AllArgsConstructor // 멤버변수를 사용하는 생성자
// @Data
public class Vo_People {
	private String id;
	private String name;
	private String age;
	private String dati;
}
