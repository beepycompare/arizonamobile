package ru.mrlargha.arizonaui.ghetto;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.arizonaui.ghetto.data.CaptureCount;
/* compiled from: GhettoScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lru/mrlargha/arizonaui/ghetto/data/CaptureCount;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.ghetto.GhettoScreen$requestCapturesCount$1$contextList$1", f = "GhettoScreen.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes5.dex */
final class GhettoScreen$requestCapturesCount$1$contextList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CaptureCount>, Object> {
    final /* synthetic */ int $fraction;
    int label;
    final /* synthetic */ GhettoScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GhettoScreen$requestCapturesCount$1$contextList$1(GhettoScreen ghettoScreen, int i, Continuation<? super GhettoScreen$requestCapturesCount$1$contextList$1> continuation) {
        super(2, continuation);
        this.this$0 = ghettoScreen;
        this.$fraction = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GhettoScreen$requestCapturesCount$1$contextList$1(this.this$0, this.$fraction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CaptureCount> continuation) {
        return ((GhettoScreen$requestCapturesCount$1$contextList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GhettoApi ghettoApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ghettoApi = this.this$0.api;
        this.label = 1;
        Object captureCount = ghettoApi.getCaptureCount(this.$fraction, this);
        return captureCount == coroutine_suspended ? coroutine_suspended : captureCount;
    }
}
