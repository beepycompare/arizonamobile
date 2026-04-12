package ru.mrlargha.feature.battle_pass_view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.battle_pass_view.databinding.ItemRewardBinding;
import ru.mrlargha.feature.battle_pass_view.databinding.ItemRewardRodinaBinding;
/* compiled from: RewardItemAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0018\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/battle_pass_view/RewardResponse;", "Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter$RewardItemViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "type", "", "arizonaPath", "", "setPath", "", "path", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "setType", "int", "RewardItemViewHolder", "Companion", "battle-pass-view"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RewardItemAdapter extends ListAdapter<RewardResponse, RewardItemViewHolder> {
    private String arizonaPath;
    private final Context context;
    private int type;
    public static final Companion Companion = new Companion(null);
    private static final RewardItemAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<RewardResponse>() { // from class: ru.mrlargha.feature.battle_pass_view.RewardItemAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(RewardResponse oldItem, RewardResponse newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getSysName() == newItem.getSysName();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(RewardResponse oldItem, RewardResponse newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardItemAdapter(Context context) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.arizonaPath = "systems/battle_pass_sound/image/";
    }

    public final void setPath(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.arizonaPath = str;
    }

    /* compiled from: RewardItemAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter$RewardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/battle_pass_view/databinding/ItemRewardBinding;", "bindingRodina", "Lru/mrlargha/feature/battle_pass_view/databinding/ItemRewardRodinaBinding;", "context", "Landroid/content/Context;", "<init>", "(Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter;Lru/mrlargha/feature/battle_pass_view/databinding/ItemRewardBinding;Lru/mrlargha/feature/battle_pass_view/databinding/ItemRewardRodinaBinding;Landroid/content/Context;)V", "bind", "", "item", "Lru/mrlargha/feature/battle_pass_view/RewardResponse;", "type", "", "battle-pass-view"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class RewardItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemRewardBinding binding;
        private final ItemRewardRodinaBinding bindingRodina;
        private final Context context;
        final /* synthetic */ RewardItemAdapter this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public RewardItemViewHolder(RewardItemAdapter rewardItemAdapter, ItemRewardBinding binding, ItemRewardRodinaBinding bindingRodina, Context context) {
            super(r2);
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(bindingRodina, "bindingRodina");
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = rewardItemAdapter;
            ViewGroup root = UtilsKt.isArizonaType() ? binding.getRoot() : bindingRodina.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            this.binding = binding;
            this.bindingRodina = bindingRodina;
            this.context = context;
        }

        public final void bind(RewardResponse item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            CardView cardView = UtilsKt.isArizonaType() ? this.binding.cvReward : this.bindingRodina.cvReward;
            Intrinsics.checkNotNull(cardView);
            TextView textView = UtilsKt.isArizonaType() ? this.binding.tvRewardDesc : this.bindingRodina.tvRewardDesc;
            Intrinsics.checkNotNull(textView);
            ImageView imageView = UtilsKt.isArizonaType() ? this.binding.ivReward : this.bindingRodina.ivReward;
            Intrinsics.checkNotNull(imageView);
            if (i == 0) {
                cardView.setCardBackgroundColor(ContextCompat.getColor(this.context, ru.mrlargha.feature.battlepassWinter2025.R.color.battlepass5));
            } else if (i == 13) {
                if (UtilsKt.isArizonaType()) {
                    cardView.setCardBackgroundColor(Color.parseColor("#86E1FF"));
                } else {
                    cardView.setCardBackgroundColor(Color.parseColor("#86E1FF"));
                }
            }
            String str = UtilsKt.isArizonaType() ? FirebaseConfigHelper.INSTANCE.getResourceUrl(false) + "projects/arizona-rp" + this.this$0.arizonaPath : FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/rodina-rp/systems/training/image/";
            textView.setText(item.getTitle());
            Glide.with(this.context).load(str + item.getSysName() + ".webp").fitCenter().diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
            this.binding.tvDopInfo.setText(item.getInfo());
            TextView tvDopInfo = this.binding.tvDopInfo;
            Intrinsics.checkNotNullExpressionValue(tvDopInfo, "tvDopInfo");
            tvDopInfo.setVisibility(item.getInfo() != null ? 0 : 8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RewardItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemRewardBinding inflate = ItemRewardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        ItemRewardRodinaBinding inflate2 = ItemRewardRodinaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new RewardItemViewHolder(this, inflate, inflate2, this.context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RewardItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        RewardResponse item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item, this.type);
    }

    public final void setType(int i) {
        this.type = i;
        notifyDataSetChanged();
    }

    /* compiled from: RewardItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/feature/battle_pass_view/RewardItemAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter$Companion$COMPARATOR$1;", "battle-pass-view"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
