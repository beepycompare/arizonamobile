package com.skydoves.cloudy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.FunctionKeyMeta;
import com.skydoves.cloudy.CloudyState;
import kotlin.Metadata;
/* compiled from: RememberCloudyState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"rememberCloudyState", "Landroidx/compose/runtime/MutableState;", "Lcom/skydoves/cloudy/CloudyState;", "initialState", "key", "", "(Lcom/skydoves/cloudy/CloudyState;Ljava/lang/Object;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "cloudy_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RememberCloudyStateKt {
    @FunctionKeyMeta(endOffset = 1186, key = 951593363, startOffset = 1006)
    public static final MutableState<CloudyState> rememberCloudyState(CloudyState cloudyState, Object obj, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 951593363, "C(rememberCloudyState)N(initialState,key)32@1133L53:RememberCloudyState.kt#nw4b6b");
        if ((i2 & 1) != 0) {
            cloudyState = CloudyState.Nothing.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            obj = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(951593363, i, -1, "com.skydoves.cloudy.rememberCloudyState (RememberCloudyState.kt:32)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -346808088, "CC(remember):RememberCloudyState.kt#9igjgp");
        boolean changed = composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(cloudyState, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState<CloudyState> mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState;
    }
}
