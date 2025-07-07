package androidx.compose.material3.pulltorefresh;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PullToRefresh.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\u0016\u0010\u001b\u001a\u00020\fHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0015JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020\u0002H\u0016J\u0013\u0010!\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0002H\u0016J\f\u0010*\u001a\u00020\u0007*\u00020+H\u0016R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006,"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "", "enabled", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnabled", "()Z", "getOnRefresh", "()Lkotlin/jvm/functions/Function0;", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "getThreshold-D9Ej5fM", "()F", "F", "component1", "component2", "component3", "component4", "component5", "component5-D9Ej5fM", "copy", "copy-M2VBTUQ", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;F)Landroidx/compose/material3/pulltorefresh/PullToRefreshElement;", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullToRefreshElement extends ModifierNodeElement<PullToRefreshModifierNode> {
    public static final int $stable = 0;
    private final boolean enabled;
    private final boolean isRefreshing;
    private final Function0<Unit> onRefresh;
    private final PullToRefreshState state;
    private final float threshold;

    public /* synthetic */ PullToRefreshElement(boolean z, Function0 function0, boolean z2, PullToRefreshState pullToRefreshState, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function0, z2, pullToRefreshState, f);
    }

    /* renamed from: copy-M2VBTUQ$default  reason: not valid java name */
    public static /* synthetic */ PullToRefreshElement m2791copyM2VBTUQ$default(PullToRefreshElement pullToRefreshElement, boolean z, Function0 function0, boolean z2, PullToRefreshState pullToRefreshState, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pullToRefreshElement.isRefreshing;
        }
        Function0<Unit> function02 = function0;
        if ((i & 2) != 0) {
            function02 = pullToRefreshElement.onRefresh;
        }
        if ((i & 4) != 0) {
            z2 = pullToRefreshElement.enabled;
        }
        if ((i & 8) != 0) {
            pullToRefreshState = pullToRefreshElement.state;
        }
        if ((i & 16) != 0) {
            f = pullToRefreshElement.threshold;
        }
        float f2 = f;
        boolean z3 = z2;
        return pullToRefreshElement.m2793copyM2VBTUQ(z, function02, z3, pullToRefreshState, f2);
    }

    public final boolean component1() {
        return this.isRefreshing;
    }

    public final Function0<Unit> component2() {
        return this.onRefresh;
    }

    public final boolean component3() {
        return this.enabled;
    }

    public final PullToRefreshState component4() {
        return this.state;
    }

    /* renamed from: component5-D9Ej5fM  reason: not valid java name */
    public final float m2792component5D9Ej5fM() {
        return this.threshold;
    }

    /* renamed from: copy-M2VBTUQ  reason: not valid java name */
    public final PullToRefreshElement m2793copyM2VBTUQ(boolean z, Function0<Unit> function0, boolean z2, PullToRefreshState pullToRefreshState, float f) {
        return new PullToRefreshElement(z, function0, z2, pullToRefreshState, f, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PullToRefreshElement) {
            PullToRefreshElement pullToRefreshElement = (PullToRefreshElement) obj;
            return this.isRefreshing == pullToRefreshElement.isRefreshing && Intrinsics.areEqual(this.onRefresh, pullToRefreshElement.onRefresh) && this.enabled == pullToRefreshElement.enabled && Intrinsics.areEqual(this.state, pullToRefreshElement.state) && Dp.m6689equalsimpl0(this.threshold, pullToRefreshElement.threshold);
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((((((Boolean.hashCode(this.isRefreshing) * 31) + this.onRefresh.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31) + this.state.hashCode()) * 31) + Dp.m6690hashCodeimpl(this.threshold);
    }

    public String toString() {
        return "PullToRefreshElement(isRefreshing=" + this.isRefreshing + ", onRefresh=" + this.onRefresh + ", enabled=" + this.enabled + ", state=" + this.state + ", threshold=" + ((Object) Dp.m6695toStringimpl(this.threshold)) + ')';
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    public final Function0<Unit> getOnRefresh() {
        return this.onRefresh;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final PullToRefreshState getState() {
        return this.state;
    }

    /* renamed from: getThreshold-D9Ej5fM  reason: not valid java name */
    public final float m2794getThresholdD9Ej5fM() {
        return this.threshold;
    }

    private PullToRefreshElement(boolean z, Function0<Unit> function0, boolean z2, PullToRefreshState pullToRefreshState, float f) {
        this.isRefreshing = z;
        this.onRefresh = function0;
        this.enabled = z2;
        this.state = pullToRefreshState;
        this.threshold = f;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public PullToRefreshModifierNode create() {
        return new PullToRefreshModifierNode(this.isRefreshing, this.onRefresh, this.enabled, this.state, this.threshold, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(PullToRefreshModifierNode pullToRefreshModifierNode) {
        pullToRefreshModifierNode.setOnRefresh(this.onRefresh);
        pullToRefreshModifierNode.setEnabled(this.enabled);
        pullToRefreshModifierNode.setState(this.state);
        pullToRefreshModifierNode.m2807setThreshold0680j_4(this.threshold);
        boolean isRefreshing = pullToRefreshModifierNode.isRefreshing();
        boolean z = this.isRefreshing;
        if (isRefreshing != z) {
            pullToRefreshModifierNode.setRefreshing(z);
            pullToRefreshModifierNode.update();
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("PullToRefreshModifierNode");
        inspectorInfo.getProperties().set("isRefreshing", Boolean.valueOf(this.isRefreshing));
        inspectorInfo.getProperties().set("onRefresh", this.onRefresh);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        inspectorInfo.getProperties().set(RemoteConfigConstants.ResponseFieldKey.STATE, this.state);
        inspectorInfo.getProperties().set("threshold", Dp.m6682boximpl(this.threshold));
    }
}
