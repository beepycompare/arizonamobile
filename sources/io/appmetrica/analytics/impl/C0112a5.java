package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
/* renamed from: io.appmetrica.analytics.impl.a5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0112a5 extends DatabaseScript {

    /* renamed from: a  reason: collision with root package name */
    public final Z4 f880a = new Z4();
    public final Y4 b = new Y4();

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        this.f880a.runScript(sQLiteDatabase);
        this.b.runScript(sQLiteDatabase);
    }
}
