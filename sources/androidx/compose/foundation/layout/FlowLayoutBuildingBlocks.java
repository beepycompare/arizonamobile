package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FlowLayoutBuildingBlocks.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0002#$B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ8\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003JW\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks;", "", "maxItemsInMainAxis", "", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "maxLines", "mainAxisSpacing", "crossAxisSpacing", "<init>", "(ILandroidx/compose/foundation/layout/FlowLayoutOverflowState;JIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getWrapEllipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "wrapInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "hasNext", "", "lastContentLineIndex", "totalCrossAxisSize", "leftOverMainAxis", "nextIndexInLine", "getWrapInfo", "nextItemHasNext", "leftOver", "Landroidx/collection/IntIntPair;", "nextSize", "lineIndex", "currentLineCrossAxisSize", "isWrappingRound", "isEllipsisWrap", "getWrapInfo-OpUlnko", "(ZIJLandroidx/collection/IntIntPair;IIIZZ)Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "WrapInfo", "WrapEllipsisInfo", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowLayoutBuildingBlocks {
    public static final int $stable = 8;
    private final long constraints;
    private final int crossAxisSpacing;
    private final int mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;

    public /* synthetic */ FlowLayoutBuildingBlocks(int i, FlowLayoutOverflowState flowLayoutOverflowState, long j, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, flowLayoutOverflowState, j, i2, i3, i4);
    }

    private FlowLayoutBuildingBlocks(int i, FlowLayoutOverflowState flowLayoutOverflowState, long j, int i2, int i3, int i4) {
        this.maxItemsInMainAxis = i;
        this.overflow = flowLayoutOverflowState;
        this.constraints = j;
        this.maxLines = i2;
        this.mainAxisSpacing = i3;
        this.crossAxisSpacing = i4;
    }

    /* compiled from: FlowLayoutBuildingBlocks.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "", "isLastItemInLine", "", "isLastItemInContainer", "<init>", "(ZZ)V", "()Z", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class WrapInfo {
        public static final int $stable = 0;
        private final boolean isLastItemInContainer;
        private final boolean isLastItemInLine;

        public WrapInfo() {
            this(false, false, 3, null);
        }

        public WrapInfo(boolean z, boolean z2) {
            this.isLastItemInLine = z;
            this.isLastItemInContainer = z2;
        }

        public /* synthetic */ WrapInfo(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
        }

        public final boolean isLastItemInLine() {
            return this.isLastItemInLine;
        }

        public final boolean isLastItemInContainer() {
            return this.isLastItemInContainer;
        }
    }

    /* compiled from: FlowLayoutBuildingBlocks.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "", "ellipsis", "Landroidx/compose/ui/layout/Measurable;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "ellipsisSize", "Landroidx/collection/IntIntPair;", "placeEllipsisOnLastContentLine", "", "<init>", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Placeable;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEllipsis", "()Landroidx/compose/ui/layout/Measurable;", "getPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "getEllipsisSize-OO21N7I", "()J", "J", "getPlaceEllipsisOnLastContentLine", "()Z", "setPlaceEllipsisOnLastContentLine", "(Z)V", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class WrapEllipsisInfo {
        public static final int $stable = 8;
        private final Measurable ellipsis;
        private final long ellipsisSize;
        private boolean placeEllipsisOnLastContentLine;
        private final Placeable placeable;

        public /* synthetic */ WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(measurable, placeable, j, z);
        }

        private WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j, boolean z) {
            this.ellipsis = measurable;
            this.placeable = placeable;
            this.ellipsisSize = j;
            this.placeEllipsisOnLastContentLine = z;
        }

        public /* synthetic */ WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(measurable, placeable, j, (i & 8) != 0 ? true : z, null);
        }

        public final Measurable getEllipsis() {
            return this.ellipsis;
        }

        public final Placeable getPlaceable() {
            return this.placeable;
        }

        /* renamed from: getEllipsisSize-OO21N7I  reason: not valid java name */
        public final long m736getEllipsisSizeOO21N7I() {
            return this.ellipsisSize;
        }

        public final boolean getPlaceEllipsisOnLastContentLine() {
            return this.placeEllipsisOnLastContentLine;
        }

        public final void setPlaceEllipsisOnLastContentLine(boolean z) {
            this.placeEllipsisOnLastContentLine = z;
        }
    }

    public final WrapEllipsisInfo getWrapEllipsisInfo(WrapInfo wrapInfo, boolean z, int i, int i2, int i3, int i4) {
        WrapEllipsisInfo ellipsisInfo$foundation_layout;
        if (wrapInfo.isLastItemInContainer() && (ellipsisInfo$foundation_layout = this.overflow.ellipsisInfo$foundation_layout(z, i, i2)) != null) {
            ellipsisInfo$foundation_layout.setPlaceEllipsisOnLastContentLine(i >= 0 && (i4 == 0 || (i3 - IntIntPair.m28getFirstimpl(ellipsisInfo$foundation_layout.m736getEllipsisSizeOO21N7I()) >= 0 && i4 < this.maxItemsInMainAxis)));
            return ellipsisInfo$foundation_layout;
        }
        return null;
    }

    /* renamed from: getWrapInfo-OpUlnko  reason: not valid java name */
    public final WrapInfo m735getWrapInfoOpUlnko(boolean z, int i, long j, IntIntPair intIntPair, int i2, int i3, int i4, boolean z2, boolean z3) {
        int i5 = i3 + i4;
        if (intIntPair == null) {
            return new WrapInfo(true, true);
        }
        if (this.overflow.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.Visible && (i2 >= this.maxLines || IntIntPair.m29getSecondimpl(j) - IntIntPair.m29getSecondimpl(intIntPair.m32unboximpl()) < 0)) {
            return new WrapInfo(true, true);
        }
        if (i != 0 && (i >= this.maxItemsInMainAxis || IntIntPair.m28getFirstimpl(j) - IntIntPair.m28getFirstimpl(intIntPair.m32unboximpl()) < 0)) {
            if (z2) {
                return new WrapInfo(true, true);
            }
            return new WrapInfo(true, m735getWrapInfoOpUlnko(z, 0, IntIntPair.m24constructorimpl(Constraints.m7508getMaxWidthimpl(this.constraints), (IntIntPair.m29getSecondimpl(j) - this.crossAxisSpacing) - i4), IntIntPair.m21boximpl(IntIntPair.m24constructorimpl(IntIntPair.m28getFirstimpl(intIntPair.m32unboximpl()) - this.mainAxisSpacing, IntIntPair.m29getSecondimpl(intIntPair.m32unboximpl()))), i2 + 1, i5, 0, true, false).isLastItemInContainer());
        }
        int max = i3 + Math.max(i4, IntIntPair.m29getSecondimpl(intIntPair.m32unboximpl()));
        IntIntPair m743ellipsisSizeF35zmw$foundation_layout = z3 ? null : this.overflow.m743ellipsisSizeF35zmw$foundation_layout(z, i2, max);
        if (m743ellipsisSizeF35zmw$foundation_layout != null) {
            m743ellipsisSizeF35zmw$foundation_layout.m32unboximpl();
            if (i + 1 >= this.maxItemsInMainAxis || ((IntIntPair.m28getFirstimpl(j) - IntIntPair.m28getFirstimpl(intIntPair.m32unboximpl())) - this.mainAxisSpacing) - IntIntPair.m28getFirstimpl(m743ellipsisSizeF35zmw$foundation_layout.m32unboximpl()) < 0) {
                if (z3) {
                    return new WrapInfo(true, true);
                }
                WrapInfo m735getWrapInfoOpUlnko = m735getWrapInfoOpUlnko(false, 0, IntIntPair.m24constructorimpl(Constraints.m7508getMaxWidthimpl(this.constraints), (IntIntPair.m29getSecondimpl(j) - this.crossAxisSpacing) - Math.max(i4, IntIntPair.m29getSecondimpl(intIntPair.m32unboximpl()))), m743ellipsisSizeF35zmw$foundation_layout, i2 + 1, max, 0, true, true);
                return new WrapInfo(m735getWrapInfoOpUlnko.isLastItemInContainer(), m735getWrapInfoOpUlnko.isLastItemInContainer());
            }
        }
        return new WrapInfo(false, false);
    }
}
