package com.logigear.test.foody.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.foody.pom.FoodyHomePage;
import com.logigear.test.foody.pom.FoodySearchResultPage;
import com.logigear.test.foody.pom.FoodyStorePage;
import com.logigear.testfw.common.BaseTest;

public class FinalTest1 extends BaseTest{
	
	@Test
	public void TC_FinalTest1() {
		
		String[] title = {"Giao tận nơi", "Đặt bàn ưu đãi"};
		String searchValue = "Cơm Tấm";
		String leftMenu = "Địa điểm";
		String topToolbar = "Đánh giá tốt nhất";
		
		FoodyHomePage foodyHomePage = new FoodyHomePage();
		
		boolean areTitleDisplay = foodyHomePage.areHomePageTableTitleDisplay(title);
		
		Assert.assertTrue(areTitleDisplay, "The table titles are not diplayed correctly as expected.");
		
		boolean isLeftMenuItemSelected = foodyHomePage.searchWithOnlyLocation(searchValue)
														.isLeftMenuItemSelected(leftMenu);
		
		Assert.assertTrue(isLeftMenuItemSelected, "The left menu item is not selected as expected.");
		
		FoodySearchResultPage foodySearchResultPage = new FoodySearchResultPage();
		boolean isStoreNameCorrect = foodySearchResultPage.clickTopToolbar(topToolbar)
															.chooseRandomLocation()
															.isRandomNameCorrect();
		
		Assert.assertTrue(isStoreNameCorrect, "The store name is not correct as expected.");
		
		boolean isStoreAddressCorrect = new FoodyStorePage().isRandomAddressCorrect();
		
		Assert.assertTrue(isStoreAddressCorrect, "The store address is not correct as expected.");
		
	}
	
	

}
