package ru.mrlargha.arizonaui.ghetto;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.arizonaui.ghetto.data.CaptureData;
/* compiled from: GhettoScreen.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lru/mrlargha/arizonaui/ghetto/data/CaptureData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.ghetto.GhettoScreen$requestCaptures$1$contextList$1", f = "GhettoScreen.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GhettoScreen$requestCaptures$1$contextList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends CaptureData>>, Object> {
    int label;
    final /* synthetic */ GhettoScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GhettoScreen$requestCaptures$1$contextList$1(GhettoScreen ghettoScreen, Continuation<? super GhettoScreen$requestCaptures$1$contextList$1> continuation) {
        super(2, continuation);
        this.this$0 = ghettoScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GhettoScreen$requestCaptures$1$contextList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends CaptureData>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<CaptureData>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<CaptureData>> continuation) {
        return ((GhettoScreen$requestCaptures$1$contextList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GhettoApi ghettoApi;
        int i;
        String token;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ghettoApi = this.this$0.api;
        if (ghettoApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("api");
            ghettoApi = null;
        }
        i = this.this$0.serverId;
        token = this.this$0.getToken();
        this.label = 1;
        Object captures$default = GhettoApi.getCaptures$default(ghettoApi, token, null, i, this, 2, null);
        return captures$default == coroutine_suspended ? coroutine_suspended : captures$default;
    }
}
