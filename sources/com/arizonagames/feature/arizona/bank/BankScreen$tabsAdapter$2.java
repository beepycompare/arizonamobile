package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class BankScreen$tabsAdapter$2 extends FunctionReferenceImpl implements Function1<BankPage, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BankScreen$tabsAdapter$2(Object obj) {
        super(1, obj, BankScreen.class, "onPageTabClick", "onPageTabClick(Lcom/arizonagames/feature/arizona/bank/BankPage;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BankPage bankPage) {
        invoke2(bankPage);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(BankPage p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((BankScreen) this.receiver).onPageTabClick(p0);
    }
}
