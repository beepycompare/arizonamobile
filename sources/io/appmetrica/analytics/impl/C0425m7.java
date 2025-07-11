package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.modulesapi.internal.common.TableDescription;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import java.sql.SQLException;
/* renamed from: io.appmetrica.analytics.impl.m7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0425m7 extends DatabaseScript {
    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS binary_data (data_key TEXT PRIMARY KEY,value BLOB)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS temp_cache (id INTEGER PRIMARY KEY,scope TEXT,data BLOB,timestamp INTEGER)");
        for (ModuleServicesDatabase moduleServicesDatabase : Ga.F.o().b()) {
            for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                sQLiteDatabase.execSQL(tableDescription.getCreateTableScript());
            }
        }
    }
}
