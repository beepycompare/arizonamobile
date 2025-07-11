package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.home.ui.model.HomeUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MenuContent.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"MenuContent", "", "uiState", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "notificationState", "Landroidx/compose/runtime/State;", "", "onClickAccount", "Lkotlin/Function0;", "onClickForum", "onClickSettings", "onClickNotificaions", "(Lcom/miami/game/feature/home/ui/model/HomeUiState;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "home_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MenuContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MenuContent$lambda$3(HomeUiState homeUiState, State state, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Composer composer, int i2) {
        MenuContent(homeUiState, state, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MenuContent(final HomeUiState uiState, final State<Integer> notificationState, final Function0<Unit> onClickAccount, final Function0<Unit> onClickForum, final Function0<Unit> onClickSettings, final Function0<Unit> onClickNotificaions, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(notificationState, "notificationState");
        Intrinsics.checkNotNullParameter(onClickAccount, "onClickAccount");
        Intrinsics.checkNotNullParameter(onClickForum, "onClickForum");
        Intrinsics.checkNotNullParameter(onClickSettings, "onClickSettings");
        Intrinsics.checkNotNullParameter(onClickNotificaions, "onClickNotificaions");
        Composer startRestartGroup = composer.startRestartGroup(1146511910);
        ComposerKt.sourceInformation(startRestartGroup, "C(MenuContent)P(5!3,4)25@879L823:MenuContent.kt#dswm0d");
        if ((i & 48) == 0) {
            i2 = (startRestartGroup.changed(notificationState) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickAccount) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickForum) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickSettings) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickNotificaions) ? 131072 : 65536;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((74897 & i3) != 74896, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1146511910, i3, -1, "com.miami.game.feature.home.ui.compose.MenuContent (MenuContent.kt:24)");
            }
            float f = 24;
            Modifier m742paddingqDBjuR0$default = PaddingKt.m742paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.m6684constructorimpl(f), 0.0f, 11, null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(4)), centerVertically, startRestartGroup, 54);
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
            Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1874684794, "C32@1089L499,48@1597L99:MenuContent.kt#dswm0d");
            Modifier m740paddingVpY3zN4$default = PaddingKt.m740paddingVpY3zN4$default(Modifier.Companion, 0.0f, 0.0f, 3, null);
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f))), centerVertically2, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m740paddingVpY3zN4$default);
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
            Updater.m3527setimpl(m3520constructorimpl2, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1720621375, "C38@1335L69,38@1300L104,41@1417L76,44@1506L72:MenuContent.kt#dswm0d");
            ScalingButtonKt.ScalingButton(onClickNotificaions, null, ComposableLambdaKt.rememberComposableLambda(2120753955, true, new Function3() { // from class: com.miami.game.feature.home.ui.compose.MenuContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MenuContent$lambda$2$lambda$1$lambda$0;
                    MenuContent$lambda$2$lambda$1$lambda$0 = MenuContentKt.MenuContent$lambda$2$lambda$1$lambda$0(State.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MenuContent$lambda$2$lambda$1$lambda$0;
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 15) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            startRestartGroup = startRestartGroup;
            ScalingButtonKt.ScalingButton(onClickAccount, null, ComposableSingletons$MenuContentKt.INSTANCE.m8382getLambda$432014182$home_release_web(), startRestartGroup, ((i3 >> 6) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            ScalingButtonKt.ScalingButton(onClickForum, null, ComposableSingletons$MenuContentKt.INSTANCE.m8383getLambda$989998245$home_release_web(), startRestartGroup, ((i3 >> 9) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton(onClickSettings, OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(0)), 1, null), ComposableSingletons$MenuContentKt.INSTANCE.getLambda$1483995263$home_release_web(), startRestartGroup, ((i3 >> 12) & 14) | 432, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.MenuContentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MenuContent$lambda$3;
                    MenuContent$lambda$3 = MenuContentKt.MenuContent$lambda$3(HomeUiState.this, notificationState, onClickAccount, onClickForum, onClickSettings, onClickNotificaions, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MenuContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MenuContent$lambda$2$lambda$1$lambda$0(State state, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C39@1353L37:MenuContent.kt#dswm0d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2120753955, i, -1, "com.miami.game.feature.home.ui.compose.MenuContent.<anonymous>.<anonymous>.<anonymous> (MenuContent.kt:39)");
            }
            ImagesKt.NotificationsImage(state, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
