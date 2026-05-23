package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PageEvent;
import androidx.paging.PagingDataEvent;
import androidx.paging.internal.CopyOnWriteArrayList;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.concurrent.CancellationException;
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
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001OB#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u001b\u001a\u00070\u0014¢\u0006\u0002\b\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH¦@¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00070\u0014¢\u0006\u0002\b\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086@¢\u0006\u0002\u0010\"J\u001a\u0010%\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010&\u001a\u00020\u001aH\u0087\u0002¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010&\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010'J\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*J\u0006\u0010+\u001a\u00020\u0014J\u0006\u0010,\u001a\u00020\u0014J\u0014\u0010;\u001a\u00020\u00142\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0014\u0010=\u001a\u00020\u00142\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u001f\u0010>\u001a\u00020\u00142\u0017\u0010<\u001a\u0013\u0012\t\u0012\u000702¢\u0006\u0002\b\u001c\u0012\u0004\u0012\u00020\u00140?J\u001f\u0010@\u001a\u00020\u00142\u0017\u0010<\u001a\u0013\u0012\t\u0012\u000702¢\u0006\u0002\b\u001c\u0012\u0004\u0012\u00020\u00140?JV\u0010A\u001a\u00020\u00142\u0012\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000D0C2\u0006\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010K\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010LJ\u0010\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0019\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010201¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u001406X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u0014088F¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006P"}, d2 = {"Landroidx/paging/PagingDataPresenter;", ExifInterface.GPS_DIRECTION_TRUE, "", "mainContext", "Lkotlin/coroutines/CoroutineContext;", "cachedPagingData", "Landroidx/paging/PagingData;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Landroidx/paging/PagingData;)V", "hintReceiver", "Landroidx/paging/HintReceiver;", "uiReceiver", "Landroidx/paging/UiReceiver;", "pageStore", "Landroidx/paging/PageStore;", "combinedLoadStatesCollection", "Landroidx/paging/MutableCombinedLoadStateCollection;", "onPagesUpdatedListeners", "Landroidx/paging/internal/CopyOnWriteArrayList;", "Lkotlin/Function0;", "", "collectFromRunner", "Landroidx/paging/SingleRunner;", "lastAccessedIndexUnfulfilled", "", "lastAccessedIndex", "", "presentPagingDataEvent", "Lkotlin/jvm/JvmSuppressWildcards;", NotificationCompat.CATEGORY_EVENT, "Landroidx/paging/PagingDataEvent;", "(Landroidx/paging/PagingDataEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectFrom", "pagingData", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inGetItem", "Lkotlinx/coroutines/flow/MutableStateFlow;", "get", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "peek", "snapshot", "Landroidx/paging/ItemSnapshotList;", "retry", "refresh", "size", "getSize", "()I", "loadStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/paging/CombinedLoadStates;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_onPagesUpdatedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "onPagesUpdatedFlow", "Lkotlinx/coroutines/flow/Flow;", "getOnPagesUpdatedFlow", "()Lkotlinx/coroutines/flow/Flow;", "addOnPagesUpdatedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeOnPagesUpdatedListener", "addLoadStateListener", "Lkotlin/Function1;", "removeLoadStateListener", "presentNewList", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersBefore", "placeholdersAfter", "dispatchLoadStates", "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "newHintReceiver", "(Ljava/util/List;IIZLandroidx/paging/LoadStates;Landroidx/paging/LoadStates;Landroidx/paging/HintReceiver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUiReceiver", "receiver", "InitialUiReceiver", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        PageEvent.Insert<T> cachedEvent$paging_common;
        Intrinsics.checkNotNullParameter(mainContext, "mainContext");
        this.mainContext = mainContext;
        this.uiReceiver = new InitialUiReceiver();
        this.pageStore = PageStore.Companion.initial$paging_common(pagingData != null ? pagingData.cachedEvent$paging_common() : null);
        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = new MutableCombinedLoadStateCollection();
        if (pagingData != null && (cachedEvent$paging_common = pagingData.cachedEvent$paging_common()) != null) {
            mutableCombinedLoadStateCollection.set(cachedEvent$paging_common.getSourceLoadStates(), cachedEvent$paging_common.getMediatorLoadStates());
        }
        this.combinedLoadStatesCollection = mutableCombinedLoadStateCollection;
        this.onPagesUpdatedListeners = new CopyOnWriteArrayList<>();
        this.collectFromRunner = new SingleRunner(false, 1, null);
        this.inGetItem = StateFlowKt.MutableStateFlow(false);
        this.loadStateFlow = mutableCombinedLoadStateCollection.getStateFlow();
        this._onPagesUpdatedFlow = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.DROP_OLDEST);
        addOnPagesUpdatedListener(new Function0() { // from class: androidx.paging.PagingDataPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PagingDataPresenter._init_$lambda$0(PagingDataPresenter.this);
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
            hintReceiver.processHint(this.pageStore.createAccessHintForIndex(i));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(PagingDataPresenter pagingDataPresenter) {
        pagingDataPresenter._onPagesUpdatedFlow.tryEmit(Unit.INSTANCE);
        return Unit.INSTANCE;
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
    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d7 A[Catch: CancellationException -> 0x0064, TryCatch #1 {CancellationException -> 0x0064, blocks: (B:12:0x005a, B:29:0x00ce, B:31:0x00d7, B:33:0x00e5, B:35:0x00eb, B:37:0x00f1, B:39:0x0103, B:41:0x0109, B:43:0x010f, B:45:0x0147, B:46:0x0165, B:48:0x0183, B:49:0x018b, B:51:0x0191, B:53:0x0195), top: B:62:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0183 A[Catch: CancellationException -> 0x0064, TryCatch #1 {CancellationException -> 0x0064, blocks: (B:12:0x005a, B:29:0x00ce, B:31:0x00d7, B:33:0x00e5, B:35:0x00eb, B:37:0x00f1, B:39:0x0103, B:41:0x0109, B:43:0x010f, B:45:0x0147, B:46:0x0165, B:48:0x0183, B:49:0x018b, B:51:0x0191, B:53:0x0195), top: B:62:0x005a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object presentNewList(List<TransformablePage<T>> list, int i, int i2, boolean z, LoadStates loadStates, LoadStates loadStates2, HintReceiver hintReceiver, Continuation<? super Unit> continuation) {
        PagingDataPresenter$presentNewList$1 pagingDataPresenter$presentNewList$1;
        int i3;
        PageStore<T> pageStore;
        HintReceiver hintReceiver2;
        List<TransformablePage<T>> list2;
        boolean z2;
        HintReceiver hintReceiver3;
        PageStore<T> pageStore2;
        LoadStates loadStates3;
        LoadStates loadStates4;
        PagingLogger pagingLogger;
        HintReceiver hintReceiver4;
        List<T> data;
        List<T> data2;
        int i4 = i;
        int i5 = i2;
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
                    PageStore<T> pageStore3 = this.pageStore;
                    HintReceiver hintReceiver5 = this.hintReceiver;
                    PageStore<T> pageStore4 = new PageStore<>(list, i4, i5);
                    PageStore<T> pageStore5 = this.pageStore;
                    Intrinsics.checkNotNull(pageStore5, "null cannot be cast to non-null type androidx.paging.PlaceholderPaddedList<T of androidx.paging.PagingDataPresenter>");
                    PageStore<T> pageStore6 = pageStore5;
                    this.pageStore = pageStore4;
                    this.hintReceiver = hintReceiver;
                    try {
                        pagingDataPresenter$presentNewList$1.L$0 = list;
                        pagingDataPresenter$presentNewList$1.L$1 = loadStates;
                        pagingDataPresenter$presentNewList$1.L$2 = loadStates2;
                        pagingDataPresenter$presentNewList$1.L$3 = hintReceiver;
                        pagingDataPresenter$presentNewList$1.L$4 = pageStore3;
                        pagingDataPresenter$presentNewList$1.L$5 = hintReceiver5;
                        pagingDataPresenter$presentNewList$1.L$6 = pageStore4;
                        pagingDataPresenter$presentNewList$1.I$0 = i4;
                        pagingDataPresenter$presentNewList$1.I$1 = i5;
                        pagingDataPresenter$presentNewList$1.Z$0 = z;
                        pagingDataPresenter$presentNewList$1.label = 1;
                        if (presentPagingDataEvent(new PagingDataEvent.Refresh<>(pageStore4, pageStore6), pagingDataPresenter$presentNewList$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list2 = list;
                        z2 = z;
                        hintReceiver3 = hintReceiver;
                        pageStore = pageStore3;
                        pageStore2 = pageStore4;
                        loadStates3 = loadStates;
                        hintReceiver2 = hintReceiver5;
                        loadStates4 = loadStates2;
                    } catch (CancellationException e) {
                        e = e;
                        pageStore = pageStore3;
                        hintReceiver2 = hintReceiver5;
                        this.pageStore = pageStore;
                        this.hintReceiver = hintReceiver2;
                        throw e;
                    }
                } else if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    z2 = pagingDataPresenter$presentNewList$1.Z$0;
                    int i6 = pagingDataPresenter$presentNewList$1.I$1;
                    int i7 = pagingDataPresenter$presentNewList$1.I$0;
                    pageStore2 = (PageStore) pagingDataPresenter$presentNewList$1.L$6;
                    hintReceiver2 = (HintReceiver) pagingDataPresenter$presentNewList$1.L$5;
                    pageStore = (PageStore) pagingDataPresenter$presentNewList$1.L$4;
                    hintReceiver3 = (HintReceiver) pagingDataPresenter$presentNewList$1.L$3;
                    loadStates4 = (LoadStates) pagingDataPresenter$presentNewList$1.L$2;
                    loadStates3 = (LoadStates) pagingDataPresenter$presentNewList$1.L$1;
                    list2 = (List) pagingDataPresenter$presentNewList$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i5 = i6;
                        i4 = i7;
                    } catch (CancellationException e2) {
                        e = e2;
                        this.pageStore = pageStore;
                        this.hintReceiver = hintReceiver2;
                        throw e;
                    }
                }
                pagingLogger = PagingLogger.INSTANCE;
                if (pagingLogger.isLoggable(3)) {
                    StringBuilder sb = new StringBuilder("Presenting data (\n                            |   first item: ");
                    TransformablePage transformablePage = (TransformablePage) CollectionsKt.firstOrNull((List<? extends Object>) list2);
                    StringBuilder append = sb.append((transformablePage == null || (data2 = transformablePage.getData()) == null) ? null : CollectionsKt.firstOrNull((List<? extends Object>) data2)).append("\n                            |   last item: ");
                    TransformablePage transformablePage2 = (TransformablePage) CollectionsKt.lastOrNull((List<? extends Object>) list2);
                    String sb2 = append.append((transformablePage2 == null || (data = transformablePage2.getData()) == null) ? null : CollectionsKt.lastOrNull((List<? extends Object>) data)).append("\n                            |   placeholdersBefore: ").append(i4).append("\n                            |   placeholdersAfter: ").append(i5).append("\n                            |   hintReceiver: ").append(hintReceiver3).append("\n                            |   sourceLoadStates: ").append(loadStates3).append("\n                        ").toString();
                    if (loadStates4 != null) {
                        sb2 = sb2 + "|   mediatorLoadStates: " + loadStates4 + '\n';
                    }
                    pagingLogger.log(3, StringsKt.trimMargin$default(sb2 + "|)", null, 1, null), null);
                }
                if (z2) {
                    MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = this.combinedLoadStatesCollection;
                    Intrinsics.checkNotNull(loadStates3);
                    mutableCombinedLoadStateCollection.set(loadStates3, loadStates4);
                }
                if (pageStore2.getSize() == 0 && (hintReceiver4 = this.hintReceiver) != null) {
                    hintReceiver4.processHint(pageStore2.initializeHint());
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
        if (z2) {
        }
        if (pageStore2.getSize() == 0) {
            hintReceiver4.processHint(pageStore2.initializeHint());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PagingDataPresenter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Landroidx/paging/PagingDataPresenter$InitialUiReceiver;", "Landroidx/paging/UiReceiver;", "<init>", "()V", "shouldRetry", "", "getShouldRetry", "()Z", "setShouldRetry", "(Z)V", "shouldRefresh", "getShouldRefresh", "setShouldRefresh", "retry", "", "refresh", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class InitialUiReceiver implements UiReceiver {
        private boolean shouldRefresh;
        private boolean shouldRetry;

        public final boolean getShouldRetry() {
            return this.shouldRetry;
        }

        public final void setShouldRetry(boolean z) {
            this.shouldRetry = z;
        }

        public final boolean getShouldRefresh() {
            return this.shouldRefresh;
        }

        public final void setShouldRefresh(boolean z) {
            this.shouldRefresh = z;
        }

        @Override // androidx.paging.UiReceiver
        public void retry() {
            this.shouldRetry = true;
        }

        @Override // androidx.paging.UiReceiver
        public void refresh() {
            this.shouldRefresh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUiReceiver(UiReceiver uiReceiver) {
        UiReceiver uiReceiver2 = this.uiReceiver;
        this.uiReceiver = uiReceiver;
        if (uiReceiver2 instanceof InitialUiReceiver) {
            InitialUiReceiver initialUiReceiver = (InitialUiReceiver) uiReceiver2;
            if (initialUiReceiver.getShouldRetry()) {
                uiReceiver.retry();
            }
            if (initialUiReceiver.getShouldRefresh()) {
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
