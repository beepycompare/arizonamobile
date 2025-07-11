package com.miami.game.feature.download.dialog.ui.error.compose;

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
/* compiled from: ErrorDialogScreen.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a9\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"ErrorDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "onBackClick", "Lkotlin/Function0;", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ErrorDialogScreen", "errorMessage", "", "uiState", "Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;", "onConfirm", "onDismiss", "(Ljava/lang/String;Lcom/miami/game/feature/download/dialog/ui/error/model/ErrorDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ErrorDialogScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogRoute$lambda$2(ErrorDialogComponent errorDialogComponent, Function0 function0, int i, Composer composer, int i2) {
        ErrorDialogRoute(errorDialogComponent, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogScreen$lambda$9(String str, ErrorDialogUiState errorDialogUiState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ErrorDialogScreen(str, errorDialogUiState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ErrorDialogRoute(final ErrorDialogComponent component, Function0<Unit> onBackClick, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Composer startRestartGroup = composer.startRestartGroup(1222259564);
        ComposerKt.sourceInformation(startRestartGroup, "C(ErrorDialogRoute)29@1341L33,33@1415L29,37@1516L21,35@1450L173:ErrorDialogScreen.kt#d3gn1w");
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
                ComposerKt.traceEventStart(1222259564, i2, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ErrorDialogRoute (ErrorDialogScreen.kt:28)");
            }
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i2 & 112, 1);
            ErrorDialogUiState ErrorDialogRoute$lambda$0 = ErrorDialogRoute$lambda$0(FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2065378273, "CC(remember):ErrorDialogScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(component);
            ErrorDialogScreenKt$ErrorDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ErrorDialogScreenKt$ErrorDialogRoute$1$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            function0 = onBackClick;
            ErrorDialogScreen(component.getErrorMessage(), ErrorDialogRoute$lambda$0, (Function0) ((KFunction) rememberedValue), function0, startRestartGroup, (i2 << 6) & 7168);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function0 = onBackClick;
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ErrorDialogScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorDialogRoute$lambda$2;
                    ErrorDialogRoute$lambda$2 = ErrorDialogScreenKt.ErrorDialogRoute$lambda$2(ErrorDialogComponent.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorDialogRoute$lambda$2;
                }
            });
        }
    }

    public static final void ErrorDialogScreen(final String errorMessage, final ErrorDialogUiState uiState, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(1329362400);
        ComposerKt.sourceInformation(startRestartGroup, "C(ErrorDialogScreen)P(!1,3)54@1924L754,54@1895L783:ErrorDialogScreen.kt#d3gn1w");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(errorMessage) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1155) != 1154, i2 & 1)) {
            function0 = onDismiss;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1329362400, i2, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ErrorDialogScreen (ErrorDialogScreen.kt:53)");
            }
            DialogFrameKt.DialogFrame(null, onDismiss, ComposableLambdaKt.rememberComposableLambda(-59434296, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ErrorDialogScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorDialogScreen$lambda$8;
                    ErrorDialogScreen$lambda$8 = ErrorDialogScreenKt.ErrorDialogScreen$lambda$8(errorMessage, onDismiss, onConfirm, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorDialogScreen$lambda$8;
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 6) & 112) | 390, 0);
            function0 = onDismiss;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ErrorDialogScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorDialogScreen$lambda$9;
                    ErrorDialogScreen$lambda$9 = ErrorDialogScreenKt.ErrorDialogScreen$lambda$9(errorMessage, uiState, onConfirm, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorDialogScreen$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogScreen$lambda$8(String str, final Function0 function0, final Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C55@1961L10,55@1934L82,58@2044L85,57@2025L217,65@2251L420:ErrorDialogScreen.kt#d3gn1w");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-59434296, i, -1, "com.miami.game.feature.download.dialog.ui.error.compose.ErrorDialogScreen.<anonymous> (ErrorDialogScreen.kt:55)");
            }
            TextKt.m2497Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.dialog_frame_download_image, composer, 0), (String) null, SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(100)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 432, (int) MenuKt.InTransitionDuration);
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
            ComposerKt.sourceInformationMarkerStart(composer, 967934991, "C66@2294L43,66@2269L188,72@2496L43,72@2470L191:ErrorDialogScreen.kt#d3gn1w");
            ComposerKt.sourceInformationMarkerStart(composer, -1354249161, "CC(remember):ErrorDialogScreen.kt#9igjgp");
            boolean changed = composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ErrorDialogScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ErrorDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3;
                        ErrorDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3 = ErrorDialogScreenKt.ErrorDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3(Function0.this);
                        return ErrorDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonNo((Function0) rememberedValue, ComposableSingletons$ErrorDialogScreenKt.INSTANCE.m8347getLambda$1032883188$dialogs_release_web(), composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1354242697, "CC(remember):ErrorDialogScreen.kt#9igjgp");
            boolean changed2 = composer.changed(function02);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.error.compose.ErrorDialogScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ErrorDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5;
                        ErrorDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5 = ErrorDialogScreenKt.ErrorDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5(Function0.this);
                        return ErrorDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonYes((Function0) rememberedValue2, false, ComposableSingletons$ErrorDialogScreenKt.INSTANCE.getLambda$24227829$dialogs_release_web(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
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
    public static final Unit ErrorDialogScreen$lambda$8$lambda$7$lambda$4$lambda$3(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorDialogScreen$lambda$8$lambda$7$lambda$6$lambda$5(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final ErrorDialogUiState ErrorDialogRoute$lambda$0(State<ErrorDialogUiState> state) {
        return state.getValue();
    }
}
