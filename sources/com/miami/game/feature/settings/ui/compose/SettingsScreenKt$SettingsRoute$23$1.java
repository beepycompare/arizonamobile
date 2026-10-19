package com.miami.game.feature.settings.ui.compose;

import com.miami.game.feature.settings.ui.SettingsComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class SettingsScreenKt$SettingsRoute$23$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsScreenKt$SettingsRoute$23$1(Object obj) {
        super(1, obj, SettingsComponent.class, "onUpdateGameTestScreenshotDeviceDir", "onUpdateGameTestScreenshotDeviceDir(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((SettingsComponent) this.receiver).onUpdateGameTestScreenshotDeviceDir(p0);
    }
}
