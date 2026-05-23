package androidx.compose.foundation.draganddrop;

import androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.spatial.RectListKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: AndroidDragAndDropSource.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1", f = "AndroidDragAndDropSource.android.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
final class DragAndDropSourceDefaults$DefaultStartDetector$1 extends SuspendLambda implements Function2<DragAndDropStartDetectorScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DragAndDropSourceDefaults$DefaultStartDetector$1(Continuation<? super DragAndDropSourceDefaults$DefaultStartDetector$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragAndDropSourceDefaults$DefaultStartDetector$1 dragAndDropSourceDefaults$DefaultStartDetector$1 = new DragAndDropSourceDefaults$DefaultStartDetector$1(continuation);
        dragAndDropSourceDefaults$DefaultStartDetector$1.L$0 = obj;
        return dragAndDropSourceDefaults$DefaultStartDetector$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DragAndDropStartDetectorScope dragAndDropStartDetectorScope, Continuation<? super Unit> continuation) {
        return ((DragAndDropSourceDefaults$DefaultStartDetector$1) create(dragAndDropStartDetectorScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragAndDropStartDetectorScope dragAndDropStartDetectorScope = (DragAndDropStartDetectorScope) this.L$0;
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(dragAndDropStartDetectorScope, new PressGestureScopeImpl(dragAndDropStartDetectorScope), null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AndroidDragAndDropSource.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1", f = "AndroidDragAndDropSource.android.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ DragAndDropStartDetectorScope $this;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DragAndDropStartDetectorScope dragAndDropStartDetectorScope, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this = dragAndDropStartDetectorScope;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this, this.$pressScope, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AndroidDragAndDropSource.android.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1", f = "AndroidDragAndDropSource.android.kt", i = {0}, l = {48, 50, RectListKt.BitOffsetForGesturable}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"}, v = 1)
        /* renamed from: androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00051 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            final /* synthetic */ DragAndDropStartDetectorScope $this;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00051(CoroutineScope coroutineScope, PressGestureScopeImpl pressGestureScopeImpl, DragAndDropStartDetectorScope dragAndDropStartDetectorScope, Continuation<? super C00051> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$pressScope = pressGestureScopeImpl;
                this.$this = dragAndDropStartDetectorScope;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static final boolean invokeSuspend$lambda$0() {
                return true;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00051 c00051 = new C00051(this.$$this$coroutineScope, this.$pressScope, this.$this, continuation);
                c00051.L$0 = obj;
                return c00051;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((C00051) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
                if (r14 == r0) goto L17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x007c, code lost:
                if (androidx.compose.foundation.gestures.DragGestureDetectorKt.processDragGesture(r4, r5, r6, null, new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda1(r14), new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda2(), new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda3(), new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda4(), r13) == r0) goto L17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
                if (androidx.compose.foundation.gestures.TapGestureDetectorKt.processTapGesture(r4, r5, r6, null, new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda5(r14), new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1.AnonymousClass1.C00051.AnonymousClass7(null), null, r13) == r0) goto L17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x00a1, code lost:
                return r0;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                AwaitPointerEventScope awaitPointerEventScope;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    obj = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, PointerEventPass.Initial, this);
                } else if (i != 1) {
                    if (i == 2 || i == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                if (PointerType.m6758equalsimpl0(pointerInputChange.m6688getTypeT8wyACA(), PointerType.Companion.m6763getMouseT8wyACA())) {
                    Function0 function0 = new Function0() { // from class: androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(DragAndDropSourceDefaults$DefaultStartDetector$1.AnonymousClass1.C00051.invokeSuspend$lambda$0());
                        }
                    };
                    final DragAndDropStartDetectorScope dragAndDropStartDetectorScope = this.$this;
                    this.L$0 = null;
                    this.label = 2;
                } else {
                    CoroutineScope coroutineScope = this.$$this$coroutineScope;
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    final DragAndDropStartDetectorScope dragAndDropStartDetectorScope2 = this.$this;
                    this.L$0 = null;
                    this.label = 3;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static final Unit invokeSuspend$lambda$1(DragAndDropStartDetectorScope dragAndDropStartDetectorScope, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
                dragAndDropStartDetectorScope.mo426requestDragAndDropTransferk4lQ0M(pointerInputChange.m6685getPositionF1C5BW0());
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: AndroidDragAndDropSource.android.kt */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$7", f = "AndroidDragAndDropSource.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            /* renamed from: androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$7  reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass7 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                int label;

                AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                    return m422invoked4ec7I(pressGestureScope, offset.m5113unboximpl(), continuation);
                }

                /* renamed from: invoke-d-4ec7I  reason: not valid java name */
                public final Object m422invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                    return new AnonymousClass7(continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static final Unit invokeSuspend$lambda$5(DragAndDropStartDetectorScope dragAndDropStartDetectorScope, Offset offset) {
                dragAndDropStartDetectorScope.mo426requestDragAndDropTransferk4lQ0M(offset.m5113unboximpl());
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$this, new C00051((CoroutineScope) this.L$0, this.$pressScope, this.$this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
