package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntIntMapKt;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* compiled from: CacheWindowLogic.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b%\b!\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\u0013J\b\u0010%\u001a\u00020\"H\u0002J\n\u0010&\u001a\u00020\"*\u00020#J\f\u0010'\u001a\u00020\"*\u00020#H\u0002J\f\u0010(\u001a\u00020\"*\u00020#H\u0002J\u0006\u0010)\u001a\u00020\u0005J\u0014\u0010*\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\u0013H\u0002J\u0014\u0010+\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\u0013H\u0002J\u0014\u0010,\u001a\u00020\"*\u00020#2\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0006\u0010.\u001a\u00020\"JD\u0010/\u001a\u00020\"*\u00020#2\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0005H\u0002J@\u00107\u001a\u00020\"2\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0015H\u0002J\u001c\u00109\u001a\u00020\u0015*\u00020#2\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u0005H\u0002J\u0018\u0010<\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0015H\u0002J \u0010>\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0001H\u0002J \u0010@\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u0015H\u0002J\u0018\u0010A\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0015H\u0002J\u0018\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0015H\u0002J\u001c\u0010E\u001a\u00020\"*\u00020#2\u0006\u0010:\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u0015H\u0002J\f\u0010G\u001a\u00020\"*\u00020#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "enableInitialPrefetch", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;Z)V", "prefetchWindowHandles", "Landroidx/collection/MutableIntObjectMap;", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "indicesToRemove", "Landroidx/collection/MutableIntSet;", "windowCache", "Landroidx/collection/MutableIntIntMap;", "windowCacheWithItems", "Landroidx/compose/foundation/lazy/layout/CachedItem;", "previousPassDelta", "", "previousPassItemCount", "", "hasUpdatedVisibleItemsOnce", "value", "prefetchWindowStartLine", "getPrefetchWindowStartLine$foundation", "()I", "prefetchWindowEndLine", "getPrefetchWindowEndLine$foundation", "prefetchWindowStartExtraSpace", "prefetchWindowEndExtraSpace", "shouldRefillWindow", "itemsCount", "onScroll", "", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "delta", "traceWindowInfo", "onVisibleItemsUpdated", "onDatasetChanged", "onDatasetChangedWithoutFix", "hasValidBounds", "fillCacheWindowBackward", "fillCacheWindowForward", "refillWindow", "refillForward", "resetStrategy", "onPrefetchForward", "visibleWindowStart", "visibleWindowEnd", "prefetchForwardWindow", "mainAxisExtraSpaceEnd", "mainAxisExtraSpaceStart", "scrollDelta", "applyForwardPrefetch", "onKeepAround", "keepAroundWindow", "getItemSizeOrPrefetch", FirebaseAnalytics.Param.INDEX, "isUrgent", "cachePrefetchedItem", "size", "updateOrCreateCachedItem", "key", "cacheVisibleItemsInfo", "cacheVisibleItemsInfoWithoutFix", "removeOutOfBoundsItems", "startLine", "endLine", "onItemPrefetched", "itemSize", "scheduleNextItemIfNeeded", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CacheWindowLogic {
    public static final int $stable = 8;
    private final LazyLayoutCacheWindow cacheWindow;
    private final boolean enableInitialPrefetch;
    private boolean hasUpdatedVisibleItemsOnce;
    private final MutableIntSet indicesToRemove;
    private int itemsCount;
    private int prefetchWindowEndExtraSpace;
    private int prefetchWindowEndLine;
    private final MutableIntObjectMap<List<LazyLayoutPrefetchState.PrefetchHandle>> prefetchWindowHandles;
    private int prefetchWindowStartExtraSpace;
    private int prefetchWindowStartLine;
    private float previousPassDelta;
    private int previousPassItemCount;
    private boolean shouldRefillWindow;
    private final MutableIntIntMap windowCache;
    private final MutableIntObjectMap<CachedItem> windowCacheWithItems;

    public CacheWindowLogic(LazyLayoutCacheWindow lazyLayoutCacheWindow, boolean z) {
        this.cacheWindow = lazyLayoutCacheWindow;
        this.enableInitialPrefetch = z;
        this.prefetchWindowHandles = IntObjectMapKt.mutableIntObjectMapOf();
        this.indicesToRemove = IntSetKt.mutableIntSetOf();
        this.windowCache = IntIntMapKt.mutableIntIntMapOf();
        this.windowCacheWithItems = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousPassItemCount = -1;
        this.prefetchWindowStartLine = Integer.MAX_VALUE;
        this.prefetchWindowEndLine = Integer.MIN_VALUE;
    }

    public /* synthetic */ CacheWindowLogic(LazyLayoutCacheWindow lazyLayoutCacheWindow, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyLayoutCacheWindow, (i & 2) != 0 ? true : z);
    }

    public final int getPrefetchWindowStartLine$foundation() {
        return this.prefetchWindowStartLine;
    }

    public final int getPrefetchWindowEndLine$foundation() {
        return this.prefetchWindowEndLine;
    }

    public final void onScroll(CacheWindowScope cacheWindowScope, float f) {
        traceWindowInfo();
        fillCacheWindowBackward(cacheWindowScope, f);
        fillCacheWindowForward(cacheWindowScope, f);
        this.previousPassDelta = f;
        traceWindowInfo();
    }

    private final void traceWindowInfo() {
        AndroidTrace_androidKt.traceValue("prefetchWindowStartExtraSpace", this.prefetchWindowStartExtraSpace);
        AndroidTrace_androidKt.traceValue("prefetchWindowEndExtraSpace", this.prefetchWindowEndExtraSpace);
        AndroidTrace_androidKt.traceValue("prefetchWindowStartIndex", this.prefetchWindowStartLine);
        AndroidTrace_androidKt.traceValue("prefetchWindowEndIndex", this.prefetchWindowEndLine);
    }

    public final void onVisibleItemsUpdated(CacheWindowScope cacheWindowScope) {
        if (!this.hasUpdatedVisibleItemsOnce && this.enableInitialPrefetch) {
            LazyLayoutCacheWindow lazyLayoutCacheWindow = this.cacheWindow;
            Density density = cacheWindowScope.getDensity();
            if ((density != null ? lazyLayoutCacheWindow.calculateAheadWindow(density, cacheWindowScope.getMainAxisViewportSize()) : 0) != 0) {
                this.shouldRefillWindow = true;
            }
            this.hasUpdatedVisibleItemsOnce = true;
        }
        int i = this.previousPassItemCount;
        if (i != -1 && i != cacheWindowScope.getTotalItemsCount()) {
            if (ComposeFoundationFlags.isCacheWindowRefillFixEnabled) {
                onDatasetChanged(cacheWindowScope);
            } else {
                onDatasetChangedWithoutFix(cacheWindowScope);
            }
        }
        this.itemsCount = cacheWindowScope.getTotalItemsCount();
        if (!cacheWindowScope.getHasVisibleItems()) {
            resetStrategy();
        } else {
            int visibleLineCount = cacheWindowScope.getVisibleLineCount();
            for (int i2 = 0; i2 < visibleLineCount; i2++) {
                int visibleItemLine = cacheWindowScope.getVisibleItemLine(i2);
                Object visibleLineKey = cacheWindowScope.getVisibleLineKey(i2);
                int visibleItemSize = cacheWindowScope.getVisibleItemSize(i2);
                if (ComposeFoundationFlags.isCacheWindowRefillFixEnabled) {
                    if (visibleItemLine != -1) {
                        cacheVisibleItemsInfo(visibleItemLine, visibleLineKey, visibleItemSize);
                    }
                } else if (visibleItemLine != -1) {
                    cacheVisibleItemsInfoWithoutFix(visibleItemLine, visibleItemSize);
                }
            }
            if (this.shouldRefillWindow) {
                refillWindow(cacheWindowScope, this.previousPassDelta <= 0.0f);
                this.shouldRefillWindow = false;
            }
        }
        this.previousPassItemCount = cacheWindowScope.getTotalItemsCount();
    }

    private final void onDatasetChanged(CacheWindowScope cacheWindowScope) {
        this.shouldRefillWindow = true;
        if (cacheWindowScope.getHasVisibleItems()) {
            this.prefetchWindowStartLine = RangesKt.coerceAtLeast(this.prefetchWindowStartLine, 0);
            int lastLineIndex = cacheWindowScope.getLastLineIndex();
            if (lastLineIndex != -1) {
                this.prefetchWindowEndLine = RangesKt.coerceAtMost(this.prefetchWindowEndLine, lastLineIndex);
            }
            if (this.previousPassDelta <= 0.0f) {
                removeOutOfBoundsItems(cacheWindowScope.getLastVisibleLineIndex(), this.itemsCount - 1);
            } else {
                removeOutOfBoundsItems(0, cacheWindowScope.getFirstVisibleLineIndex());
            }
        }
    }

    private final void onDatasetChangedWithoutFix(CacheWindowScope cacheWindowScope) {
        this.shouldRefillWindow = true;
        this.prefetchWindowStartLine = RangesKt.coerceAtLeast(this.prefetchWindowStartLine, 0);
        int lastLineIndex = cacheWindowScope.getLastLineIndex();
        if (lastLineIndex != -1) {
            this.prefetchWindowEndLine = RangesKt.coerceAtMost(this.prefetchWindowEndLine, lastLineIndex);
        }
        removeOutOfBoundsItems(this.prefetchWindowEndLine, this.itemsCount - 1);
    }

    public final boolean hasValidBounds() {
        return (this.prefetchWindowStartLine == Integer.MAX_VALUE || this.prefetchWindowEndLine == Integer.MIN_VALUE) ? false : true;
    }

    private final void fillCacheWindowBackward(CacheWindowScope cacheWindowScope, float f) {
        if (cacheWindowScope.getHasVisibleItems()) {
            int mainAxisViewportSize = cacheWindowScope.getMainAxisViewportSize();
            LazyLayoutCacheWindow lazyLayoutCacheWindow = this.cacheWindow;
            Density density = cacheWindowScope.getDensity();
            int calculateBehindWindow = density != null ? lazyLayoutCacheWindow.calculateBehindWindow(density, mainAxisViewportSize) : 0;
            this.itemsCount = cacheWindowScope.getTotalItemsCount();
            onKeepAround(cacheWindowScope.getFirstVisibleLineIndex(), cacheWindowScope.getLastVisibleLineIndex(), cacheWindowScope.getMainAxisExtraSpaceEnd(), cacheWindowScope.getMainAxisExtraSpaceStart(), calculateBehindWindow, f, cacheWindowScope.getTotalItemsCount());
        }
    }

    private final void fillCacheWindowForward(CacheWindowScope cacheWindowScope, float f) {
        if (cacheWindowScope.getHasVisibleItems()) {
            int mainAxisViewportSize = cacheWindowScope.getMainAxisViewportSize();
            LazyLayoutCacheWindow lazyLayoutCacheWindow = this.cacheWindow;
            Density density = cacheWindowScope.getDensity();
            int calculateAheadWindow = density != null ? lazyLayoutCacheWindow.calculateAheadWindow(density, mainAxisViewportSize) : 0;
            onPrefetchForward(cacheWindowScope, cacheWindowScope.getFirstVisibleLineIndex(), cacheWindowScope.getLastVisibleLineIndex(), calculateAheadWindow, cacheWindowScope.getMainAxisExtraSpaceEnd(), cacheWindowScope.getMainAxisExtraSpaceStart(), f, f <= 0.0f);
        }
    }

    private final void refillWindow(CacheWindowScope cacheWindowScope, boolean z) {
        if (cacheWindowScope.getHasVisibleItems()) {
            int mainAxisViewportSize = cacheWindowScope.getMainAxisViewportSize();
            LazyLayoutCacheWindow lazyLayoutCacheWindow = this.cacheWindow;
            Density density = cacheWindowScope.getDensity();
            onPrefetchForward(cacheWindowScope, cacheWindowScope.getFirstVisibleLineIndex(), cacheWindowScope.getLastVisibleLineIndex(), density != null ? lazyLayoutCacheWindow.calculateAheadWindow(density, mainAxisViewportSize) : 0, cacheWindowScope.getMainAxisExtraSpaceEnd(), cacheWindowScope.getMainAxisExtraSpaceStart(), 0.0f, z);
        }
    }

    public final void resetStrategy() {
        this.prefetchWindowStartLine = Integer.MAX_VALUE;
        this.prefetchWindowEndLine = Integer.MIN_VALUE;
        this.prefetchWindowStartExtraSpace = 0;
        this.prefetchWindowEndExtraSpace = 0;
        this.shouldRefillWindow = false;
        this.windowCache.clear();
        this.windowCacheWithItems.clear();
        MutableIntObjectMap<List<LazyLayoutPrefetchState.PrefetchHandle>> mutableIntObjectMap = this.prefetchWindowHandles;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        int i5 = mutableIntObjectMap.keys[i4];
                        List list = (List) mutableIntObjectMap.values[i4];
                        int size = list.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            ((LazyLayoutPrefetchState.PrefetchHandle) list.get(i6)).cancel();
                        }
                        mutableIntObjectMap.removeValueAt(i4);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    private final void onPrefetchForward(CacheWindowScope cacheWindowScope, int i, int i2, int i3, int i4, int i5, float f, boolean z) {
        boolean z2 = Math.signum(f) == Math.signum(this.previousPassDelta);
        if (z) {
            if (!z2 || this.shouldRefillWindow) {
                this.prefetchWindowEndExtraSpace = i3 - i4;
                this.prefetchWindowEndLine = i2;
            } else {
                this.prefetchWindowEndExtraSpace = RangesKt.coerceAtMost(this.prefetchWindowEndExtraSpace + MathKt.roundToInt(Math.abs(f)), i3 - i4);
            }
            while (this.prefetchWindowEndExtraSpace > 0 && cacheWindowScope.getLastIndexInLine(this.prefetchWindowEndLine) != -1 && cacheWindowScope.getLastIndexInLine(this.prefetchWindowEndLine) < this.itemsCount - 1) {
                int itemSizeOrPrefetch = getItemSizeOrPrefetch(cacheWindowScope, this.prefetchWindowEndLine + 1, this.prefetchWindowEndLine + 1 == i2 + 1 && (!ComposeFoundationFlags.isCacheWindowRefillFixEnabled || (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) != 0) && Math.abs(f) >= ((float) i4));
                if (itemSizeOrPrefetch == -1) {
                    return;
                }
                this.prefetchWindowEndLine++;
                this.prefetchWindowEndExtraSpace -= itemSizeOrPrefetch;
            }
            return;
        }
        if (!z2 || this.shouldRefillWindow) {
            this.prefetchWindowStartExtraSpace = i3 - i5;
            this.prefetchWindowStartLine = i;
        } else {
            this.prefetchWindowStartExtraSpace = RangesKt.coerceAtMost(this.prefetchWindowStartExtraSpace + MathKt.roundToInt(Math.abs(f)), i3 - i5);
        }
        while (this.prefetchWindowStartExtraSpace > 0 && this.prefetchWindowStartLine > 0) {
            int itemSizeOrPrefetch2 = getItemSizeOrPrefetch(cacheWindowScope, this.prefetchWindowStartLine - 1, this.prefetchWindowStartLine - 1 == i + (-1) && (!ComposeFoundationFlags.isCacheWindowRefillFixEnabled || (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) != 0) && Math.abs(f) >= ((float) i5));
            if (itemSizeOrPrefetch2 == -1) {
                return;
            }
            this.prefetchWindowStartLine--;
            this.prefetchWindowStartExtraSpace -= itemSizeOrPrefetch2;
        }
    }

    private final void onKeepAround(int i, int i2, int i3, int i4, int i5, float f, int i6) {
        int i7;
        int i8;
        if (f <= 0.0f) {
            this.prefetchWindowStartExtraSpace = i5 - i4;
            this.prefetchWindowStartLine = i;
            while (this.prefetchWindowStartExtraSpace > 0 && this.prefetchWindowStartLine > 0) {
                if (ComposeFoundationFlags.isCacheWindowRefillFixEnabled) {
                    if (!this.windowCacheWithItems.containsKey(this.prefetchWindowStartLine - 1)) {
                        break;
                    }
                    CachedItem cachedItem = this.windowCacheWithItems.get(this.prefetchWindowStartLine - 1);
                    Intrinsics.checkNotNull(cachedItem);
                    i8 = cachedItem.getMainAxisSize();
                    this.prefetchWindowStartLine--;
                    this.prefetchWindowStartExtraSpace -= i8;
                } else if (!this.windowCache.containsKey(this.prefetchWindowStartLine - 1)) {
                    break;
                } else {
                    i8 = this.windowCache.get(this.prefetchWindowStartLine - 1);
                    this.prefetchWindowStartLine--;
                    this.prefetchWindowStartExtraSpace -= i8;
                }
            }
            removeOutOfBoundsItems(0, this.prefetchWindowStartLine - 1);
            return;
        }
        this.prefetchWindowEndExtraSpace = i5 - i3;
        this.prefetchWindowEndLine = i2;
        while (this.prefetchWindowEndExtraSpace > 0 && this.prefetchWindowEndLine < i6 - 1) {
            if (ComposeFoundationFlags.isCacheWindowRefillFixEnabled) {
                if (!this.windowCacheWithItems.containsKey(this.prefetchWindowEndLine + 1)) {
                    break;
                }
                CachedItem cachedItem2 = this.windowCacheWithItems.get(this.prefetchWindowEndLine + 1);
                Intrinsics.checkNotNull(cachedItem2);
                i7 = cachedItem2.getMainAxisSize();
                this.prefetchWindowEndLine++;
                this.prefetchWindowEndExtraSpace -= i7;
            } else if (!this.windowCache.containsKey(this.prefetchWindowEndLine + 1)) {
                break;
            } else {
                i7 = this.windowCache.get(this.prefetchWindowEndLine + 1);
                this.prefetchWindowEndLine++;
                this.prefetchWindowEndExtraSpace -= i7;
            }
        }
        removeOutOfBoundsItems(this.prefetchWindowEndLine + 1, i6 - 1);
    }

    private final int getItemSizeOrPrefetch(final CacheWindowScope cacheWindowScope, int i, boolean z) {
        List<LazyLayoutPrefetchState.PrefetchHandle> list;
        List<LazyLayoutPrefetchState.PrefetchHandle> list2;
        List<LazyLayoutPrefetchState.PrefetchHandle> list3;
        List<LazyLayoutPrefetchState.PrefetchHandle> list4;
        int i2 = 0;
        if (ComposeFoundationFlags.isCacheWindowRefillFixEnabled) {
            if (this.windowCacheWithItems.containsKey(i)) {
                CachedItem cachedItem = this.windowCacheWithItems.get(i);
                Intrinsics.checkNotNull(cachedItem);
                return cachedItem.getMainAxisSize();
            } else if (this.prefetchWindowHandles.containsKey(i)) {
                if (z && (list4 = this.prefetchWindowHandles.get(i)) != null) {
                    int size = list4.size();
                    while (i2 < size) {
                        list4.get(i2).markAsUrgent();
                        i2++;
                    }
                }
                return -1;
            } else {
                this.prefetchWindowHandles.set(i, cacheWindowScope.schedulePrefetch(i, new Function2() { // from class: androidx.compose.foundation.lazy.layout.CacheWindowLogic$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CacheWindowLogic.getItemSizeOrPrefetch$lambda$4(CacheWindowLogic.this, cacheWindowScope, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    }
                }));
                if (z && (list3 = this.prefetchWindowHandles.get(i)) != null) {
                    int size2 = list3.size();
                    while (i2 < size2) {
                        list3.get(i2).markAsUrgent();
                        i2++;
                    }
                }
                return -1;
            }
        } else if (this.windowCache.containsKey(i)) {
            return this.windowCache.get(i);
        } else {
            if (this.prefetchWindowHandles.containsKey(i)) {
                if (z && (list2 = this.prefetchWindowHandles.get(i)) != null) {
                    int size3 = list2.size();
                    while (i2 < size3) {
                        list2.get(i2).markAsUrgent();
                        i2++;
                    }
                }
                return -1;
            }
            this.prefetchWindowHandles.set(i, cacheWindowScope.schedulePrefetch(i, new Function2() { // from class: androidx.compose.foundation.lazy.layout.CacheWindowLogic$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CacheWindowLogic.getItemSizeOrPrefetch$lambda$10(CacheWindowLogic.this, cacheWindowScope, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                }
            }));
            if (z && (list = this.prefetchWindowHandles.get(i)) != null) {
                int size4 = list.size();
                while (i2 < size4) {
                    list.get(i2).markAsUrgent();
                    i2++;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit getItemSizeOrPrefetch$lambda$4(CacheWindowLogic cacheWindowLogic, CacheWindowScope cacheWindowScope, int i, int i2) {
        cacheWindowLogic.onItemPrefetched(cacheWindowScope, i, i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit getItemSizeOrPrefetch$lambda$10(CacheWindowLogic cacheWindowLogic, CacheWindowScope cacheWindowScope, int i, int i2) {
        cacheWindowLogic.onItemPrefetched(cacheWindowScope, i, i2);
        return Unit.INSTANCE;
    }

    private final void cachePrefetchedItem(int i, int i2) {
        if (ComposeFoundationFlags.isCacheWindowRefillFixEnabled) {
            this.windowCacheWithItems.set(i, updateOrCreateCachedItem(i, i2, CachedItem.NoKey));
        } else {
            this.windowCache.set(i, i2);
        }
        if (i > this.prefetchWindowEndLine) {
            this.prefetchWindowEndLine = i;
            this.prefetchWindowEndExtraSpace -= i2;
        } else if (i < this.prefetchWindowStartLine) {
            this.prefetchWindowStartLine = i;
            this.prefetchWindowStartExtraSpace -= i2;
        }
    }

    private final CachedItem updateOrCreateCachedItem(int i, int i2, Object obj) {
        CachedItem cachedItem = this.windowCacheWithItems.get(i);
        if (cachedItem != null) {
            cachedItem.setMainAxisSize(i2);
            cachedItem.setKey(obj);
            return cachedItem;
        }
        return new CachedItem(obj, i2);
    }

    private final void cacheVisibleItemsInfo(int i, Object obj, int i2) {
        if (this.windowCacheWithItems.containsKey(i)) {
            CachedItem cachedItem = this.windowCacheWithItems.get(i);
            Intrinsics.checkNotNull(cachedItem);
            int mainAxisSize = cachedItem.getMainAxisSize();
            CachedItem cachedItem2 = this.windowCacheWithItems.get(i);
            Intrinsics.checkNotNull(cachedItem2);
            Object key = cachedItem2.getKey();
            if (mainAxisSize != i2 || !Intrinsics.areEqual(key, obj)) {
                this.shouldRefillWindow = true;
            }
        }
        this.windowCacheWithItems.set(i, updateOrCreateCachedItem(i, i2, obj));
        this.prefetchWindowStartLine = Math.min(this.prefetchWindowStartLine, i);
        this.prefetchWindowEndLine = Math.max(this.prefetchWindowEndLine, i);
        List<LazyLayoutPrefetchState.PrefetchHandle> remove = this.prefetchWindowHandles.remove(i);
        if (remove != null) {
            int size = remove.size();
            for (int i3 = 0; i3 < size; i3++) {
                remove.get(i3).cancel();
            }
        }
    }

    private final void cacheVisibleItemsInfoWithoutFix(int i, int i2) {
        if (this.windowCache.containsKey(i) && this.windowCache.get(i) != i2) {
            this.shouldRefillWindow = true;
        }
        this.windowCache.set(i, i2);
        this.prefetchWindowStartLine = Math.min(this.prefetchWindowStartLine, i);
        this.prefetchWindowEndLine = Math.max(this.prefetchWindowEndLine, i);
        List<LazyLayoutPrefetchState.PrefetchHandle> remove = this.prefetchWindowHandles.remove(i);
        if (remove != null) {
            int size = remove.size();
            for (int i3 = 0; i3 < size; i3++) {
                remove.get(i3).cancel();
            }
        }
    }

    private final void removeOutOfBoundsItems(int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        int i3;
        int i4;
        char c2;
        long j4;
        this.indicesToRemove.clear();
        MutableIntObjectMap<List<LazyLayoutPrefetchState.PrefetchHandle>> mutableIntObjectMap = this.prefetchWindowHandles;
        int[] iArr = mutableIntObjectMap.keys;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        char c3 = 7;
        long j5 = -9187201950435737472L;
        if (length >= 0) {
            int i5 = 0;
            j2 = 128;
            while (true) {
                long j6 = jArr[i5];
                j3 = 255;
                if ((((~j6) << c3) & j6 & j5) != j5) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j6 & 255) < 128) {
                            c2 = c3;
                            int i8 = iArr[(i5 << 3) + i7];
                            if (i <= i8 && i8 <= i2) {
                                j4 = j5;
                                this.indicesToRemove.add(i8);
                                j6 >>= 8;
                                i7++;
                                c3 = c2;
                                j5 = j4;
                            }
                        } else {
                            c2 = c3;
                        }
                        j4 = j5;
                        j6 >>= 8;
                        i7++;
                        c3 = c2;
                        j5 = j4;
                    }
                    c = c3;
                    j = j5;
                    if (i6 != 8) {
                        break;
                    }
                } else {
                    c = c3;
                    j = j5;
                }
                if (i5 == length) {
                    break;
                }
                i5++;
                c3 = c;
                j5 = j;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 128;
            j3 = 255;
        }
        MutableIntIntMap mutableIntIntMap = this.windowCache;
        int[] iArr2 = mutableIntIntMap.keys;
        long[] jArr2 = mutableIntIntMap.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i9 = 0;
            while (true) {
                long j7 = jArr2[i9];
                if ((((~j7) << c) & j7 & j) != j) {
                    int i10 = 8 - ((~(i9 - length2)) >>> 31);
                    for (int i11 = 0; i11 < i10; i11++) {
                        if ((j7 & j3) < j2 && i <= (i4 = iArr2[(i9 << 3) + i11]) && i4 <= i2) {
                            this.indicesToRemove.add(i4);
                        }
                        j7 >>= 8;
                    }
                    if (i10 != 8) {
                        break;
                    }
                }
                if (i9 == length2) {
                    break;
                }
                i9++;
            }
        }
        MutableIntObjectMap<CachedItem> mutableIntObjectMap2 = this.windowCacheWithItems;
        int[] iArr3 = mutableIntObjectMap2.keys;
        long[] jArr3 = mutableIntObjectMap2.metadata;
        int length3 = jArr3.length - 2;
        if (length3 >= 0) {
            int i12 = 0;
            while (true) {
                long j8 = jArr3[i12];
                if ((((~j8) << c) & j8 & j) != j) {
                    int i13 = 8 - ((~(i12 - length3)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((j8 & j3) < j2 && i <= (i3 = iArr3[(i12 << 3) + i14]) && i3 <= i2) {
                            this.indicesToRemove.add(i3);
                        }
                        j8 >>= 8;
                    }
                    if (i13 != 8) {
                        break;
                    }
                }
                if (i12 == length3) {
                    break;
                }
                i12++;
            }
        }
        MutableIntSet mutableIntSet = this.indicesToRemove;
        int[] iArr4 = mutableIntSet.elements;
        long[] jArr4 = mutableIntSet.metadata;
        int length4 = jArr4.length - 2;
        if (length4 < 0) {
            return;
        }
        int i15 = 0;
        while (true) {
            long j9 = jArr4[i15];
            if ((((~j9) << c) & j9 & j) != j) {
                int i16 = 8 - ((~(i15 - length4)) >>> 31);
                for (int i17 = 0; i17 < i16; i17++) {
                    if ((j9 & j3) < j2) {
                        int i18 = iArr4[(i15 << 3) + i17];
                        List<LazyLayoutPrefetchState.PrefetchHandle> remove = this.prefetchWindowHandles.remove(i18);
                        if (remove != null) {
                            int size = remove.size();
                            for (int i19 = 0; i19 < size; i19++) {
                                remove.get(i19).cancel();
                            }
                        }
                        this.windowCache.remove(i18);
                        this.windowCacheWithItems.remove(i18);
                    }
                    j9 >>= 8;
                }
                if (i16 != 8) {
                    return;
                }
            }
            if (i15 == length4) {
                return;
            }
            i15++;
        }
    }

    private final void onItemPrefetched(CacheWindowScope cacheWindowScope, int i, int i2) {
        cachePrefetchedItem(i, i2);
        scheduleNextItemIfNeeded(cacheWindowScope);
        traceWindowInfo();
    }

    private final void scheduleNextItemIfNeeded(final CacheWindowScope cacheWindowScope) {
        int i;
        if (Math.signum(this.previousPassDelta) <= 0.0f) {
            if (this.prefetchWindowEndExtraSpace > 0) {
                i = this.prefetchWindowEndLine + 1;
            }
            i = -1;
        } else {
            if (Math.signum(this.previousPassDelta) > 0.0f && this.prefetchWindowStartExtraSpace > 0) {
                i = this.prefetchWindowStartLine - 1;
            }
            i = -1;
        }
        if (i <= 0 || cacheWindowScope.getLastIndexInLine(i) == -1 || cacheWindowScope.getLastIndexInLine(i) >= this.itemsCount) {
            return;
        }
        this.prefetchWindowHandles.set(i, cacheWindowScope.schedulePrefetch(i, new Function2() { // from class: androidx.compose.foundation.lazy.layout.CacheWindowLogic$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CacheWindowLogic.scheduleNextItemIfNeeded$lambda$1(CacheWindowLogic.this, cacheWindowScope, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit scheduleNextItemIfNeeded$lambda$1(CacheWindowLogic cacheWindowLogic, CacheWindowScope cacheWindowScope, int i, int i2) {
        cacheWindowLogic.onItemPrefetched(cacheWindowScope, i, i2);
        return Unit.INSTANCE;
    }
}
