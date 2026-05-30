package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* loaded from: classes5.dex */
public final class Bc implements Q6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f475a;
    public final String b;
    public final Jn c;
    public final C0634ua d;
    public C0502p7 e;

    public Bc(Context context, String str, Jn jn) {
        this(context, str, new C0634ua(str), jn);
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final synchronized SQLiteDatabase a() {
        C0502p7 c0502p7;
        try {
            this.d.a();
            c0502p7 = new C0502p7(this.f475a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c0502p7;
        } catch (Throwable unused) {
            return null;
        }
        return c0502p7.getWritableDatabase();
    }

    public Bc(Context context, String str, C0634ua c0634ua, Jn jn) {
        this.f475a = context;
        this.b = str;
        this.d = c0634ua;
        this.c = jn;
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        Oo.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
