package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.AsyncPagedListDiffer;
import androidx.paging.LoadState;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
/* compiled from: AsyncPagedListDiffer.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002`aB#\b\u0017\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001f\b\u0017\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u0007\u0010\rJ\u0017\u0010I\u001a\u0004\u0018\u00018\u00002\u0006\u0010J\u001a\u00020)H\u0016¢\u0006\u0002\u0010KJ\u0018\u0010L\u001a\u00020:2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$H\u0016J\"\u0010L\u001a\u00020:2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016JK\u0010O\u001a\u00020:2\f\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000$2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000$2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020)2\b\u0010M\u001a\u0004\u0018\u00010NH\u0000¢\u0006\u0002\bWJ2\u0010X\u001a\u00020:2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$2\b\u0010M\u001a\u0004\u0018\u00010NH\u0002J\u0016\u0010Z\u001a\u00020:2\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J0\u0010Z\u001a\u00020:2(\u0010\\\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$\u0012\u0004\u0012\u00020:0=J\u0016\u0010]\u001a\u00020:2\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J0\u0010]\u001a\u00020:2(\u0010\\\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$\u0012\u0004\u0012\u00020:0=J\"\u0010^\u001a\u00020:2\u0018\u0010[\u001a\u0014\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020:0=H\u0016J\"\u0010_\u001a\u00020:2\u0018\u0010[\u001a\u0014\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020:0=H\u0016R\u001a\u0010\u000e\u001a\u00020\nX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f0\u001e8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u0014R\u001c\u0010&\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\u0014R \u0010(\u001a\u00020)X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0014\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010/\u001a\u000200X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b1\u0010\u0014R>\u00102\u001a2\u0012\u0013\u0012\u001104¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0013\u0012\u001108¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020:03X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010;\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020:0=0<X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\bB\u0010\u0014R\u0014\u0010C\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010,R\"\u0010E\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$8VX\u0096\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0014\u001a\u0004\bG\u0010H¨\u0006b"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer;", ExifInterface.GPS_DIRECTION_TRUE, "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "listUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "config", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "(Landroidx/recyclerview/widget/ListUpdateCallback;Landroidx/recyclerview/widget/AsyncDifferConfig;)V", "updateCallback", "getUpdateCallback$paging_runtime", "()Landroidx/recyclerview/widget/ListUpdateCallback;", "setUpdateCallback$paging_runtime", "(Landroidx/recyclerview/widget/ListUpdateCallback;)V", "getConfig$paging_runtime$annotations", "()V", "getConfig$paging_runtime", "()Landroidx/recyclerview/widget/AsyncDifferConfig;", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "getMainThreadExecutor$paging_runtime", "()Ljava/util/concurrent/Executor;", "setMainThreadExecutor$paging_runtime", "(Ljava/util/concurrent/Executor;)V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "getListeners$paging_runtime$annotations", "getListeners$paging_runtime", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "pagedList", "Landroidx/paging/PagedList;", "getPagedList$annotations", "snapshot", "getSnapshot$annotations", "maxScheduledGeneration", "", "getMaxScheduledGeneration$paging_runtime$annotations", "getMaxScheduledGeneration$paging_runtime", "()I", "setMaxScheduledGeneration$paging_runtime", "(I)V", "loadStateManager", "Landroidx/paging/PagedList$LoadStateManager;", "getLoadStateManager$annotations", "loadStateListener", "Lkotlin/reflect/KFunction2;", "Landroidx/paging/LoadType;", "Lkotlin/ParameterName;", "name", "type", "Landroidx/paging/LoadState;", RemoteConfigConstants.ResponseFieldKey.STATE, "", "loadStateListeners", "", "Lkotlin/Function2;", "getLoadStateListeners$paging_runtime", "()Ljava/util/List;", "pagedListCallback", "Landroidx/paging/PagedList$Callback;", "getPagedListCallback$annotations", "itemCount", "getItemCount", "currentList", "getCurrentList$annotations", "getCurrentList", "()Landroidx/paging/PagedList;", "getItem", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "submitList", "commitCallback", "Ljava/lang/Runnable;", "latchPagedList", "newList", "diffSnapshot", "diffResult", "Landroidx/paging/PlaceholderPaddedDiffResult;", "recordingCallback", "Landroidx/paging/RecordingCallback;", "lastAccessIndex", "latchPagedList$paging_runtime", "onCurrentListChanged", "previousList", "addPagedListListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "callback", "removePagedListListener", "addLoadStateListener", "removeLoadStateListener", "PagedListListener", "OnCurrentListChangedWrapper", "paging-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(message = "AsyncPagedListDiffer is deprecated and has been replaced by AsyncPagingDataDiffer", replaceWith = @ReplaceWith(expression = "AsyncPagingDataDiffer<T>", imports = {"androidx.paging.AsyncPagingDataDiffer"}))
/* loaded from: classes3.dex */
public class AsyncPagedListDiffer<T> {
    private final AsyncDifferConfig<T> config;
    private final CopyOnWriteArrayList<PagedListListener<T>> listeners;
    private final KFunction<Unit> loadStateListener;
    private final List<Function2<LoadType, LoadState, Unit>> loadStateListeners;
    private final PagedList.LoadStateManager loadStateManager;
    private Executor mainThreadExecutor;
    private int maxScheduledGeneration;
    private PagedList<T> pagedList;
    private final PagedList.Callback pagedListCallback;
    private PagedList<T> snapshot;
    public ListUpdateCallback updateCallback;

