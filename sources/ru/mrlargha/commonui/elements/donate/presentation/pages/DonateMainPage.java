package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import androidx.viewpager2.widget.ViewPager2;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import ru.mrlargha.commonui.databinding.DonateMainPageBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateSubIds;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateBottomItemsAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.utils.CustomLinearLayoutManager;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DonateMainPage.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J4\u0010\u001e\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001c0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonateMainPage;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "backendId", "", "targetActivity", "Landroid/app/Activity;", "binding", "Lru/mrlargha/commonui/databinding/DonateMainPageBinding;", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/databinding/DonateMainPageBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateMainPageBinding;", "mainItemsAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;", "scrollThroughViewPagerJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onBackendMessage", "", "subId", "data", "", "scrollThroughViewPager", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "initialize", "itemList", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModel;", "sortItemList", "Lkotlin/Pair;", "list", "getFirstItemLine", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateMainPage extends DonatePage {
    private final DonateMainPageBinding binding;
    private final DonateAdapter mainItemsAdapter;
    private final CoroutineScope scope;
    private final CompletableJob scrollThroughViewPagerJob;

    public final DonateMainPageBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateMainPage(int i, Activity targetActivity, DonateMainPageBinding binding) {
        super(i, targetActivity);
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.mainItemsAdapter = new DonateAdapter();
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.scrollThroughViewPagerJob = Job$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(Job$default));
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage
    public void onBackendMessage(int i, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == DonateSubIds.MAIN_LIST_INIT.getSubIds()) {
            initialize(MapperKt.toListModel(data, DonateItemModel.class));
        }
    }

    private final void scrollThroughViewPager(ViewPager2 viewPager2) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DonateMainPage$scrollThroughViewPager$1(viewPager2, null), 3, null);
    }

    private final void initialize(List<DonateItemModel> list) {
        DonateMainPageBinding donateMainPageBinding = this.binding;
        Pair<List<DonateItemModel>, List<List<DonateItemModel>>> sortItemList = sortItemList(list);
        donateMainPageBinding.rvMainItems.setLayoutManager(new CustomLinearLayoutManager());
        donateMainPageBinding.rvMainItems.setAdapter(this.mainItemsAdapter);
        this.mainItemsAdapter.submitList(sortItemList.getFirst());
        donateMainPageBinding.viewPager.setAdapter(new DonateBottomItemsAdapter(sortItemList.getSecond()));
        DotsIndicator dotsIndicator = donateMainPageBinding.dotsIndicator;
        ViewPager2 viewPager = donateMainPageBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        dotsIndicator.attachTo(viewPager);
        ViewPager2 viewPager2 = donateMainPageBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPager");
        scrollThroughViewPager(viewPager2);
    }

    private final Pair<List<DonateItemModel>, List<List<DonateItemModel>>> sortItemList(List<DonateItemModel> list) {
        List<DonateItemModel> minus = CollectionsKt.minus((Iterable) list, (Iterable) CollectionsKt.toSet(getFirstItemLine(list)));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (DonateItemModel donateItemModel : minus) {
            if (donateItemModel.getType() != 1) {
                arrayList2.add(donateItemModel);
            }
            if (arrayList2.size() == 4) {
                arrayList.add(CollectionsKt.toList(arrayList2));
                arrayList2.clear();
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(CollectionsKt.toList(arrayList2));
        }
        return TuplesKt.to(getFirstItemLine(list), arrayList);
    }

    private final List<DonateItemModel> getFirstItemLine(List<DonateItemModel> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (DonateItemModel donateItemModel : list) {
            i += donateItemModel.getType() == 1 ? 2 : 1;
            if (i > 4) {
                break;
            }
            arrayList.add(donateItemModel);
        }
        return arrayList;
    }
}
