package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
/* compiled from: PlatformVelocityTracker.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/input/pointer/util/PlatformVelocityTracker;", "", "addPointerInputChange", "", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "addPointerInputChange-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "addPosition", "timeMillis", "", "position", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "maximumVelocity", "calculateVelocity-AH228Gc", "(J)J", "resetTracking", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PlatformVelocityTracker {
    /* renamed from: addPointerInputChange-Uv8p0NA */
    void mo6781addPointerInputChangeUv8p0NA(PointerInputChange pointerInputChange, long j);

    /* renamed from: addPosition-Uv8p0NA */
    void mo6782addPositionUv8p0NA(long j, long j2);

    /* renamed from: calculateVelocity-AH228Gc */
    long mo6783calculateVelocityAH228Gc(long j);

    void resetTracking();
}
