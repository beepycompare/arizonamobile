package androidx.compose.foundation.gestures;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: IndirectPointerInputDragCycleDetector.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;", "", "<init>", "()V", "eventRotatingIndex", "", "eventRotatingArray", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "smoothEventPosition", "Landroidx/compose/ui/geometry/Offset;", "change", "smoothEventPosition-tuRUvjQ", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;)J", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IndirectPointerInputEventSmoother {
    private static final int SmoothingFactor = 3;
    private MutableObjectList<IndirectPointerInputChange> eventRotatingArray = new MutableObjectList<>(0, 1, null);
    private int eventRotatingIndex;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: smoothEventPosition-tuRUvjQ  reason: not valid java name */
    public final long m552smoothEventPositiontuRUvjQ(IndirectPointerInputChange indirectPointerInputChange) {
        boolean changedToUpIgnoreConsumed;
        float intBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.m6190getPositionF1C5BW0() >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (indirectPointerInputChange.m6190getPositionF1C5BW0() & 4294967295L));
        if (IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(indirectPointerInputChange)) {
            this.eventRotatingIndex = 0;
            this.eventRotatingArray.clear();
        }
        changedToUpIgnoreConsumed = IndirectPointerInputDragCycleDetectorKt.changedToUpIgnoreConsumed(indirectPointerInputChange);
        if (!changedToUpIgnoreConsumed && !IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(indirectPointerInputChange)) {
            int size = this.eventRotatingArray.getSize();
            MutableObjectList<IndirectPointerInputChange> mutableObjectList = this.eventRotatingArray;
            if (size == 3) {
                int i = this.eventRotatingIndex;
                this.eventRotatingIndex = i + 1;
                mutableObjectList.set(i, indirectPointerInputChange);
            } else {
                mutableObjectList.add(indirectPointerInputChange);
            }
            if (this.eventRotatingIndex == 3) {
                this.eventRotatingIndex = 0;
            }
            intBitsToFloat = smoothEventPosition_tuRUvjQ$averageBy(this.eventRotatingArray, new Function1() { // from class: androidx.compose.foundation.gestures.IndirectPointerInputEventSmoother$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    float intBitsToFloat3;
                    intBitsToFloat3 = Float.intBitsToFloat((int) (((IndirectPointerInputChange) obj).m6190getPositionF1C5BW0() >> 32));
                    return Float.valueOf(intBitsToFloat3);
                }
            });
            intBitsToFloat2 = smoothEventPosition_tuRUvjQ$averageBy(this.eventRotatingArray, new Function1() { // from class: androidx.compose.foundation.gestures.IndirectPointerInputEventSmoother$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    float intBitsToFloat3;
                    intBitsToFloat3 = Float.intBitsToFloat((int) (((IndirectPointerInputChange) obj).m6190getPositionF1C5BW0() & 4294967295L));
                    return Float.valueOf(intBitsToFloat3);
                }
            });
        }
        return Offset.m5095constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* compiled from: IndirectPointerInputDragCycleDetector.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother$Companion;", "", "<init>", "()V", "SmoothingFactor", "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final <T> float smoothEventPosition_tuRUvjQ$averageBy(ObjectList<T> objectList, Function1<? super T, Float> function1) {
        Object[] objArr = objectList.content;
        int i = objectList._size;
        float f = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            f += function1.invoke(objArr[i2]).floatValue();
        }
        return f / objectList.getSize();
    }
}
