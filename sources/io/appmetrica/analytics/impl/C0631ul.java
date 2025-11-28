package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
/* renamed from: io.appmetrica.analytics.impl.ul  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0631ul implements F6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0238f7 f1156a;

    public C0631ul(C0238f7 c0238f7) {
        this.f1156a = c0238f7;
    }

    @Override // io.appmetrica.analytics.impl.F6
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // io.appmetrica.analytics.impl.F6
    public final SQLiteDatabase a() {
        try {
            return this.f1156a.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }
}
