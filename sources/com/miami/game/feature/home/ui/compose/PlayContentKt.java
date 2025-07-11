package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.other.AnimatedLoadingKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.home.ui.model.HomeUiState;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlayContent.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"PlayContent", "", "uiState", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "onClickGame", "Lkotlin/Function0;", "onClickServer", "onLongClickGame", "(Lcom/miami/game/feature/home/ui/model/HomeUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "home_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayContent$lambda$5(HomeUiState homeUiState, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        PlayContent(homeUiState, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PlayContent(final HomeUiState uiState, final Function0<Unit> onClickGame, final Function0<Unit> onClickServer, final Function0<Unit> onLongClickGame, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onClickGame, "onClickGame");
        Intrinsics.checkNotNullParameter(onClickServer, "onClickServer");
        Intrinsics.checkNotNullParameter(onLongClickGame, "onLongClickGame");
        Composer startRestartGroup = composer.startRestartGroup(1510136117);
        ComposerKt.sourceInformation(startRestartGroup, "C(PlayContent)P(3)41@1702L61,42@1808L396,42@1768L436,54@2254L1217:PlayContent.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickGame) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickServer) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onLongClickGame) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1510136117, i2, -1, "com.miami.game.feature.home.ui.compose.PlayContent (PlayContent.kt:40)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -458131470, "CC(remember):PlayContent.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Проверка наличия обновления...", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Boolean valueOf = Boolean.valueOf(uiState.isCheckingFiles());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -458127743, "CC(remember):PlayContent.kt#9igjgp");
            PlayContentKt$PlayContent$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new PlayContentKt$PlayContent$1$1(mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, startRestartGroup, 0);
            boolean isCheckingFiles = uiState.isCheckingFiles();
            Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.m6684constructorimpl(12), 0.0f, 11, null);
            Alignment.Horizontal end = Alignment.Companion.getEnd();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), end, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m742paddingqDBjuR0$default);
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
            Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -677207768, "C61@2425L36,62@2470L494:PlayContent.kt#dswm0d");
            int i3 = i2 >> 3;
            ServerButtonKt.ServerButton(uiState, onClickServer, startRestartGroup, (i2 & 14) | (i3 & 112));
            Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(0)), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m698offsetVpY3zN4$default);
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
            Updater.m3527setimpl(m3520constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1066622857, "C63@2527L27,64@2615L339,64@2567L387:PlayContent.kt#dswm0d");
            AnimatedLoadingKt.m8316AnimatedLoadinguFdPcIQ(isCheckingFiles, 0.0f, null, startRestartGroup, 0, 6);
            ScalingButtonKt.ScalingButtonLong(onClickGame, onLongClickGame, null, ComposableLambdaKt.rememberComposableLambda(775434495, true, new Function3() { // from class: com.miami.game.feature.home.ui.compose.PlayContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PlayContent$lambda$4$lambda$3$lambda$2;
                    PlayContent$lambda$4$lambda$3$lambda$2 = PlayContentKt.PlayContent$lambda$4$lambda$3$lambda$2(HomeUiState.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PlayContent$lambda$4$lambda$3$lambda$2;
                }
            }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | 3072 | ((i2 >> 6) & 112), 4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (isCheckingFiles) {
                startRestartGroup.startReplaceGroup(-676667625);
                ComposerKt.sourceInformation(startRestartGroup, "79@3072L10,80@3125L13,81@3169L13,78@3003L392");
                float f = 13;
                TextKt.m2497Text4IGK_g((String) mutableState.getValue(), SizeKt.m771height3ABfNKs(OffsetKt.m698offsetVpY3zN4$default(columnScopeInstance.align(Modifier.Companion, Alignment.Companion.getStart()), Dp.m6684constructorimpl(62), 0.0f, 2, null), Dp.m6684constructorimpl(24)), ColorKt.Color(4294046193L), TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(f), startRestartGroup, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(f), startRestartGroup, 6), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getHeadlineSmall(), startRestartGroup, (int) RendererCapabilities.DECODER_SUPPORT_MASK, 0, 64496);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup = startRestartGroup;
                startRestartGroup.startReplaceGroup(-676260223);
                ComposerKt.sourceInformation(startRestartGroup, "89@3425L30");
                SpacerKt.Spacer(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(24)), startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.PlayContentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PlayContent$lambda$5;
                    PlayContent$lambda$5 = PlayContentKt.PlayContent$lambda$5(HomeUiState.this, onClickGame, onClickServer, onLongClickGame, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PlayContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayContent$lambda$4$lambda$3$lambda$2(HomeUiState homeUiState, BoxScope ScalingButtonLong, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButtonLong, "$this$ScalingButtonLong");
        ComposerKt.sourceInformation(composer, "C:PlayContent.kt#dswm0d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(775434495, i, -1, "com.miami.game.feature.home.ui.compose.PlayContent.<anonymous>.<anonymous>.<anonymous> (PlayContent.kt:65)");
            }
            if (homeUiState.isUpdateNeeded()) {
                composer.startReplaceGroup(-1659992836);
                ComposerKt.sourceInformation(composer, "");
                if (homeUiState.isPrivacyAccepted()) {
                    composer.startReplaceGroup(-1659944538);
                    ComposerKt.sourceInformation(composer, "67@2740L13");
                    ImagesKt.UpdateImage(composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-1659878105);
                    ComposerKt.sourceInformation(composer, "69@2807L12");
                    ImagesKt.SetupImage(composer, 0);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1659793351);
                ComposerKt.sourceInformation(composer, "73@2888L34");
                ImagesKt.PlayImage(homeUiState.isCheckingFiles(), composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
