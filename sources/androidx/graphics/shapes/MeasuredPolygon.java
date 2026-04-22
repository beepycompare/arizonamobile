package androidx.graphics.shapes;

import androidx.collection.FloatList;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: PolygonMeasure.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001a2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB5\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u0015\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon;", "Lkotlin/collections/AbstractList;", "Landroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic;", "measurer", "Landroidx/graphics/shapes/Measurer;", "features", "", "Landroidx/graphics/shapes/ProgressableFeature;", "cubics", "Landroidx/graphics/shapes/Cubic;", "outlineProgress", "Landroidx/collection/FloatList;", "<init>", "(Landroidx/graphics/shapes/Measurer;Ljava/util/List;Ljava/util/List;Landroidx/collection/FloatList;)V", "getFeatures", "()Ljava/util/List;", "cutAndShift", "cuttingPoint", "", "size", "", "getSize", "()I", "get", FirebaseAnalytics.Param.INDEX, "MeasuredCubic", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MeasuredPolygon extends AbstractList<MeasuredCubic> {
    public static final Companion Companion = new Companion(null);
    private final List<MeasuredCubic> cubics;
    private final List<ProgressableFeature> features;
    private final Measurer measurer;

    public /* synthetic */ MeasuredPolygon(Measurer measurer, List list, List list2, FloatList floatList, DefaultConstructorMarker defaultConstructorMarker) {
        this(measurer, list, list2, floatList);
    }

    public /* bridge */ boolean contains(MeasuredCubic measuredCubic) {
        return super.contains((Object) measuredCubic);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return contains((MeasuredCubic) obj);
        }
        return false;
    }

    public /* bridge */ int indexOf(MeasuredCubic measuredCubic) {
        return super.indexOf((Object) measuredCubic);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return indexOf((MeasuredCubic) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(MeasuredCubic measuredCubic) {
        return super.lastIndexOf((Object) measuredCubic);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return lastIndexOf((MeasuredCubic) obj);
        }
        return -1;
    }

    public final List<ProgressableFeature> getFeatures() {
        return this.features;
    }

    private MeasuredPolygon(Measurer measurer, List<ProgressableFeature> list, List<? extends Cubic> list2, FloatList floatList) {
        if (floatList._size != list2.size() + 1) {
            throw new IllegalArgumentException("Outline progress size is expected to be the cubics size + 1".toString());
        }
        if (floatList.first() != 0.0f) {
            throw new IllegalArgumentException("First outline progress value is expected to be zero".toString());
        }
        if (floatList.last() != 1.0f) {
            throw new IllegalArgumentException("Last outline progress value is expected to be one".toString());
        }
        this.measurer = measurer;
        this.features = list;
        ArrayList arrayList = new ArrayList();
        int size = list2.size();
        int i = 0;
        float f = 0.0f;
        while (i < size) {
            int i2 = i + 1;
            if (floatList.get(i2) - floatList.get(i) > 1.0E-4f) {
                arrayList.add(new MeasuredCubic(this, list2.get(i), f, floatList.get(i2)));
                f = floatList.get(i2);
            }
            i = i2;
        }
        MeasuredCubic.updateProgressRange$graphics_shapes$default((MeasuredCubic) arrayList.get(CollectionsKt.getLastIndex(arrayList)), 0.0f, 1.0f, 1, null);
        this.cubics = arrayList;
    }

    /* compiled from: PolygonMeasure.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0013J\"\u0010\u0014\u001a\u0016\u0012\b\u0012\u00060\u0000R\u00020\u0016\u0012\b\u0012\u00060\u0000R\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic;", "", "cubic", "Landroidx/graphics/shapes/Cubic;", "startOutlineProgress", "", "endOutlineProgress", "<init>", "(Landroidx/graphics/shapes/MeasuredPolygon;Landroidx/graphics/shapes/Cubic;FF)V", "getCubic", "()Landroidx/graphics/shapes/Cubic;", "measuredSize", "getMeasuredSize", "()F", "value", "getStartOutlineProgress", "getEndOutlineProgress", "updateProgressRange", "", "updateProgressRange$graphics_shapes", "cutAtProgress", "Lkotlin/Pair;", "Landroidx/graphics/shapes/MeasuredPolygon;", "cutOutlineProgress", "toString", "", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class MeasuredCubic {
        private final Cubic cubic;
        private float endOutlineProgress;
        private final float measuredSize;
        private float startOutlineProgress;
        final /* synthetic */ MeasuredPolygon this$0;

        public MeasuredCubic(MeasuredPolygon measuredPolygon, Cubic cubic, float f, float f2) {
            Intrinsics.checkNotNullParameter(cubic, "cubic");
            this.this$0 = measuredPolygon;
            this.cubic = cubic;
            if (f2 >= f) {
                this.measuredSize = measuredPolygon.measurer.measureCubic(cubic);
                this.startOutlineProgress = f;
                this.endOutlineProgress = f2;
                return;
            }
            throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress".toString());
        }

        public final Cubic getCubic() {
            return this.cubic;
        }

        public final float getMeasuredSize() {
            return this.measuredSize;
        }

        public final float getStartOutlineProgress() {
            return this.startOutlineProgress;
        }

        public final float getEndOutlineProgress() {
            return this.endOutlineProgress;
        }

        public static /* synthetic */ void updateProgressRange$graphics_shapes$default(MeasuredCubic measuredCubic, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = measuredCubic.startOutlineProgress;
            }
            if ((i & 2) != 0) {
                f2 = measuredCubic.endOutlineProgress;
            }
            measuredCubic.updateProgressRange$graphics_shapes(f, f2);
        }

        public final void updateProgressRange$graphics_shapes(float f, float f2) {
            if (f2 < f) {
                throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress".toString());
            }
            this.startOutlineProgress = f;
            this.endOutlineProgress = f2;
        }

        public final Pair<MeasuredCubic, MeasuredCubic> cutAtProgress(float f) {
            String unused;
            float coerceIn = RangesKt.coerceIn(f, this.startOutlineProgress, this.endOutlineProgress);
            float f2 = this.endOutlineProgress;
            float f3 = this.startOutlineProgress;
            float findCubicCutPoint = this.this$0.measurer.findCubicCutPoint(this.cubic, ((coerceIn - f3) / (f2 - f3)) * this.measuredSize);
            if (0.0f <= findCubicCutPoint && findCubicCutPoint <= 1.0f) {
                unused = PolygonMeasureKt.LOG_TAG;
                Pair<Cubic, Cubic> split = this.cubic.split(findCubicCutPoint);
                return TuplesKt.to(new MeasuredCubic(this.this$0, split.component1(), this.startOutlineProgress, coerceIn), new MeasuredCubic(this.this$0, split.component2(), coerceIn, this.endOutlineProgress));
            }
            throw new IllegalArgumentException("Cubic cut point is expected to be between 0 and 1".toString());
        }

        public String toString() {
            return "MeasuredCubic(outlineProgress=[" + this.startOutlineProgress + " .. " + this.endOutlineProgress + "], size=" + this.measuredSize + ", cubic=" + this.cubic + ')';
        }
    }

    public final MeasuredPolygon cutAndShift(float f) {
        float positiveModulo;
        String unused;
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException("Cutting point is expected to be between 0 and 1".toString());
        }
        if (f < 1.0E-4f) {
            return this;
        }
        Iterator<MeasuredCubic> it = this.cubics.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            MeasuredCubic next = it.next();
            float startOutlineProgress = next.getStartOutlineProgress();
            if (f <= next.getEndOutlineProgress() && startOutlineProgress <= f) {
                break;
            }
            i++;
        }
        Pair<MeasuredCubic, MeasuredCubic> cutAtProgress = this.cubics.get(i).cutAtProgress(f);
        MeasuredCubic component1 = cutAtProgress.component1();
        unused = PolygonMeasureKt.LOG_TAG;
        List mutableListOf = CollectionsKt.mutableListOf(cutAtProgress.component2().getCubic());
        int size = this.cubics.size();
        for (int i2 = 1; i2 < size; i2++) {
            List<MeasuredCubic> list = this.cubics;
            mutableListOf.add(list.get((i2 + i) % list.size()).getCubic());
        }
        mutableListOf.add(component1.getCubic());
        MutableFloatList mutableFloatList = new MutableFloatList(this.cubics.size() + 2);
        int size2 = this.cubics.size() + 2;
        int i3 = 0;
        while (i3 < size2) {
            if (i3 == 0) {
                positiveModulo = 0.0f;
            } else {
                positiveModulo = i3 == this.cubics.size() + 1 ? 1.0f : Utils.positiveModulo(this.cubics.get(((i + i3) - 1) % this.cubics.size()).getEndOutlineProgress() - f, 1.0f);
            }
            mutableFloatList.add(positiveModulo);
            i3++;
        }
        List createListBuilder = CollectionsKt.createListBuilder();
        int size3 = this.features.size();
        for (int i4 = 0; i4 < size3; i4++) {
            createListBuilder.add(new ProgressableFeature(Utils.positiveModulo(this.features.get(i4).getProgress() - f, 1.0f), this.features.get(i4).getFeature()));
        }
        return new MeasuredPolygon(this.measurer, CollectionsKt.build(createListBuilder), mutableListOf, mutableFloatList);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.cubics.size();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public MeasuredCubic get(int i) {
        return this.cubics.get(i);
    }

    /* compiled from: PolygonMeasure.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon$Companion;", "", "<init>", "()V", "measurePolygon", "Landroidx/graphics/shapes/MeasuredPolygon;", "measurer", "Landroidx/graphics/shapes/Measurer;", "polygon", "Landroidx/graphics/shapes/RoundedPolygon;", "measurePolygon$graphics_shapes", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MeasuredPolygon measurePolygon$graphics_shapes(Measurer measurer, RoundedPolygon polygon) {
            ArrayList arrayList;
            String unused;
            Intrinsics.checkNotNullParameter(measurer, "measurer");
            Intrinsics.checkNotNullParameter(polygon, "polygon");
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int size = polygon.getFeatures().size();
            for (int i = 0; i < size; i++) {
                Feature feature = polygon.getFeatures().get(i);
                int size2 = feature.getCubics().size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if ((feature instanceof Feature.Corner) && i2 == feature.getCubics().size() / 2) {
                        arrayList3.add(TuplesKt.to(feature, Integer.valueOf(arrayList2.size())));
                    }
                    arrayList2.add(feature.getCubics().get(i2));
                }
            }
            ArrayList<Cubic> arrayList4 = arrayList2;
            Float valueOf = Float.valueOf(0.0f);
            int collectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(arrayList4, 9);
            if (collectionSizeOrDefault == 0) {
                arrayList = CollectionsKt.listOf(valueOf);
            } else {
                ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault + 1);
                arrayList5.add(valueOf);
                for (Cubic cubic : arrayList4) {
                    float floatValue = valueOf.floatValue();
                    float measureCubic = measurer.measureCubic(cubic);
                    if (measureCubic < 0.0f) {
                        throw new IllegalArgumentException("Measured cubic is expected to be greater or equal to zero".toString());
                    }
                    Unit unit = Unit.INSTANCE;
                    valueOf = Float.valueOf(floatValue + measureCubic);
                    arrayList5.add(valueOf);
                }
                arrayList = arrayList5;
            }
            float floatValue2 = ((Number) CollectionsKt.last((List<? extends Object>) arrayList)).floatValue();
            MutableFloatList mutableFloatList = new MutableFloatList(arrayList.size());
            int size3 = arrayList.size();
            for (int i3 = 0; i3 < size3; i3++) {
                mutableFloatList.add(((Number) arrayList.get(i3)).floatValue() / floatValue2);
            }
            unused = PolygonMeasureKt.LOG_TAG;
            List createListBuilder = CollectionsKt.createListBuilder();
            int size4 = arrayList3.size();
            for (int i4 = 0; i4 < size4; i4++) {
                int intValue = ((Number) ((Pair) arrayList3.get(i4)).getSecond()).intValue();
                createListBuilder.add(new ProgressableFeature(Utils.positiveModulo((mutableFloatList.get(intValue) + mutableFloatList.get(intValue + 1)) / 2.0f, 1.0f), (Feature) ((Pair) arrayList3.get(i4)).getFirst()));
            }
            return new MeasuredPolygon(measurer, CollectionsKt.build(createListBuilder), arrayList2, mutableFloatList, null);
        }
    }
}
