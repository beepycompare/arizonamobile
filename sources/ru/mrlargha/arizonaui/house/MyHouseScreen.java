package ru.mrlargha.arizonaui.house;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import com.arizona.common.utils.EasyAnimation;
import com.arizona.common.utils.LinearItemDecoration;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MyHouseScreenBinding;
import ru.mrlargha.arizonaui.house.MyHouseMenuAdapter;
import ru.mrlargha.arizonaui.house.MyHousesListAdapter;
import ru.mrlargha.arizonaui.house.MyHousesTenantsAdapter;
import ru.mrlargha.arizonaui.house.MyHousesUpgradesAdapter;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: MyHouseScreen.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\u001e\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\u001b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0 H\u0002J\u0016\u0010)\u001a\u00020\u001b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020*0 H\u0002J\u0018\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "myBizScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/arizonaui/databinding/MyHouseScreenBinding;", "houseListAdapter", "Lru/mrlargha/arizonaui/house/MyHousesListAdapter;", "mainHouseStatAdapter", "Lru/mrlargha/arizonaui/house/MyHouseMainInfoAdapter;", "parentStatAdapter", "Lru/mrlargha/arizonaui/house/MyHouseParentStatAdapter;", "menuAdapter", "Lru/mrlargha/arizonaui/house/MyHouseMenuAdapter;", "tenantsAdapter", "Lru/mrlargha/arizonaui/house/MyHousesTenantsAdapter;", "upgradeAdapter", "Lru/mrlargha/arizonaui/house/MyHousesUpgradesAdapter;", "currentPage", "currentHouseId", "setCheckInfo", "", "isOpened", "", "setHouseList", "info", "", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$HouseItemInfo;", "setMainHouseInfo", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$MainHouseInfo;", "setHouseStat", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$HouseDetailInfo;", "setMenuList", FirebaseAnalytics.Param.ITEMS, "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$MenuItem;", "setHouseUpgrades", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$UpgradeItem;", "onBackendMessage", "data", "", "subId", "Companion", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyHouseScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private final MyHouseScreenBinding binding;
    private int currentHouseId;
    private int currentPage;
    private final MyHousesListAdapter houseListAdapter;
    private final MyHouseMainInfoAdapter mainHouseStatAdapter;
    private final MyHouseMenuAdapter menuAdapter;
    private final ConstraintLayout myBizScreen;
    private final MyHouseParentStatAdapter parentStatAdapter;
    private final MyHousesTenantsAdapter tenantsAdapter;
    private final MyHousesUpgradesAdapter upgradeAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyHouseScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.my_house_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.myBizScreen = constraintLayout;
        final MyHouseScreenBinding bind = MyHouseScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        MyHousesListAdapter myHousesListAdapter = new MyHousesListAdapter();
        this.houseListAdapter = myHousesListAdapter;
        MyHouseMainInfoAdapter myHouseMainInfoAdapter = new MyHouseMainInfoAdapter();
        this.mainHouseStatAdapter = myHouseMainInfoAdapter;
        MyHouseParentStatAdapter myHouseParentStatAdapter = new MyHouseParentStatAdapter();
        this.parentStatAdapter = myHouseParentStatAdapter;
        MyHouseMenuAdapter myHouseMenuAdapter = new MyHouseMenuAdapter();
        this.menuAdapter = myHouseMenuAdapter;
        MyHousesTenantsAdapter myHousesTenantsAdapter = new MyHousesTenantsAdapter();
        this.tenantsAdapter = myHousesTenantsAdapter;
        MyHousesUpgradesAdapter myHousesUpgradesAdapter = new MyHousesUpgradesAdapter();
        this.upgradeAdapter = myHousesUpgradesAdapter;
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.housesRc.setAdapter(myHousesListAdapter);
        bind.houseMainStatRc.setAdapter(myHouseMainInfoAdapter);
        bind.houseMainStatRc.addItemDecoration(new LinearItemDecoration(0.2372f, 1.0f, 0.0f));
        bind.parentStatRc.setAdapter(myHouseParentStatAdapter);
        bind.menuRc.setAdapter(myHouseMenuAdapter);
        bind.tenantsRc.setAdapter(myHousesTenantsAdapter);
        bind.upgradesRc.setAdapter(myHousesUpgradesAdapter);
        myHousesListAdapter.setOnBizClickListener(new MyHousesListAdapter.OnHouseClickListener() { // from class: ru.mrlargha.arizonaui.house.MyHouseScreen$1$1
            @Override // ru.mrlargha.arizonaui.house.MyHousesListAdapter.OnHouseClickListener
            public void callback(int i2) {
                SAMPUIElement.notifyClick$default(MyHouseScreen.this, i2, 0, null, 4, null);
            }
        });
        myHousesTenantsAdapter.setOnTenantClickListener(new MyHousesTenantsAdapter.OnTenantClickListener() { // from class: ru.mrlargha.arizonaui.house.MyHouseScreen$1$2
            @Override // ru.mrlargha.arizonaui.house.MyHousesTenantsAdapter.OnTenantClickListener
            public void callback(int i2) {
                SAMPUIElement.notifyClick$default(MyHouseScreen.this, i2, 4, null, 4, null);
            }
        });
        myHouseMenuAdapter.setOnParentItemClickListener(new MyHouseMenuAdapter.OnParentItemClickListener() { // from class: ru.mrlargha.arizonaui.house.MyHouseScreen$1$3
            @Override // ru.mrlargha.arizonaui.house.MyHouseMenuAdapter.OnParentItemClickListener
            public void callback(int i2) {
                SAMPUIElement.notifyClick$default(MyHouseScreen.this, i2, 1, null, 4, null);
            }
        });
        myHousesUpgradesAdapter.setOnUpgradeClickListener(new MyHousesUpgradesAdapter.OnUpgradeClickListener() { // from class: ru.mrlargha.arizonaui.house.MyHouseScreen$1$4
            @Override // ru.mrlargha.arizonaui.house.MyHousesUpgradesAdapter.OnUpgradeClickListener
            public void callback(int i2) {
                SAMPUIElement.notifyClick$default(MyHouseScreen.this, i2, 3, null, 4, null);
            }
        });
        myHousesUpgradesAdapter.setOnInfoClickListener(new MyHousesUpgradesAdapter.OnInfoClickListener() { // from class: ru.mrlargha.arizonaui.house.MyHouseScreen$1$5
            @Override // ru.mrlargha.arizonaui.house.MyHousesUpgradesAdapter.OnInfoClickListener
            public void callback(int i2) {
                SAMPUIElement.notifyClick$default(MyHouseScreen.this, i2, 2, null, 4, null);
            }
        });
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView backButton = bind.backButton;
        Intrinsics.checkNotNullExpressionValue(backButton, "backButton");
        EasyAnimation.animateClick$default(easyAnimation, backButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.house.MyHouseScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MyHouseScreen.lambda$3$lambda$0(MyHouseScreen.this);
            }
        }, 3, null);
        EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
        ImageView exitButton = bind.exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        EasyAnimation.animateClick$default(easyAnimation2, exitButton, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.house.MyHouseScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MyHouseScreen.lambda$3$lambda$1(MyHouseScreenBinding.this, this);
            }
        }, 3, null);
        bind.switchBiz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.mrlargha.arizonaui.house.MyHouseScreen$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MyHouseScreen.lambda$3$lambda$2(MyHouseScreen.this, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$3$lambda$0(MyHouseScreen myHouseScreen) {
        SAMPUIElement.notifyClick$default(myHouseScreen, 0, 5, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$3$lambda$1(MyHouseScreenBinding myHouseScreenBinding, MyHouseScreen myHouseScreen) {
        myHouseScreenBinding.housesRc.getRecycledViewPool().clear();
        myHouseScreen.houseListAdapter.clearHouses();
        SAMPUIElement.notifyClick$default(myHouseScreen, 1, 5, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$3$lambda$2(MyHouseScreen myHouseScreen, CompoundButton compoundButton, boolean z) {
        Log.e("check", "isChecked");
        myHouseScreen.setCheckInfo(z);
        SAMPUIElement.notifyClick$default(myHouseScreen, !z ? 1 : 0, 6, null, 4, null);
    }

    private final void setCheckInfo(boolean z) {
        MyHouseScreenBinding myHouseScreenBinding = this.binding;
        myHouseScreenBinding.switchBiz.setChecked(z);
        if (z) {
            myHouseScreenBinding.tvBiz.setText(getTargetActivity().getString(R.string.open_txt));
            myHouseScreenBinding.tvBiz.setTextColor(-16711936);
            return;
        }
        myHouseScreenBinding.tvBiz.setText(getTargetActivity().getString(R.string.close_txt));
        myHouseScreenBinding.tvBiz.setTextColor(SupportMenu.CATEGORY_MASK);
    }

    private final void setHouseList(List<Companion.HouseItemInfo> list) {
        MyHouseScreenBinding myHouseScreenBinding = this.binding;
        if (this.currentPage == 1) {
            myHouseScreenBinding.housesRc.getRecycledViewPool().clear();
            this.houseListAdapter.clearHouses();
        }
        this.currentPage = 0;
        myHouseScreenBinding.infoPage.setVisibility(8);
        myHouseScreenBinding.mainPage.setVisibility(0);
        this.houseListAdapter.addHouses(list);
    }

    private final void setMainHouseInfo(Companion.MainHouseInfo mainHouseInfo) {
        MyHouseScreenBinding myHouseScreenBinding = this.binding;
        this.mainHouseStatAdapter.clearStat();
        this.menuAdapter.clearMenu();
        this.parentStatAdapter.clearStat();
        this.currentPage = 1;
        this.currentHouseId = mainHouseInfo.getId();
        myHouseScreenBinding.mainPage.setVisibility(8);
        myHouseScreenBinding.infoPage.setVisibility(0);
        myHouseScreenBinding.houseName.setText(mainHouseInfo.getTitle());
        myHouseScreenBinding.bizId.setText(String.valueOf(mainHouseInfo.getId()));
        this.mainHouseStatAdapter.addStat(mainHouseInfo.getStats());
        myHouseScreenBinding.tenantsCount.setText(mainHouseInfo.getTenantsInformation().size() + RemoteSettings.FORWARD_SLASH_STRING + mainHouseInfo.getMaxTenants());
        setCheckInfo(mainHouseInfo.getOpened() == 0);
        if (mainHouseInfo.getTenantsInformation().isEmpty()) {
            myHouseScreenBinding.tenantsRc.setVisibility(8);
            myHouseScreenBinding.housesNoTenantsIc.setVisibility(0);
        } else {
            myHouseScreenBinding.tenantsRc.setVisibility(0);
            myHouseScreenBinding.housesNoTenantsIc.setVisibility(8);
            this.tenantsAdapter.addTenants(mainHouseInfo.getTenantsInformation());
        }
        String type = mainHouseInfo.getType();
        int hashCode = type.hashCode();
        if (hashCode == -1067215565) {
            if (type.equals("trailer")) {
                myHouseScreenBinding.houseTypeIc.setImageResource(R.drawable.my_houses_trailer_ic);
            }
        } else if (hashCode == -993141291) {
            if (type.equals("property")) {
                myHouseScreenBinding.houseTypeIc.setImageResource(R.drawable.my_houses_house_ic);
            }
        } else if (hashCode == 1959548722 && type.equals("apartment")) {
            myHouseScreenBinding.houseTypeIc.setImageResource(R.drawable.my_houses_apartment_ic);
        }
    }

    private final void setHouseStat(Companion.HouseDetailInfo houseDetailInfo) {
        this.parentStatAdapter.addParentStat(houseDetailInfo);
    }

    private final void setMenuList(List<Companion.MenuItem> list) {
        this.menuAdapter.addMenu(list);
    }

    private final void setHouseUpgrades(List<Companion.UpgradeItem> list) {
        this.upgradeAdapter.addUpgrades(list);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            if (i == 0) {
                setHouseList(MapperKt.toListModel(StringsKt.replace$default(data, "\\", "", false, 4, (Object) null), Companion.HouseItemInfo.class));
            } else if (i == 1) {
                setMenuList(MapperKt.toListModel(data, Companion.MenuItem.class));
            } else if (i == 2) {
                setMainHouseInfo((Companion.MainHouseInfo) MapperKt.toModel(data, Companion.MainHouseInfo.class));
            } else if (i == 3) {
                setHouseStat((Companion.HouseDetailInfo) MapperKt.toModel(data, Companion.HouseDetailInfo.class));
            } else if (i != 4) {
            } else {
                setHouseUpgrades(MapperKt.toListModel(data, Companion.UpgradeItem.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getTargetActivity(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
            getNotifier().setUIElementVisible(getBackendID(), false);
        }
    }

    /* compiled from: MyHouseScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000e"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion;", "", "<init>", "()V", "HouseItemInfo", "HouseItemStatInfo", "MainHouseInfo", "MainHouseInfoStat", "TenantsInformation", "HouseDetailInfo", "HouseDetailInfoItem", "MenuItem", "SubMenuItem", "UpgradeItem", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: MyHouseScreen.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$HouseItemInfo;", "", "id", "", "type", "", "title", "opened", NotificationCompat.CATEGORY_STATUS, "distance", "stats", "", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$HouseItemStatInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/util/List;)V", "getId", "()I", "getType", "()Ljava/lang/String;", "getTitle", "getOpened", "getStatus", "getDistance", "getStats", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class HouseItemInfo {
            private final int distance;
            private final int id;
            private final int opened;
            private final List<HouseItemStatInfo> stats;
            private final String status;
            private final String title;
            private final String type;

            public static /* synthetic */ HouseItemInfo copy$default(HouseItemInfo houseItemInfo, int i, String str, String str2, int i2, String str3, int i3, List list, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i = houseItemInfo.id;
                }
                if ((i4 & 2) != 0) {
                    str = houseItemInfo.type;
                }
                if ((i4 & 4) != 0) {
                    str2 = houseItemInfo.title;
                }
                if ((i4 & 8) != 0) {
                    i2 = houseItemInfo.opened;
                }
                if ((i4 & 16) != 0) {
                    str3 = houseItemInfo.status;
                }
                if ((i4 & 32) != 0) {
                    i3 = houseItemInfo.distance;
                }
                List<HouseItemStatInfo> list2 = list;
                if ((i4 & 64) != 0) {
                    list2 = houseItemInfo.stats;
                }
                int i5 = i3;
                List list3 = list2;
                String str4 = str3;
                String str5 = str2;
                return houseItemInfo.copy(i, str, str5, i2, str4, i5, list3);
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

            public final String component5() {
                return this.status;
            }

            public final int component6() {
                return this.distance;
            }

            public final List<HouseItemStatInfo> component7() {
                return this.stats;
            }

            public final HouseItemInfo copy(int i, String type, String title, int i2, String status, int i3, List<HouseItemStatInfo> stats) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(status, "status");
                Intrinsics.checkNotNullParameter(stats, "stats");
                return new HouseItemInfo(i, type, title, i2, status, i3, stats);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof HouseItemInfo) {
                    HouseItemInfo houseItemInfo = (HouseItemInfo) obj;
                    return this.id == houseItemInfo.id && Intrinsics.areEqual(this.type, houseItemInfo.type) && Intrinsics.areEqual(this.title, houseItemInfo.title) && this.opened == houseItemInfo.opened && Intrinsics.areEqual(this.status, houseItemInfo.status) && this.distance == houseItemInfo.distance && Intrinsics.areEqual(this.stats, houseItemInfo.stats);
                }
                return false;
            }

            public int hashCode() {
                return (((((((((((Integer.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.opened)) * 31) + this.status.hashCode()) * 31) + Integer.hashCode(this.distance)) * 31) + this.stats.hashCode();
            }

            public String toString() {
                int i = this.id;
                String str = this.type;
                String str2 = this.title;
                int i2 = this.opened;
                String str3 = this.status;
                int i3 = this.distance;
                return "HouseItemInfo(id=" + i + ", type=" + str + ", title=" + str2 + ", opened=" + i2 + ", status=" + str3 + ", distance=" + i3 + ", stats=" + this.stats + ")";
            }

            public HouseItemInfo(int i, String type, String title, int i2, String status, int i3, List<HouseItemStatInfo> stats) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(status, "status");
                Intrinsics.checkNotNullParameter(stats, "stats");
                this.id = i;
                this.type = type;
                this.title = title;
                this.opened = i2;
                this.status = status;
                this.distance = i3;
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

            public final String getStatus() {
                return this.status;
            }

            public final int getDistance() {
                return this.distance;
            }

            public final List<HouseItemStatInfo> getStats() {
                return this.stats;
            }
        }

        private Companion() {
        }

        /* compiled from: MyHouseScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$HouseItemStatInfo;", "", "title", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class HouseItemStatInfo {
            private final String title;
            private final String value;

            public static /* synthetic */ HouseItemStatInfo copy$default(HouseItemStatInfo houseItemStatInfo, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = houseItemStatInfo.title;
                }
                if ((i & 2) != 0) {
                    str2 = houseItemStatInfo.value;
                }
                return houseItemStatInfo.copy(str, str2);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.value;
            }

            public final HouseItemStatInfo copy(String title, String value) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                return new HouseItemStatInfo(title, value);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof HouseItemStatInfo) {
                    HouseItemStatInfo houseItemStatInfo = (HouseItemStatInfo) obj;
                    return Intrinsics.areEqual(this.title, houseItemStatInfo.title) && Intrinsics.areEqual(this.value, houseItemStatInfo.value);
                }
                return false;
            }

            public int hashCode() {
                return (this.title.hashCode() * 31) + this.value.hashCode();
            }

            public String toString() {
                String str = this.title;
                return "HouseItemStatInfo(title=" + str + ", value=" + this.value + ")";
            }

            public HouseItemStatInfo(String title, String value) {
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

        /* compiled from: MyHouseScreen.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003Je\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006*"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$MainHouseInfo;", "", "id", "", "type", "", "title", "balance", "opened", "maxTenants", "stats", "", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$MainHouseInfoStat;", "tenantsInformation", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$TenantsInformation;", "<init>", "(ILjava/lang/String;Ljava/lang/String;IIILjava/util/List;Ljava/util/List;)V", "getId", "()I", "getType", "()Ljava/lang/String;", "getTitle", "getBalance", "getOpened", "getMaxTenants", "getStats", "()Ljava/util/List;", "getTenantsInformation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class MainHouseInfo {
            private final int balance;
            private final int id;
            private final int maxTenants;
            private final int opened;
            private final List<MainHouseInfoStat> stats;
            private final List<TenantsInformation> tenantsInformation;
            private final String title;
            private final String type;

            public static /* synthetic */ MainHouseInfo copy$default(MainHouseInfo mainHouseInfo, int i, String str, String str2, int i2, int i3, int i4, List list, List list2, int i5, Object obj) {
                if ((i5 & 1) != 0) {
                    i = mainHouseInfo.id;
                }
                if ((i5 & 2) != 0) {
                    str = mainHouseInfo.type;
                }
                if ((i5 & 4) != 0) {
                    str2 = mainHouseInfo.title;
                }
                if ((i5 & 8) != 0) {
                    i2 = mainHouseInfo.balance;
                }
                if ((i5 & 16) != 0) {
                    i3 = mainHouseInfo.opened;
                }
                if ((i5 & 32) != 0) {
                    i4 = mainHouseInfo.maxTenants;
                }
                List<MainHouseInfoStat> list3 = list;
                if ((i5 & 64) != 0) {
                    list3 = mainHouseInfo.stats;
                }
                List<TenantsInformation> list4 = list2;
                if ((i5 & 128) != 0) {
                    list4 = mainHouseInfo.tenantsInformation;
                }
                List list5 = list3;
                List list6 = list4;
                int i6 = i3;
                int i7 = i4;
                return mainHouseInfo.copy(i, str, str2, i2, i6, i7, list5, list6);
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

            public final int component6() {
                return this.maxTenants;
            }

            public final List<MainHouseInfoStat> component7() {
                return this.stats;
            }

            public final List<TenantsInformation> component8() {
                return this.tenantsInformation;
            }

            public final MainHouseInfo copy(int i, String type, String title, int i2, int i3, int i4, List<MainHouseInfoStat> stats, List<TenantsInformation> tenantsInformation) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(stats, "stats");
                Intrinsics.checkNotNullParameter(tenantsInformation, "tenantsInformation");
                return new MainHouseInfo(i, type, title, i2, i3, i4, stats, tenantsInformation);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof MainHouseInfo) {
                    MainHouseInfo mainHouseInfo = (MainHouseInfo) obj;
                    return this.id == mainHouseInfo.id && Intrinsics.areEqual(this.type, mainHouseInfo.type) && Intrinsics.areEqual(this.title, mainHouseInfo.title) && this.balance == mainHouseInfo.balance && this.opened == mainHouseInfo.opened && this.maxTenants == mainHouseInfo.maxTenants && Intrinsics.areEqual(this.stats, mainHouseInfo.stats) && Intrinsics.areEqual(this.tenantsInformation, mainHouseInfo.tenantsInformation);
                }
                return false;
            }

            public int hashCode() {
                return (((((((((((((Integer.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.balance)) * 31) + Integer.hashCode(this.opened)) * 31) + Integer.hashCode(this.maxTenants)) * 31) + this.stats.hashCode()) * 31) + this.tenantsInformation.hashCode();
            }

            public String toString() {
                int i = this.id;
                String str = this.type;
                String str2 = this.title;
                int i2 = this.balance;
                int i3 = this.opened;
                int i4 = this.maxTenants;
                List<MainHouseInfoStat> list = this.stats;
                return "MainHouseInfo(id=" + i + ", type=" + str + ", title=" + str2 + ", balance=" + i2 + ", opened=" + i3 + ", maxTenants=" + i4 + ", stats=" + list + ", tenantsInformation=" + this.tenantsInformation + ")";
            }

            public MainHouseInfo(int i, String type, String title, int i2, int i3, int i4, List<MainHouseInfoStat> stats, List<TenantsInformation> tenantsInformation) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(stats, "stats");
                Intrinsics.checkNotNullParameter(tenantsInformation, "tenantsInformation");
                this.id = i;
                this.type = type;
                this.title = title;
                this.balance = i2;
                this.opened = i3;
                this.maxTenants = i4;
                this.stats = stats;
                this.tenantsInformation = tenantsInformation;
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

            public final int getMaxTenants() {
                return this.maxTenants;
            }

            public final int getOpened() {
                return this.opened;
            }

            public final List<MainHouseInfoStat> getStats() {
                return this.stats;
            }

            public final List<TenantsInformation> getTenantsInformation() {
                return this.tenantsInformation;
            }
        }

        /* compiled from: MyHouseScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$MainHouseInfoStat;", "", "title", "", "value", Constants.ScionAnalytics.PARAM_LABEL, "maxValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "getLabel", "getMaxValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class MainHouseInfoStat {
            private final String label;
            private final String maxValue;
            private final String title;
            private final String value;

            public static /* synthetic */ MainHouseInfoStat copy$default(MainHouseInfoStat mainHouseInfoStat, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = mainHouseInfoStat.title;
                }
                if ((i & 2) != 0) {
                    str2 = mainHouseInfoStat.value;
                }
                if ((i & 4) != 0) {
                    str3 = mainHouseInfoStat.label;
                }
                if ((i & 8) != 0) {
                    str4 = mainHouseInfoStat.maxValue;
                }
                return mainHouseInfoStat.copy(str, str2, str3, str4);
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

            public final MainHouseInfoStat copy(String title, String value, String str, String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                return new MainHouseInfoStat(title, value, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof MainHouseInfoStat) {
                    MainHouseInfoStat mainHouseInfoStat = (MainHouseInfoStat) obj;
                    return Intrinsics.areEqual(this.title, mainHouseInfoStat.title) && Intrinsics.areEqual(this.value, mainHouseInfoStat.value) && Intrinsics.areEqual(this.label, mainHouseInfoStat.label) && Intrinsics.areEqual(this.maxValue, mainHouseInfoStat.maxValue);
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
                return "MainHouseInfoStat(title=" + str + ", value=" + str2 + ", label=" + str3 + ", maxValue=" + this.maxValue + ")";
            }

            public MainHouseInfoStat(String title, String value, String str, String str2) {
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

        /* compiled from: MyHouseScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$TenantsInformation;", "", "id", "", "daysInRent", "name", "", FirebaseAnalytics.Param.PRICE, "alreadyPayedAmount", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getDaysInRent", "getName", "()Ljava/lang/String;", "getPrice", "getAlreadyPayedAmount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class TenantsInformation {
            private final String alreadyPayedAmount;
            private final int daysInRent;
            private final int id;
            private final String name;
            private final String price;

            public static /* synthetic */ TenantsInformation copy$default(TenantsInformation tenantsInformation, int i, int i2, String str, String str2, String str3, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = tenantsInformation.id;
                }
                if ((i3 & 2) != 0) {
                    i2 = tenantsInformation.daysInRent;
                }
                if ((i3 & 4) != 0) {
                    str = tenantsInformation.name;
                }
                if ((i3 & 8) != 0) {
                    str2 = tenantsInformation.price;
                }
                if ((i3 & 16) != 0) {
                    str3 = tenantsInformation.alreadyPayedAmount;
                }
                String str4 = str3;
                String str5 = str;
                return tenantsInformation.copy(i, i2, str5, str2, str4);
            }

            public final int component1() {
                return this.id;
            }

            public final int component2() {
                return this.daysInRent;
            }

            public final String component3() {
                return this.name;
            }

            public final String component4() {
                return this.price;
            }

            public final String component5() {
                return this.alreadyPayedAmount;
            }

            public final TenantsInformation copy(int i, int i2, String name, String price, String alreadyPayedAmount) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(price, "price");
                Intrinsics.checkNotNullParameter(alreadyPayedAmount, "alreadyPayedAmount");
                return new TenantsInformation(i, i2, name, price, alreadyPayedAmount);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TenantsInformation) {
                    TenantsInformation tenantsInformation = (TenantsInformation) obj;
                    return this.id == tenantsInformation.id && this.daysInRent == tenantsInformation.daysInRent && Intrinsics.areEqual(this.name, tenantsInformation.name) && Intrinsics.areEqual(this.price, tenantsInformation.price) && Intrinsics.areEqual(this.alreadyPayedAmount, tenantsInformation.alreadyPayedAmount);
                }
                return false;
            }

            public int hashCode() {
                return (((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.daysInRent)) * 31) + this.name.hashCode()) * 31) + this.price.hashCode()) * 31) + this.alreadyPayedAmount.hashCode();
            }

            public String toString() {
                int i = this.id;
                int i2 = this.daysInRent;
                String str = this.name;
                String str2 = this.price;
                return "TenantsInformation(id=" + i + ", daysInRent=" + i2 + ", name=" + str + ", price=" + str2 + ", alreadyPayedAmount=" + this.alreadyPayedAmount + ")";
            }

            public TenantsInformation(int i, int i2, String name, String price, String alreadyPayedAmount) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(price, "price");
                Intrinsics.checkNotNullParameter(alreadyPayedAmount, "alreadyPayedAmount");
                this.id = i;
                this.daysInRent = i2;
                this.name = name;
                this.price = price;
                this.alreadyPayedAmount = alreadyPayedAmount;
            }

            public final int getId() {
                return this.id;
            }

            public final int getDaysInRent() {
                return this.daysInRent;
            }

            public final String getName() {
                return this.name;
            }

            public final String getPrice() {
                return this.price;
            }

            public final String getAlreadyPayedAmount() {
                return this.alreadyPayedAmount;
            }
        }

        /* compiled from: MyHouseScreen.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$HouseDetailInfo;", "", "id", "", "title", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$HouseDetailInfoItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getTitle", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class HouseDetailInfo {
            private final String id;
            private final List<HouseDetailInfoItem> items;
            private final String title;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ HouseDetailInfo copy$default(HouseDetailInfo houseDetailInfo, String str, String str2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = houseDetailInfo.id;
                }
                if ((i & 2) != 0) {
                    str2 = houseDetailInfo.title;
                }
                if ((i & 4) != 0) {
                    list = houseDetailInfo.items;
                }
                return houseDetailInfo.copy(str, str2, list);
            }

            public final String component1() {
                return this.id;
            }

            public final String component2() {
                return this.title;
            }

            public final List<HouseDetailInfoItem> component3() {
                return this.items;
            }

            public final HouseDetailInfo copy(String id, String title, List<HouseDetailInfoItem> items) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(items, "items");
                return new HouseDetailInfo(id, title, items);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof HouseDetailInfo) {
                    HouseDetailInfo houseDetailInfo = (HouseDetailInfo) obj;
                    return Intrinsics.areEqual(this.id, houseDetailInfo.id) && Intrinsics.areEqual(this.title, houseDetailInfo.title) && Intrinsics.areEqual(this.items, houseDetailInfo.items);
                }
                return false;
            }

            public int hashCode() {
                return (((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.items.hashCode();
            }

            public String toString() {
                String str = this.id;
                String str2 = this.title;
                return "HouseDetailInfo(id=" + str + ", title=" + str2 + ", items=" + this.items + ")";
            }

            public HouseDetailInfo(String id, String title, List<HouseDetailInfoItem> items) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(items, "items");
                this.id = id;
                this.title = title;
                this.items = items;
            }

            public final String getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final List<HouseDetailInfoItem> getItems() {
                return this.items;
            }
        }

        /* compiled from: MyHouseScreen.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$HouseDetailInfoItem;", "", "title", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class HouseDetailInfoItem {
            private final String title;
            private final String value;

            public static /* synthetic */ HouseDetailInfoItem copy$default(HouseDetailInfoItem houseDetailInfoItem, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = houseDetailInfoItem.title;
                }
                if ((i & 2) != 0) {
                    str2 = houseDetailInfoItem.value;
                }
                return houseDetailInfoItem.copy(str, str2);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.value;
            }

            public final HouseDetailInfoItem copy(String title, String value) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(value, "value");
                return new HouseDetailInfoItem(title, value);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof HouseDetailInfoItem) {
                    HouseDetailInfoItem houseDetailInfoItem = (HouseDetailInfoItem) obj;
                    return Intrinsics.areEqual(this.title, houseDetailInfoItem.title) && Intrinsics.areEqual(this.value, houseDetailInfoItem.value);
                }
                return false;
            }

            public int hashCode() {
                return (this.title.hashCode() * 31) + this.value.hashCode();
            }

            public String toString() {
                String str = this.title;
                return "HouseDetailInfoItem(title=" + str + ", value=" + this.value + ")";
            }

            public HouseDetailInfoItem(String title, String value) {
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

        /* compiled from: MyHouseScreen.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$MenuItem;", "", "id", "", "title", "", "isPressed", "", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$SubMenuItem;", "<init>", "(ILjava/lang/String;ZLjava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "()Z", "setPressed", "(Z)V", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

            public final String getTitle() {
                return this.title;
            }

            public final boolean isPressed() {
                return this.isPressed;
            }

            public final void setPressed(boolean z) {
                this.isPressed = z;
            }

            public final List<SubMenuItem> getItems() {
                return this.items;
            }
        }

        /* compiled from: MyHouseScreen.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$SubMenuItem;", "", "id", "", "title", "", "isPressed", "", "<init>", "(ILjava/lang/String;Z)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "()Z", "setPressed", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        /* compiled from: MyHouseScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$UpgradeItem;", "", "id", "", "title", "", "shortDescription", FirebaseAnalytics.Param.PRICE, "purchased", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getShortDescription", "getPrice", "getPurchased", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class UpgradeItem {
            private final int id;
            private final String price;
            private final int purchased;
            private final String shortDescription;
            private final String title;

            public static /* synthetic */ UpgradeItem copy$default(UpgradeItem upgradeItem, int i, String str, String str2, String str3, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = upgradeItem.id;
                }
                if ((i3 & 2) != 0) {
                    str = upgradeItem.title;
                }
                if ((i3 & 4) != 0) {
                    str2 = upgradeItem.shortDescription;
                }
                if ((i3 & 8) != 0) {
                    str3 = upgradeItem.price;
                }
                if ((i3 & 16) != 0) {
                    i2 = upgradeItem.purchased;
                }
                int i4 = i2;
                String str4 = str2;
                return upgradeItem.copy(i, str, str4, str3, i4);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.shortDescription;
            }

            public final String component4() {
                return this.price;
            }

            public final int component5() {
                return this.purchased;
            }

            public final UpgradeItem copy(int i, String title, String shortDescription, String price, int i2) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(shortDescription, "shortDescription");
                Intrinsics.checkNotNullParameter(price, "price");
                return new UpgradeItem(i, title, shortDescription, price, i2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof UpgradeItem) {
                    UpgradeItem upgradeItem = (UpgradeItem) obj;
                    return this.id == upgradeItem.id && Intrinsics.areEqual(this.title, upgradeItem.title) && Intrinsics.areEqual(this.shortDescription, upgradeItem.shortDescription) && Intrinsics.areEqual(this.price, upgradeItem.price) && this.purchased == upgradeItem.purchased;
                }
                return false;
            }

            public int hashCode() {
                return (((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.shortDescription.hashCode()) * 31) + this.price.hashCode()) * 31) + Integer.hashCode(this.purchased);
            }

            public String toString() {
                int i = this.id;
                String str = this.title;
                String str2 = this.shortDescription;
                String str3 = this.price;
                return "UpgradeItem(id=" + i + ", title=" + str + ", shortDescription=" + str2 + ", price=" + str3 + ", purchased=" + this.purchased + ")";
            }

            public UpgradeItem(int i, String title, String shortDescription, String price, int i2) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(shortDescription, "shortDescription");
                Intrinsics.checkNotNullParameter(price, "price");
                this.id = i;
                this.title = title;
                this.shortDescription = shortDescription;
                this.price = price;
                this.purchased = i2;
            }

            public final int getId() {
                return this.id;
            }

            public final String getShortDescription() {
                return this.shortDescription;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getPrice() {
                return this.price;
            }

            public final int getPurchased() {
                return this.purchased;
            }
        }
    }

    /* compiled from: MyHouseScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHouseScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new MyHouseScreen(targetActivity, i);
        }
    }
}
