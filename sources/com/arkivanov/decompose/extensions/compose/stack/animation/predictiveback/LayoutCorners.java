package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutCorners.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorners;", "", "topStart", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;)V", "getTopStart", "()Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/LayoutCorner;", "getTopEnd", "getBottomEnd", "getBottomStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LayoutCorners {
    public static final int $stable = 0;
    private final LayoutCorner bottomEnd;
    private final LayoutCorner bottomStart;
    private final LayoutCorner topEnd;
    private final LayoutCorner topStart;

    public LayoutCorners() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ LayoutCorners copy$default(LayoutCorners layoutCorners, LayoutCorner layoutCorner, LayoutCorner layoutCorner2, LayoutCorner layoutCorner3, LayoutCorner layoutCorner4, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutCorner = layoutCorners.topStart;
        }
        if ((i & 2) != 0) {
            layoutCorner2 = layoutCorners.topEnd;
        }
        if ((i & 4) != 0) {
            layoutCorner3 = layoutCorners.bottomEnd;
        }
        if ((i & 8) != 0) {
            layoutCorner4 = layoutCorners.bottomStart;
        }
        return layoutCorners.copy(layoutCorner, layoutCorner2, layoutCorner3, layoutCorner4);
    }

    public final LayoutCorner component1() {
        return this.topStart;
    }

    public final LayoutCorner component2() {
        return this.topEnd;
    }

    public final LayoutCorner component3() {
        return this.bottomEnd;
    }

    public final LayoutCorner component4() {
        return this.bottomStart;
    }

    public final LayoutCorners copy(LayoutCorner topStart, LayoutCorner topEnd, LayoutCorner bottomEnd, LayoutCorner bottomStart) {
        Intrinsics.checkNotNullParameter(topStart, "topStart");
        Intrinsics.checkNotNullParameter(topEnd, "topEnd");
        Intrinsics.checkNotNullParameter(bottomEnd, "bottomEnd");
        Intrinsics.checkNotNullParameter(bottomStart, "bottomStart");
        return new LayoutCorners(topStart, topEnd, bottomEnd, bottomStart);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LayoutCorners) {
            LayoutCorners layoutCorners = (LayoutCorners) obj;
            return Intrinsics.areEqual(this.topStart, layoutCorners.topStart) && Intrinsics.areEqual(this.topEnd, layoutCorners.topEnd) && Intrinsics.areEqual(this.bottomEnd, layoutCorners.bottomEnd) && Intrinsics.areEqual(this.bottomStart, layoutCorners.bottomStart);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.topStart.hashCode() * 31) + this.topEnd.hashCode()) * 31) + this.bottomEnd.hashCode()) * 31) + this.bottomStart.hashCode();
    }

    public String toString() {
        return "LayoutCorners(topStart=" + this.topStart + ", topEnd=" + this.topEnd + ", bottomEnd=" + this.bottomEnd + ", bottomStart=" + this.bottomStart + ')';
    }

    public LayoutCorners(LayoutCorner topStart, LayoutCorner topEnd, LayoutCorner bottomEnd, LayoutCorner bottomStart) {
        Intrinsics.checkNotNullParameter(topStart, "topStart");
        Intrinsics.checkNotNullParameter(topEnd, "topEnd");
        Intrinsics.checkNotNullParameter(bottomEnd, "bottomEnd");
        Intrinsics.checkNotNullParameter(bottomStart, "bottomStart");
        this.topStart = topStart;
        this.topEnd = topEnd;
        this.bottomEnd = bottomEnd;
        this.bottomStart = bottomStart;
    }

    public /* synthetic */ LayoutCorners(LayoutCorner layoutCorner, LayoutCorner layoutCorner2, LayoutCorner layoutCorner3, LayoutCorner layoutCorner4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LayoutCorner(0.0f, false, 3, null) : layoutCorner, (i & 2) != 0 ? new LayoutCorner(0.0f, false, 3, null) : layoutCorner2, (i & 4) != 0 ? new LayoutCorner(0.0f, false, 3, null) : layoutCorner3, (i & 8) != 0 ? new LayoutCorner(0.0f, false, 3, null) : layoutCorner4);
    }

    public final LayoutCorner getTopStart() {
        return this.topStart;
    }

    public final LayoutCorner getTopEnd() {
        return this.topEnd;
    }

    public final LayoutCorner getBottomEnd() {
        return this.bottomEnd;
    }

    public final LayoutCorner getBottomStart() {
        return this.bottomStart;
    }
}
