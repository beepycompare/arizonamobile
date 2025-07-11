package com.miami.game.feature.settings.ui.compose;

import com.miami.game.feature.settings.ui.SettingsComponent;
import com.miami.game.feature.settings.ui.model.SettingsUiAction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;
/* compiled from: SettingsScreen.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "uiAction", "Lcom/miami/game/feature/settings/ui/model/SettingsUiAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.feature.settings.ui.compose.SettingsScreenKt$SettingsRoute$1$1", f = "SettingsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class SettingsScreenKt$SettingsRoute$1$1 extends SuspendLambda implements Function3<CoroutineScope, SettingsUiAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ SettingsComponent $component;
    final /* synthetic */ Function1<Function0<Unit>, Unit> $onRepairGameDialog;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsScreenKt$SettingsRoute$1$1(Function1<? super Function0<Unit>, Unit> function1, SettingsComponent settingsComponent, Continuation<? super SettingsScreenKt$SettingsRoute$1$1> continuation) {
        super(3, continuation);
        this.$onRepairGameDialog = function1;
        this.$component = settingsComponent;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, SettingsUiAction settingsUiAction, Continuation<? super Unit> continuation) {
        SettingsScreenKt$SettingsRoute$1$1 settingsScreenKt$SettingsRoute$1$1 = new SettingsScreenKt$SettingsRoute$1$1(this.$onRepairGameDialog, this.$component, continuation);
        settingsScreenKt$SettingsRoute$1$1.L$0 = settingsUiAction;
        return settingsScreenKt$SettingsRoute$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SettingsUiAction settingsUiAction = (SettingsUiAction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!Intrinsics.areEqual(settingsUiAction, SettingsUiAction.RepairGameDialog.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        Timber.Forest.d("repairGame", new Object[0]);
        Function1<Function0<Unit>, Unit> function1 = this.$onRepairGameDialog;
        final SettingsComponent settingsComponent = this.$component;
        function1.invoke(new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsScreenKt$SettingsRoute$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = SettingsScreenKt$SettingsRoute$1$1.invokeSuspend$lambda$0(SettingsComponent.this);
                return invokeSuspend$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(SettingsComponent settingsComponent) {
        settingsComponent.onRepairGameStart();
        return Unit.INSTANCE;
    }
}
