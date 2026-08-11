package com.arizonagames.feature.arizona.bank.pages;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankOtherPageController.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class BankOtherPageController$bindBusinesses$1$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BankOtherPageController$bindBusinesses$1$1(Object obj) {
        super(1, obj, BankOtherPageController.class, "selectBusiness", "selectBusiness(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((BankOtherPageController) this.receiver).selectBusiness(i);
    }
}
