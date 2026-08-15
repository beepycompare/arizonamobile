package com.miami.game.core.downloader.database.dao;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
/* compiled from: DownloaderInfoDao.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006J.\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH§@b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u000fJ\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\fH§@b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010\u0012J\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f0\u0015H'b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013J\u001c\u0010\u0016\u001a\u00020\u0005H§@b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017¢\u0006\u0002\u0010\u0012J$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H§@b\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0002¢\u0006\u0002\u0010\u001aJ0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH§@b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b( ¢\u0006\u0002\u0010\u001fJ\u001c\u0010!\u001a\u00020\"H§@b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(#¢\u0006\u0002\u0010\u0012J$\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&H§@b\f\b\b\u0012\b\b\t\u0012\u0004\b\b((¢\u0006\u0002\u0010'Ê\u0001\u0002\b*¨\u0006)À\u0006\u0003"}, d2 = {"Lcom/miami/game/core/downloader/database/dao/DownloaderInfoDao;", "", "get", "Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;", TtmlNode.ATTR_ID, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/room/Transaction;", "Landroidx/room/Query;", "value", "SELECT * FROM downloader_info_table WHERE id = :id", "getAllNotCompletedTasks", "", "isCompleted", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SELECT id FROM downloader_info_table WHERE is_completed_download = :isCompleted", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SELECT * FROM downloader_info_table", "getAllFlow", "Lkotlinx/coroutines/flow/Flow;", "getCountAllTasks", "SELECT COUNT(id) FROM downloader_info_table", "insert", "data", "(Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/room/Insert;", "onConflict", "updateCompleted", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UPDATE downloader_info_table SET is_completed_download=:isCompleted WHERE id = :id", "wipeData", "", "DELETE FROM downloader_info_table", "deleteDownloaderInfo", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DELETE FROM downloader_info_table WHERE name_from_game_info_file = :name", "downloader-database", "Landroidx/room/Dao;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DownloaderInfoDao {
    Object deleteDownloaderInfo(String str, Continuation<? super Unit> continuation);

    Object get(long j, Continuation<? super DownloaderInfoDbModel> continuation);

    Object getAll(Continuation<? super List<DownloaderInfoDbModel>> continuation);

    Flow<List<DownloaderInfoDbModel>> getAllFlow();

    Object getAllNotCompletedTasks(boolean z, Continuation<? super List<Long>> continuation);

    Object getCountAllTasks(Continuation<? super Long> continuation);

    Object insert(DownloaderInfoDbModel downloaderInfoDbModel, Continuation<? super Long> continuation);

    Object updateCompleted(long j, boolean z, Continuation<? super Unit> continuation);

    Object wipeData(Continuation<? super Integer> continuation);

    /* compiled from: DownloaderInfoDao.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getAllNotCompletedTasks$default(DownloaderInfoDao downloaderInfoDao, boolean z, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            return downloaderInfoDao.getAllNotCompletedTasks(z, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllNotCompletedTasks");
    }
}
