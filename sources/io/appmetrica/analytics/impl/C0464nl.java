package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: io.appmetrica.analytics.impl.nl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0464nl implements Q6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0525q7 f960a;

    public C0464nl(C0525q7 c0525q7) {
        this.f960a = c0525q7;
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.Q6
    public final SQLiteDatabase a() {
        try {
            return this.f960a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
