package com.miami.game.feature.select.server.ui;

import com.miami.game.core.server.model.ServerModel;
import com.miami.game.core.server.model.ServerStateCategory;
import com.miami.game.core.server.model.ServersState;
import com.miami.game.feature.select.server.ui.model.SelectServerUiState;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectServerComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "serverState", "Lcom/miami/game/core/server/model/ServersState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.select.server.ui.SelectServerComponent$observeServerState$1", f = "SelectServerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SelectServerComponent$observeServerState$1 extends SuspendLambda implements Function2<ServersState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SelectServerComponent this$0;

    /* compiled from: SelectServerComponent.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServerStateCategory.values().length];
            try {
                iArr[ServerStateCategory.Mobile.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ServerStateCategory.Desktop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ServerStateCategory.Favorite.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectServerComponent$observeServerState$1(SelectServerComponent selectServerComponent, Continuation<? super SelectServerComponent$observeServerState$1> continuation) {
        super(2, continuation);
        this.this$0 = selectServerComponent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectServerComponent$observeServerState$1 selectServerComponent$observeServerState$1 = new SelectServerComponent$observeServerState$1(this.this$0, continuation);
        selectServerComponent$observeServerState$1.L$0 = obj;
        return selectServerComponent$observeServerState$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ServersState serversState, Continuation<? super Unit> continuation) {
        return ((SelectServerComponent$observeServerState$1) create(serversState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        SelectServerUiState selectServerUiState;
        List<ServerModel> serverListMobile;
        ServersState serversState = (ServersState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.stateStore;
            do {
                value = mutableStateFlow.getValue();
                selectServerUiState = (SelectServerUiState) value;
                int i = WhenMappings.$EnumSwitchMapping$0[serversState.getSelectedCategory().ordinal()];
                if (i == 1) {
                    serverListMobile = serversState.getServerListMobile();
                } else if (i == 2) {
                    serverListMobile = serversState.getServerListDesktop();
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    serverListMobile = serversState.getServerListFavorite();
                }
            } while (!mutableStateFlow.compareAndSet(value, SelectServerUiState.copy$default(selectServerUiState, serversState.getCurrentServer(), serverListMobile, serversState.getSelectedCategory(), false, 0, false, 56, null)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
