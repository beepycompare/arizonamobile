package ru.mrlargha.arizonaui.cars;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import com.squareup.picasso.Picasso;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.cars.CarsScreen;
import ru.mrlargha.arizonaui.databinding.CarsCarItemBinding;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: CarInfoListAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0017\u0018\u0019\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tJ\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarInfoListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$CarInfoListItem;", "Lru/mrlargha/arizonaui/cars/CarInfoListAdapter$ViewHolder;", "<init>", "()V", "spawnClickListener", "Lru/mrlargha/arizonaui/cars/CarInfoListAdapter$OnSpawnClickListener;", "carInfoClickListener", "Lru/mrlargha/arizonaui/cars/CarInfoListAdapter$OnCarInfoClickListener;", "setOnSpawnClickListener", "", "onSpawnClickListener", "setOnCarInfoClickListener", "onCarInfoClickListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "OnSpawnClickListener", "OnCarInfoClickListener", "Companion", "ViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarInfoListAdapter extends ListAdapter<CarsScreen.Companion.CarInfoListItem, ViewHolder> {
    private OnCarInfoClickListener carInfoClickListener;
    private OnSpawnClickListener spawnClickListener;
    public static final Companion Companion = new Companion(null);
    private static final CarInfoListAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<CarsScreen.Companion.CarInfoListItem>() { // from class: ru.mrlargha.arizonaui.cars.CarInfoListAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CarsScreen.Companion.CarInfoListItem oldItem, CarsScreen.Companion.CarInfoListItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CarsScreen.Companion.CarInfoListItem oldItem, CarsScreen.Companion.CarInfoListItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* compiled from: CarInfoListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarInfoListAdapter$OnCarInfoClickListener;", "", "onCarInfoClickListener", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnCarInfoClickListener {
        void onCarInfoClickListener(int i);
    }

    /* compiled from: CarInfoListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarInfoListAdapter$OnSpawnClickListener;", "", "onSpawnClickListener", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnSpawnClickListener {
        void onSpawnClickListener(int i);
    }

    public CarInfoListAdapter() {
        super(COMPARATOR);
    }

    public final void setOnSpawnClickListener(OnSpawnClickListener onSpawnClickListener) {
        Intrinsics.checkNotNullParameter(onSpawnClickListener, "onSpawnClickListener");
        this.spawnClickListener = onSpawnClickListener;
    }

    public final void setOnCarInfoClickListener(OnCarInfoClickListener onCarInfoClickListener) {
        Intrinsics.checkNotNullParameter(onCarInfoClickListener, "onCarInfoClickListener");
        this.carInfoClickListener = onCarInfoClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_car_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CarsCarItemBinding binding = holder.getBinding();
        final CarsScreen.Companion.CarInfoListItem item = getItem(i);
        binding.carName.setText(item.getTitle());
        Picasso picasso = Picasso.get();
        String resourceUrl = FirebaseConfigHelper.INSTANCE.getResourceUrl();
        picasso.load(resourceUrl + "projects/arizona-rp/assets/images/inventory/vehicles/256/" + item.getSysName()).into(binding.carIc);
        String status = item.getStatus();
        switch (status.hashCode()) {
            case -2058533514:
                if (status.equals("parkhouse")) {
                    binding.carStatus.setText("Гараж дома");
                    binding.carStatus.setTextColor(Color.parseColor("#60CA5D"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_green);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_green_ic);
                    break;
                }
                break;
            case -1289345308:
                if (status.equals("arrested")) {
                    binding.carStatus.setText("На штрафстоянке");
                    binding.carStatus.setTextColor(Color.parseColor("#F34141"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_red);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_red_ic);
                    break;
                }
                break;
            case -1097519099:
                if (status.equals("loaded")) {
                    binding.carStatus.setText("Загружено");
                    binding.carStatus.setTextColor(Color.parseColor("#60CA5D"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_green);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_green_ic);
                    break;
                }
                break;
            case -995418615:
                if (status.equals("parked")) {
                    binding.carStatus.setText("Припарковано");
                    binding.carStatus.setTextColor(Color.parseColor("#60CA5D"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_green);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_green_ic);
                    break;
                }
                break;
            case -995418215:
                if (status.equals("parkra")) {
                    binding.carStatus.setText("Паркинг Риелторка");
                    binding.carStatus.setTextColor(Color.parseColor("#60CA5D"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_green);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_green_ic);
                    break;
                }
                break;
            case -892072665:
                if (status.equals("stolen")) {
                    binding.carStatus.setText("Угнан");
                    binding.carStatus.setTextColor(Color.parseColor("#F34141"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_red);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_red_ic);
                    break;
                }
                break;
            case -793209039:
                if (status.equals("parkazt")) {
                    binding.carStatus.setText("Паркинг AT");
                    binding.carStatus.setTextColor(Color.parseColor("#60CA5D"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_green);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_green_ic);
                    break;
                }
                break;
            case -793208855:
                if (status.equals("parkbar")) {
                    binding.carStatus.setText("Парковка бара");
                    binding.carStatus.setTextColor(Color.parseColor("#60CA5D"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_green);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_green_ic);
                    break;
                }
                break;
            case -793197724:
                if (status.equals("parkmst")) {
                    binding.carStatus.setText("Паркинг MS");
                    binding.carStatus.setTextColor(Color.parseColor("#60CA5D"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_green);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_green_ic);
                    break;
                }
                break;
            case -762504921:
                if (status.equals("repaircar")) {
                    binding.carStatus.setText("Требуется ремонт");
                    binding.carStatus.setTextColor(Color.parseColor("#F34141"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_red);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_red_ic);
                    break;
                }
                break;
            case -480017974:
                if (status.equals("rentgive")) {
                    binding.carStatus.setText("Сдано в аренду");
                    binding.carStatus.setTextColor(Color.parseColor("#FFC852"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_orange);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_orange_ic);
                    break;
                }
                break;
            case -479638720:
                if (status.equals("renttake")) {
                    binding.carStatus.setText("Взято в аренду");
                    binding.carStatus.setTextColor(Color.parseColor("#FFC852"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_orange);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_orange_ic);
                    break;
                }
                break;
            case 3556308:
                if (status.equals("temp")) {
                    binding.carStatus.setText("Временное");
                    binding.carStatus.setTextColor(Color.parseColor("#FFC852"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_orange);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_orange_ic);
                    break;
                }
                break;
            case 1079450808:
                if (status.equals("notLoaded")) {
                    binding.carStatus.setText("Не загружено");
                    binding.carStatus.setTextColor(Color.parseColor("#99FFFFFF"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_gray);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_gray_ic);
                    break;
                }
                break;
            case 1180809763:
                if (status.equals("parkrent")) {
                    binding.carStatus.setText("Аренда на паркоместе");
                    binding.carStatus.setTextColor(Color.parseColor("#60CA5D"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_green);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_green_ic);
                    break;
                }
                break;
            case 1566649931:
                if (status.equals("parkundeground")) {
                    binding.carStatus.setText("Подземная парковка");
                    binding.carStatus.setTextColor(Color.parseColor("#60CA5D"));
                    binding.statusContainer.setBackgroundResource(R.drawable.cars_car_status_container_green);
                    binding.carStatusIc.setImageResource(R.drawable.cars_main_page_car_status_green_ic);
                    break;
                }
                break;
        }
        binding.spawnTitle.setText(item.getNameButton());
        int statusButton = item.getStatusButton();
        if (statusButton == 0) {
            binding.spawnTitle.setTextColor(Color.parseColor("#999999"));
            binding.spawnIc.setImageResource(R.drawable.cars_spawn_not_pressed_ic);
            binding.spawnButton.setBackgroundResource(R.drawable.cars_spawn_button_bg);
        } else if (statusButton == 1) {
            binding.spawnTitle.setTextColor(Color.parseColor("#FFFFFF"));
            binding.spawnIc.setImageResource(R.drawable.cars_spawn_pressed_ic);
            binding.spawnButton.setBackgroundResource(R.drawable.cars_spawn_pressed_button_bg);
        }
        CarInfoMainPageListAdapter carInfoMainPageListAdapter = new CarInfoMainPageListAdapter();
        binding.mainPageCarParamsRc.setAdapter(carInfoMainPageListAdapter);
        binding.mainPageCarParamsRc.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: ru.mrlargha.arizonaui.cars.CarInfoListAdapter$onBindViewHolder$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Intrinsics.checkNotNullParameter(rv, "rv");
                Intrinsics.checkNotNullParameter(e, "e");
                if (e.getAction() == 0) {
                    rv.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.onInterceptTouchEvent(rv, e);
            }
        });
        carInfoMainPageListAdapter.submitList(item.getLabels());
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ConstraintLayout spawnButton = binding.spawnButton;
        Intrinsics.checkNotNullExpressionValue(spawnButton, "spawnButton");
        EasyAnimation.animateClick$default(easyAnimation, spawnButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.cars.CarInfoListAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$2$lambda$0;
                onBindViewHolder$lambda$2$lambda$0 = CarInfoListAdapter.onBindViewHolder$lambda$2$lambda$0(CarInfoListAdapter.this, item);
                return onBindViewHolder$lambda$2$lambda$0;
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ConstraintLayout carInfoContainer = binding.carInfoContainer;
        Intrinsics.checkNotNullExpressionValue(carInfoContainer, "carInfoContainer");
        EasyAnimation.animateClick$default(easyAnimation2, carInfoContainer, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.cars.CarInfoListAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$2$lambda$1;
                onBindViewHolder$lambda$2$lambda$1 = CarInfoListAdapter.onBindViewHolder$lambda$2$lambda$1(CarInfoListAdapter.this, item);
                return onBindViewHolder$lambda$2$lambda$1;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2$lambda$0(CarInfoListAdapter carInfoListAdapter, CarsScreen.Companion.CarInfoListItem carInfoListItem) {
        OnSpawnClickListener onSpawnClickListener = carInfoListAdapter.spawnClickListener;
        if (onSpawnClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spawnClickListener");
            onSpawnClickListener = null;
        }
        onSpawnClickListener.onSpawnClickListener(carInfoListItem.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2$lambda$1(CarInfoListAdapter carInfoListAdapter, CarsScreen.Companion.CarInfoListItem carInfoListItem) {
        OnCarInfoClickListener onCarInfoClickListener = carInfoListAdapter.carInfoClickListener;
        if (onCarInfoClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carInfoClickListener");
            onCarInfoClickListener = null;
        }
        onCarInfoClickListener.onCarInfoClickListener(carInfoListItem.getId());
        return Unit.INSTANCE;
    }

    /* compiled from: CarInfoListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarInfoListAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/arizonaui/cars/CarInfoListAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/arizonaui/cars/CarInfoListAdapter$Companion$COMPARATOR$1;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: CarInfoListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarInfoListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/CarsCarItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/CarsCarItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final CarsCarItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            CarsCarItemBinding bind = CarsCarItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final CarsCarItemBinding getBinding() {
            return this.binding;
        }
    }
}
