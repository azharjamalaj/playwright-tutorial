import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CommaSepratedExample {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.orangehrm.com/en/book-a-free-demo",  new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.LOAD));
        assertThat(page).hasTitle(Pattern.compile("OrangeHRM"));

        // Using Comma Separator
//        Locator loc = page.locator("a:has-text('Contact Us'), a:has-text('Press Releases')");
//        loc.scrollIntoViewIfNeeded();
//        loc.first().waitFor();
//
//        loc.first().click();

        // Using OR operator
        Locator solutions = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Solutions").setExact(true));
        Locator whyOrangeHRM = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Why OrangeHRM").setExact(true));
        Locator company = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Company").setExact(true));
        Locator resources = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Resources").setExact(true));


        Locator combined = solutions
                .or(whyOrangeHRM)
                .or(company)
                .or(resources);

        combined.first().waitFor();
        solutions.waitFor();
        solutions.click();
        whyOrangeHRM.click();
    }
}