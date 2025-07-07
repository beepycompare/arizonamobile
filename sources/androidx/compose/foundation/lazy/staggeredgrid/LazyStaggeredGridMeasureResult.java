package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LazyStaggeredGridMeasureResult.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B«\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\u0006\u0010\u001f\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"J\u0018\u0010X\u001a\u0004\u0018\u00010\u00002\u0006\u0010Y\u001a\u00020\u00152\u0006\u0010Z\u001a\u00020\u000bJ\t\u0010[\u001a\u00020EH\u0096\u0001R\u0014\u0010\u001e\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001e\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010\u001d\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0011\u0010+\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00106R\u0012\u00108\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u0010$R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010-R\u0014\u0010\u001f\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020>X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010-R'\u0010B\u001a\u0015\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020E\u0018\u00010C¢\u0006\u0002\bF8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bI\u00100R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010$R\u0014\u0010\u001c\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010$R\u001c\u0010\u0019\u001a\u00020\u001aX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010R\u001a\u0004\bP\u0010QR\u0014\u0010\u001b\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010$R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0012\u0010V\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\bW\u0010$\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItemIndices", "", "firstVisibleItemScrollOffsets", "consumedScroll", "", "measureResult", "scrollBackAmount", "canScrollForward", "", "isVertical", "remeasureNeeded", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "density", "Landroidx/compose/ui/unit/Density;", "totalItemsCount", "", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "viewportStartOffset", "viewportEndOffset", "beforeContentPadding", "afterContentPadding", "mainAxisItemSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "([I[IFLandroidx/compose/ui/layout/MeasureResult;FZZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;Landroidx/compose/ui/unit/Density;ILjava/util/List;JIIIIILkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "getConsumedScroll", "()F", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleItemIndices", "()[I", "getFirstVisibleItemScrollOffsets", "height", "getHeight", "getMainAxisItemSpacing", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getRemeasureNeeded", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "getScrollBackAmount", "getSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getSpanProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getTotalItemsCount", "getViewportEndOffset", "getViewportSize-YbymL2g", "()J", "J", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "copyWithScrollDeltaWithoutRemeasure", "delta", "updateAnimations", "placeChildren", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasureResult implements LazyStaggeredGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final boolean canScrollForward;
    private final float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final int[] firstVisibleItemIndices;
    private final int[] firstVisibleItemScrollOffsets;
    private final boolean isVertical;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final float scrollBackAmount;
    private final LazyStaggeredGridSlots slots;
    private final LazyStaggeredGridSpanProvider spanProvider;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final long viewportSize;
    private final int viewportStartOffset;
    private final List<LazyStaggeredGridMeasuredItem> visibleItemsInfo;

    public /* synthetic */ LazyStaggeredGridMeasureResult(int[] iArr, int[] iArr2, float f, MeasureResult measureResult, float f2, boolean z, boolean z2, boolean z3, LazyStaggeredGridSlots lazyStaggeredGridSlots, LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider, Density density, int i, List list, long j, int i2, int i3, int i4, int i5, int i6, CoroutineScope coroutineScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, iArr2, f, measureResult, f2, z, z2, z3, lazyStaggeredGridSlots, lazyStaggeredGridSpanProvider, density, i, list, j, i2, i3, i4, i5, i6, coroutineScope);
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.measureResult.getAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.measureResult.getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Function1<RulerScope, Unit> getRulers() {
        return this.measureResult.getRulers();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.measureResult.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void placeChildren() {
        this.measureResult.placeChildren();
    }

    private LazyStaggeredGridMeasureResult(int[] iArr, int[] iArr2, float f, MeasureResult measureResult, float f2, boolean z, boolean z2, boolean z3, LazyStaggeredGridSlots lazyStaggeredGridSlots, LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider, Density density, int i, List<LazyStaggeredGridMeasuredItem> list, long j, int i2, int i3, int i4, int i5, int i6, CoroutineScope coroutineScope) {
        this.firstVisibleItemIndices = iArr;
        this.firstVisibleItemScrollOffsets = iArr2;
        this.consumedScroll = f;
        this.measureResult = measureResult;
        this.scrollBackAmount = f2;
        this.canScrollForward = z;
        this.isVertical = z2;
        this.remeasureNeeded = z3;
        this.slots = lazyStaggeredGridSlots;
        this.spanProvider = lazyStaggeredGridSpanProvider;
        this.density = density;
        this.totalItemsCount = i;
        this.visibleItemsInfo = list;
        this.viewportSize = j;
        this.viewportStartOffset = i2;
        this.viewportEndOffset = i3;
        this.beforeContentPadding = i4;
        this.afterContentPadding = i5;
        this.mainAxisItemSpacing = i6;
        this.coroutineScope = coroutineScope;
        this.orientation = z2 ? Orientation.Vertical : Orientation.Horizontal;
    }

    public final int[] getFirstVisibleItemIndices() {
        return this.firstVisibleItemIndices;
    }

    public final int[] getFirstVisibleItemScrollOffsets() {
        return this.firstVisibleItemScrollOffsets;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final MeasureResult getMeasureResult() {
        return this.measureResult;
    }

    public final float getScrollBackAmount() {
        return this.scrollBackAmount;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public final LazyStaggeredGridSlots getSlots() {
        return this.slots;
    }

    public final LazyStaggeredGridSpanProvider getSpanProvider() {
        return this.spanProvider;
    }

    public final Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public List<LazyStaggeredGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    /* renamed from: getViewportSize-YbymL2g */
    public long mo948getViewportSizeYbymL2g() {
        return this.viewportSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final boolean getCanScrollBackward() {
        return this.firstVisibleItemIndices[0] != 0 || this.firstVisibleItemScrollOffsets[0] > 0;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b1, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b5, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LazyStaggeredGridMeasureResult copyWithScrollDeltaWithoutRemeasure(int i, boolean z) {
        if (this.remeasureNeeded || getVisibleItemsInfo().isEmpty() || this.firstVisibleItemIndices.length == 0 || this.firstVisibleItemScrollOffsets.length == 0) {
            return null;
        }
        int viewportEndOffset = getViewportEndOffset() - getAfterContentPadding();
        List<LazyStaggeredGridMeasuredItem> visibleItemsInfo = getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                List<LazyStaggeredGridMeasuredItem> visibleItemsInfo2 = getVisibleItemsInfo();
                int size2 = visibleItemsInfo2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    visibleItemsInfo2.get(i3).applyScrollDelta(i, z);
                }
                int[] iArr = this.firstVisibleItemIndices;
                int length = this.firstVisibleItemScrollOffsets.length;
                int[] iArr2 = new int[length];
                for (int i4 = 0; i4 < length; i4++) {
                    iArr2[i4] = this.firstVisibleItemScrollOffsets[i4] - i;
                }
                return new LazyStaggeredGridMeasureResult(iArr, iArr2, i, this.measureResult, this.scrollBackAmount, this.canScrollForward || i > 0, this.isVertical, this.remeasureNeeded, this.slots, this.spanProvider, this.density, getTotalItemsCount(), getVisibleItemsInfo(), mo948getViewportSizeYbymL2g(), getViewportStartOffset(), getViewportEndOffset(), getBeforeContentPadding(), getAfterContentPadding(), getMainAxisItemSpacing(), this.coroutineScope, null);
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = visibleItemsInfo.get(i2);
            if (lazyStaggeredGridMeasuredItem.getNonScrollableItem()) {
                break;
            }
            if ((lazyStaggeredGridMeasuredItem.getMainAxisOffset() <= 0) != (lazyStaggeredGridMeasuredItem.getMainAxisOffset() + i <= 0)) {
                break;
            }
            if (lazyStaggeredGridMeasuredItem.getMainAxisOffset() <= getViewportStartOffset()) {
                if (i < 0) {
                    if ((lazyStaggeredGridMeasuredItem.getMainAxisOffset() + lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings()) - getViewportStartOffset() <= (-i)) {
                        break;
                    }
                } else if (getViewportStartOffset() - lazyStaggeredGridMeasuredItem.getMainAxisOffset() <= i) {
                    break;
                }
            }
            if (lazyStaggeredGridMeasuredItem.getMainAxisOffset() + lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings() >= viewportEndOffset) {
                if (i < 0) {
                    if ((lazyStaggeredGridMeasuredItem.getMainAxisOffset() + lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings()) - getViewportEndOffset() <= (-i)) {
                        break;
                    }
                } else if (getViewportEndOffset() - lazyStaggeredGridMeasuredItem.getMainAxisOffset() <= i) {
                    break;
                }
            }
            i2++;
        }
    }
}
