package androidx.compose.ui.text.input;

import androidx.compose.ui.text.CharHelpers_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
/* compiled from: EditCommand.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/input/BackspaceCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "<init>", "()V", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BackspaceCommand implements EditCommand {
    public static final int $stable = 0;

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer editingBuffer) {
        if (editingBuffer.hasComposition$ui_text()) {
            editingBuffer.delete$ui_text(editingBuffer.getCompositionStart$ui_text(), editingBuffer.getCompositionEnd$ui_text());
        } else if (editingBuffer.getCursor$ui_text() == -1) {
            int selectionStart$ui_text = editingBuffer.getSelectionStart$ui_text();
            int selectionEnd$ui_text = editingBuffer.getSelectionEnd$ui_text();
            editingBuffer.setCursor$ui_text(editingBuffer.getSelectionStart$ui_text());
            editingBuffer.delete$ui_text(selectionStart$ui_text, selectionEnd$ui_text);
        } else if (editingBuffer.getCursor$ui_text() == 0) {
        } else {
            editingBuffer.delete$ui_text(CharHelpers_androidKt.findPrecedingBreak(editingBuffer.toString(), editingBuffer.getCursor$ui_text()), editingBuffer.getCursor$ui_text());
        }
    }

    public boolean equals(Object obj) {
        return obj instanceof BackspaceCommand;
    }

    public int hashCode() {
        return Reflection.getOrCreateKotlinClass(getClass()).hashCode();
    }

    public String toString() {
        return "BackspaceCommand()";
    }
}