    /* compiled from: AsyncPagedListDiffer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0002J(\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", ExifInterface.GPS_DIRECTION_TRUE, "", "onCurrentListChanged", "", "previousList", "Landroidx/paging/PagedList;", "currentList", "paging-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData")
    /* loaded from: classes3.dex */
    public interface PagedListListener<T> {
        void onCurrentListChanged(PagedList<T> pagedList, PagedList<T> pagedList2);
    }

    public static /* synthetic */ void getConfig$paging_runtime$annotations() {
    }

    public static /* synthetic */ void getCurrentList$annotations() {
    }

    public static /* synthetic */ void getListeners$paging_runtime$annotations() {
    }

    private static /* synthetic */ void getLoadStateManager$annotations() {
    }

    public static /* synthetic */ void getMaxScheduledGeneration$paging_runtime$annotations() {
    }

    private static /* synthetic */ void getPagedList$annotations() {
    }

    private static /* synthetic */ void getPagedListCallback$annotations() {
    }

    private static /* synthetic */ void getSnapshot$annotations() {
    }

    public final ListUpdateCallback getUpdateCallback$paging_runtime() {
        ListUpdateCallback listUpdateCallback = this.updateCallback;
        if (listUpdateCallback != null) {
            return listUpdateCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException("updateCallback");
        return null;
    }

    public final void setUpdateCallback$paging_runtime(ListUpdateCallback listUpdateCallback) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "<set-?>");
        this.updateCallback = listUpdateCallback;
    }

    public final AsyncDifferConfig<T> getConfig$paging_runtime() {
        return this.config;
    }

    public final Executor getMainThreadExecutor$paging_runtime() {
        return this.mainThreadExecutor;
    }

    public final void setMainThreadExecutor$paging_runtime(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "<set-?>");
        this.mainThreadExecutor = executor;
    }

    public final CopyOnWriteArrayList<PagedListListener<T>> getListeners$paging_runtime() {
        return this.listeners;
    }

    public final int getMaxScheduledGeneration$paging_runtime() {
        return this.maxScheduledGeneration;
    }

    public final void setMaxScheduledGeneration$paging_runtime(int i) {
        this.maxScheduledGeneration = i;
    }

    public final List<Function2<LoadType, LoadState, Unit>> getLoadStateListeners$paging_runtime() {
        return this.loadStateListeners;
    }

    public int getItemCount() {
        PagedList<T> currentList = getCurrentList();
        if (currentList != null) {
            return currentList.size();
        }
        return 0;
    }

    public PagedList<T> getCurrentList() {
        PagedList<T> pagedList = this.snapshot;
        return pagedList == null ? this.pagedList : pagedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncPagedListDiffer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B1\u0012(\u0010\u0004\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ(\u0010\f\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006H\u0016R3\u0010\u0004\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/paging/AsyncPagedListDiffer$OnCurrentListChangedWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/AsyncPagedListDiffer$PagedListListener;", "callback", "Lkotlin/Function2;", "Landroidx/paging/PagedList;", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "onCurrentListChanged", "previousList", "currentList", "paging-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class OnCurrentListChangedWrapper<T> implements PagedListListener<T> {
        private final Function2<PagedList<T>, PagedList<T>, Unit> callback;

        /* JADX WARN: Multi-variable type inference failed */
        public OnCurrentListChangedWrapper(Function2<? super PagedList<T>, ? super PagedList<T>, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
        }

        public final Function2<PagedList<T>, PagedList<T>, Unit> getCallback() {
            return this.callback;
        }

        @Override // androidx.paging.AsyncPagedListDiffer.PagedListListener
        public void onCurrentListChanged(PagedList<T> pagedList, PagedList<T> pagedList2) {
            this.callback.invoke(pagedList, pagedList2);
        }
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "AsyncPagingDataDiffer(\n                Dispatchers.Main,\n                Dispatchers.IO,\n                diffCallback,\n                listUpdateCallback\n            )", imports = {"androidx.paging.AsyncPagingDataDiffer", "kotlinx.coroutines.Dispatchers"}))
    public AsyncPagedListDiffer(RecyclerView.Adapter<?> adapter, DiffUtil.ItemCallback<T> diffCallback) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(mainThreadExecutor, "getMainThreadExecutor(...)");
        this.mainThreadExecutor = mainThreadExecutor;
        this.listeners = new CopyOnWriteArrayList<>();
        PagedList.LoadStateManager loadStateManager = new PagedList.LoadStateManager(this) { // from class: androidx.paging.AsyncPagedListDiffer$loadStateManager$1
            final /* synthetic */ AsyncPagedListDiffer<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PagedList.LoadStateManager
            public void onStateChanged(LoadType type, LoadState state) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(state, "state");
                Iterator<T> it = this.this$0.getLoadStateListeners$paging_runtime().iterator();
                while (it.hasNext()) {
                    ((Function2) it.next()).invoke(type, state);
                }
            }
        };
        this.loadStateManager = loadStateManager;
        this.loadStateListener = new AsyncPagedListDiffer$loadStateListener$1(loadStateManager);
        this.loadStateListeners = new CopyOnWriteArrayList();
        this.pagedListCallback = new PagedList.Callback(this) { // from class: androidx.paging.AsyncPagedListDiffer$pagedListCallback$1
            final /* synthetic */ AsyncPagedListDiffer<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PagedList.Callback
            public void onInserted(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime().onInserted(i, i2);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onRemoved(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime().onRemoved(i, i2);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onChanged(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime().onChanged(i, i2, null);
            }
        };
        setUpdateCallback$paging_runtime(new AdapterListUpdateCallback(adapter));
        AsyncDifferConfig<T> build = new AsyncDifferConfig.Builder(diffCallback).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.config = build;
    }

    @Deprecated(message = "PagedList is deprecated and has been replaced by PagingData", replaceWith = @ReplaceWith(expression = "AsyncPagingDataDiffer(\n                Dispatchers.Main,\n                Dispatchers.IO,\n                config.diffCallback,\n                listUpdateCallback\n            )", imports = {"androidx.paging.AsyncPagingDataDiffer", "kotlinx.coroutines.Dispatchers"}))
    public AsyncPagedListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> config) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "listUpdateCallback");
        Intrinsics.checkNotNullParameter(config, "config");
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(mainThreadExecutor, "getMainThreadExecutor(...)");
        this.mainThreadExecutor = mainThreadExecutor;
        this.listeners = new CopyOnWriteArrayList<>();
        PagedList.LoadStateManager loadStateManager = new PagedList.LoadStateManager(this) { // from class: androidx.paging.AsyncPagedListDiffer$loadStateManager$1
            final /* synthetic */ AsyncPagedListDiffer<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PagedList.LoadStateManager
            public void onStateChanged(LoadType type, LoadState state) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(state, "state");
                Iterator<T> it = this.this$0.getLoadStateListeners$paging_runtime().iterator();
                while (it.hasNext()) {
                    ((Function2) it.next()).invoke(type, state);
                }
            }
        };
        this.loadStateManager = loadStateManager;
        this.loadStateListener = new AsyncPagedListDiffer$loadStateListener$1(loadStateManager);
        this.loadStateListeners = new CopyOnWriteArrayList();
        this.pagedListCallback = new PagedList.Callback(this) { // from class: androidx.paging.AsyncPagedListDiffer$pagedListCallback$1
            final /* synthetic */ AsyncPagedListDiffer<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PagedList.Callback
            public void onInserted(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime().onInserted(i, i2);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onRemoved(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime().onRemoved(i, i2);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onChanged(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime().onChanged(i, i2, null);
            }
        };
        setUpdateCallback$paging_runtime(listUpdateCallback);
        this.config = config;
    }

    public T getItem(int i) {
        PagedList<T> pagedList = this.snapshot;
        PagedList<T> pagedList2 = this.pagedList;
        if (pagedList != null) {
            return pagedList.get(i);
        }
        if (pagedList2 != null) {
            pagedList2.loadAround(i);
            return pagedList2.get(i);
        }
        throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
    }

    public void submitList(PagedList<T> pagedList) {
        submitList(pagedList, null);
    }

    public void submitList(final PagedList<T> pagedList, final Runnable runnable) {
        final int i = this.maxScheduledGeneration + 1;
        this.maxScheduledGeneration = i;
        PagedList<T> pagedList2 = this.pagedList;
        if (pagedList == pagedList2) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (pagedList2 != null && (pagedList instanceof InitialPagedList)) {
            pagedList2.removeWeakCallback(this.pagedListCallback);
            pagedList2.removeWeakLoadStateListener((Function2) this.loadStateListener);
            this.loadStateManager.setState(LoadType.REFRESH, LoadState.Loading.INSTANCE);
            this.loadStateManager.setState(LoadType.PREPEND, new LoadState.NotLoading(false));
            this.loadStateManager.setState(LoadType.APPEND, new LoadState.NotLoading(false));
            if (runnable != null) {
                runnable.run();
            }
        } else {
            PagedList<T> currentList = getCurrentList();
            if (pagedList == null) {
                int itemCount = getItemCount();
                if (pagedList2 != null) {
                    pagedList2.removeWeakCallback(this.pagedListCallback);
                    pagedList2.removeWeakLoadStateListener((Function2) this.loadStateListener);
                    this.pagedList = null;
                } else if (this.snapshot != null) {
                    this.snapshot = null;
                }
                getUpdateCallback$paging_runtime().onRemoved(0, itemCount);
                onCurrentListChanged(currentList, null, runnable);
            } else if (getCurrentList() == null) {
                this.pagedList = pagedList;
                pagedList.addWeakLoadStateListener((Function2) this.loadStateListener);
                pagedList.addWeakCallback(this.pagedListCallback);
                getUpdateCallback$paging_runtime().onInserted(0, pagedList.size());
                onCurrentListChanged(null, pagedList, runnable);
            } else {
                PagedList<T> pagedList3 = this.pagedList;
                if (pagedList3 != null) {
                    pagedList3.removeWeakCallback(this.pagedListCallback);
                    pagedList3.removeWeakLoadStateListener((Function2) this.loadStateListener);
                    List<T> snapshot = pagedList3.snapshot();
                    Intrinsics.checkNotNull(snapshot, "null cannot be cast to non-null type androidx.paging.PagedList<T of androidx.paging.AsyncPagedListDiffer>");
                    this.snapshot = (PagedList) snapshot;
                    this.pagedList = null;
                }
                final PagedList<T> pagedList4 = this.snapshot;
                if (pagedList4 == null || this.pagedList != null) {
                    throw new IllegalStateException("must be in snapshot state to diff");
                }
                List<T> snapshot2 = pagedList.snapshot();
                Intrinsics.checkNotNull(snapshot2, "null cannot be cast to non-null type androidx.paging.PagedList<T of androidx.paging.AsyncPagedListDiffer>");
                final PagedList pagedList5 = (PagedList) snapshot2;
                final RecordingCallback recordingCallback = new RecordingCallback();
                pagedList.addWeakCallback(recordingCallback);
                this.config.getBackgroundThreadExecutor().execute(new Runnable() { // from class: androidx.paging.AsyncPagedListDiffer$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AsyncPagedListDiffer.submitList$lambda$1(PagedList.this, pagedList5, this, i, pagedList, recordingCallback, runnable);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void submitList$lambda$1(final PagedList pagedList, final PagedList pagedList2, final AsyncPagedListDiffer asyncPagedListDiffer, final int i, final PagedList pagedList3, final RecordingCallback recordingCallback, final Runnable runnable) {
        PlaceholderPaddedList<T> placeholderPaddedList = pagedList.getPlaceholderPaddedList();
        PlaceholderPaddedList<T> placeholderPaddedList2 = pagedList2.getPlaceholderPaddedList();
        DiffUtil.ItemCallback<T> diffCallback = asyncPagedListDiffer.config.getDiffCallback();
        Intrinsics.checkNotNullExpressionValue(diffCallback, "getDiffCallback(...)");
        final PlaceholderPaddedDiffResult computeDiff = PlaceholderPaddedListDiffHelperKt.computeDiff(placeholderPaddedList, placeholderPaddedList2, diffCallback);
        asyncPagedListDiffer.mainThreadExecutor.execute(new Runnable() { // from class: androidx.paging.AsyncPagedListDiffer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AsyncPagedListDiffer.submitList$lambda$1$0(AsyncPagedListDiffer.this, i, pagedList3, pagedList2, computeDiff, recordingCallback, pagedList, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitList$lambda$1$0(AsyncPagedListDiffer asyncPagedListDiffer, int i, PagedList pagedList, PagedList pagedList2, PlaceholderPaddedDiffResult placeholderPaddedDiffResult, RecordingCallback recordingCallback, PagedList pagedList3, Runnable runnable) {
        if (asyncPagedListDiffer.maxScheduledGeneration == i) {
            asyncPagedListDiffer.latchPagedList$paging_runtime(pagedList, pagedList2, placeholderPaddedDiffResult, recordingCallback, pagedList3.lastLoad(), runnable);
        }
    }

    public final void latchPagedList$paging_runtime(PagedList<T> newList, PagedList<T> diffSnapshot, PlaceholderPaddedDiffResult diffResult, RecordingCallback recordingCallback, int i, Runnable runnable) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(diffSnapshot, "diffSnapshot");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        Intrinsics.checkNotNullParameter(recordingCallback, "recordingCallback");
        PagedList<T> pagedList = this.snapshot;
        if (pagedList == null || this.pagedList != null) {
            throw new IllegalStateException("must be in snapshot state to apply diff");
        }
        this.pagedList = newList;
        newList.addWeakLoadStateListener((Function2) this.loadStateListener);
        this.snapshot = null;
        PlaceholderPaddedListDiffHelperKt.dispatchDiff(pagedList.getPlaceholderPaddedList(), getUpdateCallback$paging_runtime(), diffSnapshot.getPlaceholderPaddedList(), diffResult);
        recordingCallback.dispatchRecordingTo(this.pagedListCallback);
        newList.addWeakCallback(this.pagedListCallback);
        if (!newList.isEmpty()) {
            newList.loadAround(RangesKt.coerceIn(PlaceholderPaddedListDiffHelperKt.transformAnchorIndex(pagedList.getPlaceholderPaddedList(), diffResult, diffSnapshot.getPlaceholderPaddedList(), i), 0, newList.size() - 1));
        }
        onCurrentListChanged(pagedList, this.pagedList, runnable);
    }

    private final void onCurrentListChanged(PagedList<T> pagedList, PagedList<T> pagedList2, Runnable runnable) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((PagedListListener) it.next()).onCurrentListChanged(pagedList, pagedList2);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addPagedListListener(PagedListListener<T> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void addPagedListListener(Function2<? super PagedList<T>, ? super PagedList<T>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.listeners.add(new OnCurrentListChangedWrapper(callback));
    }

    public void removePagedListListener(PagedListListener<T> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean removePagedListListener$lambda$0(Function2 function2, PagedListListener pagedListListener) {
        return (pagedListListener instanceof OnCurrentListChangedWrapper) && ((OnCurrentListChangedWrapper) pagedListListener).getCallback() == function2;
    }

    public final void removePagedListListener(final Function2<? super PagedList<T>, ? super PagedList<T>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        CollectionsKt.removeAll((List) this.listeners, new Function1() { // from class: androidx.paging.AsyncPagedListDiffer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AsyncPagedListDiffer.removePagedListListener$lambda$0(Function2.this, (AsyncPagedListDiffer.PagedListListener) obj));
            }
        });
    }

    public void addLoadStateListener(Function2<? super LoadType, ? super LoadState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        PagedList<T> pagedList = this.pagedList;
        if (pagedList != null) {
            pagedList.addWeakLoadStateListener(listener);
        } else {
            this.loadStateManager.dispatchCurrentLoadState(listener);
        }
        this.loadStateListeners.add(listener);
    }

    public void removeLoadStateListener(Function2<? super LoadType, ? super LoadState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.loadStateListeners.remove(listener);
        PagedList<T> pagedList = this.pagedList;
        if (pagedList != null) {
            pagedList.removeWeakLoadStateListener(listener);
        }
    }
}
