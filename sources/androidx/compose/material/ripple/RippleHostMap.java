package androidx.compose.material.ripple;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
/* compiled from: RippleContainer.android.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0006H\u0086\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006J\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/ripple/RippleHostMap;", "", "()V", "hostToIndicationMap", "", "Landroidx/compose/material/ripple/RippleHostView;", "Landroidx/compose/material/ripple/RippleHostKey;", "indicationToHostMap", "get", "indicationInstance", "rippleHostView", "remove", "", "set", "material-ripple_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class RippleHostMap {
    private final Map<RippleHostKey, RippleHostView> indicationToHostMap = new LinkedHashMap();
    private final Map<RippleHostView, RippleHostKey> hostToIndicationMap = new LinkedHashMap();

    public final void set(RippleHostKey rippleHostKey, RippleHostView rippleHostView) {
        this.indicationToHostMap.put(rippleHostKey, rippleHostView);
        this.hostToIndicationMap.put(rippleHostView, rippleHostKey);
    }

    public final RippleHostView get(RippleHostKey rippleHostKey) {
        return this.indicationToHostMap.get(rippleHostKey);
    }

    public final RippleHostKey get(RippleHostView rippleHostView) {
        return this.hostToIndicationMap.get(rippleHostView);
    }

    public final void remove(RippleHostKey rippleHostKey) {
        RippleHostView rippleHostView = this.indicationToHostMap.get(rippleHostKey);
        if (rippleHostView != null) {
            this.hostToIndicationMap.remove(rippleHostView);
        }
        this.indicationToHostMap.remove(rippleHostKey);
    }
}
