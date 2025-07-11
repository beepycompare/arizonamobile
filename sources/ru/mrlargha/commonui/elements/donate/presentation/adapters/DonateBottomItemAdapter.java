package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DonateDefaultItemBinding;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBottomItemAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBadgesModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBlockType;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemType;
import ru.mrlargha.commonui.elements.donate.utils.CustomGridLayoutManager;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* compiled from: DonateBottomItemAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0016\u0017B*\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u001c\u0010\u0013\u001a\u00020\n2\n\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemAdapter$DonateBottomItemViewHolder;", "onClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "DonateBottomItemViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBottomItemAdapter extends ListAdapter<DonateItemModelUi, DonateBottomItemViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final DonateBottomItemAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<DonateItemModelUi>() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBottomItemAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(DonateItemModelUi oldItem, DonateItemModelUi newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(DonateItemModelUi oldItem, DonateItemModelUi newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }
    };
    private final Function1<Integer, Unit> onClick;

    public final Function1<Integer, Unit> getOnClick() {
        return this.onClick;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DonateBottomItemAdapter(Function1<? super Integer, Unit> onClick) {
        super(diffUtilCallback);
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
    }

    /* compiled from: DonateBottomItemAdapter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemAdapter$DonateBottomItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonateDefaultItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemAdapter;Lru/mrlargha/commonui/databinding/DonateDefaultItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateDefaultItemBinding;", "badgesAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "initItem", "initTitle", "setImageInfo", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;)Lkotlin/Unit;", "rvInit", "badges", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;", "setButtonTitle", "checkBlockType", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class DonateBottomItemViewHolder extends RecyclerView.ViewHolder {
        private final DonateBadgesAdapter badgesAdapter;
        private final DonateDefaultItemBinding binding;
        final /* synthetic */ DonateBottomItemAdapter this$0;

        /* compiled from: DonateBottomItemAdapter.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DonateBlockType.values().length];
                try {
                    iArr[DonateBlockType.CIRCLE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DonateBlockType.LOCK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DonateBlockType.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DonateBottomItemViewHolder(DonateBottomItemAdapter donateBottomItemAdapter, DonateDefaultItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = donateBottomItemAdapter;
            this.binding = binding;
            this.badgesAdapter = new DonateBadgesAdapter();
        }

        public final DonateDefaultItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(DonateItemModelUi model) {
            Intrinsics.checkNotNullParameter(model, "model");
            CardView cardContainer = this.binding.cardContainer;
            Intrinsics.checkNotNullExpressionValue(cardContainer, "cardContainer");
            cardContainer.setVisibility(0);
            initItem(model);
        }

        private final void initItem(final DonateItemModelUi donateItemModelUi) {
            DonateDefaultItemBinding donateDefaultItemBinding = this.binding;
            final DonateBottomItemAdapter donateBottomItemAdapter = this.this$0;
            ImageView ivItemBg = donateDefaultItemBinding.ivItemBg;
            Intrinsics.checkNotNullExpressionValue(ivItemBg, "ivItemBg");
            DonateUtilsKt.setImageItemBgSdn(ivItemBg, donateItemModelUi.getBackground());
            if (donateItemModelUi.isGif()) {
                ImageView ivItem = donateDefaultItemBinding.ivItem;
                Intrinsics.checkNotNullExpressionValue(ivItem, "ivItem");
                DonateUtilsKt.setGifSdn(ivItem, donateItemModelUi.getImage());
            } else {
                ImageView ivItem2 = donateDefaultItemBinding.ivItem;
                Intrinsics.checkNotNullExpressionValue(ivItem2, "ivItem");
                DonateUtilsKt.setImageSdn(ivItem2, donateItemModelUi.getImage());
            }
            initTitle(donateItemModelUi);
            setImageInfo(donateItemModelUi);
            rvInit(donateItemModelUi.getBadges());
            setButtonTitle(donateItemModelUi);
            checkBlockType(donateItemModelUi);
            if (donateItemModelUi.getAnimation()) {
                ImageView animationThumb = donateDefaultItemBinding.animationThumb;
                Intrinsics.checkNotNullExpressionValue(animationThumb, "animationThumb");
                animationThumb.setVisibility(0);
                Intrinsics.checkNotNull(Glide.with(donateDefaultItemBinding.animationThumb).load(Integer.valueOf(R.raw.donate_item_animation)).into(donateDefaultItemBinding.animationThumb));
            } else {
                ImageView animationThumb2 = donateDefaultItemBinding.animationThumb;
                Intrinsics.checkNotNullExpressionValue(animationThumb2, "animationThumb");
                animationThumb2.setVisibility(8);
            }
            if (donateItemModelUi.getItemType() == DonateItemType.WI || donateItemModelUi.getItemType() == DonateItemType.RATE) {
                donateDefaultItemBinding.ivItem.setBackground(null);
                if (!StringsKt.isBlank(donateItemModelUi.getEffectColor())) {
                    donateDefaultItemBinding.cardContainer.setCardBackgroundColor(Color.parseColor(donateItemModelUi.getEffectColor()));
                }
            }
            donateDefaultItemBinding.btnBuy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBottomItemAdapter$DonateBottomItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonateBottomItemAdapter.DonateBottomItemViewHolder.initItem$lambda$1$lambda$0(DonateBottomItemAdapter.this, donateItemModelUi, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initItem$lambda$1$lambda$0(DonateBottomItemAdapter donateBottomItemAdapter, DonateItemModelUi donateItemModelUi, View view) {
            donateBottomItemAdapter.getOnClick().invoke(Integer.valueOf(donateItemModelUi.getId()));
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0060, code lost:
            if (r9.getTextGradientColor().size() > 1) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void initTitle(DonateItemModelUi donateItemModelUi) {
            boolean z;
            DonateDefaultItemBinding donateDefaultItemBinding = this.binding;
            if (donateItemModelUi.getItemType() == DonateItemType.RATE) {
                LinearLayout rateContainer = donateDefaultItemBinding.rateContainer;
                Intrinsics.checkNotNullExpressionValue(rateContainer, "rateContainer");
                rateContainer.setVisibility(0);
                LinearLayout gradientTextContainer = donateDefaultItemBinding.gradientTextContainer;
                Intrinsics.checkNotNullExpressionValue(gradientTextContainer, "gradientTextContainer");
                gradientTextContainer.setVisibility(8);
                TextView tvName = donateDefaultItemBinding.tvName;
                Intrinsics.checkNotNullExpressionValue(tvName, "tvName");
                tvName.setVisibility(8);
                donateDefaultItemBinding.tvAzCoins.setText(String.valueOf(donateItemModelUi.getTotalEarnings()));
                return;
            }
            LinearLayout rateContainer2 = donateDefaultItemBinding.rateContainer;
            Intrinsics.checkNotNullExpressionValue(rateContainer2, "rateContainer");
            rateContainer2.setVisibility(8);
            if (!donateItemModelUi.getTextGradientColor().isEmpty()) {
                z = true;
            }
            z = false;
            LinearLayout gradientTextContainer2 = donateDefaultItemBinding.gradientTextContainer;
            Intrinsics.checkNotNullExpressionValue(gradientTextContainer2, "gradientTextContainer");
            gradientTextContainer2.setVisibility(z ? 0 : 8);
            TextView tvName2 = donateDefaultItemBinding.tvName;
            Intrinsics.checkNotNullExpressionValue(tvName2, "tvName");
            tvName2.setVisibility(z ? 8 : 0);
            if (z) {
                donateDefaultItemBinding.tvSecondTitle.setColorList(DonateUtilsKt.convertColorList(donateItemModelUi.getTextGradientColor()));
                donateDefaultItemBinding.tvFirstTitle.setText(DonateUtilsKt.splitOnPart(donateItemModelUi.getName()).getFirst());
                donateDefaultItemBinding.tvSecondTitle.setText(DonateUtilsKt.splitOnPart(donateItemModelUi.getName()).getSecond());
                return;
            }
            donateDefaultItemBinding.tvName.setText(donateItemModelUi.getName());
        }

        private final Unit setImageInfo(DonateItemModelUi donateItemModelUi) {
            DonateDefaultItemBinding donateDefaultItemBinding = this.binding;
            if (donateItemModelUi.getEffectColor().length() == 0) {
                donateDefaultItemBinding.ivItem.setBackground(null);
                return Unit.INSTANCE;
            }
            Context context = donateDefaultItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable itemEffectDrawable = DonateUtilsKt.getItemEffectDrawable(context, donateItemModelUi.getEffectColor());
            if (itemEffectDrawable != null) {
                donateDefaultItemBinding.ivItem.setBackground(itemEffectDrawable);
                return Unit.INSTANCE;
            }
            return null;
        }

        private final void rvInit(List<DonateBadgesModelUi> list) {
            DonateDefaultItemBinding donateDefaultItemBinding = this.binding;
            donateDefaultItemBinding.rvTags.setLayoutManager(new CustomGridLayoutManager());
            donateDefaultItemBinding.rvTags.setAdapter(this.badgesAdapter);
            this.badgesAdapter.submitList(list);
        }

        private final void setButtonTitle(DonateItemModelUi donateItemModelUi) {
            DonateDefaultItemBinding donateDefaultItemBinding = this.binding;
            donateDefaultItemBinding.tvOldPrice.setPaintFlags(16);
            Context context = donateDefaultItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable buttonsGradientDrawable = DonateUtilsKt.getButtonsGradientDrawable(context, donateItemModelUi.getColorButton());
            if (buttonsGradientDrawable != null) {
                donateDefaultItemBinding.btnBuy.setBackground(buttonsGradientDrawable);
            }
            donateDefaultItemBinding.ivMoneyIc.setImageResource(donateItemModelUi.getCurrencyType().getIcon());
            ImageView ivMoneyIc = donateDefaultItemBinding.ivMoneyIc;
            Intrinsics.checkNotNullExpressionValue(ivMoneyIc, "ivMoneyIc");
            ivMoneyIc.setVisibility(donateItemModelUi.getTitleButton().length() == 0 ? 0 : 8);
            donateDefaultItemBinding.tvOldPrice.setText(donateItemModelUi.getButtonTitle().getFirst());
            donateDefaultItemBinding.tvPrice.setText(donateItemModelUi.getButtonTitle().getSecond());
        }

        private final void checkBlockType(DonateItemModelUi donateItemModelUi) {
            DonateDefaultItemBinding donateDefaultItemBinding = this.binding;
            int i = WhenMappings.$EnumSwitchMapping$0[donateItemModelUi.m10603getBlockType().ordinal()];
            if (i == 1) {
                LinearLayout blockContainer = donateDefaultItemBinding.blockContainer;
                Intrinsics.checkNotNullExpressionValue(blockContainer, "blockContainer");
                blockContainer.setVisibility(0);
                donateDefaultItemBinding.tvBlockReason.setText(donateItemModelUi.getBlockTitle());
            } else if (i == 2) {
                LinearLayout blockContainer2 = donateDefaultItemBinding.blockContainer;
                Intrinsics.checkNotNullExpressionValue(blockContainer2, "blockContainer");
                blockContainer2.setVisibility(0);
                donateDefaultItemBinding.tvBlockReason.setText(donateItemModelUi.getBlockTitle());
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                LinearLayout blockContainer3 = donateDefaultItemBinding.blockContainer;
                Intrinsics.checkNotNullExpressionValue(blockContainer3, "blockContainer");
                blockContainer3.setVisibility(8);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DonateBottomItemViewHolder onCreateViewHolder(final ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        final DonateDefaultItemBinding inflate = DonateDefaultItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        parent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBottomItemAdapter$onCreateViewHolder$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                parent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ViewGroup.LayoutParams layoutParams = inflate.getRoot().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.width = parent.getMeasuredWidth() / 4;
                inflate.getRoot().setLayoutParams(marginLayoutParams);
            }
        });
        return new DonateBottomItemViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DonateBottomItemViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DonateItemModelUi donateItemModelUi = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(donateItemModelUi, "get(...)");
        holder.onBind(donateItemModelUi);
    }

    /* compiled from: DonateBottomItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBottomItemAdapter$Companion$diffUtilCallback$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
