package ru.mrlargha.commonui.elements.donate.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.DonateDialogBonusItemBinding;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBonusModelUi;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* compiled from: DonateBonusAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u00142\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBonusAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBonusModelUi;", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBonusAdapter$DonateBonusViewHolder;", "<init>", "()V", "selectPosition", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "setInputMoney", "money", "", "DonateBonusViewHolder", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateBonusAdapter extends ListAdapter<DonateBonusModelUi, DonateBonusViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final DonateBonusAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<DonateBonusModelUi>() { // from class: ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBonusAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(DonateBonusModelUi oldItem, DonateBonusModelUi newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getFrom() == newItem.getFrom();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(DonateBonusModelUi oldItem, DonateBonusModelUi newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };
    private int selectPosition;

    public DonateBonusAdapter() {
        super(diffUtilCallback);
        this.selectPosition = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DonateBonusViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DonateDialogBonusItemBinding inflate = DonateDialogBonusItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        ViewGroup.LayoutParams layoutParams = inflate.getRoot().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = parent.getMeasuredWidth() / 3;
        inflate.getRoot().setLayoutParams(marginLayoutParams);
        return new DonateBonusViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DonateBonusViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        DonateBonusModelUi donateBonusModelUi = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(donateBonusModelUi, "get(...)");
        holder.onBind(donateBonusModelUi, i);
    }

    public final int setInputMoney(long j) {
        List<DonateBonusModelUi> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        for (Object obj : currentList) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DonateBonusModelUi donateBonusModelUi = (DonateBonusModelUi) obj;
            if (j >= donateBonusModelUi.getFrom()) {
                i2 = donateBonusModelUi.getPercent();
                i3 = i;
            }
            i = i4;
        }
        int i5 = this.selectPosition;
        if (i3 != i5) {
            this.selectPosition = i3;
            if (i5 != -1) {
                notifyItemChanged(i5);
            }
            if (i3 != -1) {
                notifyItemChanged(i3);
            }
        }
        return i2;
    }

    /* compiled from: DonateBonusAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBonusAdapter$DonateBonusViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/DonateDialogBonusItemBinding;", "<init>", "(Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBonusAdapter;Lru/mrlargha/commonui/databinding/DonateDialogBonusItemBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateDialogBonusItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBonusModelUi;", "position", "", "setDefaultItem", "setSelectItem", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class DonateBonusViewHolder extends RecyclerView.ViewHolder {
        private final DonateDialogBonusItemBinding binding;
        final /* synthetic */ DonateBonusAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DonateBonusViewHolder(DonateBonusAdapter donateBonusAdapter, DonateDialogBonusItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = donateBonusAdapter;
            this.binding = binding;
        }

        public final DonateDialogBonusItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(DonateBonusModelUi model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            DonateDialogBonusItemBinding donateDialogBonusItemBinding = this.binding;
            DonateBonusAdapter donateBonusAdapter = this.this$0;
            Context context = donateDialogBonusItemBinding.getRoot().getContext();
            donateDialogBonusItemBinding.tvFrom.setText(context.getString(R.string.from_rub, Integer.valueOf(model.getFrom())));
            donateDialogBonusItemBinding.tvPercent.setText(context.getString(R.string.plus_percent, Integer.valueOf(model.getPercent())));
            if (donateBonusAdapter.selectPosition == i) {
                setSelectItem();
            } else {
                setDefaultItem();
            }
        }

        private final void setDefaultItem() {
            DonateDialogBonusItemBinding donateDialogBonusItemBinding = this.binding;
            LinearLayout linearLayout = donateDialogBonusItemBinding.bonusContainer;
            Context context = donateDialogBonusItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            linearLayout.setBackground(DonateUtilsKt.getDialogItemDrawable(context, "#1AFFFFFF", "#0DFFFFFF", 1));
        }

        private final void setSelectItem() {
            DonateDialogBonusItemBinding donateDialogBonusItemBinding = this.binding;
            LinearLayout linearLayout = donateDialogBonusItemBinding.bonusContainer;
            Context context = donateDialogBonusItemBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            linearLayout.setBackground(DonateUtilsKt.getDialogItemDrawable(context, "#4DE8B11C", "#FED01A", 2));
        }
    }

    /* compiled from: DonateBonusAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBonusAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBonusAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateBonusAdapter$Companion$diffUtilCallback$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
