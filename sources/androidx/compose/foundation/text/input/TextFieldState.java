package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextUndoManager;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: TextFieldState.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\\]B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\"\u0010/\u001a\u0002002\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0086\bJ\b\u00104\u001a\u00020\u0003H\u0016J\b\u0010:\u001a\u00020\u000fH\u0001J\u0010\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020\u000fH\u0001J\b\u0010=\u001a\u000200H\u0001JE\u0010>\u001a\u0002002\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u00172\b\b\u0002\u0010B\u001a\u00020C2\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0080\b¢\u0006\u0002\bDJ'\u0010E\u001a\u0002002\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0080\b¢\u0006\u0002\bFJ&\u0010G\u001a\u0002002\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u00172\b\b\u0002\u0010B\u001a\u00020CH\u0002J \u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\u0017H\u0002J(\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020N2\u0006\u0010B\u001a\u00020CH\u0002J\u0015\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0000¢\u0006\u0002\bRJ\u0015\u0010S\u001a\u0002002\u0006\u0010P\u001a\u00020QH\u0000¢\u0006\u0002\bTJ%\u0010U\u001a\u0002002\u0006\u0010V\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u0017H\u0001¢\u0006\u0002\bYR\u0014\u0010\u000b\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u001e8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u001d\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001c\u00105\u001a\u0002068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0011\u001a\u0004\b8\u00109R\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020Q0[X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState;", "", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "initialTextUndoManager", "Landroidx/compose/foundation/text/input/TextUndoManager;", "<init>", "(Ljava/lang/String;JLandroidx/compose/foundation/text/input/TextUndoManager;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "textUndoManager", "getTextUndoManager$foundation", "()Landroidx/compose/foundation/text/input/TextUndoManager;", "mainBuffer", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "getMainBuffer$foundation$annotations", "()V", "getMainBuffer$foundation", "()Landroidx/compose/foundation/text/input/TextFieldBuffer;", "setMainBuffer$foundation", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;)V", "<set-?>", "", "isEditing", "()Z", "setEditing", "(Z)V", "isEditing$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "value", "getValue$foundation", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "setValue", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;)V", "value$delegate", "text", "", "getText", "()Ljava/lang/CharSequence;", "selection", "getSelection-d9O1mEE", "()J", "composition", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "edit", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "toString", "undoState", "Landroidx/compose/foundation/text/input/UndoState;", "getUndoState$annotations", "getUndoState", "()Landroidx/compose/foundation/text/input/UndoState;", "startEdit", "commitEdit", "newValue", "finishEditing", "editAsUser", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "restartImeIfContentChanges", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "editAsUser$foundation", "editWithNoSideEffects", "editWithNoSideEffects$foundation", "commitEditAsUser", "updateValueAndNotifyListeners", "oldValue", "recordEditForUndo", "previousValue", "postValue", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "addNotifyImeListener", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "addNotifyImeListener$foundation", "removeNotifyImeListener", "removeNotifyImeListener$foundation", "syncMainBufferToTemporaryBuffer", "temporaryBuffer", "textChanged", "selectionChanged", "syncMainBufferToTemporaryBuffer$foundation", "notifyImeListeners", "Landroidx/compose/runtime/collection/MutableVector;", "NotifyImeListener", "Saver", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldState {
    public static final int $stable = 0;
    private final MutableState isEditing$delegate;
    private TextFieldBuffer mainBuffer;
    private final MutableVector<NotifyImeListener> notifyImeListeners;
    private final TextUndoManager textUndoManager;
    private final UndoState undoState;
    private final MutableState value$delegate;

    /* compiled from: TextFieldState.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "", "onChange", "", "oldValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "newValue", "restartIme", "", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface NotifyImeListener {
        void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z);
    }

    /* compiled from: TextFieldState.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFieldEditUndoBehavior.values().length];
            try {
                iArr[TextFieldEditUndoBehavior.ClearHistory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldEditUndoBehavior.MergeIfPossible.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextFieldEditUndoBehavior.NeverMerge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ TextFieldState(String str, long j, TextUndoManager textUndoManager, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, textUndoManager);
    }

    public /* synthetic */ TextFieldState(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    public static /* synthetic */ void getMainBuffer$foundation$annotations() {
    }

    public static /* synthetic */ void getUndoState$annotations() {
    }

    private TextFieldState(String str, long j, TextUndoManager textUndoManager) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.textUndoManager = textUndoManager;
        String str2 = str;
        this.mainBuffer = new TextFieldBuffer(new TextFieldCharSequence(str2, TextRangeKt.m7009coerceIn8ffj60Q(j, 0, str.length()), null, null, null, null, 60, null), null, null, null, 14, null);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isEditing$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldCharSequence(str2, j, null, null, null, null, 60, null), null, 2, null);
        this.value$delegate = mutableStateOf$default2;
        this.undoState = new UndoState(this);
        this.notifyImeListeners = new MutableVector<>(new NotifyImeListener[16], 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TextFieldState(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? TextRangeKt.TextRange(str.length()) : j, (DefaultConstructorMarker) null);
        str = (i & 1) != 0 ? "" : str;
    }

    private TextFieldState(String str, long j) {
        this(str, j, new TextUndoManager(null, null, 3, null), (DefaultConstructorMarker) null);
    }

    public final TextUndoManager getTextUndoManager$foundation() {
        return this.textUndoManager;
    }

    public final TextFieldBuffer getMainBuffer$foundation() {
        return this.mainBuffer;
    }

    public final void setMainBuffer$foundation(TextFieldBuffer textFieldBuffer) {
        this.mainBuffer = textFieldBuffer;
    }

    private final boolean isEditing() {
        return ((Boolean) this.isEditing$delegate.getValue()).booleanValue();
    }

    private final void setEditing(boolean z) {
        this.isEditing$delegate.setValue(Boolean.valueOf(z));
    }

    private final void setValue(TextFieldCharSequence textFieldCharSequence) {
        this.value$delegate.setValue(textFieldCharSequence);
    }

    public final TextFieldCharSequence getValue$foundation() {
        return (TextFieldCharSequence) this.value$delegate.getValue();
    }

    public final CharSequence getText() {
        return getValue$foundation().getText();
    }

    /* renamed from: getSelection-d9O1mEE */
    public final long m1338getSelectiond9O1mEE() {
        return getValue$foundation().m1336getSelectiond9O1mEE();
    }

    /* renamed from: getComposition-MzsxiRA */
    public final TextRange m1337getCompositionMzsxiRA() {
        return getValue$foundation().m1335getCompositionMzsxiRA();
    }

    public final void edit(Function1<? super TextFieldBuffer, Unit> function1) {
        TextFieldBuffer startEdit = startEdit();
        try {
            function1.invoke(startEdit);
            commitEdit(startEdit);
        } finally {
            finishEditing();
        }
    }

    public String toString() {
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            return "TextFieldState(selection=" + ((Object) TextRange.m7006toStringimpl(m1338getSelectiond9O1mEE())) + ", text=\"" + ((Object) getText()) + "\")";
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    public final UndoState getUndoState() {
        return this.undoState;
    }

    public final TextFieldBuffer startEdit() {
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (isEditing()) {
                InlineClassHelperKt.throwIllegalStateException("TextFieldState does not support concurrent or nested editing.");
            }
            setEditing(true);
            return new TextFieldBuffer(getValue$foundation(), null, null, null, 14, null);
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    public final void commitEdit(TextFieldBuffer textFieldBuffer) {
        TextFieldBuffer textFieldBuffer2;
        boolean z = textFieldBuffer.getChanges().getChangeCount() > 0;
        boolean m6996equalsimpl0 = TextRange.m6996equalsimpl0(textFieldBuffer.m1328getSelectiond9O1mEE(), this.mainBuffer.m1328getSelectiond9O1mEE());
        boolean z2 = !m6996equalsimpl0;
        if (!z && m6996equalsimpl0) {
            textFieldBuffer.setCanCallAddStyle$foundation(true);
        }
        if (z) {
            textFieldBuffer2 = textFieldBuffer;
            recordEditForUndo(getValue$foundation(), TextFieldBuffer.m1325toTextFieldCharSequencewFTz33Y$foundation$default(textFieldBuffer2, 0L, null, null, null, 15, null), textFieldBuffer2.getChanges(), TextFieldEditUndoBehavior.NeverMerge);
        } else {
            textFieldBuffer2 = textFieldBuffer;
        }
        syncMainBufferToTemporaryBuffer$foundation(textFieldBuffer2, z, z2);
    }

    public final void finishEditing() {
        setEditing(false);
    }

    public static /* synthetic */ void editAsUser$foundation$default(TextFieldState textFieldState, InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        textFieldState.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        function1.invoke(textFieldState.getMainBuffer$foundation());
        textFieldState.commitEditAsUser(inputTransformation, z, textFieldEditUndoBehavior);
    }

    public final void editAsUser$foundation(InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, Function1<? super TextFieldBuffer, Unit> function1) {
        getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        function1.invoke(getMainBuffer$foundation());
        commitEditAsUser(inputTransformation, z, textFieldEditUndoBehavior);
    }

    public final void editWithNoSideEffects$foundation(Function1<? super TextFieldBuffer, Unit> function1) {
        getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        function1.invoke(getMainBuffer$foundation());
        updateValueAndNotifyListeners(getValue$foundation(), TextFieldBuffer.m1325toTextFieldCharSequencewFTz33Y$foundation$default(getMainBuffer$foundation(), 0L, null, null, null, 15, null), true);
    }

    static /* synthetic */ void commitEditAsUser$default(TextFieldState textFieldState, InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        textFieldState.commitEditAsUser(inputTransformation, z, textFieldEditUndoBehavior);
    }

    public final void commitEditAsUser(InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        List m1340finalizeComposingAnnotationsitr0ztk;
        List m1340finalizeComposingAnnotationsitr0ztk2;
        TextFieldCharSequence value$foundation = getValue$foundation();
        if (this.mainBuffer.getChangeTracker$foundation().getChangeCount() == 0 && TextRange.m6996equalsimpl0(value$foundation.m1336getSelectiond9O1mEE(), this.mainBuffer.m1328getSelectiond9O1mEE())) {
            if (Intrinsics.areEqual(value$foundation.m1335getCompositionMzsxiRA(), this.mainBuffer.m1326getCompositionMzsxiRA$foundation()) && Intrinsics.areEqual(value$foundation.getHighlight(), this.mainBuffer.getHighlight$foundation()) && Intrinsics.areEqual(value$foundation.getComposingAnnotations(), this.mainBuffer.getComposingAnnotations$foundation())) {
                return;
            }
            TextFieldCharSequence value$foundation2 = getValue$foundation();
            long m1328getSelectiond9O1mEE = this.mainBuffer.m1328getSelectiond9O1mEE();
            TextRange m1326getCompositionMzsxiRA$foundation = this.mainBuffer.m1326getCompositionMzsxiRA$foundation();
            Pair<TextHighlightType, TextRange> highlight$foundation = this.mainBuffer.getHighlight$foundation();
            m1340finalizeComposingAnnotationsitr0ztk2 = TextFieldStateKt.m1340finalizeComposingAnnotationsitr0ztk(this.mainBuffer.m1326getCompositionMzsxiRA$foundation(), this.mainBuffer.getComposingAnnotations$foundation());
            updateValueAndNotifyListeners(value$foundation2, new TextFieldCharSequence(this.mainBuffer.toString(), m1328getSelectiond9O1mEE, m1326getCompositionMzsxiRA$foundation, highlight$foundation, m1340finalizeComposingAnnotationsitr0ztk2, null, 32, null), z);
            return;
        }
        boolean z2 = false;
        boolean z3 = this.mainBuffer.getChangeTracker$foundation().getChangeCount() != 0;
        long m1328getSelectiond9O1mEE2 = this.mainBuffer.m1328getSelectiond9O1mEE();
        TextRange m1326getCompositionMzsxiRA$foundation2 = this.mainBuffer.m1326getCompositionMzsxiRA$foundation();
        Pair<TextHighlightType, TextRange> highlight$foundation2 = this.mainBuffer.getHighlight$foundation();
        m1340finalizeComposingAnnotationsitr0ztk = TextFieldStateKt.m1340finalizeComposingAnnotationsitr0ztk(this.mainBuffer.m1326getCompositionMzsxiRA$foundation(), this.mainBuffer.getComposingAnnotations$foundation());
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence(this.mainBuffer.toString(), m1328getSelectiond9O1mEE2, m1326getCompositionMzsxiRA$foundation2, highlight$foundation2, m1340finalizeComposingAnnotationsitr0ztk, null, 32, null);
        if (inputTransformation == null) {
            if (z3 && z) {
                z2 = true;
            }
            updateValueAndNotifyListeners(value$foundation, textFieldCharSequence, z2);
            recordEditForUndo(value$foundation, textFieldCharSequence, this.mainBuffer.getChangeTracker$foundation(), textFieldEditUndoBehavior);
            return;
        }
        TextFieldBuffer textFieldBuffer = new TextFieldBuffer(textFieldCharSequence, this.mainBuffer.getChangeTracker$foundation(), value$foundation, null, 8, null);
        inputTransformation.transformInput(textFieldBuffer);
        boolean contentEquals = StringsKt.contentEquals(textFieldBuffer.asCharSequence(), textFieldCharSequence);
        boolean z4 = !contentEquals;
        boolean m6996equalsimpl0 = TextRange.m6996equalsimpl0(textFieldBuffer.m1328getSelectiond9O1mEE(), textFieldCharSequence.m1336getSelectiond9O1mEE());
        boolean z5 = !m6996equalsimpl0;
        if (!contentEquals || !m6996equalsimpl0) {
            syncMainBufferToTemporaryBuffer$foundation(textFieldBuffer, z4, z5);
        } else {
            updateValueAndNotifyListeners(value$foundation, TextFieldBuffer.m1325toTextFieldCharSequencewFTz33Y$foundation$default(textFieldBuffer, 0L, textFieldCharSequence.m1335getCompositionMzsxiRA(), null, null, 13, null), z);
        }
        recordEditForUndo(value$foundation, getValue$foundation(), textFieldBuffer.getChanges(), textFieldEditUndoBehavior);
    }

    public final void updateValueAndNotifyListeners(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
        setValue(textFieldCharSequence2);
        finishEditing();
        MutableVector<NotifyImeListener> mutableVector = this.notifyImeListeners;
        NotifyImeListener[] notifyImeListenerArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            notifyImeListenerArr[i].onChange(textFieldCharSequence, textFieldCharSequence2, (!z || textFieldCharSequence.contentEquals(textFieldCharSequence2) || textFieldCharSequence.m1335getCompositionMzsxiRA() == null) ? false : true);
        }
    }

    private final void recordEditForUndo(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, TextFieldBuffer.ChangeList changeList, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        int i = WhenMappings.$EnumSwitchMapping$0[textFieldEditUndoBehavior.ordinal()];
        if (i == 1) {
            this.textUndoManager.clearHistory();
        } else if (i == 2) {
            TextUndoManagerKt.recordChanges(this.textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, true);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            TextUndoManagerKt.recordChanges(this.textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, false);
        }
    }

    public final void addNotifyImeListener$foundation(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.add(notifyImeListener);
    }

    public final void removeNotifyImeListener$foundation(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.remove(notifyImeListener);
    }

    public final void syncMainBufferToTemporaryBuffer$foundation(TextFieldBuffer textFieldBuffer, boolean z, boolean z2) {
        TextFieldCharSequence m1325toTextFieldCharSequencewFTz33Y$foundation$default = TextFieldBuffer.m1325toTextFieldCharSequencewFTz33Y$foundation$default(this.mainBuffer, 0L, null, null, null, 15, null);
        if (z) {
            this.mainBuffer = new TextFieldBuffer(new TextFieldCharSequence(textFieldBuffer.toString(), textFieldBuffer.m1328getSelectiond9O1mEE(), null, null, null, null, 60, null), null, null, null, 14, null);
        } else if (z2) {
            this.mainBuffer.m1330setSelection5zctL8(TextRangeKt.TextRange(TextRange.m7003getStartimpl(textFieldBuffer.m1328getSelectiond9O1mEE()), TextRange.m6998getEndimpl(textFieldBuffer.m1328getSelectiond9O1mEE())));
        }
        if (z || z2 || !Intrinsics.areEqual(m1325toTextFieldCharSequencewFTz33Y$foundation$default.m1335getCompositionMzsxiRA(), textFieldBuffer.m1326getCompositionMzsxiRA$foundation())) {
            this.mainBuffer.commitComposition$foundation();
        }
        updateValueAndNotifyListeners(m1325toTextFieldCharSequencewFTz33Y$foundation$default, TextFieldBuffer.m1325toTextFieldCharSequencewFTz33Y$foundation$default(this.mainBuffer, 0L, null, null, null, 15, null), true);
    }

    /* compiled from: TextFieldState.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextFieldState;", "", "<init>", "()V", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "value", "restore", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextFieldState, Object> {
        public static final int $stable = 0;
        public static final Saver INSTANCE = new Saver();

        private Saver() {
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public Object save(SaverScope saverScope, TextFieldState textFieldState) {
            return CollectionsKt.listOf(textFieldState.getText().toString(), Integer.valueOf(TextRange.m7003getStartimpl(textFieldState.m1338getSelectiond9O1mEE())), Integer.valueOf(TextRange.m6998getEndimpl(textFieldState.m1338getSelectiond9O1mEE())), TextUndoManager.Companion.Saver.INSTANCE.save(saverScope, textFieldState.getTextUndoManager$foundation()));
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public TextFieldState restore(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Object obj3 = list.get(1);
            Object obj4 = list.get(2);
            Object obj5 = list.get(3);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
            long TextRange = TextRangeKt.TextRange(intValue, ((Integer) obj4).intValue());
            TextUndoManager.Companion.Saver saver = TextUndoManager.Companion.Saver.INSTANCE;
            Intrinsics.checkNotNull(obj5);
            TextUndoManager restore = saver.restore(obj5);
            Intrinsics.checkNotNull(restore);
            return new TextFieldState(str, TextRange, restore, (DefaultConstructorMarker) null);
        }
    }
}
