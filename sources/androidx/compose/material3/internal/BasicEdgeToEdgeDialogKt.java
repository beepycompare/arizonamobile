package androidx.compose.material3.internal;

import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BasicEdgeToEdgeDialog.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u008a\u0084\u0002"}, d2 = {"rememberPredictiveBackState", "Landroidx/compose/material3/internal/PredictiveBackState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/internal/PredictiveBackState;", "PredictiveBackStateHandler", "", RemoteConfigConstants.ResponseFieldKey.STATE, "enabled", "", "onBack", "Lkotlin/Function0;", "(Landroidx/compose/material3/internal/PredictiveBackState;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "material3", "currentOnBack"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicEdgeToEdgeDialogKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PredictiveBackStateHandler$lambda$3(PredictiveBackState predictiveBackState, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        PredictiveBackStateHandler(predictiveBackState, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final PredictiveBackState rememberPredictiveBackState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1883443352, "C(rememberPredictiveBackState)77@2674L42:BasicEdgeToEdgeDialog.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1883443352, i, -1, "androidx.compose.material3.internal.rememberPredictiveBackState (BasicEdgeToEdgeDialog.kt:77)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1807832194, "CC(remember):BasicEdgeToEdgeDialog.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new PredictiveBackStateImpl();
            composer.updateRememberedValue(rememberedValue);
        }
        PredictiveBackStateImpl predictiveBackStateImpl = (PredictiveBackStateImpl) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return predictiveBackStateImpl;
    }

    public static final void PredictiveBackStateHandler(final PredictiveBackState predictiveBackState, boolean z, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(698755635);
        ComposerKt.sourceInformation(startRestartGroup, "C(PredictiveBackStateHandler)N(state,enabled,onBack)92@3116L28:BasicEdgeToEdgeDialog.kt#mqatfk");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(predictiveBackState) : startRestartGroup.changedInstance(predictiveBackState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        boolean z2 = true;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                z = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(698755635, i3, -1, "androidx.compose.material3.internal.PredictiveBackStateHandler (BasicEdgeToEdgeDialog.kt:90)");
            }
            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function0, startRestartGroup, (i3 >> 6) & 14);
            startRestartGroup.startMovableGroup(1489276985, predictiveBackState);
            ComposerKt.sourceInformation(startRestartGroup, "96@3300L906,96@3212L994");
            Intrinsics.checkNotNull(predictiveBackState, "null cannot be cast to non-null type androidx.compose.material3.internal.PredictiveBackStateImpl");
            boolean z3 = z && !(((PredictiveBackStateImpl) predictiveBackState).getValue() instanceof BackEventProgress.Completed);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1489281629, "CC(remember):BasicEdgeToEdgeDialog.kt#9igjgp");
            if ((i3 & 14) != 4 && ((i3 & 8) == 0 || !startRestartGroup.changedInstance(predictiveBackState))) {
                z2 = false;
            }
            boolean changed = startRestartGroup.changed(rememberUpdatedState) | z2;
            BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1(predictiveBackState, rememberUpdatedState, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BackHandler_androidKt.PredictiveBackHandler(z3, (Function2) rememberedValue, startRestartGroup, 0, 0);
            startRestartGroup.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final boolean z4 = z;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicEdgeToEdgeDialogKt.PredictiveBackStateHandler$lambda$3(PredictiveBackState.this, z4, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> PredictiveBackStateHandler$lambda$1(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }
}
