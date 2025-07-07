package com.AdX.tag;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.WebView;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/* loaded from: classes3.dex */
public final class AdXConnect {
    public static final int ADX_CUSTOMERID = 1;
    public static final int ADX_DESTINATION_ID = 12;
    public static final int ADX_END_DATE = 8;
    public static final int ADX_EVENT_CONFIRMATION = 5;
    public static final int ADX_EVENT_HOMEPAGE = 0;
    public static final int ADX_EVENT_LEVEL = 6;
    public static final int ADX_EVENT_LISTINGVIEW = 3;
    public static final int ADX_EVENT_PRODUCTVIEW = 2;
    public static final int ADX_EVENT_SEARCH = 1;
    public static final int ADX_EVENT_VIEWCART = 4;
    public static final int ADX_KEYWORD = 3;
    public static final int ADX_LEVEL = 13;
    public static final int ADX_NEWCUSTOMER = 9;
    public static final int ADX_PARAMETER_DATE = 17;
    public static final int ADX_PARAMETER_FLOAT = 16;
    public static final int ADX_PARAMETER_INT = 14;
    public static final int ADX_PARAMETER_STRING = 15;
    public static final int ADX_PRODUCT = 2;
    public static final int ADX_SOURCE_ID = 11;
    public static final int ADX_START_DATE = 7;
    public static final int ADX_TRANSACTION_ID = 10;
    public static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static AdXConnect AdXConnectEventInstance = null;
    private static AdXConnect AdXConnectInstance = null;
    private static AdXURLConnection AdXURLConnection = null;
    public static boolean DEBUG = false;
    private static final String HASH_ALGORITHM = "HmacSHA256";
    public static boolean WARN;
    private String SEND_TAG;
    private String androidID;
    private String appID;
    private String appVersion;
    private String clientID;
    private ConnectEventTask connectEventTask;
    private ConnectTask connectTask;
    private Context context;
    private String deviceCountryCode;
    private String deviceID;
    private String deviceLanguage;
    private String deviceName;
    private String deviceOSVersion;
    private String deviceType;
    private String fbattribution;
    private String host;
    private String idfa;
    private boolean isLAT;
    private String libraryVersion;
    private String macAddress;
    private String protocol;
    private RetargetEventTask retargetEventTask;
    private String sdkType;
    private String storeAppID;
    private String tagVersion;
    private String urlParams;
    private String userAgent;
    private static final ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
    public static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static String referralURL = "";
    private static String AdX_PREFERENCE = "AdXPrefrences";
    private static String MODREFERRAL = "AdXReferral";
    private static String LASTIDFA = "AdXLastIDFA";
    private static String DLREFERRAL = "AdXDLReferral";
    private static String SEENCOUNT = "AdXSeencount";
    private static String RECEIVER_DONE = "ReceiverDone";
    private static String UPDATE = "AdXUpdate";
    private static String REFERRAL_URL = "InstallReferral";
    private static String clientKey = null;
    public static int LOGLEVEL = 1;
    public static int sendDelay = 3;
    private static JSONObject dict = null;
    private static JSONArray productlist = null;

    /* loaded from: classes3.dex */
    private class ConnectEventTask extends AsyncTask<Void, Void, Boolean> {
        Context context;
        String data;
        String event;

