package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* loaded from: classes5.dex */
public final class Bc implements Q6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f480a;
    public final String b;
    public final Jn c;
    public final C0627ua d;
    public C0495p7 e;

    public Bc(Context context, String str, Jn jn) {
        this(context, str, new C0627ua(str), jn);
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final synchronized SQLiteDatabase a() {
        C0495p7 c0495p7;
        try {
            this.d.a();
            c0495p7 = new C0495p7(this.f480a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c0495p7;
        } catch (Throwable unused) {
            return null;
        }
        return c0495p7.getWritableDatabase();
    }

    public Bc(Context context, String str, C0627ua c0627ua, Jn jn) {
        this.f480a = context;
        this.b = str;
        this.d = c0627ua;
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
