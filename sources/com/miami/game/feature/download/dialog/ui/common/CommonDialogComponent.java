package com.miami.game.feature.download.dialog.ui.common;

import android.content.res.Resources;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.arkivanov.decompose.ComponentContext;
import com.arkivanov.decompose.ComponentContextFactory;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.decompose.utils.CoroutineFeature;
import com.miami.game.core.decompose.utils.CoroutineFeatureImpl;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.external.navigation.model.ExternalNavigationAction;
import com.miami.game.core.privacy.privacyInteractor;
import com.miami.game.core.ui.utils.extensions.ExtensionsBrowseKt;
import com.miami.game.feature.download.dialog.ui.common.model.CommonDialogUiAction;
import com.miami.game.feature.download.dialog.ui.common.model.CommonDialogUiState;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import timber.log.Timber;
/* compiled from: CommonDialogComponent.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001@B5\b\u0001\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020 J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0019H\u0002J\u0006\u0010%\u001a\u00020 J\u0006\u0010&\u001a\u00020 J\u0010\u0010'\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001dH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0012\u0010(\u001a\u00020)X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010-X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0012\u00100\u001a\u000201X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u0012\u00104\u001a\u000205X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107R\u0012\u00108\u001a\u000209X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0012\u0010<\u001a\u00020=X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "componentContext", "description", "", "resources", "Landroid/content/res/Resources;", "buildConfig", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "privacyInteractor", "Lcom/miami/game/core/privacy/privacyInteractor;", "<init>", "(Lcom/arkivanov/decompose/ComponentContext;Ljava/lang/String;Landroid/content/res/Resources;Lcom/miami/game/core/build/config/BuildConfigRepository;Lcom/miami/game/core/privacy/privacyInteractor;)V", "getDescription", "()Ljava/lang/String;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiAction", "Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiAction;", "getUiAction", "()Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "externalNavigationAction", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "getExternalNavigationAction", "onConfirm", "", "onAccept", "onDismiss", "emitUiAction", "action", "openPolicy", "openTerms", "emitExternalNavigationAction", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Factory", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CommonDialogComponent implements ComponentContext, CoroutineFeature {
    public static final int $stable = 8;
    private final /* synthetic */ ComponentContext $$delegate_0;
    private final /* synthetic */ CoroutineFeatureImpl $$delegate_1;
    private final BuildConfigRepository buildConfig;
    private final String description;
    private final SharedEventFlow<ExternalNavigationAction> externalNavigationAction;
    private final privacyInteractor privacyInteractor;
    private final Resources resources;
    private final MutableStateFlow<CommonDialogUiState> stateStore;
    private final SharedEventFlow<CommonDialogUiAction> uiAction;
    private final StateFlow<CommonDialogUiState> uiState;

    /* compiled from: CommonDialogComponent.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦\u0002¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent$Factory;", "", "invoke", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "description", "", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Factory {
        CommonDialogComponent invoke(ComponentContext componentContext, String str);
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
    public CommonDialogComponent(@Assisted ComponentContext componentContext, @Assisted String description, Resources resources, BuildConfigRepository buildConfig, privacyInteractor privacyInteractor) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(buildConfig, "buildConfig");
        Intrinsics.checkNotNullParameter(privacyInteractor, "privacyInteractor");
        this.$$delegate_0 = componentContext;
        this.$$delegate_1 = new CoroutineFeatureImpl(componentContext);
        this.description = description;
        this.resources = resources;
        this.buildConfig = buildConfig;
        this.privacyInteractor = privacyInteractor;
        MutableStateFlow<CommonDialogUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(CommonDialogUiState.Companion.initial(buildConfig.isArizona(), description));
        this.stateStore = MutableStateFlow;
        this.uiState = FlowKt.stateIn(FlowKt.asStateFlow(MutableStateFlow), getScope(), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, null), CommonDialogUiState.Companion.initial(buildConfig.isArizona(), description));
        this.uiAction = new SharedEventFlow<>();
        this.externalNavigationAction = new SharedEventFlow<>();
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    public final String getDescription() {
        return this.description;
    }

    public final StateFlow<CommonDialogUiState> getUiState() {
        return this.uiState;
    }

    public final SharedEventFlow<CommonDialogUiAction> getUiAction() {
        return this.uiAction;
    }

    public final SharedEventFlow<ExternalNavigationAction> getExternalNavigationAction() {
        return this.externalNavigationAction;
    }

    /* compiled from: CommonDialogComponent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent$1", f = "CommonDialogComponent.kt", i = {0, 0, 0, 0, 0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "invokeSuspend", n = {"$this$update$iv", "prevValue$iv", "it", "$i$f$update", "$i$a$-update-CommonDialogComponent$1$1"}, s = {"L$0", "L$2", "L$3", "I$0", "I$1"})
    /* renamed from: com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x006d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x006e -> B:6:0x002d). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            CommonDialogComponent commonDialogComponent;
            int i;
            MutableStateFlow mutableStateFlow2;
            Object isPrivacyAccepted;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = CommonDialogComponent.this.stateStore;
                commonDialogComponent = CommonDialogComponent.this;
                i = 0;
                mutableStateFlow2 = mutableStateFlow;
                Object value = mutableStateFlow2.getValue();
                CommonDialogUiState commonDialogUiState = (CommonDialogUiState) value;
                privacyInteractor privacyinteractor = commonDialogComponent.privacyInteractor;
                this.L$0 = mutableStateFlow2;
                this.L$1 = commonDialogComponent;
                this.L$2 = value;
                this.L$3 = SpillingKt.nullOutSpilledVariable(commonDialogUiState);
                this.L$4 = commonDialogUiState;
                this.I$0 = i;
                this.I$1 = 0;
                this.I$2 = 0;
                this.label = 1;
                isPrivacyAccepted = privacyinteractor.isPrivacyAccepted(this);
                if (isPrivacyAccepted != coroutine_suspended) {
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                int i3 = this.I$2;
                int i4 = this.I$0;
                CommonDialogUiState commonDialogUiState2 = (CommonDialogUiState) this.L$3;
                Object obj2 = this.L$2;
                commonDialogComponent = (CommonDialogComponent) this.L$1;
                mutableStateFlow2 = (MutableStateFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
                Object obj3 = obj2;
                CommonDialogUiState commonDialogUiState3 = (CommonDialogUiState) this.L$4;
                int i5 = i4;
                int i6 = i3;
                isPrivacyAccepted = obj;
                CommonDialogComponent commonDialogComponent2 = commonDialogComponent;
                boolean z = i6 == 0;
                boolean booleanValue = ((Boolean) isPrivacyAccepted).booleanValue();
                mutableStateFlow = mutableStateFlow2;
                if (!mutableStateFlow.compareAndSet(obj3, CommonDialogUiState.copy$default(commonDialogUiState3, z, booleanValue, null, null, null, 29, null))) {
                    return Unit.INSTANCE;
                }
                i = i5;
                commonDialogComponent = commonDialogComponent2;
                mutableStateFlow2 = mutableStateFlow;
                Object value2 = mutableStateFlow2.getValue();
                CommonDialogUiState commonDialogUiState4 = (CommonDialogUiState) value2;
                privacyInteractor privacyinteractor2 = commonDialogComponent.privacyInteractor;
                this.L$0 = mutableStateFlow2;
                this.L$1 = commonDialogComponent;
                this.L$2 = value2;
                this.L$3 = SpillingKt.nullOutSpilledVariable(commonDialogUiState4);
                this.L$4 = commonDialogUiState4;
                this.I$0 = i;
                this.I$1 = 0;
                this.I$2 = 0;
                this.label = 1;
                isPrivacyAccepted = privacyinteractor2.isPrivacyAccepted(this);
                if (isPrivacyAccepted != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj3 = value2;
                commonDialogUiState3 = commonDialogUiState4;
                i5 = i;
                i6 = 0;
                CommonDialogComponent commonDialogComponent22 = commonDialogComponent;
                if (i6 == 0) {
                }
                boolean booleanValue2 = ((Boolean) isPrivacyAccepted).booleanValue();
                mutableStateFlow = mutableStateFlow2;
                if (!mutableStateFlow.compareAndSet(obj3, CommonDialogUiState.copy$default(commonDialogUiState3, z, booleanValue2, null, null, null, 29, null))) {
                }
            }
        }
    }

    public final void onConfirm() {
        Timber.Forest.d("onConfirm", new Object[0]);
        emitUiAction(CommonDialogUiAction.Confirm.INSTANCE);
    }

    public final void onAccept() {
        this.privacyInteractor.acceptPrivacy();
    }

    public final void onDismiss() {
        Timber.Forest.d("onDismiss", new Object[0]);
        emitUiAction(CommonDialogUiAction.Cancel.INSTANCE);
    }

    private final void emitUiAction(CommonDialogUiAction commonDialogUiAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new CommonDialogComponent$emitUiAction$1(this, commonDialogUiAction, null), 3, null);
    }

    public final void openPolicy() {
        Uri uriOrNull = ExtensionsBrowseKt.toUriOrNull(this.uiState.getValue().getPolicyLink());
        if (uriOrNull == null) {
            return;
        }
        emitExternalNavigationAction(new ExternalNavigationAction.OpenUri(uriOrNull));
    }

    public final void openTerms() {
        Uri uriOrNull = ExtensionsBrowseKt.toUriOrNull(this.uiState.getValue().getTermsLink());
        if (uriOrNull == null) {
            return;
        }
        emitExternalNavigationAction(new ExternalNavigationAction.OpenUri(uriOrNull));
    }

    private final void emitExternalNavigationAction(ExternalNavigationAction externalNavigationAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new CommonDialogComponent$emitExternalNavigationAction$1(this, externalNavigationAction, null), 3, null);
    }
}
