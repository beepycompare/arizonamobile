package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.constraintlayout.motion.widget.Key;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransformGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {60, 62}, m = "invokeSuspend", n = {"$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
/* loaded from: classes.dex */
public final class TransformGestureDetectorKt$detectTransformGestures$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
    final /* synthetic */ boolean $panZoomLock;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    int I$1;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransformGestureDetectorKt$detectTransformGestures$2(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2> continuation) {
        super(2, continuation);
        this.$panZoomLock = z;
        this.$onGesture = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformGestureDetectorKt$detectTransformGestures$2 transformGestureDetectorKt$detectTransformGestures$2 = new TransformGestureDetectorKt$detectTransformGestures$2(this.$panZoomLock, this.$onGesture, continuation);
        transformGestureDetectorKt$detectTransformGestures$2.L$0 = obj;
        return transformGestureDetectorKt$detectTransformGestures$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((TransformGestureDetectorKt$detectTransformGestures$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x009e, code lost:
        if (r3 == r1) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x013b, code lost:
        if (androidx.compose.ui.geometry.Offset.m3834equalsimpl0(r7, androidx.compose.ui.geometry.Offset.Companion.m3853getZeroF1C5BW0()) == false) goto L57;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x009e -> B:17:0x00a1). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        float f;
        float f2;
        int i;
        long j;
        AwaitPointerEventScope awaitPointerEventScope;
        float f3;
        int i2;
        float f4;
        Object awaitPointerEvent$default;
        int i3;
        Object obj2;
        int i4;
        float f5;
        int i5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        float f6 = 1.0f;
        int i7 = 2;
        float f7 = 0.0f;
        boolean z = false;
        int i8 = 1;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            long m3853getZeroF1C5BW0 = Offset.Companion.m3853getZeroF1C5BW0();
            float touchSlop = awaitPointerEventScope2.getViewConfiguration().getTouchSlop();
            this.L$0 = awaitPointerEventScope2;
            this.F$0 = 0.0f;
            this.F$1 = 1.0f;
            this.J$0 = m3853getZeroF1C5BW0;
            this.I$0 = 0;
            this.F$2 = touchSlop;
            this.I$1 = 0;
            this.label = 1;
            if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null) != coroutine_suspended) {
                f = 1.0f;
                f2 = 0.0f;
                i = 0;
                j = m3853getZeroF1C5BW0;
                awaitPointerEventScope = awaitPointerEventScope2;
                f3 = touchSlop;
                i2 = 0;
            }
            return coroutine_suspended;
        } else if (i6 != 1) {
            if (i6 == 2) {
                i2 = this.I$1;
                f3 = this.F$2;
                i = this.I$0;
                j = this.J$0;
                f = this.F$1;
                f2 = this.F$0;
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                f4 = 1.0f;
                awaitPointerEvent$default = obj;
                PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent$default;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                float f8 = f7;
                int i9 = z;
                while (true) {
                    if (i9 >= size) {
                        i3 = z;
                        break;
                    } else if (changes.get(i9).isConsumed()) {
                        i3 = i8;
                        break;
                    } else {
                        i9++;
                    }
                }
                if (i3) {
                    obj2 = coroutine_suspended;
                    i4 = i8;
                    f5 = f3;
                } else {
                    float calculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent);
                    float calculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent);
                    f5 = f3;
                    long calculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent);
                    if (i == 0) {
                        f *= calculateZoom;
                        f2 += calculateRotation;
                        j = Offset.m3842plusMKHz9U(j, calculatePan);
                        float calculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent, z);
                        obj2 = coroutine_suspended;
                        i4 = 1;
                        float abs = Math.abs(1 - f) * calculateCentroidSize;
                        float abs2 = Math.abs(((3.1415927f * f2) * calculateCentroidSize) / 180.0f);
                        float m3835getDistanceimpl = Offset.m3835getDistanceimpl(j);
                        if (abs > f5 || abs2 > f5 || m3835getDistanceimpl > f5) {
                            i2 = (!this.$panZoomLock || abs2 >= f5) ? 0 : 1;
                            i = 1;
                        }
                    } else {
                        obj2 = coroutine_suspended;
                        i4 = 1;
                    }
                    if (i != 0) {
                        long calculateCentroid = TransformGestureDetectorKt.calculateCentroid(pointerEvent, false);
                        if (i2 != 0) {
                            calculateRotation = f8;
                        }
                        if (calculateRotation == f8 && calculateZoom == f4) {
                            i5 = i2;
                        } else {
                            i5 = i2;
                        }
                        this.$onGesture.invoke(Offset.m3826boximpl(calculateCentroid), Offset.m3826boximpl(calculatePan), Boxing.boxFloat(calculateZoom), Boxing.boxFloat(calculateRotation));
                        List<PointerInputChange> changes2 = pointerEvent.getChanges();
                        int size2 = changes2.size();
                        for (int i10 = 0; i10 < size2; i10++) {
                            PointerInputChange pointerInputChange = changes2.get(i10);
                            if (PointerEventKt.positionChanged(pointerInputChange)) {
                                pointerInputChange.consume();
                            }
                        }
                    } else {
                        i5 = i2;
                    }
                    i2 = i5;
                }
                if (!i3) {
                    List<PointerInputChange> changes3 = pointerEvent.getChanges();
                    int size3 = changes3.size();
                    for (int i11 = 0; i11 < size3; i11++) {
                        if (changes3.get(i11).getPressed()) {
                            f3 = f5;
                            i8 = i4;
                            f6 = f4;
                            f7 = f8;
                            coroutine_suspended = obj2;
                            i7 = 2;
                            z = false;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i2 = this.I$1;
            f3 = this.F$2;
            i = this.I$0;
            j = this.J$0;
            f = this.F$1;
            f2 = this.F$0;
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = awaitPointerEventScope;
        this.F$0 = f2;
        this.F$1 = f;
        this.J$0 = j;
        this.I$0 = i;
        this.F$2 = f3;
        this.I$1 = i2;
        this.label = i7;
        f4 = f6;
        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, i8, null);
    }
}
