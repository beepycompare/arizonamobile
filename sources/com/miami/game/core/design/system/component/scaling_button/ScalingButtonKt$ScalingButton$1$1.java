package com.miami.game.core.design.system.component.scaling_button;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScalingButton.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ScalingButtonKt$ScalingButton$1$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableState<Boolean> $selected$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScalingButtonKt$ScalingButton$1$1(MutableState<Boolean> mutableState) {
        this.$selected$delegate = mutableState;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        ScalingButtonKt$ScalingButton$1$1$invoke$1 scalingButtonKt$ScalingButton$1$1$invoke$1;
        Object coroutine_suspended;
        int i;
        if (continuation instanceof ScalingButtonKt$ScalingButton$1$1$invoke$1) {
            scalingButtonKt$ScalingButton$1$1$invoke$1 = (ScalingButtonKt$ScalingButton$1$1$invoke$1) continuation;
            if ((scalingButtonKt$ScalingButton$1$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                scalingButtonKt$ScalingButton$1$1$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = scalingButtonKt$ScalingButton$1$1$invoke$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = scalingButtonKt$ScalingButton$1$1$invoke$1.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    pointerInputScope = (PointerInputScope) scalingButtonKt$ScalingButton$1$1$invoke$1.L$0;
                }
                ResultKt.throwOnFailure(obj);
                do {
                    scalingButtonKt$ScalingButton$1$1$invoke$1.L$0 = pointerInputScope;
                    scalingButtonKt$ScalingButton$1$1$invoke$1.label = 1;
                } while (pointerInputScope.awaitPointerEventScope(new AnonymousClass1(this.$selected$delegate, null), scalingButtonKt$ScalingButton$1$1$invoke$1) != coroutine_suspended);
                return coroutine_suspended;
            }
        }
        scalingButtonKt$ScalingButton$1$1$invoke$1 = new ScalingButtonKt$ScalingButton$1$1$invoke$1(this, continuation);
        Object obj2 = scalingButtonKt$ScalingButton$1$1$invoke$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = scalingButtonKt$ScalingButton$1$1$invoke$1.label;
        if (i != 0) {
        }
        ResultKt.throwOnFailure(obj2);
        do {
            scalingButtonKt$ScalingButton$1$1$invoke$1.L$0 = pointerInputScope;
            scalingButtonKt$ScalingButton$1$1$invoke$1.label = 1;
        } while (pointerInputScope.awaitPointerEventScope(new AnonymousClass1(this.$selected$delegate, null), scalingButtonKt$ScalingButton$1$1$invoke$1) != coroutine_suspended);
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalingButton.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt$ScalingButton$1$1$1", f = "ScalingButton.kt", i = {0}, l = {31, 33}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt$ScalingButton$1$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Boolean> $selected$delegate;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$selected$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$selected$delegate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
            if (androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation$default(r1, null, r10, 1, null) == r0) goto L14;
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
                AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope2;
                this.label = 1;
                if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null) != coroutine_suspended) {
                    awaitPointerEventScope = awaitPointerEventScope2;
                }
                return coroutine_suspended;
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    ScalingButtonKt.ScalingButton$lambda$2(this.$selected$delegate, false);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            ScalingButtonKt.ScalingButton$lambda$2(this.$selected$delegate, true);
            this.L$0 = null;
            this.label = 2;
        }
    }
}
