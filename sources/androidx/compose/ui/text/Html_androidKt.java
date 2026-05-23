package androidx.compose.ui.text;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.Html;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.text.HtmlCompat;
import androidx.media3.extractor.WavUtil;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.xml.sax.XMLReader;
/* compiled from: Html.android.kt */
@Metadata(d1 = {"\u0000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001 \u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a$\u0010\t\u001a\u00020\u0001*\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0001\u001a(\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\u001a8\u0010\u000f\u001a\u00020\f*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0002\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u001aH\u0002\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001bH\u0002\u001a\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002\"\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"fromHtml", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/AnnotatedString$Companion;", "htmlString", "", "linkStyles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "toAnnotatedString", "Landroid/text/Spanned;", "addSpans", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "spanned", "addSpan", TtmlNode.TAG_SPAN, "", TtmlNode.START, "", TtmlNode.END, "toParagraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "Landroid/text/style/AlignmentSpan;", "toSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroid/text/style/StyleSpan;", "Landroid/text/style/TypefaceSpan;", "optionalFontFamilyFromName", "Landroidx/compose/ui/text/font/FontFamily;", "familyName", "TagHandler", "androidx/compose/ui/text/Html_androidKt$TagHandler$1", "Landroidx/compose/ui/text/Html_androidKt$TagHandler$1;", Html_androidKt.ContentHandlerReplacementTag, "AnnotationTag", "Li", "Ul", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Html_androidKt {
    private static final String AnnotationTag = "annotation";
    private static final String ContentHandlerReplacementTag = "ContentHandlerReplacementTag";
    private static final String Li = "li";
    private static final Html_androidKt$TagHandler$1 TagHandler = new Html.TagHandler() { // from class: androidx.compose.ui.text.Html_androidKt$TagHandler$1
        @Override // android.text.Html.TagHandler
        public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            if (xMLReader == null || editable == null || !z || !Intrinsics.areEqual(str, "ContentHandlerReplacementTag")) {
                return;
            }
            xMLReader.setContentHandler(new AnnotationContentHandler(xMLReader.getContentHandler(), editable));
        }
    };
    private static final String Ul = "ul";

    /* compiled from: Html.android.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ AnnotatedString fromHtml$default(AnnotatedString.Companion companion, String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i, Object obj) {
        if ((i & 2) != 0) {
            textLinkStyles = null;
        }
        if ((i & 4) != 0) {
            linkInteractionListener = null;
        }
        return fromHtml(companion, str, textLinkStyles, linkInteractionListener);
    }

    public static final AnnotatedString fromHtml(AnnotatedString.Companion companion, String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        return toAnnotatedString(HtmlCompat.fromHtml("<ContentHandlerReplacementTag />" + str, 63, null, TagHandler), textLinkStyles, linkInteractionListener);
    }

    public static /* synthetic */ AnnotatedString toAnnotatedString$default(Spanned spanned, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i, Object obj) {
        if ((i & 1) != 0) {
            textLinkStyles = null;
        }
        if ((i & 2) != 0) {
            linkInteractionListener = null;
        }
        return toAnnotatedString(spanned, textLinkStyles, linkInteractionListener);
    }

    public static final AnnotatedString toAnnotatedString(Spanned spanned, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        AnnotatedString.Builder append = new AnnotatedString.Builder(spanned.length()).append((CharSequence) spanned);
        addSpans(append, spanned, textLinkStyles, linkInteractionListener);
        return append.toAnnotatedString();
    }

    private static final void addSpans(AnnotatedString.Builder builder, Spanned spanned, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        Object[] spans;
        for (Object obj : spanned.getSpans(0, builder.getLength(), Object.class)) {
            long TextRange = TextRangeKt.TextRange(spanned.getSpanStart(obj), spanned.getSpanEnd(obj));
            addSpan(builder, obj, TextRange.m7608getStartimpl(TextRange), TextRange.m7603getEndimpl(TextRange), textLinkStyles, linkInteractionListener);
        }
    }

    private static final void addSpan(AnnotatedString.Builder builder, Object obj, int i, int i2, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
        String url;
        if (obj instanceof AbsoluteSizeSpan) {
            return;
        }
        if (obj instanceof AlignmentSpan) {
            builder.addStyle(toParagraphStyle((AlignmentSpan) obj), i, i2);
        } else if (obj instanceof AnnotationSpan) {
            AnnotationSpan annotationSpan = (AnnotationSpan) obj;
            builder.addStringAnnotation(annotationSpan.getKey(), annotationSpan.getValue(), i, i2);
        } else if (obj instanceof BackgroundColorSpan) {
            builder.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, ColorKt.Color(((BackgroundColorSpan) obj).getBackgroundColor()), (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63487, (DefaultConstructorMarker) null), i, i2);
        } else if (obj instanceof BulletSpanWithLevel) {
            long m7452getDefaultIndentationXSAIIZE = Bullet.Companion.m7452getDefaultIndentationXSAIIZE();
            BulletSpanWithLevel bulletSpanWithLevel = (BulletSpanWithLevel) obj;
            int indentationLevel = bulletSpanWithLevel.getIndentationLevel();
            TextUnitKt.m8367checkArithmeticR2X_6o(m7452getDefaultIndentationXSAIIZE);
            builder.m7445addBulletr9BaKPg(bulletSpanWithLevel.getBullet(), TextUnitKt.pack(TextUnit.m8352getRawTypeimpl(m7452getDefaultIndentationXSAIIZE), TextUnit.m8354getValueimpl(m7452getDefaultIndentationXSAIIZE) * indentationLevel), i, i2);
        } else if (obj instanceof ForegroundColorSpan) {
            builder.addStyle(new SpanStyle(ColorKt.Color(((ForegroundColorSpan) obj).getForegroundColor()), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, (DefaultConstructorMarker) null), i, i2);
        } else if (obj instanceof RelativeSizeSpan) {
            builder.addStyle(new SpanStyle(0L, TextUnitKt.getEm(((RelativeSizeSpan) obj).getSizeChange()), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, (int) Utf8.REPLACEMENT_CODE_POINT, (DefaultConstructorMarker) null), i, i2);
        } else if (obj instanceof StrikethroughSpan) {
            builder.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Companion.getLineThrough(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), i, i2);
        } else if (obj instanceof StyleSpan) {
            SpanStyle spanStyle = toSpanStyle((StyleSpan) obj);
            if (spanStyle != null) {
                builder.addStyle(spanStyle, i, i2);
            }
        } else if (obj instanceof SubscriptSpan) {
            builder.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, BaselineShift.m7900boximpl(BaselineShift.Companion.m7912getSubscripty9eOQZs()), (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65279, (DefaultConstructorMarker) null), i, i2);
        } else if (obj instanceof SuperscriptSpan) {
            builder.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, BaselineShift.m7900boximpl(BaselineShift.Companion.m7913getSuperscripty9eOQZs()), (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65279, (DefaultConstructorMarker) null), i, i2);
        } else if (obj instanceof TypefaceSpan) {
            builder.addStyle(toSpanStyle((TypefaceSpan) obj), i, i2);
        } else if (obj instanceof UnderlineSpan) {
            builder.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Companion.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), i, i2);
        } else if (!(obj instanceof URLSpan) || (url = ((URLSpan) obj).getURL()) == null) {
        } else {
            builder.addLink(new LinkAnnotation.Url(url, textLinkStyles, linkInteractionListener), i, i2);
        }
    }

    private static final ParagraphStyle toParagraphStyle(AlignmentSpan alignmentSpan) {
        int m8043getStarte0LSkKk;
        Layout.Alignment alignment = alignmentSpan.getAlignment();
        int i = alignment == null ? -1 : WhenMappings.$EnumSwitchMapping$0[alignment.ordinal()];
        if (i == 1) {
            m8043getStarte0LSkKk = TextAlign.Companion.m8043getStarte0LSkKk();
        } else if (i == 2) {
            m8043getStarte0LSkKk = TextAlign.Companion.m8038getCentere0LSkKk();
        } else if (i == 3) {
            m8043getStarte0LSkKk = TextAlign.Companion.m8039getEnde0LSkKk();
        } else {
            m8043getStarte0LSkKk = TextAlign.Companion.m8044getUnspecifiede0LSkKk();
        }
        return new ParagraphStyle(m8043getStarte0LSkKk, 0, 0L, (TextIndent) null, (PlatformParagraphStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, (int) TypedValues.PositionType.TYPE_POSITION_TYPE, (DefaultConstructorMarker) null);
    }

    private static final SpanStyle toSpanStyle(StyleSpan styleSpan) {
        int style = styleSpan.getStyle();
        if (style != 1) {
            if (style != 2) {
                if (style != 3) {
                    return null;
                }
                return new SpanStyle(0L, 0L, FontWeight.Companion.getBold(), FontStyle.m7717boximpl(FontStyle.Companion.m7726getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65523, (DefaultConstructorMarker) null);
            }
            return new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.m7717boximpl(FontStyle.Companion.m7726getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (DefaultConstructorMarker) null);
        }
        return new SpanStyle(0L, 0L, FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null);
    }

    private static final SpanStyle toSpanStyle(TypefaceSpan typefaceSpan) {
        GenericFontFamily serif;
        String family = typefaceSpan.getFamily();
        if (Intrinsics.areEqual(family, FontFamily.Companion.getCursive().getName())) {
            serif = FontFamily.Companion.getCursive();
        } else if (Intrinsics.areEqual(family, FontFamily.Companion.getMonospace().getName())) {
            serif = FontFamily.Companion.getMonospace();
        } else if (Intrinsics.areEqual(family, FontFamily.Companion.getSansSerif().getName())) {
            serif = FontFamily.Companion.getSansSerif();
        } else {
            serif = Intrinsics.areEqual(family, FontFamily.Companion.getSerif().getName()) ? FontFamily.Companion.getSerif() : optionalFontFamilyFromName(typefaceSpan.getFamily());
        }
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, serif, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65503, (DefaultConstructorMarker) null);
    }

    private static final FontFamily optionalFontFamilyFromName(String str) {
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            Typeface create = Typeface.create(str, 0);
            if (Intrinsics.areEqual(create, Typeface.DEFAULT) || Intrinsics.areEqual(create, Typeface.create(Typeface.DEFAULT, 0))) {
                create = null;
            }
            if (create != null) {
                return AndroidTypeface_androidKt.FontFamily(create);
            }
        }
        return null;
    }
}
