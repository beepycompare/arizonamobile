package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* renamed from: io.appmetrica.analytics.impl.sc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0587sc implements Q6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1043a;
    public final String b;
    public final C0250en c;
    public final C0560ra d;
    public C0533q7 e;

    public C0587sc(Context context, String str, C0250en c0250en) {
        this(context, str, new C0560ra(str), c0250en);
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final synchronized SQLiteDatabase a() {
        C0533q7 c0533q7;
        try {
            this.d.a();
            c0533q7 = new C0533q7(this.f1043a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c0533q7;
        } catch (Throwable unused) {
            return null;
        }
        return c0533q7.getWritableDatabase();
    }

    public C0587sc(Context context, String str, C0560ra c0560ra, C0250en c0250en) {
        this.f1043a = context;
        this.b = str;
        this.d = c0560ra;
        this.c = c0250en;
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
