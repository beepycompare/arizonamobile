package ru.mrlargha.commonui.elements.battlePassView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.ViewTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemRewardBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: RewardItemViewHolder.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\r\u001a\u001e\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000f0\u000f\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00100\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/battlePassView/RewardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemRewardBinding;", "context", "Landroid/content/Context;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemRewardBinding;Landroid/content/Context;)V", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "", "bind", "Lcom/bumptech/glide/request/target/ViewTarget;", "Landroid/widget/ImageView;", "Landroid/graphics/drawable/Drawable;", "item", "Lru/mrlargha/commonui/elements/battlePassView/RewardResponse;", "type", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RewardItemViewHolder extends RecyclerView.ViewHolder {
    private final ItemRewardBinding binding;
    private final Context context;
    private final boolean isArizonaType;
    private final SharedPreferences sharedPref;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardItemViewHolder(ItemRewardBinding binding, Context context) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = binding;
        this.context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
    }

    public final ViewTarget<ImageView, Drawable> bind(RewardResponse item, int i) {
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        ItemRewardBinding itemRewardBinding = this.binding;
        if (i == 0) {
            itemRewardBinding.cvReward.setCardBackgroundColor(Color.parseColor("#EB8BD3"));
        } else if (i == 13) {
            itemRewardBinding.cvReward.setCardBackgroundColor(Color.parseColor("#FFCB3A"));
        }
        if (this.isArizonaType) {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/systems/battle_pass_sound/image/";
        } else {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/systems/training/image/";
        }
        itemRewardBinding.tvRewardDesc.setText(item.getTitle());
        ViewTarget<ImageView, Drawable> into = Glide.with(this.context).load(str + item.getSysName() + ".webp").fitCenter().diskCacheStrategy(DiskCacheStrategy.ALL).into(itemRewardBinding.ivReward);
        Intrinsics.checkNotNullExpressionValue(into, "with(...)");
        return into;
    }
}
