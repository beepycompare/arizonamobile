package androidx.compose.ui.node;

import kotlin.Metadata;
/* compiled from: LayoutNodeLayoutDelegate.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "", "isPlacedUnderMotionFrameOfReference", "", "()Z", "updatePlacedUnderMotionFrameOfReference", "", "newMFR", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MotionReferencePlacementDelegate {
    boolean isPlacedUnderMotionFrameOfReference();

    void updatePlacedUnderMotionFrameOfReference(boolean z);
}
