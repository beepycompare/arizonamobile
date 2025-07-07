package com.miami.game.feature.home.ui.compose;

import com.miami.game.feature.home.ui.HomeComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: HomeScreen.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
/* synthetic */ class HomeScreenKt$HomeRoute$11$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeScreenKt$HomeRoute$11$1(Object obj) {
        super(0, obj, HomeComponent.class, "onClickNotification", "onClickNotification()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((HomeComponent) this.receiver).onClickNotification();
    }
}
