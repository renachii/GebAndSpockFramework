package spocktest.geb.module

import geb.Module
import geb.waiting.WaitTimeoutException
import groovy.util.logging.Log4j

/**
 * Base Module class
 *
 * @author: Renalyn Arguelles
 */
@Log4j
class GebModule extends Module {

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
     * Scroll to element and click
     *
     * @param element
     */
    void scrollAndClick(element) {
        try {
            interact {
                moveToElement(element)
                element.click()
            }
        }
        catch (Exception ignored){}
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
}
