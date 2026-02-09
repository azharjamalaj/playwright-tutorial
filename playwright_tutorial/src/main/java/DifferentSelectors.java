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

//            This class will only focus on the differnt type of selector in Playwright

//            1. Using Text locator
            Locator textLocator = page.locator("text=Udemy Courses");

            assertThat(textLocator).hasText("Udemy Courses");
            textLocator.click();

            page.goBack();

//            getByRole


            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                            .setName("Submit"))
                    .click().;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
