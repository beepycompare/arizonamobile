package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: io.appmetrica.analytics.impl.rl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0556rl implements InterfaceC0741z6 {

    /* renamed from: a  reason: collision with root package name */
    public final Z6 f1105a;

    public C0556rl(Z6 z6) {
        this.f1105a = z6;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0741z6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0741z6
    public final SQLiteDatabase a() {
        try {
            return this.f1105a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
