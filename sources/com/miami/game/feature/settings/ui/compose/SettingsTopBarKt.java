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
import androidx.compose.material3.MenuKt;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.other.CustomDividerKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.settings.R;
import com.miami.game.feature.settings.ui.model.SettingsUiState;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsTopBar.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"SettingsTopBar", "", "uiState", "Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "modifier", "Landroidx/compose/ui/Modifier;", "onRepairGame", "Lkotlin/Function0;", "onBack", "onSupport", "onTech", "(Lcom/miami/game/feature/settings/ui/model/SettingsUiState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "settings_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$13(SettingsUiState settingsUiState, Modifier modifier, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Composer composer, int i2) {
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
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsTopBar)P(5!1,2)35@1352L2427:SettingsTopBar.kt#1gr92h");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 999182318, "C36@1368L2257,94@3634L139:SettingsTopBar.kt#1gr92h");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m771height3ABfNKs(modifier, Dp.m6684constructorimpl(80)), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 78015274, "C42@1554L1006,67@2573L1042:SettingsTopBar.kt#1gr92h");
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl3 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -782216321, "C45@1654L377,55@2075L42,54@2048L277,61@2342L28,64@2515L13,62@2387L159:SettingsTopBar.kt#1gr92h");
            int i3 = i2;
            ScalingButtonKt.ScalingButton(onBack, null, ComposableSingletons$SettingsTopBarKt.INSTANCE.m8416getLambda$1729539213$settings_release_web(), startRestartGroup, ((i2 >> 9) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            float f = 36;
            float f2 = 12;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.settings_label, startRestartGroup, 0), (String) null, OffsetKt.m698offsetVpY3zN4$default(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(f)), Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f2)), 0.0f, 2, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            SpacerKt.Spacer(SizeKt.m790width3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(6)), startRestartGroup, 6);
            TextKt.m2497Text4IGK_g("ВЕРСИЯ " + uiState.getVersion(), (Modifier) Modifier.Companion, Color.Companion.m4115getWhite0d7_KjU(), TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(11), startRestartGroup, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 432, 0, 131056);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(70), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f))), Alignment.Companion.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m698offsetVpY3zN4$default);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl4 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl4, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 424319151, "C81@3122L15,83@3197L130,80@3077L250,87@3389L18,89@3467L134,86@3344L257:SettingsTopBar.kt#1gr92h");
            if (!uiState.isDebug()) {
                startRestartGroup.startReplaceGroup(421579153);
            } else {
                startRestartGroup.startReplaceGroup(424322560);
                ComposerKt.sourceInformation(startRestartGroup, "74@2827L12,76@2907L135,73@2778L264");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1676257821, "CC(remember):SettingsTopBar.kt#9igjgp");
                boolean z = (458752 & i3) == 131072;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$2$lambda$1;
                            SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$2$lambda$1 = SettingsTopBarKt.SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$2$lambda$1(Function0.this);
                            return SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$2$lambda$1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ScalingButtonKt.ScalingButton((Function0) rememberedValue, Modifier.Companion, ComposableLambdaKt.rememberComposableLambda(-708380511, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$3;
                        SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$3 = SettingsTopBarKt.SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$3(Modifier.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$3;
                    }
                }, startRestartGroup, 54), startRestartGroup, 432, 0);
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1676267264, "CC(remember):SettingsTopBar.kt#9igjgp");
            boolean z2 = (57344 & i3) == 16384;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$5$lambda$4;
                        SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$5$lambda$4 = SettingsTopBarKt.SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$5$lambda$4(Function0.this);
                        return SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue2, Modifier.Companion, ComposableLambdaKt.rememberComposableLambda(1097723868, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$6;
                    SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$6 = SettingsTopBarKt.SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$6(Modifier.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$6;
                }
            }, startRestartGroup, 54), startRestartGroup, 432, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1676275811, "CC(remember):SettingsTopBar.kt#9igjgp");
            boolean z3 = (i3 & 896) == 256;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$8$lambda$7;
                        SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$8$lambda$7 = SettingsTopBarKt.SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$8$lambda$7(Function0.this);
                        return SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ScalingButtonKt.ScalingButton((Function0) rememberedValue3, Modifier.Companion, ComposableLambdaKt.rememberComposableLambda(-1292796603, true, new Function3() { // from class: com.miami.game.feature.settings.ui.compose.SettingsTopBarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$9;
                    SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$9 = SettingsTopBarKt.SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$9(Modifier.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$9;
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
            CustomDividerKt.CustomDivider(OffsetKt.m698offsetVpY3zN4$default(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f2)), 1, null), startRestartGroup, 0, 0);
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
                    Unit SettingsTopBar$lambda$13;
                    SettingsTopBar$lambda$13 = SettingsTopBarKt.SettingsTopBar$lambda$13(SettingsUiState.this, modifier, onRepairGame, onBack, onSupport, onTech, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingsTopBar$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$2$lambda$1(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$3(Modifier modifier, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C77@2949L39,77@2933L87:SettingsTopBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-708380511, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTopBar.kt:77)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.tech_button, composer, 0), (String) null, SizeKt.fillMaxHeight$default(modifier, 0.0f, 1, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 48, (int) MenuKt.InTransitionDuration);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$5$lambda$4(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$6(Modifier modifier, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C84@3235L42,84@3219L90:SettingsTopBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1097723868, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTopBar.kt:84)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.support_button, composer, 0), (String) null, SizeKt.fillMaxHeight$default(modifier, 0.0f, 1, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 48, (int) MenuKt.InTransitionDuration);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$8$lambda$7(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsTopBar$lambda$12$lambda$11$lambda$10$lambda$9(Modifier modifier, BoxScope ScalingButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
        ComposerKt.sourceInformation(composer, "C90@3505L46,90@3489L94:SettingsTopBar.kt#1gr92h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1292796603, i, -1, "com.miami.game.feature.settings.ui.compose.SettingsTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsTopBar.kt:90)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.check_files_button, composer, 0), (String) null, SizeKt.fillMaxHeight$default(modifier, 0.0f, 1, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 48, (int) MenuKt.InTransitionDuration);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
