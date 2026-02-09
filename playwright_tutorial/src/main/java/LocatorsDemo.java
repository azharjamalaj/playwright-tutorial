import com.microsoft.playwright.*;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LocatorsDemo {
    public static void main(String[] args)
    {
        try {

            Playwright playwright = Playwright.create();


            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
            );

            Page page = browser.newPage();
            page.navigate("https://testautomationpractice.blogspot.com/");

            System.out.println(page.title());

            Locator elem1 = page.locator("select#country option");

            System.out.println(elem1.count());
//            Using for loop
            for(int i=0 ; i< elem1.count();i++)
            {
                System.out.println(elem1.nth(i).textContent());
            }

//            Using for each
            List<String> countryList = elem1.allTextContents();
            for(String ele : countryList)
                System.out.println(ele);

//            Using Lamda expression
            countryList.forEach(ele -> System.out.println(ele));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
