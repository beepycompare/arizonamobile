package com.miami.game.core.app.root.nav.main.compose;

import com.miami.game.core.app.root.nav.main.MainComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainRoute.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class MainRouteKt$Children$1$2$8$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MainRouteKt$Children$1$2$8$1(Object obj) {
        super(0, obj, MainComponent.class, "retry", "retry()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((MainComponent) this.receiver).retry();
    }
}
