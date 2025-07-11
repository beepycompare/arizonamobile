package ru.mrlargha.commonui.elements.battlepassWinter2025;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.WinterBattlepassShopItemLayoutBinding;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.BattlePassShopData;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: ShopAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u001a\b\u0002\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0014\u0010\u001c\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eJ\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0006R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/ShopAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/battlepassWinter2025/RodinaBattlePassShopItemViewHolder;", "onSelectItem", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/battlepassWinter2025/data/BattlePassShopData;", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "shopItemList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getShopItemList", "()Ljava/util/ArrayList;", "battlePassCoins", "getBattlePassCoins", "()I", "setBattlePassCoins", "(I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addShopItems", "shopList", "", "updateBattlePassCoins", "clearShopList", "selectShopItem", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShopAdapter extends RecyclerView.Adapter<RodinaBattlePassShopItemViewHolder> {
    private int battlePassCoins;
    private final Function2<BattlePassShopData, Integer, Unit> onSelectItem;
    private final ArrayList<BattlePassShopData> shopItemList;

    public ShopAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ ShopAdapter(Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function2() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.ShopAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = ShopAdapter._init_$lambda$0((BattlePassShopData) obj, ((Integer) obj2).intValue());
                return _init_$lambda$0;
            }
        } : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(BattlePassShopData battlePassShopData, int i) {
        Intrinsics.checkNotNullParameter(battlePassShopData, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShopAdapter(Function2<? super BattlePassShopData, ? super Integer, Unit> onSelectItem) {
        Intrinsics.checkNotNullParameter(onSelectItem, "onSelectItem");
        this.onSelectItem = onSelectItem;
        this.shopItemList = new ArrayList<>();
    }

    public final ArrayList<BattlePassShopData> getShopItemList() {
        return this.shopItemList;
    }

    public final int getBattlePassCoins() {
        return this.battlePassCoins;
    }

    public final void setBattlePassCoins(int i) {
        this.battlePassCoins = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RodinaBattlePassShopItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.winter_battlepass_shop_item_layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new RodinaBattlePassShopItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RodinaBattlePassShopItemViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BattlePassShopData battlePassShopData = this.shopItemList.get(i);
        Intrinsics.checkNotNullExpressionValue(battlePassShopData, "get(...)");
        final BattlePassShopData battlePassShopData2 = battlePassShopData;
        WinterBattlepassShopItemLayoutBinding binding = holder.getBinding();
        if (battlePassShopData2.isSelected()) {
            binding.getRoot().setBackgroundResource(R.drawable.background_shop_item_selected);
        } else {
            binding.getRoot().setBackgroundResource(R.drawable.background_shop_item);
        }
        if (this.battlePassCoins >= battlePassShopData2.getPrice()) {
            binding.shopButton.setBackgroundResource(R.drawable.background_ic_addcart_enabled);
        } else {
            binding.shopButton.setBackgroundResource(R.drawable.background_ic_addcart_disabled);
        }
        binding.shopItemPriceText.setText(String.valueOf(battlePassShopData2.getPrice()));
        binding.shopItemDiscountText.setPaintFlags(16);
        if (battlePassShopData2.getDiscount() > 0) {
            binding.shopItemDiscountText.setText(String.valueOf(battlePassShopData2.getPriceWithDiscount()));
            binding.discountContainer.setVisibility(0);
        } else {
            binding.discountContainer.setVisibility(8);
        }
        binding.shopItemNameText.setText(battlePassShopData2.getSavedName());
        Bitmap savedImage = battlePassShopData2.getSavedImage();
        if (savedImage != null) {
            ImageView shopItemImage = binding.shopItemImage;
            Intrinsics.checkNotNullExpressionValue(shopItemImage, "shopItemImage");
            UtilsKt.setImage(shopItemImage, savedImage);
        } else {
            ImageView shopItemImage2 = binding.shopItemImage;
            Intrinsics.checkNotNullExpressionValue(shopItemImage2, "shopItemImage");
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            UtilsKt.setNotLoadedImage(shopItemImage2, context);
        }
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.ShopAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShopAdapter.onBindViewHolder$lambda$3$lambda$2(ShopAdapter.this, battlePassShopData2, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2(ShopAdapter shopAdapter, BattlePassShopData battlePassShopData, int i, View view) {
        shopAdapter.onSelectItem.invoke(battlePassShopData, Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.shopItemList.size();
    }

    public final void addShopItems(List<BattlePassShopData> shopList) {
        Intrinsics.checkNotNullParameter(shopList, "shopList");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ShopAdapter$addShopItems$1(shopList, this, null), 3, null);
    }

    public final void updateBattlePassCoins(int i) {
        this.battlePassCoins = i;
        notifyDataSetChanged();
    }

    public final void clearShopList() {
        this.shopItemList.clear();
        notifyDataSetChanged();
    }

    public final void selectShopItem(int i) {
        for (BattlePassShopData battlePassShopData : this.shopItemList) {
            battlePassShopData.setSelected(false);
        }
        this.shopItemList.get(i).setSelected(true);
        notifyDataSetChanged();
    }
}
