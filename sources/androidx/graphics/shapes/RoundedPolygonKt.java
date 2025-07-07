package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
/* compiled from: RoundedPolygon.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u001aL\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0007\u001a\u0019\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0012\u001a(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\u0014"}, d2 = {"RoundedPolygon", "Landroidx/graphics/shapes/RoundedPolygon;", "source", "vertices", "", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "perVertexRounding", "", "centerX", "", "centerY", "numVertices", "", "radius", "calculateCenter", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "([F)J", "verticesFromNumVerts", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoundedPolygonKt {
    public static final RoundedPolygon RoundedPolygon(int i) {
        return RoundedPolygon$default(i, 0.0f, 0.0f, 0.0f, null, null, 62, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f) {
        return RoundedPolygon$default(i, f, 0.0f, 0.0f, null, null, 60, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2) {
        return RoundedPolygon$default(i, f, f2, 0.0f, null, null, 56, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2, float f3) {
        return RoundedPolygon$default(i, f, f2, f3, null, null, 48, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2, float f3, CornerRounding rounding) {
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(i, f, f2, f3, rounding, null, 32, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        return RoundedPolygon$default(vertices, null, null, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, null, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, f, 0.0f, 16, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i, float f, float f2, float f3, CornerRounding cornerRounding, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i2 & 32) != 0) {
            list = null;
        }
        List list2 = list;
        return RoundedPolygon(i, f, f2, f3, cornerRounding, list2);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2, float f3, CornerRounding rounding, List<CornerRounding> list) {
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon(verticesFromNumVerts(i, f, f2, f3), rounding, list, f2, f3);
    }

    public static final RoundedPolygon RoundedPolygon(RoundedPolygon source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new RoundedPolygon(source.getFeatures$graphics_shapes_release(), source.getCenterX(), source.getCenterY());
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            f = Float.MIN_VALUE;
        }
        if ((i & 16) != 0) {
            f2 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, list, f, f2);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f, float f2) {
        long calculateCenter;
        int i;
        Pair pair;
        CornerRounding cornerRounding;
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        if (vertices.length < 6) {
            throw new IllegalArgumentException("Polygons must have at least 3 vertices");
        }
        int i2 = 2;
        int i3 = 1;
        if (vertices.length % 2 == 1) {
            throw new IllegalArgumentException("The vertices array should have even size");
        }
        if (list != null && list.size() * 2 != vertices.length) {
            throw new IllegalArgumentException("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
        }
        ArrayList arrayList = new ArrayList();
        int length = vertices.length / 2;
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            CornerRounding cornerRounding2 = (list == null || (cornerRounding = list.get(i5)) == null) ? rounding : cornerRounding;
            int i6 = (((i5 + length) - 1) % length) * 2;
            int i7 = i5 + 1;
            int i8 = (i7 % length) * 2;
            int i9 = i5 * 2;
            arrayList2.add(new RoundedCorner(FloatFloatPair.m14constructorimpl(vertices[i6], vertices[i6 + 1]), FloatFloatPair.m14constructorimpl(vertices[i9], vertices[i9 + 1]), FloatFloatPair.m14constructorimpl(vertices[i8], vertices[i8 + 1]), cornerRounding2, null));
            i5 = i7;
        }
        IntRange until = RangesKt.until(0, length);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            int i10 = (nextInt + 1) % length;
            float expectedRoundCut = ((RoundedCorner) arrayList2.get(nextInt)).getExpectedRoundCut() + ((RoundedCorner) arrayList2.get(i10)).getExpectedRoundCut();
            float expectedCut = ((RoundedCorner) arrayList2.get(nextInt)).getExpectedCut() + ((RoundedCorner) arrayList2.get(i10)).getExpectedCut();
            int i11 = nextInt * 2;
            int i12 = i10 * 2;
            float distance = Utils.distance(vertices[i11] - vertices[i12], vertices[i11 + 1] - vertices[i12 + 1]);
            if (expectedRoundCut > distance) {
                pair = TuplesKt.to(Float.valueOf(distance / expectedRoundCut), Float.valueOf(0.0f));
            } else if (expectedCut > distance) {
                pair = TuplesKt.to(Float.valueOf(1.0f), Float.valueOf((distance - expectedRoundCut) / (expectedCut - expectedRoundCut)));
            } else {
                pair = TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(1.0f));
            }
            arrayList3.add(pair);
        }
        ArrayList arrayList4 = arrayList3;
        for (int i13 = 0; i13 < length; i13++) {
            MutableFloatList mutableFloatList = new MutableFloatList(2);
            for (int i14 = 0; i14 < 2; i14++) {
                Pair pair2 = (Pair) arrayList4.get((((i13 + length) - 1) + i14) % length);
                mutableFloatList.add((((RoundedCorner) arrayList2.get(i13)).getExpectedRoundCut() * ((Number) pair2.component1()).floatValue()) + ((((RoundedCorner) arrayList2.get(i13)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i13)).getExpectedRoundCut()) * ((Number) pair2.component2()).floatValue()));
            }
            arrayList.add(((RoundedCorner) arrayList2.get(i13)).getCubics(mutableFloatList.get(0), mutableFloatList.get(1)));
        }
        ArrayList arrayList5 = new ArrayList();
        while (i4 < length) {
            int i15 = i4 + 1;
            int i16 = i4 * 2;
            long m14constructorimpl = FloatFloatPair.m14constructorimpl(vertices[i16], vertices[i16 + i3]);
            int i17 = (((i4 + length) - i3) % length) * i2;
            long m14constructorimpl2 = FloatFloatPair.m14constructorimpl(vertices[i17], vertices[i17 + i3]);
            int i18 = (i15 % length) * 2;
            arrayList5.add(new Feature.Corner((List) arrayList.get(i4), m14constructorimpl, ((RoundedCorner) arrayList2.get(i4)).m7256getCenter1ufDz9w(), PointKt.m7235clockwiseybeJwSQ(PointKt.m7247minusybeJwSQ(m14constructorimpl, m14constructorimpl2), PointKt.m7247minusybeJwSQ(FloatFloatPair.m14constructorimpl(vertices[i18], vertices[i18 + i3]), m14constructorimpl)), null));
            arrayList5.add(new Feature.Edge(CollectionsKt.listOf(Cubic.Companion.straightLine(((Cubic) CollectionsKt.last((List<? extends Object>) arrayList.get(i4))).getAnchor1X(), ((Cubic) CollectionsKt.last((List<? extends Object>) arrayList.get(i4))).getAnchor1Y(), ((Cubic) CollectionsKt.first((List<? extends Object>) arrayList.get(i))).getAnchor0X(), ((Cubic) CollectionsKt.first((List<? extends Object>) arrayList.get(i))).getAnchor0Y()))));
            i4 = i15;
            i2 = 2;
            i3 = 1;
        }
        if (f == Float.MIN_VALUE || f2 == Float.MIN_VALUE) {
            calculateCenter = calculateCenter(vertices);
        } else {
            calculateCenter = FloatFloatPair.m14constructorimpl(f, f2);
        }
        return new RoundedPolygon(arrayList5, Float.intBitsToFloat((int) (calculateCenter >> 32)), Float.intBitsToFloat((int) (calculateCenter & 4294967295L)));
    }

    private static final long calculateCenter(float[] fArr) {
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        while (i < fArr.length) {
            int i2 = i + 1;
            f += fArr[i];
            i += 2;
            f2 += fArr[i2];
        }
        float f3 = 2;
        return FloatFloatPair.m14constructorimpl((f / fArr.length) / f3, (f2 / fArr.length) / f3);
    }

    private static final float[] verticesFromNumVerts(int i, float f, float f2, float f3) {
        float[] fArr = new float[i * 2];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            float f4 = f;
            long m7248plusybeJwSQ = PointKt.m7248plusybeJwSQ(Utils.m7264radialToCartesianL6JJ3z0$default(f4, (Utils.getFloatPi() / i) * 2 * i2, 0L, 4, null), FloatFloatPair.m14constructorimpl(f2, f3));
            int i4 = i3 + 1;
            fArr[i3] = PointKt.m7244getXDnnuFBc(m7248plusybeJwSQ);
            i3 += 2;
            fArr[i4] = PointKt.m7245getYDnnuFBc(m7248plusybeJwSQ);
            i2++;
            f = f4;
        }
        return fArr;
    }
}
