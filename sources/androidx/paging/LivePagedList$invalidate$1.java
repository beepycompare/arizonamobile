package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LivePagedList.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.LivePagedList$invalidate$1", f = "LivePagedList.kt", i = {0, 1, 1}, l = {82, 90}, m = "invokeSuspend", n = {"pagingSource", "pagingSource", "lastKey"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes3.dex */
public final class LivePagedList$invalidate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LivePagedList<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePagedList$invalidate$1(LivePagedList<Key, Value> livePagedList, Continuation<? super LivePagedList$invalidate$1> continuation) {
        super(2, continuation);
        this.this$0 = livePagedList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LivePagedList$invalidate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LivePagedList$invalidate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cb  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PagedList pagedList;
        Function0<Unit> function0;
        Function0 function02;
        Function0<Unit> function03;
        CoroutineDispatcher coroutineDispatcher;
        PagingSource pagingSource;
        PagedList.Config config;
        PagedList pagedList2;
        PagedList.Config config2;
        Object obj2;
        PagingSource.LoadResult loadResult;
        CoroutineScope coroutineScope;
        CoroutineDispatcher coroutineDispatcher2;
        CoroutineDispatcher coroutineDispatcher3;
        PagedList.BoundaryCallback boundaryCallback;
        PagedList.Config config3;
        PagedList pagedList3;
        PagedList pagedList4;
        PagedList pagedList5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            pagedList = ((LivePagedList) this.this$0).currentData;
            PagingSource pagingSource2 = pagedList.getPagingSource();
            function0 = ((LivePagedList) this.this$0).callback;
            pagingSource2.unregisterInvalidatedCallback(function0);
            function02 = ((LivePagedList) this.this$0).pagingSourceFactory;
            PagingSource pagingSource3 = (PagingSource) function02.invoke();
            function03 = ((LivePagedList) this.this$0).callback;
            pagingSource3.registerInvalidatedCallback(function03);
            if (pagingSource3 instanceof LegacyPagingSource) {
                config = ((LivePagedList) this.this$0).config;
                ((LegacyPagingSource) pagingSource3).setPageSize(config.pageSize);
            }
            coroutineDispatcher = ((LivePagedList) this.this$0).notifyDispatcher;
            this.L$0 = pagingSource3;
            this.label = 1;
            if (BuildersKt.withContext(coroutineDispatcher, new AnonymousClass1(this.this$0, null), this) != coroutine_suspended) {
                pagingSource = pagingSource3;
            }
            return coroutine_suspended;
        } else if (i != 1) {
            if (i == 2) {
                Object obj3 = this.L$1;
                pagingSource = (PagingSource) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj3;
                loadResult = (PagingSource.LoadResult) obj;
                if (!(loadResult instanceof PagingSource.LoadResult.Invalid)) {
                    pagedList5 = ((LivePagedList) this.this$0).currentData;
                    pagedList5.setInitialLoadState(LoadType.REFRESH, new LoadState.NotLoading(false));
                    pagingSource.invalidate();
                } else if (loadResult instanceof PagingSource.LoadResult.Error) {
                    pagedList4 = ((LivePagedList) this.this$0).currentData;
                    pagedList4.setInitialLoadState(LoadType.REFRESH, new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable()));
                } else if (loadResult instanceof PagingSource.LoadResult.Page) {
                    coroutineScope = ((LivePagedList) this.this$0).coroutineScope;
                    coroutineDispatcher2 = ((LivePagedList) this.this$0).notifyDispatcher;
                    coroutineDispatcher3 = ((LivePagedList) this.this$0).fetchDispatcher;
                    boundaryCallback = ((LivePagedList) this.this$0).boundaryCallback;
                    config3 = ((LivePagedList) this.this$0).config;
                    PagedList create = PagedList.Companion.create(pagingSource, (PagingSource.LoadResult.Page) loadResult, coroutineScope, coroutineDispatcher2, coroutineDispatcher3, boundaryCallback, config3, obj2);
                    LivePagedList<Key, Value> livePagedList = this.this$0;
                    pagedList3 = ((LivePagedList) livePagedList).currentData;
                    livePagedList.onItemUpdate(pagedList3, create);
                    ((LivePagedList) this.this$0).currentData = create;
                    this.this$0.postValue(create);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            pagingSource = (PagingSource) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        pagedList2 = ((LivePagedList) this.this$0).currentData;
        Object lastKey = pagedList2.getLastKey();
        config2 = ((LivePagedList) this.this$0).config;
        this.L$0 = pagingSource;
        this.L$1 = lastKey;
        this.label = 2;
        Object load = pagingSource.load(PagedListKt.toRefreshLoadParams(config2, lastKey), this);
        if (load != coroutine_suspended) {
            obj2 = lastKey;
            obj = load;
            loadResult = (PagingSource.LoadResult) obj;
            if (!(loadResult instanceof PagingSource.LoadResult.Invalid)) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LivePagedList.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.LivePagedList$invalidate$1$1", f = "LivePagedList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.LivePagedList$invalidate$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LivePagedList<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LivePagedList<Key, Value> livePagedList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = livePagedList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PagedList pagedList;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                pagedList = ((LivePagedList) this.this$0).currentData;
                pagedList.setInitialLoadState(LoadType.REFRESH, LoadState.Loading.INSTANCE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
