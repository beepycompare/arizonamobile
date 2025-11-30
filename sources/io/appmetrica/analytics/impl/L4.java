package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
/* loaded from: classes5.dex */
public final class L4 extends DatabaseScript {

    /* renamed from: a  reason: collision with root package name */
    public final K4 f564a = new K4();
    public final J4 b = new J4();

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        this.f564a.runScript(sQLiteDatabase);
        this.b.runScript(sQLiteDatabase);
    }
}
