package ru.mrlargha.feature.selector.presentation.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.selector.databinding.SelectorAdditionalInfoItemBinding;
import ru.mrlargha.feature.selector.presentation.models.SelectorInfoModel;
/* compiled from: SelectorInfoAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/selector/presentation/adapters/SelectorInfoAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/selector/presentation/models/SelectorInfoModel;", "Lru/mrlargha/feature/selector/presentation/adapters/SelectorInfoAdapter$SelectorViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "SelectorViewHolder", "Companion", "selector"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectorInfoAdapter extends ListAdapter<SelectorInfoModel, SelectorViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final SelectorInfoAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<SelectorInfoModel>() { // from class: ru.mrlargha.feature.selector.presentation.adapters.SelectorInfoAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(SelectorInfoModel oldItem, SelectorInfoModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(SelectorInfoModel oldItem, SelectorInfoModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getTitle(), newItem.getTitle());
        }
    };

    public SelectorInfoAdapter() {
        super(diffUtilCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelectorViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SelectorAdditionalInfoItemBinding inflate = SelectorAdditionalInfoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SelectorViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SelectorViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SelectorInfoModel selectorInfoModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(selectorInfoModel, "get(...)");
        holder.onBind(selectorInfoModel, i);
    }

    /* compiled from: SelectorInfoAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lru/mrlargha/feature/selector/presentation/adapters/SelectorInfoAdapter$SelectorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/selector/databinding/SelectorAdditionalInfoItemBinding;", "<init>", "(Lru/mrlargha/feature/selector/presentation/adapters/SelectorInfoAdapter;Lru/mrlargha/feature/selector/databinding/SelectorAdditionalInfoItemBinding;)V", "getBinding", "()Lru/mrlargha/feature/selector/databinding/SelectorAdditionalInfoItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/feature/selector/presentation/models/SelectorInfoModel;", "position", "", "initialize", "checkIsLastItem", "selector"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class SelectorViewHolder extends RecyclerView.ViewHolder {
        private final SelectorAdditionalInfoItemBinding binding;
        final /* synthetic */ SelectorInfoAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectorViewHolder(SelectorInfoAdapter selectorInfoAdapter, SelectorAdditionalInfoItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = selectorInfoAdapter;
            this.binding = binding;
        }

        public final SelectorAdditionalInfoItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(SelectorInfoModel model, int i) {
            Intrinsics.checkNotNullParameter(model, "model");
            initialize(model);
            checkIsLastItem(i);
        }

        private final void initialize(SelectorInfoModel selectorInfoModel) {
            SelectorAdditionalInfoItemBinding selectorAdditionalInfoItemBinding = this.binding;
            selectorAdditionalInfoItemBinding.tvName.setText(selectorInfoModel.getTitle());
            selectorAdditionalInfoItemBinding.tvValue.setText(selectorInfoModel.getValue());
        }

        private final void checkIsLastItem(int i) {
            SelectorAdditionalInfoItemBinding selectorAdditionalInfoItemBinding = this.binding;
            SelectorInfoAdapter selectorInfoAdapter = this.this$0;
            ImageView line = selectorAdditionalInfoItemBinding.line;
            Intrinsics.checkNotNullExpressionValue(line, "line");
            line.setVisibility(i + 1 == selectorInfoAdapter.getCurrentList().size() ? 8 : 0);
        }
    }

    /* compiled from: SelectorInfoAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/selector/presentation/adapters/SelectorInfoAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/feature/selector/presentation/adapters/SelectorInfoAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/feature/selector/presentation/adapters/SelectorInfoAdapter$Companion$diffUtilCallback$1;", "selector"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
