package androidx.room;

import androidx.media3.common.C;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.room.BaseRoomConnectionManager;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.concurrent.ExclusiveLock;
import androidx.room.migration.Migration;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.SQLiteStatement;
import com.liulishuo.okdownload.core.breakpoint.BreakpointSQLiteKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: RoomConnectionManager.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 ;2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u00122\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018H¦@¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0010¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0004J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010*\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010+\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010,\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0004J\u0010\u00100\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0004J\u0010\u00102\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u00103\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002J\f\u00104\u001a\u00020.*\u000205H\u0004J\f\u00106\u001a\u00020.*\u000205H\u0004J\u0010\u00107\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u00109\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002R\u0012\u0010\u0004\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Landroidx/room/BaseRoomConnectionManager;", "", "<init>", "()V", "configuration", "Landroidx/room/DatabaseConfiguration;", "getConfiguration", "()Landroidx/room/DatabaseConfiguration;", "openDelegate", "Landroidx/room/RoomOpenDelegate;", "getOpenDelegate", "()Landroidx/room/RoomOpenDelegate;", "callbacks", "", "Landroidx/room/RoomDatabase$Callback;", "getCallbacks", "()Ljava/util/List;", "isConfigured", "", "isInitializing", "useConnection", "R", "isReadOnly", "block", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveFileName", "", "fileName", "resolveFileName$room_runtime_release", "configureDatabase", "", "connection", "Landroidx/sqlite/SQLiteConnection;", "configurationConnection", "configureJournalMode", "configureSynchronousFlag", "configureBusyTimeout", "onCreate", "hasEmptySchema", "updateIdentity", "createMasterTableIfNotExists", "onMigrate", "oldVersion", "", "newVersion", "dropAllTables", "onOpen", "checkIdentity", "hasRoomMasterTable", "getMaxNumberOfReaders", "Landroidx/room/RoomDatabase$JournalMode;", "getMaxNumberOfWriters", "invokeCreateCallback", "invokeDestructiveMigrationCallback", "invokeOpenCallback", "DriverWrapper", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseRoomConnectionManager {
    public static final int BUSY_TIMEOUT_MS = 3000;
    public static final Companion Companion = new Companion(null);
    private boolean isConfigured;
    private boolean isInitializing;

    /* compiled from: RoomConnectionManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RoomDatabase.JournalMode.values().length];
            try {
                iArr[RoomDatabase.JournalMode.TRUNCATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    protected abstract List<RoomDatabase.Callback> getCallbacks();

    protected abstract DatabaseConfiguration getConfiguration();

    protected abstract RoomOpenDelegate getOpenDelegate();

    public String resolveFileName$room_runtime_release(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return fileName;
    }

    public abstract <R> Object useConnection(boolean z, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation);

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: RoomConnectionManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0084\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/room/BaseRoomConnectionManager$DriverWrapper;", "Landroidx/sqlite/SQLiteDriver;", "actual", "<init>", "(Landroidx/room/BaseRoomConnectionManager;Landroidx/sqlite/SQLiteDriver;)V", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "Landroidx/sqlite/SQLiteConnection;", "fileName", "", "openLocked", BreakpointSQLiteKey.FILENAME, "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class DriverWrapper implements SQLiteDriver {
        private final SQLiteDriver actual;
        final /* synthetic */ BaseRoomConnectionManager this$0;

        public DriverWrapper(BaseRoomConnectionManager baseRoomConnectionManager, SQLiteDriver actual) {
            Intrinsics.checkNotNullParameter(actual, "actual");
            this.this$0 = baseRoomConnectionManager;
            this.actual = actual;
        }

        @Override // androidx.sqlite.SQLiteDriver
        public SQLiteConnection open(String fileName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return openLocked(this.this$0.resolveFileName$room_runtime_release(fileName));
        }

        private final SQLiteConnection openLocked(final String str) {
            ExclusiveLock exclusiveLock = new ExclusiveLock(str, (this.this$0.isConfigured || this.this$0.isInitializing || Intrinsics.areEqual(str, ":memory:")) ? false : true);
            final BaseRoomConnectionManager baseRoomConnectionManager = this.this$0;
            return (SQLiteConnection) exclusiveLock.withLock(new Function0() { // from class: androidx.room.BaseRoomConnectionManager$DriverWrapper$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SQLiteConnection openLocked$lambda$1;
                    openLocked$lambda$1 = BaseRoomConnectionManager.DriverWrapper.openLocked$lambda$1(BaseRoomConnectionManager.this, this, str);
                    return openLocked$lambda$1;
                }
            }, new Function1() { // from class: androidx.room.BaseRoomConnectionManager$DriverWrapper$openLocked$2
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Throwable error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    throw new IllegalStateException("Unable to open database '" + str + "'. Was a proper path / name used in Room's database builder?", error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SQLiteConnection openLocked$lambda$1(BaseRoomConnectionManager baseRoomConnectionManager, DriverWrapper driverWrapper, String str) {
            if (baseRoomConnectionManager.isInitializing) {
                throw new IllegalStateException("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?".toString());
            }
            SQLiteConnection open = driverWrapper.actual.open(str);
            if (!baseRoomConnectionManager.isConfigured) {
                try {
                    baseRoomConnectionManager.isInitializing = true;
                    baseRoomConnectionManager.configureDatabase(open);
                    return open;
                } finally {
                    baseRoomConnectionManager.isInitializing = false;
                }
            }
            baseRoomConnectionManager.configurationConnection(open);
            return open;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureDatabase(SQLiteConnection sQLiteConnection) {
        Object m8471constructorimpl;
        configureJournalMode(sQLiteConnection);
        configureSynchronousFlag(sQLiteConnection);
        configureBusyTimeout(sQLiteConnection);
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA user_version");
        try {
            SQLiteStatement sQLiteStatement = prepare;
            sQLiteStatement.step();
            int i = (int) sQLiteStatement.getLong(0);
            AutoCloseableKt.closeFinally(prepare, null);
            if (i != getOpenDelegate().getVersion()) {
                SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    Result.Companion companion = Result.Companion;
                    BaseRoomConnectionManager baseRoomConnectionManager = this;
                    if (i == 0) {
                        onCreate(sQLiteConnection);
                    } else {
                        onMigrate(sQLiteConnection, i, getOpenDelegate().getVersion());
                    }
                    SQLite.execSQL(sQLiteConnection, "PRAGMA user_version = " + getOpenDelegate().getVersion());
                    m8471constructorimpl = Result.m8471constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m8471constructorimpl = Result.m8471constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m8478isSuccessimpl(m8471constructorimpl)) {
                    Unit unit = (Unit) m8471constructorimpl;
                    SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
                }
                Throwable m8474exceptionOrNullimpl = Result.m8474exceptionOrNullimpl(m8471constructorimpl);
                if (m8474exceptionOrNullimpl != null) {
                    SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
                    throw m8474exceptionOrNullimpl;
                }
            }
            onOpen(sQLiteConnection);
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configurationConnection(SQLiteConnection sQLiteConnection) {
        configureSynchronousFlag(sQLiteConnection);
        configureBusyTimeout(sQLiteConnection);
        getOpenDelegate().onOpen(sQLiteConnection);
    }

    private final void configureJournalMode(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = WAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    private final void configureSynchronousFlag(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = NORMAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = FULL");
        }
    }

    private final void configureBusyTimeout(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA busy_timeout");
        try {
            SQLiteStatement sQLiteStatement = prepare;
            sQLiteStatement.step();
            long j = sQLiteStatement.getLong(0);
            AutoCloseableKt.closeFinally(prepare, null);
            if (j < C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                SQLite.execSQL(sQLiteConnection, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(prepare, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onCreate(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        boolean hasEmptySchema = hasEmptySchema(connection);
        getOpenDelegate().createAllTables(connection);
        if (!hasEmptySchema) {
            RoomOpenDelegate.ValidationResult onValidateSchema = getOpenDelegate().onValidateSchema(connection);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg).toString());
            }
        }
        updateIdentity(connection);
        getOpenDelegate().onCreate(connection);
        invokeCreateCallback(connection);
    }

    private final boolean hasEmptySchema(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            SQLiteStatement sQLiteStatement = prepare;
            boolean z = false;
            if (sQLiteStatement.step()) {
                if (sQLiteStatement.getLong(0) == 0) {
                    z = true;
                }
            }
            AutoCloseableKt.closeFinally(prepare, null);
            return z;
        } finally {
        }
    }

    private final void updateIdentity(SQLiteConnection sQLiteConnection) {
        createMasterTableIfNotExists(sQLiteConnection);
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.createInsertQuery(getOpenDelegate().getIdentityHash()));
    }

    private final void createMasterTableIfNotExists(SQLiteConnection sQLiteConnection) {
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.CREATE_QUERY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onMigrate(SQLiteConnection connection, int i, int i2) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        List<Migration> findMigrationPath = MigrationUtil.findMigrationPath(getConfiguration().migrationContainer, i, i2);
        if (findMigrationPath != null) {
            getOpenDelegate().onPreMigrate(connection);
            for (Migration migration : findMigrationPath) {
                migration.migrate(connection);
            }
            RoomOpenDelegate.ValidationResult onValidateSchema = getOpenDelegate().onValidateSchema(connection);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException(("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg).toString());
            }
            getOpenDelegate().onPostMigrate(connection);
            updateIdentity(connection);
        } else if (MigrationUtil.isMigrationRequired(getConfiguration(), i, i2)) {
            throw new IllegalStateException(("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
        } else {
            dropAllTables(connection);
            invokeDestructiveMigrationCallback(connection);
            getOpenDelegate().createAllTables(connection);
        }
    }

    private final void dropAllTables(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().allowDestructiveMigrationForAllTables) {
            SQLiteStatement prepare = sQLiteConnection.prepare("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                SQLiteStatement sQLiteStatement = prepare;
                List createListBuilder = CollectionsKt.createListBuilder();
                while (sQLiteStatement.step()) {
                    String text = sQLiteStatement.getText(0);
                    if (!StringsKt.startsWith$default(text, "sqlite_", false, 2, (Object) null) && !Intrinsics.areEqual(text, "android_metadata")) {
                        createListBuilder.add(TuplesKt.to(text, Boolean.valueOf(Intrinsics.areEqual(sQLiteStatement.getText(1), "view"))));
                    }
                }
                List<Pair> build = CollectionsKt.build(createListBuilder);
                AutoCloseableKt.closeFinally(prepare, null);
                for (Pair pair : build) {
                    String str = (String) pair.component1();
                    if (((Boolean) pair.component2()).booleanValue()) {
                        SQLite.execSQL(sQLiteConnection, "DROP VIEW IF EXISTS " + str);
                    } else {
                        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        } else {
            getOpenDelegate().dropAllTables(sQLiteConnection);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onOpen(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        checkIdentity(connection);
        getOpenDelegate().onOpen(connection);
        invokeOpenCallback(connection);
        this.isConfigured = true;
    }

    private final void checkIdentity(SQLiteConnection sQLiteConnection) {
        Object m8471constructorimpl;
        RoomOpenDelegate.ValidationResult onValidateSchema;
        if (hasRoomMasterTable(sQLiteConnection)) {
            SQLiteStatement prepare = sQLiteConnection.prepare(RoomMasterTable.READ_QUERY);
            try {
                SQLiteStatement sQLiteStatement = prepare;
                String text = sQLiteStatement.step() ? sQLiteStatement.getText(0) : null;
                AutoCloseableKt.closeFinally(prepare, null);
                if (!Intrinsics.areEqual(getOpenDelegate().getIdentityHash(), text) && !Intrinsics.areEqual(getOpenDelegate().getLegacyIdentityHash(), text)) {
                    throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + getOpenDelegate().getIdentityHash() + ", found: " + text).toString());
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(prepare, th);
                    throw th2;
                }
            }
        }
        SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            Result.Companion companion = Result.Companion;
            BaseRoomConnectionManager baseRoomConnectionManager = this;
            onValidateSchema = getOpenDelegate().onValidateSchema(sQLiteConnection);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            m8471constructorimpl = Result.m8471constructorimpl(ResultKt.createFailure(th3));
        }
        if (!onValidateSchema.isValid) {
            throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg).toString());
        }
        getOpenDelegate().onPostMigrate(sQLiteConnection);
        updateIdentity(sQLiteConnection);
        m8471constructorimpl = Result.m8471constructorimpl(Unit.INSTANCE);
        if (Result.m8478isSuccessimpl(m8471constructorimpl)) {
            Unit unit = (Unit) m8471constructorimpl;
            SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
        }
        Throwable m8474exceptionOrNullimpl = Result.m8474exceptionOrNullimpl(m8471constructorimpl);
        if (m8474exceptionOrNullimpl != null) {
            SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
            throw m8474exceptionOrNullimpl;
        } else {
            Result.m8470boximpl(m8471constructorimpl);
        }
    }

    private final boolean hasRoomMasterTable(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            SQLiteStatement sQLiteStatement = prepare;
            boolean z = false;
            if (sQLiteStatement.step()) {
                if (sQLiteStatement.getLong(0) != 0) {
                    z = true;
                }
            }
            AutoCloseableKt.closeFinally(prepare, null);
            return z;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMaxNumberOfReaders(RoomDatabase.JournalMode journalMode) {
        Intrinsics.checkNotNullParameter(journalMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 4;
            }
            throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMaxNumberOfWriters(RoomDatabase.JournalMode journalMode) {
        Intrinsics.checkNotNullParameter(journalMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i == 1 || i == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
    }

    private final void invokeCreateCallback(SQLiteConnection sQLiteConnection) {
        for (RoomDatabase.Callback callback : getCallbacks()) {
            callback.onCreate(sQLiteConnection);
        }
    }

    private final void invokeDestructiveMigrationCallback(SQLiteConnection sQLiteConnection) {
        for (RoomDatabase.Callback callback : getCallbacks()) {
            callback.onDestructiveMigration(sQLiteConnection);
        }
    }

    private final void invokeOpenCallback(SQLiteConnection sQLiteConnection) {
        for (RoomDatabase.Callback callback : getCallbacks()) {
            callback.onOpen(sQLiteConnection);
        }
    }

    /* compiled from: RoomConnectionManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/room/BaseRoomConnectionManager$Companion;", "", "<init>", "()V", "BUSY_TIMEOUT_MS", "", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
