package com.miami.game.core.downloader.sync.data.store;

import com.miami.game.core.domain.model.DownloaderInfo;
import com.miami.game.core.downloader.database.DownloaderInfoDatabase;
import com.miami.game.core.downloader.database.dao.DownloaderInfoDao;
import com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
/* compiled from: DownloaderSyncDbRepository.kt */
@Singleton
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u0019J\u000e\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\nJ\u0018\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0086@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\u0002\b!¨\u0006 "}, d2 = {"Lcom/miami/game/core/downloader/sync/data/store/DownloaderSyncDbRepository;", "", "database", "Lcom/miami/game/core/downloader/database/DownloaderInfoDatabase;", "<init>", "(Lcom/miami/game/core/downloader/database/DownloaderInfoDatabase;)V", "Ljavax/inject/Inject;", "getAllNotCompletedTasks", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDownloaderInfoDbModel", "", "data", "Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;", "(Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTask", "Lcom/miami/game/core/domain/model/DownloaderInfo;", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCompleted", "isCompleted", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFlow", "Lkotlinx/coroutines/flow/Flow;", "wipeData", "", "deleteDownloaderInfo", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloader-sync", "Ljavax/inject/Singleton;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloaderSyncDbRepository {
    private final DownloaderInfoDatabase database;

    @Inject
    public DownloaderSyncDbRepository(DownloaderInfoDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.database = database;
    }

    public final Object getAllNotCompletedTasks(Continuation<? super List<Long>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncDbRepository$getAllNotCompletedTasks$2(this, null), continuation);
    }

    public final Object saveDownloaderInfoDbModel(DownloaderInfoDbModel downloaderInfoDbModel, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncDbRepository$saveDownloaderInfoDbModel$2(downloaderInfoDbModel, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getTask(long j, Continuation<? super DownloaderInfo> continuation) {
        DownloaderSyncDbRepository$getTask$1 downloaderSyncDbRepository$getTask$1;
        int i;
        DownloaderInfoDbModel downloaderInfoDbModel;
        DownloaderInfo domain;
        if (continuation instanceof DownloaderSyncDbRepository$getTask$1) {
            downloaderSyncDbRepository$getTask$1 = (DownloaderSyncDbRepository$getTask$1) continuation;
            if ((downloaderSyncDbRepository$getTask$1.label & Integer.MIN_VALUE) != 0) {
                downloaderSyncDbRepository$getTask$1.label -= Integer.MIN_VALUE;
                Object obj = downloaderSyncDbRepository$getTask$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = downloaderSyncDbRepository$getTask$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    DownloaderInfoDao downloaderInfoDao = this.database.downloaderInfoDao();
                    downloaderSyncDbRepository$getTask$1.J$0 = j;
                    downloaderSyncDbRepository$getTask$1.label = 1;
                    obj = downloaderInfoDao.get(j, downloaderSyncDbRepository$getTask$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j2 = downloaderSyncDbRepository$getTask$1.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                downloaderInfoDbModel = (DownloaderInfoDbModel) obj;
                if (downloaderInfoDbModel == null) {
                    domain = DownloaderSyncDbRepositoryKt.toDomain(downloaderInfoDbModel);
                    return domain;
                }
                return null;
            }
        }
        downloaderSyncDbRepository$getTask$1 = new DownloaderSyncDbRepository$getTask$1(this, continuation);
        Object obj2 = downloaderSyncDbRepository$getTask$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = downloaderSyncDbRepository$getTask$1.label;
        if (i != 0) {
        }
        downloaderInfoDbModel = (DownloaderInfoDbModel) obj2;
        if (downloaderInfoDbModel == null) {
        }
    }

    public final Object updateCompleted(long j, boolean z, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncDbRepository$updateCompleted$2(this, j, z, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Flow<List<DownloaderInfo>> getAllFlow() {
        return new DownloaderSyncDbRepository$getAllFlow$$inlined$map$1(this.database.downloaderInfoDao().getAllFlow());
    }

    public final Object wipeData(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncDbRepository$wipeData$2(this, null), continuation);
    }

    public final Object deleteDownloaderInfo(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncDbRepository$deleteDownloaderInfo$2(str, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
