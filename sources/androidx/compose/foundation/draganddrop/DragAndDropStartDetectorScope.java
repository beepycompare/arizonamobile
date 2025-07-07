package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
/* compiled from: DragAndDropSource.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "requestDragAndDropTransfer", "", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "requestDragAndDropTransfer-k-4lQ0M", "(J)V", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DragAndDropStartDetectorScope extends PointerInputScope {
    /* renamed from: requestDragAndDropTransfer-k-4lQ0M */
    void mo381requestDragAndDropTransferk4lQ0M(long j);

    /* renamed from: requestDragAndDropTransfer-k-4lQ0M$default  reason: not valid java name */
    static /* synthetic */ void m394requestDragAndDropTransferk4lQ0M$default(DragAndDropStartDetectorScope dragAndDropStartDetectorScope, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestDragAndDropTransfer-k-4lQ0M");
        }
        if ((i & 1) != 0) {
            j = Offset.Companion.m3852getUnspecifiedF1C5BW0();
        }
        dragAndDropStartDetectorScope.mo381requestDragAndDropTransferk4lQ0M(j);
    }
}
