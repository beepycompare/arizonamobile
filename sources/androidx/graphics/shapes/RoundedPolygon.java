package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RoundedPolygon.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B#\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0000J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fJ\u001c\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020#H\u0007J\u0013\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000b¨\u0006)"}, d2 = {"Landroidx/graphics/shapes/RoundedPolygon;", "", "features", "", "Landroidx/graphics/shapes/Feature;", TtmlNode.CENTER, "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "<init>", "(Ljava/util/List;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFeatures", "()Ljava/util/List;", "getCenter-1ufDz9w$graphics_shapes", "()J", "J", "centerX", "", "getCenterX", "()F", "centerY", "getCenterY", "cubics", "Landroidx/graphics/shapes/Cubic;", "getCubics", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "normalized", "toString", "", "calculateMaxBounds", "", "bounds", "calculateBounds", "approximate", "", "equals", "other", "hashCode", "", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoundedPolygon {
    public static final Companion Companion = new Companion(null);
    private final long center;
    private final List<Cubic> cubics;
    private final List<Feature> features;

    public /* synthetic */ RoundedPolygon(List list, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, j);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }

    public final float[] calculateBounds(float[] bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        return calculateBounds$default(this, bounds, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RoundedPolygon(List<? extends Feature> features, long j) {
        List<Cubic> list;
        List<Cubic> list2;
        Cubic cubic;
        List<Cubic> cubics;
        Intrinsics.checkNotNullParameter(features, "features");
        this.features = features;
        this.center = j;
        List createListBuilder = CollectionsKt.createListBuilder();
        int i = 0;
        Cubic cubic2 = null;
        if (features.size() <= 0 || ((Feature) features.get(0)).getCubics().size() != 3) {
            list = null;
            list2 = null;
        } else {
            Pair<Cubic, Cubic> split = ((Feature) features.get(0)).getCubics().get(1).split(0.5f);
            list2 = CollectionsKt.mutableListOf(((Feature) features.get(0)).getCubics().get(0), split.component1());
            list = CollectionsKt.mutableListOf(split.component2(), ((Feature) features.get(0)).getCubics().get(2));
        }
        int size = features.size();
        if (size >= 0) {
            int i2 = 0;
            Cubic cubic3 = null;
            while (true) {
                if (i2 == 0 && list != null) {
                    cubics = list;
                } else if (i2 != this.features.size()) {
                    cubics = this.features.get(i2).getCubics();
                } else if (list2 == null) {
                    break;
                } else {
                    cubics = list2;
                }
                int size2 = cubics.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Cubic cubic4 = cubics.get(i3);
                    if (!cubic4.zeroLength$graphics_shapes()) {
                        if (cubic3 != null) {
                            createListBuilder.add(cubic3);
                        }
                        if (cubic2 == null) {
                            cubic2 = cubic4;
                            cubic3 = cubic2;
                        } else {
                            cubic3 = cubic4;
                        }
                    } else if (cubic3 != null) {
                        float[] points$graphics_shapes = cubic3.getPoints$graphics_shapes();
                        float[] copyOf = Arrays.copyOf(points$graphics_shapes, points$graphics_shapes.length);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                        Cubic cubic5 = new Cubic(copyOf);
                        cubic5.getPoints$graphics_shapes()[6] = cubic4.getAnchor1X();
                        cubic5.getPoints$graphics_shapes()[7] = cubic4.getAnchor1Y();
                        cubic3 = cubic5;
                    }
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
            cubic = cubic2;
            cubic2 = cubic3;
        } else {
            cubic = null;
        }
        if (cubic2 != null && cubic != null) {
            createListBuilder.add(CubicKt.Cubic(cubic2.getAnchor0X(), cubic2.getAnchor0Y(), cubic2.getControl0X(), cubic2.getControl0Y(), cubic2.getControl1X(), cubic2.getControl1Y(), cubic.getAnchor0X(), cubic.getAnchor0Y()));
        } else {
            createListBuilder.add(CubicKt.Cubic(getCenterX(), getCenterY(), getCenterX(), getCenterY(), getCenterX(), getCenterY(), getCenterX(), getCenterY()));
        }
        List<Cubic> build = CollectionsKt.build(createListBuilder);
        this.cubics = build;
        Cubic cubic6 = build.get(build.size() - 1);
        int size3 = build.size();
        while (i < size3) {
            Cubic cubic7 = this.cubics.get(i);
            Cubic cubic8 = cubic6;
            if (Math.abs(cubic7.getAnchor0X() - cubic8.getAnchor1X()) > 1.0E-4f || Math.abs(cubic7.getAnchor0Y() - cubic8.getAnchor1Y()) > 1.0E-4f) {
                throw new IllegalArgumentException("RoundedPolygon must be contiguous, with the anchor points of all curves matching the anchor points of the preceding and succeeding cubics");
            }
            i++;
            cubic6 = cubic7;
        }
    }

    /* renamed from: getCenter-1ufDz9w$graphics_shapes  reason: not valid java name */
    public final long m8840getCenter1ufDz9w$graphics_shapes() {
        return this.center;
    }

    public final List<Feature> getFeatures() {
        return this.features;
    }

    public final float getCenterX() {
        return PointKt.m8821getXDnnuFBc(this.center);
    }

    public final float getCenterY() {
        return PointKt.m8822getYDnnuFBc(this.center);
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public final RoundedPolygon transformed(PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        long m8828transformedso9K2fw = PointKt.m8828transformedso9K2fw(this.center, f);
        List createListBuilder = CollectionsKt.createListBuilder();
        int size = this.features.size();
        for (int i = 0; i < size; i++) {
            createListBuilder.add(this.features.get(i).transformed(f));
        }
        return new RoundedPolygon(CollectionsKt.build(createListBuilder), m8828transformedso9K2fw, null);
    }

    public final RoundedPolygon normalized() {
        float[] calculateBounds$default = calculateBounds$default(this, null, false, 3, null);
        float f = calculateBounds$default[2] - calculateBounds$default[0];
        float f2 = calculateBounds$default[3] - calculateBounds$default[1];
        final float max = Math.max(f, f2);
        float f3 = 2;
        final float f4 = ((max - f) / f3) - calculateBounds$default[0];
        final float f5 = ((max - f2) / f3) - calculateBounds$default[1];
        return transformed(new PointTransformer() { // from class: androidx.graphics.shapes.RoundedPolygon$normalized$1
            @Override // androidx.graphics.shapes.PointTransformer
            /* renamed from: transform-XgqJiTY */
            public final long mo8830transformXgqJiTY(float f6, float f7) {
                float f8 = f6 + f4;
                float f9 = max;
                return FloatFloatPair.m25constructorimpl(f8 / f9, (f7 + f5) / f9);
            }
        });
    }

    public String toString() {
        return "[RoundedPolygon. Cubics = " + CollectionsKt.joinToString$default(this.cubics, null, null, null, 0, null, null, 63, null) + " || Features = " + CollectionsKt.joinToString$default(this.features, null, null, null, 0, null, null, 63, null) + " || Center = (" + getCenterX() + ", " + getCenterY() + ")]";
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(RoundedPolygon roundedPolygon, float[] fArr, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        return roundedPolygon.calculateMaxBounds(fArr);
    }

    public final float[] calculateMaxBounds(float[] bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (bounds.length < 4) {
            throw new IllegalArgumentException("Required bounds size of 4".toString());
        }
        int size = this.cubics.size();
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            Cubic cubic = this.cubics.get(i);
            float distanceSquared = Utils.distanceSquared(cubic.getAnchor0X() - getCenterX(), cubic.getAnchor0Y() - getCenterY());
            long m8809pointOnCurveOOQOV4g$graphics_shapes = cubic.m8809pointOnCurveOOQOV4g$graphics_shapes(0.5f);
            f = Math.max(f, Math.max(distanceSquared, Utils.distanceSquared(PointKt.m8821getXDnnuFBc(m8809pointOnCurveOOQOV4g$graphics_shapes) - getCenterX(), PointKt.m8822getYDnnuFBc(m8809pointOnCurveOOQOV4g$graphics_shapes) - getCenterY())));
        }
        float sqrt = (float) Math.sqrt(f);
        bounds[0] = getCenterX() - sqrt;
        bounds[1] = getCenterY() - sqrt;
        bounds[2] = getCenterX() + sqrt;
        bounds[3] = getCenterY() + sqrt;
        return bounds;
    }

    public static /* synthetic */ float[] calculateBounds$default(RoundedPolygon roundedPolygon, float[] fArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return roundedPolygon.calculateBounds(fArr, z);
    }

    public final float[] calculateBounds(float[] bounds, boolean z) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (bounds.length < 4) {
            throw new IllegalArgumentException("Required bounds size of 4".toString());
        }
        int size = this.cubics.size();
        float f = Float.MIN_VALUE;
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MAX_VALUE;
        float f4 = Float.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            this.cubics.get(i).calculateBounds$graphics_shapes(bounds, z);
            f2 = Math.min(f2, bounds[0]);
            f3 = Math.min(f3, bounds[1]);
            f = Math.max(f, bounds[2]);
            f4 = Math.max(f4, bounds[3]);
        }
        bounds[0] = f2;
        bounds[1] = f3;
        bounds[2] = f;
        bounds[3] = f4;
        return bounds;
    }

    /* compiled from: RoundedPolygon.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/graphics/shapes/RoundedPolygon$Companion;", "", "<init>", "()V", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoundedPolygon) {
            return Intrinsics.areEqual(this.features, ((RoundedPolygon) obj).features);
        }
        return false;
    }

    public int hashCode() {
        return this.features.hashCode();
    }
}
