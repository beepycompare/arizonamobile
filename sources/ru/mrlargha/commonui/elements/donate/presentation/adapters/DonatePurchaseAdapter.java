package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.databinding.DonatePurshaseItemBinding;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePurchaseAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBadgesModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBlockType;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemType;
import ru.mrlargha.commonui.elements.donate.utils.CustomGridLayoutManager;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* compiled from: DonatePurchaseAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0016\u0017B*\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u001c\u0010\u0013\u001a\u00020\n2\n\u0010\u0014\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePurchaseAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePurchaseAdapter$DonatePurchaseViewHolder;", "onClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "DonatePurchaseViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonatePurchaseAdapter extends ListAdapter<DonateItemModelUi, DonatePurchaseViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final DonatePurchaseAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<DonateItemModelUi>() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePurchaseAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(DonateItemModelUi oldItem, DonateItemModelUi newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(DonateItemModelUi oldItem, DonateItemModelUi newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };
    private final Function1<Integer, Unit> onClick;

    public final Function1<Integer, Unit> getOnClick() {
        return this.onClick;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DonatePurchaseAdapter(Function1<? super Integer, Unit> onClick) {
        super(diffUtilCallback);
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DonatePurchaseViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DonatePurshaseItemBinding inflate = DonatePurshaseItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new DonatePurchaseViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DonatePurchaseViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Log.i(DonateUtilsKt.DONATE_TAG, "prise: " + getCurrentList().get(i).getPrice() + " ");
        DonateItemModelUi donateItemModelUi = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(donateItemModelUi, "get(...)");
        holder.onBind(donateItemModelUi, i);
    }

    /* compiled from: DonatePurchaseAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePurchaseAdapter$DonatePurchaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonatePurshaseItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePurchaseAdapter;Lru/mrlargha/commonui/databinding/DonatePurshaseItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonatePurshaseItemBinding;", "badgesAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "position", "", "initialize", "setImageInfo", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;)Lkotlin/Unit;", "rvInit", "badges", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;", "setButtonTitle", "checkBlockType", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class DonatePurchaseViewHolder extends RecyclerView.ViewHolder {
        private final DonateBadgesAdapter badgesAdapter;
        private final DonatePurshaseItemBinding binding;
        final /* synthetic */ DonatePurchaseAdapter this$0;

        /* compiled from: DonatePurchaseAdapter.kt */
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
        public DonatePurchaseViewHolder(DonatePurchaseAdapter donatePurchaseAdapter, DonatePurshaseItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = donatePurchaseAdapter;
            this.binding = binding;
            this.badgesAdapter = new DonateBadgesAdapter();
        }

        public final DonatePurshaseItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(DonateItemModelUi model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            initialize(model);
        }

        private final void initialize(final DonateItemModelUi donateItemModelUi) {
            DonatePurshaseItemBinding donatePurshaseItemBinding = this.binding;
            final DonatePurchaseAdapter donatePurchaseAdapter = this.this$0;
            donatePurshaseItemBinding.tvFirstTitle.setText(donateItemModelUi.getName());
            donatePurshaseItemBinding.tvSecondTitle.setText(donateItemModelUi.getDesc());
            donatePurshaseItemBinding.tvSecondTitle.setColorList(DonateUtilsKt.convertColorList(donateItemModelUi.getTextGradientColor()));
            ImageView ivItemBg = donatePurshaseItemBinding.ivItemBg;
            Intrinsics.checkNotNullExpressionValue(ivItemBg, "ivItemBg");
            DonateUtilsKt.setImageItemBgSdn(ivItemBg, donateItemModelUi.getBackground());
            if (donateItemModelUi.isGif()) {
                ImageView ivItem = donatePurshaseItemBinding.ivItem;
                Intrinsics.checkNotNullExpressionValue(ivItem, "ivItem");
                DonateUtilsKt.setGifSdn(ivItem, donateItemModelUi.getImage());
            } else {
                ImageView ivItem2 = donatePurshaseItemBinding.ivItem;
                Intrinsics.checkNotNullExpressionValue(ivItem2, "ivItem");
                DonateUtilsKt.setImageSdn(ivItem2, donateItemModelUi.getImage());
            }
            setImageInfo(donateItemModelUi);
            rvInit(donateItemModelUi.getBadges());
            setButtonTitle(donateItemModelUi);
            checkBlockType(donateItemModelUi);
            donateItemModelUi.getAnimation();
            if (donateItemModelUi.getItemType() == DonateItemType.WI || donateItemModelUi.getItemType() == DonateItemType.RATE) {
                donatePurshaseItemBinding.ivItem.setBackground(null);
                if (!StringsKt.isBlank(donateItemModelUi.getEffectColor())) {
                    donatePurshaseItemBinding.cardContainer.setCardBackgroundColor(Color.parseColor(donateItemModelUi.getEffectColor()));
                }
            }
            donatePurshaseItemBinding.btnBuy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePurchaseAdapter$DonatePurchaseViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonatePurchaseAdapter.DonatePurchaseViewHolder.initialize$lambda$1$lambda$0(DonatePurchaseAdapter.this, donateItemModelUi, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initialize$lambda$1$lambda$0(DonatePurchaseAdapter donatePurchaseAdapter, DonateItemModelUi donateItemModelUi, View view) {
            donatePurchaseAdapter.getOnClick().invoke(Integer.valueOf(donateItemModelUi.getId()));
        }

        private final Unit setImageInfo(DonateItemModelUi donateItemModelUi) {
            DonatePurshaseItemBinding donatePurshaseItemBinding = this.binding;
            if (donateItemModelUi.getEffectColor().length() == 0) {
                donatePurshaseItemBinding.ivItem.setBackground(null);
                return Unit.INSTANCE;
            }
            Context context = donatePurshaseItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable itemEffectDrawable = DonateUtilsKt.getItemEffectDrawable(context, donateItemModelUi.getEffectColor());
            if (itemEffectDrawable != null) {
                donatePurshaseItemBinding.ivItem.setBackground(itemEffectDrawable);
                return Unit.INSTANCE;
            }
            return null;
        }

        private final void rvInit(List<DonateBadgesModelUi> list) {
            DonatePurshaseItemBinding donatePurshaseItemBinding = this.binding;
            donatePurshaseItemBinding.rvTags.setLayoutManager(new CustomGridLayoutManager());
            donatePurshaseItemBinding.rvTags.setAdapter(this.badgesAdapter);
            this.badgesAdapter.submitList(list);
        }

        private final void setButtonTitle(DonateItemModelUi donateItemModelUi) {
            DonatePurshaseItemBinding donatePurshaseItemBinding = this.binding;
            donatePurshaseItemBinding.tvOldPrice.setPaintFlags(16);
            Context context = donatePurshaseItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable buttonsGradientDrawable = DonateUtilsKt.getButtonsGradientDrawable(context, donateItemModelUi.getColorButton());
            if (buttonsGradientDrawable != null) {
                donatePurshaseItemBinding.btnBuy.setBackground(buttonsGradientDrawable);
            }
            donatePurshaseItemBinding.ivMoneyIc.setImageResource(donateItemModelUi.getCurrencyType().getIcon());
            ImageView ivMoneyIc = donatePurshaseItemBinding.ivMoneyIc;
            Intrinsics.checkNotNullExpressionValue(ivMoneyIc, "ivMoneyIc");
            ivMoneyIc.setVisibility(donateItemModelUi.getTitleButton().length() == 0 ? 0 : 8);
            donatePurshaseItemBinding.tvOldPrice.setText(donateItemModelUi.getButtonTitle().getFirst());
            donatePurshaseItemBinding.tvPrice.setText(donateItemModelUi.getButtonTitle().getSecond());
        }

        private final void checkBlockType(DonateItemModelUi donateItemModelUi) {
            DonatePurshaseItemBinding donatePurshaseItemBinding = this.binding;
            int i = WhenMappings.$EnumSwitchMapping$0[donateItemModelUi.m10603getBlockType().ordinal()];
            if (i == 1) {
                LinearLayout blockContainer = donatePurshaseItemBinding.blockContainer;
                Intrinsics.checkNotNullExpressionValue(blockContainer, "blockContainer");
                blockContainer.setVisibility(0);
                donatePurshaseItemBinding.tvBlockReason.setText(donateItemModelUi.getBlockTitle());
            } else if (i == 2) {
                LinearLayout blockContainer2 = donatePurshaseItemBinding.blockContainer;
                Intrinsics.checkNotNullExpressionValue(blockContainer2, "blockContainer");
                blockContainer2.setVisibility(0);
                donatePurshaseItemBinding.tvBlockReason.setText(donateItemModelUi.getBlockTitle());
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                LinearLayout blockContainer3 = donatePurshaseItemBinding.blockContainer;
                Intrinsics.checkNotNullExpressionValue(blockContainer3, "blockContainer");
                blockContainer3.setVisibility(8);
            }
        }
    }

    /* compiled from: DonatePurchaseAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePurchaseAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePurchaseAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePurchaseAdapter$Companion$diffUtilCallback$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
