package com.miami.game.feature.settings.ui.compose;

import com.miami.game.feature.download.dialog.ui.connection.ConnectionData;
import com.miami.game.feature.settings.ui.SettingsComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class SettingsScreenKt$SettingsRoute$15$1 extends FunctionReferenceImpl implements Function1<ConnectionData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsScreenKt$SettingsRoute$15$1(Object obj) {
        super(1, obj, SettingsComponent.class, "onConnectGame", "onConnectGame(Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConnectionData connectionData) {
        invoke2(connectionData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConnectionData p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((SettingsComponent) this.receiver).onConnectGame(p0);
    }
}
