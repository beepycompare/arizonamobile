package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.Comparator;
import kotlin.Metadata;
/* compiled from: MultiWidgetSelectionDelegate.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\r\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002\u001a6\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\t*\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002\u001a4\u0010 \u001a\u00020\u0001*\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001a0#j\b\u0012\u0004\u0012\u00020\u001a`$2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0001H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetForPosition-3MmeM6k", "(JLandroidx/compose/ui/text/TextLayoutResult;)I", "getXDirection", "Landroidx/compose/foundation/text/selection/Direction;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getXDirection-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/foundation/text/selection/Direction;", "getYDirection", "getYDirection-3MmeM6k", "isSelected", "", "currentDirection", "otherDirection", "appendSelectableInfo", "", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "localPosition", "previousHandlePosition", "selectableId", "", "appendSelectableInfo-Parwq6A", "(Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;Landroidx/compose/ui/text/TextLayoutResult;JJJ)V", "getDirectionById", "anchorSelectableId", "currentSelectableId", "getPreviousAdjustedOffset", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "currentTextLength", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MultiWidgetSelectionDelegateKt {
    /* renamed from: appendSelectableInfo-Parwq6A  reason: not valid java name */
    public static final void m1455appendSelectableInfoParwq6A(SelectionLayoutBuilder selectionLayoutBuilder, TextLayoutResult textLayoutResult, long j, long j2, long j3) {
        Direction direction;
        Direction direction2;
        long j4;
        Direction appendSelectableInfo_Parwq6A$otherDirection;
        Direction direction3;
        Direction direction4;
        Direction direction5;
        Direction direction6;
        int m1456getOffsetForPosition3MmeM6k;
        int previousAdjustedOffset;
        Selection.AnchorInfo start;
        Selection.AnchorInfo end;
        Rect rect = new Rect(0.0f, 0.0f, (int) (textLayoutResult.m6118getSizeYbymL2g() >> 32), (int) (textLayoutResult.m6118getSizeYbymL2g() & 4294967295L));
        Direction m1457getXDirection3MmeM6k = m1457getXDirection3MmeM6k(j, rect);
        Direction m1458getYDirection3MmeM6k = m1458getYDirection3MmeM6k(j, rect);
        if (selectionLayoutBuilder.isStartHandle()) {
            Selection previousSelection = selectionLayoutBuilder.getPreviousSelection();
            direction = m1458getYDirection3MmeM6k;
            direction2 = m1457getXDirection3MmeM6k;
            j4 = j3;
            direction5 = direction2;
            direction4 = appendSelectableInfo_Parwq6A$otherDirection(direction2, direction, selectionLayoutBuilder, j3, previousSelection != null ? previousSelection.getEnd() : null);
            direction3 = direction4;
            direction6 = direction3;
            appendSelectableInfo_Parwq6A$otherDirection = direction;
        } else {
            direction = m1458getYDirection3MmeM6k;
            direction2 = m1457getXDirection3MmeM6k;
            Selection previousSelection2 = selectionLayoutBuilder.getPreviousSelection();
            j4 = j3;
            appendSelectableInfo_Parwq6A$otherDirection = appendSelectableInfo_Parwq6A$otherDirection(direction2, direction, selectionLayoutBuilder, j4, previousSelection2 != null ? previousSelection2.getStart() : null);
            direction3 = direction2;
            direction4 = direction;
            direction5 = appendSelectableInfo_Parwq6A$otherDirection;
            direction6 = direction5;
        }
        if (isSelected(SelectionLayoutKt.resolve2dDirection(direction2, direction), direction6)) {
            int length = textLayoutResult.getLayoutInput().getText().length();
            if (selectionLayoutBuilder.isStartHandle()) {
                previousAdjustedOffset = m1456getOffsetForPosition3MmeM6k(j, textLayoutResult);
                Selection previousSelection3 = selectionLayoutBuilder.getPreviousSelection();
                m1456getOffsetForPosition3MmeM6k = (previousSelection3 == null || (end = previousSelection3.getEnd()) == null) ? previousAdjustedOffset : getPreviousAdjustedOffset(end, selectionLayoutBuilder.getSelectableIdOrderingComparator(), j4, length);
            } else {
                m1456getOffsetForPosition3MmeM6k = m1456getOffsetForPosition3MmeM6k(j, textLayoutResult);
                Selection previousSelection4 = selectionLayoutBuilder.getPreviousSelection();
                previousAdjustedOffset = (previousSelection4 == null || (start = previousSelection4.getStart()) == null) ? m1456getOffsetForPosition3MmeM6k : getPreviousAdjustedOffset(start, selectionLayoutBuilder.getSelectableIdOrderingComparator(), j4, length);
            }
            selectionLayoutBuilder.appendInfo(j4, previousAdjustedOffset, direction5, appendSelectableInfo_Parwq6A$otherDirection, m1456getOffsetForPosition3MmeM6k, direction3, direction4, (9223372034707292159L & j2) == InlineClassHelperKt.UnspecifiedPackedFloats ? -1 : m1456getOffsetForPosition3MmeM6k(j2, textLayoutResult), textLayoutResult);
        }
    }

    private static final Direction appendSelectableInfo_Parwq6A$otherDirection(Direction direction, Direction direction2, SelectionLayoutBuilder selectionLayoutBuilder, long j, Selection.AnchorInfo anchorInfo) {
        Direction directionById;
        return (anchorInfo == null || (directionById = getDirectionById(selectionLayoutBuilder, anchorInfo.getSelectableId(), j)) == null) ? SelectionLayoutKt.resolve2dDirection(direction, direction2) : directionById;
    }

    private static final int getPreviousAdjustedOffset(Selection.AnchorInfo anchorInfo, Comparator<Long> comparator, long j, int i) {
        int compare = comparator.compare(Long.valueOf(anchorInfo.getSelectableId()), Long.valueOf(j));
        if (compare < 0) {
            return 0;
        }
        return compare > 0 ? i : anchorInfo.getOffset();
    }

    private static final Direction getDirectionById(SelectionLayoutBuilder selectionLayoutBuilder, long j, long j2) {
        int compare = selectionLayoutBuilder.getSelectableIdOrderingComparator().compare(Long.valueOf(j), Long.valueOf(j2));
        if (compare < 0) {
            return Direction.BEFORE;
        }
        if (compare > 0) {
            return Direction.AFTER;
        }
        return Direction.ON;
    }

    private static final boolean isSelected(Direction direction, Direction direction2) {
        return direction == Direction.ON || direction != direction2;
    }

    /* renamed from: getXDirection-3MmeM6k  reason: not valid java name */
    private static final Direction m1457getXDirection3MmeM6k(long j, Rect rect) {
        int i = (int) (j >> 32);
        return Float.intBitsToFloat(i) < rect.getLeft() ? Direction.BEFORE : Float.intBitsToFloat(i) > rect.getRight() ? Direction.AFTER : Direction.ON;
    }

    /* renamed from: getYDirection-3MmeM6k  reason: not valid java name */
    private static final Direction m1458getYDirection3MmeM6k(long j, Rect rect) {
        int i = (int) (j & 4294967295L);
        return Float.intBitsToFloat(i) < rect.getTop() ? Direction.BEFORE : Float.intBitsToFloat(i) > rect.getBottom() ? Direction.AFTER : Direction.ON;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k  reason: not valid java name */
    private static final int m1456getOffsetForPosition3MmeM6k(long j, TextLayoutResult textLayoutResult) {
        int i = (int) (4294967295L & j);
        if (Float.intBitsToFloat(i) <= 0.0f) {
            return 0;
        }
        if (Float.intBitsToFloat(i) >= textLayoutResult.getMultiParagraph().getHeight()) {
            return textLayoutResult.getLayoutInput().getText().length();
        }
        return textLayoutResult.m6117getOffsetForPositionk4lQ0M(j);
    }
}
