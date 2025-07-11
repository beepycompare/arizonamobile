package com.miami.game.feature.select.server.ui.compose;

import com.miami.game.feature.select.server.ui.SelectServerComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: SelectServerScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class SelectServerScreenKt$SelectServerRoute$6$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectServerScreenKt$SelectServerRoute$6$1(Object obj) {
        super(0, obj, SelectServerComponent.class, "onDesktopList", "onDesktopList()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((SelectServerComponent) this.receiver).onDesktopList();
    }
}
