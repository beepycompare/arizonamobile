package com.miami.game.core.design.system.component.scaling_button;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScalingButton.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ScalingButtonKt$ScalingButtonLong$1$1 implements PointerInputEventHandler {
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Function0<Unit> $onLongClick;
    final /* synthetic */ MutableState<Boolean> $selected$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScalingButtonKt$ScalingButtonLong$1$1(Function0<Unit> function0, MutableState<Boolean> mutableState, Function0<Unit> function02) {
        this.$onLongClick = function0;
        this.$selected$delegate = mutableState;
        this.$onClick = function02;
    }

    /* compiled from: ScalingButton.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt$ScalingButtonLong$1$1$2", f = "ScalingButton.kt", i = {}, l = {LockFreeTaskQueueCore.CLOSED_SHIFT}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt$ScalingButtonLong$1$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Boolean> $selected$delegate;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MutableState<Boolean> mutableState, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$selected$delegate = mutableState;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
            return m8319invoked4ec7I(pressGestureScope, offset.m3847unboximpl(), continuation);
        }

        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m8319invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$selected$delegate, continuation);
            anonymousClass2.L$0 = pressGestureScope;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                    ScalingButtonKt.ScalingButtonLong$lambda$11(this.$selected$delegate, true);
                    this.label = 1;
                    if (pressGestureScope.awaitRelease(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                ScalingButtonKt.ScalingButtonLong$lambda$11(this.$selected$delegate, false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ScalingButtonKt.ScalingButtonLong$lambda$11(this.$selected$delegate, false);
                throw th;
            }
        }
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final Function0<Unit> function0 = this.$onLongClick;
        Function1 function1 = new Function1() { // from class: com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt$ScalingButtonLong$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = ScalingButtonKt$ScalingButtonLong$1$1.invoke$lambda$0(Function0.this, (Offset) obj);
                return invoke$lambda$0;
            }
        };
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$selected$delegate, null);
        final Function0<Unit> function02 = this.$onClick;
        Object detectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, function1, anonymousClass2, new Function1() { // from class: com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt$ScalingButtonLong$1$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit invoke$lambda$1;
                invoke$lambda$1 = ScalingButtonKt$ScalingButtonLong$1$1.invoke$lambda$1(Function0.this, (Offset) obj);
                return invoke$lambda$1;
            }
        }, continuation, 1, null);
        return detectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(Function0 function0, Offset offset) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(Function0 function0, Offset offset) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
