package io.appmetrica.analytics.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.impl.A5;
import io.appmetrica.analytics.impl.AbstractC0253fj;
import io.appmetrica.analytics.impl.B5;
import io.appmetrica.analytics.impl.C0218ea;
import io.appmetrica.analytics.impl.C0275gf;
import io.appmetrica.analytics.impl.C0301hf;
import io.appmetrica.analytics.impl.C0491p3;
import io.appmetrica.analytics.impl.C0516q3;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public class PreloadInfoContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1346a = false;
    private final UriMatcher b = new UriMatcher(-1);

    private void a(B5 b5, ContentValues contentValues) {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            try {
                Object invoke = b5.f516a.invoke(contentValues);
                if (invoke != null) {
                    b5.c.b(applicationContext);
                    if (((Boolean) b5.b.invoke(invoke)).booleanValue()) {
                        AbstractC0253fj.a("Successfully saved " + b5.d, new Object[0]);
                    } else {
                        AbstractC0253fj.a("Did not save " + b5.d + " because data is already present", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Unexpected error occurred", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        AbstractC0253fj.a("Deleting is not supported", new Object[0]);
        return -1;
    }

    public synchronized void disable() {
        this.f1346a = true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        synchronized (this) {
            if (this.f1346a) {
                return null;
            }
            if (contentValues != null) {
                int match = this.b.match(uri);
                if (match == 1) {
                    a(new B5(new C0275gf(), new C0301hf(), C0218ea.d, "preload info"), contentValues);
                } else if (match != 2) {
                    AbstractC0253fj.a("Bad content provider uri.", new Object[0]);
                } else {
                    a(new B5(new C0491p3(), new C0516q3(), C0218ea.d, "clids"), contentValues);
                }
            }
            CountDownLatch countDownLatch = A5.f499a;
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
        A5.f499a = new CountDownLatch(1);
        A5.b = this;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AbstractC0253fj.a("Query is not supported", new Object[0]);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AbstractC0253fj.a("Updating is not supported", new Object[0]);
        return -1;
    }
}
