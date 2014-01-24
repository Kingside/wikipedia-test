/**
 * Copyright 2014 Bartosz Zaczynski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.company.pages.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.company.components.api.LanguageMenu;
import com.company.components.api.SearchBox;
import com.company.components.impl.LanguageMenuImpl;
import com.company.components.impl.SearchBoxImpl;
import com.company.pages.api.WikiPage;
import com.sabre.qa.gary.testng.NotYetImplemented;
import com.sabre.qa.gary.web.WebPage;
import com.sabre.qa.gary.web.browser.WebBrowser;

public abstract class WikiPageImpl extends WebPage implements WikiPage {

    // Demonstrates ways of locating web elements:
    // 1. @FindBy annotation (PageObject)
    // 2. jQuery's dollar function $()
    // 3. Helper method getElementBy*()

    @FindBy(css = "#footer-places-privacy a")
    private WebElement privacyPolicyLink;

    public WikiPageImpl(WebBrowser browser) {
        super(browser);
    }

    @Override
    public WikiPage clickPrivacyPolicy() {

        privacyPolicyLink.click(); // ad. 1)

        throw new NotYetImplemented();
    }

    @Override
    public WikiPage clickAbout() {

        $("#footer-places-about a").click(); // ad. 2)

        throw new NotYetImplemented();
    }

    @Override
    public WikiPage clickDisclaimers() {

        getElementByCss("#footer-places-disclaimer a").click(); // ad. 3)

        throw new NotYetImplemented();
    }

    @Override
    public SearchBox getSearchBox() {
        return new SearchBoxImpl(browser, $("#simpleSearch"));
    }

    @Override
    public LanguageMenu getLanguageMenu() {
        return new LanguageMenuImpl($("#p-lang"));
    }
}
