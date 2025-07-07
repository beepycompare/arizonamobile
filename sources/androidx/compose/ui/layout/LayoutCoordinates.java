package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.Set;
import kotlin.Metadata;
/* compiled from: LayoutCoordinates.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H¦\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u0003H&J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J.\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001a\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010)J\u001a\u0010,\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\b-\u0010)J\u001a\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b0\u0010)J\"\u00101\u001a\u0002022\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001a\u00107\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001a\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\b<\u0010)R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u0014X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006=À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "", "introducesMotionFrameOfReference", "", "getIntroducesMotionFrameOfReference$annotations", "()V", "getIntroducesMotionFrameOfReference", "()Z", "isAttached", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LayoutCoordinates {
    int get(AlignmentLine alignmentLine);

    default boolean getIntroducesMotionFrameOfReference() {
        return false;
    }

    LayoutCoordinates getParentCoordinates();

    LayoutCoordinates getParentLayoutCoordinates();

    Set<AlignmentLine> getProvidedAlignmentLines();

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    long mo5446getSizeYbymL2g();

    boolean isAttached();

    Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z);

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    long mo5447localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j);

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    long mo5449localToRootMKHz9U(long j);

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    long mo5451localToWindowMKHz9U(long j);

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    long mo5455windowToLocalMKHz9U(long j);

    /* compiled from: LayoutCoordinates.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getIntroducesMotionFrameOfReference$annotations() {
        }

        @Deprecated
        public static boolean getIntroducesMotionFrameOfReference(LayoutCoordinates layoutCoordinates) {
            return LayoutCoordinates.super.getIntroducesMotionFrameOfReference();
        }

        @Deprecated
        /* renamed from: screenToLocal-MK-Hz9U  reason: not valid java name */
        public static long m5459screenToLocalMKHz9U(LayoutCoordinates layoutCoordinates, long j) {
            return LayoutCoordinates.super.mo5452screenToLocalMKHz9U(j);
        }

        @Deprecated
        /* renamed from: localToScreen-MK-Hz9U  reason: not valid java name */
        public static long m5458localToScreenMKHz9U(LayoutCoordinates layoutCoordinates, long j) {
            return LayoutCoordinates.super.mo5450localToScreenMKHz9U(j);
        }

        @Deprecated
        /* renamed from: localPositionOf-S_NoaFU  reason: not valid java name */
        public static long m5456localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j, boolean z) {
            return LayoutCoordinates.super.mo5448localPositionOfS_NoaFU(layoutCoordinates2, j, z);
        }

        @Deprecated
        /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
        public static void m5460transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, float[] fArr) {
            LayoutCoordinates.super.mo5453transformFromEL8BTi8(layoutCoordinates2, fArr);
        }

        @Deprecated
        /* renamed from: transformToScreen-58bKbWc  reason: not valid java name */
        public static void m5461transformToScreen58bKbWc(LayoutCoordinates layoutCoordinates, float[] fArr) {
            LayoutCoordinates.super.mo5454transformToScreen58bKbWc(fArr);
        }
    }

    /* renamed from: screenToLocal-MK-Hz9U  reason: not valid java name */
    default long mo5452screenToLocalMKHz9U(long j) {
        return Offset.Companion.m3852getUnspecifiedF1C5BW0();
    }

    /* renamed from: localToScreen-MK-Hz9U  reason: not valid java name */
    default long mo5450localToScreenMKHz9U(long j) {
        return Offset.Companion.m3852getUnspecifiedF1C5BW0();
    }

    /* renamed from: localPositionOf-S_NoaFU$default  reason: not valid java name */
    static /* synthetic */ long m5445localPositionOfS_NoaFU$default(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                j = Offset.Companion.m3853getZeroF1C5BW0();
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return layoutCoordinates.mo5448localPositionOfS_NoaFU(layoutCoordinates2, j, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localPositionOf-S_NoaFU");
    }

    /* renamed from: localPositionOf-S_NoaFU  reason: not valid java name */
    default long mo5448localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j, boolean z) {
        throw new UnsupportedOperationException("localPositionOf is not implemented on this LayoutCoordinates");
    }

    static /* synthetic */ Rect localBoundingBoxOf$default(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            return layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    default void mo5453transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        InlineClassHelperKt.throwUnsupportedOperationException("transformFrom is not implemented on this LayoutCoordinates");
    }

    /* renamed from: transformToScreen-58bKbWc  reason: not valid java name */
    default void mo5454transformToScreen58bKbWc(float[] fArr) {
        throw new UnsupportedOperationException("transformToScreen is not implemented on this LayoutCoordinates");
    }
}
