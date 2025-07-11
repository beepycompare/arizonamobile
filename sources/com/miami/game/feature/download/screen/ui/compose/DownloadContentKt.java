package com.miami.game.feature.download.screen.ui.compose;

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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.feature.download.screen.ui.model.DownloadScreenUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DownloadContent.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"DownloadContent", "", "uiState", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiState;", "onSoundClick", "Lkotlin/Function0;", "(Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "download-screen_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloadContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloadContent$lambda$5(DownloadScreenUiState downloadScreenUiState, Function0 function0, int i, Composer composer, int i2) {
        DownloadContent(downloadScreenUiState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v17 */
    public static final void DownloadContent(final DownloadScreenUiState uiState, final Function0<Unit> onSoundClick, Composer composer, final int i) {
        int i2;
        float f;
        ?? r6;
        ?? r2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onSoundClick, "onSoundClick");
        Composer startRestartGroup = composer.startRestartGroup(-321713629);
        ComposerKt.sourceInformation(startRestartGroup, "C(DownloadContent)P(1)33@1408L1821:DownloadContent.kt#k3v2wi");
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
            if (uiState.getVideoUri() == null || uiState.isLauncherUpdate()) {
                startRestartGroup.startReplaceGroup(-2098472090);
                ComposerKt.sourceInformation(startRestartGroup, "29@1234L42,29@1228L169");
                f = 0.0f;
                r6 = 0;
                r2 = 1;
                ImageKt.Image(PainterResources_androidKt.painterResource(uiState.getLauncherUpdateRes(), startRestartGroup, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(70852819);
                ComposerKt.sourceInformation(startRestartGroup, "28@1164L48");
                VideoPlayerKt.ExoPlayerView(uiState.getVideoUri(), uiState.getSoundOn(), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                f = 0.0f;
                r2 = 1;
                r6 = 0;
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, f, r2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), r6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r6);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 246913741, "C63@2450L773:DownloadContent.kt#k3v2wi");
            if (uiState.isLauncherUpdate()) {
                i3 = r2;
                i4 = i2;
                i5 = 4;
                i6 = 0;
                i7 = 32;
                startRestartGroup.startReplaceGroup(245154149);
            } else {
                startRestartGroup.startReplaceGroup(246919258);
                ComposerKt.sourceInformation(startRestartGroup, "47@1921L509,43@1771L659");
                i3 = r2;
                i4 = i2;
                i5 = 4;
                i6 = 0;
                i7 = 32;
                ScalingButtonKt.ScalingButton(onSoundClick, boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getTopEnd()), ComposableLambdaKt.rememberComposableLambda(-2005235955, r2, new Function3() { // from class: com.miami.game.feature.download.screen.ui.compose.DownloadContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit DownloadContent$lambda$4$lambda$0;
                        DownloadContent$lambda$4$lambda$0 = DownloadContentKt.DownloadContent$lambda$4$lambda$0(DownloadScreenUiState.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return DownloadContent$lambda$4$lambda$0;
                    }
                }, startRestartGroup, 54), startRestartGroup, ((i2 >> 3) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            }
            startRestartGroup.endReplaceGroup();
            Modifier align = boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomCenter());
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i6);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2040831088, "C68@2652L10,68@2625L169,71@2834L10,71@2807L205,77@3159L40,75@3025L188:DownloadContent.kt#k3v2wi");
            int i8 = i6;
            int i9 = i5;
            TextKt.m2497Text4IGK_g(uiState.getTextDownload() + " " + uiState.getDownloadingStringState(), (Modifier) null, Color.Companion.m4115getWhite0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, (int) RendererCapabilities.DECODER_SUPPORT_MASK, 0, 65530);
            TextKt.m2497Text4IGK_g("Осталось времени: " + uiState.getTimeRemainingString(), (Modifier) null, Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 3456, 0, 65522);
            startRestartGroup = startRestartGroup;
            Modifier m739paddingVpY3zN4 = PaddingKt.m739paddingVpY3zN4(Modifier.Companion, Dp.m6684constructorimpl(i7), Dp.m6684constructorimpl(28));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873812849, "CC(remember):DownloadContent.kt#9igjgp");
            int i10 = (i4 & 14) == i9 ? i3 : i8;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (i10 != 0 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.screen.ui.compose.DownloadContentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        float DownloadContent$lambda$4$lambda$3$lambda$2$lambda$1;
                        DownloadContent$lambda$4$lambda$3$lambda$2$lambda$1 = DownloadContentKt.DownloadContent$lambda$4$lambda$3$lambda$2$lambda$1(DownloadScreenUiState.this);
                        return Float.valueOf(DownloadContent$lambda$4$lambda$3$lambda$2$lambda$1);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ProgressBarKt.CustomLinerProgressBar((Function0) rememberedValue, m739paddingVpY3zN4, startRestartGroup, 48, i8);
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
                    Unit DownloadContent$lambda$5;
                    DownloadContent$lambda$5 = DownloadContentKt.DownloadContent$lambda$5(DownloadScreenUiState.this, onSoundClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DownloadContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloadContent$lambda$4$lambda$0(DownloadScreenUiState downloadScreenUiState, BoxScope ScalingButton, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C54@2181L25,53@2154L262:DownloadContent.kt#k3v2wi");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2005235955, i, -1, "com.miami.game.feature.download.screen.ui.compose.DownloadContent.<anonymous>.<anonymous> (DownloadContent.kt:48)");
            }
            if (downloadScreenUiState.getSoundOn()) {
                i2 = R.drawable.download_screen_sound_btn;
            } else {
                i2 = R.drawable.download_screen_sound_btn_off;
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i2, composer, 0), (String) null, PaddingKt.m742paddingqDBjuR0$default(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(80)), 0.0f, Dp.m6684constructorimpl(24), 0.0f, 0.0f, 13, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, composer, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DownloadContent$lambda$4$lambda$3$lambda$2$lambda$1(DownloadScreenUiState downloadScreenUiState) {
        return (float) downloadScreenUiState.getPercentageProgress();
    }
}
