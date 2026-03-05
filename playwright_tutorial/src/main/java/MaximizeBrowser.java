import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class MaximizeBrowser {
    public static void main(String[] args) {
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        System.out.println("width" + width+ "and height " + height);
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/download");


        page.close();
        browser.close();
        playwright.close();
    }
}
