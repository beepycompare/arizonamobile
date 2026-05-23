package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import kotlin.io.CloseableKt;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.bb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0144bb implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f905a;
    public final String b = "huawei";

    public C0144bb(Context context) {
        this.f905a = context;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.b;
    }

    public static final void a(Dg dg, C0144bb c0144bb) {
        Lg jg;
        Cursor query;
        Context context = c0144bb.f905a;
        try {
            query = context.getContentResolver().query(Uri.parse("content://com.huawei.appmarket.commondata/item/5"), null, null, new String[]{context.getPackageName()}, null);
        } catch (Throwable th) {
            jg = new Jg("Failed to get referrer from huawei content provider", th);
        }
        if (query != null) {
            if (query.moveToFirst()) {
                String string = query.getString(0);
                if (string != null && !StringsKt.isBlank(string)) {
                    jg = new Kg(new Bg(string, query.getLong(1), query.getLong(2), 3));
                    CloseableKt.closeFinally(query, null);
                    dg.a(jg);
                    return;
                }
                throw new IllegalStateException("Referrer is empty".toString());
            }
            throw new IllegalStateException("Cursor is empty".toString());
        }
        throw new IllegalStateException("Not found content provider".toString());
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final void a(final Dg dg) {
        Mk mk = Na.I.d;
        Runnable runnable = new Runnable() { // from class: io.appmetrica.analytics.impl.bb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0144bb.a(Dg.this, this);
            }
        };
        mk.f667a.getClass();
        new InterruptionSafeThread(runnable, "IAA-SHMSR-" + Zd.f870a.incrementAndGet()).start();
    }
}
