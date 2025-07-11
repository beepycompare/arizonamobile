package ru.mrlargha.arizonaui.biz;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.utils.EasyAnimation;
import com.arizona.common.utils.LinearItemDecoration;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.biz.MyBusinessListAdapter;
import ru.mrlargha.arizonaui.biz.MyBusinessMenuAdapter;
import ru.mrlargha.arizonaui.biz.MyBusinessParentStatAdapter;
import ru.mrlargha.arizonaui.databinding.MyBizScreenBinding;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: MyBusinessScreen.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0019H\u0002J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "myBizScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/arizonaui/databinding/MyBizScreenBinding;", "bizListAdapter", "Lru/mrlargha/arizonaui/biz/MyBusinessListAdapter;", "mainBizStatAdapter", "Lru/mrlargha/arizonaui/biz/MyBusinessMainInfoAdapter;", "parentStatAdapter", "Lru/mrlargha/arizonaui/biz/MyBusinessParentStatAdapter;", "menuAdapter", "Lru/mrlargha/arizonaui/biz/MyBusinessMenuAdapter;", "currentPage", "currentBizId", "setBizList", "", "info", "", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$BusinessItemInfo;", "setMainBizInfo", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$MainBusinessInfo;", "setBizStat", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$BusinessDetailInfo;", "setMenuList", FirebaseAnalytics.Param.ITEMS, "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$MenuItem;", "onBackendMessage", "data", "", "subId", "setVisibility", "visible", "", "Companion", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBusinessScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final MyBizScreenBinding binding;
    private final MyBusinessListAdapter bizListAdapter;
    private int currentBizId;
    private int currentPage;
    private final MyBusinessMainInfoAdapter mainBizStatAdapter;
    private final MyBusinessMenuAdapter menuAdapter;
    private final ConstraintLayout myBizScreen;
    private final MyBusinessParentStatAdapter parentStatAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBusinessScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.my_biz_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.myBizScreen = constraintLayout;
        final MyBizScreenBinding bind = MyBizScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        MyBusinessListAdapter myBusinessListAdapter = new MyBusinessListAdapter();
        this.bizListAdapter = myBusinessListAdapter;
        MyBusinessMainInfoAdapter myBusinessMainInfoAdapter = new MyBusinessMainInfoAdapter();
        this.mainBizStatAdapter = myBusinessMainInfoAdapter;
        MyBusinessParentStatAdapter myBusinessParentStatAdapter = new MyBusinessParentStatAdapter();
        this.parentStatAdapter = myBusinessParentStatAdapter;
        MyBusinessMenuAdapter myBusinessMenuAdapter = new MyBusinessMenuAdapter();
        this.menuAdapter = myBusinessMenuAdapter;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.businessRc.setAdapter(myBusinessListAdapter);
        bind.businessMainStatRc.setAdapter(myBusinessMainInfoAdapter);
        bind.businessMainStatRc.addItemDecoration(new LinearItemDecoration(0.2372f, 1.0f, 0.0f));
        bind.parentStatRc.setAdapter(myBusinessParentStatAdapter);
        bind.menuRc.setAdapter(myBusinessMenuAdapter);
        myBusinessListAdapter.setOnBizClickListener(new MyBusinessListAdapter.OnBizClickListener() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessScreen$1$1
            @Override // ru.mrlargha.arizonaui.biz.MyBusinessListAdapter.OnBizClickListener
            public void callback(int i2) {
                SAMPUIElement.notifyClick$default(MyBusinessScreen.this, i2, 1, null, 4, null);
            }
        });
        myBusinessParentStatAdapter.setOnParentItemClickListener(new MyBusinessParentStatAdapter.OnParentItemClickListener() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessScreen$1$2
            @Override // ru.mrlargha.arizonaui.biz.MyBusinessParentStatAdapter.OnParentItemClickListener
            public void callback(int i2) {
                SAMPUIElement.notifyClick$default(MyBusinessScreen.this, i2, 6, null, 4, null);
            }
        });
        myBusinessMenuAdapter.setOnParentItemClickListener(new MyBusinessMenuAdapter.OnParentItemClickListener() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessScreen$1$3
            @Override // ru.mrlargha.arizonaui.biz.MyBusinessMenuAdapter.OnParentItemClickListener
            public void callback(int i2) {
                SAMPUIElement.notifyClick$default(MyBusinessScreen.this, i2, 2, null, 4, null);
            }
        });
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView backButton = bind.backButton;
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        EasyAnimation.animateClick$default(easyAnimation, backButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MyBusinessScreen.lambda$5$lambda$0(MyBusinessScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView exitButton = bind.exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        EasyAnimation.animateClick$default(easyAnimation2, exitButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MyBusinessScreen.lambda$5$lambda$1(MyBizScreenBinding.this, this);
            }
        }, 3, null);
        EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
        ConstraintLayout topUpButton = bind.topUpButton;
        Intrinsics.checkNotNullExpressionValue(topUpButton, "topUpButton");
        EasyAnimation.animateClick$default(easyAnimation3, topUpButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MyBusinessScreen.lambda$5$lambda$2(MyBusinessScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation4 = EasyAnimation.INSTANCE;
        ConstraintLayout withdrawButton = bind.withdrawButton;
        Intrinsics.checkNotNullExpressionValue(withdrawButton, "withdrawButton");
        EasyAnimation.animateClick$default(easyAnimation4, withdrawButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MyBusinessScreen.lambda$5$lambda$3(MyBusinessScreen.this);
            }
        }, 3, null);
        bind.openBizSwitch.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessScreen.lambda$5$lambda$4(MyBizScreenBinding.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$5$lambda$0(MyBusinessScreen myBusinessScreen) {
        SAMPUIElement.notifyClick$default(myBusinessScreen, 0, 5, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$5$lambda$1(MyBizScreenBinding myBizScreenBinding, MyBusinessScreen myBusinessScreen) {
        myBizScreenBinding.businessRc.getRecycledViewPool().clear();
        myBusinessScreen.bizListAdapter.clearBusinesses();
        SAMPUIElement.notifyClick$default(myBusinessScreen, 1, 5, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$5$lambda$2(MyBusinessScreen myBusinessScreen) {
        SAMPUIElement.notifyClick$default(myBusinessScreen, 0, 4, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$5$lambda$3(MyBusinessScreen myBusinessScreen) {
        SAMPUIElement.notifyClick$default(myBusinessScreen, 0, 3, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$5$lambda$4(MyBizScreenBinding myBizScreenBinding, MyBusinessScreen myBusinessScreen, View view) {
        if (!myBizScreenBinding.openBizSwitch.isChecked()) {
            myBizScreenBinding.bizStatus.setText("Закрыт");
            myBizScreenBinding.bizStatus.setTextColor(Color.parseColor("#F02A2A"));
            myBusinessScreen.notifyClick(0, 0, "1," + myBusinessScreen.currentBizId);
            return;
        }
        myBizScreenBinding.bizStatus.setText("Открыт");
        myBizScreenBinding.bizStatus.setTextColor(Color.parseColor("#60CA5D"));
        myBusinessScreen.notifyClick(0, 0, "0," + myBusinessScreen.currentBizId);
    }

    private final void setBizList(List<Companion.BusinessItemInfo> list) {
        MyBizScreenBinding myBizScreenBinding = this.binding;
        if (this.currentPage == 1) {
            myBizScreenBinding.businessRc.getRecycledViewPool().clear();
            this.bizListAdapter.clearBusinesses();
        }
        this.currentPage = 0;
        myBizScreenBinding.infoPage.setVisibility(8);
        myBizScreenBinding.mainPage.setVisibility(0);
        this.bizListAdapter.addBusinesses(list);
    }

    private final void setMainBizInfo(Companion.MainBusinessInfo mainBusinessInfo) {
        MyBizScreenBinding myBizScreenBinding = this.binding;
        this.mainBizStatAdapter.clearStat();
        this.menuAdapter.clearMenu();
        this.parentStatAdapter.clearStat();
        this.currentPage = 1;
        this.currentBizId = mainBusinessInfo.getId();
        myBizScreenBinding.mainPage.setVisibility(8);
        myBizScreenBinding.infoPage.setVisibility(0);
        myBizScreenBinding.balance.setText(String.valueOf(mainBusinessInfo.getBalance()));
        myBizScreenBinding.bizName.setText(mainBusinessInfo.getTitle());
        myBizScreenBinding.bizId.setText(String.valueOf(mainBusinessInfo.getId()));
        if (mainBusinessInfo.getOpened() == 1) {
            myBizScreenBinding.bizStatus.setText("Закрыт");
            myBizScreenBinding.bizStatus.setTextColor(Color.parseColor("#F02A2A"));
            myBizScreenBinding.openBizSwitch.setChecked(false);
        } else {
            myBizScreenBinding.bizStatus.setText("Открыт");
            myBizScreenBinding.bizStatus.setTextColor(Color.parseColor("#60CA5D"));
            myBizScreenBinding.openBizSwitch.setChecked(true);
        }
        this.mainBizStatAdapter.addStat(mainBusinessInfo.getStats());
        String type = mainBusinessInfo.getType();
        switch (type.hashCode()) {
            case -1884476133:
                if (type.equals("pawn-shop")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_pawn_shop_ic);
                    return;
                }
                return;
            case -1870138379:
                if (type.equals("phone-shop")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_phone_shop_ic);
                    return;
                }
                return;
            case -1568935349:
                if (type.equals("strip-club")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_strip_club_ic);
                    return;
                }
                return;
            case -1495947919:
                if (type.equals("food-stall")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_food_stall_ic);
                    return;
                }
                return;
            case -1494830709:
                if (type.equals("convenience-store")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_convience_shop_ic);
                    return;
                }
                return;
            case -1459051883:
                if (type.equals("oil-rig")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_oil_rig_ic);
                    return;
                }
                return;
            case -1370098047:
                if (type.equals("sport-palace")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_sport_palace_ic);
                    return;
                }
                return;
            case -1360334095:
                if (type.equals("cinema")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_cinema_ic);
                    return;
                }
                return;
            case -1155432426:
                if (type.equals("ad-banner")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_ad_banner_ic);
                    return;
                }
                return;
            case -868067634:
                if (type.equals("dance-school")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_dance_school_ic);
                    return;
                }
                return;
            case -593039331:
                if (type.equals("fuel-station")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_fuel_station_ic);
                    return;
                }
                return;
            case -486648565:
                if (type.equals("electronics-store")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_electronic_store_ic);
                    return;
                }
                return;
            case -410956671:
                if (type.equals(TtmlNode.RUBY_CONTAINER)) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_container_ic);
                    return;
                }
                return;
            case -353700040:
                if (type.equals("car-service-ls")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_car_service_ls_ic);
                    return;
                }
                return;
            case -353700037:
                if (type.equals("car-service-lv")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_car_service_lv_ic);
                    return;
                }
                return;
            case -353699836:
                if (type.equals("car-service-sf")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_car_service_sf_ic);
                    return;
                }
                return;
            case -190855083:
                if (type.equals("car-market")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_car_market_ic);
                    return;
                }
                return;
            case -58146414:
                if (type.equals("car-rent")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_car_rent_ic);
                    return;
                }
                return;
            case 97299:
                if (type.equals("bar")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_bar_ic);
                    return;
                }
                return;
            case 2997966:
                if (type.equals("ammo")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_gun_shop_ic);
                    return;
                }
                return;
            case 3135542:
                if (type.equals("farm")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_farm_ic);
                    return;
                }
                return;
            case 3351635:
                if (type.equals("mine")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_mine_ic);
                    return;
                }
                return;
            case 9905691:
                if (type.equals("clothing-shop")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_clothing_shop_ic);
                    return;
                }
                return;
            case 216982060:
                if (type.equals("clothing-workshop")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_clothing_workshop_ic);
                    return;
                }
                return;
            case 528422772:
                if (type.equals("plane-bike-rent")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_plane_bike_rent_ic);
                    return;
                }
                return;
            case 577622612:
                if (type.equals("info-center")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_info_center_ic);
                    return;
                }
                return;
            case 589562686:
                if (type.equals("horse-racing")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_horse_racing_ic);
                    return;
                }
                return;
            case 605823065:
                if (type.equals("fishing-shop")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_fishing_shop_ic);
                    return;
                }
                return;
            case 611988801:
                if (type.equals("econom-car-shop")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_econom_car_shop_ic);
                    return;
                }
                return;
            case 702603170:
                if (type.equals("concert-room")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_concert_room_ic);
                    return;
                }
                return;
            case 723062322:
                if (type.equals("tunning-shop-ls")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_tuning_shop_ls_ic);
                    return;
                }
                return;
            case 723062325:
                if (type.equals("tunning-shop-lv")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_tuning_shop_lv_ic);
                    return;
                }
                return;
            case 723062526:
                if (type.equals("tunning-shop-sf")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_tuning_shop_sf_ic);
                    return;
                }
                return;
            case 1225089391:
                if (type.equals("mechanics")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_mechanics_ic);
                    return;
                }
                return;
            case 1547010822:
                if (type.equals("luxe-car-shop")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_luxe_car_shop_ic);
                    return;
                }
                return;
            case 1871089144:
                if (type.equals("cotton-farm")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_cotton_farm_ic);
                    return;
                }
                return;
            case 1981773567:
                if (type.equals("average-car-shop")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_average_car_shop_ic);
                    return;
                }
                return;
            case 2037180155:
                if (type.equals("bookmaker")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_bookmaker_ic);
                    return;
                }
                return;
            case 2085719044:
                if (type.equals("accessories-store")) {
                    myBizScreenBinding.bizTypeIc.setImageResource(R.drawable.my_biz_accessories_shop_ic);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void setBizStat(Companion.BusinessDetailInfo businessDetailInfo) {
        this.parentStatAdapter.addParentStat(businessDetailInfo);
    }

    private final void setMenuList(List<Companion.MenuItem> list) {
        this.menuAdapter.addMenu(list);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setBizList(MapperKt.toListModel(data, Companion.BusinessItemInfo.class));
        } else if (i == 1) {
            Companion.MainBusinessInfo mainBusinessInfo = (Companion.MainBusinessInfo) MapperKt.jsonToModel(data, Companion.MainBusinessInfo.class, getBackendID(), getTargetActivity(), getNotifier());
            if (mainBusinessInfo != null) {
                setMainBizInfo(mainBusinessInfo);
            }
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            setMenuList(MapperKt.toListModel(data, Companion.MenuItem.class));
        } else {
            Companion.BusinessDetailInfo businessDetailInfo = (Companion.BusinessDetailInfo) MapperKt.jsonToModel(data, Companion.BusinessDetailInfo.class, getBackendID(), getTargetActivity(), getNotifier());
            if (businessDetailInfo != null) {
                setBizStat(businessDetailInfo);
            }
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        this.binding.businessRc.getRecycledViewPool().clear();
        this.bizListAdapter.clearBusinesses();
    }

    /* compiled from: MyBusinessScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\f"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion;", "", "<init>", "()V", "BusinessItemInfo", "BusinessItemStatInfo", "MainBusinessInfo", "MainBusinessInfoStat", "BusinessDetailInfo", "BusinessDetailInfoItem", "MenuItem", "SubMenuItem", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: MyBusinessScreen.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$BusinessItemInfo;", "", "id", "", "type", "", "title", "opened", "stats", "", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$BusinessItemStatInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getId", "()I", "getType", "()Ljava/lang/String;", "getTitle", "getOpened", "getStats", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class BusinessItemInfo {
            private final int id;
            private final int opened;
            private final List<BusinessItemStatInfo> stats;
            private final String title;
            private final String type;

            public static /* synthetic */ BusinessItemInfo copy$default(BusinessItemInfo businessItemInfo, int i, String str, String str2, int i2, List list, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = businessItemInfo.id;
                }
                if ((i3 & 2) != 0) {
                    str = businessItemInfo.type;
                }
                if ((i3 & 4) != 0) {
                    str2 = businessItemInfo.title;
                }
                if ((i3 & 8) != 0) {
                    i2 = businessItemInfo.opened;
                }
                List<BusinessItemStatInfo> list2 = list;
                if ((i3 & 16) != 0) {
                    list2 = businessItemInfo.stats;
                }
                List list3 = list2;
                String str3 = str2;
                return businessItemInfo.copy(i, str, str3, i2, list3);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.type;
            }

            public final String component3() {
                return this.title;
            }

            public final int component4() {
                return this.opened;
            }

            public final List<BusinessItemStatInfo> component5() {
                return this.stats;
            }

            public final BusinessItemInfo copy(int i, String type, String title, int i2, List<BusinessItemStatInfo> stats) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(stats, "stats");
                return new BusinessItemInfo(i, type, title, i2, stats);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BusinessItemInfo) {
                    BusinessItemInfo businessItemInfo = (BusinessItemInfo) obj;
                    return this.id == businessItemInfo.id && Intrinsics.areEqual(this.type, businessItemInfo.type) && Intrinsics.areEqual(this.title, businessItemInfo.title) && this.opened == businessItemInfo.opened && Intrinsics.areEqual(this.stats, businessItemInfo.stats);
                }
                return false;
            }

            public int hashCode() {
                return (((((((Integer.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.opened)) * 31) + this.stats.hashCode();
            }

            public String toString() {
                int i = this.id;
                String str = this.type;
                String str2 = this.title;
                int i2 = this.opened;
                return "BusinessItemInfo(id=" + i + ", type=" + str + ", title=" + str2 + ", opened=" + i2 + ", stats=" + this.stats + ")";
            }

            public BusinessItemInfo(int i, String type, String title, int i2, List<BusinessItemStatInfo> stats) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(stats, "stats");
                this.id = i;
                this.type = type;
                this.title = title;
                this.opened = i2;
                this.stats = stats;
            }

            public final int getId() {
                return this.id;
            }

            public final String getType() {
                return this.type;
            }

            public final String getTitle() {
                return this.title;
            }

            public final int getOpened() {
                return this.opened;
            }

            public final List<BusinessItemStatInfo> getStats() {
                return this.stats;
            }
        }

        private Companion() {
        }

        /* compiled from: MyBusinessScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$BusinessItemStatInfo;", "", "title", "", "value", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "getIcon", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class BusinessItemStatInfo {
            private final String icon;
            private final String title;
            private final String value;

            public static /* synthetic */ BusinessItemStatInfo copy$default(BusinessItemStatInfo businessItemStatInfo, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = businessItemStatInfo.title;
                }
                if ((i & 2) != 0) {
                    str2 = businessItemStatInfo.value;
                }
                if ((i & 4) != 0) {
                    str3 = businessItemStatInfo.icon;
                }
                return businessItemStatInfo.copy(str, str2, str3);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.value;
            }

            public final String component3() {
                return this.icon;
            }

            public final BusinessItemStatInfo copy(String title, String value, String icon) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(icon, "icon");
                return new BusinessItemStatInfo(title, value, icon);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BusinessItemStatInfo) {
                    BusinessItemStatInfo businessItemStatInfo = (BusinessItemStatInfo) obj;
                    return Intrinsics.areEqual(this.title, businessItemStatInfo.title) && Intrinsics.areEqual(this.value, businessItemStatInfo.value) && Intrinsics.areEqual(this.icon, businessItemStatInfo.icon);
                }
                return false;
            }

            public int hashCode() {
                return (((this.title.hashCode() * 31) + this.value.hashCode()) * 31) + this.icon.hashCode();
            }

            public String toString() {
                String str = this.title;
                String str2 = this.value;
                return "BusinessItemStatInfo(title=" + str + ", value=" + str2 + ", icon=" + this.icon + ")";
            }

            public BusinessItemStatInfo(String title, String value, String icon) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(icon, "icon");
                this.title = title;
                this.value = value;
                this.icon = icon;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getValue() {
                return this.value;
            }
        }

        /* compiled from: MyBusinessScreen.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$MainBusinessInfo;", "", "id", "", "type", "", "title", "balance", "opened", "stats", "", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$MainBusinessInfoStat;", "<init>", "(ILjava/lang/String;Ljava/lang/String;IILjava/util/List;)V", "getId", "()I", "getType", "()Ljava/lang/String;", "getTitle", "getBalance", "getOpened", "getStats", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class MainBusinessInfo {
            private final int balance;
            private final int id;
            private final int opened;
            private final List<MainBusinessInfoStat> stats;
            private final String title;
            private final String type;

            public static /* synthetic */ MainBusinessInfo copy$default(MainBusinessInfo mainBusinessInfo, int i, String str, String str2, int i2, int i3, List list, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i = mainBusinessInfo.id;
                }
                if ((i4 & 2) != 0) {
                    str = mainBusinessInfo.type;
                }
                if ((i4 & 4) != 0) {
                    str2 = mainBusinessInfo.title;
                }
                if ((i4 & 8) != 0) {
                    i2 = mainBusinessInfo.balance;
                }
                if ((i4 & 16) != 0) {
                    i3 = mainBusinessInfo.opened;
                }
                List<MainBusinessInfoStat> list2 = list;
                if ((i4 & 32) != 0) {
                    list2 = mainBusinessInfo.stats;
                }
                int i5 = i3;
                List list3 = list2;
                return mainBusinessInfo.copy(i, str, str2, i2, i5, list3);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.type;
            }

            public final String component3() {
                return this.title;
            }

            public final int component4() {
                return this.balance;
            }

            public final int component5() {
                return this.opened;
            }

            public final List<MainBusinessInfoStat> component6() {
                return this.stats;
            }

            public final MainBusinessInfo copy(int i, String type, String title, int i2, int i3, List<MainBusinessInfoStat> stats) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(stats, "stats");
                return new MainBusinessInfo(i, type, title, i2, i3, stats);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof MainBusinessInfo) {
                    MainBusinessInfo mainBusinessInfo = (MainBusinessInfo) obj;
                    return this.id == mainBusinessInfo.id && Intrinsics.areEqual(this.type, mainBusinessInfo.type) && Intrinsics.areEqual(this.title, mainBusinessInfo.title) && this.balance == mainBusinessInfo.balance && this.opened == mainBusinessInfo.opened && Intrinsics.areEqual(this.stats, mainBusinessInfo.stats);
                }
                return false;
            }

            public int hashCode() {
                return (((((((((Integer.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.balance)) * 31) + Integer.hashCode(this.opened)) * 31) + this.stats.hashCode();
            }

            public String toString() {
                int i = this.id;
                String str = this.type;
                String str2 = this.title;
                int i2 = this.balance;
                int i3 = this.opened;
                return "MainBusinessInfo(id=" + i + ", type=" + str + ", title=" + str2 + ", balance=" + i2 + ", opened=" + i3 + ", stats=" + this.stats + ")";
            }

            public MainBusinessInfo(int i, String type, String title, int i2, int i3, List<MainBusinessInfoStat> stats) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(stats, "stats");
                this.id = i;
                this.type = type;
                this.title = title;
                this.balance = i2;
                this.opened = i3;
                this.stats = stats;
            }

            public final int getBalance() {
                return this.balance;
            }

            public final int getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getType() {
                return this.type;
            }

            public final int getOpened() {
                return this.opened;
            }

            public final List<MainBusinessInfoStat> getStats() {
                return this.stats;
            }
        }

        /* compiled from: MyBusinessScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$MainBusinessInfoStat;", "", "title", "", "value", Constants.ScionAnalytics.PARAM_LABEL, "maxValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "getLabel", "getMaxValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class MainBusinessInfoStat {
            private final String label;
            private final String maxValue;
            private final String title;
            private final String value;

            public static /* synthetic */ MainBusinessInfoStat copy$default(MainBusinessInfoStat mainBusinessInfoStat, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = mainBusinessInfoStat.title;
                }
                if ((i & 2) != 0) {
                    str2 = mainBusinessInfoStat.value;
                }
                if ((i & 4) != 0) {
                    str3 = mainBusinessInfoStat.label;
                }
                if ((i & 8) != 0) {
                    str4 = mainBusinessInfoStat.maxValue;
                }
                return mainBusinessInfoStat.copy(str, str2, str3, str4);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.value;
            }

            public final String component3() {
                return this.label;
            }

            public final String component4() {
                return this.maxValue;
            }

            public final MainBusinessInfoStat copy(String title, String value, String str, String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                return new MainBusinessInfoStat(title, value, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof MainBusinessInfoStat) {
                    MainBusinessInfoStat mainBusinessInfoStat = (MainBusinessInfoStat) obj;
                    return Intrinsics.areEqual(this.title, mainBusinessInfoStat.title) && Intrinsics.areEqual(this.value, mainBusinessInfoStat.value) && Intrinsics.areEqual(this.label, mainBusinessInfoStat.label) && Intrinsics.areEqual(this.maxValue, mainBusinessInfoStat.maxValue);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = ((this.title.hashCode() * 31) + this.value.hashCode()) * 31;
                String str = this.label;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.maxValue;
                return hashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                String str = this.title;
                String str2 = this.value;
                String str3 = this.label;
                return "MainBusinessInfoStat(title=" + str + ", value=" + str2 + ", label=" + str3 + ", maxValue=" + this.maxValue + ")";
            }

            public MainBusinessInfoStat(String title, String value, String str, String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                this.title = title;
                this.value = value;
                this.label = str;
                this.maxValue = str2;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getValue() {
                return this.value;
            }

            public final String getLabel() {
                return this.label;
            }

            public final String getMaxValue() {
                return this.maxValue;
            }
        }

        /* compiled from: MyBusinessScreen.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$BusinessDetailInfo;", "", "id", "", "title", "editable", "", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$BusinessDetailInfoItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getId", "()Ljava/lang/String;", "getTitle", "getEditable", "()I", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class BusinessDetailInfo {
            private final int editable;
            private final String id;
            private final List<BusinessDetailInfoItem> items;
            private final String title;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ BusinessDetailInfo copy$default(BusinessDetailInfo businessDetailInfo, String str, String str2, int i, List list, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = businessDetailInfo.id;
                }
                if ((i2 & 2) != 0) {
                    str2 = businessDetailInfo.title;
                }
                if ((i2 & 4) != 0) {
                    i = businessDetailInfo.editable;
                }
                if ((i2 & 8) != 0) {
                    list = businessDetailInfo.items;
                }
                return businessDetailInfo.copy(str, str2, i, list);
            }

            public final String component1() {
                return this.id;
            }

            public final String component2() {
                return this.title;
            }

            public final int component3() {
                return this.editable;
            }

            public final List<BusinessDetailInfoItem> component4() {
                return this.items;
            }

            public final BusinessDetailInfo copy(String id, String title, int i, List<BusinessDetailInfoItem> items) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(items, "items");
                return new BusinessDetailInfo(id, title, i, items);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BusinessDetailInfo) {
                    BusinessDetailInfo businessDetailInfo = (BusinessDetailInfo) obj;
                    return Intrinsics.areEqual(this.id, businessDetailInfo.id) && Intrinsics.areEqual(this.title, businessDetailInfo.title) && this.editable == businessDetailInfo.editable && Intrinsics.areEqual(this.items, businessDetailInfo.items);
                }
                return false;
            }

            public int hashCode() {
                return (((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.editable)) * 31) + this.items.hashCode();
            }

            public String toString() {
                String str = this.id;
                String str2 = this.title;
                int i = this.editable;
                return "BusinessDetailInfo(id=" + str + ", title=" + str2 + ", editable=" + i + ", items=" + this.items + ")";
            }

            public BusinessDetailInfo(String id, String title, int i, List<BusinessDetailInfoItem> items) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(items, "items");
                this.id = id;
                this.title = title;
                this.editable = i;
                this.items = items;
            }

            public final String getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final int getEditable() {
                return this.editable;
            }

            public final List<BusinessDetailInfoItem> getItems() {
                return this.items;
            }
        }

        /* compiled from: MyBusinessScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$BusinessDetailInfoItem;", "", "title", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class BusinessDetailInfoItem {
            private final String title;
            private final String value;

            public static /* synthetic */ BusinessDetailInfoItem copy$default(BusinessDetailInfoItem businessDetailInfoItem, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = businessDetailInfoItem.title;
                }
                if ((i & 2) != 0) {
                    str2 = businessDetailInfoItem.value;
                }
                return businessDetailInfoItem.copy(str, str2);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.value;
            }

            public final BusinessDetailInfoItem copy(String title, String value) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                return new BusinessDetailInfoItem(title, value);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BusinessDetailInfoItem) {
                    BusinessDetailInfoItem businessDetailInfoItem = (BusinessDetailInfoItem) obj;
                    return Intrinsics.areEqual(this.title, businessDetailInfoItem.title) && Intrinsics.areEqual(this.value, businessDetailInfoItem.value);
                }
                return false;
            }

            public int hashCode() {
                return (this.title.hashCode() * 31) + this.value.hashCode();
            }

            public String toString() {
                String str = this.title;
                return "BusinessDetailInfoItem(title=" + str + ", value=" + this.value + ")";
            }

            public BusinessDetailInfoItem(String title, String value) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                this.title = title;
                this.value = value;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getValue() {
                return this.value;
            }
        }

        /* compiled from: MyBusinessScreen.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$MenuItem;", "", "id", "", "title", "", "isPressed", "", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$SubMenuItem;", "<init>", "(ILjava/lang/String;ZLjava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "()Z", "setPressed", "(Z)V", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class MenuItem {
            private final int id;
            private boolean isPressed;
            private final List<SubMenuItem> items;
            private final String title;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MenuItem copy$default(MenuItem menuItem, int i, String str, boolean z, List list, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = menuItem.id;
                }
                if ((i2 & 2) != 0) {
                    str = menuItem.title;
                }
                if ((i2 & 4) != 0) {
                    z = menuItem.isPressed;
                }
                if ((i2 & 8) != 0) {
                    list = menuItem.items;
                }
                return menuItem.copy(i, str, z, list);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.title;
            }

            public final boolean component3() {
                return this.isPressed;
            }

            public final List<SubMenuItem> component4() {
                return this.items;
            }

            public final MenuItem copy(int i, String title, boolean z, List<SubMenuItem> items) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(items, "items");
                return new MenuItem(i, title, z, items);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof MenuItem) {
                    MenuItem menuItem = (MenuItem) obj;
                    return this.id == menuItem.id && Intrinsics.areEqual(this.title, menuItem.title) && this.isPressed == menuItem.isPressed && Intrinsics.areEqual(this.items, menuItem.items);
                }
                return false;
            }

            public int hashCode() {
                return (((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Boolean.hashCode(this.isPressed)) * 31) + this.items.hashCode();
            }

            public String toString() {
                int i = this.id;
                String str = this.title;
                boolean z = this.isPressed;
                return "MenuItem(id=" + i + ", title=" + str + ", isPressed=" + z + ", items=" + this.items + ")";
            }

            public MenuItem(int i, String title, boolean z, List<SubMenuItem> items) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(items, "items");
                this.id = i;
                this.title = title;
                this.isPressed = z;
                this.items = items;
            }

            public /* synthetic */ MenuItem(int i, String str, boolean z, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, str, (i2 & 4) != 0 ? false : z, list);
            }

            public final int getId() {
                return this.id;
            }

            public final List<SubMenuItem> getItems() {
                return this.items;
            }

            public final String getTitle() {
                return this.title;
            }

            public final boolean isPressed() {
                return this.isPressed;
            }

            public final void setPressed(boolean z) {
                this.isPressed = z;
            }
        }

        /* compiled from: MyBusinessScreen.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$SubMenuItem;", "", "id", "", "title", "", "isPressed", "", "<init>", "(ILjava/lang/String;Z)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "()Z", "setPressed", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class SubMenuItem {
            private final int id;
            private boolean isPressed;
            private final String title;

            public static /* synthetic */ SubMenuItem copy$default(SubMenuItem subMenuItem, int i, String str, boolean z, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = subMenuItem.id;
                }
                if ((i2 & 2) != 0) {
                    str = subMenuItem.title;
                }
                if ((i2 & 4) != 0) {
                    z = subMenuItem.isPressed;
                }
                return subMenuItem.copy(i, str, z);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.title;
            }

            public final boolean component3() {
                return this.isPressed;
            }

            public final SubMenuItem copy(int i, String title, boolean z) {
                Intrinsics.checkNotNullParameter(title, "title");
                return new SubMenuItem(i, title, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SubMenuItem) {
                    SubMenuItem subMenuItem = (SubMenuItem) obj;
                    return this.id == subMenuItem.id && Intrinsics.areEqual(this.title, subMenuItem.title) && this.isPressed == subMenuItem.isPressed;
                }
                return false;
            }

            public int hashCode() {
                return (((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Boolean.hashCode(this.isPressed);
            }

            public String toString() {
                int i = this.id;
                String str = this.title;
                return "SubMenuItem(id=" + i + ", title=" + str + ", isPressed=" + this.isPressed + ")";
            }

            public SubMenuItem(int i, String title, boolean z) {
                Intrinsics.checkNotNullParameter(title, "title");
                this.id = i;
                this.title = title;
                this.isPressed = z;
            }

            public /* synthetic */ SubMenuItem(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, str, (i2 & 4) != 0 ? false : z);
            }

            public final int getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final boolean isPressed() {
                return this.isPressed;
            }

            public final void setPressed(boolean z) {
                this.isPressed = z;
            }
        }
    }

    /* compiled from: MyBusinessScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new MyBusinessScreen(targetActivity, i);
        }
    }
}
