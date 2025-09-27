package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ParagraphStyle.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001ac\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006$"}, d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", TtmlNode.START, "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", TtmlNode.ATTR_TTS_TEXT_ALIGN, "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.Companion.m7469getUnspecifiedXSAIIZE();

    public static final ParagraphStyle lerp(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, float f) {
        int m7147unboximpl = ((TextAlign) SpanStyleKt.lerpDiscrete(TextAlign.m7141boximpl(paragraphStyle.m6612getTextAligne0LSkKk()), TextAlign.m7141boximpl(paragraphStyle2.m6612getTextAligne0LSkKk()), f)).m7147unboximpl();
        int m7161unboximpl = ((TextDirection) SpanStyleKt.lerpDiscrete(TextDirection.m7155boximpl(paragraphStyle.m6614getTextDirections_7Xco()), TextDirection.m7155boximpl(paragraphStyle2.m6614getTextDirections_7Xco()), f)).m7161unboximpl();
        long m6673lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m6673lerpTextUnitInheritableC3pnCVY(paragraphStyle.m6610getLineHeightXSAIIZE(), paragraphStyle2.m6610getLineHeightXSAIIZE(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(m7147unboximpl, m7161unboximpl, m6673lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f), ((LineBreak) SpanStyleKt.lerpDiscrete(LineBreak.m7049boximpl(paragraphStyle.m6609getLineBreakrAG3T2k()), LineBreak.m7049boximpl(paragraphStyle2.m6609getLineBreakrAG3T2k()), f)).m7061unboximpl(), ((Hyphens) SpanStyleKt.lerpDiscrete(Hyphens.m7039boximpl(paragraphStyle.m6607getHyphensvmbZdU8()), Hyphens.m7039boximpl(paragraphStyle2.m6607getHyphensvmbZdU8()), f)).m7045unboximpl(), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.Companion.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle paragraphStyle, LayoutDirection layoutDirection) {
        int m7153getStarte0LSkKk = TextAlign.m7144equalsimpl0(paragraphStyle.m6612getTextAligne0LSkKk(), TextAlign.Companion.m7154getUnspecifiede0LSkKk()) ? TextAlign.Companion.m7153getStarte0LSkKk() : paragraphStyle.m6612getTextAligne0LSkKk();
        int m6772resolveTextDirectionIhaHGbI = TextStyleKt.m6772resolveTextDirectionIhaHGbI(layoutDirection, paragraphStyle.m6614getTextDirections_7Xco());
        long m6610getLineHeightXSAIIZE = TextUnit.m7456getRawTypeimpl(paragraphStyle.m6610getLineHeightXSAIIZE()) == 0 ? DefaultLineHeight : paragraphStyle.m6610getLineHeightXSAIIZE();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        int m7068getSimplerAG3T2k = LineBreak.m7055equalsimpl0(paragraphStyle.m6609getLineBreakrAG3T2k(), LineBreak.Companion.m7069getUnspecifiedrAG3T2k()) ? LineBreak.Companion.m7068getSimplerAG3T2k() : paragraphStyle.m6609getLineBreakrAG3T2k();
        int m7047getNonevmbZdU8 = Hyphens.m7042equalsimpl0(paragraphStyle.m6607getHyphensvmbZdU8(), Hyphens.Companion.m7048getUnspecifiedvmbZdU8()) ? Hyphens.Companion.m7047getNonevmbZdU8() : paragraphStyle.m6607getHyphensvmbZdU8();
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        return new ParagraphStyle(m7153getStarte0LSkKk, m6772resolveTextDirectionIhaHGbI, m6610getLineHeightXSAIIZE, textIndent2, platformStyle, lineHeightStyle, m7068getSimplerAG3T2k, m7047getNonevmbZdU8, textMotion, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
        if (androidx.compose.ui.unit.TextUnit.m7455equalsimpl0(r14, r23.m6610getLineHeightXSAIIZE()) != false) goto L42;
     */
    /* renamed from: fastMerge-j5T8yCg  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ParagraphStyle m6615fastMergej5T8yCg(ParagraphStyle paragraphStyle, int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        long j2;
        int i5 = i;
        TextIndent textIndent2 = textIndent;
        if (TextAlign.m7144equalsimpl0(i5, TextAlign.Companion.m7154getUnspecifiede0LSkKk()) || TextAlign.m7144equalsimpl0(i5, paragraphStyle.m6612getTextAligne0LSkKk())) {
            if (TextUnit.m7456getRawTypeimpl(j) == 0) {
                j2 = j;
            } else {
                j2 = j;
            }
            if ((textIndent2 == null || Intrinsics.areEqual(textIndent2, paragraphStyle.getTextIndent())) && ((TextDirection.m7158equalsimpl0(i2, TextDirection.Companion.m7167getUnspecifieds_7Xco()) || TextDirection.m7158equalsimpl0(i2, paragraphStyle.m6614getTextDirections_7Xco())) && ((platformParagraphStyle == null || Intrinsics.areEqual(platformParagraphStyle, paragraphStyle.getPlatformStyle())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, paragraphStyle.getLineHeightStyle())) && ((LineBreak.m7055equalsimpl0(i3, LineBreak.Companion.m7069getUnspecifiedrAG3T2k()) || LineBreak.m7055equalsimpl0(i3, paragraphStyle.m6609getLineBreakrAG3T2k())) && ((Hyphens.m7042equalsimpl0(i4, Hyphens.Companion.m7048getUnspecifiedvmbZdU8()) || Hyphens.m7042equalsimpl0(i4, paragraphStyle.m6607getHyphensvmbZdU8())) && (textMotion == null || Intrinsics.areEqual(textMotion, paragraphStyle.getTextMotion())))))))) {
                return paragraphStyle;
            }
        } else {
            j2 = j;
        }
        if (TextUnit.m7456getRawTypeimpl(j2) == 0) {
            j2 = paragraphStyle.m6610getLineHeightXSAIIZE();
        }
        if (textIndent2 == null) {
            textIndent2 = paragraphStyle.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (TextAlign.m7144equalsimpl0(i5, TextAlign.Companion.m7154getUnspecifiede0LSkKk())) {
            i5 = paragraphStyle.m6612getTextAligne0LSkKk();
        }
        return new ParagraphStyle(i5, !TextDirection.m7158equalsimpl0(i2, TextDirection.Companion.m7167getUnspecifieds_7Xco()) ? i2 : paragraphStyle.m6614getTextDirections_7Xco(), j2, textIndent3, mergePlatformStyle(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.getLineHeightStyle() : lineHeightStyle, !LineBreak.m7055equalsimpl0(i3, LineBreak.Companion.m7069getUnspecifiedrAG3T2k()) ? i3 : paragraphStyle.m6609getLineBreakrAG3T2k(), !Hyphens.m7042equalsimpl0(i4, Hyphens.Companion.m7048getUnspecifiedvmbZdU8()) ? i4 : paragraphStyle.m6607getHyphensvmbZdU8(), textMotion == null ? paragraphStyle.getTextMotion() : textMotion, (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (paragraphStyle.getPlatformStyle() == null) {
            return platformParagraphStyle;
        }
        if (platformParagraphStyle == null) {
            return paragraphStyle.getPlatformStyle();
        }
        return paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }
}
