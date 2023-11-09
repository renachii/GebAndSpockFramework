package spock.geb.test

import groovy.util.logging.Log4j
import spocktest.geb.common.SetupSpec

/**
 * This is the spec file
 *
 * @author: Renalyn Arguelles
 */
@Log4j
class AddToCart extends SetupSpec {

    def "Add to cart"() {
        given: "go to website"

        to loginPage
        loginPage.login(user, pass)
        log.info("")

        when: "add to cart"
        page homePage
        homePage.addToCart(5)
        log.info("")

        then: ""
        int number = homePage.getItemsInCart()
        assert number == 1: "numbers in cart is incorrect"
        assert genericTask.generateRandomString(10).length() == 10
        log.info("")
    }
}
