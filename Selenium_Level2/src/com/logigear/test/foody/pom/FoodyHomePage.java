package com.logigear.test.foody.pom;

import java.util.ArrayList;

import com.logigear.testfw.element.Element;

public class FoodyHomePage extends FoodyGeneralPage{
	
	protected Element lblTableTitle;
	
	public FoodyHomePage() {
		super(FoodyHomePage.class);
	}
	
	@Override
	public void initPageElements() {
		super.initPageElements();
		//this.lblShipTable = new Element(getLocator("lblShipTable").getBy());
	}
	
	public void lblTableTitle(String title) {
		this.lblTableTitle = new Element(getLocator("lblTableTitle").getBy(title));
	}
	
	public boolean areHomePageTableTitleDisplay(String... title) {
		ArrayList<Boolean> areDisplay = new ArrayList<Boolean>();
		for (String item : title) {
			boolean isDisplay = false;
			lblTableTitle(item);
			if(lblTableTitle.isDisplayed())
				isDisplay = true;
			areDisplay.add(isDisplay);
			logger.printMessage(String.format("Is table title %s display: %s", item, isDisplay));
		}
		if(areDisplay.contains(false)) {
			logger.printMessage("The table titles are not display correctly.");
			return false;
		}
		else {
			logger.printMessage("The table titles are display correctly.");
			return true;
		}
	}

}
