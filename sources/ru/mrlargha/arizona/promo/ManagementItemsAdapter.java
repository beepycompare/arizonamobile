package ru.mrlargha.arizona.promo;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
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
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
import ru.mrlargha.commonui.utils.ui.gradientBg.RadialBottomCenterCircleDrawable;
import ru.mrlargha.feature.arizona.promo.R;
import ru.mrlargha.feature.arizona.promo.databinding.ManagementItemBinding;
/* compiled from: ManagementItemsAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0014\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u0006\u0010\u0015\u001a\u00020\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizona/promo/ManagementItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizona/promo/ManagementItemViewHolder;", "<init>", "()V", "itemsList", "", "Lru/mrlargha/arizona/promo/PromoReward;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addAllItems", "items", "", "clearList", NotificationCompat.CATEGORY_PROMO}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ManagementItemsAdapter extends RecyclerView.Adapter<ManagementItemViewHolder> {
    private final List<PromoReward> itemsList = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ManagementItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.management_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ManagementItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ManagementItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PromoReward promoReward = (PromoReward) CollectionsKt.getOrNull(this.itemsList, i);
        if (promoReward == null) {
            promoReward = (PromoReward) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        ManagementItemBinding binding = holder.getBinding();
        binding.text.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, promoReward.getTitle(), 0.0f, null, 3, null));
        binding.colorBottom.setBackgroundColor(Color.parseColor(promoReward.getColor()));
        if (!UtilsKt.isArizonaType()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ManagementItemsAdapter$onBindViewHolder$1$1(promoReward, binding, null), 3, null);
        } else {
            Picasso picasso = Picasso.get();
            String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            picasso.load(projectResourceUrl$default + "assets/images/donate/" + StringsKt.substringBeforeLast$default(promoReward.getImage(), ".", (String) null, 2, (Object) null) + ".webp").into(binding.image);
        }
        binding.image.setBackground(new RadialBottomCenterCircleDrawable(Color.parseColor(promoReward.getColor()), 0));
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
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ManagementItemsAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
