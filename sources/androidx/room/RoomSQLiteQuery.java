package androidx.room;

import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RoomSQLiteQuery.android.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\b\u0007\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u00029:B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020%J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0002H\u0016J\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0004H\u0016J\u0018\u0010.\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0016\u00103\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nJ\u0018\u00104\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u00105\u001a\u00020!H\u0016J\u000e\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u0000J\b\u00108\u001a\u00020!H\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u0012\u0004\b\u0014\u0010\u000eR \u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u0012\u0004\b\u0018\u0010\u000eR\u0014\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\bR\u0014\u0010&\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006;"}, d2 = {"Landroidx/room/RoomSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "capacity", "", "<init>", "(I)V", "getCapacity", "()I", SearchIntents.EXTRA_QUERY, "", "longBindings", "", "getLongBindings$annotations", "()V", "doubleBindings", "", "getDoubleBindings$annotations", "stringBindings", "", "getStringBindings$annotations", "[Ljava/lang/String;", "blobBindings", "", "getBlobBindings$annotations", "[[B", "bindingTypes", "", "getBindingTypes$annotations", "value", "argCount", "getArgCount", "init", "", "initArgCount", "release", "toRoomRawQuery", "Landroidx/room/RoomRawQuery;", "sql", "getSql", "()Ljava/lang/String;", "bindTo", "statement", "Landroidx/sqlite/SQLiteStatement;", "bindNull", FirebaseAnalytics.Param.INDEX, "bindLong", "", "bindDouble", "", "bindString", "bindText", "bindBlob", "close", "copyArgumentsFrom", "other", "clearBindings", "Binding", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;
    public static final Companion Companion = new Companion(null);
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();

    /* compiled from: RoomSQLiteQuery.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Binding;", "", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Binding {
    }

    public /* synthetic */ RoomSQLiteQuery(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    @JvmStatic
    public static final RoomSQLiteQuery acquire(String str, int i) {
        return Companion.acquire(str, i);
    }

    @JvmStatic
    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        return Companion.copyFrom(supportSQLiteQuery);
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    public static /* synthetic */ void getLongBindings$annotations() {
    }

    public static /* synthetic */ void getStringBindings$annotations() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    private RoomSQLiteQuery(int i) {
        this.capacity = i;
        int i2 = i + 1;
        this.bindingTypes = new int[i2];
        this.longBindings = new long[i2];
        this.doubleBindings = new double[i2];
        this.stringBindings = new String[i2];
        this.blobBindings = new byte[i2];
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.argCount;
    }

    public final void init(String query, int i) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.query = query;
        this.argCount = i;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toRoomRawQuery$lambda$1(RoomSQLiteQuery roomSQLiteQuery, SQLiteStatement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        roomSQLiteQuery.bindTo(it);
        return Unit.INSTANCE;
    }

    public final RoomRawQuery toRoomRawQuery() {
        return new RoomRawQuery(getSql(), new Function1() { // from class: androidx.room.RoomSQLiteQuery$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit roomRawQuery$lambda$1;
                roomRawQuery$lambda$1 = RoomSQLiteQuery.toRoomRawQuery$lambda$1(RoomSQLiteQuery.this, (SQLiteStatement) obj);
                return roomRawQuery$lambda$1;
            }
        });
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i = 1;
        while (true) {
            int i2 = this.bindingTypes[i];
            if (i2 == 1) {
                statement.bindNull(i);
            } else if (i2 == 2) {
                statement.bindLong(i, this.longBindings[i]);
            } else if (i2 == 3) {
                statement.bindDouble(i, this.doubleBindings[i]);
            } else if (i2 == 4) {
                String str = this.stringBindings[i];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                statement.bindString(i, str);
            } else if (i2 == 5) {
                byte[] bArr = this.blobBindings[i];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                statement.bindBlob(i, bArr);
            }
            if (i == argCount) {
                return;
            }
            i++;
        }
    }

    public final void bindTo(SQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i = 1;
        while (true) {
            int i2 = this.bindingTypes[i];
            if (i2 == 1) {
                statement.mo7569bindNull(i);
            } else if (i2 == 2) {
                statement.mo7568bindLong(i, this.longBindings[i]);
            } else if (i2 == 3) {
                statement.mo7567bindDouble(i, this.doubleBindings[i]);
            } else if (i2 == 4) {
                String str = this.stringBindings[i];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                statement.mo7570bindText(i, str);
            } else if (i2 == 5) {
                byte[] bArr = this.blobBindings[i];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                statement.mo7566bindBlob(i, bArr);
            }
            if (i == argCount) {
                return;
            }
            i++;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        this.bindingTypes[i] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        this.bindingTypes[i] = 2;
        this.longBindings[i] = j;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        this.bindingTypes[i] = 3;
        this.doubleBindings[i] = d;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.bindingTypes[i] = 4;
        this.stringBindings[i] = value;
    }

    public final void bindText(int i, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        bindString(i, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.bindingTypes[i] = 5;
        this.blobBindings[i] = value;
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int argCount = other.getArgCount() + 1;
        System.arraycopy(other.bindingTypes, 0, this.bindingTypes, 0, argCount);
        System.arraycopy(other.longBindings, 0, this.longBindings, 0, argCount);
        System.arraycopy(other.stringBindings, 0, this.stringBindings, 0, argCount);
        System.arraycopy(other.blobBindings, 0, this.blobBindings, 0, argCount);
        System.arraycopy(other.doubleBindings, 0, this.doubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        ArraysKt.fill$default(this.bindingTypes, 1, 0, 0, 6, (Object) null);
        ArraysKt.fill$default(this.stringBindings, (Object) null, 0, 0, 6, (Object) null);
        ArraysKt.fill$default(this.blobBindings, (Object) null, 0, 0, 6, (Object) null);
        this.query = null;
    }

    /* compiled from: RoomSQLiteQuery.android.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Companion;", "", "<init>", "()V", "POOL_LIMIT", "", "getPOOL_LIMIT$annotations", "DESIRED_POOL_SIZE", "getDESIRED_POOL_SIZE$annotations", "queryPool", "Ljava/util/TreeMap;", "Landroidx/room/RoomSQLiteQuery;", "getQueryPool$annotations", "copyFrom", "supportSQLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "acquire", SearchIntents.EXTRA_QUERY, "", "argumentCount", "prunePoolLocked", "", "prunePoolLocked$room_runtime_release", "NULL", "LONG", "DOUBLE", "STRING", "BLOB", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        public static /* synthetic */ void getQueryPool$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
            Intrinsics.checkNotNullParameter(supportSQLiteQuery, "supportSQLiteQuery");
            final RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery$Companion$copyFrom$1
                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindBlob(int i, byte[] value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    RoomSQLiteQuery.this.bindBlob(i, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindDouble(int i, double d) {
                    RoomSQLiteQuery.this.bindDouble(i, d);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindLong(int i, long j) {
                    RoomSQLiteQuery.this.bindLong(i, j);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindNull(int i) {
                    RoomSQLiteQuery.this.bindNull(i);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindString(int i, String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    RoomSQLiteQuery.this.bindString(i, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void clearBindings() {
                    RoomSQLiteQuery.this.clearBindings();
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    RoomSQLiteQuery.this.close();
                }
            });
            return acquire;
        }

        @JvmStatic
        public final RoomSQLiteQuery acquire(String query, int i) {
            Intrinsics.checkNotNullParameter(query, "query");
            synchronized (RoomSQLiteQuery.queryPool) {
                Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = RoomSQLiteQuery.queryPool.ceilingEntry(Integer.valueOf(i));
                if (ceilingEntry != null) {
                    RoomSQLiteQuery.queryPool.remove(ceilingEntry.getKey());
                    RoomSQLiteQuery value = ceilingEntry.getValue();
                    value.init(query, i);
                    Intrinsics.checkNotNull(value);
                    return value;
                }
                Unit unit = Unit.INSTANCE;
                RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i, null);
                roomSQLiteQuery.init(query, i);
                return roomSQLiteQuery;
            }
        }

        public final void prunePoolLocked$room_runtime_release() {
            if (RoomSQLiteQuery.queryPool.size() <= 15) {
                return;
            }
            int size = RoomSQLiteQuery.queryPool.size() - 10;
            Iterator<Integer> it = RoomSQLiteQuery.queryPool.descendingKeySet().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                int i = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i;
            }
        }
    }
}
