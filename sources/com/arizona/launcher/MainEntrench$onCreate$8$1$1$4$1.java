package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainEntrench.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class MainEntrench$onCreate$8$1$1$4$1 extends FunctionReferenceImpl implements Function1<Function1<? super Boolean, ? extends Unit>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MainEntrench$onCreate$8$1$1$4$1(Object obj) {
        super(1, obj, MainEntrench.class, "deleteViceCityContent", "deleteViceCityContent(Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super Boolean, ? extends Unit> function1) {
        invoke2((Function1<? super Boolean, Unit>) function1);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Function1<? super Boolean, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((MainEntrench) this.receiver).deleteViceCityContent(p0);
    }
}
