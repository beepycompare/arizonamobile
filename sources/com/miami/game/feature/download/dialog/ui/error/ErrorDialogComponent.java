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
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: ErrorDialogComponent.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u0002:\u000278B-\b\u0001\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0018H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001f\u001a\u00020 X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010$X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0012\u0010'\u001a\u00020(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u000200X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0012\u00103\u001a\u000204X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "errorMessage", "", "componentContext", "uiAssembler", "Lcom/miami/game/feature/download/dialog/ui/error/map/ErrorDialogUiAssembler;", "resources", "Landroid/content/res/Resources;", "<init>", "(Ljava/lang/String;Lcom/arkivanov/decompose/ComponentContext;Lcom/miami/game/feature/download/dialog/ui/error/map/ErrorDialogUiAssembler;Landroid/content/res/Resources;)V", "getErrorMessage", "()Ljava/lang/String;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogVmState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiAction", "Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiAction;", "getUiAction", "()Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "onRetryFun", "", "emitUiAction", "action", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Companion", "Factory", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦\u0002¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent$Factory;", "", "invoke", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "errorMessage", "", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
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
    public ErrorDialogComponent(@Assisted String errorMessage, @Assisted ComponentContext componentContext, final ErrorDialogUiAssembler uiAssembler, Resources resources) {
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
        final StateFlow asStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.uiState = FlowKt.stateIn(new Flow<ErrorDialogUiState>() { // from class: com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ ErrorDialogUiAssembler receiver$inlined;

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent$special$$inlined$map$1$2", f = "ErrorDialogComponent.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                /* renamed from: com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent$special$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, ErrorDialogUiAssembler errorDialogUiAssembler) {
                    this.$this_unsafeFlow = flowCollector;
                    this.receiver$inlined = errorDialogUiAssembler;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                ErrorDialogUiState assembleUiState = this.receiver$inlined.assembleUiState((CommonDialogVmState) obj);
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(assembleUiState, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                int i2 = anonymousClass1.I$0;
                                FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$3;
                                Object obj3 = anonymousClass1.L$2;
                                AnonymousClass1 anonymousClass12 = (AnonymousClass1) anonymousClass1.L$1;
                                Object obj4 = anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ErrorDialogUiState> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, uiAssembler), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, getScope(), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, null), ErrorDialogUiState.Companion.initial());
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent$Companion;", "", "<init>", "()V", "onRetry", "Lkotlin/Function0;", "", "getOnRetry", "()Lkotlin/jvm/functions/Function0;", "setOnRetry", "(Lkotlin/jvm/functions/Function0;)V", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
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
