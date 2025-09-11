package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* renamed from: io.appmetrica.analytics.impl.zc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0758zc implements X6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1189a;
    public final String b;
    public final C0545qn c;
    public final C0731ya d;
    public C0703x7 e;

    public C0758zc(Context context, String str, C0545qn c0545qn) {
        this(context, str, new C0731ya(str), c0545qn);
    }

    @Override // io.appmetrica.analytics.impl.X6
    public final synchronized SQLiteDatabase a() {
        C0703x7 c0703x7;
        try {
            this.d.a();
            c0703x7 = new C0703x7(this.f1189a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c0703x7;
        } catch (Throwable unused) {
            return null;
        }
        return c0703x7.getWritableDatabase();
    }

    public C0758zc(Context context, String str, C0731ya c0731ya, C0545qn c0545qn) {
        this.f1189a = context;
        this.b = str;
        this.d = c0731ya;
        this.c = c0545qn;
    }

    @Override // io.appmetrica.analytics.impl.X6
    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        ro.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
