package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes5.dex */
public final class Vl implements Q6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0502p7 f811a;

    public Vl(C0502p7 c0502p7) {
        this.f811a = c0502p7;
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final SQLiteDatabase a() {
        try {
            return this.f811a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
