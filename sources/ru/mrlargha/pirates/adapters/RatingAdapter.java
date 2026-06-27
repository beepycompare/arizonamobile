package ru.mrlargha.pirates.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.event.data.RatingData;
import ru.mrlargha.feature.event.R;
import ru.mrlargha.feature.event.databinding.PiratesRatingItemBinding;
/* compiled from: RatingAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0014\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u0006\u0010\u0015\u001a\u00020\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/pirates/adapters/RatingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/pirates/adapters/RatingAdapter$PiratesRatingViewHolder;", "<init>", "()V", "itemsList", "", "Lru/mrlargha/event/data/RatingData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addAllItems", "items", "", "clearList", "PiratesRatingViewHolder", "event"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RatingAdapter extends RecyclerView.Adapter<PiratesRatingViewHolder> {
    private final List<RatingData> itemsList = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PiratesRatingViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.pirates_rating_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new PiratesRatingViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PiratesRatingViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        RatingData ratingData = (RatingData) CollectionsKt.getOrNull(this.itemsList, i);
        if (ratingData == null) {
            ratingData = (RatingData) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        PiratesRatingItemBinding binding = holder.getBinding();
        binding.nick.setText(ratingData.getName());
        binding.points.setText(String.valueOf(ratingData.getPoints()));
        binding.prize.setText(ratingData.getPrize());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<RatingData> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        this.itemsList.addAll(items);
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }

    /* compiled from: RatingAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/pirates/adapters/RatingAdapter$PiratesRatingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lru/mrlargha/pirates/adapters/RatingAdapter;Landroid/view/View;)V", "binding", "Lru/mrlargha/feature/event/databinding/PiratesRatingItemBinding;", "getBinding", "()Lru/mrlargha/feature/event/databinding/PiratesRatingItemBinding;", "event"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class PiratesRatingViewHolder extends RecyclerView.ViewHolder {
        private final PiratesRatingItemBinding binding;
        final /* synthetic */ RatingAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PiratesRatingViewHolder(RatingAdapter ratingAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = ratingAdapter;
            PiratesRatingItemBinding bind = PiratesRatingItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final PiratesRatingItemBinding getBinding() {
            return this.binding;
        }
    }
}
