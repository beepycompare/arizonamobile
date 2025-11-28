package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
/* renamed from: io.appmetrica.analytics.impl.gc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0269gc implements F6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f893a;
    public final String b;
    public final C0409ln c;
    public final C0241fa d;
    public C0238f7 e;

    public C0269gc(Context context, String str, C0409ln c0409ln) {
        this(context, str, new C0241fa(str), c0409ln);
    }

    @Override // io.appmetrica.analytics.impl.F6
    public final synchronized SQLiteDatabase a() {
        C0238f7 c0238f7;
        try {
            this.d.a();
            c0238f7 = new C0238f7(this.f893a, this.b, this.c, PublicLogger.getAnonymousInstance());
            this.e = c0238f7;
        } catch (Throwable unused) {
            return null;
        }
        return c0238f7.getWritableDatabase();
    }

    public C0269gc(Context context, String str, C0241fa c0241fa, C0409ln c0409ln) {
        this.f893a = context;
        this.b = str;
        this.d = c0241fa;
        this.c = c0409ln;
    }

    @Override // io.appmetrica.analytics.impl.F6
    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Throwable unused) {
            }
        }
        no.a((Closeable) this.e);
        this.d.b();
        this.e = null;
    }
}