        public ConnectEventTask(Context context, String str, String str2) {
            this.context = context;
            this.event = str;
            this.data = str2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voidArr) {
            AdXConnect.this.getIDFA(this.context);
            AdXConnect adXConnect = AdXConnect.this;
            adXConnect.urlParams = String.valueOf(adXConnect.urlParams) + "&idfa=" + AdXConnect.this.idfa + "&isLAT=" + AdXConnect.this.isLAT;
            AdXConnect.this.getHost();
            if (AdXConnect.clientKey != null) {
                try {
                    String hexString = Long.toHexString(Double.doubleToLongBits(Math.random()));
                    AdXConnect adXConnect2 = AdXConnect.this;
                    adXConnect2.urlParams = String.valueOf(adXConnect2.urlParams) + "&signature=" + URLEncoder.encode(AdXConnect.this.encrypt(String.valueOf(hexString) + AdXConnect.this.appID + AdXConnect.this.idfa + this.event + this.data + AdXConnect.this.clientID, AdXConnect.clientKey), "UTF-8");
                    AdXConnect adXConnect3 = AdXConnect.this;
                    adXConnect3.urlParams = String.valueOf(adXConnect3.urlParams) + "&nonce=" + hexString;
                    if (AdXConnect.DEBUG) {
                        Log.i("AdXAppTracker", "Signature sent with connection");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (SignatureException e2) {
                    e2.printStackTrace();
                }
            }
            String connectToURL = AdXURLConnection.connectToURL(String.valueOf(AdXConnect.this.protocol) + AdXConnect.this.host + "/API/androidevent.php?", AdXConnect.this.urlParams);
            return Boolean.valueOf(connectToURL != null ? AdXConnect.this.handleConnectResponse(connectToURL) : false);
        }
    }

    /* loaded from: classes3.dex */
    private class ConnectTask extends AsyncTask<Void, Void, Boolean> {
        Context context;

        public ConnectTask(Context context) {
            this.context = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voidArr) {
            AdXConnect adXConnect;
            AdXConnect adXConnect2;
            AdXConnect adXConnect3;
            if (!AdXConnect.this.getIDFA(this.context)) {
                AdXConnect.this.getIDFA(this.context);
            }
            AdXConnect.this.urlParams = String.valueOf(adXConnect.urlParams) + "&idfa=" + AdXConnect.this.idfa + "&isLAT=" + AdXConnect.this.isLAT;
            AdXConnect.this.getHost();
            if (AdXConnect.clientKey != null) {
                try {
                    String hexString = Long.toHexString(Double.doubleToLongBits(Math.random()));
                    AdXConnect.this.urlParams = String.valueOf(adXConnect2.urlParams) + "&signature=" + URLEncoder.encode(AdXConnect.this.encrypt(String.valueOf(hexString) + AdXConnect.this.appID + AdXConnect.this.idfa + "install" + AdXConnect.this.clientID, AdXConnect.clientKey), "UTF-8");
                    AdXConnect.this.urlParams = String.valueOf(adXConnect3.urlParams) + "&nonce=" + hexString;
                    if (AdXConnect.DEBUG) {
                        Log.i("AdXAppTracker", "Signature sent with connection");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (SignatureException e2) {
                    e2.printStackTrace();
                }
            }
            String str = AdXConnect.this.urlParams;
            if (!AdXConnect.referralURL.equals("")) {
                str = String.valueOf(str) + "&" + AdXConnect.referralURL;
            }
            String connectToURL = AdXURLConnection.connectToURL(String.valueOf(AdXConnect.this.protocol) + AdXConnect.this.host + "/atrk/andrdapp?", str);
            return Boolean.valueOf(connectToURL != null ? AdXConnect.this.handleConnectResponse(connectToURL) : false);
        }
    }

    /* loaded from: classes3.dex */
    private class RetargetEventTask extends AsyncTask<Void, Void, Boolean> {
        Context context;
        String event = "adx_v3";
        String postData;

        public RetargetEventTask(Context context, String str) {
            this.context = context;
            this.postData = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voidArr) {
            String str = AdXConnect.this.androidID;
            AdXConnect.this.getIDFA(this.context);
            AdXConnect adXConnect = AdXConnect.this;
            adXConnect.urlParams = String.valueOf(adXConnect.urlParams) + "&idfa=" + AdXConnect.this.idfa + "&isLAT=" + AdXConnect.this.isLAT;
            AdXConnect.this.getHost();
            if (AdXConnect.clientKey != null) {
                try {
                    String hexString = Long.toHexString(Double.doubleToLongBits(Math.random()));
                    AdXConnect adXConnect2 = AdXConnect.this;
                    adXConnect2.urlParams = String.valueOf(adXConnect2.urlParams) + "&signature=" + URLEncoder.encode(AdXConnect.this.encrypt(String.valueOf(hexString) + AdXConnect.this.appID + AdXConnect.this.idfa + this.event + AdXConnect.this.clientID, AdXConnect.clientKey), "UTF-8");
                    AdXConnect adXConnect3 = AdXConnect.this;
                    adXConnect3.urlParams = String.valueOf(adXConnect3.urlParams) + "&nonce=" + hexString;
                    if (AdXConnect.DEBUG) {
                        Log.i("AdXAppTracker", "Signature sent with connection");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (SignatureException e2) {
                    e2.printStackTrace();
                }
            }
            String postToURL = AdXURLConnection.postToURL(String.valueOf(AdXConnect.this.protocol) + AdXConnect.this.host + "/API/RetargetEvent/" + AdXConnect.this.clientID + RemoteSettings.FORWARD_SLASH_STRING + ((AdXConnect.this.androidID == "" || AdXConnect.this.androidID == null) ? "none" : "none") + RemoteSettings.FORWARD_SLASH_STRING + AdXConnect.this.appID + "?event=" + this.event + "&platform=Android&", AdXConnect.this.urlParams, "payload", this.postData);
            return Boolean.valueOf((postToURL == null || postToURL.length() <= 0) ? false : AdXConnect.this.handleConnectResponse(postToURL));
        }
    }

    private AdXConnect(Context context) {
        this.connectTask = null;
        this.connectEventTask = null;
        this.retargetEventTask = null;
        this.host = "";
        this.protocol = "";
        this.deviceID = "";
        this.deviceName = "";
        this.deviceType = "";
        this.deviceOSVersion = "";
        this.deviceCountryCode = "";
        this.deviceLanguage = "";
        this.androidID = "";
        this.appID = "";
        this.clientID = "";
        this.appVersion = "";
        this.libraryVersion = "";
        this.macAddress = "";
        this.tagVersion = "3.2.6";
        this.urlParams = "";
        this.sdkType = "";
        this.userAgent = "";
        this.storeAppID = "";
        this.fbattribution = "";
        this.idfa = "";
        this.SEND_TAG = "SendTag";
        this.isLAT = false;
        this.context = context;
    }

    private AdXConnect(Context context, int i, String str) {
        this.connectTask = null;
        this.connectEventTask = null;
        this.retargetEventTask = null;
        this.host = "";
        this.protocol = "";
        this.deviceID = "";
        this.deviceName = "";
        this.deviceType = "";
        this.deviceOSVersion = "";
        this.deviceCountryCode = "";
        this.deviceLanguage = "";
        this.androidID = "";
        this.appID = "";
        this.clientID = "";
        this.appVersion = "";
        this.libraryVersion = "";
        this.macAddress = "";
        this.tagVersion = "3.2.6";
        this.urlParams = "";
        this.sdkType = "";
        this.userAgent = "";
        this.storeAppID = "";
        this.fbattribution = "";
        this.idfa = "";
        this.SEND_TAG = "SendTag";
        this.isLAT = false;
        this.context = context;
        String string = context.getSharedPreferences(AdX_PREFERENCE, 0).getString(this.SEND_TAG, null);
        if (string != null && string.equals("stop")) {
            if (DEBUG) {
                Log.i("AdXAppTracker", "SendTag is set to stop ");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.i("AdXAppTracker", "Install Connection ");
        }
        getApplicationData(context);
        this.fbattribution = getFacebookAttributionId(this.context);
        try {
            String string2 = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128).metaData.getString("USEQASERVER");
            if (string2 == null || !string2.equals("ON")) {
                this.host = "apps.ad-x.co.uk";
            } else {
                this.host = "testing.ad-x.co.uk";
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("AdXAppTracker", "Error setting host: " + e.toString());
            }
            this.host = "apps.ad-x.co.uk";
        }
        this.urlParams = String.valueOf(this.urlParams) + "udid=" + this.deviceID;
        this.urlParams = String.valueOf(this.urlParams) + "&androidID=" + this.androidID;
        this.urlParams = String.valueOf(this.urlParams) + "&macAddress=" + this.macAddress;
        this.urlParams = String.valueOf(this.urlParams) + "&type=" + this.sdkType;
        this.urlParams = String.valueOf(this.urlParams) + "&storeAppID=" + this.storeAppID;
        this.urlParams = String.valueOf(this.urlParams) + "&device_name=" + this.deviceName;
        this.urlParams = String.valueOf(this.urlParams) + "&device_type=" + this.deviceType;
        this.urlParams = String.valueOf(this.urlParams) + "&os_version=" + this.deviceOSVersion;
        this.urlParams = String.valueOf(this.urlParams) + "&country_code=" + this.deviceCountryCode;
        this.urlParams = String.valueOf(this.urlParams) + "&language=" + this.deviceLanguage;
        this.urlParams = String.valueOf(this.urlParams) + "&app_id=" + this.appID;
        this.urlParams = String.valueOf(this.urlParams) + "&clientid=" + this.clientID;
        this.urlParams = String.valueOf(this.urlParams) + "&app_version=" + this.appVersion;
        this.urlParams = String.valueOf(this.urlParams) + "&tag_version=" + this.tagVersion;
        this.urlParams = String.valueOf(this.urlParams) + "&fbattribution=" + this.fbattribution;
        this.urlParams = String.valueOf(this.urlParams) + "&uagent=" + this.userAgent;
        this.urlParams = String.valueOf(this.urlParams) + "&update=" + i;
        if (!str.equals("")) {
            try {
                this.urlParams = String.valueOf(this.urlParams) + "&instData=" + URLEncoder.encode(str, "UTF-8");
                if (DEBUG) {
                    Log.i("AdXAppTracker", "Sending extra install data: " + str);
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.e("AdXAppTracker", "Error encoding extra install data: " + e2.toString());
                }
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.AdX.tag.AdXConnect.4
            @Override // java.lang.Runnable
            public void run() {
                AdXConnect adXConnect = AdXConnect.this;
                AdXConnect adXConnect2 = AdXConnect.this;
                adXConnect.connectTask = new ConnectTask(adXConnect2.context);
                AdXConnect.this.connectTask.execute(new Void[0]);
            }
        });
    }

    /* synthetic */ AdXConnect(Context context, int i, String str, AdXConnect adXConnect) {
        this(context, i, str);
    }

    private AdXConnect(Context context, final String str, final String str2, String str3, String str4, String str5, String str6) {
        this.connectTask = null;
        this.connectEventTask = null;
        this.retargetEventTask = null;
        this.host = "";
        this.protocol = "";
        this.deviceID = "";
        this.deviceName = "";
        this.deviceType = "";
        this.deviceOSVersion = "";
        this.deviceCountryCode = "";
        this.deviceLanguage = "";
        this.androidID = "";
        this.appID = "";
        this.clientID = "";
        this.appVersion = "";
        this.libraryVersion = "";
        this.macAddress = "";
        this.tagVersion = "3.2.6";
        this.urlParams = "";
        this.sdkType = "";
        this.userAgent = "";
        this.storeAppID = "";
        this.fbattribution = "";
        this.idfa = "";
        this.SEND_TAG = "SendTag";
        this.isLAT = false;
        this.context = context;
        if (DEBUG) {
            Log.i("AdXAppTracker", "Event Connection");
        }
        getApplicationData(context);
        this.fbattribution = getFacebookAttributionId(context);
        if (DEBUG) {
            Log.i("AdXAppTracker", "Got Application Data ");
        }
        this.urlParams = String.valueOf(this.urlParams) + "oursecret=" + this.clientID;
        this.urlParams = String.valueOf(this.urlParams) + "&udid=" + this.deviceID;
        this.urlParams = String.valueOf(this.urlParams) + "&androidID=" + this.androidID;
        this.urlParams = String.valueOf(this.urlParams) + "&macAddress=" + this.macAddress;
        this.urlParams = String.valueOf(this.urlParams) + "&type=" + this.sdkType;
        this.urlParams = String.valueOf(this.urlParams) + "&storeAppID=" + this.storeAppID;
        this.urlParams = String.valueOf(this.urlParams) + "&device_name=" + this.deviceName;
        this.urlParams = String.valueOf(this.urlParams) + "&device_type=" + this.deviceType;
        this.urlParams = String.valueOf(this.urlParams) + "&os_version=" + this.deviceOSVersion;
        this.urlParams = String.valueOf(this.urlParams) + "&country_code=" + this.deviceCountryCode;
        this.urlParams = String.valueOf(this.urlParams) + "&language=" + this.deviceLanguage;
        this.urlParams = String.valueOf(this.urlParams) + "&app_id=" + this.appID;
        this.urlParams = String.valueOf(this.urlParams) + "&fbattribution=" + this.fbattribution;
        this.urlParams = String.valueOf(this.urlParams) + "&event=" + str;
        this.urlParams = String.valueOf(this.urlParams) + "&data=" + str2;
        this.urlParams = String.valueOf(this.urlParams) + "&uagent=" + this.userAgent;
        this.urlParams = String.valueOf(this.urlParams) + "&currency=" + str3;
        if (str4 != null) {
            try {
                this.urlParams = String.valueOf(this.urlParams) + "&custom_data=" + URLEncoder.encode(str4, "UTF-8");
            } catch (Exception e) {
                Log.e("AdXAppTracker", "Exception URL encoding custom_data " + str4 + " " + e.getMessage());
            }
        }
        if (str5 != null && str6 != null) {
            this.urlParams = String.valueOf(this.urlParams) + "&receiptdata=" + URLEncoder.encode(str5, "UTF-8");
            this.urlParams = String.valueOf(this.urlParams) + "&receiptsignature=" + URLEncoder.encode(str6, "UTF-8");
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.AdX.tag.AdXConnect.5
            @Override // java.lang.Runnable
            public void run() {
                AdXConnect adXConnect = AdXConnect.this;
                AdXConnect adXConnect2 = AdXConnect.this;
                adXConnect.connectEventTask = new ConnectEventTask(adXConnect2.context, str, str2);
                AdXConnect.this.connectEventTask.execute(new Void[0]);
            }
        });
    }

    private void _sendExtendedEvent(String str) {
        try {
            dict.put("e", str);
        } catch (Exception e) {
            Log.e("AdXAppTracker", "Exception " + e.getMessage());
        }
        try {
            if (productlist.length() > 0) {
                dict.put(TtmlNode.TAG_P, productlist);
            }
        } catch (Exception e2) {
            Log.e("AdXAppTracker", "Exception " + e2.getMessage());
        }
        if (DEBUG) {
            Log.i("AdXAppTracker", dict.toString());
        }
        final String jSONObject = dict.toString();
        getApplicationData(this.context);
        this.fbattribution = getFacebookAttributionId(this.context);
        this.urlParams = "";
        this.urlParams = String.valueOf(this.urlParams) + "udid=" + this.deviceID + "&";
        this.urlParams = String.valueOf(this.urlParams) + "device_name=" + this.deviceName + "&";
        this.urlParams = String.valueOf(this.urlParams) + "device_type=" + this.deviceType + "&";
        this.urlParams = String.valueOf(this.urlParams) + "os_version=" + this.deviceOSVersion + "&";
        this.urlParams = String.valueOf(this.urlParams) + "fbattribution=" + this.fbattribution + "&";
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.AdX.tag.AdXConnect.3
            @Override // java.lang.Runnable
            public void run() {
                AdXConnect adXConnect = AdXConnect.this;
                AdXConnect adXConnect2 = AdXConnect.this;
                adXConnect.retargetEventTask = new RetargetEventTask(adXConnect2.context, jSONObject);
                AdXConnect.this.retargetEventTask.execute(new Void[0]);
            }
        });
    }

    public static void addProductToList(String str) {
        productlist.put(str);
    }

    public static void addProductToList(String str, double d, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CmcdData.OBJECT_TYPE_INIT_SEGMENT, str);
            jSONObject.put(CmcdConfiguration.KEY_PLAYBACK_RATE, d);
            jSONObject.put("q", i);
            productlist.put(jSONObject);
        } catch (Exception unused) {
        }
    }

