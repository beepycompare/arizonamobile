package com.miami.game.feature.download.dialog.ui.error.compose;

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
import androidx.media3.extractor.WavUtil;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogDescriptionTextKt;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
/* compiled from: NoNetworkErrorDialog.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"NoNetworkErrorDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "onBackClick", "Lkotlin/Function0;", "onRetry", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NoNetworkErrorDialogScreen", "errorMessage", "", "uiState", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "onConfirm", "onDismiss", "(Ljava/lang/String;Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NoNetworkErrorDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoNetworkErrorDialogRoute$lambda$3(ErrorDialogComponent errorDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NoNetworkErrorDialogRoute(errorDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoNetworkErrorDialogScreen$lambda$8(String str, ErrorDialogUiState errorDialogUiState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
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
        if (startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1779829502, i2, -1, "com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogRoute (NoNetworkErrorDialog.kt:31)");
            }
            SharedEventFlow<ErrorDialogUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1019175311, "CC(remember):NoNetworkErrorDialog.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$1$1(onRetry, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            startRestartGroup = startRestartGroup;
            ErrorDialogUiState NoNetworkErrorDialogRoute$lambda$1 = NoNetworkErrorDialogRoute$lambda$1(FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1019183603, "CC(remember):NoNetworkErrorDialog.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(component);
            NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new NoNetworkErrorDialogKt$NoNetworkErrorDialogRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            function0 = onBackClick;
            NoNetworkErrorDialogScreen(component.getErrorMessage(), NoNetworkErrorDialogRoute$lambda$1, (Function0) ((KFunction) rememberedValue2), function0, startRestartGroup, (i2 << 6) & 7168);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function0 = onBackClick;
            startRestartGroup.skipToGroupEnd();
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
        if (!startRestartGroup.shouldExecute((i2 & 1153) != 1152, i2 & 1)) {
            function0 = onDismiss;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-970643010, i2, -1, "com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogScreen (NoNetworkErrorDialog.kt:57)");
            }
            DialogFrameKt.DialogFrame(Integer.valueOf(R.drawable.dialog_frame_no_network_background_icon), onDismiss, ComposableLambdaKt.rememberComposableLambda(1984279206, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NoNetworkErrorDialogScreen$lambda$7;
                    NoNetworkErrorDialogScreen$lambda$7 = NoNetworkErrorDialogKt.NoNetworkErrorDialogScreen$lambda$7(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                    return NoNetworkErrorDialogScreen$lambda$7;
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 6) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            function0 = onDismiss;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NoNetworkErrorDialogScreen$lambda$8;
                    NoNetworkErrorDialogScreen$lambda$8 = NoNetworkErrorDialogKt.NoNetworkErrorDialogScreen$lambda$8(errorMessage, uiState, onConfirm, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NoNetworkErrorDialogScreen$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoNetworkErrorDialogScreen$lambda$7(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C59@2274L10,59@2247L87,62@2362L86,61@2343L218,69@2570L75,70@2654L219:NoNetworkErrorDialog.kt#d3gn1w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1984279206, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogScreen.<anonymous> (NoNetworkErrorDialog.kt:59)");
            }
            TextKt.m2497Text4IGK_g("ОТСУТСТВИЕ СЕТИ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.dialog_frame_no_network_icon, composer, 0), (String) null, SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(100)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 432, (int) MenuKt.InTransitionDuration);
            DialogDescriptionTextKt.DialogDescriptionText("Проверьте качество соединение и перезайдите в игру", composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1499075866, "C71@2698L43,71@2672L191:NoNetworkErrorDialog.kt#d3gn1w");
            ComposerKt.sourceInformationMarkerStart(composer, -921473355, "CC(remember):NoNetworkErrorDialog.kt#9igjgp");
            boolean changed = composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit NoNetworkErrorDialogScreen$lambda$7$lambda$6$lambda$5$lambda$4;
                        NoNetworkErrorDialogScreen$lambda$7$lambda$6$lambda$5$lambda$4 = NoNetworkErrorDialogKt.NoNetworkErrorDialogScreen$lambda$7$lambda$6$lambda$5$lambda$4(Function0.this);
                        return NoNetworkErrorDialogScreen$lambda$7$lambda$6$lambda$5$lambda$4;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonYes((Function0) rememberedValue, false, ComposableSingletons$NoNetworkErrorDialogKt.INSTANCE.getLambda$286452819$dialogs_release_web(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
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
    public static final Unit NoNetworkErrorDialogScreen$lambda$7$lambda$6$lambda$5$lambda$4(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final ErrorDialogUiState NoNetworkErrorDialogRoute$lambda$1(State<ErrorDialogUiState> state) {
        return state.getValue();
    }
}
