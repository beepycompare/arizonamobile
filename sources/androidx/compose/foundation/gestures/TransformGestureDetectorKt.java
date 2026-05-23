package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.motion.widget.Key;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
/* compiled from: TransformGestureDetector.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042`\u0010\u0005\u001a\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u000f\u001a\n\u0010\u0010\u001a\u00020\f*\u00020\u0011\u001a\u0013\u0010\u0012\u001a\u00020\f*\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\n\u0010\u0015\u001a\u00020\f*\u00020\u0011\u001a\u000f\u0010\u0016\u001a\u00020\u0007*\u00020\u0011¢\u0006\u0002\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\f*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u001a\u0019\u0010\u001a\u001a\u00020\u0007*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0004¢\u0006\u0002\u0010\u001b\u001a/\u0010\u001a\u001a\u00020\u0007*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u001dH\u0000¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "", "onGesture", "Lkotlin/Function4;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "", "zoom", Key.ROTATION, "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRotation", "Landroidx/compose/ui/input/pointer/PointerEvent;", "angle", "angle-k-4lQ0M", "(J)F", "calculateZoom", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateCentroidSize", "useCurrent", "calculateCentroid", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "pointerInputChangeMatcher", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Landroidx/compose/ui/input/pointer/PointerEvent;ZLkotlin/jvm/functions/Function1;)J", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformGestureDetectorKt {
    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }

    public static final Object detectTransformGestures(PointerInputScope pointerInputScope, boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new TransformGestureDetectorKt$detectTransformGestures$2(z, function4, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static final float calculateRotation(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i3 = 0;
            }
            i2 += i3;
            i++;
        }
        if (i2 < 2) {
            return 0.0f;
        }
        long calculateCentroid = calculateCentroid(pointerEvent, true);
        long calculateCentroid2 = calculateCentroid(pointerEvent, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i4 = 0; i4 < size2; i4++) {
            PointerInputChange pointerInputChange2 = changes2.get(i4);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long m6685getPositionF1C5BW0 = pointerInputChange2.m6685getPositionF1C5BW0();
                long m5107minusMKHz9U = Offset.m5107minusMKHz9U(pointerInputChange2.m6686getPreviousPositionF1C5BW0(), calculateCentroid2);
                long m5107minusMKHz9U2 = Offset.m5107minusMKHz9U(m6685getPositionF1C5BW0, calculateCentroid);
                float m646anglek4lQ0M = m646anglek4lQ0M(m5107minusMKHz9U2) - m646anglek4lQ0M(m5107minusMKHz9U);
                float m5101getDistanceimpl = Offset.m5101getDistanceimpl(Offset.m5108plusMKHz9U(m5107minusMKHz9U2, m5107minusMKHz9U)) / 2.0f;
                if (m646anglek4lQ0M > 180.0f) {
                    m646anglek4lQ0M -= 360.0f;
                } else if (m646anglek4lQ0M < -180.0f) {
                    m646anglek4lQ0M += 360.0f;
                }
                f2 += m646anglek4lQ0M * m5101getDistanceimpl;
                f += m5101getDistanceimpl;
            }
        }
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    public static final float calculateZoom(PointerEvent pointerEvent) {
        float calculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float calculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (calculateCentroidSize == 0.0f || calculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return calculateCentroidSize / calculateCentroidSize2;
    }

    public static final long calculatePan(PointerEvent pointerEvent) {
        long calculateCentroid = calculateCentroid(pointerEvent, true);
        if (Offset.m5100equalsimpl0(calculateCentroid, Offset.Companion.m5118getUnspecifiedF1C5BW0())) {
            return Offset.Companion.m5119getZeroF1C5BW0();
        }
        return Offset.m5107minusMKHz9U(calculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final float calculateCentroidSize(PointerEvent pointerEvent, boolean z) {
        long calculateCentroid = calculateCentroid(pointerEvent, z);
        float f = 0.0f;
        if (Offset.m5100equalsimpl0(calculateCentroid, Offset.Companion.m5118getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                f += Offset.m5101getDistanceimpl(Offset.m5107minusMKHz9U(z ? pointerInputChange.m6685getPositionF1C5BW0() : pointerInputChange.m6686getPreviousPositionF1C5BW0(), calculateCentroid));
                i++;
            }
        }
        return f / i;
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z) {
        return calculateCentroid(pointerEvent, z, new Function1() { // from class: androidx.compose.foundation.gestures.TransformGestureDetectorKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TransformGestureDetectorKt.calculateCentroid$lambda$0((PointerInputChange) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean calculateCentroid$lambda$0(PointerInputChange pointerInputChange) {
        return pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed();
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z, function1);
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z, Function1<? super PointerInputChange, Boolean> function1) {
        long m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (function1.invoke(pointerInputChange).booleanValue()) {
                m5119getZeroF1C5BW0 = Offset.m5108plusMKHz9U(m5119getZeroF1C5BW0, z ? pointerInputChange.m6685getPositionF1C5BW0() : pointerInputChange.m6686getPreviousPositionF1C5BW0());
                i++;
            }
        }
        if (i == 0) {
            return Offset.Companion.m5118getUnspecifiedF1C5BW0();
        }
        return Offset.m5098divtuRUvjQ(m5119getZeroF1C5BW0, i);
    }

    /* renamed from: angle-k-4lQ0M  reason: not valid java name */
    private static final float m646anglek4lQ0M(long j) {
        int i = (int) (j >> 32);
        if (Float.intBitsToFloat(i) == 0.0f && Float.intBitsToFloat((int) (j & 4294967295L)) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2(Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j & 4294967295L))))) * 180.0f) / 3.1415927f;
    }
}
