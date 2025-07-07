package com.facebook.android;

import android.content.Context;
import android.os.Bundle;
import coil3.network.internal.UtilsKt;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
@Deprecated
/* loaded from: classes3.dex */
public class AsyncFacebookRunner {
    Facebook fb;

    @Deprecated
    /* loaded from: classes3.dex */
    public interface RequestListener {
        void onComplete(String str, Object obj);

        void onFacebookError(FacebookError facebookError, Object obj);

        void onFileNotFoundException(FileNotFoundException fileNotFoundException, Object obj);

        void onIOException(IOException iOException, Object obj);

        void onMalformedURLException(MalformedURLException malformedURLException, Object obj);
    }

    public AsyncFacebookRunner(Facebook facebook) {
        this.fb = facebook;
    }

    @Deprecated
    public void logout(Context context, RequestListener requestListener) {
        logout(context, requestListener, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.android.AsyncFacebookRunner$1] */
    @Deprecated
    public void logout(final Context context, final RequestListener requestListener, final Object obj) {
        new Thread() { // from class: com.facebook.android.AsyncFacebookRunner.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    String logoutImpl = AsyncFacebookRunner.this.fb.logoutImpl(context);
                    if (logoutImpl.length() != 0 && !logoutImpl.equals("false")) {
                        requestListener.onComplete(logoutImpl, obj);
                        return;
                    }
                    requestListener.onFacebookError(new FacebookError("auth.expireSession failed"), obj);
                } catch (FileNotFoundException e) {
                    requestListener.onFileNotFoundException(e, obj);
                } catch (MalformedURLException e2) {
                    requestListener.onMalformedURLException(e2, obj);
                } catch (IOException e3) {
                    requestListener.onIOException(e3, obj);
                }
            }
        }.start();
    }

    @Deprecated
    public void request(Bundle bundle, RequestListener requestListener) {
        request(null, bundle, UtilsKt.HTTP_METHOD_GET, requestListener, null);
    }

    @Deprecated
    public void request(Bundle bundle, RequestListener requestListener, Object obj) {
        request(null, bundle, UtilsKt.HTTP_METHOD_GET, requestListener, obj);
    }

    @Deprecated
    public void request(String str, Bundle bundle, RequestListener requestListener) {
        request(str, bundle, UtilsKt.HTTP_METHOD_GET, requestListener, null);
    }

    @Deprecated
    public void request(String str, Bundle bundle, RequestListener requestListener, Object obj) {
        request(str, bundle, UtilsKt.HTTP_METHOD_GET, requestListener, obj);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.android.AsyncFacebookRunner$2] */
    @Deprecated
    public void request(final String str, final Bundle bundle, final String str2, final RequestListener requestListener, final Object obj) {
        new Thread() { // from class: com.facebook.android.AsyncFacebookRunner.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    requestListener.onComplete(AsyncFacebookRunner.this.fb.requestImpl(str, bundle, str2), obj);
                } catch (FileNotFoundException e) {
                    requestListener.onFileNotFoundException(e, obj);
                } catch (MalformedURLException e2) {
                    requestListener.onMalformedURLException(e2, obj);
                } catch (IOException e3) {
                    requestListener.onIOException(e3, obj);
                }
            }
        }.start();
    }

    @Deprecated
    public void request(String str, RequestListener requestListener) {
        request(str, new Bundle(), UtilsKt.HTTP_METHOD_GET, requestListener, null);
    }

    @Deprecated
    public void request(String str, RequestListener requestListener, Object obj) {
        request(str, new Bundle(), UtilsKt.HTTP_METHOD_GET, requestListener, obj);
    }
}
