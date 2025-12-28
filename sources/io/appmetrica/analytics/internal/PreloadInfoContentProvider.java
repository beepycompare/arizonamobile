package io.appmetrica.analytics.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.impl.AbstractC0275gj;
import io.appmetrica.analytics.impl.B5;
import io.appmetrica.analytics.impl.C0240fa;
import io.appmetrica.analytics.impl.C0297hf;
import io.appmetrica.analytics.impl.C0513q3;
import io.appmetrica.analytics.impl.C0537r3;
import io.appmetrica.analytics.impl.C5;
import io.appmetrica.analytics.impl.Cif;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public class PreloadInfoContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1339a = false;
    private final UriMatcher b = new UriMatcher(-1);

    private void a(C5 c5, ContentValues contentValues) {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            try {
                Object invoke = c5.f521a.invoke(contentValues);
                if (invoke != null) {
                    c5.c.b(applicationContext);
                    if (((Boolean) c5.b.invoke(invoke)).booleanValue()) {
                        AbstractC0275gj.a("Successfully saved " + c5.d, new Object[0]);
                    } else {
                        AbstractC0275gj.a("Did not save " + c5.d + " because data is already present", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Unexpected error occurred", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        AbstractC0275gj.a("Deleting is not supported", new Object[0]);
        return -1;
    }

    public synchronized void disable() {
        this.f1339a = true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        synchronized (this) {
            if (this.f1339a) {
                return null;
            }
            if (contentValues != null) {
                int match = this.b.match(uri);
                if (match == 1) {
                    a(new C5(new C0297hf(), new Cif(), C0240fa.d, "preload info"), contentValues);
                } else if (match != 2) {
                    AbstractC0275gj.a("Bad content provider uri.", new Object[0]);
                } else {
                    a(new C5(new C0513q3(), new C0537r3(), C0240fa.d, "clids"), contentValues);
                }
            }
            CountDownLatch countDownLatch = B5.f504a;
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
        B5.f504a = new CountDownLatch(1);
        B5.b = this;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AbstractC0275gj.a("Query is not supported", new Object[0]);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AbstractC0275gj.a("Updating is not supported", new Object[0]);
        return -1;
    }
}
