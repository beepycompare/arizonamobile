package androidx.paging;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: AsyncPagingDataDiffer.kt */
@Metadata(d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003*\u0001N\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B3\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB)\b\u0017\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\f¢\u0006\u0004\b\n\u0010\rB3\b\u0017\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\f\u0012\b\b\u0002\u0010\t\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001c\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0086@¢\u0006\u0002\u0010#J\u001c\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"J\u0006\u0010&\u001a\u00020 J\u0006\u0010'\u001a\u00020 J\u0019\u0010(\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010)\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010*J\u0019\u0010+\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010)\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010*J\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-J\u0014\u00108\u001a\u00020 2\f\u00109\u001a\b\u0012\u0004\u0012\u00020 0:J\u0014\u0010;\u001a\u00020 2\f\u00109\u001a\b\u0012\u0004\u0012\u00020 0:J\u001a\u0010@\u001a\u00020 2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020 0=J\u001a\u0010A\u001a\u00020 2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020 0=J!\u0010B\u001a\u00020 2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020 0=H\u0000¢\u0006\u0002\bCR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020302¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020 02¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\"\u0010<\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020 \u0018\u00010=0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020 0=0?X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010D\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020 0=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bI\u0010JR\u0010\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0004\n\u0002\u0010O¨\u0006P"}, d2 = {"Landroidx/paging/AsyncPagingDataDiffer;", ExifInterface.GPS_DIRECTION_TRUE, "", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "updateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "mainDispatcher", "Lkotlin/coroutines/CoroutineContext;", "workerDispatcher", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Landroidx/recyclerview/widget/ListUpdateCallback;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Landroidx/recyclerview/widget/ListUpdateCallback;Lkotlinx/coroutines/CoroutineDispatcher;)V", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Landroidx/recyclerview/widget/ListUpdateCallback;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "inGetItem", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getInGetItem$paging_runtime", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "lastAccessedIndex", "", "previousPresenter", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/paging/PlaceholderPaddedList;", "presenter", "Landroidx/paging/PagingDataPresenter;", "getPresenter$paging_runtime", "()Landroidx/paging/PagingDataPresenter;", "submitDataId", "Ljava/util/concurrent/atomic/AtomicInteger;", "submitData", "", "pagingData", "Landroidx/paging/PagingData;", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "retry", "refresh", "getItem", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "peek", "snapshot", "Landroidx/paging/ItemSnapshotList;", "itemCount", "getItemCount", "()I", "loadStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/CombinedLoadStates;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "onPagesUpdatedFlow", "getOnPagesUpdatedFlow", "addOnPagesUpdatedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function0;", "removeOnPagesUpdatedListener", "parentLoadStateListener", "Lkotlin/Function1;", "childLoadStateListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addLoadStateListener", "removeLoadStateListener", "addLoadStateListenerInternal", "addLoadStateListenerInternal$paging_runtime", "internalLoadStateListener", "getInternalLoadStateListener$paging_runtime", "()Lkotlin/jvm/functions/Function1;", "LoadStateListenerHandler", "Landroid/os/Handler;", "getLoadStateListenerHandler", "()Landroid/os/Handler;", "LoadStateListenerHandler$delegate", "Lkotlin/Lazy;", "LoadStateListenerRunnable", "androidx/paging/AsyncPagingDataDiffer$LoadStateListenerRunnable$1", "Landroidx/paging/AsyncPagingDataDiffer$LoadStateListenerRunnable$1;", "paging-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AsyncPagingDataDiffer<T> {
    private final Lazy LoadStateListenerHandler$delegate;
    private final AsyncPagingDataDiffer$LoadStateListenerRunnable$1 LoadStateListenerRunnable;
    private final CopyOnWriteArrayList<Function1<CombinedLoadStates, Unit>> childLoadStateListeners;
    private final DiffUtil.ItemCallback<T> diffCallback;
    private final MutableStateFlow<Boolean> inGetItem;
    private final Function1<CombinedLoadStates, Unit> internalLoadStateListener;
    private int lastAccessedIndex;
    private final Flow<CombinedLoadStates> loadStateFlow;
    private final CoroutineContext mainDispatcher;
    private final Flow<Unit> onPagesUpdatedFlow;
    private final AtomicReference<Function1<CombinedLoadStates, Unit>> parentLoadStateListener;
    private final PagingDataPresenter<T> presenter;
    private final AtomicReference<PlaceholderPaddedList<T>> previousPresenter;
    private final AtomicInteger submitDataId;
    private final ListUpdateCallback updateCallback;
    private final CoroutineContext workerDispatcher;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> diffCallback, ListUpdateCallback updateCallback) {
        this(diffCallback, updateCallback, (CoroutineContext) null, (CoroutineContext) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> diffCallback, ListUpdateCallback updateCallback, CoroutineContext mainDispatcher) {
        this(diffCallback, updateCallback, mainDispatcher, (CoroutineContext) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
    }

    public AsyncPagingDataDiffer(DiffUtil.ItemCallback<T> diffCallback, ListUpdateCallback updateCallback, CoroutineContext mainDispatcher, CoroutineContext workerDispatcher) {
        Flow buffer$default;
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workerDispatcher, "workerDispatcher");
        this.diffCallback = diffCallback;
        this.updateCallback = updateCallback;
        this.mainDispatcher = mainDispatcher;
        this.workerDispatcher = workerDispatcher;
        this.inGetItem = StateFlowKt.MutableStateFlow(false);
        this.previousPresenter = new AtomicReference<>(null);
        AsyncPagingDataDiffer$presenter$1 asyncPagingDataDiffer$presenter$1 = new AsyncPagingDataDiffer$presenter$1(this, mainDispatcher);
        this.presenter = asyncPagingDataDiffer$presenter$1;
        this.submitDataId = new AtomicInteger(0);
        buffer$default = FlowKt__ContextKt.buffer$default(FlowKt.filterNotNull(asyncPagingDataDiffer$presenter$1.getLoadStateFlow()), -1, null, 2, null);
        this.loadStateFlow = FlowKt.flowOn(FlowKt.flow(new AsyncPagingDataDiffer$special$$inlined$transform$1(buffer$default, null, this)), Dispatchers.getMain());
        this.onPagesUpdatedFlow = asyncPagingDataDiffer$presenter$1.getOnPagesUpdatedFlow();
        this.parentLoadStateListener = new AtomicReference<>(null);
        this.childLoadStateListeners = new CopyOnWriteArrayList<>();
        this.internalLoadStateListener = new Function1() { // from class: androidx.paging.AsyncPagingDataDiffer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AsyncPagingDataDiffer.internalLoadStateListener$lambda$0(AsyncPagingDataDiffer.this, (CombinedLoadStates) obj);
            }
        };
        this.LoadStateListenerHandler$delegate = LazyKt.lazy(new Function0() { // from class: androidx.paging.AsyncPagingDataDiffer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AsyncPagingDataDiffer.LoadStateListenerHandler_delegate$lambda$0();
            }
        });
        this.LoadStateListenerRunnable = new AsyncPagingDataDiffer$LoadStateListenerRunnable$1(this);
    }

    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback itemCallback, ListUpdateCallback listUpdateCallback, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, listUpdateCallback, (i & 4) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 8) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback itemCallback, ListUpdateCallback listUpdateCallback, MainCoroutineDispatcher mainCoroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, listUpdateCallback, (i & 4) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by constructors which accept CoroutineContext")
    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback diffCallback, ListUpdateCallback updateCallback, CoroutineDispatcher mainDispatcher) {
        this(diffCallback, updateCallback, (CoroutineContext) mainDispatcher, (CoroutineContext) Dispatchers.getDefault());
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
    }

    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback itemCallback, ListUpdateCallback listUpdateCallback, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, listUpdateCallback, (i & 4) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 8) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by constructors which accept CoroutineContext")
    public /* synthetic */ AsyncPagingDataDiffer(DiffUtil.ItemCallback diffCallback, ListUpdateCallback updateCallback, CoroutineDispatcher mainDispatcher, CoroutineDispatcher workerDispatcher) {
        this(diffCallback, updateCallback, (CoroutineContext) mainDispatcher, (CoroutineContext) workerDispatcher);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workerDispatcher, "workerDispatcher");
    }

    public final MutableStateFlow<Boolean> getInGetItem$paging_runtime() {
        return this.inGetItem;
    }

    public final PagingDataPresenter<T> getPresenter$paging_runtime() {
        return this.presenter;
    }

    public final Object submitData(PagingData<T> pagingData, Continuation<? super Unit> continuation) {
        this.submitDataId.incrementAndGet();
        Object collectFrom = this.presenter.collectFrom(pagingData, continuation);
        return collectFrom == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectFrom : Unit.INSTANCE;
    }

    public final void submitData(Lifecycle lifecycle, PagingData<T> pagingData) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(pagingData, "pagingData");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new AsyncPagingDataDiffer$submitData$2(this, this.submitDataId.incrementAndGet(), pagingData, null), 3, null);
    }

    public final void retry() {
        this.presenter.retry();
    }

    public final void refresh() {
        this.presenter.refresh();
    }

    public final T getItem(int i) {
        Boolean value;
        Boolean value2;
        T t;
        Boolean value3;
        Object obj;
        try {
            MutableStateFlow<Boolean> mutableStateFlow = this.inGetItem;
            do {
                value2 = mutableStateFlow.getValue();
                value2.booleanValue();
            } while (!mutableStateFlow.compareAndSet(value2, true));
            this.lastAccessedIndex = i;
            PlaceholderPaddedList<T> placeholderPaddedList = this.previousPresenter.get();
            if (placeholderPaddedList != null) {
                obj = AsyncPagingDataDifferKt.get(placeholderPaddedList, i);
                t = (T) obj;
            } else {
                t = this.presenter.get(i);
            }
            MutableStateFlow<Boolean> mutableStateFlow2 = this.inGetItem;
            do {
                value3 = mutableStateFlow2.getValue();
                value3.booleanValue();
            } while (!mutableStateFlow2.compareAndSet(value3, false));
            return t;
        } catch (Throwable th) {
            MutableStateFlow<Boolean> mutableStateFlow3 = this.inGetItem;
            do {
                value = mutableStateFlow3.getValue();
                value.booleanValue();
            } while (!mutableStateFlow3.compareAndSet(value, false));
            throw th;
        }
    }

    public final T peek(int i) {
        Object peek;
        PlaceholderPaddedList<T> placeholderPaddedList = this.previousPresenter.get();
        if (placeholderPaddedList != null) {
            peek = AsyncPagingDataDifferKt.peek(placeholderPaddedList, i);
            return (T) peek;
        }
        return this.presenter.peek(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = androidx.paging.AsyncPagingDataDifferKt.snapshot(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ItemSnapshotList<T> snapshot() {
        ItemSnapshotList<T> snapshot;
        PlaceholderPaddedList<T> placeholderPaddedList = this.previousPresenter.get();
        return (placeholderPaddedList == null || snapshot == null) ? this.presenter.snapshot() : snapshot;
    }

    public final int getItemCount() {
        PlaceholderPaddedList<T> placeholderPaddedList = this.previousPresenter.get();
        return placeholderPaddedList != null ? placeholderPaddedList.getSize() : this.presenter.getSize();
    }

    public final Flow<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final Flow<Unit> getOnPagesUpdatedFlow() {
        return this.onPagesUpdatedFlow;
    }

    public final void addOnPagesUpdatedListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.presenter.addOnPagesUpdatedListener(listener);
    }

    public final void removeOnPagesUpdatedListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.presenter.removeOnPagesUpdatedListener(listener);
    }

    public final void addLoadStateListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.parentLoadStateListener.get() == null) {
            addLoadStateListenerInternal$paging_runtime(this.internalLoadStateListener);
        }
        this.childLoadStateListeners.add(listener);
    }

    public final void removeLoadStateListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Function1<CombinedLoadStates, Unit> function1;
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.childLoadStateListeners.remove(listener);
        if (!this.childLoadStateListeners.isEmpty() || (function1 = this.parentLoadStateListener.get()) == null) {
            return;
        }
        this.presenter.removeLoadStateListener(function1);
    }

    public final void addLoadStateListenerInternal$paging_runtime(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.parentLoadStateListener.set(listener);
        this.presenter.addLoadStateListener(listener);
    }

    public final Function1<CombinedLoadStates, Unit> getInternalLoadStateListener$paging_runtime() {
        return this.internalLoadStateListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit internalLoadStateListener$lambda$0(AsyncPagingDataDiffer asyncPagingDataDiffer, CombinedLoadStates loadState) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (asyncPagingDataDiffer.inGetItem.getValue().booleanValue()) {
            Handler loadStateListenerHandler = asyncPagingDataDiffer.getLoadStateListenerHandler();
            loadStateListenerHandler.removeCallbacks(asyncPagingDataDiffer.LoadStateListenerRunnable);
            asyncPagingDataDiffer.LoadStateListenerRunnable.getLoadState().set(loadState);
            loadStateListenerHandler.post(asyncPagingDataDiffer.LoadStateListenerRunnable);
        } else {
            Iterator<T> it = asyncPagingDataDiffer.childLoadStateListeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(loadState);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Handler LoadStateListenerHandler_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    private final Handler getLoadStateListenerHandler() {
        return (Handler) this.LoadStateListenerHandler$delegate.getValue();
    }
}
