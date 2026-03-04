import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class AutomaticLoginUsingBroContext {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();

        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Locator username= page.locator("input[name='username']");
        username.fill("Admin");

        Locator password= page.locator("input[name='password']");
        password.fill("admin123");

        Locator sumbitButton = page.locator("button[type='submit']");
        sumbitButton.click();

        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("OrangeHRMLogin.json")));
    }
}
