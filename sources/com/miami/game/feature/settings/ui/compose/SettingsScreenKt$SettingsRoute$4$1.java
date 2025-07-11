package com.miami.game.feature.settings.ui.compose;

import com.miami.game.feature.settings.ui.SettingsComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class SettingsScreenKt$SettingsRoute$4$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsScreenKt$SettingsRoute$4$1(Object obj) {
        super(1, obj, SettingsComponent.class, "selectPageSize", "selectPageSize(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((SettingsComponent) this.receiver).selectPageSize(i);
    }
}
