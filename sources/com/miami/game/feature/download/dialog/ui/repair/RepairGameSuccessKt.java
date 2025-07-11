package com.miami.game.feature.download.dialog.ui.repair;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
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
import com.miami.game.core.drawable.resources.R;
import com.miami.game.core.ui.utils.extensions.FlowExtensionsKt;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
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
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: RepairGameSuccess.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a1\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\f\u001a)\u0010\r\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"RepairGameSuccessDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "onBackClick", "Lkotlin/Function0;", "onConfirm", "(Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RepairGameSuccessDialogScreen", "uiState", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;", "onDismiss", "(Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RepairGameSuccessDialogContent", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepairGameSuccessKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameSuccessDialogContent$lambda$10(Function0 function0, Function0 function02, int i, Composer composer, int i2) {
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
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-988112310, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessDialogRoute (RepairGameSuccess.kt:30)");
            }
            int i3 = i2 & 112;
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i3, 1);
            SharedEventFlow<CommonDialogUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -388149535, "CC(remember):RepairGameSuccess.kt#9igjgp");
            boolean z = (i3 == 32) | ((i2 & 896) == 256);
            RepairGameSuccessKt$RepairGameSuccessDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new RepairGameSuccessKt$RepairGameSuccessDialogRoute$1$1(onBackClick, onConfirm, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            startRestartGroup = startRestartGroup;
            CommonDialogUiState RepairGameSuccessDialogRoute$lambda$1 = RepairGameSuccessDialogRoute$lambda$1(FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -388138978, "CC(remember):RepairGameSuccess.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(component);
            RepairGameSuccessKt$RepairGameSuccessDialogRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new RepairGameSuccessKt$RepairGameSuccessDialogRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function0 function0 = (Function0) ((KFunction) rememberedValue2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -388137634, "CC(remember):RepairGameSuccess.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(component);
            RepairGameSuccessKt$RepairGameSuccessDialogRoute$3$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new RepairGameSuccessKt$RepairGameSuccessDialogRoute$3$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            RepairGameSuccessDialogScreen(RepairGameSuccessDialogRoute$lambda$1, function0, (Function0) ((KFunction) rememberedValue3), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessKt$$ExternalSyntheticLambda3
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
        if (!startRestartGroup.shouldExecute((i2 & 145) != 144, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1101981705, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessDialogScreen (RepairGameSuccess.kt:56)");
            }
            RepairGameSuccessDialogContent(onConfirm, onDismiss, startRestartGroup, (i2 >> 3) & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameSuccessDialogScreen$lambda$5;
                    RepairGameSuccessDialogScreen$lambda$5 = RepairGameSuccessKt.RepairGameSuccessDialogScreen$lambda$5(CommonDialogUiState.this, onConfirm, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameSuccessDialogScreen$lambda$5;
                }
            });
        }
    }

    public static final void RepairGameSuccessDialogContent(final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
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
        if (!startRestartGroup.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            function0 = onDismiss;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(102785244, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessDialogContent (RepairGameSuccess.kt:68)");
            }
            function0 = onDismiss;
            DialogFrameKt.DialogFrame(Integer.valueOf(R.drawable.check_files_success), function0, ComposableLambdaKt.rememberComposableLambda(1834912196, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameSuccessDialogContent$lambda$9;
                    RepairGameSuccessDialogContent$lambda$9 = RepairGameSuccessKt.RepairGameSuccessDialogContent$lambda$9(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameSuccessDialogContent$lambda$9;
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RepairGameSuccessDialogContent$lambda$10;
                    RepairGameSuccessDialogContent$lambda$10 = RepairGameSuccessKt.RepairGameSuccessDialogContent$lambda$10(Function0.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RepairGameSuccessDialogContent$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameSuccessDialogContent$lambda$9(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C71@2499L82,70@2480L214,78@2730L10,78@2703L135,82@2847L214:RepairGameSuccess.kt#wxnm6r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1834912196, i, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessDialogContent.<anonymous> (RepairGameSuccess.kt:70)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.check_files_success_icon, composer, 0), (String) null, SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(100)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 432, (int) MenuKt.InTransitionDuration);
            TextKt.m2497Text4IGK_g("ФАЙЛЫ ПРОВЕРЕНЫ", (Modifier) null, ColorKt.Color(4293066608L), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 390, 0, 65530);
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
            ComposerKt.sourceInformationMarkerStart(composer, -649924447, "C83@2890L43,83@2865L186:RepairGameSuccess.kt#wxnm6r");
            ComposerKt.sourceInformationMarkerStart(composer, -1267890637, "CC(remember):RepairGameSuccess.kt#9igjgp");
            boolean changed = composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit RepairGameSuccessDialogContent$lambda$9$lambda$8$lambda$7$lambda$6;
                        RepairGameSuccessDialogContent$lambda$9$lambda$8$lambda$7$lambda$6 = RepairGameSuccessKt.RepairGameSuccessDialogContent$lambda$9$lambda$8$lambda$7$lambda$6(Function0.this);
                        return RepairGameSuccessDialogContent$lambda$9$lambda$8$lambda$7$lambda$6;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonNo((Function0) rememberedValue, ComposableSingletons$RepairGameSuccessKt.INSTANCE.getLambda$1248275720$dialogs_release_web(), composer, 48);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RepairGameSuccessDialogContent$lambda$9$lambda$8$lambda$7$lambda$6(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final CommonDialogUiState RepairGameSuccessDialogRoute$lambda$1(State<CommonDialogUiState> state) {
        return state.getValue();
    }
}
