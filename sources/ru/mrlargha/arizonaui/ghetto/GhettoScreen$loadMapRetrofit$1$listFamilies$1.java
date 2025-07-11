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
import ru.mrlargha.arizonaui.ghetto.data.MapData;
/* compiled from: GhettoScreen.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lru/mrlargha/arizonaui/ghetto/data/MapData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.ghetto.GhettoScreen$loadMapRetrofit$1$listFamilies$1", f = "GhettoScreen.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GhettoScreen$loadMapRetrofit$1$listFamilies$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MapData>>, Object> {
    int label;
    final /* synthetic */ GhettoScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GhettoScreen$loadMapRetrofit$1$listFamilies$1(GhettoScreen ghettoScreen, Continuation<? super GhettoScreen$loadMapRetrofit$1$listFamilies$1> continuation) {
        super(2, continuation);
        this.this$0 = ghettoScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GhettoScreen$loadMapRetrofit$1$listFamilies$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MapData>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<MapData>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<MapData>> continuation) {
        return ((GhettoScreen$loadMapRetrofit$1$listFamilies$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GhettoApi ghettoApi;
        String token;
        int i;
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
        token = this.this$0.getToken();
        i = this.this$0.serverId;
        this.label = 1;
        Object map$default = GhettoApi.getMap$default(ghettoApi, token, null, i, this, 2, null);
        return map$default == coroutine_suspended ? coroutine_suspended : map$default;
    }
}
