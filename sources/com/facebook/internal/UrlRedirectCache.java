package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class UrlRedirectCache {
    private static volatile FileLruCache urlRedirectCache;
    static final String TAG = "UrlRedirectCache";
    private static final String REDIRECT_CONTENT_TAG = String.valueOf(TAG) + "_Redirect";

    UrlRedirectCache() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cacheUriRedirect(Context context, URI uri, URI uri2) {
        if (uri == null || uri2 == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = getCache(context).openPutStream(uri.toString(), REDIRECT_CONTENT_TAG);
            outputStream.write(uri2.toString().getBytes());
        } catch (IOException unused) {
        } finally {
            Utility.closeQuietly(outputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearCache(Context context) {
        try {
            getCache(context).clearCache();
        } catch (IOException e) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e.getMessage());
        }
    }

    static FileLruCache getCache(Context context) throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            try {
                if (urlRedirectCache == null) {
                    urlRedirectCache = new FileLruCache(context.getApplicationContext(), TAG, new FileLruCache.Limits());
                }
                fileLruCache = urlRedirectCache;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fileLruCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static URI getRedirectedUri(Context context, URI uri) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        try {
            FileLruCache cache = getCache(context);
            inputStreamReader = null;
            boolean z = false;
            while (true) {
                try {
                    InputStream inputStream = cache.get(uri2, REDIRECT_CONTENT_TAG);
                    if (inputStream == null) {
                        break;
                    }
                    InputStreamReader inputStreamReader3 = new InputStreamReader(inputStream);
                    try {
                        char[] cArr = new char[128];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int read = inputStreamReader3.read(cArr, 0, 128);
                            if (read <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, read);
                        }
                        Utility.closeQuietly(inputStreamReader3);
                        inputStreamReader = inputStreamReader3;
                        uri2 = sb.toString();
                        z = true;
                    } catch (IOException unused) {
                        inputStreamReader = inputStreamReader3;
                        Utility.closeQuietly(inputStreamReader);
                        return null;
                    } catch (URISyntaxException unused2) {
                        inputStreamReader = inputStreamReader3;
                        Utility.closeQuietly(inputStreamReader);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader2 = inputStreamReader3;
                        inputStreamReader = inputStreamReader2;
                        Utility.closeQuietly(inputStreamReader);
                        throw th;
                    }
                } catch (IOException unused3) {
                } catch (URISyntaxException unused4) {
                } catch (Throwable th2) {
                    th = th2;
                    Utility.closeQuietly(inputStreamReader);
                    throw th;
                }
            }
            if (!z) {
                Utility.closeQuietly(inputStreamReader);
                return null;
            }
            URI uri3 = new URI(uri2);
            Utility.closeQuietly(inputStreamReader);
            return uri3;
        } catch (IOException unused5) {
            inputStreamReader = null;
        } catch (URISyntaxException unused6) {
            inputStreamReader = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
