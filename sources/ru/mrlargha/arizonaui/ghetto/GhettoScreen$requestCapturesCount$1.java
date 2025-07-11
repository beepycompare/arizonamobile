package ru.mrlargha.arizonaui.ghetto;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.arizonaui.ghetto.data.CaptureCount;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GhettoScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.ghetto.GhettoScreen$requestCapturesCount$1", f = "GhettoScreen.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class GhettoScreen$requestCapturesCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $fraction;
    int label;
    final /* synthetic */ GhettoScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GhettoScreen$requestCapturesCount$1(GhettoScreen ghettoScreen, int i, Continuation<? super GhettoScreen$requestCapturesCount$1> continuation) {
        super(2, continuation);
        this.this$0 = ghettoScreen;
        this.$fraction = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GhettoScreen$requestCapturesCount$1(this.this$0, this.$fraction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GhettoScreen$requestCapturesCount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WarsAdapter warsAdapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new GhettoScreen$requestCapturesCount$1$contextList$1(this.this$0, this.$fraction, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        warsAdapter = this.this$0.warsAdapter;
        warsAdapter.setInfoCount(((CaptureCount) obj).getCount());
        return Unit.INSTANCE;
    }
}
