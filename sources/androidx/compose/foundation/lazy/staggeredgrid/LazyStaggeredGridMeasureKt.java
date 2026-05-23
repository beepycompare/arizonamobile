package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0002¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0082\b\u001a£\u0001\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102\u001a,\u00103\u001a\u00020\u0015*\u0002042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0001H\u0002\u001aK\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010@\u001aG\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0019*\u0002042\u0006\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00012\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110EH\u0082\b\u001aR\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u00072!\u0010G\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010K\u001a\u00020\u0001H\u0082\b\u001a7\u0010L\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00192\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b\u001a(\u0010O\u001a\u00020\u0011*\u00020P2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b¢\u0006\u0004\bQ\u0010R\u001a\u0014\u0010S\u001a\u00020\u0011*\u0002072\u0006\u0010T\u001a\u00020\u001aH\u0002\u001a\u001b\u0010U\u001a\u00020\u001a*\u0002072\u0006\u0010V\u001a\u00020PH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0016\u0010Y\u001a\u00020\u001a*\u0002072\b\b\u0002\u0010Z\u001a\u00020\u001aH\u0000\u001a2\u0010[\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b¢\u0006\u0002\u0010\\\u001a\f\u0010]\u001a\u00020\u001a*\u000207H\u0002\u001a!\u0010^\u001a\u000207*\u0002072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b\u001a\u001c\u0010_\u001a\u00020\u0011*\u0002042\u0006\u0010`\u001a\u0002072\u0006\u0010a\u001a\u00020\u001aH\u0002\u001a\u001c\u0010b\u001a\u00020\u001a*\u0002042\u0006\u0010c\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"DebugLoggingEnabled", "", "withDebugLogging", ExifInterface.GPS_DIRECTION_TRUE, "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "debugRender", "", "", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "debugLog", "", "message", "Lkotlin/Function0;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "initialItemIndices", "", "initialItemOffsets", "canRestartMeasure", "calculateVisibleItems", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "position", "Lkotlin/Function2;", "calculateExtraItems", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "fastForEach", "reverse", "action", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "offsetBy", "delta", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "indexOfMinValue", "minBound", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMaxValue", "transform", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "Unset", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final void debugLog(Function0<String> function0) {
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    /* renamed from: measureStaggeredGrid-C6celF4  reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m1297measureStaggeredGridC6celF4(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        int i5;
        int m1296maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo != null ? lazyStaggeredGridLayoutInfo.getVisibleItemsInfo() : null, graphicsContext, null);
        int[] updateScrollPositionIfTheFirstItemWasMoved$foundation = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition$foundation().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition$foundation().getScrollOffsets();
        if (updateScrollPositionIfTheFirstItemWasMoved$foundation.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= updateScrollPositionIfTheFirstItemWasMoved$foundation.length || (m1296maxInRangejy6DScQ = updateScrollPositionIfTheFirstItemWasMoved$foundation[i6]) == -1) {
                    m1296maxInRangejy6DScQ = i6 == 0 ? 0 : m1296maxInRangejy6DScQ(iArr, SpanRange.m1307constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = m1296maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                i6++;
            }
            updateScrollPositionIfTheFirstItemWasMoved$foundation = iArr;
        }
        if (scrollOffsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i7 = 0;
            while (i7 < laneCount2) {
                if (i7 < scrollOffsets.length) {
                    i5 = scrollOffsets[i7];
                } else {
                    i5 = i7 == 0 ? 0 : iArr2[i7 - 1];
                }
                iArr2[i7] = i5;
                i7++;
            }
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.scrollToBeConsumed$foundation(z4)), updateScrollPositionIfTheFirstItemWasMoved$foundation, scrollOffsets, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x02f1, code lost:
        r6 = indexOfMinValue$default(r9, 0, 1, null);
        r7 = indexOfMaxValue(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02fc, code lost:
        if (r6 == r7) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0302, code lost:
        if (r9[r6] != r9[r7]) goto L423;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0304, code lost:
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0306, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0307, code lost:
        r7 = r28[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x030a, code lost:
        if (r7 != (-1)) goto L427;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x030c, code lost:
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x030d, code lost:
        r7 = findPreviousItemIndex(r0, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0311, code lost:
        if (r7 >= 0) goto L429;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0313, code lost:
        r10 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0315, code lost:
        if (r1 != false) goto L465;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x031b, code lost:
        if (measure$lambda$0$misalignedStart(r10, r0, r9, r6) == false) goto L456;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x031d, code lost:
        if (r50 == false) goto L456;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x031f, code lost:
        r0.getLaneInfo().reset();
        r1 = r10.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x032a, code lost:
        if (r3 >= r1) goto L469;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x032c, code lost:
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0333, code lost:
        r1 = r9.length;
        r3 = new int[r1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0337, code lost:
        if (r4 >= r1) goto L473;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0339, code lost:
        r3[r4] = r9[r6];
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0347, code lost:
        return measure(r0, r27, r2, r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0348, code lost:
        r11 = r27;
        r47 = r2;
        r28 = r3;
        r30 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0352, code lost:
        r11 = r27;
        r10 = r28;
        r26 = r1;
        r47 = r2;
        r1 = r0.m1291getSpanRangelOCCd4c(r0.getItemProvider(), r7, r6);
        r6 = r0.getLaneInfo();
        r30 = r12;
        r27 = r13;
        r12 = (int) (r1 & 4294967295L);
        r28 = r3;
        r13 = r4;
        r3 = (int) (r1 >> r18);
        r4 = r12 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0376, code lost:
        if (r4 == 1) goto L450;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0378, code lost:
        r15 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x037a, code lost:
        r15 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x037b, code lost:
        r6.setLane(r7, r15);
        r6 = r0.getMeasuredItemProvider().m1300getAndMeasurejy6DScQ(r7, r1);
        r1 = m1296maxInRangejy6DScQ(r9, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x038b, code lost:
        if (r4 == 1) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x038d, code lost:
        r2 = r0.getLaneInfo().getGaps(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0396, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0397, code lost:
        if (r3 >= r12) goto L447;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x039b, code lost:
        if (r9[r3] == r1) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x039d, code lost:
        r26 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x039f, code lost:
        r48[r3].addFirst(r6);
        r10[r3] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03a6, code lost:
        if (r2 != null) goto L445;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03a8, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03aa, code lost:
        r4 = r2[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03ac, code lost:
        r9[r3] = (r1 + r6.getMainAxisSizeWithSpacings()) + r4;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x056a, code lost:
        if ((r1 != null ? r1.getIndex() : -1) > r13) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x0755, code lost:
        if (r8[r1] < r11) goto L302;
     */
    /* JADX WARN: Removed duplicated region for block: B:331:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x07a2  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x07be  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0818  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0886  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0894  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x08a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr3;
        int i7;
        int[] iArr4;
        int i8;
        int i9;
        int i10;
        int i11;
        String str;
        int i12;
        int i13;
        int[] iArr5;
        boolean z2;
        int i14;
        int i15;
        int i16;
        int i17;
        String str2;
        int[] iArr6;
        float f;
        int m8130constrainWidthK40F9xA;
        int m8112getMaxHeightimpl;
        int[] iArr7;
        List list;
        int i18;
        List list2;
        List<LazyStaggeredGridMeasuredItem> list3;
        int i19;
        ArrayList arrayList;
        int size;
        int i20;
        ArrayList arrayList2;
        ArrayList arrayList3;
        float f2;
        int[] iArr8;
        float f3;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z3;
        List<Integer> list4;
        ArrayList arrayList4;
        int i25;
        int i26;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int min;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        int i27;
        int[] iArr9;
        int i28;
        int i29;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        final LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext2.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext2.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext2.getLaneCount() == 0) {
            int m8115getMinWidthimpl = Constraints.m8115getMinWidthimpl(lazyStaggeredGridMeasureContext.m1288getConstraintsmsEJaDk());
            int m8114getMinHeightimpl = Constraints.m8114getMinHeightimpl(lazyStaggeredGridMeasureContext.m1288getConstraintsmsEJaDk());
            lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().onMeasured(0, m8115getMinWidthimpl, m8114getMinHeightimpl, new ArrayList(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.isVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.isInLookaheadScope(), 0, 0, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
            if (!measureScope.isLookingAhead()) {
                long m1240getMinSizeToFitDisappearingItemsYbymL2g = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().m1240getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m8329equalsimpl0(m1240getMinSizeToFitDisappearingItemsYbymL2g, IntSize.Companion.m8336getZeroYbymL2g())) {
                    m8115getMinWidthimpl = ConstraintsKt.m8130constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.m1288getConstraintsmsEJaDk(), (int) (m1240getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    m8114getMinHeightimpl = ConstraintsKt.m8129constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.m1288getConstraintsmsEJaDk(), (int) (m1240getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.layout$default(measureScope, m8115getMinWidthimpl, m8114getMinHeightimpl, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit measure$lambda$0$0;
                    measure$lambda$0$0 = LazyStaggeredGridMeasureKt.measure$lambda$0$0((Placeable.PlacementScope) obj);
                    return measure$lambda$0$0;
                }
            }, 4, null), 0.0f, false, lazyStaggeredGridMeasureContext.isVertical(), false, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), measureScope, itemCount, CollectionsKt.emptyList(), IntSize.m8326constructorimpl((Constraints.m8114getMinHeightimpl(lazyStaggeredGridMeasureContext.m1288getConstraintsmsEJaDk()) & 4294967295L) | (Constraints.m8115getMinWidthimpl(lazyStaggeredGridMeasureContext.m1288getConstraintsmsEJaDk()) << 32)), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        String str3 = "copyOf(...)";
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        int[] copyOf2 = Arrays.copyOf(iArr2, iArr2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
        ensureIndicesInRange(lazyStaggeredGridMeasureContext2, copyOf, itemCount);
        offsetBy(copyOf2, -i);
        int laneCount = lazyStaggeredGridMeasureContext2.getLaneCount();
        ArrayDeque[] arrayDequeArr = new ArrayDeque[laneCount];
        for (int i30 = 0; i30 < laneCount; i30++) {
            arrayDequeArr[i30] = new ArrayDeque(16);
        }
        offsetBy(copyOf2, -lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        boolean z4 = false;
        while (true) {
            if (!measure$lambda$0$hasSpaceBeforeFirst(copyOf, copyOf2, lazyStaggeredGridMeasureContext2)) {
                c = ' ';
                i2 = 0;
                i3 = -1;
                break;
            }
            i3 = indexOfMaxValue(copyOf);
            c = ' ';
            int i31 = copyOf[i3];
            int length = copyOf2.length;
            for (int i32 = 0; i32 < length; i32++) {
                if (copyOf[i32] != copyOf[i3]) {
                    int i33 = copyOf2[i32];
                    int i34 = copyOf2[i3];
                    if (i33 < i34) {
                        copyOf2[i32] = i34;
                    }
                }
            }
            i2 = 0;
            int findPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i31, i3);
            if (findPreviousItemIndex < 0) {
                break;
            }
            long m1291getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext2.m1291getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), findPreviousItemIndex, i3);
            int i35 = (int) (m1291getSpanRangelOCCd4c & 4294967295L);
            ArrayDeque[] arrayDequeArr2 = arrayDequeArr;
            boolean z5 = z4;
            int i36 = (int) (m1291getSpanRangelOCCd4c >> 32);
            int i37 = i35 - i36;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(findPreviousItemIndex, i37 != 1 ? -2 : i36);
            LazyStaggeredGridMeasuredItem m1300getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1300getAndMeasurejy6DScQ(findPreviousItemIndex, m1291getSpanRangelOCCd4c);
            int m1296maxInRangejy6DScQ = m1296maxInRangejy6DScQ(copyOf2, m1291getSpanRangelOCCd4c);
            int[] gaps = i37 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(findPreviousItemIndex) : null;
            boolean z6 = z5;
            while (i36 < i35) {
                copyOf[i36] = findPreviousItemIndex;
                int mainAxisSizeWithSpacings = m1296maxInRangejy6DScQ + m1300getAndMeasurejy6DScQ.getMainAxisSizeWithSpacings() + (gaps == null ? 0 : gaps[i36]);
                copyOf2[i36] = mainAxisSizeWithSpacings;
                if (lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + mainAxisSizeWithSpacings <= 0) {
                    z6 = true;
                }
                i36++;
            }
            arrayDequeArr = arrayDequeArr2;
            z4 = z6;
        }
        ArrayDeque[] arrayDequeArr3 = arrayDequeArr;
        boolean z7 = z4;
        int i38 = -lazyStaggeredGridMeasureContext2.getBeforeContentPadding();
        int i39 = copyOf2[i2];
        if (i39 < i38) {
            offsetBy(copyOf2, i38 - i39);
            i4 = i - (i38 - i39);
        } else {
            i4 = i;
        }
        offsetBy(copyOf2, lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i40 = -1;
        if (i3 == -1) {
            i3 = ArraysKt.indexOf(copyOf, i2);
        }
        if (i3 != -1 && measure$lambda$0$misalignedStart(copyOf, lazyStaggeredGridMeasureContext2, copyOf2, i3) && z) {
            lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
            int length2 = copyOf.length;
            int[] iArr10 = new int[length2];
            int i41 = 0;
            while (i41 < length2) {
                iArr10[i41] = i40;
                i41++;
                i40 = -1;
            }
            int length3 = copyOf2.length;
            int[] iArr11 = new int[length3];
            for (int i42 = 0; i42 < length3; i42++) {
                iArr11[i42] = copyOf2[i3];
            }
            return measure(lazyStaggeredGridMeasureContext2, i4, iArr10, iArr11, false);
        }
        int[] copyOf3 = Arrays.copyOf(copyOf, copyOf.length);
        Intrinsics.checkNotNullExpressionValue(copyOf3, "copyOf(...)");
        int length4 = copyOf2.length;
        int[] iArr12 = new int[length4];
        for (int i43 = 0; i43 < length4; i43++) {
            iArr12[i43] = -copyOf2[i43];
        }
        int mainAxisSpacing = lazyStaggeredGridMeasureContext2.getMainAxisSpacing() + i38;
        int coerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext2.getAfterContentPadding(), 0);
        int indexOfMinValue$default = indexOfMinValue$default(copyOf3, 0, 1, null);
        int i44 = 0;
        boolean z8 = z7;
        for (int i45 = -1; indexOfMinValue$default != i45 && i44 < lazyStaggeredGridMeasureContext2.getLaneCount(); i45 = -1) {
            int i46 = copyOf3[indexOfMinValue$default];
            int indexOfMinValue = indexOfMinValue(copyOf3, i46);
            i44++;
            if (i46 >= 0) {
                int i47 = i4;
                long m1291getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext2.m1291getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i46, indexOfMinValue$default);
                LazyStaggeredGridMeasuredItem m1300getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1300getAndMeasurejy6DScQ(i46, m1291getSpanRangelOCCd4c2);
                ArrayDeque[] arrayDequeArr4 = arrayDequeArr3;
                LazyStaggeredGridLaneInfo laneInfo = lazyStaggeredGridMeasureContext2.getLaneInfo();
                int[] iArr13 = copyOf;
                int[] iArr14 = copyOf2;
                int i48 = (int) (m1291getSpanRangelOCCd4c2 & 4294967295L);
                int i49 = itemCount;
                int i50 = (int) (m1291getSpanRangelOCCd4c2 >> c);
                int i51 = i48 - i50;
                if (i51 != 1) {
                    i28 = i46;
                    i29 = -2;
                } else {
                    i28 = i46;
                    i29 = i50;
                }
                laneInfo.setLane(i28, i29);
                int m1296maxInRangejy6DScQ2 = m1296maxInRangejy6DScQ(iArr12, m1291getSpanRangelOCCd4c2);
                for (int i52 = i50; i52 < i48; i52++) {
                    iArr12[i52] = m1300getAndMeasurejy6DScQ2.getMainAxisSizeWithSpacings() + m1296maxInRangejy6DScQ2;
                    copyOf3[i52] = i28;
                    arrayDequeArr4[i52].addLast(m1300getAndMeasurejy6DScQ2);
                }
                if (m1296maxInRangejy6DScQ2 < mainAxisSpacing && iArr12[i50] <= mainAxisSpacing) {
                    m1300getAndMeasurejy6DScQ2.setVisible(false);
                    z8 = true;
                }
                i44 = i51 != 1 ? lazyStaggeredGridMeasureContext2.getLaneCount() : i44;
                arrayDequeArr3 = arrayDequeArr4;
                indexOfMinValue$default = indexOfMinValue;
                i4 = i47;
                copyOf = iArr13;
                copyOf2 = iArr14;
                itemCount = i49;
            } else {
                indexOfMinValue$default = indexOfMinValue;
            }
        }
        int i53 = i4;
        ArrayDeque[] arrayDequeArr5 = arrayDequeArr3;
        int[] iArr15 = copyOf;
        int[] iArr16 = copyOf2;
        int i54 = itemCount;
        loop9: while (true) {
            int i55 = 0;
            while (true) {
                if (i55 < length4) {
                    int i56 = iArr12[i55];
                    if (i56 < coerceAtLeast || i56 <= 0) {
                        break;
                    }
                    i55++;
                } else {
                    for (int i57 = 0; i57 < laneCount; i57++) {
                        if (!arrayDequeArr5[i57].isEmpty()) {
                            i5 = i54;
                            i6 = 1;
                            break loop9;
                        }
                    }
                }
            }
            i6 = 1;
            int indexOfMinValue$default2 = indexOfMinValue$default(iArr12, 0, 1, null);
            int maxOrThrow = ArraysKt.maxOrThrow(copyOf3) + 1;
            i5 = i54;
            if (maxOrThrow >= i5) {
                break;
            }
            int i58 = length4;
            String str4 = str3;
            ArrayDeque[] arrayDequeArr6 = arrayDequeArr5;
            int i59 = coerceAtLeast;
            boolean z9 = z8;
            int i60 = i53;
            long m1291getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext2.m1291getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), maxOrThrow, indexOfMinValue$default2);
            int[] iArr17 = copyOf3;
            int i61 = (int) (m1291getSpanRangelOCCd4c3 & 4294967295L);
            int i62 = (int) (m1291getSpanRangelOCCd4c3 >> c);
            int i63 = i61 - i62;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(maxOrThrow, i63 != 1 ? -2 : i62);
            LazyStaggeredGridMeasuredItem m1300getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1300getAndMeasurejy6DScQ(maxOrThrow, m1291getSpanRangelOCCd4c3);
            int m1296maxInRangejy6DScQ3 = m1296maxInRangejy6DScQ(iArr12, m1291getSpanRangelOCCd4c3);
            if (i63 != 1) {
                iArr9 = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(maxOrThrow);
                if (iArr9 == null) {
                    iArr9 = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                }
            } else {
                iArr9 = null;
            }
            for (int i64 = i62; i64 < i61; i64++) {
                if (iArr9 != null) {
                    iArr9[i64] = m1296maxInRangejy6DScQ3 - iArr12[i64];
                }
                iArr17[i64] = maxOrThrow;
                iArr12[i64] = m1296maxInRangejy6DScQ3 + m1300getAndMeasurejy6DScQ3.getMainAxisSizeWithSpacings();
                arrayDequeArr6[i64].addLast(m1300getAndMeasurejy6DScQ3);
            }
            lazyStaggeredGridMeasureContext.getLaneInfo().setGaps(maxOrThrow, iArr9);
            if (m1296maxInRangejy6DScQ3 < mainAxisSpacing && iArr12[i62] <= mainAxisSpacing) {
                m1300getAndMeasurejy6DScQ3.setVisible(false);
            }
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
            copyOf3 = iArr17;
            coerceAtLeast = i59;
            i54 = i5;
            str3 = str4;
            z8 = z9;
            arrayDequeArr5 = arrayDequeArr6;
            length4 = i58;
            i53 = i60;
        }
        int i65 = 0;
        while (i65 < laneCount) {
            ArrayDeque arrayDeque = arrayDequeArr5[i65];
            while (arrayDeque.size() > i6 && !((LazyStaggeredGridMeasuredItem) arrayDeque.first()).isVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst();
                int[] gaps2 = lazyStaggeredGridMeasuredItem.getSpan() != i6 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr16[i65] = iArr16[i65] - (lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings() + (gaps2 == null ? 0 : gaps2[i65]));
                i6 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDeque.firstOrNull();
            iArr15[i65] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i65++;
            i6 = 1;
        }
        int length5 = copyOf3.length;
        int i66 = 0;
        while (true) {
            if (i66 >= length5) {
                break;
            } else if (copyOf3[i66] == i5 - 1) {
                offsetBy(iArr12, -lazyStaggeredGridMeasureContext2.getMainAxisSpacing());
                break;
            } else {
                i66++;
            }
        }
        int i67 = 0;
        while (true) {
            if (i67 < length4) {
                if (iArr12[i67] >= lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                    i9 = i5;
                    i12 = i53;
                    i7 = i12;
                    iArr4 = iArr15;
                    iArr3 = iArr16;
                    i10 = coerceAtLeast;
                    i11 = length4;
                    str = str3;
                    break;
                }
                i67++;
            } else {
                int mainAxisAvailableSize = lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() - iArr12[indexOfMaxValue(iArr12)];
                iArr3 = iArr16;
                offsetBy(iArr3, -mainAxisAvailableSize);
                offsetBy(iArr12, mainAxisAvailableSize);
                boolean z10 = false;
                loop31: while (true) {
                    int length6 = iArr3.length;
                    int i68 = 0;
                    while (true) {
                        if (i68 >= length6) {
                            i7 = i53;
                            iArr4 = iArr15;
                            i8 = mainAxisAvailableSize;
                            i9 = i5;
                            i10 = coerceAtLeast;
                            break loop31;
                        } else if (iArr3[i68] < lazyStaggeredGridMeasureContext2.getBeforeContentPadding()) {
                            break;
                        } else {
                            i68++;
                            length4 = length4;
                            iArr15 = iArr15;
                            i53 = i53;
                        }
                    }
                    mainAxisAvailableSize = i14;
                    str3 = str2;
                    z10 = z2;
                    length4 = i16;
                    coerceAtLeast = i17;
                    i5 = i15;
                    iArr15 = iArr5;
                    i53 = i13;
                }
                i11 = length4;
                str = str3;
                if (z10 && z) {
                    lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                    return measure(lazyStaggeredGridMeasureContext2, i7, iArr4, iArr3, false);
                }
                i12 = i7 + i8;
                int i69 = iArr3[indexOfMinValue$default(iArr3, 0, 1, null)];
                if (i69 < 0) {
                    i12 += i69;
                    offsetBy(iArr12, i69);
                    offsetBy(iArr3, -i69);
                }
            }
        }
        float scrollToBeConsumed$foundation = lazyStaggeredGridMeasureContext2.getState().scrollToBeConsumed$foundation(measureScope.isLookingAhead());
        if (MathKt.getSign(Math.round(scrollToBeConsumed$foundation)) != MathKt.getSign(i12) || Math.abs(Math.round(scrollToBeConsumed$foundation)) < Math.abs(i12)) {
            iArr6 = iArr4;
            f = scrollToBeConsumed$foundation;
        } else {
            iArr6 = iArr4;
            f = i12;
        }
        float f4 = scrollToBeConsumed$foundation - f;
        float f5 = 0.0f;
        if (measureScope.isLookingAhead() && i12 > i7 && f4 <= 0.0f) {
            f5 = (i12 - i7) + f4;
        }
        float f6 = f5;
        int[] copyOf4 = Arrays.copyOf(iArr3, iArr3.length);
        Intrinsics.checkNotNullExpressionValue(copyOf4, str);
        int length7 = copyOf4.length;
        for (int i70 = 0; i70 < length7; i70++) {
            copyOf4[i70] = -copyOf4[i70];
        }
        if (lazyStaggeredGridMeasureContext2.getBeforeContentPadding() > lazyStaggeredGridMeasureContext2.getMainAxisSpacing()) {
            for (int i71 = 0; i71 < laneCount; i71++) {
                ArrayDeque arrayDeque2 = arrayDequeArr5[i71];
                int size2 = arrayDeque2.size();
                int i72 = 0;
                while (i72 < size2) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) arrayDeque2.get(i72);
                    int[] gaps3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int mainAxisSizeWithSpacings2 = lazyStaggeredGridMeasuredItem3.getMainAxisSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i71]);
                    if (i72 != CollectionsKt.getLastIndex(arrayDeque2) && (i27 = iArr3[i71]) != 0 && i27 >= mainAxisSizeWithSpacings2) {
                        iArr3[i71] = i27 - mainAxisSizeWithSpacings2;
                        i72++;
                        iArr6[i71] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i72)).getIndex();
                    }
                }
            }
        }
        int beforeContentPadding = lazyStaggeredGridMeasureContext2.getBeforeContentPadding() + lazyStaggeredGridMeasureContext2.getAfterContentPadding();
        if (lazyStaggeredGridMeasureContext2.isVertical()) {
            m8130constrainWidthK40F9xA = Constraints.m8113getMaxWidthimpl(lazyStaggeredGridMeasureContext2.m1288getConstraintsmsEJaDk());
        } else {
            m8130constrainWidthK40F9xA = ConstraintsKt.m8130constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.m1288getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(iArr12) + beforeContentPadding);
        }
        int i73 = m8130constrainWidthK40F9xA;
        if (lazyStaggeredGridMeasureContext2.isVertical()) {
            m8112getMaxHeightimpl = ConstraintsKt.m8129constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.m1288getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(iArr12) + beforeContentPadding);
        } else {
            m8112getMaxHeightimpl = Constraints.m8112getMaxHeightimpl(lazyStaggeredGridMeasureContext2.m1288getConstraintsmsEJaDk());
        }
        int i74 = m8112getMaxHeightimpl;
        int afterContentPadding = lazyStaggeredGridMeasureContext2.getAfterContentPadding() + (Math.min(lazyStaggeredGridMeasureContext2.isVertical() ? i74 : i73, lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i75 = copyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int i76 = -1;
        int size3 = pinnedItems.size() - 1;
        if (size3 >= 0) {
            int i77 = size3;
            ArrayList arrayList5 = null;
            while (true) {
                int i78 = i77 - 1;
                int intValue = pinnedItems.get(i77).intValue();
                int lane = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(intValue);
                int i79 = i75;
                if (lane != -2 && lane != i76) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = (LazyStaggeredGridMeasuredItem) arrayDequeArr5[lane].firstOrNull();
                } else {
                    for (int i80 = 0; i80 < laneCount; i80++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = (LazyStaggeredGridMeasuredItem) arrayDequeArr5[i80].firstOrNull();
                        if ((lazyStaggeredGridMeasuredItem5 != null ? lazyStaggeredGridMeasuredItem5.getIndex() : -1) <= intValue) {
                            i75 = i79;
                            iArr7 = copyOf4;
                            break;
                        }
                    }
                    iArr7 = copyOf4;
                    long m1291getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext2.m1291getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), intValue, 0);
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem m1300getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1300getAndMeasurejy6DScQ(intValue, m1291getSpanRangelOCCd4c4);
                    int mainAxisSizeWithSpacings3 = i79 - m1300getAndMeasurejy6DScQ4.getMainAxisSizeWithSpacings();
                    m1300getAndMeasurejy6DScQ4.position(mainAxisSizeWithSpacings3, 0, afterContentPadding);
                    arrayList5.add(m1300getAndMeasurejy6DScQ4);
                    i75 = mainAxisSizeWithSpacings3;
                }
                if (i78 < 0) {
                    break;
                }
                copyOf4 = iArr7;
                i77 = i78;
                i76 = -1;
            }
            list = arrayList5;
        } else {
            iArr7 = copyOf4;
            list = null;
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        int[] iArr18 = iArr7;
        List list5 = list;
        int i81 = i10;
        List<LazyStaggeredGridMeasuredItem> calculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext2, arrayDequeArr5, iArr18, afterContentPadding, i38, i81);
        int i82 = iArr18[0];
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem6 = (LazyStaggeredGridMeasuredItem) CollectionsKt.lastOrNull((List<? extends Object>) calculateVisibleItems);
        int index2 = lazyStaggeredGridMeasuredItem6 != null ? lazyStaggeredGridMeasuredItem6.getIndex() : -1;
        if (measureScope.isLookingAhead() && lazyStaggeredGridMeasureContext2.getApproachVisibleItems() != null && !lazyStaggeredGridMeasureContext2.getApproachVisibleItems().isEmpty()) {
            List<LazyStaggeredGridItemInfo> approachVisibleItems = lazyStaggeredGridMeasureContext2.getApproachVisibleItems();
            for (int size4 = approachVisibleItems.size() - 1; -1 < size4; size4--) {
                if (approachVisibleItems.get(size4).getIndex() > index2 && (size4 == 0 || approachVisibleItems.get(size4 - 1).getIndex() <= index2)) {
                    lazyStaggeredGridItemInfo = approachVisibleItems.get(size4);
                    break;
                }
            }
            lazyStaggeredGridItemInfo = null;
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List<? extends Object>) lazyStaggeredGridMeasureContext2.getApproachVisibleItems());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (min = Math.min(lazyStaggeredGridItemInfo3.getIndex(), i9 - 1))) {
                int i83 = index;
                i19 = i82;
                arrayList = null;
                while (true) {
                    if (arrayList != null) {
                        int size5 = arrayList.size();
                        int i84 = 0;
                        while (i84 < size5) {
                            ArrayList arrayList6 = arrayList;
                            if (((LazyStaggeredGridMeasuredItem) arrayList.get(i84)).getIndex() == i83) {
                                arrayList = arrayList6;
                                i18 = beforeContentPadding;
                                list2 = list5;
                                list3 = calculateVisibleItems;
                                break;
                            }
                            i84++;
                            arrayList = arrayList6;
                        }
                    }
                    ArrayList arrayList7 = arrayList;
                    arrayList = arrayList7 == null ? new ArrayList() : arrayList7;
                    List<LazyStaggeredGridItemInfo> approachVisibleItems2 = lazyStaggeredGridMeasureContext2.getApproachVisibleItems();
                    int size6 = approachVisibleItems2.size();
                    i18 = beforeContentPadding;
                    int i85 = 0;
                    while (true) {
                        if (i85 >= size6) {
                            lazyStaggeredGridItemInfo2 = null;
                            break;
                        }
                        lazyStaggeredGridItemInfo2 = approachVisibleItems2.get(i85);
                        int i86 = i85;
                        if (lazyStaggeredGridItemInfo2.getIndex() == i83) {
                            break;
                        }
                        i85 = i86 + 1;
                    }
                    LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = lazyStaggeredGridItemInfo2;
                    int lane2 = lazyStaggeredGridItemInfo4 != null ? lazyStaggeredGridItemInfo4.getLane() : 0;
                    list2 = list5;
                    list3 = calculateVisibleItems;
                    LazyStaggeredGridMeasuredItem m1300getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1300getAndMeasurejy6DScQ(i83, lazyStaggeredGridMeasureContext2.m1291getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i83, lane2));
                    arrayList.add(m1300getAndMeasurejy6DScQ5);
                    int[] positions = lazyStaggeredGridMeasureContext2.getResolvedSlots().getPositions();
                    m1300getAndMeasurejy6DScQ5.position(i19, positions.length > lane2 ? positions[lane2] : 0, afterContentPadding);
                    i19 += m1300getAndMeasurejy6DScQ5.getMainAxisSizeWithSpacings();
                    if (i83 == min) {
                        break;
                    }
                    i83++;
                    beforeContentPadding = i18;
                    list5 = list2;
                    calculateVisibleItems = list3;
                }
                List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext2.getPinnedItems();
                size = pinnedItems2.size();
                i20 = 0;
                arrayList2 = null;
                while (i20 < size) {
                    int intValue2 = pinnedItems2.get(i20).intValue();
                    int i87 = i9;
                    if (intValue2 >= i87) {
                        arrayList4 = arrayList;
                        list4 = pinnedItems2;
                    } else {
                        if (arrayList != null) {
                            int size7 = arrayList.size();
                            list4 = pinnedItems2;
                            int i88 = 0;
                            while (i88 < size7) {
                                arrayList4 = arrayList;
                                if (((LazyStaggeredGridMeasuredItem) arrayList.get(i88)).getIndex() == intValue2) {
                                    break;
                                }
                                i88++;
                                arrayList = arrayList4;
                            }
                        } else {
                            list4 = pinnedItems2;
                        }
                        arrayList4 = arrayList;
                        int lane3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(intValue2);
                        if (lane3 == -2 || lane3 == -1) {
                            for (int i89 : copyOf3) {
                                if (i89 < intValue2) {
                                }
                            }
                            i25 = size;
                            i26 = i20;
                            long m1291getSpanRangelOCCd4c5 = lazyStaggeredGridMeasureContext2.m1291getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), intValue2, 0);
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            LazyStaggeredGridMeasuredItem m1300getAndMeasurejy6DScQ6 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1300getAndMeasurejy6DScQ(intValue2, m1291getSpanRangelOCCd4c5);
                            m1300getAndMeasurejy6DScQ6.position(i19, 0, afterContentPadding);
                            i19 += m1300getAndMeasurejy6DScQ6.getMainAxisSizeWithSpacings();
                            arrayList2.add(m1300getAndMeasurejy6DScQ6);
                        }
                        i20 = i26 + 1;
                        size = i25;
                        pinnedItems2 = list4;
                        arrayList = arrayList4;
                        i9 = i87;
                    }
                    i25 = size;
                    i26 = i20;
                    i20 = i26 + 1;
                    size = i25;
                    pinnedItems2 = list4;
                    arrayList = arrayList4;
                    i9 = i87;
                }
                int i90 = i9;
                arrayList3 = arrayList;
                if (arrayList2 == null) {
                    arrayList2 = CollectionsKt.emptyList();
                }
                final ArrayList arrayList8 = new ArrayList();
                arrayList8.addAll(list2);
                arrayList8.addAll(list3);
                if (arrayList3 != null) {
                    arrayList8.addAll(arrayList3);
                }
                arrayList8.addAll(arrayList2);
                lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().onMeasured((int) f, i73, i74, arrayList8, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.isVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext2.getLaneCount(), lazyStaggeredGridMeasureContext2.isInLookaheadScope(), ArraysKt.minOrThrow(iArr3), ArraysKt.maxOrThrow(iArr12) + i18, lazyStaggeredGridMeasureContext2.getCoroutineScope(), lazyStaggeredGridMeasureContext2.getGraphicsContext());
                if (measureScope.isLookingAhead()) {
                    long m1240getMinSizeToFitDisappearingItemsYbymL2g2 = lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().m1240getMinSizeToFitDisappearingItemsYbymL2g();
                    f2 = f6;
                    if (!IntSize.m8329equalsimpl0(m1240getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.Companion.m8336getZeroYbymL2g())) {
                        int i91 = lazyStaggeredGridMeasureContext2.isVertical() ? i74 : i73;
                        iArr8 = iArr3;
                        f3 = f;
                        int m8130constrainWidthK40F9xA2 = ConstraintsKt.m8130constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.m1288getConstraintsmsEJaDk(), Math.max(i73, (int) (m1240getMinSizeToFitDisappearingItemsYbymL2g2 >> c)));
                        int m8129constrainHeightK40F9xA = ConstraintsKt.m8129constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.m1288getConstraintsmsEJaDk(), Math.max(i74, (int) (m1240getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                        int i92 = lazyStaggeredGridMeasureContext2.isVertical() ? m8129constrainHeightK40F9xA : m8130constrainWidthK40F9xA2;
                        if (i92 != i91) {
                            int size8 = arrayList8.size();
                            for (int i93 = 0; i93 < size8; i93++) {
                                arrayList8.get(i93).updateMainAxisLayoutSize(i92);
                            }
                        }
                        i21 = m8130constrainWidthK40F9xA2;
                        i22 = m8129constrainHeightK40F9xA;
                        i23 = i11;
                        i24 = 0;
                        while (true) {
                            if (i24 < i23) {
                                if (iArr12[i24] > lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                                    break;
                                }
                                i24++;
                            } else {
                                for (int i94 : copyOf3) {
                                    if (i94 >= i90 - 1) {
                                        z3 = false;
                                        break;
                                    }
                                }
                            }
                        }
                        z3 = true;
                        final boolean reverseLayout = lazyStaggeredGridMeasureContext2.getReverseLayout();
                        final long m1289getContentOffsetnOccac = lazyStaggeredGridMeasureContext2.m1289getContentOffsetnOccac();
                        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
                        return new LazyStaggeredGridMeasureResult(iArr6, iArr8, f3, MeasureScope.layout$default(measureScope, i21, i22, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit measure$lambda$0$37;
                                measure$lambda$0$37 = LazyStaggeredGridMeasureKt.measure$lambda$0$37(LazyStaggeredGridMeasureContext.this, arrayList8, reverseLayout, m1289getContentOffsetnOccac, measureScope, (Placeable.PlacementScope) obj);
                                return measure$lambda$0$37;
                            }
                        }, 4, null), f2, z3, lazyStaggeredGridMeasureContext3.isVertical(), z8, lazyStaggeredGridMeasureContext3.getResolvedSlots(), lazyStaggeredGridMeasureContext3.getItemProvider().getSpanProvider(), measureScope, i90, list3, IntSize.m8326constructorimpl((i22 & 4294967295L) | (i21 << c)), i38, i81, lazyStaggeredGridMeasureContext3.getBeforeContentPadding(), lazyStaggeredGridMeasureContext3.getAfterContentPadding(), lazyStaggeredGridMeasureContext3.getMainAxisSpacing(), lazyStaggeredGridMeasureContext3.getCoroutineScope(), null);
                    }
                } else {
                    f2 = f6;
                }
                iArr8 = iArr3;
                f3 = f;
                i21 = i73;
                i22 = i74;
                i23 = i11;
                i24 = 0;
                while (true) {
                    if (i24 < i23) {
                    }
                    i24++;
                }
                z3 = true;
                final boolean reverseLayout2 = lazyStaggeredGridMeasureContext2.getReverseLayout();
                final long m1289getContentOffsetnOccac2 = lazyStaggeredGridMeasureContext2.m1289getContentOffsetnOccac();
                final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext32 = lazyStaggeredGridMeasureContext2;
                return new LazyStaggeredGridMeasureResult(iArr6, iArr8, f3, MeasureScope.layout$default(measureScope, i21, i22, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit measure$lambda$0$37;
                        measure$lambda$0$37 = LazyStaggeredGridMeasureKt.measure$lambda$0$37(LazyStaggeredGridMeasureContext.this, arrayList8, reverseLayout2, m1289getContentOffsetnOccac2, measureScope, (Placeable.PlacementScope) obj);
                        return measure$lambda$0$37;
                    }
                }, 4, null), f2, z3, lazyStaggeredGridMeasureContext32.isVertical(), z8, lazyStaggeredGridMeasureContext32.getResolvedSlots(), lazyStaggeredGridMeasureContext32.getItemProvider().getSpanProvider(), measureScope, i90, list3, IntSize.m8326constructorimpl((i22 & 4294967295L) | (i21 << c)), i38, i81, lazyStaggeredGridMeasureContext32.getBeforeContentPadding(), lazyStaggeredGridMeasureContext32.getAfterContentPadding(), lazyStaggeredGridMeasureContext32.getMainAxisSpacing(), lazyStaggeredGridMeasureContext32.getCoroutineScope(), null);
            }
        }
        i18 = beforeContentPadding;
        list2 = list5;
        list3 = calculateVisibleItems;
        i19 = i82;
        arrayList = null;
        List<Integer> pinnedItems22 = lazyStaggeredGridMeasureContext2.getPinnedItems();
        size = pinnedItems22.size();
        i20 = 0;
        arrayList2 = null;
        while (i20 < size) {
        }
        int i902 = i9;
        arrayList3 = arrayList;
        if (arrayList2 == null) {
        }
        final List arrayList82 = new ArrayList();
        arrayList82.addAll(list2);
        arrayList82.addAll(list3);
        if (arrayList3 != null) {
        }
        arrayList82.addAll(arrayList2);
        lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().onMeasured((int) f, i73, i74, arrayList82, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.isVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext2.getLaneCount(), lazyStaggeredGridMeasureContext2.isInLookaheadScope(), ArraysKt.minOrThrow(iArr3), ArraysKt.maxOrThrow(iArr12) + i18, lazyStaggeredGridMeasureContext2.getCoroutineScope(), lazyStaggeredGridMeasureContext2.getGraphicsContext());
        if (measureScope.isLookingAhead()) {
        }
        iArr8 = iArr3;
        f3 = f;
        i21 = i73;
        i22 = i74;
        i23 = i11;
        i24 = 0;
        while (true) {
            if (i24 < i23) {
            }
            i24++;
        }
        z3 = true;
        final boolean reverseLayout22 = lazyStaggeredGridMeasureContext2.getReverseLayout();
        final long m1289getContentOffsetnOccac22 = lazyStaggeredGridMeasureContext2.m1289getContentOffsetnOccac();
        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext322 = lazyStaggeredGridMeasureContext2;
        return new LazyStaggeredGridMeasureResult(iArr6, iArr8, f3, MeasureScope.layout$default(measureScope, i21, i22, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure$lambda$0$37;
                measure$lambda$0$37 = LazyStaggeredGridMeasureKt.measure$lambda$0$37(LazyStaggeredGridMeasureContext.this, arrayList82, reverseLayout22, m1289getContentOffsetnOccac22, measureScope, (Placeable.PlacementScope) obj);
                return measure$lambda$0$37;
            }
        }, 4, null), f2, z3, lazyStaggeredGridMeasureContext322.isVertical(), z8, lazyStaggeredGridMeasureContext322.getResolvedSlots(), lazyStaggeredGridMeasureContext322.getItemProvider().getSpanProvider(), measureScope, i902, list3, IntSize.m8326constructorimpl((i22 & 4294967295L) | (i21 << c)), i38, i81, lazyStaggeredGridMeasureContext322.getBeforeContentPadding(), lazyStaggeredGridMeasureContext322.getAfterContentPadding(), lazyStaggeredGridMeasureContext322.getMainAxisSpacing(), lazyStaggeredGridMeasureContext322.getCoroutineScope(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    private static final boolean measure$lambda$0$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$0$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, final List list, final boolean z, final long j, final LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure$lambda$0$37$0;
                measure$lambda$0$37$0 = LazyStaggeredGridMeasureKt.measure$lambda$0$37$0(list, z, j, lazyLayoutMeasureScope, (Placeable.PlacementScope) obj);
                return measure$lambda$0$37$0;
            }
        });
        ObservableScopeInvalidator.m1258attachToScopeimpl(lazyStaggeredGridMeasureContext.getState().m1305getPlacementScopeInvalidatorzYiylxw$foundation());
        return Unit.INSTANCE;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i, int i2, int i3) {
        int i4 = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            i4 += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(i4);
        while (true) {
            for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque2 : arrayDequeArr) {
                if (!arrayDeque2.isEmpty()) {
                    int length = arrayDequeArr.length;
                    int i5 = -1;
                    int i6 = Integer.MAX_VALUE;
                    for (int i7 = 0; i7 < length; i7++) {
                        LazyStaggeredGridMeasuredItem firstOrNull = arrayDequeArr[i7].firstOrNull();
                        int index = firstOrNull != null ? firstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i6 > index) {
                            i5 = i7;
                            i6 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem removeFirst = arrayDequeArr[i5].removeFirst();
                    if (removeFirst.getLane() == i5) {
                        long m1307constructorimpl = SpanRange.m1307constructorimpl(removeFirst.getLane(), removeFirst.getSpan());
                        int m1296maxInRangejy6DScQ = m1296maxInRangejy6DScQ(iArr, m1307constructorimpl);
                        int i8 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i5];
                        if (removeFirst.getMainAxisSize() + m1296maxInRangejy6DScQ >= i2 && m1296maxInRangejy6DScQ <= i3) {
                            removeFirst.position(m1296maxInRangejy6DScQ, i8, i);
                            arrayList.add(removeFirst);
                        }
                        int i9 = (int) (m1307constructorimpl & 4294967295L);
                        for (int i10 = (int) (m1307constructorimpl >> 32); i10 < i9; i10++) {
                            iArr[i10] = removeFirst.getMainAxisSizeWithSpacings() + m1296maxInRangejy6DScQ;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    private static final List<LazyStaggeredGridMeasuredItem> itemsRetainedForLookahead(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2, boolean z, Function2<? super LazyStaggeredGridMeasuredItem, ? super Integer, Unit> function2) {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int min;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        if (z && lazyStaggeredGridMeasureContext.getApproachVisibleItems() != null && !lazyStaggeredGridMeasureContext.getApproachVisibleItems().isEmpty()) {
            List<LazyStaggeredGridItemInfo> approachVisibleItems = lazyStaggeredGridMeasureContext.getApproachVisibleItems();
            int size = approachVisibleItems.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    lazyStaggeredGridItemInfo = null;
                    break;
                } else if (approachVisibleItems.get(size).getIndex() <= i || (size != 0 && approachVisibleItems.get(size - 1).getIndex() > i)) {
                }
            }
            lazyStaggeredGridItemInfo = approachVisibleItems.get(size);
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List<? extends Object>) lazyStaggeredGridMeasureContext.getApproachVisibleItems());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (min = Math.min(lazyStaggeredGridItemInfo3.getIndex(), i2 - 1))) {
                ArrayList arrayList = null;
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            if (arrayList.get(i3).getIndex() == index) {
                                break;
                            }
                        }
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    List<LazyStaggeredGridItemInfo> approachVisibleItems2 = lazyStaggeredGridMeasureContext.getApproachVisibleItems();
                    int size3 = approachVisibleItems2.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            lazyStaggeredGridItemInfo2 = null;
                            break;
                        }
                        lazyStaggeredGridItemInfo2 = approachVisibleItems2.get(i4);
                        if (lazyStaggeredGridItemInfo2.getIndex() == index) {
                            break;
                        }
                        i4++;
                    }
                    LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = lazyStaggeredGridItemInfo2;
                    int lane = lazyStaggeredGridItemInfo4 != null ? lazyStaggeredGridItemInfo4.getLane() : 0;
                    LazyStaggeredGridMeasuredItem m1300getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1300getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m1291getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                    arrayList.add(m1300getAndMeasurejy6DScQ);
                    int[] positions = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                    function2.invoke(m1300getAndMeasurejy6DScQ, Integer.valueOf(positions.length > lane ? positions[lane] : 0));
                    if (index == min) {
                        return arrayList;
                    }
                    index++;
                }
            }
        }
        return null;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int intValue = pinnedItems.get(size).intValue();
                    if (function12.invoke(Integer.valueOf(intValue)).booleanValue()) {
                        long m1291getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m1291getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem m1300getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1300getAndMeasurejy6DScQ(intValue, m1291getSpanRangelOCCd4c);
                        function1.invoke(m1300getAndMeasurejy6DScQ);
                        arrayList.add(m1300getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int intValue2 = pinnedItems.get(i2).intValue();
                if (function12.invoke(Integer.valueOf(intValue2)).booleanValue()) {
                    long m1291getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m1291getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem m1300getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1300getAndMeasurejy6DScQ(intValue2, m1291getSpanRangelOCCd4c2);
                    function1.invoke(m1300getAndMeasurejy6DScQ2);
                    arrayList.add(m1300getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* renamed from: forEach-nIS5qE8  reason: not valid java name */
    private static final void m1295forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    /* renamed from: maxInRange-jy6DScQ  reason: not valid java name */
    private static final int m1296maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int i2 = Integer.MIN_VALUE;
        for (int i3 = (int) (j >> 32); i3 < i; i3++) {
            i2 = Math.max(i2, iArr[i3]);
        }
        return i2;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int intValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > intValue) {
                i = i3;
                i2 = intValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                }
                iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
            }
            int i3 = iArr[length];
            if (i3 >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), i3)) {
                if (lazyStaggeredGridMeasureContext.getLaneInfo().getLane(i3) == -2) {
                    int length2 = iArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            i4 = -1;
                            break;
                        } else if (iArr[i4] == i3) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    int i5 = i4 + 1;
                    if (i5 <= length) {
                        while (true) {
                            if (iArr[i5] == i3) {
                                iArr[i5] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, i3, i5);
                            }
                            if (i5 == length) {
                                break;
                            }
                            i5++;
                        }
                    }
                    length = i4;
                }
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(i3, length);
            }
            if (i2 < 0) {
                return;
            }
            length = i2;
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i = size - 1;
                function1.invoke((T) list.get(size));
                if (i < 0) {
                    return;
                }
                size = i;
            }
        } else {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                function1.invoke((T) list.get(i2));
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i2 = size - 1;
                function1.invoke(list.get(size));
                if (i2 < 0) {
                    return;
                }
                size = i2;
            }
        } else {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function1.invoke(list.get(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37$0(List list, boolean z, long j, LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyStaggeredGridMeasuredItem) list.get(i)).m1303placeGMOY1bU(placementScope, z, j, lazyLayoutMeasureScope.isLookingAhead());
        }
        return Unit.INSTANCE;
    }
}
