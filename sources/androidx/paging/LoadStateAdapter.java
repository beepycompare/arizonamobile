package androidx.paging;

import android.view.ViewGroup;
import androidx.paging.LoadState;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LoadStateAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0010J\u001d\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u0019J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Landroidx/paging/LoadStateAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "<init>", "()V", "loadState", "Landroidx/paging/LoadState;", "getLoadState", "()Landroidx/paging/LoadState;", "setLoadState", "(Landroidx/paging/LoadState;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onBindViewHolder", "", "holder", "position", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemViewType", "getItemCount", "(Landroid/view/ViewGroup;Landroidx/paging/LoadState;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/paging/LoadState;)V", "getStateViewType", "displayLoadStateAsItem", "", "paging-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class LoadStateAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private LoadState loadState = new LoadState.NotLoading(false);

    public int getStateViewType(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        return 0;
    }

    public abstract void onBindViewHolder(VH vh, LoadState loadState);

    public abstract VH onCreateViewHolder(ViewGroup viewGroup, LoadState loadState);

    public final LoadState getLoadState() {
        return this.loadState;
    }

    public final void setLoadState(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (Intrinsics.areEqual(this.loadState, loadState)) {
            return;
        }
        boolean displayLoadStateAsItem = displayLoadStateAsItem(this.loadState);
        boolean displayLoadStateAsItem2 = displayLoadStateAsItem(loadState);
        if (displayLoadStateAsItem && !displayLoadStateAsItem2) {
            notifyItemRemoved(0);
        } else if (displayLoadStateAsItem2 && !displayLoadStateAsItem) {
            notifyItemInserted(0);
        } else if (displayLoadStateAsItem && displayLoadStateAsItem2) {
            notifyItemChanged(0);
        }
        this.loadState = loadState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final VH onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return onCreateViewHolder(parent, this.loadState);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        onBindViewHolder((LoadStateAdapter<VH>) holder, this.loadState);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return getStateViewType(this.loadState);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return displayLoadStateAsItem(this.loadState) ? 1 : 0;
    }

    public boolean displayLoadStateAsItem(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        return (loadState instanceof LoadState.Loading) || (loadState instanceof LoadState.Error);
    }
}
