package androidx.compose.foundation.gestures;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0017\u0010\f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u001f\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\u0015\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\tH\u0016J\u0015\u0010 \u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultDraggableAnchors;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/DraggableAnchors;", UserMetadata.KEYDATA_FILENAME, "", "anchors", "", "(Ljava/util/List;[F)V", "size", "", "getSize", "()I", "anchorAt", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "closestAnchor", "position", "", "(F)Ljava/lang/Object;", "searchUpwards", "", "(FZ)Ljava/lang/Object;", "equals", "other", "", "hasPositionFor", "anchor", "(Ljava/lang/Object;)Z", "hashCode", "maxPosition", "minPosition", "positionAt", "positionOf", "(Ljava/lang/Object;)F", "toString", "", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultDraggableAnchors<T> implements DraggableAnchors<T> {
    private final float[] anchors;
    private final List<T> keys;
    private final int size;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultDraggableAnchors(List<? extends T> list, float[] fArr) {
        this.keys = list;
        this.anchors = fArr;
        list.size();
        int length = fArr.length;
        this.size = fArr.length;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float positionOf(T t) {
        Function1 function1;
        int indexOf = this.keys.indexOf(t);
        float[] fArr = this.anchors;
        function1 = AnchoredDraggableKt.GetOrNan;
        return (indexOf < 0 || indexOf > ArraysKt.getLastIndex(fArr)) ? ((Number) function1.invoke(Integer.valueOf(indexOf))).floatValue() : fArr[indexOf];
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public boolean hasPositionFor(T t) {
        return this.keys.indexOf(t) != -1;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public T closestAnchor(float f) {
        float[] fArr = this.anchors;
        int length = fArr.length;
        int i = -1;
        float f2 = Float.POSITIVE_INFINITY;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            float abs = Math.abs(f - fArr[i2]);
            if (abs <= f2) {
                i = i3;
                f2 = abs;
            }
            i2++;
            i3 = i4;
        }
        return this.keys.get(i);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public T closestAnchor(float f, boolean z) {
        float[] fArr = this.anchors;
        int length = fArr.length;
        int i = -1;
        int i2 = 0;
        float f2 = Float.POSITIVE_INFINITY;
        int i3 = 0;
        while (i2 < length) {
            float f3 = fArr[i2];
            int i4 = i3 + 1;
            float f4 = z ? f3 - f : f - f3;
            if (f4 < 0.0f) {
                f4 = Float.POSITIVE_INFINITY;
            }
            if (f4 <= f2) {
                i = i3;
                f2 = f4;
            }
            i2++;
            i3 = i4;
        }
        return this.keys.get(i);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float minPosition() {
        Float minOrNull = ArraysKt.minOrNull(this.anchors);
        if (minOrNull != null) {
            return minOrNull.floatValue();
        }
        return Float.NaN;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float maxPosition() {
        Float maxOrNull = ArraysKt.maxOrNull(this.anchors);
        if (maxOrNull != null) {
            return maxOrNull.floatValue();
        }
        return Float.NaN;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public T anchorAt(int i) {
        return (T) CollectionsKt.getOrNull(this.keys, i);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float positionAt(int i) {
        Function1 function1;
        float[] fArr = this.anchors;
        function1 = AnchoredDraggableKt.GetOrNan;
        return (i < 0 || i > ArraysKt.getLastIndex(fArr)) ? ((Number) function1.invoke(Integer.valueOf(i))).floatValue() : fArr[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultDraggableAnchors) {
            DefaultDraggableAnchors defaultDraggableAnchors = (DefaultDraggableAnchors) obj;
            return Intrinsics.areEqual(this.keys, defaultDraggableAnchors.keys) && Arrays.equals(this.anchors, defaultDraggableAnchors.anchors) && getSize() == defaultDraggableAnchors.getSize();
        }
        return false;
    }

    public int hashCode() {
        return (((this.keys.hashCode() * 31) + Arrays.hashCode(this.anchors)) * 31) + getSize();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DraggableAnchors(anchors={");
        int size = getSize();
        for (int i = 0; i < size; i++) {
            sb.append(new StringBuilder().append(anchorAt(i)).append('=').append(positionAt(i)).toString());
            if (i < getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("})");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
