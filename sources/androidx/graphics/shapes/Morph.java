package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.graphics.shapes.MeasuredPolygon;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Morph.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0017\u001a\u00020\u0018J2\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001a0\u001eH\u0087\bø\u0001\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\b8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"Landroidx/graphics/shapes/Morph;", "", TtmlNode.START, "Landroidx/graphics/shapes/RoundedPolygon;", TtmlNode.END, "<init>", "(Landroidx/graphics/shapes/RoundedPolygon;Landroidx/graphics/shapes/RoundedPolygon;)V", "morphMatch", "", "Lkotlin/Pair;", "Landroidx/graphics/shapes/Cubic;", "getMorphMatch$annotations", "()V", "getMorphMatch", "()Ljava/util/List;", "_morphMatch", "calculateBounds", "", "bounds", "approximate", "", "calculateMaxBounds", "asCubics", "progress", "", "forEachCubic", "", "mutableCubic", "Landroidx/graphics/shapes/MutableCubic;", "callback", "Lkotlin/Function1;", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Morph {
    public static final Companion Companion = new Companion(null);
    private final List<Pair<Cubic, Cubic>> _morphMatch;
    private final RoundedPolygon end;
    private final RoundedPolygon start;

    public static /* synthetic */ void getMorphMatch$annotations() {
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }

    public final float[] calculateBounds(float[] bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        return calculateBounds$default(this, bounds, false, 2, null);
    }

    public Morph(RoundedPolygon start, RoundedPolygon end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        this.start = start;
        this.end = end;
        this._morphMatch = Companion.match$graphics_shapes(start, end);
    }

    public final List<Pair<Cubic, Cubic>> getMorphMatch() {
        return this._morphMatch;
    }

    public static /* synthetic */ float[] calculateBounds$default(Morph morph, float[] fArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return morph.calculateBounds(fArr, z);
    }

    public final float[] calculateBounds(float[] bounds, boolean z) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.start.calculateBounds(bounds, z);
        float f = bounds[0];
        float f2 = bounds[1];
        float f3 = bounds[2];
        float f4 = bounds[3];
        this.end.calculateBounds(bounds, z);
        bounds[0] = Math.min(f, bounds[0]);
        bounds[1] = Math.min(f2, bounds[1]);
        bounds[2] = Math.max(f3, bounds[2]);
        bounds[3] = Math.max(f4, bounds[3]);
        return bounds;
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(Morph morph, float[] fArr, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        return morph.calculateMaxBounds(fArr);
    }

    public final float[] calculateMaxBounds(float[] bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.start.calculateMaxBounds(bounds);
        float f = bounds[0];
        float f2 = bounds[1];
        float f3 = bounds[2];
        float f4 = bounds[3];
        this.end.calculateMaxBounds(bounds);
        bounds[0] = Math.min(f, bounds[0]);
        bounds[1] = Math.min(f2, bounds[1]);
        bounds[2] = Math.max(f3, bounds[2]);
        bounds[3] = Math.max(f4, bounds[3]);
        return bounds;
    }

    public final List<Cubic> asCubics(float f) {
        List createListBuilder = CollectionsKt.createListBuilder();
        int size = this._morphMatch.size();
        Cubic cubic = null;
        Cubic cubic2 = null;
        int i = 0;
        while (i < size) {
            float[] fArr = new float[8];
            for (int i2 = 0; i2 < 8; i2++) {
                fArr[i2] = Utils.interpolate(this._morphMatch.get(i).getFirst().getPoints$graphics_shapes()[i2], this._morphMatch.get(i).getSecond().getPoints$graphics_shapes()[i2], f);
            }
            Cubic cubic3 = new Cubic(fArr);
            if (cubic2 == null) {
                cubic2 = cubic3;
            }
            if (cubic != null) {
                createListBuilder.add(cubic);
            }
            i++;
            cubic = cubic3;
        }
        if (cubic != null && cubic2 != null) {
            createListBuilder.add(CubicKt.Cubic(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic2.getAnchor0X(), cubic2.getAnchor0Y()));
        }
        return CollectionsKt.build(createListBuilder);
    }

    public static /* synthetic */ void forEachCubic$default(Morph morph, float f, MutableCubic mutableCubic, Function1 callback, int i, Object obj) {
        if ((i & 2) != 0) {
            mutableCubic = new MutableCubic();
        }
        Intrinsics.checkNotNullParameter(mutableCubic, "mutableCubic");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int size = morph.getMorphMatch().size();
        for (int i2 = 0; i2 < size; i2++) {
            mutableCubic.interpolate(morph.getMorphMatch().get(i2).getFirst(), morph.getMorphMatch().get(i2).getSecond(), f);
            callback.invoke(mutableCubic);
        }
    }

    public final void forEachCubic(float f, MutableCubic mutableCubic, Function1<? super MutableCubic, Unit> callback) {
        Intrinsics.checkNotNullParameter(mutableCubic, "mutableCubic");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int size = getMorphMatch().size();
        for (int i = 0; i < size; i++) {
            mutableCubic.interpolate(getMorphMatch().get(i).getFirst(), getMorphMatch().get(i).getSecond(), f);
            callback.invoke(mutableCubic);
        }
    }

    /* compiled from: Morph.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/graphics/shapes/Morph$Companion;", "", "<init>", "()V", "match", "", "Lkotlin/Pair;", "Landroidx/graphics/shapes/Cubic;", "p1", "Landroidx/graphics/shapes/RoundedPolygon;", "p2", "match$graphics_shapes", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<Pair<Cubic, Cubic>> match$graphics_shapes(RoundedPolygon p1, RoundedPolygon p2) {
            Pair<MeasuredPolygon.MeasuredCubic, MeasuredPolygon.MeasuredCubic> pair;
            Pair<MeasuredPolygon.MeasuredCubic, MeasuredPolygon.MeasuredCubic> pair2;
            String unused;
            String unused2;
            String unused3;
            String unused4;
            String unused5;
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            MeasuredPolygon measurePolygon$graphics_shapes = MeasuredPolygon.Companion.measurePolygon$graphics_shapes(new LengthMeasurer(), p1);
            MeasuredPolygon measurePolygon$graphics_shapes2 = MeasuredPolygon.Companion.measurePolygon$graphics_shapes(new LengthMeasurer(), p2);
            DoubleMapper featureMapper = FeatureMappingKt.featureMapper(measurePolygon$graphics_shapes.getFeatures(), measurePolygon$graphics_shapes2.getFeatures());
            float map = featureMapper.map(0.0f);
            unused = MorphKt.LOG_TAG;
            MeasuredPolygon cutAndShift = measurePolygon$graphics_shapes2.cutAndShift(map);
            ArrayList arrayList = new ArrayList();
            MeasuredPolygon measuredPolygon = measurePolygon$graphics_shapes;
            MeasuredPolygon.MeasuredCubic measuredCubic = (MeasuredPolygon.MeasuredCubic) CollectionsKt.getOrNull(measuredPolygon, 0);
            MeasuredPolygon measuredPolygon2 = cutAndShift;
            MeasuredPolygon.MeasuredCubic measuredCubic2 = (MeasuredPolygon.MeasuredCubic) CollectionsKt.getOrNull(measuredPolygon2, 0);
            int i = 1;
            int i2 = 1;
            while (measuredCubic != null && measuredCubic2 != null) {
                float endOutlineProgress = i == measurePolygon$graphics_shapes.size() ? 1.0f : measuredCubic.getEndOutlineProgress();
                float mapBack = i2 == cutAndShift.size() ? 1.0f : featureMapper.mapBack(Utils.positiveModulo(measuredCubic2.getEndOutlineProgress() + map, 1.0f));
                float min = Math.min(endOutlineProgress, mapBack);
                unused2 = MorphKt.LOG_TAG;
                float f = 1.0E-6f + min;
                if (endOutlineProgress > f) {
                    unused3 = MorphKt.LOG_TAG;
                    pair = measuredCubic.cutAtProgress(min);
                } else {
                    pair = TuplesKt.to(measuredCubic, CollectionsKt.getOrNull(measuredPolygon, i));
                    i++;
                }
                MeasuredPolygon.MeasuredCubic component1 = pair.component1();
                measuredCubic = pair.component2();
                if (mapBack > f) {
                    unused4 = MorphKt.LOG_TAG;
                    pair2 = measuredCubic2.cutAtProgress(Utils.positiveModulo(featureMapper.map(min) - map, 1.0f));
                } else {
                    pair2 = TuplesKt.to(measuredCubic2, CollectionsKt.getOrNull(measuredPolygon2, i2));
                    i2++;
                }
                measuredCubic2 = pair2.component2();
                unused5 = MorphKt.LOG_TAG;
                arrayList.add(TuplesKt.to(component1.getCubic(), pair2.component1().getCubic()));
            }
            if (measuredCubic == null && measuredCubic2 == null) {
                return arrayList;
            }
            throw new IllegalArgumentException("Expected both Polygon's Cubic to be fully matched".toString());
        }

        private static final String match$lambda$10(FloatFloatPair floatFloatPair) {
            return Format_jvmKt.toStringWithLessPrecision(PointKt.m8106getXDnnuFBc(floatFloatPair.m20unboximpl()) * 100.0f) + ' ' + Format_jvmKt.toStringWithLessPrecision(PointKt.m8107getYDnnuFBc(floatFloatPair.m20unboximpl()) * 100.0f);
        }

        private static final CharSequence match$lambda$14$lambda$13$lambda$12(Function1 function1, Cubic it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "C " + ((String) function1.invoke(FloatFloatPair.m9boximpl(FloatFloatPair.m12constructorimpl(it.getControl0X(), it.getControl0Y())))) + ", " + ((String) function1.invoke(FloatFloatPair.m9boximpl(FloatFloatPair.m12constructorimpl(it.getControl1X(), it.getControl1Y())))) + ", " + ((String) function1.invoke(FloatFloatPair.m9boximpl(FloatFloatPair.m12constructorimpl(it.getAnchor1X(), it.getAnchor1Y()))));
        }
    }

    public final void forEachCubic(float f, Function1<? super MutableCubic, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        MutableCubic mutableCubic = new MutableCubic();
        int size = getMorphMatch().size();
        for (int i = 0; i < size; i++) {
            mutableCubic.interpolate(getMorphMatch().get(i).getFirst(), getMorphMatch().get(i).getSecond(), f);
            callback.invoke(mutableCubic);
        }
    }
}
