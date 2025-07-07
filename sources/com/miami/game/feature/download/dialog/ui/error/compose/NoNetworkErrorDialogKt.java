package com.miami.game.feature.download.dialog.ui.error.compose;

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
import com.miami.game.core.drawable.resources.R;
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
import kotlin.reflect.KFunction;
/* compiled from: NoNetworkErrorDialog.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"NoNetworkErrorDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "onBackClick", "Lkotlin/Function0;", "onRetry", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NoNetworkErrorDialogScreen", "errorMessage", "", "uiState", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "onConfirm", "onDismiss", "(Ljava/lang/String;Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NoNetworkErrorDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoNetworkErrorDialogRoute$lambda$3(ErrorDialogComponent errorDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NoNetworkErrorDialogRoute(errorDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoNetworkErrorDialogScreen$lambda$4(String str, ErrorDialogUiState errorDialogUiState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NoNetworkErrorDialogScreen(str, errorDialogUiState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NoNetworkErrorDialogRoute(final ErrorDialogComponent component, Function0<Unit> onBackClick, final Function0<Unit> onRetry, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        Composer startRestartGroup = composer.startRestartGroup(1779829502);
        ComposerKt.sourceInformation(startRestartGroup, "C(NoNetworkErrorDialogRoute)34@1557L113,34@1520L150,40@1709L29,44@1819L21,42@1744L182:NoNetworkErrorDialog.kt#d3gn1w");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onRetry) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1779829502, i2, -1, "com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogRoute (NoNetworkErrorDialog.kt:31)");
            }
            SharedEventFlow<ErrorDialogUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NoNetworkErrorDialog.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1(onRetry, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            startRestartGroup = startRestartGroup;
            ErrorDialogUiState NoNetworkErrorDialogRoute$lambda$1 = NoNetworkErrorDialogRoute$lambda$1(FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NoNetworkErrorDialog.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(component);
            NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            function0 = onBackClick;
            NoNetworkErrorDialogScreen(component.getErrorMessage(), NoNetworkErrorDialogRoute$lambda$1, (Function0) ((KFunction) rememberedValue2), function0, startRestartGroup, (i2 << 6) & 7168);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            function0 = onBackClick;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NoNetworkErrorDialogRoute$lambda$3;
                    NoNetworkErrorDialogRoute$lambda$3 = NoNetworkErrorDialogKt.NoNetworkErrorDialogRoute$lambda$3(ErrorDialogComponent.this, function0, onRetry, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NoNetworkErrorDialogRoute$lambda$3;
                }
            });
        }
    }

    public static final void NoNetworkErrorDialogScreen(final String errorMessage, final ErrorDialogUiState uiState, final Function0<Unit> onConfirm, Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-970643010);
        ComposerKt.sourceInformation(startRestartGroup, "C(NoNetworkErrorDialogScreen)P(!1,3)58@2237L643,58@2162L718:NoNetworkErrorDialog.kt#d3gn1w");
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
                ComposerKt.traceEventStart(-970643010, i2, -1, "com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogScreen (NoNetworkErrorDialog.kt:57)");
            }
            DialogFrameKt.DialogFrame(Integer.valueOf(R.drawable.dialog_frame_no_network_background_icon), onDismiss, ComposableLambdaKt.rememberComposableLambda(1984279206, true, new NoNetworkErrorDialogKt$NoNetworkErrorDialogScreen$1(onConfirm), startRestartGroup, 54), startRestartGroup, ((i2 >> 6) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NoNetworkErrorDialogScreen$lambda$4;
                    NoNetworkErrorDialogScreen$lambda$4 = NoNetworkErrorDialogKt.NoNetworkErrorDialogScreen$lambda$4(errorMessage, uiState, onConfirm, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NoNetworkErrorDialogScreen$lambda$4;
                }
            });
        }
    }

    private static final ErrorDialogUiState NoNetworkErrorDialogRoute$lambda$1(State<ErrorDialogUiState> state) {
        return state.getValue();
    }
}
