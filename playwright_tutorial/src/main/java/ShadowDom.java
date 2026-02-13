import com.microsoft.playwright.*;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class ShadowDom {

    public static void main(String[] args) {
        try {
            Playwright playwright = Playwright.create();

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://books-pwakit.appspot.com/");

            // Shadow Dom
            page.locator("book-input-decorator #input").fill("Harry Porter ");

            page.keyboard().press("Enter");

            page.locator("div.title-container .title").nth(2).click();

//            List<String> bookList = listOfbook.allTextContents();
//
//            for(String ele : bookList)
//                System.out.println(ele);




        }catch (Exception e)
        {

        }
    }
}
