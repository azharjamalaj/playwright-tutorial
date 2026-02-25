import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommaSepratedExample {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.orangehrm.com/en/book-a-free-demo");

        List<String> componentOfPage = Arrays.asList();