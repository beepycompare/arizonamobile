package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.theme.RoundedParallelogramLeftShape;
import com.miami.game.feature.home.R;
import com.miami.game.feature.home.ui.model.HomeUiState;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OnlineContent.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"OnlineContent", "", "uiState", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "(Lcom/miami/game/feature/home/ui/model/HomeUiState;Landroidx/compose/runtime/Composer;I)V", "home_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OnlineContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnlineContent$lambda$1(HomeUiState homeUiState, int i, Composer composer, int i2) {
        OnlineContent(homeUiState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OnlineContent(final HomeUiState uiState, Composer composer, final int i) {
        int i2;
        Composer composer2;
        int i3;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Composer startRestartGroup = composer.startRestartGroup(400238897);
        ComposerKt.sourceInformation(startRestartGroup, "C(OnlineContent)N(uiState)45@2076L2425:OnlineContent.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(400238897, i2, -1, "com.miami.game.feature.home.ui.compose.OnlineContent (OnlineContent.kt:44)");
            }
            Modifier m930paddingVpY3zN4$default = PaddingKt.m930paddingVpY3zN4$default(BorderKt.m316borderziNgDLE(BackgroundKt.m298backgroundbw27NRU(PaddingKt.m932paddingqDBjuR0$default(SizeKt.m962height3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(27)), 0.0f, 0.0f, 0.0f, Dp.m8258constructorimpl(6), 7, null), Color.m5423copywmQWz5c$default(Color.Companion.m5450getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), new RoundedParallelogramLeftShape(0.0f, 0.04f, 1, null)), Dp.m8258constructorimpl(1), Brush.Companion.m5379verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5414boximpl(Color.m5423copywmQWz5c$default(Color.Companion.m5456getLightGray0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5414boximpl(Color.Companion.m5459getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), new RoundedParallelogramLeftShape(0.0f, 0.04f, 1, null)), Dp.m8258constructorimpl(14), 0.0f, 2, null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m930paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4673constructorimpl = Updater.m4673constructorimpl(startRestartGroup);
            Updater.m4681setimpl(m4673constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 349516311, "C64@2868L1623:OnlineContent.kt#dswm0d");
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null);
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m783spacedBy0680j_4(Dp.m8258constructorimpl(4)), centerVertically2, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4673constructorimpl2 = Updater.m4673constructorimpl(startRestartGroup);
            Updater.m4681setimpl(m4673constructorimpl2, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 756125618, "C91@3966L10,92@4019L13,88@3847L203,95@4094L37,94@4067L166,102@4393L10,103@4446L13,99@4250L227:OnlineContent.kt#dswm0d");
            if (uiState.getQueue() <= 0) {
                i3 = 0;
                startRestartGroup.startReplaceGroup(753028841);
            } else {
                startRestartGroup.startReplaceGroup(756124780);
                ComposerKt.sourceInformation(startRestartGroup, "73@3251L10,74@3308L13,70@3119L224,77@3395L36,76@3364L181,84@3720L10,85@3777L13,81@3566L246");
                float f = 11;
                i3 = 0;
                TextKt.m3255TextNvy7gAk("Очередь", null, Color.Companion.m5461getWhite0d7_KjU(), null, TypeKt.m10183dpToSp8Feqmps(Dp.m8258constructorimpl(f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 390, 0, 131050);
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.queue_ic, startRestartGroup, 0), (String) null, SizeKt.m976size3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(13)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
                TextKt.m3255TextNvy7gAk(String.valueOf(uiState.getQueue()), null, Color.Companion.m5461getWhite0d7_KjU(), null, TypeKt.m10183dpToSp8Feqmps(Dp.m8258constructorimpl(f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131050);
                startRestartGroup = startRestartGroup;
            }
            startRestartGroup.endReplaceGroup();
            float f2 = 11;
            composer2 = startRestartGroup;
            TextKt.m3255TextNvy7gAk("Онлайн", null, Color.Companion.m5461getWhite0d7_KjU(), null, TypeKt.m10183dpToSp8Feqmps(Dp.m8258constructorimpl(f2), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), composer2, 390, 0, 131050);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.online_ic, composer2, i3), (String) null, SizeKt.m976size3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(13)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer2, Painter.$stable | 432, 120);
            TextKt.m3255TextNvy7gAk(String.valueOf(uiState.getOnline()), null, Color.Companion.m5461getWhite0d7_KjU(), null, TypeKt.m10183dpToSp8Feqmps(Dp.m8258constructorimpl(f2), composer2, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0, 131050);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.OnlineContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnlineContent$lambda$1;
                    OnlineContent$lambda$1 = OnlineContentKt.OnlineContent$lambda$1(HomeUiState.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OnlineContent$lambda$1;
                }
            });
        }
    }
}
