package com.miami.game.feature.select.server.ui.compose;

import com.miami.game.core.server.model.ServerModel;
import com.miami.game.feature.select.server.ui.SelectServerComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectServerScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class SelectServerScreenKt$SelectServerRoute$2$1 extends FunctionReferenceImpl implements Function1<ServerModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectServerScreenKt$SelectServerRoute$2$1(Object obj) {
        super(1, obj, SelectServerComponent.class, "onSelect", "onSelect(Lcom/miami/game/core/server/model/ServerModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ServerModel serverModel) {
        invoke2(serverModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ServerModel p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((SelectServerComponent) this.receiver).onSelect(p0);
    }
}
