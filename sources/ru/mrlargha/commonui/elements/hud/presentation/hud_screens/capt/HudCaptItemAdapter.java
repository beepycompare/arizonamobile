package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.HudCaptItemBinding;
/* compiled from: HudCaptItemAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001b\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemModel;", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemAdapter$HudCaptItemViewHolder;", "<init>", "()V", "isShowNumbering", "", "()Z", "setShowNumbering", "(Z)V", "value", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptScoreIconType;", "scoreIconType", "getScoreIconType", "()Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptScoreIconType;", "setScoreIconType", "(Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptScoreIconType;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "HudCaptItemViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudCaptItemAdapter extends ListAdapter<HudCaptItemModel, HudCaptItemViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final HudCaptItemAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<HudCaptItemModel>() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.capt.HudCaptItemAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(HudCaptItemModel oldItem, HudCaptItemModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getName(), newItem.getName());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(HudCaptItemModel oldItem, HudCaptItemModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };
    private boolean isShowNumbering;
    private HudCaptScoreIconType scoreIconType;

    public HudCaptItemAdapter() {
        super(diffUtilCallback);
        this.isShowNumbering = true;
        this.scoreIconType = HudCaptScoreIconType.SKULL;
    }

    public final boolean isShowNumbering() {
        return this.isShowNumbering;
    }

    public final void setShowNumbering(boolean z) {
        this.isShowNumbering = z;
    }

    public final HudCaptScoreIconType getScoreIconType() {
        return this.scoreIconType;
    }

    public final void setScoreIconType(HudCaptScoreIconType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.scoreIconType = value;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HudCaptItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        HudCaptItemBinding inflate = HudCaptItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new HudCaptItemViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(HudCaptItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        HudCaptItemModel hudCaptItemModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(hudCaptItemModel, "get(...)");
        holder.onBind(hudCaptItemModel, i);
    }

    /* compiled from: HudCaptItemAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemAdapter$HudCaptItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/HudCaptItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemAdapter;Lru/mrlargha/commonui/databinding/HudCaptItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/HudCaptItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemModel;", "position", "", "getItemBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "colorList", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class HudCaptItemViewHolder extends RecyclerView.ViewHolder {
        private final HudCaptItemBinding binding;
        final /* synthetic */ HudCaptItemAdapter this$0;

        /* compiled from: HudCaptItemAdapter.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[HudCaptScoreIconType.values().length];
                try {
                    iArr[HudCaptScoreIconType.SKULL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[HudCaptScoreIconType.BOX.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HudCaptItemViewHolder(HudCaptItemAdapter hudCaptItemAdapter, HudCaptItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = hudCaptItemAdapter;
            this.binding = binding;
        }

        public final HudCaptItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(HudCaptItemModel model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            HudCaptItemBinding hudCaptItemBinding = this.binding;
            HudCaptItemAdapter hudCaptItemAdapter = this.this$0;
            int parseColor = Color.parseColor(model.getTextColor());
            int alphaComponent = ColorUtils.setAlphaComponent(parseColor, 124);
            int alphaComponent2 = ColorUtils.setAlphaComponent(parseColor, 10);
            hudCaptItemBinding.tvName.setText(model.getName());
            hudCaptItemBinding.tvName.setTextColor(parseColor);
            hudCaptItemBinding.tvNumbering.setText(hudCaptItemBinding.getRoot().getContext().getString(R.string.numbering, Integer.valueOf(i + 1)));
            TextView tvNumbering = hudCaptItemBinding.tvNumbering;
            Intrinsics.checkNotNullExpressionValue(tvNumbering, "tvNumbering");
            tvNumbering.setVisibility(hudCaptItemAdapter.isShowNumbering() ? 0 : 8);
            hudCaptItemBinding.tvKillsCount.setText(String.valueOf(model.getKills()));
            hudCaptItemBinding.tvPeopleCount.setText(String.valueOf(model.getPeopleCount()));
            int i2 = WhenMappings.$EnumSwitchMapping$0[hudCaptItemAdapter.getScoreIconType().ordinal()];
            if (i2 == 1) {
                hudCaptItemBinding.ivScore.setImageResource(R.drawable.hud_capt_scull_ic);
            } else if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                hudCaptItemBinding.ivScore.setImageResource(R.drawable.hud_capt_box_ic);
            }
            LinearLayout root = hudCaptItemBinding.getRoot();
            Context context = hudCaptItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            root.setBackground(getItemBackgroundDrawable(context, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(alphaComponent), Integer.valueOf(alphaComponent2)})));
        }

        private final Drawable getItemBackgroundDrawable(Context context, List<Integer> list) {
            Drawable.ConstantState constantState;
            Drawable newDrawable;
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.hud_capt_item_bg);
            Drawable mutate = (drawable == null || (constantState = drawable.getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null) ? null : newDrawable.mutate();
            GradientDrawable gradientDrawable = mutate instanceof GradientDrawable ? (GradientDrawable) mutate : null;
            if (gradientDrawable != null) {
                gradientDrawable.setColors(CollectionsKt.toIntArray(list));
            }
            return gradientDrawable;
        }
    }

    /* compiled from: HudCaptItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/capt/HudCaptItemAdapter$Companion$diffUtilCallback$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
