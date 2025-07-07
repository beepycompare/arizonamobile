package com.miami.game.core.downloader.database.dao;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel;
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
/* compiled from: DownloaderInfoDao_Impl.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0096@¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/miami/game/core/downloader/database/dao/DownloaderInfoDao_Impl;", "Lcom/miami/game/core/downloader/database/dao/DownloaderInfoDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfDownloaderInfoDbModel", "Landroidx/room/EntityInsertAdapter;", "Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;", "insert", "", "data", "(Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotCompletedTasks", "", "isCompleted", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFlow", "Lkotlinx/coroutines/flow/Flow;", "getCountAllTasks", "updateCompleted", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wipeData", "", "deleteDownloaderInfo", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "downloader-database_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloaderInfoDao_Impl implements DownloaderInfoDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<DownloaderInfoDbModel> __insertAdapterOfDownloaderInfoDbModel;

    public DownloaderInfoDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfDownloaderInfoDbModel = new EntityInsertAdapter<DownloaderInfoDbModel>() { // from class: com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `downloader_info_table` (`id`,`path`,`name_from_game_info_file`,`size_from_game_info_file`,`hash_from_game_info_file`,`date_change_from_game_info_file`,`gpu_type_from_game_info_file`,`is_completed_download`,`download_start_at`,`download_finish_at`,`created_at`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, DownloaderInfoDbModel entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo7567bindLong(1, entity.getId());
                String path = entity.getPath();
                if (path == null) {
                    statement.mo7568bindNull(2);
                } else {
                    statement.mo7569bindText(2, path);
                }
                String nameFromGameInfoFile = entity.getNameFromGameInfoFile();
                if (nameFromGameInfoFile == null) {
                    statement.mo7568bindNull(3);
                } else {
                    statement.mo7569bindText(3, nameFromGameInfoFile);
                }
                Long sizeFromGameInfoFile = entity.getSizeFromGameInfoFile();
                if (sizeFromGameInfoFile == null) {
                    statement.mo7568bindNull(4);
                } else {
                    statement.mo7567bindLong(4, sizeFromGameInfoFile.longValue());
                }
                String hashFromGameInfoFile = entity.getHashFromGameInfoFile();
                if (hashFromGameInfoFile == null) {
                    statement.mo7568bindNull(5);
                } else {
                    statement.mo7569bindText(5, hashFromGameInfoFile);
                }
                Long dateChangeFromGameInfoFile = entity.getDateChangeFromGameInfoFile();
                if (dateChangeFromGameInfoFile == null) {
                    statement.mo7568bindNull(6);
                } else {
                    statement.mo7567bindLong(6, dateChangeFromGameInfoFile.longValue());
                }
                String gpuTypeFromGameInfoFile = entity.getGpuTypeFromGameInfoFile();
                if (gpuTypeFromGameInfoFile == null) {
                    statement.mo7568bindNull(7);
                } else {
                    statement.mo7569bindText(7, gpuTypeFromGameInfoFile);
                }
                statement.mo7567bindLong(8, entity.isCompletedDownload() ? 1L : 0L);
                Long downloadStartAt = entity.getDownloadStartAt();
                if (downloadStartAt == null) {
                    statement.mo7568bindNull(9);
                } else {
                    statement.mo7567bindLong(9, downloadStartAt.longValue());
                }
                Long downloadFinishAt = entity.getDownloadFinishAt();
                if (downloadFinishAt == null) {
                    statement.mo7568bindNull(10);
                } else {
                    statement.mo7567bindLong(10, downloadFinishAt.longValue());
                }
                Long createdAt = entity.getCreatedAt();
                if (createdAt == null) {
                    statement.mo7568bindNull(11);
                } else {
                    statement.mo7567bindLong(11, createdAt.longValue());
                }
            }
        };
    }

    @Override // com.miami.game.core.downloader.database.dao.DownloaderInfoDao
    public Object insert(final DownloaderInfoDbModel downloaderInfoDbModel, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                long insert$lambda$0;
                insert$lambda$0 = DownloaderInfoDao_Impl.insert$lambda$0(DownloaderInfoDao_Impl.this, downloaderInfoDbModel, (SQLiteConnection) obj);
                return Long.valueOf(insert$lambda$0);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(DownloaderInfoDao_Impl downloaderInfoDao_Impl, DownloaderInfoDbModel downloaderInfoDbModel, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return downloaderInfoDao_Impl.__insertAdapterOfDownloaderInfoDbModel.insertAndReturnId(_connection, downloaderInfoDbModel);
    }

    @Override // com.miami.game.core.downloader.database.dao.DownloaderInfoDao
    public Object get(final long j, Continuation<? super DownloaderInfoDbModel> continuation) {
        return DBUtil.performSuspending(this.__db, true, true, new Function1() { // from class: com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloaderInfoDbModel downloaderInfoDbModel;
                downloaderInfoDbModel = DownloaderInfoDao_Impl.get$lambda$1(r1, j, (SQLiteConnection) obj);
                return downloaderInfoDbModel;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloaderInfoDbModel get$lambda$1(String str, long j, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        boolean z = true;
        try {
            prepare.mo7567bindLong(1, j);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "path");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "name_from_game_info_file");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "size_from_game_info_file");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hash_from_game_info_file");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "date_change_from_game_info_file");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "gpu_type_from_game_info_file");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "is_completed_download");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "download_start_at");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "download_finish_at");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "created_at");
            DownloaderInfoDbModel downloaderInfoDbModel = null;
            if (prepare.step()) {
                long j2 = prepare.getLong(columnIndexOrThrow);
                String text = prepare.isNull(columnIndexOrThrow2) ? null : prepare.getText(columnIndexOrThrow2);
                String text2 = prepare.isNull(columnIndexOrThrow3) ? null : prepare.getText(columnIndexOrThrow3);
                Long valueOf = prepare.isNull(columnIndexOrThrow4) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow4));
                String text3 = prepare.isNull(columnIndexOrThrow5) ? null : prepare.getText(columnIndexOrThrow5);
                Long valueOf2 = prepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow6));
                String text4 = prepare.isNull(columnIndexOrThrow7) ? null : prepare.getText(columnIndexOrThrow7);
                if (((int) prepare.getLong(columnIndexOrThrow8)) == 0) {
                    z = false;
                }
                downloaderInfoDbModel = new DownloaderInfoDbModel(j2, text, text2, valueOf, text3, valueOf2, text4, z, prepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow9)), prepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow10)), prepare.isNull(columnIndexOrThrow11) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow11)));
            }
            return downloaderInfoDbModel;
        } finally {
            prepare.close();
        }
    }

    @Override // com.miami.game.core.downloader.database.dao.DownloaderInfoDao
    public Object getAllNotCompletedTasks(final boolean z, Continuation<? super List<Long>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List allNotCompletedTasks$lambda$2;
                allNotCompletedTasks$lambda$2 = DownloaderInfoDao_Impl.getAllNotCompletedTasks$lambda$2(r1, z, (SQLiteConnection) obj);
                return allNotCompletedTasks$lambda$2;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllNotCompletedTasks$lambda$2(String str, boolean z, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo7567bindLong(1, z ? 1L : 0L);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(Long.valueOf(prepare.getLong(0)));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // com.miami.game.core.downloader.database.dao.DownloaderInfoDao
    public Object getAll(Continuation<? super List<DownloaderInfoDbModel>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List all$lambda$3;
                all$lambda$3 = DownloaderInfoDao_Impl.getAll$lambda$3(r1, (SQLiteConnection) obj);
                return all$lambda$3;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAll$lambda$3(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "path");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "name_from_game_info_file");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "size_from_game_info_file");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hash_from_game_info_file");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "date_change_from_game_info_file");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "gpu_type_from_game_info_file");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "is_completed_download");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "download_start_at");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "download_finish_at");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "created_at");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(new DownloaderInfoDbModel(prepare.getLong(columnIndexOrThrow), prepare.isNull(columnIndexOrThrow2) ? null : prepare.getText(columnIndexOrThrow2), prepare.isNull(columnIndexOrThrow3) ? null : prepare.getText(columnIndexOrThrow3), prepare.isNull(columnIndexOrThrow4) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow4)), prepare.isNull(columnIndexOrThrow5) ? null : prepare.getText(columnIndexOrThrow5), prepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow6)), prepare.isNull(columnIndexOrThrow7) ? null : prepare.getText(columnIndexOrThrow7), ((int) prepare.getLong(columnIndexOrThrow8)) != 0, prepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow9)), prepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow10)), prepare.isNull(columnIndexOrThrow11) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow11))));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // com.miami.game.core.downloader.database.dao.DownloaderInfoDao
    public Flow<List<DownloaderInfoDbModel>> getAllFlow() {
        return FlowUtil.createFlow(this.__db, false, new String[]{"downloader_info_table"}, new Function1() { // from class: com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List allFlow$lambda$4;
                allFlow$lambda$4 = DownloaderInfoDao_Impl.getAllFlow$lambda$4(r1, (SQLiteConnection) obj);
                return allFlow$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllFlow$lambda$4(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "path");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "name_from_game_info_file");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "size_from_game_info_file");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hash_from_game_info_file");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "date_change_from_game_info_file");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "gpu_type_from_game_info_file");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "is_completed_download");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "download_start_at");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "download_finish_at");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "created_at");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                arrayList.add(new DownloaderInfoDbModel(prepare.getLong(columnIndexOrThrow), prepare.isNull(columnIndexOrThrow2) ? null : prepare.getText(columnIndexOrThrow2), prepare.isNull(columnIndexOrThrow3) ? null : prepare.getText(columnIndexOrThrow3), prepare.isNull(columnIndexOrThrow4) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow4)), prepare.isNull(columnIndexOrThrow5) ? null : prepare.getText(columnIndexOrThrow5), prepare.isNull(columnIndexOrThrow6) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow6)), prepare.isNull(columnIndexOrThrow7) ? null : prepare.getText(columnIndexOrThrow7), ((int) prepare.getLong(columnIndexOrThrow8)) != 0, prepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow9)), prepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow10)), prepare.isNull(columnIndexOrThrow11) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow11))));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // com.miami.game.core.downloader.database.dao.DownloaderInfoDao
    public Object getCountAllTasks(Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                long countAllTasks$lambda$5;
                countAllTasks$lambda$5 = DownloaderInfoDao_Impl.getCountAllTasks$lambda$5(r1, (SQLiteConnection) obj);
                return Long.valueOf(countAllTasks$lambda$5);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getCountAllTasks$lambda$5(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            return prepare.step() ? prepare.getLong(0) : 0L;
        } finally {
            prepare.close();
        }
    }

    @Override // com.miami.game.core.downloader.database.dao.DownloaderInfoDao
    public Object updateCompleted(final long j, final boolean z, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit updateCompleted$lambda$6;
                updateCompleted$lambda$6 = DownloaderInfoDao_Impl.updateCompleted$lambda$6(r1, z, j, (SQLiteConnection) obj);
                return updateCompleted$lambda$6;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateCompleted$lambda$6(String str, boolean z, long j, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo7567bindLong(1, z ? 1L : 0L);
            prepare.mo7567bindLong(2, j);
            prepare.step();
            prepare.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    @Override // com.miami.game.core.downloader.database.dao.DownloaderInfoDao
    public Object wipeData(Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int wipeData$lambda$7;
                wipeData$lambda$7 = DownloaderInfoDao_Impl.wipeData$lambda$7(r1, (SQLiteConnection) obj);
                return Integer.valueOf(wipeData$lambda$7);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int wipeData$lambda$7(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            prepare.close();
        }
    }

    @Override // com.miami.game.core.downloader.database.dao.DownloaderInfoDao
    public Object deleteDownloaderInfo(final String str, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.miami.game.core.downloader.database.dao.DownloaderInfoDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit deleteDownloaderInfo$lambda$8;
                deleteDownloaderInfo$lambda$8 = DownloaderInfoDao_Impl.deleteDownloaderInfo$lambda$8(r1, str, (SQLiteConnection) obj);
                return deleteDownloaderInfo$lambda$8;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteDownloaderInfo$lambda$8(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            prepare.mo7569bindText(1, str2);
            prepare.step();
            prepare.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* compiled from: DownloaderInfoDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/downloader/database/dao/DownloaderInfoDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "downloader-database_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
