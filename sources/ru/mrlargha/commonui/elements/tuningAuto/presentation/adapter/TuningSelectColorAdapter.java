package ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemTuningSelectColorBinding;
import ru.mrlargha.commonui.elements.tuningAuto.domain.SelectedColors;
/* compiled from: TuningSelectColorAdapter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/TuningSelectColorAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/tuningAuto/domain/SelectedColors;", "Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/TuningSelectColorViewHolder;", "onItemClicked", "Lkotlin/Function2;", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "selectedItemPosition", "getSelectedItemPosition", "()I", "setSelectedItemPosition", "(I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TuningSelectColorAdapter extends ListAdapter<SelectedColors, TuningSelectColorViewHolder> {
    private final Function2<SelectedColors, Integer, Unit> onItemClicked;
    private int selectedItemPosition;
    public static final Companion Companion = new Companion(null);
    private static final TuningSelectColorAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<SelectedColors>() { // from class: ru.mrlargha.commonui.elements.tuningAuto.presentation.adapter.TuningSelectColorAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(SelectedColors oldItem, SelectedColors newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getColor() == newItem.getColor();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(SelectedColors oldItem, SelectedColors newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TuningSelectColorAdapter(Function2<? super SelectedColors, ? super Integer, Unit> onItemClicked) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
        this.selectedItemPosition = -1;
    }

    public final int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    public final void setSelectedItemPosition(int i) {
        this.selectedItemPosition = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TuningSelectColorViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemTuningSelectColorBinding inflate = ItemTuningSelectColorBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new TuningSelectColorViewHolder(inflate, this.onItemClicked);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TuningSelectColorViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SelectedColors item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    /* compiled from: TuningSelectColorAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/TuningSelectColorAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/TuningSelectColorAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/commonui/elements/tuningAuto/presentation/adapter/TuningSelectColorAdapter$Companion$COMPARATOR$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
