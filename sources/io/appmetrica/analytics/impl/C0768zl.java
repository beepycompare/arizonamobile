package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: io.appmetrica.analytics.impl.zl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0768zl implements X6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0704x7 f1195a;

    public C0768zl(C0704x7 c0704x7) {
        this.f1195a = c0704x7;
    }

    @Override // io.appmetrica.analytics.impl.X6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.X6
    public final SQLiteDatabase a() {
        try {
            return this.f1195a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
