package com.miami.game.core.server;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.reflect.TypeToken;
import com.miami.game.core.local.repository.common.IKeyValueRepository;
import com.miami.game.core.server.model.ServerModel;
import java.lang.reflect.Type;
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
/* compiled from: LocalRepositoryExtensions.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlinx/coroutines/CoroutineScope;", "com/miami/game/core/local/repository/common/LocalRepositoryExtensionsKt$getSuspend$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.local.repository.common.LocalRepositoryExtensionsKt$getSuspend$2", f = "LocalRepositoryExtensions.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class ServersInteractor$getCurrentServer$1$invokeSuspend$$inlined$getSuspend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ServerModel>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ IKeyValueRepository $this_getSuspend;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServersInteractor$getCurrentServer$1$invokeSuspend$$inlined$getSuspend$1(IKeyValueRepository iKeyValueRepository, String str, Continuation continuation) {
        super(2, continuation);
        this.$this_getSuspend = iKeyValueRepository;
        this.$key = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ServersInteractor$getCurrentServer$1$invokeSuspend$$inlined$getSuspend$1(this.$this_getSuspend, this.$key, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ServerModel> continuation) {
        return ((ServersInteractor$getCurrentServer$1$invokeSuspend$$inlined$getSuspend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
        IKeyValueRepository iKeyValueRepository = this.$this_getSuspend;
        String str = this.$key;
        Type type = new TypeToken<ServerModel>() { // from class: com.miami.game.core.server.ServersInteractor$getCurrentServer$1$invokeSuspend$$inlined$getSuspend$1.1
        }.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        this.label = 1;
        Object obj2 = iKeyValueRepository.get(str, type, this);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
