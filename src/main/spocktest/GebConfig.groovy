package spocktest

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

waiting {
    timeout = 10
    retryInterval = 0.1
    presets {
        slow {
            timeout = 120
            retryInterval = 1
        }
    }
}

atCheckWaiting = true
baseNavigatorWaiting = true
reportsDir = "target/geb-reports"
baseUrl = "https://www.saucedemo.com/"

test {
    testLogging.showStandardStreams = true
}

driver = { new ChromeDriver() }

environments {
    driver = {
        WebDriver chromeDriver = new ChromeDriver()
        chromeDriver.manage().window().maximize()
    }
}