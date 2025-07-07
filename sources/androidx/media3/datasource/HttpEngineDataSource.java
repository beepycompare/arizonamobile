package androidx.media3.datasource;

import android.net.Uri;
import android.net.http.HttpEngine;
import android.net.http.HttpException;
import android.net.http.NetworkException;
import android.net.http.UrlRequest;
import android.net.http.UrlResponseInfo;
import android.text.TextUtils;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HttpHeaders;
import com.google.common.primitives.Longs;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.UByte$$ExternalSyntheticBackport0;
/* loaded from: classes2.dex */
public final class HttpEngineDataSource extends BaseDataSource implements HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int READ_BUFFER_SIZE_BYTES = 32768;
    private static final String TAG = "HttpEngineDataSource";
    private long bytesRemaining;
    private final Clock clock;
    private final int connectTimeoutMs;
    private Predicate<String> contentTypePredicate;
    private volatile long currentConnectTimeoutMs;
    private DataSpec currentDataSpec;
    private UrlRequestWrapper currentUrlRequestWrapper;
    private final HttpDataSource.RequestProperties defaultRequestProperties;
    private IOException exception;
    private final Executor executor;
    private boolean finished;
    private final boolean handleSetCookieRequests;
    private final HttpEngine httpEngine;
    private final boolean keepPostFor302Redirects;
    private final ConditionVariable operation;
    private ByteBuffer readBuffer;
    private final int readTimeoutMs;
    private final int requestPriority;
    private final HttpDataSource.RequestProperties requestProperties;
    private final boolean resetTimeoutOnRedirects;
    private UrlResponseInfo responseInfo;
    private boolean transferStarted;
    private final String userAgent;

    /* loaded from: classes2.dex */
    public static final class Factory implements HttpDataSource.Factory {
        private Predicate<String> contentTypePredicate;
        private final Executor executor;
        private boolean handleSetCookieRequests;
        private final HttpEngine httpEngine;
        private boolean keepPostFor302Redirects;
        private boolean resetTimeoutOnRedirects;
        private TransferListener transferListener;
        private String userAgent;
        private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();
        private int requestPriority = 3;
        private int connectTimeoutMs = 8000;
        private int readTimeoutMs = 8000;

        @Override // androidx.media3.datasource.HttpDataSource.Factory
        public /* bridge */ /* synthetic */ HttpDataSource.Factory setDefaultRequestProperties(Map map) {
            return setDefaultRequestProperties((Map<String, String>) map);
        }

        public Factory(HttpEngine httpEngine, Executor executor) {
            this.httpEngine = (HttpEngine) Assertions.checkNotNull(httpEngine);
            this.executor = executor;
        }

        @Override // androidx.media3.datasource.HttpDataSource.Factory
        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }

        public Factory setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Factory setRequestPriority(int i) {
            this.requestPriority = i;
            return this;
        }

        public Factory setConnectionTimeoutMs(int i) {
            this.connectTimeoutMs = i;
            return this;
        }

        public Factory setResetTimeoutOnRedirects(boolean z) {
            this.resetTimeoutOnRedirects = z;
            return this;
        }

        public Factory setHandleSetCookieRequests(boolean z) {
            this.handleSetCookieRequests = z;
            return this;
        }

        public Factory setReadTimeoutMs(int i) {
            this.readTimeoutMs = i;
            return this;
        }

        public Factory setContentTypePredicate(Predicate<String> predicate) {
            this.contentTypePredicate = predicate;
            return this;
        }

        public Factory setKeepPostFor302Redirects(boolean z) {
            this.keepPostFor302Redirects = z;
            return this;
        }

        public Factory setTransferListener(TransferListener transferListener) {
            this.transferListener = transferListener;
            return this;
        }

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public HttpDataSource createDataSource() {
            HttpEngineDataSource httpEngineDataSource = new HttpEngineDataSource(this.httpEngine, this.executor, this.requestPriority, this.connectTimeoutMs, this.readTimeoutMs, this.resetTimeoutOnRedirects, this.handleSetCookieRequests, this.userAgent, this.defaultRequestProperties, this.contentTypePredicate, this.keepPostFor302Redirects);
            TransferListener transferListener = this.transferListener;
            if (transferListener != null) {
                httpEngineDataSource.addTransferListener(transferListener);
            }
            return httpEngineDataSource;
        }
    }

    /* loaded from: classes2.dex */
    public static final class OpenException extends HttpDataSource.HttpDataSourceException {
        public final int httpEngineConnectionStatus;

        public OpenException(IOException iOException, DataSpec dataSpec, int i, int i2) {
            super(iOException, dataSpec, i, 1);
            this.httpEngineConnectionStatus = i2;
        }

        public OpenException(String str, DataSpec dataSpec, int i, int i2) {
            super(str, dataSpec, i, 1);
            this.httpEngineConnectionStatus = i2;
        }

        public OpenException(DataSpec dataSpec, int i, int i2) {
            super(dataSpec, i, 1);
            this.httpEngineConnectionStatus = i2;
        }
    }

    HttpEngineDataSource(HttpEngine httpEngine, Executor executor, int i, int i2, int i3, boolean z, boolean z2, String str, HttpDataSource.RequestProperties requestProperties, Predicate<String> predicate, boolean z3) {
        super(true);
        this.httpEngine = (HttpEngine) Assertions.checkNotNull(httpEngine);
        this.executor = (Executor) Assertions.checkNotNull(executor);
        this.requestPriority = i;
        this.connectTimeoutMs = i2;
        this.readTimeoutMs = i3;
        this.resetTimeoutOnRedirects = z;
        this.handleSetCookieRequests = z2;
        this.userAgent = str;
        this.defaultRequestProperties = requestProperties;
        this.contentTypePredicate = predicate;
        this.keepPostFor302Redirects = z3;
        this.clock = Clock.DEFAULT;
        this.requestProperties = new HttpDataSource.RequestProperties();
        this.operation = new ConditionVariable();
    }

    @Override // androidx.media3.datasource.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        this.requestProperties.set(str, str2);
    }

    @Override // androidx.media3.datasource.HttpDataSource
    public void clearRequestProperty(String str) {
        this.requestProperties.remove(str);
    }

    @Override // androidx.media3.datasource.HttpDataSource
    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    @Override // androidx.media3.datasource.HttpDataSource
    public int getResponseCode() {
        UrlResponseInfo urlResponseInfo = this.responseInfo;
        if (urlResponseInfo == null || urlResponseInfo.getHttpStatusCode() <= 0) {
            return -1;
        }
        return this.responseInfo.getHttpStatusCode();
    }

    @Override // androidx.media3.datasource.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        UrlResponseInfo urlResponseInfo = this.responseInfo;
        return urlResponseInfo == null ? Collections.emptyMap() : urlResponseInfo.getHeaders().getAsMap();
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        UrlResponseInfo urlResponseInfo = this.responseInfo;
        if (urlResponseInfo != null) {
            return Uri.parse(urlResponseInfo.getUrl());
        }
        DataSpec dataSpec = this.currentDataSpec;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    @Override // androidx.media3.datasource.DataSource
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        byte[] bArr;
        String firstHeader;
        Assertions.checkNotNull(dataSpec);
        Assertions.checkState(!this.transferStarted);
        this.operation.close();
        resetConnectTimeout();
        this.currentDataSpec = dataSpec;
        try {
            UrlRequestWrapper buildRequestWrapper = buildRequestWrapper(dataSpec);
            this.currentUrlRequestWrapper = buildRequestWrapper;
            buildRequestWrapper.start();
            transferInitializing(dataSpec);
            try {
                boolean blockUntilConnectTimeout = blockUntilConnectTimeout();
                IOException iOException = this.exception;
                if (iOException != null) {
                    String message = iOException.getMessage();
                    if (message != null && Ascii.toLowerCase(message).contains("err_cleartext_not_permitted")) {
                        throw new HttpDataSource.CleartextNotPermittedException(iOException, dataSpec);
                    }
                    throw new OpenException(iOException, dataSpec, (int) PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, buildRequestWrapper.getStatus());
                } else if (!blockUntilConnectTimeout) {
                    throw new OpenException(new SocketTimeoutException(), dataSpec, (int) PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT, buildRequestWrapper.getStatus());
                } else {
                    UrlResponseInfo urlResponseInfo = (UrlResponseInfo) Assertions.checkNotNull(this.responseInfo);
                    int httpStatusCode = urlResponseInfo.getHttpStatusCode();
                    Map asMap = urlResponseInfo.getHeaders().getAsMap();
                    long j = 0;
                    if (httpStatusCode < 200 || httpStatusCode > 299) {
                        if (httpStatusCode == 416) {
                            if (dataSpec.position == HttpUtil.getDocumentSize(getFirstHeader(asMap, "Content-Range"))) {
                                this.transferStarted = true;
                                transferStarted(dataSpec);
                                if (dataSpec.length != -1) {
                                    return dataSpec.length;
                                }
                                return 0L;
                            }
                        }
                        try {
                            bArr = readResponseBody();
                        } catch (IOException unused) {
                            bArr = Util.EMPTY_BYTE_ARRAY;
                        }
                        throw new HttpDataSource.InvalidResponseCodeException(httpStatusCode, urlResponseInfo.getHttpStatusText(), httpStatusCode == 416 ? new DataSourceException(2008) : null, asMap, dataSpec, bArr);
                    }
                    Predicate<String> predicate = this.contentTypePredicate;
                    if (predicate != null && (firstHeader = getFirstHeader(asMap, "Content-Type")) != null && !predicate.apply(firstHeader)) {
                        throw new HttpDataSource.InvalidContentTypeException(firstHeader, dataSpec);
                    }
                    if (httpStatusCode == 200 && dataSpec.position != 0) {
                        j = dataSpec.position;
                    }
                    if (!isCompressed(urlResponseInfo)) {
                        if (dataSpec.length != -1) {
                            this.bytesRemaining = dataSpec.length;
                        } else {
                            long contentLength = HttpUtil.getContentLength(getFirstHeader(asMap, "Content-Length"), getFirstHeader(asMap, "Content-Range"));
                            this.bytesRemaining = contentLength != -1 ? contentLength - j : -1L;
                        }
                    } else {
                        this.bytesRemaining = dataSpec.length;
                    }
                    this.transferStarted = true;
                    transferStarted(dataSpec);
                    skipFully(j, dataSpec);
                    return this.bytesRemaining;
                }
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
                throw new OpenException(new InterruptedIOException(), dataSpec, 1004, -1);
            }
        } catch (IOException e) {
            if (e instanceof HttpDataSource.HttpDataSourceException) {
                throw ((HttpDataSource.HttpDataSourceException) e);
            }
            throw new OpenException(e, dataSpec, 2000, 0);
        }
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource.HttpDataSourceException {
        Assertions.checkState(this.transferStarted);
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        ByteBuffer orCreateReadBuffer = getOrCreateReadBuffer();
        if (!orCreateReadBuffer.hasRemaining()) {
            this.operation.close();
            orCreateReadBuffer.clear();
            readInternal(orCreateReadBuffer, (DataSpec) Util.castNonNull(this.currentDataSpec));
            if (this.finished) {
                this.bytesRemaining = 0L;
                return -1;
            }
            orCreateReadBuffer.flip();
            Assertions.checkState(orCreateReadBuffer.hasRemaining());
        }
        long j = this.bytesRemaining;
        if (j == -1) {
            j = Long.MAX_VALUE;
        }
        int min = (int) Longs.min(j, orCreateReadBuffer.remaining(), i2);
        orCreateReadBuffer.get(bArr, i, min);
        long j2 = this.bytesRemaining;
        if (j2 != -1) {
            this.bytesRemaining = j2 - min;
        }
        bytesTransferred(min);
        return min;
    }

    public int read(ByteBuffer byteBuffer) throws HttpDataSource.HttpDataSourceException {
        int copyByteBuffer;
        Assertions.checkState(this.transferStarted);
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Passed buffer is not a direct ByteBuffer");
        }
        if (byteBuffer.hasRemaining()) {
            if (this.bytesRemaining == 0) {
                return -1;
            }
            int remaining = byteBuffer.remaining();
            ByteBuffer byteBuffer2 = this.readBuffer;
            if (byteBuffer2 != null && (copyByteBuffer = copyByteBuffer(byteBuffer2, byteBuffer)) != 0) {
                long j = this.bytesRemaining;
                if (j != -1) {
                    this.bytesRemaining = j - copyByteBuffer;
                }
                bytesTransferred(copyByteBuffer);
                return copyByteBuffer;
            }
            this.operation.close();
            readInternal(byteBuffer, (DataSpec) Util.castNonNull(this.currentDataSpec));
            if (this.finished) {
                this.bytesRemaining = 0L;
                return -1;
            }
            Assertions.checkState(remaining > byteBuffer.remaining());
            int remaining2 = remaining - byteBuffer.remaining();
            long j2 = this.bytesRemaining;
            if (j2 != -1) {
                this.bytesRemaining = j2 - remaining2;
            }
            bytesTransferred(remaining2);
            return remaining2;
        }
        return 0;
    }

    @Override // androidx.media3.datasource.DataSource
    public synchronized void close() {
        UrlRequestWrapper urlRequestWrapper = this.currentUrlRequestWrapper;
        if (urlRequestWrapper != null) {
            urlRequestWrapper.close();
            this.currentUrlRequestWrapper = null;
        }
        ByteBuffer byteBuffer = this.readBuffer;
        if (byteBuffer != null) {
            byteBuffer.limit(0);
        }
        this.currentDataSpec = null;
        this.responseInfo = null;
        this.exception = null;
        this.finished = false;
        if (this.transferStarted) {
            this.transferStarted = false;
            transferEnded();
        }
    }

    UrlRequestCallback getCurrentUrlRequestCallback() {
        UrlRequestWrapper urlRequestWrapper = this.currentUrlRequestWrapper;
        if (urlRequestWrapper == null) {
            return null;
        }
        return urlRequestWrapper.getUrlRequestCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UrlRequestWrapper buildRequestWrapper(DataSpec dataSpec) throws IOException {
        UrlRequestCallback urlRequestCallback = new UrlRequestCallback();
        return new UrlRequestWrapper(buildRequestBuilder(dataSpec, urlRequestCallback).build(), urlRequestCallback);
    }

    private UrlRequest.Builder buildRequestBuilder(DataSpec dataSpec, UrlRequest.Callback callback) throws IOException {
        UrlRequest.Builder directExecutorAllowed = this.httpEngine.newUrlRequestBuilder(dataSpec.uri.toString(), this.executor, callback).setPriority(this.requestPriority).setDirectExecutorAllowed(true);
        HashMap hashMap = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.defaultRequestProperties;
        if (requestProperties != null) {
            hashMap.putAll(requestProperties.getSnapshot());
        }
        hashMap.putAll(this.requestProperties.getSnapshot());
        hashMap.putAll(dataSpec.httpRequestHeaders);
        for (Map.Entry entry : hashMap.entrySet()) {
            directExecutorAllowed.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        if (dataSpec.httpBody != null && !hashMap.containsKey("Content-Type")) {
            throw new OpenException("HTTP request with non-empty body must set Content-Type", dataSpec, 1004, 0);
        }
        String buildRangeRequestHeader = HttpUtil.buildRangeRequestHeader(dataSpec.position, dataSpec.length);
        if (buildRangeRequestHeader != null) {
            directExecutorAllowed.addHeader("Range", buildRangeRequestHeader);
        }
        String str = this.userAgent;
        if (str != null) {
            directExecutorAllowed.addHeader("User-Agent", str);
        }
        directExecutorAllowed.setHttpMethod(dataSpec.getHttpMethodString());
        if (dataSpec.httpBody != null) {
            directExecutorAllowed.setUploadDataProvider(new ByteArrayUploadDataProvider(dataSpec.httpBody), this.executor);
        }
        return directExecutorAllowed;
    }

    private boolean blockUntilConnectTimeout() throws InterruptedException {
        long elapsedRealtime = this.clock.elapsedRealtime();
        boolean z = false;
        while (!z && elapsedRealtime < this.currentConnectTimeoutMs) {
            z = this.operation.block((this.currentConnectTimeoutMs - elapsedRealtime) + 5);
            elapsedRealtime = this.clock.elapsedRealtime();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetConnectTimeout() {
        this.currentConnectTimeoutMs = this.clock.elapsedRealtime() + this.connectTimeoutMs;
    }

    private void skipFully(long j, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        if (j == 0) {
            return;
        }
        ByteBuffer orCreateReadBuffer = getOrCreateReadBuffer();
        while (j > 0) {
            try {
                this.operation.close();
                orCreateReadBuffer.clear();
                readInternal(orCreateReadBuffer, dataSpec);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (this.finished) {
                    throw new OpenException(dataSpec, 2008, 14);
                }
                orCreateReadBuffer.flip();
                Assertions.checkState(orCreateReadBuffer.hasRemaining());
                int min = (int) Math.min(orCreateReadBuffer.remaining(), j);
                orCreateReadBuffer.position(orCreateReadBuffer.position() + min);
                j -= min;
            } catch (IOException e) {
                if (e instanceof HttpDataSource.HttpDataSourceException) {
                    throw ((HttpDataSource.HttpDataSourceException) e);
                }
                throw new OpenException(e, dataSpec, e instanceof SocketTimeoutException ? PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT : PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, 14);
            }
        }
    }

    private byte[] readResponseBody() throws IOException {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ByteBuffer orCreateReadBuffer = getOrCreateReadBuffer();
        while (!this.finished) {
            this.operation.close();
            orCreateReadBuffer.clear();
            readInternal(orCreateReadBuffer, (DataSpec) Util.castNonNull(this.currentDataSpec));
            orCreateReadBuffer.flip();
            if (orCreateReadBuffer.remaining() > 0) {
                int length = bArr.length;
                bArr = Arrays.copyOf(bArr, bArr.length + orCreateReadBuffer.remaining());
                orCreateReadBuffer.get(bArr, length, orCreateReadBuffer.remaining());
            }
        }
        return bArr;
    }

    private void readInternal(ByteBuffer byteBuffer, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        ((UrlRequestWrapper) Util.castNonNull(this.currentUrlRequestWrapper)).read(byteBuffer);
        try {
        } catch (InterruptedException unused) {
            if (byteBuffer == this.readBuffer) {
                this.readBuffer = null;
            }
            Thread.currentThread().interrupt();
            this.exception = new InterruptedIOException();
        } catch (SocketTimeoutException e) {
            if (byteBuffer == this.readBuffer) {
                this.readBuffer = null;
            }
            this.exception = new HttpDataSource.HttpDataSourceException(e, dataSpec, (int) PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT, 2);
        }
        if (!this.operation.block(this.readTimeoutMs)) {
            throw new SocketTimeoutException();
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            if (iOException instanceof HttpDataSource.HttpDataSourceException) {
                throw ((HttpDataSource.HttpDataSourceException) iOException);
            }
            throw HttpDataSource.HttpDataSourceException.createForIOException(iOException, dataSpec, 2);
        }
    }

    private ByteBuffer getOrCreateReadBuffer() {
        if (this.readBuffer == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32768);
            this.readBuffer = allocateDirect;
            allocateDirect.limit(0);
        }
        return this.readBuffer;
    }

    private static boolean isCompressed(UrlResponseInfo urlResponseInfo) {
        for (Map.Entry entry : urlResponseInfo.getHeaders().getAsList()) {
            if (((String) entry.getKey()).equalsIgnoreCase(HttpHeaders.CONTENT_ENCODING)) {
                return !((String) entry.getValue()).equalsIgnoreCase("identity");
            }
        }
        return false;
    }

    private static String getFirstHeader(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static int copyByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int min = Math.min(byteBuffer.remaining(), byteBuffer2.remaining());
        int limit = byteBuffer.limit();
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer2.put(byteBuffer);
        byteBuffer.limit(limit);
        return min;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void storeCookiesFromHeaders(UrlResponseInfo urlResponseInfo) {
        storeCookiesFromHeaders(urlResponseInfo, CookieHandler.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void storeCookiesFromHeaders(UrlResponseInfo urlResponseInfo, CookieHandler cookieHandler) {
        if (cookieHandler == null) {
            return;
        }
        try {
            cookieHandler.put(new URI(urlResponseInfo.getUrl()), urlResponseInfo.getHeaders().getAsMap());
        } catch (Exception e) {
            Log.w(TAG, "Failed to store cookies in CookieHandler", e);
        }
    }

    static String getCookieHeader(String str) {
        return getCookieHeader(str, ImmutableMap.of(), CookieHandler.getDefault());
    }

    static String getCookieHeader(String str, CookieHandler cookieHandler) {
        return getCookieHeader(str, ImmutableMap.of(), cookieHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCookieHeader(String str, Map<String, List<String>> map, CookieHandler cookieHandler) {
        List<String> list;
        if (cookieHandler == null) {
            return "";
        }
        Map<String, List<String>> of = ImmutableMap.of();
        try {
            of = cookieHandler.get(new URI(str), map);
        } catch (Exception e) {
            Log.w(TAG, "Failed to read cookies from CookieHandler", e);
        }
        StringBuilder sb = new StringBuilder();
        if (of.containsKey(HttpHeaders.COOKIE) && (list = of.get(HttpHeaders.COOKIE)) != null) {
            for (String str2 : list) {
                sb.append(str2).append("; ");
            }
        }
        return UByte$$ExternalSyntheticBackport0.m(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class UrlRequestWrapper {
        private final UrlRequest urlRequest;
        private final UrlRequestCallback urlRequestCallback;

        UrlRequestWrapper(UrlRequest urlRequest, UrlRequestCallback urlRequestCallback) {
            this.urlRequest = urlRequest;
            this.urlRequestCallback = urlRequestCallback;
        }

        public void start() {
            this.urlRequest.start();
        }

        public void read(ByteBuffer byteBuffer) {
            this.urlRequest.read(byteBuffer);
        }

        public void close() {
            this.urlRequestCallback.close();
            this.urlRequest.cancel();
        }

        public UrlRequestCallback getUrlRequestCallback() {
            return this.urlRequestCallback;
        }

        public int getStatus() throws InterruptedException {
            final ConditionVariable conditionVariable = new ConditionVariable();
            final int[] iArr = new int[1];
            this.urlRequest.getStatus(new UrlRequest.StatusListener() { // from class: androidx.media3.datasource.HttpEngineDataSource.UrlRequestWrapper.1
                public void onStatus(int i) {
                    iArr[0] = i;
                    conditionVariable.open();
                }
            });
            conditionVariable.block();
            return iArr[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class UrlRequestCallback implements UrlRequest.Callback {
        private volatile boolean isClosed = false;

        UrlRequestCallback() {
        }

        public void close() {
            this.isClosed = true;
        }

        public synchronized void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            DataSpec withUri;
            if (this.isClosed) {
                return;
            }
            DataSpec dataSpec = (DataSpec) Assertions.checkNotNull(HttpEngineDataSource.this.currentDataSpec);
            int httpStatusCode = urlResponseInfo.getHttpStatusCode();
            if (dataSpec.httpMethod != 2 || (httpStatusCode != 307 && httpStatusCode != 308)) {
                if (HttpEngineDataSource.this.resetTimeoutOnRedirects) {
                    HttpEngineDataSource.this.resetConnectTimeout();
                }
                CookieHandler cookieHandler = CookieHandler.getDefault();
                if (cookieHandler == null && HttpEngineDataSource.this.handleSetCookieRequests) {
                    cookieHandler = new CookieManager();
                }
                HttpEngineDataSource.storeCookiesFromHeaders(urlResponseInfo, cookieHandler);
                String cookieHeader = HttpEngineDataSource.getCookieHeader(urlResponseInfo.getUrl(), urlResponseInfo.getHeaders().getAsMap(), cookieHandler);
                boolean z = HttpEngineDataSource.this.keepPostFor302Redirects && dataSpec.httpMethod == 2 && httpStatusCode == 302;
                if (!z && (!HttpEngineDataSource.this.handleSetCookieRequests || TextUtils.isEmpty(cookieHeader))) {
                    urlRequest.followRedirect();
                    return;
                }
                urlRequest.cancel();
                if (!z && dataSpec.httpMethod == 2) {
                    withUri = dataSpec.buildUpon().setUri(str).setHttpMethod(1).setHttpBody(null).build();
                } else {
                    withUri = dataSpec.withUri(Uri.parse(str));
                }
                if (!TextUtils.isEmpty(cookieHeader)) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(dataSpec.httpRequestHeaders);
                    hashMap.put(HttpHeaders.COOKIE, cookieHeader);
                    withUri = withUri.buildUpon().setHttpRequestHeaders(hashMap).build();
                }
                try {
                    UrlRequestWrapper buildRequestWrapper = HttpEngineDataSource.this.buildRequestWrapper(withUri);
                    if (HttpEngineDataSource.this.currentUrlRequestWrapper != null) {
                        HttpEngineDataSource.this.currentUrlRequestWrapper.close();
                    }
                    HttpEngineDataSource.this.currentUrlRequestWrapper = buildRequestWrapper;
                    HttpEngineDataSource.this.currentUrlRequestWrapper.start();
                    return;
                } catch (IOException e) {
                    HttpEngineDataSource.this.exception = e;
                    return;
                }
            }
            HttpEngineDataSource.this.exception = new HttpDataSource.InvalidResponseCodeException(httpStatusCode, urlResponseInfo.getHttpStatusText(), null, urlResponseInfo.getHeaders().getAsMap(), dataSpec, Util.EMPTY_BYTE_ARRAY);
            HttpEngineDataSource.this.operation.open();
        }

        public synchronized void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (this.isClosed) {
                return;
            }
            HttpEngineDataSource.storeCookiesFromHeaders(urlResponseInfo);
            HttpEngineDataSource.this.responseInfo = urlResponseInfo;
            HttpEngineDataSource.this.operation.open();
        }

        public synchronized void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            if (this.isClosed) {
                return;
            }
            HttpEngineDataSource.this.operation.open();
        }

        public synchronized void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (this.isClosed) {
                return;
            }
            HttpEngineDataSource.this.finished = true;
            HttpEngineDataSource.this.operation.open();
        }

        public synchronized void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, HttpException httpException) {
            if (this.isClosed) {
                return;
            }
            if (!(httpException instanceof NetworkException) || ((NetworkException) httpException).getErrorCode() != 1) {
                HttpEngineDataSource.this.exception = httpException;
            } else {
                HttpEngineDataSource.this.exception = new UnknownHostException();
            }
            HttpEngineDataSource.this.operation.open();
        }

        public synchronized void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }
    }
}
