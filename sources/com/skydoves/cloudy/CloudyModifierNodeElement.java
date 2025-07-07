package com.skydoves.cloudy;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CloudyModifierNode.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u000f\u001a\u00020\b*\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/skydoves/cloudy/CloudyModifierNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcom/skydoves/cloudy/CloudyModifierNode;", "radius", "", "onStateChanged", "Lkotlin/Function1;", "Lcom/skydoves/cloudy/CloudyState;", "", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "getRadius", "()I", "getOnStateChanged", "()Lkotlin/jvm/functions/Function1;", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "create", "update", "node", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "cloudy_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class CloudyModifierNodeElement extends ModifierNodeElement<CloudyModifierNode> {
    private final Function1<CloudyState, Unit> onStateChanged;
    private final int radius;

    public CloudyModifierNodeElement() {
        this(0, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CloudyModifierNodeElement copy$default(CloudyModifierNodeElement cloudyModifierNodeElement, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cloudyModifierNodeElement.radius;
        }
        if ((i2 & 2) != 0) {
            function1 = cloudyModifierNodeElement.onStateChanged;
        }
        return cloudyModifierNodeElement.copy(i, function1);
    }

    public final int component1() {
        return this.radius;
    }

    public final Function1<CloudyState, Unit> component2() {
        return this.onStateChanged;
    }

    public final CloudyModifierNodeElement copy(int i, Function1<? super CloudyState, Unit> onStateChanged) {
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        return new CloudyModifierNodeElement(i, onStateChanged);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CloudyModifierNodeElement) {
            CloudyModifierNodeElement cloudyModifierNodeElement = (CloudyModifierNodeElement) obj;
            return this.radius == cloudyModifierNodeElement.radius && Intrinsics.areEqual(this.onStateChanged, cloudyModifierNodeElement.onStateChanged);
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (Integer.hashCode(this.radius) * 31) + this.onStateChanged.hashCode();
    }

    public String toString() {
        return "CloudyModifierNodeElement(radius=" + this.radius + ", onStateChanged=" + this.onStateChanged + ')';
    }

    public final int getRadius() {
        return this.radius;
    }

    public /* synthetic */ CloudyModifierNodeElement(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i, (i2 & 2) != 0 ? new Function1() { // from class: com.skydoves.cloudy.CloudyModifierNodeElement$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = CloudyModifierNodeElement._init_$lambda$0((CloudyState) obj);
                return _init_$lambda$0;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(CloudyState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<CloudyState, Unit> getOnStateChanged() {
        return this.onStateChanged;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CloudyModifierNodeElement(int i, Function1<? super CloudyState, Unit> onStateChanged) {
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        this.radius = i;
        this.onStateChanged = onStateChanged;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName("cloudy");
        inspectorInfo.getProperties().set("cloudy", Integer.valueOf(this.radius));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public CloudyModifierNode create() {
        return new CloudyModifierNode(this.radius, this.onStateChanged);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(CloudyModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setRadius(this.radius);
    }
}
