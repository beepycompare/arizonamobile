package com.miami.game.feature.download.dialog.ui.repair;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogDescriptionTextKt;
import com.miami.game.feature.download.dialog.ui.common.ComponentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RepairGameDialog.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class RepairGameDialogKt$RepairGameDialogScreen$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $onConfirm;
    final /* synthetic */ Function0<Unit> $onDismiss;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RepairGameDialogKt$RepairGameDialogScreen$1(Function0<Unit> function0, Function0<Unit> function02) {
        this.$onDismiss = function0;
        this.$onConfirm = function02;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.runtime.Composer] */
    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C69@2677L18,70@2704L102,71@2815L409:RepairGameDialog.kt#wxnm6r");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1489415267, i, -1, "com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogScreen.<anonymous> (RepairGameDialog.kt:69)");
        }
        ComponentKt.AlertLabelDialog(composer, 0);
        DialogDescriptionTextKt.DialogDescriptionText("Проверка целостности файлов может занять длительное время. Хотите продолжить?", composer, 6);
        final Function0<Unit> function0 = this.$onDismiss;
        final Function0<Unit> function02 = this.$onConfirm;
        ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer);
        Updater.m3527setimpl(m3520constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -967043315, "C72@2858L43,72@2833L184,78@3056L43,78@3030L184:RepairGameDialog.kt#wxnm6r");
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):RepairGameDialog.kt#9igjgp");
        boolean changed = composer.changed(function0);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt$RepairGameDialogScreen$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$4$lambda$1$lambda$0;
                    invoke$lambda$4$lambda$1$lambda$0 = RepairGameDialogKt$RepairGameDialogScreen$1.invoke$lambda$4$lambda$1$lambda$0(Function0.this);
                    return invoke$lambda$4$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        DialogButtonKt.DialogButtonNo((Function0) rememberedValue, ComposableSingletons$RepairGameDialogKt.INSTANCE.m8344getLambda$1796529959$dialogs_release_web(), composer, 48);
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):RepairGameDialog.kt#9igjgp");
        boolean changed2 = composer.changed(function02);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt$RepairGameDialogScreen$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$4$lambda$3$lambda$2;
                    invoke$lambda$4$lambda$3$lambda$2 = RepairGameDialogKt$RepairGameDialogScreen$1.invoke$lambda$4$lambda$3$lambda$2(Function0.this);
                    return invoke$lambda$4$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        DialogButtonKt.DialogButtonYes(rememberedValue2, false, ComposableSingletons$RepairGameDialogKt.INSTANCE.m8345getLambda$277375600$dialogs_release_web(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
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
