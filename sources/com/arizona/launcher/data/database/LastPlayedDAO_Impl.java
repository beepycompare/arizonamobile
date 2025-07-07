package com.arizona.launcher.data.database;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RxRoom;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.arizona.launcher.model.servers.LastPlayedServer;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import ru.mrlargha.commonui.utils.DateConverter;
/* compiled from: LastPlayedDAO_Impl.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/data/database/LastPlayedDAO_Impl;", "Lcom/arizona/launcher/data/database/LastPlayedDAO;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfLastPlayedServer", "Landroidx/room/EntityInsertAdapter;", "Lcom/arizona/launcher/model/servers/LastPlayedServer;", "__dateConverter", "Lru/mrlargha/commonui/utils/DateConverter;", "addLastPlayed", "Lio/reactivex/Completable;", "server", "getLastPlayedServers", "Lio/reactivex/Observable;", "", "dropTable", "", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LastPlayedDAO_Impl implements LastPlayedDAO {
    private final DateConverter __dateConverter;
    private final RoomDatabase __db;
    private final EntityInsertAdapter<LastPlayedServer> __insertAdapterOfLastPlayedServer;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public LastPlayedDAO_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__dateConverter = new DateConverter();
        this.__db = __db;
        this.__insertAdapterOfLastPlayedServer = new EntityInsertAdapter<LastPlayedServer>() { // from class: com.arizona.launcher.data.database.LastPlayedDAO_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `lastplayed` (`serverId`,`serverType`,`date`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, LastPlayedServer entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo7567bindLong(1, entity.getServerId());
                statement.mo7569bindText(2, entity.getServerType());
                Long dateToTimestamp = LastPlayedDAO_Impl.this.__dateConverter.dateToTimestamp(entity.getDate());
                if (dateToTimestamp == null) {
                    statement.mo7568bindNull(3);
                } else {
                    statement.mo7567bindLong(3, dateToTimestamp.longValue());
                }
            }
        };
    }

    @Override // com.arizona.launcher.data.database.LastPlayedDAO
    public Completable addLastPlayed(final LastPlayedServer server) {
        Intrinsics.checkNotNullParameter(server, "server");
        return RxRoom.Companion.createCompletable(this.__db, false, true, new Function1() { // from class: com.arizona.launcher.data.database.LastPlayedDAO_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit addLastPlayed$lambda$0;
                addLastPlayed$lambda$0 = LastPlayedDAO_Impl.addLastPlayed$lambda$0(LastPlayedDAO_Impl.this, server, (SQLiteConnection) obj);
                return addLastPlayed$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addLastPlayed$lambda$0(LastPlayedDAO_Impl lastPlayedDAO_Impl, LastPlayedServer lastPlayedServer, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        lastPlayedDAO_Impl.__insertAdapterOfLastPlayedServer.insert(_connection, (SQLiteConnection) lastPlayedServer);
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.data.database.LastPlayedDAO
    public Observable<List<LastPlayedServer>> getLastPlayedServers() {
        return RxRoom.Companion.createObservable(this.__db, false, new String[]{"lastplayed"}, new Function1() { // from class: com.arizona.launcher.data.database.LastPlayedDAO_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List lastPlayedServers$lambda$1;
                lastPlayedServers$lambda$1 = LastPlayedDAO_Impl.getLastPlayedServers$lambda$1(r1, this, (SQLiteConnection) obj);
                return lastPlayedServers$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getLastPlayedServers$lambda$1(String str, LastPlayedDAO_Impl lastPlayedDAO_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverType");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "date");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i = (int) prepare.getLong(columnIndexOrThrow);
                String text = prepare.getText(columnIndexOrThrow2);
                Date fromTimestamp = lastPlayedDAO_Impl.__dateConverter.fromTimestamp(prepare.isNull(columnIndexOrThrow3) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow3)));
                if (fromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                arrayList.add(new LastPlayedServer(i, text, fromTimestamp));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // com.arizona.launcher.data.database.LastPlayedDAO
    public void dropTable() {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: com.arizona.launcher.data.database.LastPlayedDAO_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit dropTable$lambda$2;
                dropTable$lambda$2 = LastPlayedDAO_Impl.dropTable$lambda$2(r1, (SQLiteConnection) obj);
                return dropTable$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dropTable$lambda$2(String str, SQLiteConnection _connection) {
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

    /* compiled from: LastPlayedDAO_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/data/database/LastPlayedDAO_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
