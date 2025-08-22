package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ru.mrlargha.commonui.databinding.DonateOrdinaryPageBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateOnItemCompleteListeners;
import ru.mrlargha.commonui.elements.donate.presentation.DonateSubIds;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.utils.CustomGridLayoutManager;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DonateOrdinaryPage.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001BL\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010#\u001a\u00020\u0010H\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0016J\u0016\u0010(\u001a\u00020\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0*H\u0002J\b\u0010+\u001a\u00020\u0010H\u0002J\u0016\u0010,\u001a\u00020\u00102\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0*H\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0003H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R.\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonateOrdinaryPage;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "backendId", "", "targetActivity", "Landroid/app/Activity;", "onItemCompleteListeners", "Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "binding", "Lru/mrlargha/commonui/databinding/DonateOrdinaryPageBinding;", "openDialog", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "Lkotlin/ParameterName;", "name", "itemModelUi", "", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;Lru/mrlargha/commonui/databinding/DonateOrdinaryPageBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateOrdinaryPageBinding;", "getOpenDialog", "()Lkotlin/jvm/functions/Function1;", "itemAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "renderJob", "Lkotlinx/coroutines/Job;", "allItemList", "", "page", "pageSize", "isLoading", "", "setupRecycler", "onBackendMessage", "subId", "data", "", "setOrdinaryItemList", "itemList", "", "loadPage", "renderListGradually", "list", "onItemClick", "id", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateOrdinaryPage extends DonatePage {
    private final List<DonateItemModelUi> allItemList;
    private final DonateOrdinaryPageBinding binding;
    private boolean isLoading;
    private final DonateAdapter itemAdapter;
    private final Function1<DonateItemModelUi, Unit> openDialog;
    private int page;
    private final int pageSize;
    private Job renderJob;
    private final CoroutineScope scope;

    public final DonateOrdinaryPageBinding getBinding() {
        return this.binding;
    }

    public final Function1<DonateItemModelUi, Unit> getOpenDialog() {
        return this.openDialog;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DonateOrdinaryPage(int i, Activity targetActivity, DonateOnItemCompleteListeners onItemCompleteListeners, DonateOrdinaryPageBinding binding, Function1<? super DonateItemModelUi, Unit> openDialog) {
        super(i, targetActivity, onItemCompleteListeners);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(onItemCompleteListeners, "onItemCompleteListeners");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(openDialog, "openDialog");
        this.binding = binding;
        this.openDialog = openDialog;
        this.itemAdapter = new DonateAdapter(new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit itemAdapter$lambda$1;
                itemAdapter$lambda$1 = DonateOrdinaryPage.itemAdapter$lambda$1(DonateOrdinaryPage.this, ((Integer) obj).intValue());
                return itemAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit itemAdapter$lambda$2;
                itemAdapter$lambda$2 = DonateOrdinaryPage.itemAdapter$lambda$2(DonateOrdinaryPage.this, (DonateItemModelUi) obj);
                return itemAdapter$lambda$2;
            }
        });
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.allItemList = new ArrayList();
        this.pageSize = 20;
        setupRecycler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit itemAdapter$lambda$1(DonateOrdinaryPage donateOrdinaryPage, int i) {
        donateOrdinaryPage.onItemClick(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit itemAdapter$lambda$2(DonateOrdinaryPage donateOrdinaryPage, DonateItemModelUi donateItemModelUi) {
        donateOrdinaryPage.openDialog.invoke(donateItemModelUi);
        return Unit.INSTANCE;
    }

    private final void setupRecycler() {
        this.binding.rvItems.setLayoutManager(new CustomGridLayoutManager(getTargetActivity()));
        this.binding.rvItems.setAdapter(this.itemAdapter);
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage
    public void onBackendMessage(int i, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == DonateSubIds.ITEM_INIT.getSubIds()) {
            setOrdinaryItemList(MapperKt.toListModel(data, DonateItemModelUi.class));
        }
    }

    private final void setOrdinaryItemList(List<DonateItemModelUi> list) {
        Log.d(DonateUtilsKt.DONATE_TAG, "setOrdinaryItemList: itemSize: " + list.size());
        Log.d(DonateUtilsKt.DONATE_TAG, "setOrdinaryItemList: categoryId: " + list.get(0).getCategoryId());
        this.page = 0;
        this.allItemList.clear();
        this.allItemList.addAll(list);
        this.binding.rvItems.scrollToPosition(0);
        this.itemAdapter.submitList(CollectionsKt.emptyList());
        renderListGradually(list);
    }

    private final void loadPage() {
        this.isLoading = true;
        int i = this.page * this.pageSize;
        int size = this.allItemList.size() - i;
        if (size <= 0) {
            return;
        }
        List<DonateItemModelUi> take = CollectionsKt.take(CollectionsKt.drop(this.allItemList, i), Math.min(this.pageSize, size));
        if (this.page == 0) {
            renderListGradually(take);
        } else {
            List<DonateItemModelUi> currentList = this.itemAdapter.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            List mutableList = CollectionsKt.toMutableList((Collection) currentList);
            mutableList.addAll(take);
            this.itemAdapter.submitList(mutableList);
        }
        Log.i(DonateUtilsKt.DONATE_TAG, "setOrdinaryItemList: page: " + this.page + " \n " + take);
        Log.d(DonateUtilsKt.DONATE_TAG, "setOrdinaryItemList: adapterList: " + this.itemAdapter.getCurrentList());
        this.page++;
        this.isLoading = false;
    }

    private final void renderListGradually(List<DonateItemModelUi> list) {
        Job launch$default;
        Job job = this.renderJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new DonateOrdinaryPage$renderListGradually$1(list, this, null), 2, null);
        this.renderJob = launch$default;
    }

    private final void onItemClick(int i) {
        getNotifier().clickedWrapper(getBackendId(), i, 3);
    }
}
