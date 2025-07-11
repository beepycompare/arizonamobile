package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PagingDataPresenter.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PagingDataPresenter$collectFrom$2", f = "PagingDataPresenter.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class PagingDataPresenter$collectFrom$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ PagingData<T> $pagingData;
    int label;
    final /* synthetic */ PagingDataPresenter<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagingDataPresenter$collectFrom$2(PagingDataPresenter<T> pagingDataPresenter, PagingData<T> pagingData, Continuation<? super PagingDataPresenter$collectFrom$2> continuation) {
        super(1, continuation);
        this.this$0 = pagingDataPresenter;
        this.$pagingData = pagingData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PagingDataPresenter$collectFrom$2(this.this$0, this.$pagingData, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((PagingDataPresenter$collectFrom$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.setUiReceiver(this.$pagingData.getUiReceiver$paging_common_release());
            Flow flow$paging_common_release = this.$pagingData.getFlow$paging_common_release();
            final PagingDataPresenter<T> pagingDataPresenter = this.this$0;
            final PagingData<T> pagingData = this.$pagingData;
            this.label = 1;
            if (flow$paging_common_release.collect(new FlowCollector() { // from class: androidx.paging.PagingDataPresenter$collectFrom$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((PageEvent) ((PageEvent) obj2), (Continuation<? super Unit>) continuation);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: PagingDataPresenter.kt */
                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.paging.PagingDataPresenter$collectFrom$2$1$2", f = "PagingDataPresenter.kt", i = {}, l = {141, 158, 170, 173, 225, 228}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.paging.PagingDataPresenter$collectFrom$2$1$2  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PageEvent<T> $event;
                    final /* synthetic */ PagingData<T> $pagingData;
                    int label;
                    final /* synthetic */ PagingDataPresenter<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(PageEvent<T> pageEvent, PagingDataPresenter<T> pagingDataPresenter, PagingData<T> pagingData, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$event = pageEvent;
                        this.this$0 = pagingDataPresenter;
                        this.$pagingData = pagingData;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$event, this.this$0, this.$pagingData, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:
                        if (r14 == r0) goto L24;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ce, code lost:
                        if (r14 == r0) goto L24;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f4, code lost:
                        if (kotlinx.coroutines.YieldKt.yield(r13) == r0) goto L24;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:38:0x010e, code lost:
                        if (r14.presentPagingDataEvent(r1.processEvent(r13.$event), r13) != r0) goto L26;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:87:0x023f, code lost:
                        if (kotlinx.coroutines.YieldKt.yield(r13) == r0) goto L24;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:90:0x0258, code lost:
                        if (r14.presentPagingDataEvent(r1.processEvent(r13.$event), r13) != r0) goto L7;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:105:0x02b7 A[LOOP:0: B:103:0x02b1->B:105:0x02b7, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:98:0x029d  */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection;
                        MutableStateFlow mutableStateFlow;
                        MutableStateFlow mutableStateFlow2;
                        Object presentNewList;
                        Object presentNewList2;
                        PageStore pageStore;
                        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection2;
                        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection3;
                        boolean z;
                        HintReceiver hintReceiver;
                        PageStore pageStore2;
                        int i;
                        int i2;
                        PageStore pageStore3;
                        int i3;
                        PageStore pageStore4;
                        PageStore pageStore5;
                        PageStore pageStore6;
                        PageEvent<T> pageEvent;
                        CopyOnWriteArrayList<Function0> copyOnWriteArrayList;
                        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection4;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        boolean z2 = true;
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                PageEvent<T> pageEvent2 = this.$event;
                                if (pageEvent2 instanceof PageEvent.StaticList) {
                                    PagingDataPresenter<T> pagingDataPresenter = this.this$0;
                                    List listOf = CollectionsKt.listOf(new TransformablePage(0, ((PageEvent.StaticList) this.$event).getData()));
                                    boolean z3 = (((PageEvent.StaticList) this.$event).getSourceLoadStates() == null && ((PageEvent.StaticList) this.$event).getMediatorLoadStates() == null) ? false : true;
                                    this.label = 1;
                                    presentNewList2 = pagingDataPresenter.presentNewList(listOf, 0, 0, z3, ((PageEvent.StaticList) this.$event).getSourceLoadStates(), ((PageEvent.StaticList) this.$event).getMediatorLoadStates(), this.$pagingData.getHintReceiver$paging_common_release(), this);
                                    break;
                                } else if ((pageEvent2 instanceof PageEvent.Insert) && ((PageEvent.Insert) pageEvent2).getLoadType() == LoadType.REFRESH) {
                                    this.label = 2;
                                    presentNewList = this.this$0.presentNewList(((PageEvent.Insert) this.$event).getPages(), ((PageEvent.Insert) this.$event).getPlaceholdersBefore(), ((PageEvent.Insert) this.$event).getPlaceholdersAfter(), true, ((PageEvent.Insert) this.$event).getSourceLoadStates(), ((PageEvent.Insert) this.$event).getMediatorLoadStates(), this.$pagingData.getHintReceiver$paging_common_release(), this);
                                    break;
                                } else {
                                    PageEvent<T> pageEvent3 = this.$event;
                                    if (pageEvent3 instanceof PageEvent.Insert) {
                                        mutableStateFlow2 = ((PagingDataPresenter) this.this$0).inGetItem;
                                        if (((Boolean) mutableStateFlow2.getValue()).booleanValue()) {
                                            this.label = 3;
                                            break;
                                        }
                                        PagingDataPresenter<T> pagingDataPresenter2 = this.this$0;
                                        pageStore = ((PagingDataPresenter) pagingDataPresenter2).pageStore;
                                        this.label = 4;
                                        break;
                                    } else if (pageEvent3 instanceof PageEvent.Drop) {
                                        mutableStateFlow = ((PagingDataPresenter) this.this$0).inGetItem;
                                        if (((Boolean) mutableStateFlow.getValue()).booleanValue()) {
                                            this.label = 5;
                                            break;
                                        }
                                        PagingDataPresenter<T> pagingDataPresenter3 = this.this$0;
                                        pageStore6 = ((PagingDataPresenter) pagingDataPresenter3).pageStore;
                                        this.label = 6;
                                        break;
                                    } else {
                                        if (pageEvent3 instanceof PageEvent.LoadStateUpdate) {
                                            mutableCombinedLoadStateCollection = ((PagingDataPresenter) this.this$0).combinedLoadStatesCollection;
                                            mutableCombinedLoadStateCollection.set(((PageEvent.LoadStateUpdate) this.$event).getSource(), ((PageEvent.LoadStateUpdate) this.$event).getMediator());
                                        }
                                        pageEvent = this.$event;
                                        if (!(pageEvent instanceof PageEvent.Insert) || (pageEvent instanceof PageEvent.Drop) || (pageEvent instanceof PageEvent.StaticList)) {
                                            copyOnWriteArrayList = ((PagingDataPresenter) this.this$0).onPagesUpdatedListeners;
                                            for (Function0 function0 : copyOnWriteArrayList) {
                                                function0.invoke();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    return coroutine_suspended;
                                }
                                break;
                            case 1:
                            case 2:
                                ResultKt.throwOnFailure(obj);
                                pageEvent = this.$event;
                                if (!(pageEvent instanceof PageEvent.Insert)) {
                                    break;
                                }
                                copyOnWriteArrayList = ((PagingDataPresenter) this.this$0).onPagesUpdatedListeners;
                                while (r14.hasNext()) {
                                }
                                return Unit.INSTANCE;
                            case 3:
                                ResultKt.throwOnFailure(obj);
                                PagingDataPresenter<T> pagingDataPresenter22 = this.this$0;
                                pageStore = ((PagingDataPresenter) pagingDataPresenter22).pageStore;
                                this.label = 4;
                                break;
                            case 4:
                                ResultKt.throwOnFailure(obj);
                                mutableCombinedLoadStateCollection2 = ((PagingDataPresenter) this.this$0).combinedLoadStatesCollection;
                                mutableCombinedLoadStateCollection2.set(((PageEvent.Insert) this.$event).getSourceLoadStates(), ((PageEvent.Insert) this.$event).getMediatorLoadStates());
                                mutableCombinedLoadStateCollection3 = ((PagingDataPresenter) this.this$0).combinedLoadStatesCollection;
                                CombinedLoadStates value = mutableCombinedLoadStateCollection3.getStateFlow().getValue();
                                LoadStates source = value != null ? value.getSource() : null;
                                if (source == null) {
                                    throw new IllegalStateException("PagingDataPresenter.combinedLoadStatesCollection.stateFlow should not hold null CombinedLoadStates after Insert event.".toString());
                                }
                                boolean z4 = ((((PageEvent.Insert) this.$event).getLoadType() == LoadType.PREPEND && source.getPrepend().getEndOfPaginationReached()) || (((PageEvent.Insert) this.$event).getLoadType() == LoadType.APPEND && source.getAppend().getEndOfPaginationReached())) ? false : true;
                                List<TransformablePage<T>> pages = ((PageEvent.Insert) this.$event).getPages();
                                if (!(pages instanceof Collection) || !pages.isEmpty()) {
                                    Iterator<T> it = pages.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (!((TransformablePage) it.next()).getData().isEmpty()) {
                                                z2 = false;
                                            }
                                        }
                                    }
                                }
                                if (!z4) {
                                    ((PagingDataPresenter) this.this$0).lastAccessedIndexUnfulfilled = false;
                                } else {
                                    z = ((PagingDataPresenter) this.this$0).lastAccessedIndexUnfulfilled;
                                    if (z || z2) {
                                        if (!z2) {
                                            i2 = ((PagingDataPresenter) this.this$0).lastAccessedIndex;
                                            pageStore3 = ((PagingDataPresenter) this.this$0).pageStore;
                                            if (i2 >= pageStore3.getPlaceholdersBefore()) {
                                                i3 = ((PagingDataPresenter) this.this$0).lastAccessedIndex;
                                                pageStore4 = ((PagingDataPresenter) this.this$0).pageStore;
                                                int placeholdersBefore = pageStore4.getPlaceholdersBefore();
                                                pageStore5 = ((PagingDataPresenter) this.this$0).pageStore;
                                                if (i3 <= placeholdersBefore + pageStore5.getDataCount()) {
                                                    ((PagingDataPresenter) this.this$0).lastAccessedIndexUnfulfilled = false;
                                                }
                                            }
                                        }
                                        hintReceiver = ((PagingDataPresenter) this.this$0).hintReceiver;
                                        if (hintReceiver != null) {
                                            pageStore2 = ((PagingDataPresenter) this.this$0).pageStore;
                                            i = ((PagingDataPresenter) this.this$0).lastAccessedIndex;
                                            hintReceiver.accessHint(pageStore2.accessHintForPresenterIndex(i));
                                        }
                                    }
                                }
                                pageEvent = this.$event;
                                if (!(pageEvent instanceof PageEvent.Insert)) {
                                }
                                copyOnWriteArrayList = ((PagingDataPresenter) this.this$0).onPagesUpdatedListeners;
                                while (r14.hasNext()) {
                                }
                                return Unit.INSTANCE;
                            case 5:
                                ResultKt.throwOnFailure(obj);
                                PagingDataPresenter<T> pagingDataPresenter32 = this.this$0;
                                pageStore6 = ((PagingDataPresenter) pagingDataPresenter32).pageStore;
                                this.label = 6;
                                break;
                            case 6:
                                ResultKt.throwOnFailure(obj);
                                mutableCombinedLoadStateCollection4 = ((PagingDataPresenter) this.this$0).combinedLoadStatesCollection;
                                mutableCombinedLoadStateCollection4.set(((PageEvent.Drop) this.$event).getLoadType(), false, LoadState.NotLoading.Companion.getIncomplete$paging_common_release());
                                ((PagingDataPresenter) this.this$0).lastAccessedIndexUnfulfilled = false;
                                pageEvent = this.$event;
                                if (!(pageEvent instanceof PageEvent.Insert)) {
                                }
                                copyOnWriteArrayList = ((PagingDataPresenter) this.this$0).onPagesUpdatedListeners;
                                while (r14.hasNext()) {
                                }
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                public final Object emit(PageEvent<T> pageEvent, Continuation<? super Unit> continuation) {
                    CoroutineContext coroutineContext;
                    PagingLogger pagingLogger = PagingLogger.INSTANCE;
                    if (pagingLogger.isLoggable(2)) {
                        pagingLogger.log(2, "Collected " + pageEvent, null);
                    }
                    coroutineContext = ((PagingDataPresenter) pagingDataPresenter).mainContext;
                    Object withContext = BuildersKt.withContext(coroutineContext, new AnonymousClass2(pageEvent, pagingDataPresenter, pagingData, null), continuation);
                    return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
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
}
