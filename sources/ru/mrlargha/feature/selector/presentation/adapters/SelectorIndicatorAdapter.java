package ru.mrlargha.feature.selector.presentation.adapters;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.selector.databinding.SelectorIndicatorItemBinding;
/* compiled from: SelectorIndicatorAdapter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R$\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/mrlargha/feature/selector/presentation/adapters/SelectorIndicatorAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Lru/mrlargha/feature/selector/presentation/adapters/SelectorIndicatorAdapter$SelectorIndicatorViewHolder;", "<init>", "()V", "value", "selectedId", "getSelectedId", "()I", "setSelectedId", "(I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "SelectorIndicatorViewHolder", "Companion", "selector"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectorIndicatorAdapter extends ListAdapter<Integer, SelectorIndicatorViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final SelectorIndicatorAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<Integer>() { // from class: ru.mrlargha.feature.selector.presentation.adapters.SelectorIndicatorAdapter$Companion$diffUtilCallback$1
        public boolean areContentsTheSame(int i, int i2) {
            return i == i2;
        }

        public boolean areItemsTheSame(int i, int i2) {
            return i == i2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* bridge */ /* synthetic */ boolean areContentsTheSame(Integer num, Integer num2) {
            return areContentsTheSame(num.intValue(), num2.intValue());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* bridge */ /* synthetic */ boolean areItemsTheSame(Integer num, Integer num2) {
            return areItemsTheSame(num.intValue(), num2.intValue());
        }
    };
    private int selectedId;

    public SelectorIndicatorAdapter() {
        super(diffUtilCallback);
        this.selectedId = -1;
    }

    public final int getSelectedId() {
        return this.selectedId;
    }

    public final void setSelectedId(int i) {
        Log.d("selector", "currentId: " + i + " maxSize: " + getCurrentList().size());
        notifyItemChanged(this.selectedId);
        this.selectedId = i;
        notifyItemChanged(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelectorIndicatorViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SelectorIndicatorItemBinding inflate = SelectorIndicatorItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SelectorIndicatorViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SelectorIndicatorViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer num = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        holder.onBind(num.intValue());
    }

    /* compiled from: SelectorIndicatorAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/selector/presentation/adapters/SelectorIndicatorAdapter$SelectorIndicatorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/selector/databinding/SelectorIndicatorItemBinding;", "<init>", "(Lru/mrlargha/feature/selector/presentation/adapters/SelectorIndicatorAdapter;Lru/mrlargha/feature/selector/databinding/SelectorIndicatorItemBinding;)V", "getBinding", "()Lru/mrlargha/feature/selector/databinding/SelectorIndicatorItemBinding;", "onBind", "", "currentId", "", "selector"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class SelectorIndicatorViewHolder extends RecyclerView.ViewHolder {
        private final SelectorIndicatorItemBinding binding;
        final /* synthetic */ SelectorIndicatorAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectorIndicatorViewHolder(SelectorIndicatorAdapter selectorIndicatorAdapter, SelectorIndicatorItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = selectorIndicatorAdapter;
            this.binding = binding;
        }

        public final SelectorIndicatorItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(int i) {
            SelectorIndicatorItemBinding selectorIndicatorItemBinding = this.binding;
            if (i == this.this$0.getSelectedId()) {
                selectorIndicatorItemBinding.indicator.setBackground(Color.parseColor("#B2FFFFFF"));
            } else {
                selectorIndicatorItemBinding.indicator.setBackground(Color.parseColor("#33FFFFFF"));
            }
        }
    }

    /* compiled from: SelectorIndicatorAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/selector/presentation/adapters/SelectorIndicatorAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/feature/selector/presentation/adapters/SelectorIndicatorAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/feature/selector/presentation/adapters/SelectorIndicatorAdapter$Companion$diffUtilCallback$1;", "selector"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
