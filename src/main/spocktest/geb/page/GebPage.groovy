package spocktest.geb.page

import geb.Page
import geb.waiting.WaitTimeoutException
import groovy.util.logging.Log4j
import org.openqa.selenium.*;

/**
 * Base Page class
 *
 * @author: Renalyn Arguelles
 */
@Log4j
abstract class GebPage extends Page {
    WebDriver driver = getDriver()

    /**
     * WaitFor the element to be displayed
     *
     * @param element the element to check
     * @param timeout (optional)
     */
    void waitForElementToBeDisplayed(element, int timeout = 5) {
        try {
            waitFor(timeout) { element.isDisplayed() }
        }
        catch (WaitTimeoutException ignored) {}
    }

    /**
     * WaitFor the element to be displayed
     *
     * @param element the element to check
     * @return true if element is displayed otherwise false
     */
    boolean isElementDisplayed(element) {
        boolean isDisplayed = false
        try {
            waitFor { element.isDisplayed() }
            isDisplayed = true
        }
        catch (WaitTimeoutException ignored) {}
        return isDisplayed
    }

    /**
     * WaitFor the element not to be displayed
     *
     * @param element the element to check
     * @param timeout (optional)
     */
    void waitForElementNotToBeDisplayed(element, int timeout = 5) {
        try {
            waitFor(timeout) { !element.isDisplayed() }
        }
        catch (WaitTimeoutException ignored) {}
    }

    /**
     * Scroll to element
     *
     * @param element
     */
    void scrollToElement(element) {
        try {
            interact {
                moveToElement(element)
            }
        }
        catch (Exception ignored){}
    }

    /**
     * Force click using javascript
     *
     * @param element
     */
    void forceClick(element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element)
        }
        catch (ignored) {}
    }
}