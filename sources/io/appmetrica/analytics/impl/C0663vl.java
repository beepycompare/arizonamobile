package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: io.appmetrica.analytics.impl.vl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0663vl implements U6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0624u7 f1107a;

    public C0663vl(C0624u7 c0624u7) {
        this.f1107a = c0624u7;
    }

    @Override // io.appmetrica.analytics.impl.U6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.U6
    public final SQLiteDatabase a() {
        try {
            return this.f1107a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
