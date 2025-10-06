package ru.mrlargha.rating;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.item.rating.R;
import ru.mrlargha.feature.item.rating.databinding.RatingItemBinding;
/* compiled from: ItemsAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0014\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dJ\u0006\u0010\u001e\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/mrlargha/rating/ItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/rating/MembersViewHolder;", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/rating/RatingItem;", "", "onScrollFinish", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "isRequestSend", "", "page", "_isManager", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", "items", "", "clearList", "item-rating_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ItemsAdapter extends RecyclerView.Adapter<MembersViewHolder> {
    private boolean _isManager;
    private boolean isRequestSend;
    private final List<RatingItem> itemsList;
    private final Function1<RatingItem, Unit> onClick;
    private final Function1<Integer, Unit> onScrollFinish;
    private int page;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemsAdapter(Function1<? super RatingItem, Unit> onClick, Function1<? super Integer, Unit> onScrollFinish) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onScrollFinish, "onScrollFinish");
        this.onClick = onClick;
        this.onScrollFinish = onScrollFinish;
        this.itemsList = new ArrayList();
        this.page = 1;
    }

    public final List<RatingItem> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MembersViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.rating_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MembersViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MembersViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final RatingItem ratingItem = (RatingItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (ratingItem == null) {
            ratingItem = (RatingItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        RatingItemBinding binding = holder.getBinding();
        binding.number.setText(String.valueOf(ratingItem.getId()));
        binding.nick.setText(ratingItem.getPlayerName());
        binding.title.setText(ratingItem.getCarName());
        Picasso picasso = Picasso.get();
        String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso.load(resourceUrl + "projects/rodina-rp/assets/images/inventory/vehicles/512/" + ratingItem.getImage() + ".webp").into(binding.image);
        int rarity = ratingItem.getRarity();
        if (rarity == 1) {
            binding.getRoot().setBackgroundResource(R.drawable.rating_card_bg3);
            binding.labelText.setText("Хлам (" + ratingItem.getRarityLevel() + ")");
            CustomCardView labelBg = binding.labelBg;
            Intrinsics.checkNotNullExpressionValue(labelBg, "labelBg");
            CustomCardView.setBackground$default(labelBg, Color.parseColor("#E5E5E5"), Color.parseColor("#00787878"), null, null, 12, null);
            binding.labelText.setTextColor(Color.parseColor("#000000"));
        } else if (rarity == 2) {
            binding.getRoot().setBackgroundResource(R.drawable.rating_card_bg2);
            binding.labelText.setText("Обычное (" + ratingItem.getRarityLevel() + ")");
            CustomCardView labelBg2 = binding.labelBg;
            Intrinsics.checkNotNullExpressionValue(labelBg2, "labelBg");
            CustomCardView.setBackground$default(labelBg2, Color.parseColor("#00FFFF"), Color.parseColor("#00003636"), null, null, 12, null);
            binding.labelText.setTextColor(Color.parseColor("#004D4D"));
        } else if (rarity == 4) {
            binding.getRoot().setBackgroundResource(R.drawable.rating_card_bg1);
            CustomCardView labelBg3 = binding.labelBg;
            Intrinsics.checkNotNullExpressionValue(labelBg3, "labelBg");
            CustomCardView.setBackground$default(labelBg3, Color.parseColor("#FFCC00"), Color.parseColor("#00FFCC00"), null, null, 12, null);
            binding.labelText.setText("Идеальное (" + ratingItem.getRarityLevel() + ")");
            binding.labelText.setTextColor(Color.parseColor("#672400"));
        }
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.rating.ItemsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemsAdapter.onBindViewHolder$lambda$0$0(ItemsAdapter.this, ratingItem, view);
            }
        });
        if (i + 1 != this.itemsList.size() || this.isRequestSend || i <= 18) {
            return;
        }
        this.isRequestSend = true;
        int i2 = this.page + 1;
        this.page = i2;
        this.onScrollFinish.invoke(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(ItemsAdapter itemsAdapter, RatingItem ratingItem, View view) {
        itemsAdapter.onClick.invoke(ratingItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<RatingItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.isRequestSend = false;
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ItemsAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void clearList() {
        this.page = 1;
        this.isRequestSend = false;
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
