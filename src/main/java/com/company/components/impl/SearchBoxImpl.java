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

package com.company.components.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.company.components.api.SearchBox;
import com.company.pages.api.ArticlePage;
import com.company.pages.impl.ArticlePageImpl;
import com.sabre.qa.gary.web.Component;
import com.sabre.qa.gary.web.browser.WebBrowser;

public class SearchBoxImpl extends Component implements SearchBox {

    // Note: @FindBy annotation doesn't work for Components

    public SearchBoxImpl(WebBrowser browser, WebElement parent) {

        // page navigation and explicit wait require WebBrowser instance

        super(browser, parent);
    }

    @Override
    public ArticlePage search(String phrase) {

        type(phrase);

        $("#searchButton").click();

        return new ArticlePageImpl(browser);
    }

    @Override
    public List<String> getSuggestionsFor(String phrase) {

        type(phrase);

        waitForSuggestions();

        return getSuggestions();
    }

    private void type(String phrase) {
        type($("#searchInput"), phrase);
    }

    private void waitForSuggestions() {
        browser.wait.until(suggestionBoxShown());
    }

    private ExpectedCondition<Boolean> suggestionBoxShown() {
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                By by = By.cssSelector("div.suggestions");
                return driver.findElement(by).isDisplayed();
            }
        };
    }

    private List<String> getSuggestions() {

        List<String> suggestions = new ArrayList<String>();
        for (WebElement item : getSuggestionItems()) {
            suggestions.add(item.getAttribute("title"));
        }

        return suggestions;
    }

    private List<WebElement> getSuggestionItems() {

        // Must use Selenium's findElements() because framework's wrappers
        // (like jQuery syntax) are relative to this component's parent node,
        // while suggestions reside at the end of the whole document.

        By by = By.cssSelector("div.suggestions-result");
        return browser.findElements(by);
    }
}
