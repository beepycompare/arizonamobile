package androidx.room.paging;

import android.database.Cursor;
import androidx.sqlite.SQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CursorSQLiteStatement.android.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\b\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/room/paging/CursorSQLiteStatement;", "Landroidx/sqlite/SQLiteStatement;", "cursor", "Landroid/database/Cursor;", "<init>", "(Landroid/database/Cursor;)V", "getBlob", "", FirebaseAnalytics.Param.INDEX, "", "getDouble", "", "getLong", "", "getText", "", "isNull", "", "getColumnCount", "getColumnName", "getColumnType", "step", "reset", "", "close", "bindBlob", "", "value", "bindDouble", "bindLong", "bindText", "bindNull", "clearBindings", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CursorSQLiteStatement implements SQLiteStatement {
    public static final Companion Companion = new Companion(null);
    private final Cursor cursor;

    public CursorSQLiteStatement(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        this.cursor = cursor;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public byte[] getBlob(int i) {
        byte[] blob = this.cursor.getBlob(i);
        Intrinsics.checkNotNullExpressionValue(blob, "getBlob(...)");
        return blob;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(int i) {
        return this.cursor.getDouble(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(int i) {
        return this.cursor.getLong(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getText(int i) {
        String string = this.cursor.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(int i) {
        return this.cursor.isNull(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getColumnName(int i) {
        String columnName = this.cursor.getColumnName(i);
        Intrinsics.checkNotNullExpressionValue(columnName, "getColumnName(...)");
        return columnName;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnType(int i) {
        return Companion.getDataType(this.cursor, i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean step() {
        return this.cursor.moveToNext();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        this.cursor.moveToPosition(-1);
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        this.cursor.close();
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindBlob */
    public Void mo7566bindBlob(int i, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement".toString());
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindDouble */
    public Void mo7567bindDouble(int i, double d) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement".toString());
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindLong */
    public Void mo7568bindLong(int i, long j) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement".toString());
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindText */
    public Void mo7570bindText(int i, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement".toString());
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindNull */
    public Void mo7569bindNull(int i) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement".toString());
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: clearBindings */
    public Void mo7571clearBindings() {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement".toString());
    }

    /* compiled from: CursorSQLiteStatement.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"Landroidx/room/paging/CursorSQLiteStatement$Companion;", "", "<init>", "()V", "getDataType", "", "Landroid/database/Cursor;", FirebaseAnalytics.Param.INDEX, "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getDataType(Cursor cursor, int i) {
            int type = cursor.getType(i);
            int type2 = cursor.getType(i);
            if (type2 != 0) {
                int i2 = 1;
                if (type2 != 1) {
                    i2 = 2;
                    if (type2 != 2) {
                        i2 = 3;
                        if (type2 != 3) {
                            if (type2 == 4) {
                                return 4;
                            }
                            throw new IllegalStateException(("Unknown field type: " + type).toString());
                        }
                    }
                }
                return i2;
            }
            return 5;
        }
    }
}
