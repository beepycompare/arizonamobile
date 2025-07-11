package ru.mrlargha.commonui.elements.craft.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemMenuBtnBinding;
import ru.mrlargha.commonui.elements.craft.presentation.viewHolder.CraftMenuViewHolder;
/* compiled from: CraftMenuAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/craft/presentation/adapter/CraftMenuAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Lru/mrlargha/commonui/elements/craft/presentation/viewHolder/CraftMenuViewHolder;", "onItemClicked", "Lkotlin/Function2;", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "selectedItemPosition", "getSelectedItemPosition", "()I", "setSelectedItemPosition", "(I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CraftMenuAdapter extends ListAdapter<Integer, CraftMenuViewHolder> {
    private final Function2<Integer, Integer, Unit> onItemClicked;
    private int selectedItemPosition;
    public static final Companion Companion = new Companion(null);
    private static final CraftMenuAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<Integer>() { // from class: ru.mrlargha.commonui.elements.craft.presentation.adapter.CraftMenuAdapter$Companion$COMPARATOR$1
        public boolean areContentsTheSame(int i, int i2) {
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

        public boolean areItemsTheSame(int i, int i2) {
            return Integer.hashCode(i) == Integer.hashCode(i2);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CraftMenuAdapter(Function2<? super Integer, ? super Integer, Unit> onItemClicked) {
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
    public CraftMenuViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemMenuBtnBinding inflate = ItemMenuBtnBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new CraftMenuViewHolder(inflate, this.onItemClicked);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CraftMenuViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item.intValue(), i, this.selectedItemPosition);
    }

    /* compiled from: CraftMenuAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/craft/presentation/adapter/CraftMenuAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/commonui/elements/craft/presentation/adapter/CraftMenuAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/commonui/elements/craft/presentation/adapter/CraftMenuAdapter$Companion$COMPARATOR$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
