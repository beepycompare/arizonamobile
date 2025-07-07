package com.miami.game.feature.download.dialog.ui.connection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.miami.game.core.design.system.component.dialog_frame.DialogFrameKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConnectionDialog.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"ConnectionDialog", "", "connectionData", "Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;", "onClose", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function1;", "(Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "dialogs_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectionDialog$lambda$0(ConnectionData connectionData, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        ConnectionDialog(connectionData, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ConnectionDialog(final ConnectionData connectionData, Function0<Unit> onClose, final Function1<? super ConnectionData, Unit> onConfirm, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer startRestartGroup = composer.startRestartGroup(522024473);
        ComposerKt.sourceInformation(startRestartGroup, "C(ConnectionDialog)25@1203L1427,25@1156L1474:ConnectionDialog.kt#yp5s1q");
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
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(522024473, i2, -1, "com.miami.game.feature.download.dialog.ui.connection.ConnectionDialog (ConnectionDialog.kt:24)");
            }
            function0 = onClose;
            DialogFrameKt.DialogFrame(null, function0, ComposableLambdaKt.rememberComposableLambda(-137565439, true, new ConnectionDialogKt$ConnectionDialog$1(connectionData, onClose, onConfirm), startRestartGroup, 54), startRestartGroup, (i2 & 112) | 390, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            function0 = onClose;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.connection.ConnectionDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConnectionDialog$lambda$0;
                    ConnectionDialog$lambda$0 = ConnectionDialogKt.ConnectionDialog$lambda$0(ConnectionData.this, function0, onConfirm, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ConnectionDialog$lambda$0;
                }
            });
        }
    }
}
