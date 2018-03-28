package com.example.cozmo.crud_mysql_android.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ModelInventori{

	@SerializedName("DataInventori")
	private List<DataInventoriItem> dataInventori;

	public void setDataInventori(List<DataInventoriItem> dataInventori){
		this.dataInventori = dataInventori;
	}

	public List<DataInventoriItem> getDataInventori(){
		return dataInventori;
	}
}