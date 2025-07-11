package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: LayoutCorners.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;", "", "radius", "Landroidx/compose/ui/unit/Dp;", "isFixed", "", "<init>", "(FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRadius-D9Ej5fM", "()F", "F", "()Z", "component1", "component1-D9Ej5fM", "component2", "copy", "copy-D5KLDUw", "(FZ)Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;", "equals", "other", "hashCode", "", "toString", "", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LayoutCorner {
    public static final int $stable = 0;
    private final boolean isFixed;
    private final float radius;

    public /* synthetic */ LayoutCorner(float f, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, z);
    }

    /* renamed from: copy-D5KLDUw$default  reason: not valid java name */
    public static /* synthetic */ LayoutCorner m7999copyD5KLDUw$default(LayoutCorner layoutCorner, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = layoutCorner.radius;
        }
        if ((i & 2) != 0) {
            z = layoutCorner.isFixed;
        }
        return layoutCorner.m8001copyD5KLDUw(f, z);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m8000component1D9Ej5fM() {
        return this.radius;
    }

    public final boolean component2() {
        return this.isFixed;
    }

    /* renamed from: copy-D5KLDUw  reason: not valid java name */
    public final LayoutCorner m8001copyD5KLDUw(float f, boolean z) {
        return new LayoutCorner(f, z, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LayoutCorner) {
            LayoutCorner layoutCorner = (LayoutCorner) obj;
            return Dp.m6689equalsimpl0(this.radius, layoutCorner.radius) && this.isFixed == layoutCorner.isFixed;
        }
        return false;
    }

    public int hashCode() {
        return (Dp.m6690hashCodeimpl(this.radius) * 31) + Boolean.hashCode(this.isFixed);
    }

    public String toString() {
        return "LayoutCorner(radius=" + ((Object) Dp.m6695toStringimpl(this.radius)) + ", isFixed=" + this.isFixed + ')';
    }

    private LayoutCorner(float f, boolean z) {
        this.radius = f;
        this.isFixed = z;
    }

    /* renamed from: getRadius-D9Ej5fM  reason: not valid java name */
    public final float m8002getRadiusD9Ej5fM() {
        return this.radius;
    }

    public final boolean isFixed() {
        return this.isFixed;
    }

    public /* synthetic */ LayoutCorner(float f, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.m6684constructorimpl(16) : f, (i & 2) != 0 ? false : z, null);
    }
}
