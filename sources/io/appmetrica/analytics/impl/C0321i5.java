package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
/* renamed from: io.appmetrica.analytics.impl.i5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0321i5 extends DatabaseScript {

    /* renamed from: a  reason: collision with root package name */
    public final C0295h5 f914a = new C0295h5();
    public final C0269g5 b = new C0269g5();

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        this.f914a.runScript(sQLiteDatabase);
        this.b.runScript(sQLiteDatabase);
    }
}
