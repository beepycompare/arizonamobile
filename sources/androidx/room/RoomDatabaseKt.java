package androidx.room;

import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
@Metadata(d1 = {"androidx/room/RoomDatabaseKt__RoomDatabaseKt", "androidx/room/RoomDatabaseKt__RoomDatabase_androidKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RoomDatabaseKt {
    @Deprecated(message = "Replaced by equivalent API in InvalidationTracker.", replaceWith = @ReplaceWith(expression = "this.invalidationTracker.createFlow(*tables)", imports = {}))
    public static final Flow<Set<String>> invalidationTrackerFlow(RoomDatabase roomDatabase, String[] strArr, boolean z) {
        return RoomDatabaseKt__RoomDatabase_androidKt.invalidationTrackerFlow(roomDatabase, strArr, z);
    }

    public static final <R> Object useReaderConnection(RoomDatabase roomDatabase, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return RoomDatabaseKt__RoomDatabaseKt.useReaderConnection(roomDatabase, function2, continuation);
    }

    public static final <R> Object useWriterConnection(RoomDatabase roomDatabase, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return RoomDatabaseKt__RoomDatabaseKt.useWriterConnection(roomDatabase, function2, continuation);
    }

    public static final void validateAutoMigrations(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.validateAutoMigrations(roomDatabase, databaseConfiguration);
    }

    public static final void validateMigrationsNotRequired(Set<Integer> set, Set<Integer> set2) {
        RoomDatabaseKt__RoomDatabaseKt.validateMigrationsNotRequired(set, set2);
    }

    public static final void validateTypeConverters(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.validateTypeConverters(roomDatabase, databaseConfiguration);
    }

    public static final <R> Object withTransaction(RoomDatabase roomDatabase, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        return RoomDatabaseKt__RoomDatabase_androidKt.withTransaction(roomDatabase, function1, continuation);
    }

    public static final <R> Object withTransactionContext(RoomDatabase roomDatabase, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        return RoomDatabaseKt__RoomDatabase_androidKt.withTransactionContext(roomDatabase, function1, continuation);
    }
}
