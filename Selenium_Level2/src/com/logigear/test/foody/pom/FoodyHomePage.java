package com.logigear.test.foody.pom;

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
