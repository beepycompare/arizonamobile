package com.miami.game.core.design.system.component.other;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
/* compiled from: CustomDivider.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"CustomDivider", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "design-system"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomDividerKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CustomDivider$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        CustomDivider(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void CustomDivider(Modifier modifier, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        final Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-2147212628);
        ComposerKt.sourceInformation(startRestartGroup, "C(CustomDivider)N(modifier)16@607L386:CustomDivider.kt#8aq8qr");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        if (!startRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
            companion = obj;
        } else {
            companion = i4 != 0 ? Modifier.Companion : obj;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2147212628, i3, -1, "com.miami.game.core.design.system.component.other.CustomDivider (CustomDivider.kt:15)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m1103height3ABfNKs(SizeKt.fillMaxWidth(companion, 0.8f), Dp.m8160constructorimpl(1.0f)), Brush.Companion.m5295horizontalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5338boximpl(Color.Companion.m5383getTransparent0d7_KjU()), Color.m5338boximpl(Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5338boximpl(Color.Companion.m5383getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.design.system.component.other.CustomDividerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CustomDividerKt.CustomDivider$lambda$0(Modifier.this, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }
}
