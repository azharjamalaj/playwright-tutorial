import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("https://playwright.dev");
            System.out.println(page.title());

            boolean status = browser.isConnected();
            System.out.println("The browser is active"+ status);

            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions()
                            .setPermissions(List.of("geolocation"))
            );

            context.storageState(
                    new BrowserContext.StorageStateOptions()
                            .setPath(Paths.get("state.json"))
            );
            System.out.println("Geolocation "+ context);

        }

    }
}