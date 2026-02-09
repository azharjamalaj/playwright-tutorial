import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HandlingFramesAndIframes {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

        // By using frame locator
        page.frameLocator("frame[name='navbar']").locator("text=No frames").click();

        //  Verify the text matches the actual
        assertThat(page).hasTitle("Example home page");

        //  Navigate back to home page
        page.goBack();

        // By using frame name
        String contentText =page.frame("content").locator("head title").textContent();
        System.out.println(contentText);







    }

}
