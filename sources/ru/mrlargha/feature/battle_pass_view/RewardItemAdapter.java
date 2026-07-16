package ru.mrlargha.feature.battle_pass_view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battle_pass_view.databinding.ItemRewardBinding;
/* compiled from: RewardItemAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0018\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/battle_pass_view/RewardResponse;", "Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter$RewardItemViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "type", "", "arizonaPath", "", "setPath", "", "path", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "setType", "int", "RewardItemViewHolder", "Companion", "battle-pass-view"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter$RewardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/battle_pass_view/databinding/ItemRewardBinding;", "context", "Landroid/content/Context;", "<init>", "(Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter;Lru/mrlargha/feature/battle_pass_view/databinding/ItemRewardBinding;Landroid/content/Context;)V", "bind", "", "item", "Lru/mrlargha/feature/battle_pass_view/RewardResponse;", "type", "", "battle-pass-view"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class RewardItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemRewardBinding binding;
        private final Context context;
        final /* synthetic */ RewardItemAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RewardItemViewHolder(RewardItemAdapter rewardItemAdapter, ItemRewardBinding binding, Context context) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = rewardItemAdapter;
            this.binding = binding;
            this.context = context;
        }

        public final void bind(RewardResponse item, int i) {
            Object m9898constructorimpl;
            Intrinsics.checkNotNullParameter(item, "item");
            ItemRewardBinding itemRewardBinding = this.binding;
            RewardItemAdapter rewardItemAdapter = this.this$0;
            if (i == 0) {
                itemRewardBinding.cvReward.setBackground(ContextCompat.getColor(this.context, ru.mrlargha.feature.battlepassWinter2025.R.color.battlepass5));
            } else if (i == 13) {
                if (UtilsKt.isArizonaType()) {
                    itemRewardBinding.cvReward.setBackground(Color.parseColor("#86E1FF"));
                } else {
                    itemRewardBinding.cvReward.setBackground(Color.parseColor("#567A97"));
                }
            }
            String str = UtilsKt.isArizonaType() ? FirebaseConfigHelper.INSTANCE.getProjectResourceUrl(false) + StringsKt.removePrefix(rewardItemAdapter.arizonaPath, (CharSequence) "/") : FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "systems/training/image/";
            TextView textView = itemRewardBinding.tvRewardDesc;
            String title = item.getTitle();
            if (title == null) {
                title = "";
            }
            textView.setText(title);
            Glide.with(this.context).load(str + item.getSysName() + ".webp").fitCenter().diskCacheStrategy(DiskCacheStrategy.ALL).into(itemRewardBinding.ivReward);
            String info = UtilsKt.isArizonaType() ? item.getInfo() : item.getDescription();
            this.binding.tvDopInfo.setText(info != null ? info : "");
            TextView tvDopInfo = this.binding.tvDopInfo;
            Intrinsics.checkNotNullExpressionValue(tvDopInfo, "tvDopInfo");
            String str2 = info;
            tvDopInfo.setVisibility(!(str2 == null || StringsKt.isBlank(str2)) ? 0 : 8);
            if (UtilsKt.isArizonaType()) {
                return;
            }
            List<String> colors = item.getColors();
            if (colors == null) {
                colors = CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str3 : colors) {
                try {
                    Result.Companion companion = Result.Companion;
                    m9898constructorimpl = Result.m9898constructorimpl(Integer.valueOf(Color.parseColor(str3)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m9898constructorimpl = Result.m9898constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m9904isFailureimpl(m9898constructorimpl)) {
                    m9898constructorimpl = null;
                }
                Integer num = (Integer) m9898constructorimpl;
                if (num != null) {
                    arrayList.add(num);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.size() >= 2) {
                CustomCardView cvReward = itemRewardBinding.cvReward;
                Intrinsics.checkNotNullExpressionValue(cvReward, "cvReward");
                CustomCardView.setBackground$default(cvReward, CollectionsKt.toIntArray(arrayList2), null, null, 6, null);
            } else if (arrayList2.size() == 1) {
                itemRewardBinding.cvReward.setBackground(((Number) arrayList2.get(0)).intValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RewardItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemRewardBinding inflate = ItemRewardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new RewardItemViewHolder(this, inflate, this.context);
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
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/feature/battle_pass_view/RewardItemAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/feature/battle_pass_view/RewardItemAdapter$Companion$COMPARATOR$1;", "battle-pass-view"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
