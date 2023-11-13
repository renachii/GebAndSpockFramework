package spocktest.geb.page

import geb.Page

/**
 * Page class for the Login
 *
 * @author: Renalyn Arguelles
 */
class LoginPage extends GebPage {
    static url = "https://www.saucedemo.com/"

    static at = {
        title == "Swag Labs"
    }

    static content = {
        usernameField (required: true, wait: true) { $("#user-name") }
        passwordField (required: true, wait: true) { $("#password") }
        loginButton (wait: true) { $("#login-button") }
    }
}
