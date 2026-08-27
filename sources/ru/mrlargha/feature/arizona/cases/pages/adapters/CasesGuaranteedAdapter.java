package ru.mrlargha.feature.arizona.cases.pages.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.arizona.cases.CasesGuaranteedPrizeModel;
import ru.mrlargha.feature.arizona.cases.CasesResponseKt;
import ru.mrlargha.feature.arizona.cases.R;
import ru.mrlargha.feature.arizona.cases.databinding.ArizonaCasesGuaranteedPrizeItemBinding;
/* compiled from: CasesGuaranteedAdapter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u001c\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\t2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesGuaranteedAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesGuaranteedAdapter$GuaranteedViewHolder;", "<init>", "()V", "progress", "", "setProgress", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "GuaranteedViewHolder", "DiffUtilCallback", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesGuaranteedAdapter extends ListAdapter<CasesGuaranteedPrizeModel, GuaranteedViewHolder> {
    private int progress;

    /* compiled from: CasesGuaranteedAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesGuaranteedAdapter$DiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class DiffUtilCallback extends DiffUtil.ItemCallback<CasesGuaranteedPrizeModel> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CasesGuaranteedPrizeModel oldItem, CasesGuaranteedPrizeModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CasesGuaranteedPrizeModel oldItem, CasesGuaranteedPrizeModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }
    }

    public CasesGuaranteedAdapter() {
        super(new DiffUtilCallback());
    }

    /* compiled from: CasesGuaranteedAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesGuaranteedAdapter$GuaranteedViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesGuaranteedPrizeItemBinding;", "<init>", "(Lru/mrlargha/feature/arizona/cases/pages/adapters/CasesGuaranteedAdapter;Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesGuaranteedPrizeItemBinding;)V", "getBinding", "()Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesGuaranteedPrizeItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "initialize", "setupListeners", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class GuaranteedViewHolder extends RecyclerView.ViewHolder {
        private final ArizonaCasesGuaranteedPrizeItemBinding binding;
        final /* synthetic */ CasesGuaranteedAdapter this$0;

        private final void setupListeners() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuaranteedViewHolder(CasesGuaranteedAdapter casesGuaranteedAdapter, ArizonaCasesGuaranteedPrizeItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = casesGuaranteedAdapter;
            this.binding = binding;
        }

        public final ArizonaCasesGuaranteedPrizeItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(CasesGuaranteedPrizeModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            initialize(model);
            setupListeners();
        }

        private final void initialize(CasesGuaranteedPrizeModel casesGuaranteedPrizeModel) {
            Object obj;
            ArizonaCasesGuaranteedPrizeItemBinding arizonaCasesGuaranteedPrizeItemBinding = this.binding;
            CasesGuaranteedAdapter casesGuaranteedAdapter = this.this$0;
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
                if (casesGuaranteedPrizeModel.getCustom_image() != null) {
                    ImageView ivPrize = arizonaCasesGuaranteedPrizeItemBinding.ivPrize;
                    Intrinsics.checkNotNullExpressionValue(ivPrize, "ivPrize");
                    CasesResponseKt.getCaseImageUrl(ivPrize, casesGuaranteedPrizeModel.getCustom_image() + ".webp");
                } else {
                    ImageView ivPrize2 = arizonaCasesGuaranteedPrizeItemBinding.ivPrize;
                    Intrinsics.checkNotNullExpressionValue(ivPrize2, "ivPrize");
                    CasesResponseKt.getCaseImageUrl(ivPrize2, itemsInfo.getIcon());
                }
                TextView textView = arizonaCasesGuaranteedPrizeItemBinding.tvPrizeName;
                String name = itemsInfo.getName();
                textView.setText(name + " " + casesGuaranteedPrizeModel.m11918getCount());
                arizonaCasesGuaranteedPrizeItemBinding.tvItemCount.setText(casesGuaranteedPrizeModel.getGaranteX());
                if (casesGuaranteedAdapter.progress >= casesGuaranteedPrizeModel.getGarante()) {
                    arizonaCasesGuaranteedPrizeItemBinding.progressBar.setVisibility(8);
                    arizonaCasesGuaranteedPrizeItemBinding.doneIc.setVisibility(0);
                } else {
                    arizonaCasesGuaranteedPrizeItemBinding.doneIc.setVisibility(8);
                    arizonaCasesGuaranteedPrizeItemBinding.progressBar.setVisibility(0);
                    arizonaCasesGuaranteedPrizeItemBinding.progressBar.setPercentWidth(casesGuaranteedAdapter.progress / casesGuaranteedPrizeModel.getGarante());
                }
            }
            if (getPosition() == 0) {
                arizonaCasesGuaranteedPrizeItemBinding.getRoot().setBackgroundResource(R.drawable.arizona_cases_prize_select_item_bg_image);
                arizonaCasesGuaranteedPrizeItemBinding.progressBar.setBackground(Color.parseColor("#FFC919"));
                return;
            }
            arizonaCasesGuaranteedPrizeItemBinding.getRoot().setBackgroundResource(R.drawable.arizona_cases_prize_item_bg);
            arizonaCasesGuaranteedPrizeItemBinding.progressBar.setBackground(Color.parseColor("#626262"));
        }
    }

    public final void setProgress(int i) {
        this.progress = i;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GuaranteedViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ArizonaCasesGuaranteedPrizeItemBinding inflate = ArizonaCasesGuaranteedPrizeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new GuaranteedViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GuaranteedViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CasesGuaranteedPrizeModel casesGuaranteedPrizeModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(casesGuaranteedPrizeModel, "get(...)");
        holder.onBind(casesGuaranteedPrizeModel);
    }
}
