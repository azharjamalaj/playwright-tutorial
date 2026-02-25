import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

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
        page.navigate("https://www.orangehrm.com/en/book-a-free-demo");
        assertThat(page).hasTitle(Pattern.compile("OrangeHRM"));

        // Using Comma Separator
        Locator loc = page.locator("a:has-text('Solutions'), a:has-text('Why OrangeHRM'), a:has-text('Resources'), a:has-text('Pricing')");

        loc.waitFor();

        // Validate any of the href is visible on the page
        assertThat(loc).isVisible();

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
