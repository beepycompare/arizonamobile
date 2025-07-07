package com.miami.game.feature.home.ui.model;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: HomeExternalUiState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/miami/game/feature/home/ui/model/HomeExternalUiStateHolder;", "", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "homeStateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/home/ui/model/HomeExternalUiState;", "getHomeStateStore", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "homeState", "Lkotlinx/coroutines/flow/StateFlow;", "getHomeState", "()Lkotlinx/coroutines/flow/StateFlow;", "home_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeExternalUiStateHolder {
    public static final int $stable;
    public static final HomeExternalUiStateHolder INSTANCE = new HomeExternalUiStateHolder();
    private static final StateFlow<HomeExternalUiState> homeState;
    private static final MutableStateFlow<HomeExternalUiState> homeStateStore;
    private static final CoroutineScope scope;

    private HomeExternalUiStateHolder() {
    }

    static {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        scope = CoroutineScope;
        MutableStateFlow<HomeExternalUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(new HomeExternalUiState(false, null, null, false, false, false, 63, null));
        homeStateStore = MutableStateFlow;
        homeState = FlowKt.stateIn(MutableStateFlow, CoroutineScope, SharingStarted.Companion.getEagerly(), new HomeExternalUiState(false, null, null, false, false, false, 63, null));
        $stable = 8;
    }

    public final MutableStateFlow<HomeExternalUiState> getHomeStateStore() {
        return homeStateStore;
    }

    public final StateFlow<HomeExternalUiState> getHomeState() {
        return homeState;
    }
}
