package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SocialContent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"SocialContent", "", "uiState", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "onClickSocial", "Lkotlin/Function1;", "", "(Lcom/miami/game/feature/home/ui/model/HomeUiState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "home_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocialContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SocialContent$lambda$7(HomeUiState homeUiState, Function1 function1, int i, Composer composer, int i2) {
        SocialContent(homeUiState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SocialContent(final HomeUiState uiState, final Function1<? super String, Unit> onClickSocial, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onClickSocial, "onClickSocial");
        Composer startRestartGroup = composer.startRestartGroup(-1659282498);
        ComposerKt.sourceInformation(startRestartGroup, "C(SocialContent)P(1)18@646L586:SocialContent.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onClickSocial) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1659282498, i2, -1, "com.miami.game.feature.home.ui.compose.SocialContent (SocialContent.kt:17)");
            }
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical m619spacedBy0680j_4 = Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(-Dp.m6684constructorimpl(24)));
            Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(12)), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m619spacedBy0680j_4, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m698offsetVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 578044183, "C24@869L42,23@832L128,29@1006L40,28@969L127,34@1142L40,33@1105L121:SocialContent.kt#dswm0d");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1681215404, "CC(remember):SocialContent.kt#9igjgp");
            int i3 = i2 & 112;
            int i4 = i2 & 14;
            boolean z = (i3 == 32) | (i4 == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.home.ui.compose.SocialContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SocialContent$lambda$6$lambda$1$lambda$0;
                        SocialContent$lambda$6$lambda$1$lambda$0 = SocialContentKt.SocialContent$lambda$6$lambda$1$lambda$0(Function1.this, uiState);
                        return SocialContent$lambda$6$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableSingletons$SocialContentKt.INSTANCE.getLambda$1688114711$home_release_web(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1681219786, "CC(remember):SocialContent.kt#9igjgp");
            boolean z2 = (i3 == 32) | (i4 == 4);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.home.ui.compose.SocialContentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SocialContent$lambda$6$lambda$3$lambda$2;
                        SocialContent$lambda$6$lambda$3$lambda$2 = SocialContentKt.SocialContent$lambda$6$lambda$3$lambda$2(Function1.this, uiState);
                        return SocialContent$lambda$6$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue2, null, ComposableSingletons$SocialContentKt.INSTANCE.getLambda$2011919310$home_release_web(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1681224138, "CC(remember):SocialContent.kt#9igjgp");
            boolean z3 = (i3 == 32) | (i4 == 4);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.miami.game.feature.home.ui.compose.SocialContentKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SocialContent$lambda$6$lambda$5$lambda$4;
                        SocialContent$lambda$6$lambda$5$lambda$4 = SocialContentKt.SocialContent$lambda$6$lambda$5$lambda$4(Function1.this, uiState);
                        return SocialContent$lambda$6$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue3, null, ComposableSingletons$SocialContentKt.INSTANCE.m8386getLambda$2110633905$home_release_web(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.SocialContentKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SocialContent$lambda$7;
                    SocialContent$lambda$7 = SocialContentKt.SocialContent$lambda$7(HomeUiState.this, onClickSocial, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SocialContent$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SocialContent$lambda$6$lambda$1$lambda$0(Function1 function1, HomeUiState homeUiState) {
        function1.invoke(homeUiState.getDiscLink());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SocialContent$lambda$6$lambda$3$lambda$2(Function1 function1, HomeUiState homeUiState) {
        function1.invoke(homeUiState.getTgLink());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SocialContent$lambda$6$lambda$5$lambda$4(Function1 function1, HomeUiState homeUiState) {
        function1.invoke(homeUiState.getVkLink());
        return Unit.INSTANCE;
    }
}
