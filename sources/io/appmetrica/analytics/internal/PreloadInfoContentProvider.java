package io.appmetrica.analytics.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.impl.AbstractC0520pj;
import io.appmetrica.analytics.impl.C0590sf;
import io.appmetrica.analytics.impl.C0615tf;
import io.appmetrica.analytics.impl.C0710xa;
import io.appmetrica.analytics.impl.L3;
import io.appmetrica.analytics.impl.M3;
import io.appmetrica.analytics.impl.T5;
import io.appmetrica.analytics.impl.U5;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes4.dex */
public class PreloadInfoContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1177a = false;
    private final UriMatcher b = new UriMatcher(-1);

    private void a(U5 u5, ContentValues contentValues) {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            try {
                Object invoke = u5.f653a.invoke(contentValues);
                if (invoke != null) {
                    u5.c.b(applicationContext);
                    if (((Boolean) u5.b.invoke(invoke)).booleanValue()) {
                        AbstractC0520pj.a("Successfully saved " + u5.d, new Object[0]);
                    } else {
                        AbstractC0520pj.a("Did not save " + u5.d + " because data is already present", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Unexpected error occurred", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        AbstractC0520pj.a("Deleting is not supported", new Object[0]);
        return -1;
    }

    public synchronized void disable() {
        this.f1177a = true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        synchronized (this) {
            if (this.f1177a) {
                return null;
            }
            if (contentValues != null) {
                int match = this.b.match(uri);
                if (match == 1) {
                    a(new U5(new C0590sf(), new C0615tf(), C0710xa.d, "preload info"), contentValues);
                } else if (match != 2) {
                    AbstractC0520pj.a("Bad content provider uri.", new Object[0]);
                } else {
                    a(new U5(new L3(), new M3(), C0710xa.d, "clids"), contentValues);
                }
            }
            CountDownLatch countDownLatch = T5.f634a;
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
        T5.f634a = new CountDownLatch(1);
        T5.b = this;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AbstractC0520pj.a("Query is not supported", new Object[0]);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AbstractC0520pj.a("Updating is not supported", new Object[0]);
        return -1;
    }
}
