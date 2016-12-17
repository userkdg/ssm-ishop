package com.ishop.myMapper;

import java.util.Date;

public class ItemParam {
	private String id;
	private String itemCatId;
	private String itemCatName;
	private String param_data;
	private Date created;
	private Date updated;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemCatId() {
		return itemCatId;
	}
	public void setItemCatId(String itemCatId) {
		this.itemCatId = itemCatId;
	}
	public String getItemCatName() {
		return itemCatName;
	}
	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}
	public String getParam_data() {
		return param_data;
	}
	public void setParam_data(String param_data) {
		this.param_data = param_data;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	
}

