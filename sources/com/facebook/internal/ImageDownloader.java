package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookException;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static Handler handler;
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class CacheReadWorkItem implements Runnable {
        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        CacheReadWorkItem(Context context, RequestKey requestKey, boolean z) {
            this.context = context;
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DownloadImageWorkItem implements Runnable {
        private Context context;
        private RequestKey key;

        DownloadImageWorkItem(Context context, RequestKey requestKey) {
            this.context = context;
            this.key = requestKey;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageDownloader.download(this.key, this.context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DownloaderContext {
        boolean isCancelled;
        ImageRequest request;
        WorkQueue.WorkItem workItem;

        private DownloaderContext() {
        }

        /* synthetic */ DownloaderContext(DownloaderContext downloaderContext) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class RequestKey {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        Object tag;
        URI uri;

        RequestKey(URI uri, Object obj) {
            this.uri = uri;
            this.tag = obj;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof RequestKey)) {
                RequestKey requestKey = (RequestKey) obj;
                if (requestKey.uri == this.uri && requestKey.tag == this.tag) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((this.uri.hashCode() + 1073) * 37) + this.tag.hashCode();
        }
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            if (downloaderContext != null) {
                z = true;
                if (downloaderContext.workItem.cancel()) {
                    map.remove(requestKey);
                } else {
                    downloaderContext.isCancelled = true;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public static void clearCache(Context context) {
        ImageResponseCache.clearCache(context);
        UrlRedirectCache.clearCache(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void download(RequestKey requestKey, Context context) {
        HttpURLConnection httpURLConnection;
        FacebookException facebookException;
        int responseCode;
        Bitmap decodeStream;
        Closeable closeable = null;
        InputStream inputStream = null;
        closeable = null;
        Bitmap bitmap = null;
        boolean z = true;
        try {
            httpURLConnection = (HttpURLConnection) new URL(requestKey.uri.toString()).openConnection();
            try {
                try {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    responseCode = httpURLConnection.getResponseCode();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            } catch (URISyntaxException e2) {
                e = e2;
            }
            try {
                if (responseCode == 200) {
                    InputStream interceptAndCacheImageStream = ImageResponseCache.interceptAndCacheImageStream(context, httpURLConnection);
                    decodeStream = BitmapFactory.decodeStream(interceptAndCacheImageStream);
                    inputStream = interceptAndCacheImageStream;
                    facebookException = null;
                } else if (responseCode == 301 || responseCode == 302) {
                    try {
                        String headerField = httpURLConnection.getHeaderField(FirebaseAnalytics.Param.LOCATION);
                        if (!Utility.isNullOrEmpty(headerField)) {
                            URI uri = new URI(headerField);
                            UrlRedirectCache.cacheUriRedirect(context, requestKey.uri, uri);
                            DownloaderContext removePendingRequest = removePendingRequest(requestKey);
                            if (removePendingRequest != null && !removePendingRequest.isCancelled) {
                                enqueueCacheRead(removePendingRequest.request, new RequestKey(uri, requestKey.tag), false);
                            }
                        }
                        z = false;
                        facebookException = null;
                        decodeStream = null;
                    } catch (IOException e3) {
                        e = e3;
                        z = false;
                        context = 0;
                        Utility.closeQuietly(context);
                        Utility.disconnectQuietly(httpURLConnection);
                        facebookException = e;
                        if (z) {
                        }
                    } catch (URISyntaxException e4) {
                        e = e4;
                        z = false;
                        context = 0;
                        Utility.closeQuietly(context);
                        Utility.disconnectQuietly(httpURLConnection);
                        facebookException = e;
                        if (z) {
                        }
                    }
                } else {
                    InputStream errorStream = httpURLConnection.getErrorStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
                    char[] cArr = new char[128];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = inputStreamReader.read(cArr, 0, 128);
                        if (read <= 0) {
                            break;
                        }
                        sb.append(cArr, 0, read);
                    }
                    Utility.closeQuietly(inputStreamReader);
                    inputStream = errorStream;
                    facebookException = new FacebookException(sb.toString());
                    decodeStream = null;
                }
                Utility.closeQuietly(inputStream);
                Utility.disconnectQuietly(httpURLConnection);
                bitmap = decodeStream;
            } catch (IOException e5) {
                e = e5;
                Utility.closeQuietly(context);
                Utility.disconnectQuietly(httpURLConnection);
                facebookException = e;
                if (z) {
                }
            } catch (URISyntaxException e6) {
                e = e6;
                Utility.closeQuietly(context);
                Utility.disconnectQuietly(httpURLConnection);
                facebookException = e;
                if (z) {
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = context;
                Utility.closeQuietly(closeable);
                Utility.disconnectQuietly(httpURLConnection);
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            context = 0;
            httpURLConnection = null;
            Utility.closeQuietly(context);
            Utility.disconnectQuietly(httpURLConnection);
            facebookException = e;
            if (z) {
            }
        } catch (URISyntaxException e8) {
            e = e8;
            context = 0;
            httpURLConnection = null;
            Utility.closeQuietly(context);
            Utility.disconnectQuietly(httpURLConnection);
            facebookException = e;
            if (z) {
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
        if (z) {
            issueResponse(requestKey, facebookException, bitmap, false);
        }
    }

    public static void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.request = imageRequest;
                downloaderContext.isCancelled = false;
                downloaderContext.workItem.moveToFront();
            } else {
                enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
            }
        }
    }

    private static void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(imageRequest.getContext(), requestKey, z));
    }

    private static void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(imageRequest.getContext(), requestKey));
    }

    private static void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = new DownloaderContext(null);
            downloaderContext.request = imageRequest;
            map.put(requestKey, downloaderContext);
            downloaderContext.workItem = workQueue.addActiveWorkItem(runnable);
        }
    }

    private static Handler getHandler() {
        Handler handler2;
        synchronized (ImageDownloader.class) {
            try {
                if (handler == null) {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler2 = handler;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler2;
    }

    private static void issueResponse(RequestKey requestKey, final Exception exc, final Bitmap bitmap, final boolean z) {
        final ImageRequest imageRequest;
        final ImageRequest.Callback callback;
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest == null || removePendingRequest.isCancelled || (callback = (imageRequest = removePendingRequest.request).getCallback()) == null) {
            return;
        }
        getHandler().post(new Runnable() { // from class: com.facebook.internal.ImageDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                callback.onCompleted(new ImageResponse(ImageRequest.this, exc, z, bitmap));
            }
        });
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.workItem.moveToFront();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readFromCache(RequestKey requestKey, Context context, boolean z) {
        InputStream inputStream;
        URI redirectedUri;
        boolean z2 = false;
        if (!z || (redirectedUri = UrlRedirectCache.getRedirectedUri(context, requestKey.uri)) == null) {
            inputStream = null;
        } else {
            inputStream = ImageResponseCache.getCachedImageStream(redirectedUri, context);
            if (inputStream != null) {
                z2 = true;
            }
        }
        if (!z2) {
            inputStream = ImageResponseCache.getCachedImageStream(requestKey.uri, context);
        }
        if (inputStream != null) {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            Utility.closeQuietly(inputStream);
            issueResponse(requestKey, null, decodeStream, z2);
            return;
        }
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest == null || removePendingRequest.isCancelled) {
            return;
        }
        enqueueDownload(removePendingRequest.request, requestKey);
    }

    private static DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext remove;
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            remove = map.remove(requestKey);
        }
        return remove;
    }
}
