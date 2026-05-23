package com.skydoves.cloudy;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CloudyBackground.android.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/skydoves/cloudy/SkyModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcom/skydoves/cloudy/SkyModifierNode;", "sky", "Lcom/skydoves/cloudy/Sky;", "<init>", "(Lcom/skydoves/cloudy/Sky;)V", "getSky", "()Lcom/skydoves/cloudy/Sky;", "inspectableProperties", "", "Landroidx/compose/ui/platform/InspectorInfo;", "create", "update", "node", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SkyModifierElement extends ModifierNodeElement<SkyModifierNode> {
    private final Sky sky;

    public static /* synthetic */ SkyModifierElement copy$default(SkyModifierElement skyModifierElement, Sky sky, int i, Object obj) {
        if ((i & 1) != 0) {
            sky = skyModifierElement.sky;
        }
        return skyModifierElement.copy(sky);
    }

    public final Sky component1() {
        return this.sky;
    }

    public final SkyModifierElement copy(Sky sky) {
        Intrinsics.checkNotNullParameter(sky, "sky");
        return new SkyModifierElement(sky);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SkyModifierElement) && Intrinsics.areEqual(this.sky, ((SkyModifierElement) obj).sky);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.sky.hashCode();
    }

    public String toString() {
        return "SkyModifierElement(sky=" + this.sky + ')';
    }

    public SkyModifierElement(Sky sky) {
        Intrinsics.checkNotNullParameter(sky, "sky");
        this.sky = sky;
    }

    public final Sky getSky() {
        return this.sky;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName("sky");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public SkyModifierNode create() {
        return new SkyModifierNode(this.sky);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SkyModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setSky(this.sky);
    }
}
