package com.arizonagames.feature.arizona.bank.navigation;

import com.arizonagames.feature.arizona.bank.BankPage;
import com.arizonagames.feature.arizona.bank.adapters.BankTabsAdapter;
import com.arizonagames.feature.arizona.bank.pages.BankPageController;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: BankNavigator.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fJ\u0014\u0010\u0017\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fJ\u0016\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/navigation/BankNavigator;", "", "tabsAdapter", "Lcom/arizonagames/feature/arizona/bank/adapters/BankTabsAdapter;", "pageControllers", "", "Lcom/arizonagames/feature/arizona/bank/pages/BankPageController;", "<init>", "(Lcom/arizonagames/feature/arizona/bank/adapters/BankTabsAdapter;Ljava/util/List;)V", "controllersByPage", "", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "hasShownPage", "", "visibleTopPages", "", "value", "currentPage", "getCurrentPage", "()Lcom/arizonagames/feature/arizona/bank/BankPage;", "setVisibleTopTabs", "", "pages", "setEnabledTopTabs", "showPage", "page", "allowCardIssue", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankNavigator {
    private final Map<BankPage, BankPageController> controllersByPage;
    private BankPage currentPage;
    private boolean hasShownPage;
    private final BankTabsAdapter tabsAdapter;
    private Set<? extends BankPage> visibleTopPages;

    /* compiled from: BankNavigator.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BankPage.values().length];
            try {
                iArr[BankPage.CARD_ISSUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BankNavigator(BankTabsAdapter tabsAdapter, List<? extends BankPageController> pageControllers) {
        Intrinsics.checkNotNullParameter(tabsAdapter, "tabsAdapter");
        Intrinsics.checkNotNullParameter(pageControllers, "pageControllers");
        this.tabsAdapter = tabsAdapter;
        List<? extends BankPageController> list = pageControllers;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((BankPageController) obj).getPage(), obj);
        }
        this.controllersByPage = linkedHashMap;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : BankPage.getEntries()) {
            if (((BankPage) obj2).getHasTopTab()) {
                arrayList.add(obj2);
            }
        }
        this.visibleTopPages = CollectionsKt.toSet(arrayList);
        this.currentPage = BankPage.MAIN;
    }

    public final BankPage getCurrentPage() {
        return this.currentPage;
    }

    public final void setVisibleTopTabs(Set<? extends BankPage> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.visibleTopPages = pages;
        this.tabsAdapter.setVisiblePages(pages);
    }

    public final void setEnabledTopTabs(Set<? extends BankPage> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.tabsAdapter.setEnabledPages(pages);
    }

    public final BankPage showPage(BankPage page, boolean z) {
        BankPage bankPage;
        Intrinsics.checkNotNullParameter(page, "page");
        if (page == BankPage.CARD_ISSUE && !z) {
            page = BankPage.MAIN;
        } else if (page.getHasTopTab() && !this.visibleTopPages.contains(page)) {
            page = BankPage.MAIN;
        }
        BankPage bankPage2 = this.currentPage;
        boolean z2 = this.hasShownPage && bankPage2 != page;
        int i = page.getBackendValue() >= bankPage2.getBackendValue() ? 1 : -1;
        this.currentPage = page;
        for (Map.Entry<BankPage, BankPageController> entry : this.controllersByPage.entrySet()) {
            BankPage key = entry.getKey();
            BankPageController value = entry.getValue();
            if (key == page) {
                value.setVisible(true, z2, i);
            } else if (value.getRoot().getVisibility() == 0) {
                value.setVisible(false, z2, -i);
            } else {
                BankPageController.setVisible$default(value, false, false, 0, 6, null);
            }
        }
        BankTabsAdapter bankTabsAdapter = this.tabsAdapter;
        if (WhenMappings.$EnumSwitchMapping$0[page.ordinal()] == 1) {
            bankPage = BankPage.MAIN;
        } else {
            bankPage = page.getHasTopTab() ? page : null;
        }
        bankTabsAdapter.setSelectedPage(bankPage);
        this.hasShownPage = true;
        return page;
    }
}
