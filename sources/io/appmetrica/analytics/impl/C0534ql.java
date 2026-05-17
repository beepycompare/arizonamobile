package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: io.appmetrica.analytics.impl.ql  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0534ql implements InterfaceC0718y6 {

    /* renamed from: a  reason: collision with root package name */
    public final Y6 f1197a;

    public C0534ql(Y6 y6) {
        this.f1197a = y6;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0718y6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0718y6
    public final SQLiteDatabase a() {
        try {
            return this.f1197a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
