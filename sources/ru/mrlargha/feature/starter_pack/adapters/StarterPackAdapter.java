package ru.mrlargha.feature.starter_pack.adapters;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.starter_pack.databinding.StarterpackItemBinding;
import ru.mrlargha.feature.starter_pack.models.StarterPackRewardsModel;
/* compiled from: StarterPackAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/starter_pack/adapters/StarterPackAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/starter_pack/models/StarterPackRewardsModel;", "Lru/mrlargha/feature/starter_pack/adapters/StarterPackAdapter$StarterPackViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "StarterPackViewHolder", "DiffUtilCallback", "starter-pack"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StarterPackAdapter extends ListAdapter<StarterPackRewardsModel, StarterPackViewHolder> {
    public StarterPackAdapter() {
        super(new DiffUtilCallback());
    }

    /* compiled from: StarterPackAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/starter_pack/adapters/StarterPackAdapter$StarterPackViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/starter_pack/databinding/StarterpackItemBinding;", "<init>", "(Lru/mrlargha/feature/starter_pack/databinding/StarterpackItemBinding;)V", "getBinding", "()Lru/mrlargha/feature/starter_pack/databinding/StarterpackItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/feature/starter_pack/models/StarterPackRewardsModel;", "starter-pack"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class StarterPackViewHolder extends RecyclerView.ViewHolder {
        private final StarterpackItemBinding binding;

        public final StarterpackItemBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StarterPackViewHolder(StarterpackItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void onBind(StarterPackRewardsModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            StarterpackItemBinding starterpackItemBinding = this.binding;
            starterpackItemBinding.rarity.setBackgroundColor(Color.parseColor(model.getColor()));
            starterpackItemBinding.tvTitle.setText(model.getTitle());
            String str = "systems/starter_packs/items/" + model.getIcon() + ".webp";
            String str2 = "systems/starter-packs/images/" + model.getIcon() + ".webp";
            Picasso picasso = Picasso.get();
            String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            if (!UtilsKt.isArizonaType()) {
                str = str2;
            }
            picasso.load(projectResourceUrl$default + str).into(starterpackItemBinding.imagePrise);
            starterpackItemBinding.bg.setForeground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.parseColor("#80" + StringsKt.removePrefix(model.getColor(), (CharSequence) "#")), 0}));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public StarterPackViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        StarterpackItemBinding inflate = StarterpackItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new StarterPackViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(StarterPackViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        StarterPackRewardsModel starterPackRewardsModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(starterPackRewardsModel, "get(...)");
        holder.onBind(starterPackRewardsModel);
    }

    /* compiled from: StarterPackAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/feature/starter_pack/adapters/StarterPackAdapter$DiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/mrlargha/feature/starter_pack/models/StarterPackRewardsModel;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "starter-pack"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DiffUtilCallback extends DiffUtil.ItemCallback<StarterPackRewardsModel> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(StarterPackRewardsModel oldItem, StarterPackRewardsModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getTitle(), newItem.getTitle());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(StarterPackRewardsModel oldItem, StarterPackRewardsModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
