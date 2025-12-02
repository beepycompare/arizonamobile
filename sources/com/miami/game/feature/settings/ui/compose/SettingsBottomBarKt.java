package com.miami.game.feature.settings.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.other.CustomDividerKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsBottomBar.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"SettingsBottomBar", "", "onBugsReport", "Lkotlin/Function0;", "onShareLogs", "onPrivacyPolicy", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "settings_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsBottomBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsBottomBar$lambda$1(Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        SettingsBottomBar(function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SettingsBottomBar(Function0<Unit> onBugsReport, final Function0<Unit> onShareLogs, Function0<Unit> onPrivacyPolicy, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final Function0<Unit> function02;
        Intrinsics.checkNotNullParameter(onBugsReport, "onBugsReport");
        Intrinsics.checkNotNullParameter(onShareLogs, "onShareLogs");
        Intrinsics.checkNotNullParameter(onPrivacyPolicy, "onPrivacyPolicy");
        Composer startRestartGroup = composer.startRestartGroup(943966847);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsBottomBar)N(onBugsReport,onShareLogs,onPrivacyPolicy)32@1311L1782:SettingsBottomBar.kt#1gr92h");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onBugsReport) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onShareLogs) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onPrivacyPolicy) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            function0 = onBugsReport;
            function02 = onPrivacyPolicy;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(943966847, i3, -1, "com.miami.game.feature.settings.ui.compose.SettingsBottomBar (SettingsBottomBar.kt:31)");
            }
            Modifier background$default = BackgroundKt.background$default(SizeKt.fillMaxWidth$default(OffsetKt.m798offsetVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m7996constructorimpl(8), 1, null), 0.0f, 1, null), Brush.Companion.m5236verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5270boximpl(Color.m5279copywmQWz5c$default(Color.Companion.m5306getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5270boximpl(Color.Companion.m5315getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, background$default);
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
            Composer m4598constructorimpl = Updater.m4598constructorimpl(startRestartGroup);
            Updater.m4605setimpl(m4598constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4605setimpl(m4598constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4598constructorimpl.getInserting() || !Intrinsics.areEqual(m4598constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                m4598constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                m4598constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.m4605setimpl(m4598constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 952786830, "C45@1663L1281,79@2953L134:SettingsBottomBar.kt#1gr92h");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Composer m4598constructorimpl2 = Updater.m4598constructorimpl(startRestartGroup);
            Updater.m4605setimpl(m4598constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4605setimpl(m4598constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4598constructorimpl2.getInserting() || !Intrinsics.areEqual(m4598constructorimpl2.rememberedValue(), Integer.valueOf(hashCode2))) {
                m4598constructorimpl2.updateRememberedValue(Integer.valueOf(hashCode2));
                m4598constructorimpl2.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
            }
            Updater.m4605setimpl(m4598constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 60742637, "C50@1801L1133:SettingsBottomBar.kt#1gr92h");
            Modifier m881height3ABfNKs = SizeKt.m881height3ABfNKs(Modifier.Companion, Dp.m7996constructorimpl(76));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m702spacedBy0680j_4(Dp.m7996constructorimpl(-Dp.m7996constructorimpl(28))), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m881height3ABfNKs);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4598constructorimpl3 = Updater.m4598constructorimpl(startRestartGroup);
            Updater.m4605setimpl(m4598constructorimpl3, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4605setimpl(m4598constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4598constructorimpl3.getInserting() || !Intrinsics.areEqual(m4598constructorimpl3.rememberedValue(), Integer.valueOf(hashCode3))) {
                m4598constructorimpl3.updateRememberedValue(Integer.valueOf(hashCode3));
                m4598constructorimpl3.apply(Integer.valueOf(hashCode3), setCompositeKeyHash3);
            }
            Updater.m4605setimpl(m4598constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1974234326, "C55@1979L300,62@2296L299,69@2612L307:SettingsBottomBar.kt#1gr92h");
            ScalingButtonKt.ScalingButton(onBugsReport, null, ComposableSingletons$SettingsBottomBarKt.INSTANCE.m9839getLambda$13006014$settings_release(), startRestartGroup, (i3 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            function0 = onBugsReport;
            ScalingButtonKt.ScalingButton(onShareLogs, null, ComposableSingletons$SettingsBottomBarKt.INSTANCE.getLambda$983320313$settings_release(), startRestartGroup, ((i3 >> 3) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            function02 = onPrivacyPolicy;
            ScalingButtonKt.ScalingButton(function02, null, ComposableSingletons$SettingsBottomBarKt.INSTANCE.m9840getLambda$473092742$settings_release(), startRestartGroup, ((i3 >> 6) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
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
            CustomDividerKt.CustomDivider(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getTopCenter()), startRestartGroup, 0, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsBottomBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingsBottomBar$lambda$1;
                    SettingsBottomBar$lambda$1 = SettingsBottomBarKt.SettingsBottomBar$lambda$1(Function0.this, onShareLogs, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingsBottomBar$lambda$1;
                }
            });
        }
    }
}
