package com.miami.game.feature.download.dialog.ui.setup;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DescriptionText.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"DescriptionText", "", "updateSize", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DescriptionTextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DescriptionText$lambda$4(String str, int i, Composer composer, int i2) {
        DescriptionText(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DescriptionText(final String updateSize, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        Composer startRestartGroup = composer.startRestartGroup(1047179564);
        ComposerKt.sourceInformation(startRestartGroup, "C(DescriptionText)63@2238L10,58@2068L253:DescriptionText.kt#18sjrx");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(updateSize) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1047179564, i2, -1, "com.miami.game.feature.download.dialog.ui.setup.DescriptionText (DescriptionText.kt:19)");
            }
            startRestartGroup.startReplaceGroup(1317217607);
            ComposerKt.sourceInformation(startRestartGroup, "*25@945L13,26@1003L10,27@1079L10,36@1342L11,37@1390L13,38@1448L10,39@1524L10,49@1794L13,50@1852L10,51@1928L10");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            float f = 16;
            int pushStyle = builder.pushStyle(new SpanStyle(Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(f), startRestartGroup, 6), MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall().getFontWeight(), (FontStyle) null, (FontSynthesis) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall().getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65496, (DefaultConstructorMarker) null));
            try {
                builder.append("Вы собираетесь загрузить файлы игры размером ");
                Unit unit = Unit.INSTANCE;
                builder.pop(pushStyle);
                pushStyle = builder.pushStyle(new SpanStyle(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m1714getPrimary0d7_KjU(), TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(18), startRestartGroup, 6), MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall().getFontWeight(), (FontStyle) null, (FontSynthesis) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall().getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65496, (DefaultConstructorMarker) null));
                try {
                    builder.append(updateSize);
                    Unit unit2 = Unit.INSTANCE;
                    builder.pop(pushStyle);
                    pushStyle = builder.pushStyle(new SpanStyle(Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(f), startRestartGroup, 6), MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall().getFontWeight(), (FontStyle) null, (FontSynthesis) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall().getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65496, (DefaultConstructorMarker) null));
                    try {
                        builder.append(". Вы действительно хотите продолжить?");
                        Unit unit3 = Unit.INSTANCE;
                        builder.pop(pushStyle);
                        AnnotatedString annotatedString = builder.toAnnotatedString();
                        startRestartGroup.endReplaceGroup();
                        BasicTextKt.m1046BasicTextCL7eQgs(annotatedString, SizeKt.fillMaxSize$default(PaddingKt.m740paddingVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null), TextStyle.m6160copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.Companion.m6568getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), null, 0, false, 0, 0, null, null, null, startRestartGroup, 48, 0, 2040);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.setup.DescriptionTextKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DescriptionText$lambda$4;
                    DescriptionText$lambda$4 = DescriptionTextKt.DescriptionText$lambda$4(updateSize, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DescriptionText$lambda$4;
                }
            });
        }
    }
}
