package com.miami.game.feature.download.dialog.ui.connection;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.button.DialogButtonKt;
import com.miami.game.core.design.system.component.dialog_frame.DialogFrameKt;
import com.miami.game.feature.download.dialog.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConnectionDialog.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"ConnectionDialog", "", "connectionData", "Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;", "onClose", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function1;", "(Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "dialogs_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectionDialog$lambda$1(ConnectionData connectionData, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        ConnectionDialog(connectionData, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ConnectionDialog(final ConnectionData connectionData, final Function0<Unit> onClose, final Function1<? super ConnectionData, Unit> onConfirm, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer startRestartGroup = composer.startRestartGroup(522024473);
        ComposerKt.sourceInformation(startRestartGroup, "C(ConnectionDialog)N(connectionData,onClose,onConfirm)25@1203L1427,25@1156L1474:ConnectionDialog.kt#yp5s1q");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(connectionData) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onConfirm) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            function0 = onClose;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(522024473, i2, -1, "com.miami.game.feature.download.dialog.ui.connection.ConnectionDialog (ConnectionDialog.kt:24)");
            }
            function0 = onClose;
            DialogFrameKt.DialogFrame(null, function0, ComposableLambdaKt.rememberComposableLambda(-137565439, true, new Function2() { // from class: com.miami.game.feature.download.dialog.ui.connection.ConnectionDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConnectionDialog$lambda$0;
                    ConnectionDialog$lambda$0 = ConnectionDialogKt.ConnectionDialog$lambda$0(ConnectionData.this, onClose, onConfirm, (Composer) obj, ((Integer) obj2).intValue());
                    return ConnectionDialog$lambda$0;
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 112) | 390, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.connection.ConnectionDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConnectionDialog$lambda$1;
                    ConnectionDialog$lambda$1 = ConnectionDialogKt.ConnectionDialog$lambda$1(ConnectionData.this, function0, onConfirm, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ConnectionDialog$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectionDialog$lambda$0(ConnectionData connectionData, final Function0 function0, final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C26@1240L10,26@1213L94,29@1331L45,30@1401L47,31@1477L51,32@1537L30,33@1576L357,46@1942L30,47@1981L642:ConnectionDialog.kt#yp5s1q");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-137565439, i, -1, "com.miami.game.feature.download.dialog.ui.connection.ConnectionDialog.<anonymous> (ConnectionDialog.kt:26)");
            }
            TextKt.m3255TextNvy7gAk("ПОДКЛЮЧИТЬСЯ К СЕРВЕРУ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, 131070);
            ComposerKt.sourceInformationMarkerStart(composer, 943603438, "CC(remember):ConnectionDialog.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(connectionData.getIp(), null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 943605680, "CC(remember):ConnectionDialog.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(connectionData.getPort(), null, 2, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 943608116, "CC(remember):ConnectionDialog.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(connectionData.getPassword(), null, 2, null);
                composer.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            float f = 12;
            SpacerKt.Spacer(SizeKt.m962height3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(f)), composer, 6);
            Modifier m962height3ABfNKs = SizeKt.m962height3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(60));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m962height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4673constructorimpl = Updater.m4673constructorimpl(composer);
            Updater.m4681setimpl(m4673constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -967227730, "C36@1651L75,39@1739L81,42@1833L90:ConnectionDialog.kt#yp5s1q");
            InputFieldKt.m10090InputFieldrAjV9yQ(mutableState, Dp.m8258constructorimpl(140), R.drawable.input, composer, 54);
            InputFieldKt.m10090InputFieldrAjV9yQ(mutableState2, Dp.m8258constructorimpl(50), R.drawable.input_port, composer, 54);
            InputFieldKt.m10090InputFieldrAjV9yQ(mutableState3, Dp.m8258constructorimpl(120), R.drawable.input_password, composer, 54);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.m962height3ABfNKs(Modifier.Companion, Dp.m8258constructorimpl(f)), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer m4673constructorimpl2 = Updater.m4673constructorimpl(composer);
            Updater.m4681setimpl(m4673constructorimpl2, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4681setimpl(m4673constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4677initimpl(m4673constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4679reconcileimpl(m4673constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4681setimpl(m4673constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 797046465, "C48@2024L41,48@1999L185,54@2223L265,54@2197L416:ConnectionDialog.kt#yp5s1q");
            ComposerKt.sourceInformationMarkerStart(composer, 1965374053, "CC(remember):ConnectionDialog.kt#9igjgp");
            boolean changed = composer.changed(function0);
            Object rememberedValue4 = composer.rememberedValue();
            if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.connection.ConnectionDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ConnectionDialog$lambda$0$4$0$0;
                        ConnectionDialog$lambda$0$4$0$0 = ConnectionDialogKt.ConnectionDialog$lambda$0$4$0$0(Function0.this);
                        return ConnectionDialog$lambda$0$4$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonNo((Function0) rememberedValue4, ComposableSingletons$ConnectionDialogKt.INSTANCE.m10085getLambda$751471044$dialogs_release(), composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, 1965380645, "CC(remember):ConnectionDialog.kt#9igjgp");
            boolean changed2 = composer.changed(function1);
            Object rememberedValue5 = composer.rememberedValue();
            if (changed2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: com.miami.game.feature.download.dialog.ui.connection.ConnectionDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ConnectionDialog$lambda$0$4$1$0;
                        ConnectionDialog$lambda$0$4$1$0 = ConnectionDialogKt.ConnectionDialog$lambda$0$4$1$0(Function1.this, mutableState, mutableState2, mutableState3);
                        return ConnectionDialog$lambda$0$4$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DialogButtonKt.DialogButtonYes((Function0) rememberedValue5, false, ComposableSingletons$ConnectionDialogKt.INSTANCE.m10084getLambda$1711092251$dialogs_release(), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectionDialog$lambda$0$4$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectionDialog$lambda$0$4$1$0(Function1 function1, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        function1.invoke(new ConnectionData((String) mutableState.getValue(), (String) mutableState2.getValue(), (String) mutableState3.getValue()));
        return Unit.INSTANCE;
    }
}
