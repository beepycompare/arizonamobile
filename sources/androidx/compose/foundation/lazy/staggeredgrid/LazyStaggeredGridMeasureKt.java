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
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082\b\u001a5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\b\u000fH\u0082\b¢\u0006\u0002\u0010\u0010\u001aR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0001H\u0082\b\u001aK\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010$\u001a\u001d\u0010%\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001dH\u0002¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020\u0005*\u00020\u00142\u0006\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0003H\u0002\u001a7\u0010*\u001a\u00020\u0005\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00122\b\b\u0002\u0010+\u001a\u00020\u00012\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\b\u001a\u001c\u0010-\u001a\u00020\u0003*\u00020\u00142\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H\u0002\u001a+\u00100\u001a\u00020\u0005*\u0002012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\bø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\f\u00104\u001a\u00020\u0003*\u00020 H\u0002\u001a2\u00105\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u001d2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\b¢\u0006\u0002\u00106\u001a\u0016\u00107\u001a\u00020\u0003*\u00020 2\b\b\u0002\u00108\u001a\u00020\u0003H\u0000\u001aG\u00109\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012*\u00020\u00142\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00012\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050=H\u0082\b\u001a\u001e\u0010>\u001a\u00020\u0003*\u00020 2\u0006\u0010?\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a,\u0010B\u001a\u00020C*\u00020\u00142\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020\u0001H\u0002\u001a¦\u0001\u0010H\u001a\u00020C*\u00020\f2\u0006\u0010I\u001a\u00020J2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020`H\u0000ø\u0001\u0000¢\u0006\u0004\ba\u0010b\u001a\u0014\u0010c\u001a\u00020\u0005*\u00020 2\u0006\u0010d\u001a\u00020\u0003H\u0002\u001a!\u0010e\u001a\u00020 *\u00020 2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006f"}, d2 = {"DebugLoggingEnabled", "", "Unset", "", "debugLog", "", "message", "Lkotlin/Function0;", "", "withDebugLogging", ExifInterface.GPS_DIRECTION_TRUE, "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "calculateExtraItems", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "calculateVisibleItems", "measuredItems", "", "Lkotlin/collections/ArrayDeque;", "itemScrollOffsets", "", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "debugRender", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "ensureIndicesInRange", "indices", "itemCount", "fastForEach", "reverse", "action", "findPreviousItemIndex", "item", "lane", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "indexOfMaxValue", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "minBound", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "isLookingAhead", "Lkotlin/Function2;", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measureStaggeredGrid", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
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
    public static final LazyStaggeredGridMeasureResult m957measureStaggeredGridC6celF4(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        int i5;
        int m956maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo, graphicsContext, null);
        int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition$foundation_release().getScrollOffsets();
        if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length || (m956maxInRangejy6DScQ = updateScrollPositionIfTheFirstItemWasMoved$foundation_release[i6]) == -1) {
                    m956maxInRangejy6DScQ = i6 == 0 ? 0 : m956maxInRangejy6DScQ(iArr, SpanRange.m967constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = m956maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                i6++;
            }
            updateScrollPositionIfTheFirstItemWasMoved$foundation_release = iArr;
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
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.scrollToBeConsumed$foundation_release(z4)), updateScrollPositionIfTheFirstItemWasMoved$foundation_release, scrollOffsets, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x023e, code lost:
        r6 = indexOfMinValue$default(r14, 0, 1, null);
        r1 = kotlin.collections.ArraysKt.maxOrThrow(r8) + 1;
        r12 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0249, code lost:
        if (r1 < r12) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02fd, code lost:
        r6 = indexOfMinValue$default(r9, 0, 1, null);
        r7 = indexOfMaxValue(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0308, code lost:
        if (r6 == r7) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x030e, code lost:
        if (r9[r6] != r9[r7]) goto L479;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0310, code lost:
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0312, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0313, code lost:
        r7 = r28[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0316, code lost:
        if (r7 != (-1)) goto L483;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0318, code lost:
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0319, code lost:
        r7 = findPreviousItemIndex(r0, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x031d, code lost:
        if (r7 >= 0) goto L485;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x031f, code lost:
        r10 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0321, code lost:
        if (r1 != false) goto L527;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0327, code lost:
        if (measure$lambda$43$misalignedStart(r10, r0, r9, r6) == false) goto L518;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0329, code lost:
        if (r50 == false) goto L518;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x032b, code lost:
        r0.getLaneInfo().reset();
        r1 = r10.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0336, code lost:
        if (r3 >= r1) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0338, code lost:
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x033f, code lost:
        r1 = r9.length;
        r3 = new int[r1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0343, code lost:
        if (r4 >= r1) goto L535;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0345, code lost:
        r3[r4] = r9[r6];
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0353, code lost:
        return measure(r0, r27, r2, r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0354, code lost:
        r11 = r27;
        r24 = r2;
        r28 = r3;
        r30 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x035e, code lost:
        r11 = r27;
        r10 = r28;
        r25 = r1;
        r24 = r2;
        r1 = r0.m952getSpanRangelOCCd4c(r0.getItemProvider(), r7, r6);
        r6 = r0.getLaneInfo();
        r30 = r12;
        r27 = r13;
        r12 = (int) (r1 & 4294967295L);
        r28 = r3;
        r13 = r4;
        r3 = (int) (r1 >> r18);
        r4 = r12 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0382, code lost:
        if (r4 == 1) goto L512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0384, code lost:
        r29 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0387, code lost:
        r29 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0389, code lost:
        if (r29 == false) goto L511;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x038b, code lost:
        r15 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x038d, code lost:
        r15 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x038e, code lost:
        r6.setLane(r7, r15);
        r6 = r0.getMeasuredItemProvider().m961getAndMeasurejy6DScQ(r7, r1);
        r1 = m956maxInRangejy6DScQ(r9, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x039e, code lost:
        if (r4 == 1) goto L510;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03a0, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03a2, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03a3, code lost:
        if (r2 == false) goto L509;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03a5, code lost:
        r2 = r0.getLaneInfo().getGaps(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03ae, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03af, code lost:
        if (r3 >= r12) goto L507;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x03b3, code lost:
        if (r9[r3] == r1) goto L500;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03b5, code lost:
        r25 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03b7, code lost:
        r49[r3].addFirst(r6);
        r10[r3] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03be, code lost:
        if (r2 != null) goto L505;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03c0, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03c2, code lost:
        r4 = r2[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x03c4, code lost:
        r9[r3] = (r1 + r6.getMainAxisSizeWithSpacings()) + r4;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0581, code lost:
        if ((r1 != null ? r1.getIndex() : -1) > r15) goto L444;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x07b0, code lost:
        if (r8[r1] < r7) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:459:0x098a, code lost:
        r7 = r13;
        r13 = r4;
        r10 = r48;
        r7 = r49;
        r24 = r3;
        r15 = r26;
        r11 = r27;
        r3 = r0.m952getSpanRangelOCCd4c(r0.getItemProvider(), r1, r6);
        r6 = r0.getLaneInfo();
        r47 = r8;
        r7 = (int) (r3 & 4294967295L);
        r8 = (int) (r3 >> r18);
        r9 = r7 - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x09b4, code lost:
        if (r9 == 1) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x09b6, code lost:
        r0 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:462:0x09b8, code lost:
        r0 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:463:0x09b9, code lost:
        r6.setLane(r1, r0);
        r0 = r46.getMeasuredItemProvider().m961getAndMeasurejy6DScQ(r1, r3);
        r3 = m956maxInRangejy6DScQ(r14, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x09c9, code lost:
        if (r9 == 1) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:465:0x09cb, code lost:
        r6 = r46.getLaneInfo().getGaps(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x09d3, code lost:
        if (r6 != null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x09d5, code lost:
        r6 = new int[r46.getLaneCount()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x09dc, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x09dd, code lost:
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:470:0x09de, code lost:
        if (r9 >= r7) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x09e0, code lost:
        if (r6 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x09e2, code lost:
        r6[r9] = r3 - r14[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x09e8, code lost:
        r47[r9] = r1;
        r14[r9] = r3 + r0.getMainAxisSizeWithSpacings();
        r7[r9].addLast(r0);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:474:0x09fb, code lost:
        r46.getLaneInfo().setGaps(r1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x0a02, code lost:
        if (r3 >= r2) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0a06, code lost:
        if (r14[r8] > r2) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x0a08, code lost:
        r0.setVisible(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0228, code lost:
        r11 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:334:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x072f A[LOOP:21: B:317:0x0684->B:357:0x072f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x07c8  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x07f8  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x080e  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0827  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0883  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x08f5  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x090a  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0739 A[EDGE_INSN: B:542:0x0739->B:358:0x0739 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:556:0x0907 A[SYNTHETIC] */
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
        int m6654constrainWidthK40F9xA;
        int m6636getMaxHeightimpl;
        int[] iArr7;
        List list;
        List<LazyStaggeredGridMeasuredItem> list2;
        int[] iArr8;
        float f2;
        ArrayList arrayList;
        int size;
        int i18;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z3;
        int i23;
        boolean z4;
        boolean z5;
        ArrayList arrayList4;
        List<Integer> list3;
        boolean z6;
        boolean z7;
        boolean z8;
        int i24;
        int i25;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int min;
        boolean z9;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        boolean z10;
        boolean z11;
        int i26;
        int i27;
        String str3;
        boolean z12;
        ArrayDeque[] arrayDequeArr;
        int i28;
        LazyLayoutMeasureScope lazyLayoutMeasureScope;
        int i29;
        int[] iArr9;
        LazyStaggeredGridLaneInfo lazyStaggeredGridLaneInfo;
        int i30;
        boolean z13;
        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext2.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext2.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext2.getLaneCount() == 0) {
            int m6639getMinWidthimpl = Constraints.m6639getMinWidthimpl(lazyStaggeredGridMeasureContext.m949getConstraintsmsEJaDk());
            int m6638getMinHeightimpl = Constraints.m6638getMinHeightimpl(lazyStaggeredGridMeasureContext.m949getConstraintsmsEJaDk());
            lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation_release().onMeasured(0, m6639getMinWidthimpl, m6638getMinHeightimpl, new ArrayList(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.isVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.isInLookaheadScope(), 0, 0, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
            if (!measureScope.isLookingAhead()) {
                long m906getMinSizeToFitDisappearingItemsYbymL2g = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation_release().m906getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m6853equalsimpl0(m906getMinSizeToFitDisappearingItemsYbymL2g, IntSize.Companion.m6860getZeroYbymL2g())) {
                    m6639getMinWidthimpl = ConstraintsKt.m6654constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.m949getConstraintsmsEJaDk(), (int) (m906getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    m6638getMinHeightimpl = ConstraintsKt.m6653constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.m949getConstraintsmsEJaDk(), (int) (m906getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.layout$default(measureScope, m6639getMinWidthimpl, m6638getMinHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null), 0.0f, false, lazyStaggeredGridMeasureContext.isVertical(), false, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), measureScope, itemCount, CollectionsKt.emptyList(), IntSize.m6850constructorimpl((Constraints.m6638getMinHeightimpl(lazyStaggeredGridMeasureContext.m949getConstraintsmsEJaDk()) & 4294967295L) | (Constraints.m6639getMinWidthimpl(lazyStaggeredGridMeasureContext.m949getConstraintsmsEJaDk()) << 32)), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        String str4 = "copyOf(...)";
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        int[] copyOf2 = Arrays.copyOf(iArr2, iArr2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
        ensureIndicesInRange(lazyStaggeredGridMeasureContext2, copyOf, itemCount);
        offsetBy(copyOf2, -i);
        int laneCount = lazyStaggeredGridMeasureContext2.getLaneCount();
        ArrayDeque[] arrayDequeArr2 = new ArrayDeque[laneCount];
        for (int i31 = 0; i31 < laneCount; i31++) {
            arrayDequeArr2[i31] = new ArrayDeque(16);
        }
        offsetBy(copyOf2, -lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        boolean z14 = false;
        while (true) {
            if (!measure$lambda$43$hasSpaceBeforeFirst(copyOf, copyOf2, lazyStaggeredGridMeasureContext2)) {
                c = ' ';
                i2 = 0;
                i3 = -1;
                break;
            }
            i3 = indexOfMaxValue(copyOf);
            c = ' ';
            int i32 = copyOf[i3];
            int length = copyOf2.length;
            for (int i33 = 0; i33 < length; i33++) {
                if (copyOf[i33] != copyOf[i3]) {
                    int i34 = copyOf2[i33];
                    int i35 = copyOf2[i3];
                    if (i34 < i35) {
                        copyOf2[i33] = i35;
                    }
                }
            }
            i2 = 0;
            int findPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i32, i3);
            if (findPreviousItemIndex < 0) {
                break;
            }
            long m952getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext2.m952getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), findPreviousItemIndex, i3);
            int i36 = (int) (m952getSpanRangelOCCd4c & 4294967295L);
            ArrayDeque[] arrayDequeArr3 = arrayDequeArr2;
            boolean z15 = z14;
            int i37 = (int) (m952getSpanRangelOCCd4c >> 32);
            int i38 = i36 - i37;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(findPreviousItemIndex, i38 != 1 ? -2 : i37);
            LazyStaggeredGridMeasuredItem m961getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m961getAndMeasurejy6DScQ(findPreviousItemIndex, m952getSpanRangelOCCd4c);
            int m956maxInRangejy6DScQ = m956maxInRangejy6DScQ(copyOf2, m952getSpanRangelOCCd4c);
            int[] gaps = i38 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(findPreviousItemIndex) : null;
            boolean z16 = z15;
            while (i37 < i36) {
                copyOf[i37] = findPreviousItemIndex;
                int mainAxisSizeWithSpacings = m956maxInRangejy6DScQ + m961getAndMeasurejy6DScQ.getMainAxisSizeWithSpacings() + (gaps == null ? 0 : gaps[i37]);
                copyOf2[i37] = mainAxisSizeWithSpacings;
                if (lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + mainAxisSizeWithSpacings <= 0) {
                    z16 = true;
                }
                i37++;
            }
            arrayDequeArr2 = arrayDequeArr3;
            z14 = z16;
        }
        ArrayDeque[] arrayDequeArr4 = arrayDequeArr2;
        boolean z17 = z14;
        int i39 = -lazyStaggeredGridMeasureContext2.getBeforeContentPadding();
        int i40 = copyOf2[i2];
        if (i40 < i39) {
            offsetBy(copyOf2, i39 - i40);
            i4 = i - (i39 - i40);
        } else {
            i4 = i;
        }
        offsetBy(copyOf2, lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i41 = -1;
        if (i3 == -1) {
            i3 = ArraysKt.indexOf(copyOf, i2);
        }
        if (i3 != -1 && measure$lambda$43$misalignedStart(copyOf, lazyStaggeredGridMeasureContext2, copyOf2, i3) && z) {
            lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
            int length2 = copyOf.length;
            int[] iArr10 = new int[length2];
            int i42 = 0;
            while (i42 < length2) {
                iArr10[i42] = i41;
                i42++;
                i41 = -1;
            }
            int length3 = copyOf2.length;
            int[] iArr11 = new int[length3];
            for (int i43 = 0; i43 < length3; i43++) {
                iArr11[i43] = copyOf2[i3];
            }
            return measure(lazyStaggeredGridMeasureContext2, i4, iArr10, iArr11, false);
        }
        int[] copyOf3 = Arrays.copyOf(copyOf, copyOf.length);
        Intrinsics.checkNotNullExpressionValue(copyOf3, "copyOf(...)");
        int length4 = copyOf2.length;
        int[] iArr12 = new int[length4];
        for (int i44 = 0; i44 < length4; i44++) {
            iArr12[i44] = -copyOf2[i44];
        }
        int mainAxisSpacing = lazyStaggeredGridMeasureContext2.getMainAxisSpacing() + i39;
        int coerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext2.getAfterContentPadding(), 0);
        ArrayDeque[] arrayDequeArr5 = arrayDequeArr4;
        int indexOfMinValue$default = indexOfMinValue$default(copyOf3, 0, 1, null);
        int i45 = 0;
        while (indexOfMinValue$default != -1 && i45 < lazyStaggeredGridMeasureContext2.getLaneCount()) {
            int i46 = copyOf3[indexOfMinValue$default];
            int indexOfMinValue = indexOfMinValue(copyOf3, i46);
            i45++;
            if (i46 >= 0) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = measureScope;
                int i47 = i4;
                long m952getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext2.m952getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i46, indexOfMinValue$default);
                LazyStaggeredGridMeasuredItem m961getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m961getAndMeasurejy6DScQ(i46, m952getSpanRangelOCCd4c2);
                LazyStaggeredGridLaneInfo laneInfo = lazyStaggeredGridMeasureContext2.getLaneInfo();
                int[] iArr13 = copyOf;
                int[] iArr14 = copyOf2;
                int i48 = (int) (m952getSpanRangelOCCd4c2 & 4294967295L);
                int i49 = itemCount;
                int i50 = (int) (m952getSpanRangelOCCd4c2 >> c);
                int i51 = i48 - i50;
                if (i51 != 1) {
                    lazyStaggeredGridLaneInfo = laneInfo;
                    i30 = -2;
                } else {
                    lazyStaggeredGridLaneInfo = laneInfo;
                    i30 = i50;
                }
                lazyStaggeredGridLaneInfo.setLane(i46, i30);
                int m956maxInRangejy6DScQ2 = m956maxInRangejy6DScQ(iArr12, m952getSpanRangelOCCd4c2);
                for (int i52 = i50; i52 < i48; i52++) {
                    iArr12[i52] = m961getAndMeasurejy6DScQ2.getMainAxisSizeWithSpacings() + m956maxInRangejy6DScQ2;
                    copyOf3[i52] = i46;
                    arrayDequeArr5[i52].addLast(m961getAndMeasurejy6DScQ2);
                }
                if (m956maxInRangejy6DScQ2 >= mainAxisSpacing || iArr12[i50] > mainAxisSpacing) {
                    z13 = z17;
                } else {
                    m961getAndMeasurejy6DScQ2.setVisible(false);
                    z13 = true;
                }
                if (i51 != 1) {
                    z17 = z13;
                    i45 = lazyStaggeredGridMeasureContext2.getLaneCount();
                    indexOfMinValue$default = indexOfMinValue;
                } else {
                    z17 = z13;
                    indexOfMinValue$default = indexOfMinValue;
                    i45 = i45;
                }
                measureScope = lazyLayoutMeasureScope2;
                i4 = i47;
                copyOf = iArr13;
                copyOf2 = iArr14;
                itemCount = i49;
            } else {
                indexOfMinValue$default = indexOfMinValue;
            }
        }
        LazyLayoutMeasureScope lazyLayoutMeasureScope3 = measureScope;
        int i53 = i4;
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
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
            copyOf3 = iArr9;
            z17 = z12;
            i54 = i5;
            str4 = str3;
            lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
            coerceAtLeast = i28;
            arrayDequeArr5 = arrayDequeArr;
            length4 = i27;
            i53 = i29;
        }
        int i58 = 0;
        while (i58 < laneCount) {
            ArrayDeque arrayDeque = arrayDequeArr5[i58];
            while (arrayDeque.size() > i6 && !((LazyStaggeredGridMeasuredItem) arrayDeque.first()).isVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst();
                int[] gaps2 = lazyStaggeredGridMeasuredItem.getSpan() != i6 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr16[i58] = iArr16[i58] - (lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings() + (gaps2 == null ? 0 : gaps2[i58]));
                i6 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDeque.firstOrNull();
            iArr15[i58] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i58++;
            i6 = 1;
        }
        int length5 = copyOf3.length;
        int i59 = 0;
        while (true) {
            if (i59 >= length5) {
                break;
            } else if (copyOf3[i59] == i5 - 1) {
                offsetBy(iArr12, -lazyStaggeredGridMeasureContext2.getMainAxisSpacing());
                break;
            } else {
                i59++;
            }
        }
        int i60 = 0;
        while (true) {
            if (i60 < length4) {
                if (iArr12[i60] >= lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                    i9 = i5;
                    i12 = i53;
                    i7 = i12;
                    iArr4 = iArr15;
                    iArr3 = iArr16;
                    i10 = coerceAtLeast;
                    i11 = length4;
                    str = str4;
                    break;
                }
                i60++;
            } else {
                int mainAxisAvailableSize = lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() - iArr12[indexOfMaxValue(iArr12)];
                iArr3 = iArr16;
                offsetBy(iArr3, -mainAxisAvailableSize);
                offsetBy(iArr12, mainAxisAvailableSize);
                boolean z18 = false;
                loop31: while (true) {
                    int length6 = iArr3.length;
                    int i61 = 0;
                    while (true) {
                        if (i61 >= length6) {
                            i7 = i53;
                            iArr4 = iArr15;
                            i8 = mainAxisAvailableSize;
                            i9 = i5;
                            i10 = coerceAtLeast;
                            break loop31;
                        }
                        if (iArr3[i61] < lazyStaggeredGridMeasureContext2.getBeforeContentPadding()) {
                            break;
                        }
                        i61++;
                        length4 = length4;
                        iArr15 = iArr15;
                        i53 = i53;
                    }
                    str4 = str2;
                    mainAxisAvailableSize = i14;
                    z18 = z2;
                    length4 = i16;
                    coerceAtLeast = i17;
                    i5 = i15;
                    iArr15 = iArr5;
                    i53 = i13;
                }
                i11 = length4;
                str = str4;
                if (z18 && z) {
                    lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                    return measure(lazyStaggeredGridMeasureContext2, i7, iArr4, iArr3, false);
                }
                i12 = i7 + i8;
                int i62 = iArr3[indexOfMinValue$default(iArr3, 0, 1, null)];
                if (i62 < 0) {
                    i12 += i62;
                    offsetBy(iArr12, i62);
                    offsetBy(iArr3, -i62);
                }
            }
        }
        float scrollToBeConsumed$foundation_release = lazyStaggeredGridMeasureContext2.getState().scrollToBeConsumed$foundation_release(lazyLayoutMeasureScope3.isLookingAhead());
        if (MathKt.getSign(Math.round(scrollToBeConsumed$foundation_release)) != MathKt.getSign(i12) || Math.abs(Math.round(scrollToBeConsumed$foundation_release)) < Math.abs(i12)) {
            iArr6 = iArr4;
            f = scrollToBeConsumed$foundation_release;
        } else {
            iArr6 = iArr4;
            f = i12;
        }
        float f3 = scrollToBeConsumed$foundation_release - f;
        float f4 = 0.0f;
        if (lazyLayoutMeasureScope3.isLookingAhead() && i12 > i7 && f3 <= 0.0f) {
            f4 = (i12 - i7) + f3;
        }
        float f5 = f4;
        int[] copyOf4 = Arrays.copyOf(iArr3, iArr3.length);
        Intrinsics.checkNotNullExpressionValue(copyOf4, str);
        int length7 = copyOf4.length;
        for (int i63 = 0; i63 < length7; i63++) {
            copyOf4[i63] = -copyOf4[i63];
        }
        if (lazyStaggeredGridMeasureContext2.getBeforeContentPadding() > lazyStaggeredGridMeasureContext2.getMainAxisSpacing()) {
            for (int i64 = 0; i64 < laneCount; i64++) {
                ArrayDeque arrayDeque2 = arrayDequeArr5[i64];
                int size2 = arrayDeque2.size();
                int i65 = 0;
                while (i65 < size2) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) arrayDeque2.get(i65);
                    int[] gaps3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int mainAxisSizeWithSpacings2 = lazyStaggeredGridMeasuredItem3.getMainAxisSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i64]);
                    if (i65 != CollectionsKt.getLastIndex(arrayDeque2) && (i26 = iArr3[i64]) != 0 && i26 >= mainAxisSizeWithSpacings2) {
                        iArr3[i64] = i26 - mainAxisSizeWithSpacings2;
                        i65++;
                        iArr6[i64] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i65)).getIndex();
                    }
                }
            }
        }
        int beforeContentPadding = lazyStaggeredGridMeasureContext2.getBeforeContentPadding() + lazyStaggeredGridMeasureContext2.getAfterContentPadding();
        if (lazyStaggeredGridMeasureContext2.isVertical()) {
            m6654constrainWidthK40F9xA = Constraints.m6637getMaxWidthimpl(lazyStaggeredGridMeasureContext2.m949getConstraintsmsEJaDk());
        } else {
            m6654constrainWidthK40F9xA = ConstraintsKt.m6654constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.m949getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(iArr12) + beforeContentPadding);
        }
        int i66 = m6654constrainWidthK40F9xA;
        if (lazyStaggeredGridMeasureContext2.isVertical()) {
            m6636getMaxHeightimpl = ConstraintsKt.m6653constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.m949getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(iArr12) + beforeContentPadding);
        } else {
            m6636getMaxHeightimpl = Constraints.m6636getMaxHeightimpl(lazyStaggeredGridMeasureContext2.m949getConstraintsmsEJaDk());
        }
        int i67 = m6636getMaxHeightimpl;
        int afterContentPadding = lazyStaggeredGridMeasureContext2.getAfterContentPadding() + (Math.min(lazyStaggeredGridMeasureContext2.isVertical() ? i67 : i66, lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i68 = copyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size3 = pinnedItems.size() - 1;
        if (size3 >= 0) {
            int i69 = size3;
            ArrayList arrayList5 = null;
            while (true) {
                int i70 = i69 - 1;
                int intValue = pinnedItems.get(i69).intValue();
                int lane = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(intValue);
                int i71 = i68;
                if (lane == -2 || lane == -1) {
                    for (int i72 = 0; i72 < laneCount; i72++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = (LazyStaggeredGridMeasuredItem) arrayDequeArr5[i72].firstOrNull();
                        if (!((lazyStaggeredGridMeasuredItem4 != null ? lazyStaggeredGridMeasuredItem4.getIndex() : -1) > intValue)) {
                            z11 = false;
                            break;
                        }
                    }
                    z11 = true;
                } else {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = (LazyStaggeredGridMeasuredItem) arrayDequeArr5[lane].firstOrNull();
                }
                if (z11) {
                    iArr7 = copyOf4;
                    long m952getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext2.m952getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), intValue, 0);
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem m961getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m961getAndMeasurejy6DScQ(intValue, m952getSpanRangelOCCd4c3);
                    int mainAxisSizeWithSpacings3 = i71 - m961getAndMeasurejy6DScQ3.getMainAxisSizeWithSpacings();
                    m961getAndMeasurejy6DScQ3.position(mainAxisSizeWithSpacings3, 0, afterContentPadding);
                    arrayList5.add(m961getAndMeasurejy6DScQ3);
                    i68 = mainAxisSizeWithSpacings3;
                } else {
                    iArr7 = copyOf4;
                    i68 = i71;
                }
                if (i70 < 0) {
                    break;
                }
                i69 = i70;
                copyOf4 = iArr7;
            }
            list = arrayList5;
        } else {
            iArr7 = copyOf4;
            list = null;
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List list4 = list;
        int[] iArr17 = iArr7;
        int i73 = i10;
        List<LazyStaggeredGridMeasuredItem> calculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext2, arrayDequeArr5, iArr17, afterContentPadding, i39, i73);
        int i74 = iArr17[0];
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem6 = (LazyStaggeredGridMeasuredItem) CollectionsKt.lastOrNull((List<? extends Object>) calculateVisibleItems);
        int index2 = lazyStaggeredGridMeasuredItem6 != null ? lazyStaggeredGridMeasuredItem6.getIndex() : -1;
        if (lazyLayoutMeasureScope3.isLookingAhead() && lazyStaggeredGridMeasureContext2.getApproachLayoutInfo() != null && !lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            List<LazyStaggeredGridItemInfo> visibleItemsInfo = lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo();
            for (int size4 = visibleItemsInfo.size() - 1; -1 < size4; size4--) {
                if (visibleItemsInfo.get(size4).getIndex() > index2 && (size4 == 0 || visibleItemsInfo.get(size4 - 1).getIndex() <= index2)) {
                    lazyStaggeredGridItemInfo = visibleItemsInfo.get(size4);
                    break;
                }
            }
            lazyStaggeredGridItemInfo = null;
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List<? extends Object>) lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (min = Math.min(lazyStaggeredGridItemInfo3.getIndex(), i9 - 1))) {
                int i75 = index;
                int i76 = i74;
                ArrayList arrayList6 = null;
                while (true) {
                    if (arrayList6 != null) {
                        int size5 = arrayList6.size();
                        list2 = calculateVisibleItems;
                        int i77 = 0;
                        while (true) {
                            if (i77 >= size5) {
                                z10 = false;
                                break;
                            }
                            int i78 = i77;
                            if (((LazyStaggeredGridMeasuredItem) arrayList6.get(i77)).getIndex() == i75) {
                                z10 = true;
                                break;
                            }
                            i77 = i78 + 1;
                        }
                        if (z10) {
                            z9 = true;
                            if (z9) {
                                if (arrayList6 == null) {
                                    arrayList6 = new ArrayList();
                                }
                                List<LazyStaggeredGridItemInfo> visibleItemsInfo2 = lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo();
                                int size6 = visibleItemsInfo2.size();
                                iArr8 = iArr6;
                                int i79 = 0;
                                while (true) {
                                    if (i79 >= size6) {
                                        lazyStaggeredGridItemInfo2 = null;
                                        break;
                                    }
                                    LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = visibleItemsInfo2.get(i79);
                                    List<LazyStaggeredGridItemInfo> list5 = visibleItemsInfo2;
                                    if (lazyStaggeredGridItemInfo4.getIndex() == i75) {
                                        lazyStaggeredGridItemInfo2 = lazyStaggeredGridItemInfo4;
                                        break;
                                    }
                                    i79++;
                                    visibleItemsInfo2 = list5;
                                }
                                LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo5 = lazyStaggeredGridItemInfo2;
                                int lane2 = lazyStaggeredGridItemInfo5 != null ? lazyStaggeredGridItemInfo5.getLane() : 0;
                                f2 = f5;
                                LazyStaggeredGridMeasuredItem m961getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m961getAndMeasurejy6DScQ(i75, lazyStaggeredGridMeasureContext2.m952getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i75, lane2));
                                arrayList6.add(m961getAndMeasurejy6DScQ4);
                                int[] positions = lazyStaggeredGridMeasureContext2.getResolvedSlots().getPositions();
                                m961getAndMeasurejy6DScQ4.position(i76, positions.length > lane2 ? positions[lane2] : 0, afterContentPadding);
                                i76 += m961getAndMeasurejy6DScQ4.getMainAxisSizeWithSpacings();
                            } else {
                                iArr8 = iArr6;
                                f2 = f5;
                            }
                            if (i75 != min) {
                                break;
                            }
                            i75++;
                            calculateVisibleItems = list2;
                            iArr6 = iArr8;
                            f5 = f2;
                        }
                    } else {
                        list2 = calculateVisibleItems;
                    }
                    z9 = false;
                    if (z9) {
                    }
                    if (i75 != min) {
                    }
                }
                arrayList = arrayList6;
                i74 = i76;
                List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext2.getPinnedItems();
                size = pinnedItems2.size();
                i18 = 0;
                arrayList2 = null;
                while (i18 < size) {
                    int intValue2 = pinnedItems2.get(i18).intValue();
                    int i80 = i9;
                    if (intValue2 >= i80) {
                        arrayList4 = arrayList;
                        list3 = pinnedItems2;
                    } else {
                        if (arrayList != null) {
                            int size7 = arrayList.size();
                            list3 = pinnedItems2;
                            int i81 = 0;
                            while (true) {
                                if (i81 >= size7) {
                                    arrayList4 = arrayList;
                                    z8 = false;
                                    break;
                                }
                                arrayList4 = arrayList;
                                if (((LazyStaggeredGridMeasuredItem) arrayList.get(i81)).getIndex() == intValue2) {
                                    z8 = true;
                                    break;
                                }
                                i81++;
                                arrayList = arrayList4;
                            }
                            if (z8) {
                                z6 = true;
                                if (!z6) {
                                    int lane3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(intValue2);
                                    if (lane3 != -2 && lane3 != -1) {
                                    }
                                    for (int i82 : copyOf3) {
                                        if (i82 < intValue2) {
                                        }
                                    }
                                    z7 = true;
                                    if (z7) {
                                        i24 = size;
                                        i25 = i18;
                                    } else {
                                        i24 = size;
                                        long m952getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext2.m952getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), intValue2, 0);
                                        if (arrayList2 == null) {
                                            arrayList2 = new ArrayList();
                                        }
                                        i25 = i18;
                                        List list6 = arrayList2;
                                        LazyStaggeredGridMeasuredItem m961getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m961getAndMeasurejy6DScQ(intValue2, m952getSpanRangelOCCd4c4);
                                        m961getAndMeasurejy6DScQ5.position(i74, 0, afterContentPadding);
                                        i74 += m961getAndMeasurejy6DScQ5.getMainAxisSizeWithSpacings();
                                        list6.add(m961getAndMeasurejy6DScQ5);
                                        arrayList2 = list6;
                                    }
                                    i18 = i25 + 1;
                                    pinnedItems2 = list3;
                                    size = i24;
                                    arrayList = arrayList4;
                                    i9 = i80;
                                }
                            }
                        } else {
                            arrayList4 = arrayList;
                            list3 = pinnedItems2;
                        }
                        z6 = false;
                        if (!z6) {
                        }
                    }
                    z7 = false;
                    if (z7) {
                    }
                    i18 = i25 + 1;
                    pinnedItems2 = list3;
                    size = i24;
                    arrayList = arrayList4;
                    i9 = i80;
                }
                int i83 = i9;
                arrayList3 = arrayList;
                if (arrayList2 == null) {
                    arrayList2 = CollectionsKt.emptyList();
                }
                final ArrayList arrayList7 = new ArrayList();
                arrayList7.addAll(list4);
                arrayList7.addAll(list2);
                if (arrayList3 != null) {
                    arrayList7.addAll(arrayList3);
                }
                arrayList7.addAll(arrayList2);
                lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation_release().onMeasured((int) f, i66, i67, arrayList7, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.isVertical(), lazyLayoutMeasureScope3.isLookingAhead(), lazyStaggeredGridMeasureContext2.getLaneCount(), lazyStaggeredGridMeasureContext2.isInLookaheadScope(), ArraysKt.minOrThrow(iArr3), ArraysKt.maxOrThrow(iArr12) + beforeContentPadding, lazyStaggeredGridMeasureContext2.getCoroutineScope(), lazyStaggeredGridMeasureContext2.getGraphicsContext());
                if (!lazyLayoutMeasureScope3.isLookingAhead()) {
                    long m906getMinSizeToFitDisappearingItemsYbymL2g2 = lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation_release().m906getMinSizeToFitDisappearingItemsYbymL2g();
                    if (!IntSize.m6853equalsimpl0(m906getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.Companion.m6860getZeroYbymL2g())) {
                        int i84 = lazyStaggeredGridMeasureContext2.isVertical() ? i67 : i66;
                        int m6654constrainWidthK40F9xA2 = ConstraintsKt.m6654constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.m949getConstraintsmsEJaDk(), Math.max(i66, (int) (m906getMinSizeToFitDisappearingItemsYbymL2g2 >> c)));
                        int m6653constrainHeightK40F9xA = ConstraintsKt.m6653constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.m949getConstraintsmsEJaDk(), Math.max(i67, (int) (m906getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                        int i85 = lazyStaggeredGridMeasureContext2.isVertical() ? m6653constrainHeightK40F9xA : m6654constrainWidthK40F9xA2;
                        if (i85 != i84) {
                            int size8 = arrayList7.size();
                            for (int i86 = 0; i86 < size8; i86++) {
                                arrayList7.get(i86).updateMainAxisLayoutSize(i85);
                            }
                        }
                        i19 = m6654constrainWidthK40F9xA2;
                        i20 = m6653constrainHeightK40F9xA;
                        i21 = i11;
                        i22 = 0;
                        while (true) {
                            if (i22 >= i21) {
                                z3 = false;
                                break;
                            }
                            if (iArr12[i22] > lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                                z3 = true;
                                break;
                            }
                            i22++;
                        }
                        if (!z3) {
                            int length8 = copyOf3.length;
                            int i87 = 0;
                            while (true) {
                                if (i87 >= length8) {
                                    z5 = true;
                                    break;
                                }
                                if (!(copyOf3[i87] < i83 + (-1))) {
                                    z5 = false;
                                    break;
                                }
                                i87++;
                            }
                            if (!z5) {
                                i23 = i83;
                                z4 = false;
                                final LazyLayoutMeasureScope lazyLayoutMeasureScope4 = lazyLayoutMeasureScope3;
                                return new LazyStaggeredGridMeasureResult(iArr8, iArr3, f, MeasureScope.layout$default(lazyLayoutMeasureScope3, i19, i20, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$33
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                        final List<LazyStaggeredGridMeasuredItem> list7 = arrayList7;
                                        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = LazyStaggeredGridMeasureContext.this;
                                        final LazyLayoutMeasureScope lazyLayoutMeasureScope5 = lazyLayoutMeasureScope4;
                                        placementScope.withMotionFrameOfReferencePlacement(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$33.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope2) {
                                                invoke2(placementScope2);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2(Placeable.PlacementScope placementScope2) {
                                                List<LazyStaggeredGridMeasuredItem> list8 = list7;
                                                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = lazyStaggeredGridMeasureContext3;
                                                LazyLayoutMeasureScope lazyLayoutMeasureScope6 = lazyLayoutMeasureScope5;
                                                int size9 = list8.size();
                                                for (int i88 = 0; i88 < size9; i88++) {
                                                    list8.get(i88).place(placementScope2, lazyStaggeredGridMeasureContext4, lazyLayoutMeasureScope6.isLookingAhead());
                                                }
                                            }
                                        });
                                        ObservableScopeInvalidator.m918attachToScopeimpl(LazyStaggeredGridMeasureContext.this.getState().m965getPlacementScopeInvalidatorzYiylxw$foundation_release());
                                    }
                                }, 4, null), f2, z4, lazyStaggeredGridMeasureContext2.isVertical(), z17, lazyStaggeredGridMeasureContext2.getResolvedSlots(), lazyStaggeredGridMeasureContext2.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope4, i23, list2, IntSize.m6850constructorimpl((i20 & 4294967295L) | (i19 << c)), i39, i73, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), lazyStaggeredGridMeasureContext2.getCoroutineScope(), null);
                            }
                        }
                        i23 = i83;
                        z4 = true;
                        final LazyLayoutMeasureScope lazyLayoutMeasureScope42 = lazyLayoutMeasureScope3;
                        return new LazyStaggeredGridMeasureResult(iArr8, iArr3, f, MeasureScope.layout$default(lazyLayoutMeasureScope3, i19, i20, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$33
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                final List<LazyStaggeredGridMeasuredItem> list7 = arrayList7;
                                final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = LazyStaggeredGridMeasureContext.this;
                                final LazyLayoutMeasureScope lazyLayoutMeasureScope5 = lazyLayoutMeasureScope42;
                                placementScope.withMotionFrameOfReferencePlacement(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$33.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope2) {
                                        invoke2(placementScope2);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope2) {
                                        List<LazyStaggeredGridMeasuredItem> list8 = list7;
                                        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = lazyStaggeredGridMeasureContext3;
                                        LazyLayoutMeasureScope lazyLayoutMeasureScope6 = lazyLayoutMeasureScope5;
                                        int size9 = list8.size();
                                        for (int i88 = 0; i88 < size9; i88++) {
                                            list8.get(i88).place(placementScope2, lazyStaggeredGridMeasureContext4, lazyLayoutMeasureScope6.isLookingAhead());
                                        }
                                    }
                                });
                                ObservableScopeInvalidator.m918attachToScopeimpl(LazyStaggeredGridMeasureContext.this.getState().m965getPlacementScopeInvalidatorzYiylxw$foundation_release());
                            }
                        }, 4, null), f2, z4, lazyStaggeredGridMeasureContext2.isVertical(), z17, lazyStaggeredGridMeasureContext2.getResolvedSlots(), lazyStaggeredGridMeasureContext2.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope42, i23, list2, IntSize.m6850constructorimpl((i20 & 4294967295L) | (i19 << c)), i39, i73, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), lazyStaggeredGridMeasureContext2.getCoroutineScope(), null);
                    }
                }
                i19 = i66;
                i20 = i67;
                i21 = i11;
                i22 = 0;
                while (true) {
                    if (i22 >= i21) {
                    }
                    i22++;
                }
                if (!z3) {
                }
                i23 = i83;
                z4 = true;
                final LazyLayoutMeasureScope lazyLayoutMeasureScope422 = lazyLayoutMeasureScope3;
                return new LazyStaggeredGridMeasureResult(iArr8, iArr3, f, MeasureScope.layout$default(lazyLayoutMeasureScope3, i19, i20, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$33
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope) {
                        final List<LazyStaggeredGridMeasuredItem> list7 = arrayList7;
                        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = LazyStaggeredGridMeasureContext.this;
                        final LazyLayoutMeasureScope lazyLayoutMeasureScope5 = lazyLayoutMeasureScope422;
                        placementScope.withMotionFrameOfReferencePlacement(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$33.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope2) {
                                invoke2(placementScope2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope2) {
                                List<LazyStaggeredGridMeasuredItem> list8 = list7;
                                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = lazyStaggeredGridMeasureContext3;
                                LazyLayoutMeasureScope lazyLayoutMeasureScope6 = lazyLayoutMeasureScope5;
                                int size9 = list8.size();
                                for (int i88 = 0; i88 < size9; i88++) {
                                    list8.get(i88).place(placementScope2, lazyStaggeredGridMeasureContext4, lazyLayoutMeasureScope6.isLookingAhead());
                                }
                            }
                        });
                        ObservableScopeInvalidator.m918attachToScopeimpl(LazyStaggeredGridMeasureContext.this.getState().m965getPlacementScopeInvalidatorzYiylxw$foundation_release());
                    }
                }, 4, null), f2, z4, lazyStaggeredGridMeasureContext2.isVertical(), z17, lazyStaggeredGridMeasureContext2.getResolvedSlots(), lazyStaggeredGridMeasureContext2.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope422, i23, list2, IntSize.m6850constructorimpl((i20 & 4294967295L) | (i19 << c)), i39, i73, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), lazyStaggeredGridMeasureContext2.getCoroutineScope(), null);
            }
        }
        list2 = calculateVisibleItems;
        iArr8 = iArr6;
        f2 = f5;
        arrayList = null;
        List<Integer> pinnedItems22 = lazyStaggeredGridMeasureContext2.getPinnedItems();
        size = pinnedItems22.size();
        i18 = 0;
        arrayList2 = null;
        while (i18 < size) {
        }
        int i832 = i9;
        arrayList3 = arrayList;
        if (arrayList2 == null) {
        }
        final List<LazyStaggeredGridMeasuredItem> arrayList72 = new ArrayList();
        arrayList72.addAll(list4);
        arrayList72.addAll(list2);
        if (arrayList3 != null) {
        }
        arrayList72.addAll(arrayList2);
        lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation_release().onMeasured((int) f, i66, i67, arrayList72, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.isVertical(), lazyLayoutMeasureScope3.isLookingAhead(), lazyStaggeredGridMeasureContext2.getLaneCount(), lazyStaggeredGridMeasureContext2.isInLookaheadScope(), ArraysKt.minOrThrow(iArr3), ArraysKt.maxOrThrow(iArr12) + beforeContentPadding, lazyStaggeredGridMeasureContext2.getCoroutineScope(), lazyStaggeredGridMeasureContext2.getGraphicsContext());
        if (!lazyLayoutMeasureScope3.isLookingAhead()) {
        }
        i19 = i66;
        i20 = i67;
        i21 = i11;
        i22 = 0;
        while (true) {
            if (i22 >= i21) {
            }
            i22++;
        }
        if (!z3) {
        }
        i23 = i832;
        z4 = true;
        final LazyLayoutMeasureScope lazyLayoutMeasureScope4222 = lazyLayoutMeasureScope3;
        return new LazyStaggeredGridMeasureResult(iArr8, iArr3, f, MeasureScope.layout$default(lazyLayoutMeasureScope3, i19, i20, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$33
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                final List<LazyStaggeredGridMeasuredItem> list7 = arrayList72;
                final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = LazyStaggeredGridMeasureContext.this;
                final LazyLayoutMeasureScope lazyLayoutMeasureScope5 = lazyLayoutMeasureScope4222;
                placementScope.withMotionFrameOfReferencePlacement(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$33.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope2) {
                        invoke2(placementScope2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope2) {
                        List<LazyStaggeredGridMeasuredItem> list8 = list7;
                        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = lazyStaggeredGridMeasureContext3;
                        LazyLayoutMeasureScope lazyLayoutMeasureScope6 = lazyLayoutMeasureScope5;
                        int size9 = list8.size();
                        for (int i88 = 0; i88 < size9; i88++) {
                            list8.get(i88).place(placementScope2, lazyStaggeredGridMeasureContext4, lazyLayoutMeasureScope6.isLookingAhead());
                        }
                    }
                });
                ObservableScopeInvalidator.m918attachToScopeimpl(LazyStaggeredGridMeasureContext.this.getState().m965getPlacementScopeInvalidatorzYiylxw$foundation_release());
            }
        }, 4, null), f2, z4, lazyStaggeredGridMeasureContext2.isVertical(), z17, lazyStaggeredGridMeasureContext2.getResolvedSlots(), lazyStaggeredGridMeasureContext2.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope4222, i23, list2, IntSize.m6850constructorimpl((i20 & 4294967295L) | (i19 << c)), i39, i73, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), lazyStaggeredGridMeasureContext2.getCoroutineScope(), null);
    }

    private static final boolean measure$lambda$43$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$43$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
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
                        long m967constructorimpl = SpanRange.m967constructorimpl(removeFirst.getLane(), removeFirst.getSpan());
                        int m956maxInRangejy6DScQ = m956maxInRangejy6DScQ(iArr, m967constructorimpl);
                        int i8 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i5];
                        if (removeFirst.getMainAxisSize() + m956maxInRangejy6DScQ >= i2 && m956maxInRangejy6DScQ <= i3) {
                            removeFirst.position(m956maxInRangejy6DScQ, i8, i);
                            arrayList.add(removeFirst);
                        }
                        int i9 = (int) (m967constructorimpl & 4294967295L);
                        for (int i10 = (int) (m967constructorimpl >> 32); i10 < i9; i10++) {
                            iArr[i10] = removeFirst.getMainAxisSizeWithSpacings() + m956maxInRangejy6DScQ;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        r8 = r10.get(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<LazyStaggeredGridMeasuredItem> itemsRetainedForLookahead(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2, boolean z, Function2<? super LazyStaggeredGridMeasuredItem, ? super Integer, Unit> function2) {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int min;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        if (z && lazyStaggeredGridMeasureContext.getApproachLayoutInfo() != null && !lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            List<LazyStaggeredGridItemInfo> visibleItemsInfo = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
            int size = visibleItemsInfo.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    lazyStaggeredGridItemInfo = null;
                    break;
                } else if (visibleItemsInfo.get(size).getIndex() <= i || (size != 0 && visibleItemsInfo.get(size - 1).getIndex() > i)) {
                }
            }
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3 = (LazyStaggeredGridItemInfo) CollectionsKt.last((List<? extends Object>) lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo());
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
                    List<LazyStaggeredGridItemInfo> visibleItemsInfo2 = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
                    int size3 = visibleItemsInfo2.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            lazyStaggeredGridItemInfo2 = null;
                            break;
                        }
                        lazyStaggeredGridItemInfo2 = visibleItemsInfo2.get(i4);
                        if (lazyStaggeredGridItemInfo2.getIndex() == index) {
                            break;
                        }
                        i4++;
                    }
                    LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = lazyStaggeredGridItemInfo2;
                    int lane = lazyStaggeredGridItemInfo4 != null ? lazyStaggeredGridItemInfo4.getLane() : 0;
                    LazyStaggeredGridMeasuredItem m961getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m961getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m952getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                    arrayList.add(m961getAndMeasurejy6DScQ);
                    int[] positions = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                    function2.invoke(m961getAndMeasurejy6DScQ, Integer.valueOf(positions.length > lane ? positions[lane] : 0));
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
                        long m952getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m952getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem m961getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m961getAndMeasurejy6DScQ(intValue, m952getSpanRangelOCCd4c);
                        function1.invoke(m961getAndMeasurejy6DScQ);
                        arrayList.add(m961getAndMeasurejy6DScQ);
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
                    long m952getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m952getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem m961getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m961getAndMeasurejy6DScQ(intValue2, m952getSpanRangelOCCd4c2);
                    function1.invoke(m961getAndMeasurejy6DScQ2);
                    arrayList.add(m961getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* renamed from: forEach-nIS5qE8  reason: not valid java name */
    private static final void m955forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
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
    private static final int m956maxInRangejy6DScQ(int[] iArr, long j) {
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
            if (iArr[length] >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), iArr[length])) {
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[length], length);
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
}
