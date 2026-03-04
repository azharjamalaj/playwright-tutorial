import com.microsoft.playwright.*;

public class BrowserContextExample {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext contextA = browser.newContext();

        Page pageA = contextA.newPage();
        pageA.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Locator username= pageA.locator("input[name='username']");
        username.fill("Admin");

        Locator password= pageA.locator("input[name='password']");
        password.fill("admin123");

        Locator sumbitButton = pageA.locator("button[type='submit']");
        sumbitButton.click();

        BrowserContext contextB = browser.newContext();
        Page pageB =contextB.newPage();
        pageB.navigate("https://www.saucedemo.com/");
        pageB.locator("input[placeholder='Username']").fill("standard_user");
        pageB.locator("input[placeholder='Password']").fill("secret_sauce");
        pageB.locator("input[type='submit']").click();



    }
}
