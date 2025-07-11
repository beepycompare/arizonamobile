package com.miami.game.core.decompose.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: CoroutineFeatureExtensions.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 176)
@DebugMetadata(c = "com.miami.game.core.decompose.utils.CoroutineFeatureExtensionsKt$launchSafe$1", f = "CoroutineFeatureExtensions.kt", i = {0, 1, 1}, l = {20, 22}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "exception"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes4.dex */
public final class CoroutineFeatureExtensionsKt$launchSafe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Function2<Exception, Continuation<? super Unit>, Object> $errorHandler;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineFeatureExtensionsKt$launchSafe$1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super Exception, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super CoroutineFeatureExtensionsKt$launchSafe$1> continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$errorHandler = function22;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoroutineFeatureExtensionsKt$launchSafe$1 coroutineFeatureExtensionsKt$launchSafe$1 = new CoroutineFeatureExtensionsKt$launchSafe$1(this.$block, this.$errorHandler, continuation);
        coroutineFeatureExtensionsKt$launchSafe$1.L$0 = obj;
        return coroutineFeatureExtensionsKt$launchSafe$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineFeatureExtensionsKt$launchSafe$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.invoke(r0, r5) == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r2.invoke(r6, r5) != r1) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            Function2<Exception, Continuation<? super Unit>, Object> function2 = this.$errorHandler;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(e);
            this.label = 2;
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function22 = this.$block;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.label = 1;
        } else if (i != 1) {
            if (i == 2) {
                Exception exc = (Exception) this.L$1;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        try {
            this.$block.invoke((CoroutineScope) this.L$0, this);
        } catch (Exception e) {
            this.$errorHandler.invoke(e, this);
        }
        return Unit.INSTANCE;
    }
}
