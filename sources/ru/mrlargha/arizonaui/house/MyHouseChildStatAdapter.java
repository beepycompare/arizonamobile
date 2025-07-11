package ru.mrlargha.arizonaui.house;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MyHouseChildStatItemBinding;
import ru.mrlargha.arizonaui.house.MyHouseScreen;
/* compiled from: MyHouseChildStatAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0014\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseChildStatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/house/MyHouseChildStatAdapter$BusinessViewHolder;", "<init>", "()V", "houseItemStatList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$HouseDetailInfoItem;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addChildStat", "info", "", "BusinessViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyHouseChildStatAdapter extends RecyclerView.Adapter<BusinessViewHolder> {
    private final ArrayList<MyHouseScreen.Companion.HouseDetailInfoItem> houseItemStatList = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BusinessViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_house_child_stat_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BusinessViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BusinessViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MyHouseScreen.Companion.HouseDetailInfoItem houseDetailInfoItem = this.houseItemStatList.get(i);
        Intrinsics.checkNotNullExpressionValue(houseDetailInfoItem, "get(...)");
        MyHouseScreen.Companion.HouseDetailInfoItem houseDetailInfoItem2 = houseDetailInfoItem;
        MyHouseChildStatItemBinding binding = holder.getBinding();
        binding.title.setText(houseDetailInfoItem2.getTitle());
        binding.value.setText(houseDetailInfoItem2.getValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.houseItemStatList.size();
    }

    /* compiled from: MyHouseChildStatAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseChildStatAdapter$BusinessViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/MyHouseChildStatItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/MyHouseChildStatItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BusinessViewHolder extends RecyclerView.ViewHolder {
        private final MyHouseChildStatItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BusinessViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            MyHouseChildStatItemBinding bind = MyHouseChildStatItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final MyHouseChildStatItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addChildStat(List<MyHouseScreen.Companion.HouseDetailInfoItem> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.houseItemStatList.clear();
        this.houseItemStatList.addAll(info);
        notifyDataSetChanged();
    }
}
