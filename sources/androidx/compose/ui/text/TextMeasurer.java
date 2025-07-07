package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
/* compiled from: TextMeasurer.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u008a\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#Jt\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020$2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Landroidx/compose/ui/text/TextMeasurer;", "", "defaultFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "defaultDensity", "Landroidx/compose/ui/unit/Density;", "defaultLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "", "measure-wNUYSr0", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;IZIJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextMeasurer {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int cacheSize;
    private final Density defaultDensity;
    private final FontFamily.Resolver defaultFontFamilyResolver;
    private final LayoutDirection defaultLayoutDirection;
    private final TextLayoutCache textLayoutCache;

    public TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i) {
        this.defaultFontFamilyResolver = resolver;
        this.defaultDensity = density;
        this.defaultLayoutDirection = layoutDirection;
        this.cacheSize = i;
        this.textLayoutCache = i > 0 ? new TextLayoutCache(i) : null;
    }

    public /* synthetic */ TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver, density, layoutDirection, (i2 & 8) != 0 ? 8 : i);
    }

    /* renamed from: measure-xDpz5zY$default */
    public static /* synthetic */ TextLayoutResult m6121measurexDpz5zY$default(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, int i, boolean z, int i2, List list, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            textStyle = TextStyle.Companion.getDefault();
        }
        return textMeasurer.m6123measurexDpz5zY(annotatedString, textStyle, (i3 & 4) != 0 ? TextOverflow.Companion.m6619getClipgIe3tQ8() : i, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? Integer.MAX_VALUE : i2, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list, (i3 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : j, (i3 & 128) != 0 ? textMeasurer.defaultLayoutDirection : layoutDirection, (i3 & 256) != 0 ? textMeasurer.defaultDensity : density, (i3 & 512) != 0 ? textMeasurer.defaultFontFamilyResolver : resolver, (i3 & 1024) != 0 ? false : z2);
    }

    /* renamed from: measure-xDpz5zY */
    public final TextLayoutResult m6123measurexDpz5zY(AnnotatedString annotatedString, TextStyle textStyle, int i, boolean z, int i2, List<AnnotatedString.Range<Placeholder>> list, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2) {
        TextLayoutCache textLayoutCache;
        TextLayoutInput textLayoutInput = new TextLayoutInput(annotatedString, textStyle, list, i2, z, i, density, layoutDirection, resolver, j, (DefaultConstructorMarker) null);
        TextLayoutResult textLayoutResult = (z2 || (textLayoutCache = this.textLayoutCache) == null) ? null : textLayoutCache.get(textLayoutInput);
        if (textLayoutResult != null) {
            return textLayoutResult.m6116copyO0kMr_c(textLayoutInput, ConstraintsKt.m6651constrain4WqzIAM(j, IntSize.m6850constructorimpl((ParagraphKt.ceilToInt(textLayoutResult.getMultiParagraph().getWidth()) << 32) | (ParagraphKt.ceilToInt(textLayoutResult.getMultiParagraph().getHeight()) & 4294967295L))));
        }
        TextLayoutResult layout = Companion.layout(textLayoutInput);
        TextLayoutCache textLayoutCache2 = this.textLayoutCache;
        if (textLayoutCache2 != null) {
            textLayoutCache2.put(textLayoutInput, layout);
        }
        return layout;
    }

    /* renamed from: measure-wNUYSr0$default */
    public static /* synthetic */ TextLayoutResult m6120measurewNUYSr0$default(TextMeasurer textMeasurer, String str, TextStyle textStyle, int i, boolean z, int i2, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            textStyle = TextStyle.Companion.getDefault();
        }
        TextStyle textStyle2 = textStyle;
        if ((i3 & 4) != 0) {
            i = TextOverflow.Companion.m6619getClipgIe3tQ8();
        }
        return textMeasurer.m6122measurewNUYSr0(str, textStyle2, i, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? Integer.MAX_VALUE : i2, (i3 & 32) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : j, (i3 & 64) != 0 ? textMeasurer.defaultLayoutDirection : layoutDirection, (i3 & 128) != 0 ? textMeasurer.defaultDensity : density, (i3 & 256) != 0 ? textMeasurer.defaultFontFamilyResolver : resolver, (i3 & 512) != 0 ? false : z2);
    }

    /* renamed from: measure-wNUYSr0 */
    public final TextLayoutResult m6122measurewNUYSr0(String str, TextStyle textStyle, int i, boolean z, int i2, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2) {
        return m6121measurexDpz5zY$default(this, new AnnotatedString(str, null, 2, null), textStyle, i, z, i2, null, j, layoutDirection, density, resolver, z2, 32, null);
    }

    /* compiled from: TextMeasurer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "()V", TtmlNode.TAG_LAYOUT, "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
            if (r2 != false) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0069  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final TextLayoutResult layout(TextLayoutInput textLayoutInput) {
            int m6637getMaxWidthimpl;
            int maxLines;
            boolean m6125isEllipsisMW5ApA;
            boolean m6125isEllipsisMW5ApA2;
            MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(textLayoutInput.getText(), TextStyleKt.resolveDefaults(textLayoutInput.getStyle(), textLayoutInput.getLayoutDirection()), textLayoutInput.getPlaceholders(), textLayoutInput.getDensity(), textLayoutInput.getFontFamilyResolver());
            int m6639getMinWidthimpl = Constraints.m6639getMinWidthimpl(textLayoutInput.m6113getConstraintsmsEJaDk());
            if (!textLayoutInput.getSoftWrap()) {
                m6125isEllipsisMW5ApA2 = TextMeasurerKt.m6125isEllipsisMW5ApA(textLayoutInput.m6114getOverflowgIe3tQ8());
            }
            if (Constraints.m6633getHasBoundedWidthimpl(textLayoutInput.m6113getConstraintsmsEJaDk())) {
                m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(textLayoutInput.m6113getConstraintsmsEJaDk());
                if (!textLayoutInput.getSoftWrap()) {
                    m6125isEllipsisMW5ApA = TextMeasurerKt.m6125isEllipsisMW5ApA(textLayoutInput.m6114getOverflowgIe3tQ8());
                    if (m6125isEllipsisMW5ApA) {
                        maxLines = 1;
                        int i = maxLines;
                        if (m6639getMinWidthimpl != m6637getMaxWidthimpl) {
                            m6637getMaxWidthimpl = RangesKt.coerceIn(ParagraphKt.ceilToInt(multiParagraphIntrinsics.getMaxIntrinsicWidth()), m6639getMinWidthimpl, m6637getMaxWidthimpl);
                        }
                        MultiParagraph multiParagraph = new MultiParagraph(multiParagraphIntrinsics, Constraints.Companion.m6646fitPrioritizingWidthZbe2FdA(0, m6637getMaxWidthimpl, 0, Constraints.m6636getMaxHeightimpl(textLayoutInput.m6113getConstraintsmsEJaDk())), i, textLayoutInput.m6114getOverflowgIe3tQ8(), (DefaultConstructorMarker) null);
                        return new TextLayoutResult(textLayoutInput, multiParagraph, ConstraintsKt.m6651constrain4WqzIAM(textLayoutInput.m6113getConstraintsmsEJaDk(), IntSize.m6850constructorimpl((((int) Math.ceil(multiParagraph.getWidth())) << 32) | (((int) Math.ceil(multiParagraph.getHeight())) & 4294967295L))), null);
                    }
                }
                maxLines = textLayoutInput.getMaxLines();
                int i2 = maxLines;
                if (m6639getMinWidthimpl != m6637getMaxWidthimpl) {
                }
                MultiParagraph multiParagraph2 = new MultiParagraph(multiParagraphIntrinsics, Constraints.Companion.m6646fitPrioritizingWidthZbe2FdA(0, m6637getMaxWidthimpl, 0, Constraints.m6636getMaxHeightimpl(textLayoutInput.m6113getConstraintsmsEJaDk())), i2, textLayoutInput.m6114getOverflowgIe3tQ8(), (DefaultConstructorMarker) null);
                return new TextLayoutResult(textLayoutInput, multiParagraph2, ConstraintsKt.m6651constrain4WqzIAM(textLayoutInput.m6113getConstraintsmsEJaDk(), IntSize.m6850constructorimpl((((int) Math.ceil(multiParagraph2.getWidth())) << 32) | (((int) Math.ceil(multiParagraph2.getHeight())) & 4294967295L))), null);
            }
            m6637getMaxWidthimpl = Integer.MAX_VALUE;
            if (!textLayoutInput.getSoftWrap()) {
            }
            maxLines = textLayoutInput.getMaxLines();
            int i22 = maxLines;
            if (m6639getMinWidthimpl != m6637getMaxWidthimpl) {
            }
            MultiParagraph multiParagraph22 = new MultiParagraph(multiParagraphIntrinsics, Constraints.Companion.m6646fitPrioritizingWidthZbe2FdA(0, m6637getMaxWidthimpl, 0, Constraints.m6636getMaxHeightimpl(textLayoutInput.m6113getConstraintsmsEJaDk())), i22, textLayoutInput.m6114getOverflowgIe3tQ8(), (DefaultConstructorMarker) null);
            return new TextLayoutResult(textLayoutInput, multiParagraph22, ConstraintsKt.m6651constrain4WqzIAM(textLayoutInput.m6113getConstraintsmsEJaDk(), IntSize.m6850constructorimpl((((int) Math.ceil(multiParagraph22.getWidth())) << 32) | (((int) Math.ceil(multiParagraph22.getHeight())) & 4294967295L))), null);
        }
    }
}
