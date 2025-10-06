package ru.mrlargha.feature.arizona.cases.pages;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CasesOpenPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class CasesOpenPage$openAdapter$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CasesOpenPage$openAdapter$2(Object obj) {
        super(1, obj, CasesOpenPage.class, "updateCost", "updateCost(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((CasesOpenPage) this.receiver).updateCost(i);
    }
}
