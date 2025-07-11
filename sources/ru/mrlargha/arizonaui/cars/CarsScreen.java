package ru.mrlargha.arizonaui.cars;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.utils.EasyAnimation;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.cars.ActionsListAdapter;
import ru.mrlargha.arizonaui.cars.CarInfoListAdapter;
import ru.mrlargha.arizonaui.cars.CarsScreen;
import ru.mrlargha.arizonaui.cars.ToggleSwitchListAdapter;
import ru.mrlargha.arizonaui.databinding.CarsLayoutBinding;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: CarsScreen.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u000256B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0&H\u0002J\u0018\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0016\u0010*\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0&H\u0002J\u0016\u0010,\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0&H\u0002J\u0016\u0010-\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020 0&H\u0002J\u0016\u0010.\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0&H\u0002J\u0016\u0010/\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002000&H\u0002J\u0018\u00101\u001a\u00020$2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarsScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", TtmlNode.TAG_LAYOUT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/arizonaui/databinding/CarsLayoutBinding;", "carInfoListAdapter", "Lru/mrlargha/arizonaui/cars/CarInfoListAdapter;", "toggleSwitchListAdapter", "Lru/mrlargha/arizonaui/cars/ToggleSwitchListAdapter;", "actionsListAdapter", "Lru/mrlargha/arizonaui/cars/ActionsListAdapter;", "circleProgressbarListAdapter", "Lru/mrlargha/arizonaui/cars/CircleProgressbarListAdapter;", "carInfoSecondScreenListAdapter", "Lru/mrlargha/arizonaui/cars/CarInfoSecondScreenListAdapter;", "textListAdapter", "Lru/mrlargha/arizonaui/cars/TextListAdapter;", "carsItemList", "", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$CarInfoListItem;", "toggleSwitchItemList", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$ToggleSwitchInfo;", "actionButtonItemList", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$ActionButtonInfo;", "circleProgressBarItemList", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$CircleProgressBarInfo;", "textInfoItemList", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$TextInfo;", "setCarInfoList", "", "carInfoList", "", "setSlotsInfo", "slotsCount", "partCount", "setToggleSwitchInfo", "infoList", "setActionButtonsInfo", "setCircleProgressBarsInfo", "setTextInfo", "setCarInfoSecondScreen", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$CarInfoSecondScreen;", "onBackendMessage", "data", "", "subId", "Companion", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CarsScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final List<Companion.ActionButtonInfo> actionButtonItemList;
    private final ActionsListAdapter actionsListAdapter;
    private final CarsLayoutBinding binding;
    private final CarInfoListAdapter carInfoListAdapter;
    private final CarInfoSecondScreenListAdapter carInfoSecondScreenListAdapter;
    private List<Companion.CarInfoListItem> carsItemList;
    private final List<Companion.CircleProgressBarInfo> circleProgressBarItemList;
    private final CircleProgressbarListAdapter circleProgressbarListAdapter;
    private final ConstraintLayout layout;
    private final List<Companion.TextInfo> textInfoItemList;
    private final TextListAdapter textListAdapter;
    private final List<Companion.ToggleSwitchInfo> toggleSwitchItemList;
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
        CarInfoListAdapter carInfoListAdapter = new CarInfoListAdapter();
        this.carInfoListAdapter = carInfoListAdapter;
        ToggleSwitchListAdapter toggleSwitchListAdapter = new ToggleSwitchListAdapter(targetActivity);
        this.toggleSwitchListAdapter = toggleSwitchListAdapter;
        ActionsListAdapter actionsListAdapter = new ActionsListAdapter(targetActivity);
        this.actionsListAdapter = actionsListAdapter;
        CircleProgressbarListAdapter circleProgressbarListAdapter = new CircleProgressbarListAdapter(targetActivity);
        this.circleProgressbarListAdapter = circleProgressbarListAdapter;
        CarInfoSecondScreenListAdapter carInfoSecondScreenListAdapter = new CarInfoSecondScreenListAdapter(targetActivity);
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
        carInfoListAdapter.setOnCarInfoClickListener(new CarInfoListAdapter.OnCarInfoClickListener() { // from class: ru.mrlargha.arizonaui.cars.CarsScreen$1$1
            @Override // ru.mrlargha.arizonaui.cars.CarInfoListAdapter.OnCarInfoClickListener
            public void onCarInfoClickListener(int i2) {
                List list;
                list = CarsScreen.this.carsItemList;
                list.clear();
                SAMPUIElement.notifyClick$default(CarsScreen.this, i2, 0, null, 4, null);
            }
        });
        carInfoListAdapter.setOnSpawnClickListener(new CarInfoListAdapter.OnSpawnClickListener() { // from class: ru.mrlargha.arizonaui.cars.CarsScreen$1$2
            @Override // ru.mrlargha.arizonaui.cars.CarInfoListAdapter.OnSpawnClickListener
            public void onSpawnClickListener(int i2) {
                List list;
                list = CarsScreen.this.carsItemList;
                list.clear();
                SAMPUIElement.notifyClick$default(CarsScreen.this, i2, 5, null, 4, null);
            }
        });
        bind.secondPageCarSwitchRc.setAdapter(toggleSwitchListAdapter);
        toggleSwitchListAdapter.setOnSwitchClickListener(new ToggleSwitchListAdapter.OnSwitchClickListener() { // from class: ru.mrlargha.arizonaui.cars.CarsScreen$1$3
            @Override // ru.mrlargha.arizonaui.cars.ToggleSwitchListAdapter.OnSwitchClickListener
            public void onSwitchClickListener(int i2) {
                SAMPUIElement.notifyClick$default(CarsScreen.this, i2, 1, null, 4, null);
            }
        });
        bind.secondPageCarActionsRc.setAdapter(actionsListAdapter);
        actionsListAdapter.setOnActionClickListener(new ActionsListAdapter.OnActionClickListener() { // from class: ru.mrlargha.arizonaui.cars.CarsScreen$1$4
            @Override // ru.mrlargha.arizonaui.cars.ActionsListAdapter.OnActionClickListener
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
        EasyAnimation.animateClick$default(easyAnimation, secondPageBackButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.cars.CarsScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CarsScreen.lambda$3$lambda$0(CarsScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView secondPageExitButton = bind.secondPageExitButton;
        Intrinsics.checkNotNullExpressionValue(secondPageExitButton, "secondPageExitButton");
        EasyAnimation.animateClick$default(easyAnimation2, secondPageExitButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.cars.CarsScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CarsScreen.lambda$3$lambda$1(CarsScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
        ImageView mainPageExitButton = bind.mainPageExitButton;
        Intrinsics.checkNotNullExpressionValue(mainPageExitButton, "mainPageExitButton");
        EasyAnimation.animateClick$default(easyAnimation3, mainPageExitButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.cars.CarsScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CarsScreen.lambda$3$lambda$2(CarsScreen.this);
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$3$lambda$0(CarsScreen carsScreen) {
        SAMPUIElement.notifyClick$default(carsScreen, 0, 3, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$3$lambda$1(CarsScreen carsScreen) {
        SAMPUIElement.notifyClick$default(carsScreen, 0, 4, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$3$lambda$2(CarsScreen carsScreen) {
        SAMPUIElement.notifyClick$default(carsScreen, 0, 4, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void setCarInfoList(List<Companion.CarInfoListItem> list) {
        CarsLayoutBinding carsLayoutBinding = this.binding;
        carsLayoutBinding.secondPage.setVisibility(8);
        carsLayoutBinding.mainPage.setVisibility(0);
        for (Companion.CarInfoListItem carInfoListItem : list) {
            boolean z = false;
            for (Companion.CarInfoListItem carInfoListItem2 : this.carsItemList) {
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
        List<Companion.CarInfoListItem> list2 = this.carsItemList;
        if (list2.size() > 1) {
            CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.arizonaui.cars.CarsScreen$setCarInfoList$$inlined$sortByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Boolean.valueOf(Intrinsics.areEqual(((CarsScreen.Companion.CarInfoListItem) t2).getStatus(), "loaded")), Boolean.valueOf(Intrinsics.areEqual(((CarsScreen.Companion.CarInfoListItem) t).getStatus(), "loaded")));
                }
            });
        }
        CarInfoListAdapter carInfoListAdapter = this.carInfoListAdapter;
        List<Companion.CarInfoListItem> list3 = this.carsItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (Companion.CarInfoListItem carInfoListItem3 : list3) {
            arrayList.add(Companion.CarInfoListItem.copy$default(carInfoListItem3, 0, null, null, 0, null, null, null, 127, null));
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
        carsLayoutBinding.slotsOccupied.setText(split$default.get(0) + RemoteSettings.FORWARD_SLASH_STRING + replace$default);
    }

    private final void setToggleSwitchInfo(List<Companion.ToggleSwitchInfo> list) {
        for (Companion.ToggleSwitchInfo toggleSwitchInfo : list) {
            boolean z = false;
            for (Companion.ToggleSwitchInfo toggleSwitchInfo2 : this.toggleSwitchItemList) {
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
        List<Companion.ToggleSwitchInfo> list2 = this.toggleSwitchItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Companion.ToggleSwitchInfo toggleSwitchInfo3 : list2) {
            arrayList.add(Companion.ToggleSwitchInfo.copy$default(toggleSwitchInfo3, 0, null, 0, 7, null));
        }
        toggleSwitchListAdapter.submitList(arrayList);
    }

    private final void setActionButtonsInfo(List<Companion.ActionButtonInfo> list) {
        this.actionButtonItemList.clear();
        for (Companion.ActionButtonInfo actionButtonInfo : list) {
            boolean z = false;
            for (Companion.ActionButtonInfo actionButtonInfo2 : this.actionButtonItemList) {
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
        List<Companion.ActionButtonInfo> list2 = this.actionButtonItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Companion.ActionButtonInfo actionButtonInfo3 : list2) {
            arrayList.add(Companion.ActionButtonInfo.copy$default(actionButtonInfo3, 0, null, null, 7, null));
        }
        actionsListAdapter.submitList(arrayList);
    }

    private final void setCircleProgressBarsInfo(List<Companion.CircleProgressBarInfo> list) {
        for (Companion.CircleProgressBarInfo circleProgressBarInfo : list) {
            boolean z = false;
            for (Companion.CircleProgressBarInfo circleProgressBarInfo2 : this.circleProgressBarItemList) {
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
        List<Companion.CircleProgressBarInfo> list2 = this.circleProgressBarItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Companion.CircleProgressBarInfo circleProgressBarInfo3 : list2) {
            arrayList.add(Companion.CircleProgressBarInfo.copy$default(circleProgressBarInfo3, 0, null, null, 0, 0, null, 63, null));
        }
        circleProgressbarListAdapter.submitList(arrayList);
    }

    private final void setTextInfo(List<Companion.TextInfo> list) {
        for (Companion.TextInfo textInfo : list) {
            boolean z = false;
            for (Companion.TextInfo textInfo2 : this.textInfoItemList) {
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
        List<Companion.TextInfo> list2 = this.textInfoItemList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Companion.TextInfo textInfo3 : list2) {
            arrayList.add(Companion.TextInfo.copy$default(textInfo3, 0, null, null, 7, null));
        }
        textListAdapter.submitList(arrayList);
    }

    private final void setCarInfoSecondScreen(List<Companion.CarInfoSecondScreen> list) {
        new ArrayList(this.carInfoSecondScreenListAdapter.getCurrentList()).addAll(list);
        this.carInfoSecondScreenListAdapter.submitList(list);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        switch (i) {
            case 0:
                setCarInfoList(MapperKt.toListModel(data, Companion.CarInfoListItem.class));
                return;
            case 1:
                setSlotsInfo(Integer.parseInt(data), 0);
                return;
            case 2:
                setSlotsInfo(Integer.parseInt(data), 1);
                return;
            case 3:
                setToggleSwitchInfo(MapperKt.toListModel(data, Companion.ToggleSwitchInfo.class));
                return;
            case 4:
                setActionButtonsInfo(MapperKt.toListModel(data, Companion.ActionButtonInfo.class));
                return;
            case 5:
                setCircleProgressBarsInfo(MapperKt.toListModel(data, Companion.CircleProgressBarInfo.class));
                return;
            case 6:
                setTextInfo(MapperKt.toListModel(data, Companion.TextInfo.class));
                return;
            case 7:
                setCarInfoSecondScreen(MapperKt.toListModel(data, Companion.CarInfoSecondScreen.class));
                return;
            case 8:
                this.binding.carName.setText(data);
                return;
            case 9:
                CarsLayoutBinding carsLayoutBinding = this.binding;
                carsLayoutBinding.mainPage.setVisibility(8);
                carsLayoutBinding.secondPage.setVisibility(0);
                return;
            default:
                return;
        }
    }

    /* compiled from: CarsScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarsScreen$Companion;", "", "<init>", "()V", "CarInfoListItem", "LabelInfo", "ToggleSwitchInfo", "ActionButtonInfo", "CircleProgressBarInfo", "TextInfo", "CarInfoSecondScreen", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: CarsScreen.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JU\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006/"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$CarInfoListItem;", "", "id", "", "title", "", "sysName", "statusButton", "nameButton", NotificationCompat.CATEGORY_STATUS, "labels", "", "Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$LabelInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getSysName", "setSysName", "getStatusButton", "setStatusButton", "(I)V", "getNameButton", "setNameButton", "getStatus", "setStatus", "getLabels", "()Ljava/util/List;", "setLabels", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class CarInfoListItem {
            private final int id;
            private List<LabelInfo> labels;
            private String nameButton;
            private String status;
            private int statusButton;
            private String sysName;
            private String title;

            public static /* synthetic */ CarInfoListItem copy$default(CarInfoListItem carInfoListItem, int i, String str, String str2, int i2, String str3, String str4, List list, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = carInfoListItem.id;
                }
                if ((i3 & 2) != 0) {
                    str = carInfoListItem.title;
                }
                if ((i3 & 4) != 0) {
                    str2 = carInfoListItem.sysName;
                }
                if ((i3 & 8) != 0) {
                    i2 = carInfoListItem.statusButton;
                }
                if ((i3 & 16) != 0) {
                    str3 = carInfoListItem.nameButton;
                }
                if ((i3 & 32) != 0) {
                    str4 = carInfoListItem.status;
                }
                List<LabelInfo> list2 = list;
                if ((i3 & 64) != 0) {
                    list2 = carInfoListItem.labels;
                }
                String str5 = str4;
                List list3 = list2;
                String str6 = str3;
                String str7 = str2;
                return carInfoListItem.copy(i, str, str7, i2, str6, str5, list3);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.sysName;
            }

            public final int component4() {
                return this.statusButton;
            }

            public final String component5() {
                return this.nameButton;
            }

            public final String component6() {
                return this.status;
            }

            public final List<LabelInfo> component7() {
                return this.labels;
            }

            public final CarInfoListItem copy(int i, String title, String sysName, int i2, String nameButton, String status, List<LabelInfo> labels) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(sysName, "sysName");
                Intrinsics.checkNotNullParameter(nameButton, "nameButton");
                Intrinsics.checkNotNullParameter(status, "status");
                Intrinsics.checkNotNullParameter(labels, "labels");
                return new CarInfoListItem(i, title, sysName, i2, nameButton, status, labels);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof CarInfoListItem) {
                    CarInfoListItem carInfoListItem = (CarInfoListItem) obj;
                    return this.id == carInfoListItem.id && Intrinsics.areEqual(this.title, carInfoListItem.title) && Intrinsics.areEqual(this.sysName, carInfoListItem.sysName) && this.statusButton == carInfoListItem.statusButton && Intrinsics.areEqual(this.nameButton, carInfoListItem.nameButton) && Intrinsics.areEqual(this.status, carInfoListItem.status) && Intrinsics.areEqual(this.labels, carInfoListItem.labels);
                }
                return false;
            }

            public int hashCode() {
                return (((((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.sysName.hashCode()) * 31) + Integer.hashCode(this.statusButton)) * 31) + this.nameButton.hashCode()) * 31) + this.status.hashCode()) * 31) + this.labels.hashCode();
            }

            public String toString() {
                int i = this.id;
                String str = this.title;
                String str2 = this.sysName;
                int i2 = this.statusButton;
                String str3 = this.nameButton;
                String str4 = this.status;
                return "CarInfoListItem(id=" + i + ", title=" + str + ", sysName=" + str2 + ", statusButton=" + i2 + ", nameButton=" + str3 + ", status=" + str4 + ", labels=" + this.labels + ")";
            }

            public CarInfoListItem(int i, String title, String sysName, int i2, String nameButton, String status, List<LabelInfo> labels) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(sysName, "sysName");
                Intrinsics.checkNotNullParameter(nameButton, "nameButton");
                Intrinsics.checkNotNullParameter(status, "status");
                Intrinsics.checkNotNullParameter(labels, "labels");
                this.id = i;
                this.title = title;
                this.sysName = sysName;
                this.statusButton = i2;
                this.nameButton = nameButton;
                this.status = status;
                this.labels = labels;
            }

            public final int getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setTitle(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.title = str;
            }

            public final String getSysName() {
                return this.sysName;
            }

            public final void setSysName(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.sysName = str;
            }

            public final int getStatusButton() {
                return this.statusButton;
            }

            public final void setStatusButton(int i) {
                this.statusButton = i;
            }

            public final String getNameButton() {
                return this.nameButton;
            }

            public final void setNameButton(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.nameButton = str;
            }

            public final String getStatus() {
                return this.status;
            }

            public final void setStatus(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.status = str;
            }

            public final List<LabelInfo> getLabels() {
                return this.labels;
            }

            public final void setLabels(List<LabelInfo> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.labels = list;
            }
        }

        private Companion() {
        }

        /* compiled from: CarsScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$LabelInfo;", "", "title", "", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class LabelInfo {
            private final String icon;
            private final String title;

            public static /* synthetic */ LabelInfo copy$default(LabelInfo labelInfo, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = labelInfo.title;
                }
                if ((i & 2) != 0) {
                    str2 = labelInfo.icon;
                }
                return labelInfo.copy(str, str2);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.icon;
            }

            public final LabelInfo copy(String title, String icon) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(icon, "icon");
                return new LabelInfo(title, icon);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LabelInfo) {
                    LabelInfo labelInfo = (LabelInfo) obj;
                    return Intrinsics.areEqual(this.title, labelInfo.title) && Intrinsics.areEqual(this.icon, labelInfo.icon);
                }
                return false;
            }

            public int hashCode() {
                return (this.title.hashCode() * 31) + this.icon.hashCode();
            }

            public String toString() {
                String str = this.title;
                return "LabelInfo(title=" + str + ", icon=" + this.icon + ")";
            }

            public LabelInfo(String title, String icon) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(icon, "icon");
                this.title = title;
                this.icon = icon;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getTitle() {
                return this.title;
            }
        }

        /* compiled from: CarsScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$ToggleSwitchInfo;", "", "id", "", "title", "", "value", "<init>", "(ILjava/lang/String;I)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getValue", "setValue", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class ToggleSwitchInfo {
            private final int id;
            private String title;
            private int value;

            public static /* synthetic */ ToggleSwitchInfo copy$default(ToggleSwitchInfo toggleSwitchInfo, int i, String str, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = toggleSwitchInfo.id;
                }
                if ((i3 & 2) != 0) {
                    str = toggleSwitchInfo.title;
                }
                if ((i3 & 4) != 0) {
                    i2 = toggleSwitchInfo.value;
                }
                return toggleSwitchInfo.copy(i, str, i2);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.title;
            }

            public final int component3() {
                return this.value;
            }

            public final ToggleSwitchInfo copy(int i, String title, int i2) {
                Intrinsics.checkNotNullParameter(title, "title");
                return new ToggleSwitchInfo(i, title, i2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ToggleSwitchInfo) {
                    ToggleSwitchInfo toggleSwitchInfo = (ToggleSwitchInfo) obj;
                    return this.id == toggleSwitchInfo.id && Intrinsics.areEqual(this.title, toggleSwitchInfo.title) && this.value == toggleSwitchInfo.value;
                }
                return false;
            }

            public int hashCode() {
                return (((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.value);
            }

            public String toString() {
                int i = this.id;
                String str = this.title;
                return "ToggleSwitchInfo(id=" + i + ", title=" + str + ", value=" + this.value + ")";
            }

            public ToggleSwitchInfo(int i, String title, int i2) {
                Intrinsics.checkNotNullParameter(title, "title");
                this.id = i;
                this.title = title;
                this.value = i2;
            }

            public final int getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final int getValue() {
                return this.value;
            }

            public final void setTitle(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.title = str;
            }

            public final void setValue(int i) {
                this.value = i;
            }
        }

        /* compiled from: CarsScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$ActionButtonInfo;", "", "id", "", "title", "", "icon", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getIcon", "setIcon", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class ActionButtonInfo {
            private String icon;
            private final int id;
            private String title;

            public static /* synthetic */ ActionButtonInfo copy$default(ActionButtonInfo actionButtonInfo, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = actionButtonInfo.id;
                }
                if ((i2 & 2) != 0) {
                    str = actionButtonInfo.title;
                }
                if ((i2 & 4) != 0) {
                    str2 = actionButtonInfo.icon;
                }
                return actionButtonInfo.copy(i, str, str2);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.icon;
            }

            public final ActionButtonInfo copy(int i, String title, String icon) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(icon, "icon");
                return new ActionButtonInfo(i, title, icon);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ActionButtonInfo) {
                    ActionButtonInfo actionButtonInfo = (ActionButtonInfo) obj;
                    return this.id == actionButtonInfo.id && Intrinsics.areEqual(this.title, actionButtonInfo.title) && Intrinsics.areEqual(this.icon, actionButtonInfo.icon);
                }
                return false;
            }

            public int hashCode() {
                return (((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode();
            }

            public String toString() {
                int i = this.id;
                String str = this.title;
                return "ActionButtonInfo(id=" + i + ", title=" + str + ", icon=" + this.icon + ")";
            }

            public ActionButtonInfo(int i, String title, String icon) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(icon, "icon");
                this.id = i;
                this.title = title;
                this.icon = icon;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final int getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setIcon(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.icon = str;
            }

            public final void setTitle(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.title = str;
            }
        }

        /* compiled from: CarsScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006'"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$CircleProgressBarInfo;", "", "id", "", "title", "", "icon", "value", "maxValue", "postfix", "<init>", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getValue", "setValue", "(I)V", "getMaxValue", "setMaxValue", "getPostfix", "setPostfix", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class CircleProgressBarInfo {
            private String icon;
            private final int id;
            private int maxValue;
            private String postfix;
            private String title;
            private int value;

            public static /* synthetic */ CircleProgressBarInfo copy$default(CircleProgressBarInfo circleProgressBarInfo, int i, String str, String str2, int i2, int i3, String str3, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i = circleProgressBarInfo.id;
                }
                if ((i4 & 2) != 0) {
                    str = circleProgressBarInfo.title;
                }
                if ((i4 & 4) != 0) {
                    str2 = circleProgressBarInfo.icon;
                }
                if ((i4 & 8) != 0) {
                    i2 = circleProgressBarInfo.value;
                }
                if ((i4 & 16) != 0) {
                    i3 = circleProgressBarInfo.maxValue;
                }
                if ((i4 & 32) != 0) {
                    str3 = circleProgressBarInfo.postfix;
                }
                int i5 = i3;
                String str4 = str3;
                return circleProgressBarInfo.copy(i, str, str2, i2, i5, str4);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.icon;
            }

            public final int component4() {
                return this.value;
            }

            public final int component5() {
                return this.maxValue;
            }

            public final String component6() {
                return this.postfix;
            }

            public final CircleProgressBarInfo copy(int i, String title, String icon, int i2, int i3, String postfix) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(icon, "icon");
                Intrinsics.checkNotNullParameter(postfix, "postfix");
                return new CircleProgressBarInfo(i, title, icon, i2, i3, postfix);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof CircleProgressBarInfo) {
                    CircleProgressBarInfo circleProgressBarInfo = (CircleProgressBarInfo) obj;
                    return this.id == circleProgressBarInfo.id && Intrinsics.areEqual(this.title, circleProgressBarInfo.title) && Intrinsics.areEqual(this.icon, circleProgressBarInfo.icon) && this.value == circleProgressBarInfo.value && this.maxValue == circleProgressBarInfo.maxValue && Intrinsics.areEqual(this.postfix, circleProgressBarInfo.postfix);
                }
                return false;
            }

            public int hashCode() {
                return (((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31) + Integer.hashCode(this.value)) * 31) + Integer.hashCode(this.maxValue)) * 31) + this.postfix.hashCode();
            }

            public String toString() {
                int i = this.id;
                String str = this.title;
                String str2 = this.icon;
                int i2 = this.value;
                int i3 = this.maxValue;
                return "CircleProgressBarInfo(id=" + i + ", title=" + str + ", icon=" + str2 + ", value=" + i2 + ", maxValue=" + i3 + ", postfix=" + this.postfix + ")";
            }

            public CircleProgressBarInfo(int i, String title, String icon, int i2, int i3, String postfix) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(icon, "icon");
                Intrinsics.checkNotNullParameter(postfix, "postfix");
                this.id = i;
                this.title = title;
                this.icon = icon;
                this.value = i2;
                this.maxValue = i3;
                this.postfix = postfix;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final int getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setIcon(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.icon = str;
            }

            public final void setTitle(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.title = str;
            }

            public final int getMaxValue() {
                return this.maxValue;
            }

            public final String getPostfix() {
                return this.postfix;
            }

            public final int getValue() {
                return this.value;
            }

            public final void setMaxValue(int i) {
                this.maxValue = i;
            }

            public final void setPostfix(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.postfix = str;
            }

            public final void setValue(int i) {
                this.value = i;
            }
        }

        /* compiled from: CarsScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$TextInfo;", "", "id", "", "title", "", "value", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getValue", "setValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class TextInfo {
            private final int id;
            private String title;
            private String value;

            public static /* synthetic */ TextInfo copy$default(TextInfo textInfo, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = textInfo.id;
                }
                if ((i2 & 2) != 0) {
                    str = textInfo.title;
                }
                if ((i2 & 4) != 0) {
                    str2 = textInfo.value;
                }
                return textInfo.copy(i, str, str2);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.value;
            }

            public final TextInfo copy(int i, String title, String value) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                return new TextInfo(i, title, value);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TextInfo) {
                    TextInfo textInfo = (TextInfo) obj;
                    return this.id == textInfo.id && Intrinsics.areEqual(this.title, textInfo.title) && Intrinsics.areEqual(this.value, textInfo.value);
                }
                return false;
            }

            public int hashCode() {
                return (((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.value.hashCode();
            }

            public String toString() {
                int i = this.id;
                String str = this.title;
                return "TextInfo(id=" + i + ", title=" + str + ", value=" + this.value + ")";
            }

            public TextInfo(int i, String title, String value) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                this.id = i;
                this.title = title;
                this.value = value;
            }

            public final int getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getValue() {
                return this.value;
            }

            public final void setTitle(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.title = str;
            }

            public final void setValue(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.value = str;
            }
        }

        /* compiled from: CarsScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarsScreen$Companion$CarInfoSecondScreen;", "", "title", "", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "setIcon", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class CarInfoSecondScreen {
            private String icon;
            private final String title;

            public static /* synthetic */ CarInfoSecondScreen copy$default(CarInfoSecondScreen carInfoSecondScreen, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = carInfoSecondScreen.title;
                }
                if ((i & 2) != 0) {
                    str2 = carInfoSecondScreen.icon;
                }
                return carInfoSecondScreen.copy(str, str2);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.icon;
            }

            public final CarInfoSecondScreen copy(String title, String icon) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(icon, "icon");
                return new CarInfoSecondScreen(title, icon);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof CarInfoSecondScreen) {
                    CarInfoSecondScreen carInfoSecondScreen = (CarInfoSecondScreen) obj;
                    return Intrinsics.areEqual(this.title, carInfoSecondScreen.title) && Intrinsics.areEqual(this.icon, carInfoSecondScreen.icon);
                }
                return false;
            }

            public int hashCode() {
                return (this.title.hashCode() * 31) + this.icon.hashCode();
            }

            public String toString() {
                String str = this.title;
                return "CarInfoSecondScreen(title=" + str + ", icon=" + this.icon + ")";
            }

            public CarInfoSecondScreen(String title, String icon) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(icon, "icon");
                this.title = title;
                this.icon = icon;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setIcon(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.icon = str;
            }
        }
    }

    /* compiled from: CarsScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/cars/CarsScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CarsScreen(targetActivity, i);
        }
    }
}
