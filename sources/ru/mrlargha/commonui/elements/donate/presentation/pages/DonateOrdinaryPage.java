package ru.mrlargha.commonui.elements.donate.presentation.pages;

import android.app.Activity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.DonateOrdinaryPageBinding;
import ru.mrlargha.commonui.elements.donate.presentation.DonateSubIds;
import ru.mrlargha.commonui.elements.donate.presentation.adapters.DonateAdapter;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.utils.CustomLinearLayoutManager;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: DonateOrdinaryPage.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/pages/DonateOrdinaryPage;", "Lru/mrlargha/commonui/elements/donate/presentation/pages/DonatePage;", "backendId", "", "targetActivity", "Landroid/app/Activity;", "binding", "Lru/mrlargha/commonui/databinding/DonateOrdinaryPageBinding;", "<init>", "(ILandroid/app/Activity;Lru/mrlargha/commonui/databinding/DonateOrdinaryPageBinding;)V", "getBinding", "()Lru/mrlargha/commonui/databinding/DonateOrdinaryPageBinding;", "itemAdapter", "Lru/mrlargha/commonui/elements/donate/presentation/adapters/DonateAdapter;", "onBackendMessage", "", "subId", "data", "", "setOrdinaryItemList", "itemList", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModel;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateOrdinaryPage extends DonatePage {
    private final DonateOrdinaryPageBinding binding;
    private final DonateAdapter itemAdapter;

    public final DonateOrdinaryPageBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateOrdinaryPage(int i, Activity targetActivity, DonateOrdinaryPageBinding binding) {
        super(i, targetActivity);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.itemAdapter = new DonateAdapter();
    }

    @Override // ru.mrlargha.commonui.elements.donate.presentation.pages.DonatePage
    public void onBackendMessage(int i, String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == DonateSubIds.ORDINARY_LIST_INIT.getSubIds()) {
            setOrdinaryItemList(MapperKt.toListModel(data, DonateItemModel.class));
        }
    }

    private final void setOrdinaryItemList(List<DonateItemModel> list) {
        DonateOrdinaryPageBinding donateOrdinaryPageBinding = this.binding;
        donateOrdinaryPageBinding.rvItems.setLayoutManager(new CustomLinearLayoutManager());
        donateOrdinaryPageBinding.rvItems.setAdapter(this.itemAdapter);
        this.itemAdapter.submitList(DonateUtilsKt.sortForLines(list));
    }
}
