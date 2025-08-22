package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* renamed from: io.appmetrica.analytics.impl.wc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0679wc implements U6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1121a;
    public final String b;
    public final C0441mn c;
    public final C0652va d;
    public C0624u7 e;

    public C0679wc(Context context, String str, C0441mn c0441mn) {
        this(context, str, new C0652va(str), c0441mn);
    }

    @Override // io.appmetrica.analytics.impl.U6
    public final synchronized SQLiteDatabase a() {
        C0624u7 c0624u7;
        try {
            this.d.a();
            c0624u7 = new C0624u7(this.f1121a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c0624u7;
        } catch (Throwable unused) {
            return null;
        }
        return c0624u7.getWritableDatabase();
    }

    public C0679wc(Context context, String str, C0652va c0652va, C0441mn c0441mn) {
        this.f1121a = context;
        this.b = str;
        this.d = c0652va;
        this.c = c0441mn;
    }

    @Override // io.appmetrica.analytics.impl.U6
    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        no.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
