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

package com.company;

import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.util.List;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.company.testcase.MainPageTestCase;
import com.sabre.qa.gary.testng.SkipTest;
import com.sabre.qa.gary.web.browser.JavascriptNotSupported;
import com.sabre.qa.gary.web.browser.storage.LocalStorage;

public class TestWithJavaScript extends MainPageTestCase {

    @Test
    public void shouldShowAlertMessage() {
        try {

            // given
            String message = "Hello world";

            // when
            String code = format("alert('%s');", message);
            browser.executeJavascript(code);

            // then
            Alert alert = browser.switchTo().alert();
            assertThat(alert.getText(), equalTo(message));
            alert.dismiss();

        } catch (JavascriptNotSupported ex) {            
            throw new SkipTest("JavaScript not supported");
        }
    }

    @Test
    public void shouldReadLocalStorage() {

        // given
        LocalStorage localStorage = new LocalStorage(browser);

        try {
            if (localStorage.isSupported()) {

                // when
                List<String> keys = localStorage.keys();

                // then
                assertThat(keys, hasItem("CentralAuthAnon"));
                assertThat(keys, hasItem("moduleStorageExperiment2"));
            }
        } catch (JavascriptNotSupported ex) {
            throw new SkipTest("JavaScript not supported");
        }
    }
}
