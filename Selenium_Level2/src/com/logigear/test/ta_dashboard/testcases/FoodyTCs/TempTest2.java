package com.logigear.test.ta_dashboard.testcases.FoodyTCs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.Foody.SearchValue;
import com.logigear.test.ta_dashboard.pom.Foody.FoodyHomePage;
import com.logigear.testfw.common.BaseTest;

public class TempTest2 extends BaseTest{
	
	@Test
	public void TC_TempTest2() {
		
		String[] store = {"Quán Ăn Năm Gia - Miến Gà", "Miến Gà Kỳ Đồng"};
		
		SearchValue searchValue = new SearchValue("TP. HCM", "Ăn uống->Quán ăn", "Miến Gà");
		
		boolean areStoreDisplay = new FoodyHomePage().searchFoodStore(searchValue)
															.isStoreDisplayInResultPage(store);
		
		Assert.assertTrue(areStoreDisplay, "The stores are not display as expected.");
		
	}
	
	

}
