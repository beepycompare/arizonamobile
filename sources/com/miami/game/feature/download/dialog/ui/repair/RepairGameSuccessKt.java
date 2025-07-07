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
import com.miami.game.core.drawable.resources.R;
import com.miami.game.core.ui.utils.extensions.FlowExtensionsKt;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
import com.miami.game.feature.download.dialog.ui.common.model.CommonDialogUiAction;
import com.miami.game.feature.download.dialog.ui.common.model.CommonDialogUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: RepairGameSuccess.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a1\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\f\u001a)\u0010\r\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"RepairGameSuccessDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "onBackClick", "Lkotlin/Function0;", "onConfirm", "(Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RepairGameSuccessDialogScreen", "uiState", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;", "onDismiss", "(Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RepairGameSuccessDialogContent", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepairGameSuccessKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameSuccessDialogContent$lambda$6(Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        RepairGameSuccessDialogContent(function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameSuccessDialogRoute$lambda$4(CommonDialogComponent commonDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        RepairGameSuccessDialogRoute(commonDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameSuccessDialogScreen$lambda$5(CommonDialogUiState commonDialogUiState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        RepairGameSuccessDialogScreen(commonDialogUiState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void RepairGameSuccessDialogRoute(final CommonDialogComponent component, final Function0<Unit> onBackClick, final Function0<Unit> onConfirm, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer startRestartGroup = composer.startRestartGroup(-988112310);
        ComposerKt.sourceInformation(startRestartGroup, "C(RepairGameSuccessDialogRoute)31@1422L33,33@1517L183,33@1480L220,41@1739L29,45@1852L20,46@1894L20,43@1774L147:RepairGameSuccess.kt#wxnm6r");
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
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-988112310, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessDialogRoute (RepairGameSuccess.kt:30)");
            }
            int i3 = i2 & 112;
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i3, 1);
            SharedEventFlow<CommonDialogUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):RepairGameSuccess.kt#9igjgp");
            boolean z = (i3 == 32) | ((i2 & 896) == 256);
            RepairGameSuccessKt$RepairGameSuccessDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new RepairGameSuccessKt$RepairGameSuccessDialogRoute$1$1(onBackClick, onConfirm, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            startRestartGroup = startRestartGroup;
            CommonDialogUiState RepairGameSuccessDialogRoute$lambda$1 = RepairGameSuccessDialogRoute$lambda$1(FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):RepairGameSuccess.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(component);
            RepairGameSuccessKt$RepairGameSuccessDialogRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new RepairGameSuccessKt$RepairGameSuccessDialogRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function0 = (Function0) ((KFunction) rememberedValue2);
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):RepairGameSuccess.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(component);
            RepairGameSuccessKt$RepairGameSuccessDialogRoute$3$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new RepairGameSuccessKt$RepairGameSuccessDialogRoute$3$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            RepairGameSuccessDialogScreen(RepairGameSuccessDialogRoute$lambda$1, function0, (Function0) ((KFunction) rememberedValue3), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameSuccessDialogRoute$lambda$4;
                    RepairGameSuccessDialogRoute$lambda$4 = RepairGameSuccessKt.RepairGameSuccessDialogRoute$lambda$4(CommonDialogComponent.this, onBackClick, onConfirm, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameSuccessDialogRoute$lambda$4;
                }
            });
        }
    }

    public static final void RepairGameSuccessDialogScreen(final CommonDialogUiState uiState, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(1101981705);
        ComposerKt.sourceInformation(startRestartGroup, "C(RepairGameSuccessDialogScreen)P(2)57@2135L99:RepairGameSuccess.kt#wxnm6r");
        if ((i & 48) == 0) {
            i2 = (startRestartGroup.changedInstance(onConfirm) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if ((i2 & 145) != 144 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1101981705, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessDialogScreen (RepairGameSuccess.kt:56)");
            }
            RepairGameSuccessDialogContent(onConfirm, onDismiss, startRestartGroup, (i2 >> 3) & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameSuccessDialogScreen$lambda$5;
                    RepairGameSuccessDialogScreen$lambda$5 = RepairGameSuccessKt.RepairGameSuccessDialogScreen$lambda$5(CommonDialogUiState.this, onConfirm, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameSuccessDialogScreen$lambda$5;
                }
            });
        }
    }

    public static final void RepairGameSuccessDialogContent(final Function0<Unit> onConfirm, Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(102785244);
        ComposerKt.sourceInformation(startRestartGroup, "C(RepairGameSuccessDialogContent)69@2470L597,69@2415L652:RepairGameSuccess.kt#wxnm6r");
        if ((i & 48) == 0) {
            i2 = (startRestartGroup.changedInstance(onDismiss) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 17) != 16 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(102785244, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessDialogContent (RepairGameSuccess.kt:68)");
            }
            function0 = onDismiss;
            DialogFrameKt.DialogFrame(Integer.valueOf(R.drawable.check_files_success), function0, ComposableLambdaKt.rememberComposableLambda(1834912196, true, new RepairGameSuccessKt$RepairGameSuccessDialogContent$1(onDismiss), startRestartGroup, 54), startRestartGroup, (i2 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            function0 = onDismiss;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameSuccessDialogContent$lambda$6;
                    RepairGameSuccessDialogContent$lambda$6 = RepairGameSuccessKt.RepairGameSuccessDialogContent$lambda$6(Function0.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameSuccessDialogContent$lambda$6;
                }
            });
        }
    }

    private static final CommonDialogUiState RepairGameSuccessDialogRoute$lambda$1(State<CommonDialogUiState> state) {
        return state.getValue();
    }
}
