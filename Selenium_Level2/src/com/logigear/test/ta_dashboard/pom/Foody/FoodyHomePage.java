package com.logigear.test.ta_dashboard.pom.Foody;

public class FoodyHomePage extends FoodyGeneralPage{
	
	//protected Element cbbLocation;
	
	public FoodyHomePage() {
		super(FoodyHomePage.class);
	}
	
	@Override
	public void initPageElements() {
		super.initPageElements();
		//this.cbbLocation = new Element(getLocator("cbbLocation").getBy());
	}

}
