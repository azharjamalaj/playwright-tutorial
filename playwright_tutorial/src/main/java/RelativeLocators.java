import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

import java.util.List;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RelativeLocators {
    static Page page;
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        page =browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/", new Page.NavigateOptions()
                .setWaitUntil(WaitUntilState.LOAD));
        assertThat(page).hasTitle(Pattern.compile("Xpath Practice Page"));

        // use of left-0f
        clickCheckBox("Joe.Root");

        // use of right-of
       System.out.println(navigationHeader("Joe.Root"));

        // use of above
        System.out.println(useOfAbove("Joe.Root"));

        // use of below
        System.out.println(useOfBelow("Joe.Root"));

        // use of below
        System.out.println(useOfNear("Joe.Root"));
    }

    //    Use of left-of
    public static void clickCheckBox(String userName)
    {
        page.locator("input[type='checkbox']:left-of(:text('"+userName+"'))").first().click();
    }
    //    Use of right-of
    public static String navigationHeader(String cellName)
    {
        return page.locator("td:right-of(:text('"+cellName+"'))").nth(0).innerText();
    }

    //  Use of above
    public static String useOfAbove(String cellName)
    {
        return page.locator("td:above(:text('"+cellName+"'))").nth(0).innerText();
    }


    //  Use of near
    public static String useOfBelow(String cellName)
    {
        return page.locator("td:below(:text('"+cellName+"'))").nth(0).innerText();
    }

    //  Use of near
    public static List<String> useOfNear(String cellName)
    {
        return (List<String>) page.locator("td:near(:text('"+cellName+"'),400)").allInnerTexts();
    }

}
