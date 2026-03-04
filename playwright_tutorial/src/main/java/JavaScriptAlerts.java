import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JavaScriptAlerts {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.onDialog( dialog -> {
            System.out.println(dialog.message());
            dialog.accept("In Alert prompt text");
        });
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.locator("//button[text()='Click for JS Alert']").click();
        Thread.sleep(3000);
        page.locator("//button[text()='Click for JS Confirm']").click();
        Thread.sleep(3000);
        page.locator("//button[text()='Click for JS Prompt']").click();
        Thread.sleep(3000);
        System.out.println(page.locator("#result").textContent());
        page.close();
        browser.close();
        playwright.close();
    }
}
