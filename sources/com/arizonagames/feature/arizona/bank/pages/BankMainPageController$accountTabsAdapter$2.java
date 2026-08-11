package com.arizonagames.feature.arizona.bank.pages;

import com.arizonagames.feature.arizona.bank.ui.BankRecyclerTabIndicator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: BankMainPageController.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class BankMainPageController$accountTabsAdapter$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BankMainPageController$accountTabsAdapter$2(Object obj) {
        super(1, obj, BankRecyclerTabIndicator.class, "select", "select(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((BankRecyclerTabIndicator) this.receiver).select(i);
    }
}