    private Document buildDocument(String str) {
        try {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            return newInstance.newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("UTF-8")));
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("AdXAppTracker", "buildDocument exception: " + e.toString());
            }
            return null;
        }
    }

    public static void doBroadcastConnectInstance(Context context) {
        if (DEBUG) {
            Log.i("AdXAppTracker", "Broadcast Receiver - sending to AdX.");
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(AdX_PREFERENCE, 0).edit();
        edit.putString(RECEIVER_DONE, "done");
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String encrypt(String str, String str2) throws SignatureException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), HASH_ALGORITHM);
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return toHexString(mac.doFinal(str.getBytes()));
        } catch (InvalidKeyException unused) {
            throw new SignatureException("Invalid key HmacSHA256");
        } catch (NoSuchAlgorithmException unused2) {
            throw new SignatureException("No such algorithm HmacSHA256");
        }
    }

    public static void getAdXConnectEventInstance(Context context, String str, String str2, String str3) {
        if (AdXURLConnection == null) {
            AdXURLConnection = new AdXURLConnection();
        }
        if (AdXConnectEventInstance != null) {
            AdXConnectEventInstance = null;
        }
        AdXConnectEventInstance = new AdXConnect(context, str, str2, str3, null, null, null);
    }

    public static void getAdXConnectEventInstance(Context context, String str, String str2, String str3, String str4) {
        if (AdXURLConnection == null) {
            AdXURLConnection = new AdXURLConnection();
        }
        if (AdXConnectEventInstance != null) {
            AdXConnectEventInstance = null;
        }
        AdXConnectEventInstance = new AdXConnect(context, str, str2, str3, str4, null, null);
    }

    public static void getAdXConnectEventInstanceWithReceipt(Context context, String str, String str2, String str3, String str4, String str5) {
        if (AdXURLConnection == null) {
            AdXURLConnection = new AdXURLConnection();
        }
        if (AdXConnectEventInstance != null) {
            AdXConnectEventInstance = null;
        }
        AdXConnectEventInstance = new AdXConnect(context, str, str2, str3, null, str4, str5);
    }

    public static void getAdXConnectEventInstanceWithReceipt(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (AdXURLConnection == null) {
            AdXURLConnection = new AdXURLConnection();
        }
        if (AdXConnectEventInstance != null) {
            AdXConnectEventInstance = null;
        }
        AdXConnectEventInstance = new AdXConnect(context, str, str2, str3, str6, str4, str5);
    }

    public static AdXConnect getAdXConnectInstance(Context context, boolean z, int i) {
        return getAdXConnectInstance(context, z, i, "");
    }

    public static AdXConnect getAdXConnectInstance(final Context context, boolean z, int i, final String str) {
        LOGLEVEL = i;
        int i2 = 0;
        WARN = i > 1;
        DEBUG = i > 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences(AdX_PREFERENCE, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        final int i3 = sharedPreferences.getInt(UPDATE, -1);
        if (i3 < 0) {
            if (z) {
                edit.putInt(UPDATE, 1);
                i2 = 1;
            } else {
                edit.putInt(UPDATE, 0);
            }
            if (DEBUG) {
                Log.i("AdXAppTracker", "Update flag set to " + i2);
            }
            i3 = i2;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            String string = applicationInfo.metaData.getString("OTHERSTORE");
            if (string != null && !string.equals("")) {
                edit.putString(RECEIVER_DONE, "done");
                edit.apply();
                if (DEBUG) {
                    Log.i("AdXAppTracker", "Otherstore set in manifest.");
                }
            }
            String string2 = applicationInfo.metaData.getString("NETWORK");
            if (string2 != null && !string2.equals("")) {
                edit.putString(REFERRAL_URL, "referrer=utm_source%3D" + string2.trim() + "%26utm_medium%3Dcpc%26utm_campaign%3D" + applicationInfo.metaData.getString("REFERENCE").trim());
                edit.putString(RECEIVER_DONE, "done");
                edit.apply();
            }
        } catch (Exception e) {
            if (WARN) {
                Log.i("AdXAppTracker", "Exception " + e.getMessage());
            }
        }
        String string3 = sharedPreferences.getString(RECEIVER_DONE, null);
        if (i3 == 1 || (string3 != null && string3.equals("done"))) {
            if (DEBUG) {
                Log.i("AdXAppTracker", "Sending to AdX");
            }
            if (AdXURLConnection == null) {
                AdXURLConnection = new AdXURLConnection();
            }
            if (AdXConnectInstance == null) {
                AdXConnectInstance = new AdXConnect(context, i3, str);
            }
            return AdXConnectInstance;
        }
        if (DEBUG) {
            Log.i("AdXAppTracker", "Re Referral yet - deferring..");
        }
        edit.putString(RECEIVER_DONE, "done");
        edit.apply();
        try {
        } catch (Exception e2) {
            if (WARN) {
                Log.i("AdXAppTracker", "Exception in delayed send to Ad-X: " + e2.getMessage());
            }
        }
        if (Looper.myLooper() == Looper.getMainLooper() && Looper.myLooper() != null) {
            new Handler().postDelayed(new Runnable() { // from class: com.AdX.tag.AdXConnect.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AdXConnect.DEBUG) {
                        Log.i("AdXAppTracker", String.valueOf(AdXConnect.sendDelay) + " seconds is up sending to AdX");
                    }
                    if (AdXConnect.AdXURLConnection == null) {
                        AdXConnect.AdXURLConnection = new AdXURLConnection();
                    }
                    if (AdXConnect.AdXConnectInstance == null) {
                        AdXConnect.AdXConnectInstance = new AdXConnect(context, i3, str, null);
                    }
                }
            }, sendDelay * 1000);
            return null;
        }
        schedule(new Runnable() { // from class: com.AdX.tag.AdXConnect.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                if (AdXConnect.DEBUG) {
                    Log.i("AdXAppTracker", "Looper " + AdXConnect.sendDelay + " seconds is up sending to AdX");
                }
                if (AdXConnect.AdXURLConnection == null) {
                    AdXConnect.AdXURLConnection = new AdXURLConnection();
                }
                if (AdXConnect.AdXConnectInstance == null) {
                    AdXConnect.AdXConnectInstance = new AdXConnect(context, i3, str, null);
                }
            }
        }, Long.valueOf(sendDelay));
        return null;
    }

    public static String getAdXDLReferral(Context context, int i) {
        int i2 = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences(AdX_PREFERENCE, 0);
        String string = sharedPreferences.getString(DLREFERRAL, null);
        while (i2 < i * 5 && (string == null || string.equals(""))) {
            i2++;
            try {
                string = sharedPreferences.getString(DLREFERRAL, null);
            } catch (Exception unused) {
            }
            if (string != null && string.length() > 0) {
                break;
            }
            Thread.sleep(200L);
        }
        return string;
    }

    public static String getAdXDeviceID(Context context) {
        AdXConnect adXConnect = AdXConnectInstance;
        if (adXConnect != null) {
            return adXConnect.getDeviceID(context);
        }
        return null;
    }

    public static String getAdXReferral(Context context, int i) {
        int i2 = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences(AdX_PREFERENCE, 0);
        String string = sharedPreferences.getString(MODREFERRAL, null);
        while (i2 < i * 5 && (string == null || string.equals(""))) {
            i2++;
            try {
                string = sharedPreferences.getString(MODREFERRAL, null);
            } catch (Exception unused) {
            }
            if (string != null && string.length() > 0) {
                break;
            }
            Thread.sleep(200L);
        }
        return string;
    }

    private void getApplicationData(Context context) {
        String str;
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                if (WARN) {
                    Log.e("AdXAppTracker", "Check your AndroidManifest.xml file. For more details view integration document.");
                    return;
                }
                return;
            }
            String string = applicationInfo.metaData.getString("APP_NAME");
            if (string != null && !string.equals("")) {
                this.appID = string.trim();
                String string2 = applicationInfo.metaData.getString("ADX_CLIENT_ID");
                if (string2 != null && !string2.equals("")) {
                    this.clientID = string2.trim();
                    String string3 = applicationInfo.metaData.getString("SENDFINGERPRINT");
                    if (string3 == null || !string3.equals("ON")) {
                        this.userAgent = "";
                    } else {
                        this.userAgent = new WebView(this.context).getSettings().getUserAgentString();
                    }
                    String string4 = applicationInfo.metaData.getString("OTHERSTORE");
                    if (string4 != null && !string4.equals("")) {
                        this.sdkType = string4;
                    }
                    String string5 = applicationInfo.metaData.getString("STOREAPPID");
                    if (string5 != null && !string5.equals("")) {
                        this.storeAppID = string5;
                    }
                    this.appVersion = packageManager.getPackageInfo(this.context.getPackageName(), 0).versionName;
                    this.deviceType = ConstantDeviceInfo.APP_PLATFORM;
                    this.deviceName = Build.MODEL;
                    this.deviceOSVersion = Build.VERSION.RELEASE;
                    this.deviceCountryCode = Locale.getDefault().getCountry();
                    this.deviceLanguage = Locale.getDefault().getLanguage();
                    this.libraryVersion = this.tagVersion;
                    SharedPreferences sharedPreferences = this.context.getSharedPreferences(AdX_PREFERENCE, 0);
                    String string6 = applicationInfo.metaData.getString("DEVICE_ID");
                    if (string6 == null || string6.equals("")) {
                        try {
                            String string7 = applicationInfo.metaData.getString("ANDROIDID");
                            if (string7 == null || !string7.equals("ON")) {
                                this.androidID = "";
                            } else {
                                this.androidID = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
                            }
                            String string8 = applicationInfo.metaData.getString("MACADDRESS");
                            if (string8 == null || !string8.equals("ON")) {
                                this.macAddress = "";
                            } else {
                                this.macAddress = ((WifiManager) this.context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                            }
                            String string9 = applicationInfo.metaData.getString("IMEI");
                            if (string9 == null || !string9.equals("ON")) {
                                this.deviceID = null;
                            } else {
                                TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
                                if (telephonyManager != null) {
                                    this.deviceID = telephonyManager.getDeviceId();
                                }
                            }
                            String string10 = applicationInfo.metaData.getString("SERIALID");
                            if (string10 != null && string10.equals("ON")) {
                                int i = Build.VERSION.SDK_INT;
                                String str2 = this.deviceID;
                                if (str2 == null) {
                                    if (DEBUG) {
                                        Log.i("AdXAppTracker", "Using Serial ID.");
                                    }
                                    DeviceSerial.getInstance();
                                    this.deviceID = DeviceSerial.getDeviceSerial();
                                } else if (str2 == null && DEBUG) {
                                    Log.e("AdXAppTracker", "Serial ID not available on SDK " + i);
                                }
                            }
                            String str3 = this.deviceID;
                            if (str3 != null && str3.length() != 0 && !this.deviceID.equals("000000000000000") && !this.deviceID.equals("0")) {
                                this.deviceID = this.deviceID.toLowerCase(Locale.ENGLISH);
                            }
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(this.androidID);
                            if (stringBuffer.length() == 0) {
                                stringBuffer.append("ADXID");
                            }
                            String string11 = sharedPreferences.getString("emulatorDeviceId", null);
                            if (string11 == null || string11.equals("")) {
                                for (int i2 = 0; i2 < 16; i2++) {
                                    stringBuffer.append("1234567890abcdefghijklmnopqrstuvw".charAt(((int) (Math.random() * 100.0d)) % 30));
                                }
                                this.deviceID = stringBuffer.toString().toLowerCase(Locale.ENGLISH);
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString("emulatorDeviceId", this.deviceID);
                                edit.apply();
                            } else {
                                this.deviceID = string11;
                            }
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.e("AdXAppTracker", "Error getting a deviceID. e: " + e.toString());
                            }
                            this.deviceID = null;
                        }
                    } else {
                        this.deviceID = string6;
                    }
                    String string12 = sharedPreferences.getString(REFERRAL_URL, null);
                    if (string12 != null && !string12.equals("")) {
                        referralURL = string12;
                    }
                    if (DEBUG) {
                        Log.i("AdXAppTracker", "Metadata successfully loaded");
                    }
                    if (DEBUG) {
                        Log.i("AdXAppTracker", "APP_ID = [" + this.appID + "]");
                    }
                    if (DEBUG) {
                        Log.i("AdXAppTracker", "deviceName: [" + this.deviceName + "]");
                    }
                    if (DEBUG) {
                        Log.i("AdXAppTracker", "deviceType: [" + this.deviceType + "]");
                    }
                    if (DEBUG) {
                        Log.i("AdXAppTracker", "libraryVersion: [" + this.libraryVersion + "]");
                    }
                    if (DEBUG) {
                        Log.i("AdXAppTracker", "deviceOSVersion: [" + this.deviceOSVersion + "]");
                    }
                    if (DEBUG) {
                        Log.i("AdXAppTracker", "COUNTRY_CODE: [" + this.deviceCountryCode + "]");
                    }
                    if (DEBUG) {
                        Log.i("AdXAppTracker", "LANGUAGE_CODE: [" + this.deviceLanguage + "]");
                    }
                    if (DEBUG) {
                        Log.i("AdXAppTracker", "referralURL: [" + referralURL + "]");
                        return;
                    }
                    return;
                } else if (!WARN) {
                    return;
                } else {
                    str = "ADX_CLIENT_ID can't be empty.";
                }
            } else if (!WARN) {
                return;
            } else {
                str = "APP_NAME can't be empty.";
            }
            Log.e("AdXAppTracker", str);
        } catch (PackageManager.NameNotFoundException unused) {
            if (WARN) {
                Log.e("AdXAppTracker", "Check your AndroidManifest.xml file. For more details view integration document.");
            }
        }
    }

    private String getDeviceID(Context context) {
        return context.getSharedPreferences(AdX_PREFERENCE, 0).getString(LASTIDFA, this.deviceID);
    }

    private String getFacebookAttributionId(Context context) {
        String[] strArr = {"aid"};
        String str = "";
        try {
            Cursor query = context.getContentResolver().query(ATTRIBUTION_ID_CONTENT_URI, strArr, null, null, null);
            if (query != null && query.moveToFirst()) {
                str = query.getString(query.getColumnIndex("aid"));
                query.close();
                return str;
            }
            return null;
        } catch (Exception e) {
            if (WARN) {
                Log.i("AdXAppTracker", e.getMessage());
            }
            if (WARN) {
                Log.i("AdXAppTracker", "Retry");
            }
            try {
                Cursor query2 = context.getContentResolver().query(ATTRIBUTION_ID_CONTENT_URI, strArr, null, null, null);
                if (query2 != null && query2.moveToFirst()) {
                    str = query2.getString(query2.getColumnIndex("aid"));
                    query2.close();
                    return str;
                }
                return null;
            } catch (Exception e2) {
                if (WARN) {
                    Log.i("AdXAppTracker", e2.getMessage());
                    return str;
                }
                return str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getHost() {
        String str;
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            String string = applicationInfo.metaData.getString("USEQASERVER");
            if (string == null || !string.equals("ON")) {
                this.host = "apps.ad-x.co.uk";
            } else {
                if (DEBUG) {
                    Log.i("AdXAppTracker", "Host Set to QA SERVER");
                }
                this.host = "testing.ad-x.co.uk";
            }
            String string2 = applicationInfo.metaData.getString("USEHTTPS");
            if (string2 == null || !string2.equals("ON")) {
                str = "http://";
            } else {
                if (DEBUG) {
                    Log.i("AdXAppTracker", "Set to HTTPS");
                }
                str = "https://";
            }
            this.protocol = str;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("AdXAppTracker", "Error setting host: " + e.toString());
            }
            this.host = "apps.ad-x.co.uk";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getIDFA(Context context) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0) {
            this.idfa = context.getSharedPreferences(AdX_PREFERENCE, 0).getString(LASTIDFA, "");
            this.isLAT = false;
            return false;
        }
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            this.idfa = advertisingIdInfo.getId();
            this.isLAT = advertisingIdInfo.isLimitAdTrackingEnabled();
            SharedPreferences.Editor edit = context.getSharedPreferences(AdX_PREFERENCE, 0).edit();
            edit.putString(LASTIDFA, this.idfa);
            edit.apply();
            return true;
        } catch (Exception e) {
            this.idfa = context.getSharedPreferences(AdX_PREFERENCE, 0).getString(LASTIDFA, "");
            this.isLAT = false;
            e.printStackTrace();
            return false;
        }
    }

    private String getNodeTrimValue(NodeList nodeList) {
        Node item;
        Element element = (Element) nodeList.item(0);
        if (element != null) {
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            String str = "";
            for (int i = 0; i < length; i++) {
                if (childNodes.item(i) != null) {
                    str = String.valueOf(str) + item.getNodeValue();
                }
            }
            if (str == null || str.equals("")) {
                return null;
            }
            return str.trim();
        }
        return null;
    }

    public static String getSeencount(Context context, int i) {
        int i2 = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences(AdX_PREFERENCE, 0);
        String string = sharedPreferences.getString(SEENCOUNT, null);
        while (i2 < i * 5 && (string == null || string.equals(""))) {
            i2++;
            try {
                string = sharedPreferences.getString(SEENCOUNT, null);
            } catch (Exception unused) {
            }
            if (string != null && string.length() > 0) {
                break;
            }
            Thread.sleep(200L);
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleConnectResponse(String str) {
        Document buildDocument = buildDocument(str);
        if (buildDocument != null) {
            String nodeTrimValue = getNodeTrimValue(buildDocument.getElementsByTagName("Referral"));
            if (nodeTrimValue != null) {
                if (DEBUG) {
                    Log.i("AdXAppTracker", "Successfully get returned referral " + nodeTrimValue);
                }
                SharedPreferences.Editor edit = this.context.getSharedPreferences(AdX_PREFERENCE, 0).edit();
                edit.putString(MODREFERRAL, nodeTrimValue);
                edit.apply();
            }
            String nodeTrimValue2 = getNodeTrimValue(buildDocument.getElementsByTagName("DLReferral"));
            if (nodeTrimValue2 != null) {
                if (DEBUG) {
                    Log.i("AdXAppTracker", "Successfully get returned DLreferral " + nodeTrimValue2);
                }
                SharedPreferences.Editor edit2 = this.context.getSharedPreferences(AdX_PREFERENCE, 0).edit();
                edit2.putString(DLREFERRAL, nodeTrimValue2);
                edit2.apply();
            }
            String nodeTrimValue3 = getNodeTrimValue(buildDocument.getElementsByTagName("Seencount"));
            if (nodeTrimValue3 != null) {
                SharedPreferences.Editor edit3 = this.context.getSharedPreferences(AdX_PREFERENCE, 0).edit();
                edit3.putString(SEENCOUNT, nodeTrimValue3);
                edit3.apply();
            }
            String nodeTrimValue4 = getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
            if (nodeTrimValue4 != null && nodeTrimValue4.equals("true")) {
                if (DEBUG) {
                    Log.i("AdXAppTracker", "Successfully connected to AdX site.");
                }
                return true;
            } else if (nodeTrimValue4 != null && nodeTrimValue4.equals("stop")) {
                if (DEBUG) {
                    Log.i("AdXAppTracker", "Successfully connected to AdX site - stopping tags from now on.");
                }
                SharedPreferences.Editor edit4 = this.context.getSharedPreferences(AdX_PREFERENCE, 0).edit();
                edit4.putString(this.SEND_TAG, "stop");
                edit4.apply();
                return true;
            } else if (DEBUG) {
                Log.w("AdXAppTracker", "Event Connection before device attribution.");
            }
        }
        return false;
    }

    private static void schedule(Runnable runnable, Long l) {
        scheduledExecutor.schedule(runnable, l.longValue(), TimeUnit.SECONDS);
    }

    public static void sendExtendedEvent(int i) {
        AdXConnectEventInstance._sendExtendedEvent(new String[]{"vh", "vs", "vp", "vl", "vb", "vc", "lc"}[i]);
    }

    public static void sendExtendedEventOfName(String str) {
        AdXConnectEventInstance._sendExtendedEvent(str);
    }

    public static void setAttribution(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(AdX_PREFERENCE, 0).edit();
        edit.putString(REFERRAL_URL, "referrer=utm_source%3D" + str + "%26utm_medium%3Dcpc%26utm_campaign%3D" + str2);
        edit.putString(RECEIVER_DONE, "done");
        edit.apply();
    }

    public static void setEventParameter(int i, Object obj) {
        try {
            dict.put(new String[]{CmcdData.OBJECT_TYPE_AUDIO_ONLY, "ci", TtmlNode.TAG_P, "kw", TtmlNode.TAG_P, CmcdConfiguration.KEY_PLAYBACK_RATE, "q", "din", "dout", "nc", "id", CmcdConfiguration.KEY_SESSION_ID, "did", CmcdData.STREAM_TYPE_LIVE}[i], obj);
        } catch (Exception e) {
            Log.e("AdXAppTracker", "Exception " + e.getMessage());
        }
    }

    public static void setEventParameterOfName(String str, Object obj) {
        try {
            dict.put(str, obj);
        } catch (Exception e) {
            Log.e("AdXAppTracker", "Exception " + e.getMessage());
        }
    }

    public static void setKey(String str) {
        clientKey = str;
    }

    public static void startNewExtendedEvent(Context context) {
        if (AdXURLConnection == null) {
            AdXURLConnection = new AdXURLConnection();
        }
        if (AdXConnectEventInstance != null) {
            AdXConnectEventInstance = null;
        }
        AdXConnectEventInstance = new AdXConnect(context);
        dict = new JSONObject();
        productlist = new JSONArray();
    }

    private String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        Formatter formatter = new Formatter(sb);
        for (byte b : bArr) {
            formatter.format("%02x", Byte.valueOf(b));
        }
        formatter.close();
        return sb.toString();
    }

    public void finalize() {
    }
}
