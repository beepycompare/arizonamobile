package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import io.appmetrica.analytics.impl.O2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextPaintExtensions.android.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001aP\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012&\u0010\u0004\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a3\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0016\u0010\u0018\u001a\u00020\u0019*\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000\u001a\f\u0010\u001c\u001a\u00020\u000e*\u00020\u0001H\u0000\u001a\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¨\u0006 "}, d2 = {"applySpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "requiresLetterSpacing", "", "generateFallbackSpanStyle", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", O2.g, "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "setTextMotion", "", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "hasFontAttributes", "correctBlurRadius", "", "blurRadius", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextPaintExtensions_androidKt {
    public static final float correctBlurRadius(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    public static /* synthetic */ SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4 function4, Density density, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return applySpanStyle(androidTextPaint, spanStyle, function4, density, z);
    }

    public static final SpanStyle applySpanStyle(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4, Density density, boolean z) {
        long m7457getTypeUIouoOA = TextUnit.m7457getTypeUIouoOA(spanStyle.m6668getFontSizeXSAIIZE());
        if (TextUnitType.m7486equalsimpl0(m7457getTypeUIouoOA, TextUnitType.Companion.m7491getSpUIouoOA())) {
            androidTextPaint.setTextSize(density.mo428toPxR2X_6o(spanStyle.m6668getFontSizeXSAIIZE()));
        } else if (TextUnitType.m7486equalsimpl0(m7457getTypeUIouoOA, TextUnitType.Companion.m7490getEmUIouoOA())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * TextUnit.m7458getValueimpl(spanStyle.m6668getFontSizeXSAIIZE()));
        }
        if (hasFontAttributes(spanStyle)) {
            FontFamily fontFamily = spanStyle.getFontFamily();
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle m6669getFontStyle4Lr2A7w = spanStyle.m6669getFontStyle4Lr2A7w();
            FontStyle m6836boximpl = FontStyle.m6836boximpl(m6669getFontStyle4Lr2A7w != null ? m6669getFontStyle4Lr2A7w.m6842unboximpl() : FontStyle.Companion.m6846getNormal_LCdwA());
            FontSynthesis m6670getFontSynthesisZQGJjVo = spanStyle.m6670getFontSynthesisZQGJjVo();
            androidTextPaint.setTypeface(function4.invoke(fontFamily, fontWeight, m6836boximpl, FontSynthesis.m6847boximpl(m6670getFontSynthesisZQGJjVo != null ? m6670getFontSynthesisZQGJjVo.m6855unboximpl() : FontSynthesis.Companion.m6856getAllGVVA2EU())));
        }
        if (spanStyle.getLocaleList() != null && !Intrinsics.areEqual(spanStyle.getLocaleList(), LocaleList.Companion.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales(androidTextPaint, spanStyle.getLocaleList());
        }
        if (spanStyle.getFontFeatureSettings() != null && !Intrinsics.areEqual(spanStyle.getFontFeatureSettings(), "")) {
            androidTextPaint.setFontFeatureSettings(spanStyle.getFontFeatureSettings());
        }
        if (spanStyle.getTextGeometricTransform() != null && !Intrinsics.areEqual(spanStyle.getTextGeometricTransform(), TextGeometricTransform.Companion.getNone$ui_text())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * spanStyle.getTextGeometricTransform().getScaleX());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + spanStyle.getTextGeometricTransform().getSkewX());
        }
        androidTextPaint.m6998setColor8_81llA(spanStyle.m6667getColor0d7_KjU());
        androidTextPaint.m6996setBrush12SF9DM(spanStyle.getBrush(), Size.Companion.m4382getUnspecifiedNHjbRc(), spanStyle.getAlpha());
        androidTextPaint.setShadow(spanStyle.getShadow());
        androidTextPaint.setTextDecoration(spanStyle.getTextDecoration());
        androidTextPaint.setDrawStyle(spanStyle.getDrawStyle());
        if (TextUnitType.m7486equalsimpl0(TextUnit.m7457getTypeUIouoOA(spanStyle.m6671getLetterSpacingXSAIIZE()), TextUnitType.Companion.m7491getSpUIouoOA()) && TextUnit.m7458getValueimpl(spanStyle.m6671getLetterSpacingXSAIIZE()) != 0.0f) {
            float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
            float mo428toPxR2X_6o = density.mo428toPxR2X_6o(spanStyle.m6671getLetterSpacingXSAIIZE());
            if (textSize != 0.0f) {
                androidTextPaint.setLetterSpacing(mo428toPxR2X_6o / textSize);
            }
        } else if (TextUnitType.m7486equalsimpl0(TextUnit.m7457getTypeUIouoOA(spanStyle.m6671getLetterSpacingXSAIIZE()), TextUnitType.Companion.m7490getEmUIouoOA())) {
            androidTextPaint.setLetterSpacing(TextUnit.m7458getValueimpl(spanStyle.m6671getLetterSpacingXSAIIZE()));
        }
        return m7013generateFallbackSpanStyle62GTOB8(spanStyle.m6671getLetterSpacingXSAIIZE(), z, spanStyle.m6665getBackground0d7_KjU(), spanStyle.m6666getBaselineShift5SSeXJ0());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
        if (androidx.compose.ui.text.style.BaselineShift.m7023equalsimpl0(r36.m7026unboximpl(), androidx.compose.ui.text.style.BaselineShift.Companion.m7030getNoney9eOQZs()) == false) goto L16;
     */
    /* renamed from: generateFallbackSpanStyle-62GTOB8  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final SpanStyle m7013generateFallbackSpanStyle62GTOB8(long j, boolean z, long j2, BaselineShift baselineShift) {
        long j3 = j2;
        boolean z2 = true;
        boolean z3 = z && TextUnitType.m7486equalsimpl0(TextUnit.m7457getTypeUIouoOA(j), TextUnitType.Companion.m7491getSpUIouoOA()) && TextUnit.m7458getValueimpl(j) != 0.0f;
        boolean z4 = (Color.m4550equalsimpl0(j3, Color.Companion.m4585getUnspecified0d7_KjU()) || Color.m4550equalsimpl0(j3, Color.Companion.m4584getTransparent0d7_KjU())) ? false : true;
        if (baselineShift != null) {
        }
        z2 = false;
        if (z3 || z4 || z2) {
            long m7469getUnspecifiedXSAIIZE = z3 ? j : TextUnit.Companion.m7469getUnspecifiedXSAIIZE();
            if (!z4) {
                j3 = Color.Companion.m4585getUnspecified0d7_KjU();
            }
            return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, m7469getUnspecifiedXSAIIZE, z2 ? baselineShift : null, (TextGeometricTransform) null, (LocaleList) null, j3, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63103, (DefaultConstructorMarker) null);
        }
        return null;
    }

    public static final void setTextMotion(AndroidTextPaint androidTextPaint, TextMotion textMotion) {
        int flags;
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        if (textMotion.getSubpixelTextPositioning$ui_text()) {
            flags = androidTextPaint.getFlags() | 128;
        } else {
            flags = androidTextPaint.getFlags() & (-129);
        }
        androidTextPaint.setFlags(flags);
        int m7176getLinearity4e0Vf04$ui_text = textMotion.m7176getLinearity4e0Vf04$ui_text();
        if (TextMotion.Linearity.m7180equalsimpl0(m7176getLinearity4e0Vf04$ui_text, TextMotion.Linearity.Companion.m7185getLinear4e0Vf04())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.m7180equalsimpl0(m7176getLinearity4e0Vf04$ui_text, TextMotion.Linearity.Companion.m7184getFontHinting4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (TextMotion.Linearity.m7180equalsimpl0(m7176getLinearity4e0Vf04$ui_text, TextMotion.Linearity.Companion.m7186getNone4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        } else {
            androidTextPaint.getFlags();
        }
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        return (spanStyle.getFontFamily() == null && spanStyle.m6669getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) ? false : true;
    }
}
