package com.miami.game.core.server;

import com.miami.game.core.local.repository.common.IKeyValueRepository;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.server.model.ServerModel;
import com.miami.game.core.server.model.ServersState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import okhttp3.internal.ws.WebSocketProtocol;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServersInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.server.ServersInteractor$getCurrentServerLocal$1", f = "ServersInteractor.kt", i = {0, 0, 0}, l = {364}, m = "invokeSuspend", n = {"$this$getSuspend$iv", "key$iv", "$i$f$getSuspend"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes4.dex */
public final class ServersInteractor$getCurrentServerLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ServerModel> $list;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ServersInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServersInteractor$getCurrentServerLocal$1(ServersInteractor serversInteractor, List<ServerModel> list, Continuation<? super ServersInteractor$getCurrentServerLocal$1> continuation) {
        super(2, continuation);
        this.this$0 = serversInteractor;
        this.$list = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ServersInteractor$getCurrentServerLocal$1(this.this$0, this.$list, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ServersInteractor$getCurrentServerLocal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocalRepository localRepository;
        MutableStateFlow mutableStateFlow;
        Object value;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            localRepository = this.this$0.localRepository;
            LocalRepository localRepository2 = localRepository;
            this.L$0 = SpillingKt.nullOutSpilledVariable(localRepository2);
            this.L$1 = SpillingKt.nullOutSpilledVariable(ServersInteractor.CURRENT_SERVER_KEY);
            this.I$0 = 0;
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new ServersInteractor$getCurrentServerLocal$1$invokeSuspend$$inlined$getSuspend$1(localRepository2, ServersInteractor.CURRENT_SERVER_KEY, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            String str = (String) this.L$1;
            IKeyValueRepository iKeyValueRepository = (IKeyValueRepository) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ServerModel serverModel = (ServerModel) obj;
        if (serverModel != null) {
            mutableStateFlow = this.this$0.stateStore;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ServersState.copy$default((ServersState) value, serverModel, null, null, null, null, false, 0, WebSocketProtocol.PAYLOAD_SHORT, null)));
        } else {
            ServerModel serverModel2 = (ServerModel) CollectionsKt.firstOrNull((List<? extends Object>) this.$list);
            if (serverModel2 != null) {
                mutableStateFlow2 = this.this$0.stateStore;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, ServersState.copy$default((ServersState) value2, serverModel2, null, null, null, null, false, 0, WebSocketProtocol.PAYLOAD_SHORT, null)));
            }
        }
        return Unit.INSTANCE;
    }
}
