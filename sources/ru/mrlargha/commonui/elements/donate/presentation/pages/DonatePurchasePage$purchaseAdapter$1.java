package ru.mrlargha.commonui.elements.donate.presentation.pages;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUi;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonatePurchasePage.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class DonatePurchasePage$purchaseAdapter$1 extends FunctionReferenceImpl implements Function1<DonateItemModelUi, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DonatePurchasePage$purchaseAdapter$1(Object obj) {
        super(1, obj, DonatePurchasePage.class, "onItemClick", "onItemClick(Lru/mrlargha/commonui/elements/donate/presentation/models/DonateItemModelUi;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DonateItemModelUi donateItemModelUi) {
        invoke2(donateItemModelUi);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DonateItemModelUi p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DonatePurchasePage) this.receiver).onItemClick(p0);
    }
}
