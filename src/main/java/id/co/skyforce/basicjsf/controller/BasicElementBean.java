package id.co.skyforce.basicjsf.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BasicElementBean {

	private String message;
	private String password;
	private String address;
	private String hiddenText;
	private Integer age = 17;
	private List<String> favoritFruits;
	private String favoritSoapOpera;
	private String favoritFootballClub;
	private Long id;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFavoritFootballClub() {
		return favoritFootballClub;
	}

	public void setFavoritFootballClub(String favoritFootballClub) {
		this.favoritFootballClub = favoritFootballClub;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHiddenText() {
		return hiddenText;
	}

	public void setHiddenText(String hiddenText) {
		this.hiddenText = hiddenText;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getFavoritFruits() {
		return favoritFruits;
	}

	public void setFavoritFruits(List<String> favoritFruits) {
		this.favoritFruits = favoritFruits;
	}

	public String getFavoritSoapOpera() {
		return favoritSoapOpera;
	}

	public void setFavoritSoapOpera(String favoritSoapOpera) {
		this.favoritSoapOpera = favoritSoapOpera;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
