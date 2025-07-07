package coil3.compose.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\f\u0010\u0017\u001a\u00020\u0015*\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÂ\u0003J\t\u0010\u001b\u001a\u00020\bHÂ\u0003J\t\u0010\u001c\u001a\u00020\nHÂ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÂ\u0003J\t\u0010\u001e\u001a\u00020\u000eHÂ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0010HÂ\u0003JS\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0010HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcoil3/compose/internal/SubcomposeContentPainterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcoil3/compose/internal/SubcomposeContentPainterNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clipToBounds", "", "contentDescription", "", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLjava/lang/String;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "coil-compose-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubcomposeContentPainterElement extends ModifierNodeElement<SubcomposeContentPainterNode> {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final float alpha;
    private final boolean clipToBounds;
    private final ColorFilter colorFilter;
    private final String contentDescription;
    private final ContentScale contentScale;
    private final Painter painter;

    private final Painter component1() {
        return this.painter;
    }

    private final Alignment component2() {
        return this.alignment;
    }

    private final ContentScale component3() {
        return this.contentScale;
    }

    private final float component4() {
        return this.alpha;
    }

    private final ColorFilter component5() {
        return this.colorFilter;
    }

    private final boolean component6() {
        return this.clipToBounds;
    }

    private final String component7() {
        return this.contentDescription;
    }

    public static /* synthetic */ SubcomposeContentPainterElement copy$default(SubcomposeContentPainterElement subcomposeContentPainterElement, Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            painter = subcomposeContentPainterElement.painter;
        }
        if ((i & 2) != 0) {
            alignment = subcomposeContentPainterElement.alignment;
        }
        if ((i & 4) != 0) {
            contentScale = subcomposeContentPainterElement.contentScale;
        }
        if ((i & 8) != 0) {
            f = subcomposeContentPainterElement.alpha;
        }
        if ((i & 16) != 0) {
            colorFilter = subcomposeContentPainterElement.colorFilter;
        }
        if ((i & 32) != 0) {
            z = subcomposeContentPainterElement.clipToBounds;
        }
        if ((i & 64) != 0) {
            str = subcomposeContentPainterElement.contentDescription;
        }
        boolean z2 = z;
        String str2 = str;
        ColorFilter colorFilter2 = colorFilter;
        ContentScale contentScale2 = contentScale;
        return subcomposeContentPainterElement.copy(painter, alignment, contentScale2, f, colorFilter2, z2, str2);
    }

    public final SubcomposeContentPainterElement copy(Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, String str) {
        return new SubcomposeContentPainterElement(painter, alignment, contentScale, f, colorFilter, z, str);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubcomposeContentPainterElement) {
            SubcomposeContentPainterElement subcomposeContentPainterElement = (SubcomposeContentPainterElement) obj;
            return Intrinsics.areEqual(this.painter, subcomposeContentPainterElement.painter) && Intrinsics.areEqual(this.alignment, subcomposeContentPainterElement.alignment) && Intrinsics.areEqual(this.contentScale, subcomposeContentPainterElement.contentScale) && Float.compare(this.alpha, subcomposeContentPainterElement.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, subcomposeContentPainterElement.colorFilter) && this.clipToBounds == subcomposeContentPainterElement.clipToBounds && Intrinsics.areEqual(this.contentDescription, subcomposeContentPainterElement.contentDescription);
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int hashCode = ((((((this.painter.hashCode() * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        int hashCode2 = (((hashCode + (colorFilter == null ? 0 : colorFilter.hashCode())) * 31) + Boolean.hashCode(this.clipToBounds)) * 31;
        String str = this.contentDescription;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        Painter painter = this.painter;
        Alignment alignment = this.alignment;
        ContentScale contentScale = this.contentScale;
        float f = this.alpha;
        ColorFilter colorFilter = this.colorFilter;
        boolean z = this.clipToBounds;
        return "SubcomposeContentPainterElement(painter=" + painter + ", alignment=" + alignment + ", contentScale=" + contentScale + ", alpha=" + f + ", colorFilter=" + colorFilter + ", clipToBounds=" + z + ", contentDescription=" + this.contentDescription + ")";
    }

    public SubcomposeContentPainterElement(Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, String str) {
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
        this.clipToBounds = z;
        this.contentDescription = str;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public SubcomposeContentPainterNode create() {
        return new SubcomposeContentPainterNode(this.painter, this.alignment, this.contentScale, this.alpha, this.colorFilter, this.clipToBounds, this.contentDescription);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SubcomposeContentPainterNode subcomposeContentPainterNode) {
        boolean m3902equalsimpl0 = Size.m3902equalsimpl0(subcomposeContentPainterNode.getPainter().mo4761getIntrinsicSizeNHjbRc(), this.painter.mo4761getIntrinsicSizeNHjbRc());
        subcomposeContentPainterNode.setPainter(this.painter);
        subcomposeContentPainterNode.setAlignment(this.alignment);
        subcomposeContentPainterNode.setContentScale(this.contentScale);
        subcomposeContentPainterNode.setAlpha(this.alpha);
        subcomposeContentPainterNode.setColorFilter(this.colorFilter);
        subcomposeContentPainterNode.setClipToBounds(this.clipToBounds);
        if (!Intrinsics.areEqual(subcomposeContentPainterNode.getContentDescription(), this.contentDescription)) {
            subcomposeContentPainterNode.setContentDescription(this.contentDescription);
            SemanticsModifierNodeKt.invalidateSemantics(subcomposeContentPainterNode);
        }
        if (!m3902equalsimpl0) {
            LayoutModifierNodeKt.invalidateMeasurement(subcomposeContentPainterNode);
        }
        DrawModifierNodeKt.invalidateDraw(subcomposeContentPainterNode);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName(FirebaseAnalytics.Param.CONTENT);
        inspectorInfo.getProperties().set("painter", this.painter);
        inspectorInfo.getProperties().set("alignment", this.alignment);
        inspectorInfo.getProperties().set("contentScale", this.contentScale);
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.alpha));
        inspectorInfo.getProperties().set("colorFilter", this.colorFilter);
        inspectorInfo.getProperties().set("clipToBounds", Boolean.valueOf(this.clipToBounds));
        inspectorInfo.getProperties().set("contentDescription", this.contentDescription);
    }
}
