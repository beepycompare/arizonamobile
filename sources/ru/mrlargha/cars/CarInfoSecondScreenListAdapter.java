package ru.mrlargha.cars;

import android.app.Activity;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.cars.R;
import ru.mrlargha.feature.cars.databinding.CarsSecondScreenCarParamItemBinding;
/* compiled from: CarInfoSecondScreenListAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/mrlargha/cars/CarInfoSecondScreenListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/cars/CarInfoSecondScreen;", "Lru/mrlargha/cars/CarInfoSecondScreenListAdapter$ViewHolder;", "activity", "Landroid/app/Activity;", "onQuality", "Lkotlin/Function1;", "", "", "<init>", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "Companion", "ViewHolder", "cars"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CarInfoSecondScreenListAdapter extends ListAdapter<CarInfoSecondScreen, ViewHolder> {
    private final Activity activity;
    private final Function1<Integer, Unit> onQuality;
    public static final Companion Companion = new Companion(null);
    private static final CarInfoSecondScreenListAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<CarInfoSecondScreen>() { // from class: ru.mrlargha.cars.CarInfoSecondScreenListAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CarInfoSecondScreen oldItem, CarInfoSecondScreen newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getTitle(), newItem.getTitle());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CarInfoSecondScreen oldItem, CarInfoSecondScreen newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CarInfoSecondScreenListAdapter(Activity activity, Function1<? super Integer, Unit> onQuality) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onQuality, "onQuality");
        this.activity = activity;
        this.onQuality = onQuality;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_second_screen_car_param_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x0187, code lost:
        if (r8.intValue() != 4) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b6  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(ViewHolder holder, int i) {
        String str;
        CarsRarity rarity;
        Intrinsics.checkNotNullParameter(holder, "holder");
        CarsSecondScreenCarParamItemBinding binding = holder.getBinding();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        binding.carsFirstScreenCarParamItem.getLayoutParams().width = (int) ((i2 * 11.56d) / 100.0d);
        binding.carsFirstScreenCarParamItem.getLayoutParams().height = (int) ((i3 * 6.94d) / 100.0d);
        final CarInfoSecondScreen item = getItem(i);
        binding.itemValue.setText(item.getTitle());
        if (item.getRarity() != null) {
            if (UtilsKt.isArizonaType()) {
                binding.qualityButton.setVisibility(8);
            } else {
                binding.qualityButton.setVisibility(0);
            }
            binding.qualityButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.cars.CarInfoSecondScreenListAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CarInfoSecondScreenListAdapter.onBindViewHolder$lambda$0$0(CarInfoSecondScreenListAdapter.this, item, view);
                }
            });
        } else {
            binding.qualityButton.setVisibility(8);
        }
        String icon = item.getIcon();
        int hashCode = icon.hashCode();
        if (hashCode != -1437013366) {
            if (hashCode != 277342518) {
                if (hashCode == 1638726383 && icon.equals("icon-id")) {
                    binding.itemIc.setImageResource(R.drawable.cars_icon_id);
                }
            } else if (icon.equals("icon-car-number")) {
                binding.itemIc.setImageResource(R.drawable.cars_icon_car_number);
            }
        } else if (icon.equals("icon-fuel")) {
            binding.itemIc.setImageResource(R.drawable.cars_icon_fuel);
        }
        String str2 = "#FFFFFF";
        String str3 = "#40000000";
        if (item.getRarity() != null) {
            CarsRarity rarity2 = item.getRarity();
            Integer valueOf = rarity2 != null ? Integer.valueOf(rarity2.getRarity()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                str = "случайное";
            } else if (valueOf != null && valueOf.intValue() == 1) {
                str = "хлам";
            } else if (valueOf != null && valueOf.intValue() == 2) {
                str = "обычное";
            } else {
                str = (valueOf != null && valueOf.intValue() == 4) ? "идеальное" : "";
            }
            CarsRarity rarity3 = item.getRarity();
            Integer valueOf2 = rarity3 != null ? Integer.valueOf(rarity3.getRarity()) : null;
            if (valueOf2 != null && valueOf2.intValue() == 1) {
                str3 = "#408F8F8F";
            } else if (valueOf2 != null && valueOf2.intValue() == 2) {
                str3 = "#4000FFFF";
            } else if (valueOf2 != null && valueOf2.intValue() == 4) {
                str3 = "#40FFCC00";
            }
            CarsRarity rarity4 = item.getRarity();
            Integer valueOf3 = rarity4 != null ? Integer.valueOf(rarity4.getRarity()) : null;
            if (valueOf3 == null || valueOf3.intValue() != 0) {
                if (valueOf3 != null && valueOf3.intValue() == 1) {
                    str2 = "#8F8F8F";
                } else if (valueOf3 != null && valueOf3.intValue() == 2) {
                    str2 = "#00FFFF";
                } else if (valueOf3 != null) {
                }
                rarity = item.getRarity();
                if (rarity == null && rarity.getRarity() == 0) {
                    binding.itemValue.setText(String.valueOf(str));
                    binding.itemIc.setVisibility(0);
                    binding.itemIc.setImageResource(R.drawable.transport_random_ic);
                } else {
                    TextView textView = binding.itemValue;
                    CarsRarity rarity5 = item.getRarity();
                    textView.setText(str + " (" + (rarity5 != null ? Integer.valueOf(rarity5.getRarityLevel()) : null) + ")");
                    binding.itemIc.setVisibility(8);
                }
                binding.bg.setBackground(Color.parseColor(str3));
                binding.itemValue.setTextColor(Color.parseColor(str2));
                return;
            }
            str2 = "#FFCC00";
            rarity = item.getRarity();
            if (rarity == null) {
            }
            TextView textView2 = binding.itemValue;
            CarsRarity rarity52 = item.getRarity();
            textView2.setText(str + " (" + (rarity52 != null ? Integer.valueOf(rarity52.getRarityLevel()) : null) + ")");
            binding.itemIc.setVisibility(8);
            binding.bg.setBackground(Color.parseColor(str3));
            binding.itemValue.setTextColor(Color.parseColor(str2));
            return;
        }
        binding.bg.setBackground(Color.parseColor("#40000000"));
        binding.itemValue.setTextColor(Color.parseColor("#FFFFFF"));
        binding.itemIc.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(CarInfoSecondScreenListAdapter carInfoSecondScreenListAdapter, CarInfoSecondScreen carInfoSecondScreen, View view) {
        Function1<Integer, Unit> function1 = carInfoSecondScreenListAdapter.onQuality;
        CarsRarity rarity = carInfoSecondScreen.getRarity();
        function1.invoke(Integer.valueOf(rarity != null ? rarity.getRarity() : 1));
    }

    /* compiled from: CarInfoSecondScreenListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/cars/CarInfoSecondScreenListAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/cars/CarInfoSecondScreenListAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/cars/CarInfoSecondScreenListAdapter$Companion$COMPARATOR$1;", "cars"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: CarInfoSecondScreenListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/cars/CarInfoSecondScreenListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/feature/cars/databinding/CarsSecondScreenCarParamItemBinding;", "getBinding", "()Lru/mrlargha/feature/cars/databinding/CarsSecondScreenCarParamItemBinding;", "cars"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final CarsSecondScreenCarParamItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            CarsSecondScreenCarParamItemBinding bind = CarsSecondScreenCarParamItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final CarsSecondScreenCarParamItemBinding getBinding() {
            return this.binding;
        }
    }
}
