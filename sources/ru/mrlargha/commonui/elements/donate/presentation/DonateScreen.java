package ru.mrlargha.commonui.elements.donate.presentation;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.DonateMainPageBinding;
import ru.mrlargha.commonui.databinding.DonateOrdinaryPageBinding;
import ru.mrlargha.commonui.databinding.DonatePurchasePageBinding;
import ru.mrlargha.commonui.databinding.DonateReplenishmentDialogBinding;
import ru.mrlargha.commonui.databinding.DonateScreenBinding;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateCategoryAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBadgesModel;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBonusModel;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModel;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateRateModel;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateReplenishmentDialogModel;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonateMainPage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePurchasePage;
import ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: DonateScreen.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u000fH\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/DonateScreenBinding;", "pages", "", "Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen$Pages;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "currentPage", "categoryAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateCategoryAdapter;", "getBadgesList", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBadgesModel;", "categoryModel", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateCategoryModel;", "itemModel", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModel;", "dialogModel", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateReplenishmentDialogModel;", "initAdapters", "", "()Lkotlin/Unit;", "setPage", "page", "Pages", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateScreen extends SAMPUIElement {
    private final DonateScreenBinding binding;
    private final DonateCategoryAdapter categoryAdapter;
    private final DonateCategoryModel categoryModel;
    private Pages currentPage;
    private final DonateReplenishmentDialogModel dialogModel;
    private final DonateItemModel itemModel;
    private final Map<Pages, DonatePage> pages;
    private final View screen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.donate_screen, (ViewGroup) null);
        this.screen = screen;
        DonateScreenBinding bind = DonateScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        Pages pages = Pages.MAIN;
        DonateMainPageBinding mainPage = bind.mainPage;
        Intrinsics.checkNotNullExpressionValue(mainPage, "mainPage");
        Pages pages2 = Pages.ORDINARY;
        DonateOrdinaryPageBinding ordinaryPage = bind.ordinaryPage;
        Intrinsics.checkNotNullExpressionValue(ordinaryPage, "ordinaryPage");
        Pages pages3 = Pages.PURCHASE;
        DonatePurchasePageBinding purchasePage = bind.purchasePage;
        Intrinsics.checkNotNullExpressionValue(purchasePage, "purchasePage");
        Pages pages4 = Pages.DIALOG;
        DonateReplenishmentDialogBinding replenishmentDialogPage = bind.replenishmentDialogPage;
        Intrinsics.checkNotNullExpressionValue(replenishmentDialogPage, "replenishmentDialogPage");
        this.pages = MapsKt.mapOf(TuplesKt.to(pages, new DonateMainPage(i, targetActivity, mainPage)), TuplesKt.to(pages2, new DonateOrdinaryPage(i, targetActivity, ordinaryPage)), TuplesKt.to(pages3, new DonatePurchasePage(i, targetActivity, purchasePage)), TuplesKt.to(pages4, new DonateReplenishmentDialogPage(i, targetActivity, replenishmentDialogPage)));
        this.currentPage = Pages.NONE;
        this.categoryAdapter = new DonateCategoryAdapter();
        this.categoryModel = new DonateCategoryModel(0, "", null, "#80CB3200", "", "", false, true);
        this.itemModel = new DonateItemModel(0, "title", 300, 0, 0, 1, false, CollectionsKt.listOf((Object[]) new String[]{"#FD0E42", "#D5002B"}), "Title", "", "#D5002B", "", 5, 3, "Требуется бокс миллионера", 1718097600, getBadgesList());
        this.dialogModel = new DonateReplenishmentDialogModel(getBadgesList(), new DonateRateModel(1, 75), CollectionsKt.listOf((Object[]) new DonateBonusModel[]{new DonateBonusModel(1000, 5), new DonateBonusModel(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 10), new DonateBonusModel(5000, 15)}));
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        initAdapters();
    }

    private final List<DonateBadgesModel> getBadgesList() {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 4; i++) {
            arrayList.add(new DonateBadgesModel(CollectionsKt.listOf((Object[]) new String[]{"#CF60A6", "#B7004F"}), "Title " + i, 12345));
        }
        return arrayList;
    }

    private final Unit initAdapters() {
        DonateScreenBinding donateScreenBinding = this.binding;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            String str = null;
            if (i >= 11) {
                break;
            }
            arrayList2.add(DonateItemModel.copy$default(this.itemModel, i, "title " + i, 0, 0, Random.Default.nextInt(4), 0, false, null, null, null, null, null, 0, 0, null, 0, null, 131052, null));
            DonateCategoryModel donateCategoryModel = this.categoryModel;
            String str2 = "title " + i;
            boolean nextBoolean = Random.Default.nextBoolean();
            if (Random.Default.nextBoolean()) {
                str = "#FF9112";
            }
            arrayList.add(DonateCategoryModel.copy$default(donateCategoryModel, i, str2, str, null, null, null, nextBoolean, false, 184, null));
            i++;
        }
        donateScreenBinding.rvCategories.setAdapter(this.categoryAdapter);
        donateScreenBinding.rvCategories.setScrollbarFadingEnabled(false);
        this.categoryAdapter.submitList(arrayList);
        setPage(Pages.MAIN);
        DonatePage donatePage = this.pages.get(this.currentPage);
        if (donatePage != null) {
            donatePage.onBackendMessage(DonateSubIds.MAIN_LIST_INIT.getSubIds(), StringKt.toStringJson(arrayList2));
            return Unit.INSTANCE;
        }
        return null;
    }

    private final void setPage(Pages pages) {
        DonateScreenBinding donateScreenBinding = this.binding;
        this.currentPage = pages;
        if (pages != Pages.DIALOG) {
            LinearLayout root = donateScreenBinding.mainPage.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(Pages.MAIN != pages ? 8 : 0);
            RecyclerView root2 = donateScreenBinding.ordinaryPage.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            root2.setVisibility(Pages.ORDINARY != pages ? 8 : 0);
            LinearLayout root3 = donateScreenBinding.purchasePage.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
            root3.setVisibility(Pages.PURCHASE != pages ? 8 : 0);
        }
        FrameLayout root4 = donateScreenBinding.replenishmentDialogPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
        root4.setVisibility(Pages.DIALOG != pages ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DonateScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen$Pages;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "MAIN", "ORDINARY", "PURCHASE", "DIALOG", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Pages {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Pages[] $VALUES;
        public static final Pages NONE = new Pages("NONE", 0);
        public static final Pages MAIN = new Pages("MAIN", 1);
        public static final Pages ORDINARY = new Pages("ORDINARY", 2);
        public static final Pages PURCHASE = new Pages("PURCHASE", 3);
        public static final Pages DIALOG = new Pages("DIALOG", 4);

        private static final /* synthetic */ Pages[] $values() {
            return new Pages[]{NONE, MAIN, ORDINARY, PURCHASE, DIALOG};
        }

        public static EnumEntries<Pages> getEntries() {
            return $ENTRIES;
        }

        private Pages(String str, int i) {
        }

        static {
            Pages[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Pages valueOf(String str) {
            return (Pages) Enum.valueOf(Pages.class, str);
        }

        public static Pages[] values() {
            return (Pages[]) $VALUES.clone();
        }
    }

    /* compiled from: DonateScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/DonateScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new DonateScreen(targetActivity, i);
        }
    }
}
