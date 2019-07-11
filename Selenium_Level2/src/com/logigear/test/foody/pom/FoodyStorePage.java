package com.logigear.test.foody.pom;

import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.Constant;
import com.logigear.testfw.element.Element;

public class FoodyStorePage extends FoodyGeneralPage{
	
	protected Element lblHeaderTitle;
	protected Element lblStreetAddress;
	protected Element lblDistrictAddress;
	protected Element lblCityAddress;
	
	public FoodyStorePage() {
		super(FoodyStorePage.class);
	}
	
	@Override
	public void initPageElements() {
		super.initPageElements();
		this.lblHeaderTitle = new Element(getLocator("lblHeaderTitle").getBy());
		this.lblStreetAddress = new Element(getLocator("lblStreetAddress").getBy());
		this.lblDistrictAddress = new Element(getLocator("lblDistrictAddress").getBy());
		this.lblCityAddress = new Element(getLocator("lblCityAddress").getBy());
	}
	
	public FoodyStorePage waitForLoading(int timeOutInSeconds) {
		lblHeaderTitle.waitForDisplay(timeOutInSeconds);
		logger.printMessage("Page is loaded successfully");
		return this;
	}

	public FoodyStorePage waitForLoading() {
		waitForLoading(Common.ELEMENT_TIMEOUT);
		return this;
	}
	
	public boolean isNameCorrect(String name) {
		boolean isCorrect = false;
		String actualName = lblHeaderTitle.getText();
		if(actualName.equalsIgnoreCase(name))
			isCorrect = true;
		logger.printMessage("Is store name correct: " + isCorrect);
		return isCorrect;
	}
	
	public boolean isRandomNameCorrect() {
		return isNameCorrect(Constant.storeName);
	}
	
	public String[] splitAddress(String address) {
		String[] add = new String[3];
		int streetEnd = address.indexOf(",", address.indexOf("."));
		add[0] = address.substring(0, streetEnd);
		int districtEnd = address.indexOf(",", streetEnd + 1);
		add[1] = address.substring(streetEnd + 1, districtEnd).trim();
		add[2] = address.substring(districtEnd + 1).trim();
		return add;
	}
	
	public boolean isAddressCorrect(String address) {
		String[] add = splitAddress(address);
		return verifyAddress(add[0], add[1], add[2]);
	}
	
	public boolean verifyAddress(String address, String district, String city) {
		boolean isCorrect = false;
		boolean isStreetCorrect, isDistrictCorrect = false, isCityCorrect = false;
		if(lblStreetAddress.getText().equals(address))
			isStreetCorrect = true;
		else {
			isStreetCorrect = false;
			logger.printMessage("The Street address is false.");
		}
		
		if(district != "") {
			if(lblDistrictAddress.getText().equals(district))
				isDistrictCorrect = true;
			else {
				isDistrictCorrect = false;
				logger.printMessage("The District address is false.");
			}
		}
		if (district == "") {
			isDistrictCorrect = true;
		}
		
		if(city != "") {
			if(lblCityAddress.getText().equals(city))
				isCityCorrect = true;
			else {
				isCityCorrect = false;
				logger.printMessage("The City address is false, the right value is: " + city + ", but found: " + lblCityAddress.getText());
			}
		}
		if(city == "") {
			isCityCorrect = true;
		}
			
		if(isStreetCorrect && isDistrictCorrect && isCityCorrect) 
			isCorrect = true;
		
		logger.printMessage("Is address correct: " + isCorrect);
		return isCorrect;
	}
	
	public boolean isRandomAddressCorrect() {
		return verifyAddress(Constant.storeAddress, Constant.storeDistrict, Constant.storeCity);
	}

}
