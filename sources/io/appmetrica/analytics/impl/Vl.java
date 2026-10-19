package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes5.dex */
public final class Vl implements Q6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0495p7 f817a;

    public Vl(C0495p7 c0495p7) {
        this.f817a = c0495p7;
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final SQLiteDatabase a() {
        try {
            return this.f817a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
