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
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogFrameKt;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.model.ErrorDialogUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
/* compiled from: FailDownloadDialog.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a9\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"FailDownloadErrorDialogRoot", "", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "onBackClick", "Lkotlin/Function0;", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FailDownloadErrorDialogScreen", "errorMessage", "", "uiState", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "onConfirm", "onDismiss", "(Ljava/lang/String;Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FailDownloadDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FailDownloadErrorDialogRoot$lambda$2(ErrorDialogComponent errorDialogComponent, Function0 function0, int i, Composer composer, int i2) {
        FailDownloadErrorDialogRoot(errorDialogComponent, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FailDownloadErrorDialogScreen$lambda$9(String str, ErrorDialogUiState errorDialogUiState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        FailDownloadErrorDialogScreen(str, errorDialogUiState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void FailDownloadErrorDialogRoot(final ErrorDialogComponent component, Function0<Unit> onBackClick, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Composer startRestartGroup = composer.startRestartGroup(2025743521);
        ComposerKt.sourceInformation(startRestartGroup, "C(FailDownloadErrorDialogRoot)32@1383L29,36@1496L21,34@1418L185:FailDownloadDialog.kt#d3gn1w");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onBackClick) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025743521, i2, -1, "com.miami.game.feature.download.dialog.ui.error.compose.FailDownloadErrorDialogRoot (FailDownloadDialog.kt:27)");
            }
            ErrorDialogUiState FailDownloadErrorDialogRoot$lambda$0 = FailDownloadErrorDialogRoot$lambda$0(FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1119348470, "CC(remember):FailDownloadDialog.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(component);
            FailDownloadDialogKt$FailDownloadErrorDialogRoot$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new FailDownloadDialogKt$FailDownloadErrorDialogRoot$1$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            function0 = onBackClick;
            FailDownloadErrorDialogScreen(component.getErrorMessage(), FailDownloadErrorDialogRoot$lambda$0, (Function0) ((KFunction) rememberedValue), function0, startRestartGroup, (i2 << 6) & 7168);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function0 = onBackClick;
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.FailDownloadDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FailDownloadErrorDialogRoot$lambda$2;
                    FailDownloadErrorDialogRoot$lambda$2 = FailDownloadDialogKt.FailDownloadErrorDialogRoot$lambda$2(ErrorDialogComponent.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FailDownloadErrorDialogRoot$lambda$2;
                }
            });
        }
    }

    public static final void FailDownloadErrorDialogScreen(final String errorMessage, final ErrorDialogUiState uiState, final Function0<Unit> onConfirm, Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1458419362);
        ComposerKt.sourceInformation(startRestartGroup, "C(FailDownloadErrorDialogScreen)P(!1,3)50@1917L759,50@1842L834:FailDownloadDialog.kt#d3gn1w");
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
                ComposerKt.traceEventStart(-1458419362, i2, -1, "com.miami.game.feature.download.dialog.ui.error.compose.FailDownloadErrorDialogScreen (FailDownloadDialog.kt:49)");
            }
            DialogFrameKt.DialogFrame(Integer.valueOf(R.drawable.dialog_frame_no_network_background_icon), onDismiss, ComposableLambdaKt.rememberComposableLambda(-50143882, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.FailDownloadDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FailDownloadErrorDialogScreen$lambda$8;
                    FailDownloadErrorDialogScreen$lambda$8 = FailDownloadDialogKt.FailDownloadErrorDialogScreen$lambda$8(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                    return FailDownloadErrorDialogScreen$lambda$8;
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 6) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            function0 = onDismiss;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.FailDownloadDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FailDownloadErrorDialogScreen$lambda$9;
                    FailDownloadErrorDialogScreen$lambda$9 = FailDownloadDialogKt.FailDownloadErrorDialogScreen$lambda$9(errorMessage, uiState, onConfirm, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FailDownloadErrorDialogScreen$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FailDownloadErrorDialogScreen$lambda$8(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C51@1954L10,51@1927L87,54@2042L86,53@2023L218,61@2250L419:FailDownloadDialog.kt#d3gn1w");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-50143882, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.FailDownloadErrorDialogScreen.<anonymous> (FailDownloadDialog.kt:51)");
            }
            TextKt.m2497Text4IGK_g("ОТСУТСТВИЕ СЕТИ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.dialog_frame_no_network_icon, composer, 0), (String) null, SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(100)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 432, (int) MenuKt.InTransitionDuration);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1627999178, "C62@2293L43,62@2268L187,68@2494L43,68@2468L191:FailDownloadDialog.kt#d3gn1w");
            ComposerKt.sourceInformationMarkerStart(composer, -1471504099, "CC(remember):FailDownloadDialog.kt#9igjgp");
            boolean changed = composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.FailDownloadDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit FailDownloadErrorDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3;
                        FailDownloadErrorDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3 = FailDownloadDialogKt.FailDownloadErrorDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3(Function0.this);
                        return FailDownloadErrorDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonNo((Function0) rememberedValue, ComposableSingletons$FailDownloadDialogKt.INSTANCE.getLambda$1464513202$dialogs_release_web(), composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1471497667, "CC(remember):FailDownloadDialog.kt#9igjgp");
            boolean changed2 = composer.changed(function0);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.FailDownloadDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit FailDownloadErrorDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5;
                        FailDownloadErrorDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5 = FailDownloadDialogKt.FailDownloadErrorDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5(Function0.this);
                        return FailDownloadErrorDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonYes((Function0) rememberedValue2, false, ComposableSingletons$FailDownloadDialogKt.INSTANCE.m8348getLambda$1143154327$dialogs_release_web(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
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
    public static final Unit FailDownloadErrorDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FailDownloadErrorDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final ErrorDialogUiState FailDownloadErrorDialogRoot$lambda$0(State<ErrorDialogUiState> state) {
        return state.getValue();
    }
}
