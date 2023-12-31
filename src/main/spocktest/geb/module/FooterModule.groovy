package spocktest.geb.module

/**
 * Module class for the header elements
 *
 * @author: Renalyn Arguelles
 */
class FooterModule extends GebModule {
    static content = {
        facebookLink { $("li.social_facebook") }
        linkedInLink { $("li.social_linkedin") }
        twitterLink { $("li.social_twitter") }
        footer { $(".footer_copy") }
    }
}
