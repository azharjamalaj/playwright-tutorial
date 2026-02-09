import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DifferentSelectors {
    public static void main(String[] args) {
        try {
            Playwright playwright = Playwright.create();

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://testautomationpractice.blogspot.com/");

            // This class will only focus on the different type of selector in Playwright

            //  1. Using Text locator
            Locator textLocator = page.locator("text=Udemy Courses");

            //  Verify the text matches the actual
            assertThat(textLocator).hasText("Udemy Courses");

            // Click on the Udemy Course link
            textLocator.click();

            // navigate back to the home page
            page.goBack();

            //  Use of has-text
            // Click on the Playwright Practice link
            page.locator("a:has-text('PlaywrightPractice')").click();

            //Verify the title of the page
            assertThat(page).hasTitle("Automation Testing Practice: PlaywrightPractice");

            // navigate back to the home page
            page.goBack();

            //Using CSS selector
            page.locator("div.form-group input#name").fill("Azhar");

            //Using CSS selector to clear field
            page.locator("div.form-group input#name").clear();

            //Using Xpath with attribute
            page.locator("//div//input[@id='email']").fill("azhar@gmail.com");

            //Using Xpath Contains and siblings
            page.locator("//label[contains(text(), 'Phone')]/following-sibling::input").fill("9090909090");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
