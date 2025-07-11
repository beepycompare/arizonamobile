package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import androidx.viewpager2.widget.ViewPager2;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import ru.mrlargha.commonui.databinding.DonateMainPageBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateOnItemCompleteListeners;
import ru.mrlargha.commonui.elements.donate.presentation.DonateSubIds;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBottomItemsAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemType;
import ru.mrlargha.commonui.elements.donate.utils.CustomGridLayoutManager;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DonateMainPage.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#H\u0002J4\u0010$\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001f0%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0010\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0003H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonateMainPage;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "backendId", "", "targetActivity", "Landroid/app/Activity;", "onItemCompleteListeners", "Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "binding", "Lru/mrlargha/commonui/databinding/DonateMainPageBinding;", "openDialog", "Lkotlin/Function0;", "", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;Lru/mrlargha/commonui/databinding/DonateMainPageBinding;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateMainPageBinding;", "getOpenDialog", "()Lkotlin/jvm/functions/Function0;", "mainItemsAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;", "scrollThroughViewPagerJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onBackendMessage", "subId", "data", "", "initialize", "itemList", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "scrollThroughViewPager", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "sortItemList", "Lkotlin/Pair;", "list", "getFirstItemLine", "onClick", "id", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateMainPage extends DonatePage {
    private final DonateMainPageBinding binding;
    private final DonateAdapter mainItemsAdapter;
    private final Function0<Unit> openDialog;
    private final CoroutineScope scope;
    private final CompletableJob scrollThroughViewPagerJob;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$4$lambda$2() {
    }

    public final DonateMainPageBinding getBinding() {
        return this.binding;
    }

    public final Function0<Unit> getOpenDialog() {
        return this.openDialog;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateMainPage(int i, Activity targetActivity, DonateOnItemCompleteListeners onItemCompleteListeners, DonateMainPageBinding binding, Function0<Unit> openDialog) {
        super(i, targetActivity, onItemCompleteListeners);
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(onItemCompleteListeners, "onItemCompleteListeners");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(openDialog, "openDialog");
        this.binding = binding;
        this.openDialog = openDialog;
        this.mainItemsAdapter = new DonateAdapter(new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateMainPage$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, new DonateMainPage$mainItemsAdapter$2(this), new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateMainPage$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit mainItemsAdapter$lambda$1;
                mainItemsAdapter$lambda$1 = DonateMainPage.mainItemsAdapter$lambda$1(DonateMainPage.this);
                return mainItemsAdapter$lambda$1;
            }
        });
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.scrollThroughViewPagerJob = Job$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(Job$default));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mainItemsAdapter$lambda$1(DonateMainPage donateMainPage) {
        donateMainPage.openDialog.invoke();
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage
    public void onBackendMessage(int i, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == DonateSubIds.ITEM_INIT.getSubIds()) {
            getOnItemCompleteListeners().itemReadyToShow();
            initialize(MapperKt.toListModel(data, DonateItemModelUi.class));
        }
    }

    private final void initialize(List<DonateItemModelUi> list) {
        DonateMainPageBinding donateMainPageBinding = this.binding;
        Pair<List<DonateItemModelUi>, List<List<DonateItemModelUi>>> sortItemList = sortItemList(list);
        donateMainPageBinding.rvMainItems.setLayoutManager(new CustomGridLayoutManager());
        donateMainPageBinding.rvMainItems.setAdapter(this.mainItemsAdapter);
        this.mainItemsAdapter.submitList(sortItemList.getFirst(), new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateMainPage$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DonateMainPage.initialize$lambda$4$lambda$2();
            }
        });
        donateMainPageBinding.viewPager.setAdapter(new DonateBottomItemsAdapter(sortItemList.getSecond(), new Function1() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateMainPage$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initialize$lambda$4$lambda$3;
                initialize$lambda$4$lambda$3 = DonateMainPage.initialize$lambda$4$lambda$3(DonateMainPage.this, ((Integer) obj).intValue());
                return initialize$lambda$4$lambda$3;
            }
        }));
        DotsIndicator dotsIndicator = donateMainPageBinding.dotsIndicator;
        ViewPager2 viewPager = donateMainPageBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        dotsIndicator.attachTo(viewPager);
        ViewPager2 viewPager2 = donateMainPageBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPager");
        scrollThroughViewPager(viewPager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialize$lambda$4$lambda$3(DonateMainPage donateMainPage, int i) {
        donateMainPage.onClick(i);
        return Unit.INSTANCE;
    }

    private final void scrollThroughViewPager(ViewPager2 viewPager2) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateMainPage$scrollThroughViewPager$1(viewPager2, null), 3, null);
    }

    private final Pair<List<DonateItemModelUi>, List<List<DonateItemModelUi>>> sortItemList(List<DonateItemModelUi> list) {
        List<DonateItemModelUi> firstItemLine = getFirstItemLine(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.minus((Iterable) list, (Iterable) CollectionsKt.toSet(firstItemLine))) {
            if (((DonateItemModelUi) obj).getType() != 1) {
                arrayList.add(obj);
            }
        }
        return TuplesKt.to(firstItemLine, CollectionsKt.chunked(arrayList, 4));
    }

    private final List<DonateItemModelUi> getFirstItemLine(List<DonateItemModelUi> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (DonateItemModelUi donateItemModelUi : list) {
            i += donateItemModelUi.getItemType() == DonateItemType.BIG ? 2 : 1;
            if (i > 4) {
                break;
            }
            arrayList.add(donateItemModelUi);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClick(int i) {
        getNotifier().clickedWrapper(getBackendId(), i, 3);
    }
}
