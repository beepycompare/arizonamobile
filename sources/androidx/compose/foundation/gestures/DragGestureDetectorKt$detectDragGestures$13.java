package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$13", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7}, l = {248, 254, 1116, 1158, 279, 1197, 1240, 1252}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "initialDown", "awaitTouchSlop", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "drag", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$drag_u2dVnAYq1g$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$2", "L$3"}, v = 1)
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$detectDragGestures$13 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
    final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
    final /* synthetic */ Orientation $orientationLock;
    final /* synthetic */ Ref.LongRef $overSlop;
    final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
    float F$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DragGestureDetectorKt$detectDragGestures$13(Function0<Boolean> function0, Ref.LongRef longRef, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super DragGestureDetectorKt$detectDragGestures$13> continuation) {
        super(2, continuation);
        this.$shouldAwaitTouchSlop = function0;
        this.$overSlop = longRef;
        this.$orientationLock = orientation;
        this.$onDragStart = function3;
        this.$onDrag = function2;
        this.$onDragCancel = function02;
        this.$onDragEnd = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$13 dragGestureDetectorKt$detectDragGestures$13 = new DragGestureDetectorKt$detectDragGestures$13(this.$shouldAwaitTouchSlop, this.$overSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$13.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$13;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$13) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0166, code lost:
        if (r5 == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x055b, code lost:
        if (r7 == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x05e8, code lost:
        if (r7 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0198, code lost:
        if (r2 == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x01a8, code lost:
        if (r6 != false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0324, code lost:
        if (r3 == r1) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:185:0x0595, B:196:0x05c2], limit reached: 219 */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0429 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x022b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02e7  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v5, types: [androidx.compose.ui.input.pointer.PointerEventPass, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x03b4 -> B:158:0x04e3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x0437 -> B:158:0x04e3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:154:0x04d4 -> B:155:0x04d9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:160:0x04e9 -> B:113:0x03d2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x04f3 -> B:81:0x02e5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x055b -> B:173:0x055e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x01c4 -> B:74:0x02d0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0231 -> B:73:0x02ce). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0239 -> B:73:0x02ce). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0265 -> B:73:0x02ce). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0295 -> B:75:0x02d1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x029e -> B:30:0x01df). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x02c4 -> B:71:0x02c8). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x035c -> B:87:0x030a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long j;
        long j2;
        AwaitPointerEventScope awaitPointerEventScope;
        Object awaitFirstDown;
        PointerInputChange pointerInputChange;
        boolean booleanValue;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object awaitFirstDown$default;
        PointerInputChange pointerInputChange2;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope3;
        PointerInputChange pointerInputChange3;
        TouchSlopDetector touchSlopDetector;
        float f;
        Ref.LongRef longRef2;
        AwaitPointerEventScope awaitPointerEventScope4;
        TouchSlopDetector touchSlopDetector2;
        float f2;
        PointerInputChange pointerInputChange4;
        PointerInputChange pointerInputChange5;
        PointerInputChange pointerInputChange6;
        AwaitPointerEventScope awaitPointerEventScope5;
        Object obj2;
        TouchSlopDetector touchSlopDetector3;
        PointerInputChange pointerInputChange7;
        Object obj3;
        float f3;
        Ref.LongRef longRef3;
        AwaitPointerEventScope awaitPointerEventScope6;
        AwaitPointerEventScope awaitPointerEventScope7;
        Ref.LongRef longRef4;
        Ref.LongRef longRef5;
        Ref.LongRef longRef6;
        TouchSlopDetector touchSlopDetector4;
        float f4;
        ?? r11;
        PointerEvent pointerEvent;
        int size;
        int i;
        PointerEvent pointerEvent2;
        TouchSlopDetector touchSlopDetector5;
        PointerInputChange pointerInputChange8;
        PointerInputChange pointerInputChange9;
        PointerInputChange pointerInputChange10;
        TouchSlopDetector touchSlopDetector6;
        AwaitPointerEventScope awaitPointerEventScope8;
        TouchSlopDetector touchSlopDetector7;
        PointerInputChange pointerInputChange11;
        long m6083getIdJ3iCeTQ;
        Function2<PointerInputChange, Offset, Unit> function2;
        Orientation orientation;
        PointerInputChange pointerInputChange12;
        AwaitPointerEventScope awaitPointerEventScope9;
        AwaitPointerEventScope awaitPointerEventScope10;
        Ref.LongRef longRef7;
        Object awaitPointerEvent$default;
        PointerInputChange pointerInputChange13;
        boolean z;
        PointerInputChange pointerInputChange14;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 0;
        int i3 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        defaultConstructorMarker = null;
        defaultConstructorMarker = null;
        switch (this.label) {
            case 0:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                awaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, PointerEventPass.Initial, this);
                break;
            case 1:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitFirstDown = obj;
                pointerInputChange = (PointerInputChange) awaitFirstDown;
                booleanValue = this.$shouldAwaitTouchSlop.invoke().booleanValue();
                if (!booleanValue) {
                    pointerInputChange.consume();
                }
                this.L$0 = awaitPointerEventScope;
                this.L$1 = pointerInputChange;
                this.Z$0 = booleanValue;
                this.label = 2;
                awaitPointerEventScope2 = awaitPointerEventScope;
                awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null);
                break;
            case 2:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                boolean z2 = this.Z$0;
                pointerInputChange = (PointerInputChange) this.L$1;
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                booleanValue = z2;
                awaitFirstDown$default = obj;
                pointerInputChange2 = (PointerInputChange) awaitFirstDown$default;
                this.$overSlop.element = Offset.Companion.m4543getZeroF1C5BW0();
                break;
            case 3:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                float f5 = this.F$0;
                TouchSlopDetector touchSlopDetector8 = (TouchSlopDetector) this.L$5;
                ResultKt.throwOnFailure(obj);
                float f6 = f5;
                longRef = (Ref.LongRef) this.L$4;
                AwaitPointerEventScope awaitPointerEventScope11 = (AwaitPointerEventScope) this.L$2;
                pointerInputChange2 = (PointerInputChange) this.L$1;
                awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                Object obj4 = obj;
                Ref.LongRef longRef8 = (Ref.LongRef) this.L$3;
                TouchSlopDetector touchSlopDetector9 = touchSlopDetector8;
                PointerEvent pointerEvent3 = (PointerEvent) obj4;
                List<PointerInputChange> changes = pointerEvent3.getChanges();
                int size2 = changes.size();
                int i4 = i2;
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange3 = changes.get(i4);
                        if (!PointerId.m6067equalsimpl0(pointerInputChange3.m6083getIdJ3iCeTQ(), longRef.element)) {
                            i4++;
                        }
                    } else {
                        pointerInputChange3 = null;
                    }
                }
                pointerInputChange = pointerInputChange3;
                if (pointerInputChange != null && !pointerInputChange.isConsumed()) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                        long m604addPositionsakrDWew = touchSlopDetector9.m604addPositionsakrDWew(pointerInputChange.m6085getPositionF1C5BW0(), pointerInputChange.m6086getPreviousPositionF1C5BW0(), f6);
                        touchSlopDetector = touchSlopDetector9;
                        f = f6;
                        if ((m604addPositionsakrDWew & j2) != j) {
                            pointerInputChange.consume();
                            longRef8.element = m604addPositionsakrDWew;
                            if (pointerInputChange.isConsumed()) {
                                awaitPointerEventScope2 = awaitPointerEventScope3;
                                if (pointerInputChange != null && !pointerInputChange.isConsumed()) {
                                    i2 = 0;
                                    i3 = 1;
                                    long m6083getIdJ3iCeTQ2 = pointerInputChange2.m6083getIdJ3iCeTQ();
                                    int m6088getTypeT8wyACA = pointerInputChange2.m6088getTypeT8wyACA();
                                    Orientation orientation2 = this.$orientationLock;
                                    longRef8 = this.$overSlop;
                                    long m4543getZeroF1C5BW0 = Offset.Companion.m4543getZeroF1C5BW0();
                                    if (!DragGestureDetectorKt.m475isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), m6083getIdJ3iCeTQ2)) {
                                        f2 = DragGestureDetectorKt.m476pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), m6088getTypeT8wyACA);
                                        longRef = new Ref.LongRef();
                                        longRef.element = m6083getIdJ3iCeTQ2;
                                        touchSlopDetector8 = new TouchSlopDetector(orientation2, m4543getZeroF1C5BW0, null);
                                        awaitPointerEventScope11 = awaitPointerEventScope2;
                                        awaitPointerEventScope3 = awaitPointerEventScope11;
                                        this.L$0 = awaitPointerEventScope3;
                                        this.L$1 = pointerInputChange2;
                                        this.L$2 = awaitPointerEventScope11;
                                        this.L$3 = longRef8;
                                        this.L$4 = longRef;
                                        this.L$5 = touchSlopDetector8;
                                        this.L$6 = null;
                                        this.F$0 = f2;
                                        this.label = 3;
                                        obj4 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope11, null, this, i3, null);
                                        if (obj4 != coroutine_suspended) {
                                            f6 = f2;
                                            TouchSlopDetector touchSlopDetector92 = touchSlopDetector8;
                                            PointerEvent pointerEvent32 = (PointerEvent) obj4;
                                            List<PointerInputChange> changes2 = pointerEvent32.getChanges();
                                            int size22 = changes2.size();
                                            int i42 = i2;
                                            while (true) {
                                                if (i42 >= size22) {
                                                }
                                                i42++;
                                            }
                                            pointerInputChange = pointerInputChange3;
                                            if (pointerInputChange != null) {
                                                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                                                }
                                            }
                                        }
                                    }
                                    pointerInputChange = null;
                                    if (pointerInputChange != null) {
                                        i2 = 0;
                                        i3 = 1;
                                        long m6083getIdJ3iCeTQ22 = pointerInputChange2.m6083getIdJ3iCeTQ();
                                        int m6088getTypeT8wyACA2 = pointerInputChange2.m6088getTypeT8wyACA();
                                        Orientation orientation22 = this.$orientationLock;
                                        longRef8 = this.$overSlop;
                                        long m4543getZeroF1C5BW02 = Offset.Companion.m4543getZeroF1C5BW0();
                                        if (!DragGestureDetectorKt.m475isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), m6083getIdJ3iCeTQ22)) {
                                        }
                                        pointerInputChange = null;
                                        if (pointerInputChange != null) {
                                        }
                                    }
                                }
                                if (pointerInputChange == null) {
                                    List<PointerInputChange> changes3 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                    int size3 = changes3.size();
                                    int i5 = 0;
                                    defaultConstructorMarker2 = defaultConstructorMarker;
                                    while (i5 < size3) {
                                        if (changes3.get(i5).getPressed()) {
                                            PointerInputChange pointerInputChange15 = pointerInputChange;
                                            pointerInputChange6 = pointerInputChange2;
                                            pointerInputChange5 = pointerInputChange15;
                                            awaitPointerEventScope5 = awaitPointerEventScope2;
                                            this.L$0 = awaitPointerEventScope5;
                                            this.L$1 = pointerInputChange6;
                                            this.L$2 = pointerInputChange5;
                                            this.L$3 = defaultConstructorMarker2;
                                            this.L$4 = defaultConstructorMarker2;
                                            this.L$5 = defaultConstructorMarker2;
                                            this.L$6 = defaultConstructorMarker2;
                                            this.label = 5;
                                            obj2 = awaitPointerEventScope5.awaitPointerEvent(PointerEventPass.Final, this);
                                            defaultConstructorMarker2 = defaultConstructorMarker2;
                                            break;
                                        } else {
                                            i5++;
                                            defaultConstructorMarker2 = null;
                                        }
                                    }
                                }
                                if (pointerInputChange != null) {
                                    this.$onDragStart.invoke(pointerInputChange2, pointerInputChange, Offset.m4516boximpl(this.$overSlop.element));
                                    this.$onDrag.invoke(pointerInputChange, Offset.m4516boximpl(this.$overSlop.element));
                                    m6083getIdJ3iCeTQ = pointerInputChange.m6083getIdJ3iCeTQ();
                                    function2 = this.$onDrag;
                                    if (!DragGestureDetectorKt.m475isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), m6083getIdJ3iCeTQ)) {
                                        orientation = null;
                                        Ref.LongRef longRef9 = new Ref.LongRef();
                                        longRef9.element = m6083getIdJ3iCeTQ;
                                        longRef7 = longRef9;
                                        awaitPointerEventScope10 = awaitPointerEventScope2;
                                        awaitPointerEventScope9 = awaitPointerEventScope10;
                                        this.L$0 = awaitPointerEventScope9;
                                        this.L$1 = function2;
                                        this.L$2 = awaitPointerEventScope10;
                                        this.L$3 = longRef7;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.L$6 = null;
                                        this.label = 8;
                                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope10, null, this, 1, null);
                                        break;
                                    }
                                    pointerInputChange12 = null;
                                    if (pointerInputChange12 == null) {
                                        this.$onDragCancel.invoke();
                                    } else {
                                        this.$onDragEnd.invoke(pointerInputChange12);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                            TouchSlopDetector.m603resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
                        } else {
                            this.L$0 = awaitPointerEventScope3;
                            this.L$1 = pointerInputChange2;
                            this.L$2 = awaitPointerEventScope11;
                            this.L$3 = longRef8;
                            this.L$4 = longRef;
                            this.L$5 = touchSlopDetector;
                            this.L$6 = pointerInputChange;
                            this.F$0 = f;
                            this.label = 4;
                            if (awaitPointerEventScope11.awaitPointerEvent(PointerEventPass.Final, this) != coroutine_suspended) {
                                longRef2 = longRef8;
                                awaitPointerEventScope4 = awaitPointerEventScope11;
                                touchSlopDetector2 = touchSlopDetector;
                                f2 = f;
                                if (!pointerInputChange.isConsumed()) {
                                    touchSlopDetector8 = touchSlopDetector2;
                                    awaitPointerEventScope11 = awaitPointerEventScope4;
                                    i2 = 0;
                                    i3 = 1;
                                    longRef8 = longRef2;
                                    this.L$0 = awaitPointerEventScope3;
                                    this.L$1 = pointerInputChange2;
                                    this.L$2 = awaitPointerEventScope11;
                                    this.L$3 = longRef8;
                                    this.L$4 = longRef;
                                    this.L$5 = touchSlopDetector8;
                                    this.L$6 = null;
                                    this.F$0 = f2;
                                    this.label = 3;
                                    obj4 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope11, null, this, i3, null);
                                    if (obj4 != coroutine_suspended) {
                                    }
                                }
                            }
                        }
                    } else {
                        List<PointerInputChange> changes4 = pointerEvent32.getChanges();
                        int size4 = changes4.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 < size4) {
                                pointerInputChange4 = changes4.get(i6);
                                if (!pointerInputChange4.getPressed()) {
                                    i6++;
                                }
                            } else {
                                pointerInputChange4 = null;
                            }
                        }
                        PointerInputChange pointerInputChange16 = pointerInputChange4;
                        if (pointerInputChange16 != null) {
                            longRef.element = pointerInputChange16.m6083getIdJ3iCeTQ();
                            touchSlopDetector = touchSlopDetector92;
                            f = f6;
                        }
                    }
                    touchSlopDetector8 = touchSlopDetector;
                    f2 = f;
                    i2 = 0;
                    i3 = 1;
                    this.L$0 = awaitPointerEventScope3;
                    this.L$1 = pointerInputChange2;
                    this.L$2 = awaitPointerEventScope11;
                    this.L$3 = longRef8;
                    this.L$4 = longRef;
                    this.L$5 = touchSlopDetector8;
                    this.L$6 = null;
                    this.F$0 = f2;
                    this.label = 3;
                    obj4 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope11, null, this, i3, null);
                    if (obj4 != coroutine_suspended) {
                    }
                }
                awaitPointerEventScope2 = awaitPointerEventScope3;
                pointerInputChange = null;
                if (pointerInputChange != null) {
                }
                if (pointerInputChange == null) {
                }
                if (pointerInputChange != null) {
                }
                return Unit.INSTANCE;
            case 4:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                float f7 = this.F$0;
                pointerInputChange = (PointerInputChange) this.L$6;
                touchSlopDetector2 = (TouchSlopDetector) this.L$5;
                awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$2;
                ResultKt.throwOnFailure(obj);
                longRef = (Ref.LongRef) this.L$4;
                longRef2 = (Ref.LongRef) this.L$3;
                awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                f2 = f7;
                pointerInputChange2 = (PointerInputChange) this.L$1;
                if (!pointerInputChange.isConsumed()) {
                }
                awaitPointerEventScope2 = awaitPointerEventScope3;
                pointerInputChange = null;
                if (pointerInputChange != null) {
                }
                if (pointerInputChange == null) {
                }
                if (pointerInputChange != null) {
                }
                return Unit.INSTANCE;
            case 5:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                pointerInputChange5 = (PointerInputChange) this.L$2;
                pointerInputChange6 = (PointerInputChange) this.L$1;
                awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                PointerEvent pointerEvent4 = (PointerEvent) obj2;
                List<PointerInputChange> changes5 = pointerEvent4.getChanges();
                int size5 = changes5.size();
                int i7 = 0;
                while (true) {
                    if (i7 < size5) {
                        if (changes5.get(i7).isConsumed()) {
                            List<PointerInputChange> changes6 = pointerEvent4.getChanges();
                            int size6 = changes6.size();
                            for (int i8 = 0; i8 < size6; i8++) {
                                if (changes6.get(i8).getPressed()) {
                                    break;
                                }
                            }
                        } else {
                            i7++;
                        }
                    }
                }
                List<PointerInputChange> changes7 = pointerEvent4.getChanges();
                int size7 = changes7.size();
                int i9 = 0;
                defaultConstructorMarker = defaultConstructorMarker2;
                while (i9 < size7) {
                    if (changes7.get(i9).getPressed()) {
                        PointerInputChange pointerInputChange17 = (PointerInputChange) CollectionsKt.firstOrNull((List<? extends Object>) pointerEvent4.getChanges());
                        long m4531minusMKHz9U = Offset.m4531minusMKHz9U(pointerInputChange17 != null ? pointerInputChange17.m6085getPositionF1C5BW0() : Offset.Companion.m4543getZeroF1C5BW0(), pointerInputChange6.m6085getPositionF1C5BW0());
                        long m6083getIdJ3iCeTQ3 = pointerInputChange6.m6083getIdJ3iCeTQ();
                        int m6088getTypeT8wyACA3 = pointerInputChange6.m6088getTypeT8wyACA();
                        Orientation orientation3 = this.$orientationLock;
                        longRef6 = this.$overSlop;
                        if (DragGestureDetectorKt.m475isPointerUpDmW0f2w(awaitPointerEventScope5.getCurrentEvent(), m6083getIdJ3iCeTQ3)) {
                            pointerInputChange2 = pointerInputChange6;
                            awaitPointerEventScope2 = awaitPointerEventScope5;
                            pointerInputChange = defaultConstructorMarker;
                            defaultConstructorMarker = null;
                            if (pointerInputChange == null) {
                            }
                            if (pointerInputChange != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        float m476pointerSlopE8SPZFQ = DragGestureDetectorKt.m476pointerSlopE8SPZFQ(awaitPointerEventScope5.getViewConfiguration(), m6088getTypeT8wyACA3);
                        longRef5 = new Ref.LongRef();
                        longRef5.element = m6083getIdJ3iCeTQ3;
                        touchSlopDetector4 = new TouchSlopDetector(orientation3, m4531minusMKHz9U, defaultConstructorMarker);
                        f4 = m476pointerSlopE8SPZFQ;
                        awaitPointerEventScope7 = awaitPointerEventScope5;
                        r11 = defaultConstructorMarker;
                        this.L$0 = awaitPointerEventScope7;
                        this.L$1 = pointerInputChange6;
                        this.L$2 = awaitPointerEventScope5;
                        this.L$3 = longRef6;
                        this.L$4 = longRef5;
                        this.L$5 = touchSlopDetector4;
                        this.L$6 = r11;
                        this.F$0 = f4;
                        this.label = 6;
                        obj3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope5, r11, this, 1, r11);
                        if (obj3 != coroutine_suspended) {
                            longRef4 = longRef6;
                            longRef3 = longRef5;
                            f3 = f4;
                            pointerInputChange7 = pointerInputChange6;
                            awaitPointerEventScope6 = awaitPointerEventScope5;
                            touchSlopDetector3 = touchSlopDetector4;
                            pointerEvent = (PointerEvent) obj3;
                            List<PointerInputChange> changes8 = pointerEvent.getChanges();
                            size = changes8.size();
                            i = 0;
                            while (true) {
                                if (i >= size) {
                                    pointerInputChange9 = changes8.get(i);
                                    pointerInputChange8 = pointerInputChange7;
                                    pointerEvent2 = pointerEvent;
                                    touchSlopDetector5 = touchSlopDetector3;
                                    if (!PointerId.m6067equalsimpl0(pointerInputChange9.m6083getIdJ3iCeTQ(), longRef3.element)) {
                                        i++;
                                        touchSlopDetector3 = touchSlopDetector5;
                                        pointerEvent = pointerEvent2;
                                        pointerInputChange7 = pointerInputChange8;
                                    }
                                } else {
                                    pointerEvent2 = pointerEvent;
                                    touchSlopDetector5 = touchSlopDetector3;
                                    pointerInputChange8 = pointerInputChange7;
                                    pointerInputChange9 = null;
                                }
                            }
                            pointerInputChange10 = pointerInputChange9;
                            if (pointerInputChange10 != null && !pointerInputChange10.isConsumed()) {
                                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange10)) {
                                    touchSlopDetector6 = touchSlopDetector5;
                                    if ((touchSlopDetector6.m604addPositionsakrDWew(pointerInputChange10.m6085getPositionF1C5BW0(), pointerInputChange10.m6086getPreviousPositionF1C5BW0(), f3) & j2) != j) {
                                        pointerInputChange10.consume();
                                        longRef4.element = PointerEventKt.positionChange(pointerInputChange10);
                                        if (pointerInputChange10.isConsumed()) {
                                            pointerInputChange = pointerInputChange10;
                                            pointerInputChange2 = pointerInputChange8;
                                            awaitPointerEventScope2 = awaitPointerEventScope7;
                                            defaultConstructorMarker = null;
                                            if (pointerInputChange == null) {
                                            }
                                            if (pointerInputChange != null) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        TouchSlopDetector.m603resetk4lQ0M$default(touchSlopDetector6, 0L, 1, null);
                                    } else {
                                        this.L$0 = awaitPointerEventScope7;
                                        PointerInputChange pointerInputChange18 = pointerInputChange8;
                                        this.L$1 = pointerInputChange18;
                                        this.L$2 = awaitPointerEventScope6;
                                        this.L$3 = longRef4;
                                        this.L$4 = longRef3;
                                        this.L$5 = touchSlopDetector6;
                                        this.L$6 = pointerInputChange10;
                                        this.F$0 = f3;
                                        this.label = 7;
                                        if (awaitPointerEventScope6.awaitPointerEvent(PointerEventPass.Final, this) != coroutine_suspended) {
                                            awaitPointerEventScope8 = awaitPointerEventScope6;
                                            f4 = f3;
                                            longRef6 = longRef4;
                                            touchSlopDetector7 = touchSlopDetector6;
                                            pointerInputChange6 = pointerInputChange18;
                                            if (!pointerInputChange10.isConsumed()) {
                                                awaitPointerEventScope2 = awaitPointerEventScope7;
                                                pointerInputChange2 = pointerInputChange6;
                                                pointerInputChange = null;
                                                defaultConstructorMarker = null;
                                                if (pointerInputChange == null) {
                                                }
                                                if (pointerInputChange != null) {
                                                }
                                                return Unit.INSTANCE;
                                            }
                                            awaitPointerEventScope5 = awaitPointerEventScope8;
                                            touchSlopDetector4 = touchSlopDetector7;
                                            longRef5 = longRef3;
                                            r11 = 0;
                                            this.L$0 = awaitPointerEventScope7;
                                            this.L$1 = pointerInputChange6;
                                            this.L$2 = awaitPointerEventScope5;
                                            this.L$3 = longRef6;
                                            this.L$4 = longRef5;
                                            this.L$5 = touchSlopDetector4;
                                            this.L$6 = r11;
                                            this.F$0 = f4;
                                            this.label = 6;
                                            obj3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope5, r11, this, 1, r11);
                                            if (obj3 != coroutine_suspended) {
                                            }
                                        }
                                    }
                                } else {
                                    List<PointerInputChange> changes9 = pointerEvent2.getChanges();
                                    int size8 = changes9.size();
                                    int i10 = 0;
                                    while (true) {
                                        if (i10 < size8) {
                                            pointerInputChange11 = changes9.get(i10);
                                            if (!pointerInputChange11.getPressed()) {
                                                i10++;
                                            }
                                        } else {
                                            pointerInputChange11 = null;
                                        }
                                    }
                                    PointerInputChange pointerInputChange19 = pointerInputChange11;
                                    if (pointerInputChange19 != null) {
                                        longRef3.element = pointerInputChange19.m6083getIdJ3iCeTQ();
                                        touchSlopDetector6 = touchSlopDetector5;
                                    }
                                }
                                awaitPointerEventScope5 = awaitPointerEventScope6;
                                touchSlopDetector4 = touchSlopDetector6;
                                f4 = f3;
                                longRef6 = longRef4;
                                longRef5 = longRef3;
                                pointerInputChange6 = pointerInputChange8;
                                r11 = 0;
                                this.L$0 = awaitPointerEventScope7;
                                this.L$1 = pointerInputChange6;
                                this.L$2 = awaitPointerEventScope5;
                                this.L$3 = longRef6;
                                this.L$4 = longRef5;
                                this.L$5 = touchSlopDetector4;
                                this.L$6 = r11;
                                this.F$0 = f4;
                                this.label = 6;
                                obj3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope5, r11, this, 1, r11);
                                if (obj3 != coroutine_suspended) {
                                }
                            }
                            pointerInputChange2 = pointerInputChange8;
                            pointerInputChange = null;
                            awaitPointerEventScope2 = awaitPointerEventScope7;
                            defaultConstructorMarker = null;
                            if (pointerInputChange == null) {
                            }
                            if (pointerInputChange != null) {
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        i9++;
                        defaultConstructorMarker = null;
                    }
                }
                PointerInputChange pointerInputChange20 = pointerInputChange6;
                pointerInputChange = pointerInputChange5;
                pointerInputChange2 = pointerInputChange20;
                awaitPointerEventScope2 = awaitPointerEventScope5;
                if (pointerInputChange == null) {
                }
                if (pointerInputChange != null) {
                }
                return Unit.INSTANCE;
            case 6:
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                float f8 = this.F$0;
                touchSlopDetector3 = (TouchSlopDetector) this.L$5;
                pointerInputChange7 = (PointerInputChange) this.L$1;
                ResultKt.throwOnFailure(obj);
                obj3 = obj;
                f3 = f8;
                longRef3 = (Ref.LongRef) this.L$4;
                awaitPointerEventScope6 = (AwaitPointerEventScope) this.L$2;
                awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                longRef4 = (Ref.LongRef) this.L$3;
                pointerEvent = (PointerEvent) obj3;
                List<PointerInputChange> changes82 = pointerEvent.getChanges();
                size = changes82.size();
                i = 0;
                while (true) {
                    if (i >= size) {
                    }
                    i++;
                    touchSlopDetector3 = touchSlopDetector5;
                    pointerEvent = pointerEvent2;
                    pointerInputChange7 = pointerInputChange8;
                }
                pointerInputChange10 = pointerInputChange9;
                if (pointerInputChange10 != null) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange10)) {
                    }
                    awaitPointerEventScope5 = awaitPointerEventScope6;
                    touchSlopDetector4 = touchSlopDetector6;
                    f4 = f3;
                    longRef6 = longRef4;
                    longRef5 = longRef3;
                    pointerInputChange6 = pointerInputChange8;
                    r11 = 0;
                    this.L$0 = awaitPointerEventScope7;
                    this.L$1 = pointerInputChange6;
                    this.L$2 = awaitPointerEventScope5;
                    this.L$3 = longRef6;
                    this.L$4 = longRef5;
                    this.L$5 = touchSlopDetector4;
                    this.L$6 = r11;
                    this.F$0 = f4;
                    this.label = 6;
                    obj3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope5, r11, this, 1, r11);
                    if (obj3 != coroutine_suspended) {
                    }
                    break;
                }
                pointerInputChange2 = pointerInputChange8;
                pointerInputChange = null;
                awaitPointerEventScope2 = awaitPointerEventScope7;
                defaultConstructorMarker = null;
                if (pointerInputChange == null) {
                }
                if (pointerInputChange != null) {
                }
                return Unit.INSTANCE;
            case 7:
                f4 = this.F$0;
                pointerInputChange10 = (PointerInputChange) this.L$6;
                touchSlopDetector7 = (TouchSlopDetector) this.L$5;
                longRef3 = (Ref.LongRef) this.L$4;
                j = InlineClassHelperKt.UnspecifiedPackedFloats;
                j2 = 9223372034707292159L;
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope8 = (AwaitPointerEventScope) this.L$2;
                pointerInputChange6 = (PointerInputChange) this.L$1;
                awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                longRef6 = (Ref.LongRef) this.L$3;
                if (!pointerInputChange10.isConsumed()) {
                }
                break;
            case 8:
                longRef7 = (Ref.LongRef) this.L$3;
                awaitPointerEventScope10 = (AwaitPointerEventScope) this.L$2;
                function2 = (Function2) this.L$1;
                ResultKt.throwOnFailure(obj);
                awaitPointerEvent$default = obj;
                awaitPointerEventScope9 = (AwaitPointerEventScope) this.L$0;
                orientation = null;
                PointerEvent pointerEvent5 = (PointerEvent) awaitPointerEvent$default;
                List<PointerInputChange> changes10 = pointerEvent5.getChanges();
                int size9 = changes10.size();
                int i11 = 0;
                while (true) {
                    if (i11 < size9) {
                        pointerInputChange13 = changes10.get(i11);
                        if (!PointerId.m6067equalsimpl0(pointerInputChange13.m6083getIdJ3iCeTQ(), longRef7.element)) {
                            i11++;
                        }
                    } else {
                        pointerInputChange13 = null;
                    }
                }
                PointerInputChange pointerInputChange21 = pointerInputChange13;
                if (pointerInputChange21 != null) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange21)) {
                        List<PointerInputChange> changes11 = pointerEvent5.getChanges();
                        int size10 = changes11.size();
                        int i12 = 0;
                        while (true) {
                            if (i12 < size10) {
                                pointerInputChange14 = changes11.get(i12);
                                if (!pointerInputChange14.getPressed()) {
                                    i12++;
                                }
                            } else {
                                pointerInputChange14 = null;
                            }
                        }
                        PointerInputChange pointerInputChange22 = pointerInputChange14;
                        if (pointerInputChange22 != null) {
                            longRef7.element = pointerInputChange22.m6083getIdJ3iCeTQ();
                            this.L$0 = awaitPointerEventScope9;
                            this.L$1 = function2;
                            this.L$2 = awaitPointerEventScope10;
                            this.L$3 = longRef7;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.label = 8;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope10, null, this, 1, null);
                            break;
                        }
                    } else {
                        long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange21);
                        if ((orientation != null ? Float.intBitsToFloat((int) (orientation == Orientation.Vertical ? positionChangeIgnoreConsumed & 4294967295L : positionChangeIgnoreConsumed >> 32)) : Offset.m4525getDistanceimpl(positionChangeIgnoreConsumed)) == 0.0f) {
                            z = true;
                            break;
                        } else {
                            z = false;
                            break;
                        }
                    }
                } else {
                    pointerInputChange21 = null;
                }
                if (pointerInputChange21 != null && !pointerInputChange21.isConsumed()) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange21)) {
                        pointerInputChange12 = pointerInputChange21;
                        if (pointerInputChange12 == null) {
                        }
                        return Unit.INSTANCE;
                    }
                    function2.invoke(pointerInputChange21, Offset.m4516boximpl(PointerEventKt.positionChange(pointerInputChange21)));
                    pointerInputChange21.consume();
                    m6083getIdJ3iCeTQ = pointerInputChange21.m6083getIdJ3iCeTQ();
                    awaitPointerEventScope2 = awaitPointerEventScope9;
                    Ref.LongRef longRef92 = new Ref.LongRef();
                    longRef92.element = m6083getIdJ3iCeTQ;
                    longRef7 = longRef92;
                    awaitPointerEventScope10 = awaitPointerEventScope2;
                    awaitPointerEventScope9 = awaitPointerEventScope10;
                    this.L$0 = awaitPointerEventScope9;
                    this.L$1 = function2;
                    this.L$2 = awaitPointerEventScope10;
                    this.L$3 = longRef7;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.label = 8;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope10, null, this, 1, null);
                }
                pointerInputChange12 = null;
                if (pointerInputChange12 == null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return coroutine_suspended;
    }
}
