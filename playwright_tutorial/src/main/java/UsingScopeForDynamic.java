import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

public class UsingScopeForDynamic {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/",  new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.LOAD));

        String str = page.locator("table[id='resultTable'] tr").locator(":scope", new Locator.LocatorOptions().setHasText("Kevin.Mathews")).locator(".left").textContent();
//        row.scrollIntoViewIfNeeded();
//        row.focus();
//        String str = row.locator(":scope" , new Locator.LocatorOptions().setHasText("Kevin.Mathews")).locator(".left").textContent();
        System.out.println(str);
    }
}
