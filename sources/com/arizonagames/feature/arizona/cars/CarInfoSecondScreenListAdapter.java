package com.arizonagames.feature.arizona.cars;

import android.app.Activity;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.arizona.cars.databinding.CarsSecondScreenCarParamItemBinding;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizona.cars.QualityType;
/* compiled from: CarInfoSecondScreenListAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0014\u0010\u0013\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/CarInfoSecondScreenListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/arizonagames/feature/arizona/cars/CarInfoSecondScreen;", "Lcom/arizonagames/feature/arizona/cars/CarInfoSecondScreenListAdapter$ViewHolder;", "activity", "Landroid/app/Activity;", "onQuality", "Lkotlin/Function1;", "", "", "<init>", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "qualityTypeList", "", "Lru/mrlargha/arizona/cars/QualityType;", "addQualities", "qualities", "onBindViewHolder", "holder", "position", "Companion", "ViewHolder", "cars"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CarInfoSecondScreenListAdapter extends ListAdapter<CarInfoSecondScreen, ViewHolder> {
    private final Activity activity;
    private final Function1<Integer, Unit> onQuality;
    private List<QualityType> qualityTypeList;
    public static final Companion Companion = new Companion(null);
    private static final CarInfoSecondScreenListAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<CarInfoSecondScreen>() { // from class: com.arizonagames.feature.arizona.cars.CarInfoSecondScreenListAdapter$Companion$COMPARATOR$1
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
        this.qualityTypeList = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_second_screen_car_param_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    public final void addQualities(List<QualityType> qualities) {
        Intrinsics.checkNotNullParameter(qualities, "qualities");
        this.qualityTypeList = qualities;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Object obj;
        CarsRarity rarity;
        int i2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        CarsSecondScreenCarParamItemBinding binding = holder.getBinding();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        double d = 100;
        binding.carsFirstScreenCarParamItem.getLayoutParams().width = (int) ((i3 * 11.56d) / d);
        binding.carsFirstScreenCarParamItem.getLayoutParams().height = (int) ((i4 * 6.94d) / d);
        final CarInfoSecondScreen item = getItem(i);
        binding.itemValue.setText(item.getTitle());
        if (item.getRarity() != null) {
            binding.qualityButton.setVisibility(0);
            binding.qualityButton.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.cars.CarInfoSecondScreenListAdapter$$ExternalSyntheticLambda0
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
        if (item.getRarity() == null) {
            binding.itemIc.setVisibility(0);
            return;
        }
        Iterator<T> it = this.qualityTypeList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int id = ((QualityType) obj).getId();
            CarsRarity rarity2 = item.getRarity();
            if (rarity2 != null) {
                i2 = rarity2.getRarity();
                continue;
            } else {
                i2 = 0;
                continue;
            }
            if (id == i2) {
                break;
            }
        }
        QualityType qualityType = (QualityType) obj;
        if (qualityType != null) {
            CarsRarity rarity3 = item.getRarity();
            if (rarity3 != null && rarity3.getRarity() == 0) {
                binding.itemValue.setText(String.valueOf(qualityType.getName()));
            } else {
                binding.itemValue.setText(qualityType.getName() + " (" + (item.getRarity() != null ? Integer.valueOf(rarity.getRarityLevel()) : null) + ")");
            }
            binding.bg.setBackground(Color.parseColor(qualityType.getColors().get(0)));
            binding.itemValue.setTextColor(Color.parseColor(qualityType.getColors().get(0)));
        }
        CarsRarity rarity4 = item.getRarity();
        if (rarity4 != null && rarity4.getRarity() == 0) {
            binding.itemIc.setVisibility(0);
            binding.itemIc.setImageResource(R.drawable.transport_random_ic);
            return;
        }
        binding.itemIc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(CarInfoSecondScreenListAdapter carInfoSecondScreenListAdapter, CarInfoSecondScreen carInfoSecondScreen, View view) {
        Function1<Integer, Unit> function1 = carInfoSecondScreenListAdapter.onQuality;
        CarsRarity rarity = carInfoSecondScreen.getRarity();
        function1.invoke(Integer.valueOf(rarity != null ? rarity.getRarity() : 1));
    }

    /* compiled from: CarInfoSecondScreenListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/CarInfoSecondScreenListAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "com/arizonagames/feature/arizona/cars/CarInfoSecondScreenListAdapter$Companion$COMPARATOR$1", "Lcom/arizonagames/feature/arizona/cars/CarInfoSecondScreenListAdapter$Companion$COMPARATOR$1;", "cars"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: CarInfoSecondScreenListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/CarInfoSecondScreenListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lcom/arizonagames/feature/arizona/cars/databinding/CarsSecondScreenCarParamItemBinding;", "getBinding", "()Lcom/arizonagames/feature/arizona/cars/databinding/CarsSecondScreenCarParamItemBinding;", "cars"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
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
