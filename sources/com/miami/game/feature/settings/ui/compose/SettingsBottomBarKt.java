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
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007b\u0002\b\bb\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\u0007¨\u0006\f"}, d2 = {"SettingsBottomBar", "", "onBugsReport", "Lkotlin/Function0;", "onShareLogs", "onPrivacyPolicy", "onLongShareLogs", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "settings"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsBottomBarKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsBottomBar$lambda$1(Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Composer composer, int i2) {
        SettingsBottomBar(function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SettingsBottomBar(final Function0<Unit> onBugsReport, final Function0<Unit> onShareLogs, final Function0<Unit> onPrivacyPolicy, final Function0<Unit> onLongShareLogs, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onBugsReport, "onBugsReport");
        Intrinsics.checkNotNullParameter(onShareLogs, "onShareLogs");
        Intrinsics.checkNotNullParameter(onPrivacyPolicy, "onPrivacyPolicy");
        Intrinsics.checkNotNullParameter(onLongShareLogs, "onLongShareLogs");
        Composer startRestartGroup = composer.startRestartGroup(-592364725);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsBottomBar)N(onBugsReport,onShareLogs,onPrivacyPolicy,onLongShareLogs)33@1368L1803:SettingsBottomBar.kt#1gr92h");
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
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onLongShareLogs) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-592364725, i3, -1, "com.miami.game.feature.settings.ui.compose.SettingsBottomBar (SettingsBottomBar.kt:32)");
            }
            Modifier background$default = BackgroundKt.background$default(SizeKt.fillMaxWidth$default(OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m8160constructorimpl(8.0f), 1, null), 0.0f, 1, null), Brush.Companion.m5303verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5338boximpl(Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5338boximpl(Color.Companion.m5383getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, background$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 712928589, "C46@1720L1302,80@3031L134:SettingsBottomBar.kt#1gr92h");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1776449196, "C51@1858L1154:SettingsBottomBar.kt#1gr92h");
            Modifier m1103height3ABfNKs = SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(76.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(-Dp.m8160constructorimpl(28.0f))), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m1103height3ABfNKs);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl3 = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl3, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 167246569, "C56@2036L300,63@2353L320,70@2690L307:SettingsBottomBar.kt#1gr92h");
            ScalingButtonKt.ScalingButton(onBugsReport, null, ComposableSingletons$SettingsBottomBarKt.INSTANCE.getLambda$631972942$settings(), startRestartGroup, (i3 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            int i4 = i3 >> 6;
            ScalingButtonKt.ScalingButtonLong(onShareLogs, onLongShareLogs, null, ComposableSingletons$SettingsBottomBarKt.INSTANCE.getLambda$124095881$settings(), startRestartGroup, ((i3 >> 3) & 14) | 3072 | (i4 & 112), 4);
            startRestartGroup = startRestartGroup;
            ScalingButtonKt.ScalingButton(onPrivacyPolicy, null, ComposableSingletons$SettingsBottomBarKt.INSTANCE.m9844getLambda$1935939771$settings(), startRestartGroup, (i4 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
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
                    return SettingsBottomBarKt.SettingsBottomBar$lambda$1(Function0.this, onShareLogs, onPrivacyPolicy, onLongShareLogs, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
