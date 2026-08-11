package com.miami.game.feature.download.dialog.ui.common;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
/* compiled from: Component.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u0001H\u0007b\u0002\b\u0003b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"AlertLabelDialog", "", "(Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "dialogs"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComponentKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AlertLabelDialog$lambda$0(int i, Composer composer, int i2) {
        AlertLabelDialog(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AlertLabelDialog(Composer composer, final int i) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1152776580);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertLabelDialog)16@536L80,15@521L191,23@744L10,25@830L11,26@870L13,23@717L172:Component.kt#v58dvv");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1152776580, i, -1, "com.miami.game.feature.download.dialog.ui.common.AlertLabelDialog (Component.kt:14)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.dialog_frame_check_files_error, startRestartGroup, 0), (String) null, SizeKt.m1117size3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(60.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
            composer2 = startRestartGroup;
            TextKt.m3157TextNvy7gAk("ПРЕДУПРЕЖДЕНИЕ", null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6).m2322getPrimary0d7_KjU(), null, TypeKt.m9864dpToSp8Feqmps(Dp.m8160constructorimpl(40.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyMedium(), composer2, 6, 0, 131050);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.common.ComponentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentKt.AlertLabelDialog$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
