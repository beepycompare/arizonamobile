package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes5.dex */
public final class Vl implements Q6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0501p7 f814a;

    public Vl(C0501p7 c0501p7) {
        this.f814a = c0501p7;
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final SQLiteDatabase a() {
        try {
            return this.f814a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
