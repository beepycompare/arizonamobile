package com.arizonagames.feature.arizona.cars;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import com.arizonagames.feature.arizona.cars.databinding.CarsCarItemBinding;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizona.cars.QualityType;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: CarInfoListAdapter.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003./0B*\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0019J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0014\u0010%\u001a\u00020\t2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012J\u000e\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)J\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012J\u0006\u0010,\u001a\u00020\tJ\b\u0010-\u001a\u00020\u0005H\u0016R)\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/CarInfoListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/arizonagames/feature/arizona/cars/CarInfoListAdapter$ViewHolder;", "onFavClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "Lcom/arizonagames/feature/arizona/cars/CarInfoListItem;", "getItemsList", "()Ljava/util/List;", "qualityTypeList", "", "Lru/mrlargha/arizona/cars/QualityType;", "addQualities", "qualities", "spawnClickListener", "Lcom/arizonagames/feature/arizona/cars/CarInfoListAdapter$OnSpawnClickListener;", "carInfoClickListener", "Lcom/arizonagames/feature/arizona/cars/CarInfoListAdapter$OnCarInfoClickListener;", "setOnSpawnClickListener", "onSpawnClickListener", "setOnCarInfoClickListener", "onCarInfoClickListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "addAllItems", "items", "updateFav", "favorite", "Lcom/arizonagames/feature/arizona/cars/Favorite;", "sortCars", "list", "clear", "getItemCount", "OnSpawnClickListener", "OnCarInfoClickListener", "ViewHolder", "cars_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CarInfoListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private OnCarInfoClickListener carInfoClickListener;
    private final List<CarInfoListItem> itemsList;
    private final Function1<Integer, Unit> onFavClick;
    private List<QualityType> qualityTypeList;
    private OnSpawnClickListener spawnClickListener;

    /* compiled from: CarInfoListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/CarInfoListAdapter$OnCarInfoClickListener;", "", "onCarInfoClickListener", "", "id", "", "cars_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface OnCarInfoClickListener {
        void onCarInfoClickListener(int i);
    }

    /* compiled from: CarInfoListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/CarInfoListAdapter$OnSpawnClickListener;", "", "onSpawnClickListener", "", "id", "", "cars_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface OnSpawnClickListener {
        void onSpawnClickListener(int i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CarInfoListAdapter(Function1<? super Integer, Unit> onFavClick) {
        Intrinsics.checkNotNullParameter(onFavClick, "onFavClick");
        this.onFavClick = onFavClick;
        this.itemsList = new ArrayList();
        this.qualityTypeList = CollectionsKt.emptyList();
    }

    public final List<CarInfoListItem> getItemsList() {
        return this.itemsList;
    }

    public final void addQualities(List<QualityType> qualities) {
        Intrinsics.checkNotNullParameter(qualities, "qualities");
        this.qualityTypeList = qualities;
        notifyDataSetChanged();
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
        Object obj;
        Intrinsics.checkNotNullParameter(holder, "holder");
        CarsCarItemBinding binding = holder.getBinding();
        final CarInfoListItem carInfoListItem = (CarInfoListItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (carInfoListItem == null) {
            return;
        }
        Integer favorite = carInfoListItem.getFavorite();
        if (favorite != null && favorite.intValue() == 0) {
            binding.carFavIc.setImageResource(R.drawable.cars_fav_not_ic);
        } else {
            binding.carFavIc.setImageResource(R.drawable.cars_fav_ic);
        }
        binding.carFavIc.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.arizona.cars.CarInfoListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarInfoListAdapter.onBindViewHolder$lambda$0$0(CarInfoListAdapter.this, carInfoListItem, view);
            }
        });
        binding.carName.setText(carInfoListItem.getTitle());
        String str = UtilsKt.isArizonaType() ? "projects/arizona-rp/assets/images/inventory/vehicles/256/" : "projects/rodina-rp/assets/images/inventory/vehicles/512/";
        Picasso.get().load(FirebaseConfigHelper.INSTANCE.getResourceUrl() + str + carInfoListItem.getSysName()).into(binding.carIc);
        String status = carInfoListItem.getStatus();
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
        binding.spawnTitle.setText(carInfoListItem.getNameButton());
        int statusButton = carInfoListItem.getStatusButton();
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
        binding.mainPageCarParamsRc.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.arizonagames.feature.arizona.cars.CarInfoListAdapter$onBindViewHolder$1$2
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
        carInfoMainPageListAdapter.submitList(carInfoListItem.getLabels());
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ConstraintLayout spawnButton = binding.spawnButton;
        Intrinsics.checkNotNullExpressionValue(spawnButton, "spawnButton");
        EasyAnimation.animateClick$default(easyAnimation, spawnButton, 0L, null, new Function0() { // from class: com.arizonagames.feature.arizona.cars.CarInfoListAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$0$1;
                onBindViewHolder$lambda$0$1 = CarInfoListAdapter.onBindViewHolder$lambda$0$1(CarInfoListAdapter.this, carInfoListItem);
                return onBindViewHolder$lambda$0$1;
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ConstraintLayout carInfoContainer = binding.carInfoContainer;
        Intrinsics.checkNotNullExpressionValue(carInfoContainer, "carInfoContainer");
        EasyAnimation.animateClick$default(easyAnimation2, carInfoContainer, 0L, null, new Function0() { // from class: com.arizonagames.feature.arizona.cars.CarInfoListAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$0$2;
                onBindViewHolder$lambda$0$2 = CarInfoListAdapter.onBindViewHolder$lambda$0$2(CarInfoListAdapter.this, carInfoListItem);
                return onBindViewHolder$lambda$0$2;
            }
        }, 3, null);
        binding.rarityCard.setVisibility(8);
        Integer rarity = carInfoListItem.getRarity();
        if (rarity != null) {
            int intValue = rarity.intValue();
            Iterator<T> it = this.qualityTypeList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((QualityType) obj).getId() == carInfoListItem.getRarity().intValue()) {
                    }
                } else {
                    obj = null;
                }
            }
            QualityType qualityType = (QualityType) obj;
            if (qualityType != null) {
                Integer rarity2 = carInfoListItem.getRarity();
                if (rarity2 != null && rarity2.intValue() == 0) {
                    binding.qualityText.setText("Качество не определено");
                    binding.rarityCard.setVisibility(8);
                } else {
                    binding.qualityText.setText(qualityType.getName() + " (" + carInfoListItem.getRarityLevel() + ")");
                }
                CustomCardView rarityCard = binding.rarityCard;
                Intrinsics.checkNotNullExpressionValue(rarityCard, "rarityCard");
                CustomCardView.setBackground$default(rarityCard, Color.parseColor(qualityType.getColors().get(1)), Color.parseColor(qualityType.getColors().get(0)), null, null, 12, null);
            }
            binding.rarityCard.setVisibility(0);
            binding.ratingText.setText(carInfoListItem.getRatingPosition() + " место");
            Integer ratingPosition = carInfoListItem.getRatingPosition();
            if (ratingPosition != null && ratingPosition.intValue() == 0) {
                binding.ratingText.setText("Рейтинг скоро будет определен");
            }
            if (intValue == 0) {
                binding.ratingCard.setVisibility(8);
            } else {
                binding.ratingCard.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(CarInfoListAdapter carInfoListAdapter, CarInfoListItem carInfoListItem, View view) {
        carInfoListAdapter.onFavClick.invoke(Integer.valueOf(carInfoListItem.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$1(CarInfoListAdapter carInfoListAdapter, CarInfoListItem carInfoListItem) {
        OnSpawnClickListener onSpawnClickListener = carInfoListAdapter.spawnClickListener;
        if (onSpawnClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spawnClickListener");
            onSpawnClickListener = null;
        }
        onSpawnClickListener.onSpawnClickListener(carInfoListItem.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$0$2(CarInfoListAdapter carInfoListAdapter, CarInfoListItem carInfoListItem) {
        OnCarInfoClickListener onCarInfoClickListener = carInfoListAdapter.carInfoClickListener;
        if (onCarInfoClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carInfoClickListener");
            onCarInfoClickListener = null;
        }
        onCarInfoClickListener.onCarInfoClickListener(carInfoListItem.getId());
        return Unit.INSTANCE;
    }

    public final void addAllItems(List<CarInfoListItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.itemsList.clear();
        this.itemsList.addAll(sortCars(items));
        notifyDataSetChanged();
    }

    public final void updateFav(Favorite favorite) {
        Object obj;
        Intrinsics.checkNotNullParameter(favorite, "favorite");
        Iterator<T> it = this.itemsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CarInfoListItem) obj).getId() == favorite.getIndex()) {
                break;
            }
        }
        CarInfoListItem carInfoListItem = (CarInfoListItem) obj;
        if (carInfoListItem != null) {
            carInfoListItem.setFavorite(Integer.valueOf(favorite.getFavorite()));
            notifyDataSetChanged();
            List<CarInfoListItem> sortCars = sortCars(this.itemsList);
            this.itemsList.clear();
            this.itemsList.addAll(sortCars);
        }
    }

    public final List<CarInfoListItem> sortCars(List<CarInfoListItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        final Comparator comparator = new Comparator() { // from class: com.arizonagames.feature.arizona.cars.CarInfoListAdapter$sortCars$$inlined$compareByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Boolean.valueOf(Intrinsics.areEqual(((CarInfoListItem) t2).getStatus(), "loaded")), Boolean.valueOf(Intrinsics.areEqual(((CarInfoListItem) t).getStatus(), "loaded")));
            }
        };
        final Comparator comparator2 = new Comparator() { // from class: com.arizonagames.feature.arizona.cars.CarInfoListAdapter$sortCars$$inlined$thenByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                if (compare != 0) {
                    return compare;
                }
                int favorite = ((CarInfoListItem) t2).getFavorite();
                if (favorite == null) {
                    favorite = Integer.MAX_VALUE;
                }
                Integer num = favorite;
                int favorite2 = ((CarInfoListItem) t).getFavorite();
                if (favorite2 == null) {
                    favorite2 = Integer.MAX_VALUE;
                }
                return ComparisonsKt.compareValues(num, favorite2);
            }
        };
        return CollectionsKt.sortedWith(list, new Comparator() { // from class: com.arizonagames.feature.arizona.cars.CarInfoListAdapter$sortCars$$inlined$thenByDescending$2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator2.compare(t, t2);
                return compare != 0 ? compare : ComparisonsKt.compareValues(Integer.valueOf(((CarInfoListItem) t2).getId()), Integer.valueOf(((CarInfoListItem) t).getId()));
            }
        });
    }

    public final void clear() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    /* compiled from: CarInfoListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/CarInfoListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lcom/arizonagames/feature/arizona/cars/databinding/CarsCarItemBinding;", "getBinding", "()Lcom/arizonagames/feature/arizona/cars/databinding/CarsCarItemBinding;", "cars_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
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
