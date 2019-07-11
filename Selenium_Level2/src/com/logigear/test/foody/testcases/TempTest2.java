package com.logigear.test.foody.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.foody.data_object.SearchValue;
import com.logigear.test.foody.pom.FoodyHomePage;
import com.logigear.testfw.common.BaseTest;

public class TempTest2 extends BaseTest{
	
	@Test
	public void TC_TempTest2() {
		
		String[] store = {"Quán Ăn Năm Gia - Miến Gà", "Phở Miến Gà Kỳ Đồng"};
		
		SearchValue searchValue = new SearchValue("TP. HCM", "Ăn uống->Quán ăn", "Miến Gà");
		
		boolean areStoreDisplay = new FoodyHomePage().searchFoodStore(searchValue)
															.isStoreDisplayInResultPage(store);
		
		Assert.assertTrue(areStoreDisplay, "The stores are not display as expected.");
		
	}
	
	

}
