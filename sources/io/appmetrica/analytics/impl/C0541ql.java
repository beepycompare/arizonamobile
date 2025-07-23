package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: io.appmetrica.analytics.impl.ql  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0541ql implements T6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0601t7 f1022a;

    public C0541ql(C0601t7 c0601t7) {
        this.f1022a = c0601t7;
    }

    @Override // io.appmetrica.analytics.impl.T6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.T6
    public final SQLiteDatabase a() {
        try {
            return this.f1022a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
