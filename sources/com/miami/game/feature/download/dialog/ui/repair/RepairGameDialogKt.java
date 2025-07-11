package com.miami.game.feature.download.dialog.ui.repair;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogDescriptionTextKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogFrameKt;
import com.miami.game.core.ui.utils.extensions.FlowExtensionsKt;
import com.miami.game.feature.download.dialog.ui.common.ComponentKt;
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
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\b\u001a9\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"RepairGameDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "onBackClick", "Lkotlin/Function0;", "onConfirm", "onRetry", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RepairGameDialogScreen", "errorMessage", "", "uiState", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "onDismiss", "(Ljava/lang/String;Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepairGameDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameDialogRoute$lambda$2(ErrorDialogComponent errorDialogComponent, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        RepairGameDialogRoute(errorDialogComponent, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameDialogScreen$lambda$9(String str, ErrorDialogUiState errorDialogUiState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
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
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            function0 = onConfirm;
            function02 = onBackClick;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1550967417, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogRoute (RepairGameDialog.kt:38)");
            }
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i2 & 112, 1);
            SharedEventFlow<ErrorDialogUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 126044394, "CC(remember):RepairGameDialog.kt#9igjgp");
            boolean z = (i2 & 7168) == 2048;
            RepairGameDialogKt$RepairGameDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new RepairGameDialogKt$RepairGameDialogRoute$1$1(onRetry, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            startRestartGroup = startRestartGroup;
            function0 = onConfirm;
            RepairGameDialogScreen(component.getErrorMessage(), RepairGameDialogRoute$lambda$1(FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7)), function0, onBackClick, startRestartGroup, (i2 & 896) | ((i2 << 6) & 7168));
            function02 = onBackClick;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0<Unit> function03 = function0;
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameDialogRoute$lambda$2;
                    RepairGameDialogRoute$lambda$2 = RepairGameDialogKt.RepairGameDialogRoute$lambda$2(ErrorDialogComponent.this, function02, function03, onRetry, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameDialogRoute$lambda$2;
                }
            });
        }
    }

    public static final void RepairGameDialogScreen(final String errorMessage, final ErrorDialogUiState uiState, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
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
        if (!startRestartGroup.shouldExecute((i2 & 1153) != 1152, i2 & 1)) {
            function0 = onDismiss;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2066583429, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogScreen (RepairGameDialog.kt:67)");
            }
            DialogFrameKt.DialogFrame(null, onDismiss, ComposableLambdaKt.rememberComposableLambda(-1489415267, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameDialogScreen$lambda$8;
                    RepairGameDialogScreen$lambda$8 = RepairGameDialogKt.RepairGameDialogScreen$lambda$8(Function0.this, onConfirm, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameDialogScreen$lambda$8;
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 6) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            function0 = onDismiss;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameDialogScreen$lambda$9;
                    RepairGameDialogScreen$lambda$9 = RepairGameDialogKt.RepairGameDialogScreen$lambda$9(errorMessage, uiState, onConfirm, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameDialogScreen$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameDialogScreen$lambda$8(final Function0 function0, final Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C69@2677L18,70@2704L102,71@2815L409:RepairGameDialog.kt#wxnm6r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1489415267, i, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogScreen.<anonymous> (RepairGameDialog.kt:69)");
            }
            ComponentKt.AlertLabelDialog(composer, 0);
            DialogDescriptionTextKt.DialogDescriptionText("Проверка целостности файлов может занять длительное время. Хотите продолжить?", composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer);
            Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -967043315, "C72@2858L43,72@2833L184,78@3056L43,78@3030L184:RepairGameDialog.kt#wxnm6r");
            ComposerKt.sourceInformationMarkerStart(composer, -308289148, "CC(remember):RepairGameDialog.kt#9igjgp");
            boolean changed = composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit RepairGameDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3;
                        RepairGameDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3 = RepairGameDialogKt.RepairGameDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3(Function0.this);
                        return RepairGameDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonNo((Function0) rememberedValue, ComposableSingletons$RepairGameDialogKt.INSTANCE.m8355getLambda$1796529959$dialogs_release_web(), composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -308282812, "CC(remember):RepairGameDialog.kt#9igjgp");
            boolean changed2 = composer.changed(function02);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit RepairGameDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5;
                        RepairGameDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5 = RepairGameDialogKt.RepairGameDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5(Function0.this);
                        return RepairGameDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonYes((Function0) rememberedValue2, false, ComposableSingletons$RepairGameDialogKt.INSTANCE.m8356getLambda$277375600$dialogs_release_web(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final ErrorDialogUiState RepairGameDialogRoute$lambda$1(State<ErrorDialogUiState> state) {
        return state.getValue();
    }
}
