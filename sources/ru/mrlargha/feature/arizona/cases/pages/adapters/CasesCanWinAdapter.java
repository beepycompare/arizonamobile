package ru.mrlargha.feature.arizona.cases.pages.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.arizona.cases.CasesGuaranteedPrizeModel;
import ru.mrlargha.feature.arizona.cases.CasesResponseKt;
import ru.mrlargha.feature.arizona.cases.databinding.CasesCanWinItemBinding;
import ru.mrlargha.feature.arizona.cases.pages.adapters.CasesCanWinAdapter;
/* compiled from: CasesCanWinAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B)\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesCanWinAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesCanWinAdapter$CanWinViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "onQuality", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "CanWinViewHolder", "DiffUtilCallback", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesCanWinAdapter extends ListAdapter<CasesGuaranteedPrizeModel, CanWinViewHolder> {
    private final Function1<Integer, Unit> onClick;
    private final Function0<Unit> onQuality;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CasesCanWinAdapter(Function1<? super Integer, Unit> onClick, Function0<Unit> onQuality) {
        super(new DiffUtilCallback());
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onQuality, "onQuality");
        this.onClick = onClick;
        this.onQuality = onQuality;
    }

    /* compiled from: CasesCanWinAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesCanWinAdapter$CanWinViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/arizona/cases/databinding/CasesCanWinItemBinding;", "<init>", "(Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesCanWinAdapter;Lru/mrlargha/feature/arizona/cases/databinding/CasesCanWinItemBinding;)V", "getBinding", "()Lru/mrlargha/feature/arizona/cases/databinding/CasesCanWinItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "initialize", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class CanWinViewHolder extends RecyclerView.ViewHolder {
        private final CasesCanWinItemBinding binding;
        final /* synthetic */ CasesCanWinAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CanWinViewHolder(CasesCanWinAdapter casesCanWinAdapter, CasesCanWinItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = casesCanWinAdapter;
            this.binding = binding;
        }

        public final CasesCanWinItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(CasesGuaranteedPrizeModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            initialize(model);
        }

        private final void initialize(final CasesGuaranteedPrizeModel casesGuaranteedPrizeModel) {
            Object obj;
            CasesCanWinItemBinding casesCanWinItemBinding = this.binding;
            final CasesCanWinAdapter casesCanWinAdapter = this.this$0;
            casesCanWinItemBinding.getRoot().setBackgroundResource(casesGuaranteedPrizeModel.getBgType().getResId());
            Iterator<T> it = UtilsKt.getItemsName().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ItemsInfo) obj).getId() == casesGuaranteedPrizeModel.getItem()) {
                    break;
                }
            }
            ItemsInfo itemsInfo = (ItemsInfo) obj;
            if (itemsInfo != null) {
                TextView textView = casesCanWinItemBinding.tvPrizeName;
                String name = itemsInfo.getName();
                textView.setText(name + "\n" + casesGuaranteedPrizeModel.m11346getCount());
                ImageView ivPrize = casesCanWinItemBinding.ivPrize;
                Intrinsics.checkNotNullExpressionValue(ivPrize, "ivPrize");
                CasesResponseKt.getCaseImageUrl(ivPrize, itemsInfo.getIcon());
            }
            Integer isVehicle = casesGuaranteedPrizeModel.isVehicle();
            if (isVehicle != null && isVehicle.intValue() == 1) {
                casesCanWinItemBinding.qualityButton1.setVisibility(0);
                casesCanWinItemBinding.qualityButton1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.adapters.CasesCanWinAdapter$CanWinViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CasesCanWinAdapter.CanWinViewHolder.initialize$lambda$0$2(CasesCanWinAdapter.this, view);
                    }
                });
            } else {
                casesCanWinItemBinding.qualityButton1.setVisibility(8);
            }
            casesCanWinItemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.pages.adapters.CasesCanWinAdapter$CanWinViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CasesCanWinAdapter.CanWinViewHolder.initialize$lambda$0$3(CasesCanWinAdapter.this, casesGuaranteedPrizeModel, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initialize$lambda$0$2(CasesCanWinAdapter casesCanWinAdapter, View view) {
            casesCanWinAdapter.onQuality.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initialize$lambda$0$3(CasesCanWinAdapter casesCanWinAdapter, CasesGuaranteedPrizeModel casesGuaranteedPrizeModel, View view) {
            casesCanWinAdapter.onClick.invoke(Integer.valueOf(casesGuaranteedPrizeModel.getItem()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CanWinViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CasesCanWinItemBinding inflate = CasesCanWinItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new CanWinViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CanWinViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CasesGuaranteedPrizeModel casesGuaranteedPrizeModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(casesGuaranteedPrizeModel, "get(...)");
        holder.onBind(casesGuaranteedPrizeModel);
    }

    /* compiled from: CasesCanWinAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesCanWinAdapter$DiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class DiffUtilCallback extends DiffUtil.ItemCallback<CasesGuaranteedPrizeModel> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CasesGuaranteedPrizeModel oldItem, CasesGuaranteedPrizeModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getItem() == newItem.getItem();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CasesGuaranteedPrizeModel oldItem, CasesGuaranteedPrizeModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
