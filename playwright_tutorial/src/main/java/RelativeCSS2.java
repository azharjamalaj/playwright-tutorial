import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RelativeCSS2 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.LOAD));
        assertThat(page).hasTitle(Pattern.compile("OrangeHRM"));

        // Use Of Relative CSS selector
        page.locator("input[name='username']:below(label:text('Username'))").fill("Admin");
        page.locator("input[name='password']:below(label:text('Password'))").fill("admin123");
        page.locator("button[type='submit']").click();
    }
}
