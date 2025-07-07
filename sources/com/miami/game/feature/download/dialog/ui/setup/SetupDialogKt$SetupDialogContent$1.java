package com.miami.game.feature.download.dialog.ui.setup;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.scaling_button.ScalingButtonKt;
import com.miami.game.feature.download.dialog.ui.common.ComponentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SetupDialog.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SetupDialogKt$SetupDialogContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $isPolicyAccepted;
    final /* synthetic */ boolean $isPrivacyAccepted;
    final /* synthetic */ Function0<Unit> $onAccept;
    final /* synthetic */ Function0<Unit> $onConfirm;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function0<Unit> $onPolicy;
    final /* synthetic */ Function0<Unit> $onTerms;
    final /* synthetic */ String $updateSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SetupDialogKt$SetupDialogContent$1(String str, boolean z, Function0<Unit> function0, Function0<Unit> function02, MutableState<Boolean> mutableState, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05) {
        this.$updateSize = str;
        this.$isPrivacyAccepted = z;
        this.$onPolicy = function0;
        this.$onTerms = function02;
        this.$isPolicyAccepted = mutableState;
        this.$onDismiss = function03;
        this.$onAccept = function04;
        this.$onConfirm = function05;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(MutableState mutableState) {
        mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$4$lambda$3(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6$lambda$5(Function0 function0, Function0 function02) {
        function0.invoke();
        function02.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v17 */
    public final void invoke(Composer composer, int i) {
        int i2;
        String str;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C88@3595L18,89@3622L27,106@4285L622:SetupDialog.kt#18sjrx");
        if ((i & 3) == 2 && composer2.getSkipping()) {
            composer2.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(97924095, i, -1, "com.miami.game.feature.download.dialog.ui.setup.SetupDialogContent.<anonymous> (SetupDialog.kt:88)");
        }
        ComponentKt.AlertLabelDialog(composer2, 0);
        DescriptionTextKt.DescriptionText(this.$updateSize, composer2, 0);
        composer2.startReplaceGroup(-384222263);
        ComposerKt.sourceInformation(composer2, "91@3696L570");
        if (this.$isPrivacyAccepted) {
            i2 = 693286680;
            str = "CC(remember):SetupDialog.kt#9igjgp";
        } else {
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical m619spacedBy0680j_4 = Arrangement.INSTANCE.m619spacedBy0680j_4(Dp.m6684constructorimpl(-Dp.m6684constructorimpl(12)));
            Function0<Unit> function0 = this.$onPolicy;
            Function0<Unit> function02 = this.$onTerms;
            final MutableState<Boolean> mutableState = this.$isPolicyAccepted;
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m619spacedBy0680j_4, centerVertically, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
            Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1047564806, "C93@3860L93,95@3955L75,93@3836L194,98@4047L204:SetupDialog.kt#18sjrx");
            composer2.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composer2, "CC(remember):SetupDialog.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$SetupDialogContent$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$2$lambda$1$lambda$0;
                        invoke$lambda$2$lambda$1$lambda$0 = SetupDialogKt$SetupDialogContent$1.invoke$lambda$2$lambda$1$lambda$0(MutableState.this);
                        return invoke$lambda$2$lambda$1$lambda$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceGroup();
            str = "CC(remember):SetupDialog.kt#9igjgp";
            i2 = 693286680;
            ScalingButtonKt.ScalingButton((Function0) rememberedValue, null, ComposableLambdaKt.rememberComposableLambda(-1817021325, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$SetupDialogContent$1$1$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer3, Integer num) {
                    invoke(boxScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxScope ScalingButton, Composer composer3, int i3) {
                    Intrinsics.checkNotNullParameter(ScalingButton, "$this$ScalingButton");
                    ComposerKt.sourceInformation(composer3, "C96@3977L35:SetupDialog.kt#18sjrx");
                    if ((i3 & 17) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1817021325, i3, -1, "com.miami.game.feature.download.dialog.ui.setup.SetupDialogContent.<anonymous>.<anonymous>.<anonymous> (SetupDialog.kt:96)");
                        }
                        CheckButtonKt.CheckButton(mutableState.getValue().booleanValue(), composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composer2, 54), composer2, 390, 2);
            PolicyTextKt.PolicyText("политикой конфиденциальности", "условиями использования", function0, function02, composer, 54);
            composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        composer2.endReplaceGroup();
        final Function0<Unit> function03 = this.$onDismiss;
        final MutableState<Boolean> mutableState2 = this.$isPolicyAccepted;
        final boolean z = this.$isPrivacyAccepted;
        final Function0<Unit> function04 = this.$onAccept;
        final Function0<Unit> function05 = this.$onConfirm;
        ComposerKt.sourceInformationMarkerStart(composer2, i2, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer2, 0);
        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, Modifier.Companion);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
        if (!(composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(constructor2);
        } else {
            composer2.useNode();
        }
        Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer2);
        Updater.m3527setimpl(m3520constructorimpl2, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer2, 2071125742, "C107@4328L43,107@4303L187,113@4587L70,116@4659L238,113@4503L394:SetupDialog.kt#18sjrx");
        composer2.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer2, str);
        boolean changed = composer2.changed(function03);
        Object rememberedValue2 = composer2.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$SetupDialogContent$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$7$lambda$4$lambda$3;
                    invoke$lambda$7$lambda$4$lambda$3 = SetupDialogKt$SetupDialogContent$1.invoke$lambda$7$lambda$4$lambda$3(Function0.this);
                    return invoke$lambda$7$lambda$4$lambda$3;
                }
            };
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer2.endReplaceGroup();
        DialogButtonKt.DialogButtonNo((Function0) rememberedValue2, ComposableSingletons$SetupDialogKt.INSTANCE.getLambda$1149507$dialogs_release_web(), composer2, 48);
        boolean z2 = mutableState2.getValue().booleanValue() || z;
        composer2.startReplaceGroup(-1633490746);
        ComposerKt.sourceInformation(composer2, str);
        boolean changed2 = composer2.changed(function04) | composer2.changed(function05);
        Object rememberedValue3 = composer2.rememberedValue();
        if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$SetupDialogContent$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$7$lambda$6$lambda$5;
                    invoke$lambda$7$lambda$6$lambda$5 = SetupDialogKt$SetupDialogContent$1.invoke$lambda$7$lambda$6$lambda$5(Function0.this, function05);
                    return invoke$lambda$7$lambda$6$lambda$5;
                }
            };
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer2.endReplaceGroup();
        DialogButtonKt.DialogButtonYes(rememberedValue3, z2, ComposableLambdaKt.rememberComposableLambda(-1429769364, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt$SetupDialogContent$1$2$3
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer3, Integer num) {
                invoke(boxScope, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxScope DialogButtonYes, Composer composer3, int i3) {
                Intrinsics.checkNotNullParameter(DialogButtonYes, "$this$DialogButtonYes");
                ComposerKt.sourceInformation(composer3, "C117@4704L10,117@4677L206:SetupDialog.kt#18sjrx");
                if ((i3 & 17) != 16 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1429769364, i3, -1, "com.miami.game.feature.download.dialog.ui.setup.SetupDialogContent.<anonymous>.<anonymous>.<anonymous> (SetupDialog.kt:117)");
                    }
                    TextKt.m2497Text4IGK_g("ЗАГРУЗИТЬ", (Modifier) null, (mutableState2.getValue().booleanValue() || z) ? Color.Companion.m4115getWhite0d7_KjU() : Color.m4077copywmQWz5c$default(Color.Companion.m4115getWhite0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getBodySmall(), composer3, 6, 0, 65530);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }, composer2, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
