package com.miami.game.feature.download.dialog.ui.setup;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogFrameKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt;
import com.miami.game.core.ui.utils.extensions.FlowExtensionsKt;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
import com.miami.game.feature.download.dialog.ui.common.ComponentKt;
import com.miami.game.feature.download.dialog.ui.common.model.CommonDialogUiAction;
import com.miami.game.feature.download.dialog.ui.common.model.CommonDialogUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
/* compiled from: SetupDialog.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001ac\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"SetupDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "onBackClick", "Lkotlin/Function0;", "navigateToDownloadScreen", "(Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SetupDialogContent", "isPrivacyAccepted", "", "updateSize", "", "onConfirm", "onDismiss", "onPolicy", "onTerms", "onAccept", "(ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web", "uiState", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SetupDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupDialogContent$lambda$20(boolean z, String str, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i, Composer composer, int i2) {
        SetupDialogContent(z, str, function0, function02, function03, function04, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupDialogRoute$lambda$7(CommonDialogComponent commonDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        SetupDialogRoute(commonDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SetupDialogRoute(final CommonDialogComponent component, final Function0<Unit> onBackClick, final Function0<Unit> navigateToDownloadScreen, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(navigateToDownloadScreen, "navigateToDownloadScreen");
        Composer startRestartGroup = composer.startRestartGroup(1304023394);
        ComposerKt.sourceInformation(startRestartGroup, "C(SetupDialogRoute)P(!1,2)47@2373L33,49@2468L198,49@2431L235,57@2707L34,60@2781L29,63@2856L20,64@2898L20,67@3040L21,68@3081L20,69@3122L19,62@2816L335:SetupDialog.kt#18sjrx");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToDownloadScreen) ? 256 : 128;
        }
        if (startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1304023394, i2, -1, "com.miami.game.feature.download.dialog.ui.setup.SetupDialogRoute (SetupDialog.kt:46)");
            }
            int i3 = i2 & 112;
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i3, 1);
            SharedEventFlow<CommonDialogUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -963960728, "CC(remember):SetupDialog.kt#9igjgp");
            boolean z = (i3 == 32) | ((i2 & 896) == 256);
            SetupDialogKt$SetupDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SetupDialogKt$SetupDialogRoute$1$1(onBackClick, navigateToDownloadScreen, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            ObserveExternalNavigationActionsKt.observeExternalNavigationActions(component.getExternalNavigationAction(), startRestartGroup, 0);
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -963948490, "CC(remember):SetupDialog.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(component);
            SetupDialogKt$SetupDialogRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SetupDialogKt$SetupDialogRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            KFunction kFunction = (KFunction) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -963947146, "CC(remember):SetupDialog.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(component);
            SetupDialogKt$SetupDialogRoute$3$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new SetupDialogKt$SetupDialogRoute$3$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            KFunction kFunction2 = (KFunction) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String descriptionText = SetupDialogRoute$lambda$1(collectAsStateWithLifecycle).getDescriptionText();
            boolean isPrivacyAccepted = SetupDialogRoute$lambda$1(collectAsStateWithLifecycle).isPrivacyAccepted();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -963942601, "CC(remember):SetupDialog.kt#9igjgp");
            boolean changedInstance3 = startRestartGroup.changedInstance(component);
            SetupDialogKt$SetupDialogRoute$4$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new SetupDialogKt$SetupDialogRoute$4$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction3 = (KFunction) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -963941290, "CC(remember):SetupDialog.kt#9igjgp");
            boolean changedInstance4 = startRestartGroup.changedInstance(component);
            SetupDialogKt$SetupDialogRoute$5$1 rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new SetupDialogKt$SetupDialogRoute$5$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction4 = (KFunction) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -963939979, "CC(remember):SetupDialog.kt#9igjgp");
            boolean changedInstance5 = startRestartGroup.changedInstance(component);
            SetupDialogKt$SetupDialogRoute$6$1 rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new SetupDialogKt$SetupDialogRoute$6$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SetupDialogContent(isPrivacyAccepted, descriptionText, (Function0) kFunction, (Function0) kFunction2, (Function0) kFunction3, (Function0) kFunction4, (Function0) ((KFunction) rememberedValue6), startRestartGroup, 0);
            startRestartGroup = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SetupDialogRoute$lambda$7;
                    SetupDialogRoute$lambda$7 = SetupDialogKt.SetupDialogRoute$lambda$7(CommonDialogComponent.this, onBackClick, navigateToDownloadScreen, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SetupDialogRoute$lambda$7;
                }
            });
        }
    }

    public static final void SetupDialogContent(final boolean z, final String updateSize, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, final Function0<Unit> onPolicy, final Function0<Unit> onTerms, final Function0<Unit> onAccept, Composer composer, final int i) {
        final boolean z2;
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onPolicy, "onPolicy");
        Intrinsics.checkNotNullParameter(onTerms, "onTerms");
        Intrinsics.checkNotNullParameter(onAccept, "onAccept");
        Composer startRestartGroup = composer.startRestartGroup(-1274880745);
        ComposerKt.sourceInformation(startRestartGroup, "C(SetupDialogContent)P(!1,6,2,3,4,5)86@3472L35,87@3585L1328,87@3512L1401:SetupDialog.kt#18sjrx");
        if ((i & 6) == 0) {
            z2 = z;
            i2 = (startRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(updateSize) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(onPolicy) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onTerms) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onAccept) ? 1048576 : 524288;
        }
        if (!startRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1274880745, i2, -1, "com.miami.game.feature.download.dialog.ui.setup.SetupDialogContent (SetupDialog.kt:84)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1094706438, "CC(remember):SetupDialog.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            composer2 = startRestartGroup;
            DialogFrameKt.DialogFrame(Integer.valueOf(R.drawable.dialog_frame_background_download_icon), onDismiss, ComposableLambdaKt.rememberComposableLambda(97924095, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SetupDialogContent$lambda$19;
                    SetupDialogContent$lambda$19 = SetupDialogKt.SetupDialogContent$lambda$19(updateSize, z2, onPolicy, onTerms, mutableState, onDismiss, onAccept, onConfirm, (Composer) obj, ((Integer) obj2).intValue());
                    return SetupDialogContent$lambda$19;
                }
            }, startRestartGroup, 54), composer2, ((i2 >> 6) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SetupDialogContent$lambda$20;
                    SetupDialogContent$lambda$20 = SetupDialogKt.SetupDialogContent$lambda$20(z, updateSize, onConfirm, onDismiss, onPolicy, onTerms, onAccept, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SetupDialogContent$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupDialogContent$lambda$19(String str, final boolean z, Function0 function0, Function0 function02, final MutableState mutableState, final Function0 function03, final Function0 function04, final Function0 function05, Composer composer, int i) {
        String str2;
        String str3;
        int i2;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C88@3595L18,89@3622L27,106@4285L622:SetupDialog.kt#18sjrx");
        if (composer2.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(97924095, i, -1, "com.miami.game.feature.download.dialog.ui.setup.SetupDialogContent.<anonymous> (SetupDialog.kt:88)");
            }
            ComponentKt.AlertLabelDialog(composer2, 0);
            DescriptionTextKt.DescriptionText(str, composer2, 0);
            if (z) {
                str2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str3 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                i2 = 693286680;
                composer2.startReplaceGroup(970362851);
            } else {
                composer2.startReplaceGroup(974034801);
                ComposerKt.sourceInformation(composer2, "91@3696L570");
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(-Dp.m6684constructorimpl(12))), centerVertically, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, Modifier.Companion);
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
                Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1047564806, "C93@3860L93,95@3955L75,93@3836L194,98@4047L204:SetupDialog.kt#18sjrx");
                ComposerKt.sourceInformationMarkerStart(composer2, 33792859, "CC(remember):SetupDialog.kt#9igjgp");
                Object rememberedValue = composer2.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SetupDialogContent$lambda$19$lambda$12$lambda$10$lambda$9;
                            SetupDialogContent$lambda$19$lambda$12$lambda$10$lambda$9 = SetupDialogKt.SetupDialogContent$lambda$19$lambda$12$lambda$10$lambda$9(MutableState.this);
                            return SetupDialogContent$lambda$19$lambda$12$lambda$10$lambda$9;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                str3 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                str2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                i2 = 693286680;
                ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(-1817021325, true, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit SetupDialogContent$lambda$19$lambda$12$lambda$11;
                        SetupDialogContent$lambda$19$lambda$12$lambda$11 = SetupDialogKt.SetupDialogContent$lambda$19$lambda$12$lambda$11(MutableState.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return SetupDialogContent$lambda$19$lambda$12$lambda$11;
                    }
                }, composer2, 54), composer2, 390, 2);
                PolicyTextKt.PolicyText("политикой конфиденциальности", "условиями использования", function0, function02, composer, 54);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer2, i2, str3);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str2);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, Modifier.Companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer2);
            Updater.m3527setimpl(m3520constructorimpl2, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 2071125742, "C107@4328L43,107@4303L187,113@4587L70,116@4659L238,113@4503L394:SetupDialog.kt#18sjrx");
            ComposerKt.sourceInformationMarkerStart(composer2, 1452284078, "CC(remember):SetupDialog.kt#9igjgp");
            boolean changed = composer2.changed(function03);
            Object rememberedValue2 = composer2.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SetupDialogContent$lambda$19$lambda$18$lambda$14$lambda$13;
                        SetupDialogContent$lambda$19$lambda$18$lambda$14$lambda$13 = SetupDialogKt.SetupDialogContent$lambda$19$lambda$18$lambda$14$lambda$13(Function0.this);
                        return SetupDialogContent$lambda$19$lambda$18$lambda$14$lambda$13;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            DialogButtonKt.DialogButtonNo((Function0) rememberedValue2, ComposableSingletons$SetupDialogKt.INSTANCE.getLambda$1149507$dialogs_release_web(), composer2, 48);
            boolean z2 = ((Boolean) mutableState.getValue()).booleanValue() || z;
            ComposerKt.sourceInformationMarkerStart(composer2, 1452292393, "CC(remember):SetupDialog.kt#9igjgp");
            boolean changed2 = composer2.changed(function04) | composer2.changed(function05);
            Object rememberedValue3 = composer2.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SetupDialogContent$lambda$19$lambda$18$lambda$16$lambda$15;
                        SetupDialogContent$lambda$19$lambda$18$lambda$16$lambda$15 = SetupDialogKt.SetupDialogContent$lambda$19$lambda$18$lambda$16$lambda$15(Function0.this, function05);
                        return SetupDialogContent$lambda$19$lambda$18$lambda$16$lambda$15;
                    }
                };
                composer2.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            DialogButtonKt.DialogButtonYes((Function0) rememberedValue3, z2, ComposableLambdaKt.rememberComposableLambda(-1429769364, true, new Function3() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SetupDialogContent$lambda$19$lambda$18$lambda$17;
                    SetupDialogContent$lambda$19$lambda$18$lambda$17 = SetupDialogKt.SetupDialogContent$lambda$19$lambda$18$lambda$17(MutableState.this, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SetupDialogContent$lambda$19$lambda$18$lambda$17;
                }
            }, composer2, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
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
    public static final Unit SetupDialogContent$lambda$19$lambda$12$lambda$10$lambda$9(MutableState mutableState) {
        mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupDialogContent$lambda$19$lambda$12$lambda$11(MutableState mutableState, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C96@3977L35:SetupDialog.kt#18sjrx");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1817021325, i, -1, "com.miami.game.feature.download.dialog.ui.setup.SetupDialogContent.<anonymous>.<anonymous>.<anonymous> (SetupDialog.kt:96)");
            }
            CheckButtonKt.CheckButton(((Boolean) mutableState.getValue()).booleanValue(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupDialogContent$lambda$19$lambda$18$lambda$14$lambda$13(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupDialogContent$lambda$19$lambda$18$lambda$16$lambda$15(Function0 function0, Function0 function02) {
        function0.invoke();
        function02.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupDialogContent$lambda$19$lambda$18$lambda$17(MutableState mutableState, boolean z, BoxScope DialogButtonYes, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
        ComposerKt.sourceInformation(composer, "C117@4704L10,117@4677L206:SetupDialog.kt#18sjrx");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1429769364, i, -1, "com.miami.game.feature.download.dialog.ui.setup.SetupDialogContent.<anonymous>.<anonymous>.<anonymous> (SetupDialog.kt:117)");
            }
            TextKt.m2497Text4IGK_g("ЗАГРУЗИТЬ", (Modifier) null, (((Boolean) mutableState.getValue()).booleanValue() || z) ? Color.Companion.m4115getWhite0d7_KjU() : Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 6, 0, 65530);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final CommonDialogUiState SetupDialogRoute$lambda$1(State<CommonDialogUiState> state) {
        return state.getValue();
    }
}
