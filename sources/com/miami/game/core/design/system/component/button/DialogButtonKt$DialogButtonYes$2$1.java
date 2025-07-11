package com.miami.game.core.design.system.component.button;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DialogButton.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DialogButtonKt$DialogButtonYes$2$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableState<Boolean> $selected$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogButtonKt$DialogButtonYes$2$1(MutableState<Boolean> mutableState) {
        this.$selected$delegate = mutableState;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        DialogButtonKt$DialogButtonYes$2$1$invoke$1 dialogButtonKt$DialogButtonYes$2$1$invoke$1;
        Object coroutine_suspended;
        int i;
        if (continuation instanceof DialogButtonKt$DialogButtonYes$2$1$invoke$1) {
            dialogButtonKt$DialogButtonYes$2$1$invoke$1 = (DialogButtonKt$DialogButtonYes$2$1$invoke$1) continuation;
            if ((dialogButtonKt$DialogButtonYes$2$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                dialogButtonKt$DialogButtonYes$2$1$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = dialogButtonKt$DialogButtonYes$2$1$invoke$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dialogButtonKt$DialogButtonYes$2$1$invoke$1.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    pointerInputScope = (PointerInputScope) dialogButtonKt$DialogButtonYes$2$1$invoke$1.L$0;
                }
                ResultKt.throwOnFailure(obj);
                do {
                    dialogButtonKt$DialogButtonYes$2$1$invoke$1.L$0 = pointerInputScope;
                    dialogButtonKt$DialogButtonYes$2$1$invoke$1.label = 1;
                } while (pointerInputScope.awaitPointerEventScope(new AnonymousClass1(this.$selected$delegate, null), dialogButtonKt$DialogButtonYes$2$1$invoke$1) != coroutine_suspended);
                return coroutine_suspended;
            }
        }
        dialogButtonKt$DialogButtonYes$2$1$invoke$1 = new DialogButtonKt$DialogButtonYes$2$1$invoke$1(this, continuation);
        Object obj2 = dialogButtonKt$DialogButtonYes$2$1$invoke$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dialogButtonKt$DialogButtonYes$2$1$invoke$1.label;
        if (i != 0) {
        }
        ResultKt.throwOnFailure(obj2);
        do {
            dialogButtonKt$DialogButtonYes$2$1$invoke$1.L$0 = pointerInputScope;
            dialogButtonKt$DialogButtonYes$2$1$invoke$1.label = 1;
        } while (pointerInputScope.awaitPointerEventScope(new AnonymousClass1(this.$selected$delegate, null), dialogButtonKt$DialogButtonYes$2$1$invoke$1) != coroutine_suspended);
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogButton.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.core.design.system.component.button.DialogButtonKt$DialogButtonYes$2$1$1", f = "DialogButton.kt", i = {0, 1}, l = {87, TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0"})
    /* renamed from: com.miami.game.core.design.system.component.button.DialogButtonKt$DialogButtonYes$2$1$1  reason: invalid class name */
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

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
            if (androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r1, false, null, r9, 2, null) == r0) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
            if (androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation$default(r1, null, r9, 1, null) == r0) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    DialogButtonKt.DialogButtonYes$lambda$2(this.$selected$delegate, false);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            DialogButtonKt.DialogButtonYes$lambda$2(this.$selected$delegate, true);
            this.L$0 = SpillingKt.nullOutSpilledVariable(awaitPointerEventScope);
            this.label = 2;
        }
    }
}
