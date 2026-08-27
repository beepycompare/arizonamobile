package com.miami.game.feature.settings.ui.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.other.CustomDividerKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.settings.ui.model.SettingsUiState;
import com.miami.game.ui.classic.settings.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsTopBar.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010\u000b¨\u0006\u0010"}, d2 = {"SettingsTopBar", "", "uiState", "Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "modifier", "Landroidx/compose/ui/Modifier;", "onRepairGame", "Lkotlin/Function0;", "onBack", "onSupport", "onTech", "(Lcom/miami/game/feature/settings/ui/model/SettingsUiState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "settings"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsTopBarKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsTopBar$lambda$1(SettingsUiState settingsUiState, Modifier modifier, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Composer composer, int i2) {
        SettingsTopBar(settingsUiState, modifier, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SettingsTopBar(final SettingsUiState uiState, final Modifier modifier, final Function0<Unit> onRepairGame, final Function0<Unit> onBack, final Function0<Unit> onSupport, final Function0<Unit> onTech, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onRepairGame, "onRepairGame");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onSupport, "onSupport");
        Intrinsics.checkNotNullParameter(onTech, "onTech");
        Composer startRestartGroup = composer.startRestartGroup(1535138134);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsTopBar)N(uiState,modifier,onRepairGame,onBack,onSupport,onTech)35@1355L2430:SettingsTopBar.kt#1gr92h");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onRepairGame) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onBack) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(onSupport) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onTech) ? 131072 : 65536;
        }
        if (!startRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1535138134, i2, -1, "com.miami.game.feature.settings.ui.compose.SettingsTopBar (SettingsTopBar.kt:34)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
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
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 999182411, "C36@1371L2260,94@3640L139:SettingsTopBar.kt#1gr92h");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m1103height3ABfNKs(modifier, Dp.m8160constructorimpl(80.0f)), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 78015367, "C42@1557L1009,67@2579L1042:SettingsTopBar.kt#1gr92h");
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -782216228, "C45@1657L377,55@2078L42,54@2051L277,61@2345L28,64@2521L13,62@2390L162:SettingsTopBar.kt#1gr92h");
            ScalingButtonKt.ScalingButton(onBack, null, ComposableSingletons$SettingsTopBarKt.INSTANCE.m9849getLambda$1729539213$settings(), startRestartGroup, ((i3 >> 9) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.settings_label, startRestartGroup, 0), (String) null, OffsetKt.m1010offsetVpY3zN4$default(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(36.0f)), Dp.m8160constructorimpl(-Dp.m8160constructorimpl(12.0f)), 0.0f, 2, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            SpacerKt.Spacer(SizeKt.m1122width3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(6.0f)), startRestartGroup, 6);
            TextKt.m3157TextNvy7gAk("ВЕРСИЯ " + uiState.getAppVersion(), Modifier.Companion, Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9868dpToSp8Feqmps(Dp.m8160constructorimpl(11.0f), startRestartGroup, 6), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 432, 0, 262120);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m1010offsetVpY3zN4$default = OffsetKt.m1010offsetVpY3zN4$default(Modifier.Companion, Dp.m8160constructorimpl(70.0f), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m742spacedBy0680j_4(Dp.m8160constructorimpl(-Dp.m8160constructorimpl(36.0f))), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m1010offsetVpY3zN4$default);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl4 = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl4, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl4, Integer.valueOf(hashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 424319151, "C81@3128L15,83@3203L130,80@3083L250,87@3395L18,89@3473L134,86@3350L257:SettingsTopBar.kt#1gr92h");
            if (uiState.isDebug()) {
                startRestartGroup.startReplaceGroup(424322560);
                ComposerKt.sourceInformation(startRestartGroup, "74@2833L12,76@2913L135,73@2784L264");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1676257821, "CC(remember):SettingsTopBar.kt#9igjgp");
                boolean z = (458752 & i3) == 131072;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SettingsTopBar$lambda$0$0$1$0$0;
                            SettingsTopBar$lambda$0$0$1$0$0 = SettingsTopBarKt.SettingsTopBar$lambda$0$0$1$0$0(Function0.this);
                            return SettingsTopBar$lambda$0$0$1$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ScalingButtonKt.ScalingButton((Function0) rememberedValue, Modifier.Companion, ComposableLambdaKt.rememberComposableLambda(-708380511, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit SettingsTopBar$lambda$0$0$1$1;
                        SettingsTopBar$lambda$0$0$1$1 = SettingsTopBarKt.SettingsTopBar$lambda$0$0$1$1(Modifier.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return SettingsTopBar$lambda$0$0$1$1;
                    }
                }, startRestartGroup, 54), startRestartGroup, 432, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(424615665);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1676267264, "CC(remember):SettingsTopBar.kt#9igjgp");
            boolean z2 = (57344 & i3) == 16384;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SettingsTopBar$lambda$0$0$1$2$0;
                        SettingsTopBar$lambda$0$0$1$2$0 = SettingsTopBarKt.SettingsTopBar$lambda$0$0$1$2$0(Function0.this);
                        return SettingsTopBar$lambda$0$0$1$2$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue2, Modifier.Companion, ComposableLambdaKt.rememberComposableLambda(1097723868, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SettingsTopBar$lambda$0$0$1$3;
                    SettingsTopBar$lambda$0$0$1$3 = SettingsTopBarKt.SettingsTopBar$lambda$0$0$1$3(Modifier.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SettingsTopBar$lambda$0$0$1$3;
                }
            }, startRestartGroup, 54), startRestartGroup, 432, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1676275811, "CC(remember):SettingsTopBar.kt#9igjgp");
            boolean z3 = (i3 & 896) == 256;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SettingsTopBar$lambda$0$0$1$4$0;
                        SettingsTopBar$lambda$0$0$1$4$0 = SettingsTopBarKt.SettingsTopBar$lambda$0$0$1$4$0(Function0.this);
                        return SettingsTopBar$lambda$0$0$1$4$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue3, Modifier.Companion, ComposableLambdaKt.rememberComposableLambda(-1292796603, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SettingsTopBar$lambda$0$0$1$5;
                    SettingsTopBar$lambda$0$0$1$5 = SettingsTopBarKt.SettingsTopBar$lambda$0$0$1$5(Modifier.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SettingsTopBar$lambda$0$0$1$5;
                }
            }, startRestartGroup, 54), startRestartGroup, 432, 0);
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
            CustomDividerKt.CustomDivider(OffsetKt.m1010offsetVpY3zN4$default(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(12.0f)), 1, null), startRestartGroup, 0, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsTopBarKt.SettingsTopBar$lambda$1(SettingsUiState.this, modifier, onRepairGame, onBack, onSupport, onTech, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$0$0$1$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$0$0$1$1(Modifier modifier, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C77@2955L39,77@2939L87:SettingsTopBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-708380511, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTopBar.kt:77)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.tech_button, composer, 0), (String) null, SizeKt.fillMaxHeight$default(modifier, 0.0f, 1, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$0$0$1$2$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$0$0$1$3(Modifier modifier, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C84@3241L42,84@3225L90:SettingsTopBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1097723868, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTopBar.kt:84)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.support_button, composer, 0), (String) null, SizeKt.fillMaxHeight$default(modifier, 0.0f, 1, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$0$0$1$4$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$0$0$1$5(Modifier modifier, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C90@3511L46,90@3495L94:SettingsTopBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1292796603, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTopBar.kt:90)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.check_files_button, composer, 0), (String) null, SizeKt.fillMaxHeight$default(modifier, 0.0f, 1, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 48, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
