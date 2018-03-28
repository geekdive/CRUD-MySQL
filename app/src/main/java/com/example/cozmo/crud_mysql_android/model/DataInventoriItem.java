package com.example.cozmo.crud_mysql_android.model;

import com.google.gson.annotations.SerializedName;

public class DataInventoriItem{

	@SerializedName("img_invventori")
	private String imgInvventori;

	@SerializedName("id_kategori")
	private String idKategori;

	@SerializedName("nama_inventori")
	private String namaInventori;

	@SerializedName("id_inventori")
	private String idInventori;

	@SerializedName("waktu_input")
	private String waktuInput;

	@SerializedName("id_user")
	private String idUser;

	public void setImgInvventori(String imgInvventori){
		this.imgInvventori = imgInvventori;
	}

	public String getImgInvventori(){
		return imgInvventori;
	}

	public void setIdKategori(String idKategori){
		this.idKategori = idKategori;
	}

	public String getIdKategori(){
		return idKategori;
	}

	public void setNamaInventori(String namaInventori){
		this.namaInventori = namaInventori;
	}

	public String getNamaInventori(){
		return namaInventori;
	}

	public void setIdInventori(String idInventori){
		this.idInventori = idInventori;
	}

	public String getIdInventori(){
		return idInventori;
	}

	public void setWaktuInput(String waktuInput){
		this.waktuInput = waktuInput;
	}

	public String getWaktuInput(){
		return waktuInput;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}
}