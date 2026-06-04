package com.arizonagames.feature.minigames.fishing.backend;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import com.arizonagames.feature.minigames.fishing.backend.databinding.BackendGameItemBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FishingAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0006J\u0014\u0010\u0011\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/arizonagames/feature/minigames/fishing/backend/FishingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/minigames/fishing/backend/FishingAdapter$ViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "onBindViewHolder", "holder", "position", "clearList", "addItems", "infoList", "", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "fishing-backend"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FishingAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<Integer> itemsList;
    private final Function1<Integer, Unit> onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public FishingAdapter(Function1<? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.itemsList = new ArrayList();
    }

    public final List<Integer> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer num = (Integer) CollectionsKt.getOrNull(this.itemsList, i);
        if (num != null) {
            int intValue = num.intValue();
            BackendGameItemBinding binding = holder.getBinding();
            if (intValue == -1) {
                i2 = R.drawable.dig0;
            } else if (intValue == 0) {
                i2 = R.drawable.dig1;
            } else if (intValue == 1) {
                i2 = R.drawable.dig2;
            } else if (intValue == 2) {
                i2 = R.drawable.dig3;
            } else if (intValue == 3) {
                i2 = R.drawable.dig4;
            } else {
                i2 = R.drawable.dig0;
            }
            binding.itemImg.setImageResource(i2);
            EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
            ConstraintLayout fishingItem = binding.fishingItem;
            Intrinsics.checkNotNullExpressionValue(fishingItem, "fishingItem");
            EasyAnimation.animateClick$default(easyAnimation, fishingItem, 0L, new Function0() { // from class: com.arizonagames.feature.minigames.fishing.backend.FishingAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onBindViewHolder$lambda$0$0;
                    onBindViewHolder$lambda$0$0 = FishingAdapter.onBindViewHolder$lambda$0$0(FishingAdapter.this, i);
                    return onBindViewHolder$lambda$0$0;
                }
            }, null, 5, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$0(FishingAdapter fishingAdapter, int i) {
        fishingAdapter.onClick.invoke(Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }

    public final void addItems(List<Integer> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.itemsList.clear();
        this.itemsList.addAll(infoList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    /* compiled from: FishingAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/arizonagames/feature/minigames/fishing/backend/FishingAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/arizonagames/feature/minigames/fishing/backend/databinding/BackendGameItemBinding;", "Lcom/arizonagames/feature/minigames/fishing/backend/ItemBinding;", "<init>", "(Lcom/arizonagames/feature/minigames/fishing/backend/databinding/BackendGameItemBinding;)V", "getBinding", "()Lcom/arizonagames/feature/minigames/fishing/backend/databinding/BackendGameItemBinding;", "fishing-backend"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final BackendGameItemBinding binding;

        public final BackendGameItemBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(BackendGameItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BackendGameItemBinding inflate = BackendGameItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }
}
