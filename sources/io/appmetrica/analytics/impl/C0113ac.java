package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* renamed from: io.appmetrica.analytics.impl.ac  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0113ac implements InterfaceC0740z6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f880a;
    public final String b;
    public final C0356jn c;
    public final Z9 d;
    public Z6 e;

    public C0113ac(Context context, String str, C0356jn c0356jn) {
        this(context, str, new Z9(str), c0356jn);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0740z6
    public final synchronized SQLiteDatabase a() {
        Z6 z6;
        try {
            this.d.a();
            z6 = new Z6(this.f880a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = z6;
        } catch (Throwable unused) {
            return null;
        }
        return z6.getWritableDatabase();
    }

    public C0113ac(Context context, String str, Z9 z9, C0356jn c0356jn) {
        this.f880a = context;
        this.b = str;
        this.d = z9;
        this.c = c0356jn;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0740z6
    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        mo.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
