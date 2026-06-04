package ru.mrlargha.event.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
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
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.event.data.ShopItem;
import ru.mrlargha.feature.event.R;
import ru.mrlargha.feature.event.databinding.EventShopItemBinding;
/* compiled from: ShopAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\u0006\u0010\u0017\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/event/adapters/ShopAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/event/adapters/EasterShopViewHolder;", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/event/data/ShopItem;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", "items", "", "clearList", NotificationCompat.CATEGORY_EVENT}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShopAdapter extends RecyclerView.Adapter<EasterShopViewHolder> {
    private final List<ShopItem> itemsList;
    private final Function1<ShopItem, Unit> onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public ShopAdapter(Function1<? super ShopItem, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.itemsList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EasterShopViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_shop_item, parent, false);
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
        EventShopItemBinding binding = holder.getBinding();
        binding.tvTitle.setText(shopItem.getName());
        binding.price.setText(String.valueOf(shopItem.getPrice()));
        if (UtilsKt.isArizonaType()) {
            Picasso picasso = Picasso.get();
            String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso.load(projectResourceUrl$default + "/systems/battlepass/easter-2026/" + shopItem.getImage() + ".webp").into(binding.ivName);
        } else {
            Picasso picasso2 = Picasso.get();
            String projectResourceUrl$default2 = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso2.load(projectResourceUrl$default2 + "systems/pirate-event/shop/" + shopItem.getImage() + ".webp").into(binding.ivName);
        }
        binding.btnSelect.setVisibility(8);
        binding.btnUnselect.setVisibility(8);
        if (shopItem.getRecived() == 0) {
            binding.btnSelect.setVisibility(0);
            binding.buyButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.event.adapters.ShopAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShopAdapter.onBindViewHolder$lambda$0$0(ShopAdapter.this, shopItem, view);
                }
            });
            binding.bg.setBackgroundResource(R.drawable.event_prise_item_bg);
        } else {
            binding.btnUnselect.setVisibility(0);
            binding.bg.setBackgroundResource(R.drawable.event_prise_item_bg1);
        }
        ImageView imageView = binding.ivCurrency;
        shopItem.isAzCoins();
        imageView.setImageResource(ru.mrlargha.commonui.R.drawable.ic_rubble);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(ShopAdapter shopAdapter, ShopItem shopItem, View view) {
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
