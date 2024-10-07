package com.test.api.food;

public class FoodDTO {
	
	private String seq;
	private String name;
	private String lat;
	private String lng;
	private String address;
	private String star;
	private String menu;

	/*
	 * FK DTO
	 * 1. 키값을 그대로 받아오기
	 * 	- 관계키 값을 가져와야 할 때 한번 더 거쳐야 함
	 * 	- 처음 작업 간단/후처리 복잡
	 * 
	 * 2. 바로 관계테이블 내용을 가져오기
	 * 	- 조인해서 가져오거나 두번 거쳐서 가져옴
	 * 	- 처음 작업 복잡/후처리 간단
	 * 
	 * 3. 두개를 동시에 사용하기도 함
	 * 	- 관계형 DB 테이블 <- 매핑 -> 객체 지향의 객체(클래스)
	 */
	private String category;
	private CategoryDTO categoryDTO;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
}
