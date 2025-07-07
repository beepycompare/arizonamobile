package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: SelectionManager.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u00012\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0001\u001a\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0000\u001a\u001e\u0010\u001a\u001a\u00020\u001b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H 0\u0011\"\u0004\b\u0000\u0010 *\b\u0012\u0004\u0012\u0002H 0\u0011H\u0002\u001a\f\u0010!\u001a\u00020\u0001*\u00020\u0016H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"invertedInfiniteRect", "Landroidx/compose/ui/geometry/Rect;", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/SelectionManager;J)J", "getMagnifierCenter", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getMagnifierCenter-JVtK1S4", "(Landroidx/compose/foundation/text/selection/SelectionManager;JLandroidx/compose/foundation/text/selection/Selection$AnchorInfo;)J", "getSelectedRegionRect", "selectableSubSelectionPairs", "", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/selection/Selectable;", "Landroidx/compose/foundation/text/selection/Selection;", "containerCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "merge", "lhs", "rhs", "containsInclusive", "", TypedValues.CycleType.S_WAVE_OFFSET, "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "firstAndLast", ExifInterface.GPS_DIRECTION_TRUE, "visibleBounds", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionManagerKt {
    private static final Rect invertedInfiniteRect = new Rect(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    /* compiled from: SelectionManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.SelectionStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.Cursor.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Selection merge(Selection selection, Selection selection2) {
        Selection merge;
        return (selection == null || (merge = selection.merge(selection2)) == null) ? selection2 : merge;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> firstAndLast(List<? extends T> list) {
        int size = list.size();
        return (size == 0 || size == 1) ? list : CollectionsKt.listOf(CollectionsKt.first((List<? extends Object>) list), CollectionsKt.last((List<? extends Object>) list));
    }

    public static final Rect getSelectedRegionRect(List<? extends Pair<? extends Selectable, Selection>> list, LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        int[] iArr;
        List<? extends Pair<? extends Selectable, Selection>> list2 = list;
        if (list2.isEmpty()) {
            return invertedInfiniteRect;
        }
        Rect rect = invertedInfiniteRect;
        float component1 = rect.component1();
        float component2 = rect.component2();
        float component3 = rect.component3();
        float component4 = rect.component4();
        int size = list2.size();
        char c = 0;
        int i = 0;
        while (i < size) {
            Pair<? extends Selectable, Selection> pair = list2.get(i);
            Selectable component12 = pair.component1();
            Selection component22 = pair.component2();
            int offset = component22.getStart().getOffset();
            int offset2 = component22.getEnd().getOffset();
            if (offset != offset2 && (layoutCoordinates2 = component12.getLayoutCoordinates()) != null) {
                int min = Math.min(offset, offset2);
                int max = Math.max(offset, offset2) - 1;
                if (min == max) {
                    iArr = new int[1];
                    iArr[c] = min;
                } else {
                    int[] iArr2 = new int[2];
                    iArr2[c] = min;
                    iArr2[1] = max;
                    iArr = iArr2;
                }
                Rect rect2 = invertedInfiniteRect;
                float component13 = rect2.component1();
                float component23 = rect2.component2();
                float component32 = rect2.component3();
                float component42 = rect2.component4();
                int length = iArr.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2;
                    Rect boundingBox = component12.getBoundingBox(iArr[i3]);
                    component13 = Math.min(component13, boundingBox.getLeft());
                    component23 = Math.min(component23, boundingBox.getTop());
                    component32 = Math.max(component32, boundingBox.getRight());
                    component42 = Math.max(component42, boundingBox.getBottom());
                    i2 = i3 + 1;
                }
                long m3829constructorimpl = Offset.m3829constructorimpl((Float.floatToRawIntBits(component13) << 32) | (Float.floatToRawIntBits(component23) & 4294967295L));
                long m3829constructorimpl2 = Offset.m3829constructorimpl((Float.floatToRawIntBits(component42) & 4294967295L) | (Float.floatToRawIntBits(component32) << 32));
                long mo5447localPositionOfR5De75A = layoutCoordinates.mo5447localPositionOfR5De75A(layoutCoordinates2, m3829constructorimpl);
                long mo5447localPositionOfR5De75A2 = layoutCoordinates.mo5447localPositionOfR5De75A(layoutCoordinates2, m3829constructorimpl2);
                component1 = Math.min(component1, Float.intBitsToFloat((int) (mo5447localPositionOfR5De75A >> 32)));
                component2 = Math.min(component2, Float.intBitsToFloat((int) (mo5447localPositionOfR5De75A & 4294967295L)));
                component3 = Math.max(component3, Float.intBitsToFloat((int) (mo5447localPositionOfR5De75A2 >> 32)));
                component4 = Math.max(component4, Float.intBitsToFloat((int) (mo5447localPositionOfR5De75A2 & 4294967295L)));
            }
            i++;
            list2 = list;
            c = 0;
        }
        return new Rect(component1, component2, component3, component4);
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c  reason: not valid java name */
    public static final long m1503calculateSelectionMagnifierCenterAndroidO0kMr_c(SelectionManager selectionManager, long j) {
        Selection selection = selectionManager.getSelection();
        if (selection == null) {
            return Offset.Companion.m3852getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = selectionManager.getDraggingHandle();
        int i = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        throw new IllegalStateException("SelectionContainer does not support cursor".toString());
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return m1505getMagnifierCenterJVtK1S4(selectionManager, j, selection.getEnd());
            }
            return m1505getMagnifierCenterJVtK1S4(selectionManager, j, selection.getStart());
        }
        return Offset.Companion.m3852getUnspecifiedF1C5BW0();
    }

    /* renamed from: getMagnifierCenter-JVtK1S4  reason: not valid java name */
    private static final long m1505getMagnifierCenterJVtK1S4(SelectionManager selectionManager, long j, Selection.AnchorInfo anchorInfo) {
        LayoutCoordinates containerLayoutCoordinates;
        LayoutCoordinates layoutCoordinates;
        int offset;
        float coerceIn;
        Selectable anchorSelectable$foundation_release = selectionManager.getAnchorSelectable$foundation_release(anchorInfo);
        if (anchorSelectable$foundation_release != null && (containerLayoutCoordinates = selectionManager.getContainerLayoutCoordinates()) != null && (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) != null && (offset = anchorInfo.getOffset()) <= anchorSelectable$foundation_release.getLastVisibleOffset()) {
            Offset m1492getCurrentDragPosition_m7T9E = selectionManager.m1492getCurrentDragPosition_m7T9E();
            Intrinsics.checkNotNull(m1492getCurrentDragPosition_m7T9E);
            float intBitsToFloat = Float.intBitsToFloat((int) (layoutCoordinates.mo5447localPositionOfR5De75A(containerLayoutCoordinates, m1492getCurrentDragPosition_m7T9E.m3847unboximpl()) >> 32));
            long mo1454getRangeOfLineContainingjx7JFs = anchorSelectable$foundation_release.mo1454getRangeOfLineContainingjx7JFs(offset);
            if (TextRange.m6141getCollapsedimpl(mo1454getRangeOfLineContainingjx7JFs)) {
                coerceIn = anchorSelectable$foundation_release.getLineLeft(offset);
            } else {
                float lineLeft = anchorSelectable$foundation_release.getLineLeft(TextRange.m6147getStartimpl(mo1454getRangeOfLineContainingjx7JFs));
                float lineRight = anchorSelectable$foundation_release.getLineRight(TextRange.m6142getEndimpl(mo1454getRangeOfLineContainingjx7JFs) - 1);
                coerceIn = RangesKt.coerceIn(intBitsToFloat, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
            }
            if (coerceIn == -1.0f) {
                return Offset.Companion.m3852getUnspecifiedF1C5BW0();
            }
            if (!IntSize.m6853equalsimpl0(j, IntSize.Companion.m6860getZeroYbymL2g()) && Math.abs(intBitsToFloat - coerceIn) > ((int) (j >> 32)) / 2) {
                return Offset.Companion.m3852getUnspecifiedF1C5BW0();
            }
            float centerYForOffset = anchorSelectable$foundation_release.getCenterYForOffset(offset);
            if (centerYForOffset == -1.0f) {
                return Offset.Companion.m3852getUnspecifiedF1C5BW0();
            }
            return containerLayoutCoordinates.mo5447localPositionOfR5De75A(layoutCoordinates, Offset.m3829constructorimpl((Float.floatToRawIntBits(coerceIn) << 32) | (4294967295L & Float.floatToRawIntBits(centerYForOffset))));
        }
        return Offset.Companion.m3852getUnspecifiedF1C5BW0();
    }

    public static final Rect visibleBounds(LayoutCoordinates layoutCoordinates) {
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        return RectKt.m3875Rect0a9Yr6o(layoutCoordinates.mo5455windowToLocalMKHz9U(boundsInWindow.m3872getTopLeftF1C5BW0()), layoutCoordinates.mo5455windowToLocalMKHz9U(boundsInWindow.m3866getBottomRightF1C5BW0()));
    }

    /* renamed from: containsInclusive-Uv8p0NA  reason: not valid java name */
    public static final boolean m1504containsInclusiveUv8p0NA(Rect rect, long j) {
        float left = rect.getLeft();
        float right = rect.getRight();
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        if (left > intBitsToFloat || intBitsToFloat > right) {
            return false;
        }
        float top = rect.getTop();
        float bottom = rect.getBottom();
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return top <= intBitsToFloat2 && intBitsToFloat2 <= bottom;
    }
}
