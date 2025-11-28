package ru.mrlargha.arizona.promo;

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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.gradientBg.RadialBottomCenterCircleDrawable;
import ru.mrlargha.feature.arizona.promo.R;
import ru.mrlargha.feature.arizona.promo.databinding.RewardItemBinding;
/* compiled from: RewardItemsAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0014\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u0006\u0010\u0015\u001a\u00020\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizona/promo/RewardItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizona/promo/RewardItemViewHolder;", "<init>", "()V", "itemsList", "", "Lru/mrlargha/arizona/promo/PromoReward;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addAllItems", "items", "", "clearList", "promo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RewardItemsAdapter extends RecyclerView.Adapter<RewardItemViewHolder> {
    private final List<PromoReward> itemsList = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RewardItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.reward_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new RewardItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RewardItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PromoReward promoReward = (PromoReward) CollectionsKt.getOrNull(this.itemsList, i);
        if (promoReward == null) {
            promoReward = (PromoReward) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        RewardItemBinding binding = holder.getBinding();
        binding.text.setText(promoReward.getTitle());
        binding.colorBottom.setBackgroundColor(Color.parseColor(promoReward.getColor()));
        if (!UtilsKt.isArizonaType()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new RewardItemsAdapter$onBindViewHolder$1$1(promoReward, binding, null), 3, null);
        } else {
            Picasso picasso = Picasso.get();
            String resourceUrl$default = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso.load(resourceUrl$default + "projects/arizona-rp/assets/images/donate/" + StringsKt.substringBeforeLast$default(promoReward.getImage(), ".", (String) null, 2, (Object) null) + ".webp").into(binding.image);
        }
        binding.image.setBackground(new RadialBottomCenterCircleDrawable(Color.parseColor(promoReward.getColor()), 0));
        if (promoReward.getReceived() == 1) {
            binding.recieved.setVisibility(0);
        } else {
            binding.recieved.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<PromoReward> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        this.itemsList.clear();
        this.itemsList.addAll(items);
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
