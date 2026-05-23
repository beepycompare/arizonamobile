package com.skydoves.cloudy;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Sky.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u0006\u0010\u001e\u001a\u00020\u001cR/\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/skydoves/cloudy/Sky;", "", "<init>", "()V", "<set-?>", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "backgroundLayer", "getBackgroundLayer$cloudy_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setBackgroundLayer$cloudy_release", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "backgroundLayer$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/geometry/Rect;", "sourceBounds", "getSourceBounds$cloudy_release", "()Landroidx/compose/ui/geometry/Rect;", "setSourceBounds$cloudy_release", "(Landroidx/compose/ui/geometry/Rect;)V", "sourceBounds$delegate", "", "contentVersion", "getContentVersion$cloudy_release", "()J", "setContentVersion", "(J)V", "contentVersion$delegate", "incrementContentVersion", "", "incrementContentVersion$cloudy_release", "invalidate", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Sky {
    public static final int $stable = 0;
    private final MutableState backgroundLayer$delegate;
    private final MutableState contentVersion$delegate;
    private final MutableState sourceBounds$delegate;

    public Sky() {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.backgroundLayer$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Rect.Companion.getZero(), null, 2, null);
        this.sourceBounds$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.contentVersion$delegate = mutableStateOf$default3;
    }

    public final GraphicsLayer getBackgroundLayer$cloudy_release() {
        return (GraphicsLayer) this.backgroundLayer$delegate.getValue();
    }

    public final void setBackgroundLayer$cloudy_release(GraphicsLayer graphicsLayer) {
        this.backgroundLayer$delegate.setValue(graphicsLayer);
    }

    public final Rect getSourceBounds$cloudy_release() {
        return (Rect) this.sourceBounds$delegate.getValue();
    }

    public final void setSourceBounds$cloudy_release(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.sourceBounds$delegate.setValue(rect);
    }

    private final void setContentVersion(long j) {
        this.contentVersion$delegate.setValue(Long.valueOf(j));
    }

    public final long getContentVersion$cloudy_release() {
        return ((Number) this.contentVersion$delegate.getValue()).longValue();
    }

    public final void incrementContentVersion$cloudy_release() {
        setContentVersion(getContentVersion$cloudy_release() + 1);
    }

    public final void invalidate() {
        incrementContentVersion$cloudy_release();
    }
}
