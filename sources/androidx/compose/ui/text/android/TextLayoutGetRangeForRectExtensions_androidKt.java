package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.Layout;
import androidx.compose.ui.text.android.LayoutHelper;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.android.selection.SegmentFinder_androidKt;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
/* compiled from: TextLayoutGetRangeForRectExtensions.android.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001af\u0010\b\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001aH\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00032\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0000\u001af\u0010\u001d\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001aV\u0010\u001e\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010 \u001a\u00020\u0014H\u0002\u001a\u001c\u0010!\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0002¨\u0006$"}, d2 = {"getCharacterLeftBounds", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "lineStart", "horizontalBounds", "", "getCharacterRightBounds", "getEndOffsetForRectWithinRun", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "rect", "Landroid/graphics/RectF;", "lineTop", "lineBottom", "runLeft", "runRight", "segmentFinder", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "inclusionStrategy", "Lkotlin/Function2;", "", "getRangeForRect", "", "Landroidx/compose/ui/text/android/TextLayout;", TtmlNode.TAG_LAYOUT, "Landroid/text/Layout;", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "granularity", "getStartOffsetForRectWithinRun", "getStartOrEndOffsetForRectWithinLine", "lineIndex", "getStart", "horizontalOverlap", TtmlNode.LEFT, TtmlNode.RIGHT, "ui-text_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextLayoutGetRangeForRectExtensions_androidKt {
    public static final int[] getRangeForRect(TextLayout textLayout, Layout layout, LayoutHelper layoutHelper, RectF rectF, int i, Function2<? super RectF, ? super RectF, Boolean> function2) {
        WordSegmentFinder createGraphemeClusterSegmentFinder;
        int i2;
        if (i == 1) {
            createGraphemeClusterSegmentFinder = new WordSegmentFinder(textLayout.getText(), textLayout.getWordIterator());
        } else {
            createGraphemeClusterSegmentFinder = SegmentFinder_androidKt.createGraphemeClusterSegmentFinder(textLayout.getText(), textLayout.getTextPaint());
        }
        SegmentFinder segmentFinder = createGraphemeClusterSegmentFinder;
        int lineForVertical = layout.getLineForVertical((int) rectF.top);
        if (rectF.top <= textLayout.getLineBottom(lineForVertical) || (lineForVertical = lineForVertical + 1) < textLayout.getLineCount()) {
            int i3 = lineForVertical;
            int lineForVertical2 = layout.getLineForVertical((int) rectF.bottom);
            if (lineForVertical2 != 0 || rectF.bottom >= textLayout.getLineTop(0)) {
                int startOrEndOffsetForRectWithinLine = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i3, rectF, segmentFinder, function2, true);
                while (true) {
                    i2 = i3;
                    if (startOrEndOffsetForRectWithinLine != -1 || i2 >= lineForVertical2) {
                        break;
                    }
                    i3 = i2 + 1;
                    startOrEndOffsetForRectWithinLine = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i3, rectF, segmentFinder, function2, true);
                }
                if (startOrEndOffsetForRectWithinLine == -1) {
                    return null;
                }
                int startOrEndOffsetForRectWithinLine2 = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, lineForVertical2, rectF, segmentFinder, function2, false);
                while (startOrEndOffsetForRectWithinLine2 == -1 && i2 < lineForVertical2) {
                    int i4 = lineForVertical2 - 1;
                    startOrEndOffsetForRectWithinLine2 = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i4, rectF, segmentFinder, function2, false);
                    lineForVertical2 = i4;
                }
                if (startOrEndOffsetForRectWithinLine2 == -1) {
                    return null;
                }
                return new int[]{segmentFinder.previousStartBoundary(startOrEndOffsetForRectWithinLine + 1), segmentFinder.nextEndBoundary(startOrEndOffsetForRectWithinLine2 - 1)};
            }
            return null;
        }
        return null;
    }

    private static final int getStartOrEndOffsetForRectWithinLine(TextLayout textLayout, Layout layout, LayoutHelper layoutHelper, int i, RectF rectF, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2, boolean z) {
        IntRange downTo;
        float characterLeftBounds;
        float characterRightBounds;
        int endOffsetForRectWithinRun;
        int lineTop = layout.getLineTop(i);
        int lineBottom = layout.getLineBottom(i);
        int lineStart = layout.getLineStart(i);
        int lineEnd = layout.getLineEnd(i);
        if (lineStart == lineEnd) {
            return -1;
        }
        float[] fArr = new float[(lineEnd - lineStart) * 2];
        textLayout.fillLineHorizontalBounds$ui_text_release(i, fArr);
        LayoutHelper.BidiRun[] lineBidiRuns$ui_text_release = layoutHelper.getLineBidiRuns$ui_text_release(i);
        if (z) {
            downTo = ArraysKt.getIndices(lineBidiRuns$ui_text_release);
        } else {
            downTo = RangesKt.downTo(ArraysKt.getLastIndex(lineBidiRuns$ui_text_release), 0);
        }
        int first = downTo.getFirst();
        int last = downTo.getLast();
        int step = downTo.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            int i2 = first;
            while (true) {
                LayoutHelper.BidiRun bidiRun = lineBidiRuns$ui_text_release[i2];
                if (bidiRun.isRtl()) {
                    characterLeftBounds = getCharacterLeftBounds(bidiRun.getEnd() - 1, lineStart, fArr);
                } else {
                    characterLeftBounds = getCharacterLeftBounds(bidiRun.getStart(), lineStart, fArr);
                }
                float f = characterLeftBounds;
                if (bidiRun.isRtl()) {
                    characterRightBounds = getCharacterRightBounds(bidiRun.getStart(), lineStart, fArr);
                } else {
                    characterRightBounds = getCharacterRightBounds(bidiRun.getEnd() - 1, lineStart, fArr);
                }
                float f2 = characterRightBounds;
                if (z) {
                    endOffsetForRectWithinRun = getStartOffsetForRectWithinRun(bidiRun, rectF, lineStart, lineTop, lineBottom, f, f2, fArr, segmentFinder, function2);
                } else {
                    endOffsetForRectWithinRun = getEndOffsetForRectWithinRun(bidiRun, rectF, lineStart, lineTop, lineBottom, f, f2, fArr, segmentFinder, function2);
                }
                if (endOffsetForRectWithinRun < 0) {
                    if (i2 == last) {
                        break;
                    }
                    i2 += step;
                } else {
                    return endOffsetForRectWithinRun;
                }
            }
        }
        return -1;
    }

    private static final int getStartOffsetForRectWithinRun(LayoutHelper.BidiRun bidiRun, RectF rectF, int i, int i2, int i3, float f, float f2, float[] fArr, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2) {
        int start;
        int previousStartBoundary;
        float characterLeftBounds;
        float characterRightBounds;
        if (horizontalOverlap(rectF, f, f2)) {
            if ((!bidiRun.isRtl() && rectF.left <= f) || (bidiRun.isRtl() && rectF.right >= f2)) {
                start = bidiRun.getStart();
            } else {
                start = bidiRun.getStart();
                int end = bidiRun.getEnd();
                while (end - start > 1) {
                    int i4 = (end + start) / 2;
                    float characterLeftBounds2 = getCharacterLeftBounds(i4, i, fArr);
                    if ((bidiRun.isRtl() || characterLeftBounds2 <= rectF.left) && (!bidiRun.isRtl() || characterLeftBounds2 >= rectF.right)) {
                        start = i4;
                    } else {
                        end = i4;
                    }
                }
                if (bidiRun.isRtl()) {
                    start = end;
                }
            }
            int nextEndBoundary = segmentFinder.nextEndBoundary(start);
            if (nextEndBoundary != -1 && (previousStartBoundary = segmentFinder.previousStartBoundary(nextEndBoundary)) < bidiRun.getEnd()) {
                int coerceAtLeast = RangesKt.coerceAtLeast(previousStartBoundary, bidiRun.getStart());
                int coerceAtMost = RangesKt.coerceAtMost(nextEndBoundary, bidiRun.getEnd());
                RectF rectF2 = new RectF(0.0f, i2, 0.0f, i3);
                while (true) {
                    if (bidiRun.isRtl()) {
                        characterLeftBounds = getCharacterLeftBounds(coerceAtMost - 1, i, fArr);
                    } else {
                        characterLeftBounds = getCharacterLeftBounds(coerceAtLeast, i, fArr);
                    }
                    rectF2.left = characterLeftBounds;
                    if (bidiRun.isRtl()) {
                        characterRightBounds = getCharacterRightBounds(coerceAtLeast, i, fArr);
                    } else {
                        characterRightBounds = getCharacterRightBounds(coerceAtMost - 1, i, fArr);
                    }
                    rectF2.right = characterRightBounds;
                    if (function2.invoke(rectF2, rectF).booleanValue()) {
                        return coerceAtLeast;
                    }
                    coerceAtLeast = segmentFinder.nextStartBoundary(coerceAtLeast);
                    if (coerceAtLeast == -1 || coerceAtLeast >= bidiRun.getEnd()) {
                        break;
                    }
                    coerceAtMost = RangesKt.coerceAtMost(segmentFinder.nextEndBoundary(coerceAtLeast), bidiRun.getEnd());
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d6, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int getEndOffsetForRectWithinRun(LayoutHelper.BidiRun bidiRun, RectF rectF, int i, int i2, int i3, float f, float f2, float[] fArr, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2) {
        int start;
        int nextEndBoundary;
        float characterLeftBounds;
        float characterRightBounds;
        if (!horizontalOverlap(rectF, f, f2)) {
            return -1;
        }
        if ((!bidiRun.isRtl() && rectF.right >= f2) || (bidiRun.isRtl() && rectF.left <= f)) {
            start = bidiRun.getEnd() - 1;
        } else {
            start = bidiRun.getStart();
            int end = bidiRun.getEnd();
            while (end - start > 1) {
                int i4 = (end + start) / 2;
                float characterLeftBounds2 = getCharacterLeftBounds(i4, i, fArr);
                if ((bidiRun.isRtl() || characterLeftBounds2 <= rectF.right) && (!bidiRun.isRtl() || characterLeftBounds2 >= rectF.left)) {
                    start = i4;
                } else {
                    end = i4;
                }
            }
            if (bidiRun.isRtl()) {
                start = end;
            }
        }
        int previousStartBoundary = segmentFinder.previousStartBoundary(start + 1);
        if (previousStartBoundary == -1 || (nextEndBoundary = segmentFinder.nextEndBoundary(previousStartBoundary)) <= bidiRun.getStart()) {
            return -1;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(previousStartBoundary, bidiRun.getStart());
        int coerceAtMost = RangesKt.coerceAtMost(nextEndBoundary, bidiRun.getEnd());
        RectF rectF2 = new RectF(0.0f, i2, 0.0f, i3);
        while (true) {
            if (bidiRun.isRtl()) {
                characterLeftBounds = getCharacterLeftBounds(coerceAtMost - 1, i, fArr);
            } else {
                characterLeftBounds = getCharacterLeftBounds(coerceAtLeast, i, fArr);
            }
            rectF2.left = characterLeftBounds;
            if (bidiRun.isRtl()) {
                characterRightBounds = getCharacterRightBounds(coerceAtLeast, i, fArr);
            } else {
                characterRightBounds = getCharacterRightBounds(coerceAtMost - 1, i, fArr);
            }
            rectF2.right = characterRightBounds;
            if (function2.invoke(rectF2, rectF).booleanValue()) {
                return coerceAtMost;
            }
            coerceAtMost = segmentFinder.previousEndBoundary(coerceAtMost);
            if (coerceAtMost == -1 || coerceAtMost <= bidiRun.getStart()) {
                break;
            }
            coerceAtLeast = RangesKt.coerceAtLeast(segmentFinder.previousStartBoundary(coerceAtMost), bidiRun.getStart());
        }
    }

    private static final float getCharacterLeftBounds(int i, int i2, float[] fArr) {
        return fArr[(i - i2) * 2];
    }

    private static final float getCharacterRightBounds(int i, int i2, float[] fArr) {
        return fArr[((i - i2) * 2) + 1];
    }

    private static final boolean horizontalOverlap(RectF rectF, float f, float f2) {
        return f2 >= rectF.left && f <= rectF.right;
    }
}
