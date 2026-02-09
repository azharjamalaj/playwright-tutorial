import com.microsoft.playwright.*;
import com.microsoft.playwright.Playwright;

public class ShadowDom {

    public static void main(String[] args) {
        try {
            Playwright playwright = Playwright.create();

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://books-pwakit.appspot.com/");

            page.locator("book-input-decorator #input").fill("Harry Porter ");





        }catch (Exception e)
        {

        }
    }
}
