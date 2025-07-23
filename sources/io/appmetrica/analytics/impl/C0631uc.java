package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* renamed from: io.appmetrica.analytics.impl.uc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0631uc implements T6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1083a;
    public final String b;
    public final C0319hn c;
    public final C0604ta d;
    public C0601t7 e;

    public C0631uc(Context context, String str, C0319hn c0319hn) {
        this(context, str, new C0604ta(str), c0319hn);
    }

    @Override // io.appmetrica.analytics.impl.T6
    public final synchronized SQLiteDatabase a() {
        C0601t7 c0601t7;
        try {
            this.d.a();
            c0601t7 = new C0601t7(this.f1083a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c0601t7;
        } catch (Throwable unused) {
            return null;
        }
        return c0601t7.getWritableDatabase();
    }

    public C0631uc(Context context, String str, C0604ta c0604ta, C0319hn c0319hn) {
        this.f1083a = context;
        this.b = str;
        this.d = c0604ta;
        this.c = c0319hn;
    }

    @Override // io.appmetrica.analytics.impl.T6
    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        io.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
