package androidx.room;

import androidx.room.concurrent.CloseBarrier;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: InvalidationTracker.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 O2\u00020\u0001:\u0001OBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&J9\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\fH\u0000¢\u0006\u0004\b-\u0010.J1\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0004\u0012\u00020+002\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\nH\u0000¢\u0006\u0004\b2\u00103J#\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\nH\u0002¢\u0006\u0002\u00105J\u0015\u00106\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b7J\u0015\u00108\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b9J\u0010\u0010:\u001a\u00020\u0010H\u0080@¢\u0006\u0004\b;\u0010<J\u001e\u0010=\u001a\u00020\u00102\u0006\u0010%\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010@J\u001e\u0010A\u001a\u00020\u00102\u0006\u0010%\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010@J@\u0010B\u001a\u00020\f2\u000e\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\n2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00100\u001f2\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100\u001fH\u0080@¢\u0006\u0004\bF\u0010GJ-\u0010H\u001a\u00020\u00102\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00100\u001f2\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100\u001fH\u0000¢\u0006\u0002\bIJ\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0082@¢\u0006\u0002\u0010<J\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010%\u001a\u00020>H\u0082@¢\u0006\u0002\u0010LJ\r\u0010M\u001a\u00020\u0010H\u0000¢\u0006\u0002\bNR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00060\u001bj\u0002`\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006P"}, d2 = {"Landroidx/room/TriggerBasedInvalidationTracker;", "", "database", "Landroidx/room/RoomDatabase;", "shadowTablesMap", "", "", "viewTables", "", "tableNames", "", "useTempTable", "", "onInvalidatedTablesIds", "Lkotlin/Function1;", "", "", "<init>", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "tableIdLookup", "tablesNames", "[Ljava/lang/String;", "observedTableStates", "Landroidx/room/ObservedTableStates;", "observedTableVersions", "Landroidx/room/ObservedTableVersions;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onAllowRefresh", "Lkotlin/Function0;", "getOnAllowRefresh$room_runtime_release", "()Lkotlin/jvm/functions/Function0;", "setOnAllowRefresh$room_runtime_release", "(Lkotlin/jvm/functions/Function0;)V", "configureConnection", "connection", "Landroidx/sqlite/SQLiteConnection;", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "resolvedTableNames", "tableIds", "", "emitInitialState", "createFlow$room_runtime_release", "([Ljava/lang/String;[IZ)Lkotlinx/coroutines/flow/Flow;", "validateTableNames", "Lkotlin/Pair;", "names", "validateTableNames$room_runtime_release", "([Ljava/lang/String;)Lkotlin/Pair;", "resolveViews", "([Ljava/lang/String;)[Ljava/lang/String;", "onObserverAdded", "onObserverAdded$room_runtime_release", "onObserverRemoved", "onObserverRemoved$room_runtime_release", "syncTriggers", "syncTriggers$room_runtime_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startTrackingTable", "Landroidx/room/PooledConnection;", "tableId", "(Landroidx/room/PooledConnection;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTrackingTable", "refreshInvalidation", "tables", "onRefreshScheduled", "onRefreshCompleted", "refreshInvalidation$room_runtime_release", "([Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshInvalidationAsync", "refreshInvalidationAsync$room_runtime_release", "notifyInvalidation", "checkInvalidatedTables", "(Landroidx/room/PooledConnection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetSync", "resetSync$room_runtime_release", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TriggerBasedInvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String DROP_TRACKING_TABLE_SQL = "DROP TABLE IF EXISTS room_table_modification_log";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    private static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    private static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private final RoomDatabase database;
    private final ObservedTableStates observedTableStates;
    private final ObservedTableVersions observedTableVersions;
    private Function0<Boolean> onAllowRefresh;
    private final Function1<Set<Integer>, Unit> onInvalidatedTablesIds;
    private final AtomicBoolean pendingRefresh;
    private final Map<String, String> shadowTablesMap;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final boolean useTempTable;
    private final Map<String, Set<String>> viewTables;
    public static final Companion Companion = new Companion(null);
    private static final String[] TRIGGERS = {"INSERT", "UPDATE", "DELETE"};

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAllowRefresh$lambda$0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerBasedInvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, ? extends Set<String>> viewTables, String[] tableNames, boolean z, Function1<? super Set<Integer>, Unit> onInvalidatedTablesIds) {
        String str;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(onInvalidatedTablesIds, "onInvalidatedTablesIds");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.useTempTable = z;
        this.onInvalidatedTablesIds = onInvalidatedTablesIds;
        this.pendingRefresh = new AtomicBoolean(false);
        this.onAllowRefresh = new Function0() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean onAllowRefresh$lambda$0;
                onAllowRefresh$lambda$0 = TriggerBasedInvalidationTracker.onAllowRefresh$lambda$0();
                return Boolean.valueOf(onAllowRefresh$lambda$0);
            }
        };
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            String lowerCase = tableNames[i].toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str2 = this.shadowTablesMap.get(tableNames[i]);
            if (str2 != null) {
                str = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr[i] = lowerCase;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String lowerCase2 = entry.getValue().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (this.tableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase3, MapsKt.getValue(map, lowerCase2));
            }
        }
        this.observedTableStates = new ObservedTableStates(this.tablesNames.length);
        this.observedTableVersions = new ObservedTableVersions(this.tablesNames.length);
    }

    public final Function0<Boolean> getOnAllowRefresh$room_runtime_release() {
        return this.onAllowRefresh;
    }

    public final void setOnAllowRefresh$room_runtime_release(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onAllowRefresh = function0;
    }

    public final void configureConnection(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLiteStatement prepare = connection.prepare("PRAGMA query_only");
        try {
            SQLiteStatement sQLiteStatement = prepare;
            sQLiteStatement.step();
            boolean z = sQLiteStatement.getBoolean(0);
            AutoCloseableKt.closeFinally(prepare, null);
            if (z) {
                return;
            }
            SQLite.execSQL(connection, "PRAGMA temp_store = MEMORY");
            SQLite.execSQL(connection, "PRAGMA recursive_triggers = 1");
            SQLite.execSQL(connection, DROP_TRACKING_TABLE_SQL);
            if (this.useTempTable) {
                SQLite.execSQL(connection, CREATE_TRACKING_TABLE_SQL);
            } else {
                SQLite.execSQL(connection, StringsKt.replace$default(CREATE_TRACKING_TABLE_SQL, "TEMP", "", false, 4, (Object) null));
            }
            this.observedTableStates.forceNeedSync$room_runtime_release();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(prepare, th);
                throw th2;
            }
        }
    }

    public final Flow<Set<String>> createFlow$room_runtime_release(String[] resolvedTableNames, int[] tableIds, boolean z) {
        Intrinsics.checkNotNullParameter(resolvedTableNames, "resolvedTableNames");
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return FlowKt.flow(new TriggerBasedInvalidationTracker$createFlow$1(this, tableIds, z, resolvedTableNames, null));
    }

    public final Pair<String[], int[]> validateTableNames$room_runtime_release(String[] names) {
        Intrinsics.checkNotNullParameter(names, "names");
        String[] resolveViews = resolveViews(names);
        int length = resolveViews.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            String str = resolveViews[i];
            Map<String, Integer> map = this.tableIdLookup;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            iArr[i] = num.intValue();
        }
        return TuplesKt.to(resolveViews, iArr);
    }

    private final String[] resolveViews(String[] strArr) {
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.viewTables;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Set<String> set = map.get(lowerCase);
            if (set != null) {
                createSetBuilder.addAll(set);
            } else {
                createSetBuilder.add(str);
            }
        }
        return (String[]) SetsKt.build(createSetBuilder).toArray(new String[0]);
    }

    public final boolean onObserverAdded$room_runtime_release(int[] tableIds) {
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return this.observedTableStates.onObserverAdded$room_runtime_release(tableIds);
    }

    public final boolean onObserverRemoved$room_runtime_release(int[] tableIds) {
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return this.observedTableStates.onObserverRemoved$room_runtime_release(tableIds);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object syncTriggers$room_runtime_release(Continuation<? super Unit> continuation) {
        TriggerBasedInvalidationTracker$syncTriggers$1 triggerBasedInvalidationTracker$syncTriggers$1;
        int i;
        CloseBarrier closeBarrier;
        Throwable th;
        if (continuation instanceof TriggerBasedInvalidationTracker$syncTriggers$1) {
            triggerBasedInvalidationTracker$syncTriggers$1 = (TriggerBasedInvalidationTracker$syncTriggers$1) continuation;
            if ((triggerBasedInvalidationTracker$syncTriggers$1.label & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$syncTriggers$1.label -= Integer.MIN_VALUE;
                Object obj = triggerBasedInvalidationTracker$syncTriggers$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = triggerBasedInvalidationTracker$syncTriggers$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CloseBarrier closeBarrier$room_runtime_release = this.database.getCloseBarrier$room_runtime_release();
                    if (closeBarrier$room_runtime_release.block$room_runtime_release()) {
                        try {
                            triggerBasedInvalidationTracker$syncTriggers$1.L$0 = closeBarrier$room_runtime_release;
                            triggerBasedInvalidationTracker$syncTriggers$1.label = 1;
                            if (this.database.useConnection$room_runtime_release(false, new TriggerBasedInvalidationTracker$syncTriggers$2$1(this, null), triggerBasedInvalidationTracker$syncTriggers$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            closeBarrier = closeBarrier$room_runtime_release;
                        } catch (Throwable th2) {
                            closeBarrier = closeBarrier$room_runtime_release;
                            th = th2;
                            closeBarrier.unblock$room_runtime_release();
                            throw th;
                        }
                    }
                    return Unit.INSTANCE;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    closeBarrier = (CloseBarrier) triggerBasedInvalidationTracker$syncTriggers$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        closeBarrier.unblock$room_runtime_release();
                        throw th;
                    }
                }
                closeBarrier.unblock$room_runtime_release();
                return Unit.INSTANCE;
            }
        }
        triggerBasedInvalidationTracker$syncTriggers$1 = new TriggerBasedInvalidationTracker$syncTriggers$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$syncTriggers$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = triggerBasedInvalidationTracker$syncTriggers$1.label;
        if (i != 0) {
        }
        closeBarrier.unblock$room_runtime_release();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0106, code lost:
        if (androidx.room.TransactorKt.execSQL(r11, r3, r4) == r5) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0106 -> B:29:0x0109). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startTrackingTable(PooledConnection pooledConnection, int i, Continuation<? super Unit> continuation) {
        TriggerBasedInvalidationTracker$startTrackingTable$1 triggerBasedInvalidationTracker$startTrackingTable$1;
        int i2;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker;
        String[] strArr;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker2;
        int i3;
        int i4;
        PooledConnection pooledConnection2;
        int length;
        String str;
        String str2;
        PooledConnection pooledConnection3 = pooledConnection;
        int i5 = i;
        if (continuation instanceof TriggerBasedInvalidationTracker$startTrackingTable$1) {
            triggerBasedInvalidationTracker$startTrackingTable$1 = (TriggerBasedInvalidationTracker$startTrackingTable$1) continuation;
            if ((triggerBasedInvalidationTracker$startTrackingTable$1.label & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$startTrackingTable$1.label -= Integer.MIN_VALUE;
                Object obj = triggerBasedInvalidationTracker$startTrackingTable$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = triggerBasedInvalidationTracker$startTrackingTable$1.label;
                boolean z = true;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str3 = "INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i5 + ", 0)";
                    triggerBasedInvalidationTracker$startTrackingTable$1.L$0 = this;
                    triggerBasedInvalidationTracker$startTrackingTable$1.L$1 = pooledConnection3;
                    triggerBasedInvalidationTracker$startTrackingTable$1.I$0 = i5;
                    triggerBasedInvalidationTracker$startTrackingTable$1.label = 1;
                    if (TransactorKt.execSQL(pooledConnection3, str3, triggerBasedInvalidationTracker$startTrackingTable$1) != coroutine_suspended) {
                        triggerBasedInvalidationTracker = this;
                    }
                    return coroutine_suspended;
                } else if (i2 == 1) {
                    int i6 = triggerBasedInvalidationTracker$startTrackingTable$1.I$0;
                    PooledConnection pooledConnection4 = (PooledConnection) triggerBasedInvalidationTracker$startTrackingTable$1.L$1;
                    triggerBasedInvalidationTracker = (TriggerBasedInvalidationTracker) triggerBasedInvalidationTracker$startTrackingTable$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i5 = i6;
                    pooledConnection3 = pooledConnection4;
                } else if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    length = triggerBasedInvalidationTracker$startTrackingTable$1.I$2;
                    i4 = triggerBasedInvalidationTracker$startTrackingTable$1.I$1;
                    i3 = triggerBasedInvalidationTracker$startTrackingTable$1.I$0;
                    strArr = (String[]) triggerBasedInvalidationTracker$startTrackingTable$1.L$3;
                    str = (String) triggerBasedInvalidationTracker$startTrackingTable$1.L$2;
                    pooledConnection2 = (PooledConnection) triggerBasedInvalidationTracker$startTrackingTable$1.L$1;
                    triggerBasedInvalidationTracker2 = (TriggerBasedInvalidationTracker) triggerBasedInvalidationTracker$startTrackingTable$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    boolean z2 = true;
                    i4++;
                    z = z2;
                    if (i4 >= length) {
                        return Unit.INSTANCE;
                    }
                    z2 = z;
                    String str4 = "CREATE " + (triggerBasedInvalidationTracker2.useTempTable ? "TEMP" : "") + " TRIGGER IF NOT EXISTS `" + Companion.getTriggerName(str, str2) + "` AFTER " + strArr[i4] + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i3 + " AND invalidated = 0; END";
                    triggerBasedInvalidationTracker$startTrackingTable$1.L$0 = triggerBasedInvalidationTracker2;
                    triggerBasedInvalidationTracker$startTrackingTable$1.L$1 = pooledConnection2;
                    triggerBasedInvalidationTracker$startTrackingTable$1.L$2 = str;
                    triggerBasedInvalidationTracker$startTrackingTable$1.L$3 = strArr;
                    triggerBasedInvalidationTracker$startTrackingTable$1.I$0 = i3;
                    triggerBasedInvalidationTracker$startTrackingTable$1.I$1 = i4;
                    triggerBasedInvalidationTracker$startTrackingTable$1.I$2 = length;
                    triggerBasedInvalidationTracker$startTrackingTable$1.label = 2;
                }
                String str5 = triggerBasedInvalidationTracker.tablesNames[i5];
                strArr = TRIGGERS;
                triggerBasedInvalidationTracker2 = triggerBasedInvalidationTracker;
                i3 = i5;
                i4 = 0;
                pooledConnection2 = pooledConnection3;
                length = strArr.length;
                str = str5;
                if (i4 >= length) {
                }
            }
        }
        triggerBasedInvalidationTracker$startTrackingTable$1 = new TriggerBasedInvalidationTracker$startTrackingTable$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$startTrackingTable$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = triggerBasedInvalidationTracker$startTrackingTable$1.label;
        boolean z3 = true;
        if (i2 != 0) {
        }
        String str52 = triggerBasedInvalidationTracker.tablesNames[i5];
        strArr = TRIGGERS;
        triggerBasedInvalidationTracker2 = triggerBasedInvalidationTracker;
        i3 = i5;
        i4 = 0;
        pooledConnection2 = pooledConnection3;
        length = strArr.length;
        str = str52;
        if (i4 >= length) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0085 -> B:20:0x0087). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stopTrackingTable(PooledConnection pooledConnection, int i, Continuation<? super Unit> continuation) {
        TriggerBasedInvalidationTracker$stopTrackingTable$1 triggerBasedInvalidationTracker$stopTrackingTable$1;
        int i2;
        int i3;
        PooledConnection pooledConnection2;
        int length;
        String[] strArr;
        String str;
        if (continuation instanceof TriggerBasedInvalidationTracker$stopTrackingTable$1) {
            triggerBasedInvalidationTracker$stopTrackingTable$1 = (TriggerBasedInvalidationTracker$stopTrackingTable$1) continuation;
            if ((triggerBasedInvalidationTracker$stopTrackingTable$1.label & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$stopTrackingTable$1.label -= Integer.MIN_VALUE;
                Object obj = triggerBasedInvalidationTracker$stopTrackingTable$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = triggerBasedInvalidationTracker$stopTrackingTable$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str2 = this.tablesNames[i];
                    String[] strArr2 = TRIGGERS;
                    i3 = 0;
                    pooledConnection2 = pooledConnection;
                    length = strArr2.length;
                    strArr = strArr2;
                    str = str2;
                    if (i3 < length) {
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    length = triggerBasedInvalidationTracker$stopTrackingTable$1.I$1;
                    int i4 = triggerBasedInvalidationTracker$stopTrackingTable$1.I$0;
                    strArr = (String[]) triggerBasedInvalidationTracker$stopTrackingTable$1.L$2;
                    PooledConnection pooledConnection3 = (PooledConnection) triggerBasedInvalidationTracker$stopTrackingTable$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str = (String) triggerBasedInvalidationTracker$stopTrackingTable$1.L$1;
                    i3 = i4 + 1;
                    pooledConnection2 = pooledConnection3;
                    if (i3 < length) {
                        String str3 = "DROP TRIGGER IF EXISTS `" + Companion.getTriggerName(str, strArr[i3]) + '`';
                        triggerBasedInvalidationTracker$stopTrackingTable$1.L$0 = pooledConnection2;
                        triggerBasedInvalidationTracker$stopTrackingTable$1.L$1 = str;
                        triggerBasedInvalidationTracker$stopTrackingTable$1.L$2 = strArr;
                        triggerBasedInvalidationTracker$stopTrackingTable$1.I$0 = i3;
                        triggerBasedInvalidationTracker$stopTrackingTable$1.I$1 = length;
                        triggerBasedInvalidationTracker$stopTrackingTable$1.label = 1;
                        if (TransactorKt.execSQL(pooledConnection2, str3, triggerBasedInvalidationTracker$stopTrackingTable$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pooledConnection3 = pooledConnection2;
                        i4 = i3;
                        i3 = i4 + 1;
                        pooledConnection2 = pooledConnection3;
                        if (i3 < length) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        triggerBasedInvalidationTracker$stopTrackingTable$1 = new TriggerBasedInvalidationTracker$stopTrackingTable$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$stopTrackingTable$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = triggerBasedInvalidationTracker$stopTrackingTable$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063 A[Catch: all -> 0x0089, TryCatch #0 {all -> 0x0089, blocks: (B:12:0x002f, B:20:0x0058, B:25:0x0063, B:27:0x0067, B:35:0x0081, B:30:0x0074, B:31:0x0077, B:17:0x004b), top: B:41:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077 A[Catch: all -> 0x0089, TryCatch #0 {all -> 0x0089, blocks: (B:12:0x002f, B:20:0x0058, B:25:0x0063, B:27:0x0067, B:35:0x0081, B:30:0x0074, B:31:0x0077, B:17:0x004b), top: B:41:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshInvalidation$room_runtime_release(String[] strArr, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super Boolean> continuation) {
        TriggerBasedInvalidationTracker$refreshInvalidation$1 triggerBasedInvalidationTracker$refreshInvalidation$1;
        int i;
        int[] component2;
        try {
            if (continuation instanceof TriggerBasedInvalidationTracker$refreshInvalidation$1) {
                triggerBasedInvalidationTracker$refreshInvalidation$1 = (TriggerBasedInvalidationTracker$refreshInvalidation$1) continuation;
                if ((triggerBasedInvalidationTracker$refreshInvalidation$1.label & Integer.MIN_VALUE) != 0) {
                    triggerBasedInvalidationTracker$refreshInvalidation$1.label -= Integer.MIN_VALUE;
                    Object obj = triggerBasedInvalidationTracker$refreshInvalidation$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = triggerBasedInvalidationTracker$refreshInvalidation$1.label;
                    boolean z = true;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        component2 = validateTableNames$room_runtime_release(strArr).component2();
                        function0.invoke();
                        triggerBasedInvalidationTracker$refreshInvalidation$1.L$0 = function02;
                        triggerBasedInvalidationTracker$refreshInvalidation$1.L$1 = component2;
                        triggerBasedInvalidationTracker$refreshInvalidation$1.label = 1;
                        obj = notifyInvalidation(triggerBasedInvalidationTracker$refreshInvalidation$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        component2 = (int[]) triggerBasedInvalidationTracker$refreshInvalidation$1.L$1;
                        function02 = (Function0) triggerBasedInvalidationTracker$refreshInvalidation$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    Set set = (Set) obj;
                    if (!(component2.length != 0)) {
                        if (!set.isEmpty()) {
                            return Boxing.boxBoolean(z);
                        }
                        z = false;
                        return Boxing.boxBoolean(z);
                    }
                    for (int i2 : component2) {
                        if (set.contains(Boxing.boxInt(i2))) {
                            break;
                        }
                    }
                    z = false;
                    return Boxing.boxBoolean(z);
                }
            }
            if (i != 0) {
            }
            Set set2 = (Set) obj;
            if (!(component2.length != 0)) {
            }
        } finally {
            function02.invoke();
        }
        triggerBasedInvalidationTracker$refreshInvalidation$1 = new TriggerBasedInvalidationTracker$refreshInvalidation$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$refreshInvalidation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = triggerBasedInvalidationTracker$refreshInvalidation$1.label;
        boolean z2 = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object refreshInvalidation$room_runtime_release$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, String[] strArr, Function0 function0, Function0 function02, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        return triggerBasedInvalidationTracker.refreshInvalidation$room_runtime_release(strArr, function0, function02, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshInvalidationAsync$room_runtime_release$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i & 2) != 0) {
            function02 = new Function0() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        triggerBasedInvalidationTracker.refreshInvalidationAsync$room_runtime_release(function0, function02);
    }

    public final void refreshInvalidationAsync$room_runtime_release(Function0<Unit> onRefreshScheduled, Function0<Unit> onRefreshCompleted) {
        Intrinsics.checkNotNullParameter(onRefreshScheduled, "onRefreshScheduled");
        Intrinsics.checkNotNullParameter(onRefreshCompleted, "onRefreshCompleted");
        if (this.pendingRefresh.compareAndSet(false, true)) {
            onRefreshScheduled.invoke();
            BuildersKt__Builders_commonKt.launch$default(this.database.getCoroutineScope(), new CoroutineName("Room Invalidation Tracker Refresh"), null, new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this, onRefreshCompleted, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098 A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:12:0x002e, B:34:0x008d, B:36:0x0098), top: B:45:0x002e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object notifyInvalidation(Continuation<? super Set<Integer>> continuation) {
        TriggerBasedInvalidationTracker$notifyInvalidation$1 triggerBasedInvalidationTracker$notifyInvalidation$1;
        int i;
        CloseBarrier closeBarrier;
        Throwable th;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker;
        Set<Integer> set;
        if (continuation instanceof TriggerBasedInvalidationTracker$notifyInvalidation$1) {
            triggerBasedInvalidationTracker$notifyInvalidation$1 = (TriggerBasedInvalidationTracker$notifyInvalidation$1) continuation;
            if ((triggerBasedInvalidationTracker$notifyInvalidation$1.label & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$notifyInvalidation$1.label -= Integer.MIN_VALUE;
                Object obj = triggerBasedInvalidationTracker$notifyInvalidation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = triggerBasedInvalidationTracker$notifyInvalidation$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CloseBarrier closeBarrier$room_runtime_release = this.database.getCloseBarrier$room_runtime_release();
                    if (closeBarrier$room_runtime_release.block$room_runtime_release()) {
                        try {
                            if (!this.pendingRefresh.compareAndSet(true, false)) {
                                Set emptySet = SetsKt.emptySet();
                                closeBarrier$room_runtime_release.unblock$room_runtime_release();
                                return emptySet;
                            } else if (!this.onAllowRefresh.invoke().booleanValue()) {
                                Set emptySet2 = SetsKt.emptySet();
                                closeBarrier$room_runtime_release.unblock$room_runtime_release();
                                return emptySet2;
                            } else {
                                triggerBasedInvalidationTracker$notifyInvalidation$1.L$0 = this;
                                triggerBasedInvalidationTracker$notifyInvalidation$1.L$1 = closeBarrier$room_runtime_release;
                                triggerBasedInvalidationTracker$notifyInvalidation$1.label = 1;
                                Object useConnection$room_runtime_release = this.database.useConnection$room_runtime_release(false, new TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(this, null), triggerBasedInvalidationTracker$notifyInvalidation$1);
                                if (useConnection$room_runtime_release == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                closeBarrier = closeBarrier$room_runtime_release;
                                obj = useConnection$room_runtime_release;
                                triggerBasedInvalidationTracker = this;
                            }
                        } catch (Throwable th2) {
                            closeBarrier = closeBarrier$room_runtime_release;
                            th = th2;
                            closeBarrier.unblock$room_runtime_release();
                            throw th;
                        }
                    } else {
                        return SetsKt.emptySet();
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    closeBarrier = (CloseBarrier) triggerBasedInvalidationTracker$notifyInvalidation$1.L$1;
                    triggerBasedInvalidationTracker = (TriggerBasedInvalidationTracker) triggerBasedInvalidationTracker$notifyInvalidation$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        closeBarrier.unblock$room_runtime_release();
                        throw th;
                    }
                }
                set = (Set) obj;
                if (!set.isEmpty()) {
                    triggerBasedInvalidationTracker.observedTableVersions.increment(set);
                    triggerBasedInvalidationTracker.onInvalidatedTablesIds.invoke(set);
                }
                closeBarrier.unblock$room_runtime_release();
                return set;
            }
        }
        triggerBasedInvalidationTracker$notifyInvalidation$1 = new TriggerBasedInvalidationTracker$notifyInvalidation$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$notifyInvalidation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = triggerBasedInvalidationTracker$notifyInvalidation$1.label;
        if (i != 0) {
        }
        set = (Set) obj2;
        if (!set.isEmpty()) {
        }
        closeBarrier.unblock$room_runtime_release();
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        if (r7 == r1) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkInvalidatedTables(PooledConnection pooledConnection, Continuation<? super Set<Integer>> continuation) {
        TriggerBasedInvalidationTracker$checkInvalidatedTables$1 triggerBasedInvalidationTracker$checkInvalidatedTables$1;
        int i;
        Set set;
        if (continuation instanceof TriggerBasedInvalidationTracker$checkInvalidatedTables$1) {
            triggerBasedInvalidationTracker$checkInvalidatedTables$1 = (TriggerBasedInvalidationTracker$checkInvalidatedTables$1) continuation;
            if ((triggerBasedInvalidationTracker$checkInvalidatedTables$1.label & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$checkInvalidatedTables$1.label -= Integer.MIN_VALUE;
                Object obj = triggerBasedInvalidationTracker$checkInvalidatedTables$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = triggerBasedInvalidationTracker$checkInvalidatedTables$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = new Function1() { // from class: androidx.room.TriggerBasedInvalidationTracker$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Set checkInvalidatedTables$lambda$14;
                            checkInvalidatedTables$lambda$14 = TriggerBasedInvalidationTracker.checkInvalidatedTables$lambda$14((SQLiteStatement) obj2);
                            return checkInvalidatedTables$lambda$14;
                        }
                    };
                    triggerBasedInvalidationTracker$checkInvalidatedTables$1.L$0 = pooledConnection;
                    triggerBasedInvalidationTracker$checkInvalidatedTables$1.label = 1;
                    obj = pooledConnection.usePrepared(SELECT_UPDATED_TABLES_SQL, function1, triggerBasedInvalidationTracker$checkInvalidatedTables$1);
                } else if (i != 1) {
                    if (i == 2) {
                        Set set2 = (Set) triggerBasedInvalidationTracker$checkInvalidatedTables$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return set2;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    pooledConnection = (PooledConnection) triggerBasedInvalidationTracker$checkInvalidatedTables$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                set = (Set) obj;
                if (!set.isEmpty()) {
                    triggerBasedInvalidationTracker$checkInvalidatedTables$1.L$0 = set;
                    triggerBasedInvalidationTracker$checkInvalidatedTables$1.label = 2;
                    if (TransactorKt.execSQL(pooledConnection, RESET_UPDATED_TABLES_SQL, triggerBasedInvalidationTracker$checkInvalidatedTables$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return set;
            }
        }
        triggerBasedInvalidationTracker$checkInvalidatedTables$1 = new TriggerBasedInvalidationTracker$checkInvalidatedTables$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$checkInvalidatedTables$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = triggerBasedInvalidationTracker$checkInvalidatedTables$1.label;
        if (i != 0) {
        }
        set = (Set) obj2;
        if (!set.isEmpty()) {
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set checkInvalidatedTables$lambda$14(SQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        Set createSetBuilder = SetsKt.createSetBuilder();
        while (statement.step()) {
            createSetBuilder.add(Integer.valueOf((int) statement.getLong(0)));
        }
        return SetsKt.build(createSetBuilder);
    }

    public final void resetSync$room_runtime_release() {
        this.observedTableStates.resetTriggerState$room_runtime_release();
    }

    /* compiled from: InvalidationTracker.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/TriggerBasedInvalidationTracker$Companion;", "", "<init>", "()V", "TRIGGERS", "", "", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "TABLE_ID_COLUMN_NAME", "INVALIDATED_COLUMN_NAME", "CREATE_TRACKING_TABLE_SQL", "DROP_TRACKING_TABLE_SQL", "SELECT_UPDATED_TABLES_SQL", "RESET_UPDATED_TABLES_SQL", "getTriggerName", "tableName", "triggerType", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getTriggerName(String str, String str2) {
            return "room_table_modification_trigger_" + str + '_' + str2;
        }
    }
}
