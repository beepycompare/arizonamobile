package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* renamed from: io.appmetrica.analytics.impl.zc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0759zc implements X6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1190a;
    public final String b;
    public final C0546qn c;
    public final C0732ya d;
    public C0704x7 e;

    public C0759zc(Context context, String str, C0546qn c0546qn) {
        this(context, str, new C0732ya(str), c0546qn);
    }

    @Override // io.appmetrica.analytics.impl.X6
    public final synchronized SQLiteDatabase a() {
        C0704x7 c0704x7;
        try {
            this.d.a();
            c0704x7 = new C0704x7(this.f1190a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c0704x7;
        } catch (Throwable unused) {
            return null;
        }
        return c0704x7.getWritableDatabase();
    }

    public C0759zc(Context context, String str, C0732ya c0732ya, C0546qn c0546qn) {
        this.f1190a = context;
        this.b = str;
        this.d = c0732ya;
        this.c = c0546qn;
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
