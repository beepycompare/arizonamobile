package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import com.google.gson.JsonParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.data.remote.MobileRetrofitClient;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryMainBinding;
import ru.mrlargha.feature.mobile.presentation.MobilePHoneSendSubIds;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.MobileRentAccessoryEvent;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCategoryModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryFilterModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryModelItem;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryNavigateModel;
/* compiled from: MobileRentAccessoryMainPage.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J \u0010&\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020)H\u0002J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\u0016\u0010/\u001a\u00020\u001b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\b\u00101\u001a\u00020\u001bH\u0002J\b\u00102\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryMainPage;", "", "parentContainer", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage;", "<init>", "(Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage;)V", "bindingPage", "Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryMainBinding;", "updateJob", "Lkotlinx/coroutines/Job;", "retrofitClient", "Lru/mrlargha/feature/mobile/data/remote/MobileRetrofitClient;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "adapter", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter;", "currentBar", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryMainPage$Companion$TopBar;", "topBars", "", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryMainPage$Companion$TopBarModel;", "currentAddsList", "", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryModel;", "currentFilter", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryFilterModel;", NotificationCompat.CATEGORY_EVENT, "", "data", "", "eventType", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/MobileRentAccessoryEvent;", "show", "initFilter", "selectTopBar", "topBar", "getAds", "updateWareHouse", "sendEvent", "Lru/mrlargha/feature/mobile/presentation/MobilePHoneSendSubIds;", "id", "", "getCategory", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", "categoryId", "update", "setupListeners", "setAddsApplyFilter", "list", "checkUpdate", "hide", "Companion", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryMainPage {
    public static final Companion Companion = new Companion(null);
    private final MobileRentAccessoryMainAdapter adapter;
    private final MobileRentAccessoryMainBinding bindingPage;
    private List<MobileRentAccessoryModel> currentAddsList;
    private Companion.TopBar currentBar;
    private MobileRentAccessoryFilterModel currentFilter;
    private final RentAccessoryPage parentContainer;
    private final MobileRetrofitClient retrofitClient;
    private final CoroutineScope scope;
    private final Map<Companion.TopBar, Companion.TopBarModel> topBars;
    private Job updateJob;

    /* compiled from: MobileRentAccessoryMainPage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Companion.TopBar.values().length];
            try {
                iArr[Companion.TopBar.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.TopBar.MY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Companion.TopBar.WAREHOUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MobileRentAccessoryEvent.values().length];
            try {
                iArr2[MobileRentAccessoryEvent.GET_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MobileRentAccessoryEvent.SET_TAB.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MobileRentAccessoryEvent.UPDATE_ADDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MobileRentAccessoryEvent.WARE_HOUSE_COUNT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public MobileRentAccessoryMainPage(RentAccessoryPage parentContainer) {
        Intrinsics.checkNotNullParameter(parentContainer, "parentContainer");
        this.parentContainer = parentContainer;
        MobileRentAccessoryMainBinding main = parentContainer.getBinding().main;
        Intrinsics.checkNotNullExpressionValue(main, "main");
        this.bindingPage = main;
        MobileRetrofitClient mobileRetrofitClient = new MobileRetrofitClient(parentContainer.getTargetActivity(), UIElementID.ARIZONA_MOBILE_PHONE.getId());
        this.retrofitClient = mobileRetrofitClient;
        this.scope = mobileRetrofitClient.getRetrofit().getScope();
        MobileRentAccessoryMainAdapter mobileRentAccessoryMainAdapter = new MobileRentAccessoryMainAdapter(parentContainer, new MobileRentAccessoryMainPage$adapter$1(this), new MobileRentAccessoryMainPage$adapter$2(this));
        this.adapter = mobileRentAccessoryMainAdapter;
        this.currentBar = Companion.TopBar.ALL;
        Companion.TopBar topBar = Companion.TopBar.ALL;
        CustomCardView btnAll = main.btnAll;
        Intrinsics.checkNotNullExpressionValue(btnAll, "btnAll");
        TextView tvAll = main.tvAll;
        Intrinsics.checkNotNullExpressionValue(tvAll, "tvAll");
        Companion.TopBar topBar2 = Companion.TopBar.MY;
        CustomCardView btnMy = main.btnMy;
        Intrinsics.checkNotNullExpressionValue(btnMy, "btnMy");
        TextView tvMy = main.tvMy;
        Intrinsics.checkNotNullExpressionValue(tvMy, "tvMy");
        Companion.TopBar topBar3 = Companion.TopBar.WAREHOUSE;
        CustomCardView btnWarehouse = main.btnWarehouse;
        Intrinsics.checkNotNullExpressionValue(btnWarehouse, "btnWarehouse");
        TextView tvWarehouse = main.tvWarehouse;
        Intrinsics.checkNotNullExpressionValue(tvWarehouse, "tvWarehouse");
        this.topBars = MapsKt.mutableMapOf(TuplesKt.to(topBar, new Companion.TopBarModel(btnAll, tvAll)), TuplesKt.to(topBar2, new Companion.TopBarModel(btnMy, tvMy)), TuplesKt.to(topBar3, new Companion.TopBarModel(btnWarehouse, tvWarehouse)));
        this.currentAddsList = CollectionsKt.emptyList();
        this.currentFilter = new MobileRentAccessoryFilterModel(null, null, false, false, false, false, 0, 0, 255, null);
        main.rvItems.setAdapter(mobileRentAccessoryMainAdapter);
        initFilter();
        setupListeners();
    }

    public static /* synthetic */ void event$default(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, String str, MobileRentAccessoryEvent mobileRentAccessoryEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            mobileRentAccessoryEvent = MobileRentAccessoryEvent.NONE;
        }
        mobileRentAccessoryMainPage.event(str, mobileRentAccessoryEvent);
    }

    public final void event(String str, MobileRentAccessoryEvent eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (str != null) {
            if (eventType == MobileRentAccessoryEvent.NONE) {
                show();
                return;
            } else {
                update(str, eventType);
                return;
            }
        }
        hide();
    }

    private final void show() {
        FrameLayout root = this.bindingPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        getAds();
        checkUpdate();
    }

    private final void initFilter() {
        MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding = this.bindingPage;
        if (this.currentFilter.equals(new MobileRentAccessoryFilterModel(null, null, false, false, false, false, 0, 0, 255, null))) {
            CustomCardView btnFilter = mobileRentAccessoryMainBinding.btnFilter;
            Intrinsics.checkNotNullExpressionValue(btnFilter, "btnFilter");
            CustomCardView.setBackground$default(btnFilter, Color.parseColor("#33FFFFFF"), Color.parseColor("#0DFFFFFF"), null, null, 12, null);
            mobileRentAccessoryMainBinding.ivFilter.setImageTintList(ColorStateList.valueOf(-1));
            return;
        }
        mobileRentAccessoryMainBinding.btnFilter.setBackground(-1);
        mobileRentAccessoryMainBinding.ivFilter.setImageTintList(ColorStateList.valueOf(-16777216));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectTopBar(Companion.TopBar topBar) {
        CustomCardView customCardView;
        TextView textView;
        for (Map.Entry<Companion.TopBar, Companion.TopBarModel> entry : this.topBars.entrySet()) {
            entry.getKey();
            Companion.TopBarModel value = entry.getValue();
            value.getTextView().setTextColor(Color.parseColor("#B2FFFFFF"));
            CustomCardView.setBackground$default(value.getCustomCardView(), Color.parseColor("#33FFFFFF"), Color.parseColor("#0DFFFFFF"), null, null, 12, null);
        }
        Companion.TopBarModel topBarModel = this.topBars.get(topBar);
        if (topBarModel != null && (textView = topBarModel.getTextView()) != null) {
            textView.setTextColor(Color.parseColor("#E5000000"));
        }
        Companion.TopBarModel topBarModel2 = this.topBars.get(topBar);
        if (topBarModel2 != null && (customCardView = topBarModel2.getCustomCardView()) != null) {
            customCardView.setBackground(-1);
        }
        this.currentBar = topBar;
        this.adapter.setCurrentTopBar(topBar);
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentBar.ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.currentAddsList) {
                if (((MobileRentAccessoryModel) obj).getStatus() == 1) {
                    arrayList.add(obj);
                }
            }
            setAddsApplyFilter(arrayList);
        } else if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : this.currentAddsList) {
                MobileRentAccessoryModel mobileRentAccessoryModel = (MobileRentAccessoryModel) obj2;
                if ((mobileRentAccessoryModel.getStatus() == 0 && mobileRentAccessoryModel.getIsMy(this.parentContainer.getTargetActivity())) || (mobileRentAccessoryModel.getStatus() == 1 && mobileRentAccessoryModel.getIsMy(this.parentContainer.getTargetActivity()))) {
                    arrayList2.add(obj2);
                }
            }
            setAddsApplyFilter(arrayList2);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : this.currentAddsList) {
                MobileRentAccessoryModel mobileRentAccessoryModel2 = (MobileRentAccessoryModel) obj3;
                if ((mobileRentAccessoryModel2.getStatus() == 2 && mobileRentAccessoryModel2.getIsMy(this.parentContainer.getTargetActivity())) || (mobileRentAccessoryModel2.getStatus() == 3 && mobileRentAccessoryModel2.getIsRent(this.parentContainer.getTargetActivity()))) {
                    arrayList3.add(obj3);
                }
            }
            setAddsApplyFilter(arrayList3);
        }
    }

    private final void getAds() {
        LinearLayout mainContainer = this.bindingPage.mainContainer;
        Intrinsics.checkNotNullExpressionValue(mainContainer, "mainContainer");
        mainContainer.setVisibility(8);
        ProgressBar progressBar = this.bindingPage.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(0);
        BuildersKt__Builders_commonKt.launch$default(this.retrofitClient.getRetrofit().getScope(), null, null, new MobileRentAccessoryMainPage$getAds$1(this, null), 3, null);
        updateWareHouse();
    }

    private final void updateWareHouse() {
        int i = this.parentContainer.getSharedPreferences().getInt("WAREHOUSE_COUNT", 0);
        Log.d("TAG", "updateWareHouse: " + i);
        MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding = this.bindingPage;
        if (i > 0) {
            CustomCardView notification = mobileRentAccessoryMainBinding.notification;
            Intrinsics.checkNotNullExpressionValue(notification, "notification");
            notification.setVisibility(0);
            this.bindingPage.tvNotificationCount.setText(String.valueOf(i));
            return;
        }
        CustomCardView notification2 = mobileRentAccessoryMainBinding.notification;
        Intrinsics.checkNotNullExpressionValue(notification2, "notification");
        notification2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(MobilePHoneSendSubIds mobilePHoneSendSubIds, String str, int i) {
        this.parentContainer.sendFrontendMessage(mobilePHoneSendSubIds.getSubIds(), i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MobileRentAccessoryCategoryModel getCategory(int i) {
        List<MobileRentAccessoryCategoryModel> rentCategories = this.parentContainer.getRentCategories();
        Object obj = null;
        if (rentCategories != null) {
            Iterator<T> it = rentCategories.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MobileRentAccessoryCategoryModel) next).getId() == i) {
                    obj = next;
                    break;
                }
            }
            return (MobileRentAccessoryCategoryModel) obj;
        }
        return null;
    }

    private final void update(String str, MobileRentAccessoryEvent mobileRentAccessoryEvent) {
        Companion.TopBar topBar;
        int i = WhenMappings.$EnumSwitchMapping$1[mobileRentAccessoryEvent.ordinal()];
        if (i == 1) {
            if (MapperKt.isJsonValid(str)) {
                this.currentFilter = (MobileRentAccessoryFilterModel) MapperKt.getGson().fromJson(str, (Class<Object>) MobileRentAccessoryFilterModel.class);
                initFilter();
                return;
            }
            throw new JsonParseException("Json is not valid");
        } else if (i != 2) {
            if (i == 3) {
                getAds();
            } else if (i != 4) {
            } else {
                updateWareHouse();
            }
        } else if (MapperKt.isJsonValid(str)) {
            MobileRentAccessoryNavigateModel mobileRentAccessoryNavigateModel = (MobileRentAccessoryNavigateModel) MapperKt.getGson().fromJson(str, (Class<Object>) MobileRentAccessoryNavigateModel.class);
            int tab = mobileRentAccessoryNavigateModel.getTab();
            if (tab == 0) {
                topBar = Companion.TopBar.ALL;
            } else if (tab == 1) {
                topBar = Companion.TopBar.MY;
            } else {
                topBar = Companion.TopBar.WAREHOUSE;
            }
            this.currentBar = topBar;
            selectTopBar(topBar);
            if (mobileRentAccessoryNavigateModel.getListUID() > 0) {
                Iterator<MobileRentAccessoryModel> it = this.currentAddsList.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    } else if (it.next().getListUID() == mobileRentAccessoryNavigateModel.getListUID()) {
                        break;
                    } else {
                        i2++;
                    }
                }
                this.bindingPage.rvItems.smoothScrollToPosition(i2);
            }
        } else {
            throw new JsonParseException("Json is not valid");
        }
    }

    private final void setupListeners() {
        final MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding = this.bindingPage;
        mobileRentAccessoryMainBinding.btnAll.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryMainPage.setupListeners$lambda$0$0(MobileRentAccessoryMainPage.this, view);
            }
        });
        mobileRentAccessoryMainBinding.btnMy.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryMainPage.setupListeners$lambda$0$1(MobileRentAccessoryMainPage.this, view);
            }
        });
        mobileRentAccessoryMainBinding.btnWarehouse.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryMainPage.setupListeners$lambda$0$2(MobileRentAccessoryMainPage.this, view);
            }
        });
        mobileRentAccessoryMainBinding.btnFilter.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileRentAccessoryMainPage.setupListeners$lambda$0$3(MobileRentAccessoryMainPage.this, view);
            }
        });
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        CustomCardView btnUpdate = mobileRentAccessoryMainBinding.btnUpdate;
        Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
        EasyAnimation.animateClick$default(easyAnimation, btnUpdate, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = MobileRentAccessoryMainPage.setupListeners$lambda$0$4(MobileRentAccessoryMainBinding.this, this);
                return unit;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, View view) {
        mobileRentAccessoryMainPage.selectTopBar(Companion.TopBar.ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, View view) {
        mobileRentAccessoryMainPage.selectTopBar(Companion.TopBar.MY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, View view) {
        mobileRentAccessoryMainPage.selectTopBar(Companion.TopBar.WAREHOUSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$3(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, View view) {
        mobileRentAccessoryMainPage.parentContainer.navigatePage(RentAccessoryPage.Companion.RentAccessoryPages.FILTER);
        mobileRentAccessoryMainPage.parentContainer.getFilterPage().event(StringKt.toStringJson(mobileRentAccessoryMainPage.currentFilter), MobileRentAccessoryEvent.GET_FILTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupListeners$lambda$0$4(MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding, MobileRentAccessoryMainPage mobileRentAccessoryMainPage) {
        CustomCardView btnUpdate = mobileRentAccessoryMainBinding.btnUpdate;
        Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
        btnUpdate.setVisibility(8);
        mobileRentAccessoryMainPage.getAds();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List, T] */
    private final void setAddsApplyFilter(List<MobileRentAccessoryModel> list) {
        T t;
        Object obj;
        String name;
        String obj2;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = list;
        String name2 = this.currentFilter.getName();
        if (name2 != null) {
            String obj3 = StringsKt.trim((CharSequence) name2).toString();
            ArrayList arrayList = new ArrayList();
            for (Object obj4 : (Iterable) objectRef.element) {
                List<MobileRentAccessoryModelItem> items = ((MobileRentAccessoryModel) obj4).getItems();
                if (!(items instanceof Collection) || !items.isEmpty()) {
                    Iterator<T> it = items.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            MobileRentAccessoryModelItem mobileRentAccessoryModelItem = (MobileRentAccessoryModelItem) it.next();
                            Iterator<T> it2 = UtilsKt.getItemsName().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it2.next();
                                if (((ItemsInfo) obj).getId() == mobileRentAccessoryModelItem.getItemID()) {
                                    break;
                                }
                            }
                            ItemsInfo itemsInfo = (ItemsInfo) obj;
                            if (itemsInfo != null && (name = itemsInfo.getName()) != null && (obj2 = StringsKt.trim((CharSequence) name).toString()) != null && StringsKt.equals(obj2, obj3, true)) {
                                arrayList.add(obj4);
                                break;
                            }
                        }
                    }
                }
            }
            objectRef.element = arrayList;
        }
        Integer number = this.currentFilter.getNumber();
        if (number != null) {
            int intValue = number.intValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj5 : (Iterable) objectRef.element) {
                if (((MobileRentAccessoryModel) obj5).getListID() == intValue) {
                    arrayList2.add(obj5);
                }
            }
            objectRef.element = arrayList2;
        }
        if (this.currentFilter.isSortByPrice()) {
            t = CollectionsKt.sortedWith((Iterable) objectRef.element, new Comparator() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$setAddsApplyFilter$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t2, T t3) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((MobileRentAccessoryModel) t2).getCost()), Integer.valueOf(((MobileRentAccessoryModel) t3).getCost()));
                }
            });
        } else {
            if (this.currentFilter.isSortByRating()) {
                CollectionsKt.sortedWith((Iterable) objectRef.element, new Comparator() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$setAddsApplyFilter$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t2, T t3) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((MobileRentAccessoryModel) t2).getRating()), Integer.valueOf(((MobileRentAccessoryModel) t3).getRating()));
                    }
                });
            }
            t = (List) objectRef.element;
        }
        objectRef.element = t;
        if (this.currentFilter.getOnlySet()) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj6 : (Iterable) objectRef.element) {
                if (((MobileRentAccessoryModel) obj6).getType() == 0) {
                    arrayList3.add(obj6);
                }
            }
            objectRef.element = arrayList3;
        }
        if (this.currentFilter.getOnlySharpingTenPlus()) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj7 : (Iterable) objectRef.element) {
                List<MobileRentAccessoryModelItem> items2 = ((MobileRentAccessoryModel) obj7).getItems();
                if (!(items2 instanceof Collection) || !items2.isEmpty()) {
                    Iterator<T> it3 = items2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (((MobileRentAccessoryModelItem) it3.next()).getEnchanted() > 10) {
                                arrayList4.add(obj7);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            objectRef.element = arrayList4;
        }
        if (this.currentFilter.getCategoryId() > -1) {
            ArrayList arrayList5 = new ArrayList();
            for (Object obj8 : (Iterable) objectRef.element) {
                if (((MobileRentAccessoryModel) obj8).getCategory() == this.currentFilter.getCategoryId()) {
                    arrayList5.add(obj8);
                }
            }
            objectRef.element = arrayList5;
        }
        if (this.currentFilter.getBizId() > -1) {
            ArrayList arrayList6 = new ArrayList();
            for (Object obj9 : (Iterable) objectRef.element) {
                if (((MobileRentAccessoryModel) obj9).getBizID() == this.currentFilter.getBizId()) {
                    arrayList6.add(obj9);
                }
            }
            objectRef.element = arrayList6;
        }
        LinearLayout root = this.bindingPage.notFoundContainer.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(((List) objectRef.element).isEmpty() ? 0 : 8);
        RecyclerView rvItems = this.bindingPage.rvItems;
        Intrinsics.checkNotNullExpressionValue(rvItems, "rvItems");
        rvItems.setVisibility(((Collection) objectRef.element).isEmpty() ? 8 : 0);
        this.adapter.submitList(CollectionsKt.toMutableList((Collection) objectRef.element));
    }

    private final void checkUpdate() {
        Job launch$default;
        Job job = this.updateJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MobileRentAccessoryMainPage$checkUpdate$1(this, null), 3, null);
        this.updateJob = launch$default;
    }

    private final void hide() {
        FrameLayout root = this.bindingPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }

    /* compiled from: MobileRentAccessoryMainPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryMainPage$Companion;", "", "<init>", "()V", "TopBar", "TopBarModel", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: MobileRentAccessoryMainPage.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryMainPage$Companion$TopBar;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "MY", "WAREHOUSE", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class TopBar {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ TopBar[] $VALUES;
            public static final TopBar ALL = new TopBar("ALL", 0);
            public static final TopBar MY = new TopBar("MY", 1);
            public static final TopBar WAREHOUSE = new TopBar("WAREHOUSE", 2);

            private static final /* synthetic */ TopBar[] $values() {
                return new TopBar[]{ALL, MY, WAREHOUSE};
            }

            public static EnumEntries<TopBar> getEntries() {
                return $ENTRIES;
            }

            public static TopBar valueOf(String str) {
                return (TopBar) Enum.valueOf(TopBar.class, str);
            }

            public static TopBar[] values() {
                return (TopBar[]) $VALUES.clone();
            }

            private TopBar(String str, int i) {
            }

            static {
                TopBar[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MobileRentAccessoryMainPage.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryMainPage$Companion$TopBarModel;", "", "customCardView", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "textView", "Landroid/widget/TextView;", "<init>", "(Lru/mrlargha/commonui/utils/ui/CustomCardView;Landroid/widget/TextView;)V", "getCustomCardView", "()Lru/mrlargha/commonui/utils/ui/CustomCardView;", "getTextView", "()Landroid/widget/TextView;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class TopBarModel {
            private final CustomCardView customCardView;
            private final TextView textView;

            public static /* synthetic */ TopBarModel copy$default(TopBarModel topBarModel, CustomCardView customCardView, TextView textView, int i, Object obj) {
                if ((i & 1) != 0) {
                    customCardView = topBarModel.customCardView;
                }
                if ((i & 2) != 0) {
                    textView = topBarModel.textView;
                }
                return topBarModel.copy(customCardView, textView);
            }

            public final CustomCardView component1() {
                return this.customCardView;
            }

            public final TextView component2() {
                return this.textView;
            }

            public final TopBarModel copy(CustomCardView customCardView, TextView textView) {
                Intrinsics.checkNotNullParameter(customCardView, "customCardView");
                Intrinsics.checkNotNullParameter(textView, "textView");
                return new TopBarModel(customCardView, textView);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TopBarModel) {
                    TopBarModel topBarModel = (TopBarModel) obj;
                    return Intrinsics.areEqual(this.customCardView, topBarModel.customCardView) && Intrinsics.areEqual(this.textView, topBarModel.textView);
                }
                return false;
            }

            public int hashCode() {
                return (this.customCardView.hashCode() * 31) + this.textView.hashCode();
            }

            public String toString() {
                CustomCardView customCardView = this.customCardView;
                return "TopBarModel(customCardView=" + customCardView + ", textView=" + this.textView + ")";
            }

            public TopBarModel(CustomCardView customCardView, TextView textView) {
                Intrinsics.checkNotNullParameter(customCardView, "customCardView");
                Intrinsics.checkNotNullParameter(textView, "textView");
                this.customCardView = customCardView;
                this.textView = textView;
            }

            public final CustomCardView getCustomCardView() {
                return this.customCardView;
            }

            public final TextView getTextView() {
                return this.textView;
            }
        }
    }
}
