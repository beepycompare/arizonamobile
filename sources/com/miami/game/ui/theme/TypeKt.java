package com.miami.game.ui.theme;

import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import com.miami.game.core.fonts.resources.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Type.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Typography", "Landroidx/compose/material3/Typography;", "getTypography", "()Landroidx/compose/material3/Typography;", "dpToSp", "Landroidx/compose/ui/unit/TextUnit;", "dp", "Landroidx/compose/ui/unit/Dp;", "dpToSp-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)J", "design-system_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TypeKt {
    private static final Typography Typography;

    public static final Typography getTypography() {
        return Typography;
    }

    static {
        FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m6240FontYpTlLL0$default(R.font.dinpro_condensedbolditalic, null, 0, 0, 14, null));
        TextStyle textStyle = new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getW700(), (FontStyle) null, (FontSynthesis) null, FontFamily, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(24), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (DefaultConstructorMarker) null);
        FontFamily FontFamily2 = FontFamilyKt.FontFamily(FontKt.m6240FontYpTlLL0$default(R.font.dinpro_condensedbolditalic, null, 0, 0, 14, null));
        FontWeight w700 = FontWeight.Companion.getW700();
        TextStyle textStyle2 = new TextStyle(androidx.compose.ui.graphics.ColorKt.Color(4293205330L), TextUnitKt.getSp(32), w700, (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, TextUnitKt.getSp(0.2d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(24), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645976, (DefaultConstructorMarker) null);
        FontFamily FontFamily3 = FontFamilyKt.FontFamily(FontKt.m6240FontYpTlLL0$default(R.font.dinpro_condensedbolditalic, null, 0, 0, 14, null));
        FontWeight w7002 = FontWeight.Companion.getW700();
        TextStyle textStyle3 = new TextStyle(Color.Companion.m4115getWhite0d7_KjU(), TextUnitKt.getSp(16), w7002, (FontStyle) null, (FontSynthesis) null, FontFamily3, (String) null, TextUnitKt.getSp(-0.0d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645976, (DefaultConstructorMarker) null);
        FontFamily FontFamily4 = FontFamilyKt.FontFamily(FontKt.m6240FontYpTlLL0$default(R.font.dinpro_condensedbold, null, 0, 0, 14, null));
        FontWeight w7003 = FontWeight.Companion.getW700();
        TextStyle textStyle4 = new TextStyle(Color.Companion.m4115getWhite0d7_KjU(), TextUnitKt.getSp(16), w7003, (FontStyle) null, (FontSynthesis) null, FontFamily4, (String) null, TextUnitKt.getSp(-0.0d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645976, (DefaultConstructorMarker) null);
        FontFamily FontFamily5 = FontFamilyKt.FontFamily(FontKt.m6240FontYpTlLL0$default(R.font.dinpro_condensedmedium, null, 0, 0, 14, null));
        FontWeight normal = FontWeight.Companion.getNormal();
        TextStyle textStyle5 = new TextStyle(Color.Companion.m4115getWhite0d7_KjU(), TextUnitKt.getSp(16), normal, (FontStyle) null, (FontSynthesis) null, FontFamily5, (String) null, TextUnitKt.getSp(-0.0d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645976, (DefaultConstructorMarker) null);
        FontFamily FontFamily6 = FontFamilyKt.FontFamily(FontKt.m6240FontYpTlLL0$default(R.font.dinpro_condensedbolditalic, null, 0, 0, 14, null));
        FontWeight w7004 = FontWeight.Companion.getW700();
        TextStyle textStyle6 = new TextStyle(Color.Companion.m4115getWhite0d7_KjU(), TextUnitKt.getSp(16), w7004, (FontStyle) null, (FontSynthesis) null, FontFamily6, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645976, (DefaultConstructorMarker) null);
        FontFamily FontFamily7 = FontFamilyKt.FontFamily(FontKt.m6240FontYpTlLL0$default(R.font.dinpro_condensedblackitalic, null, 0, 0, 14, null));
        Typography = new Typography(null, null, textStyle5, null, null, new TextStyle(Color.Companion.m4115getWhite0d7_KjU(), TextUnitKt.getSp(16), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily7, (String) null, TextUnitKt.getSp(-0.2d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645980, (DefaultConstructorMarker) null), null, null, null, textStyle, textStyle2, textStyle3, null, textStyle6, textStyle4, 4571, null);
    }

    /* renamed from: dpToSp-8Feqmps  reason: not valid java name */
    public static final long m8401dpToSp8Feqmps(float f, Composer composer, int i) {
        composer.startReplaceGroup(927535330);
        ComposerKt.sourceInformation(composer, "C(dpToSp)P(0:c#ui.unit.Dp)73@2421L7:Type.kt#3dgxrl");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(927535330, i, -1, "com.miami.game.ui.theme.dpToSp (Type.kt:73)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        long j = ((Density) consume).mo391toSp0xMU5do(f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return j;
    }
}
