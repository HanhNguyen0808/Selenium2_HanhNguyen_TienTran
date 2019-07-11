package com.logigear.test.foody.pom;

import java.util.ArrayList;
import java.util.Arrays;

import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.Constant;
import com.logigear.testfw.element.Element;

public class FoodySearchResultPage extends FoodyGeneralPage{
	
	protected Element lnkSearchResult;
	protected Element itemLeftMenu;
	protected Element lnkTopToolbar;
	protected Element lnkFirstSearchResult;
	protected Element lblFirstSearchResultAddress;
	protected Element lblFirstSearchResultDistrict;
	protected Element lblFirstSearchResultCity;
	protected Element listStoreName;
	
	public FoodySearchResultPage() {
		super(FoodySearchResultPage.class);
	}
	
	@Override
	public void initPageElements() {
		super.initPageElements();
		this.lnkFirstSearchResult = new Element(getLocator("lnkFirstSearchResult").getBy());
		this.lblFirstSearchResultAddress = new Element(getLocator("lblFirstSearchResultAddress").getBy());
		this.lblFirstSearchResultDistrict = new Element(getLocator("lblFirstSearchResultDistrict").getBy());
		this.lblFirstSearchResultCity = new Element(getLocator("lblFirstSearchResultCity").getBy());
		this.listStoreName = new Element(getLocator("listStoreName").getBy());
	}
	
	public void lnkSearchResult(String name) {
		this.lnkSearchResult = new Element(getLocator("lnkSearchResult").getBy(name));
	}
	
	public void itemLeftMenu(String menuItem) {
		this.itemLeftMenu = new Element(getLocator("itemLeftMenu").getBy(menuItem));
	}
	
	public void lnkTopToolbar(String toolbar) {
		this.lnkTopToolbar = new Element(getLocator("lnkTopToolbar").getBy(toolbar));
	}
	
	public FoodyStorePage chooseLocation(String location) {
		logger.printMessage("Choose a store: " + location);
		lnkSearchResult(location);
		lnkSearchResult.click();
		switchTab(1);
		return new FoodyStorePage().waitForLoading();
	}
	
	public FoodyStorePage chooseRandomLocation() {
		logger.printMessage("Choose first store in result grid: " + lnkFirstSearchResult.getText());
		lnkFirstSearchResult.waitForDisplay(Common.ELEMENT_TIMEOUT);
		getRandomStoreName();
		getRandomStoreAddress();
		getRandomStoreDistrict();
		getRandomStoreCity();
		lnkFirstSearchResult.click();
		switchTab(1);
		return new FoodyStorePage().waitForLoading();
	}
	
	public FoodySearchResultPage waitForLoading(int timeOutInSeconds) {
		lnkFirstSearchResult.waitForClickable(timeOutInSeconds);
		return this;
	}
	
	public String getRandomStoreName() {
		Constant.storeName = lnkFirstSearchResult.getText().trim();
		logger.printMessage("The random store name is: " + Constant.storeName);
		return Constant.storeName;
	}
	
	public String getRandomStoreAddress() {
		Constant.storeAddress = lblFirstSearchResultAddress.getText().trim();
		logger.printMessage("The random store address is: " + Constant.storeAddress);
		return Constant.storeAddress;
	}
	
	public String getRandomStoreDistrict() {
		if(lblFirstSearchResultDistrict.isDisplayed()) {
			Constant.storeDistrict = lblFirstSearchResultDistrict.getText().trim();
			logger.printMessage("The random store district is: " + Constant.storeDistrict);
		}
		else 
			Constant.storeDistrict = "";
		return Constant.storeDistrict; 
	}
	
	public String getRandomStoreCity() {
		if(lblFirstSearchResultCity.isDisplayed()) {
			Constant.storeCity = lblFirstSearchResultCity.getText().trim();
			logger.printMessage("The random store district is: " + Constant.storeCity);
		}
		else 
			Constant.storeCity = "";
		return Constant.storeCity;
	}
	
	public boolean isStoreDisplayInResultPage(String... storeName) {
		ArrayList<Boolean> areDisplay = new ArrayList<Boolean>();
		for (String name : storeName) {
			boolean isDisplay = false;
			lnkSearchResult(name);
			if(lnkSearchResult.isDisplayed())
				isDisplay = true;
			areDisplay.add(isDisplay);
			logger.printMessage(String.format("Is store %s in search result: %s", name, isDisplay));
		}
		if(areDisplay.contains(false)) {
			logger.printMessage("The stores are not all in search result.");
			return false;
		}
		else {
			logger.printMessage("The stores are all in search result.");
			return true;
		}
	}
	
	public boolean isLeftMenuItemSelected(String menuItem) {
		boolean isSelected = false;
		itemLeftMenu(menuItem);
		if(itemLeftMenu.getAttribute("class").equals("current"))
			isSelected = true;
		logger.printMessage("Is Left menu item " + menuItem + " selected: " + isSelected);
		return isSelected;
	}
	
	public FoodySearchResultPage clickTopToolbar(String toolbar) {
		logger.printMessage("Click the Top Toolbar: " + toolbar);
		lnkTopToolbar(toolbar);
		lnkTopToolbar.click();
		return this;
	}
	
	public boolean areAllDiplayItemsContainText(String text) {
		ArrayList<Boolean> areContain = new ArrayList<Boolean>();
		ArrayList<String> storeNames = new ArrayList<>(Arrays.asList(listStoreName.getText())); 
		//ArrayList<String> storeNames = (ArrayList<String>) Arrays.asList(listStoreName.getText());
		for (String name : storeNames) {
			boolean isContain = false;
			if(name.contains(text))
				isContain = true;
			areContain.add(isContain);
			logger.printMessage(String.format("Is table title %s display: %s", name, isContain));
		}
		if(areContain.contains(false)) {
			logger.printMessage("Not all items in result grid contain text: " + text);
			return false;
		}
		else {
			logger.printMessage("All items in result grid contain text: " + text);
			return true;
		}
	}

}
