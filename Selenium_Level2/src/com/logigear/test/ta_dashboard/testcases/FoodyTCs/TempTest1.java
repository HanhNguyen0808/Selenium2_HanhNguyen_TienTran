package com.logigear.test.ta_dashboard.testcases.FoodyTCs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.Foody.FoodyHomePage;
import com.logigear.test.ta_dashboard.pom.Foody.FoodyStorePage;
import com.logigear.testfw.common.BaseTest;

public class TempTest1 extends BaseTest{
	
	@Test
	public void TC_TempTest1() {
		
		String location = "Quán Ăn Năm Gia - Miến Gà";
		String address = "313 Phan Xích Long, P. 2,  Quận Phú Nhuận, TP. HCM";
		
		FoodyStorePage foodyStorePage = new FoodyHomePage().searchWithOnlyLocation(location)
															.chooseLocation(location);
		boolean isNameCorrect = foodyStorePage.isNameCorrect(location);
		
		Assert.assertTrue(isNameCorrect, "The store name is not correct as expected.");
		
		boolean isAddressCorrect = foodyStorePage.isAddressCorrect(address);
		
		Assert.assertTrue(isAddressCorrect, "The address name is not correct as expected.");
	}
	
	

}
