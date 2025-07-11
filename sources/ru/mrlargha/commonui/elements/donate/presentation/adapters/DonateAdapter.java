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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DonateDefaultItemBinding;
import ru.mrlargha.commonui.databinding.DonatePosterItemBinding;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBadgesModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBlockType;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemType;
import ru.mrlargha.commonui.elements.donate.utils.CustomGridLayoutManager;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* compiled from: DonateAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003#$%BF\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0014\u0010\u001b\u001a\u00060\u001cR\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0014\u0010\u001d\u001a\u00060\u001cR\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0014\u0010\u001e\u001a\u00060\u001fR\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R,\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006&"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "lastItemBind", "Lkotlin/Function0;", "", "onClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "openDialog", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getLastItemBind", "()Lkotlin/jvm/functions/Function0;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "getOpenDialog", "onViewRecycled", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "createDefaultViewHolder", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$DonateDefaultViewHolder;", "createWiViewHolder", "createPosterViewHolder", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$DonatePosterViewHolder;", "onBindViewHolder", "position", "getItemViewType", "DonateDefaultViewHolder", "DonatePosterViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateAdapter extends ListAdapter<DonateItemModelUi, RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final DonateAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<DonateItemModelUi>() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter$Companion$diffUtilCallback$1
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
    private final Function0<Unit> lastItemBind;
    private final Function1<Integer, Unit> onClick;
    private final Function0<Unit> openDialog;

    /* compiled from: DonateAdapter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DonateItemType.values().length];
            try {
                iArr[DonateItemType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DonateItemType.WI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DonateItemType.BIG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DonateItemType.RATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Function0<Unit> getLastItemBind() {
        return this.lastItemBind;
    }

    public final Function1<Integer, Unit> getOnClick() {
        return this.onClick;
    }

    public final Function0<Unit> getOpenDialog() {
        return this.openDialog;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DonateAdapter(Function0<Unit> lastItemBind, Function1<? super Integer, Unit> onClick, Function0<Unit> openDialog) {
        super(diffUtilCallback);
        Intrinsics.checkNotNullParameter(lastItemBind, "lastItemBind");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(openDialog, "openDialog");
        this.lastItemBind = lastItemBind;
        this.onClick = onClick;
        this.openDialog = openDialog;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        if (holder instanceof DonateDefaultViewHolder) {
            CardView cardContainer = ((DonateDefaultViewHolder) holder).getBinding().cardContainer;
            Intrinsics.checkNotNullExpressionValue(cardContainer, "cardContainer");
            cardContainer.setVisibility(8);
        } else if (holder instanceof DonatePosterViewHolder) {
            CardView cardContainer2 = ((DonatePosterViewHolder) holder).getBinding().cardContainer;
            Intrinsics.checkNotNullExpressionValue(cardContainer2, "cardContainer");
            cardContainer2.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i == DonateItemType.BIG.getType()) {
            return createPosterViewHolder(parent);
        }
        if (i == DonateItemType.WI.getType()) {
            return createWiViewHolder(parent);
        }
        return createDefaultViewHolder(parent);
    }

    private final DonateDefaultViewHolder createDefaultViewHolder(final ViewGroup viewGroup) {
        final DonateDefaultItemBinding inflate = DonateDefaultItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        viewGroup.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DonateAdapter.createDefaultViewHolder$lambda$0(viewGroup, inflate);
            }
        });
        return new DonateDefaultViewHolder(this, inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDefaultViewHolder$lambda$0(ViewGroup viewGroup, DonateDefaultItemBinding donateDefaultItemBinding) {
        ViewGroup.LayoutParams layoutParams = donateDefaultItemBinding.getRoot().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = viewGroup.getMeasuredWidth() / 4;
        donateDefaultItemBinding.getRoot().setLayoutParams(marginLayoutParams);
    }

    private final DonateDefaultViewHolder createWiViewHolder(final ViewGroup viewGroup) {
        final DonateDefaultItemBinding inflate = DonateDefaultItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        viewGroup.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DonateAdapter.createWiViewHolder$lambda$1(viewGroup, inflate);
            }
        });
        return new DonateDefaultViewHolder(this, inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createWiViewHolder$lambda$1(ViewGroup viewGroup, DonateDefaultItemBinding donateDefaultItemBinding) {
        int dimensionPixelSize = viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen._140sdp);
        ViewGroup.LayoutParams layoutParams = donateDefaultItemBinding.getRoot().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = viewGroup.getMeasuredWidth() / 4;
        marginLayoutParams.height = dimensionPixelSize;
        donateDefaultItemBinding.getRoot().setLayoutParams(marginLayoutParams);
    }

    private final DonatePosterViewHolder createPosterViewHolder(final ViewGroup viewGroup) {
        final DonatePosterItemBinding inflate = DonatePosterItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        viewGroup.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DonateAdapter.createPosterViewHolder$lambda$2(viewGroup, inflate);
            }
        });
        return new DonatePosterViewHolder(this, inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createPosterViewHolder$lambda$2(ViewGroup viewGroup, DonatePosterItemBinding donatePosterItemBinding) {
        ViewGroup.LayoutParams layoutParams = donatePosterItemBinding.getRoot().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = viewGroup.getMeasuredWidth() / 2;
        donatePosterItemBinding.getRoot().setLayoutParams(marginLayoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DonateDefaultViewHolder) {
            DonateDefaultViewHolder donateDefaultViewHolder = (DonateDefaultViewHolder) holder;
            CardView cardContainer = donateDefaultViewHolder.getBinding().cardContainer;
            Intrinsics.checkNotNullExpressionValue(cardContainer, "cardContainer");
            cardContainer.setVisibility(8);
            DonateItemModelUi donateItemModelUi = getCurrentList().get(i);
            Intrinsics.checkNotNullExpressionValue(donateItemModelUi, "get(...)");
            donateDefaultViewHolder.onBind(donateItemModelUi, i);
        } else if (holder instanceof DonatePosterViewHolder) {
            DonatePosterViewHolder donatePosterViewHolder = (DonatePosterViewHolder) holder;
            CardView cardContainer2 = donatePosterViewHolder.getBinding().cardContainer;
            Intrinsics.checkNotNullExpressionValue(cardContainer2, "cardContainer");
            cardContainer2.setVisibility(8);
            DonateItemModelUi donateItemModelUi2 = getCurrentList().get(i);
            Intrinsics.checkNotNullExpressionValue(donateItemModelUi2, "get(...)");
            donatePosterViewHolder.onBind(donateItemModelUi2, i);
        }
        if (i + 1 == getCurrentList().size()) {
            this.lastItemBind.invoke();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[getCurrentList().get(i).getItemType().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return DonateItemType.RATE.getType();
                }
                return DonateItemType.BIG.getType();
            }
            return DonateItemType.WI.getType();
        }
        return DonateItemType.DEFAULT.getType();
    }

    /* compiled from: DonateAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$DonateDefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonateDefaultItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;Lru/mrlargha/commonui/databinding/DonateDefaultItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateDefaultItemBinding;", "badgesAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "position", "", "initItem", "initTitle", "setImageInfo", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;)Lkotlin/Unit;", "rvInit", "badges", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;", "setButtonTitle", "checkBlockType", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class DonateDefaultViewHolder extends RecyclerView.ViewHolder {
        private final DonateBadgesAdapter badgesAdapter;
        private final DonateDefaultItemBinding binding;
        final /* synthetic */ DonateAdapter this$0;

        /* compiled from: DonateAdapter.kt */
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
        public DonateDefaultViewHolder(DonateAdapter donateAdapter, DonateDefaultItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = donateAdapter;
            this.binding = binding;
            this.badgesAdapter = new DonateBadgesAdapter();
        }

        public final DonateDefaultItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(DonateItemModelUi model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            initItem(model);
            this.binding.getRoot().post(new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter$DonateDefaultViewHolder$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    DonateAdapter.DonateDefaultViewHolder.onBind$lambda$0(DonateAdapter.DonateDefaultViewHolder.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(DonateDefaultViewHolder donateDefaultViewHolder) {
            CardView cardContainer = donateDefaultViewHolder.binding.cardContainer;
            Intrinsics.checkNotNullExpressionValue(cardContainer, "cardContainer");
            cardContainer.setVisibility(0);
        }

        private final void initItem(final DonateItemModelUi donateItemModelUi) {
            DonateDefaultItemBinding donateDefaultItemBinding = this.binding;
            final DonateAdapter donateAdapter = this.this$0;
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
            donateDefaultItemBinding.btnBuy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter$DonateDefaultViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonateAdapter.DonateDefaultViewHolder.initItem$lambda$2$lambda$1(DonateItemModelUi.this, donateAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initItem$lambda$2$lambda$1(DonateItemModelUi donateItemModelUi, DonateAdapter donateAdapter, View view) {
            if (donateItemModelUi.getItemType() == DonateItemType.RATE) {
                donateAdapter.getOpenDialog().invoke();
            } else {
                donateAdapter.getOnClick().invoke(Integer.valueOf(donateItemModelUi.getId()));
            }
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

    /* compiled from: DonateAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$DonatePosterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonatePosterItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;Lru/mrlargha/commonui/databinding/DonatePosterItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonatePosterItemBinding;", "badgesAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBadgesAdapter;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "position", "", "initItem", "setImageInfo", "(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;)Lkotlin/Unit;", "rvInit", "badges", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModelUi;", "setButtonTitle", "checkBlockType", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class DonatePosterViewHolder extends RecyclerView.ViewHolder {
        private final DonateBadgesAdapter badgesAdapter;
        private final DonatePosterItemBinding binding;
        final /* synthetic */ DonateAdapter this$0;

        /* compiled from: DonateAdapter.kt */
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
        public DonatePosterViewHolder(DonateAdapter donateAdapter, DonatePosterItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = donateAdapter;
            this.binding = binding;
            this.badgesAdapter = new DonateBadgesAdapter();
        }

        public final DonatePosterItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(DonateItemModelUi model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            initItem(model);
            this.binding.getRoot().post(new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter$DonatePosterViewHolder$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    DonateAdapter.DonatePosterViewHolder.onBind$lambda$0(DonateAdapter.DonatePosterViewHolder.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(DonatePosterViewHolder donatePosterViewHolder) {
            CardView cardContainer = donatePosterViewHolder.binding.cardContainer;
            Intrinsics.checkNotNullExpressionValue(cardContainer, "cardContainer");
            cardContainer.setVisibility(0);
        }

        private final void initItem(final DonateItemModelUi donateItemModelUi) {
            DonatePosterItemBinding donatePosterItemBinding = this.binding;
            final DonateAdapter donateAdapter = this.this$0;
            ImageView ivItemBg = donatePosterItemBinding.ivItemBg;
            Intrinsics.checkNotNullExpressionValue(ivItemBg, "ivItemBg");
            DonateUtilsKt.setImageItemBgSdn(ivItemBg, donateItemModelUi.getBackground());
            if (donateItemModelUi.isGif()) {
                ImageView ivItem = donatePosterItemBinding.ivItem;
                Intrinsics.checkNotNullExpressionValue(ivItem, "ivItem");
                DonateUtilsKt.setGifSdn(ivItem, donateItemModelUi.getImage());
            } else {
                ImageView ivItem2 = donatePosterItemBinding.ivItem;
                Intrinsics.checkNotNullExpressionValue(ivItem2, "ivItem");
                DonateUtilsKt.setImageSdn(ivItem2, donateItemModelUi.getImage());
            }
            if (donateItemModelUi.getAnimation()) {
                ImageView animationThumb = donatePosterItemBinding.animationThumb;
                Intrinsics.checkNotNullExpressionValue(animationThumb, "animationThumb");
                animationThumb.setVisibility(0);
                Intrinsics.checkNotNull(Glide.with(donatePosterItemBinding.animationThumb).load(Integer.valueOf(R.raw.donate_item_animation)).into(donatePosterItemBinding.animationThumb));
            } else {
                ImageView animationThumb2 = donatePosterItemBinding.animationThumb;
                Intrinsics.checkNotNullExpressionValue(animationThumb2, "animationThumb");
                animationThumb2.setVisibility(8);
            }
            donatePosterItemBinding.tvSecondTitle.setColorList(DonateUtilsKt.convertColorList(donateItemModelUi.getTextGradientColor()));
            donatePosterItemBinding.tvFirstTitle.setText(DonateUtilsKt.splitOnPart(donateItemModelUi.getName()).getFirst());
            donatePosterItemBinding.tvSecondTitle.setText(DonateUtilsKt.splitOnPart(donateItemModelUi.getName()).getSecond());
            setImageInfo(donateItemModelUi);
            rvInit(donateItemModelUi.getBadges());
            setButtonTitle(donateItemModelUi);
            checkBlockType(donateItemModelUi);
            if (donateItemModelUi.getItemType() == DonateItemType.WI || donateItemModelUi.getItemType() == DonateItemType.RATE) {
                donatePosterItemBinding.ivItem.setBackground(null);
                if (!StringsKt.isBlank(donateItemModelUi.getEffectColor())) {
                    donatePosterItemBinding.cardContainer.setCardBackgroundColor(Color.parseColor(donateItemModelUi.getEffectColor()));
                }
            }
            donatePosterItemBinding.btnBuy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter$DonatePosterViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonateAdapter.DonatePosterViewHolder.initItem$lambda$2$lambda$1(DonateItemModelUi.this, donateAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initItem$lambda$2$lambda$1(DonateItemModelUi donateItemModelUi, DonateAdapter donateAdapter, View view) {
            Log.d(DonateUtilsKt.DONATE_TAG, donateItemModelUi.getItemType().toString());
            if (donateItemModelUi.getItemType() == DonateItemType.RATE) {
                donateAdapter.getOpenDialog().invoke();
            } else {
                donateAdapter.getOnClick().invoke(Integer.valueOf(donateItemModelUi.getId()));
            }
        }

        private final Unit setImageInfo(DonateItemModelUi donateItemModelUi) {
            DonatePosterItemBinding donatePosterItemBinding = this.binding;
            if (donateItemModelUi.getEffectColor().length() == 0) {
                donatePosterItemBinding.ivItem.setBackground(null);
                return Unit.INSTANCE;
            }
            Context context = donatePosterItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable itemEffectDrawable = DonateUtilsKt.getItemEffectDrawable(context, donateItemModelUi.getEffectColor());
            if (itemEffectDrawable != null) {
                donatePosterItemBinding.ivItem.setBackground(itemEffectDrawable);
                return Unit.INSTANCE;
            }
            return null;
        }

        private final void rvInit(List<DonateBadgesModelUi> list) {
            DonatePosterItemBinding donatePosterItemBinding = this.binding;
            donatePosterItemBinding.rvTags.setLayoutManager(new CustomGridLayoutManager());
            donatePosterItemBinding.rvTags.setAdapter(this.badgesAdapter);
            this.badgesAdapter.submitList(list);
        }

        private final void setButtonTitle(DonateItemModelUi donateItemModelUi) {
            DonatePosterItemBinding donatePosterItemBinding = this.binding;
            donatePosterItemBinding.tvOldPrice.setPaintFlags(16);
            Context context = donatePosterItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable buttonsGradientDrawable = DonateUtilsKt.getButtonsGradientDrawable(context, donateItemModelUi.getColorButton());
            if (buttonsGradientDrawable != null) {
                donatePosterItemBinding.btnBuy.setBackground(buttonsGradientDrawable);
            }
            donatePosterItemBinding.ivMoneyIc.setImageResource(donateItemModelUi.getCurrencyType().getIcon());
            ImageView ivMoneyIc = donatePosterItemBinding.ivMoneyIc;
            Intrinsics.checkNotNullExpressionValue(ivMoneyIc, "ivMoneyIc");
            ivMoneyIc.setVisibility(donateItemModelUi.getTitleButton().length() == 0 ? 0 : 8);
            donatePosterItemBinding.tvOldPrice.setText(donateItemModelUi.getButtonTitle().getFirst());
            donatePosterItemBinding.tvPrice.setText(donateItemModelUi.getButtonTitle().getSecond());
        }

        private final void checkBlockType(DonateItemModelUi donateItemModelUi) {
            DonatePosterItemBinding donatePosterItemBinding = this.binding;
            int i = WhenMappings.$EnumSwitchMapping$0[donateItemModelUi.m10603getBlockType().ordinal()];
            if (i == 1) {
                LinearLayout blockContainer = donatePosterItemBinding.blockContainer;
                Intrinsics.checkNotNullExpressionValue(blockContainer, "blockContainer");
                blockContainer.setVisibility(0);
                donatePosterItemBinding.tvBlockReason.setText(donateItemModelUi.getBlockTitle());
            } else if (i == 2) {
                LinearLayout blockContainer2 = donatePosterItemBinding.blockContainer;
                Intrinsics.checkNotNullExpressionValue(blockContainer2, "blockContainer");
                blockContainer2.setVisibility(0);
                donatePosterItemBinding.tvBlockReason.setText(donateItemModelUi.getBlockTitle());
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                LinearLayout blockContainer3 = donatePosterItemBinding.blockContainer;
                Intrinsics.checkNotNullExpressionValue(blockContainer3, "blockContainer");
                blockContainer3.setVisibility(8);
            }
        }
    }

    /* compiled from: DonateAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter$Companion$diffUtilCallback$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
