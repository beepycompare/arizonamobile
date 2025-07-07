package com.arkivanov.decompose.extensions.compose.utils;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputConsumingOverlay.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"InputConsumingOverlay", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InputConsumingOverlayKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputConsumingOverlay$lambda$1(Modifier modifier, int i, Composer composer, int i2) {
        InputConsumingOverlay(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void InputConsumingOverlay(final Modifier modifier, Composer composer, final int i) {
        int i2;
        Modifier then;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-502821345);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-502821345, i2, -1, "com.arkivanov.decompose.extensions.compose.utils.InputConsumingOverlay (InputConsumingOverlay.kt:8)");
            }
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1757309367);
            InputConsumingOverlayKt$InputConsumingOverlay$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new InputConsumingOverlayKt$InputConsumingOverlay$1$1(null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            then = modifier.then(new SuspendPointerInputElement(unit, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) rememberedValue), 6, null));
            BoxKt.Box(then, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.utils.InputConsumingOverlayKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputConsumingOverlay$lambda$1;
                    InputConsumingOverlay$lambda$1 = InputConsumingOverlayKt.InputConsumingOverlay$lambda$1(Modifier.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InputConsumingOverlay$lambda$1;
                }
            });
        }
    }
}
