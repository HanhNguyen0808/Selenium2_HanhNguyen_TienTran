package com.logigear.test.foody.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.foody.data_object.SearchValue;
import com.logigear.test.foody.pom.FoodyHomePage;
import com.logigear.testfw.common.BaseTest;

public class FinalTest2 extends BaseTest{
	
	@Test
	public void TC_FinalTest2() {
		
		SearchValue searchValue = new SearchValue("TP. HCM", "Ăn uống->Quán ăn", "Phở Bò");
		
		boolean areStoreNameContainText = new FoodyHomePage().searchFoodStore(searchValue)
															.areAllDiplayItemsContainText(searchValue.getStore());
		
		Assert.assertTrue(areStoreNameContainText, "Not all items in result grid contain text as expected.");
		
	}
	
}
