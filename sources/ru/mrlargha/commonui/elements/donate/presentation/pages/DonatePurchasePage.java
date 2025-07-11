package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.DonatePurchasePageBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateOnItemCompleteListeners;
import ru.mrlargha.commonui.elements.donate.presentation.DonateSubIds;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonatePurchaseAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBoostModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateRateModel;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DonatePurchasePage.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001BJ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0!H\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0003H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R,\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePurchasePage;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "backendId", "", "targetActivity", "Landroid/app/Activity;", "onItemCompleteListeners", "Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;", "binding", "Lru/mrlargha/commonui/databinding/DonatePurchasePageBinding;", "openDialog", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateBoostModelUi;", "Lkotlin/ParameterName;", "name", CommonUrlParts.MODEL, "", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/elements/donate/presentation/DonateOnItemCompleteListeners;Lru/mrlargha/commonui/databinding/DonatePurchasePageBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonatePurchasePageBinding;", "getOpenDialog", "()Lkotlin/jvm/functions/Function1;", "purchaseAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonatePurchaseAdapter;", "canPressItem", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;", "onBackendMessage", "subId", "data", "", "setPurchaseList", "list", "", "onItemClick", "id", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonatePurchasePage extends DonatePage {
    private final DonatePurchasePageBinding binding;
    private DonateItemModelUi canPressItem;
    private final Function1<DonateBoostModelUi, Unit> openDialog;
    private final DonatePurchaseAdapter purchaseAdapter;

    public final DonatePurchasePageBinding getBinding() {
        return this.binding;
    }

    public final Function1<DonateBoostModelUi, Unit> getOpenDialog() {
        return this.openDialog;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DonatePurchasePage(int i, Activity targetActivity, DonateOnItemCompleteListeners onItemCompleteListeners, DonatePurchasePageBinding binding, Function1<? super DonateBoostModelUi, Unit> openDialog) {
        super(i, targetActivity, onItemCompleteListeners);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(onItemCompleteListeners, "onItemCompleteListeners");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(openDialog, "openDialog");
        this.binding = binding;
        this.openDialog = openDialog;
        DonatePurchaseAdapter donatePurchaseAdapter = new DonatePurchaseAdapter(new DonatePurchasePage$purchaseAdapter$1(this));
        this.purchaseAdapter = donatePurchaseAdapter;
        binding.rvPurchaseItems.setAdapter(donatePurchaseAdapter);
        binding.rvPurchaseItems.setHorizontalScrollBarEnabled(true);
        binding.rvPurchaseItems.setScrollbarFadingEnabled(false);
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage
    public void onBackendMessage(int i, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == DonateSubIds.ITEM_INIT.getSubIds()) {
            setPurchaseList(MapperKt.toListModel(data, DonateItemModelUi.class));
        }
    }

    private final void setPurchaseList(List<DonateItemModelUi> list) {
        DonateItemModelUi donateItemModelUi = (DonateItemModelUi) CollectionsKt.firstOrNull((List<? extends Object>) list);
        if (donateItemModelUi != null) {
            this.canPressItem = donateItemModelUi;
        }
        this.purchaseAdapter.submitList(list, new Runnable() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePurchasePage$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DonatePurchasePage.setPurchaseList$lambda$2(DonatePurchasePage.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPurchaseList$lambda$2(DonatePurchasePage donatePurchasePage) {
        donatePurchasePage.getOnItemCompleteListeners().itemReadyToShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemClick(int i) {
        DonateItemModelUi donateItemModelUi = this.canPressItem;
        if (donateItemModelUi != null) {
            if (donateItemModelUi.getId() == i) {
                this.openDialog.invoke(new DonateBoostModelUi(new DonateRateModel(1, donateItemModelUi.getTotalEarnings() < 1 ? 1 : donateItemModelUi.getTotalEarnings()), donateItemModelUi.getUnixTime(), CollectionsKt.emptyList(), false, 0, 0));
            } else {
                getNotifier().clickedWrapper(getBackendId(), i, 3);
            }
        }
    }
}
