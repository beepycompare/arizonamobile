package com.miami.game.feature.download.dialog.ui.error.fromactivity;

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
/* compiled from: ExternalState.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogExternalUiStateHolder;", "", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/download/dialog/ui/error/fromactivity/ErrorDialogExternalUiState;", "getStateStore", "()Lkotlinx/coroutines/flow/MutableStateFlow;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "onPositive", "Lkotlin/Function0;", "", "getOnPositive", "()Lkotlin/jvm/functions/Function0;", "setOnPositive", "(Lkotlin/jvm/functions/Function0;)V", "onNegative", "getOnNegative", "setOnNegative", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorDialogExternalUiStateHolder {
    public static final int $stable;
    public static final ErrorDialogExternalUiStateHolder INSTANCE = new ErrorDialogExternalUiStateHolder();
    private static Function0<Unit> onNegative;
    private static Function0<Unit> onPositive;
    private static final CoroutineScope scope;
    private static final StateFlow<ErrorDialogExternalUiState> state;
    private static final MutableStateFlow<ErrorDialogExternalUiState> stateStore;

    private ErrorDialogExternalUiStateHolder() {
    }

    static {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        scope = CoroutineScope;
        MutableStateFlow<ErrorDialogExternalUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ErrorDialogExternalUiState(null, null, null, null, null, 31, null));
        stateStore = MutableStateFlow;
        state = FlowKt.stateIn(MutableStateFlow, CoroutineScope, SharingStarted.Companion.getEagerly(), new ErrorDialogExternalUiState(null, null, null, null, null, 31, null));
        onPositive = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogExternalUiStateHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
        onNegative = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogExternalUiStateHolder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
        $stable = 8;
    }

    public final MutableStateFlow<ErrorDialogExternalUiState> getStateStore() {
        return stateStore;
    }

    public final StateFlow<ErrorDialogExternalUiState> getState() {
        return state;
    }

    public final Function0<Unit> getOnPositive() {
        return onPositive;
    }

    public final void setOnPositive(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        onPositive = function0;
    }

    public final Function0<Unit> getOnNegative() {
        return onNegative;
    }

    public final void setOnNegative(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        onNegative = function0;
    }
}
