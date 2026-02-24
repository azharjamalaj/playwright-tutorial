import com.microsoft.playwright.*;

import java.util.List;

public class VisibleElement {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

//        page.navigate("https://books-pwakit.appspot.com/");
//
//        page.locator("book-input-decorator #input").fill("Harry Porter ");
//
//        page.keyboard().press("Enter");

//        int count = page.locator("xpath = //img >> visible = true").count();
//        System.out.println(count);

        page.navigate("https://books-pwakit.appspot.com/");

        System.out.println("Navigate to books");
//        List<String> listOFAmazonlink
             int count = page.locator("xpath=//a >> visible = true").count();
        System.out.println(count);
//        System.out.println(listOFAmazonlink);
//        for(int i=0; i<listOFAmazonlink.size();i++)
//            System.out.println(listOFAmazonlink.get(i));

    }
}
