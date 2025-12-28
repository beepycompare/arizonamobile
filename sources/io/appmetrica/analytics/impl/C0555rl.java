package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: io.appmetrica.analytics.impl.rl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0555rl implements InterfaceC0740z6 {

    /* renamed from: a  reason: collision with root package name */
    public final Z6 f1203a;

    public C0555rl(Z6 z6) {
        this.f1203a = z6;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0740z6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0740z6
    public final SQLiteDatabase a() {
        try {
            return this.f1203a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
