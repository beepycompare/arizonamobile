package com.miami.game.feature.download.dialog.ui.setup;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PolicyText.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"PolicyText", "", "text1", "", "text2", "onPolicy", "Lkotlin/Function0;", "onPrivacy", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "dialogs"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PolicyTextKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PolicyText$lambda$1(String str, String str2, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        PolicyText(str, str2, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PolicyText(final String text1, final String text2, final Function0<Unit> onPolicy, final Function0<Unit> onPrivacy, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(text1, "text1");
        Intrinsics.checkNotNullParameter(text2, "text2");
        Intrinsics.checkNotNullParameter(onPolicy, "onPolicy");
        Intrinsics.checkNotNullParameter(onPrivacy, "onPrivacy");
        Composer startRestartGroup = composer.startRestartGroup(322184517);
        ComposerKt.sourceInformation(startRestartGroup, "C(PolicyText)N(text1,text2,onPolicy,onPrivacy)16@616L1095:PolicyText.kt#18sjrx");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(text1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(text2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onPolicy) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onPrivacy) ? 2048 : 1024;
        }
        if (startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(322184517, i2, -1, "com.miami.game.feature.download.dialog.ui.setup.PolicyText (PolicyText.kt:15)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1725005493, "C18@674L34,18@640L533,34@1216L35,34@1182L523:PolicyText.kt#18sjrx");
            Modifier.Companion companion = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1579665935, "CC(remember):PolicyText.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.setup.PolicyTextKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PolicyText$lambda$0$0$0;
                        PolicyText$lambda$0$0$0 = PolicyTextKt.PolicyText$lambda$0$0$0(Function0.this);
                        return PolicyText$lambda$0$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m323clickableoSLSa3U$default = ClickableKt.m323clickableoSLSa3U$default(companion, false, null, null, null, (Function0) rememberedValue, 15, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m323clickableoSLSa3U$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            int i3 = i2;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 686536832, "C23@796L13,24@849L10,21@723L217,29@1027L10,30@1076L13,31@1129L11,27@953L210:PolicyText.kt#18sjrx");
            TextKt.m3157TextNvy7gAk("Соглашаюсь с ", null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(14.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, 390, 0, 131050);
            TextKt.m3157TextNvy7gAk(text1, null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m2322getPrimary0d7_KjU(), null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(14.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), startRestartGroup, i3 & 14, 0, 131050);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier.Companion companion2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1579648590, "CC(remember):PolicyText.kt#9igjgp");
            boolean z2 = (i3 & 7168) == 2048;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.setup.PolicyTextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PolicyText$lambda$0$2$0;
                        PolicyText$lambda$0$2$0 = PolicyTextKt.PolicyText$lambda$0$2$0(Function0.this);
                        return PolicyText$lambda$0$2$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m323clickableoSLSa3U$default2 = ClickableKt.m323clickableoSLSa3U$default(companion2, false, null, null, null, (Function0) rememberedValue2, 15, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m323clickableoSLSa3U$default2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1850425310, "C39@1328L13,40@1381L10,37@1266L206,45@1559L10,46@1608L13,47@1661L11,43@1485L210:PolicyText.kt#18sjrx");
            composer2 = startRestartGroup;
            TextKt.m3157TextNvy7gAk("и ", null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(14.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), composer2, 390, 0, 131050);
            TextKt.m3157TextNvy7gAk(text2, null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).m2322getPrimary0d7_KjU(), null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(14.0f), composer2, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, (i3 >> 3) & 14, 0, 131050);
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
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.setup.PolicyTextKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PolicyTextKt.PolicyText$lambda$1(text1, text2, onPolicy, onPrivacy, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PolicyText$lambda$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PolicyText$lambda$0$2$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
