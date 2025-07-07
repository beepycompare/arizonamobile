package androidx.room.util;

import androidx.sqlite.SQLiteStatement;
import kotlin.Metadata;
@Metadata(d1 = {"androidx/room/util/SQLiteStatementUtil__StatementUtilKt", "androidx/room/util/SQLiteStatementUtil__StatementUtil_androidKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SQLiteStatementUtil {
    public static final int columnIndexOf(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtil_androidKt.columnIndexOf(sQLiteStatement, str);
    }

    public static final int columnIndexOfCommon(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtilKt.columnIndexOfCommon(sQLiteStatement, str);
    }

    public static final int getColumnIndex(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtilKt.getColumnIndex(sQLiteStatement, str);
    }

    public static final int getColumnIndexOrThrow(SQLiteStatement sQLiteStatement, String str) {
        return SQLiteStatementUtil__StatementUtilKt.getColumnIndexOrThrow(sQLiteStatement, str);
    }

    public static final SQLiteStatement wrapMappedColumns(SQLiteStatement sQLiteStatement, String[] strArr, int[] iArr) {
        return SQLiteStatementUtil__StatementUtilKt.wrapMappedColumns(sQLiteStatement, strArr, iArr);
    }
}
