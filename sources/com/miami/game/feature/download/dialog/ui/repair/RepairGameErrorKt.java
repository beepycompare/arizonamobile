package com.miami.game.feature.download.dialog.ui.repair;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogDescriptionTextKt;
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
/* compiled from: RepairGameError.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a1\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\f\u001a)\u0010\r\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"RepairGameErrorDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "onBackClick", "Lkotlin/Function0;", "onConfirm", "(Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RepairGameErrorDialogScreen", "uiState", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;", "onDismiss", "(Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RepairGameErrorDialogContent", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RepairGameErrorKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RepairGameErrorDialogContent$lambda$1(Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        RepairGameErrorDialogContent(function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RepairGameErrorDialogRoute$lambda$4(CommonDialogComponent commonDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        RepairGameErrorDialogRoute(commonDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RepairGameErrorDialogScreen$lambda$0(CommonDialogUiState commonDialogUiState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        RepairGameErrorDialogScreen(commonDialogUiState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void RepairGameErrorDialogRoute(final CommonDialogComponent component, final Function0<Unit> onBackClick, final Function0<Unit> onConfirm, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer startRestartGroup = composer.startRestartGroup(2044412224);
        ComposerKt.sourceInformation(startRestartGroup, "C(RepairGameErrorDialogRoute)N(component,onBackClick,onConfirm)31@1464L33,33@1559L183,33@1522L220,41@1781L29,44@1866L20,45@1908L20,43@1816L119:RepairGameError.kt#wxnm6r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2044412224, i3, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorDialogRoute (RepairGameError.kt:30)");
            }
            int i4 = i3 & 112;
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i4, 1);
            SharedEventFlow<CommonDialogUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1880100503, "CC(remember):RepairGameError.kt#9igjgp");
            boolean z = (i4 == 32) | ((i3 & 896) == 256);
            RepairGameErrorKt$RepairGameErrorDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new RepairGameErrorKt$RepairGameErrorDialogRoute$1$1(onBackClick, onConfirm, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            composer2 = startRestartGroup;
            ComposerKt.sourceInformationMarkerStart(composer2, 1880110164, "CC(remember):RepairGameError.kt#9igjgp");
            int i5 = i3 & 14;
            boolean z2 = i5 == 4 || ((i3 & 8) != 0 && composer2.changedInstance(component));
            RepairGameErrorKt$RepairGameErrorDialogRoute$2$1 rememberedValue2 = composer2.rememberedValue();
            if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new RepairGameErrorKt$RepairGameErrorDialogRoute$2$1(component);
                composer2.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function0 = (Function0) ((KFunction) rememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composer2, 1880111508, "CC(remember):RepairGameError.kt#9igjgp");
            boolean z3 = i5 == 4 || ((i3 & 8) != 0 && composer2.changedInstance(component));
            RepairGameErrorKt$RepairGameErrorDialogRoute$3$1 rememberedValue3 = composer2.rememberedValue();
            if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new RepairGameErrorKt$RepairGameErrorDialogRoute$3$1(component);
                composer2.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            RepairGameErrorDialogContent(function0, (Function0) ((KFunction) rememberedValue3), composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RepairGameErrorKt.RepairGameErrorDialogRoute$lambda$4(CommonDialogComponent.this, onBackClick, onConfirm, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void RepairGameErrorDialogScreen(final CommonDialogUiState uiState, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1069905879);
        ComposerKt.sourceInformation(startRestartGroup, "C(RepairGameErrorDialogScreen)N(uiState,onConfirm,onDismiss)56@2147L97:RepairGameError.kt#wxnm6r");
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
                ComposerKt.traceEventStart(-1069905879, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorDialogScreen (RepairGameError.kt:55)");
            }
            RepairGameErrorDialogContent(onConfirm, onDismiss, startRestartGroup, (i2 >> 3) & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RepairGameErrorKt.RepairGameErrorDialogScreen$lambda$0(CommonDialogUiState.this, onConfirm, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void RepairGameErrorDialogContent(final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(776871890);
        ComposerKt.sourceInformation(startRestartGroup, "C(RepairGameErrorDialogContent)N(onConfirm,onDismiss)68@2458L691,68@2423L726:RepairGameError.kt#wxnm6r");
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
                ComposerKt.traceEventStart(776871890, i2, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorDialogContent (RepairGameError.kt:67)");
            }
            function0 = onDismiss;
            DialogFrameKt.DialogFrame(null, function0, ComposableLambdaKt.rememberComposableLambda(2140470458, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RepairGameErrorKt.RepairGameErrorDialogContent$lambda$0(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RepairGameErrorKt.RepairGameErrorDialogContent$lambda$1(Function0.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RepairGameErrorDialogContent$lambda$0(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C70@2487L88,69@2468L220,77@2724L10,77@2697L78,79@2784L136,80@2929L214:RepairGameError.kt#wxnm6r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2140470458, i, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorDialogContent.<anonymous> (RepairGameError.kt:69)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.dialog_frame_check_files_error, composer, 0), (String) null, SizeKt.m864size3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(100.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 432, 120);
            TextKt.m2712TextNvy7gAk("ОШИБКА", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, 131070);
            DialogDescriptionTextKt.DialogDescriptionText("Ты приближаешься к землям, где магия и сила стихий соединяются, образуя таинственные и непредсказуемые явления.", composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(composer);
            Updater.m4049setimpl(m4041constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 174424043, "C81@2972L43,81@2947L186:RepairGameError.kt#wxnm6r");
            ComposerKt.sourceInformationMarkerStart(composer, -2072582743, "CC(remember):RepairGameError.kt#9igjgp");
            boolean changed = composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit RepairGameErrorDialogContent$lambda$0$0$0$0;
                        RepairGameErrorDialogContent$lambda$0$0$0$0 = RepairGameErrorKt.RepairGameErrorDialogContent$lambda$0$0$0$0(Function0.this);
                        return RepairGameErrorDialogContent$lambda$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonNo((Function0) rememberedValue, ComposableSingletons$RepairGameErrorKt.INSTANCE.getLambda$2144985598$dialogs(), composer, 48);
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
    public static final Unit RepairGameErrorDialogContent$lambda$0$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
