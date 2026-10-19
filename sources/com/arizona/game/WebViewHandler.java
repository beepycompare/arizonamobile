package com.arizona.game;

import android.util.Base64;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes3.dex */
public class WebViewHandler {
    private static final int BROWSER_CHANGEURL = 3;
    private static final int BROWSER_CREATE = 1;
    private static final int BROWSER_DESTROY = 2;
    private static final int BROWSER_INJECTCODE = 4;
    private static final int BROWSER_TOGGLE_SHOW_SCREEN = 5;
    private GTASA context;
    private Map<Integer, WebView> webViews = new HashMap();

    /* loaded from: classes3.dex */
    public static class BrowserChangeUrlJson {
        public int id;
        public String url;
    }

    /* loaded from: classes3.dex */
    public static class BrowserCreateJson {
        public int id;
        public String url;
    }

    /* loaded from: classes3.dex */
    public static class BrowserDestoryJson {
        public int id;
    }

    /* loaded from: classes3.dex */
    public static class BrowserInjectCodeJson {
        public String code;
        public int id;
    }

    /* loaded from: classes3.dex */
    public static class IncomingJsonInternal {
        public String data;
        public int id;
    }

    public WebViewHandler(GTASA context) {
        this.context = context;
    }

    public void onJsonDataIncoming(String json) {
        try {
            IncomingJsonInternal incomingJsonInternal = (IncomingJsonInternal) new Gson().fromJson(json, (Class<Object>) IncomingJsonInternal.class);
            String str = new String(Base64.decode(incomingJsonInternal.data, 0));
            if (incomingJsonInternal.id == 1) {
                onCreateBrowser(str);
            } else if (incomingJsonInternal.id == 2) {
                onDestoryBrowser(str);
            } else if (incomingJsonInternal.id == 3) {
                onChangeUrlBrowser(str);
            } else if (incomingJsonInternal.id == 4) {
                onInjectCodeBrowser(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadWebViewUrl(WebView webView, String url) {
        boolean contains = url.contains("file::");
        GTASA gtasa = this.context;
        if (contains) {
            webView.loadUrl("file://" + gtasa.getFullPath(url.replace("file://", "")));
            return;
        }
        webView.loadUrl("file://" + gtasa.getFullPath(url));
    }

    public void onCreateBrowser(String json) {
        try {
            BrowserCreateJson browserCreateJson = (BrowserCreateJson) new Gson().fromJson(json, (Class<Object>) BrowserCreateJson.class);
            if (browserCreateJson.id != 0) {
                return;
            }
            WebView webView = new WebView(this.context);
            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setAllowFileAccess(true);
            webView.getSettings().setAllowContentAccess(true);
            webView.getSettings().setAllowFileAccessFromFileURLs(true);
            webView.setBackgroundColor(0);
            webView.evaluateJavascript("var meta = document.createElement('meta');meta.name = 'viewport';meta.content = 'width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no';var head = document.getElementsByTagName('head')[0];head.appendChild(meta);", null);
            webView.evaluateJavascript("window.cef = {SendMessage: function SendMessage(message, uid) {window.Android.postMessage(JSON.stringify({id: 1, data: message, uid: uid}));},GetMyId: function GetMyId() {window.Android.postMessage(JSON.stringify({id: 2, data: \"\"}));},GetVoiceState: function GetVoiceState() {},onMyId: function onMyId() {},LoadPassword: function LoadPassword() {},StorePassword: function StorePassword() {},onRegRead: function onRegRead() {},RegRead2: function RegRead2(path, name) {window.cef.onRegRead(\"\".concat(path, \":\").concat(name), !Math.round(Math.random()));},LayoutName: function LayoutName() {},LayoutCapital: function LayoutCapital() {},RegWrite2: function RegWrite2(path, name) {},IsCommandLineContain: function IsCommandLineContain(arg) { window.cef.onCommandLineContain(true, true); },IsSampConnected: function IsSampConnected(arg) { window.cef.onSampConnected(true); }};window.cef[\"GetPedVehicle\"] = function GetPedVehicle(arg) {};window.cef[\"GetVehLights\"] = function GetVehLights(arg) {};window.cef[\"GetVehClosed\"] = function GetVehClosed(arg) {};window.cef[\"GetVehEngine\"] = function GetVehEngine(arg) {};window.cef[\"GetVehSpeed\"] = function GetVehSpeed(arg) {};window.cef[\"GetPedHitpoints\"] = function GetPedHitpoints(arg) {};window.cef[\"GetLocalPedId\"] = function GetLocalPedId(arg) {};window.cef[\"GetLocalPedMoney\"] = function GetLocalPedMoney(arg) {};window.cef[\"GetPedArmor\"] = function GetPedArmor(arg) {};window.cef[\"GetPedWeaponSlot\"] = function GetPedWeaponSlot(arg) {};window.cef[\"GetPedWeaponId\"] = function GetPedWeaponId(arg) {};window.cef[\"GetPedWeaponAmmoTotal\"] = function GetPedWeaponAmmoTotal(arg) {};window.cef[\"GetPedWeaponAmmoClip\"] = function GetPedWeaponAmmoClip(arg) {};window.cef[\"GetPedWeaponState\"] = function GetPedWeaponState(arg) {};window.cef[\"GetLocalPedWanted\"] = function GetLocalPedWanted(arg) {};window.cef[\"GetVoiceState\"] = function GetVoiceState(arg) {};window.cef[\"GetVehHitpoints\"] = function GetVehHitpoints(arg) {};window.cef[\"GetLaunchInfo\"] = function GetLaunchInfo(arg) {};window.cef[\"GetTurnState\"] = function GetTurnState(arg) {};window.cef[\"GetPedDriver\"] = function GetPedDriver(arg) {};window.cef[\"GetPlayersCount\"] = function GetPlayersCount(arg) {};", null);
            loadWebViewUrl(webView, browserCreateJson.url);
            webView.addJavascriptInterface(new WebAppInterface(), "Android");
            this.context.getRootView().addView(webView);
            this.webViews.put(Integer.valueOf(browserCreateJson.id), webView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDestoryBrowser(String json) {
        try {
            BrowserDestoryJson browserDestoryJson = (BrowserDestoryJson) new Gson().fromJson(json, (Class<Object>) BrowserDestoryJson.class);
            if (this.webViews.containsKey(Integer.valueOf(browserDestoryJson.id))) {
                this.context.getRootView().removeView(this.webViews.get(Integer.valueOf(browserDestoryJson.id)));
                this.webViews.remove(Integer.valueOf(browserDestoryJson.id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onChangeUrlBrowser(String json) {
        try {
            BrowserChangeUrlJson browserChangeUrlJson = (BrowserChangeUrlJson) new Gson().fromJson(json, (Class<Object>) BrowserChangeUrlJson.class);
            if (this.webViews.containsKey(Integer.valueOf(browserChangeUrlJson.id))) {
                loadWebViewUrl(this.webViews.get(Integer.valueOf(browserChangeUrlJson.id)), browserChangeUrlJson.url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onInjectCodeBrowser(String json) {
        try {
            BrowserInjectCodeJson browserInjectCodeJson = (BrowserInjectCodeJson) new Gson().fromJson(json, (Class<Object>) BrowserInjectCodeJson.class);
            if (this.webViews.containsKey(Integer.valueOf(browserInjectCodeJson.id))) {
                this.webViews.get(Integer.valueOf(browserInjectCodeJson.id)).evaluateJavascript(new String(Base64.decode(browserInjectCodeJson.code, 0)), null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFilesFromAssets() {
        try {
            File file = new File(this.context.getFullPath("frontend.zip"));
            File file2 = new File(this.context.getFullPath(""));
            if (!file2.exists()) {
                file2.mkdirs();
            }
            unzip(file, file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unzip(File zipFile, File destDir) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
        try {
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                File file = new File(destDir, nextEntry.getName());
                if (nextEntry.isDirectory()) {
                    file.mkdirs();
                } else {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                }
                zipInputStream.closeEntry();
            }
            zipInputStream.close();
        } catch (Throwable th) {
            try {
                zipInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
