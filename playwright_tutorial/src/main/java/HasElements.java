import com.microsoft.playwright.*;

public class HasElements {
    public static void main(String[] args) {
        Playwright playwright =Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://www.orangehrm.com/en/book-a-free-demo");

        Locator loc = page.locator("select#Form_getForm_Country:has(option[value='India'])");

        loc.allInnerTexts().forEach(e->System.out.println(e));

    }
}
