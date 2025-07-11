package com.miami.game.feature.settings.ui.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import com.davemorrissey.labs.subscaleview.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SettingsRows.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a3\u0010\t\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\f\u001a-\u0010\r\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\u0012\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"ChatFontSize", "", "onClick", "Lkotlin/Function1;", "", "currentFont", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function1;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "FontsCount", "", "currentCount", "(Lkotlin/jvm/functions/Function1;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "KeyboardSwitch", "Lkotlin/Function0;", "isActive", "", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StreamerSwitch", "settings_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsRowsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatFontSize$lambda$11(Function1 function1, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ChatFontSize(function1, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FontsCount$lambda$21(Function1 function1, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        FontsCount(function1, i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyboardSwitch$lambda$29(Function0 function0, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        KeyboardSwitch(function0, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamerSwitch$lambda$37(Function0 function0, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StreamerSwitch(function0, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ChatFontSize(final Function1<? super Float, Unit> onClick, final float f, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1816129311);
        ComposerKt.sourceInformation(startRestartGroup, "C(ChatFontSize)P(2)20@845L662:SettingsRows.kt#1gr92h");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                companion = obj;
            } else {
                companion = i4 != 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1816129311, i3, -1, "com.miami.game.feature.settings.ui.compose.ChatFontSize (SettingsRows.kt:19)");
                }
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -761272387, "C26@980L141,30@1130L371:SettingsRows.kt#1gr92h");
                Modifier m790width3ABfNKs = SizeKt.m790width3ABfNKs(companion, Dp.m6684constructorimpl(180));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m790width3ABfNKs);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 987266641, "C27@1022L36,28@1071L40:SettingsRows.kt#1gr92h");
                TextSettingsKt.TextSettings("РАЗМЕР ШРИФТА В ЧАТЕ", null, startRestartGroup, 6, 2);
                SpacerKt.Spacer(SizeKt.m790width3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(12)), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(-Dp.m6684constructorimpl(28))), Alignment.Companion.getTop(), startRestartGroup, 6);
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
                Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1311271638, "C33@1244L17,33@1224L59,34@1316L15,34@1296L55,35@1384L17,35@1364L59,36@1456L15,36@1436L55:SettingsRows.kt#1gr92h");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 42299475, "CC(remember):SettingsRows.kt#9igjgp");
                int i5 = i3 & 14;
                boolean z = i5 == 4;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit ChatFontSize$lambda$10$lambda$9$lambda$2$lambda$1;
                            ChatFontSize$lambda$10$lambda$9$lambda$2$lambda$1 = SettingsRowsKt.ChatFontSize$lambda$10$lambda$9$lambda$2$lambda$1(Function1.this, (String) obj2);
                            return ChatFontSize$lambda$10$lambda$9$lambda$2$lambda$1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function1 function1 = (Function1) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.NumberButton("0.5", function1, f == 0.5f, startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 42301777, "CC(remember):SettingsRows.kt#9igjgp");
                boolean z2 = i5 == 4;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit ChatFontSize$lambda$10$lambda$9$lambda$4$lambda$3;
                            ChatFontSize$lambda$10$lambda$9$lambda$4$lambda$3 = SettingsRowsKt.ChatFontSize$lambda$10$lambda$9$lambda$4$lambda$3(Function1.this, (String) obj2);
                            return ChatFontSize$lambda$10$lambda$9$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function1 function12 = (Function1) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.NumberButton(BuildConfig.VERSION_NAME, function12, f == 1.0f, startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 42303955, "CC(remember):SettingsRows.kt#9igjgp");
                boolean z3 = i5 == 4;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit ChatFontSize$lambda$10$lambda$9$lambda$6$lambda$5;
                            ChatFontSize$lambda$10$lambda$9$lambda$6$lambda$5 = SettingsRowsKt.ChatFontSize$lambda$10$lambda$9$lambda$6$lambda$5(Function1.this, (String) obj2);
                            return ChatFontSize$lambda$10$lambda$9$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                Function1 function13 = (Function1) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.NumberButton("1.5", function13, f == 1.5f, startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 42306257, "CC(remember):SettingsRows.kt#9igjgp");
                boolean z4 = i5 == 4;
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit ChatFontSize$lambda$10$lambda$9$lambda$8$lambda$7;
                            ChatFontSize$lambda$10$lambda$9$lambda$8$lambda$7 = SettingsRowsKt.ChatFontSize$lambda$10$lambda$9$lambda$8$lambda$7(Function1.this, (String) obj2);
                            return ChatFontSize$lambda$10$lambda$9$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                Function1 function14 = (Function1) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.NumberButton("2.0", function14, f == 2.0f, startRestartGroup, 6);
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier2 = companion;
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ChatFontSize$lambda$11;
                        ChatFontSize$lambda$11 = SettingsRowsKt.ChatFontSize$lambda$11(Function1.this, f, modifier2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        return ChatFontSize$lambda$11;
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatFontSize$lambda$10$lambda$9$lambda$2$lambda$1(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(Float.valueOf(0.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatFontSize$lambda$10$lambda$9$lambda$4$lambda$3(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(Float.valueOf(1.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatFontSize$lambda$10$lambda$9$lambda$6$lambda$5(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(Float.valueOf(1.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChatFontSize$lambda$10$lambda$9$lambda$8$lambda$7(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(Float.valueOf(2.0f));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FontsCount(final Function1<? super Integer, Unit> onClick, final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Object obj;
        Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1841430793);
        ComposerKt.sourceInformation(startRestartGroup, "C(FontsCount)P(2)44@1616L618:SettingsRows.kt#1gr92h");
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        int i5 = i3 & 4;
        if (i5 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 256 : 128;
            if (startRestartGroup.shouldExecute((i4 & 147) == 146, i4 & 1)) {
                startRestartGroup.skipToGroupEnd();
                companion = obj;
            } else {
                companion = i5 != 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1841430793, i4, -1, "com.miami.game.feature.settings.ui.compose.FontsCount (SettingsRows.kt:43)");
                }
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 321521051, "C50@1759L148,55@1916L312:SettingsRows.kt#1gr92h");
                Modifier m790width3ABfNKs = SizeKt.m790width3ABfNKs(companion, Dp.m6684constructorimpl(180));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m790width3ABfNKs);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1907357012, "C51@1801L43,53@1857L40:SettingsRows.kt#1gr92h");
                TextSettingsKt.TextSettings("СТРОК ЧАТА", null, startRestartGroup, 6, 2);
                SpacerKt.Spacer(SizeKt.m790width3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(12)), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(-Dp.m6684constructorimpl(28))), Alignment.Companion.getTop(), startRestartGroup, 6);
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
                Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1484254524, "C58@2029L14,58@2011L52,59@2094L14,59@2076L52,60@2160L15,60@2141L77:SettingsRows.kt#1gr92h");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1017710886, "CC(remember):SettingsRows.kt#9igjgp");
                int i6 = i4 & 14;
                boolean z = i6 == 4;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit FontsCount$lambda$20$lambda$19$lambda$14$lambda$13;
                            FontsCount$lambda$20$lambda$19$lambda$14$lambda$13 = SettingsRowsKt.FontsCount$lambda$20$lambda$19$lambda$14$lambda$13(Function1.this, (String) obj2);
                            return FontsCount$lambda$20$lambda$19$lambda$14$lambda$13;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function1 function1 = (Function1) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.NumberButton("5", function1, i == 5, startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1017712966, "CC(remember):SettingsRows.kt#9igjgp");
                boolean z2 = i6 == 4;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit FontsCount$lambda$20$lambda$19$lambda$16$lambda$15;
                            FontsCount$lambda$20$lambda$19$lambda$16$lambda$15 = SettingsRowsKt.FontsCount$lambda$20$lambda$19$lambda$16$lambda$15(Function1.this, (String) obj2);
                            return FontsCount$lambda$20$lambda$19$lambda$16$lambda$15;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function1 function12 = (Function1) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.NumberButton("8", function12, i == 8, startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1017715079, "CC(remember):SettingsRows.kt#9igjgp");
                boolean z3 = i6 == 4;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit FontsCount$lambda$20$lambda$19$lambda$18$lambda$17;
                            FontsCount$lambda$20$lambda$19$lambda$18$lambda$17 = SettingsRowsKt.FontsCount$lambda$20$lambda$19$lambda$18$lambda$17(Function1.this, (String) obj2);
                            return FontsCount$lambda$20$lambda$19$lambda$18$lambda$17;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                Function1 function13 = (Function1) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.NumberButton("10", function13, i == 10 || i == 15, startRestartGroup, 6);
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier2 = companion;
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit FontsCount$lambda$21;
                        FontsCount$lambda$21 = SettingsRowsKt.FontsCount$lambda$21(Function1.this, i, modifier2, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                        return FontsCount$lambda$21;
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if (startRestartGroup.shouldExecute((i4 & 147) == 146, i4 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FontsCount$lambda$20$lambda$19$lambda$14$lambda$13(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FontsCount$lambda$20$lambda$19$lambda$16$lambda$15(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FontsCount$lambda$20$lambda$19$lambda$18$lambda$17(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(10);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x036a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void KeyboardSwitch(final Function0<Unit> onClick, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1039663295);
        ComposerKt.sourceInformation(startRestartGroup, "C(KeyboardSwitch)P(2)68@2344L604:SettingsRows.kt#1gr92h");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                companion = obj;
            } else {
                companion = i4 != 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1039663295, i3, -1, "com.miami.game.feature.settings.ui.compose.KeyboardSwitch (SettingsRows.kt:67)");
                }
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), centerVertically, startRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -589388975, "C74@2535L124,79@2668L274:SettingsRows.kt#1gr92h");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1178405236, "C75@2553L43,77@2609L40:SettingsRows.kt#1gr92h");
                TextSettingsKt.TextSettings("КЛАВИАТУРА", null, startRestartGroup, 6, 2);
                float f = 12;
                SpacerKt.Spacer(SizeKt.m790width3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(f)), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Arrangement.HorizontalOrVertical m619spacedBy0680j_4 = Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(-Dp.m6684constructorimpl(28)));
                Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f)), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m619spacedBy0680j_4, Alignment.Companion.getTop(), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m698offsetVpY3zN4$default);
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
                Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1657830573, "C83@2842L13,83@2814L53,84@2908L13,84@2880L52:SettingsRows.kt#1gr92h");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 607668525, "CC(remember):SettingsRows.kt#9igjgp");
                int i5 = i3 & 14;
                boolean z2 = i5 == 4;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit KeyboardSwitch$lambda$28$lambda$27$lambda$24$lambda$23;
                            KeyboardSwitch$lambda$28$lambda$27$lambda$24$lambda$23 = SettingsRowsKt.KeyboardSwitch$lambda$28$lambda$27$lambda$24$lambda$23(Function0.this);
                            return KeyboardSwitch$lambda$28$lambda$27$lambda$24$lambda$23;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.KeyboardButton("Системная", (Function0) rememberedValue, !z, startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 607670637, "CC(remember):SettingsRows.kt#9igjgp");
                boolean z3 = i5 == 4;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit KeyboardSwitch$lambda$28$lambda$27$lambda$26$lambda$25;
                            KeyboardSwitch$lambda$28$lambda$27$lambda$26$lambda$25 = SettingsRowsKt.KeyboardSwitch$lambda$28$lambda$27$lambda$26$lambda$25(Function0.this);
                            return KeyboardSwitch$lambda$28$lambda$27$lambda$26$lambda$25;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.KeyboardButton("Кастомная", (Function0) rememberedValue2, z, startRestartGroup, ((i3 << 3) & 896) | 6);
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier2 = companion;
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit KeyboardSwitch$lambda$29;
                        KeyboardSwitch$lambda$29 = SettingsRowsKt.KeyboardSwitch$lambda$29(Function0.this, z, modifier2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        return KeyboardSwitch$lambda$29;
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyboardSwitch$lambda$28$lambda$27$lambda$24$lambda$23(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyboardSwitch$lambda$28$lambda$27$lambda$26$lambda$25(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x036a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StreamerSwitch(final Function0<Unit> onClick, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(778183045);
        ComposerKt.sourceInformation(startRestartGroup, "C(StreamerSwitch)P(2)90@3056L595:SettingsRows.kt#1gr92h");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                companion = obj;
            } else {
                companion = i4 != 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(778183045, i3, -1, "com.miami.game.feature.settings.ui.compose.StreamerSwitch (SettingsRows.kt:89)");
                }
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), centerVertically, startRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 723157940, "C96@3247L119,101@3375L270:SettingsRows.kt#1gr92h");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 134141803, "C97@3265L38,99@3316L40:SettingsRows.kt#1gr92h");
                TextSettingsKt.TextSettings("РЕЖИМ", null, startRestartGroup, 6, 2);
                float f = 12;
                SpacerKt.Spacer(SizeKt.m790width3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(f)), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Arrangement.HorizontalOrVertical m619spacedBy0680j_4 = Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(-Dp.m6684constructorimpl(28)));
                Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f)), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m619spacedBy0680j_4, Alignment.Companion.getTop(), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m698offsetVpY3zN4$default);
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
                Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1324589653, "C105@3547L13,105@3521L51,106@3611L13,106@3585L50:SettingsRows.kt#1gr92h");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1566748621, "CC(remember):SettingsRows.kt#9igjgp");
                int i5 = i3 & 14;
                boolean z2 = i5 == 4;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StreamerSwitch$lambda$36$lambda$35$lambda$32$lambda$31;
                            StreamerSwitch$lambda$36$lambda$35$lambda$32$lambda$31 = SettingsRowsKt.StreamerSwitch$lambda$36$lambda$35$lambda$32$lambda$31(Function0.this);
                            return StreamerSwitch$lambda$36$lambda$35$lambda$32$lambda$31;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.KeyboardButton("ОБЫЧНЫЙ", (Function0) rememberedValue, !z, startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1566746573, "CC(remember):SettingsRows.kt#9igjgp");
                boolean z3 = i5 == 4;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StreamerSwitch$lambda$36$lambda$35$lambda$34$lambda$33;
                            StreamerSwitch$lambda$36$lambda$35$lambda$34$lambda$33 = SettingsRowsKt.StreamerSwitch$lambda$36$lambda$35$lambda$34$lambda$33(Function0.this);
                            return StreamerSwitch$lambda$36$lambda$35$lambda$34$lambda$33;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumberButtonKt.KeyboardButton("СТРИМЕР", (Function0) rememberedValue2, z, startRestartGroup, ((i3 << 3) & 896) | 6);
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier2 = companion;
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.settings.ui.compose.SettingsRowsKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit StreamerSwitch$lambda$37;
                        StreamerSwitch$lambda$37 = SettingsRowsKt.StreamerSwitch$lambda$37(Function0.this, z, modifier2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        return StreamerSwitch$lambda$37;
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamerSwitch$lambda$36$lambda$35$lambda$32$lambda$31(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StreamerSwitch$lambda$36$lambda$35$lambda$34$lambda$33(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
