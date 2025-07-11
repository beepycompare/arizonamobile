package com.miami.game.ui.theme;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Theme.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "LightColorScheme", "MyApplicationTheme", "", "darkTheme", "", "dynamicColor", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "design-system_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ThemeKt {
    private static final ColorScheme DarkColorScheme = ColorSchemeKt.m1735darkColorSchemeCXl9yA$default(ColorKt.getPurple80(), 0, 0, 0, 0, ColorKt.getPurpleGrey80(), 0, 0, 0, ColorKt.getPink80(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -546, 15, null);
    private static final ColorScheme LightColorScheme = ColorSchemeKt.m1739lightColorSchemeCXl9yA$default(androidx.compose.ui.graphics.ColorKt.Color(4293205330L), 0, 0, 0, 0, ColorKt.getPurpleGrey40(), 0, 0, 0, androidx.compose.ui.graphics.ColorKt.Color(4279571733L), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -546, 15, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyApplicationTheme$lambda$0(boolean z, boolean z2, Function2 function2, int i, int i2, Composer composer, int i3) {
        MyApplicationTheme(z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void MyApplicationTheme(boolean z, boolean z2, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        final boolean z3;
        final boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(731267600);
        ComposerKt.sourceInformation(startRestartGroup, "C(MyApplicationTheme)P(1,2)50@1582L114:Theme.kt#3dgxrl");
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 = (startRestartGroup.changedInstance(content) ? 256 : 128) | i;
        } else {
            i3 = i;
        }
        if (startRestartGroup.shouldExecute((i3 & TsExtractor.TS_STREAM_TYPE_AC3) != 128, i3 & 1)) {
            startRestartGroup.startDefaults();
            ComposerKt.sourceInformation(startRestartGroup, "33@1047L21");
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    z5 = DarkThemeKt.isSystemInDarkTheme(startRestartGroup, 0);
                    i3 &= -15;
                } else {
                    z5 = z;
                }
                z6 = (i2 & 2) != 0 ? true : z2;
                z7 = z5;
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                z7 = z;
                z6 = z2;
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(731267600, i3, -1, "com.miami.game.ui.theme.MyApplicationTheme (Theme.kt:37)");
            }
            MaterialThemeKt.MaterialTheme(LightColorScheme, null, TypeKt.getTypography(), content, startRestartGroup, ((i3 << 3) & 7168) | 390, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z3 = z7;
            z4 = z6;
        } else {
            startRestartGroup.skipToGroupEnd();
            z3 = z;
            z4 = z2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.theme.ThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MyApplicationTheme$lambda$0;
                    MyApplicationTheme$lambda$0 = ThemeKt.MyApplicationTheme$lambda$0(z3, z4, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return MyApplicationTheme$lambda$0;
                }
            });
        }
    }
}
