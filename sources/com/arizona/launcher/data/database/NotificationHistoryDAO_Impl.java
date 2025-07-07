package com.arizona.launcher.data.database;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.arizona.launcher.model.servers.NotificationHistoryData;
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
import ru.mrlargha.commonui.utils.DateConverter;
/* compiled from: NotificationHistoryDAO_Impl.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/data/database/NotificationHistoryDAO_Impl;", "Lcom/arizona/launcher/data/database/NotificationHistoryDAO;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfNotificationHistoryData", "Landroidx/room/EntityInsertAdapter;", "Lcom/arizona/launcher/model/servers/NotificationHistoryData;", "__dateConverter", "Lru/mrlargha/commonui/utils/DateConverter;", "addNotification", "", "notification", "(Lcom/arizona/launcher/model/servers/NotificationHistoryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotification", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dropTable", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NotificationHistoryDAO_Impl implements NotificationHistoryDAO {
    private final DateConverter __dateConverter;
    private final RoomDatabase __db;
    private final EntityInsertAdapter<NotificationHistoryData> __insertAdapterOfNotificationHistoryData;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public NotificationHistoryDAO_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__dateConverter = new DateConverter();
        this.__db = __db;
        this.__insertAdapterOfNotificationHistoryData = new EntityInsertAdapter<NotificationHistoryData>() { // from class: com.arizona.launcher.data.database.NotificationHistoryDAO_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `notifications` (`id`,`date`,`title`,`text`,`imageUrl`,`isViewed`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, NotificationHistoryData entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo7567bindLong(1, entity.getId());
                Long dateToTimestamp = NotificationHistoryDAO_Impl.this.__dateConverter.dateToTimestamp(entity.getDate());
                if (dateToTimestamp == null) {
                    statement.mo7568bindNull(2);
                } else {
                    statement.mo7567bindLong(2, dateToTimestamp.longValue());
                }
                statement.mo7569bindText(3, entity.getTitle());
                statement.mo7569bindText(4, entity.getText());
                statement.mo7569bindText(5, entity.getImageUrl());
                statement.mo7567bindLong(6, entity.isViewed() ? 1L : 0L);
            }
        };
    }

    @Override // com.arizona.launcher.data.database.NotificationHistoryDAO
    public Object addNotification(final NotificationHistoryData notificationHistoryData, Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.arizona.launcher.data.database.NotificationHistoryDAO_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit addNotification$lambda$0;
                addNotification$lambda$0 = NotificationHistoryDAO_Impl.addNotification$lambda$0(NotificationHistoryDAO_Impl.this, notificationHistoryData, (SQLiteConnection) obj);
                return addNotification$lambda$0;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addNotification$lambda$0(NotificationHistoryDAO_Impl notificationHistoryDAO_Impl, NotificationHistoryData notificationHistoryData, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        notificationHistoryDAO_Impl.__insertAdapterOfNotificationHistoryData.insert(_connection, (SQLiteConnection) notificationHistoryData);
        return Unit.INSTANCE;
    }

    @Override // com.arizona.launcher.data.database.NotificationHistoryDAO
    public Object getAllNotification(Continuation<? super List<NotificationHistoryData>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.arizona.launcher.data.database.NotificationHistoryDAO_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List allNotification$lambda$1;
                allNotification$lambda$1 = NotificationHistoryDAO_Impl.getAllNotification$lambda$1(r1, this, (SQLiteConnection) obj);
                return allNotification$lambda$1;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAllNotification$lambda$1(String str, NotificationHistoryDAO_Impl notificationHistoryDAO_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement prepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "date");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "title");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "text");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "imageUrl");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "isViewed");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                int i = columnIndexOrThrow2;
                int i2 = columnIndexOrThrow3;
                arrayList.add(new NotificationHistoryData((int) prepare.getLong(columnIndexOrThrow), notificationHistoryDAO_Impl.__dateConverter.fromTimestamp(prepare.isNull(columnIndexOrThrow2) ? null : Long.valueOf(prepare.getLong(columnIndexOrThrow2))), prepare.getText(columnIndexOrThrow3), prepare.getText(columnIndexOrThrow4), prepare.getText(columnIndexOrThrow5), ((int) prepare.getLong(columnIndexOrThrow6)) != 0));
                columnIndexOrThrow2 = i;
                columnIndexOrThrow3 = i2;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    @Override // com.arizona.launcher.data.database.NotificationHistoryDAO
    public Object dropTable(Continuation<? super Unit> continuation) {
        Object performSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.arizona.launcher.data.database.NotificationHistoryDAO_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit dropTable$lambda$2;
                dropTable$lambda$2 = NotificationHistoryDAO_Impl.dropTable$lambda$2(r1, (SQLiteConnection) obj);
                return dropTable$lambda$2;
            }
        }, continuation);
        return performSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? performSuspending : Unit.INSTANCE;
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

    /* compiled from: NotificationHistoryDAO_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/data/database/NotificationHistoryDAO_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
