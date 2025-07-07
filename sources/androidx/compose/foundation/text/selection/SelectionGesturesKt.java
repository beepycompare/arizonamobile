package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import io.appmetrica.analytics.BuildConfig;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: SelectionGestures.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0012\u0010\f\u001a\u00020\u0004*\u00020\rH\u0082@¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016\u001a\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u001a\"\u0010\u001d\u001a\u00020\u0010*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0080@¢\u0006\u0002\u0010\u001f\u001a\"\u0010 \u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a\"\u0010\"\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a\"\u0010$\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a \u0010%\u001a\u00020\u0019*\u00020\u00192\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100'H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006("}, d2 = {"STATIC_KEY", "", "isPrecisePointer", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "awaitDown", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelectionBtf2", "selectionGestureInput", "Landroidx/compose/ui/Modifier;", "mouseSelectionObserver", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "selectionGesturePointerInputBtf2", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "downEvent", "touchSelectionSubsequentPress", "updateSelectionTouchMode", "updateTouchMode", "Lkotlin/Function1;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    public static final Modifier updateSelectionTouchMode(Modifier modifier, final Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Integer.valueOf((int) STATIC_KEY), new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1

            /* compiled from: SelectionGestures.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1", f = "SelectionGestures.kt", i = {0}, l = {94}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
            /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1  reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$updateTouchMode = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$updateTouchMode, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
                    */
                /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[RETURN] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0030 -> B:12:0x0033). Please submit an issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                    /*
                        r4 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r4.label
                        r2 = 1
                        if (r1 == 0) goto L1b
                        if (r1 != r2) goto L13
                        java.lang.Object r1 = r4.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r5)
                        goto L33
                    L13:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r0)
                        throw r5
                    L1b:
                        kotlin.ResultKt.throwOnFailure(r5)
                        java.lang.Object r5 = r4.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                        r1 = r5
                    L23:
                        androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r3 = r4
                        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                        r4.L$0 = r1
                        r4.label = r2
                        java.lang.Object r5 = r1.awaitPointerEvent(r5, r3)
                        if (r5 != r0) goto L33
                        return r0
                    L33:
                        androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.ui.input.pointer.PointerEvent) r5
                        kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r3 = r4.$updateTouchMode
                        boolean r5 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r5)
                        r5 = r5 ^ r2
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r3.invoke(r5)
                        goto L23
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new AnonymousClass1(function1, null), continuation);
                return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
            }
        });
    }

    public static final Modifier selectionGestureInput(Modifier modifier, final MouseSelectionObserver mouseSelectionObserver, final TextDragObserver textDragObserver) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mouseSelectionObserver, textDragObserver, new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1

            /* compiled from: SelectionGestures.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1", f = "SelectionGestures.kt", i = {0}, l = {107, 113, BuildConfig.API_LEVEL}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
            /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1  reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ClicksCounter $clicksCounter;
                final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
                final /* synthetic */ TextDragObserver $textDragObserver;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, TextDragObserver textDragObserver, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$mouseSelectionObserver = mouseSelectionObserver;
                    this.$clicksCounter = clicksCounter;
                    this.$textDragObserver = textDragObserver;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mouseSelectionObserver, this.$clicksCounter, this.$textDragObserver, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
                    if (r10 == r0) goto L26;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
                    if (r10 == r0) goto L26;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:31:0x0093, code lost:
                    if (r10 == r0) goto L26;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:32:0x0095, code lost:
                    return r0;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    Object obj2;
                    Object mouseSelection;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope;
                        this.label = 1;
                        obj = SelectionGesturesKt.awaitDown(awaitPointerEventScope, this);
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
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    if (SelectionGesturesKt.isPrecisePointer(pointerEvent) && PointerEvent_androidKt.m5286isPrimaryPressedaHzCxE(pointerEvent.m5253getButtonsry648PA())) {
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        int size = changes.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if (!changes.get(i2).isConsumed()) {
                            }
                        }
                        this.L$0 = null;
                        this.label = 2;
                        mouseSelection = SelectionGesturesKt.mouseSelection(awaitPointerEventScope, this.$mouseSelectionObserver, this.$clicksCounter, pointerEvent, this);
                    }
                    if (!SelectionGesturesKt.isPrecisePointer(pointerEvent)) {
                        this.L$0 = null;
                        this.label = 3;
                        obj2 = SelectionGesturesKt.touchSelection(awaitPointerEventScope, this.$textDragObserver, pointerEvent, this);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(MouseSelectionObserver.this, new ClicksCounter(pointerInputScope.getViewConfiguration()), textDragObserver, null), continuation);
                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
        if (r11 != r1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelection(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$touchSelection$1 selectionGesturesKt$touchSelection$1;
        Object obj;
        int i;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        try {
            if (continuation instanceof SelectionGesturesKt$touchSelection$1) {
                selectionGesturesKt$touchSelection$1 = (SelectionGesturesKt$touchSelection$1) continuation;
                if ((selectionGesturesKt$touchSelection$1.label & Integer.MIN_VALUE) != 0) {
                    selectionGesturesKt$touchSelection$1.label -= Integer.MIN_VALUE;
                    obj = selectionGesturesKt$touchSelection$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = selectionGesturesKt$touchSelection$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = (PointerInputChange) CollectionsKt.first((List<? extends Object>) pointerEvent.getChanges());
                        long m5311getIdJ3iCeTQ = pointerInputChange.m5311getIdJ3iCeTQ();
                        selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelection$1.L$2 = pointerInputChange;
                        selectionGesturesKt$touchSelection$1.label = 1;
                        obj = DragGestureDetectorKt.m435awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, m5311getIdJ3iCeTQ, selectionGesturesKt$touchSelection$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        if (i == 2) {
                            textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelection$1.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$touchSelection$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                int size = changes.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    PointerInputChange pointerInputChange3 = changes.get(i2);
                                    if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                        pointerInputChange3.consume();
                                    }
                                }
                                textDragObserver.onStop();
                            } else {
                                textDragObserver.onCancel();
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        PointerInputChange pointerInputChange4 = (PointerInputChange) selectionGesturesKt$touchSelection$1.L$2;
                        textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelection$1.L$1;
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$touchSelection$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = pointerInputChange4;
                        awaitPointerEventScope = awaitPointerEventScope2;
                    }
                    pointerInputChange2 = (PointerInputChange) obj;
                    if (pointerInputChange2 != null && distanceIsTolerable(awaitPointerEventScope.getViewConfiguration(), pointerInputChange, pointerInputChange2)) {
                        textDragObserver.mo1148onStartk4lQ0M(pointerInputChange2.m5313getPositionF1C5BW0());
                        selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelection$1.L$2 = null;
                        selectionGesturesKt$touchSelection$1.label = 2;
                        obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope, pointerInputChange2.m5311getIdJ3iCeTQ(), new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange5) {
                                invoke2(pointerInputChange5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange pointerInputChange5) {
                                TextDragObserver.this.mo1147onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange5));
                                pointerInputChange5.consume();
                            }
                        }, selectionGesturesKt$touchSelection$1);
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            pointerInputChange2 = (PointerInputChange) obj;
            if (pointerInputChange2 != null) {
                textDragObserver.mo1148onStartk4lQ0M(pointerInputChange2.m5313getPositionF1C5BW0());
                selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                selectionGesturesKt$touchSelection$1.L$2 = null;
                selectionGesturesKt$touchSelection$1.label = 2;
                obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope, pointerInputChange2.m5311getIdJ3iCeTQ(), new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange5) {
                        invoke2(pointerInputChange5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(PointerInputChange pointerInputChange5) {
                        TextDragObserver.this.mo1147onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange5));
                        pointerInputChange5.consume();
                    }
                }, selectionGesturesKt$touchSelection$1);
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            textDragObserver.onCancel();
            throw e;
        }
        selectionGesturesKt$touchSelection$1 = new SelectionGesturesKt$touchSelection$1(continuation);
        obj = selectionGesturesKt$touchSelection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$touchSelection$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
        if (r12 == r1) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelection(AwaitPointerEventScope awaitPointerEventScope, final MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$mouseSelection$1 selectionGesturesKt$mouseSelection$1;
        int i;
        final SelectionAdjustment none;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.BooleanRef booleanRef;
        int size;
        if (continuation instanceof SelectionGesturesKt$mouseSelection$1) {
            selectionGesturesKt$mouseSelection$1 = (SelectionGesturesKt$mouseSelection$1) continuation;
            if ((selectionGesturesKt$mouseSelection$1.label & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$mouseSelection$1.label -= Integer.MIN_VALUE;
                Object obj = selectionGesturesKt$mouseSelection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = selectionGesturesKt$mouseSelection$1.label;
                int i2 = 0;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    clicksCounter.update(pointerEvent);
                    PointerInputChange pointerInputChange = pointerEvent.getChanges().get(0);
                    if (TextFieldSelectionManager_androidKt.isShiftPressed(pointerEvent)) {
                        if (mouseSelectionObserver.mo1389onExtendk4lQ0M(pointerInputChange.m5313getPositionF1C5BW0())) {
                            selectionGesturesKt$mouseSelection$1.L$0 = awaitPointerEventScope;
                            selectionGesturesKt$mouseSelection$1.L$1 = mouseSelectionObserver;
                            selectionGesturesKt$mouseSelection$1.label = 1;
                            obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope, pointerInputChange.m5311getIdJ3iCeTQ(), new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                                    invoke2(pointerInputChange2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(PointerInputChange pointerInputChange2) {
                                    if (MouseSelectionObserver.this.mo1390onExtendDragk4lQ0M(pointerInputChange2.m5313getPositionF1C5BW0())) {
                                        pointerInputChange2.consume();
                                    }
                                }
                            }, selectionGesturesKt$mouseSelection$1);
                        }
                    } else {
                        int clicks = clicksCounter.getClicks();
                        if (clicks == 1) {
                            none = SelectionAdjustment.Companion.getNone();
                        } else if (clicks == 2) {
                            none = SelectionAdjustment.Companion.getWord();
                        } else {
                            none = SelectionAdjustment.Companion.getParagraph();
                        }
                        if (mouseSelectionObserver.mo1391onStart3MmeM6k(pointerInputChange.m5313getPositionF1C5BW0(), none)) {
                            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                            booleanRef2.element = !Intrinsics.areEqual(none, SelectionAdjustment.Companion.getNone());
                            selectionGesturesKt$mouseSelection$1.L$0 = awaitPointerEventScope;
                            selectionGesturesKt$mouseSelection$1.L$1 = mouseSelectionObserver;
                            selectionGesturesKt$mouseSelection$1.L$2 = booleanRef2;
                            selectionGesturesKt$mouseSelection$1.label = 2;
                            obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope, pointerInputChange.m5311getIdJ3iCeTQ(), new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                                    invoke2(pointerInputChange2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(PointerInputChange pointerInputChange2) {
                                    if (MouseSelectionObserver.this.mo1388onDrag3MmeM6k(pointerInputChange2.m5313getPositionF1C5BW0(), none)) {
                                        pointerInputChange2.consume();
                                        booleanRef2.element = true;
                                    }
                                }
                            }, selectionGesturesKt$mouseSelection$1);
                            if (obj != coroutine_suspended) {
                                awaitPointerEventScope2 = awaitPointerEventScope;
                                booleanRef = booleanRef2;
                                if (((Boolean) obj).booleanValue()) {
                                    List<PointerInputChange> changes = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                    size = changes.size();
                                    while (i2 < size) {
                                    }
                                }
                                mouseSelectionObserver.onDragDone();
                            }
                            return coroutine_suspended;
                        }
                    }
                } else if (i == 1) {
                    mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelection$1.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$mouseSelection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        List<PointerInputChange> changes2 = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size2 = changes2.size();
                        while (i2 < size2) {
                            PointerInputChange pointerInputChange2 = changes2.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                            i2++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    booleanRef = (Ref.BooleanRef) selectionGesturesKt$mouseSelection$1.L$2;
                    mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelection$1.L$1;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$mouseSelection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue() && booleanRef.element) {
                        List<PointerInputChange> changes3 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                        size = changes3.size();
                        while (i2 < size) {
                            PointerInputChange pointerInputChange3 = changes3.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                pointerInputChange3.consume();
                            }
                            i2++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                }
                return Unit.INSTANCE;
            }
        }
        selectionGesturesKt$mouseSelection$1 = new SelectionGesturesKt$mouseSelection$1(continuation);
        Object obj2 = selectionGesturesKt$mouseSelection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$mouseSelection$1.label;
        int i22 = 0;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    public static final Object selectionGesturePointerInputBtf2(PointerInputScope pointerInputScope, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new SelectionGesturesKt$selectionGesturePointerInputBtf2$2(new ClicksCounter(pointerInputScope.getViewConfiguration()), mouseSelectionObserver, textDragObserver, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
        if (r11 != r1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionFirstPress(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$touchSelectionFirstPress$1 selectionGesturesKt$touchSelectionFirstPress$1;
        Object obj;
        int i;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        try {
            if (continuation instanceof SelectionGesturesKt$touchSelectionFirstPress$1) {
                selectionGesturesKt$touchSelectionFirstPress$1 = (SelectionGesturesKt$touchSelectionFirstPress$1) continuation;
                if ((selectionGesturesKt$touchSelectionFirstPress$1.label & Integer.MIN_VALUE) != 0) {
                    selectionGesturesKt$touchSelectionFirstPress$1.label -= Integer.MIN_VALUE;
                    obj = selectionGesturesKt$touchSelectionFirstPress$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = selectionGesturesKt$touchSelectionFirstPress$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = (PointerInputChange) CollectionsKt.first((List<? extends Object>) pointerEvent.getChanges());
                        long m5311getIdJ3iCeTQ = pointerInputChange.m5311getIdJ3iCeTQ();
                        selectionGesturesKt$touchSelectionFirstPress$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelectionFirstPress$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelectionFirstPress$1.L$2 = pointerInputChange;
                        selectionGesturesKt$touchSelectionFirstPress$1.label = 1;
                        obj = DragGestureDetectorKt.m435awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, m5311getIdJ3iCeTQ, selectionGesturesKt$touchSelectionFirstPress$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        if (i == 2) {
                            textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelectionFirstPress$1.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$touchSelectionFirstPress$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                int size = changes.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    PointerInputChange pointerInputChange3 = changes.get(i2);
                                    if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                        pointerInputChange3.consume();
                                    }
                                }
                                textDragObserver.onStop();
                            } else {
                                textDragObserver.onCancel();
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        PointerInputChange pointerInputChange4 = (PointerInputChange) selectionGesturesKt$touchSelectionFirstPress$1.L$2;
                        textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelectionFirstPress$1.L$1;
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$touchSelectionFirstPress$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = pointerInputChange4;
                        awaitPointerEventScope = awaitPointerEventScope2;
                    }
                    pointerInputChange2 = (PointerInputChange) obj;
                    if (pointerInputChange2 != null && distanceIsTolerable(awaitPointerEventScope.getViewConfiguration(), pointerInputChange, pointerInputChange2)) {
                        textDragObserver.mo1148onStartk4lQ0M(pointerInputChange2.m5313getPositionF1C5BW0());
                        selectionGesturesKt$touchSelectionFirstPress$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelectionFirstPress$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelectionFirstPress$1.L$2 = null;
                        selectionGesturesKt$touchSelectionFirstPress$1.label = 2;
                        obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope, pointerInputChange2.m5311getIdJ3iCeTQ(), new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$dragCompletedWithUp$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange5) {
                                invoke2(pointerInputChange5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange pointerInputChange5) {
                                TextDragObserver.this.mo1147onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange5));
                                pointerInputChange5.consume();
                            }
                        }, selectionGesturesKt$touchSelectionFirstPress$1);
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            pointerInputChange2 = (PointerInputChange) obj;
            if (pointerInputChange2 != null) {
                textDragObserver.mo1148onStartk4lQ0M(pointerInputChange2.m5313getPositionF1C5BW0());
                selectionGesturesKt$touchSelectionFirstPress$1.L$0 = awaitPointerEventScope;
                selectionGesturesKt$touchSelectionFirstPress$1.L$1 = textDragObserver;
                selectionGesturesKt$touchSelectionFirstPress$1.L$2 = null;
                selectionGesturesKt$touchSelectionFirstPress$1.label = 2;
                obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope, pointerInputChange2.m5311getIdJ3iCeTQ(), new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$dragCompletedWithUp$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange5) {
                        invoke2(pointerInputChange5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(PointerInputChange pointerInputChange5) {
                        TextDragObserver.this.mo1147onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange5));
                        pointerInputChange5.consume();
                    }
                }, selectionGesturesKt$touchSelectionFirstPress$1);
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            textDragObserver.onCancel();
            throw e;
        }
        selectionGesturesKt$touchSelectionFirstPress$1 = new SelectionGesturesKt$touchSelectionFirstPress$1(continuation);
        obj = selectionGesturesKt$touchSelectionFirstPress$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$touchSelectionFirstPress$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00de, code lost:
        if (r15 == r1) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6 A[Catch: CancellationException -> 0x0117, TryCatch #1 {CancellationException -> 0x0117, blocks: (B:13:0x0033, B:43:0x00e1, B:45:0x00e9, B:47:0x00fb, B:49:0x0107, B:50:0x010a, B:51:0x010d, B:52:0x0111, B:26:0x00a2, B:28:0x00a6, B:29:0x00a8, B:31:0x00ac, B:33:0x00af, B:35:0x00ba, B:37:0x00c0, B:39:0x00c4, B:40:0x00c9, B:23:0x0064), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac A[Catch: CancellationException -> 0x0117, TryCatch #1 {CancellationException -> 0x0117, blocks: (B:13:0x0033, B:43:0x00e1, B:45:0x00e9, B:47:0x00fb, B:49:0x0107, B:50:0x010a, B:51:0x010d, B:52:0x0111, B:26:0x00a2, B:28:0x00a6, B:29:0x00a8, B:31:0x00ac, B:33:0x00af, B:35:0x00ba, B:37:0x00c0, B:39:0x00c4, B:40:0x00c9, B:23:0x0064), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00af A[Catch: CancellationException -> 0x0117, TryCatch #1 {CancellationException -> 0x0117, blocks: (B:13:0x0033, B:43:0x00e1, B:45:0x00e9, B:47:0x00fb, B:49:0x0107, B:50:0x010a, B:51:0x010d, B:52:0x0111, B:26:0x00a2, B:28:0x00a6, B:29:0x00a8, B:31:0x00ac, B:33:0x00af, B:35:0x00ba, B:37:0x00c0, B:39:0x00c4, B:40:0x00c9, B:23:0x0064), top: B:60:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionSubsequentPress(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$touchSelectionSubsequentPress$1 selectionGesturesKt$touchSelectionSubsequentPress$1;
        int i;
        PointerInputChange pointerInputChange;
        long m5311getIdJ3iCeTQ;
        Ref.LongRef longRef;
        Object withTimeoutOrNull;
        DownResolution downResolution;
        try {
            if (continuation instanceof SelectionGesturesKt$touchSelectionSubsequentPress$1) {
                selectionGesturesKt$touchSelectionSubsequentPress$1 = (SelectionGesturesKt$touchSelectionSubsequentPress$1) continuation;
                if ((selectionGesturesKt$touchSelectionSubsequentPress$1.label & Integer.MIN_VALUE) != 0) {
                    selectionGesturesKt$touchSelectionSubsequentPress$1.label -= Integer.MIN_VALUE;
                    Object obj = selectionGesturesKt$touchSelectionSubsequentPress$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = selectionGesturesKt$touchSelectionSubsequentPress$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = (PointerInputChange) CollectionsKt.first((List<? extends Object>) pointerEvent.getChanges());
                        m5311getIdJ3iCeTQ = pointerInputChange.m5311getIdJ3iCeTQ();
                        longRef = new Ref.LongRef();
                        longRef.element = Offset.Companion.m3852getUnspecifiedF1C5BW0();
                        selectionGesturesKt$touchSelectionSubsequentPress$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelectionSubsequentPress$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelectionSubsequentPress$1.L$2 = pointerInputChange;
                        selectionGesturesKt$touchSelectionSubsequentPress$1.L$3 = longRef;
                        selectionGesturesKt$touchSelectionSubsequentPress$1.J$0 = m5311getIdJ3iCeTQ;
                        selectionGesturesKt$touchSelectionSubsequentPress$1.label = 1;
                        withTimeoutOrNull = awaitPointerEventScope.withTimeoutOrNull(awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis(), new SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(m5311getIdJ3iCeTQ, longRef, null), selectionGesturesKt$touchSelectionSubsequentPress$1);
                        if (withTimeoutOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        if (i == 2) {
                            textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelectionSubsequentPress$1.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$touchSelectionSubsequentPress$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                int size = changes.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    PointerInputChange pointerInputChange2 = changes.get(i2);
                                    if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                        pointerInputChange2.consume();
                                    }
                                }
                                textDragObserver.onStop();
                            } else {
                                textDragObserver.onCancel();
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        long j = selectionGesturesKt$touchSelectionSubsequentPress$1.J$0;
                        Ref.LongRef longRef2 = (Ref.LongRef) selectionGesturesKt$touchSelectionSubsequentPress$1.L$3;
                        pointerInputChange = (PointerInputChange) selectionGesturesKt$touchSelectionSubsequentPress$1.L$2;
                        TextDragObserver textDragObserver2 = (TextDragObserver) selectionGesturesKt$touchSelectionSubsequentPress$1.L$1;
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$touchSelectionSubsequentPress$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            longRef = longRef2;
                            withTimeoutOrNull = obj;
                            m5311getIdJ3iCeTQ = j;
                            textDragObserver = textDragObserver2;
                            awaitPointerEventScope = awaitPointerEventScope2;
                        } catch (CancellationException e) {
                            e = e;
                            textDragObserver = textDragObserver2;
                            textDragObserver.onCancel();
                            throw e;
                        }
                    }
                    downResolution = (DownResolution) withTimeoutOrNull;
                    if (downResolution == null) {
                        downResolution = DownResolution.Timeout;
                    }
                    if (downResolution != DownResolution.Cancel) {
                        return Unit.INSTANCE;
                    }
                    textDragObserver.mo1148onStartk4lQ0M(pointerInputChange.m5313getPositionF1C5BW0());
                    if (downResolution == DownResolution.Up) {
                        textDragObserver.onStop();
                        return Unit.INSTANCE;
                    }
                    if (downResolution == DownResolution.Drag) {
                        textDragObserver.mo1147onDragk4lQ0M(longRef.element);
                    }
                    selectionGesturesKt$touchSelectionSubsequentPress$1.L$0 = awaitPointerEventScope;
                    selectionGesturesKt$touchSelectionSubsequentPress$1.L$1 = textDragObserver;
                    selectionGesturesKt$touchSelectionSubsequentPress$1.L$2 = null;
                    selectionGesturesKt$touchSelectionSubsequentPress$1.L$3 = null;
                    selectionGesturesKt$touchSelectionSubsequentPress$1.label = 2;
                    obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope, m5311getIdJ3iCeTQ, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$dragCompletedWithUp$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3) {
                            invoke2(pointerInputChange3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(PointerInputChange pointerInputChange3) {
                            TextDragObserver.this.mo1147onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange3));
                            pointerInputChange3.consume();
                        }
                    }, selectionGesturesKt$touchSelectionSubsequentPress$1);
                }
            }
            if (i != 0) {
            }
            downResolution = (DownResolution) withTimeoutOrNull;
            if (downResolution == null) {
            }
            if (downResolution != DownResolution.Cancel) {
            }
        } catch (CancellationException e2) {
            e = e2;
        }
        selectionGesturesKt$touchSelectionSubsequentPress$1 = new SelectionGesturesKt$touchSelectionSubsequentPress$1(continuation);
        Object obj2 = selectionGesturesKt$touchSelectionSubsequentPress$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$touchSelectionSubsequentPress$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096 A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:20:0x004f, B:31:0x008e, B:33:0x0096, B:35:0x00a7, B:37:0x00b3, B:28:0x0072), top: B:69:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0136 A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:13:0x0036, B:54:0x0119, B:56:0x0121, B:58:0x0125, B:60:0x0136, B:62:0x0142, B:50:0x00e8), top: B:69:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelectionBtf2(AwaitPointerEventScope awaitPointerEventScope, final MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$mouseSelectionBtf2$1 selectionGesturesKt$mouseSelectionBtf2$1;
        int i;
        final SelectionAdjustment none;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.BooleanRef booleanRef;
        int size;
        try {
            try {
                if (continuation instanceof SelectionGesturesKt$mouseSelectionBtf2$1) {
                    selectionGesturesKt$mouseSelectionBtf2$1 = (SelectionGesturesKt$mouseSelectionBtf2$1) continuation;
                    if ((selectionGesturesKt$mouseSelectionBtf2$1.label & Integer.MIN_VALUE) != 0) {
                        selectionGesturesKt$mouseSelectionBtf2$1.label -= Integer.MIN_VALUE;
                        Object obj = selectionGesturesKt$mouseSelectionBtf2$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = selectionGesturesKt$mouseSelectionBtf2$1.label;
                        int i2 = 0;
                        if (i == 0) {
                            if (i == 1) {
                                mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelectionBtf2$1.L$1;
                                awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$mouseSelectionBtf2$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                if (((Boolean) obj).booleanValue()) {
                                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                    int size2 = changes.size();
                                    while (i2 < size2) {
                                        PointerInputChange pointerInputChange = changes.get(i2);
                                        if (PointerEventKt.changedToUp(pointerInputChange)) {
                                            pointerInputChange.consume();
                                        }
                                        i2++;
                                    }
                                }
                                return Unit.INSTANCE;
                            } else if (i == 2) {
                                booleanRef = (Ref.BooleanRef) selectionGesturesKt$mouseSelectionBtf2$1.L$2;
                                mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelectionBtf2$1.L$1;
                                awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$mouseSelectionBtf2$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                if (((Boolean) obj).booleanValue() && booleanRef.element) {
                                    List<PointerInputChange> changes2 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                    size = changes2.size();
                                    while (i2 < size) {
                                        PointerInputChange pointerInputChange2 = changes2.get(i2);
                                        if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                            pointerInputChange2.consume();
                                        }
                                        i2++;
                                    }
                                }
                                mouseSelectionObserver.onDragDone();
                                return Unit.INSTANCE;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                        ResultKt.throwOnFailure(obj);
                        PointerInputChange pointerInputChange3 = pointerEvent.getChanges().get(0);
                        if (TextFieldSelectionManager_androidKt.isShiftPressed(pointerEvent)) {
                            if (mouseSelectionObserver.mo1389onExtendk4lQ0M(pointerInputChange3.m5313getPositionF1C5BW0())) {
                                pointerInputChange3.consume();
                                selectionGesturesKt$mouseSelectionBtf2$1.L$0 = awaitPointerEventScope;
                                selectionGesturesKt$mouseSelectionBtf2$1.L$1 = mouseSelectionObserver;
                                selectionGesturesKt$mouseSelectionBtf2$1.label = 1;
                                obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope, pointerInputChange3.m5311getIdJ3iCeTQ(), new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$shouldConsumeUp$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange4) {
                                        invoke2(pointerInputChange4);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(PointerInputChange pointerInputChange4) {
                                        if (MouseSelectionObserver.this.mo1390onExtendDragk4lQ0M(pointerInputChange4.m5313getPositionF1C5BW0())) {
                                            pointerInputChange4.consume();
                                        }
                                    }
                                }, selectionGesturesKt$mouseSelectionBtf2$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                if (((Boolean) obj).booleanValue()) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        int clicks = clicksCounter.getClicks();
                        if (clicks == 1) {
                            none = SelectionAdjustment.Companion.getNone();
                        } else if (clicks == 2) {
                            none = SelectionAdjustment.Companion.getWord();
                        } else {
                            none = SelectionAdjustment.Companion.getParagraph();
                        }
                        if (mouseSelectionObserver.mo1391onStart3MmeM6k(pointerInputChange3.m5313getPositionF1C5BW0(), none)) {
                            pointerInputChange3.consume();
                            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                            booleanRef2.element = !Intrinsics.areEqual(none, SelectionAdjustment.Companion.getNone());
                            selectionGesturesKt$mouseSelectionBtf2$1.L$0 = awaitPointerEventScope;
                            selectionGesturesKt$mouseSelectionBtf2$1.L$1 = mouseSelectionObserver;
                            selectionGesturesKt$mouseSelectionBtf2$1.L$2 = booleanRef2;
                            selectionGesturesKt$mouseSelectionBtf2$1.label = 2;
                            obj = DragGestureDetectorKt.m445dragjO51t88(awaitPointerEventScope, pointerInputChange3.m5311getIdJ3iCeTQ(), new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$shouldConsumeUp$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange4) {
                                    invoke2(pointerInputChange4);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(PointerInputChange pointerInputChange4) {
                                    if (MouseSelectionObserver.this.mo1388onDrag3MmeM6k(pointerInputChange4.m5313getPositionF1C5BW0(), none)) {
                                        pointerInputChange4.consume();
                                        booleanRef2.element = true;
                                    }
                                }
                            }, selectionGesturesKt$mouseSelectionBtf2$1);
                            if (obj != coroutine_suspended) {
                                awaitPointerEventScope2 = awaitPointerEventScope;
                                booleanRef = booleanRef2;
                                if (((Boolean) obj).booleanValue()) {
                                    List<PointerInputChange> changes22 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                    size = changes22.size();
                                    while (i2 < size) {
                                    }
                                }
                                mouseSelectionObserver.onDragDone();
                            }
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                if (i == 0) {
                }
            } finally {
            }
        } finally {
        }
        selectionGesturesKt$mouseSelectionBtf2$1 = new SelectionGesturesKt$mouseSelectionBtf2$1(continuation);
        Object obj2 = selectionGesturesKt$mouseSelectionBtf2$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$mouseSelectionBtf2$1.label;
        int i22 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0043 -> B:18:0x0046). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitDown(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerEvent> continuation) {
        SelectionGesturesKt$awaitDown$1 selectionGesturesKt$awaitDown$1;
        int i;
        int size;
        int i2;
        if (continuation instanceof SelectionGesturesKt$awaitDown$1) {
            selectionGesturesKt$awaitDown$1 = (SelectionGesturesKt$awaitDown$1) continuation;
            if ((selectionGesturesKt$awaitDown$1.label & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$awaitDown$1.label -= Integer.MIN_VALUE;
                Object obj = selectionGesturesKt$awaitDown$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = selectionGesturesKt$awaitDown$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerEventPass pointerEventPass = PointerEventPass.Main;
                    selectionGesturesKt$awaitDown$1.L$0 = awaitPointerEventScope;
                    selectionGesturesKt$awaitDown$1.label = 1;
                    obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, selectionGesturesKt$awaitDown$1);
                    if (obj == coroutine_suspended) {
                    }
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    i2 = 0;
                    while (i2 < size) {
                    }
                    return pointerEvent;
                } else if (i == 1) {
                    awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$awaitDown$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                    size = changes2.size();
                    i2 = 0;
                    while (i2 < size) {
                        if (PointerEventKt.changedToDownIgnoreConsumed(changes2.get(i2))) {
                            i2++;
                        } else {
                            PointerEventPass pointerEventPass2 = PointerEventPass.Main;
                            selectionGesturesKt$awaitDown$1.L$0 = awaitPointerEventScope;
                            selectionGesturesKt$awaitDown$1.label = 1;
                            obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, selectionGesturesKt$awaitDown$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            PointerEvent pointerEvent22 = (PointerEvent) obj;
                            List<PointerInputChange> changes22 = pointerEvent22.getChanges();
                            size = changes22.size();
                            i2 = 0;
                            while (i2 < size) {
                            }
                        }
                    }
                    return pointerEvent22;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        selectionGesturesKt$awaitDown$1 = new SelectionGesturesKt$awaitDown$1(continuation);
        Object obj2 = selectionGesturesKt$awaitDown$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$awaitDown$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return Offset.m3835getDistanceimpl(Offset.m3841minusMKHz9U(pointerInputChange.m5313getPositionF1C5BW0(), pointerInputChange2.m5313getPositionF1C5BW0())) < DragGestureDetectorKt.m448pointerSlopE8SPZFQ(viewConfiguration, pointerInputChange.m5316getTypeT8wyACA());
    }

    public static final boolean isPrecisePointer(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (!PointerType.m5384equalsimpl0(changes.get(i).m5316getTypeT8wyACA(), PointerType.Companion.m5389getMouseT8wyACA())) {
                return false;
            }
        }
        return true;
    }
}
