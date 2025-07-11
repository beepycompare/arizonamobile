package ru.mrlargha.commonui.elements.easter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.EasterBattlePassShopItemBinding;
import ru.mrlargha.commonui.elements.easter.data.ShopItem;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: ShopAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0014\u0010\u0017\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019J\u0006\u0010\u001a\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/easter/adapters/ShopAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/easter/adapters/EasterShopViewHolder;", "isArizona", "", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/easter/data/ShopItem;", "", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "()Z", "itemsList", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", FirebaseAnalytics.Param.ITEMS, "", "clearList", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShopAdapter extends RecyclerView.Adapter<EasterShopViewHolder> {
    private final boolean isArizona;
    private final List<ShopItem> itemsList;
    private final Function1<ShopItem, Unit> onClick;

    public final boolean isArizona() {
        return this.isArizona;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShopAdapter(boolean z, Function1<? super ShopItem, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.isArizona = z;
        this.onClick = onClick;
        this.itemsList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EasterShopViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.easter_battle_pass_shop_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new EasterShopViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EasterShopViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final ShopItem shopItem = (ShopItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (shopItem == null) {
            shopItem = (ShopItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        EasterBattlePassShopItemBinding binding = holder.getBinding();
        binding.tvTitle.setText(shopItem.getName());
        binding.price.setText(String.valueOf(shopItem.getPrice()));
        if (this.isArizona) {
            Picasso picasso = Picasso.get();
            String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso.load(resourceUrl + "/projects/arizona-rp/systems/battlepass_holiday/shop_image/" + shopItem.getImage() + ".webp").into(binding.ivName);
        } else {
            Picasso picasso2 = Picasso.get();
            String resourceUrl2 = FirebaseConfigHelper.INSTANCE.getResourceUrl();
            picasso2.load(resourceUrl2 + "/projects/rodina-rp/systems/battlepass/items/" + shopItem.getImage() + ".webp").into(binding.ivName);
        }
        binding.btnSelect.setVisibility(8);
        binding.btnUnselect.setVisibility(8);
        if (shopItem.getRecived() == 0) {
            binding.btnSelect.setVisibility(0);
            binding.buyButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.adapters.ShopAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShopAdapter.onBindViewHolder$lambda$1$lambda$0(ShopAdapter.this, shopItem, view);
                }
            });
            binding.bg.setBackgroundResource(R.drawable.easter_battle_pass_prise_item_bg);
            return;
        }
        binding.btnUnselect.setVisibility(0);
        binding.bg.setBackgroundResource(R.drawable.easter_battle_pass_prise_item_bg1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(ShopAdapter shopAdapter, ShopItem shopItem, View view) {
        shopAdapter.onClick.invoke(shopItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<ShopItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ShopAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
