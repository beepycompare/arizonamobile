package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* renamed from: io.appmetrica.analytics.impl.uc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0632uc implements T6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1083a;
    public final String b;
    public final C0320hn c;
    public final C0605ta d;
    public C0602t7 e;

    public C0632uc(Context context, String str, C0320hn c0320hn) {
        this(context, str, new C0605ta(str), c0320hn);
    }

    @Override // io.appmetrica.analytics.impl.T6
    public final synchronized SQLiteDatabase a() {
        C0602t7 c0602t7;
        try {
            this.d.a();
            c0602t7 = new C0602t7(this.f1083a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c0602t7;
        } catch (Throwable unused) {
            return null;
        }
        return c0602t7.getWritableDatabase();
    }

    public C0632uc(Context context, String str, C0605ta c0605ta, C0320hn c0320hn) {
        this.f1083a = context;
        this.b = str;
        this.d = c0605ta;
        this.c = c0320hn;
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
