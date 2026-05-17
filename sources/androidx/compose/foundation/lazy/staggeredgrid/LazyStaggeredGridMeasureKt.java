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
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0002¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0082\b\u001a£\u0001\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102\u001a,\u00103\u001a\u00020\u0015*\u0002042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0001H\u0002\u001aK\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010@\u001aG\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0019*\u0002042\u0006\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00012\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110EH\u0082\b\u001aR\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u00072!\u0010G\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010K\u001a\u00020\u0001H\u0082\b\u001a7\u0010L\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00192\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b\u001a(\u0010O\u001a\u00020\u0011*\u00020P2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b¢\u0006\u0004\bQ\u0010R\u001a\u0014\u0010S\u001a\u00020\u0011*\u0002072\u0006\u0010T\u001a\u00020\u001aH\u0002\u001a\u001b\u0010U\u001a\u00020\u001a*\u0002072\u0006\u0010V\u001a\u00020PH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0016\u0010Y\u001a\u00020\u001a*\u0002072\b\b\u0002\u0010Z\u001a\u00020\u001aH\u0000\u001a2\u0010[\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b¢\u0006\u0002\u0010\\\u001a\f\u0010]\u001a\u00020\u001a*\u000207H\u0002\u001a!\u0010^\u001a\u000207*\u0002072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b\u001a\u001c\u0010_\u001a\u00020\u0011*\u0002042\u0006\u0010`\u001a\u0002072\u0006\u0010a\u001a\u00020\u001aH\u0002\u001a\u001c\u0010b\u001a\u00020\u001a*\u0002042\u0006\u0010c\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"DebugLoggingEnabled", "", "withDebugLogging", ExifInterface.GPS_DIRECTION_TRUE, "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "debugRender", "", "", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "debugLog", "", "message", "Lkotlin/Function0;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "initialItemIndices", "", "initialItemOffsets", "canRestartMeasure", "calculateVisibleItems", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "position", "Lkotlin/Function2;", "calculateExtraItems", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "fastForEach", "reverse", "action", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "offsetBy", "delta", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "indexOfMinValue", "minBound", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMaxValue", "transform", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "Unset", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
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
    public static final LazyStaggeredGridMeasureResult m1044measureStaggeredGridC6celF4(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        int i5;
        int m1043maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo, graphicsContext, null);
        int[] updateScrollPositionIfTheFirstItemWasMoved$foundation = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition$foundation().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition$foundation().getScrollOffsets();
        if (updateScrollPositionIfTheFirstItemWasMoved$foundation.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= updateScrollPositionIfTheFirstItemWasMoved$foundation.length || (m1043maxInRangejy6DScQ = updateScrollPositionIfTheFirstItemWasMoved$foundation[i6]) == -1) {
                    m1043maxInRangejy6DScQ = i6 == 0 ? 0 : m1043maxInRangejy6DScQ(iArr, SpanRange.m1053constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = m1043maxInRangejy6DScQ;
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

    /* JADX WARN: Code restructure failed: missing block: B:106:0x023e, code lost:
        r6 = indexOfMinValue$default(r14, 0, 1, null);
        r1 = kotlin.collections.ArraysKt.maxOrThrow(r8) + 1;
        r12 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0249, code lost:
        if (r1 < r12) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02f8, code lost:
        r6 = indexOfMinValue$default(r9, 0, 1, null);
        r7 = indexOfMaxValue(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0303, code lost:
        if (r6 == r7) goto L429;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0309, code lost:
        if (r9[r6] != r9[r7]) goto L428;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x030b, code lost:
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x030d, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x030e, code lost:
        r7 = r28[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0311, code lost:
        if (r7 != (-1)) goto L432;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0313, code lost:
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0314, code lost:
        r7 = findPreviousItemIndex(r0, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0318, code lost:
        if (r7 >= 0) goto L434;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x031a, code lost:
        r10 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x031c, code lost:
        if (r1 != false) goto L470;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0322, code lost:
        if (measure$lambda$0$misalignedStart(r10, r0, r9, r6) == false) goto L461;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0324, code lost:
        if (r50 == false) goto L461;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0326, code lost:
        r0.getLaneInfo().reset();
        r1 = r10.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0331, code lost:
        if (r3 >= r1) goto L474;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0333, code lost:
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x033a, code lost:
        r1 = r9.length;
        r3 = new int[r1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x033e, code lost:
        if (r4 >= r1) goto L478;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0340, code lost:
        r3[r4] = r9[r6];
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x034e, code lost:
        return measure(r0, r27, r2, r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x034f, code lost:
        r11 = r27;
        r24 = r2;
        r28 = r3;
        r30 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0359, code lost:
        r11 = r27;
        r10 = r28;
        r25 = r1;
        r24 = r2;
        r1 = r0.m1038getSpanRangelOCCd4c(r0.getItemProvider(), r7, r6);
        r6 = r0.getLaneInfo();
        r30 = r12;
        r27 = r13;
        r12 = (int) (r1 & 4294967295L);
        r28 = r3;
        r13 = r4;
        r3 = (int) (r1 >> r18);
        r4 = r12 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x037d, code lost:
        if (r4 == 1) goto L455;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x037f, code lost:
        r15 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0381, code lost:
        r15 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0382, code lost:
        r6.setLane(r7, r15);
        r6 = r0.getMeasuredItemProvider().m1047getAndMeasurejy6DScQ(r7, r1);
        r1 = m1043maxInRangejy6DScQ(r9, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0392, code lost:
        if (r4 == 1) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0394, code lost:
        r2 = r0.getLaneInfo().getGaps(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x039d, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x039e, code lost:
        if (r3 >= r12) goto L452;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x03a2, code lost:
        if (r9[r3] == r1) goto L445;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x03a4, code lost:
        r25 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03a6, code lost:
        r49[r3].addFirst(r6);
        r10[r3] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03ad, code lost:
        if (r2 != null) goto L450;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03af, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03b1, code lost:
        r4 = r2[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03b3, code lost:
        r9[r3] = (r1 + r6.getMainAxisSizeWithSpacings()) + r4;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0570, code lost:
        if ((r1 != null ? r1.getIndex() : -1) > r15) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x076e, code lost:
        if (r8[r1] < r7) goto L308;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x08c5, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0929, code lost:
        r7 = r13;
        r13 = r4;
        r15 = r48;
        r7 = r49;
        r24 = r3;
        r30 = r12;
        r12 = r26;
        r11 = r27;
        r3 = r0.m1038getSpanRangelOCCd4c(r0.getItemProvider(), r1, r6);
        r6 = r0.getLaneInfo();
        r47 = r8;
        r7 = (int) (r3 & 4294967295L);
        r8 = (int) (r3 >> r18);
        r9 = r7 - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0956, code lost:
        if (r9 == 1) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0958, code lost:
        r0 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x095a, code lost:
        r0 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x095b, code lost:
        r6.setLane(r1, r0);
        r0 = r46.getMeasuredItemProvider().m1047getAndMeasurejy6DScQ(r1, r3);
        r3 = m1043maxInRangejy6DScQ(r14, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x096b, code lost:
        if (r9 == 1) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x096d, code lost:
        r6 = r46.getLaneInfo().getGaps(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x0975, code lost:
        if (r6 != null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x0977, code lost:
        r6 = new int[r46.getLaneCount()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x097e, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x097f, code lost:
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0980, code lost:
        if (r9 >= r7) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0982, code lost:
        if (r6 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x0984, code lost:
        r6[r9] = r3 - r14[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x098a, code lost:
        r47[r9] = r1;
        r14[r9] = r3 + r0.getMainAxisSizeWithSpacings();
        r7[r9].addLast(r0);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x099d, code lost:
        r46.getLaneInfo().setGaps(r1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x09a4, code lost:
        if (r3 >= r2) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x09a8, code lost:
        if (r14[r8] > r2) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x09aa, code lost:
        r0.setVisible(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0228, code lost:
        r11 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0725  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x07c3  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x07dc  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0838  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x08aa  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x08b6 A[SYNTHETIC] */
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
        int m7525constrainWidthK40F9xA;
        int m7507getMaxHeightimpl;
        int[] iArr7;
        List list;
        List<LazyStaggeredGridMeasuredItem> list2;
        int[] iArr8;
        float f2;
        int[] iArr9;
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
        List<Integer> list3;
        ArrayList arrayList4;
        int i23;
        int i24;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int min;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        int i25;
        int i26;
        String str3;
        boolean z4;
        ArrayDeque[] arrayDequeArr;
        int i27;
        LazyLayoutMeasureScope lazyLayoutMeasureScope;
        int i28;
        int[] iArr10;
        LazyStaggeredGridLaneInfo lazyStaggeredGridLaneInfo;
        int i29;
        boolean z5;
        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext2.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext2.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext2.getLaneCount() == 0) {
            int m7510getMinWidthimpl = Constraints.m7510getMinWidthimpl(lazyStaggeredGridMeasureContext.m1035getConstraintsmsEJaDk());
            int m7509getMinHeightimpl = Constraints.m7509getMinHeightimpl(lazyStaggeredGridMeasureContext.m1035getConstraintsmsEJaDk());
            lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().onMeasured(0, m7510getMinWidthimpl, m7509getMinHeightimpl, new ArrayList(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.isVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.isInLookaheadScope(), 0, 0, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
            if (!measureScope.isLookingAhead()) {
                long m987getMinSizeToFitDisappearingItemsYbymL2g = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation().m987getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m7724equalsimpl0(m987getMinSizeToFitDisappearingItemsYbymL2g, IntSize.Companion.m7731getZeroYbymL2g())) {
                    m7510getMinWidthimpl = ConstraintsKt.m7525constrainWidthK40F9xA(lazyStaggeredGridMeasureContext.m1035getConstraintsmsEJaDk(), (int) (m987getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    m7509getMinHeightimpl = ConstraintsKt.m7524constrainHeightK40F9xA(lazyStaggeredGridMeasureContext.m1035getConstraintsmsEJaDk(), (int) (m987getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.layout$default(measureScope, m7510getMinWidthimpl, m7509getMinHeightimpl, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit measure$lambda$0$0;
                    measure$lambda$0$0 = LazyStaggeredGridMeasureKt.measure$lambda$0$0((Placeable.PlacementScope) obj);
                    return measure$lambda$0$0;
                }
            }, 4, null), 0.0f, false, lazyStaggeredGridMeasureContext.isVertical(), false, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), measureScope, itemCount, CollectionsKt.emptyList(), IntSize.m7721constructorimpl((Constraints.m7509getMinHeightimpl(lazyStaggeredGridMeasureContext.m1035getConstraintsmsEJaDk()) & 4294967295L) | (Constraints.m7510getMinWidthimpl(lazyStaggeredGridMeasureContext.m1035getConstraintsmsEJaDk()) << 32)), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
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
        for (int i30 = 0; i30 < laneCount; i30++) {
            arrayDequeArr2[i30] = new ArrayDeque(16);
        }
        offsetBy(copyOf2, -lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        boolean z6 = false;
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
            long m1038getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext2.m1038getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), findPreviousItemIndex, i3);
            int i35 = (int) (m1038getSpanRangelOCCd4c & 4294967295L);
            ArrayDeque[] arrayDequeArr3 = arrayDequeArr2;
            boolean z7 = z6;
            int i36 = (int) (m1038getSpanRangelOCCd4c >> 32);
            int i37 = i35 - i36;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(findPreviousItemIndex, i37 != 1 ? -2 : i36);
            LazyStaggeredGridMeasuredItem m1047getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1047getAndMeasurejy6DScQ(findPreviousItemIndex, m1038getSpanRangelOCCd4c);
            int m1043maxInRangejy6DScQ = m1043maxInRangejy6DScQ(copyOf2, m1038getSpanRangelOCCd4c);
            int[] gaps = i37 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(findPreviousItemIndex) : null;
            boolean z8 = z7;
            while (i36 < i35) {
                copyOf[i36] = findPreviousItemIndex;
                int mainAxisSizeWithSpacings = m1043maxInRangejy6DScQ + m1047getAndMeasurejy6DScQ.getMainAxisSizeWithSpacings() + (gaps == null ? 0 : gaps[i36]);
                copyOf2[i36] = mainAxisSizeWithSpacings;
                if (lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + mainAxisSizeWithSpacings <= 0) {
                    z8 = true;
                }
                i36++;
            }
            arrayDequeArr2 = arrayDequeArr3;
            z6 = z8;
        }
        ArrayDeque[] arrayDequeArr4 = arrayDequeArr2;
        boolean z9 = z6;
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
            int[] iArr11 = new int[length2];
            int i41 = 0;
            while (i41 < length2) {
                iArr11[i41] = i40;
                i41++;
                i40 = -1;
            }
            int length3 = copyOf2.length;
            int[] iArr12 = new int[length3];
            for (int i42 = 0; i42 < length3; i42++) {
                iArr12[i42] = copyOf2[i3];
            }
            return measure(lazyStaggeredGridMeasureContext2, i4, iArr11, iArr12, false);
        }
        int[] copyOf3 = Arrays.copyOf(copyOf, copyOf.length);
        Intrinsics.checkNotNullExpressionValue(copyOf3, "copyOf(...)");
        int length4 = copyOf2.length;
        int[] iArr13 = new int[length4];
        for (int i43 = 0; i43 < length4; i43++) {
            iArr13[i43] = -copyOf2[i43];
        }
        int mainAxisSpacing = lazyStaggeredGridMeasureContext2.getMainAxisSpacing() + i38;
        int coerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext2.getAfterContentPadding(), 0);
        ArrayDeque[] arrayDequeArr5 = arrayDequeArr4;
        int indexOfMinValue$default = indexOfMinValue$default(copyOf3, 0, 1, null);
        int i44 = 0;
        while (indexOfMinValue$default != -1 && i44 < lazyStaggeredGridMeasureContext2.getLaneCount()) {
            int i45 = copyOf3[indexOfMinValue$default];
            int indexOfMinValue = indexOfMinValue(copyOf3, i45);
            i44++;
            if (i45 >= 0) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = measureScope;
                int i46 = i4;
                long m1038getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext2.m1038getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i45, indexOfMinValue$default);
                LazyStaggeredGridMeasuredItem m1047getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1047getAndMeasurejy6DScQ(i45, m1038getSpanRangelOCCd4c2);
                LazyStaggeredGridLaneInfo laneInfo = lazyStaggeredGridMeasureContext2.getLaneInfo();
                int[] iArr14 = copyOf;
                int[] iArr15 = copyOf2;
                int i47 = (int) (m1038getSpanRangelOCCd4c2 & 4294967295L);
                int i48 = itemCount;
                int i49 = (int) (m1038getSpanRangelOCCd4c2 >> c);
                int i50 = i47 - i49;
                if (i50 != 1) {
                    lazyStaggeredGridLaneInfo = laneInfo;
                    i29 = -2;
                } else {
                    lazyStaggeredGridLaneInfo = laneInfo;
                    i29 = i49;
                }
                lazyStaggeredGridLaneInfo.setLane(i45, i29);
                int m1043maxInRangejy6DScQ2 = m1043maxInRangejy6DScQ(iArr13, m1038getSpanRangelOCCd4c2);
                for (int i51 = i49; i51 < i47; i51++) {
                    iArr13[i51] = m1047getAndMeasurejy6DScQ2.getMainAxisSizeWithSpacings() + m1043maxInRangejy6DScQ2;
                    copyOf3[i51] = i45;
                    arrayDequeArr5[i51].addLast(m1047getAndMeasurejy6DScQ2);
                }
                if (m1043maxInRangejy6DScQ2 >= mainAxisSpacing || iArr13[i49] > mainAxisSpacing) {
                    z5 = z9;
                } else {
                    m1047getAndMeasurejy6DScQ2.setVisible(false);
                    z5 = true;
                }
                if (i50 != 1) {
                    z9 = z5;
                    i44 = lazyStaggeredGridMeasureContext2.getLaneCount();
                    indexOfMinValue$default = indexOfMinValue;
                } else {
                    z9 = z5;
                    indexOfMinValue$default = indexOfMinValue;
                    i44 = i44;
                }
                measureScope = lazyLayoutMeasureScope2;
                i4 = i46;
                copyOf = iArr14;
                copyOf2 = iArr15;
                itemCount = i48;
            } else {
                indexOfMinValue$default = indexOfMinValue;
            }
        }
        LazyLayoutMeasureScope lazyLayoutMeasureScope3 = measureScope;
        int i52 = i4;
        int[] iArr16 = copyOf;
        int[] iArr17 = copyOf2;
        int i53 = itemCount;
        loop9: while (true) {
            int i54 = 0;
            while (true) {
                if (i54 < length4) {
                    int i55 = iArr13[i54];
                    if (i55 < coerceAtLeast || i55 <= 0) {
                        break;
                    }
                    i54++;
                } else {
                    for (int i56 = 0; i56 < laneCount; i56++) {
                        if (!arrayDequeArr5[i56].isEmpty()) {
                            i5 = i53;
                            i6 = 1;
                            break loop9;
                        }
                    }
                }
            }
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
            copyOf3 = iArr10;
            arrayDequeArr5 = arrayDequeArr;
            lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
            str4 = str3;
            z9 = z4;
            coerceAtLeast = i27;
            length4 = i26;
            i52 = i28;
        }
        int i57 = 0;
        while (i57 < laneCount) {
            ArrayDeque arrayDeque = arrayDequeArr5[i57];
            while (arrayDeque.size() > i6 && !((LazyStaggeredGridMeasuredItem) arrayDeque.first()).isVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst();
                int[] gaps2 = lazyStaggeredGridMeasuredItem.getSpan() != i6 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr17[i57] = iArr17[i57] - (lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings() + (gaps2 == null ? 0 : gaps2[i57]));
                i6 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDeque.firstOrNull();
            iArr16[i57] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i57++;
            i6 = 1;
        }
        int length5 = copyOf3.length;
        int i58 = 0;
        while (true) {
            if (i58 >= length5) {
                break;
            } else if (copyOf3[i58] == i5 - 1) {
                offsetBy(iArr13, -lazyStaggeredGridMeasureContext2.getMainAxisSpacing());
                break;
            } else {
                i58++;
            }
        }
        int i59 = 0;
        while (true) {
            if (i59 < length4) {
                if (iArr13[i59] >= lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                    i9 = i5;
                    i12 = i52;
                    i7 = i12;
                    iArr4 = iArr16;
                    iArr3 = iArr17;
                    i10 = coerceAtLeast;
                    i11 = length4;
                    str = str4;
                    break;
                }
                i59++;
            } else {
                int mainAxisAvailableSize = lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() - iArr13[indexOfMaxValue(iArr13)];
                iArr3 = iArr17;
                offsetBy(iArr3, -mainAxisAvailableSize);
                offsetBy(iArr13, mainAxisAvailableSize);
                boolean z10 = false;
                loop31: while (true) {
                    int length6 = iArr3.length;
                    int i60 = 0;
                    while (true) {
                        if (i60 >= length6) {
                            i7 = i52;
                            iArr4 = iArr16;
                            i8 = mainAxisAvailableSize;
                            i9 = i5;
                            i10 = coerceAtLeast;
                            break loop31;
                        } else if (iArr3[i60] < lazyStaggeredGridMeasureContext2.getBeforeContentPadding()) {
                            break;
                        } else {
                            i60++;
                            length4 = length4;
                            iArr16 = iArr16;
                            i52 = i52;
                        }
                    }
                    str4 = str2;
                    mainAxisAvailableSize = i14;
                    z10 = z2;
                    length4 = i16;
                    coerceAtLeast = i17;
                    i5 = i15;
                    iArr16 = iArr5;
                    i52 = i13;
                }
                i11 = length4;
                str = str4;
                if (z10 && z) {
                    lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                    return measure(lazyStaggeredGridMeasureContext2, i7, iArr4, iArr3, false);
                }
                i12 = i7 + i8;
                int i61 = iArr3[indexOfMinValue$default(iArr3, 0, 1, null)];
                if (i61 < 0) {
                    i12 += i61;
                    offsetBy(iArr13, i61);
                    offsetBy(iArr3, -i61);
                }
            }
        }
        float scrollToBeConsumed$foundation = lazyStaggeredGridMeasureContext2.getState().scrollToBeConsumed$foundation(lazyLayoutMeasureScope3.isLookingAhead());
        if (MathKt.getSign(Math.round(scrollToBeConsumed$foundation)) != MathKt.getSign(i12) || Math.abs(Math.round(scrollToBeConsumed$foundation)) < Math.abs(i12)) {
            iArr6 = iArr4;
            f = scrollToBeConsumed$foundation;
        } else {
            iArr6 = iArr4;
            f = i12;
        }
        float f3 = scrollToBeConsumed$foundation - f;
        float f4 = 0.0f;
        if (lazyLayoutMeasureScope3.isLookingAhead() && i12 > i7 && f3 <= 0.0f) {
            f4 = (i12 - i7) + f3;
        }
        float f5 = f4;
        int[] copyOf4 = Arrays.copyOf(iArr3, iArr3.length);
        Intrinsics.checkNotNullExpressionValue(copyOf4, str);
        int length7 = copyOf4.length;
        for (int i62 = 0; i62 < length7; i62++) {
            copyOf4[i62] = -copyOf4[i62];
        }
        if (lazyStaggeredGridMeasureContext2.getBeforeContentPadding() > lazyStaggeredGridMeasureContext2.getMainAxisSpacing()) {
            for (int i63 = 0; i63 < laneCount; i63++) {
                ArrayDeque arrayDeque2 = arrayDequeArr5[i63];
                int size2 = arrayDeque2.size();
                int i64 = 0;
                while (i64 < size2) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) arrayDeque2.get(i64);
                    int[] gaps3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int mainAxisSizeWithSpacings2 = lazyStaggeredGridMeasuredItem3.getMainAxisSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i63]);
                    if (i64 != CollectionsKt.getLastIndex(arrayDeque2) && (i25 = iArr3[i63]) != 0 && i25 >= mainAxisSizeWithSpacings2) {
                        iArr3[i63] = i25 - mainAxisSizeWithSpacings2;
                        i64++;
                        iArr6[i63] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i64)).getIndex();
                    }
                }
            }
        }
        int beforeContentPadding = lazyStaggeredGridMeasureContext2.getBeforeContentPadding() + lazyStaggeredGridMeasureContext2.getAfterContentPadding();
        if (lazyStaggeredGridMeasureContext2.isVertical()) {
            m7525constrainWidthK40F9xA = Constraints.m7508getMaxWidthimpl(lazyStaggeredGridMeasureContext2.m1035getConstraintsmsEJaDk());
        } else {
            m7525constrainWidthK40F9xA = ConstraintsKt.m7525constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.m1035getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(iArr13) + beforeContentPadding);
        }
        int i65 = m7525constrainWidthK40F9xA;
        if (lazyStaggeredGridMeasureContext2.isVertical()) {
            m7507getMaxHeightimpl = ConstraintsKt.m7524constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.m1035getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(iArr13) + beforeContentPadding);
        } else {
            m7507getMaxHeightimpl = Constraints.m7507getMaxHeightimpl(lazyStaggeredGridMeasureContext2.m1035getConstraintsmsEJaDk());
        }
        int i66 = m7507getMaxHeightimpl;
        int afterContentPadding = lazyStaggeredGridMeasureContext2.getAfterContentPadding() + (Math.min(lazyStaggeredGridMeasureContext2.isVertical() ? i66 : i65, lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i67 = copyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size3 = pinnedItems.size() - 1;
        if (size3 >= 0) {
            int i68 = size3;
            ArrayList arrayList5 = null;
            while (true) {
                int i69 = i68 - 1;
                int intValue = pinnedItems.get(i68).intValue();
                int lane = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(intValue);
                int i70 = i67;
                if (lane != -2 && lane != -1) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = (LazyStaggeredGridMeasuredItem) arrayDequeArr5[lane].firstOrNull();
                } else {
                    for (int i71 = 0; i71 < laneCount; i71++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = (LazyStaggeredGridMeasuredItem) arrayDequeArr5[i71].firstOrNull();
                        if ((lazyStaggeredGridMeasuredItem5 != null ? lazyStaggeredGridMeasuredItem5.getIndex() : -1) <= intValue) {
                            i67 = i70;
                            iArr7 = copyOf4;
                            break;
                        }
                    }
                    iArr7 = copyOf4;
                    long m1038getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext2.m1038getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), intValue, 0);
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem m1047getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1047getAndMeasurejy6DScQ(intValue, m1038getSpanRangelOCCd4c3);
                    int mainAxisSizeWithSpacings3 = i70 - m1047getAndMeasurejy6DScQ3.getMainAxisSizeWithSpacings();
                    m1047getAndMeasurejy6DScQ3.position(mainAxisSizeWithSpacings3, 0, afterContentPadding);
                    arrayList5.add(m1047getAndMeasurejy6DScQ3);
                    i67 = mainAxisSizeWithSpacings3;
                }
                if (i69 < 0) {
                    break;
                }
                i68 = i69;
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
        int[] iArr18 = iArr7;
        int i72 = i10;
        List<LazyStaggeredGridMeasuredItem> calculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext2, arrayDequeArr5, iArr18, afterContentPadding, i38, i72);
        int i73 = iArr18[0];
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
                int i74 = index;
                int i75 = i73;
                ArrayList arrayList6 = null;
                while (true) {
                    if (arrayList6 != null) {
                        int size5 = arrayList6.size();
                        list2 = calculateVisibleItems;
                        int i76 = 0;
                        while (i76 < size5) {
                            int i77 = i76;
                            if (((LazyStaggeredGridMeasuredItem) arrayList6.get(i76)).getIndex() == i74) {
                                iArr8 = iArr6;
                                f2 = f5;
                                iArr9 = iArr3;
                                break;
                            }
                            i76 = i77 + 1;
                        }
                    } else {
                        list2 = calculateVisibleItems;
                    }
                    if (arrayList6 == null) {
                        arrayList6 = new ArrayList();
                    }
                    List<LazyStaggeredGridItemInfo> visibleItemsInfo2 = lazyStaggeredGridMeasureContext2.getApproachLayoutInfo().getVisibleItemsInfo();
                    int size6 = visibleItemsInfo2.size();
                    iArr8 = iArr6;
                    int i78 = 0;
                    while (true) {
                        if (i78 >= size6) {
                            lazyStaggeredGridItemInfo2 = null;
                            break;
                        }
                        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = visibleItemsInfo2.get(i78);
                        List<LazyStaggeredGridItemInfo> list5 = visibleItemsInfo2;
                        if (lazyStaggeredGridItemInfo4.getIndex() == i74) {
                            lazyStaggeredGridItemInfo2 = lazyStaggeredGridItemInfo4;
                            break;
                        }
                        i78++;
                        visibleItemsInfo2 = list5;
                    }
                    LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo5 = lazyStaggeredGridItemInfo2;
                    int lane2 = lazyStaggeredGridItemInfo5 != null ? lazyStaggeredGridItemInfo5.getLane() : 0;
                    f2 = f5;
                    iArr9 = iArr3;
                    LazyStaggeredGridMeasuredItem m1047getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1047getAndMeasurejy6DScQ(i74, lazyStaggeredGridMeasureContext2.m1038getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i74, lane2));
                    arrayList6.add(m1047getAndMeasurejy6DScQ4);
                    int[] positions = lazyStaggeredGridMeasureContext2.getResolvedSlots().getPositions();
                    m1047getAndMeasurejy6DScQ4.position(i75, positions.length > lane2 ? positions[lane2] : 0, afterContentPadding);
                    i75 += m1047getAndMeasurejy6DScQ4.getMainAxisSizeWithSpacings();
                    if (i74 == min) {
                        break;
                    }
                    i74++;
                    calculateVisibleItems = list2;
                    iArr6 = iArr8;
                    f5 = f2;
                    iArr3 = iArr9;
                }
                arrayList = arrayList6;
                i73 = i75;
                List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext2.getPinnedItems();
                size = pinnedItems2.size();
                i18 = 0;
                arrayList2 = null;
                while (i18 < size) {
                    int intValue2 = pinnedItems2.get(i18).intValue();
                    int i79 = i9;
                    if (intValue2 >= i79) {
                        arrayList4 = arrayList;
                        list3 = pinnedItems2;
                    } else {
                        if (arrayList != null) {
                            int size7 = arrayList.size();
                            list3 = pinnedItems2;
                            int i80 = 0;
                            while (i80 < size7) {
                                arrayList4 = arrayList;
                                if (((LazyStaggeredGridMeasuredItem) arrayList.get(i80)).getIndex() == intValue2) {
                                    break;
                                }
                                i80++;
                                arrayList = arrayList4;
                            }
                        } else {
                            list3 = pinnedItems2;
                        }
                        arrayList4 = arrayList;
                        int lane3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(intValue2);
                        if (lane3 == -2 || lane3 == -1) {
                            for (int i81 : copyOf3) {
                                if (i81 < intValue2) {
                                }
                            }
                            i23 = size;
                            long m1038getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext2.m1038getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), intValue2, 0);
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            i24 = i18;
                            List list6 = arrayList2;
                            LazyStaggeredGridMeasuredItem m1047getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1047getAndMeasurejy6DScQ(intValue2, m1038getSpanRangelOCCd4c4);
                            m1047getAndMeasurejy6DScQ5.position(i73, 0, afterContentPadding);
                            i73 += m1047getAndMeasurejy6DScQ5.getMainAxisSizeWithSpacings();
                            list6.add(m1047getAndMeasurejy6DScQ5);
                            arrayList2 = list6;
                        }
                        i18 = i24 + 1;
                        pinnedItems2 = list3;
                        size = i23;
                        arrayList = arrayList4;
                        i9 = i79;
                    }
                    i23 = size;
                    i24 = i18;
                    i18 = i24 + 1;
                    pinnedItems2 = list3;
                    size = i23;
                    arrayList = arrayList4;
                    i9 = i79;
                }
                int i82 = i9;
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
                lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().onMeasured((int) f, i65, i66, arrayList7, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.isVertical(), lazyLayoutMeasureScope3.isLookingAhead(), lazyStaggeredGridMeasureContext2.getLaneCount(), lazyStaggeredGridMeasureContext2.isInLookaheadScope(), ArraysKt.minOrThrow(iArr9), ArraysKt.maxOrThrow(iArr13) + beforeContentPadding, lazyStaggeredGridMeasureContext2.getCoroutineScope(), lazyStaggeredGridMeasureContext2.getGraphicsContext());
                if (!lazyLayoutMeasureScope3.isLookingAhead()) {
                    long m987getMinSizeToFitDisappearingItemsYbymL2g2 = lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().m987getMinSizeToFitDisappearingItemsYbymL2g();
                    if (!IntSize.m7724equalsimpl0(m987getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.Companion.m7731getZeroYbymL2g())) {
                        int i83 = lazyStaggeredGridMeasureContext2.isVertical() ? i66 : i65;
                        int m7525constrainWidthK40F9xA2 = ConstraintsKt.m7525constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.m1035getConstraintsmsEJaDk(), Math.max(i65, (int) (m987getMinSizeToFitDisappearingItemsYbymL2g2 >> c)));
                        int m7524constrainHeightK40F9xA = ConstraintsKt.m7524constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.m1035getConstraintsmsEJaDk(), Math.max(i66, (int) (m987getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                        int i84 = lazyStaggeredGridMeasureContext2.isVertical() ? m7524constrainHeightK40F9xA : m7525constrainWidthK40F9xA2;
                        if (i84 != i83) {
                            int size8 = arrayList7.size();
                            for (int i85 = 0; i85 < size8; i85++) {
                                arrayList7.get(i85).updateMainAxisLayoutSize(i84);
                            }
                        }
                        i19 = m7525constrainWidthK40F9xA2;
                        i20 = m7524constrainHeightK40F9xA;
                        i21 = i11;
                        i22 = 0;
                        while (true) {
                            if (i22 < i21) {
                                if (iArr13[i22] > lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                                    break;
                                }
                                i22++;
                            } else {
                                for (int i86 : copyOf3) {
                                    if (i86 >= i82 - 1) {
                                        z3 = false;
                                        break;
                                    }
                                }
                            }
                        }
                        final LazyLayoutMeasureScope lazyLayoutMeasureScope4 = lazyLayoutMeasureScope3;
                        return new LazyStaggeredGridMeasureResult(iArr8, iArr9, f, MeasureScope.layout$default(lazyLayoutMeasureScope3, i19, i20, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit measure$lambda$0$37;
                                measure$lambda$0$37 = LazyStaggeredGridMeasureKt.measure$lambda$0$37(LazyStaggeredGridMeasureContext.this, arrayList7, lazyLayoutMeasureScope4, (Placeable.PlacementScope) obj);
                                return measure$lambda$0$37;
                            }
                        }, 4, null), f2, z3, lazyStaggeredGridMeasureContext2.isVertical(), z9, lazyStaggeredGridMeasureContext2.getResolvedSlots(), lazyStaggeredGridMeasureContext2.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope4, i82, list2, IntSize.m7721constructorimpl((i20 & 4294967295L) | (i19 << c)), i38, i72, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), lazyStaggeredGridMeasureContext2.getCoroutineScope(), null);
                    }
                }
                i19 = i65;
                i20 = i66;
                i21 = i11;
                i22 = 0;
                while (true) {
                    if (i22 < i21) {
                    }
                    i22++;
                }
                final LazyLayoutMeasureScope lazyLayoutMeasureScope42 = lazyLayoutMeasureScope3;
                return new LazyStaggeredGridMeasureResult(iArr8, iArr9, f, MeasureScope.layout$default(lazyLayoutMeasureScope3, i19, i20, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit measure$lambda$0$37;
                        measure$lambda$0$37 = LazyStaggeredGridMeasureKt.measure$lambda$0$37(LazyStaggeredGridMeasureContext.this, arrayList7, lazyLayoutMeasureScope42, (Placeable.PlacementScope) obj);
                        return measure$lambda$0$37;
                    }
                }, 4, null), f2, z3, lazyStaggeredGridMeasureContext2.isVertical(), z9, lazyStaggeredGridMeasureContext2.getResolvedSlots(), lazyStaggeredGridMeasureContext2.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope42, i82, list2, IntSize.m7721constructorimpl((i20 & 4294967295L) | (i19 << c)), i38, i72, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), lazyStaggeredGridMeasureContext2.getCoroutineScope(), null);
            }
        }
        list2 = calculateVisibleItems;
        iArr8 = iArr6;
        f2 = f5;
        iArr9 = iArr3;
        arrayList = null;
        List<Integer> pinnedItems22 = lazyStaggeredGridMeasureContext2.getPinnedItems();
        size = pinnedItems22.size();
        i18 = 0;
        arrayList2 = null;
        while (i18 < size) {
        }
        int i822 = i9;
        arrayList3 = arrayList;
        if (arrayList2 == null) {
        }
        final List arrayList72 = new ArrayList();
        arrayList72.addAll(list4);
        arrayList72.addAll(list2);
        if (arrayList3 != null) {
        }
        arrayList72.addAll(arrayList2);
        lazyStaggeredGridMeasureContext2.getState().getItemAnimator$foundation().onMeasured((int) f, i65, i66, arrayList72, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.isVertical(), lazyLayoutMeasureScope3.isLookingAhead(), lazyStaggeredGridMeasureContext2.getLaneCount(), lazyStaggeredGridMeasureContext2.isInLookaheadScope(), ArraysKt.minOrThrow(iArr9), ArraysKt.maxOrThrow(iArr13) + beforeContentPadding, lazyStaggeredGridMeasureContext2.getCoroutineScope(), lazyStaggeredGridMeasureContext2.getGraphicsContext());
        if (!lazyLayoutMeasureScope3.isLookingAhead()) {
        }
        i19 = i65;
        i20 = i66;
        i21 = i11;
        i22 = 0;
        while (true) {
            if (i22 < i21) {
            }
            i22++;
        }
        final LazyLayoutMeasureScope lazyLayoutMeasureScope422 = lazyLayoutMeasureScope3;
        return new LazyStaggeredGridMeasureResult(iArr8, iArr9, f, MeasureScope.layout$default(lazyLayoutMeasureScope3, i19, i20, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure$lambda$0$37;
                measure$lambda$0$37 = LazyStaggeredGridMeasureKt.measure$lambda$0$37(LazyStaggeredGridMeasureContext.this, arrayList72, lazyLayoutMeasureScope422, (Placeable.PlacementScope) obj);
                return measure$lambda$0$37;
            }
        }, 4, null), f2, z3, lazyStaggeredGridMeasureContext2.isVertical(), z9, lazyStaggeredGridMeasureContext2.getResolvedSlots(), lazyStaggeredGridMeasureContext2.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope422, i822, list2, IntSize.m7721constructorimpl((i20 & 4294967295L) | (i19 << c)), i38, i72, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), lazyStaggeredGridMeasureContext2.getCoroutineScope(), null);
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
    public static final Unit measure$lambda$0$37(final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, final List list, final LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure$lambda$0$37$0;
                measure$lambda$0$37$0 = LazyStaggeredGridMeasureKt.measure$lambda$0$37$0(list, lazyStaggeredGridMeasureContext, lazyLayoutMeasureScope, (Placeable.PlacementScope) obj);
                return measure$lambda$0$37$0;
            }
        });
        ObservableScopeInvalidator.m1005attachToScopeimpl(lazyStaggeredGridMeasureContext.getState().m1051getPlacementScopeInvalidatorzYiylxw$foundation());
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
                        long m1053constructorimpl = SpanRange.m1053constructorimpl(removeFirst.getLane(), removeFirst.getSpan());
                        int m1043maxInRangejy6DScQ = m1043maxInRangejy6DScQ(iArr, m1053constructorimpl);
                        int i8 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i5];
                        if (removeFirst.getMainAxisSize() + m1043maxInRangejy6DScQ >= i2 && m1043maxInRangejy6DScQ <= i3) {
                            removeFirst.position(m1043maxInRangejy6DScQ, i8, i);
                            arrayList.add(removeFirst);
                        }
                        int i9 = (int) (m1053constructorimpl & 4294967295L);
                        for (int i10 = (int) (m1053constructorimpl >> 32); i10 < i9; i10++) {
                            iArr[i10] = removeFirst.getMainAxisSizeWithSpacings() + m1043maxInRangejy6DScQ;
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
                    LazyStaggeredGridMeasuredItem m1047getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1047getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m1038getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                    arrayList.add(m1047getAndMeasurejy6DScQ);
                    int[] positions = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                    function2.invoke(m1047getAndMeasurejy6DScQ, Integer.valueOf(positions.length > lane ? positions[lane] : 0));
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
                        long m1038getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m1038getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem m1047getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1047getAndMeasurejy6DScQ(intValue, m1038getSpanRangelOCCd4c);
                        function1.invoke(m1047getAndMeasurejy6DScQ);
                        arrayList.add(m1047getAndMeasurejy6DScQ);
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
                    long m1038getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m1038getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem m1047getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1047getAndMeasurejy6DScQ(intValue2, m1038getSpanRangelOCCd4c2);
                    function1.invoke(m1047getAndMeasurejy6DScQ2);
                    arrayList.add(m1047getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* renamed from: forEach-nIS5qE8  reason: not valid java name */
    private static final void m1042forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
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
    private static final int m1043maxInRangejy6DScQ(int[] iArr, long j) {
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
    public static final Unit measure$lambda$0$37$0(List list, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyStaggeredGridMeasuredItem) list.get(i)).place(placementScope, lazyStaggeredGridMeasureContext, lazyLayoutMeasureScope.isLookingAhead());
        }
        return Unit.INSTANCE;
    }
}
