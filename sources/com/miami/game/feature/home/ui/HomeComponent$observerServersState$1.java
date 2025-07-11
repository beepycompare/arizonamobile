package com.miami.game.feature.home.ui;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.server.model.ServersState;
import com.miami.game.feature.home.ui.model.HomeUiAction;
import com.miami.game.feature.home.ui.model.HomeUiState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/miami/game/core/server/model/ServersState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.home.ui.HomeComponent$observerServersState$1", f = "HomeComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class HomeComponent$observerServersState$1 extends SuspendLambda implements Function2<ServersState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HomeComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeComponent$observerServersState$1(HomeComponent homeComponent, Continuation<? super HomeComponent$observerServersState$1> continuation) {
        super(2, continuation);
        this.this$0 = homeComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeComponent$observerServersState$1 homeComponent$observerServersState$1 = new HomeComponent$observerServersState$1(this.this$0, continuation);
        homeComponent$observerServersState$1.L$0 = obj;
        return homeComponent$observerServersState$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ServersState serversState, Continuation<? super Unit> continuation) {
        return ((HomeComponent$observerServersState$1) create(serversState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        ServersState serversState = (ServersState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.stateStore;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, HomeUiState.copy$default((HomeUiState) value, 0, false, null, null, serversState.getCurrentServer(), null, null, null, null, null, null, false, false, false, serversState.getXDonate(), false, false, false, 245743, null)));
            if (serversState.isError()) {
                this.this$0.emitUiAction(HomeUiAction.NavigateToErrorDialog.INSTANCE);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
