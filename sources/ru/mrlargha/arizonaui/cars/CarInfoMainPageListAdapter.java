package ru.mrlargha.arizonaui.cars;

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
import ru.mrlargha.arizonaui.databinding.CarsFirstScreenCarParamItemBinding;
/* compiled from: CarInfoMainPageListAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarInfoMainPageListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$LabelInfo;", "Lru/mrlargha/arizonaui/cars/CarInfoMainPageListAdapter$ViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "ViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarInfoMainPageListAdapter extends ListAdapter<CarsScreen.Companion.LabelInfo, ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final CarInfoMainPageListAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<CarsScreen.Companion.LabelInfo>() { // from class: ru.mrlargha.arizonaui.cars.CarInfoMainPageListAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CarsScreen.Companion.LabelInfo oldItem, CarsScreen.Companion.LabelInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getTitle(), newItem.getTitle());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CarsScreen.Companion.LabelInfo oldItem, CarsScreen.Companion.LabelInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    public CarInfoMainPageListAdapter() {
        super(COMPARATOR);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_first_screen_car_param_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CarsFirstScreenCarParamItemBinding binding = holder.getBinding();
        CarsScreen.Companion.LabelInfo item = getItem(i);
        binding.itemValue.setText(item.getTitle());
        String icon = item.getIcon();
        int hashCode = icon.hashCode();
        if (hashCode == -1437013366) {
            if (icon.equals("icon-fuel")) {
                binding.itemIc.setImageResource(R.drawable.cars_icon_fuel);
            }
        } else if (hashCode == 277342518) {
            if (icon.equals("icon-car-number")) {
                binding.itemIc.setImageResource(R.drawable.cars_icon_car_number);
            }
        } else if (hashCode == 1638726383 && icon.equals("icon-id")) {
            binding.itemIc.setImageResource(R.drawable.cars_icon_id);
        }
    }

    /* compiled from: CarInfoMainPageListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarInfoMainPageListAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/arizonaui/cars/CarInfoMainPageListAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/arizonaui/cars/CarInfoMainPageListAdapter$Companion$COMPARATOR$1;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: CarInfoMainPageListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarInfoMainPageListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/CarsFirstScreenCarParamItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/CarsFirstScreenCarParamItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final CarsFirstScreenCarParamItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            CarsFirstScreenCarParamItemBinding bind = CarsFirstScreenCarParamItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final CarsFirstScreenCarParamItemBinding getBinding() {
            return this.binding;
        }
    }
}
