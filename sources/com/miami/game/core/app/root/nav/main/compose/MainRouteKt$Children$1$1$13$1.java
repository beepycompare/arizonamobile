package com.miami.game.core.app.root.nav.main.compose;

import com.miami.game.core.app.root.nav.main.MainComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainRoute.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
/* synthetic */ class MainRouteKt$Children$1$1$13$1 extends FunctionReferenceImpl implements Function1<Function0<? extends Unit>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MainRouteKt$Children$1$1$13$1(Object obj) {
        super(1, obj, MainComponent.class, "navigateToRepairGameDialog", "navigateToRepairGameDialog(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
        invoke2((Function0<Unit>) function0);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Function0<Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((MainComponent) this.receiver).navigateToRepairGameDialog(p0);
    }
}
