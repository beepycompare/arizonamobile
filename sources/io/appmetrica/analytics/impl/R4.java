package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
/* loaded from: classes3.dex */
public final class R4 extends DatabaseScript {

    /* renamed from: a  reason: collision with root package name */
    public final Q4 f659a = new Q4();
    public final P4 b = new P4();

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        this.f659a.runScript(sQLiteDatabase);
        this.b.runScript(sQLiteDatabase);
    }
}
