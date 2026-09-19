package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DonatePayPassColumnBinding;
import ru.mrlargha.commonui.databinding.DonatePayPassMarkerBinding;
import ru.mrlargha.commonui.databinding.DonatePayPassPrizeBinding;
import ru.mrlargha.commonui.databinding.DonatePayPassTierBinding;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePayPassAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassPrize;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassReward;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassStateKt;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonatePayPassTierStatus;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.utils.PicassoLoadSafeKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: DonatePayPassAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dBQ\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassColumn;", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassAdapter$ColumnViewHolder;", "onClaimLevel", "Lkotlin/Function1;", "", "", "onShowTooltip", "Lkotlin/Function3;", "Landroid/view/View;", "", "onAnchorDetached", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "getItemId", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "onViewRecycled", "ColumnViewHolder", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassAdapter extends ListAdapter<DonatePayPassColumn, ColumnViewHolder> {
    public static final int AVAILABLE_BUTTON_BORDER = 1308622847;
    public static final int AVAILABLE_BUTTON_END = -3968512;
    public static final int AVAILABLE_BUTTON_START = -17664;
    public static final int AVAILABLE_CARD_END = -2131185151;
    public static final int AVAILABLE_CARD_START = Integer.MIN_VALUE;
    public static final Companion Companion = new Companion(null);
    private static final DonatePayPassAdapter$Companion$DIFF_CALLBACK$1 DIFF_CALLBACK = new DiffUtil.ItemCallback<DonatePayPassColumn>() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePayPassAdapter$Companion$DIFF_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(DonatePayPassColumn oldItem, DonatePayPassColumn newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getReward().getId() == newItem.getReward().getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(DonatePayPassColumn oldItem, DonatePayPassColumn newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public Object getChangePayload(DonatePayPassColumn oldItem, DonatePayPassColumn newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.getReward().getId() == newItem.getReward().getId() && Intrinsics.areEqual(oldItem.getReward().getPrizes(), newItem.getReward().getPrizes()) && Intrinsics.areEqual(oldItem.getReward().getPrice(), newItem.getReward().getPrice()) && oldItem.getReward().getLevel() == newItem.getReward().getLevel() && oldItem.isFirst() == newItem.isFirst() && oldItem.isLast() == newItem.isLast()) {
                return DonatePayPassAdapter.PAYLOAD_STATUS;
            }
            return null;
        }
    };
    public static final int GOLD = -16640;
    public static final int HEADER_DARK = -15921135;
    public static final int LOCKED_BUTTON = 452984831;
    public static final int LOCKED_CARD_END = 1384876939;
    public static final String PAYLOAD_STATUS = "paypass_status";
    public static final int RECEIVED_BUTTON = 864078929;
    private final Function1<View, Unit> onAnchorDetached;
    private final Function1<Integer, Unit> onClaimLevel;
    private final Function3<View, String, String, Unit> onShowTooltip;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((ColumnViewHolder) viewHolder, i, (List<Object>) list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DonatePayPassAdapter(Function1<? super Integer, Unit> function1, Function3<? super View, ? super String, ? super String, Unit> onShowTooltip, Function1<? super View, Unit> onAnchorDetached) {
        super(DIFF_CALLBACK);
        Intrinsics.checkNotNullParameter(onShowTooltip, "onShowTooltip");
        Intrinsics.checkNotNullParameter(onAnchorDetached, "onAnchorDetached");
        this.onClaimLevel = function1;
        this.onShowTooltip = onShowTooltip;
        this.onAnchorDetached = onAnchorDetached;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return getItem(i).getReward().getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ColumnViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DonatePayPassColumnBinding inflate = DonatePayPassColumnBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ColumnViewHolder(inflate, this.onClaimLevel, this.onShowTooltip, this.onAnchorDetached);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ColumnViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DonatePayPassColumn item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    public void onBindViewHolder(ColumnViewHolder holder, int i, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            DonatePayPassColumn item = getItem(i);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
            holder.bind(item);
            return;
        }
        List<Object> list = payloads;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Object obj : list) {
                if (!Intrinsics.areEqual(obj, PAYLOAD_STATUS)) {
                    DonatePayPassColumn item2 = getItem(i);
                    Intrinsics.checkNotNullExpressionValue(item2, "getItem(...)");
                    holder.bind(item2);
                    return;
                }
            }
        }
        DonatePayPassColumn item3 = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item3, "getItem(...)");
        holder.bindStatus(item3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(ColumnViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.recycle();
        super.onViewRecycled((DonatePayPassAdapter) holder);
    }

    /* compiled from: DonatePayPassAdapter.kt */
    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00062\b\b\u0002\u0010,\u001a\u00020'2\b\b\u0002\u0010-\u001a\u00020'H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u000204H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassAdapter$ColumnViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonatePayPassColumnBinding;", "onClaimLevel", "Lkotlin/Function1;", "", "", "onShowTooltip", "Lkotlin/Function3;", "Landroid/view/View;", "", "onAnchorDetached", "<init>", "(Lru/mrlargha/commonui/databinding/DonatePayPassColumnBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "inflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "cornerRadius", "", "prizeGap", "bind", "item", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassColumn;", "bindStatus", "recycle", "bindPrice", "bindClaim", "bindPrizes", "reward", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassReward;", "bindPrize", "prizeBinding", "Lru/mrlargha/commonui/databinding/DonatePayPassPrizeBinding;", "prize", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassPrize;", "bindTierVisuals", "applyMarker", "reached", "", "applyProgress", "progressFill", "Landroid/graphics/drawable/Drawable;", "color", "leftRound", "rightRound", "clearPrizeImages", "clearImage", "image", "Landroid/widget/ImageView;", "preferVerticalScroll", "scroll", "Landroidx/core/widget/NestedScrollView;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ColumnViewHolder extends RecyclerView.ViewHolder {
        private final DonatePayPassColumnBinding binding;
        private final float cornerRadius;
        private final LayoutInflater inflater;
        private final Function1<View, Unit> onAnchorDetached;
        private final Function1<Integer, Unit> onClaimLevel;
        private final Function3<View, String, String, Unit> onShowTooltip;
        private final int prizeGap;

        /* compiled from: DonatePayPassAdapter.kt */
        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DonatePayPassTierStatus.values().length];
                try {
                    iArr[DonatePayPassTierStatus.RECEIVED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DonatePayPassTierStatus.AVAILABLE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DonatePayPassTierStatus.LOCKED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ColumnViewHolder(DonatePayPassColumnBinding binding, Function1<? super Integer, Unit> function1, Function3<? super View, ? super String, ? super String, Unit> onShowTooltip, Function1<? super View, Unit> onAnchorDetached) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(onShowTooltip, "onShowTooltip");
            Intrinsics.checkNotNullParameter(onAnchorDetached, "onAnchorDetached");
            this.binding = binding;
            this.onClaimLevel = function1;
            this.onShowTooltip = onShowTooltip;
            this.onAnchorDetached = onAnchorDetached;
            this.inflater = LayoutInflater.from(binding.getRoot().getContext());
            this.cornerRadius = binding.getRoot().getResources().getDimension(R.dimen._16sdp);
            this.prizeGap = binding.getRoot().getResources().getDimensionPixelSize(R.dimen._5sdp);
            NestedScrollView paypassTierPrizesScroll = binding.paypassTier.paypassTierPrizesScroll;
            Intrinsics.checkNotNullExpressionValue(paypassTierPrizesScroll, "paypassTierPrizesScroll");
            preferVerticalScroll(paypassTierPrizesScroll);
        }

        public final void bind(DonatePayPassColumn item) {
            Intrinsics.checkNotNullParameter(item, "item");
            bindStatus(item);
            bindPrice(item);
            bindPrizes(item.getReward());
        }

        public final void bindStatus(DonatePayPassColumn item) {
            Intrinsics.checkNotNullParameter(item, "item");
            applyMarker(item.getMarkerReached());
            applyProgress(item);
            bindTierVisuals(item);
            bindClaim(item);
        }

        public final void recycle() {
            Function1<View, Unit> function1 = this.onAnchorDetached;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            function1.invoke(itemView);
            this.binding.paypassTier.paypassTierButton.setOnClickListener(null);
            LinearLayout paypassTierPrizes = this.binding.paypassTier.paypassTierPrizes;
            Intrinsics.checkNotNullExpressionValue(paypassTierPrizes, "paypassTierPrizes");
            int childCount = paypassTierPrizes.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = paypassTierPrizes.getChildAt(i);
                childAt.setOnClickListener(null);
                childAt.setOnLongClickListener(null);
            }
            clearPrizeImages();
        }

        private final void bindPrice(DonatePayPassColumn donatePayPassColumn) {
            DonatePayPassTierBinding paypassTier = this.binding.paypassTier;
            Intrinsics.checkNotNullExpressionValue(paypassTier, "paypassTier");
            Context context = this.itemView.getContext();
            paypassTier.getRoot().setContentDescription(context.getString(R.string.donate_paypass_level, Integer.valueOf(donatePayPassColumn.getReward().getLevel())));
            Integer price = donatePayPassColumn.getReward().getPrice();
            if (price != null) {
                String formatPayPassMoney = DonatePayPassStateKt.formatPayPassMoney(price.intValue());
                TextView paypassTierPrice = paypassTier.paypassTierPrice;
                Intrinsics.checkNotNullExpressionValue(paypassTierPrice, "paypassTierPrice");
                paypassTierPrice.setVisibility(0);
                paypassTier.paypassTierPrice.setText(formatPayPassMoney);
                paypassTier.paypassTierPrice.setContentDescription(context.getString(R.string.donate_paypass_level_threshold, formatPayPassMoney));
                return;
            }
            TextView paypassTierPrice2 = paypassTier.paypassTierPrice;
            Intrinsics.checkNotNullExpressionValue(paypassTierPrice2, "paypassTierPrice");
            paypassTierPrice2.setVisibility(8);
            paypassTier.paypassTierPrice.setContentDescription(null);
        }

        private final void bindClaim(DonatePayPassColumn donatePayPassColumn) {
            CustomCardView paypassTierButton = this.binding.paypassTier.paypassTierButton;
            Intrinsics.checkNotNullExpressionValue(paypassTierButton, "paypassTierButton");
            boolean z = (!donatePayPassColumn.getReward().getCanClaim() || donatePayPassColumn.getExpired() || donatePayPassColumn.getPending() || this.onClaimLevel == null) ? false : true;
            paypassTierButton.setEnabled(z);
            paypassTierButton.setClickable(z);
            paypassTierButton.setAlpha(donatePayPassColumn.getPending() ? 0.7f : 1.0f);
            if (z) {
                final int id = donatePayPassColumn.getReward().getId();
                paypassTierButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePayPassAdapter$ColumnViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DonatePayPassAdapter.ColumnViewHolder.bindClaim$lambda$0(DonatePayPassAdapter.ColumnViewHolder.this, id, view);
                    }
                });
                return;
            }
            paypassTierButton.setOnClickListener(null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void bindClaim$lambda$0(ColumnViewHolder columnViewHolder, int i, View view) {
            Function1<Integer, Unit> function1 = columnViewHolder.onClaimLevel;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i));
            }
        }

        private final void bindPrizes(DonatePayPassReward donatePayPassReward) {
            LinearLayout paypassTierPrizes = this.binding.paypassTier.paypassTierPrizes;
            Intrinsics.checkNotNullExpressionValue(paypassTierPrizes, "paypassTierPrizes");
            clearPrizeImages();
            paypassTierPrizes.removeAllViews();
            this.binding.paypassTier.paypassTierPrizesScroll.scrollTo(0, 0);
            int i = 0;
            for (Object obj : donatePayPassReward.getPrizes()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                DonatePayPassPrizeBinding inflate = DonatePayPassPrizeBinding.inflate(this.inflater, paypassTierPrizes, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                bindPrize(inflate, (DonatePayPassPrize) obj);
                if (i != CollectionsKt.getLastIndex(donatePayPassReward.getPrizes())) {
                    ViewGroup.LayoutParams layoutParams = inflate.getRoot().getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.prizeGap;
                }
                paypassTierPrizes.addView(inflate.getRoot());
                i = i2;
            }
        }

        private final void bindPrize(final DonatePayPassPrizeBinding donatePayPassPrizeBinding, DonatePayPassPrize donatePayPassPrize) {
            TextView paypassPrizeCount = donatePayPassPrizeBinding.paypassPrizeCount;
            Intrinsics.checkNotNullExpressionValue(paypassPrizeCount, "paypassPrizeCount");
            paypassPrizeCount.setVisibility((donatePayPassPrize.getCount() > 0L ? 1 : (donatePayPassPrize.getCount() == 0L ? 0 : -1)) <= 0 ? 8 : 0);
            if (donatePayPassPrize.getCount() > 0) {
                donatePayPassPrizeBinding.paypassPrizeCount.setText(DonateUtilsKt.formatWithSpaces(donatePayPassPrize.getCount()));
            }
            String title = donatePayPassPrize.getTitle();
            if (StringsKt.isBlank(title)) {
                title = donatePayPassPrize.getDescription();
            }
            donatePayPassPrizeBinding.getRoot().setContentDescription(title);
            ImageView paypassPrizeImage = donatePayPassPrizeBinding.paypassPrizeImage;
            Intrinsics.checkNotNullExpressionValue(paypassPrizeImage, "paypassPrizeImage");
            clearImage(paypassPrizeImage);
            if (donatePayPassPrize.getCanLoadHttpsImage()) {
                Picasso picasso = Picasso.get();
                Intrinsics.checkNotNullExpressionValue(picasso, "get(...)");
                PicassoLoadSafeKt.loadSafe(picasso, donatePayPassPrize.getImage()).error(R.drawable.image_placeholder).into(paypassPrizeImage);
            } else if (donatePayPassPrize.getCanLoadCatalogImage()) {
                if (donatePayPassPrize.isGif()) {
                    DonateUtilsKt.setGifSdn(paypassPrizeImage, donatePayPassPrize.getImageId());
                } else {
                    DonateUtilsKt.setImageSdn(paypassPrizeImage, donatePayPassPrize.getImageId());
                }
            } else {
                paypassPrizeImage.setImageResource(R.drawable.image_placeholder);
            }
            final String title2 = donatePayPassPrize.getTitle();
            final String description = donatePayPassPrize.getDescription();
            if (StringsKt.isBlank(title2) && StringsKt.isBlank(description)) {
                donatePayPassPrizeBinding.getRoot().setOnClickListener(null);
                donatePayPassPrizeBinding.getRoot().setOnLongClickListener(null);
                return;
            }
            donatePayPassPrizeBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePayPassAdapter$ColumnViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonatePayPassAdapter.ColumnViewHolder.bindPrize$lambda$1(DonatePayPassAdapter.ColumnViewHolder.this, donatePayPassPrizeBinding, title2, description, view);
                }
            });
            donatePayPassPrizeBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePayPassAdapter$ColumnViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return DonatePayPassAdapter.ColumnViewHolder.bindPrize$lambda$2(DonatePayPassAdapter.ColumnViewHolder.this, donatePayPassPrizeBinding, title2, description, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void bindPrize$lambda$1(ColumnViewHolder columnViewHolder, DonatePayPassPrizeBinding donatePayPassPrizeBinding, String str, String str2, View view) {
            Function3<View, String, String, Unit> function3 = columnViewHolder.onShowTooltip;
            CustomCardView root = donatePayPassPrizeBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            function3.invoke(root, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean bindPrize$lambda$2(ColumnViewHolder columnViewHolder, DonatePayPassPrizeBinding donatePayPassPrizeBinding, String str, String str2, View view) {
            Function3<View, String, String, Unit> function3 = columnViewHolder.onShowTooltip;
            CustomCardView root = donatePayPassPrizeBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            function3.invoke(root, str, str2);
            return true;
        }

        private final void bindTierVisuals(DonatePayPassColumn donatePayPassColumn) {
            DonatePayPassTierBinding paypassTier = this.binding.paypassTier;
            Intrinsics.checkNotNullExpressionValue(paypassTier, "paypassTier");
            DonatePayPassTierStatus status = donatePayPassColumn.getReward().getStatus();
            int i = status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            if (i != -1) {
                if (i == 1) {
                    paypassTier.paypassTierCard.setBackground(DonatePayPassAdapter.HEADER_DARK);
                    paypassTier.paypassTierCard.setBorder(0);
                    paypassTier.paypassTierButton.setBackground(DonatePayPassAdapter.RECEIVED_BUTTON);
                    paypassTier.paypassTierButton.setBorder(0);
                    ImageView paypassTierButtonIcon = paypassTier.paypassTierButtonIcon;
                    Intrinsics.checkNotNullExpressionValue(paypassTierButtonIcon, "paypassTierButtonIcon");
                    paypassTierButtonIcon.setVisibility(0);
                    paypassTier.paypassTierButtonIcon.setImageResource(R.drawable.donate_paypass_ic_check_green);
                    paypassTier.paypassTierButtonText.setText(R.string.donate_paypass_status_received);
                    return;
                } else if (i == 2) {
                    CustomCardView paypassTierCard = paypassTier.paypassTierCard;
                    Intrinsics.checkNotNullExpressionValue(paypassTierCard, "paypassTierCard");
                    CustomCardView.setBackground$default(paypassTierCard, Integer.MIN_VALUE, DonatePayPassAdapter.AVAILABLE_CARD_END, 25, null, 8, null);
                    paypassTier.paypassTierCard.setBorder(-16640);
                    CustomCardView paypassTierButton = paypassTier.paypassTierButton;
                    Intrinsics.checkNotNullExpressionValue(paypassTierButton, "paypassTierButton");
                    CustomCardView.setBackground$default(paypassTierButton, DonatePayPassAdapter.AVAILABLE_BUTTON_START, DonatePayPassAdapter.AVAILABLE_BUTTON_END, 224, null, 8, null);
                    paypassTier.paypassTierButton.setBorder(DonatePayPassAdapter.AVAILABLE_BUTTON_BORDER);
                    ImageView paypassTierButtonIcon2 = paypassTier.paypassTierButtonIcon;
                    Intrinsics.checkNotNullExpressionValue(paypassTierButtonIcon2, "paypassTierButtonIcon");
                    paypassTierButtonIcon2.setVisibility(8);
                    paypassTier.paypassTierButtonText.setText(donatePayPassColumn.getPending() ? R.string.donate_paypass_status_pending : R.string.donate_paypass_status_available);
                    return;
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            CustomCardView paypassTierCard2 = paypassTier.paypassTierCard;
            Intrinsics.checkNotNullExpressionValue(paypassTierCard2, "paypassTierCard");
            CustomCardView.setBackground$default(paypassTierCard2, DonatePayPassAdapter.HEADER_DARK, DonatePayPassAdapter.LOCKED_CARD_END, 233, null, 8, null);
            paypassTier.paypassTierCard.setBorder(0);
            paypassTier.paypassTierButton.setBackground(DonatePayPassAdapter.LOCKED_BUTTON);
            paypassTier.paypassTierButton.setBorder(0);
            ImageView paypassTierButtonIcon3 = paypassTier.paypassTierButtonIcon;
            Intrinsics.checkNotNullExpressionValue(paypassTierButtonIcon3, "paypassTierButtonIcon");
            paypassTierButtonIcon3.setVisibility(0);
            paypassTier.paypassTierButtonIcon.setImageResource(R.drawable.donate_paypass_ic_lock_button);
            paypassTier.paypassTierButtonText.setText(R.string.donate_paypass_status_locked);
        }

        private final void applyMarker(boolean z) {
            DonatePayPassMarkerBinding paypassMarker = this.binding.paypassMarker;
            Intrinsics.checkNotNullExpressionValue(paypassMarker, "paypassMarker");
            if (z) {
                paypassMarker.paypassMarkerChip.setBackground(-16640);
                paypassMarker.paypassMarkerIcon.setImageResource(R.drawable.donate_paypass_ic_check);
                return;
            }
            paypassMarker.paypassMarkerChip.setBackground(-16777216);
            paypassMarker.paypassMarkerIcon.setImageResource(R.drawable.donate_paypass_ic_lock);
        }

        private final void applyProgress(DonatePayPassColumn donatePayPassColumn) {
            boolean z = donatePayPassColumn.getFill() == DonatePayPassProgressFill.FULL || donatePayPassColumn.getFill() == DonatePayPassProgressFill.TO_CENTER;
            boolean z2 = donatePayPassColumn.getFill() == DonatePayPassProgressFill.FULL;
            this.binding.paypassProgressBefore.setBackground(progressFill$default(this, z ? -16640 : -16777216, donatePayPassColumn.isFirst(), false, 4, null));
            this.binding.paypassProgressAfter.setBackground(progressFill$default(this, z2 ? -16640 : -16777216, false, donatePayPassColumn.isLast(), 2, null));
            this.binding.paypassProgressGap.setBackground(progressFill$default(this, z2 ? -16640 : -16777216, false, false, 6, null));
            View paypassProgressGap = this.binding.paypassProgressGap;
            Intrinsics.checkNotNullExpressionValue(paypassProgressGap, "paypassProgressGap");
            paypassProgressGap.setVisibility(donatePayPassColumn.isLast() ? 8 : 0);
        }

        static /* synthetic */ Drawable progressFill$default(ColumnViewHolder columnViewHolder, int i, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            if ((i2 & 4) != 0) {
                z2 = false;
            }
            return columnViewHolder.progressFill(i, z, z2);
        }

        private final Drawable progressFill(int i, boolean z, boolean z2) {
            if (!z && !z2) {
                return new ColorDrawable(i);
            }
            float f = this.cornerRadius;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            float f2 = z ? f : 0.0f;
            float f3 = z ? f : 0.0f;
            float f4 = z2 ? f : 0.0f;
            float f5 = z2 ? f : 0.0f;
            float f6 = z2 ? f : 0.0f;
            float f7 = z2 ? f : 0.0f;
            float f8 = z ? f : 0.0f;
            if (!z) {
                f = 0.0f;
            }
            gradientDrawable.setCornerRadii(new float[]{f2, f3, f4, f5, f6, f7, f8, f});
            return gradientDrawable;
        }

        private final void clearPrizeImages() {
            LinearLayout paypassTierPrizes = this.binding.paypassTier.paypassTierPrizes;
            Intrinsics.checkNotNullExpressionValue(paypassTierPrizes, "paypassTierPrizes");
            int childCount = paypassTierPrizes.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ImageView imageView = (ImageView) paypassTierPrizes.getChildAt(i).findViewById(R.id.paypass_prize_image);
                if (imageView != null) {
                    clearImage(imageView);
                }
            }
        }

        private final void clearImage(ImageView imageView) {
            Picasso.get().cancelRequest(imageView);
            try {
                Glide.with(imageView).clear(imageView);
            } catch (Exception unused) {
            }
            imageView.setImageDrawable(null);
        }

        private final void preferVerticalScroll(NestedScrollView nestedScrollView) {
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            final int scaledTouchSlop = ViewConfiguration.get(nestedScrollView.getContext()).getScaledTouchSlop();
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePayPassAdapter$ColumnViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return DonatePayPassAdapter.ColumnViewHolder.preferVerticalScroll$lambda$0(Ref.FloatRef.this, floatRef2, scaledTouchSlop, view, motionEvent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
            if (r0 != 3) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final boolean preferVerticalScroll$lambda$0(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, int i, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                floatRef.element = motionEvent.getX();
                floatRef2.element = motionEvent.getY();
                view.getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        float abs = Math.abs(motionEvent.getX() - floatRef.element);
                        float abs2 = Math.abs(motionEvent.getY() - floatRef2.element);
                        float f = i;
                        if (abs > f || abs2 > f) {
                            view.getParent().requestDisallowInterceptTouchEvent(abs2 > abs);
                        }
                    }
                }
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    }

    /* compiled from: DonatePayPassAdapter.kt */
    @Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\b\u0003*\u0001\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassAdapter$Companion;", "", "<init>", "()V", "PAYLOAD_STATUS", "", "GOLD", "", "HEADER_DARK", "AVAILABLE_CARD_START", "AVAILABLE_CARD_END", "AVAILABLE_BUTTON_START", "AVAILABLE_BUTTON_END", "AVAILABLE_BUTTON_BORDER", "LOCKED_CARD_END", "LOCKED_BUTTON", "RECEIVED_BUTTON", "DIFF_CALLBACK", "ru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassAdapter$Companion$DIFF_CALLBACK$1", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePayPassAdapter$Companion$DIFF_CALLBACK$1;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
