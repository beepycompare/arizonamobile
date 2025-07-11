package com.miami.game.core.app.root.nav.main.compose;

import com.miami.game.core.app.root.nav.main.MainComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainRoute.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class MainRouteKt$Children$1$1$4$1 extends FunctionReferenceImpl implements Function2<Function0<? extends Unit>, String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MainRouteKt$Children$1$1$4$1(Object obj) {
        super(2, obj, MainComponent.class, "navigateToErrorDialog", "navigateToErrorDialog(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, String str) {
        invoke2((Function0<Unit>) function0, str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Function0<Unit> p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((MainComponent) this.receiver).navigateToErrorDialog(p0, p1);
    }
}
