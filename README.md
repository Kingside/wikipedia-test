# wikipedia-test

Sample project demonstrating the basic use of *Gary Framework* in test automation.

The project was used as a training material for [TripCase](http://travel.tripcase.com/).

### Major classes discussed:

1. `WebBrowser`
 * Wraps Selenium's `WebDriver` interface.
 * Augments it with convenience methods, e.g. for easy JavaScript execution or waiting for elements.
2. `WebApplication`
 * Provides template method for getting the initial page object.
 * Provides initialized WebBrowser object (e.g. remote or with proxy).
3. `WebPage`
 * Extends the concept of page object.
 * Hides Selenium's boilerplate code.
 * Provides lots of convenience methods, e.g. for looking up web elements with XPath, CSS, etc.
4. `Component`
 * Encapsulates reusable widgets that can appear across many web pages, e.g. date picker.
5. `WebDriverTestCase`
 * Automatically handles web browser instantiation, configuration and termination.
 * Allows for setting arbitrary test preconditions before the browser starts.
 * ...and *much* more under the hood.