package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayoutCorners.android.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/ScreenInfo;", "", "cornerRadii", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/CornerRadii;", "width", "", "height", "<init>", "(Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/CornerRadii;II)V", "getCornerRadii", "()Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/CornerRadii;", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenInfo {
    private final CornerRadii cornerRadii;
    private final int height;
    private final int width;

    public static /* synthetic */ ScreenInfo copy$default(ScreenInfo screenInfo, CornerRadii cornerRadii, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cornerRadii = screenInfo.cornerRadii;
        }
        if ((i3 & 2) != 0) {
            i = screenInfo.width;
        }
        if ((i3 & 4) != 0) {
            i2 = screenInfo.height;
        }
        return screenInfo.copy(cornerRadii, i, i2);
    }

    public final CornerRadii component1() {
        return this.cornerRadii;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final ScreenInfo copy(CornerRadii cornerRadii, int i, int i2) {
        Intrinsics.checkNotNullParameter(cornerRadii, "cornerRadii");
        return new ScreenInfo(cornerRadii, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScreenInfo) {
            ScreenInfo screenInfo = (ScreenInfo) obj;
            return Intrinsics.areEqual(this.cornerRadii, screenInfo.cornerRadii) && this.width == screenInfo.width && this.height == screenInfo.height;
        }
        return false;
    }

    public int hashCode() {
        return (((this.cornerRadii.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "ScreenInfo(cornerRadii=" + this.cornerRadii + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public ScreenInfo(CornerRadii cornerRadii, int i, int i2) {
        Intrinsics.checkNotNullParameter(cornerRadii, "cornerRadii");
        this.cornerRadii = cornerRadii;
        this.width = i;
        this.height = i2;
    }

    public final CornerRadii getCornerRadii() {
        return this.cornerRadii;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
