package com.arizona.launcher.data.database;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RxRoom;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.arizona.launcher.model.servers.ServerEntity;
import com.arizona.launcher.model.servers.ServerType;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
/* compiled from: ServersDAO_Impl.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/data/database/ServersDAO_Impl;", "Lcom/arizona/launcher/data/database/ServersDAO;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfServerEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/arizona/launcher/model/servers/ServerEntity;", "addServer", "Lio/reactivex/Completable;", "server", "getAllServers", "Lio/reactivex/Observable;", "", "deleteTable", "", "__ServerType_enumToString", "", "_value", "Lcom/arizona/launcher/model/servers/ServerType;", "__ServerType_stringToEnum", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServersDAO_Impl implements ServersDAO {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<ServerEntity> __insertAdapterOfServerEntity;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ServersDAO_Impl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServerType.values().length];
            try {
                iArr[ServerType.ARIZONA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ServerType.RODINA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ServerType.RODINA_MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ServerType.ARIZONA_MOBILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ServersDAO_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfServerEntity = new EntityInsertAdapter<ServerEntity>() { // from class: com.arizona.launcher.data.database.ServersDAO_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `allservers` (`id`,`address`,`port`,`hasPassword`,`currentPlayerCount`,`maxPlayerCount`,`serverName`,`tg`,`vk`,`inst`,`favorite`,`serverType`,`ping`,`plotPoints`,`serverIcon`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, ServerEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo7567bindLong(1, entity.getId());
                statement.mo7569bindText(2, entity.getAddress());
                statement.mo7567bindLong(3, entity.getPort());
                statement.mo7567bindLong(4, entity.getHasPassword() ? 1L : 0L);
                statement.mo7567bindLong(5, entity.getCurrentPlayerCount());
                statement.mo7567bindLong(6, entity.getMaxPlayerCount());
                statement.mo7569bindText(7, entity.getServerName());
                statement.mo7569bindText(8, entity.getTg());
                statement.mo7569bindText(9, entity.getVk());
                statement.mo7569bindText(10, entity.getInst());
                statement.mo7567bindLong(11, entity.getFavorite() ? 1L : 0L);
                statement.mo7569bindText(12, ServersDAO_Impl.this.__ServerType_enumToString(entity.getServerType()));
                statement.mo7567bindLong(13, entity.getPing());
                statement.mo7569bindText(14, entity.getPlotPoints());
                statement.mo7569bindText(15, entity.getServerIcon());
            }
        };
    }

    @Override // com.arizona.launcher.data.database.ServersDAO
    public Completable addServer(final ServerEntity server) {
        Intrinsics.checkNotNullParameter(server, "server");
        return RxRoom.Companion.createCompletable(this.__db, false, true, new Function1() { // from class: com.arizona.launcher.data.database.ServersDAO_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit addServer$lambda$0;
                addServer$lambda$0 = ServersDAO_Impl.addServer$lambda$0(ServersDAO_Impl.this, server, (SQLiteConnection) obj);
                return addServer$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addServer$lambda$0(ServersDAO_Impl serversDAO_Impl, ServerEntity serverEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        serversDAO_Impl.__insertAdapterOfServerEntity.insert(_connection, (SQLiteConnection) serverEntity);
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.data.database.ServersDAO
    public Observable<List<ServerEntity>> getAllServers() {
        return RxRoom.Companion.createObservable(this.__db, false, new String[]{"allservers"}, new Function1() { // from class: com.arizona.launcher.data.database.ServersDAO_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List allServers$lambda$1;
                allServers$lambda$1 = ServersDAO_Impl.getAllServers$lambda$1(r1, this, (SQLiteConnection) obj);
                return allServers$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllServers$lambda$1(String str, ServersDAO_Impl serversDAO_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "address");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "port");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hasPassword");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "currentPlayerCount");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "maxPlayerCount");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverName");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "tg");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "vk");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "inst");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "favorite");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverType");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "ping");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "plotPoints");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "serverIcon");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i = columnIndexOrThrow14;
                ArrayList arrayList2 = arrayList;
                int i2 = (int) prepare.getLong(columnIndexOrThrow);
                String text = prepare.getText(columnIndexOrThrow2);
                int i3 = (int) prepare.getLong(columnIndexOrThrow3);
                int i4 = columnIndexOrThrow2;
                int i5 = columnIndexOrThrow3;
                boolean z = ((int) prepare.getLong(columnIndexOrThrow4)) != 0;
                int i6 = (int) prepare.getLong(columnIndexOrThrow5);
                columnIndexOrThrow4 = columnIndexOrThrow4;
                int i7 = (int) prepare.getLong(columnIndexOrThrow6);
                String text2 = prepare.getText(columnIndexOrThrow7);
                String text3 = prepare.getText(columnIndexOrThrow8);
                String text4 = prepare.getText(columnIndexOrThrow9);
                String text5 = prepare.getText(columnIndexOrThrow10);
                boolean z2 = ((int) prepare.getLong(columnIndexOrThrow11)) != 0;
                String text6 = prepare.getText(i);
                int i8 = columnIndexOrThrow;
                int i9 = columnIndexOrThrow15;
                arrayList2.add(new ServerEntity(i2, text, i3, z, i6, i7, text2, text3, text4, text5, z2, serversDAO_Impl.__ServerType_stringToEnum(prepare.getText(columnIndexOrThrow12)), (int) prepare.getLong(columnIndexOrThrow13), text6, prepare.getText(i9)));
                columnIndexOrThrow15 = i9;
                columnIndexOrThrow2 = i4;
                columnIndexOrThrow = i8;
                arrayList = arrayList2;
                columnIndexOrThrow14 = i;
                columnIndexOrThrow3 = i5;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // com.arizona.launcher.data.database.ServersDAO
    public void deleteTable() {
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: com.arizona.launcher.data.database.ServersDAO_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit deleteTable$lambda$2;
                deleteTable$lambda$2 = ServersDAO_Impl.deleteTable$lambda$2(r1, (SQLiteConnection) obj);
                return deleteTable$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteTable$lambda$2(String str, SQLiteConnection _connection) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String __ServerType_enumToString(ServerType serverType) {
        int i = WhenMappings.$EnumSwitchMapping$0[serverType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return "ARIZONA_MOBILE";
                }
                return "RODINA_MOBILE";
            }
            return "RODINA";
        }
        return "ARIZONA";
    }

    private final ServerType __ServerType_stringToEnum(String str) {
        switch (str.hashCode()) {
            case -1872320331:
                if (str.equals("RODINA")) {
                    return ServerType.RODINA;
                }
                break;
            case -1311861908:
                if (str.equals("RODINA_MOBILE")) {
                    return ServerType.RODINA_MOBILE;
                }
                break;
            case -24035872:
                if (str.equals("ARIZONA")) {
                    return ServerType.ARIZONA;
                }
                break;
            case 1649731553:
                if (str.equals("ARIZONA_MOBILE")) {
                    return ServerType.ARIZONA_MOBILE;
                }
                break;
        }
        throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + str);
    }

    /* compiled from: ServersDAO_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/data/database/ServersDAO_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
