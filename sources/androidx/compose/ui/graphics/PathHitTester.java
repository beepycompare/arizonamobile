package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.PathIterator;
import androidx.compose.ui.graphics.PathSegment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PathHitTester.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/graphics/PathHitTester;", "", "()V", "bounds", "Landroidx/compose/ui/geometry/Rect;", "curves", "", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "path", "Landroidx/compose/ui/graphics/Path;", "roots", "tolerance", "", "contains", "", "position", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "updatePath", "", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PathHitTester {
    private Rect bounds;
    private final float[] curves;
    private final IntervalTree<PathSegment> intervals;
    private Path path;
    private final float[] roots;
    private float tolerance;

    /* compiled from: PathHitTester.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PathHitTester() {
        Path path;
        path = PathHitTesterKt.EmptyPath;
        this.path = path;
        this.tolerance = 0.5f;
        this.bounds = Rect.Companion.getZero();
        this.intervals = new IntervalTree<>();
        this.curves = new float[20];
        this.roots = new float[2];
    }

    public static /* synthetic */ void updatePath$default(PathHitTester pathHitTester, Path path, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        pathHitTester.updatePath(path, f);
    }

    public final void updatePath(Path path, float f) {
        this.path = path;
        this.tolerance = f;
        this.bounds = path.getBounds();
        this.intervals.clear();
        PathIterator it = path.iterator(PathIterator.ConicEvaluation.AsQuadratics, f);
        while (it.hasNext()) {
            PathSegment next = it.next();
            int i = WhenMappings.$EnumSwitchMapping$0[next.getType().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                long computeVerticalBounds$default = BezierKt.computeVerticalBounds$default(next, this.curves, 0, 4, null);
                this.intervals.addInterval(Float.intBitsToFloat((int) (computeVerticalBounds$default >> 32)), Float.intBitsToFloat((int) (computeVerticalBounds$default & 4294967295L)), next);
            } else if (i == 4) {
                return;
            }
        }
    }

    /* renamed from: contains-k-4lQ0M  reason: not valid java name */
    public final boolean m4363containsk4lQ0M(long j) {
        int i;
        int lineWinding;
        if (!this.path.isEmpty() && this.bounds.m3863containsk4lQ0M(j)) {
            float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
            float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
            float[] fArr = this.curves;
            float[] fArr2 = this.roots;
            IntervalTree<PathSegment> intervalTree = this.intervals;
            if (intervalTree.root != intervalTree.terminator) {
                ArrayList<IntervalTree<PathSegment>.Node> arrayList = intervalTree.stack;
                arrayList.add(intervalTree.root);
                i = 0;
                while (arrayList.size() > 0) {
                    IntervalTree<PathSegment>.Node remove = arrayList.remove(arrayList.size() - 1);
                    if (remove.overlaps(intBitsToFloat2, intBitsToFloat2)) {
                        PathSegment data = remove.getData();
                        Intrinsics.checkNotNull(data);
                        PathSegment pathSegment = data;
                        float[] points = pathSegment.getPoints();
                        int i2 = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
                        if (i2 == 1) {
                            lineWinding = BezierKt.lineWinding(points, intBitsToFloat, intBitsToFloat2);
                        } else if (i2 == 2) {
                            lineWinding = BezierKt.quadraticWinding(points, intBitsToFloat, intBitsToFloat2, fArr, fArr2);
                        } else if (i2 == 3) {
                            lineWinding = BezierKt.cubicWinding(points, intBitsToFloat, intBitsToFloat2, fArr, fArr2);
                        }
                        i += lineWinding;
                    }
                    if (remove.getLeft() != intervalTree.terminator && remove.getLeft().getMax() >= intBitsToFloat2) {
                        arrayList.add(remove.getLeft());
                    }
                    if (remove.getRight() != intervalTree.terminator && remove.getRight().getMin() <= intBitsToFloat2) {
                        arrayList.add(remove.getRight());
                    }
                }
                arrayList.clear();
            } else {
                i = 0;
            }
            if (PathFillType.m4357equalsimpl0(this.path.mo3969getFillTypeRgk1Os(), PathFillType.Companion.m4361getEvenOddRgk1Os())) {
                i &= 1;
            }
            if (i != 0) {
                return true;
            }
        }
        return false;
    }
}
