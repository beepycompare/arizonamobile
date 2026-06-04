package com.miami.game.feature.download.screen.ui.compose;

import android.net.Uri;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.download.screen.ui.model.DownloadScreenUiState;
import com.miami.game.ui.classic.download.screen.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DownloadContent.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"DownloadContent", "", "uiState", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiState;", "onSoundClick", "Lkotlin/Function0;", "(Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "download-screen"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloadContentKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DownloadContent$lambda$1(DownloadScreenUiState downloadScreenUiState, Function0 function0, int i, Composer composer, int i2) {
        DownloadContent(downloadScreenUiState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    public static final void DownloadContent(final DownloadScreenUiState uiState, final Function0<Unit> onSoundClick, Composer composer, final int i) {
        int i2;
        int i3;
        ?? r2;
        boolean z;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onSoundClick, "onSoundClick");
        Composer startRestartGroup = composer.startRestartGroup(-321713629);
        ComposerKt.sourceInformation(startRestartGroup, "C(DownloadContent)N(uiState,onSoundClick)45@1734L1902:DownloadContent.kt#k3v2wi");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onSoundClick) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-321713629, i2, -1, "com.miami.game.feature.download.screen.ui.compose.DownloadContent (DownloadContent.kt:25)");
            }
            Uri videoUri = uiState.getVideoUri();
            if (videoUri != null && !uiState.isLauncherUpdate()) {
                startRestartGroup.startReplaceGroup(-2098511801);
                ComposerKt.sourceInformation(startRestartGroup, "29@1235L40");
                VideoPlayerKt.ExoPlayerView(videoUri, uiState.getSoundOn(), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                r2 = 1;
            } else {
                startRestartGroup.startReplaceGroup(-2098438362);
                ComposerKt.sourceInformation(startRestartGroup, "38@1546L34,37@1517L205");
                if (uiState.isArizona()) {
                    i3 = R.drawable.arizona_launcher_update;
                } else {
                    i3 = R.drawable.rodina_launcher_update;
                }
                r2 = 1;
                ImageKt.Image(PainterResources_androidKt.painterResource(i3, startRestartGroup, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
                startRestartGroup.endReplaceGroup();
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, r2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 246916252, "C75@2776L854:DownloadContent.kt#k3v2wi");
            if (!uiState.isLauncherUpdate()) {
                startRestartGroup.startReplaceGroup(246919258);
                ComposerKt.sourceInformation(startRestartGroup, "59@2247L509,55@2097L659");
                z = r2;
                i4 = i2;
                i5 = 4;
                ScalingButtonKt.ScalingButton(onSoundClick, boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getTopEnd()), ComposableLambdaKt.rememberComposableLambda(-2005235955, r2, new Function3() { // from class: com.miami.game.feature.download.screen.ui.compose.DownloadContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit DownloadContent$lambda$0$0;
                        DownloadContent$lambda$0$0 = DownloadContentKt.DownloadContent$lambda$0$0(DownloadScreenUiState.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return DownloadContent$lambda$0$0;
                    }
                }, startRestartGroup, 54), startRestartGroup, ((i2 >> 3) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                z = r2;
                i4 = i2;
                i5 = 4;
                startRestartGroup.startReplaceGroup(247575621);
                startRestartGroup.endReplaceGroup();
            }
            Modifier align = boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomCenter());
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl2 = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2040833599, "C81@2995L10,80@2951L199,86@3207L10,85@3163L235,94@3566L40,91@3411L209:DownloadContent.kt#k3v2wi");
            int i6 = i5;
            TextKt.m3157TextNvy7gAk(uiState.getTextDownload() + " " + uiState.getDownloadingStringState(), null, Color.Companion.m5385getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131066);
            TextKt.m3157TextNvy7gAk("Осталось времени: " + uiState.getTimeRemainingString(), null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(10), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall(), startRestartGroup, 24960, 0, 131050);
            startRestartGroup = startRestartGroup;
            Modifier m1051paddingVpY3zN4 = PaddingKt.m1051paddingVpY3zN4(Modifier.Companion, Dp.m8160constructorimpl(32.0f), Dp.m8160constructorimpl(28.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873810257, "CC(remember):DownloadContent.kt#9igjgp");
            boolean z2 = (i4 & 14) == i6 ? z : false;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.screen.ui.compose.DownloadContentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        float DownloadContent$lambda$0$1$0$0;
                        DownloadContent$lambda$0$1$0$0 = DownloadContentKt.DownloadContent$lambda$0$1$0$0(DownloadScreenUiState.this);
                        return Float.valueOf(DownloadContent$lambda$0$1$0$0);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ProgressBarKt.CustomLinerProgressBar((Function0) rememberedValue, m1051paddingVpY3zN4, startRestartGroup, 48, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.screen.ui.compose.DownloadContentKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DownloadContentKt.DownloadContent$lambda$1(DownloadScreenUiState.this, onSoundClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloadContent$lambda$0$0(DownloadScreenUiState downloadScreenUiState, BoxScope ScalingButton, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C66@2507L25,65@2480L262:DownloadContent.kt#k3v2wi");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2005235955, i, -1, "com.miami.game.feature.download.screen.ui.compose.DownloadContent.<anonymous>.<anonymous> (DownloadContent.kt:60)");
            }
            if (downloadScreenUiState.getSoundOn()) {
                i2 = com.miami.game.core.drawable.resources.R.drawable.download_screen_sound_btn;
            } else {
                i2 = com.miami.game.core.drawable.resources.R.drawable.download_screen_sound_btn_off;
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i2, composer, 0), (String) null, PaddingKt.m1054paddingqDBjuR0$default(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(80.0f)), 0.0f, Dp.m8160constructorimpl(24.0f), 0.0f, 0.0f, 13, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DownloadContent$lambda$0$1$0$0(DownloadScreenUiState downloadScreenUiState) {
        return (float) downloadScreenUiState.getPercentageProgress();
    }
}
