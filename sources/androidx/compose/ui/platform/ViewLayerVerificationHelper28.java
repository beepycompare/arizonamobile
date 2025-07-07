package androidx.compose.ui.platform;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
/* compiled from: ViewLayer.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/ViewLayerVerificationHelper28;", "", "()V", "setOutlineAmbientShadowColor", "", "view", "Landroid/view/View;", TypedValues.AttributesType.S_TARGET, "", "setOutlineSpotShadowColor", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
final class ViewLayerVerificationHelper28 {
    public static final ViewLayerVerificationHelper28 INSTANCE = new ViewLayerVerificationHelper28();

    private ViewLayerVerificationHelper28() {
    }

    public final void setOutlineAmbientShadowColor(View view, int i) {
        view.setOutlineAmbientShadowColor(i);
    }

    public final void setOutlineSpotShadowColor(View view, int i) {
        view.setOutlineSpotShadowColor(i);
    }
}
