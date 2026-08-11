package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class BankScreen$cardIssuePageController$2 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BankScreen$cardIssuePageController$2(Object obj) {
        super(0, obj, BankScreen.class, "openSignatureModal", "openSignatureModal()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((BankScreen) this.receiver).openSignatureModal();
    }
}
