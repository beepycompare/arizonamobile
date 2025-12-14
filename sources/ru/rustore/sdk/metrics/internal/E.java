package ru.rustore.sdk.metrics.internal;

import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes6.dex */
public final class E extends Lambda implements Function0<SQLiteDatabase> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I f1567a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(I i) {
        super(0);
        this.f1567a = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SQLiteDatabase invoke() {
        SQLiteDatabase writableDatabase = this.f1567a.f1571a.getWritableDatabase();
        writableDatabase.enableWriteAheadLogging();
        return writableDatabase;
    }
}
