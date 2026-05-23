package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2", f = "Transformable.kt", i = {0, 1, 2, 3}, l = {288, 315, 331, 349}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0", "L$0", "L$0"}, v = 1)
/* loaded from: classes.dex */
public final class TransformableKt$detectNonTouchGestures$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<TransformEvent> $channel;
    final /* synthetic */ CoroutineContext $currentContext;
    final /* synthetic */ ScrollConfig $scrollConfig;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformableKt$detectNonTouchGestures$2(CoroutineContext coroutineContext, ScrollConfig scrollConfig, Channel<TransformEvent> channel, Continuation<? super TransformableKt$detectNonTouchGestures$2> continuation) {
        super(2, continuation);
        this.$currentContext = coroutineContext;
        this.$scrollConfig = scrollConfig;
        this.$channel = channel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean invokeSuspend$lambda$0(PointerInputChange pointerInputChange) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean invokeSuspend$lambda$1(PointerInputChange pointerInputChange) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean invokeSuspend$lambda$3(PointerInputChange pointerInputChange) {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableKt$detectNonTouchGestures$2 transformableKt$detectNonTouchGestures$2 = new TransformableKt$detectNonTouchGestures$2(this.$currentContext, this.$scrollConfig, this.$channel, continuation);
        transformableKt$detectNonTouchGestures$2.L$0 = obj;
        return transformableKt$detectNonTouchGestures$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((TransformableKt$detectNonTouchGestures$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0163, code lost:
        if (r9 != r0) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0166, B:57:0x016e, B:52:0x0136, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d2, B:41:0x00dc, B:43:0x00e3, B:44:0x00ef, B:47:0x0119, B:49:0x0121, B:51:0x0128, B:60:0x017c, B:61:0x0187, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0166, B:57:0x016e, B:52:0x0136, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d2, B:41:0x00dc, B:43:0x00e3, B:44:0x00ef, B:47:0x0119, B:49:0x0121, B:51:0x0128, B:60:0x017c, B:61:0x0187, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0166, B:57:0x016e, B:52:0x0136, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d2, B:41:0x00dc, B:43:0x00e3, B:44:0x00ef, B:47:0x0119, B:49:0x0121, B:51:0x0128, B:60:0x017c, B:61:0x0187, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0190  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0080 -> B:27:0x005d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00da -> B:59:0x0173). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00dc -> B:36:0x008f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x011f -> B:59:0x0173). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0121 -> B:44:0x00ef). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0163 -> B:55:0x0166). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        Object obj2;
        PointerEvent pointerEvent;
        Offset consumePointerEventAsPanOrNull;
        Object obj3;
        Offset consumePointerEventAsCtrlScrollOrNull;
        Object obj4;
        Offset consumePointerEventAsCtrlScrollOrNull2;
        Offset consumePointerEventAsPanOrNull2;
        Float consumePointerEventAsScaleOrNull;
        float f;
        Float consumePointerEventAsScaleOrNull2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                if (!JobKt.isActive(this.$currentContext)) {
                }
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                obj4 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                if (obj4 == coroutine_suspended) {
                }
                pointerEvent = (PointerEvent) obj4;
                consumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                consumePointerEventAsPanOrNull2 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                consumePointerEventAsScaleOrNull = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                if (consumePointerEventAsCtrlScrollOrNull2 == null) {
                }
                if (consumePointerEventAsCtrlScrollOrNull2 != null) {
                }
            } else if (i == 1) {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj4 = obj;
                pointerEvent = (PointerEvent) obj4;
                consumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                consumePointerEventAsPanOrNull2 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                consumePointerEventAsScaleOrNull = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                if (consumePointerEventAsCtrlScrollOrNull2 == null) {
                }
                if (consumePointerEventAsCtrlScrollOrNull2 != null) {
                }
            } else if (i == 2) {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj3 = obj;
                pointerEvent = (PointerEvent) obj3;
                consumePointerEventAsCtrlScrollOrNull = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                if (consumePointerEventAsCtrlScrollOrNull != null) {
                }
                if (!JobKt.isActive(this.$currentContext)) {
                }
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                obj4 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                if (obj4 == coroutine_suspended) {
                }
                pointerEvent = (PointerEvent) obj4;
                consumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                consumePointerEventAsPanOrNull2 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                consumePointerEventAsScaleOrNull = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                if (consumePointerEventAsCtrlScrollOrNull2 == null) {
                }
                if (consumePointerEventAsCtrlScrollOrNull2 != null) {
                }
            } else if (i == 3) {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                pointerEvent = (PointerEvent) obj2;
                consumePointerEventAsPanOrNull = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                if (consumePointerEventAsPanOrNull != null) {
                }
                if (!JobKt.isActive(this.$currentContext)) {
                }
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                obj4 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                if (obj4 == coroutine_suspended) {
                }
                pointerEvent = (PointerEvent) obj4;
                consumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                consumePointerEventAsPanOrNull2 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                consumePointerEventAsScaleOrNull = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                if (consumePointerEventAsCtrlScrollOrNull2 == null) {
                }
                if (consumePointerEventAsCtrlScrollOrNull2 != null) {
                }
            } else if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Object awaitPointerEvent$default = obj;
                pointerEvent = (PointerEvent) awaitPointerEvent$default;
                consumePointerEventAsScaleOrNull2 = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                if (consumePointerEventAsScaleOrNull2 != null) {
                    f = consumePointerEventAsScaleOrNull2.floatValue();
                    this.$channel.mo9005trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj5) {
                            return Boolean.valueOf(TransformableKt$detectNonTouchGestures$2.invokeSuspend$lambda$3((PointerInputChange) obj5));
                        }
                    }, 1, null), f, Offset.Companion.m5119getZeroF1C5BW0(), 0.0f, null));
                    this.L$0 = awaitPointerEventScope;
                    this.label = 4;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                }
                if (!JobKt.isActive(this.$currentContext)) {
                    return Unit.INSTANCE;
                }
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                obj4 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                if (obj4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pointerEvent = (PointerEvent) obj4;
                consumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                consumePointerEventAsPanOrNull2 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                consumePointerEventAsScaleOrNull = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                if (consumePointerEventAsCtrlScrollOrNull2 == null || consumePointerEventAsPanOrNull2 != null || consumePointerEventAsScaleOrNull != null) {
                    if (consumePointerEventAsCtrlScrollOrNull2 != null) {
                        long m5113unboximpl = consumePointerEventAsCtrlScrollOrNull2.m5113unboximpl();
                        this.$channel.mo9005trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                        this.$channel.mo9005trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj5) {
                                return Boolean.valueOf(TransformableKt$detectNonTouchGestures$2.invokeSuspend$lambda$0((PointerInputChange) obj5));
                            }
                        }, 1, null), (float) Math.pow(2.0d, Float.intBitsToFloat((int) (m5113unboximpl & 4294967295L)) / 545.0f), Offset.Companion.m5119getZeroF1C5BW0(), 0.0f, null));
                        this.L$0 = awaitPointerEventScope;
                        this.label = 2;
                        obj3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pointerEvent = (PointerEvent) obj3;
                        consumePointerEventAsCtrlScrollOrNull = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                        if (consumePointerEventAsCtrlScrollOrNull != null) {
                            m5113unboximpl = consumePointerEventAsCtrlScrollOrNull.m5113unboximpl();
                            this.$channel.mo9005trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj5) {
                                    return Boolean.valueOf(TransformableKt$detectNonTouchGestures$2.invokeSuspend$lambda$0((PointerInputChange) obj5));
                                }
                            }, 1, null), (float) Math.pow(2.0d, Float.intBitsToFloat((int) (m5113unboximpl & 4294967295L)) / 545.0f), Offset.Companion.m5119getZeroF1C5BW0(), 0.0f, null));
                            this.L$0 = awaitPointerEventScope;
                            this.label = 2;
                            obj3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                            if (obj3 == coroutine_suspended) {
                            }
                            pointerEvent = (PointerEvent) obj3;
                            consumePointerEventAsCtrlScrollOrNull = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                            if (consumePointerEventAsCtrlScrollOrNull != null) {
                            }
                        }
                        if (!JobKt.isActive(this.$currentContext)) {
                        }
                    } else if (consumePointerEventAsPanOrNull2 != null) {
                        long m5113unboximpl2 = consumePointerEventAsPanOrNull2.m5113unboximpl();
                        this.$channel.mo9005trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                        long m5113unboximpl3 = m5113unboximpl2;
                        this.$channel.mo9005trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj5) {
                                return Boolean.valueOf(TransformableKt$detectNonTouchGestures$2.invokeSuspend$lambda$1((PointerInputChange) obj5));
                            }
                        }, 1, null), 1.0f, m5113unboximpl3, 0.0f, null));
                        this.L$0 = awaitPointerEventScope;
                        this.label = 3;
                        obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pointerEvent = (PointerEvent) obj2;
                        consumePointerEventAsPanOrNull = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                        if (consumePointerEventAsPanOrNull != null) {
                            m5113unboximpl3 = consumePointerEventAsPanOrNull.m5113unboximpl();
                            this.$channel.mo9005trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj5) {
                                    return Boolean.valueOf(TransformableKt$detectNonTouchGestures$2.invokeSuspend$lambda$1((PointerInputChange) obj5));
                                }
                            }, 1, null), 1.0f, m5113unboximpl3, 0.0f, null));
                            this.L$0 = awaitPointerEventScope;
                            this.label = 3;
                            obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                            if (obj2 == coroutine_suspended) {
                            }
                            pointerEvent = (PointerEvent) obj2;
                            consumePointerEventAsPanOrNull = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                            if (consumePointerEventAsPanOrNull != null) {
                            }
                        }
                        if (!JobKt.isActive(this.$currentContext)) {
                        }
                    } else if (consumePointerEventAsScaleOrNull == null) {
                        throw new IllegalStateException("One of zoomOffset, panOffset and scaleDelta must be non-null".toString());
                    } else {
                        float floatValue = consumePointerEventAsScaleOrNull.floatValue();
                        this.$channel.mo9005trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                        f = floatValue;
                        this.$channel.mo9005trySendJP2dKIU(new TransformEvent.TransformDelta(TransformGestureDetectorKt.calculateCentroid$default(pointerEvent, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj5) {
                                return Boolean.valueOf(TransformableKt$detectNonTouchGestures$2.invokeSuspend$lambda$3((PointerInputChange) obj5));
                            }
                        }, 1, null), f, Offset.Companion.m5119getZeroF1C5BW0(), 0.0f, null));
                        this.L$0 = awaitPointerEventScope;
                        this.label = 4;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                    }
                }
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                obj4 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
                if (obj4 == coroutine_suspended) {
                }
                pointerEvent = (PointerEvent) obj4;
                consumePointerEventAsCtrlScrollOrNull2 = TransformableKt.consumePointerEventAsCtrlScrollOrNull(awaitPointerEventScope, pointerEvent, this.$scrollConfig);
                consumePointerEventAsPanOrNull2 = TransformableKt.consumePointerEventAsPanOrNull(awaitPointerEventScope, pointerEvent);
                consumePointerEventAsScaleOrNull = TransformableKt.consumePointerEventAsScaleOrNull(awaitPointerEventScope, pointerEvent);
                if (consumePointerEventAsCtrlScrollOrNull2 == null) {
                }
                if (consumePointerEventAsCtrlScrollOrNull2 != null) {
                }
            }
        } finally {
            this.$channel.mo9005trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
        }
    }
}
