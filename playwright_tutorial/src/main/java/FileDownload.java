import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownload {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/download");

        Download download = page.waitForDownload(()->{page.locator("a:text('tmpvnq5ytwm.png')").click();});

        System.out.println(download.url());
        System.out.println(download.path());

        download.saveAs(Paths.get("download.json"));

        page.close();
        browser.close();
        playwright.close();
    }
}
