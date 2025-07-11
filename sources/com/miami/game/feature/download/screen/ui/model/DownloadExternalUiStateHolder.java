package com.miami.game.feature.download.screen.ui.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
/* compiled from: DownloadExternalUiState.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/miami/game/feature/download/screen/ui/model/DownloadExternalUiStateHolder;", "", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/download/screen/ui/model/DownloadExternalUiState;", "getStateStore", "()Lkotlinx/coroutines/flow/MutableStateFlow;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "onStartDownload", "Lkotlin/Function0;", "", "getOnStartDownload", "()Lkotlin/jvm/functions/Function0;", "setOnStartDownload", "(Lkotlin/jvm/functions/Function0;)V", "download-screen_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloadExternalUiStateHolder {
    public static final int $stable;
    public static final DownloadExternalUiStateHolder INSTANCE = new DownloadExternalUiStateHolder();
    private static Function0<Unit> onStartDownload;
    private static final CoroutineScope scope;
    private static final StateFlow<DownloadExternalUiState> state;
    private static final MutableStateFlow<DownloadExternalUiState> stateStore;

    private DownloadExternalUiStateHolder() {
    }

    static {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        scope = CoroutineScope;
        MutableStateFlow<DownloadExternalUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(new DownloadExternalUiState(null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 511, null));
        stateStore = MutableStateFlow;
        state = FlowKt.stateIn(MutableStateFlow, CoroutineScope, SharingStarted.Companion.getEagerly(), new DownloadExternalUiState(null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, false, null, false, false, false, 511, null));
        onStartDownload = new Function0() { // from class: com.miami.game.feature.download.screen.ui.model.DownloadExternalUiStateHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
        $stable = 8;
    }

    public final MutableStateFlow<DownloadExternalUiState> getStateStore() {
        return stateStore;
    }

    public final StateFlow<DownloadExternalUiState> getState() {
        return state;
    }

    public final Function0<Unit> getOnStartDownload() {
        return onStartDownload;
    }

    public final void setOnStartDownload(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        onStartDownload = function0;
    }
}
