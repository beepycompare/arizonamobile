package com.miami.game.core.server;

import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.server.model.ServerModel;
import com.miami.game.core.server.model.ServersState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import okhttp3.internal.ws.WebSocketProtocol;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServersInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.server.ServersInteractor$selectServer$1", f = "ServersInteractor.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class ServersInteractor$selectServer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ServerModel $serverModel;
    int label;
    final /* synthetic */ ServersInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServersInteractor$selectServer$1(ServersInteractor serversInteractor, ServerModel serverModel, Continuation<? super ServersInteractor$selectServer$1> continuation) {
        super(2, continuation);
        this.this$0 = serversInteractor;
        this.$serverModel = serverModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ServersInteractor$selectServer$1(this.this$0, this.$serverModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ServersInteractor$selectServer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocalRepository localRepository;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            localRepository = this.this$0.localRepository;
            this.label = 1;
            if (localRepository.save2(ServersInteractor.CURRENT_SERVER_KEY, (String) this.$serverModel, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        mutableStateFlow = this.this$0.stateStore;
        ServerModel serverModel = this.$serverModel;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default((ServersState) value, serverModel, null, null, null, null, false, 0, WebSocketProtocol.PAYLOAD_SHORT, null)));
        return Unit.INSTANCE;
    }
}
