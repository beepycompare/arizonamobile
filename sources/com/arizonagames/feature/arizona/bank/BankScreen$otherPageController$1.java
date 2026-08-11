package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class BankScreen$otherPageController$1 extends FunctionReferenceImpl implements Function2<Integer, BankSendSubId, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BankScreen$otherPageController$1(Object obj) {
        super(2, obj, BankScreen.class, "dispatchAction", "dispatchAction(ILcom/arizonagames/feature/arizona/bank/BankSendSubId;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, BankSendSubId bankSendSubId) {
        invoke(num.intValue(), bankSendSubId);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, BankSendSubId p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((BankScreen) this.receiver).dispatchAction(i, p1);
    }
}
