package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation;
import com.arkivanov.decompose.router.stack.ChildStack;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: PredictiveBackAnimation.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$Handler$onBackCancelled$1", f = "PredictiveBackAnimation.kt", i = {}, l = {DownloaderService.STATUS_QUEUED_FOR_WIFI}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class PredictiveBackAnimation$Handler$onBackCancelled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PredictiveBackAnimation.Handler<C, T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PredictiveBackAnimation$Handler$onBackCancelled$1(PredictiveBackAnimation.Handler<C, T> handler, Continuation<? super PredictiveBackAnimation$Handler$onBackCancelled$1> continuation) {
        super(2, continuation);
        this.this$0 = handler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PredictiveBackAnimation$Handler$onBackCancelled$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PredictiveBackAnimation$Handler$onBackCancelled$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PredictiveBackAnimatable predictiveBackAnimatable;
        ChildStack childStack;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            predictiveBackAnimatable = ((PredictiveBackAnimation.Handler) this.this$0).animatable;
            if (predictiveBackAnimatable != null) {
                this.label = 1;
                if (predictiveBackAnimatable.cancel(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        ((PredictiveBackAnimation.Handler) this.this$0).animatable = null;
        PredictiveBackAnimation.Handler<C, T> handler = this.this$0;
        childStack = ((PredictiveBackAnimation.Handler) this.this$0).stack;
        i = ((PredictiveBackAnimation.Handler) this.this$0).key;
        handler.setItems(CollectionsKt.listOf(new PredictiveBackAnimation.Item(childStack, i, null, 4, null)));
        return Unit.INSTANCE;
    }
}
