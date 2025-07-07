package ru.mrlargha.arizonaui.house;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MyHouseUpgradeItemBinding;
import ru.mrlargha.arizonaui.house.MyHouseScreen;
/* compiled from: MyHousesUpgradesAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0014\u0010\u0019\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHousesUpgradesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/house/MyHousesUpgradesAdapter$ViewHolder;", "<init>", "()V", "upgradeItemInfoList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$UpgradeItem;", "Lkotlin/collections/ArrayList;", "onUpgradeClickListener", "Lru/mrlargha/arizonaui/house/MyHousesUpgradesAdapter$OnUpgradeClickListener;", "setOnUpgradeClickListener", "", "onInfoClickListener", "Lru/mrlargha/arizonaui/house/MyHousesUpgradesAdapter$OnInfoClickListener;", "setOnInfoClickListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addUpgrades", "upgradesList", "", "OnUpgradeClickListener", "OnInfoClickListener", "ViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyHousesUpgradesAdapter extends RecyclerView.Adapter<ViewHolder> {
    private OnInfoClickListener onInfoClickListener;
    private OnUpgradeClickListener onUpgradeClickListener;
    private final ArrayList<MyHouseScreen.Companion.UpgradeItem> upgradeItemInfoList = new ArrayList<>();

    /* compiled from: MyHousesUpgradesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHousesUpgradesAdapter$OnInfoClickListener;", "", "callback", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnInfoClickListener {
        void callback(int i);
    }

    /* compiled from: MyHousesUpgradesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHousesUpgradesAdapter$OnUpgradeClickListener;", "", "callback", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnUpgradeClickListener {
        void callback(int i);
    }

    public final void setOnUpgradeClickListener(OnUpgradeClickListener onUpgradeClickListener) {
        Intrinsics.checkNotNullParameter(onUpgradeClickListener, "onUpgradeClickListener");
        this.onUpgradeClickListener = onUpgradeClickListener;
    }

    public final void setOnInfoClickListener(OnInfoClickListener onInfoClickListener) {
        Intrinsics.checkNotNullParameter(onInfoClickListener, "onInfoClickListener");
        this.onInfoClickListener = onInfoClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_house_upgrade_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MyHouseScreen.Companion.UpgradeItem upgradeItem = this.upgradeItemInfoList.get(i);
        Intrinsics.checkNotNullExpressionValue(upgradeItem, "get(...)");
        final MyHouseScreen.Companion.UpgradeItem upgradeItem2 = upgradeItem;
        MyHouseUpgradeItemBinding binding = holder.getBinding();
        binding.nameContainerTitle.setText(upgradeItem2.getTitle());
        binding.nameContainerValue.setText(upgradeItem2.getShortDescription());
        binding.priceContainerTitle.setText(upgradeItem2.getPrice());
        if (upgradeItem2.getPurchased() > 0) {
            binding.buyButton.setOnClickListener(null);
            binding.buyButton.setImageResource(R.drawable.houses_upgrade_button);
        } else {
            EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
            ImageView buyButton = binding.buyButton;
            Intrinsics.checkNotNullExpressionValue(buyButton, "buyButton");
            EasyAnimation.animateClick$default(easyAnimation, buyButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.house.MyHousesUpgradesAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onBindViewHolder$lambda$2$lambda$0;
                    onBindViewHolder$lambda$2$lambda$0 = MyHousesUpgradesAdapter.onBindViewHolder$lambda$2$lambda$0(MyHousesUpgradesAdapter.this, upgradeItem2);
                    return onBindViewHolder$lambda$2$lambda$0;
                }
            }, 3, null);
            binding.buyButton.setImageResource(R.drawable.houses_cart_button);
        }
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView infoButton = binding.infoButton;
        Intrinsics.checkNotNullExpressionValue(infoButton, "infoButton");
        EasyAnimation.animateClick$default(easyAnimation2, infoButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.house.MyHousesUpgradesAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$2$lambda$1;
                onBindViewHolder$lambda$2$lambda$1 = MyHousesUpgradesAdapter.onBindViewHolder$lambda$2$lambda$1(MyHousesUpgradesAdapter.this, upgradeItem2);
                return onBindViewHolder$lambda$2$lambda$1;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2$lambda$0(MyHousesUpgradesAdapter myHousesUpgradesAdapter, MyHouseScreen.Companion.UpgradeItem upgradeItem) {
        OnUpgradeClickListener onUpgradeClickListener = myHousesUpgradesAdapter.onUpgradeClickListener;
        if (onUpgradeClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onUpgradeClickListener");
            onUpgradeClickListener = null;
        }
        onUpgradeClickListener.callback(upgradeItem.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2$lambda$1(MyHousesUpgradesAdapter myHousesUpgradesAdapter, MyHouseScreen.Companion.UpgradeItem upgradeItem) {
        OnInfoClickListener onInfoClickListener = myHousesUpgradesAdapter.onInfoClickListener;
        if (onInfoClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onInfoClickListener");
            onInfoClickListener = null;
        }
        onInfoClickListener.callback(upgradeItem.getId());
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.upgradeItemInfoList.size();
    }

    /* compiled from: MyHousesUpgradesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHousesUpgradesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/MyHouseUpgradeItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/MyHouseUpgradeItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final MyHouseUpgradeItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            MyHouseUpgradeItemBinding bind = MyHouseUpgradeItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final MyHouseUpgradeItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addUpgrades(List<MyHouseScreen.Companion.UpgradeItem> upgradesList) {
        Intrinsics.checkNotNullParameter(upgradesList, "upgradesList");
        this.upgradeItemInfoList.clear();
        this.upgradeItemInfoList.addAll(upgradesList);
        notifyDataSetChanged();
    }
}
