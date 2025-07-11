package com.miami.game.core.server.data;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
/* compiled from: FavoriteServerDao_Impl.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u0011H\u0016J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0096@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/miami/game/core/server/data/FavoriteServerDao_Impl;", "Lcom/miami/game/core/server/data/FavoriteServerDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfFavoriteServerEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/miami/game/core/server/data/FavoriteServerEntity;", "__deleteAdapterOfFavoriteServerEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "addFavorite", "", "server", "(Lcom/miami/game/core/server/data/FavoriteServerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromFavorite", "getAllFlowFavoriteServers", "Lkotlinx/coroutines/flow/Flow;", "", "getAllFavoriteServers", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dropTable", "Companion", "server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FavoriteServerDao_Impl implements FavoriteServerDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<FavoriteServerEntity> __deleteAdapterOfFavoriteServerEntity;
    private final EntityInsertAdapter<FavoriteServerEntity> __insertAdapterOfFavoriteServerEntity;

    public FavoriteServerDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfFavoriteServerEntity = new EntityInsertAdapter<FavoriteServerEntity>() { // from class: com.miami.game.core.server.data.FavoriteServerDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `favorite_server_table` (`serverId`,`serverName`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, FavoriteServerEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo7568bindLong(1, entity.getServerId());
                statement.mo7570bindText(2, entity.getServerName());
            }
        };
        this.__deleteAdapterOfFavoriteServerEntity = new EntityDeleteOrUpdateAdapter<FavoriteServerEntity>() { // from class: com.miami.game.core.server.data.FavoriteServerDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `favorite_server_table` WHERE `serverId` = ? AND `serverName` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, FavoriteServerEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo7568bindLong(1, entity.getServerId());
                statement.mo7570bindText(2, entity.getServerName());
            }
        };
    }

    @Override // com.miami.game.core.server.data.FavoriteServerDao
    public Object addFavorite(final FavoriteServerEntity favoriteServerEntity, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.miami.game.core.server.data.FavoriteServerDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit addFavorite$lambda$0;
                addFavorite$lambda$0 = FavoriteServerDao_Impl.addFavorite$lambda$0(FavoriteServerDao_Impl.this, favoriteServerEntity, (SQLiteConnection) obj);
                return addFavorite$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addFavorite$lambda$0(FavoriteServerDao_Impl favoriteServerDao_Impl, FavoriteServerEntity favoriteServerEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        favoriteServerDao_Impl.__insertAdapterOfFavoriteServerEntity.insert(_connection, (SQLiteConnection) favoriteServerEntity);
        return Unit.INSTANCE;
    }

    @Override // com.miami.game.core.server.data.FavoriteServerDao
    public Object removeFromFavorite(final FavoriteServerEntity favoriteServerEntity, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.miami.game.core.server.data.FavoriteServerDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit removeFromFavorite$lambda$1;
                removeFromFavorite$lambda$1 = FavoriteServerDao_Impl.removeFromFavorite$lambda$1(FavoriteServerDao_Impl.this, favoriteServerEntity, (SQLiteConnection) obj);
                return removeFromFavorite$lambda$1;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit removeFromFavorite$lambda$1(FavoriteServerDao_Impl favoriteServerDao_Impl, FavoriteServerEntity favoriteServerEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        favoriteServerDao_Impl.__deleteAdapterOfFavoriteServerEntity.handle(_connection, favoriteServerEntity);
        return Unit.INSTANCE;
    }

    @Override // com.miami.game.core.server.data.FavoriteServerDao
    public Flow<List<FavoriteServerEntity>> getAllFlowFavoriteServers() {
        return FlowUtil.createFlow(this.__db, false, new String[]{"favorite_server_table"}, new Function1() { // from class: com.miami.game.core.server.data.FavoriteServerDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List allFlowFavoriteServers$lambda$2;
                allFlowFavoriteServers$lambda$2 = FavoriteServerDao_Impl.getAllFlowFavoriteServers$lambda$2(r1, (SQLiteConnection) obj);
                return allFlowFavoriteServers$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllFlowFavoriteServers$lambda$2(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverName");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(new FavoriteServerEntity((int) prepare.getLong(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2)));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // com.miami.game.core.server.data.FavoriteServerDao
    public Object getAllFavoriteServers(Continuation<? super List<FavoriteServerEntity>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.miami.game.core.server.data.FavoriteServerDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List allFavoriteServers$lambda$3;
                allFavoriteServers$lambda$3 = FavoriteServerDao_Impl.getAllFavoriteServers$lambda$3(r1, (SQLiteConnection) obj);
                return allFavoriteServers$lambda$3;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllFavoriteServers$lambda$3(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverName");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(new FavoriteServerEntity((int) prepare.getLong(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2)));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // com.miami.game.core.server.data.FavoriteServerDao
    public Object dropTable(Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.miami.game.core.server.data.FavoriteServerDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit dropTable$lambda$4;
                dropTable$lambda$4 = FavoriteServerDao_Impl.dropTable$lambda$4(r1, (SQLiteConnection) obj);
                return dropTable$lambda$4;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dropTable$lambda$4(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.step();
            prepare.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* compiled from: FavoriteServerDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/server/data/FavoriteServerDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
