import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class WorkingWithMultipleTab {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/windows");

        Page popup = page.waitForPopup(()-> {
            page.click("a[href='/windows/new']");
        }
        );
        popup.waitForLoadState();
        System.out.println(page.textContent("h3"));
        System.out.println(popup.url());
        System.out.println(popup.title());
        popup.close();

        System.out.println("Control goes back to parent window "+page.title());



        context.close();
        page.close();
        browser.close();
        playwright.close();
    }
}
