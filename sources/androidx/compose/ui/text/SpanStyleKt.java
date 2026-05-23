package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.impl.M2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SpanStyle.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\n\u001a\u0002H\u00112\u0006\u0010\u000b\u001a\u0002H\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0000¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r\u001a&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\rH\u0000\u001a\f\u0010\u001c\u001a\u00020\u0019*\u00020\u0019H\u0002\u001a&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0012\u001a\u00020\rH\u0002\u001a\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0000\u001a½\u0001\u0010!\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u00012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010\u00192\b\u0010<\u001a\u0004\u0018\u00010\u001e2\b\u0010=\u001a\u0004\u0018\u00010>H\u0000¢\u0006\u0004\b?\u0010@\u001a\u0018\u0010A\u001a\u0004\u0018\u00010\u001e*\u00020\u00152\b\u0010B\u001a\u0004\u0018\u00010\u001eH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "DefaultLetterSpacing", "DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "DefaultColor", "DefaultColorForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "lerpTextUnitInheritable", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "t", "", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "lerpDiscrete", ExifInterface.GPS_DIRECTION_TRUE, "fraction", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerp", "Landroidx/compose/ui/text/SpanStyle;", TtmlNode.START, "stop", "nullSafeLerp", "Landroidx/compose/ui/graphics/Shadow;", "lhs", "rhs", "dropAlpha", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", TtmlNode.ATTR_TTS_FONT_SIZE, TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", TtmlNode.ATTR_TTS_FONT_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", TtmlNode.ATTR_TTS_FONT_FAMILY, "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", M2.g, TtmlNode.ATTR_TTS_TEXT_DECORATION, "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SpanStyleKt {
    private static final long DefaultColor;
    private static final TextForegroundStyle DefaultColorForegroundStyle;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);
    private static final long DefaultBackgroundColor = Color.Companion.m5383getTransparent0d7_KjU();

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    static {
        long m5374getBlack0d7_KjU = Color.Companion.m5374getBlack0d7_KjU();
        DefaultColor = m5374getBlack0d7_KjU;
        DefaultColorForegroundStyle = TextForegroundStyle.Companion.m8065from8_81llA(m5374getBlack0d7_KjU);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f) {
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle$ui_text(), spanStyle2.getTextForegroundStyle$ui_text(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long m7555lerpTextUnitInheritableC3pnCVY = m7555lerpTextUnitInheritableC3pnCVY(spanStyle.m7550getFontSizeXSAIIZE(), spanStyle2.m7550getFontSizeXSAIIZE(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.m7551getFontStyle4Lr2A7w(), spanStyle2.m7551getFontStyle4Lr2A7w(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.m7552getFontSynthesisZQGJjVo(), spanStyle2.m7552getFontSynthesisZQGJjVo(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long m7555lerpTextUnitInheritableC3pnCVY2 = m7555lerpTextUnitInheritableC3pnCVY(spanStyle.m7553getLetterSpacingXSAIIZE(), spanStyle2.m7553getLetterSpacingXSAIIZE(), f);
        BaselineShift m7548getBaselineShift5SSeXJ0 = spanStyle.m7548getBaselineShift5SSeXJ0();
        float m7906unboximpl = m7548getBaselineShift5SSeXJ0 != null ? m7548getBaselineShift5SSeXJ0.m7906unboximpl() : BaselineShift.m7901constructorimpl(0.0f);
        BaselineShift m7548getBaselineShift5SSeXJ02 = spanStyle2.m7548getBaselineShift5SSeXJ0();
        float m7916lerpjWV1Mfo = BaselineShiftKt.m7916lerpjWV1Mfo(m7906unboximpl, m7548getBaselineShift5SSeXJ02 != null ? m7548getBaselineShift5SSeXJ02.m7906unboximpl() : BaselineShift.m7901constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text();
        }
        return new SpanStyle(lerp, m7555lerpTextUnitInheritableC3pnCVY, lerp2, fontStyle, fontSynthesis, fontFamily, str, m7555lerpTextUnitInheritableC3pnCVY2, BaselineShift.m7900boximpl(m7916lerpjWV1Mfo), TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f), (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f), ColorKt.m5399lerpjxsXWHM(spanStyle.m7547getBackground0d7_KjU(), spanStyle2.m7547getBackground0d7_KjU(), f), (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f), nullSafeLerp(spanStyle.getShadow(), spanStyle2.getShadow(), f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    public static final Shadow nullSafeLerp(Shadow shadow, Shadow shadow2, float f) {
        if (!ComposeUiTextFlags.isCorrectShadowLerpWithNullsEnabled) {
            if (shadow == null) {
                shadow = new Shadow(0L, 0L, 0.0f, 7, null);
            }
            if (shadow2 == null) {
                shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
            }
            return ShadowKt.lerp(shadow, shadow2, f);
        } else if (shadow == null && shadow2 == null) {
            return null;
        } else {
            if (shadow == null) {
                Intrinsics.checkNotNull(shadow2);
                return ShadowKt.lerp(dropAlpha(shadow2), shadow2, f);
            } else if (shadow2 == null) {
                return ShadowKt.lerp(shadow, dropAlpha(shadow), f);
            } else {
                return ShadowKt.lerp(shadow, shadow2, f);
            }
        }
    }

    private static final Shadow dropAlpha(Shadow shadow) {
        return Shadow.m5688copyqcb84PM$default(shadow, Color.m5347copywmQWz5c$default(shadow.m5692getColor0d7_KjU(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0.0f, 6, null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle spanStyle) {
        long m7553getLetterSpacingXSAIIZE;
        TextForegroundStyle takeOrElse = spanStyle.getTextForegroundStyle$ui_text().takeOrElse(new Function0() { // from class: androidx.compose.ui.text.SpanStyleKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TextForegroundStyle textForegroundStyle;
                textForegroundStyle = SpanStyleKt.DefaultColorForegroundStyle;
                return textForegroundStyle;
            }
        });
        long m7550getFontSizeXSAIIZE = TextUnit.m8352getRawTypeimpl(spanStyle.m7550getFontSizeXSAIIZE()) == 0 ? DefaultFontSize : spanStyle.m7550getFontSizeXSAIIZE();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle m7551getFontStyle4Lr2A7w = spanStyle.m7551getFontStyle4Lr2A7w();
        FontStyle m7717boximpl = FontStyle.m7717boximpl(m7551getFontStyle4Lr2A7w != null ? m7551getFontStyle4Lr2A7w.m7723unboximpl() : FontStyle.Companion.m7727getNormal_LCdwA());
        FontSynthesis m7552getFontSynthesisZQGJjVo = spanStyle.m7552getFontSynthesisZQGJjVo();
        FontSynthesis m7728boximpl = FontSynthesis.m7728boximpl(m7552getFontSynthesisZQGJjVo != null ? m7552getFontSynthesisZQGJjVo.m7736unboximpl() : FontSynthesis.Companion.m7737getAllGVVA2EU());
        SystemFontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnit.m8352getRawTypeimpl(spanStyle.m7553getLetterSpacingXSAIIZE()) == 0) {
            m7553getLetterSpacingXSAIIZE = DefaultLetterSpacing;
        } else {
            m7553getLetterSpacingXSAIIZE = spanStyle.m7553getLetterSpacingXSAIIZE();
        }
        long j = m7553getLetterSpacingXSAIIZE;
        BaselineShift m7548getBaselineShift5SSeXJ0 = spanStyle.m7548getBaselineShift5SSeXJ0();
        float m7906unboximpl = m7548getBaselineShift5SSeXJ0 != null ? m7548getBaselineShift5SSeXJ0.m7906unboximpl() : BaselineShift.Companion.m7911getNoney9eOQZs();
        if (Float.isNaN(m7906unboximpl)) {
            m7906unboximpl = BaselineShift.Companion.m7911getNoney9eOQZs();
        }
        BaselineShift m7900boximpl = BaselineShift.m7900boximpl(m7906unboximpl);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long m7547getBackground0d7_KjU = spanStyle.m7547getBackground0d7_KjU();
        if (m7547getBackground0d7_KjU == 16) {
            m7547getBackground0d7_KjU = DefaultBackgroundColor;
        }
        long j2 = m7547getBackground0d7_KjU;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        Fill drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(takeOrElse, m7550getFontSizeXSAIIZE, fontWeight2, m7717boximpl, m7728boximpl, fontFamily2, str, j, m7900boximpl, textGeometricTransform2, localeList2, j2, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY  reason: not valid java name */
    public static final long m7555lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (TextUnit.m8352getRawTypeimpl(j) == 0 || TextUnit.m8352getRawTypeimpl(j2) == 0) {
            return ((TextUnit) lerpDiscrete(TextUnit.m8344boximpl(j), TextUnit.m8344boximpl(j2), f)).m8363unboximpl();
        }
        return TextUnitKt.m8374lerpC3pnCVY(j, j2, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
        if (androidx.compose.ui.unit.TextUnit.m8351equalsimpl0(r35, r23.m7553getLetterSpacingXSAIIZE()) == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ec, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r14, r23.getTextGeometricTransform()) != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00fd, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r39, r23.getLocaleList()) == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0110, code lost:
        if (androidx.compose.ui.graphics.Color.m5349equalsimpl0(r7, r23.m7547getBackground0d7_KjU()) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
        if (androidx.compose.ui.unit.TextUnit.m8351equalsimpl0(r11, r23.m7550getFontSizeXSAIIZE()) != false) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017b  */
    /* renamed from: fastMerge-dSHsh3o  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpanStyle m7554fastMergedSHsh3o(SpanStyle spanStyle, long j, Brush brush, float f, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        long j5;
        TextGeometricTransform textGeometricTransform2;
        long j6;
        DrawStyle drawStyle2;
        TextForegroundStyle m8065from8_81llA;
        String str2 = str;
        BaselineShift baselineShift2 = baselineShift;
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow2 = shadow;
        if (TextUnit.m8352getRawTypeimpl(j2) == 0) {
            j5 = j2;
        } else {
            j5 = j2;
        }
        if ((brush != null || j == 16 || Color.m5349equalsimpl0(j, spanStyle.getTextForegroundStyle$ui_text().mo7918getColor0d7_KjU())) && ((fontStyle == null || Intrinsics.areEqual(fontStyle, spanStyle.m7551getFontStyle4Lr2A7w())) && ((fontWeight == null || Intrinsics.areEqual(fontWeight, spanStyle.getFontWeight())) && (fontFamily == null || fontFamily == spanStyle.getFontFamily())))) {
            if (TextUnit.m8352getRawTypeimpl(j3) == 0) {
            }
            if ((textDecoration2 == null || Intrinsics.areEqual(textDecoration2, spanStyle.getTextDecoration())) && Intrinsics.areEqual(brush, spanStyle.getTextForegroundStyle$ui_text().getBrush()) && ((brush == null || f == spanStyle.getTextForegroundStyle$ui_text().getAlpha()) && ((fontSynthesis == null || Intrinsics.areEqual(fontSynthesis, spanStyle.m7552getFontSynthesisZQGJjVo())) && ((str2 == null || Intrinsics.areEqual(str2, spanStyle.getFontFeatureSettings())) && (baselineShift2 == null || Intrinsics.areEqual(baselineShift2, spanStyle.m7548getBaselineShift5SSeXJ0())))))) {
                if (textGeometricTransform != null) {
                    textGeometricTransform2 = textGeometricTransform;
                } else {
                    textGeometricTransform2 = textGeometricTransform;
                }
                if (localeList == null) {
                }
                if (j4 != 16) {
                    j6 = j4;
                } else {
                    j6 = j4;
                }
                if ((shadow2 == null || Intrinsics.areEqual(shadow2, spanStyle.getShadow())) && (platformSpanStyle == null || Intrinsics.areEqual(platformSpanStyle, spanStyle.getPlatformStyle()))) {
                    drawStyle2 = drawStyle;
                    if (drawStyle2 == null || Intrinsics.areEqual(drawStyle2, spanStyle.getDrawStyle())) {
                        return spanStyle;
                    }
                    if (brush != null) {
                        m8065from8_81llA = TextForegroundStyle.Companion.from(brush, f);
                    } else {
                        m8065from8_81llA = TextForegroundStyle.Companion.m8065from8_81llA(j);
                    }
                    TextForegroundStyle merge = spanStyle.getTextForegroundStyle$ui_text().merge(m8065from8_81llA);
                    FontFamily fontFamily2 = fontFamily == null ? spanStyle.getFontFamily() : fontFamily;
                    if (TextUnit.m8352getRawTypeimpl(j5) == 0) {
                        j5 = spanStyle.m7550getFontSizeXSAIIZE();
                    }
                    FontWeight fontWeight2 = fontWeight == null ? spanStyle.getFontWeight() : fontWeight;
                    FontStyle m7551getFontStyle4Lr2A7w = fontStyle == null ? spanStyle.m7551getFontStyle4Lr2A7w() : fontStyle;
                    FontSynthesis m7552getFontSynthesisZQGJjVo = fontSynthesis == null ? spanStyle.m7552getFontSynthesisZQGJjVo() : fontSynthesis;
                    if (str2 == null) {
                        str2 = spanStyle.getFontFeatureSettings();
                    }
                    long m7553getLetterSpacingXSAIIZE = TextUnit.m8352getRawTypeimpl(j3) == 0 ? spanStyle.m7553getLetterSpacingXSAIIZE() : j3;
                    if (baselineShift2 == null) {
                        baselineShift2 = spanStyle.m7548getBaselineShift5SSeXJ0();
                    }
                    if (textGeometricTransform2 == null) {
                        textGeometricTransform2 = spanStyle.getTextGeometricTransform();
                    }
                    LocaleList localeList2 = localeList == null ? spanStyle.getLocaleList() : localeList;
                    if (j6 == 16) {
                        j6 = spanStyle.m7547getBackground0d7_KjU();
                    }
                    if (textDecoration2 == null) {
                        textDecoration2 = spanStyle.getTextDecoration();
                    }
                    if (shadow2 == null) {
                        shadow2 = spanStyle.getShadow();
                    }
                    return new SpanStyle(merge, j5, fontWeight2, m7551getFontStyle4Lr2A7w, m7552getFontSynthesisZQGJjVo, fontFamily2, str2, m7553getLetterSpacingXSAIIZE, baselineShift2, textGeometricTransform2, localeList2, j6, textDecoration2, shadow2, mergePlatformStyle(spanStyle, platformSpanStyle), drawStyle2 == null ? spanStyle.getDrawStyle() : drawStyle2, (DefaultConstructorMarker) null);
                }
                drawStyle2 = drawStyle;
                if (brush != null) {
                }
                TextForegroundStyle merge2 = spanStyle.getTextForegroundStyle$ui_text().merge(m8065from8_81llA);
                if (fontFamily == null) {
                }
                if (TextUnit.m8352getRawTypeimpl(j5) == 0) {
                }
                if (fontWeight == null) {
                }
                if (fontStyle == null) {
                }
                if (fontSynthesis == null) {
                }
                if (str2 == null) {
                }
                if (TextUnit.m8352getRawTypeimpl(j3) == 0) {
                }
                if (baselineShift2 == null) {
                }
                if (textGeometricTransform2 == null) {
                }
                if (localeList == null) {
                }
                if (j6 == 16) {
                }
                if (textDecoration2 == null) {
                }
                if (shadow2 == null) {
                }
                return new SpanStyle(merge2, j5, fontWeight2, m7551getFontStyle4Lr2A7w, m7552getFontSynthesisZQGJjVo, fontFamily2, str2, m7553getLetterSpacingXSAIIZE, baselineShift2, textGeometricTransform2, localeList2, j6, textDecoration2, shadow2, mergePlatformStyle(spanStyle, platformSpanStyle), drawStyle2 == null ? spanStyle.getDrawStyle() : drawStyle2, (DefaultConstructorMarker) null);
            }
        }
        textGeometricTransform2 = textGeometricTransform;
        j6 = j4;
        drawStyle2 = drawStyle;
        if (brush != null) {
        }
        TextForegroundStyle merge22 = spanStyle.getTextForegroundStyle$ui_text().merge(m8065from8_81llA);
        if (fontFamily == null) {
        }
        if (TextUnit.m8352getRawTypeimpl(j5) == 0) {
        }
        if (fontWeight == null) {
        }
        if (fontStyle == null) {
        }
        if (fontSynthesis == null) {
        }
        if (str2 == null) {
        }
        if (TextUnit.m8352getRawTypeimpl(j3) == 0) {
        }
        if (baselineShift2 == null) {
        }
        if (textGeometricTransform2 == null) {
        }
        if (localeList == null) {
        }
        if (j6 == 16) {
        }
        if (textDecoration2 == null) {
        }
        if (shadow2 == null) {
        }
        return new SpanStyle(merge22, j5, fontWeight2, m7551getFontStyle4Lr2A7w, m7552getFontSynthesisZQGJjVo, fontFamily2, str2, m7553getLetterSpacingXSAIIZE, baselineShift2, textGeometricTransform2, localeList2, j6, textDecoration2, shadow2, mergePlatformStyle(spanStyle, platformSpanStyle), drawStyle2 == null ? spanStyle.getDrawStyle() : drawStyle2, (DefaultConstructorMarker) null);
    }
}
