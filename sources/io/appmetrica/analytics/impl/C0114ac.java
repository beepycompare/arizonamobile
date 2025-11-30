package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* renamed from: io.appmetrica.analytics.impl.ac  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0114ac implements InterfaceC0741z6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f797a;
    public final String b;
    public final C0357jn c;
    public final Z9 d;
    public Z6 e;

    public C0114ac(Context context, String str, C0357jn c0357jn) {
        this(context, str, new Z9(str), c0357jn);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0741z6
    public final synchronized SQLiteDatabase a() {
        Z6 z6;
        try {
            this.d.a();
            z6 = new Z6(this.f797a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = z6;
        } catch (Throwable unused) {
            return null;
        }
        return z6.getWritableDatabase();
    }

    public C0114ac(Context context, String str, Z9 z9, C0357jn c0357jn) {
        this.f797a = context;
        this.b = str;
        this.d = z9;
        this.c = c0357jn;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0741z6
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
