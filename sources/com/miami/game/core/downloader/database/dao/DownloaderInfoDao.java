package com.miami.game.core.downloader.database.dao;

import com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
/* compiled from: DownloaderInfoDao.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\bH§@¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u000fH'J\u000e\u0010\u0010\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0018H§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH§@¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/miami/game/core/downloader/database/dao/DownloaderInfoDao;", "", "get", "Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotCompletedTasks", "", "isCompleted", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFlow", "Lkotlinx/coroutines/flow/Flow;", "getCountAllTasks", "insert", "data", "(Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCompleted", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wipeData", "", "deleteDownloaderInfo", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloader-database_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
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
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getAllNotCompletedTasks$default(DownloaderInfoDao downloaderInfoDao, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return downloaderInfoDao.getAllNotCompletedTasks(z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllNotCompletedTasks");
        }
    }
}
