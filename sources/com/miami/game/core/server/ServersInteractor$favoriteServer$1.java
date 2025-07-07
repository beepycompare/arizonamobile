package com.miami.game.core.server;

import com.miami.game.core.server.data.FavoriteServerDatabase;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.server.ServersInteractor$favoriteServer$1", f = "ServersInteractor.kt", i = {}, l = {162, 166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class ServersInteractor$favoriteServer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ServerModel $serverModel;
    int label;
    final /* synthetic */ ServersInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServersInteractor$favoriteServer$1(ServerModel serverModel, ServersInteractor serversInteractor, Continuation<? super ServersInteractor$favoriteServer$1> continuation) {
        super(2, continuation);
        this.$serverModel = serverModel;
        this.this$0 = serversInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ServersInteractor$favoriteServer$1(this.$serverModel, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ServersInteractor$favoriteServer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (r12.favoriteServerDAO().addFavorite(com.miami.game.core.server.data.FavoriteServerEntityKt.toFavoriteEntity(r11.$serverModel), r11) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
        if (r12.favoriteServerDAO().removeFromFavorite(com.miami.game.core.server.data.FavoriteServerEntityKt.toFavoriteEntity(r11.$serverModel), r11) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FavoriteServerDatabase favoriteServerDatabase;
        FavoriteServerDatabase favoriteServerDatabase2;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$serverModel.isFavorite()) {
                favoriteServerDatabase2 = this.this$0.favoriteServerDatabase;
                this.label = 1;
            } else {
                favoriteServerDatabase = this.this$0.favoriteServerDatabase;
                this.label = 2;
            }
        } else if (i != 1 && i != 2) {
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
