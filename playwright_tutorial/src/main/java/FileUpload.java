import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/upload");

        page.setInputFiles("#file-upload", Paths.get("OrangeHRMLogin.json"));
        System.out.println("File is attached");
        page.setInputFiles("#file-upload", new Path[0]);
        System.out.println("File is deattached");

        page.close();
        browser.close();
        playwright.close();
    }
}
