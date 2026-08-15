package com.skydoves.cloudy;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CloudyBackground.android.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\f\u0010 \u001a\u00020\u0010*\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0002H\u0016J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u0010\u0010(\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b)\u0010\u001aJ\t\u0010*\u001a\u00020\fHÆ\u0003J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eHÆ\u0003JX\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0014\u0010/\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0083\u0004J\n\u00102\u001a\u00020\u0006HÖ\u0081\u0004J\n\u00103\u001a\u000204HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Lcom/skydoves/cloudy/CloudyBackgroundModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcom/skydoves/cloudy/CloudyBackgroundModifierNode;", "sky", "Lcom/skydoves/cloudy/Sky;", "radius", "", "progressive", "Lcom/skydoves/cloudy/CloudyProgressive;", "tint", "Landroidx/compose/ui/graphics/Color;", "cpuBlurEnabled", "", "onStateChanged", "Lkotlin/Function1;", "Lcom/skydoves/cloudy/CloudyState;", "", "<init>", "(Lcom/skydoves/cloudy/Sky;ILcom/skydoves/cloudy/CloudyProgressive;JZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSky", "()Lcom/skydoves/cloudy/Sky;", "getRadius", "()I", "getProgressive", "()Lcom/skydoves/cloudy/CloudyProgressive;", "getTint-0d7_KjU", "()J", "J", "getCpuBlurEnabled", "()Z", "getOnStateChanged", "()Lkotlin/jvm/functions/Function1;", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "create", "update", "node", "component1", "component2", "component3", "component4", "component4-0d7_KjU", "component5", "component6", "copy", "copy-Bx497Mc", "(Lcom/skydoves/cloudy/Sky;ILcom/skydoves/cloudy/CloudyProgressive;JZLkotlin/jvm/functions/Function1;)Lcom/skydoves/cloudy/CloudyBackgroundModifierElement;", "equals", "other", "", "hashCode", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
final class CloudyBackgroundModifierElement extends ModifierNodeElement<CloudyBackgroundModifierNode> {
    private final boolean cpuBlurEnabled;
    private final Function1<CloudyState, Unit> onStateChanged;
    private final CloudyProgressive progressive;
    private final int radius;
    private final Sky sky;
    private final long tint;

    public /* synthetic */ CloudyBackgroundModifierElement(Sky sky, int i, CloudyProgressive cloudyProgressive, long j, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(sky, i, cloudyProgressive, j, z, function1);
    }

    /* renamed from: copy-Bx497Mc$default  reason: not valid java name */
    public static /* synthetic */ CloudyBackgroundModifierElement m9866copyBx497Mc$default(CloudyBackgroundModifierElement cloudyBackgroundModifierElement, Sky sky, int i, CloudyProgressive cloudyProgressive, long j, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sky = cloudyBackgroundModifierElement.sky;
        }
        if ((i2 & 2) != 0) {
            i = cloudyBackgroundModifierElement.radius;
        }
        if ((i2 & 4) != 0) {
            cloudyProgressive = cloudyBackgroundModifierElement.progressive;
        }
        if ((i2 & 8) != 0) {
            j = cloudyBackgroundModifierElement.tint;
        }
        if ((i2 & 16) != 0) {
            z = cloudyBackgroundModifierElement.cpuBlurEnabled;
        }
        Function1<CloudyState, Unit> function12 = function1;
        if ((i2 & 32) != 0) {
            function12 = cloudyBackgroundModifierElement.onStateChanged;
        }
        long j2 = j;
        CloudyProgressive cloudyProgressive2 = cloudyProgressive;
        return cloudyBackgroundModifierElement.m9868copyBx497Mc(sky, i, cloudyProgressive2, j2, z, function12);
    }

    public final Sky component1() {
        return this.sky;
    }

    public final int component2() {
        return this.radius;
    }

    public final CloudyProgressive component3() {
        return this.progressive;
    }

    /* renamed from: component4-0d7_KjU  reason: not valid java name */
    public final long m9867component40d7_KjU() {
        return this.tint;
    }

    public final boolean component5() {
        return this.cpuBlurEnabled;
    }

    public final Function1<CloudyState, Unit> component6() {
        return this.onStateChanged;
    }

    /* renamed from: copy-Bx497Mc  reason: not valid java name */
    public final CloudyBackgroundModifierElement m9868copyBx497Mc(Sky sky, int i, CloudyProgressive progressive, long j, boolean z, Function1<? super CloudyState, Unit> onStateChanged) {
        Intrinsics.checkNotNullParameter(sky, "sky");
        Intrinsics.checkNotNullParameter(progressive, "progressive");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        return new CloudyBackgroundModifierElement(sky, i, progressive, j, z, onStateChanged, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CloudyBackgroundModifierElement) {
            CloudyBackgroundModifierElement cloudyBackgroundModifierElement = (CloudyBackgroundModifierElement) obj;
            return Intrinsics.areEqual(this.sky, cloudyBackgroundModifierElement.sky) && this.radius == cloudyBackgroundModifierElement.radius && Intrinsics.areEqual(this.progressive, cloudyBackgroundModifierElement.progressive) && Color.m5349equalsimpl0(this.tint, cloudyBackgroundModifierElement.tint) && this.cpuBlurEnabled == cloudyBackgroundModifierElement.cpuBlurEnabled && Intrinsics.areEqual(this.onStateChanged, cloudyBackgroundModifierElement.onStateChanged);
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((((((((this.sky.hashCode() * 31) + Integer.hashCode(this.radius)) * 31) + this.progressive.hashCode()) * 31) + Color.m5355hashCodeimpl(this.tint)) * 31) + Boolean.hashCode(this.cpuBlurEnabled)) * 31) + this.onStateChanged.hashCode();
    }

    public String toString() {
        return "CloudyBackgroundModifierElement(sky=" + this.sky + ", radius=" + this.radius + ", progressive=" + this.progressive + ", tint=" + ((Object) Color.m5356toStringimpl(this.tint)) + ", cpuBlurEnabled=" + this.cpuBlurEnabled + ", onStateChanged=" + this.onStateChanged + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CloudyBackgroundModifierElement(Sky sky, int i, CloudyProgressive progressive, long j, boolean z, Function1<? super CloudyState, Unit> onStateChanged) {
        Intrinsics.checkNotNullParameter(sky, "sky");
        Intrinsics.checkNotNullParameter(progressive, "progressive");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        this.sky = sky;
        this.radius = i;
        this.progressive = progressive;
        this.tint = j;
        this.cpuBlurEnabled = z;
        this.onStateChanged = onStateChanged;
    }

    public final Sky getSky() {
        return this.sky;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final CloudyProgressive getProgressive() {
        return this.progressive;
    }

    /* renamed from: getTint-0d7_KjU  reason: not valid java name */
    public final long m9869getTint0d7_KjU() {
        return this.tint;
    }

    public final boolean getCpuBlurEnabled() {
        return this.cpuBlurEnabled;
    }

    public final Function1<CloudyState, Unit> getOnStateChanged() {
        return this.onStateChanged;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName("cloudy");
        inspectorInfo.getProperties().set("sky", this.sky);
        inspectorInfo.getProperties().set("radius", Integer.valueOf(this.radius));
        inspectorInfo.getProperties().set("progressive", this.progressive);
        inspectorInfo.getProperties().set("tint", Color.m5338boximpl(this.tint));
        inspectorInfo.getProperties().set("cpuBlurEnabled", Boolean.valueOf(this.cpuBlurEnabled));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public CloudyBackgroundModifierNode create() {
        return new CloudyBackgroundModifierNode(this.sky, this.radius, this.progressive, this.tint, this.cpuBlurEnabled, this.onStateChanged, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(CloudyBackgroundModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.m9870updateBx497Mc(this.sky, this.radius, this.progressive, this.tint, this.cpuBlurEnabled, this.onStateChanged);
    }
}
