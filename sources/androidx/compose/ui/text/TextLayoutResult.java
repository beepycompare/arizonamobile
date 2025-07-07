package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextLayoutResult.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001aJ\u000e\u0010/\u001a\u00020!2\u0006\u0010.\u001a\u00020\u001aJ\u000e\u00100\u001a\u00020!2\u0006\u0010.\u001a\u00020\u001aJ\u0016\u00101\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\nJ\u000e\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u000e\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u0018\u00106\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001a2\b\b\u0002\u00107\u001a\u00020\nJ\u000e\u00108\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001aJ\u000e\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u0010J\u000e\u0010;\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u000e\u0010<\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u000e\u0010=\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001aJ\u000e\u0010>\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001aJ\u0018\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020Aø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u000e\u0010D\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001aJ\u0016\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u001aJ\u001b\u0010I\u001a\u00020J2\u0006\u0010.\u001a\u00020\u001aø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\b\u0010M\u001a\u00020\u001aH\u0016J\u000e\u0010N\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001aJ\b\u0010O\u001a\u00020PH\u0016R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/ui/text/TextLayoutResult;", "", "layoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "multiParagraph", "Landroidx/compose/ui/text/MultiParagraph;", "size", "Landroidx/compose/ui/unit/IntSize;", "(Landroidx/compose/ui/text/TextLayoutInput;Landroidx/compose/ui/text/MultiParagraph;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "didOverflowHeight", "", "getDidOverflowHeight", "()Z", "didOverflowWidth", "getDidOverflowWidth", "firstBaseline", "", "getFirstBaseline", "()F", "hasVisualOverflow", "getHasVisualOverflow", "lastBaseline", "getLastBaseline", "getLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "lineCount", "", "getLineCount", "()I", "getMultiParagraph", "()Landroidx/compose/ui/text/MultiParagraph;", "placeholderRects", "", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "getSize-YbymL2g", "()J", "J", "copy", "copy-O0kMr_c", "(Landroidx/compose/ui/text/TextLayoutInput;J)Landroidx/compose/ui/text/TextLayoutResult;", "equals", "other", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", TypedValues.CycleType.S_WAVE_OFFSET, "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBaseline", "lineIndex", "getLineBottom", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", TtmlNode.START, TtmlNode.END, "getWordBoundary", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "hashCode", "isLineEllipsized", "toString", "", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextLayoutResult {
    public static final int $stable = 8;
    private final float firstBaseline;
    private final float lastBaseline;
    private final TextLayoutInput layoutInput;
    private final MultiParagraph multiParagraph;
    private final List<Rect> placeholderRects;
    private final long size;

    public /* synthetic */ TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLayoutInput, multiParagraph, j);
    }

    private TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j) {
        this.layoutInput = textLayoutInput;
        this.multiParagraph = multiParagraph;
        this.size = j;
        this.firstBaseline = multiParagraph.getFirstBaseline();
        this.lastBaseline = multiParagraph.getLastBaseline();
        this.placeholderRects = multiParagraph.getPlaceholderRects();
    }

    public final TextLayoutInput getLayoutInput() {
        return this.layoutInput;
    }

    public final MultiParagraph getMultiParagraph() {
        return this.multiParagraph;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m6118getSizeYbymL2g() {
        return this.size;
    }

    public final float getFirstBaseline() {
        return this.firstBaseline;
    }

    public final float getLastBaseline() {
        return this.lastBaseline;
    }

    public final boolean getDidOverflowHeight() {
        return this.multiParagraph.getDidExceedMaxLines() || ((float) ((int) (this.size & 4294967295L))) < this.multiParagraph.getHeight();
    }

    public final boolean getDidOverflowWidth() {
        return ((float) ((int) (this.size >> 32))) < this.multiParagraph.getWidth();
    }

    public final boolean getHasVisualOverflow() {
        return getDidOverflowWidth() || getDidOverflowHeight();
    }

    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final int getLineCount() {
        return this.multiParagraph.getLineCount();
    }

    public final int getLineStart(int i) {
        return this.multiParagraph.getLineStart(i);
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResult textLayoutResult, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayoutResult.getLineEnd(i, z);
    }

    public final int getLineEnd(int i, boolean z) {
        return this.multiParagraph.getLineEnd(i, z);
    }

    public final boolean isLineEllipsized(int i) {
        return this.multiParagraph.isLineEllipsized(i);
    }

    public final float getLineTop(int i) {
        return this.multiParagraph.getLineTop(i);
    }

    public final float getLineBaseline(int i) {
        return this.multiParagraph.getLineBaseline(i);
    }

    public final float getLineBottom(int i) {
        return this.multiParagraph.getLineBottom(i);
    }

    public final float getLineLeft(int i) {
        return this.multiParagraph.getLineLeft(i);
    }

    public final float getLineRight(int i) {
        return this.multiParagraph.getLineRight(i);
    }

    public final int getLineForOffset(int i) {
        return this.multiParagraph.getLineForOffset(i);
    }

    public final int getLineForVerticalPosition(float f) {
        return this.multiParagraph.getLineForVerticalPosition(f);
    }

    public final float getHorizontalPosition(int i, boolean z) {
        return this.multiParagraph.getHorizontalPosition(i, z);
    }

    public final ResolvedTextDirection getParagraphDirection(int i) {
        return this.multiParagraph.getParagraphDirection(i);
    }

    public final ResolvedTextDirection getBidiRunDirection(int i) {
        return this.multiParagraph.getBidiRunDirection(i);
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M  reason: not valid java name */
    public final int m6117getOffsetForPositionk4lQ0M(long j) {
        return this.multiParagraph.m5998getOffsetForPositionk4lQ0M(j);
    }

    public final Rect getBoundingBox(int i) {
        return this.multiParagraph.getBoundingBox(i);
    }

    /* renamed from: getWordBoundary--jx7JFs  reason: not valid java name */
    public final long m6119getWordBoundaryjx7JFs(int i) {
        return this.multiParagraph.m6000getWordBoundaryjx7JFs(i);
    }

    public final Rect getCursorRect(int i) {
        return this.multiParagraph.getCursorRect(i);
    }

    public final Path getPathForRange(int i, int i2) {
        return this.multiParagraph.getPathForRange(i, i2);
    }

    /* renamed from: copy-O0kMr_c$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m6115copyO0kMr_c$default(TextLayoutResult textLayoutResult, TextLayoutInput textLayoutInput, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            textLayoutInput = textLayoutResult.layoutInput;
        }
        if ((i & 2) != 0) {
            j = textLayoutResult.size;
        }
        return textLayoutResult.m6116copyO0kMr_c(textLayoutInput, j);
    }

    /* renamed from: copy-O0kMr_c  reason: not valid java name */
    public final TextLayoutResult m6116copyO0kMr_c(TextLayoutInput textLayoutInput, long j) {
        return new TextLayoutResult(textLayoutInput, this.multiParagraph, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextLayoutResult) {
            TextLayoutResult textLayoutResult = (TextLayoutResult) obj;
            return Intrinsics.areEqual(this.layoutInput, textLayoutResult.layoutInput) && Intrinsics.areEqual(this.multiParagraph, textLayoutResult.multiParagraph) && IntSize.m6853equalsimpl0(this.size, textLayoutResult.size) && this.firstBaseline == textLayoutResult.firstBaseline && this.lastBaseline == textLayoutResult.lastBaseline && Intrinsics.areEqual(this.placeholderRects, textLayoutResult.placeholderRects);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.layoutInput.hashCode() * 31) + this.multiParagraph.hashCode()) * 31) + IntSize.m6856hashCodeimpl(this.size)) * 31) + Float.hashCode(this.firstBaseline)) * 31) + Float.hashCode(this.lastBaseline)) * 31) + this.placeholderRects.hashCode();
    }

    public String toString() {
        return "TextLayoutResult(layoutInput=" + this.layoutInput + ", multiParagraph=" + this.multiParagraph + ", size=" + ((Object) IntSize.m6858toStringimpl(this.size)) + ", firstBaseline=" + this.firstBaseline + ", lastBaseline=" + this.lastBaseline + ", placeholderRects=" + this.placeholderRects + ')';
    }
}
