package com.logigear.test.ta_dashboard.pom.Foody;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.element.Element;

public class FilterForm extends BasePOM{
	
	protected Element cbbLocation;
	
	public FilterForm() {
		super(FilterForm.class);
	}
	
	@Override
	public void initPageElements() {
		this.cbbLocation = new Element(getLocator("cbbLocation").getBy());
		
	}
	
	

}
