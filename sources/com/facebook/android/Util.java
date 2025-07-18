package com.facebook.android;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import coil3.network.internal.UtilsKt;
import com.facebook.internal.Utility;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class Util {
    private static final String UTF8 = "UTF-8";

    @Deprecated
    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    } else if (split.length == 1) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        return bundle;
    }

    @Deprecated
    public static String encodePostBody(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + ((String) obj));
                sb.append("\r\n--" + str + "\r\n");
            }
        }
        return sb.toString();
    }

    @Deprecated
    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            if (bundle.get(str) instanceof String) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(String.valueOf(URLEncoder.encode(str)) + "=" + URLEncoder.encode(bundle.getString(str)));
            }
        }
        return sb.toString();
    }

    @Deprecated
    public static String openUrl(String str, String str2, Bundle bundle) throws MalformedURLException, IOException {
        if (str2.equals(UtilsKt.HTTP_METHOD_GET)) {
            str = String.valueOf(str) + "?" + encodeUrl(bundle);
        }
        Utility.logd("Facebook-Util", String.valueOf(str2) + " URL: " + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestProperty("User-Agent", String.valueOf(System.getProperties().getProperty("http.agent")) + " FacebookAndroidSDK");
        if (!str2.equals(UtilsKt.HTTP_METHOD_GET)) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof byte[]) {
                    bundle2.putByteArray(str3, (byte[]) obj);
                }
            }
            if (!bundle.containsKey(FirebaseAnalytics.Param.METHOD)) {
                bundle.putString(FirebaseAnalytics.Param.METHOD, str2);
            }
            if (bundle.containsKey("access_token")) {
                bundle.putString("access_token", URLDecoder.decode(bundle.getString("access_token")));
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
            httpURLConnection.connect();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            try {
                bufferedOutputStream.write(("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n").getBytes());
                bufferedOutputStream.write(encodePostBody(bundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
                bufferedOutputStream.write((String.valueOf("\r\n") + "--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n").getBytes());
                if (!bundle2.isEmpty()) {
                    for (String str4 : bundle2.keySet()) {
                        bufferedOutputStream.write(("Content-Disposition: form-data; filename=\"" + str4 + "\"\r\n").getBytes());
                        bufferedOutputStream.write(("Content-Type: content/unknown\r\n\r\n").getBytes());
                        bufferedOutputStream.write(bundle2.getByteArray(str4));
                        bufferedOutputStream.write((String.valueOf("\r\n") + "--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n").getBytes());
                    }
                }
                bufferedOutputStream.flush();
            } finally {
                bufferedOutputStream.close();
            }
        }
        try {
            return read(httpURLConnection.getInputStream());
        } catch (FileNotFoundException unused) {
            return read(httpURLConnection.getErrorStream());
        }
    }

    @Deprecated
    public static JSONObject parseJson(String str) throws JSONException, FacebookError {
        if (str.equals("false")) {
            throw new FacebookError("request failed");
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("error")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("error");
            throw new FacebookError(jSONObject2.getString("message"), jSONObject2.getString("type"), 0);
        } else if (jSONObject.has("error_code") && jSONObject.has("error_msg")) {
            throw new FacebookError(jSONObject.getString("error_msg"), "", Integer.parseInt(jSONObject.getString("error_code")));
        } else {
            if (jSONObject.has("error_code")) {
                throw new FacebookError("request failed", "", Integer.parseInt(jSONObject.getString("error_code")));
            }
            if (jSONObject.has("error_msg")) {
                throw new FacebookError(jSONObject.getString("error_msg"));
            }
            if (jSONObject.has("error_reason")) {
                throw new FacebookError(jSONObject.getString("error_reason"));
            }
            return jSONObject;
        }
    }

    @Deprecated
    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    @Deprecated
    private static String read(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                inputStream.close();
                return sb.toString();
            }
            sb.append(readLine);
        }
    }

    @Deprecated
    public static void showAlert(Context context, String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
    }
}
