package androidx.room.driver;

import android.database.Cursor;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.room.driver.SupportSQLiteStatement;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: SupportSQLiteStatement.android.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00132\u00020\u0001:\u0003\u0013\u0014\u0015B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018"}, d2 = {"Landroidx/room/driver/SupportSQLiteStatement;", "Landroidx/sqlite/SQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", "<init>", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "getDb", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "getSql", "()Ljava/lang/String;", "isClosed", "", "()Z", "setClosed", "(Z)V", "throwIfClosed", "", "Companion", "SupportAndroidSQLiteStatement", "SupportOtherAndroidSQLiteStatement", "Landroidx/room/driver/SupportSQLiteStatement$SupportAndroidSQLiteStatement;", "Landroidx/room/driver/SupportSQLiteStatement$SupportOtherAndroidSQLiteStatement;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SupportSQLiteStatement implements SQLiteStatement {
    public static final Companion Companion = new Companion(null);
    private final SupportSQLiteDatabase db;
    private boolean isClosed;
    private final String sql;

    public /* synthetic */ SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(supportSQLiteDatabase, str);
    }

    private SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        this.db = supportSQLiteDatabase;
        this.sql = str;
    }

    protected final SupportSQLiteDatabase getDb() {
        return this.db;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getSql() {
        return this.sql;
    }

    protected final boolean isClosed() {
        return this.isClosed;
    }

    protected final void setClosed(boolean z) {
        this.isClosed = z;
    }

    protected final void throwIfClosed() {
        if (this.isClosed) {
            SQLite.throwSQLiteException(21, "statement is closed");
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: SupportSQLiteStatement.android.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0017\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002¨\u0006\u0012"}, d2 = {"Landroidx/room/driver/SupportSQLiteStatement$Companion;", "", "<init>", "()V", "create", "Landroidx/room/driver/SupportSQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", "isRowStatement", "", "prefix", "getStatementPrefix", "getStatementPrefix$room_runtime_release", "getStatementPrefixIndex", "", CmcdData.STREAMING_FORMAT_SS, "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SupportSQLiteStatement create(SupportSQLiteDatabase db, String sql) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            String upperCase = StringsKt.trim((CharSequence) sql).toString().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String statementPrefix$room_runtime_release = getStatementPrefix$room_runtime_release(upperCase);
            if (statementPrefix$room_runtime_release == null) {
                return new SupportOtherAndroidSQLiteStatement(db, sql);
            }
            if (isRowStatement(statementPrefix$room_runtime_release)) {
                return new SupportAndroidSQLiteStatement(db, sql);
            }
            return new SupportOtherAndroidSQLiteStatement(db, sql);
        }

        private final boolean isRowStatement(String str) {
            int hashCode = str.hashCode();
            return hashCode != 79487 ? hashCode != 81978 ? hashCode == 85954 && str.equals("WIT") : str.equals("SEL") : str.equals("PRA");
        }

        public final String getStatementPrefix$room_runtime_release(String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            int statementPrefixIndex = getStatementPrefixIndex(sql);
            if (statementPrefixIndex < 0 || statementPrefixIndex > sql.length()) {
                return null;
            }
            String substring = sql.substring(statementPrefixIndex, Math.min(statementPrefixIndex + 3, sql.length()));
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }

        private final int getStatementPrefixIndex(String str) {
            int i;
            int length = str.length() - 2;
            if (length < 0) {
                return -1;
            }
            int i2 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (Intrinsics.compare((int) charAt, 32) > 0) {
                    if (charAt == '-') {
                        if (str.charAt(i2 + 1) == '-') {
                            i2 = StringsKt.indexOf$default((CharSequence) str, '\n', i2 + 2, false, 4, (Object) null);
                            if (i2 < 0) {
                                return -1;
                            }
                        }
                    } else if (charAt == '/') {
                        int i3 = i2 + 1;
                        if (str.charAt(i3) == '*') {
                            do {
                                i3 = StringsKt.indexOf$default((CharSequence) str, '*', i3 + 1, false, 4, (Object) null);
                                if (i3 >= 0) {
                                    i = i3 + 1;
                                    if (i >= length) {
                                        break;
                                    }
                                } else {
                                    return -1;
                                }
                            } while (str.charAt(i) != '/');
                            i2 = i3 + 2;
                        }
                    }
                    return i2;
                }
                i2++;
            }
            return -1;
        }
    }

    /* compiled from: SupportSQLiteStatement.android.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020&H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\u0018\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\b\u00101\u001a\u00020\u0015H\u0002J\u0018\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0018\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Landroidx/room/driver/SupportSQLiteStatement$SupportAndroidSQLiteStatement;", "Landroidx/room/driver/SupportSQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", "<init>", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "bindingTypes", "", "longBindings", "", "doubleBindings", "", "stringBindings", "", "[Ljava/lang/String;", "blobBindings", "", "[[B", "cursor", "Landroid/database/Cursor;", "bindBlob", "", FirebaseAnalytics.Param.INDEX, "", "value", "bindDouble", "", "bindLong", "", "bindText", "bindNull", "getBlob", "getDouble", "getLong", "getText", "isNull", "", "getColumnCount", "getColumnName", "getColumnType", "step", "reset", "clearBindings", "close", "ensureCapacity", "columnType", "ensureCursor", "throwIfNoRow", "throwIfInvalidColumn", "c", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class SupportAndroidSQLiteStatement extends SupportSQLiteStatement {
        public static final Companion Companion = new Companion(null);
        private int[] bindingTypes;
        private byte[][] blobBindings;
        private Cursor cursor;
        private double[] doubleBindings;
        private long[] longBindings;
        private String[] stringBindings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportAndroidSQLiteStatement(SupportSQLiteDatabase db, String sql) {
            super(db, sql, null);
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0];
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo7566bindBlob(int i, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throwIfClosed();
            ensureCapacity(4, i);
            this.bindingTypes[i] = 4;
            this.blobBindings[i] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo7567bindDouble(int i, double d) {
            throwIfClosed();
            ensureCapacity(2, i);
            this.bindingTypes[i] = 2;
            this.doubleBindings[i] = d;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo7568bindLong(int i, long j) {
            throwIfClosed();
            ensureCapacity(1, i);
            this.bindingTypes[i] = 1;
            this.longBindings[i] = j;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo7570bindText(int i, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throwIfClosed();
            ensureCapacity(3, i);
            this.bindingTypes[i] = 3;
            this.stringBindings[i] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo7569bindNull(int i) {
            throwIfClosed();
            ensureCapacity(5, i);
            this.bindingTypes[i] = 5;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int i) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i);
            byte[] blob = throwIfNoRow.getBlob(i);
            Intrinsics.checkNotNullExpressionValue(blob, "getBlob(...)");
            return blob;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i);
            return throwIfNoRow.getDouble(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i);
            return throwIfNoRow.getLong(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int i) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i);
            String string = throwIfNoRow.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i) {
            throwIfClosed();
            Cursor throwIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(throwIfNoRow, i);
            return throwIfNoRow.isNull(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            throwIfInvalidColumn(cursor, i);
            String columnName = cursor.getColumnName(i);
            Intrinsics.checkNotNullExpressionValue(columnName, "getColumnName(...)");
            return columnName;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            throwIfInvalidColumn(cursor, i);
            return Companion.getDataType(cursor, i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            throwIfClosed();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                cursor.close();
            }
            this.cursor = null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo7571clearBindings() {
            throwIfClosed();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0];
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (!isClosed()) {
                mo7571clearBindings();
                reset();
            }
            setClosed(true);
        }

        private final void ensureCapacity(int i, int i2) {
            int i3 = i2 + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i3) {
                int[] copyOf = Arrays.copyOf(iArr, i3);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.bindingTypes = copyOf;
            }
            if (i == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i3) {
                    long[] copyOf2 = Arrays.copyOf(jArr, i3);
                    Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
                    this.longBindings = copyOf2;
                }
            } else if (i == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i3) {
                    double[] copyOf3 = Arrays.copyOf(dArr, i3);
                    Intrinsics.checkNotNullExpressionValue(copyOf3, "copyOf(...)");
                    this.doubleBindings = copyOf3;
                }
            } else if (i == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i3) {
                    Object[] copyOf4 = Arrays.copyOf(strArr, i3);
                    Intrinsics.checkNotNullExpressionValue(copyOf4, "copyOf(...)");
                    this.stringBindings = (String[]) copyOf4;
                }
            } else if (i != 4) {
            } else {
                byte[][] bArr = this.blobBindings;
                if (bArr.length < i3) {
                    Object[] copyOf5 = Arrays.copyOf(bArr, i3);
                    Intrinsics.checkNotNullExpressionValue(copyOf5, "copyOf(...)");
                    this.blobBindings = (byte[][]) copyOf5;
                }
            }
        }

        private final void ensureCursor() {
            if (this.cursor == null) {
                this.cursor = getDb().query(new SupportSQLiteQuery() { // from class: androidx.room.driver.SupportSQLiteStatement$SupportAndroidSQLiteStatement$ensureCursor$1
                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public String getSql() {
                        return SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.getSql();
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public void bindTo(SupportSQLiteProgram statement) {
                        int[] iArr;
                        int[] iArr2;
                        long[] jArr;
                        double[] dArr;
                        String[] strArr;
                        byte[][] bArr;
                        Intrinsics.checkNotNullParameter(statement, "statement");
                        iArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.bindingTypes;
                        int length = iArr.length;
                        for (int i = 1; i < length; i++) {
                            iArr2 = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.bindingTypes;
                            int i2 = iArr2[i];
                            if (i2 == 1) {
                                jArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.longBindings;
                                statement.bindLong(i, jArr[i]);
                            } else if (i2 == 2) {
                                dArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.doubleBindings;
                                statement.bindDouble(i, dArr[i]);
                            } else if (i2 == 3) {
                                strArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.stringBindings;
                                String str = strArr[i];
                                Intrinsics.checkNotNull(str);
                                statement.bindString(i, str);
                            } else if (i2 == 4) {
                                bArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.blobBindings;
                                byte[] bArr2 = bArr[i];
                                Intrinsics.checkNotNull(bArr2);
                                statement.bindBlob(i, bArr2);
                            } else if (i2 == 5) {
                                statement.bindNull(i);
                            }
                        }
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public int getArgCount() {
                        int[] iArr;
                        iArr = SupportSQLiteStatement.SupportAndroidSQLiteStatement.this.bindingTypes;
                        return iArr.length;
                    }
                });
            }
        }

        private final Cursor throwIfNoRow() {
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor;
            }
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        private final void throwIfInvalidColumn(Cursor cursor, int i) {
            if (i < 0 || i >= cursor.getColumnCount()) {
                SQLite.throwSQLiteException(25, "column index out of range");
                throw new KotlinNothingValueException();
            }
        }

        /* compiled from: SupportSQLiteStatement.android.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"Landroidx/room/driver/SupportSQLiteStatement$SupportAndroidSQLiteStatement$Companion;", "", "<init>", "()V", "getDataType", "", "Landroid/database/Cursor;", FirebaseAnalytics.Param.INDEX, "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    /* compiled from: SupportSQLiteStatement.android.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0016R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/room/driver/SupportSQLiteStatement$SupportOtherAndroidSQLiteStatement;", "Landroidx/room/driver/SupportSQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", "<init>", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "delegate", "Landroidx/sqlite/db/SupportSQLiteStatement;", "Landroidx/room/driver/SupportStatement;", "bindBlob", "", FirebaseAnalytics.Param.INDEX, "", "value", "", "bindDouble", "", "bindLong", "", "bindText", "bindNull", "getBlob", "getDouble", "getLong", "getText", "isNull", "", "getColumnCount", "getColumnName", "getColumnType", "step", "reset", "clearBindings", "close", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class SupportOtherAndroidSQLiteStatement extends SupportSQLiteStatement {
        private final androidx.sqlite.db.SupportSQLiteStatement delegate;

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportOtherAndroidSQLiteStatement(SupportSQLiteDatabase db, String sql) {
            super(db, sql, null);
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            this.delegate = db.compileStatement(sql);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo7566bindBlob(int i, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throwIfClosed();
            this.delegate.bindBlob(i, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo7567bindDouble(int i, double d) {
            throwIfClosed();
            this.delegate.bindDouble(i, d);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo7568bindLong(int i, long j) {
            throwIfClosed();
            this.delegate.bindLong(i, j);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo7570bindText(int i, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throwIfClosed();
            this.delegate.bindString(i, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo7569bindNull(int i) {
            throwIfClosed();
            this.delegate.bindNull(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            this.delegate.execute();
            return false;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo7571clearBindings() {
            throwIfClosed();
            this.delegate.clearBindings();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            setClosed(true);
        }
    }
}
