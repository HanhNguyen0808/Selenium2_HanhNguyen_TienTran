package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class GeneralPage extends BasePOM {

	protected com.logigear.testfw.utilities.Logger logger = new com.logigear.testfw.utilities.Logger();

	// Element
	protected Element lnkMyProfile;
	protected Element tabExecutionDashboard;
	protected Element lnkGlobalSetting;
	protected Element lnkAddPage;
	protected Element lnkChoosePanels;
	protected Element btnCreateNewPanel;
	protected Element lnkCreatePanel;
	protected Element itemAdminister;
	protected Element lnkPanel;

	public GeneralPage(Class<?> derivedClass) {
		super(derivedClass);
	}

	@Override
	public void initPageElements() {
		this.lnkMyProfile = new Element(getLocator("lnkMyProfile").getBy());
		this.tabExecutionDashboard = new Element(getLocator("tabExecutionDashboard").getBy());
		this.lnkGlobalSetting = new Element(getLocator("lnkGlobalSetting").getBy());
		this.lnkAddPage = new Element(getLocator("lnkAddPage").getBy());
		this.lnkChoosePanels = new Element(getLocator("lnkChoosePanels").getBy());
		this.btnCreateNewPanel = new Element(getLocator("btnCreateNewPanel").getBy());
		this.lnkCreatePanel = new Element(getLocator("lnkCreatePanel").getBy());
		this.itemAdminister = new Element(getLocator("itemAdminister").getBy());
		this.lnkPanel = new Element(getLocator("lnkPanel").getBy());
	}

	/**
	 * Open Add New Page dialog or Edit Page dialog.
	 *
	 * @author hanh.nguyen
	 */
	public PageDialog openPageDialog() {
		logger.printMessage("Open \"New Page\" or \"Edit Page\" dialog.");
		lnkGlobalSetting.click();
		lnkAddPage.click();
		return new PageDialog();
	}

	/**
	 * Open Add New Panel dialog.
	 *
	 * @author hanh.nguyen
	 * @param isFromChoosePanels open the dialog from "Choose Panels" linked button
	 *                           or from "Global Setting" linked button
	 */
	public PanelDialog openPanelDialog(boolean isFromChoosePanels) {
		logger.printMessage("Open \"Add New Panel\" dialog.");
		if (isFromChoosePanels) {
			lnkChoosePanels.click();
			btnCreateNewPanel.click();
		} else if (!isFromChoosePanels) {
			lnkGlobalSetting.click();
			lnkCreatePanel.click();
		}
		return new PanelDialog();

	}

	/**
	 * @author nhan.tran
	 * @Description: Select menu item without <option>tab by hold/click
	 * @param selectedElement Element that should be select.
	 */

	public void selectMenuItem(int timeOutInSeconds, Element menuElement, Element selectedElement) {
		if (timeOutInSeconds <= 0) {
			timeOutInSeconds = Common.ELEMENT_TIMEOUT;
		}
		try {
			menuElement.moveToElement();
			selectedElement.click();
		} catch (Exception error) {
			LOG.severe(String.format("Has error when select item in %d", timeOutInSeconds));
		}
	}
}
