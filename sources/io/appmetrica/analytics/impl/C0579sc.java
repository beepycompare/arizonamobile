package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* renamed from: io.appmetrica.analytics.impl.sc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0579sc implements Q6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1044a;
    public final String b;
    public final C0242en c;
    public final C0552ra d;
    public C0525q7 e;

    public C0579sc(Context context, String str, C0242en c0242en) {
        this(context, str, new C0552ra(str), c0242en);
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final synchronized SQLiteDatabase a() {
        C0525q7 c0525q7;
        try {
            this.d.a();
            c0525q7 = new C0525q7(this.f1044a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c0525q7;
        } catch (Throwable unused) {
            return null;
        }
        return c0525q7.getWritableDatabase();
    }

    public C0579sc(Context context, String str, C0552ra c0552ra, C0242en c0242en) {
        this.f1044a = context;
        this.b = str;
        this.d = c0552ra;
        this.c = c0242en;
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        fo.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
