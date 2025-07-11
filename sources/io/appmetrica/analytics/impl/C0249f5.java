package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
/* renamed from: io.appmetrica.analytics.impl.f5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0249f5 extends DatabaseScript {

    /* renamed from: a  reason: collision with root package name */
    public final C0224e5 f832a = new C0224e5();
    public final C0199d5 b = new C0199d5();

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        this.f832a.runScript(sQLiteDatabase);
        this.b.runScript(sQLiteDatabase);
    }
}
