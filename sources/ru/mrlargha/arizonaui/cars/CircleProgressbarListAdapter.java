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
import ru.mrlargha.arizonaui.databinding.CarsCircleItemBinding;
/* compiled from: CircleProgressbarListAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/cars/CircleProgressbarListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$CircleProgressBarInfo;", "Lru/mrlargha/arizonaui/cars/CircleProgressbarListAdapter$ViewHolder;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "ViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CircleProgressbarListAdapter extends ListAdapter<CarsScreen.Companion.CircleProgressBarInfo, ViewHolder> {
    private final Activity activity;
    public static final Companion Companion = new Companion(null);
    private static final CircleProgressbarListAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<CarsScreen.Companion.CircleProgressBarInfo>() { // from class: ru.mrlargha.arizonaui.cars.CircleProgressbarListAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CarsScreen.Companion.CircleProgressBarInfo oldItem, CarsScreen.Companion.CircleProgressBarInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CarsScreen.Companion.CircleProgressBarInfo oldItem, CarsScreen.Companion.CircleProgressBarInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressbarListAdapter(Activity activity) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_circle_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CarsCircleItemBinding binding = holder.getBinding();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        double d = 100;
        binding.carsCircleItem.getLayoutParams().width = (int) ((i2 * 9.11d) / d);
        binding.carsCircleItem.getLayoutParams().height = (int) ((i3 * 12.87d) / d);
        CarsScreen.Companion.CircleProgressBarInfo item = getItem(i);
        String icon = item.getIcon();
        switch (icon.hashCode()) {
            case -1437013366:
                if (icon.equals("icon-fuel")) {
                    binding.icon.setImageResource(R.drawable.cars_circle_icon_fuel);
                    break;
                }
                break;
            case -1427385483:
                if (icon.equals("icon-oil-level")) {
                    binding.icon.setImageResource(R.drawable.cars_circle_icon_oil_level);
                    break;
                }
                break;
            case 577698830:
                if (icon.equals("icon-car-condition")) {
                    binding.icon.setImageResource(R.drawable.cars_circle_icon_car_condition);
                    break;
                }
                break;
            case 578934467:
                if (icon.equals("icon-heart-hp")) {
                    binding.icon.setImageResource(R.drawable.cars_circle_icon_heart_hp);
                    break;
                }
                break;
        }
        binding.progress.setMax(item.getMaxValue());
        binding.progress.setProgress(item.getValue());
        binding.paramName.setText(item.getTitle());
        binding.paramValue.setText(item.getValue() + " / " + item.getMaxValue() + " " + item.getPostfix());
    }

    /* compiled from: CircleProgressbarListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/arizonaui/cars/CircleProgressbarListAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/arizonaui/cars/CircleProgressbarListAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/arizonaui/cars/CircleProgressbarListAdapter$Companion$COMPARATOR$1;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: CircleProgressbarListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/cars/CircleProgressbarListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/CarsCircleItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/CarsCircleItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final CarsCircleItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            CarsCircleItemBinding bind = CarsCircleItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final CarsCircleItemBinding getBinding() {
            return this.binding;
        }
    }
}
