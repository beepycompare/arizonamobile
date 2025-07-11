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
import ru.mrlargha.arizonaui.databinding.MyHouseTenantItemBinding;
import ru.mrlargha.arizonaui.house.MyHouseScreen;
/* compiled from: MyHousesTenantsAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J\u0006\u0010\u0019\u001a\u00020\fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHousesTenantsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/house/MyHousesTenantsAdapter$ViewHolder;", "<init>", "()V", "tenantsItemInfoList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$TenantsInformation;", "Lkotlin/collections/ArrayList;", "onTenantClickListener", "Lru/mrlargha/arizonaui/house/MyHousesTenantsAdapter$OnTenantClickListener;", "setOnTenantClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addTenants", "infoList", "", "clear", "OnTenantClickListener", "ViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyHousesTenantsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private OnTenantClickListener onTenantClickListener;
    private final ArrayList<MyHouseScreen.Companion.TenantsInformation> tenantsItemInfoList = new ArrayList<>();

    /* compiled from: MyHousesTenantsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHousesTenantsAdapter$OnTenantClickListener;", "", "callback", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnTenantClickListener {
        void callback(int i);
    }

    public final void setOnTenantClickListener(OnTenantClickListener onTenantClickListener) {
        Intrinsics.checkNotNullParameter(onTenantClickListener, "onTenantClickListener");
        this.onTenantClickListener = onTenantClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_house_tenant_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MyHouseScreen.Companion.TenantsInformation tenantsInformation = this.tenantsItemInfoList.get(i);
        Intrinsics.checkNotNullExpressionValue(tenantsInformation, "get(...)");
        final MyHouseScreen.Companion.TenantsInformation tenantsInformation2 = tenantsInformation;
        MyHouseTenantItemBinding binding = holder.getBinding();
        binding.nameContainerTitle.setText(tenantsInformation2.getName());
        binding.daysInRentContainerTitle.setText(String.valueOf(tenantsInformation2.getDaysInRent()));
        binding.priceContainerTitle.setText(tenantsInformation2.getPrice());
        binding.statusContainerTitle.setText(tenantsInformation2.getAlreadyPayedAmount());
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView kickTenantButton = binding.kickTenantButton;
        Intrinsics.checkNotNullExpressionValue(kickTenantButton, "kickTenantButton");
        EasyAnimation.animateClick$default(easyAnimation, kickTenantButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.house.MyHousesTenantsAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$1$lambda$0;
                onBindViewHolder$lambda$1$lambda$0 = MyHousesTenantsAdapter.onBindViewHolder$lambda$1$lambda$0(MyHousesTenantsAdapter.this, tenantsInformation2);
                return onBindViewHolder$lambda$1$lambda$0;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$1$lambda$0(MyHousesTenantsAdapter myHousesTenantsAdapter, MyHouseScreen.Companion.TenantsInformation tenantsInformation) {
        OnTenantClickListener onTenantClickListener = myHousesTenantsAdapter.onTenantClickListener;
        if (onTenantClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onTenantClickListener");
            onTenantClickListener = null;
        }
        onTenantClickListener.callback(tenantsInformation.getId());
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.tenantsItemInfoList.size();
    }

    /* compiled from: MyHousesTenantsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHousesTenantsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/MyHouseTenantItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/MyHouseTenantItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final MyHouseTenantItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            MyHouseTenantItemBinding bind = MyHouseTenantItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final MyHouseTenantItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addTenants(List<MyHouseScreen.Companion.TenantsInformation> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.tenantsItemInfoList.clear();
        this.tenantsItemInfoList.addAll(infoList);
        notifyDataSetChanged();
    }

    public final void clear() {
        this.tenantsItemInfoList.clear();
    }
}
