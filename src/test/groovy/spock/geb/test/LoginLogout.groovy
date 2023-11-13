package spock.geb.test

import groovy.util.logging.Log4j
import spocktest.geb.common.SetupSpec

/**
 * This is the spec file
 *
 * @author: Renalyn Arguelles
 */
@Log4j
class LoginLogout extends SetupSpec {

    def "Login"() {
        given: "go to website"
        to loginPage
        loginPage.usernameField.value user
        loginPage.passwordField.value pass
        log.info("")

        when: "click login"
        loginPage.loginButton.click()
        log.info("")

        then: "home page is accessed"
        page homePage
        homePage.waitForElementToBeDisplayed(homePage.inventoryItemList)
        boolean result = homePage.inventoryItemList.isDisplayed()
        assert result == true: "Home page is not accessed"

        log.info("")
    }
}
