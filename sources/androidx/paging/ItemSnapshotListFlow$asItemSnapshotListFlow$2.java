package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ItemSnapshotListFlow.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/paging/ItemSnapshotList;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.ItemSnapshotListFlow$asItemSnapshotListFlow$2", f = "ItemSnapshotListFlow.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes3.dex */
final class ItemSnapshotListFlow$asItemSnapshotListFlow$2<T> extends SuspendLambda implements Function2<ProducerScope<? super ItemSnapshotList<T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<CombinedLoadStates> $errorCombinedLoadStates;
    final /* synthetic */ Function1<CombinedLoadStates, Unit> $onLoadError;
    final /* synthetic */ Flow<PagingData<T>> $this_asItemSnapshotListFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ItemSnapshotListFlow$asItemSnapshotListFlow$2(Flow<PagingData<T>> flow, Ref.ObjectRef<CombinedLoadStates> objectRef, Function1<? super CombinedLoadStates, Unit> function1, Continuation<? super ItemSnapshotListFlow$asItemSnapshotListFlow$2> continuation) {
        super(2, continuation);
        this.$this_asItemSnapshotListFlow = flow;
        this.$errorCombinedLoadStates = objectRef;
        this.$onLoadError = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ItemSnapshotListFlow$asItemSnapshotListFlow$2 itemSnapshotListFlow$asItemSnapshotListFlow$2 = new ItemSnapshotListFlow$asItemSnapshotListFlow$2(this.$this_asItemSnapshotListFlow, this.$errorCombinedLoadStates, this.$onLoadError, continuation);
        itemSnapshotListFlow$asItemSnapshotListFlow$2.L$0 = obj;
        return itemSnapshotListFlow$asItemSnapshotListFlow$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super ItemSnapshotList<T>> producerScope, Continuation<? super Unit> continuation) {
        return ((ItemSnapshotListFlow$asItemSnapshotListFlow$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ItemSnapshotListFlow.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "pagingData", "Landroidx/paging/PagingData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.ItemSnapshotListFlow$asItemSnapshotListFlow$2$1", f = "ItemSnapshotListFlow.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: androidx.paging.ItemSnapshotListFlow$asItemSnapshotListFlow$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PagingData<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProducerScope<ItemSnapshotList<T>> $$this$channelFlow;
        final /* synthetic */ Ref.ObjectRef<CombinedLoadStates> $errorCombinedLoadStates;
        final /* synthetic */ Function1<CombinedLoadStates, Unit> $onLoadError;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.ObjectRef<CombinedLoadStates> objectRef, Function1<? super CombinedLoadStates, Unit> function1, ProducerScope<? super ItemSnapshotList<T>> producerScope, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$errorCombinedLoadStates = objectRef;
            this.$onLoadError = function1;
            this.$$this$channelFlow = producerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$errorCombinedLoadStates, this.$onLoadError, this.$$this$channelFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(PagingData<T> pagingData, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pagingData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return invoke((PagingData) ((PagingData) obj), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow distinctUntilChangedBy = FlowKt.distinctUntilChangedBy(FlowKt.filterNotNull(FlowExtKt.simpleScan(((PagingData) this.L$0).getFlow$paging_common(), null, new C00351(this.$errorCombinedLoadStates, this.$onLoadError, null))), new Function1() { // from class: androidx.paging.ItemSnapshotListFlow$asItemSnapshotListFlow$2$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        int hashCode;
                        hashCode = ((PageStore) obj2).hashCode();
                        return Integer.valueOf(hashCode);
                    }
                });
                final ProducerScope<ItemSnapshotList<T>> producerScope = this.$$this$channelFlow;
                this.label = 1;
                if (distinctUntilChangedBy.collect(new FlowCollector() { // from class: androidx.paging.ItemSnapshotListFlow.asItemSnapshotListFlow.2.1.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((PageStore) ((PageStore) obj2), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(PageStore<T> pageStore, Continuation<? super Unit> continuation) {
                        Object send = producerScope.send(pageStore.snapshot(), continuation);
                        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ItemSnapshotListFlow.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\n"}, d2 = {"<anonymous>", "Landroidx/paging/PageStore;", ExifInterface.GPS_DIRECTION_TRUE, "", "pageStore", "pageEvent", "Landroidx/paging/PageEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.ItemSnapshotListFlow$asItemSnapshotListFlow$2$1$1", f = "ItemSnapshotListFlow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: androidx.paging.ItemSnapshotListFlow$asItemSnapshotListFlow$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C00351 extends SuspendLambda implements Function3<PageStore<T>, PageEvent<T>, Continuation<? super PageStore<T>>, Object> {
            final /* synthetic */ Ref.ObjectRef<CombinedLoadStates> $errorCombinedLoadStates;
            final /* synthetic */ Function1<CombinedLoadStates, Unit> $onLoadError;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00351(Ref.ObjectRef<CombinedLoadStates> objectRef, Function1<? super CombinedLoadStates, Unit> function1, Continuation<? super C00351> continuation) {
                super(3, continuation);
                this.$errorCombinedLoadStates = objectRef;
                this.$onLoadError = function1;
            }

            public final Object invoke(PageStore<T> pageStore, PageEvent<T> pageEvent, Continuation<? super PageStore<T>> continuation) {
                C00351 c00351 = new C00351(this.$errorCombinedLoadStates, this.$onLoadError, continuation);
                c00351.L$0 = pageStore;
                c00351.L$1 = pageEvent;
                return c00351.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((PageStore) ((PageStore) obj), (PageEvent) ((PageEvent) obj2), (Continuation) ((Continuation) obj3));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                LoadStates mediator;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                PageStore pageStore = (PageStore) this.L$0;
                PageEvent<T> pageEvent = (PageEvent) this.L$1;
                if (pageEvent instanceof PageEvent.LoadStateUpdate) {
                    PageEvent.LoadStateUpdate loadStateUpdate = (PageEvent.LoadStateUpdate) pageEvent;
                    if (loadStateUpdate.getSource().hasError() || ((mediator = loadStateUpdate.getMediator()) != null && mediator.hasError())) {
                        Ref.ObjectRef<CombinedLoadStates> objectRef = this.$errorCombinedLoadStates;
                        objectRef.element = (T) MutableCombinedLoadStateCollectionKt.computeNewState(objectRef.element, loadStateUpdate.getSource(), loadStateUpdate.getMediator());
                        this.$onLoadError.invoke(this.$errorCombinedLoadStates.element);
                        return pageStore;
                    }
                    return pageStore;
                } else if (pageEvent instanceof PageEvent.StaticList) {
                    PageEvent.StaticList staticList = (PageEvent.StaticList) pageEvent;
                    return new PageStore(CollectionsKt.listOf(new TransformablePage(0, staticList.getData())), staticList.getPlaceholdersBefore(), staticList.getPlaceholdersAfter());
                } else {
                    if (pageEvent instanceof PageEvent.Insert) {
                        PageEvent.Insert insert = (PageEvent.Insert) pageEvent;
                        if (insert.getLoadType() == LoadType.REFRESH) {
                            if (pageStore != null) {
                                throw new IllegalArgumentException("PageStore should be null on REFRESH. This likely indicates an error in the library. Please file a bug in the Buganizer".toString());
                            }
                            return new PageStore(insert.getPages(), insert.getPlaceholdersBefore(), insert.getPlaceholdersAfter());
                        }
                    }
                    if (pageStore == null) {
                        throw new IllegalArgumentException("PageStore should only be null on REFRESH. This likely indicates an error in the library. Please file a bug in the Buganizer".toString());
                    }
                    pageStore.processEvent(pageEvent);
                    return pageStore;
                }
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<PagingData<T>> flow = this.$this_asItemSnapshotListFlow;
            Ref.ObjectRef<CombinedLoadStates> objectRef = this.$errorCombinedLoadStates;
            Function1<CombinedLoadStates, Unit> function1 = this.$onLoadError;
            this.label = 1;
            if (FlowKt.collectLatest(flow, new AnonymousClass1(objectRef, function1, (ProducerScope) this.L$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
