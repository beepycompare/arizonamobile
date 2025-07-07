package com.skydoves.cloudy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.skydoves.cloudy.CloudyState;
import kotlin.Metadata;
/* compiled from: RememberCloudyState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"rememberCloudyState", "Landroidx/compose/runtime/MutableState;", "Lcom/skydoves/cloudy/CloudyState;", "initialState", "key", "", "(Lcom/skydoves/cloudy/CloudyState;Ljava/lang/Object;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "cloudy_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RememberCloudyStateKt {
    public static final MutableState<CloudyState> rememberCloudyState(CloudyState cloudyState, Object obj, Composer composer, int i, int i2) {
        composer.startReplaceGroup(951593363);
        if ((i2 & 1) != 0) {
            cloudyState = CloudyState.Nothing.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            obj = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(951593363, i, -1, "com.skydoves.cloudy.rememberCloudyState (RememberCloudyState.kt:32)");
        }
        composer.startReplaceGroup(1436912180);
        boolean changed = composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(cloudyState, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState<CloudyState> mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return mutableState;
    }
}
