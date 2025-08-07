package io.appmetrica.analytics.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.impl.AbstractC0589sj;
import io.appmetrica.analytics.impl.C0635uf;
import io.appmetrica.analytics.impl.C0660vf;
import io.appmetrica.analytics.impl.C0755za;
import io.appmetrica.analytics.impl.L3;
import io.appmetrica.analytics.impl.M3;
import io.appmetrica.analytics.impl.W5;
import io.appmetrica.analytics.impl.X5;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes4.dex */
public class PreloadInfoContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1181a = false;
    private final UriMatcher b = new UriMatcher(-1);

    private void a(X5 x5, ContentValues contentValues) {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            try {
                Object invoke = x5.f713a.invoke(contentValues);
                if (invoke != null) {
                    x5.c.b(applicationContext);
                    if (((Boolean) x5.b.invoke(invoke)).booleanValue()) {
                        AbstractC0589sj.a("Successfully saved " + x5.d, new Object[0]);
                    } else {
                        AbstractC0589sj.a("Did not save " + x5.d + " because data is already present", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Unexpected error occurred", new Object[0]) + "\n" + StringUtils.throwableToString(th), new Object[0]);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        AbstractC0589sj.a("Deleting is not supported", new Object[0]);
        return -1;
    }

    public synchronized void disable() {
        this.f1181a = true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        synchronized (this) {
            if (this.f1181a) {
                return null;
            }
            if (contentValues != null) {
                int match = this.b.match(uri);
                if (match == 1) {
                    a(new X5(new C0635uf(), new C0660vf(), C0755za.d, "preload info"), contentValues);
                } else if (match != 2) {
                    AbstractC0589sj.a("Bad content provider uri.", new Object[0]);
                } else {
                    a(new X5(new L3(), new M3(), C0755za.d, "clids"), contentValues);
                }
            }
            CountDownLatch countDownLatch = W5.f695a;
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
        W5.f695a = new CountDownLatch(1);
        W5.b = this;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AbstractC0589sj.a("Query is not supported", new Object[0]);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AbstractC0589sj.a("Updating is not supported", new Object[0]);
        return -1;
    }
}
