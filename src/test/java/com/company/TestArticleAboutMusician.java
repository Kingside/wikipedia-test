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

import com.company.testcase.ArticlePageTestCase;
import com.sabre.qa.gary.annotation.RandomStringItem;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class TestArticleAboutMusician extends ArticlePageTestCase {

    @RandomStringItem({"Brian Culbertson",
                       "Gary Moore",
                       "London Elektricity"})
    private String musician;

    @Test
    public void shouldDisplayCorrectTitle() {

        // given
        assumeThat(articlePage, notNullValue()); // skip test if false

        // when
        String title = articlePage.getTitle();

        // then
        assertThat(title, equalTo(musician));
    }
    
    @Override
    protected String getSearchPhrase() {
        return musician;
    }
}
