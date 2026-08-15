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
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.other.AnimatedLoadingKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.home.ui.model.HomeUiState;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlayContent.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\b¨\u0006\r"}, d2 = {"PlayContent", "", "uiState", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "onClickGame", "Lkotlin/Function0;", "onClickServer", "onLongClickGame", "(Lcom/miami/game/feature/home/ui/model/HomeUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "home"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlayContentKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PlayContent$lambda$3(HomeUiState homeUiState, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
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
        ComposerKt.sourceInformation(startRestartGroup, "C(PlayContent)N(uiState,onClickGame,onClickServer,onLongClickGame)41@1705L61,42@1811L396,42@1771L436,54@2257L1248:PlayContent.kt#dswm0d");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -458132142, "CC(remember):PlayContent.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Проверка наличия обновления...", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Boolean valueOf = Boolean.valueOf(uiState.isCheckingFiles());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -458128415, "CC(remember):PlayContent.kt#9igjgp");
            PlayContentKt$PlayContent$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new PlayContentKt$PlayContent$1$1(mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, startRestartGroup, 0);
            boolean isCheckingFiles = uiState.isCheckingFiles();
            Modifier m1054paddingqDBjuR0$default = PaddingKt.m1054paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.m8160constructorimpl(12.0f), 0.0f, 11, null);
            Alignment.Horizontal end = Alignment.Companion.getEnd();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), end, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1054paddingqDBjuR0$default);
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
            Updater.m4475setimpl(m4467constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -677206807, "C61@2428L22,62@2459L36,63@2504L494:PlayContent.kt#dswm0d");
            int i3 = i2 & 14;
            OnlineContentKt.OnlineContent(uiState, startRestartGroup, i3);
            int i4 = i2 >> 3;
            ServerButtonKt.ServerButton(uiState, onClickServer, startRestartGroup, i3 | (i4 & 112));
            Modifier m1010offsetVpY3zN4$default = OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(0.0f)), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1010offsetVpY3zN4$default);
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
            Updater.m4475setimpl(m4467constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1066622857, "C64@2561L27,65@2649L339,65@2601L387:PlayContent.kt#dswm0d");
            AnimatedLoadingKt.m9791AnimatedLoadinguFdPcIQ(isCheckingFiles, 0.0f, null, startRestartGroup, 0, 6);
            ScalingButtonKt.ScalingButtonLong(onClickGame, onLongClickGame, null, ComposableLambdaKt.rememberComposableLambda(775434495, true, new Function3() { // from class: com.miami.game.feature.home.ui.compose.PlayContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PlayContent$lambda$2$0$0;
                    PlayContent$lambda$2$0$0 = PlayContentKt.PlayContent$lambda$2$0$0(HomeUiState.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PlayContent$lambda$2$0$0;
                }
            }, startRestartGroup, 54), startRestartGroup, (i4 & 14) | 3072 | ((i2 >> 6) & 112), 4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (isCheckingFiles) {
                startRestartGroup.startReplaceGroup(-676623729);
                ComposerKt.sourceInformation(startRestartGroup, "80@3106L10,81@3159L13,82@3203L13,79@3037L392");
                TextKt.m3157TextNvy7gAk((String) mutableState.getValue(), SizeKt.m1103height3ABfNKs(OffsetKt.m1010offsetVpY3zN4$default(columnScopeInstance.align(Modifier.Companion, Alignment.Companion.getStart()), Dp.m8160constructorimpl(62.0f), 0.0f, 2, null), Dp.m8160constructorimpl(24.0f)), ColorKt.Color(4294046193L), null, TypeKt.m9865dpToSp8Feqmps(Dp.m8160constructorimpl(13.0f), startRestartGroup, 6), null, null, null, 0L, null, null, TypeKt.m9865dpToSp8Feqmps(Dp.m8160constructorimpl(13.0f), startRestartGroup, 6), 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getHeadlineSmall(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 129000);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup = startRestartGroup;
                startRestartGroup.startReplaceGroup(-676229471);
                ComposerKt.sourceInformation(startRestartGroup, "90@3459L30");
                SpacerKt.Spacer(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(24.0f)), startRestartGroup, 6);
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
                    return PlayContentKt.PlayContent$lambda$3(HomeUiState.this, onClickGame, onClickServer, onLongClickGame, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayContent$lambda$2$0$0(HomeUiState homeUiState, BoxScope ScalingButtonLong, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButtonLong, "$this$ScalingButtonLong");
        ComposerKt.sourceInformation(composer, "C:PlayContent.kt#dswm0d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(775434495, i, -1, "com.miami.game.feature.home.ui.compose.PlayContent.<anonymous>.<anonymous>.<anonymous> (PlayContent.kt:66)");
            }
            if (homeUiState.isUpdateNeeded()) {
                composer.startReplaceGroup(-1659992836);
                ComposerKt.sourceInformation(composer, "");
                if (homeUiState.isPrivacyAccepted()) {
                    composer.startReplaceGroup(-1659944538);
                    ComposerKt.sourceInformation(composer, "68@2774L13");
                    ImagesKt.UpdateImage(composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-1659878105);
                    ComposerKt.sourceInformation(composer, "70@2841L12");
                    ImagesKt.SetupImage(composer, 0);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1659793351);
                ComposerKt.sourceInformation(composer, "74@2922L34");
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
