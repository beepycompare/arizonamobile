package com.miami.game.core.downloader.sync.data.store;

import com.miami.game.core.domain.model.DownloaderInfo;
import com.miami.game.core.downloader.database.DownloaderInfoDatabase;
import com.miami.game.core.downloader.database.dao.DownloaderInfoDao;
import com.miami.game.core.downloader.database.entity.DownloaderInfoDbModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: DownloaderSyncDbRepository.kt */
@Singleton
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u0018J\u000e\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\tJ\u0018\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0086@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/miami/game/core/downloader/sync/data/store/DownloaderSyncDbRepository;", "", "database", "Lcom/miami/game/core/downloader/database/DownloaderInfoDatabase;", "<init>", "(Lcom/miami/game/core/downloader/database/DownloaderInfoDatabase;)V", "getAllNotCompletedTasks", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDownloaderInfoDbModel", "", "data", "Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;", "(Lcom/miami/game/core/downloader/database/entity/DownloaderInfoDbModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTask", "Lcom/miami/game/core/domain/model/DownloaderInfo;", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCompleted", "isCompleted", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFlow", "Lkotlinx/coroutines/flow/Flow;", "wipeData", "", "deleteDownloaderInfo", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloader-sync_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
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
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d A[RETURN] */
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
                    downloaderSyncDbRepository$getTask$1.label = 1;
                    obj = downloaderInfoDao.get(j, downloaderSyncDbRepository$getTask$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
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
        final Flow<List<DownloaderInfoDbModel>> allFlow = this.database.downloaderInfoDao().getAllFlow();
        return (Flow) new Flow<List<? extends DownloaderInfo>>() { // from class: com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository$getAllFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* renamed from: com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository$getAllFlow$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository$getAllFlow$$inlined$map$1$2", f = "DownloaderSyncDbRepository.kt", i = {}, l = {50}, m = "emit", n = {}, s = {})
                /* renamed from: com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository$getAllFlow$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    DownloaderInfo domain;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                List<DownloaderInfoDbModel> list = (List) obj;
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                                for (DownloaderInfoDbModel downloaderInfoDbModel : list) {
                                    domain = DownloaderSyncDbRepositoryKt.toDomain(downloaderInfoDbModel);
                                    arrayList.add(domain);
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends DownloaderInfo>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    public final Object wipeData(Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncDbRepository$wipeData$2(this, null), continuation);
    }

    public final Object deleteDownloaderInfo(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new DownloaderSyncDbRepository$deleteDownloaderInfo$2(str, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
