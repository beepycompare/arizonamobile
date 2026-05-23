package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010(\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0017\u0010<\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010>J\u001e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004J(\u0010?\u001a\u00020@2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0016J-\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020\u000b¢\u0006\u0004\bN\u0010OJ\u000e\u0010P\u001a\u00020@2\u0006\u0010/\u001a\u00020\u0004J\u0016\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u000bJ(\u0010W\u001a\u000209*\u0002092\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040YH\u0082\b¢\u0006\u0004\bZ\u0010[J\b\u0010\\\u001a\u00020]H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001cR\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u000e\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0019R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019R\u000e\u0010/\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010%R\u0016\u00105\u001a\u000206X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b7\u0010!R \u0010:\u001a\u0002092\u0006\u00108\u001a\u000209@RX\u0096\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b;\u0010!R\u0011\u0010C\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bG\u0010\u0019R\u0018\u0010A\u001a\u00020\u0004*\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0019\u0010)\u001a\u00020\u0004*\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010V¨\u0006^"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", FirebaseAnalytics.Param.INDEX, "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", TtmlNode.TAG_SPAN, "beforeContentPadding", "afterContentPadding", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "()Z", "getLane", "getSpan", "getContentType", "getConstraints-msEJaDk", "()J", "J", "isVisible", "setVisible", "(Z)V", "placeablesCount", "getPlaceablesCount", "getParentData", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "value", "Landroidx/compose/ui/unit/IntOffset;", TypedValues.CycleType.S_WAVE_OFFSET, "getOffset-nOcc-ac", "getOffset", "getOffset-Bjo55l4", "(I)J", "position", "", "mainAxis", "crossAxis", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "getMainAxisOffset", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "reverseLayout", "contentOffset", "isLookingAhead", "place-GMOY1bU", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;ZJZ)V", "updateMainAxisLayoutSize", "applyScrollDelta", "delta", "updateAnimations", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "toString", "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int span;

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int i, Object obj, List list, boolean z, int i2, int i3, int i4, int i5, int i6, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, list, z, i2, i3, i4, i5, i6, obj2, lazyLayoutItemAnimator, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyStaggeredGridMeasuredItem(int i, Object obj, List<? extends Placeable> list, boolean z, int i2, int i3, int i4, int i5, int i6, Object obj2, LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> lazyLayoutItemAnimator, long j) {
        int height;
        long m8326constructorimpl;
        this.index = i;
        this.key = obj;
        this.placeables = list;
        this.isVertical = z;
        this.lane = i3;
        this.span = i4;
        this.beforeContentPadding = i5;
        this.afterContentPadding = i6;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j;
        int i7 = 1;
        this.isVisible = true;
        int i8 = 0;
        if (list.isEmpty()) {
            height = 0;
        } else {
            Placeable placeable = (Placeable) list.get(0);
            height = isVertical() ? placeable.getHeight() : placeable.getWidth();
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i9 = 1;
                while (true) {
                    Placeable placeable2 = (Placeable) list.get(i9);
                    int height2 = isVertical() ? placeable2.getHeight() : placeable2.getWidth();
                    height = height2 > height ? height2 : height;
                    if (i9 == lastIndex) {
                        break;
                    }
                    i9++;
                }
            }
        }
        this.mainAxisSize = height;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(height + i2, 0);
        List<Placeable> list2 = this.placeables;
        if (!list2.isEmpty()) {
            Placeable placeable3 = list2.get(0);
            int width = isVertical() ? placeable3.getWidth() : placeable3.getHeight();
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                while (true) {
                    Placeable placeable4 = list2.get(i7);
                    int width2 = isVertical() ? placeable4.getWidth() : placeable4.getHeight();
                    width = width2 > width ? width2 : width;
                    if (i7 == lastIndex2) {
                        break;
                    }
                    i7++;
                }
            }
            i8 = width;
        }
        this.crossAxisSize = i8;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        boolean isVertical = isVertical();
        int i10 = this.mainAxisSize;
        if (isVertical) {
            m8326constructorimpl = IntSize.m8326constructorimpl((i10 & 4294967295L) | (i8 << 32));
        } else {
            m8326constructorimpl = IntSize.m8326constructorimpl((i10 << 32) | (i8 & 4294967295L));
        }
        this.size = m8326constructorimpl;
        this.offset = IntOffset.Companion.m8299getZeronOccac();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getConstraints-msEJaDk */
    public long mo1183getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int i) {
        return this.placeables.get(i).getParentData();
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* renamed from: getSize-YbymL2g */
    public long mo1284getSizeYbymL2g() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* renamed from: getOffset-nOcc-ac */
    public long mo1283getOffsetnOccac() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* renamed from: getOffset-Bjo55l4 */
    public long mo1184getOffsetBjo55l4(int i) {
        return mo1283getOffsetnOccac();
    }

    public final void position(int i, int i2, int i3) {
        long m8282constructorimpl;
        this.mainAxisLayoutSize = i3;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = i3 + this.afterContentPadding;
        if (isVertical()) {
            m8282constructorimpl = IntOffset.m8282constructorimpl((i2 << 32) | (4294967295L & i));
        } else {
            m8282constructorimpl = IntOffset.m8282constructorimpl((i2 & 4294967295L) | (i << 32));
        }
        this.offset = m8282constructorimpl;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int i, int i2, int i3, int i4) {
        if (isVertical()) {
            i3 = i4;
        }
        position(i, i2, i3);
    }

    public final int getMainAxisOffset() {
        return !isVertical() ? IntOffset.m8288getXimpl(mo1283getOffsetnOccac()) : IntOffset.m8289getYimpl(mo1283getOffsetnOccac());
    }

    /* renamed from: place-GMOY1bU  reason: not valid java name */
    public final void m1303placeGMOY1bU(Placeable.PlacementScope placementScope, boolean z, long j, boolean z2) {
        GraphicsLayer graphicsLayer;
        int m8288getXimpl;
        int m8289getYimpl;
        if (!(this.mainAxisLayoutSize != Integer.MIN_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
        }
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            int height = this.minMainAxisOffset - (isVertical() ? placeable.getHeight() : placeable.getWidth());
            int i2 = this.maxMainAxisOffset;
            long mo1283getOffsetnOccac = mo1283getOffsetnOccac();
            LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i);
            if (animation != null) {
                if (z2) {
                    animation.m1237setLookaheadOffsetgyyYBs(mo1283getOffsetnOccac);
                } else {
                    long m8292plusqkQi6aY = IntOffset.m8292plusqkQi6aY(!IntOffset.m8287equalsimpl0(animation.m1233getLookaheadOffsetnOccac(), LazyLayoutItemAnimation.Companion.m1239getNotInitializednOccac()) ? animation.m1233getLookaheadOffsetnOccac() : mo1283getOffsetnOccac, animation.m1234getPlacementDeltanOccac());
                    if ((m1302getMainAxisgyyYBs(mo1283getOffsetnOccac) <= height && m1302getMainAxisgyyYBs(m8292plusqkQi6aY) <= height) || (m1302getMainAxisgyyYBs(mo1283getOffsetnOccac) >= i2 && m1302getMainAxisgyyYBs(m8292plusqkQi6aY) >= i2)) {
                        animation.cancelPlacementAnimation();
                    }
                    mo1283getOffsetnOccac = m8292plusqkQi6aY;
                }
                graphicsLayer = animation.getLayer();
            } else {
                graphicsLayer = null;
            }
            if (z) {
                if (isVertical()) {
                    m8288getXimpl = IntOffset.m8288getXimpl(mo1283getOffsetnOccac);
                } else {
                    m8288getXimpl = (this.mainAxisLayoutSize - IntOffset.m8288getXimpl(mo1283getOffsetnOccac)) - (isVertical() ? placeable.getHeight() : placeable.getWidth());
                }
                if (!isVertical()) {
                    m8289getYimpl = IntOffset.m8289getYimpl(mo1283getOffsetnOccac);
                } else {
                    m8289getYimpl = (this.mainAxisLayoutSize - IntOffset.m8289getYimpl(mo1283getOffsetnOccac)) - (isVertical() ? placeable.getHeight() : placeable.getWidth());
                }
                mo1283getOffsetnOccac = IntOffset.m8282constructorimpl((m8289getYimpl & 4294967295L) | (m8288getXimpl << 32));
            }
            long m8292plusqkQi6aY2 = IntOffset.m8292plusqkQi6aY(mo1283getOffsetnOccac, j);
            if (!z2 && animation != null) {
                animation.m1236setFinalOffsetgyyYBs(m8292plusqkQi6aY2);
            }
            if (graphicsLayer != null) {
                Placeable.PlacementScope.m6887placeRelativeWithLayeraW9wM$default(placementScope, placeable, m8292plusqkQi6aY2, graphicsLayer, 0.0f, 4, (Object) null);
            } else {
                Placeable.PlacementScope.m6886placeRelativeWithLayeraW9wM$default(placementScope, placeable, m8292plusqkQi6aY2, 0.0f, (Function1) null, 6, (Object) null);
            }
        }
    }

    public final void updateMainAxisLayoutSize(int i) {
        this.mainAxisLayoutSize = i;
        this.maxMainAxisOffset = i + this.afterContentPadding;
    }

    public final void applyScrollDelta(int i, boolean z) {
        if (getNonScrollableItem()) {
            return;
        }
        long mo1283getOffsetnOccac = mo1283getOffsetnOccac();
        int m8288getXimpl = isVertical() ? IntOffset.m8288getXimpl(mo1283getOffsetnOccac) : IntOffset.m8288getXimpl(mo1283getOffsetnOccac) + i;
        boolean isVertical = isVertical();
        int m8289getYimpl = IntOffset.m8289getYimpl(mo1283getOffsetnOccac);
        if (isVertical) {
            m8289getYimpl += i;
        }
        this.offset = IntOffset.m8282constructorimpl((m8288getXimpl << 32) | (m8289getYimpl & 4294967295L));
        if (z) {
            int placeablesCount = getPlaceablesCount();
            for (int i2 = 0; i2 < placeablesCount; i2++) {
                LazyLayoutItemAnimation animation = this.animator.getAnimation(getKey(), i2);
                if (animation != null) {
                    long m1235getRawOffsetnOccac = animation.m1235getRawOffsetnOccac();
                    int m8288getXimpl2 = isVertical() ? IntOffset.m8288getXimpl(m1235getRawOffsetnOccac) : Integer.valueOf(IntOffset.m8288getXimpl(m1235getRawOffsetnOccac) + i).intValue();
                    boolean isVertical2 = isVertical();
                    int m8289getYimpl2 = IntOffset.m8289getYimpl(m1235getRawOffsetnOccac);
                    if (isVertical2) {
                        m8289getYimpl2 = Integer.valueOf(m8289getYimpl2 + i).intValue();
                    }
                    animation.m1238setRawOffsetgyyYBs(IntOffset.m8282constructorimpl((m8289getYimpl2 & 4294967295L) | (m8288getXimpl2 << 32)));
                }
            }
        }
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m1302getMainAxisgyyYBs(long j) {
        return isVertical() ? IntOffset.m8289getYimpl(j) : IntOffset.m8288getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return isVertical() ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m1301copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        return IntOffset.m8282constructorimpl(((isVertical() ? IntOffset.m8288getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m8288getXimpl(j))).intValue()) << 32) | ((isVertical() ? function1.invoke(Integer.valueOf(IntOffset.m8289getYimpl(j))).intValue() : IntOffset.m8289getYimpl(j)) & 4294967295L));
    }

    public String toString() {
        return super.toString();
    }
}
