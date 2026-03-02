import com.microsoft.playwright.*;

import java.util.List;

public class NthSelectors {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.amazon.in/");

        Locator locator= page.locator(".navAccessibility ul li");

        List<String> list= locator.allInnerTexts();
        list.forEach(footer-> System.out.println(footer));

        for (int i=0;i<list.size();i++)
        {
            String str=page.locator(".navAccessibility ul li a >> nth="+i+"").textContent();
            System.out.println(str);
        }
    }
}
