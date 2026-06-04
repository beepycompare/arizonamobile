package com.miami.game.feature.download.dialog.ui.error;

import android.content.res.Resources;
import com.arkivanov.decompose.ComponentContext;
import com.arkivanov.decompose.ComponentContextFactory;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import com.miami.game.core.decompose.utils.CoroutineFeature;
import com.miami.game.core.decompose.utils.CoroutineFeatureImpl;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.feature.download.dialog.ui.common.model.CommonDialogVmState;
import com.miami.game.feature.download.dialog.ui.error.map.ErrorDialogUiAssembler;
import com.miami.game.feature.download.dialog.ui.error.model.ErrorDialogUiAction;
import com.miami.game.feature.download.dialog.ui.error.model.ErrorDialogUiState;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: ErrorDialogComponent.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00029:B9\b\u0001\u0012\f\b\u0001\u0010\u0003\u001a\u00020\u0004:\u0002\b\u0005\u0012\f\b\u0001\u0010\u0006\u001a\u00020\u0001:\u0002\b\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u001a\u0002\b\r¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001aH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010!\u001a\u00020\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010&X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020*X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020.X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0012\u00101\u001a\u000202X\u0096\u0005¢\u0006\u0006\u001a\u0004\b3\u00104R\u0012\u00105\u001a\u000206X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u00108Ê\u0001\f\b<\u0012\b\b=\u0012\u0004\b\u0003\u0010\u0000¨\u0006;"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "errorMessage", "", "Ldagger/assisted/Assisted;", "componentContext", "uiAssembler", "Lcom/miami/game/feature/download/dialog/ui/error/map/ErrorDialogUiAssembler;", "resources", "Landroid/content/res/Resources;", "<init>", "(Ljava/lang/String;Lcom/arkivanov/decompose/ComponentContext;Lcom/miami/game/feature/download/dialog/ui/error/map/ErrorDialogUiAssembler;Landroid/content/res/Resources;)V", "Ldagger/assisted/AssistedInject;", "getErrorMessage", "()Ljava/lang/String;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogVmState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiAction", "Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiAction;", "getUiAction", "()Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "onRetryFun", "", "emitUiAction", "action", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Companion", "Factory", "dialogs", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ErrorDialogComponent implements ComponentContext, CoroutineFeature {
    private final /* synthetic */ ComponentContext $$delegate_0;
    private final /* synthetic */ CoroutineFeatureImpl $$delegate_1;
    private final String errorMessage;
    private final Resources resources;
    private final MutableStateFlow<CommonDialogVmState> stateStore;
    private final SharedEventFlow<ErrorDialogUiAction> uiAction;
    private final StateFlow<ErrorDialogUiState> uiState;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static Function0<Unit> onRetry = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Unit unit;
            unit = Unit.INSTANCE;
            return unit;
        }
    };

    /* compiled from: ErrorDialogComponent.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦\u0002Ê\u0001\u0002\b\t¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent$Factory;", "", "invoke", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "errorMessage", "", "dialogs", "Ldagger/assisted/AssistedFactory;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Factory {
        ErrorDialogComponent invoke(ComponentContext componentContext, String str);
    }

    @Override // com.arkivanov.essenty.backhandler.BackHandlerOwner
    public BackHandler getBackHandler() {
        return this.$$delegate_0.getBackHandler();
    }

    @Override // com.arkivanov.decompose.ComponentContextFactoryOwner
    public ComponentContextFactory<ComponentContext> getComponentContextFactory() {
        return this.$$delegate_0.getComponentContextFactory();
    }

    @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeperOwner
    public InstanceKeeper getInstanceKeeper() {
        return this.$$delegate_0.getInstanceKeeper();
    }

    @Override // com.arkivanov.essenty.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.$$delegate_0.getLifecycle();
    }

    @Override // com.miami.game.core.decompose.utils.CoroutineFeature
    public CoroutineScope getScope() {
        return this.$$delegate_1.getScope();
    }

    @Override // com.arkivanov.essenty.statekeeper.StateKeeperOwner
    public StateKeeper getStateKeeper() {
        return this.$$delegate_0.getStateKeeper();
    }

    @AssistedInject
    public ErrorDialogComponent(@Assisted String errorMessage, @Assisted ComponentContext componentContext, ErrorDialogUiAssembler uiAssembler, Resources resources) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        Intrinsics.checkNotNullParameter(uiAssembler, "uiAssembler");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.$$delegate_0 = componentContext;
        this.$$delegate_1 = new CoroutineFeatureImpl(componentContext);
        this.errorMessage = errorMessage;
        this.resources = resources;
        MutableStateFlow<CommonDialogVmState> MutableStateFlow = StateFlowKt.MutableStateFlow(CommonDialogVmState.Companion.initial$default(CommonDialogVmState.Companion, null, 1, null));
        this.stateStore = MutableStateFlow;
        this.uiState = FlowKt.stateIn(new ErrorDialogComponent$special$$inlined$map$1(FlowKt.asStateFlow(MutableStateFlow), uiAssembler), getScope(), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, null), ErrorDialogUiState.Companion.initial());
        this.uiAction = new SharedEventFlow<>();
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final StateFlow<ErrorDialogUiState> getUiState() {
        return this.uiState;
    }

    public final SharedEventFlow<ErrorDialogUiAction> getUiAction() {
        return this.uiAction;
    }

    public final void onRetryFun() {
        onRetry.invoke();
        emitUiAction(ErrorDialogUiAction.Retry.INSTANCE);
    }

    private final void emitUiAction(ErrorDialogUiAction errorDialogUiAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new ErrorDialogComponent$emitUiAction$1(this, errorDialogUiAction, null), 3, null);
    }

    /* compiled from: ErrorDialogComponent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent$Companion;", "", "<init>", "()V", "onRetry", "Lkotlin/Function0;", "", "getOnRetry", "()Lkotlin/jvm/functions/Function0;", "setOnRetry", "(Lkotlin/jvm/functions/Function0;)V", "dialogs"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<Unit> getOnRetry() {
            return ErrorDialogComponent.onRetry;
        }

        public final void setOnRetry(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            ErrorDialogComponent.onRetry = function0;
        }
    }
}
