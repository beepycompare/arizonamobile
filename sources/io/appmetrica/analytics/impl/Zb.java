package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* loaded from: classes5.dex */
public final class Zb implements InterfaceC0718y6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f884a;
    public final String b;
    public final C0334in c;
    public final Y9 d;
    public Y6 e;

    public Zb(Context context, String str, C0334in c0334in) {
        this(context, str, new Y9(str), c0334in);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0718y6
    public final synchronized SQLiteDatabase a() {
        Y6 y6;
        try {
            this.d.a();
            y6 = new Y6(this.f884a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = y6;
        } catch (Throwable unused) {
            return null;
        }
        return y6.getWritableDatabase();
    }

    public Zb(Context context, String str, Y9 y9, C0334in c0334in) {
        this.f884a = context;
        this.b = str;
        this.d = y9;
        this.c = c0334in;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0718y6
    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        lo.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
