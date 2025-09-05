package ru.mrlargha.commonui.elements.donate.presentation.pages;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonatePurchasePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class DonatePurchasePage$purchaseAdapter$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DonatePurchasePage$purchaseAdapter$1(Object obj) {
        super(1, obj, DonatePurchasePage.class, "onItemClick", "onItemClick(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((DonatePurchasePage) this.receiver).onItemClick(i);
    }
}
