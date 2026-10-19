package com.miami.game.feature.settings.ui.compose;

import android.content.SharedPreferences;
import androidx.compose.runtime.MutableState;
import com.miami.game.feature.settings.ui.SettingsComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class SettingsScreenKt$SettingsRoute$4$1 extends FunctionReferenceImpl implements Function3<SharedPreferences, MutableState<Integer>, Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsScreenKt$SettingsRoute$4$1(Object obj) {
        super(3, obj, SettingsComponent.class, "onPageSize", "onPageSize(Landroid/content/SharedPreferences;Landroidx/compose/runtime/MutableState;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(SharedPreferences sharedPreferences, MutableState<Integer> mutableState, Integer num) {
        invoke(sharedPreferences, mutableState, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SharedPreferences p0, MutableState<Integer> p1, int i) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((SettingsComponent) this.receiver).onPageSize(p0, p1, i);
    }
}
