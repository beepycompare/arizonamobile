package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RelativeLayoutBounds.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0'J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0000J&\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0019J\u0006\u00100\u001a\u00020)J\u001d\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00109\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b%\u0010!¨\u0006:"}, d2 = {"Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "<init>", "(JJJJJ[FLandroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "[F", "positionInRoot", "getPositionInRoot-nOcc-ac", "()J", "positionInWindow", "getPositionInWindow-nOcc-ac", "positionInScreen", "getPositionInScreen-nOcc-ac", "width", "", "getWidth", "()I", "height", "getHeight", "boundsInRoot", "Landroidx/compose/ui/unit/IntRect;", "getBoundsInRoot", "()Landroidx/compose/ui/unit/IntRect;", "boundsInWindow", "getBoundsInWindow", "boundsInScreen", "getBoundsInScreen", "calculateOcclusions", "", "fractionVisibleIn", "", "viewport", "fractionVisibleInRect", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "fractionVisibleInWindow", "fractionVisibleInWindowWithInsets", "topLeftInset", "bottomRightInset", "fractionVisibleInWindowWithInsets-E1MhUcY", "(JJ)F", "equals", "", "other", "hashCode", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RelativeLayoutBounds {
    public static final int $stable = 8;
    private final long bottomRight;
    private final DelegatableNode node;
    private final long screenOffset;
    private final long topLeft;
    private final float[] viewToWindowMatrix;
    private final long windowOffset;
    private final long windowSize;

    public /* synthetic */ RelativeLayoutBounds(long j, long j2, long j3, long j4, long j5, float[] fArr, DelegatableNode delegatableNode, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, fArr, delegatableNode);
    }

    private RelativeLayoutBounds(long j, long j2, long j3, long j4, long j5, float[] fArr, DelegatableNode delegatableNode) {
        this.topLeft = j;
        this.bottomRight = j2;
        this.windowOffset = j3;
        this.screenOffset = j4;
        this.windowSize = j5;
        this.viewToWindowMatrix = fArr;
        this.node = delegatableNode;
    }

    /* renamed from: getPositionInRoot-nOcc-ac  reason: not valid java name */
    public final long m6489getPositionInRootnOccac() {
        return IntOffset.m7373constructorimpl(this.topLeft);
    }

    /* renamed from: getPositionInWindow-nOcc-ac  reason: not valid java name */
    public final long m6491getPositionInWindownOccac() {
        int m7379getXimpl = IntOffset.m7379getXimpl(this.screenOffset) - IntOffset.m7379getXimpl(this.windowOffset);
        int m7380getYimpl = IntOffset.m7380getYimpl(this.screenOffset) - IntOffset.m7380getYimpl(this.windowOffset);
        long j = this.topLeft;
        return IntOffset.m7373constructorimpl(((((int) (j >> 32)) + m7379getXimpl) << 32) | ((((int) j) + m7380getYimpl) & 4294967295L));
    }

    /* renamed from: getPositionInScreen-nOcc-ac  reason: not valid java name */
    public final long m6490getPositionInScreennOccac() {
        int m7379getXimpl = IntOffset.m7379getXimpl(this.screenOffset);
        int m7380getYimpl = IntOffset.m7380getYimpl(this.screenOffset);
        long j = this.topLeft;
        return IntOffset.m7373constructorimpl(((((int) (j >> 32)) + m7379getXimpl) << 32) | ((((int) j) + m7380getYimpl) & 4294967295L));
    }

    public final int getWidth() {
        return ((int) (this.bottomRight >> 32)) - ((int) (this.topLeft >> 32));
    }

    public final int getHeight() {
        return ((int) this.bottomRight) - ((int) this.topLeft);
    }

    public final IntRect getBoundsInRoot() {
        long j = this.topLeft;
        long j2 = this.bottomRight;
        return new IntRect((int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
    }

    public final IntRect getBoundsInWindow() {
        long j = this.topLeft;
        int i = (int) (j >> 32);
        int i2 = (int) j;
        long j2 = this.bottomRight;
        int i3 = (int) (j2 >> 32);
        int i4 = (int) j2;
        float[] fArr = this.viewToWindowMatrix;
        if (fArr != null) {
            return IntRectKt.roundToIntRect(Matrix.m4786mapimpl(fArr, new Rect(i, i2, i3, i4)));
        }
        int m7379getXimpl = IntOffset.m7379getXimpl(this.screenOffset) - IntOffset.m7379getXimpl(this.windowOffset);
        int m7380getYimpl = IntOffset.m7380getYimpl(this.screenOffset) - IntOffset.m7380getYimpl(this.windowOffset);
        return new IntRect(i + m7379getXimpl, i2 + m7380getYimpl, i3 + m7379getXimpl, i4 + m7380getYimpl);
    }

    public final IntRect getBoundsInScreen() {
        if (this.viewToWindowMatrix != null) {
            IntRect boundsInWindow = getBoundsInWindow();
            long j = this.windowOffset;
            return new IntRect(boundsInWindow.getLeft() + IntOffset.m7379getXimpl(j), boundsInWindow.getTop() + IntOffset.m7380getYimpl(j), boundsInWindow.getRight() + IntOffset.m7379getXimpl(j), boundsInWindow.getBottom() + IntOffset.m7380getYimpl(j));
        }
        long j2 = this.topLeft;
        long j3 = this.bottomRight;
        int i = (int) j3;
        int m7379getXimpl = IntOffset.m7379getXimpl(this.screenOffset);
        int m7380getYimpl = IntOffset.m7380getYimpl(this.screenOffset);
        return new IntRect(((int) (j2 >> 32)) + m7379getXimpl, ((int) j2) + m7380getYimpl, ((int) (j3 >> 32)) + m7379getXimpl, i + m7380getYimpl);
    }

    public final List<IntRect> calculateOcclusions() {
        int i;
        int i2;
        RectManager rectManager = DelegatableNodeKt.requireOwner(this.node).getRectManager();
        int semanticsId = DelegatableNodeKt.requireLayoutNode(this.node).getSemanticsId();
        RectList rects = rectManager.getRects();
        int indexOf = rects.indexOf(semanticsId);
        if (indexOf < 0) {
            return CollectionsKt.emptyList();
        }
        List createListBuilder = CollectionsKt.createListBuilder();
        long[] jArr = rects.items;
        int i3 = rects.itemsSize;
        long j = jArr[indexOf];
        long j2 = jArr[indexOf + 1];
        int i4 = 0;
        while (i4 < jArr.length - 2 && i4 < i3) {
            if (i4 == indexOf) {
                i4 += 3;
            } else {
                long j3 = jArr[i4];
                long j4 = jArr[i4 + 1];
                if (((((j2 - j3) - InlineClassHelperKt.Uint64Low32) | ((j4 - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                    i = i3;
                    i2 = indexOf;
                    int i5 = (int) (j3 >> 32);
                    int i6 = (int) j3;
                    int i7 = (int) (j4 >> 32);
                    int i8 = (int) j4;
                    if (rectManager.isTargetDrawnFirst$ui_release(semanticsId, ((int) jArr[i4 + 2]) & RectListKt.Lower26Bits)) {
                        createListBuilder.add(new IntRect(i5, i6, i7, i8));
                    }
                } else {
                    i = i3;
                    i2 = indexOf;
                }
                i4 += 3;
                indexOf = i2;
                i3 = i;
            }
        }
        return CollectionsKt.build(createListBuilder);
    }

    public final float fractionVisibleIn(RelativeLayoutBounds relativeLayoutBounds) {
        long j = relativeLayoutBounds.topLeft;
        long j2 = relativeLayoutBounds.bottomRight;
        return fractionVisibleInRect((int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
    }

    public final float fractionVisibleInRect(int i, int i2, int i3, int i4) {
        int i5 = (int) (this.topLeft >> 32);
        int min = Math.min(Math.max(i5, i), i3);
        int i6 = (int) this.topLeft;
        int min2 = Math.min(Math.max(i6, i2), i4);
        int i7 = (int) (this.bottomRight >> 32);
        int max = Math.max(Math.min(i7, i3), i);
        int i8 = (int) this.bottomRight;
        return Math.max((max - min) * (Math.max(Math.min(i8, i4), i2) - min2), 0) / Math.min((i3 - i) * (i4 - i2), (i7 - i5) * (i8 - i6));
    }

    public final float fractionVisibleInWindow() {
        long j = this.windowSize;
        return fractionVisibleInRect(0, 0, (int) (j >> 32), (int) j);
    }

    /* renamed from: fractionVisibleInWindowWithInsets-E1MhUcY  reason: not valid java name */
    public final float m6488fractionVisibleInWindowWithInsetsE1MhUcY(long j, long j2) {
        long j3 = this.windowSize;
        int m7379getXimpl = IntOffset.m7379getXimpl(this.windowOffset);
        int m7380getYimpl = IntOffset.m7380getYimpl(this.windowOffset);
        return fractionVisibleInRect(IntOffset.m7379getXimpl(j) + m7379getXimpl, IntOffset.m7380getYimpl(j) + m7380getYimpl, (m7379getXimpl + ((int) (j3 >> 32))) - IntOffset.m7379getXimpl(j2), (m7380getYimpl + ((int) j3)) - IntOffset.m7380getYimpl(j2));
    }

    public boolean equals(Object obj) {
        boolean m4781equalsimpl0;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RelativeLayoutBounds relativeLayoutBounds = (RelativeLayoutBounds) obj;
        if (this.topLeft == relativeLayoutBounds.topLeft && this.bottomRight == relativeLayoutBounds.bottomRight && this.windowSize == relativeLayoutBounds.windowSize && IntOffset.m7378equalsimpl0(this.windowOffset, relativeLayoutBounds.windowOffset) && IntOffset.m7378equalsimpl0(this.screenOffset, relativeLayoutBounds.screenOffset)) {
            float[] fArr = this.viewToWindowMatrix;
            float[] fArr2 = relativeLayoutBounds.viewToWindowMatrix;
            if (fArr == null) {
                if (fArr2 == null) {
                    m4781equalsimpl0 = true;
                }
                m4781equalsimpl0 = false;
            } else {
                if (fArr2 != null) {
                    m4781equalsimpl0 = Matrix.m4781equalsimpl0(fArr, fArr2);
                }
                m4781equalsimpl0 = false;
            }
            return m4781equalsimpl0 && Intrinsics.areEqual(this.node, relativeLayoutBounds.node);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((Long.hashCode(this.topLeft) * 31) + Long.hashCode(this.bottomRight)) * 31) + Long.hashCode(this.windowSize)) * 31) + IntOffset.m7381hashCodeimpl(this.windowOffset)) * 31) + IntOffset.m7381hashCodeimpl(this.screenOffset)) * 31;
        float[] fArr = this.viewToWindowMatrix;
        return ((hashCode + (fArr != null ? Matrix.m4783hashCodeimpl(fArr) : 0)) * 31) + this.node.hashCode();
    }
}
