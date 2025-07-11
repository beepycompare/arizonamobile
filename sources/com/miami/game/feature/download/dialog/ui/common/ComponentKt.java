package com.miami.game.feature.download.dialog.ui.common;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: Component.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"AlertLabelDialog", "", "(Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
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
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.dialog_frame_check_files_error, startRestartGroup, 0), (String) null, SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(60)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 432, (int) MenuKt.InTransitionDuration);
            composer2 = startRestartGroup;
            TextKt.m2497Text4IGK_g("ПРЕДУПРЕЖДЕНИЕ", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1714getPrimary0d7_KjU(), TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(40), startRestartGroup, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodyMedium(), composer2, 6, 0, 65522);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.common.ComponentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AlertLabelDialog$lambda$0;
                    AlertLabelDialog$lambda$0 = ComponentKt.AlertLabelDialog$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                    return AlertLabelDialog$lambda$0;
                }
            });
        }
    }
}
