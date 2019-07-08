package com.logigear.test.ta_dashboard.data_object.Foody;

public class SearchValue {
	
	protected String _location, _category, _store, _type, _language;
	protected String[] _region, _foodType, _foodCategory;

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		this._location = location;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		this._category = category;
	}

	public String getStore() {
		return _store;
	}

	public void setStore(String store) {
		this._store = store;
	}

	public String[] getRegion() {
		return _region;
	}

	public void setRegion(String[] region) {
		this._region = region;
	}

	public String[] getFoodType() {
		return _foodType;
	}

	public void setFoodType(String[] foodType) {
		this._foodType = foodType;
	}

	public String[] getFoodCategory() {
		return _foodCategory;
	}

	public void setFoodCategory(String[] foodCategory) {
		this._foodCategory = foodCategory;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		this._type = type;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		this._language = language;
	}
	
	

}
