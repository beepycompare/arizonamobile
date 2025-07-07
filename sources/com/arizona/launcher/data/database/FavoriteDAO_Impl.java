package com.arizona.launcher.data.database;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RxRoom;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.arizona.launcher.model.servers.FavoriteServer;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
/* compiled from: FavoriteDAO_Impl.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/data/database/FavoriteDAO_Impl;", "Lcom/arizona/launcher/data/database/FavoriteDAO;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfFavoriteServer", "Landroidx/room/EntityInsertAdapter;", "Lcom/arizona/launcher/model/servers/FavoriteServer;", "__deleteAdapterOfFavoriteServer", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "addFavorite", "Lio/reactivex/Completable;", "server", "removeFromFavorite", "getAllFavoriteServers", "Lio/reactivex/Observable;", "", "dropTable", "", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FavoriteDAO_Impl implements FavoriteDAO {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<FavoriteServer> __deleteAdapterOfFavoriteServer;
    private final EntityInsertAdapter<FavoriteServer> __insertAdapterOfFavoriteServer;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FavoriteDAO_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfFavoriteServer = new EntityInsertAdapter<FavoriteServer>() { // from class: com.arizona.launcher.data.database.FavoriteDAO_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `FavoriteServer` (`serverId`,`serverType`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, FavoriteServer entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo7567bindLong(1, entity.getServerId());
                statement.mo7569bindText(2, entity.getServerType());
            }
        };
        this.__deleteAdapterOfFavoriteServer = new EntityDeleteOrUpdateAdapter<FavoriteServer>() { // from class: com.arizona.launcher.data.database.FavoriteDAO_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `FavoriteServer` WHERE `serverId` = ? AND `serverType` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, FavoriteServer entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo7567bindLong(1, entity.getServerId());
                statement.mo7569bindText(2, entity.getServerType());
            }
        };
    }

    @Override // com.arizona.launcher.data.database.FavoriteDAO
    public Completable addFavorite(final FavoriteServer server) {
        Intrinsics.checkNotNullParameter(server, "server");
        return RxRoom.Companion.createCompletable(this.__db, false, true, new Function1() { // from class: com.arizona.launcher.data.database.FavoriteDAO_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit addFavorite$lambda$0;
                addFavorite$lambda$0 = FavoriteDAO_Impl.addFavorite$lambda$0(FavoriteDAO_Impl.this, server, (SQLiteConnection) obj);
                return addFavorite$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addFavorite$lambda$0(FavoriteDAO_Impl favoriteDAO_Impl, FavoriteServer favoriteServer, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        favoriteDAO_Impl.__insertAdapterOfFavoriteServer.insert(_connection, (SQLiteConnection) favoriteServer);
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.data.database.FavoriteDAO
    public Completable removeFromFavorite(final FavoriteServer server) {
        Intrinsics.checkNotNullParameter(server, "server");
        return RxRoom.Companion.createCompletable(this.__db, false, true, new Function1() { // from class: com.arizona.launcher.data.database.FavoriteDAO_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit removeFromFavorite$lambda$1;
                removeFromFavorite$lambda$1 = FavoriteDAO_Impl.removeFromFavorite$lambda$1(FavoriteDAO_Impl.this, server, (SQLiteConnection) obj);
                return removeFromFavorite$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit removeFromFavorite$lambda$1(FavoriteDAO_Impl favoriteDAO_Impl, FavoriteServer favoriteServer, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        favoriteDAO_Impl.__deleteAdapterOfFavoriteServer.handle(_connection, favoriteServer);
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.data.database.FavoriteDAO
    public Observable<List<FavoriteServer>> getAllFavoriteServers() {
        return RxRoom.Companion.createObservable(this.__db, false, new String[]{"favoriteserver"}, new Function1() { // from class: com.arizona.launcher.data.database.FavoriteDAO_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List allFavoriteServers$lambda$2;
                allFavoriteServers$lambda$2 = FavoriteDAO_Impl.getAllFavoriteServers$lambda$2(r1, (SQLiteConnection) obj);
                return allFavoriteServers$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllFavoriteServers$lambda$2(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverType");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(new FavoriteServer((int) prepare.getLong(columnIndexOrThrow), prepare.getText(columnIndexOrThrow2)));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // com.arizona.launcher.data.database.FavoriteDAO
    public void dropTable() {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: com.arizona.launcher.data.database.FavoriteDAO_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit dropTable$lambda$3;
                dropTable$lambda$3 = FavoriteDAO_Impl.dropTable$lambda$3(r1, (SQLiteConnection) obj);
                return dropTable$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dropTable$lambda$3(String str, SQLiteConnection _connection) {
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

    /* compiled from: FavoriteDAO_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/data/database/FavoriteDAO_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
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
