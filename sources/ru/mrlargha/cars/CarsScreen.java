package ru.mrlargha.cars;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.FrameMetricsAggregator;
import com.arizona.common.utils.EasyAnimation;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.cars.ActionsListAdapter;
import ru.mrlargha.cars.CarInfoListAdapter;
import ru.mrlargha.cars.ToggleSwitchListAdapter;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.cars.R;
import ru.mrlargha.feature.cars.databinding.CarsLayoutBinding;
/* compiled from: CarsScreen.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001;B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0016\u0010)\u001a\u00020'2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001d0\rH\u0002J\u0018\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0016\u0010.\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001f0\rH\u0002J\u0016\u00100\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020!0\rH\u0002J\u0016\u00101\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020#0\rH\u0002J\u0016\u00102\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020%0\rH\u0002J\u0016\u00103\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002040\rH\u0002J\u0018\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0005H\u0016J\u0010\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lru/mrlargha/cars/CarsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/feature/cars/databinding/CarsLayoutBinding;", "bonuses", "", "", "carInfoListAdapter", "Lru/mrlargha/cars/CarInfoListAdapter;", "toggleSwitchListAdapter", "Lru/mrlargha/cars/ToggleSwitchListAdapter;", "actionsListAdapter", "Lru/mrlargha/cars/ActionsListAdapter;", "circleProgressbarListAdapter", "Lru/mrlargha/cars/CircleProgressbarListAdapter;", "carInfoSecondScreenListAdapter", "Lru/mrlargha/cars/CarInfoSecondScreenListAdapter;", "textListAdapter", "Lru/mrlargha/cars/TextListAdapter;", "carsItemList", "", "Lru/mrlargha/cars/CarInfoListItem;", "toggleSwitchItemList", "Lru/mrlargha/cars/ToggleSwitchInfo;", "actionButtonItemList", "Lru/mrlargha/cars/ActionButtonInfo;", "circleProgressBarItemList", "Lru/mrlargha/cars/CircleProgressBarInfo;", "textInfoItemList", "Lru/mrlargha/cars/TextInfo;", "onQuality", "", "rarity", "setCarInfoList", "carInfoList", "setSlotsInfo", "slotsCount", "partCount", "setToggleSwitchInfo", "infoList", "setActionButtonsInfo", "setCircleProgressBarsInfo", "setTextInfo", "setCarInfoSecondScreen", "Lru/mrlargha/cars/CarInfoSecondScreen;", "onBackendMessage", "data", "subId", "setCarRarity", "info", "Lru/mrlargha/cars/CarsRarity;", "Spawner", "cars_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarsScreen extends SAMPUIElement {
    private final List<ActionButtonInfo> actionButtonItemList;
    private final ActionsListAdapter actionsListAdapter;
    private final CarsLayoutBinding binding;
    private List<String> bonuses;
    private final CarInfoListAdapter carInfoListAdapter;
    private final CarInfoSecondScreenListAdapter carInfoSecondScreenListAdapter;
    private List<CarInfoListItem> carsItemList;
    private final List<CircleProgressBarInfo> circleProgressBarItemList;
    private final CircleProgressbarListAdapter circleProgressbarListAdapter;
    private final ConstraintLayout layout;
    private final List<TextInfo> textInfoItemList;
    private final TextListAdapter textListAdapter;
    private final List<ToggleSwitchInfo> toggleSwitchItemList;
    private final ToggleSwitchListAdapter toggleSwitchListAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CarsScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.cars_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        CarsLayoutBinding bind = CarsLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.bonuses = CollectionsKt.emptyList();
        CarInfoListAdapter carInfoListAdapter = new CarInfoListAdapter();
        this.carInfoListAdapter = carInfoListAdapter;
        ToggleSwitchListAdapter toggleSwitchListAdapter = new ToggleSwitchListAdapter(targetActivity);
        this.toggleSwitchListAdapter = toggleSwitchListAdapter;
        ActionsListAdapter actionsListAdapter = new ActionsListAdapter(targetActivity);
        this.actionsListAdapter = actionsListAdapter;
        CircleProgressbarListAdapter circleProgressbarListAdapter = new CircleProgressbarListAdapter(targetActivity);
        this.circleProgressbarListAdapter = circleProgressbarListAdapter;
        CarInfoSecondScreenListAdapter carInfoSecondScreenListAdapter = new CarInfoSecondScreenListAdapter(targetActivity, new Function1() { // from class: ru.mrlargha.cars.CarsScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit carInfoSecondScreenListAdapter$lambda$0;
                carInfoSecondScreenListAdapter$lambda$0 = CarsScreen.carInfoSecondScreenListAdapter$lambda$0(CarsScreen.this, ((Integer) obj).intValue());
                return carInfoSecondScreenListAdapter$lambda$0;
            }
        });
        this.carInfoSecondScreenListAdapter = carInfoSecondScreenListAdapter;
        TextListAdapter textListAdapter = new TextListAdapter(targetActivity);
        this.textListAdapter = textListAdapter;
        this.carsItemList = new ArrayList();
        this.toggleSwitchItemList = new ArrayList();
        this.actionButtonItemList = new ArrayList();
        this.circleProgressBarItemList = new ArrayList();
        this.textInfoItemList = new ArrayList();
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.mainPageCarsRc.setAdapter(carInfoListAdapter);
        carInfoListAdapter.setOnCarInfoClickListener(new CarInfoListAdapter.OnCarInfoClickListener() { // from class: ru.mrlargha.cars.CarsScreen$1$1
            @Override // ru.mrlargha.cars.CarInfoListAdapter.OnCarInfoClickListener
            public void onCarInfoClickListener(int i2) {
                List list;
                list = CarsScreen.this.carsItemList;
                list.clear();
                SAMPUIElement.notifyClick$default(CarsScreen.this, i2, 0, null, 4, null);
            }
        });
        carInfoListAdapter.setOnSpawnClickListener(new CarInfoListAdapter.OnSpawnClickListener() { // from class: ru.mrlargha.cars.CarsScreen$1$2
            @Override // ru.mrlargha.cars.CarInfoListAdapter.OnSpawnClickListener
            public void onSpawnClickListener(int i2) {
                List list;
                list = CarsScreen.this.carsItemList;
                list.clear();
                SAMPUIElement.notifyClick$default(CarsScreen.this, i2, 5, null, 4, null);
            }
        });
        bind.secondPageCarSwitchRc.setAdapter(toggleSwitchListAdapter);
        toggleSwitchListAdapter.setOnSwitchClickListener(new ToggleSwitchListAdapter.OnSwitchClickListener() { // from class: ru.mrlargha.cars.CarsScreen$1$3
            @Override // ru.mrlargha.cars.ToggleSwitchListAdapter.OnSwitchClickListener
            public void onSwitchClickListener(int i2) {
                SAMPUIElement.notifyClick$default(CarsScreen.this, i2, 1, null, 4, null);
            }
        });
        bind.secondPageCarActionsRc.setAdapter(actionsListAdapter);
        actionsListAdapter.setOnActionClickListener(new ActionsListAdapter.OnActionClickListener() { // from class: ru.mrlargha.cars.CarsScreen$1$4
            @Override // ru.mrlargha.cars.ActionsListAdapter.OnActionClickListener
            public void onActionClickListener(int i2) {
                SAMPUIElement.notifyClick$default(CarsScreen.this, i2, 2, null, 4, null);
            }
        });
        bind.secondPageCarCircleInfoRc.setAdapter(circleProgressbarListAdapter);
        bind.secondPageCarParamsRc.setAdapter(carInfoSecondScreenListAdapter);
        bind.secondPageCarTextInfoRc.setAdapter(textListAdapter);
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView secondPageBackButton = bind.secondPageBackButton;
        Intrinsics.checkNotNullExpressionValue(secondPageBackButton, "secondPageBackButton");
        EasyAnimation.animateClick$default(easyAnimation, secondPageBackButton, 0L, null, new Function0() { // from class: ru.mrlargha.cars.CarsScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CarsScreen.lambda$0$0(CarsScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView secondPageExitButton = bind.secondPageExitButton;
        Intrinsics.checkNotNullExpressionValue(secondPageExitButton, "secondPageExitButton");
        EasyAnimation.animateClick$default(easyAnimation2, secondPageExitButton, 0L, null, new Function0() { // from class: ru.mrlargha.cars.CarsScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CarsScreen.lambda$0$1(CarsScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
        ImageView mainPageExitButton = bind.mainPageExitButton;
        Intrinsics.checkNotNullExpressionValue(mainPageExitButton, "mainPageExitButton");
        EasyAnimation.animateClick$default(easyAnimation3, mainPageExitButton, 0L, null, new Function0() { // from class: ru.mrlargha.cars.CarsScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CarsScreen.lambda$0$2(CarsScreen.this);
            }
        }, 3, null);
        if (!UtilsKt.isArizonaType()) {
            bind.ratingBnt.setVisibility(0);
            bind.ratingBnt1.setVisibility(0);
            bind.ratingBnt.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.cars.CarsScreen$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SAMPUIElement.notifyClick$default(CarsScreen.this, 0, 6, null, 4, null);
                }
            });
            bind.ratingBnt1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.cars.CarsScreen$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SAMPUIElement.notifyClick$default(CarsScreen.this, 0, 6, null, 4, null);
                }
            });
        } else {
            bind.ratingBnt.setVisibility(8);
            bind.ratingBnt1.setVisibility(8);
        }
        bind.overlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.cars.CarsScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CarsScreen._init_$lambda$1(CarsScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit carInfoSecondScreenListAdapter$lambda$0(CarsScreen carsScreen, int i) {
        carsScreen.onQuality(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(CarsScreen carsScreen) {
        SAMPUIElement.notifyClick$default(carsScreen, 0, 3, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(CarsScreen carsScreen) {
        SAMPUIElement.notifyClick$default(carsScreen, 0, 4, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(CarsScreen carsScreen) {
        SAMPUIElement.notifyClick$default(carsScreen, 0, 4, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(CarsScreen carsScreen, View view) {
        carsScreen.binding.overlay.setVisibility(8);
        carsScreen.binding.cardInfo.setVisibility(8);
    }

    private final void onQuality(int i) {
        this.binding.cardInfo.setVisibility(0);
        this.binding.overlay.setVisibility(0);
        if (i == 1) {
            this.binding.bonusTitle.setText("Недостатки:");
        } else {
            this.binding.bonusTitle.setText("Бонусы:");
        }
        String str = "#9A9A9A";
        if (i != 1) {
            if (i == 2) {
                str = "#00FFFF";
            } else if (i == 4) {
                str = "#FFCC00";
            }
        }
        this.binding.textBonus.setText(ru.mrlargha.commonui.utils.ui.UtilsKt.buildSpannableList(this.bonuses, Color.parseColor("#223144"), true, Integer.valueOf(Color.parseColor(str)), true));
    }

    private final void setCarInfoList(List<CarInfoListItem> list) {
        this.binding.overlay.setVisibility(8);
        this.binding.cardInfo.setVisibility(8);
        CarsLayoutBinding carsLayoutBinding = this.binding;
        carsLayoutBinding.secondPage.setVisibility(8);
        carsLayoutBinding.mainPage.setVisibility(0);
        for (CarInfoListItem carInfoListItem : list) {
            boolean z = false;
            for (CarInfoListItem carInfoListItem2 : this.carsItemList) {
                if (carInfoListItem2.getId() == carInfoListItem.getId()) {
                    carInfoListItem2.setTitle(carInfoListItem.getTitle());
                    carInfoListItem2.setSysName(carInfoListItem.getSysName());
                    carInfoListItem2.setStatus(carInfoListItem.getStatus());
                    carInfoListItem2.setLabels(carInfoListItem.getLabels());
                    carInfoListItem2.setStatusButton(carInfoListItem.getStatusButton());
                    carInfoListItem2.setNameButton(carInfoListItem.getNameButton());
                    z = true;
                }
            }
            if (!z) {
                this.carsItemList.add(carInfoListItem);
            }
        }
        List<CarInfoListItem> list2 = this.carsItemList;
        if (list2.size() > 1) {
            CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.cars.CarsScreen$setCarInfoList$$inlined$sortByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Boolean.valueOf(Intrinsics.areEqual(((CarInfoListItem) t2).getStatus(), "loaded")), Boolean.valueOf(Intrinsics.areEqual(((CarInfoListItem) t).getStatus(), "loaded")));
                }
            });
        }
        CarInfoListAdapter carInfoListAdapter = this.carInfoListAdapter;
        List<CarInfoListItem> list3 = this.carsItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (CarInfoListItem carInfoListItem3 : list3) {
            arrayList.add(CarInfoListItem.copy$default(carInfoListItem3, 0, null, null, 0, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null));
        }
        carInfoListAdapter.submitList(arrayList);
    }

    private final void setSlotsInfo(int i, int i2) {
        CarsLayoutBinding carsLayoutBinding = this.binding;
        String obj = carsLayoutBinding.slotsOccupied.getText().toString();
        List split$default = StringsKt.split$default((CharSequence) obj, new char[]{'/'}, false, 0, 6, (Object) null);
        String str = (String) split$default.get(i2);
        String replace$default = StringsKt.replace$default(str, str, String.valueOf(i), false, 4, (Object) null);
        if (i2 == 0) {
            TextView textView = carsLayoutBinding.slotsOccupied;
            String substring = obj.substring(str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            textView.setText(replace$default + substring);
            return;
        }
        carsLayoutBinding.slotsOccupied.setText(split$default.get(0) + "/" + replace$default);
    }

    private final void setToggleSwitchInfo(List<ToggleSwitchInfo> list) {
        for (ToggleSwitchInfo toggleSwitchInfo : list) {
            boolean z = false;
            for (ToggleSwitchInfo toggleSwitchInfo2 : this.toggleSwitchItemList) {
                if (toggleSwitchInfo2.getId() == toggleSwitchInfo.getId()) {
                    toggleSwitchInfo2.setTitle(toggleSwitchInfo.getTitle());
                    toggleSwitchInfo2.setValue(toggleSwitchInfo.getValue());
                    z = true;
                }
            }
            if (!z) {
                this.toggleSwitchItemList.add(toggleSwitchInfo);
            }
        }
        ToggleSwitchListAdapter toggleSwitchListAdapter = this.toggleSwitchListAdapter;
        List<ToggleSwitchInfo> list2 = this.toggleSwitchItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ToggleSwitchInfo toggleSwitchInfo3 : list2) {
            arrayList.add(ToggleSwitchInfo.copy$default(toggleSwitchInfo3, 0, null, 0, 7, null));
        }
        toggleSwitchListAdapter.submitList(arrayList);
    }

    private final void setActionButtonsInfo(List<ActionButtonInfo> list) {
        this.actionButtonItemList.clear();
        for (ActionButtonInfo actionButtonInfo : list) {
            boolean z = false;
            for (ActionButtonInfo actionButtonInfo2 : this.actionButtonItemList) {
                if (actionButtonInfo2.getId() == actionButtonInfo.getId()) {
                    actionButtonInfo2.setTitle(actionButtonInfo.getTitle());
                    actionButtonInfo2.setIcon(actionButtonInfo.getIcon());
                    z = true;
                }
            }
            if (!z) {
                this.actionButtonItemList.add(actionButtonInfo);
            }
        }
        ActionsListAdapter actionsListAdapter = this.actionsListAdapter;
        List<ActionButtonInfo> list2 = this.actionButtonItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ActionButtonInfo actionButtonInfo3 : list2) {
            arrayList.add(ActionButtonInfo.copy$default(actionButtonInfo3, 0, null, null, null, 15, null));
        }
        actionsListAdapter.submitList(arrayList);
    }

    private final void setCircleProgressBarsInfo(List<CircleProgressBarInfo> list) {
        for (CircleProgressBarInfo circleProgressBarInfo : list) {
            boolean z = false;
            for (CircleProgressBarInfo circleProgressBarInfo2 : this.circleProgressBarItemList) {
                if (circleProgressBarInfo2.getId() == circleProgressBarInfo.getId()) {
                    circleProgressBarInfo2.setTitle(circleProgressBarInfo.getTitle());
                    circleProgressBarInfo2.setIcon(circleProgressBarInfo.getIcon());
                    circleProgressBarInfo2.setPostfix(circleProgressBarInfo.getPostfix());
                    circleProgressBarInfo2.setMaxValue(circleProgressBarInfo.getMaxValue());
                    circleProgressBarInfo2.setValue(circleProgressBarInfo.getValue());
                    z = true;
                }
            }
            if (!z) {
                this.circleProgressBarItemList.add(circleProgressBarInfo);
            }
        }
        CircleProgressbarListAdapter circleProgressbarListAdapter = this.circleProgressbarListAdapter;
        List<CircleProgressBarInfo> list2 = this.circleProgressBarItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (CircleProgressBarInfo circleProgressBarInfo3 : list2) {
            arrayList.add(CircleProgressBarInfo.copy$default(circleProgressBarInfo3, 0, null, null, 0, 0, null, 63, null));
        }
        circleProgressbarListAdapter.submitList(arrayList);
    }

    private final void setTextInfo(List<TextInfo> list) {
        for (TextInfo textInfo : list) {
            boolean z = false;
            for (TextInfo textInfo2 : this.textInfoItemList) {
                if (textInfo2.getId() == textInfo.getId()) {
                    textInfo2.setTitle(textInfo.getTitle());
                    textInfo2.setValue(textInfo.getValue());
                    z = true;
                }
            }
            if (!z) {
                this.textInfoItemList.add(textInfo);
            }
        }
        TextListAdapter textListAdapter = this.textListAdapter;
        List<TextInfo> list2 = this.textInfoItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (TextInfo textInfo3 : list2) {
            arrayList.add(TextInfo.copy$default(textInfo3, 0, null, null, 7, null));
        }
        textListAdapter.submitList(arrayList);
    }

    private final void setCarInfoSecondScreen(List<CarInfoSecondScreen> list) {
        new ArrayList(this.carInfoSecondScreenListAdapter.getCurrentList()).addAll(list);
        this.carInfoSecondScreenListAdapter.submitList(list);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            switch (i) {
                case 0:
                    setCarInfoList(MapperKt.toListModel(data, CarInfoListItem.class));
                    return;
                case 1:
                    setSlotsInfo(Integer.parseInt(data), 0);
                    return;
                case 2:
                    setSlotsInfo(Integer.parseInt(data), 1);
                    return;
                case 3:
                    setToggleSwitchInfo(MapperKt.toListModel(data, ToggleSwitchInfo.class));
                    return;
                case 4:
                    setActionButtonsInfo(MapperKt.toListModel(data, ActionButtonInfo.class));
                    return;
                case 5:
                    setCircleProgressBarsInfo(MapperKt.toListModel(data, CircleProgressBarInfo.class));
                    return;
                case 6:
                    setTextInfo(MapperKt.toListModel(data, TextInfo.class));
                    return;
                case 7:
                    setCarInfoSecondScreen(MapperKt.toListModel(data, CarInfoSecondScreen.class));
                    return;
                case 8:
                    this.binding.carName.setText(data);
                    return;
                case 9:
                    CarsLayoutBinding carsLayoutBinding = this.binding;
                    carsLayoutBinding.mainPage.setVisibility(8);
                    carsLayoutBinding.secondPage.setVisibility(0);
                    return;
                case 10:
                    if (MapperKt.isJsonValid(data)) {
                        setCarRarity((CarsRarity) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) CarsRarity.class));
                        return;
                    }
                    throw new JsonParseException("Json is not valid");
                case 11:
                    this.bonuses = MapperKt.toListModel(data, String.class);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("cars", data + "  " + e.getMessage());
            Toast.makeText(getTargetActivity().getApplicationContext(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
        }
    }

    private final void setCarRarity(CarsRarity carsRarity) {
        ArrayList arrayList = new ArrayList(this.carInfoSecondScreenListAdapter.getCurrentList());
        ArrayList arrayList2 = arrayList;
        CarInfoSecondScreen carInfoSecondScreen = (CarInfoSecondScreen) CollectionsKt.lastOrNull((List<? extends Object>) arrayList2);
        if ((carInfoSecondScreen != null ? carInfoSecondScreen.getRarity() : null) == null) {
            arrayList.add(new CarInfoSecondScreen(null, null, carsRarity, 3, null));
            this.carInfoSecondScreenListAdapter.submitList(arrayList2);
        }
    }

    /* compiled from: CarsScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/cars/CarsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "cars_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.CARS);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CarsScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
