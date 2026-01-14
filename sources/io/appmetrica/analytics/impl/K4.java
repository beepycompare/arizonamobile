package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
/* loaded from: classes5.dex */
public final class K4 extends DatabaseScript {

    /* renamed from: a  reason: collision with root package name */
    public final J4 f653a = new J4();
    public final I4 b = new I4();

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        this.f653a.runScript(sQLiteDatabase);
        this.b.runScript(sQLiteDatabase);
    }
}
