package io.appmetrica.analytics.impl;

import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.modulesapi.internal.common.TableDescription;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import java.sql.SQLException;
/* renamed from: io.appmetrica.analytics.impl.n7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0450n7 extends DatabaseScript {
    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preferences");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS binary_data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS temp_cache");
        for (ModuleServicesDatabase moduleServicesDatabase : Ga.F.o().b()) {
            for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                sQLiteDatabase.execSQL(tableDescription.getDropTableScript());
            }
        }
    }
}
