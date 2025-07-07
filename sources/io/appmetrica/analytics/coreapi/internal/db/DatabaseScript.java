package io.appmetrica.analytics.coreapi.internal.db;

import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;
import org.json.JSONException;
/* loaded from: classes4.dex */
public abstract class DatabaseScript {
    public abstract void runScript(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException;
}
