package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {284, 1172, 1213, 307, 1252, 1294, 1306}, m = "processDragGesture", n = {"$this$processDragGesture", "initialDown", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "awaitTouchSlop", "$this$processDragGesture", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$processDragGesture", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$processDragGesture", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "down", "drag", "overSlop", "$this$processDragGesture", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$processDragGesture", "orientationLock", "onDragStart", "onDrag", "onDragCancel", "onDragEnd", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "onDrag", "onDragCancel", "onDragEnd", "$this$drag_u2dVnAYq1g$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "F$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "F$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "F$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "F$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$processDragGesture$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DragGestureDetectorKt$processDragGesture$1(Continuation<? super DragGestureDetectorKt$processDragGesture$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.processDragGesture(null, null, null, null, null, null, null, null, this);
    }
}
