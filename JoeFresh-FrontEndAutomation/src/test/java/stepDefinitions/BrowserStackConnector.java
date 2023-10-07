package stepDefinitions;

import com.browserstack.local.Local;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackConnector {
    private static Local bsLocal;

    public static void startBrowserStackLocal(String username, String accessKey) throws Exception {
        Map<String, String> bsLocalArgs = new HashMap<String, String>();
        bsLocalArgs.put("key", accessKey);
        bsLocalArgs.put("forcelocal", "true");
        bsLocal = new Local();
        bsLocal.start(bsLocalArgs);
    }

    public static void stopBrowserStackLocal() throws Exception {
        if (bsLocal != null) {
            bsLocal.stop();
        }
    }
}

