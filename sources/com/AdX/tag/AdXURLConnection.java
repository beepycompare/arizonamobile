package com.AdX.tag;

import android.util.Log;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
/* loaded from: classes3.dex */
public class AdXURLConnection {
    static int httpResponseCode;

    public static String connectToURL(String str, String str2) {
        StringBuilder sb;
        String outOfMemoryError;
        String str3 = null;
        try {
            HttpGet httpGet = new HttpGet((String.valueOf(str) + str2).replaceAll(" ", "%20"));
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
            HttpResponse execute = new DefaultHttpClient(basicHttpParams).execute(httpGet);
            str3 = EntityUtils.toString(execute.getEntity());
            httpResponseCode = execute.getStatusLine().getStatusCode();
            if (AdXConnect.DEBUG) {
                Log.i("AdXAppTracker", "--------------------");
                Log.i("AdXAppTracker", "response status: " + execute.getStatusLine().getStatusCode());
                Log.i("AdXAppTracker", "response size: " + str3.length());
                Log.i("AdXAppTracker", "response: ");
                Log.i("AdXAppTracker", str3);
                Log.i("AdXAppTracker", "--------------------");
            }
            return str3;
        } catch (Exception e) {
            sb = new StringBuilder("Exception: ");
            outOfMemoryError = e.toString();
            Log.e("AdXAppTracker", sb.append(outOfMemoryError).toString());
            return str3;
        } catch (OutOfMemoryError e2) {
            sb = new StringBuilder("Out of Memory - Unable to send AdX connetion: ");
            outOfMemoryError = e2.toString();
            Log.e("AdXAppTracker", sb.append(outOfMemoryError).toString());
            return str3;
        }
    }

    public static String postToURL(String str, String str2, String str3, String str4) {
        StringBuilder sb;
        String outOfMemoryError;
        String str5 = null;
        try {
            HttpPost httpPost = new HttpPost((String.valueOf(str) + str2).replaceAll(" ", "%20"));
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(str3, str4));
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            str5 = EntityUtils.toString(execute.getEntity());
            httpResponseCode = execute.getStatusLine().getStatusCode();
            if (AdXConnect.DEBUG) {
                Log.i("AdXAppTracker", "--------------------");
                Log.i("AdXAppTracker", "response status: " + execute.getStatusLine().getStatusCode());
                Log.i("AdXAppTracker", "response size: " + str5.length());
                Log.i("AdXAppTracker", "response: ");
                Log.i("AdXAppTracker", str5);
                Log.i("AdXAppTracker", "--------------------");
            }
            return str5;
        } catch (Exception e) {
            sb = new StringBuilder("Exception: ");
            outOfMemoryError = e.toString();
            Log.e("AdXAppTracker", sb.append(outOfMemoryError).toString());
            return str5;
        } catch (OutOfMemoryError e2) {
            sb = new StringBuilder("Out of Memory - Unable to send AdX connetion: ");
            outOfMemoryError = e2.toString();
            Log.e("AdXAppTracker", sb.append(outOfMemoryError).toString());
            return str5;
        }
    }
}
