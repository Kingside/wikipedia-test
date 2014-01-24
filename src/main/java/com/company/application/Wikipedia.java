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

package com.company.application;

import com.company.pages.impl.MainPageImpl;
import com.sabre.qa.gary.web.WebApplication;
import com.sabre.qa.gary.web.WebPage;
import com.sabre.qa.gary.web.browser.WebBrowser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wikipedia extends WebApplication {

    private static final String URL = "http://en.wikipedia.org";

    final Logger logger = LoggerFactory.getLogger(Wikipedia.class);

    public Wikipedia(WebBrowser browser) {
        super(browser);
    }

    @Override
    public WebPage getHomePage() {

        logger.info("Navigating to {}", URL);

        browser.navigate().to(URL);

        return new MainPageImpl(browser);
    }
}
