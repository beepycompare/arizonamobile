package com.arizonagames.feature.arizona.bank.pages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankLotteryTaskInfo;
import com.arizonagames.feature.arizona.bank.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankLotteryPageController.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u001e\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\rR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryTasksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryTaskViewHolder;", "onTaskClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "Lcom/arizonagames/feature/arizona/bank/BankLotteryTaskInfo;", "actionsEnabled", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "submitList", "tasks", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class BankLotteryTasksAdapter extends RecyclerView.Adapter<BankLotteryTaskViewHolder> {
    private boolean actionsEnabled;
    private List<BankLotteryTaskInfo> items;
    private final Function1<Integer, Unit> onTaskClick;

    /* JADX WARN: Multi-variable type inference failed */
    public BankLotteryTasksAdapter(Function1<? super Integer, Unit> onTaskClick) {
        Intrinsics.checkNotNullParameter(onTaskClick, "onTaskClick");
        this.onTaskClick = onTaskClick;
        this.items = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BankLotteryTaskViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_lottery_task_item, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new BankLotteryTaskViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BankLotteryTaskViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(i), this.actionsEnabled, this.onTaskClick);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public static /* synthetic */ void submitList$default(BankLotteryTasksAdapter bankLotteryTasksAdapter, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        bankLotteryTasksAdapter.submitList(list, z);
    }

    public final void submitList(List<BankLotteryTaskInfo> tasks, boolean z) {
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        if (Intrinsics.areEqual(this.items, tasks) && this.actionsEnabled == z) {
            return;
        }
        this.items = tasks;
        this.actionsEnabled = z;
        notifyDataSetChanged();
    }
}
