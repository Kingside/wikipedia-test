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

import org.openqa.selenium.WebElement;

import com.company.components.api.LanguageMenu;
import com.sabre.qa.gary.web.Component;

public class LanguageMenuImpl extends Component implements LanguageMenu {
    
    // Note: @FindBy annotation doesn't work for Components

    public LanguageMenuImpl(WebElement parent) {

        // simple component, don't need WebBrowser here

        super(parent);
    }

    @Override
    public void collapse() {
        if (!isCollapsed()) {
            toggle();
        }
    }

    @Override
    public void expand() {
        if (isCollapsed()) {
            toggle();
        }
    }

    @Override
    public boolean isCollapsed() {
        return parent.getAttribute("class").contains("collapsed");
    }

    @Override
    public List<String> getLanguages() {

        expand(); // Selenium won't see invisible elements

        List<String> languages = new ArrayList<String>();
        for (WebElement item : getLanguageItems()) {
            languages.add(item.getText());
        }

        return languages;
    }

    private void toggle() {
        $("#p-lang-label a").click();
    }
    
    private List<WebElement> getLanguageItems() {
        
        // jQuery syntax for obtaining a list of web elements:
        
        return $("#p-lang-list li.interlanguage-link a").elements();
    }
}
