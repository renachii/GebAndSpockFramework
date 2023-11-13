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
        login(user, pass)
        log.info("")

        when: "add to cart"
        page homePage
        homePage.scrollToElement(homePage.invetoryItem(5))
        homePage.addToCartButton(5).click()
        log.info("")

        then: ""
        int number = homePage.navigation.getItemsInCart()
        assert number == 1: "numbers in cart is incorrect"
        assert genericTask.generateRandomString(10).length() == 10
        log.info("")
    }
}
