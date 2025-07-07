package com.google.android.vending.expansion.downloader.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.os.Looper;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes4.dex */
public final class AndroidHttpClient implements HttpClient {
    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 0;
    private static final int SOCKET_OPERATION_TIMEOUT = 60000;
    private static final String TAG = "AndroidHttpClient";
    static Class<?> sSslSessionCacheClass;
    private static final HttpRequestInterceptor sThreadCheckInterceptor;
    private volatile LoggingConfiguration curlConfiguration;
    private final HttpClient delegate;
    private RuntimeException mLeakedException = new IllegalStateException("AndroidHttpClient created and never closed");

    /* loaded from: classes4.dex */
    private class CurlLogger implements HttpRequestInterceptor {
        private CurlLogger() {
        }

        public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
            LoggingConfiguration loggingConfiguration = AndroidHttpClient.this.curlConfiguration;
            if (loggingConfiguration != null && loggingConfiguration.isLoggable() && (httpRequest instanceof HttpUriRequest)) {
                loggingConfiguration.println(AndroidHttpClient.toCurl((HttpUriRequest) httpRequest, false));
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class LoggingConfiguration {
        private final int level;
        private final String tag;

        private LoggingConfiguration(String str, int i) {
            this.tag = str;
            this.level = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isLoggable() {
            return Log.isLoggable(this.tag, this.level);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void println(String str) {
            Log.println(this.level, this.tag, str);
        }
    }

    static {
        try {
            sSslSessionCacheClass = Class.forName("android.net.SSLSessionCache");
        } catch (Exception unused) {
        }
        DEFAULT_SYNC_MIN_GZIP_BYTES = 256L;
        sThreadCheckInterceptor = new HttpRequestInterceptor() { // from class: com.google.android.vending.expansion.downloader.impl.AndroidHttpClient.1
            public void process(HttpRequest httpRequest, HttpContext httpContext) {
                if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                    throw new RuntimeException("This thread forbids HTTP requests");
                }
            }
        };
    }

    private AndroidHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.delegate = new DefaultHttpClient(clientConnectionManager, httpParams) { // from class: com.google.android.vending.expansion.downloader.impl.AndroidHttpClient.2
            protected HttpContext createHttpContext() {
                BasicHttpContext basicHttpContext = new BasicHttpContext();
                basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
                basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
                basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
                return basicHttpContext;
            }

            protected BasicHttpProcessor createHttpProcessor() {
                BasicHttpProcessor createHttpProcessor = super.createHttpProcessor();
                createHttpProcessor.addRequestInterceptor(AndroidHttpClient.sThreadCheckInterceptor);
                createHttpProcessor.addRequestInterceptor(new CurlLogger());
                return createHttpProcessor;
            }
        };
    }

    public static AbstractHttpEntity getCompressedEntity(byte[] bArr, ContentResolver contentResolver) throws IOException {
        if (bArr.length < getMinGzipSize(contentResolver)) {
            return new ByteArrayEntity(bArr);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(byteArrayOutputStream.toByteArray());
        byteArrayEntity.setContentEncoding("gzip");
        return byteArrayEntity;
    }

    public static long getMinGzipSize(ContentResolver contentResolver) {
        return DEFAULT_SYNC_MIN_GZIP_BYTES;
    }

    public static InputStream getUngzippedContent(HttpEntity httpEntity) throws IOException {
        Header contentEncoding;
        String value;
        InputStream content = httpEntity.getContent();
        return (content == null || (contentEncoding = httpEntity.getContentEncoding()) == null || (value = contentEncoding.getValue()) == null || !value.contains("gzip")) ? content : new GZIPInputStream(content);
    }

    public static void modifyRequestToAcceptGzipResponse(HttpRequest httpRequest) {
        httpRequest.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");
    }

    public static AndroidHttpClient newInstance(String str) {
        return newInstance(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AndroidHttpClient newInstance(String str, Context context) {
        Object obj;
        Class<?> cls;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 60000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 60000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpClientParams.setRedirecting(basicHttpParams, false);
        SocketFactory socketFactory = null;
        if (context != null && (cls = sSslSessionCacheClass) != null) {
            try {
                obj = cls.getConstructor(Context.class).newInstance(context);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (SecurityException e5) {
                e5.printStackTrace();
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
            }
            HttpProtocolParams.setUserAgent(basicHttpParams, str);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            if (obj != null) {
                try {
                    socketFactory = (SocketFactory) SSLCertificateSocketFactory.class.getDeclaredMethod("getHttpSocketFactory", Integer.TYPE, sSslSessionCacheClass).invoke(null, 60000, obj);
                } catch (IllegalAccessException e7) {
                    e7.printStackTrace();
                } catch (IllegalArgumentException e8) {
                    e8.printStackTrace();
                } catch (NoSuchMethodException e9) {
                    e9.printStackTrace();
                } catch (SecurityException e10) {
                    e10.printStackTrace();
                } catch (InvocationTargetException e11) {
                    e11.printStackTrace();
                }
            }
            if (socketFactory == null) {
                socketFactory = SSLSocketFactory.getSocketFactory();
            }
            schemeRegistry.register(new Scheme(Constants.SCHEME, socketFactory, 443));
            return new AndroidHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        }
        obj = null;
        HttpProtocolParams.setUserAgent(basicHttpParams, str);
        SchemeRegistry schemeRegistry2 = new SchemeRegistry();
        schemeRegistry2.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (obj != null) {
        }
        if (socketFactory == null) {
        }
        schemeRegistry2.register(new Scheme(Constants.SCHEME, socketFactory, 443));
        return new AndroidHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry2), basicHttpParams);
    }

    public static long parseDate(String str) {
        return HttpDateTime.parse(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String toCurl(HttpUriRequest httpUriRequest, boolean z) throws IOException {
        Header[] allHeaders;
        HttpEntity entity;
        StringBuilder sb = new StringBuilder("curl ");
        for (Header header : httpUriRequest.getAllHeaders()) {
            if (z || (!header.getName().equals(HttpHeaders.AUTHORIZATION) && !header.getName().equals(HttpHeaders.COOKIE))) {
                sb.append("--header \"");
                sb.append(header.toString().trim());
                sb.append("\" ");
            }
        }
        URI uri = httpUriRequest.getURI();
        if (httpUriRequest instanceof RequestWrapper) {
            HttpUriRequest original = ((RequestWrapper) httpUriRequest).getOriginal();
            if (original instanceof HttpUriRequest) {
                uri = original.getURI();
            }
        }
        sb.append("\"");
        sb.append(uri);
        sb.append("\"");
        if ((httpUriRequest instanceof HttpEntityEnclosingRequest) && (entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity()) != null && entity.isRepeatable()) {
            if (entity.getContentLength() < 1024) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                entity.writeTo(byteArrayOutputStream);
                sb.append(" --data-ascii \"").append(byteArrayOutputStream.toString()).append("\"");
            } else {
                sb.append(" [TOO MUCH DATA TO INCLUDE]");
            }
        }
        return sb.toString();
    }

    public void close() {
        if (this.mLeakedException != null) {
            getConnectionManager().shutdown();
            this.mLeakedException = null;
        }
    }

    public void disableCurlLogging() {
        this.curlConfiguration = null;
    }

    public void enableCurlLogging(String str, int i) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        if (i < 2 || i > 7) {
            throw new IllegalArgumentException("Level is out of range [2..7]");
        }
        this.curlConfiguration = new LoggingConfiguration(str, i);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return (T) this.delegate.execute(httpHost, httpRequest, responseHandler);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return (T) this.delegate.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return (T) this.delegate.execute(httpUriRequest, responseHandler);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return (T) this.delegate.execute(httpUriRequest, responseHandler, httpContext);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return this.delegate.execute(httpHost, httpRequest);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return this.delegate.execute(httpHost, httpRequest, httpContext);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return this.delegate.execute(httpUriRequest);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return this.delegate.execute(httpUriRequest, httpContext);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        RuntimeException runtimeException = this.mLeakedException;
        if (runtimeException != null) {
            Log.e(TAG, "Leak found", runtimeException);
            this.mLeakedException = null;
        }
    }

    public ClientConnectionManager getConnectionManager() {
        return this.delegate.getConnectionManager();
    }

    public HttpParams getParams() {
        return this.delegate.getParams();
    }
}
