import com.microsoft.playwright.*;

public class VisibleElement {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://books-pwakit.appspot.com/");

        page.locator("book-input-decorator #input").fill("Harry Porter ");

        page.keyboard().press("Enter");

        int count = page.locator("xpath = //img >> visible = true").count();
        System.out.println(count);
    }
}
