package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
/* compiled from: Paragraph.android.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J,\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u000fH&ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000fH&J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u000fH&J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u000fH&J\u0018\u0010+\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u0003H&J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u001a\u00100\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u0003H&J\u0010\u00102\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fH&J\u0010\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u0007H&J\u0010\u00105\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u00106\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u00107\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u00108\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u00109\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u0010:\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u001a\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=H&ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000fH&J\u0018\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fH&J*\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH&ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001d\u0010M\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000fH&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u000fH&JZ\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020\u00072\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\b\b\u0002\u0010]\u001a\u00020^H&ø\u0001\u0000¢\u0006\u0004\b_\u0010`J<\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020S2\b\b\u0002\u0010a\u001a\u00020b2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010ZH&ø\u0001\u0000¢\u0006\u0004\bc\u0010dJR\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020S2\b\b\u0002\u0010a\u001a\u00020b2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010Z2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\b\b\u0002\u0010]\u001a\u00020^H&ø\u0001\u0000¢\u0006\u0004\be\u0010fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0012\u0010\u0014\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\t\u0082\u0001\u0001gø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006hÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/text/Paragraph;", "", "didExceedMaxLines", "", "getDidExceedMaxLines", "()Z", "firstBaseline", "", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", "lineCount", "", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "minIntrinsicWidth", "getMinIntrinsicWidth", "placeholderRects", "", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "width", "getWidth", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", TypedValues.CycleType.S_WAVE_OFFSET, "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBaseline", "lineIndex", "getLineBottom", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", TtmlNode.START, TtmlNode.END, "getRangeForRect", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "Landroidx/compose/ui/text/AndroidParagraph;", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Paragraph {
    /* renamed from: fillBoundingBoxes-8ffj60Q */
    void mo5955fillBoundingBoxes8ffj60Q(long j, float[] fArr, int i);

    ResolvedTextDirection getBidiRunDirection(int i);

    Rect getBoundingBox(int i);

    Rect getCursorRect(int i);

    boolean getDidExceedMaxLines();

    float getFirstBaseline();

    float getHeight();

    float getHorizontalPosition(int i, boolean z);

    float getLastBaseline();

    float getLineBaseline(int i);

    float getLineBottom(int i);

    int getLineCount();

    int getLineEnd(int i, boolean z);

    int getLineForOffset(int i);

    int getLineForVerticalPosition(float f);

    float getLineHeight(int i);

    float getLineLeft(int i);

    float getLineRight(int i);

    int getLineStart(int i);

    float getLineTop(int i);

    float getLineWidth(int i);

    float getMaxIntrinsicWidth();

    float getMinIntrinsicWidth();

    /* renamed from: getOffsetForPosition-k-4lQ0M */
    int mo5957getOffsetForPositionk4lQ0M(long j);

    ResolvedTextDirection getParagraphDirection(int i);

    Path getPathForRange(int i, int i2);

    List<Rect> getPlaceholderRects();

    /* renamed from: getRangeForRect-8-6BmAI */
    long mo5959getRangeForRect86BmAI(Rect rect, int i, TextInclusionStrategy textInclusionStrategy);

    float getWidth();

    /* renamed from: getWordBoundary--jx7JFs */
    long mo5960getWordBoundaryjx7JFs(int i);

    boolean isLineEllipsized(int i);

    /* renamed from: paint-LG529CI */
    void mo5961paintLG529CI(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i);

    /* renamed from: paint-RPmYEkk */
    void mo5962paintRPmYEkk(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration);

    /* renamed from: paint-hn5TExg */
    void mo5963painthn5TExg(Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i);

    /* compiled from: Paragraph.android.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ int getLineEnd$default(Paragraph paragraph, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return paragraph.getLineEnd(i, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEnd");
    }

    /* renamed from: paint-LG529CI$default  reason: not valid java name */
    static /* synthetic */ void m6005paintLG529CI$default(Paragraph paragraph, Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-LG529CI");
        }
        paragraph.mo5961paintLG529CI(canvas, (i2 & 2) != 0 ? Color.Companion.m4114getUnspecified0d7_KjU() : j, (i2 & 4) != 0 ? null : shadow, (i2 & 8) != 0 ? null : textDecoration, (i2 & 16) == 0 ? drawStyle : null, (i2 & 32) != 0 ? DrawScope.Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: paint-RPmYEkk$default  reason: not valid java name */
    static /* synthetic */ void m6006paintRPmYEkk$default(Paragraph paragraph, Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-RPmYEkk");
        }
        if ((i & 2) != 0) {
            j = Color.Companion.m4114getUnspecified0d7_KjU();
        }
        paragraph.mo5962paintRPmYEkk(canvas, j, (i & 4) != 0 ? null : shadow, (i & 8) != 0 ? null : textDecoration);
    }

    /* renamed from: paint-hn5TExg$default  reason: not valid java name */
    static /* synthetic */ void m6007painthn5TExg$default(Paragraph paragraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-hn5TExg");
        }
        if ((i2 & 4) != 0) {
            f = Float.NaN;
        }
        paragraph.mo5963painthn5TExg(canvas, brush, f, (i2 & 8) != 0 ? null : shadow, (i2 & 16) != 0 ? null : textDecoration, (i2 & 32) != 0 ? null : drawStyle, (i2 & 64) != 0 ? DrawScope.Companion.m4642getDefaultBlendMode0nO6VwU() : i);
    }
}
