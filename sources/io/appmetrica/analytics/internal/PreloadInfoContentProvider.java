package io.appmetrica.analytics.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.impl.Ba;
import io.appmetrica.analytics.impl.G3;
import io.appmetrica.analytics.impl.Gf;
import io.appmetrica.analytics.impl.Gj;
import io.appmetrica.analytics.impl.H3;
import io.appmetrica.analytics.impl.Hf;
import io.appmetrica.analytics.impl.Q5;
import io.appmetrica.analytics.impl.R5;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public class PreloadInfoContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1328a = false;
    private final UriMatcher b = new UriMatcher(-1);

    private void a(R5 r5, ContentValues contentValues) {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            try {
                Object invoke = r5.f743a.invoke(contentValues);
                if (invoke != null) {
                    r5.c.b(applicationContext);
                    if (((Boolean) r5.b.invoke(invoke)).booleanValue()) {
                        Gj.a("Successfully saved " + r5.d, new Object[0]);
                    } else {
                        Gj.a("Did not save " + r5.d + " because data is already present", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Unexpected error occurred", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Gj.a("Deleting is not supported", new Object[0]);
        return -1;
    }

    public synchronized void disable() {
        this.f1328a = true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        synchronized (this) {
            if (this.f1328a) {
                return null;
            }
            if (contentValues != null) {
                int match = this.b.match(uri);
                if (match == 1) {
                    a(new R5(new Gf(), new Hf(), Ba.d, "preload info"), contentValues);
                } else if (match != 2) {
                    Gj.a("Bad content provider uri.", new Object[0]);
                } else {
                    a(new R5(new G3(), new H3(), Ba.d, "clids"), contentValues);
                }
            }
            CountDownLatch countDownLatch = Q5.f728a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String str;
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            str = applicationContext.getPackageName();
        } else {
            str = "";
        }
        String str2 = str + ".appmetrica.preloadinfo.retail";
        this.b.addURI(str2, "preloadinfo", 1);
        this.b.addURI(str2, "clids", 2);
        Q5.f728a = new CountDownLatch(1);
        Q5.b = this;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Gj.a("Query is not supported", new Object[0]);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Gj.a("Updating is not supported", new Object[0]);
        return -1;
    }
}
