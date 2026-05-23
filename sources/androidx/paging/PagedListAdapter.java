package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PagedListAdapter.kt */
@Deprecated(message = "PagedListAdapter is deprecated and has been replaced by PagingDataAdapter", replaceWith = @ReplaceWith(expression = "PagingDataAdapter<T, VH>", imports = {"androidx.paging.PagingDataAdapter"}))
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u0017\b\u0014\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tB\u0017\b\u0014\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u001c\u001a\u00020\u00162\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015H\u0016J\"\u0010\u001c\u001a\u00020\u00162\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0017\u0010 \u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\"H\u0014¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\"H\u0016J\u0018\u0010%\u001a\u00020\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015H\u0017J(\u0010%\u001a\u00020\u00162\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00152\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015H\u0016J\"\u0010'\u001a\u00020\u00162\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00160\u0014H\u0016J\"\u0010*\u001a\u00020\u00162\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00160\u0014H\u0016J\u0012\u0010+\u001a\u00020,2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.J\u0012\u0010/\u001a\u00020,2\n\u00100\u001a\u0006\u0012\u0002\b\u00030.J\u001e\u00101\u001a\u00020,2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.2\n\u00100\u001a\u0006\u0012\u0002\b\u00030.R \u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R6\u0010\u0013\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0010R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00158VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u001b¨\u00062"}, d2 = {"Landroidx/paging/PagedListAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "config", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "(Landroidx/recyclerview/widget/AsyncDifferConfig;)V", "differ", "Landroidx/paging/AsyncPagedListDiffer;", "getDiffer$paging_runtime$annotations", "()V", "getDiffer$paging_runtime", "()Landroidx/paging/AsyncPagedListDiffer;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Landroidx/paging/PagedList;", "", "getListener$annotations", "currentList", "getCurrentList$annotations", "getCurrentList", "()Landroidx/paging/PagedList;", "submitList", "pagedList", "commitCallback", "Ljava/lang/Runnable;", "getItem", "position", "", "(I)Ljava/lang/Object;", "getItemCount", "onCurrentListChanged", "previousList", "addLoadStateListener", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "removeLoadStateListener", "withLoadStateHeader", "Landroidx/recyclerview/widget/ConcatAdapter;", "header", "Landroidx/paging/LoadStateAdapter;", "withLoadStateFooter", "footer", "withLoadStateHeaderAndFooter", "paging-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncPagedListDiffer<T> differ;
    private final Function2<PagedList<T>, PagedList<T>, Unit> listener;

    public static /* synthetic */ void getCurrentList$annotations() {
    }

    public static /* synthetic */ void getDiffer$paging_runtime$annotations() {
    }

    private static /* synthetic */ void getListener$annotations() {
    }

    @Deprecated(message = "Use the two argument variant instead.", replaceWith = @ReplaceWith(expression = "onCurrentListChanged(previousList, currentList)", imports = {}))
    public void onCurrentListChanged(PagedList<T> pagedList) {
    }

    public void onCurrentListChanged(PagedList<T> pagedList, PagedList<T> pagedList2) {
    }

    public final AsyncPagedListDiffer<T> getDiffer$paging_runtime() {
        return this.differ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit listener$lambda$0(PagedListAdapter pagedListAdapter, PagedList pagedList, PagedList pagedList2) {
        pagedListAdapter.onCurrentListChanged(pagedList2);
        pagedListAdapter.onCurrentListChanged(pagedList, pagedList2);
        return Unit.INSTANCE;
    }

    public PagedList<T> getCurrentList() {
        return this.differ.getCurrentList();
    }

    protected PagedListAdapter(DiffUtil.ItemCallback<T> diffCallback) {
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Function2<PagedList<T>, PagedList<T>, Unit> function2 = new Function2() { // from class: androidx.paging.PagedListAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PagedListAdapter.listener$lambda$0(PagedListAdapter.this, (PagedList) obj, (PagedList) obj2);
            }
        };
        this.listener = function2;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>(this, diffCallback);
        this.differ = asyncPagedListDiffer;
        asyncPagedListDiffer.addPagedListListener(function2);
    }

    protected PagedListAdapter(AsyncDifferConfig<T> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Function2<PagedList<T>, PagedList<T>, Unit> function2 = new Function2() { // from class: androidx.paging.PagedListAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PagedListAdapter.listener$lambda$0(PagedListAdapter.this, (PagedList) obj, (PagedList) obj2);
            }
        };
        this.listener = function2;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>(new AdapterListUpdateCallback(this), config);
        this.differ = asyncPagedListDiffer;
        asyncPagedListDiffer.addPagedListListener(function2);
    }

    public void submitList(PagedList<T> pagedList) {
        this.differ.submitList(pagedList);
    }

    public void submitList(PagedList<T> pagedList, Runnable runnable) {
        this.differ.submitList(pagedList, runnable);
    }

    protected T getItem(int i) {
        return this.differ.getItem(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.differ.getItemCount();
    }

    public void addLoadStateListener(Function2<? super LoadType, ? super LoadState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.differ.addLoadStateListener(listener);
    }

    public void removeLoadStateListener(Function2<? super LoadType, ? super LoadState, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.differ.removeLoadStateListener(listener);
    }

    public final ConcatAdapter withLoadStateHeader(final LoadStateAdapter<?> header) {
        Intrinsics.checkNotNullParameter(header, "header");
        addLoadStateListener(new Function2() { // from class: androidx.paging.PagedListAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PagedListAdapter.withLoadStateHeader$lambda$0(LoadStateAdapter.this, (LoadType) obj, (LoadState) obj2);
            }
        });
        return new ConcatAdapter(header, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit withLoadStateHeader$lambda$0(LoadStateAdapter loadStateAdapter, LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (loadType == LoadType.PREPEND) {
            loadStateAdapter.setLoadState(loadState);
        }
        return Unit.INSTANCE;
    }

    public final ConcatAdapter withLoadStateFooter(final LoadStateAdapter<?> footer) {
        Intrinsics.checkNotNullParameter(footer, "footer");
        addLoadStateListener(new Function2() { // from class: androidx.paging.PagedListAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PagedListAdapter.withLoadStateFooter$lambda$0(LoadStateAdapter.this, (LoadType) obj, (LoadState) obj2);
            }
        });
        return new ConcatAdapter(this, footer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit withLoadStateFooter$lambda$0(LoadStateAdapter loadStateAdapter, LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (loadType == LoadType.APPEND) {
            loadStateAdapter.setLoadState(loadState);
        }
        return Unit.INSTANCE;
    }

    public final ConcatAdapter withLoadStateHeaderAndFooter(final LoadStateAdapter<?> header, final LoadStateAdapter<?> footer) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(footer, "footer");
        addLoadStateListener(new Function2() { // from class: androidx.paging.PagedListAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PagedListAdapter.withLoadStateHeaderAndFooter$lambda$0(LoadStateAdapter.this, footer, (LoadType) obj, (LoadState) obj2);
            }
        });
        return new ConcatAdapter(header, this, footer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit withLoadStateHeaderAndFooter$lambda$0(LoadStateAdapter loadStateAdapter, LoadStateAdapter loadStateAdapter2, LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (loadType == LoadType.PREPEND) {
            loadStateAdapter.setLoadState(loadState);
        } else if (loadType == LoadType.APPEND) {
            loadStateAdapter2.setLoadState(loadState);
        }
        return Unit.INSTANCE;
    }
}
