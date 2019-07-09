package com.logigear.test.ta_dashboard.pom.Foody;

import java.util.ArrayList;

import com.logigear.testfw.element.Element;

public class FoodySearchResultPage extends FoodyGeneralPage{
	
	protected Element imgSearchResult;
	
	public FoodySearchResultPage() {
		super(FoodySearchResultPage.class);
	}
	
	@Override
	public void initPageElements() {
		super.initPageElements();
		//this.cbbLocation = new Element(getLocator("cbbLocation").getBy());
	}
	
	public void imgSearchResult(String name) {
		this.imgSearchResult = new Element(getLocator("imgSearchResult").getBy(name));
	}
	
	public FoodyStorePage chooseLocation(String location) {
		logger.printMessage("Choose a store: " + location);
		imgSearchResult(location);
		imgSearchResult.click();
		switchTab(1);
		return new FoodyStorePage();
	}
	
	public boolean isStoreDisplayInResultPage(String... storeName) {
		ArrayList<Boolean> areDisplay = new ArrayList<Boolean>();
		for (String name : storeName) {
			boolean isDisplay = false;
			imgSearchResult(name);
			if(imgSearchResult.isDisplayed())
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
