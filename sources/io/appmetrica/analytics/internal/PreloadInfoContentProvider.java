package io.appmetrica.analytics.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.impl.Af;
import io.appmetrica.analytics.impl.Bf;
import io.appmetrica.analytics.impl.Bj;
import io.appmetrica.analytics.impl.C0115a6;
import io.appmetrica.analytics.impl.Ea;
import io.appmetrica.analytics.impl.O3;
import io.appmetrica.analytics.impl.P3;
import io.appmetrica.analytics.impl.Z5;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes4.dex */
public class PreloadInfoContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1200a = false;
    private final UriMatcher b = new UriMatcher(-1);

    private void a(C0115a6 c0115a6, ContentValues contentValues) {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            try {
                Object invoke = c0115a6.f786a.invoke(contentValues);
                if (invoke != null) {
                    c0115a6.c.b(applicationContext);
                    if (((Boolean) c0115a6.b.invoke(invoke)).booleanValue()) {
                        Bj.a("Successfully saved " + c0115a6.d, new Object[0]);
                    } else {
                        Bj.a("Did not save " + c0115a6.d + " because data is already present", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Unexpected error occurred", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Bj.a("Deleting is not supported", new Object[0]);
        return -1;
    }

    public synchronized void disable() {
        this.f1200a = true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        synchronized (this) {
            if (this.f1200a) {
                return null;
            }
            if (contentValues != null) {
                int match = this.b.match(uri);
                if (match == 1) {
                    a(new C0115a6(new Af(), new Bf(), Ea.d, "preload info"), contentValues);
                } else if (match != 2) {
                    Bj.a("Bad content provider uri.", new Object[0]);
                } else {
                    a(new C0115a6(new O3(), new P3(), Ea.d, "clids"), contentValues);
                }
            }
            CountDownLatch countDownLatch = Z5.f769a;
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
        Z5.f769a = new CountDownLatch(1);
        Z5.b = this;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Bj.a("Query is not supported", new Object[0]);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Bj.a("Updating is not supported", new Object[0]);
        return -1;
    }
}
