package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.paging.LoadState;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
/* compiled from: PagingDataAdapter.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u001f\b\u0017\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB)\b\u0017\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fB)\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\r\u0012\b\b\u0002\u0010\u000b\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u001b\u001a\u00020\u00172\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00170\u001dJ\u0014\u0010\u001e\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001fJ\u0019\u0010 \u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010!\u001a\u00020\"H\u0005¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\"H\u0016J\u000e\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\"J\u0019\u0010'\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010(\u001a\u00020\"H\u0007¢\u0006\u0002\u0010#J\u0006\u0010)\u001a\u00020\u0017J\u001a\u0010*\u001a\u00020\u00172\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00170\u001dJ\u0014\u0010+\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001fJ\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u001aJ\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u000201H\u0016J\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000003J\u001c\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000008J\u001c\u00104\u001a\u00020\u00172\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000008H\u0086@¢\u0006\u0002\u00109J\u0012\u0010:\u001a\u00020;2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030=J\u0012\u0010>\u001a\u00020;2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030=J\u001e\u0010@\u001a\u00020;2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030=2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030=R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Landroidx/paging/PagingDataAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/CoroutineDispatcher;)V", "workerDispatcher", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "differ", "Landroidx/paging/AsyncPagingDataDiffer;", "loadStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/CombinedLoadStates;", "getLoadStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "onPagesUpdatedFlow", "", "getOnPagesUpdatedFlow", "userSetRestorationPolicy", "", "addLoadStateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "addOnPagesUpdatedListener", "Lkotlin/Function0;", "getItem", "position", "", "(I)Ljava/lang/Object;", "getItemCount", "getItemId", "", "peek", FirebaseAnalytics.Param.INDEX, "refresh", "removeLoadStateListener", "removeOnPagesUpdatedListener", "retry", "setHasStableIds", "hasStableIds", "setStateRestorationPolicy", "strategy", "Landroidx/recyclerview/widget/RecyclerView$Adapter$StateRestorationPolicy;", "snapshot", "Landroidx/paging/ItemSnapshotList;", "submitData", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "pagingData", "Landroidx/paging/PagingData;", "(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withLoadStateFooter", "Landroidx/recyclerview/widget/ConcatAdapter;", "footer", "Landroidx/paging/LoadStateAdapter;", "withLoadStateHeader", "header", "withLoadStateHeaderAndFooter", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PagingDataAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncPagingDataDiffer<T> differ;
    private final Flow<CombinedLoadStates> loadStateFlow;
    private final Flow<Unit> onPagesUpdatedFlow;
    private boolean userSetRestorationPolicy;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagingDataAdapter(DiffUtil.ItemCallback<T> diffCallback) {
        this(diffCallback, (CoroutineContext) null, (CoroutineContext) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagingDataAdapter(DiffUtil.ItemCallback<T> diffCallback, CoroutineContext mainDispatcher) {
        this(diffCallback, mainDispatcher, (CoroutineContext) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, (i & 2) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> diffCallback, CoroutineContext mainDispatcher, CoroutineContext workerDispatcher) {
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workerDispatcher, "workerDispatcher");
        AsyncPagingDataDiffer<T> asyncPagingDataDiffer = new AsyncPagingDataDiffer<>(diffCallback, new AdapterListUpdateCallback(this), mainDispatcher, workerDispatcher);
        this.differ = asyncPagingDataDiffer;
        super.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT);
        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) { // from class: androidx.paging.PagingDataAdapter.1
            final /* synthetic */ PagingDataAdapter<T, VH> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                PagingDataAdapter._init_$considerAllowingStateRestoration(this.this$0);
                this.this$0.unregisterAdapterDataObserver(this);
                super.onItemRangeInserted(i, i2);
            }
        });
        addLoadStateListener(new Function1<CombinedLoadStates, Unit>(this) { // from class: androidx.paging.PagingDataAdapter.2
            private boolean ignoreNextEvent = true;
            final /* synthetic */ PagingDataAdapter<T, VH> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
                invoke2(combinedLoadStates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public void invoke2(CombinedLoadStates loadStates) {
                Intrinsics.checkNotNullParameter(loadStates, "loadStates");
                if (this.ignoreNextEvent) {
                    this.ignoreNextEvent = false;
                } else if (loadStates.getSource().getRefresh() instanceof LoadState.NotLoading) {
                    PagingDataAdapter._init_$considerAllowingStateRestoration(this.this$0);
                    this.this$0.removeLoadStateListener(this);
                }
            }
        });
        this.loadStateFlow = asyncPagingDataDiffer.getLoadStateFlow();
        this.onPagesUpdatedFlow = asyncPagingDataDiffer.getOnPagesUpdatedFlow();
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, MainCoroutineDispatcher mainCoroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, (i & 2) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by constructors which accept CoroutineContext")
    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback diffCallback, CoroutineDispatcher mainDispatcher) {
        this(diffCallback, (CoroutineContext) mainDispatcher, (CoroutineContext) Dispatchers.getDefault());
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, (i & 2) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher, (i & 4) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by constructors which accept CoroutineContext")
    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback diffCallback, CoroutineDispatcher mainDispatcher, CoroutineDispatcher workerDispatcher) {
        this(diffCallback, (CoroutineContext) mainDispatcher, (CoroutineContext) workerDispatcher);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(workerDispatcher, "workerDispatcher");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.userSetRestorationPolicy = true;
        super.setStateRestorationPolicy(strategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, VH extends RecyclerView.ViewHolder> void _init_$considerAllowingStateRestoration(PagingDataAdapter<T, VH> pagingDataAdapter) {
        if (pagingDataAdapter.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT || ((PagingDataAdapter) pagingDataAdapter).userSetRestorationPolicy) {
            return;
        }
        pagingDataAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        return super.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    public final Object submitData(PagingData<T> pagingData, Continuation<? super Unit> continuation) {
        Object submitData = this.differ.submitData(pagingData, continuation);
        return submitData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? submitData : Unit.INSTANCE;
    }

    public final void submitData(Lifecycle lifecycle, PagingData<T> pagingData) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(pagingData, "pagingData");
        this.differ.submitData(lifecycle, pagingData);
    }

    public final void retry() {
        this.differ.retry();
    }

    public final void refresh() {
        this.differ.refresh();
    }

    protected final T getItem(int i) {
        return this.differ.getItem(i);
    }

    public final T peek(int i) {
        return this.differ.peek(i);
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.differ.snapshot();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.differ.getItemCount();
    }

    public final Flow<CombinedLoadStates> getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final Flow<Unit> getOnPagesUpdatedFlow() {
        return this.onPagesUpdatedFlow;
    }

    public final void addLoadStateListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.differ.addLoadStateListener(listener);
    }

    public final void removeLoadStateListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.differ.removeLoadStateListener(listener);
    }

    public final void addOnPagesUpdatedListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.differ.addOnPagesUpdatedListener(listener);
    }

    public final void removeOnPagesUpdatedListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.differ.removeOnPagesUpdatedListener(listener);
    }

    public final ConcatAdapter withLoadStateHeader(final LoadStateAdapter<?> header) {
        Intrinsics.checkNotNullParameter(header, "header");
        addLoadStateListener(new Function1<CombinedLoadStates, Unit>() { // from class: androidx.paging.PagingDataAdapter$withLoadStateHeader$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
                invoke2(combinedLoadStates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CombinedLoadStates loadStates) {
                Intrinsics.checkNotNullParameter(loadStates, "loadStates");
                header.setLoadState(loadStates.getPrepend());
            }
        });
        return new ConcatAdapter(header, this);
    }

    public final ConcatAdapter withLoadStateFooter(final LoadStateAdapter<?> footer) {
        Intrinsics.checkNotNullParameter(footer, "footer");
        addLoadStateListener(new Function1<CombinedLoadStates, Unit>() { // from class: androidx.paging.PagingDataAdapter$withLoadStateFooter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
                invoke2(combinedLoadStates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CombinedLoadStates loadStates) {
                Intrinsics.checkNotNullParameter(loadStates, "loadStates");
                footer.setLoadState(loadStates.getAppend());
            }
        });
        return new ConcatAdapter(this, footer);
    }

    public final ConcatAdapter withLoadStateHeaderAndFooter(final LoadStateAdapter<?> header, final LoadStateAdapter<?> footer) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(footer, "footer");
        addLoadStateListener(new Function1<CombinedLoadStates, Unit>() { // from class: androidx.paging.PagingDataAdapter$withLoadStateHeaderAndFooter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
                invoke2(combinedLoadStates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CombinedLoadStates loadStates) {
                Intrinsics.checkNotNullParameter(loadStates, "loadStates");
                header.setLoadState(loadStates.getPrepend());
                footer.setLoadState(loadStates.getAppend());
            }
        });
        return new ConcatAdapter(header, this, footer);
    }
}
