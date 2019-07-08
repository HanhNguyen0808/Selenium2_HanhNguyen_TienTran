package com.logigear.test.ta_dashboard.pom.Foody;

import java.util.ArrayList;

import com.logigear.test.ta_dashboard.data_object.Foody.SearchValue;
import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.TestExecutor;
import com.logigear.testfw.element.Element;

public class FoodyGeneralPage extends BasePOM {
	
	protected Element cbbLocation;
	protected Element cbbCategory;
	protected Element mneCategory;
	protected Element mneSubCategory;
	protected Element txtSearch;
	protected Element btnSearch;
	protected Element btnFilter;
	protected Element btnSelectType;
	protected Element btnChangeLanguage;
	protected Element mneLanguage;
	protected Element tblDelivery;
	protected Element otpLocation;
	protected Element txtLocation;
	protected Element filterForm;
	
	public FoodyGeneralPage(Class<?> derivedClass) {
		super(derivedClass);
	}
	
	@Override
	public void initPageElements() {
		this.cbbLocation = new Element(getLocator("cbbLocation").getBy());
		this.cbbCategory = new Element(getLocator("cbbCategory").getBy());
		this.txtSearch = new Element(getLocator("txtSearch").getBy());
		this.btnSearch = new Element(getLocator("btnSearch").getBy());
		this.btnFilter = new Element(getLocator("btnFilter").getBy());
		this.btnSelectType = new Element(getLocator("btnSelectType").getBy());
		this.btnChangeLanguage = new Element(getLocator("btnChangeLanguage").getBy());
		this.tblDelivery = new Element(getLocator("tblDelivery").getBy());
		this.txtLocation = new Element(getLocator("txtLocation").getBy());
		this.filterForm = new Element(getLocator("filterForm").getBy());
	}
	
	public void mneCategory(String type) {
		this.mneCategory = new Element(getLocator("mneCategory").getBy(type));
	}
	
	public void mneSubCategory(String type, String subType) {
		this.mneSubCategory = new Element(getLocator("mneSubCategory").getBy(type, subType));
	}
	
	public void mneLanguage(String language) {
		this.mneLanguage = new Element(getLocator("mneLanguage").getBy(language));
	}
	
	public void otpLocation(String location) {
		this.otpLocation = new Element(getLocator("otpLocation").getBy(location));
	}
	
	public FoodySearchResultPage searchWithOnlyLocation(String foodStore) {
		logger.printMessage("Enter value: " + foodStore + " in \"Search\" textbox to search.");
		enterFilterValue(foodStore);
		btnSearch.click();
		//tblDelivery.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return new FoodySearchResultPage();
	}
	
	//@author hanh.nguyen
	//The tabIndex starts with 0
	public void switchTab(int tabIndex) {
		try {
			LOG.info(String.format("Try to switch tab in browser."));
			
			ArrayList<String> tabs = new ArrayList<String> (TestExecutor.getInstance().getCurrentDriver().getWindowHandles());
			if(tabIndex > tabs.size() - 1) {
				LOG.severe("The index is out of bound.");
				return;
			}
			TestExecutor.getInstance().getCurrentDriver().switchTo().window(tabs.get(tabIndex));
		} catch (Exception error) {
			LOG.severe(String.format("Has error when switching tab in browser."));
			throw error;
		}
	}
	
	public void enterFilterValue(String value) {
		if(value != null && (txtSearch.getText() == null || txtSearch.getText() != value)) {
			logger.printMessage("In \"Search\" textbox, enter: " + value);
			txtSearch.enter(value);
		}
	}
	
	public void selectLocation(String location) {
		if(location != null && location != cbbLocation.getText()){
			logger.printMessage("In \"Location\" combobox, seach: " + location);
			cbbLocation.click();
			otpLocation(location);
			otpLocation.waitForClickable(Common.ELEMENT_TIMEOUT);
			otpLocation.click();
		}
	}
	
	public void selectCategory(String category) {
		if(category != null && category != cbbCategory.getText()){
			logger.printMessage("In \"Category\" combobox, seach: " + category);
			String[] menuItem = category.split("->", 2);
			cbbCategory.click();
			mneCategory(menuItem[0].trim());
			mneCategory.moveToElement();
			mneSubCategory(menuItem[0].trim(), menuItem[1].trim());
			mneSubCategory.click();
		}
	}
	
	public FoodySearchResultPage searchFoodStore(SearchValue searchValue) {
		logger.printMessage("Search food store.");
		enterFilterValue(searchValue.getStore());
		selectLocation(searchValue.getLocation());
		selectCategory(searchValue.getCategory());
		btnSearch.click();
		return new FoodySearchResultPage();
	}
	
	public FilterForm openFilterForm() {
		if(!filterForm.isDisplayed()) {
			logger.printMessage("Open \"Filter Form\" by clicking \"Filert\" button.");
			btnFilter.click();
		}
		return new FilterForm();
	}
	
	
}
