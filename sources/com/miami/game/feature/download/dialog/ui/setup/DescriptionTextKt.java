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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0004¨\u0006\t"}, d2 = {"DescriptionText", "", "updateSize", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "dialogs"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DescriptionTextKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DescriptionText$lambda$1(String str, int i, Composer composer, int i2) {
        DescriptionText(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DescriptionText(final String updateSize, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        Composer startRestartGroup = composer.startRestartGroup(1047179564);
        ComposerKt.sourceInformation(startRestartGroup, "C(DescriptionText)N(updateSize)63@2237L10,58@2067L253:DescriptionText.kt#18sjrx");
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
            startRestartGroup.startReplaceGroup(1317217222);
            ComposerKt.sourceInformation(startRestartGroup, "*25@945L13,26@1003L10,27@1079L10,36@1341L11,37@1389L13,38@1447L10,39@1523L10,49@1793L13,50@1851L10,51@1927L10");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            int pushStyle = builder.pushStyle(new SpanStyle(Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), TypeKt.m9869dpToSp8Feqmps(Dp.m8160constructorimpl(16.0f), startRestartGroup, 6), MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getFontWeight(), (FontStyle) null, (FontSynthesis) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65496, (DefaultConstructorMarker) null));
            try {
                builder.append("Вы собираетесь загрузить файлы игры объёмом ");
                Unit unit = Unit.INSTANCE;
                builder.pop(pushStyle);
                pushStyle = builder.pushStyle(new SpanStyle(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6).m2322getPrimary0d7_KjU(), TypeKt.m9869dpToSp8Feqmps(Dp.m8160constructorimpl(18.0f), startRestartGroup, 6), MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getFontWeight(), (FontStyle) null, (FontSynthesis) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65496, (DefaultConstructorMarker) null));
                try {
                    builder.append(updateSize);
                    Unit unit2 = Unit.INSTANCE;
                    builder.pop(pushStyle);
                    pushStyle = builder.pushStyle(new SpanStyle(Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), TypeKt.m9869dpToSp8Feqmps(Dp.m8160constructorimpl(16.0f), startRestartGroup, 6), MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getFontWeight(), (FontStyle) null, (FontSynthesis) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65496, (DefaultConstructorMarker) null));
                    try {
                        builder.append(". Вы действительно хотите продолжить?");
                        Unit unit3 = Unit.INSTANCE;
                        builder.pop(pushStyle);
                        AnnotatedString annotatedString = builder.toAnnotatedString();
                        startRestartGroup.endReplaceGroup();
                        BasicTextKt.m1498BasicTextCL7eQgs(annotatedString, SizeKt.fillMaxSize$default(PaddingKt.m1052paddingVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(20.0f), 0.0f, 2, null), 0.0f, 1, null), TextStyle.m7621copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.Companion.m8038getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), null, 0, false, 0, 0, null, null, null, startRestartGroup, 48, 0, 2040);
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
                    return DescriptionTextKt.DescriptionText$lambda$1(updateSize, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
