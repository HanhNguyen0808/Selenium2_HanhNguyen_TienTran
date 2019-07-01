package com.logigear.test.ta_dashboard.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.DataProfile;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.DPGeneralSettingsPage;
import com.logigear.test.ta_dashboard.pom.DPStatisticFieldsPage;

public class DataProfileTest_Tien extends Precondition{

	@Test
	public void DA_DP_TC095() {

		String[] displayFieldList = {""};
		String[] sortFieldList = {""};
		String[] filterFieldList = {""};
		String[] statisticFieldList = {"Name", "Description", "Version", "Priority", "Last update date", "Creation date", 
				"Notes", "Check out machine", "Location", "Recent result", "Assigned user", 
				"Status", "Last updated by", "Created by", "Check out user"};
		DataProfile dataProfile = new DataProfile("Test", "test modules", "None", displayFieldList, sortFieldList, filterFieldList, statisticFieldList);
		
		/*
		 * Log in Dashboard
		 * Navigate to Data Profiles page
		 * Input to "Name *" field
		 * Click "Item Type" dropped down menu and choose Test Modules
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Description, Version, Priority, Last update date, Creation date, Notes, 
		 * Check out machine, Location, Recent result, Assigned user, 
		 * Status, Last updated by, Created by, Check out user
		 */ 
//		HomePage homePage = preconditionLoginValid();
//		DPStatisticFieldsPage statisFieldsPage = (DPStatisticFieldsPage) homePage.gotoGeneralSettingsPageByMenuItem()
//				.submitDataProfilesGeneralSettingsPage(dataProfile)
//				.navigateSettingPage(TableNavigatedPage.STATISTIC_FIELDS);
//		boolean actualResult =  statisFieldsPage.isStatisticItemTypeDisplayCorrect(dataProfile);
//		Assert.assertTrue(actualResult, "The item types don't display as expected");

		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Test Cases
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Title, Notes, Location, Recent result
		 */
		statisticFieldList = new String[]{"Name", "Title","Notes", "Location", "Recent result"};
		dataProfile = new DataProfile("Test", "test case", "None", displayFieldList, sortFieldList, filterFieldList, statisticFieldList);
		
//		actualResult = ((DPStatisticFieldsPage) ((DPGeneralSettingsPage) statisFieldsPage.navigateSettingPage(TableNavigatedPage.GENERAL_SETTINGS))
//				.submitDataProfilesGeneralSettingsPage(dataProfile)
//				.navigateSettingPage(TableNavigatedPage.STATISTIC_FIELDS))
//				.isStatisticItemTypeDisplayCorrect(dataProfile);

		//Assert.assertTrue(actualResult, "The item types don't display as expected");
		
		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Test Objectives
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Title, Notes, Location, Recent result, Source
		 */ 
		statisticFieldList = new String[]{"Name", "Title","Notes", "Location", "Recent result", "Source"};
		dataProfile = new DataProfile("Test", "test objectives", "None", displayFieldList, sortFieldList, filterFieldList, statisticFieldList);
		
//		actualResult = ((DPStatisticFieldsPage) ((DPGeneralSettingsPage) statisFieldsPage.navigateSettingPage(TableNavigatedPage.GENERAL_SETTINGS))
//				.submitDataProfilesGeneralSettingsPage(dataProfile)
//				.navigateSettingPage(TableNavigatedPage.STATISTIC_FIELDS))
//				.isStatisticItemTypeDisplayCorrect(statisticFieldList);
//
//		Assert.assertTrue(actualResult, "The item types don't display as expected");
		
		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Data Sets
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Description, Assigned user, Last update date, Creation date, Notes, 
		 * Check out machine, Location, Version, Status, Last updated by, Created by, Check out user
		 */ 
		statisticFieldList = new String[]{"Name", "Description", "Assigned user", "Last update date","Last updated by", "Creation date", "Notes", "Check out machine"
				,"Location", "Version", "Status", "Last updated by", "Created by", "Check out user"};
		dataProfile = new DataProfile("Test", "data sets", "None", displayFieldList, sortFieldList, filterFieldList, statisticFieldList);

//		actualResult = ((DPStatisticFieldsPage) ((DPGeneralSettingsPage) statisFieldsPage.navigateSettingPage(TableNavigatedPage.GENERAL_SETTINGS))
//				.submitDataProfilesGeneralSettingsPage(dataProfile)
//				.navigateSettingPage(TableNavigatedPage.STATISTIC_FIELDS))
//				.isStatisticItemTypeDisplayCorrect(statisticFieldList);
//
//		Assert.assertTrue(actualResult, "The item types don't display as expected");

		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Actions
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Description, Assigned user, Last update date, Creation date, Notes, 
		 * Check out machine, Location, Version, Status, 
		 * Last updated by, Created by, Verbose description, Check out user
		 */ 
		statisticFieldList = new String[]{"Name", "Description", "Assigned user", "Last update date", "Creation date", "Notes", "Check out machine"
				,"Location", "Version", "Status", "Last updated by", "Created by", "Verbose description", "Check out user"};
		dataProfile = new DataProfile("Test", "actions", "None", displayFieldList, sortFieldList, filterFieldList, statisticFieldList);

//		actualResult = ((DPStatisticFieldsPage) ((DPGeneralSettingsPage) statisFieldsPage.navigateSettingPage(TableNavigatedPage.GENERAL_SETTINGS))
//				.submitDataProfilesGeneralSettingsPage(dataProfile)
//				.navigateSettingPage(TableNavigatedPage.STATISTIC_FIELDS))
//				.isStatisticItemTypeDisplayCorrect(statisticFieldList);
//
//		Assert.assertTrue(actualResult, "The item types don't display as expected");

		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Interface Entities
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Description, Assigned user, Last update date, Creation date, Notes, 
		 * Check out machine, Location, Version, Status, Last updated by, Created by, Check out user
		 */ 
		statisticFieldList = new String[]{"Name", "Desscription", "Assigned user", "Last update date", "Creation date", "Notes", "Check out machine"
				,"Location", "Version", "Status", "Last updated by", "Created by", "Check out user"};
		dataProfile = new DataProfile("Test", "interface entities", "None", displayFieldList, sortFieldList, filterFieldList, statisticFieldList);

//		actualResult = ((DPStatisticFieldsPage) ((DPGeneralSettingsPage) statisFieldsPage.navigateSettingPage(TableNavigatedPage.GENERAL_SETTINGS))
//				.submitDataProfilesGeneralSettingsPage(dataProfile)
//				.navigateSettingPage(TableNavigatedPage.STATISTIC_FIELDS))
//				.isStatisticItemTypeDisplayCorrect(statisticFieldList);
//
//		Assert.assertTrue(actualResult, "The item types don't display as expected");

		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Test Results
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Reported by, Start time, Duration, Variation, Passed, Warnings, Automated/Manual, 
		 * Notes, Location, Date of run, End time, Comment, Result, Failed, Errors, Run Machine
		 */
		statisticFieldList = new String[]{"Name", "Reported by", "Start time", "Duration","Variation", "Passed", "Warnings", "Automated/Manual", "Notes"
				,"Location", "Date of run", "End time", "Comment", "Results", "Failed", "Errors", "Run Machine"};
		dataProfile = new DataProfile("Test", "test results", "None", displayFieldList, sortFieldList, filterFieldList, statisticFieldList);

//		actualResult = ((DPStatisticFieldsPage) ((DPGeneralSettingsPage) statisFieldsPage.navigateSettingPage(TableNavigatedPage.GENERAL_SETTINGS))
//				.submitDataProfilesGeneralSettingsPage(dataProfile)
//				.navigateSettingPage(TableNavigatedPage.STATISTIC_FIELDS))
//				.isStatisticItemTypeDisplayCorrect(statisticFieldList);
//
//		Assert.assertTrue(actualResult, "The item types don't display as expected");

		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Test Case Results
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Date of run, Passed, Warnings, Notes, Location, Result, Failed, Errors
		 */
		statisticFieldList = new String[]{"Name", "Date of run", "Passed", "Warnings", "Notes", "Location", "Result", "Failed", "Errors"};
		dataProfile = new DataProfile("Test", "test case results", "None", displayFieldList, sortFieldList, filterFieldList, statisticFieldList);
		
//		actualResult = ((DPStatisticFieldsPage) ((DPGeneralSettingsPage) statisFieldsPage.navigateSettingPage(TableNavigatedPage.GENERAL_SETTINGS))
//				.submitDataProfilesGeneralSettingsPage(dataProfile)
//				.navigateSettingPage(TableNavigatedPage.STATISTIC_FIELDS))
//				.isStatisticItemTypeDisplayCorrect(statisticFieldList);
//
//		Assert.assertTrue(actualResult, "The item types don't display as expected");
	}
}
