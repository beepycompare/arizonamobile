package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.animation.core.Animatable;
import com.arkivanov.essenty.backhandler.BackEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: AndroidPredictiveBackAnimatable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$animate$3", f = "AndroidPredictiveBackAnimatable.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class AndroidPredictiveBackAnimatable$animate$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BackEvent $event;
    int label;
    final /* synthetic */ AndroidPredictiveBackAnimatable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidPredictiveBackAnimatable$animate$3(AndroidPredictiveBackAnimatable androidPredictiveBackAnimatable, BackEvent backEvent, Continuation<? super AndroidPredictiveBackAnimatable$animate$3> continuation) {
        super(2, continuation);
        this.this$0 = androidPredictiveBackAnimatable;
        this.$event = backEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidPredictiveBackAnimatable$animate$3(this.this$0, this.$event, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidPredictiveBackAnimatable$animate$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Animatable animatable;
        float enterProgress;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            animatable = this.this$0.enterProgressAnimatable;
            enterProgress = this.this$0.enterProgress(this.$event.getProgress());
            this.label = 1;
            if (Animatable.animateTo$default(animatable, Boxing.boxFloat(enterProgress), null, null, null, this, 14, null) == coroutine_suspended) {
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
