package ru.mrlargha.employment.center;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.employment.center.data.AdditionalInfo;
import ru.mrlargha.feature.employment.center.R;
import ru.mrlargha.feature.employment.center.databinding.EmploymentCenterSalaryItemBinding;
/* compiled from: TextBonusAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0014\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016J\u0006\u0010\u0017\u001a\u00020\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lru/mrlargha/employment/center/TextBonusAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/employment/center/SalaryItemViewHolder;", "<init>", "()V", "itemsList", "", "Lru/mrlargha/employment/center/data/AdditionalInfo;", "getItemsList", "()Ljava/util/List;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addAllItems", "items", "", "clearList", "employment-center"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TextBonusAdapter extends RecyclerView.Adapter<SalaryItemViewHolder> {
    private final List<AdditionalInfo> itemsList = new ArrayList();

    public final List<AdditionalInfo> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SalaryItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.employment_center_salary_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SalaryItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SalaryItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        AdditionalInfo additionalInfo = (AdditionalInfo) CollectionsKt.getOrNull(this.itemsList, i);
        if (additionalInfo == null) {
            additionalInfo = (AdditionalInfo) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        EmploymentCenterSalaryItemBinding binding = holder.getBinding();
        binding.text.setText(additionalInfo.getName());
        binding.value.setText("+" + additionalInfo.getValue() + "%");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<AdditionalInfo> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        clearList();
        this.itemsList.addAll(items);
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
