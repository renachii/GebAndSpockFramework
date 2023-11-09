package spocktest.geb.module

import geb.Module

/**
 * Module class for the header elements
 *
 * @author: Renalyn Arguelles
 */
class HeaderModule extends Module {
    static content = {
        title { $("div.login_logo") }

        burgerButton (required: true) { $("#react-burger-menu-btn") }
        logoutButton (required: true) { $("#logout_sidebar_link") }
        allItemsButton { $("#inventory_sidebar_link") }
        aboutButton { $("#about_sidebar_link") }
        resetAppState { $("#reset_sidebar_link") }

        shoppingCartLink { $("a.shopping_cart_link") }
        cartBadge { $("span.shopping_cart_badge") }
    }
}
