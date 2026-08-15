package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import kotlin.io.CloseableKt;
import kotlin.text.StringsKt;
/* renamed from: io.appmetrica.analytics.impl.bb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0143bb implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f908a;
    public final String b = "huawei";

    public C0143bb(Context context) {
        this.f908a = context;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.b;
    }

    public static final void a(Dg dg, C0143bb c0143bb) {
        Lg jg;
        Cursor query;
        Context context = c0143bb.f908a;
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
                C0143bb.a(Dg.this, this);
            }
        };
        mk.f670a.getClass();
        new InterruptionSafeThread(runnable, "IAA-SHMSR-" + Zd.f873a.incrementAndGet()).start();
    }
}
