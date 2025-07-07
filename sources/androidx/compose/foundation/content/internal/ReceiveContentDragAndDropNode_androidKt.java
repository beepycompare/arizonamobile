package androidx.compose.foundation.content.internal;

import android.view.DragEvent;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReceiveContentDragAndDropNode.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0006H\u0000¨\u0006\n"}, d2 = {"ReceiveContentDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "dragAndDropRequestPermission", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "toTransferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ReceiveContentDragAndDropNode_androidKt {
    public static final DragAndDropTargetModifierNode ReceiveContentDragAndDropNode(final ReceiveContentConfiguration receiveContentConfiguration, final Function1<? super DragAndDropEvent, Unit> function1) {
        return DragAndDropNodeKt.DragAndDropTargetModifierNode(new Function1<DragAndDropEvent, Boolean>() { // from class: androidx.compose.foundation.content.internal.ReceiveContentDragAndDropNode_androidKt$ReceiveContentDragAndDropNode$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(DragAndDropEvent dragAndDropEvent) {
                return true;
            }
        }, new DragAndDropTarget() { // from class: androidx.compose.foundation.content.internal.ReceiveContentDragAndDropNode_androidKt$ReceiveContentDragAndDropNode$2
            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void onStarted(DragAndDropEvent dragAndDropEvent) {
                ReceiveContentConfiguration.this.getReceiveContentListener().onDragStart();
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void onEnded(DragAndDropEvent dragAndDropEvent) {
                ReceiveContentConfiguration.this.getReceiveContentListener().onDragEnd();
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void onEntered(DragAndDropEvent dragAndDropEvent) {
                ReceiveContentConfiguration.this.getReceiveContentListener().onDragEnter();
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public void onExited(DragAndDropEvent dragAndDropEvent) {
                ReceiveContentConfiguration.this.getReceiveContentListener().onDragExit();
            }

            @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
            public boolean onDrop(DragAndDropEvent dragAndDropEvent) {
                function1.invoke(dragAndDropEvent);
                TransferableContent transferableContent = ReceiveContentDragAndDropNode_androidKt.toTransferableContent(dragAndDropEvent);
                return !Intrinsics.areEqual(transferableContent, ReceiveContentConfiguration.this.getReceiveContentListener().onReceive(transferableContent));
            }
        });
    }

    public static final TransferableContent toTransferableContent(DragAndDropEvent dragAndDropEvent) {
        DragEvent androidDragEvent = DragAndDrop_androidKt.toAndroidDragEvent(dragAndDropEvent);
        return new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(androidDragEvent.getClipData()), AndroidClipboardManager_androidKt.toClipMetadata(androidDragEvent.getClipDescription()), TransferableContent.Source.Companion.m349getDragAndDropkB6V9T0(), null, 8, null);
    }
}
