package ru.mrlargha.commonui.elements.gasstation.presentation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.gasstation.domain.GasStationShop;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: GasStationAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0014\u0010\u001a\u001a\u00020\u00162\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/gasstation/presentation/GasStationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/gasstation/presentation/GasStationViewHolder;", "targetActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "shopList", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/gasstation/domain/GasStationShop;", "Lkotlin/collections/ArrayList;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addShopItem", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GasStationAdapter extends RecyclerView.Adapter<GasStationViewHolder> {
    private final boolean isArizonaType;
    private final SharedPreferences sharedPref;
    private final ArrayList<GasStationShop> shopList;
    private final Activity targetActivity;

    public GasStationAdapter(Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.shopList = new ArrayList<>();
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GasStationViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gas_station_shop_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new GasStationViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GasStationViewHolder holder, final int i) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.isArizonaType) {
            str = "$";
        } else {
            str = "₽";
        }
        String title = this.shopList.get(i).getTitle();
        String str3 = this.shopList.get(i).getPrice() + str;
        if (this.isArizonaType) {
            str2 = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/assets/images/donate/";
        } else {
            str2 = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/assets/images/items/";
        }
        Picasso.get().load(str2 + this.shopList.get(i).getImage() + ".webp").into(holder.getGasStationItem().gsShopItemImg);
        holder.getGasStationItem().gsShopItemTitle.setText(title);
        holder.getGasStationItem().gsShopItemPrice.setText(str3);
        holder.getGasStationItem().gsShopItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.gasstation.presentation.GasStationAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GasStationAdapter.onBindViewHolder$lambda$0(GasStationAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(GasStationAdapter gasStationAdapter, int i, View view) {
        Activity activity = gasStationAdapter.targetActivity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        ((IBackendNotifier) activity).clickedWrapper(UIElementID.ARIZONA_GAS_STATION.getId(), i, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.shopList.size();
    }

    public final void addShopItem(List<GasStationShop> shopList) {
        Intrinsics.checkNotNullParameter(shopList, "shopList");
        this.shopList.clear();
        Unit unit = Unit.INSTANCE;
        this.shopList.addAll(shopList);
    }
}
