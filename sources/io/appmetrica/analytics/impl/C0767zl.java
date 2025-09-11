package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: io.appmetrica.analytics.impl.zl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0767zl implements X6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0703x7 f1194a;

    public C0767zl(C0703x7 c0703x7) {
        this.f1194a = c0703x7;
    }

    @Override // io.appmetrica.analytics.impl.X6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.X6
    public final SQLiteDatabase a() {
        try {
            return this.f1194a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
