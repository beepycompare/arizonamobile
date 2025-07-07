package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
/* compiled from: AndroidPredictiveBackAnimatable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$awaitAll$2", f = "AndroidPredictiveBackAnimatable.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class AndroidPredictiveBackAnimatable$awaitAll$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object>[] $actions;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidPredictiveBackAnimatable$awaitAll$2(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>[] function2Arr, Continuation<? super AndroidPredictiveBackAnimatable$awaitAll$2> continuation) {
        super(2, continuation);
        this.$actions = function2Arr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidPredictiveBackAnimatable$awaitAll$2 androidPredictiveBackAnimatable$awaitAll$2 = new AndroidPredictiveBackAnimatable$awaitAll$2(this.$actions, continuation);
        androidPredictiveBackAnimatable$awaitAll$2.L$0 = obj;
        return androidPredictiveBackAnimatable$awaitAll$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidPredictiveBackAnimatable$awaitAll$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Job launch$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Function2<CoroutineScope, Continuation<? super Unit>, Object>[] function2Arr = this.$actions;
            ArrayList arrayList = new ArrayList(function2Arr.length);
            for (Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 : function2Arr) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, function2, 3, null);
                arrayList.add(launch$default);
            }
            this.label = 1;
            if (AwaitKt.joinAll(arrayList, this) == coroutine_suspended) {
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
