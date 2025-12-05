package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperationKt;
import androidx.compose.foundation.text.input.internal.undo.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextUndoManager.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0017J\b\u0010\u001e\u001a\u00020\u0017H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager;", "", "initialStagingUndo", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "undoManager", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "<init>", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;Landroidx/compose/foundation/text/input/internal/undo/UndoManager;)V", "<set-?>", "stagingUndo", "getStagingUndo", "()Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "setStagingUndo", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)V", "stagingUndo$delegate", "Landroidx/compose/runtime/MutableState;", "canUndo", "", "getCanUndo", "()Z", "canRedo", "getCanRedo", "undo", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "redo", "record", "op", "clearHistory", "flush", "Companion", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextUndoManager {
    private final MutableState stagingUndo$delegate;
    private final UndoManager<TextUndoOperation> undoManager;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TextUndoManager() {
        this(null, null, 3, null);
    }

    public TextUndoManager(TextUndoOperation textUndoOperation, UndoManager<TextUndoOperation> undoManager) {
        MutableState mutableStateOf$default;
        this.undoManager = undoManager;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(textUndoOperation, null, 2, null);
        this.stagingUndo$delegate = mutableStateOf$default;
    }

    public /* synthetic */ TextUndoManager(TextUndoOperation textUndoOperation, UndoManager undoManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textUndoOperation, (i & 2) != 0 ? new UndoManager(null, null, 100, 3, null) : undoManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextUndoOperation getStagingUndo() {
        return (TextUndoOperation) this.stagingUndo$delegate.getValue();
    }

    private final void setStagingUndo(TextUndoOperation textUndoOperation) {
        this.stagingUndo$delegate.setValue(textUndoOperation);
    }

    public final boolean getCanUndo() {
        return this.undoManager.getCanUndo$foundation() || getStagingUndo() != null;
    }

    public final boolean getCanRedo() {
        return this.undoManager.getCanRedo$foundation() && getStagingUndo() == null;
    }

    public final void undo(TextFieldState textFieldState) {
        if (getCanUndo()) {
            flush();
            TextUndoOperationKt.undo(textFieldState, this.undoManager.undo());
        }
    }

    public final void redo(TextFieldState textFieldState) {
        if (getCanRedo()) {
            TextUndoOperationKt.redo(textFieldState, this.undoManager.redo());
        }
    }

    public final void record(TextUndoOperation textUndoOperation) {
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextUndoOperation stagingUndo = getStagingUndo();
            if (stagingUndo == null) {
                setStagingUndo(textUndoOperation);
                return;
            }
            TextUndoOperation merge = TextUndoManagerKt.merge(stagingUndo, textUndoOperation);
            if (merge != null) {
                setStagingUndo(merge);
                return;
            }
            flush();
            setStagingUndo(textUndoOperation);
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    public final void clearHistory() {
        setStagingUndo(null);
        this.undoManager.clearHistory();
    }

    private final void flush() {
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextUndoOperation stagingUndo = getStagingUndo();
            if (stagingUndo != null) {
                this.undoManager.record(stagingUndo);
            }
            setStagingUndo(null);
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    /* compiled from: TextUndoManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager$Companion;", "", "<init>", "()V", "Saver", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: TextUndoManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\t\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R \u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/input/TextUndoManager$Companion$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextUndoManager;", "", "<init>", "()V", "undoManagerSaver", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "value", "restore", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextUndoManager, Object> {
            public static final int $stable;
            public static final Saver INSTANCE = new Saver();
            private static final androidx.compose.runtime.saveable.Saver<UndoManager<TextUndoOperation>, Object> undoManagerSaver;

            private Saver() {
            }

            static {
                UndoManager.Companion companion = UndoManager.Companion;
                final androidx.compose.runtime.saveable.Saver<TextUndoOperation, Object> saver = TextUndoOperation.Companion.getSaver();
                undoManagerSaver = new androidx.compose.runtime.saveable.Saver<UndoManager<TextUndoOperation>, Object>() { // from class: androidx.compose.foundation.text.input.TextUndoManager$Companion$Saver$special$$inlined$createSaver$1
                    @Override // androidx.compose.runtime.saveable.Saver
                    public Object save(SaverScope saverScope, UndoManager<TextUndoOperation> undoManager) {
                        int i;
                        SnapshotStateList snapshotStateList;
                        SnapshotStateList snapshotStateList2;
                        SnapshotStateList snapshotStateList3;
                        SnapshotStateList snapshotStateList4;
                        Saver saver2 = Saver.this;
                        List createListBuilder = CollectionsKt.createListBuilder();
                        i = ((UndoManager) undoManager).capacity;
                        createListBuilder.add(Integer.valueOf(i));
                        snapshotStateList = ((UndoManager) undoManager).undoStack;
                        createListBuilder.add(Integer.valueOf(snapshotStateList.size()));
                        snapshotStateList2 = ((UndoManager) undoManager).redoStack;
                        createListBuilder.add(Integer.valueOf(snapshotStateList2.size()));
                        snapshotStateList3 = ((UndoManager) undoManager).undoStack;
                        SnapshotStateList snapshotStateList5 = snapshotStateList3;
                        int size = snapshotStateList5.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            createListBuilder.add(saver2.save(saverScope, snapshotStateList5.get(i2)));
                        }
                        snapshotStateList4 = ((UndoManager) undoManager).redoStack;
                        SnapshotStateList snapshotStateList6 = snapshotStateList4;
                        int size2 = snapshotStateList6.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            createListBuilder.add(saver2.save(saverScope, snapshotStateList6.get(i3)));
                        }
                        return CollectionsKt.build(createListBuilder);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // androidx.compose.runtime.saveable.Saver
                    public UndoManager<TextUndoOperation> restore(Object obj) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                        List list = (List) obj;
                        int intValue = ((Number) list.get(0)).intValue();
                        int intValue2 = ((Number) list.get(1)).intValue();
                        int intValue3 = ((Number) list.get(2)).intValue();
                        Saver saver2 = Saver.this;
                        List createListBuilder = CollectionsKt.createListBuilder();
                        int i = 3;
                        while (i < intValue2 + 3) {
                            Object restore = saver2.restore(list.get(i));
                            Intrinsics.checkNotNull(restore);
                            createListBuilder.add(restore);
                            i++;
                        }
                        List build = CollectionsKt.build(createListBuilder);
                        Saver saver3 = Saver.this;
                        List createListBuilder2 = CollectionsKt.createListBuilder();
                        while (i < intValue2 + intValue3 + 3) {
                            Object restore2 = saver3.restore(list.get(i));
                            Intrinsics.checkNotNull(restore2);
                            createListBuilder2.add(restore2);
                            i++;
                        }
                        return new UndoManager<>(build, CollectionsKt.build(createListBuilder2), intValue);
                    }
                };
                $stable = 8;
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public Object save(SaverScope saverScope, TextUndoManager textUndoManager) {
                TextUndoOperation stagingUndo = textUndoManager.getStagingUndo();
                return CollectionsKt.listOf(stagingUndo != null ? TextUndoOperation.Companion.getSaver().save(saverScope, stagingUndo) : null, undoManagerSaver.save(saverScope, textUndoManager.undoManager));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.compose.runtime.saveable.Saver
            public TextUndoManager restore(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
                List list = (List) obj;
                Object obj2 = list.get(0);
                Object obj3 = list.get(1);
                TextUndoOperation restore = obj2 != null ? TextUndoOperation.Companion.getSaver().restore(obj2) : null;
                androidx.compose.runtime.saveable.Saver<UndoManager<TextUndoOperation>, Object> saver = undoManagerSaver;
                Intrinsics.checkNotNull(obj3);
                UndoManager<TextUndoOperation> restore2 = saver.restore(obj3);
                Intrinsics.checkNotNull(restore2);
                return new TextUndoManager(restore, restore2);
            }
        }

        private Companion() {
        }
    }
}
