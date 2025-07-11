package com.miami.game.feature.settings.ui.compose;

import com.miami.game.feature.settings.ui.SettingsComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class SettingsScreenKt$SettingsRoute$9$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsScreenKt$SettingsRoute$9$1(Object obj) {
        super(0, obj, SettingsComponent.class, "onPrivacyPolicy", "onPrivacyPolicy()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((SettingsComponent) this.receiver).onPrivacyPolicy();
    }
}
