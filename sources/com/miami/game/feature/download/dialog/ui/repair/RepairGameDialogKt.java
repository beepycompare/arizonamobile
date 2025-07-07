package com.miami.game.feature.download.dialog.ui.repair;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.design.system.component.dialog_frame.DialogFrameKt;
import com.miami.game.core.ui.utils.extensions.FlowExtensionsKt;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.model.ErrorDialogUiAction;
import com.miami.game.feature.download.dialog.ui.error.model.ErrorDialogUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RepairGameDialog.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\b\u001a9\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"RepairGameDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "onBackClick", "Lkotlin/Function0;", "onConfirm", "onRetry", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RepairGameDialogScreen", "errorMessage", "", "uiState", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "onDismiss", "(Ljava/lang/String;Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepairGameDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameDialogRoute$lambda$2(ErrorDialogComponent errorDialogComponent, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        RepairGameDialogRoute(errorDialogComponent, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameDialogScreen$lambda$3(String str, ErrorDialogUiState errorDialogUiState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        RepairGameDialogScreen(str, errorDialogUiState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void RepairGameDialogRoute(final ErrorDialogComponent component, Function0<Unit> onBackClick, Function0<Unit> onConfirm, final Function0<Unit> onRetry, Composer composer, final int i) {
        int i2;
        Function0<Unit> function0;
        final Function0<Unit> function02;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        Composer startRestartGroup = composer.startRestartGroup(1550967417);
        ComposerKt.sourceInformation(startRestartGroup, "C(RepairGameDialogRoute)39@1907L33,41@2002L113,41@1965L150,47@2154L29,49@2189L166:RepairGameDialog.kt#wxnm6r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onRetry) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1550967417, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogRoute (RepairGameDialog.kt:38)");
            }
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i2 & 112, 1);
            SharedEventFlow<ErrorDialogUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):RepairGameDialog.kt#9igjgp");
            boolean z = (i2 & 7168) == 2048;
            RepairGameDialogKt$RepairGameDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new RepairGameDialogKt$RepairGameDialogRoute$1$1(onRetry, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            startRestartGroup = startRestartGroup;
            function0 = onConfirm;
            RepairGameDialogScreen(component.getErrorMessage(), RepairGameDialogRoute$lambda$1(FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7)), function0, onBackClick, startRestartGroup, (i2 & 896) | ((i2 << 6) & 7168));
            function02 = onBackClick;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            function0 = onConfirm;
            function02 = onBackClick;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0<Unit> function03 = function0;
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameDialogRoute$lambda$2;
                    RepairGameDialogRoute$lambda$2 = RepairGameDialogKt.RepairGameDialogRoute$lambda$2(ErrorDialogComponent.this, function02, function03, onRetry, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameDialogRoute$lambda$2;
                }
            });
        }
    }

    public static final void RepairGameDialogScreen(final String errorMessage, final ErrorDialogUiState uiState, final Function0<Unit> onConfirm, Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(2066583429);
        ComposerKt.sourceInformation(startRestartGroup, "C(RepairGameDialogScreen)P(!1,3)68@2667L564,68@2632L599:RepairGameDialog.kt#wxnm6r");
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 = (startRestartGroup.changedInstance(onConfirm) ? 256 : 128) | i;
        } else {
            i2 = i;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        if ((i2 & 1153) != 1152 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2066583429, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogScreen (RepairGameDialog.kt:67)");
            }
            DialogFrameKt.DialogFrame(null, onDismiss, ComposableLambdaKt.rememberComposableLambda(-1489415267, true, new RepairGameDialogKt$RepairGameDialogScreen$1(onDismiss, onConfirm), startRestartGroup, 54), startRestartGroup, ((i2 >> 6) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            function0 = onDismiss;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            function0 = onDismiss;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameDialogScreen$lambda$3;
                    RepairGameDialogScreen$lambda$3 = RepairGameDialogKt.RepairGameDialogScreen$lambda$3(errorMessage, uiState, onConfirm, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameDialogScreen$lambda$3;
                }
            });
        }
    }

    private static final ErrorDialogUiState RepairGameDialogRoute$lambda$1(State<ErrorDialogUiState> state) {
        return state.getValue();
    }
}
