package com.miami.game.feature.settings.ui.compose;

import android.content.SharedPreferences;
import androidx.compose.runtime.MutableState;
import com.miami.game.feature.settings.ui.SettingsComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class SettingsScreenKt$SettingsRoute$5$1 extends FunctionReferenceImpl implements Function2<SharedPreferences, MutableState<Boolean>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsScreenKt$SettingsRoute$5$1(Object obj) {
        super(2, obj, SettingsComponent.class, "onFullScreen", "onFullScreen(Landroid/content/SharedPreferences;Landroidx/compose/runtime/MutableState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SharedPreferences sharedPreferences, MutableState<Boolean> mutableState) {
        invoke2(sharedPreferences, mutableState);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SharedPreferences p0, MutableState<Boolean> p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((SettingsComponent) this.receiver).onFullScreen(p0, p1);
    }
}
