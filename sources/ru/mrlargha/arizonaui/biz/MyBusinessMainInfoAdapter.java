package ru.mrlargha.arizonaui.biz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.biz.MyBusinessScreen;
import ru.mrlargha.arizonaui.databinding.MyBusinessMainStatItemBinding;
/* compiled from: MyBusinessMainInfoAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0014\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015J\u0006\u0010\u0016\u001a\u00020\u000fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessMainInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/biz/MyBusinessMainInfoAdapter$BusinessViewHolder;", "<init>", "()V", "businessItemStatList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$MainBusinessInfoStat;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addStat", "infoList", "", "clearStat", "BusinessViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBusinessMainInfoAdapter extends RecyclerView.Adapter<BusinessViewHolder> {
    private final ArrayList<MyBusinessScreen.Companion.MainBusinessInfoStat> businessItemStatList = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BusinessViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_business_main_stat_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BusinessViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BusinessViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MyBusinessScreen.Companion.MainBusinessInfoStat mainBusinessInfoStat = this.businessItemStatList.get(i);
        Intrinsics.checkNotNullExpressionValue(mainBusinessInfoStat, "get(...)");
        MyBusinessScreen.Companion.MainBusinessInfoStat mainBusinessInfoStat2 = mainBusinessInfoStat;
        MyBusinessMainStatItemBinding binding = holder.getBinding();
        binding.title.setText(mainBusinessInfoStat2.getTitle());
        binding.value.setText(mainBusinessInfoStat2.getValue());
        if (mainBusinessInfoStat2.getLabel() != null) {
            binding.labelContainer.setVisibility(0);
            binding.label.setText(mainBusinessInfoStat2.getLabel());
        } else {
            binding.labelContainer.setVisibility(8);
        }
        if (mainBusinessInfoStat2.getMaxValue() != null) {
            binding.maxValue.setVisibility(0);
            binding.maxValue.setText("/ " + mainBusinessInfoStat2.getMaxValue());
            return;
        }
        binding.maxValue.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.businessItemStatList.size();
    }

    /* compiled from: MyBusinessMainInfoAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessMainInfoAdapter$BusinessViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/MyBusinessMainStatItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/MyBusinessMainStatItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BusinessViewHolder extends RecyclerView.ViewHolder {
        private final MyBusinessMainStatItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BusinessViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            MyBusinessMainStatItemBinding bind = MyBusinessMainStatItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final MyBusinessMainStatItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addStat(List<MyBusinessScreen.Companion.MainBusinessInfoStat> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.businessItemStatList.addAll(infoList);
        notifyDataSetChanged();
    }

    public final void clearStat() {
        this.businessItemStatList.clear();
    }
}
