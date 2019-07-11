package com.logigear.test.foody.pom;

import java.util.ArrayList;

import com.logigear.testfw.element.Element;

public class FoodySearchResultPage extends FoodyGeneralPage{
	
	protected Element lnkSearchResult;
	
	public FoodySearchResultPage() {
		super(FoodySearchResultPage.class);
	}
	
	@Override
	public void initPageElements() {
		super.initPageElements();
		//this.cbbLocation = new Element(getLocator("cbbLocation").getBy());
	}
	
	public void lnkSearchResult(String name) {
		this.lnkSearchResult = new Element(getLocator("lnkSearchResult").getBy(name));
	}
	
	public FoodyStorePage chooseLocation(String location) {
		logger.printMessage("Choose a store: " + location);
		lnkSearchResult(location);
		lnkSearchResult.click();
		switchTab(1);
		return new FoodyStorePage();
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

}
