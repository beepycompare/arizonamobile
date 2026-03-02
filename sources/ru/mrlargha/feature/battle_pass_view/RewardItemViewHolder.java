package ru.mrlargha.feature.battle_pass_view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.ViewTarget;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.battle_pass_view.databinding.ItemRewardBinding;
/* compiled from: RewardItemViewHolder.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\b\u001a\u001e\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\f0\f0\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/RewardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/battle_pass_view/databinding/ItemRewardBinding;", "context", "Landroid/content/Context;", "<init>", "(Lru/mrlargha/feature/battle_pass_view/databinding/ItemRewardBinding;Landroid/content/Context;)V", "bind", "Lcom/bumptech/glide/request/target/ViewTarget;", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "Landroid/graphics/drawable/Drawable;", "item", "Lru/mrlargha/feature/battle_pass_view/RewardResponse;", "type", "", "battle-pass-view"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RewardItemViewHolder extends RecyclerView.ViewHolder {
    private final ItemRewardBinding binding;
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardItemViewHolder(ItemRewardBinding binding, Context context) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = binding;
        this.context = context;
    }

    public final ViewTarget<ImageView, Drawable> bind(RewardResponse item, int i) {
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        ItemRewardBinding itemRewardBinding = this.binding;
        if (i == 0) {
            itemRewardBinding.cvReward.setCardBackgroundColor(ContextCompat.getColor(this.context, ru.mrlargha.feature.battlepassWinter2025.R.color.battlepass5));
        } else if (i == 13) {
            if (UtilsKt.isArizonaType()) {
                itemRewardBinding.cvReward.setCardBackgroundColor(Color.parseColor("#86E1FF"));
            } else {
                itemRewardBinding.cvReward.setCardBackgroundColor(Color.parseColor("#86E1FF"));
            }
        }
        if (UtilsKt.isArizonaType()) {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl(false) + "projects/arizona-rp/systems/battle_pass_sound/image/";
        } else {
            str = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/rodina-rp/systems/training/image/";
        }
        itemRewardBinding.tvRewardDesc.setText(item.getTitle());
        ViewTarget<ImageView, Drawable> into = Glide.with(this.context).load(str + item.getSysName() + ".webp").fitCenter().diskCacheStrategy(DiskCacheStrategy.ALL).into(itemRewardBinding.ivReward);
        Intrinsics.checkNotNullExpressionValue(into, "with(...)");
        return into;
    }
}
