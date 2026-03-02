package androidx.navigationevent.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.InspectionModeKt;
import kotlin.Metadata;
/* compiled from: NavigationEventHandler.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"isInspectionMode", "", "(Landroidx/compose/runtime/Composer;I)Z", "navigationevent-compose"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavigationEventHandler_androidKt {
    public static final boolean isInspectionMode(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1476766739, "C(isInspectionMode)21@841L7:NavigationEventHandler.android.kt#wc8b4r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1476766739, i, -1, "androidx.navigationevent.compose.isInspectionMode (NavigationEventHandler.android.kt:21)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(InspectionModeKt.getLocalInspectionMode());
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean booleanValue = ((Boolean) consume).booleanValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return booleanValue;
    }
}
