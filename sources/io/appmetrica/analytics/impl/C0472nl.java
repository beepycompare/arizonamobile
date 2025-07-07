package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: io.appmetrica.analytics.impl.nl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0472nl implements Q6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0533q7 f959a;

    public C0472nl(C0533q7 c0533q7) {
        this.f959a = c0533q7;
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final SQLiteDatabase a() {
        try {
            return this.f959a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
