package androidx.graphics.shapes;

import androidx.collection.FloatList;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
/* compiled from: FloatMapping.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0000¨\u0006\u000e"}, d2 = {"linearMap", "", "xValues", "Landroidx/collection/FloatList;", "yValues", "x", "progressInRange", "", "progress", "progressFrom", "progressTo", "validateProgress", "", TtmlNode.TAG_P, "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatMappingKt {
    public static final boolean progressInRange(float f, float f2, float f3) {
        return f3 >= f2 ? f2 <= f && f <= f3 : f >= f2 || f <= f3;
    }

    public static final void validateProgress(FloatList p) {
        int i;
        Intrinsics.checkNotNullParameter(p, "p");
        Boolean bool = true;
        float[] fArr = p.content;
        int i2 = p._size;
        for (int i3 = 0; i3 < i2; i3++) {
            float f = fArr[i3];
            bool = Boolean.valueOf(bool.booleanValue() && 0.0f <= f && f <= 1.0f);
        }
        if (!bool.booleanValue()) {
            throw new IllegalArgumentException(("FloatMapping - Progress outside of range: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
        }
        IntRange until = RangesKt.until(1, p.getSize());
        if ((until instanceof Collection) && ((Collection) until).isEmpty()) {
            i = 0;
        } else {
            Iterator<Integer> it = until.iterator();
            i = 0;
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                if ((p.get(nextInt) < p.get(nextInt - 1)) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (!(i <= 1)) {
            throw new IllegalArgumentException(("FloatMapping - Progress wraps more than once: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
        }
    }

    public static final float linearMap(FloatList xValues, FloatList yValues, float f) {
        Intrinsics.checkNotNullParameter(xValues, "xValues");
        Intrinsics.checkNotNullParameter(yValues, "yValues");
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException(("Invalid progress: " + f).toString());
        }
        Iterator<Integer> it = RangesKt.until(0, xValues._size).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            int i = nextInt + 1;
            if (progressInRange(f, xValues.get(nextInt), xValues.get(i % xValues.getSize()))) {
                int size = i % xValues.getSize();
                float positiveModulo = Utils.positiveModulo(xValues.get(size) - xValues.get(nextInt), 1.0f);
                return Utils.positiveModulo(yValues.get(nextInt) + (Utils.positiveModulo(yValues.get(size) - yValues.get(nextInt), 1.0f) * (positiveModulo < 0.001f ? 0.5f : Utils.positiveModulo(f - xValues.get(nextInt), 1.0f) / positiveModulo)), 1.0f);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
