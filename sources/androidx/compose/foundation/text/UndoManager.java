package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UndoManager.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\bJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/UndoManager;", "", "maxStoredCharacters", "", "(I)V", "forceNextSnapshot", "", "lastSnapshot", "", "Ljava/lang/Long;", "getMaxStoredCharacters", "()I", "redoStack", "Landroidx/compose/foundation/text/UndoManager$Entry;", "storedCharacters", "undoStack", "", "makeSnapshot", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "redo", "removeLastUndo", "snapshotIfNeeded", "now", "undo", "Entry", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UndoManager {
    public static final int $stable = 8;
    private boolean forceNextSnapshot;
    private Long lastSnapshot;
    private final int maxStoredCharacters;
    private Entry redoStack;
    private int storedCharacters;
    private Entry undoStack;

    public UndoManager() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UndoManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/text/UndoManager$Entry;", "", "next", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/foundation/text/UndoManager$Entry;Landroidx/compose/ui/text/input/TextFieldValue;)V", "getNext", "()Landroidx/compose/foundation/text/UndoManager$Entry;", "setNext", "(Landroidx/compose/foundation/text/UndoManager$Entry;)V", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Entry {
        private Entry next;
        private TextFieldValue value;

        public Entry(Entry entry, TextFieldValue textFieldValue) {
            this.next = entry;
            this.value = textFieldValue;
        }

        public /* synthetic */ Entry(Entry entry, TextFieldValue textFieldValue, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : entry, textFieldValue);
        }

        public final Entry getNext() {
            return this.next;
        }

        public final TextFieldValue getValue() {
            return this.value;
        }

        public final void setNext(Entry entry) {
            this.next = entry;
        }

        public final void setValue(TextFieldValue textFieldValue) {
            this.value = textFieldValue;
        }
    }

    public UndoManager(int i) {
        this.maxStoredCharacters = i;
    }

    public /* synthetic */ UndoManager(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 100000 : i);
    }

    public final int getMaxStoredCharacters() {
        return this.maxStoredCharacters;
    }

    public static /* synthetic */ void snapshotIfNeeded$default(UndoManager undoManager, TextFieldValue textFieldValue, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = UndoManager_jvmKt.timeNowMillis();
        }
        undoManager.snapshotIfNeeded(textFieldValue, j);
    }

    public final void snapshotIfNeeded(TextFieldValue textFieldValue, long j) {
        if (!this.forceNextSnapshot) {
            Long l = this.lastSnapshot;
            if (j <= (l != null ? l.longValue() : 0L) + UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS()) {
                return;
            }
        }
        this.lastSnapshot = Long.valueOf(j);
        makeSnapshot(textFieldValue);
    }

    public final void forceNextSnapshot() {
        this.forceNextSnapshot = true;
    }

    public final void makeSnapshot(TextFieldValue textFieldValue) {
        TextFieldValue value;
        this.forceNextSnapshot = false;
        Entry entry = this.undoStack;
        if (Intrinsics.areEqual(textFieldValue, entry != null ? entry.getValue() : null)) {
            return;
        }
        String text = textFieldValue.getText();
        Entry entry2 = this.undoStack;
        if (Intrinsics.areEqual(text, (entry2 == null || (value = entry2.getValue()) == null) ? null : value.getText())) {
            Entry entry3 = this.undoStack;
            if (entry3 == null) {
                return;
            }
            entry3.setValue(textFieldValue);
            return;
        }
        this.undoStack = new Entry(this.undoStack, textFieldValue);
        this.redoStack = null;
        int length = this.storedCharacters + textFieldValue.getText().length();
        this.storedCharacters = length;
        if (length > this.maxStoredCharacters) {
            removeLastUndo();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001e A[LOOP:0: B:8:0x000e->B:14:0x001e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0023 A[EDGE_INSN: B:19:0x0023->B:15:0x0023 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void removeLastUndo() {
        Entry entry;
        Entry entry2 = this.undoStack;
        if ((entry2 != null ? entry2.getNext() : null) == null) {
            return;
        }
        while (true) {
            if (entry2 != null) {
                Entry next = entry2.getNext();
                if (next != null) {
                    entry = next.getNext();
                    if (entry != null) {
                        break;
                    }
                    entry2 = entry2.getNext();
                }
            }
            entry = null;
            if (entry != null) {
            }
        }
        if (entry2 == null) {
            return;
        }
        entry2.setNext(null);
    }

    public final TextFieldValue undo() {
        Entry next;
        Entry entry = this.undoStack;
        if (entry == null || (next = entry.getNext()) == null) {
            return null;
        }
        this.undoStack = next;
        this.storedCharacters -= entry.getValue().getText().length();
        this.redoStack = new Entry(this.redoStack, entry.getValue());
        return next.getValue();
    }

    public final TextFieldValue redo() {
        Entry entry = this.redoStack;
        if (entry != null) {
            this.redoStack = entry.getNext();
            this.undoStack = new Entry(this.undoStack, entry.getValue());
            this.storedCharacters += entry.getValue().getText().length();
            return entry.getValue();
        }
        return null;
    }
}
