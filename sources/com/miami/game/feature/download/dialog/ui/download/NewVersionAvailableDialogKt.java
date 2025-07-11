package com.miami.game.feature.download.dialog.ui.download;

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
/* compiled from: NewVersionAvailableDialog.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a1\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\r\u001a)\u0010\u000e\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"NewVersionAvailableDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "onBackClick", "Lkotlin/Function0;", "navigateToDownloadScreen", "(Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NewVersionAvailableDialogScreen", "uiState", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;", "onConfirm", "onDismiss", "(Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NewVersionAvailableDialogContent", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NewVersionAvailableDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewVersionAvailableDialogContent$lambda$12(Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NewVersionAvailableDialogContent(function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewVersionAvailableDialogRoute$lambda$4(CommonDialogComponent commonDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NewVersionAvailableDialogRoute(commonDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewVersionAvailableDialogScreen$lambda$5(CommonDialogUiState commonDialogUiState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NewVersionAvailableDialogScreen(commonDialogUiState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NewVersionAvailableDialogRoute(final CommonDialogComponent component, final Function0<Unit> onBackClick, final Function0<Unit> navigateToDownloadScreen, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(navigateToDownloadScreen, "navigateToDownloadScreen");
        Composer startRestartGroup = composer.startRestartGroup(1398636739);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewVersionAvailableDialogRoute)P(!1,2)30@1399L33,32@1494L198,32@1457L235,40@1731L29,44@1846L20,45@1888L20,42@1766L149:NewVersionAvailableDialog.kt#as3uag");
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
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1398636739, i2, -1, "com.miami.game.feature.download.dialog.ui.download.NewVersionAvailableDialogRoute (NewVersionAvailableDialog.kt:29)");
            }
            int i3 = i2 & 112;
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i3, 1);
            SharedEventFlow<CommonDialogUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -234848951, "CC(remember):NewVersionAvailableDialog.kt#9igjgp");
            boolean z = (i3 == 32) | ((i2 & 896) == 256);
            NewVersionAvailableDialogKt$NewVersionAvailableDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NewVersionAvailableDialogKt$NewVersionAvailableDialogRoute$1$1(onBackClick, navigateToDownloadScreen, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            startRestartGroup = startRestartGroup;
            CommonDialogUiState NewVersionAvailableDialogRoute$lambda$1 = NewVersionAvailableDialogRoute$lambda$1(FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -234837865, "CC(remember):NewVersionAvailableDialog.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(component);
            NewVersionAvailableDialogKt$NewVersionAvailableDialogRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new NewVersionAvailableDialogKt$NewVersionAvailableDialogRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function0 function0 = (Function0) ((KFunction) rememberedValue2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -234836521, "CC(remember):NewVersionAvailableDialog.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(component);
            NewVersionAvailableDialogKt$NewVersionAvailableDialogRoute$3$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new NewVersionAvailableDialogKt$NewVersionAvailableDialogRoute$3$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            NewVersionAvailableDialogScreen(NewVersionAvailableDialogRoute$lambda$1, function0, (Function0) ((KFunction) rememberedValue3), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.download.NewVersionAvailableDialogKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NewVersionAvailableDialogRoute$lambda$4;
                    NewVersionAvailableDialogRoute$lambda$4 = NewVersionAvailableDialogKt.NewVersionAvailableDialogRoute$lambda$4(CommonDialogComponent.this, onBackClick, navigateToDownloadScreen, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NewVersionAvailableDialogRoute$lambda$4;
                }
            });
        }
    }

    public static final void NewVersionAvailableDialogScreen(final CommonDialogUiState uiState, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(136578044);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewVersionAvailableDialogScreen)P(2)56@2131L101:NewVersionAvailableDialog.kt#as3uag");
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
                ComposerKt.traceEventStart(136578044, i2, -1, "com.miami.game.feature.download.dialog.ui.download.NewVersionAvailableDialogScreen (NewVersionAvailableDialog.kt:55)");
            }
            NewVersionAvailableDialogContent(onConfirm, onDismiss, startRestartGroup, (i2 >> 3) & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.download.NewVersionAvailableDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NewVersionAvailableDialogScreen$lambda$5;
                    NewVersionAvailableDialogScreen$lambda$5 = NewVersionAvailableDialogKt.NewVersionAvailableDialogScreen$lambda$5(CommonDialogUiState.this, onConfirm, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NewVersionAvailableDialogScreen$lambda$5;
                }
            });
        }
    }

    public static final void NewVersionAvailableDialogContent(final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(960090197);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewVersionAvailableDialogContent)68@2488L764,68@2415L837:NewVersionAvailableDialog.kt#as3uag");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onConfirm) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function0 = onDismiss;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(960090197, i2, -1, "com.miami.game.feature.download.dialog.ui.download.NewVersionAvailableDialogContent (NewVersionAvailableDialog.kt:67)");
            }
            function0 = onDismiss;
            DialogFrameKt.DialogFrame(Integer.valueOf(R.drawable.dialog_frame_background_download_icon), function0, ComposableLambdaKt.rememberComposableLambda(1396301117, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.download.NewVersionAvailableDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NewVersionAvailableDialogContent$lambda$11;
                    NewVersionAvailableDialogContent$lambda$11 = NewVersionAvailableDialogKt.NewVersionAvailableDialogContent$lambda$11(Function0.this, onConfirm, (Composer) obj, ((Integer) obj2).intValue());
                    return NewVersionAvailableDialogContent$lambda$11;
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.download.NewVersionAvailableDialogKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NewVersionAvailableDialogContent$lambda$12;
                    NewVersionAvailableDialogContent$lambda$12 = NewVersionAvailableDialogKt.NewVersionAvailableDialogContent$lambda$12(Function0.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NewVersionAvailableDialogContent$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewVersionAvailableDialogContent$lambda$11(final Function0 function0, final Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C69@2525L10,69@2498L93,72@2619L85,71@2600L217,79@2826L419:NewVersionAvailableDialog.kt#as3uag");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1396301117, i, -1, "com.miami.game.feature.download.dialog.ui.download.NewVersionAvailableDialogContent.<anonymous> (NewVersionAvailableDialog.kt:69)");
            }
            TextKt.m2497Text4IGK_g("ДОСТУПНА НОВАЯ ВЕРСИЯ", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1637839525, "C80@2869L43,80@2844L187,86@3070L43,86@3044L191:NewVersionAvailableDialog.kt#as3uag");
            ComposerKt.sourceInformationMarkerStart(composer, 1194092908, "CC(remember):NewVersionAvailableDialog.kt#9igjgp");
            boolean changed = composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.download.NewVersionAvailableDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit NewVersionAvailableDialogContent$lambda$11$lambda$10$lambda$7$lambda$6;
                        NewVersionAvailableDialogContent$lambda$11$lambda$10$lambda$7$lambda$6 = NewVersionAvailableDialogKt.NewVersionAvailableDialogContent$lambda$11$lambda$10$lambda$7$lambda$6(Function0.this);
                        return NewVersionAvailableDialogContent$lambda$11$lambda$10$lambda$7$lambda$6;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonNo((Function0) rememberedValue, ComposableSingletons$NewVersionAvailableDialogKt.INSTANCE.m8341getLambda$1405896063$dialogs_release_web(), composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, 1194099340, "CC(remember):NewVersionAvailableDialog.kt#9igjgp");
            boolean changed2 = composer.changed(function02);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.download.NewVersionAvailableDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit NewVersionAvailableDialogContent$lambda$11$lambda$10$lambda$9$lambda$8;
                        NewVersionAvailableDialogContent$lambda$11$lambda$10$lambda$9$lambda$8 = NewVersionAvailableDialogKt.NewVersionAvailableDialogContent$lambda$11$lambda$10$lambda$9$lambda$8(Function0.this);
                        return NewVersionAvailableDialogContent$lambda$11$lambda$10$lambda$9$lambda$8;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonYes((Function0) rememberedValue2, false, ComposableSingletons$NewVersionAvailableDialogKt.INSTANCE.m8342getLambda$1889472662$dialogs_release_web(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
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
    public static final Unit NewVersionAvailableDialogContent$lambda$11$lambda$10$lambda$7$lambda$6(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewVersionAvailableDialogContent$lambda$11$lambda$10$lambda$9$lambda$8(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final CommonDialogUiState NewVersionAvailableDialogRoute$lambda$1(State<CommonDialogUiState> state) {
        return state.getValue();
    }
}
