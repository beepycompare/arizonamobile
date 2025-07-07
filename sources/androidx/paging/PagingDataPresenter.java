package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PageEvent;
import androidx.paging.PagingDataEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: PagingDataPresenter.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001OB!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001f\u0010+\u001a\u00020\n2\u0017\u0010,\u001a\u0013\u0012\t\u0012\u00070\u0019¢\u0006\u0002\b.\u0012\u0004\u0012\u00020\n0-J\u0014\u0010/\u001a\u00020\n2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\"J!\u00100\u001a\u00070\n¢\u0006\u0002\b.2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086@¢\u0006\u0002\u00102J\u001a\u00103\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u00104\u001a\u00020\u0015H\u0087\u0002¢\u0006\u0002\u00105J\u0019\u00106\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u00104\u001a\u00020\u0015H\u0007¢\u0006\u0002\u00105JV\u00107\u001a\u00020\n2\u0012\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000:092\u0006\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00132\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010A\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010BJ!\u0010C\u001a\u00070\n¢\u0006\u0002\b.2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000EH¦@¢\u0006\u0002\u0010FJ\u0006\u0010G\u001a\u00020\nJ\u001f\u0010H\u001a\u00020\n2\u0017\u0010,\u001a\u0013\u0012\t\u0012\u00070\u0019¢\u0006\u0002\b.\u0012\u0004\u0012\u00020\n0-J\u0014\u0010I\u001a\u00020\n2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\"J\u0006\u0010J\u001a\u00020\nJ\u0010\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020*H\u0002J\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000NR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\"0!j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\"`#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Landroidx/paging/PagingDataPresenter;", ExifInterface.GPS_DIRECTION_TRUE, "", "mainContext", "Lkotlin/coroutines/CoroutineContext;", "cachedPagingData", "Landroidx/paging/PagingData;", "(Lkotlin/coroutines/CoroutineContext;Landroidx/paging/PagingData;)V", "_onPagesUpdatedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "collectFromRunner", "Landroidx/paging/SingleRunner;", "combinedLoadStatesCollection", "Landroidx/paging/MutableCombinedLoadStateCollection;", "hintReceiver", "Landroidx/paging/HintReceiver;", "inGetItem", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "lastAccessedIndex", "", "lastAccessedIndexUnfulfilled", "loadStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/paging/CombinedLoadStates;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "onPagesUpdatedFlow", "Lkotlinx/coroutines/flow/Flow;", "getOnPagesUpdatedFlow", "()Lkotlinx/coroutines/flow/Flow;", "onPagesUpdatedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "Landroidx/paging/internal/CopyOnWriteArrayList;", "pageStore", "Landroidx/paging/PageStore;", "size", "getSize", "()I", "uiReceiver", "Landroidx/paging/UiReceiver;", "addLoadStateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "addOnPagesUpdatedListener", "collectFrom", "pagingData", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "peek", "presentNewList", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersBefore", "placeholdersAfter", "dispatchLoadStates", "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "newHintReceiver", "(Ljava/util/List;IIZLandroidx/paging/LoadStates;Landroidx/paging/LoadStates;Landroidx/paging/HintReceiver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "presentPagingDataEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/paging/PagingDataEvent;", "(Landroidx/paging/PagingDataEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "removeLoadStateListener", "removeOnPagesUpdatedListener", "retry", "setUiReceiver", "receiver", "snapshot", "Landroidx/paging/ItemSnapshotList;", "InitialUiReceiver", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PagingDataPresenter<T> {
    private final MutableSharedFlow<Unit> _onPagesUpdatedFlow;
    private final SingleRunner collectFromRunner;
    private final MutableCombinedLoadStateCollection combinedLoadStatesCollection;
    private HintReceiver hintReceiver;
    private final MutableStateFlow<Boolean> inGetItem;
    private volatile int lastAccessedIndex;
    private volatile boolean lastAccessedIndexUnfulfilled;
    private final StateFlow<CombinedLoadStates> loadStateFlow;
    private final CoroutineContext mainContext;
    private final CopyOnWriteArrayList<Function0<Unit>> onPagesUpdatedListeners;
    private PageStore<T> pageStore;
    private UiReceiver uiReceiver;

    public PagingDataPresenter() {
        this(null, null, 3, null);
    }

    public abstract Object presentPagingDataEvent(PagingDataEvent<T> pagingDataEvent, Continuation<Unit> continuation);

    public PagingDataPresenter(CoroutineContext mainContext, PagingData<T> pagingData) {
        PageEvent.Insert<T> cachedEvent$paging_common_release;
        Intrinsics.checkNotNullParameter(mainContext, "mainContext");
        this.mainContext = mainContext;
        this.uiReceiver = new InitialUiReceiver();
        this.pageStore = PageStore.Companion.initial$paging_common_release(pagingData != null ? pagingData.cachedEvent$paging_common_release() : null);
        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = new MutableCombinedLoadStateCollection();
        if (pagingData != null && (cachedEvent$paging_common_release = pagingData.cachedEvent$paging_common_release()) != null) {
            mutableCombinedLoadStateCollection.set(cachedEvent$paging_common_release.getSourceLoadStates(), cachedEvent$paging_common_release.getMediatorLoadStates());
        }
        this.combinedLoadStatesCollection = mutableCombinedLoadStateCollection;
        this.onPagesUpdatedListeners = new CopyOnWriteArrayList<>();
        this.collectFromRunner = new SingleRunner(false, 1, null);
        this.inGetItem = StateFlowKt.MutableStateFlow(false);
        this.loadStateFlow = mutableCombinedLoadStateCollection.getStateFlow();
        this._onPagesUpdatedFlow = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.DROP_OLDEST);
        addOnPagesUpdatedListener(new Function0<Unit>(this) { // from class: androidx.paging.PagingDataPresenter.1
            final /* synthetic */ PagingDataPresenter<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((PagingDataPresenter) this.this$0)._onPagesUpdatedFlow.tryEmit(Unit.INSTANCE);
            }
        });
    }

    public /* synthetic */ PagingDataPresenter(MainCoroutineDispatcher mainCoroutineDispatcher, PagingData pagingData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 2) != 0 ? null : pagingData);
    }

    public final Object collectFrom(PagingData<T> pagingData, Continuation<Unit> continuation) {
        Object runInIsolation$default = SingleRunner.runInIsolation$default(this.collectFromRunner, 0, new PagingDataPresenter$collectFrom$2(this, pagingData, null), continuation, 1, null);
        return runInIsolation$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? runInIsolation$default : Unit.INSTANCE;
    }

    public final T get(int i) {
        Boolean value;
        Boolean value2;
        MutableStateFlow<Boolean> mutableStateFlow = this.inGetItem;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, true));
        this.lastAccessedIndexUnfulfilled = true;
        this.lastAccessedIndex = i;
        PagingLogger pagingLogger = PagingLogger.INSTANCE;
        if (pagingLogger.isLoggable(2)) {
            pagingLogger.log(2, "Accessing item index[" + i + AbstractJsonLexerKt.END_LIST, null);
        }
        HintReceiver hintReceiver = this.hintReceiver;
        if (hintReceiver != null) {
            hintReceiver.accessHint(this.pageStore.accessHintForPresenterIndex(i));
        }
        T t = this.pageStore.get(i);
        MutableStateFlow<Boolean> mutableStateFlow2 = this.inGetItem;
        do {
            value2 = mutableStateFlow2.getValue();
            value2.booleanValue();
        } while (!mutableStateFlow2.compareAndSet(value2, false));
        return t;
    }

    public final T peek(int i) {
        return this.pageStore.get(i);
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.pageStore.snapshot();
    }

    public final int getSize() {
        return this.pageStore.getSize();
    }

    public final StateFlow<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final Flow<Unit> getOnPagesUpdatedFlow() {
        return FlowKt.asSharedFlow(this._onPagesUpdatedFlow);
    }

    public final void addOnPagesUpdatedListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onPagesUpdatedListeners.add(listener);
    }

    public final void removeOnPagesUpdatedListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onPagesUpdatedListeners.remove(listener);
    }

    public final void addLoadStateListener(Function1<CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.combinedLoadStatesCollection.addListener(listener);
    }

    public final void removeLoadStateListener(Function1<CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.combinedLoadStatesCollection.removeListener(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object presentNewList(List<TransformablePage<T>> list, int i, int i2, boolean z, LoadStates loadStates, LoadStates loadStates2, HintReceiver hintReceiver, Continuation<? super Unit> continuation) {
        PagingDataPresenter$presentNewList$1 pagingDataPresenter$presentNewList$1;
        int i3;
        PageStore<T> pageStore;
        PagingDataPresenter<T> pagingDataPresenter;
        PagingLogger pagingLogger;
        HintReceiver hintReceiver2;
        List<T> data;
        List<T> data2;
        if (continuation instanceof PagingDataPresenter$presentNewList$1) {
            pagingDataPresenter$presentNewList$1 = (PagingDataPresenter$presentNewList$1) continuation;
            if ((pagingDataPresenter$presentNewList$1.label & Integer.MIN_VALUE) != 0) {
                pagingDataPresenter$presentNewList$1.label -= Integer.MIN_VALUE;
                Object obj = pagingDataPresenter$presentNewList$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = pagingDataPresenter$presentNewList$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (z && loadStates == null) {
                        throw new IllegalArgumentException("Cannot dispatch LoadStates in PagingDataPresenter without source LoadStates set.".toString());
                    }
                    this.lastAccessedIndexUnfulfilled = false;
                    pageStore = new PageStore<>(list, i, i2);
                    PageStore<T> pageStore2 = this.pageStore;
                    Intrinsics.checkNotNull(pageStore2, "null cannot be cast to non-null type androidx.paging.PlaceholderPaddedList<T of androidx.paging.PagingDataPresenter>");
                    this.pageStore = pageStore;
                    this.hintReceiver = hintReceiver;
                    PageStore<T> pageStore3 = pageStore;
                    pagingDataPresenter$presentNewList$1.L$0 = this;
                    pagingDataPresenter$presentNewList$1.L$1 = list;
                    pagingDataPresenter$presentNewList$1.L$2 = loadStates;
                    pagingDataPresenter$presentNewList$1.L$3 = loadStates2;
                    pagingDataPresenter$presentNewList$1.L$4 = hintReceiver;
                    pagingDataPresenter$presentNewList$1.L$5 = pageStore;
                    pagingDataPresenter$presentNewList$1.I$0 = i;
                    pagingDataPresenter$presentNewList$1.I$1 = i2;
                    pagingDataPresenter$presentNewList$1.Z$0 = z;
                    pagingDataPresenter$presentNewList$1.label = 1;
                    if (presentPagingDataEvent(new PagingDataEvent.Refresh<>(pageStore3, pageStore2), pagingDataPresenter$presentNewList$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pagingDataPresenter = this;
                } else if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    z = pagingDataPresenter$presentNewList$1.Z$0;
                    i2 = pagingDataPresenter$presentNewList$1.I$1;
                    i = pagingDataPresenter$presentNewList$1.I$0;
                    hintReceiver = (HintReceiver) pagingDataPresenter$presentNewList$1.L$4;
                    loadStates2 = (LoadStates) pagingDataPresenter$presentNewList$1.L$3;
                    loadStates = (LoadStates) pagingDataPresenter$presentNewList$1.L$2;
                    pagingDataPresenter = (PagingDataPresenter) pagingDataPresenter$presentNewList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    pageStore = (PageStore) pagingDataPresenter$presentNewList$1.L$5;
                    list = (List) pagingDataPresenter$presentNewList$1.L$1;
                }
                pagingLogger = PagingLogger.INSTANCE;
                if (pagingLogger.isLoggable(3)) {
                    StringBuilder sb = new StringBuilder("Presenting data (\n                            |   first item: ");
                    TransformablePage transformablePage = (TransformablePage) CollectionsKt.firstOrNull((List<? extends Object>) list);
                    StringBuilder append = sb.append((transformablePage == null || (data2 = transformablePage.getData()) == null) ? null : CollectionsKt.firstOrNull((List<? extends Object>) data2)).append("\n                            |   last item: ");
                    TransformablePage transformablePage2 = (TransformablePage) CollectionsKt.lastOrNull((List<? extends Object>) list);
                    String sb2 = append.append((transformablePage2 == null || (data = transformablePage2.getData()) == null) ? null : CollectionsKt.lastOrNull((List<? extends Object>) data)).append("\n                            |   placeholdersBefore: ").append(i).append("\n                            |   placeholdersAfter: ").append(i2).append("\n                            |   hintReceiver: ").append(hintReceiver).append("\n                            |   sourceLoadStates: ").append(loadStates).append("\n                        ").toString();
                    if (loadStates2 != null) {
                        sb2 = sb2 + "|   mediatorLoadStates: " + loadStates2 + '\n';
                    }
                    pagingLogger.log(3, StringsKt.trimMargin$default(sb2 + "|)", null, 1, null), null);
                }
                if (z) {
                    MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = pagingDataPresenter.combinedLoadStatesCollection;
                    Intrinsics.checkNotNull(loadStates);
                    mutableCombinedLoadStateCollection.set(loadStates, loadStates2);
                }
                if (pageStore.getSize() == 0 && (hintReceiver2 = pagingDataPresenter.hintReceiver) != null) {
                    hintReceiver2.accessHint(pageStore.initializeHint());
                }
                return Unit.INSTANCE;
            }
        }
        pagingDataPresenter$presentNewList$1 = new PagingDataPresenter$presentNewList$1(this, continuation);
        Object obj2 = pagingDataPresenter$presentNewList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = pagingDataPresenter$presentNewList$1.label;
        if (i3 != 0) {
        }
        pagingLogger = PagingLogger.INSTANCE;
        if (pagingLogger.isLoggable(3)) {
        }
        if (z) {
        }
        if (pageStore.getSize() == 0) {
            hintReceiver2.accessHint(pageStore.initializeHint());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PagingDataPresenter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\fH\u0016J\b\u0010\t\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Landroidx/paging/PagingDataPresenter$InitialUiReceiver;", "Landroidx/paging/UiReceiver;", "()V", "refresh", "", "getRefresh", "()Z", "setRefresh", "(Z)V", "retry", "getRetry", "setRetry", "", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class InitialUiReceiver implements UiReceiver {
        private boolean refresh;
        private boolean retry;

        public final boolean getRetry() {
            return this.retry;
        }

        public final void setRetry(boolean z) {
            this.retry = z;
        }

        public final boolean getRefresh() {
            return this.refresh;
        }

        public final void setRefresh(boolean z) {
            this.refresh = z;
        }

        @Override // androidx.paging.UiReceiver
        public void retry() {
            this.retry = true;
        }

        @Override // androidx.paging.UiReceiver
        public void refresh() {
            this.refresh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiReceiver(UiReceiver uiReceiver) {
        UiReceiver uiReceiver2 = this.uiReceiver;
        this.uiReceiver = uiReceiver;
        if (uiReceiver2 instanceof InitialUiReceiver) {
            InitialUiReceiver initialUiReceiver = (InitialUiReceiver) uiReceiver2;
            if (initialUiReceiver.getRetry()) {
                uiReceiver.retry();
            }
            if (initialUiReceiver.getRefresh()) {
                uiReceiver.refresh();
            }
        }
    }

    public final void retry() {
        PagingLogger pagingLogger = PagingLogger.INSTANCE;
        if (pagingLogger.isLoggable(3)) {
            pagingLogger.log(3, "Retry signal received", null);
        }
        this.uiReceiver.retry();
    }

    public final void refresh() {
        PagingLogger pagingLogger = PagingLogger.INSTANCE;
        if (pagingLogger.isLoggable(3)) {
            pagingLogger.log(3, "Refresh signal received", null);
        }
        this.uiReceiver.refresh();
    }
}
