import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.List;

public class LocatorUsingCLI {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page= browser.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Locator username= page.locator("input[name='username']");
        username.fill("Admin");

        Locator password= page.locator("input[name='password']");
        password.fill("admin123");

        Locator sumbitButton = page.locator("button[type='submit']");
        sumbitButton.click();

        Locator listOfMainMenu = page.locator("a.oxd-main-menu-item");

        int count = listOfMainMenu.count();

        for (int i = 0; i < count; i++) {
            String text = listOfMainMenu.nth(i).innerText();
            System.out.println(text);
        }

//                waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.valueOf("Admin")));
        List<String> traverseListOfMainMenu = listOfMainMenu.allInnerTexts();

        System.out.println(traverseListOfMainMenu);

        for (int i=0; i<traverseListOfMainMenu.size()-1;i++)
            System.out.println(traverseListOfMainMenu.get(i));

    }


}
