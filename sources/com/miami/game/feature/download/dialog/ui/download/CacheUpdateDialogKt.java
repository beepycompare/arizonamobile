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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
/* compiled from: CacheUpdateDialog.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a1\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\r\u001a1\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"CacheUpdateDialogRoute", "", "component", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "onBackClick", "Lkotlin/Function0;", "navigateToDownloadScreen", "(Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CacheUpdateDialogScreen", "uiState", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;", "onConfirm", "onDismiss", "(Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CacheUpdateDialogContent", "updateSize", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CacheUpdateDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CacheUpdateDialogContent$lambda$1(String str, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        CacheUpdateDialogContent(str, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CacheUpdateDialogRoute$lambda$4(CommonDialogComponent commonDialogComponent, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        CacheUpdateDialogRoute(commonDialogComponent, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CacheUpdateDialogScreen$lambda$0(CommonDialogUiState commonDialogUiState, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        CacheUpdateDialogScreen(commonDialogUiState, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CacheUpdateDialogRoute(final CommonDialogComponent component, final Function0<Unit> onBackClick, final Function0<Unit> navigateToDownloadScreen, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(navigateToDownloadScreen, "navigateToDownloadScreen");
        Composer startRestartGroup = composer.startRestartGroup(101938191);
        ComposerKt.sourceInformation(startRestartGroup, "C(CacheUpdateDialogRoute)N(component,onBackClick,navigateToDownloadScreen)31@1477L33,33@1572L198,33@1535L235,41@1809L29,45@1916L20,46@1958L20,43@1844L141:CacheUpdateDialog.kt#as3uag");
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
                ComposerKt.traceEventStart(101938191, i2, -1, "com.miami.game.feature.download.dialog.ui.download.CacheUpdateDialogRoute (CacheUpdateDialog.kt:30)");
            }
            int i3 = i2 & 112;
            BackHandlerKt.BackHandler(false, onBackClick, startRestartGroup, i3, 1);
            SharedEventFlow<CommonDialogUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -821638379, "CC(remember):CacheUpdateDialog.kt#9igjgp");
            boolean z = (i3 == 32) | ((i2 & 896) == 256);
            CacheUpdateDialogKt$CacheUpdateDialogRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new CacheUpdateDialogKt$CacheUpdateDialogRoute$1$1(onBackClick, navigateToDownloadScreen, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, startRestartGroup, 0, 6);
            startRestartGroup = startRestartGroup;
            CommonDialogUiState CacheUpdateDialogRoute$lambda$1 = CacheUpdateDialogRoute$lambda$1(FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -821627549, "CC(remember):CacheUpdateDialog.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(component);
            CacheUpdateDialogKt$CacheUpdateDialogRoute$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new CacheUpdateDialogKt$CacheUpdateDialogRoute$2$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function0 function0 = (Function0) ((KFunction) rememberedValue2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -821626205, "CC(remember):CacheUpdateDialog.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(component);
            CacheUpdateDialogKt$CacheUpdateDialogRoute$3$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new CacheUpdateDialogKt$CacheUpdateDialogRoute$3$1(component);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CacheUpdateDialogScreen(CacheUpdateDialogRoute$lambda$1, function0, (Function0) ((KFunction) rememberedValue3), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.download.CacheUpdateDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CacheUpdateDialogRoute$lambda$4;
                    CacheUpdateDialogRoute$lambda$4 = CacheUpdateDialogKt.CacheUpdateDialogRoute$lambda$4(CommonDialogComponent.this, onBackClick, navigateToDownloadScreen, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CacheUpdateDialogRoute$lambda$4;
                }
            });
        }
    }

    public static final void CacheUpdateDialogScreen(final CommonDialogUiState uiState, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(1364349116);
        ComposerKt.sourceInformation(startRestartGroup, "C(CacheUpdateDialogScreen)N(uiState,onConfirm,onDismiss)57@2193L138:CacheUpdateDialog.kt#as3uag");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1364349116, i2, -1, "com.miami.game.feature.download.dialog.ui.download.CacheUpdateDialogScreen (CacheUpdateDialog.kt:56)");
            }
            CacheUpdateDialogContent(uiState.getDescriptionText(), onConfirm, onDismiss, startRestartGroup, i2 & 1008);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.download.CacheUpdateDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CacheUpdateDialogScreen$lambda$0;
                    CacheUpdateDialogScreen$lambda$0 = CacheUpdateDialogKt.CacheUpdateDialogScreen$lambda$0(CommonDialogUiState.this, onConfirm, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CacheUpdateDialogScreen$lambda$0;
                }
            });
        }
    }

    public static final void CacheUpdateDialogContent(final String updateSize, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(352303246);
        ComposerKt.sourceInformation(startRestartGroup, "C(CacheUpdateDialogContent)N(updateSize,onConfirm,onDismiss)71@2603L864,71@2530L937:CacheUpdateDialog.kt#as3uag");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(updateSize) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            function0 = onDismiss;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(352303246, i2, -1, "com.miami.game.feature.download.dialog.ui.download.CacheUpdateDialogContent (CacheUpdateDialog.kt:70)");
            }
            function0 = onDismiss;
            DialogFrameKt.DialogFrame(Integer.valueOf(R.drawable.dialog_frame_background_download_icon), function0, ComposableLambdaKt.rememberComposableLambda(-1885731162, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.download.CacheUpdateDialogKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CacheUpdateDialogContent$lambda$0;
                    CacheUpdateDialogContent$lambda$0 = CacheUpdateDialogKt.CacheUpdateDialogContent$lambda$0(updateSize, onDismiss, onConfirm, (Composer) obj, ((Integer) obj2).intValue());
                    return CacheUpdateDialogContent$lambda$0;
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 3) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.download.CacheUpdateDialogKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CacheUpdateDialogContent$lambda$1;
                    CacheUpdateDialogContent$lambda$1 = CacheUpdateDialogKt.CacheUpdateDialogContent$lambda$1(updateSize, onConfirm, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CacheUpdateDialogContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CacheUpdateDialogContent$lambda$0(String str, final Function0 function0, final Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@2640L10,72@2613L87,75@2728L85,74@2709L217,82@2935L97,83@3041L419:CacheUpdateDialog.kt#as3uag");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1885731162, i, -1, "com.miami.game.feature.download.dialog.ui.download.CacheUpdateDialogContent.<anonymous> (CacheUpdateDialog.kt:72)");
            }
            TextKt.m2814Text4IGK_g("ОБНОВЛЕНИЕ КЭША", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, (int) WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.dialog_frame_download_image, composer, 0), (String) null, SizeKt.m894size3ABfNKs(Modifier.Companion, Dp.m7264constructorimpl(100)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 432, (int) MenuKt.InTransitionDuration);
            DialogDescriptionTextKt.DialogDescriptionText("Данная версия устарела, необходимо загрузить версию 4.3.1az0 " + str, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
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
            Composer m3867constructorimpl = Updater.m3867constructorimpl(composer);
            Updater.m3874setimpl(m3867constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3874setimpl(m3867constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3867constructorimpl.getInserting() || !Intrinsics.areEqual(m3867constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                m3867constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                m3867constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.m3874setimpl(m3867constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1035232358, "C84@3084L43,84@3059L187,90@3285L43,90@3259L191:CacheUpdateDialog.kt#as3uag");
            ComposerKt.sourceInformationMarkerStart(composer, 1352079181, "CC(remember):CacheUpdateDialog.kt#9igjgp");
            boolean changed = composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.download.CacheUpdateDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CacheUpdateDialogContent$lambda$0$0$0$0;
                        CacheUpdateDialogContent$lambda$0$0$0$0 = CacheUpdateDialogKt.CacheUpdateDialogContent$lambda$0$0$0$0(Function0.this);
                        return CacheUpdateDialogContent$lambda$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonNo((Function0) rememberedValue, ComposableSingletons$CacheUpdateDialogKt.INSTANCE.getLambda$2143907042$dialogs_release(), composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, 1352085613, "CC(remember):CacheUpdateDialog.kt#9igjgp");
            boolean changed2 = composer.changed(function02);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.download.CacheUpdateDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CacheUpdateDialogContent$lambda$0$0$1$0;
                        CacheUpdateDialogContent$lambda$0$0$1$0 = CacheUpdateDialogKt.CacheUpdateDialogContent$lambda$0$0$1$0(Function0.this);
                        return CacheUpdateDialogContent$lambda$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonYes((Function0) rememberedValue2, false, ComposableSingletons$CacheUpdateDialogKt.INSTANCE.getLambda$1292262873$dialogs_release(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
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
    public static final Unit CacheUpdateDialogContent$lambda$0$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CacheUpdateDialogContent$lambda$0$0$1$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final CommonDialogUiState CacheUpdateDialogRoute$lambda$1(State<CommonDialogUiState> state) {
        return state.getValue();
    }
}
