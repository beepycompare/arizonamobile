package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutCorners.android.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\b\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\b\u0015J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/CornerRadii;", "", "topLeft", "Landroidx/compose/ui/unit/Dp;", "topRight", "bottomRight", "bottomLeft", "<init>", "(Landroidx/compose/ui/unit/Dp;Landroidx/compose/ui/unit/Dp;Landroidx/compose/ui/unit/Dp;Landroidx/compose/ui/unit/Dp;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTopLeft-lTKBWiU", "()Landroidx/compose/ui/unit/Dp;", "getTopRight-lTKBWiU", "getBottomRight-lTKBWiU", "getBottomLeft-lTKBWiU", "component1", "component1-lTKBWiU", "component2", "component2-lTKBWiU", "component3", "component3-lTKBWiU", "component4", "component4-lTKBWiU", "copy", "copy-WZe73OQ", "equals", "", "other", "hashCode", "", "toString", "", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class CornerRadii {
    private final Dp bottomLeft;
    private final Dp bottomRight;
    private final Dp topLeft;
    private final Dp topRight;

    public /* synthetic */ CornerRadii(Dp dp, Dp dp2, Dp dp3, Dp dp4, DefaultConstructorMarker defaultConstructorMarker) {
        this(dp, dp2, dp3, dp4);
    }

    /* renamed from: copy-WZe73OQ$default  reason: not valid java name */
    public static /* synthetic */ CornerRadii m7990copyWZe73OQ$default(CornerRadii cornerRadii, Dp dp, Dp dp2, Dp dp3, Dp dp4, int i, Object obj) {
        if ((i & 1) != 0) {
            dp = cornerRadii.topLeft;
        }
        if ((i & 2) != 0) {
            dp2 = cornerRadii.topRight;
        }
        if ((i & 4) != 0) {
            dp3 = cornerRadii.bottomRight;
        }
        if ((i & 8) != 0) {
            dp4 = cornerRadii.bottomLeft;
        }
        return cornerRadii.m7995copyWZe73OQ(dp, dp2, dp3, dp4);
    }

    /* renamed from: component1-lTKBWiU  reason: not valid java name */
    public final Dp m7991component1lTKBWiU() {
        return this.topLeft;
    }

    /* renamed from: component2-lTKBWiU  reason: not valid java name */
    public final Dp m7992component2lTKBWiU() {
        return this.topRight;
    }

    /* renamed from: component3-lTKBWiU  reason: not valid java name */
    public final Dp m7993component3lTKBWiU() {
        return this.bottomRight;
    }

    /* renamed from: component4-lTKBWiU  reason: not valid java name */
    public final Dp m7994component4lTKBWiU() {
        return this.bottomLeft;
    }

    /* renamed from: copy-WZe73OQ  reason: not valid java name */
    public final CornerRadii m7995copyWZe73OQ(Dp dp, Dp dp2, Dp dp3, Dp dp4) {
        return new CornerRadii(dp, dp2, dp3, dp4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CornerRadii) {
            CornerRadii cornerRadii = (CornerRadii) obj;
            return Intrinsics.areEqual(this.topLeft, cornerRadii.topLeft) && Intrinsics.areEqual(this.topRight, cornerRadii.topRight) && Intrinsics.areEqual(this.bottomRight, cornerRadii.bottomRight) && Intrinsics.areEqual(this.bottomLeft, cornerRadii.bottomLeft);
        }
        return false;
    }

    public int hashCode() {
        Dp dp = this.topLeft;
        int m6690hashCodeimpl = (dp == null ? 0 : Dp.m6690hashCodeimpl(dp.m6698unboximpl())) * 31;
        Dp dp2 = this.topRight;
        int m6690hashCodeimpl2 = (m6690hashCodeimpl + (dp2 == null ? 0 : Dp.m6690hashCodeimpl(dp2.m6698unboximpl()))) * 31;
        Dp dp3 = this.bottomRight;
        int m6690hashCodeimpl3 = (m6690hashCodeimpl2 + (dp3 == null ? 0 : Dp.m6690hashCodeimpl(dp3.m6698unboximpl()))) * 31;
        Dp dp4 = this.bottomLeft;
        return m6690hashCodeimpl3 + (dp4 != null ? Dp.m6690hashCodeimpl(dp4.m6698unboximpl()) : 0);
    }

    public String toString() {
        return "CornerRadii(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomRight=" + this.bottomRight + ", bottomLeft=" + this.bottomLeft + ')';
    }

    private CornerRadii(Dp dp, Dp dp2, Dp dp3, Dp dp4) {
        this.topLeft = dp;
        this.topRight = dp2;
        this.bottomRight = dp3;
        this.bottomLeft = dp4;
    }

    public /* synthetic */ CornerRadii(Dp dp, Dp dp2, Dp dp3, Dp dp4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dp, (i & 2) != 0 ? null : dp2, (i & 4) != 0 ? null : dp3, (i & 8) != 0 ? null : dp4, null);
    }

    /* renamed from: getTopLeft-lTKBWiU  reason: not valid java name */
    public final Dp m7998getTopLeftlTKBWiU() {
        return this.topLeft;
    }

    /* renamed from: getTopRight-lTKBWiU  reason: not valid java name */
    public final Dp m7999getTopRightlTKBWiU() {
        return this.topRight;
    }

    /* renamed from: getBottomRight-lTKBWiU  reason: not valid java name */
    public final Dp m7997getBottomRightlTKBWiU() {
        return this.bottomRight;
    }

    /* renamed from: getBottomLeft-lTKBWiU  reason: not valid java name */
    public final Dp m7996getBottomLeftlTKBWiU() {
        return this.bottomLeft;
    }
}
