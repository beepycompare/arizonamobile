package io.appmetrica.analytics.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.impl.AbstractC0379kj;
import io.appmetrica.analytics.impl.C0396la;
import io.appmetrica.analytics.impl.C0401lf;
import io.appmetrica.analytics.impl.C0426mf;
import io.appmetrica.analytics.impl.C0688x3;
import io.appmetrica.analytics.impl.C0713y3;
import io.appmetrica.analytics.impl.H5;
import io.appmetrica.analytics.impl.I5;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public class PreloadInfoContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1242a = false;
    private final UriMatcher b = new UriMatcher(-1);

    private void a(I5 i5, ContentValues contentValues) {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            try {
                Object invoke = i5.f520a.invoke(contentValues);
                if (invoke != null) {
                    i5.c.b(applicationContext);
                    if (((Boolean) i5.b.invoke(invoke)).booleanValue()) {
                        AbstractC0379kj.a("Successfully saved " + i5.d, new Object[0]);
                    } else {
                        AbstractC0379kj.a("Did not save " + i5.d + " because data is already present", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Unexpected error occurred", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        AbstractC0379kj.a("Deleting is not supported", new Object[0]);
        return -1;
    }

    public synchronized void disable() {
        this.f1242a = true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        synchronized (this) {
            if (this.f1242a) {
                return null;
            }
            if (contentValues != null) {
                int match = this.b.match(uri);
                if (match == 1) {
                    a(new I5(new C0401lf(), new C0426mf(), C0396la.d, "preload info"), contentValues);
                } else if (match != 2) {
                    AbstractC0379kj.a("Bad content provider uri.", new Object[0]);
                } else {
                    a(new I5(new C0688x3(), new C0713y3(), C0396la.d, "clids"), contentValues);
                }
            }
            CountDownLatch countDownLatch = H5.f502a;
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
        H5.f502a = new CountDownLatch(1);
        H5.b = this;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AbstractC0379kj.a("Query is not supported", new Object[0]);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AbstractC0379kj.a("Updating is not supported", new Object[0]);
        return -1;
    }
}
