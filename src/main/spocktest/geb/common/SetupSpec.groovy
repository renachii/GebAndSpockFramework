package spocktest.geb.common

import groovy.util.logging.Log4j
import spock.lang.Shared
import geb.spock.GebSpec
import spocktest.geb.page.HomePage
import spocktest.geb.page.LoginPage
import spocktest.geb.utils.*

/**
 * This is the base class for the spec file
 *
 * @author: Renalyn Arguelles
 */
@Log4j
class SetupSpec extends GebSpec {

    @Shared LoginPage loginPage
    @Shared HomePage homePage

    @Shared JsonReader jsonReader
    @Shared GenericTask genericTask

    @Shared String user
    @Shared String pass

    void setupPageObjects() {
        loginPage = new LoginPage()
        homePage = new HomePage()
        jsonReader = new JsonReader()
        genericTask = new GenericTask()

        user = jsonReader.getCredentials("default", "username")
        pass = jsonReader.getCredentials("default", "password")
    }

    def setupSpec() {
        setupPageObjects()
        log.info("Run before all")
    }

    def setup() {
        log.info("Run before each")
    }

    def cleanup() {
        homePage.navigation.logout()
        log.info("Run after each")
    }

    def cleanupSpec() {
        log.info("Run after all")
    }

    /**
     * login
     *
     * @param user
     * @param pass
     */
    void login(String user, String pass) {
        if (loginPage.isElementDisplayed(loginPage.loginButton)) {
            loginPage.usernameField.value(user)
            loginPage.passwordField.value(pass)
            loginPage.loginButton.click()
        }
    }
}