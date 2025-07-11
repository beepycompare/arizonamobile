package com.wardrumstudios.utils;

import android.util.Log;
import androidx.autofill.HintConstants;
import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.AbstractVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
/* loaded from: classes4.dex */
public class WarHttp {
    private static boolean AddLineFeeds = false;
    private int timeoutSeconds = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class MyVerifier extends AbstractVerifier {
        private final X509HostnameVerifier delegate;

        public MyVerifier(X509HostnameVerifier x509HostnameVerifier) {
            this.delegate = x509HostnameVerifier;
        }

        @Override // org.apache.http.conn.ssl.X509HostnameVerifier
        public void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
            try {
                this.delegate.verify(str, strArr, strArr2);
            } catch (SSLException e) {
                boolean z = false;
                for (String str2 : strArr) {
                    if (str2.startsWith("*.")) {
                        try {
                            if (str2.substring(2).equals("onmodulus.net")) {
                            }
                            this.delegate.verify(str, new String[]{str2.substring(2)}, strArr2);
                            z = true;
                        } catch (Exception unused) {
                        }
                    }
                }
                if (!z) {
                    throw e;
                }
            }
        }
    }

    protected WarHttp(WarBase warBase) {
    }

    private static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder("");
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        if (AddLineFeeds) {
                            sb.append("\n");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    break;
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
        inputStream.close();
        Log.e("log_tag", "convertStreamToString " + sb.toString());
        return sb.toString();
    }

    public void AddHttpGetLineFeeds(boolean z) {
        AddLineFeeds = z;
    }

    public String HttpGet(String str) {
        try {
            DefaultHttpClient tolerantClient = getTolerantClient();
            HttpConnectionParams.setConnectionTimeout(tolerantClient.getParams(), this.timeoutSeconds * 1000);
            HttpConnectionParams.setSoTimeout(tolerantClient.getParams(), this.timeoutSeconds * 1000);
            HttpGet httpGet = new HttpGet();
            httpGet.setURI(new URI(str));
            HttpEntity entity = tolerantClient.execute(httpGet).getEntity();
            if (entity != null) {
                InputStream content = entity.getContent();
                String convertStreamToString = convertStreamToString(content);
                content.close();
                Log.e("log_tag", "HttpGet " + convertStreamToString);
                return convertStreamToString;
            }
        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        Log.e("log_tag", "return blank string");
        return "";
    }

    public byte[] HttpGetData(String str) {
        try {
            DefaultHttpClient tolerantClient = getTolerantClient();
            HttpConnectionParams.setConnectionTimeout(tolerantClient.getParams(), this.timeoutSeconds * 1000);
            HttpConnectionParams.setSoTimeout(tolerantClient.getParams(), this.timeoutSeconds * 1000);
            HttpGet httpGet = new HttpGet();
            httpGet.setURI(new URI(str));
            HttpEntity entity = tolerantClient.execute(httpGet).getEntity();
            Log.e("log_tag", "entity len=" + entity.getContentLength() + "getContentType=" + entity.getContentType());
            if (entity != null) {
                InputStream content = entity.getContent();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        String convertStreamToString = convertStreamToString(content);
                        content.close();
                        Log.e("log_tag", "HttpGet " + convertStreamToString);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        Log.e("log_tag", "return blank string");
        return null;
    }

    public String HttpPost(String str) {
        try {
            DefaultHttpClient tolerantClient = getTolerantClient();
            HttpConnectionParams.setConnectionTimeout(tolerantClient.getParams(), this.timeoutSeconds * 1000);
            HttpConnectionParams.setSoTimeout(tolerantClient.getParams(), this.timeoutSeconds * 1000);
            HttpPost httpPost = new HttpPost();
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(new BasicNameValuePair(HintConstants.AUTOFILL_HINT_USERNAME, "eeewardrum@gmail.com"));
            arrayList.add(new BasicNameValuePair(HintConstants.AUTOFILL_HINT_PASSWORD, "*"));
            httpPost.setURI(new URI(str));
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            HttpResponse execute = tolerantClient.execute(httpPost);
            Log.e("log_tag", "HttpPost send " + str);
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                InputStream content = entity.getContent();
                String convertStreamToString = convertStreamToString(content);
                content.close();
                Log.e("log_tag", "HttpPost " + convertStreamToString);
                return convertStreamToString;
            }
        } catch (Exception e2) {
            Log.e("log_tag", "Error in http connection " + e2.toString());
        }
        Log.e("log_tag", "return blank string");
        return "";
    }

    public void SetHttpTimeout(int i) {
    }

    public DefaultHttpClient getTolerantClient() {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        SSLSocketFactory sSLSocketFactory = (SSLSocketFactory) defaultHttpClient.getConnectionManager().getSchemeRegistry().getScheme(Constants.SCHEME).getSocketFactory();
        X509HostnameVerifier hostnameVerifier = sSLSocketFactory.getHostnameVerifier();
        if (!(hostnameVerifier instanceof MyVerifier)) {
            sSLSocketFactory.setHostnameVerifier(new MyVerifier(hostnameVerifier));
        }
        return defaultHttpClient;
    }
}
