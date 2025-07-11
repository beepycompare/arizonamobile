package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import android.util.Log;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0019\u001a\u00020\fH\u0002J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0016\u0010\"\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0003H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonateOrdinaryPage;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "backendId", "", "targetActivity", "Landroid/app/Activity;", "onItemCompleteListeners", "Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "binding", "Lru/mrlargha/commonui/databinding/DonateOrdinaryPageBinding;", "openDialog", "Lkotlin/Function0;", "", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;Lru/mrlargha/commonui/databinding/DonateOrdinaryPageBinding;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateOrdinaryPageBinding;", "getOpenDialog", "()Lkotlin/jvm/functions/Function0;", "itemAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "renderJob", "Lkotlinx/coroutines/Job;", "setupRecycler", "onBackendMessage", "subId", "data", "", "setOrdinaryItemList", "itemList", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "renderListGradually", "list", "onItemClick", "id", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateOrdinaryPage extends DonatePage {
    private final DonateOrdinaryPageBinding binding;
    private final DonateAdapter itemAdapter;
    private final Function0<Unit> openDialog;
    private Job renderJob;
    private final CoroutineScope scope;

    public final DonateOrdinaryPageBinding getBinding() {
        return this.binding;
    }

    public final Function0<Unit> getOpenDialog() {
        return this.openDialog;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateOrdinaryPage(int i, Activity targetActivity, DonateOnItemCompleteListeners onItemCompleteListeners, DonateOrdinaryPageBinding binding, Function0<Unit> openDialog) {
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
        }, new Function0() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateOrdinaryPage$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit itemAdapter$lambda$2;
                itemAdapter$lambda$2 = DonateOrdinaryPage.itemAdapter$lambda$2(DonateOrdinaryPage.this);
                return itemAdapter$lambda$2;
            }
        });
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        setupRecycler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit itemAdapter$lambda$1(DonateOrdinaryPage donateOrdinaryPage, int i) {
        donateOrdinaryPage.onItemClick(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit itemAdapter$lambda$2(DonateOrdinaryPage donateOrdinaryPage) {
        donateOrdinaryPage.openDialog.invoke();
        return Unit.INSTANCE;
    }

    private final void setupRecycler() {
        this.binding.rvItems.setLayoutManager(new CustomGridLayoutManager());
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
        Log.d(DonateUtilsKt.DONATE_TAG, "openOrdinaryPage: ");
        this.binding.rvItems.scrollToPosition(0);
        this.itemAdapter.submitList(CollectionsKt.emptyList());
        renderListGradually(list);
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
