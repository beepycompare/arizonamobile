package com.arizonagames.feature.arizona.bank.adapters;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.bank.BankTaxInfo;
import com.arizonagames.feature.arizona.bank.R;
import com.arizonagames.feature.arizona.bank.adapters.BankTaxesAdapter;
import com.arizonagames.feature.arizona.bank.databinding.BankTaxPayAllItemBinding;
import com.arizonagames.feature.arizona.bank.databinding.BankTaxTransportItemBinding;
import com.arizonagames.feature.arizona.bank.ui.BankClickAnimationKt;
import com.arizonagames.feature.arizona.bank.ui.BankImageLoaderKt;
import com.arizonagames.feature.arizona.bank.ui.BankUiFormatterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: BankTaxesAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B)\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u001c\u0010\u001d\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/adapters/BankTaxesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onTaxClick", "Lkotlin/Function1;", "", "", "onPayAllClick", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "items", "", "Lcom/arizonagames/feature/arizona/bank/BankTaxInfo;", "totalCost", "", "hasPayAllButton", "", "getHasPayAllButton", "()Z", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "submitList", "data", "getSpanSize", "isPayAllPosition", "Companion", "BankTaxViewHolder", "BankPayAllViewHolder", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankTaxesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final int PAY_ALL_SPAN_SIZE = 2;
    private static final int TAX_SPAN_SIZE = 1;
    private static final int VIEW_TYPE_PAY_ALL = 1;
    private static final int VIEW_TYPE_TAX = 0;
    private List<BankTaxInfo> items;
    private final Function0<Unit> onPayAllClick;
    private final Function1<Integer, Unit> onTaxClick;
    private long totalCost;

    /* JADX WARN: Multi-variable type inference failed */
    public BankTaxesAdapter(Function1<? super Integer, Unit> onTaxClick, Function0<Unit> onPayAllClick) {
        Intrinsics.checkNotNullParameter(onTaxClick, "onTaxClick");
        Intrinsics.checkNotNullParameter(onPayAllClick, "onPayAllClick");
        this.onTaxClick = onTaxClick;
        this.onPayAllClick = onPayAllClick;
        this.items = CollectionsKt.emptyList();
    }

    /* compiled from: BankTaxesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/adapters/BankTaxesAdapter$Companion;", "", "<init>", "()V", "VIEW_TYPE_TAX", "", "VIEW_TYPE_PAY_ALL", "TAX_SPAN_SIZE", "PAY_ALL_SPAN_SIZE", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean getHasPayAllButton() {
        return this.totalCost > 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (i == 1) {
            BankTaxPayAllItemBinding inflate = BankTaxPayAllItemBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new BankPayAllViewHolder(inflate);
        }
        BankTaxTransportItemBinding inflate2 = BankTaxTransportItemBinding.inflate(from, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new BankTaxViewHolder(inflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof BankTaxViewHolder) {
            ((BankTaxViewHolder) holder).bind(this.items.get(i), this.onTaxClick);
        } else if (holder instanceof BankPayAllViewHolder) {
            ((BankPayAllViewHolder) holder).bind(this.totalCost, this.onPayAllClick);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return isPayAllPosition(i) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size() + (getHasPayAllButton() ? 1 : 0);
    }

    public final void submitList(List<BankTaxInfo> data, long j) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.items = BankTaxesAdapterKt.sortedForDisplay(data);
        this.totalCost = j;
        notifyDataSetChanged();
    }

    public final int getSpanSize(int i) {
        return isPayAllPosition(i) ? 2 : 1;
    }

    private final boolean isPayAllPosition(int i) {
        return getHasPayAllButton() && i == this.items.size();
    }

    /* compiled from: BankTaxesAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/adapters/BankTaxesAdapter$BankTaxViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankTaxTransportItemBinding;", "<init>", "(Lcom/arizonagames/feature/arizona/bank/databinding/BankTaxTransportItemBinding;)V", "bind", "", "item", "Lcom/arizonagames/feature/arizona/bank/BankTaxInfo;", "onClick", "Lkotlin/Function1;", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BankTaxViewHolder extends RecyclerView.ViewHolder {
        private final BankTaxTransportItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BankTaxViewHolder(BankTaxTransportItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void bind(final BankTaxInfo item, final Function1<? super Integer, Unit> onClick) {
            String bankMoneyText;
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            BankTaxTransportItemBinding bankTaxTransportItemBinding = this.binding;
            bankTaxTransportItemBinding.bankTaxTransportTitle.setText(item.getTitle());
            TextView textView = bankTaxTransportItemBinding.bankTaxTransportPrice;
            String tag = item.getTag();
            if (tag != null) {
                if (!Boolean.valueOf(!StringsKt.isBlank(tag)).booleanValue()) {
                    tag = null;
                }
                if (tag != null) {
                    bankMoneyText = tag;
                    textView.setText(bankMoneyText);
                    ImageView bankTaxImage = bankTaxTransportItemBinding.bankTaxImage;
                    Intrinsics.checkNotNullExpressionValue(bankTaxImage, "bankTaxImage");
                    BankImageLoaderKt.loadBankImage$default(bankTaxImage, BankTaxesAdapterKt.resolveTaxImagePath(item), null, true, 2, null);
                    bankTaxTransportItemBinding.bankTaxTransportItem.setEnabled(!item.getDisabled());
                    bankTaxTransportItemBinding.bankTaxTransportContent.setAlpha(!item.getDisabled() ? 0.68f : 1.0f);
                    bankTaxTransportItemBinding.bankTaxTransportDisabledOverlay.setVisibility(!item.getDisabled() ? 0 : 8);
                    bankTaxTransportItemBinding.bankTaxTransportLock.setVisibility(item.getDisabled() ? 0 : 8);
                    FrameLayout bankTaxTransportItem = bankTaxTransportItemBinding.bankTaxTransportItem;
                    Intrinsics.checkNotNullExpressionValue(bankTaxTransportItem, "bankTaxTransportItem");
                    BankClickAnimationKt.setAnimatedClickListener(bankTaxTransportItem, null);
                    if (item.getDisabled()) {
                        FrameLayout bankTaxTransportItem2 = bankTaxTransportItemBinding.bankTaxTransportItem;
                        Intrinsics.checkNotNullExpressionValue(bankTaxTransportItem2, "bankTaxTransportItem");
                        BankClickAnimationKt.setAnimatedClickListener(bankTaxTransportItem2, new Function0() { // from class: com.arizonagames.feature.arizona.bank.adapters.BankTaxesAdapter$BankTaxViewHolder$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit bind$lambda$0$1;
                                bind$lambda$0$1 = BankTaxesAdapter.BankTaxViewHolder.bind$lambda$0$1(Function1.this, item);
                                return bind$lambda$0$1;
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            long tax = item.getTax();
            Context context = bankTaxTransportItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            bankMoneyText = BankUiFormatterKt.toBankMoneyText(tax, context);
            textView.setText(bankMoneyText);
            ImageView bankTaxImage2 = bankTaxTransportItemBinding.bankTaxImage;
            Intrinsics.checkNotNullExpressionValue(bankTaxImage2, "bankTaxImage");
            BankImageLoaderKt.loadBankImage$default(bankTaxImage2, BankTaxesAdapterKt.resolveTaxImagePath(item), null, true, 2, null);
            bankTaxTransportItemBinding.bankTaxTransportItem.setEnabled(!item.getDisabled());
            bankTaxTransportItemBinding.bankTaxTransportContent.setAlpha(!item.getDisabled() ? 0.68f : 1.0f);
            bankTaxTransportItemBinding.bankTaxTransportDisabledOverlay.setVisibility(!item.getDisabled() ? 0 : 8);
            bankTaxTransportItemBinding.bankTaxTransportLock.setVisibility(item.getDisabled() ? 0 : 8);
            FrameLayout bankTaxTransportItem3 = bankTaxTransportItemBinding.bankTaxTransportItem;
            Intrinsics.checkNotNullExpressionValue(bankTaxTransportItem3, "bankTaxTransportItem");
            BankClickAnimationKt.setAnimatedClickListener(bankTaxTransportItem3, null);
            if (item.getDisabled()) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$0$1(Function1 function1, BankTaxInfo bankTaxInfo) {
            function1.invoke(Integer.valueOf(bankTaxInfo.getId()));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: BankTaxesAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/adapters/BankTaxesAdapter$BankPayAllViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/arizonagames/feature/arizona/bank/databinding/BankTaxPayAllItemBinding;", "<init>", "(Lcom/arizonagames/feature/arizona/bank/databinding/BankTaxPayAllItemBinding;)V", "bind", "", "totalCost", "", "onClick", "Lkotlin/Function0;", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BankPayAllViewHolder extends RecyclerView.ViewHolder {
        private final BankTaxPayAllItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BankPayAllViewHolder(BankTaxPayAllItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final void bind(long j, final Function0<Unit> onClick) {
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            BankTaxPayAllItemBinding bankTaxPayAllItemBinding = this.binding;
            TextView textView = bankTaxPayAllItemBinding.bankTaxPayAllText;
            SpannableStringBuilder append = new SpannableStringBuilder(bankTaxPayAllItemBinding.getRoot().getContext().getString(R.string.bank_pay_all_taxes)).append((CharSequence) "  ");
            Context context = bankTaxPayAllItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(append.append(BankUiFormatterKt.toBankMoneyText(j, context)));
            CustomCardView bankTaxPayAllItem = bankTaxPayAllItemBinding.bankTaxPayAllItem;
            Intrinsics.checkNotNullExpressionValue(bankTaxPayAllItem, "bankTaxPayAllItem");
            BankClickAnimationKt.setAnimatedClickListener(bankTaxPayAllItem, new Function0() { // from class: com.arizonagames.feature.arizona.bank.adapters.BankTaxesAdapter$BankPayAllViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit bind$lambda$0$0;
                    bind$lambda$0$0 = BankTaxesAdapter.BankPayAllViewHolder.bind$lambda$0$0(Function0.this);
                    return bind$lambda$0$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit bind$lambda$0$0(Function0 function0) {
            function0.invoke();
            return Unit.INSTANCE;
        }
    }
}
