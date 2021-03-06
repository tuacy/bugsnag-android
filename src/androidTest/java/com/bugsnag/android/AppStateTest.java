package com.bugsnag.android;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class AppStateTest extends BugsnagTestCase {
    public void testSaneValues() throws JSONException, IOException {
        Configuration config = new Configuration("some-api-key");
        AppState appState = new AppState(getContext());
        JSONObject appStateJson = streamableToJson(appState);

        assertTrue(appStateJson.getLong("memoryUsage") > 0);
        assertNotNull(appStateJson.getBoolean("lowMemory"));
        assertTrue(appStateJson.getLong("duration") >= 0);
    }
}
