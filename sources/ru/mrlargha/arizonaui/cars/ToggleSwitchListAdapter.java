package ru.mrlargha.arizonaui.cars;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.cars.CarsScreen;
import ru.mrlargha.arizonaui.databinding.CarsSwitchableItemBinding;
/* compiled from: ToggleSwitchListAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/cars/ToggleSwitchListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$ToggleSwitchInfo;", "Lru/mrlargha/arizonaui/cars/ToggleSwitchListAdapter$ViewHolder;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "switchClickListener", "Lru/mrlargha/arizonaui/cars/ToggleSwitchListAdapter$OnSwitchClickListener;", "setOnSwitchClickListener", "", "onSwitchClickListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "OnSwitchClickListener", "Companion", "ViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ToggleSwitchListAdapter extends ListAdapter<CarsScreen.Companion.ToggleSwitchInfo, ViewHolder> {
    private final Activity activity;
    private OnSwitchClickListener switchClickListener;
    public static final Companion Companion = new Companion(null);
    private static final ToggleSwitchListAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<CarsScreen.Companion.ToggleSwitchInfo>() { // from class: ru.mrlargha.arizonaui.cars.ToggleSwitchListAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CarsScreen.Companion.ToggleSwitchInfo oldItem, CarsScreen.Companion.ToggleSwitchInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CarsScreen.Companion.ToggleSwitchInfo oldItem, CarsScreen.Companion.ToggleSwitchInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* compiled from: ToggleSwitchListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/cars/ToggleSwitchListAdapter$OnSwitchClickListener;", "", "onSwitchClickListener", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnSwitchClickListener {
        void onSwitchClickListener(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToggleSwitchListAdapter(Activity activity) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    public final void setOnSwitchClickListener(OnSwitchClickListener onSwitchClickListener) {
        Intrinsics.checkNotNullParameter(onSwitchClickListener, "onSwitchClickListener");
        this.switchClickListener = onSwitchClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_switchable_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final CarsSwitchableItemBinding binding = holder.getBinding();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        double d = 100;
        binding.carsSwitchableItem.getLayoutParams().width = (int) ((i2 * 11.97d) / d);
        binding.carsSwitchableItem.getLayoutParams().height = (int) ((i3 * 6.94d) / d);
        final CarsScreen.Companion.ToggleSwitchInfo item = getItem(i);
        binding.itemName.setText(item.getTitle());
        binding.carSwitch.setChecked(item.getValue() == 1);
        binding.carSwitch.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.cars.ToggleSwitchListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToggleSwitchListAdapter.onBindViewHolder$lambda$1$lambda$0(CarsSwitchableItemBinding.this, item, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(CarsSwitchableItemBinding carsSwitchableItemBinding, CarsScreen.Companion.ToggleSwitchInfo toggleSwitchInfo, ToggleSwitchListAdapter toggleSwitchListAdapter, View view) {
        carsSwitchableItemBinding.carSwitch.setChecked(toggleSwitchInfo.getValue() == 1);
        OnSwitchClickListener onSwitchClickListener = toggleSwitchListAdapter.switchClickListener;
        if (onSwitchClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchClickListener");
            onSwitchClickListener = null;
        }
        onSwitchClickListener.onSwitchClickListener(toggleSwitchInfo.getId());
    }

    /* compiled from: ToggleSwitchListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/arizonaui/cars/ToggleSwitchListAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/arizonaui/cars/ToggleSwitchListAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/arizonaui/cars/ToggleSwitchListAdapter$Companion$COMPARATOR$1;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: ToggleSwitchListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/cars/ToggleSwitchListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/CarsSwitchableItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/CarsSwitchableItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final CarsSwitchableItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            CarsSwitchableItemBinding bind = CarsSwitchableItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final CarsSwitchableItemBinding getBinding() {
            return this.binding;
        }
    }
}
