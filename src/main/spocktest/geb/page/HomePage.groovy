package spocktest.geb.page

import spocktest.geb.module.FooterModule
import spocktest.geb.module.HeaderModule

class HomePage extends GebPage {

	static at = {
        title == 'Swag Labs'
    }
	
    static content = {
        inventoryItemList { $("div.inventory_list") }
        invetoryItems { $("div.inventory_item)")}
        invetoryItem { num -> $("div.inventory_item:nth-of-type(${num})") }
        inventoryItemImg { num -> $("div.inventory_item_img:nth-of-type(${num})") }
        inventoryItemNames  { $("div.inventory_item_name") }
        inventoryItemName { name -> $("div.inventory_item_name", text: "${name}") }
        inventoryItemPrice { num -> $("div.inventory_item_price:nth-of-type(${num})") }
        addToCartButton { num -> $("div.inventory_item:nth-of-type(${num}) button.btn_inventory") }

        navigation (wait: true) { module HeaderModule }
        tabs (wait: true) { module FooterModule }
		//exampleModule(wait: 'slow') { $("<selector>").module(exampleModule) }

    }

    /**
     * logout
     */
    void logout() {
        if (isElementDisplayed(navigation.burgerButton)) {
            navigation.burgerButton.click()
            waitForElementToBeDisplayed(navigation.logoutButton)
            navigation.logoutButton.click()
        }
    }

    /**
     * wait for home
     */
    void waitForHome() {
        waitForElementToBeDisplayed(inventoryItemList)
    }

    /**
     * Get items in cart
     * @return number
     */
    int getItemsInCart() {
        scrollToElement(navigation.cartBadge)
        return Integer.parseInt(navigation.cartBadge.text())
    }


    /**
     * Add to cart
     * @param itemNo
     */
    void addToCart(int itemNo) {
        scrollToElement(invetoryItem(itemNo))
        addToCartButton(itemNo).click()
    }
}

