package androidx.compose.ui.text;

import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary_androidKt;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: AndroidParagraph.android.kt */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001Bi\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016B%\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0019JT\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\r2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010U\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0002J,\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\b\b\u0001\u0010\\\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u0010\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\rH\u0016J\u0010\u0010b\u001a\u00020>2\u0006\u0010a\u001a\u00020\rH\u0016J\u0010\u0010c\u001a\u00020>2\u0006\u0010a\u001a\u00020\rH\u0016J\u0018\u0010d\u001a\u00020(2\u0006\u0010a\u001a\u00020\r2\u0006\u0010e\u001a\u00020$H\u0016J\u0015\u0010f\u001a\u00020(2\u0006\u0010g\u001a\u00020\rH\u0000¢\u0006\u0002\bhJ\u0010\u0010i\u001a\u00020(2\u0006\u0010g\u001a\u00020\rH\u0016J\u0010\u0010j\u001a\u00020(2\u0006\u0010g\u001a\u00020\rH\u0016J\u0015\u0010k\u001a\u00020(2\u0006\u0010g\u001a\u00020\rH\u0000¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0000¢\u0006\u0002\bnJ\u0015\u0010o\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0000¢\u0006\u0002\bpJ\u0018\u0010q\u001a\u00020\r2\u0006\u0010g\u001a\u00020\r2\u0006\u0010r\u001a\u00020$H\u0016J\u0010\u0010s\u001a\u00020\r2\u0006\u0010a\u001a\u00020\rH\u0016J\u0010\u0010t\u001a\u00020\r2\u0006\u0010u\u001a\u00020(H\u0016J\u0010\u0010v\u001a\u00020(2\u0006\u0010g\u001a\u00020\rH\u0016J\u0010\u0010w\u001a\u00020(2\u0006\u0010g\u001a\u00020\rH\u0016J\u0010\u0010x\u001a\u00020(2\u0006\u0010g\u001a\u00020\rH\u0016J\u0010\u0010y\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rH\u0016J\u0010\u0010z\u001a\u00020(2\u0006\u0010g\u001a\u00020\rH\u0016J\u0010\u0010{\u001a\u00020(2\u0006\u0010g\u001a\u00020\rH\u0016J\u001b\u0010|\u001a\u00020\r2\u0006\u0010}\u001a\u00020~H\u0016ø\u0001\u0000¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0011\u0010\u0081\u0001\u001a\u00020`2\u0006\u0010a\u001a\u00020\rH\u0016J\u001c\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020\r2\u0007\u0010\u0085\u0001\u001a\u00020\rH\u0016J2\u0010\u0086\u0001\u001a\u00020Y2\u0007\u0010\u0087\u0001\u001a\u00020>2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J \u0010\u008e\u0001\u001a\u00020Y2\u0006\u0010a\u001a\u00020\rH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u00020$2\u0006\u0010g\u001a\u00020\rH\u0016J\u0013\u0010\u0092\u0001\u001a\u00020W2\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0002J`\u0010\u0092\u0001\u001a\u00020W2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020(2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010¡\u0001JA\u0010\u0092\u0001\u001a\u00020W2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b¤\u0001\u0010¥\u0001JW\u0010\u0092\u0001\u001a\u00020W2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u00012\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u001d\u0010¨\u0001\u001a\f\u0012\u0005\u0012\u00030ª\u0001\u0018\u00010©\u0001*\u000200H\u0002¢\u0006\u0003\u0010«\u0001J\u001c\u0010¬\u0001\u001a\u00020$*\u00030\u00ad\u00012\f\u0010®\u0001\u001a\u0007\u0012\u0002\b\u00030¯\u0001H\u0002R\u001c\u0010\u001a\u001a\u00020\u001b8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010*R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0014\u00107\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010*R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010:\u001a\u0004\b9\u00103R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020B8@X\u0081\u0004¢\u0006\f\u0012\u0004\bC\u0010\u001d\u001a\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020G8@X\u0081\u0004¢\u0006\f\u0012\u0004\bH\u0010\u001d\u001a\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010*\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006°\u0001"}, d2 = {"Landroidx/compose/ui/text/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IIJLandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "charSequence", "", "getCharSequence$ui_text_release$annotations", "()V", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getConstraints-msEJaDk", "()J", "J", "didExceedMaxLines", "", "getDidExceedMaxLines", "()Z", "firstBaseline", "", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", TtmlNode.TAG_LAYOUT, "Landroidx/compose/ui/text/android/TextLayout;", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getOverflow-gIe3tQ8", "I", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "textLocale", "Ljava/util/Locale;", "getTextLocale$ui_text_release$annotations", "getTextLocale$ui_text_release", "()Ljava/util/Locale;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release$annotations", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "width", "getWidth", "constructTextLayout", "alignment", "justificationMode", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "hyphens", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", TypedValues.CycleType.S_WAVE_OFFSET, "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineAscent", "lineIndex", "getLineAscent$ui_text_release", "getLineBaseline", "getLineBottom", "getLineDescent", "getLineDescent$ui_text_release", "getLineEllipsisCount", "getLineEllipsisCount$ui_text_release", "getLineEllipsisOffset", "getLineEllipsisOffset$ui_text_release", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", TtmlNode.START, TtmlNode.END, "getRangeForRect", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "getShaderBrushSpans", "", "Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "hasSpan", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidParagraph implements Paragraph {
    public static final int $stable = 8;
    private final CharSequence charSequence;
    private final long constraints;
    private final TextLayout layout;
    private final int maxLines;
    private final int overflow;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List<Rect> placeholderRects;

    /* compiled from: AndroidParagraph.android.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            try {
                iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, int i2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i, i2, j);
    }

    public /* synthetic */ AndroidParagraph(String str, TextStyle textStyle, List list, List list2, int i, int i2, long j, FontFamily.Resolver resolver, Density density, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, list, list2, i, i2, j, resolver, density);
    }

    public static /* synthetic */ void getCharSequence$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextLocale$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextPaint$ui_text_release$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0206  */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.text.Spanned] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, int i2, long j) {
        CharSequence charSequence$ui_text_release;
        TextStyle textStyle;
        int i3;
        int i4;
        int i5;
        TextUtils.TruncateAt truncateAt;
        TextLayout constructTextLayout$default;
        int i6;
        ?? r15;
        AndroidParagraph androidParagraph;
        int i7;
        ShaderBrushSpan[] shaderBrushSpans;
        CharSequence charSequence;
        ArrayList arrayList;
        Rect rect;
        float horizontalPosition;
        float lineBaseline;
        int heightPx;
        float lineTop;
        float f;
        float lineBaseline2;
        this.paragraphIntrinsics = androidParagraphIntrinsics;
        this.maxLines = i;
        this.overflow = i2;
        this.constraints = j;
        if ((Constraints.m6638getMinHeightimpl(j) == 0 && Constraints.m6639getMinWidthimpl(j) == 0) == false) {
            InlineClassHelperKt.throwIllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        if ((i >= 1) == false) {
            InlineClassHelperKt.throwIllegalArgumentException("maxLines should be greater than 0");
        }
        TextStyle style = androidParagraphIntrinsics.getStyle();
        if (AndroidParagraph_androidKt.access$shouldAttachIndentationFixSpan(style, TextOverflow.m6610equalsimpl0(i2, TextOverflow.Companion.m6620getEllipsisgIe3tQ8()))) {
            charSequence$ui_text_release = AndroidParagraph_androidKt.access$attachIndentationFixSpan(androidParagraphIntrinsics.getCharSequence$ui_text_release());
        } else {
            charSequence$ui_text_release = androidParagraphIntrinsics.getCharSequence$ui_text_release();
        }
        this.charSequence = charSequence$ui_text_release;
        int m5964access$toLayoutAlignaXe7zB0 = AndroidParagraph_androidKt.m5964access$toLayoutAlignaXe7zB0(style.m6188getTextAligne0LSkKk());
        boolean m6564equalsimpl0 = TextAlign.m6564equalsimpl0(style.m6188getTextAligne0LSkKk(), TextAlign.Companion.m6570getJustifye0LSkKk());
        int m5966access$toLayoutHyphenationFrequency3fSNIE = AndroidParagraph_androidKt.m5966access$toLayoutHyphenationFrequency3fSNIE(style.getParagraphStyle$ui_text_release().m6037getHyphensvmbZdU8());
        int m5965access$toLayoutBreakStrategyxImikfE = AndroidParagraph_androidKt.m5965access$toLayoutBreakStrategyxImikfE(LineBreak.m6476getStrategyfcGXIks(style.m6185getLineBreakrAG3T2k()));
        int m5967access$toLayoutLineBreakStylehpcqdu8 = AndroidParagraph_androidKt.m5967access$toLayoutLineBreakStylehpcqdu8(LineBreak.m6477getStrictnessusljTpc(style.m6185getLineBreakrAG3T2k()));
        int m5968access$toLayoutLineBreakWordStylewPN0Rpw = AndroidParagraph_androidKt.m5968access$toLayoutLineBreakWordStylewPN0Rpw(LineBreak.m6478getWordBreakjp8hJ3c(style.m6185getLineBreakrAG3T2k()));
        if (TextOverflow.m6610equalsimpl0(i2, TextOverflow.Companion.m6620getEllipsisgIe3tQ8())) {
            truncateAt = TextUtils.TruncateAt.END;
        } else if (TextOverflow.m6610equalsimpl0(i2, TextOverflow.Companion.m6621getMiddleEllipsisgIe3tQ8())) {
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        } else if (!TextOverflow.m6610equalsimpl0(i2, TextOverflow.Companion.m6622getStartEllipsisgIe3tQ8())) {
            textStyle = style;
            i3 = m6564equalsimpl0 ? 1 : 0;
            i4 = m5965access$toLayoutBreakStrategyxImikfE;
            i5 = m5968access$toLayoutLineBreakWordStylewPN0Rpw;
            truncateAt = null;
            TextUtils.TruncateAt truncateAt2 = truncateAt;
            CharSequence charSequence2 = charSequence$ui_text_release;
            constructTextLayout$default = constructTextLayout$default(this, m5964access$toLayoutAlignaXe7zB0, i3, truncateAt2, i, m5966access$toLayoutHyphenationFrequency3fSNIE, i4, m5967access$toLayoutLineBreakStylehpcqdu8, i5, null, 256, null);
            if (Build.VERSION.SDK_INT < 35 || getTextPaint$ui_text_release().getLetterSpacing() == 0.0f || (!(TextOverflow.m6610equalsimpl0(i2, TextOverflow.Companion.m6622getStartEllipsisgIe3tQ8()) || TextOverflow.m6610equalsimpl0(i2, TextOverflow.Companion.m6621getMiddleEllipsisgIe3tQ8())) || constructTextLayout$default.getLineEllipsisCount(0) <= 0)) {
                i6 = i;
                r15 = 1;
            } else {
                int lineEllipsisOffset = constructTextLayout$default.getLineEllipsisOffset(0);
                r15 = 1;
                i6 = i;
                constructTextLayout$default = constructTextLayout(m5964access$toLayoutAlignaXe7zB0, i3, truncateAt2, i6, m5966access$toLayoutHyphenationFrequency3fSNIE, i4, m5967access$toLayoutLineBreakStylehpcqdu8, i5, TextUtils.concat(charSequence2.subSequence(0, lineEllipsisOffset), "…", charSequence2.subSequence(constructTextLayout$default.getLineEllipsisCount(0) + lineEllipsisOffset, charSequence2.length())));
            }
            if (!TextOverflow.m6610equalsimpl0(i2, TextOverflow.Companion.m6620getEllipsisgIe3tQ8()) && constructTextLayout$default.getHeight() > Constraints.m6636getMaxHeightimpl(j) && i6 > r15) {
                int access$numberOfLinesThatFitMaxHeight = AndroidParagraph_androidKt.access$numberOfLinesThatFitMaxHeight(constructTextLayout$default, Constraints.m6636getMaxHeightimpl(j));
                if (access$numberOfLinesThatFitMaxHeight < 0 || access$numberOfLinesThatFitMaxHeight == i6) {
                    androidParagraph = this;
                    i7 = 2;
                } else {
                    int coerceAtLeast = RangesKt.coerceAtLeast(access$numberOfLinesThatFitMaxHeight, (int) r15);
                    i7 = 2;
                    androidParagraph = this;
                    constructTextLayout$default = constructTextLayout$default(androidParagraph, m5964access$toLayoutAlignaXe7zB0, i3, truncateAt2, coerceAtLeast, m5966access$toLayoutHyphenationFrequency3fSNIE, i4, m5967access$toLayoutLineBreakStylehpcqdu8, i5, null, 256, null);
                }
                androidParagraph.layout = constructTextLayout$default;
            } else {
                androidParagraph = this;
                i7 = 2;
                androidParagraph.layout = constructTextLayout$default;
            }
            androidParagraph.getTextPaint$ui_text_release().m6416setBrush12SF9DM(textStyle.getBrush(), Size.m3897constructorimpl((Float.floatToRawIntBits(androidParagraph.getHeight()) & 4294967295L) | (Float.floatToRawIntBits(androidParagraph.getWidth()) << 32)), textStyle.getAlpha());
            shaderBrushSpans = androidParagraph.getShaderBrushSpans(androidParagraph.layout);
            if (shaderBrushSpans != null) {
                Iterator it = ArrayIteratorKt.iterator(shaderBrushSpans);
                while (it.hasNext()) {
                    ((ShaderBrushSpan) it.next()).m6439setSizeuvyYCjk(Size.m3897constructorimpl((Float.floatToRawIntBits(androidParagraph.getHeight()) & 4294967295L) | (Float.floatToRawIntBits(androidParagraph.getWidth()) << 32)));
                }
            }
            charSequence = androidParagraph.charSequence;
            if (charSequence instanceof Spanned) {
                arrayList = CollectionsKt.emptyList();
            } else {
                ?? r2 = (Spanned) charSequence;
                Object[] spans = r2.getSpans(0, charSequence.length(), PlaceholderSpan.class);
                ArrayList arrayList2 = new ArrayList(spans.length);
                for (Object obj : spans) {
                    PlaceholderSpan placeholderSpan = (PlaceholderSpan) obj;
                    int spanStart = r2.getSpanStart(placeholderSpan);
                    int spanEnd = r2.getSpanEnd(placeholderSpan);
                    int lineForOffset = androidParagraph.layout.getLineForOffset(spanStart);
                    ?? r11 = lineForOffset >= androidParagraph.maxLines ? r15 : false;
                    ?? r13 = (androidParagraph.layout.getLineEllipsisCount(lineForOffset) <= 0 || spanEnd <= androidParagraph.layout.getLineEllipsisOffset(lineForOffset)) ? false : r15;
                    ?? r9 = spanEnd > androidParagraph.layout.getLineEnd(lineForOffset) ? r15 : false;
                    if (r13 == true || r9 == true || r11 == true) {
                        rect = null;
                    } else {
                        int i8 = WhenMappings.$EnumSwitchMapping$0[androidParagraph.getBidiRunDirection(spanStart).ordinal()];
                        if (i8 == r15) {
                            horizontalPosition = androidParagraph.getHorizontalPosition(spanStart, r15);
                        } else if (i8 != i7) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            horizontalPosition = androidParagraph.getHorizontalPosition(spanStart, r15) - placeholderSpan.getWidthPx();
                        }
                        float widthPx = placeholderSpan.getWidthPx() + horizontalPosition;
                        TextLayout textLayout = androidParagraph.layout;
                        switch (placeholderSpan.getVerticalAlign()) {
                            case 0:
                                lineBaseline = textLayout.getLineBaseline(lineForOffset);
                                heightPx = placeholderSpan.getHeightPx();
                                lineTop = lineBaseline - heightPx;
                                break;
                            case 1:
                                lineTop = textLayout.getLineTop(lineForOffset);
                                break;
                            case 2:
                                lineBaseline = textLayout.getLineBottom(lineForOffset);
                                heightPx = placeholderSpan.getHeightPx();
                                lineTop = lineBaseline - heightPx;
                                break;
                            case 3:
                                lineTop = ((textLayout.getLineTop(lineForOffset) + textLayout.getLineBottom(lineForOffset)) - placeholderSpan.getHeightPx()) / i7;
                                break;
                            case 4:
                                f = placeholderSpan.getFontMetrics().ascent;
                                lineBaseline2 = textLayout.getLineBaseline(lineForOffset);
                                lineTop = f + lineBaseline2;
                                break;
                            case 5:
                                lineTop = (placeholderSpan.getFontMetrics().descent + textLayout.getLineBaseline(lineForOffset)) - placeholderSpan.getHeightPx();
                                break;
                            case 6:
                                Paint.FontMetricsInt fontMetrics = placeholderSpan.getFontMetrics();
                                f = ((fontMetrics.ascent + fontMetrics.descent) - placeholderSpan.getHeightPx()) / i7;
                                lineBaseline2 = textLayout.getLineBaseline(lineForOffset);
                                lineTop = f + lineBaseline2;
                                break;
                            default:
                                throw new IllegalStateException("unexpected verticalAlignment");
                        }
                        rect = new Rect(horizontalPosition, lineTop, widthPx, placeholderSpan.getHeightPx() + lineTop);
                    }
                    arrayList2.add(rect);
                }
                arrayList = arrayList2;
            }
            androidParagraph.placeholderRects = arrayList;
        } else {
            truncateAt = TextUtils.TruncateAt.START;
        }
        textStyle = style;
        i3 = m6564equalsimpl0 ? 1 : 0;
        i4 = m5965access$toLayoutBreakStrategyxImikfE;
        i5 = m5968access$toLayoutLineBreakWordStylewPN0Rpw;
        TextUtils.TruncateAt truncateAt22 = truncateAt;
        CharSequence charSequence22 = charSequence$ui_text_release;
        constructTextLayout$default = constructTextLayout$default(this, m5964access$toLayoutAlignaXe7zB0, i3, truncateAt22, i, m5966access$toLayoutHyphenationFrequency3fSNIE, i4, m5967access$toLayoutLineBreakStylehpcqdu8, i5, null, 256, null);
        if (Build.VERSION.SDK_INT < 35) {
        }
        i6 = i;
        r15 = 1;
        if (!TextOverflow.m6610equalsimpl0(i2, TextOverflow.Companion.m6620getEllipsisgIe3tQ8())) {
        }
        androidParagraph = this;
        i7 = 2;
        androidParagraph.layout = constructTextLayout$default;
        androidParagraph.getTextPaint$ui_text_release().m6416setBrush12SF9DM(textStyle.getBrush(), Size.m3897constructorimpl((Float.floatToRawIntBits(androidParagraph.getHeight()) & 4294967295L) | (Float.floatToRawIntBits(androidParagraph.getWidth()) << 32)), textStyle.getAlpha());
        shaderBrushSpans = androidParagraph.getShaderBrushSpans(androidParagraph.layout);
        if (shaderBrushSpans != null) {
        }
        charSequence = androidParagraph.charSequence;
        if (charSequence instanceof Spanned) {
        }
        androidParagraph.placeholderRects = arrayList;
    }

    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    /* renamed from: getOverflow-gIe3tQ8  reason: not valid java name */
    public final int m5958getOverflowgIe3tQ8() {
        return this.overflow;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m5956getConstraintsmsEJaDk() {
        return this.constraints;
    }

    private AndroidParagraph(String str, TextStyle textStyle, List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>> list, List<AnnotatedString.Range<Placeholder>> list2, int i, int i2, long j, FontFamily.Resolver resolver, Density density) {
        this(new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density), i, i2, j, null);
    }

    public final CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getWidth() {
        return Constraints.m6637getMaxWidthimpl(this.constraints);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHeight() {
        return this.layout.getHeight();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getFirstBaseline() {
        return getLineBaseline(0);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLastBaseline() {
        return getLineBaseline(getLineCount() - 1);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    public final Locale getTextLocale$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release().getTextLocale();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForVerticalPosition(float f) {
        return this.layout.getLineForVertical((int) f);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getOffsetForPosition-k-4lQ0M  reason: not valid java name */
    public int mo5957getOffsetForPositionk4lQ0M(long j) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int) Float.intBitsToFloat((int) (4294967295L & j))), Float.intBitsToFloat((int) (j >> 32)));
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getRangeForRect-8-6BmAI  reason: not valid java name */
    public long mo5959getRangeForRect86BmAI(Rect rect, int i, final TextInclusionStrategy textInclusionStrategy) {
        int[] rangeForRect = this.layout.getRangeForRect(RectHelper_androidKt.toAndroidRectF(rect), AndroidParagraph_androidKt.m5969access$toLayoutTextGranularityduNsdkg(i), new Function2<RectF, RectF, Boolean>() { // from class: androidx.compose.ui.text.AndroidParagraph$getRangeForRect$range$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(RectF rectF, RectF rectF2) {
                return Boolean.valueOf(TextInclusionStrategy.this.isIncluded(RectHelper_androidKt.toComposeRect(rectF), RectHelper_androidKt.toComposeRect(rectF2)));
            }
        });
        if (rangeForRect == null) {
            return TextRange.Companion.m6152getZerod9O1mEE();
        }
        return TextRangeKt.TextRange(rangeForRect[0], rangeForRect[1]);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getBoundingBox(int i) {
        boolean z = false;
        if (i >= 0 && i < this.charSequence.length()) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("offset(" + i + ") is out of bounds [0," + this.charSequence.length() + ')');
        }
        RectF boundingBox = this.layout.getBoundingBox(i);
        return new Rect(boundingBox.left, boundingBox.top, boundingBox.right, boundingBox.bottom);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: fillBoundingBoxes-8ffj60Q  reason: not valid java name */
    public void mo5955fillBoundingBoxes8ffj60Q(long j, float[] fArr, int i) {
        this.layout.fillBoundingBoxes(TextRange.m6145getMinimpl(j), TextRange.m6144getMaximpl(j), fArr, i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Path getPathForRange(int i, int i2) {
        if (!(i >= 0 && i <= i2 && i2 <= this.charSequence.length())) {
            InlineClassHelperKt.throwIllegalArgumentException("start(" + i + ") or end(" + i2 + ") is out of range [0.." + this.charSequence.length() + "], or start > end!");
        }
        android.graphics.Path path = new android.graphics.Path();
        this.layout.getSelectionPath(i, i2, path);
        return AndroidPath_androidKt.asComposePath(path);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getCursorRect(int i) {
        if (!(i >= 0 && i <= this.charSequence.length())) {
            InlineClassHelperKt.throwIllegalArgumentException("offset(" + i + ") is out of bounds [0," + this.charSequence.length() + AbstractJsonLexerKt.END_LIST);
        }
        float primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, i, false, 2, null);
        int lineForOffset = this.layout.getLineForOffset(i);
        return new Rect(primaryHorizontal$default, this.layout.getLineTop(lineForOffset), primaryHorizontal$default, this.layout.getLineBottom(lineForOffset));
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getWordBoundary--jx7JFs  reason: not valid java name */
    public long mo5960getWordBoundaryjx7JFs(int i) {
        WordIterator wordIterator = this.layout.getWordIterator();
        return TextRangeKt.TextRange(WordBoundary_androidKt.getWordStart(wordIterator, i), WordBoundary_androidKt.getWordEnd(wordIterator, i));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineLeft(int i) {
        return this.layout.getLineLeft(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineRight(int i) {
        return this.layout.getLineRight(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineTop(int i) {
        return this.layout.getLineTop(i);
    }

    public final float getLineAscent$ui_text_release(int i) {
        return this.layout.getLineAscent(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineBaseline(int i) {
        return this.layout.getLineBaseline(i);
    }

    public final float getLineDescent$ui_text_release(int i) {
        return this.layout.getLineDescent(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineBottom(int i) {
        return this.layout.getLineBottom(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineHeight(int i) {
        return this.layout.getLineHeight(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineWidth(int i) {
        return this.layout.getLineWidth(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineStart(int i) {
        return this.layout.getLineStart(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineEnd(int i, boolean z) {
        if (z) {
            return this.layout.getLineVisibleEnd(i);
        }
        return this.layout.getLineEnd(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean isLineEllipsized(int i) {
        return this.layout.isLineEllipsized(i);
    }

    public final int getLineEllipsisOffset$ui_text_release(int i) {
        return this.layout.getLineEllipsisOffset(i);
    }

    public final int getLineEllipsisCount$ui_text_release(int i) {
        return this.layout.getLineEllipsisCount(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForOffset(int i) {
        return this.layout.getLineForOffset(i);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHorizontalPosition(int i, boolean z) {
        if (z) {
            return TextLayout.getPrimaryHorizontal$default(this.layout, i, false, 2, null);
        }
        return TextLayout.getSecondaryHorizontal$default(this.layout, i, false, 2, null);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getParagraphDirection(int i) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(i)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getBidiRunDirection(int i) {
        return this.layout.isRtlCharAt(i) ? ResolvedTextDirection.Rtl : ResolvedTextDirection.Ltr;
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout textLayout) {
        if (textLayout.getText() instanceof Spanned) {
            CharSequence text = textLayout.getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
            if (hasSpan((Spanned) text, ShaderBrushSpan.class)) {
                CharSequence text2 = textLayout.getText();
                Intrinsics.checkNotNull(text2, "null cannot be cast to non-null type android.text.Spanned");
                return (ShaderBrushSpan[]) ((Spanned) text2).getSpans(0, textLayout.getText().length(), ShaderBrushSpan.class);
            }
            return null;
        }
        return null;
    }

    private final boolean hasSpan(Spanned spanned, Class<?> cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-RPmYEkk  reason: not valid java name */
    public void mo5962paintRPmYEkk(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration) {
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m6418setColor8_81llA(j);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        paint(canvas);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-LG529CI  reason: not valid java name */
    public void mo5961paintLG529CI(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        int m6413getBlendMode0nO6VwU = getTextPaint$ui_text_release().m6413getBlendMode0nO6VwU();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m6418setColor8_81llA(j);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        textPaint$ui_text_release.m6415setBlendModes9anfk8(i);
        paint(canvas);
        getTextPaint$ui_text_release().m6415setBlendModes9anfk8(m6413getBlendMode0nO6VwU);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-hn5TExg  reason: not valid java name */
    public void mo5963painthn5TExg(Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        int m6413getBlendMode0nO6VwU = getTextPaint$ui_text_release().m6413getBlendMode0nO6VwU();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        float width = getWidth();
        float height = getHeight();
        textPaint$ui_text_release.m6416setBrush12SF9DM(brush, Size.m3897constructorimpl((Float.floatToRawIntBits(height) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)), f);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        textPaint$ui_text_release.m6415setBlendModes9anfk8(i);
        paint(canvas);
        getTextPaint$ui_text_release().m6415setBlendModes9anfk8(m6413getBlendMode0nO6VwU);
    }

    private final void paint(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    static /* synthetic */ TextLayout constructTextLayout$default(AndroidParagraph androidParagraph, int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8, Object obj) {
        return androidParagraph.constructTextLayout(i, i2, truncateAt, i3, i4, i5, i6, i7, (i8 & 256) != 0 ? androidParagraph.charSequence : charSequence);
    }

    private final TextLayout constructTextLayout(int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence) {
        float width = getWidth();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        return new TextLayout(charSequence, width, textPaint$ui_text_release, i, truncateAt, this.paragraphIntrinsics.getTextDirectionHeuristic$ui_text_release(), 1.0f, 0.0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, i3, i5, i6, i7, i4, i2, null, null, this.paragraphIntrinsics.getLayoutIntrinsics$ui_text_release(), 196736, null);
    }
}
