package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
/* renamed from: io.appmetrica.analytics.impl.f5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0257f5 extends DatabaseScript {

    /* renamed from: a  reason: collision with root package name */
    public final C0232e5 f831a = new C0232e5();
    public final C0207d5 b = new C0207d5();

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        this.f831a.runScript(sQLiteDatabase);
        this.b.runScript(sQLiteDatabase);
    }
}
