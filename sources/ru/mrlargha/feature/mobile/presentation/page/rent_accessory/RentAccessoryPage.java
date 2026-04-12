package ru.mrlargha.feature.mobile.presentation.page.rent_accessory;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonParseException;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.data.remote.MobileRetrofitClient;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryPageBinding;
import ru.mrlargha.feature.mobile.domain.enums.MobilePhonePage;
import ru.mrlargha.feature.mobile.presentation.HistoryManager;
import ru.mrlargha.feature.mobile.presentation.MobilePHoneSendSubIds;
import ru.mrlargha.feature.mobile.presentation.MobilePage;
import ru.mrlargha.feature.mobile.presentation.MobilePhoneGetSubIds;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryCategoryAdapter;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.adapters.MobileRentAccessoryMainAdapter;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryCategoryModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryFilterServerModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.models.MobileRentAccessoryNavigateModel;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryCreateAddPage;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryFilterPage;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage;
/* compiled from: RentAccessoryPage.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u0002062\u0006\u00109\u001a\u00020:2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u000206H\u0002J\b\u0010?\u001a\u000206H\u0002J\b\u0010@\u001a\u000206H\u0002J\u0010\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020(H\u0002J\u000e\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020-J\b\u0010E\u001a\u000206H\u0016J\b\u0010F\u001a\u000206H\u0016J\b\u0010G\u001a\u000206H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\"\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R.\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006I"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage;", "Lru/mrlargha/feature/mobile/presentation/MobilePage;", "<init>", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "binding", "Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryPageBinding;", "getBinding", "()Lru/mrlargha/feature/mobile/databinding/MobileRentAccessoryPageBinding;", "targetActivity", "Landroid/app/Activity;", "getTargetActivity", "()Landroid/app/Activity;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "retrofitClient", "Lru/mrlargha/feature/mobile/data/remote/MobileRetrofitClient;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "mainPage", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryMainPage;", "getMainPage", "()Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryMainPage;", "createAddPage", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryCreateAddPage;", "filterPage", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryFilterPage;", "getFilterPage", "()Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/pages/MobileRentAccessoryFilterPage;", "value", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter$Companion$UserPosition;", "userPosition", "getUserPosition", "()Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryMainAdapter$Companion$UserPosition;", "", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/models/MobileRentAccessoryCategoryModel;", "rentCategories", "getRentCategories", "()Ljava/util/List;", "currentPage", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage$Companion$RentAccessoryPages;", "categoryAdapter", "Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/adapters/MobileRentAccessoryCategoryAdapter;", "afterCategoryPage", "getAfterCategoryPage", "()Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage$Companion$RentAccessoryPages;", "setAfterCategoryPage", "(Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage$Companion$RentAccessoryPages;)V", "sendEvent", "", "subId", "Lru/mrlargha/feature/mobile/presentation/MobilePhoneGetSubIds;", "data", "", "changeFocus", "withUpdate", "", "initialize", "getCategories", "setupListeners", "selectCategory", CommonUrlParts.MODEL, "navigatePage", "page", "hidePage", "removePage", "renderPage", "Companion", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RentAccessoryPage extends MobilePage {
    public static final Companion Companion = new Companion(null);
    private Companion.RentAccessoryPages afterCategoryPage;
    private final MobileRentAccessoryPageBinding binding;
    private final MobileRentAccessoryCategoryAdapter categoryAdapter;
    private final MobileRentAccessoryCreateAddPage createAddPage;
    private Companion.RentAccessoryPages currentPage;
    private final MobileRentAccessoryFilterPage filterPage;
    private final MobileRentAccessoryMainPage mainPage;
    private List<MobileRentAccessoryCategoryModel> rentCategories;
    private final MobileRetrofitClient retrofitClient;
    private final CoroutineScope scope;
    private final SharedPreferences sharedPreferences;
    private final Activity targetActivity;
    private MobileRentAccessoryMainAdapter.Companion.UserPosition userPosition;
    private final View view;

    /* compiled from: RentAccessoryPage.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MobilePhoneGetSubIds.values().length];
            try {
                iArr[MobilePhoneGetSubIds.RENT_ACCESSORY_GET_USER_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MobilePhoneGetSubIds.RENT_ACCESSORY_GET_SELECTED_ACCESSORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MobilePhoneGetSubIds.RENT_ACCESSORY_GET_LIMIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MobilePhoneGetSubIds.RENT_ACCESSORY_WAREHOUSE_COUNT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MobilePhoneGetSubIds.RENT_ACCESSORY_GET_FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MobilePhoneGetSubIds.RENT_ACCESSORY_CHANGE_FOCUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MobilePhoneGetSubIds.RENT_ACCESSORY_UPDATE_API.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RentAccessoryPage() {
        super(MobilePhonePage.RENT_ACCESSORY.getId());
        View inflate = getContext().getLayoutInflater().inflate(R.layout.mobile_rent_accessory_page, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.view = inflate;
        MobileRentAccessoryPageBinding bind = MobileRentAccessoryPageBinding.bind(getView());
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.targetActivity = getMobilePhone().getContext();
        this.sharedPreferences = getMobilePhone().getSharedPreferencesFun();
        MobileRetrofitClient mobileRetrofitClient = new MobileRetrofitClient(getContext(), UIElementID.ARIZONA_MOBILE_PHONE.getId());
        this.retrofitClient = mobileRetrofitClient;
        this.scope = mobileRetrofitClient.getRetrofit().getScope();
        this.mainPage = new MobileRentAccessoryMainPage(this);
        this.createAddPage = new MobileRentAccessoryCreateAddPage(this);
        this.filterPage = new MobileRentAccessoryFilterPage(this);
        this.currentPage = Companion.RentAccessoryPages.MAIN;
        this.categoryAdapter = new MobileRentAccessoryCategoryAdapter(new RentAccessoryPage$categoryAdapter$1(this));
        this.afterCategoryPage = Companion.RentAccessoryPages.FILTER;
        HistoryManager.Companion.push(MobilePhonePage.RENT_ACCESSORY.getId());
        bind.getRoot().setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        initialize();
        getCategories();
        setupListeners();
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage
    public View getView() {
        return this.view;
    }

    public final MobileRentAccessoryPageBinding getBinding() {
        return this.binding;
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    public final SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    public final MobileRentAccessoryMainPage getMainPage() {
        return this.mainPage;
    }

    public final MobileRentAccessoryFilterPage getFilterPage() {
        return this.filterPage;
    }

    public final MobileRentAccessoryMainAdapter.Companion.UserPosition getUserPosition() {
        return this.userPosition;
    }

    public final List<MobileRentAccessoryCategoryModel> getRentCategories() {
        return this.rentCategories;
    }

    public final Companion.RentAccessoryPages getAfterCategoryPage() {
        return this.afterCategoryPage;
    }

    public final void setAfterCategoryPage(Companion.RentAccessoryPages rentAccessoryPages) {
        Intrinsics.checkNotNullParameter(rentAccessoryPages, "<set-?>");
        this.afterCategoryPage = rentAccessoryPages;
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage
    public void sendEvent(MobilePhoneGetSubIds subId, String data) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(data, "data");
        switch (WhenMappings.$EnumSwitchMapping$0[subId.ordinal()]) {
            case 1:
                if (MapperKt.isJsonValid(data)) {
                    this.userPosition = (MobileRentAccessoryMainAdapter.Companion.UserPosition) MapperKt.getGson().fromJson(data, (Class<Object>) MobileRentAccessoryMainAdapter.Companion.UserPosition.class);
                    return;
                }
                throw new JsonParseException("Json is not valid");
            case 2:
                this.createAddPage.event(data, MobileRentAccessoryEvent.GET_CHOSEN_ITEM);
                return;
            case 3:
                this.createAddPage.event(data, MobileRentAccessoryEvent.SET_LIMITS);
                return;
            case 4:
                this.mainPage.event(data, MobileRentAccessoryEvent.WARE_HOUSE_COUNT);
                return;
            case 5:
                if (MapperKt.isJsonValid(data)) {
                    MobileRentAccessoryFilterServerModel mobileRentAccessoryFilterServerModel = (MobileRentAccessoryFilterServerModel) MapperKt.getGson().fromJson(data, (Class<Object>) MobileRentAccessoryFilterServerModel.class);
                    this.mainPage.event(StringKt.toStringJson(mobileRentAccessoryFilterServerModel.toItemModel()), MobileRentAccessoryEvent.GET_FILTER);
                    this.filterPage.event(StringKt.toStringJson(mobileRentAccessoryFilterServerModel.toItemModel()), MobileRentAccessoryEvent.GET_FILTER);
                    return;
                }
                throw new JsonParseException("Json is not valid");
            case 6:
                changeFocus(data, false);
                return;
            case 7:
                changeFocus(data, true);
                return;
            default:
                return;
        }
    }

    private final void initialize() {
        this.binding.rvCategories.setAdapter(this.categoryAdapter);
        navigatePage(Companion.RentAccessoryPages.MAIN);
    }

    private final void getCategories() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new RentAccessoryPage$getCategories$1(this, null), 3, null);
    }

    private final void setupListeners() {
        MobileRentAccessoryPageBinding mobileRentAccessoryPageBinding = this.binding;
        mobileRentAccessoryPageBinding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RentAccessoryPage.setupListeners$lambda$0$0(RentAccessoryPage.this, view);
            }
        });
        mobileRentAccessoryPageBinding.btnAdd.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RentAccessoryPage.setupListeners$lambda$0$1(RentAccessoryPage.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(RentAccessoryPage rentAccessoryPage, View view) {
        if (rentAccessoryPage.currentPage == Companion.RentAccessoryPages.MAIN || rentAccessoryPage.currentPage == Companion.RentAccessoryPages.NOT_DATA) {
            rentAccessoryPage.closeApp();
        } else {
            rentAccessoryPage.navigatePage(Companion.RentAccessoryPages.MAIN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(RentAccessoryPage rentAccessoryPage, View view) {
        rentAccessoryPage.sendFrontendMessage(MobilePHoneSendSubIds.RENT_ACCESSORY_NAVIGATE_CREATE_ADD.getSubIds(), 0, "");
        rentAccessoryPage.navigatePage(Companion.RentAccessoryPages.CREATE_ADD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectCategory(MobileRentAccessoryCategoryModel mobileRentAccessoryCategoryModel) {
        if (this.afterCategoryPage == Companion.RentAccessoryPages.FILTER) {
            navigatePage(this.afterCategoryPage);
            this.filterPage.event(StringKt.toStringJson(mobileRentAccessoryCategoryModel), MobileRentAccessoryEvent.GET_CATEGORY);
            return;
        }
        RecyclerView rvCategories = this.binding.rvCategories;
        Intrinsics.checkNotNullExpressionValue(rvCategories, "rvCategories");
        rvCategories.setVisibility(8);
        this.currentPage = Companion.RentAccessoryPages.CREATE_ADD;
        this.createAddPage.event(StringKt.toStringJson(mobileRentAccessoryCategoryModel), MobileRentAccessoryEvent.GET_CATEGORY);
    }

    public final void navigatePage(Companion.RentAccessoryPages page) {
        Intrinsics.checkNotNullParameter(page, "page");
        MobileRentAccessoryPageBinding mobileRentAccessoryPageBinding = this.binding;
        this.currentPage = page;
        MobileRentAccessoryMainPage.event$default(this.mainPage, (page == Companion.RentAccessoryPages.MAIN || page == Companion.RentAccessoryPages.FILTER) ? "" : null, null, 2, null);
        RecyclerView rvCategories = mobileRentAccessoryPageBinding.rvCategories;
        Intrinsics.checkNotNullExpressionValue(rvCategories, "rvCategories");
        rvCategories.setVisibility(page == Companion.RentAccessoryPages.CATEGORIES ? 0 : 8);
        if (page == Companion.RentAccessoryPages.CATEGORIES) {
            this.categoryAdapter.submitList(this.rentCategories);
        }
        MobileRentAccessoryCreateAddPage.event$default(this.createAddPage, page == Companion.RentAccessoryPages.CREATE_ADD ? "" : null, null, 2, null);
        LinearLayout root = mobileRentAccessoryPageBinding.notData.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(page == Companion.RentAccessoryPages.NOT_DATA ? 0 : 8);
        MobileRentAccessoryFilterPage.event$default(this.filterPage, page != Companion.RentAccessoryPages.FILTER ? null : "", null, 2, null);
        FrameLayout root2 = mobileRentAccessoryPageBinding.filter.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(page == Companion.RentAccessoryPages.FILTER ? 0 : 8);
        ImageView btnAdd = mobileRentAccessoryPageBinding.btnAdd;
        Intrinsics.checkNotNullExpressionValue(btnAdd, "btnAdd");
        btnAdd.setVisibility(page == Companion.RentAccessoryPages.CREATE_ADD ? 4 : 0);
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage
    public void hidePage() {
        super.hidePage();
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage, ru.mrlargha.feature.mobile.presentation.MobileController
    public void removePage() {
        super.removePage();
        sendFrontendMessage(MobilePHoneSendSubIds.RENT_ACCESSORY_CLOSE.getSubIds(), 0, "");
        Log.d("TAG", "removePage: ");
    }

    @Override // ru.mrlargha.feature.mobile.presentation.MobilePage, ru.mrlargha.feature.mobile.presentation.MobileController
    public void renderPage() {
        super.renderPage();
        getMobilePhone().getBinding().phoneBackground.setBackgroundResource(R.drawable.mobile_rent_accessory_bg);
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
    }

    /* compiled from: RentAccessoryPage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage$Companion;", "", "<init>", "()V", "RentAccessoryPages", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: RentAccessoryPage.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/RentAccessoryPage$Companion$RentAccessoryPages;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN", "CREATE_ADD", "FILTER", "NOT_DATA", "CATEGORIES", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class RentAccessoryPages {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ RentAccessoryPages[] $VALUES;
            public static final RentAccessoryPages MAIN = new RentAccessoryPages("MAIN", 0);
            public static final RentAccessoryPages CREATE_ADD = new RentAccessoryPages("CREATE_ADD", 1);
            public static final RentAccessoryPages FILTER = new RentAccessoryPages("FILTER", 2);
            public static final RentAccessoryPages NOT_DATA = new RentAccessoryPages("NOT_DATA", 3);
            public static final RentAccessoryPages CATEGORIES = new RentAccessoryPages("CATEGORIES", 4);

            private static final /* synthetic */ RentAccessoryPages[] $values() {
                return new RentAccessoryPages[]{MAIN, CREATE_ADD, FILTER, NOT_DATA, CATEGORIES};
            }

            public static EnumEntries<RentAccessoryPages> getEntries() {
                return $ENTRIES;
            }

            public static RentAccessoryPages valueOf(String str) {
                return (RentAccessoryPages) Enum.valueOf(RentAccessoryPages.class, str);
            }

            public static RentAccessoryPages[] values() {
                return (RentAccessoryPages[]) $VALUES.clone();
            }

            private RentAccessoryPages(String str, int i) {
            }

            static {
                RentAccessoryPages[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }

        private Companion() {
        }
    }

    private final void changeFocus(String str, boolean z) {
        if (MapperKt.isJsonValid(str)) {
            int page = ((MobileRentAccessoryNavigateModel) MapperKt.getGson().fromJson(str, (Class<Object>) MobileRentAccessoryNavigateModel.class)).getPage();
            if (page == 0) {
                navigatePage(Companion.RentAccessoryPages.MAIN);
                this.mainPage.event(str, MobileRentAccessoryEvent.SET_TAB);
            } else if (page == 1) {
                navigatePage(Companion.RentAccessoryPages.CREATE_ADD);
                this.createAddPage.event(str, MobileRentAccessoryEvent.SET_TAB);
            }
            if (z) {
                this.mainPage.event(str, MobileRentAccessoryEvent.UPDATE_ADDS);
                return;
            }
            return;
        }
        throw new JsonParseException("Json is not valid");
    }
}
