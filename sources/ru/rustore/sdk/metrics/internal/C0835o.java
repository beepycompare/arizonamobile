package ru.rustore.sdk.metrics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: ru.rustore.sdk.metrics.internal.o  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0835o extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public final B f1444a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0835o(Context context, B migrationVer1to2) {
        super(context, "MetricsEvent.db", (SQLiteDatabase.CursorFactory) null, 2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(migrationVer1to2, "migrationVer1to2");
        this.f1444a = migrationVer1to2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        db.execSQL("CREATE TABLE IF NOT EXISTS metrics_event_table (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    uuid VARCHAR(36),\n    metrics_event BLOB);\n\nCREATE INDEX IF NOT EXISTS uuid_index\n    ON metrics_event_table(uuid)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1 && i2 == 2 && sQLiteDatabase != null) {
            this.f1444a.a(sQLiteDatabase);
        }
    }
}
