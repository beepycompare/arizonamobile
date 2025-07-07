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
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: TextFieldState.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0002[\\B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001fH\u0000¢\u0006\u0002\b9J\u0010\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020\u0016H\u0001J&\u0010<\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010@\u001a\u00020AH\u0002J\"\u0010B\u001a\u0002072\u0017\u0010C\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002070D¢\u0006\u0002\bEH\u0086\bJE\u0010F\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010@\u001a\u00020A2\u0017\u0010C\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002070D¢\u0006\u0002\bEH\u0080\b¢\u0006\u0002\bGJ'\u0010H\u001a\u0002072\u0017\u0010C\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002070D¢\u0006\u0002\bEH\u0080\b¢\u0006\u0002\bIJ\b\u0010J\u001a\u000207H\u0001J(\u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020O2\u0006\u0010@\u001a\u00020AH\u0002J\u0015\u0010P\u001a\u0002072\u0006\u00108\u001a\u00020\u001fH\u0000¢\u0006\u0002\bQJ\b\u0010R\u001a\u00020\u0016H\u0001J%\u0010S\u001a\u0002072\u0006\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\u000eH\u0001¢\u0006\u0002\bWJ\b\u0010X\u001a\u00020\u0003H\u0016J \u0010Y\u001a\u0002072\u0006\u0010Z\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010?\u001a\u00020\u000eH\u0002R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010*\u001a\u00020+8GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010.R+\u00100\u001a\u00020/2\u0006\u0010\r\u001a\u00020/8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0014\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006]"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState;", "", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "initialTextUndoManager", "Landroidx/compose/foundation/text/input/TextUndoManager;", "(Ljava/lang/String;JLandroidx/compose/foundation/text/input/TextUndoManager;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "composition", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "<set-?>", "", "isEditing", "()Z", "setEditing", "(Z)V", "isEditing$delegate", "Landroidx/compose/runtime/MutableState;", "mainBuffer", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "getMainBuffer$foundation_release$annotations", "()V", "getMainBuffer$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldBuffer;", "setMainBuffer$foundation_release", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;)V", "notifyImeListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "selection", "getSelection-d9O1mEE", "()J", "text", "", "getText", "()Ljava/lang/CharSequence;", "textUndoManager", "getTextUndoManager$foundation_release", "()Landroidx/compose/foundation/text/input/TextUndoManager;", "undoState", "Landroidx/compose/foundation/text/input/UndoState;", "getUndoState$annotations", "getUndoState", "()Landroidx/compose/foundation/text/input/UndoState;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "value", "getValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "setValue", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;)V", "value$delegate", "addNotifyImeListener", "", "notifyImeListener", "addNotifyImeListener$foundation_release", "commitEdit", "newValue", "commitEditAsUser", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "restartImeIfContentChanges", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "edit", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "editAsUser", "editAsUser$foundation_release", "editWithNoSideEffects", "editWithNoSideEffects$foundation_release", "finishEditing", "recordEditForUndo", "previousValue", "postValue", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "removeNotifyImeListener", "removeNotifyImeListener$foundation_release", "startEdit", "syncMainBufferToTemporaryBuffer", "temporaryBuffer", "textChanged", "selectionChanged", "syncMainBufferToTemporaryBuffer$foundation_release", "toString", "updateValueAndNotifyListeners", "oldValue", "NotifyImeListener", "Saver", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "", "onChange", "", "oldValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "newValue", "restartIme", "", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface NotifyImeListener {
        void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z);
    }

    /* compiled from: TextFieldState.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
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

    public static /* synthetic */ void getMainBuffer$foundation_release$annotations() {
    }

    public static /* synthetic */ void getUndoState$annotations() {
    }

    private TextFieldState(String str, long j, TextUndoManager textUndoManager) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.textUndoManager = textUndoManager;
        String str2 = str;
        this.mainBuffer = new TextFieldBuffer(new TextFieldCharSequence(str2, TextRangeKt.m6153coerceIn8ffj60Q(j, 0, str.length()), null, null, null, 28, null), null, null, null, 14, null);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isEditing$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldCharSequence(str2, j, null, null, null, 28, null), null, 2, null);
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

    public final TextUndoManager getTextUndoManager$foundation_release() {
        return this.textUndoManager;
    }

    public final TextFieldBuffer getMainBuffer$foundation_release() {
        return this.mainBuffer;
    }

    public final void setMainBuffer$foundation_release(TextFieldBuffer textFieldBuffer) {
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

    public final TextFieldCharSequence getValue$foundation_release() {
        return (TextFieldCharSequence) this.value$delegate.getValue();
    }

    public final CharSequence getText() {
        return getValue$foundation_release().getText();
    }

    /* renamed from: getSelection-d9O1mEE */
    public final long m1205getSelectiond9O1mEE() {
        return getValue$foundation_release().m1203getSelectiond9O1mEE();
    }

    /* renamed from: getComposition-MzsxiRA */
    public final TextRange m1204getCompositionMzsxiRA() {
        return getValue$foundation_release().m1202getCompositionMzsxiRA();
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
            return "TextFieldState(selection=" + ((Object) TextRange.m6150toStringimpl(m1205getSelectiond9O1mEE())) + ", text=\"" + ((Object) getText()) + "\")";
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
            return new TextFieldBuffer(getValue$foundation_release(), null, null, null, 14, null);
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    public final void commitEdit(TextFieldBuffer textFieldBuffer) {
        boolean z = textFieldBuffer.getChanges().getChangeCount() > 0;
        boolean m6140equalsimpl0 = true ^ TextRange.m6140equalsimpl0(textFieldBuffer.m1195getSelectiond9O1mEE(), this.mainBuffer.m1195getSelectiond9O1mEE());
        if (z) {
            this.textUndoManager.clearHistory();
        }
        syncMainBufferToTemporaryBuffer$foundation_release(textFieldBuffer, z, m6140equalsimpl0);
    }

    public final void finishEditing() {
        setEditing(false);
    }

    public static /* synthetic */ void editAsUser$foundation_release$default(TextFieldState textFieldState, InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        textFieldState.getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        function1.invoke(textFieldState.getMainBuffer$foundation_release());
        textFieldState.commitEditAsUser(inputTransformation, z, textFieldEditUndoBehavior);
    }

    public final void editAsUser$foundation_release(InputTransformation inputTransformation, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, Function1<? super TextFieldBuffer, Unit> function1) {
        getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        function1.invoke(getMainBuffer$foundation_release());
        commitEditAsUser(inputTransformation, z, textFieldEditUndoBehavior);
    }

    public final void editWithNoSideEffects$foundation_release(Function1<? super TextFieldBuffer, Unit> function1) {
        getMainBuffer$foundation_release().getChangeTracker$foundation_release().clearChanges();
        function1.invoke(getMainBuffer$foundation_release());
        updateValueAndNotifyListeners(getValue$foundation_release(), TextFieldBuffer.m1192toTextFieldCharSequenceI88jaVs$foundation_release$default(getMainBuffer$foundation_release(), 0L, null, null, 7, null), true);
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
        List m1207finalizeComposingAnnotationsitr0ztk;
        List m1207finalizeComposingAnnotationsitr0ztk2;
        TextFieldCharSequence value$foundation_release = getValue$foundation_release();
        if (this.mainBuffer.getChangeTracker$foundation_release().getChangeCount() == 0 && TextRange.m6140equalsimpl0(value$foundation_release.m1203getSelectiond9O1mEE(), this.mainBuffer.m1195getSelectiond9O1mEE())) {
            if (Intrinsics.areEqual(value$foundation_release.m1202getCompositionMzsxiRA(), this.mainBuffer.m1193getCompositionMzsxiRA$foundation_release()) && Intrinsics.areEqual(value$foundation_release.getHighlight(), this.mainBuffer.getHighlight$foundation_release()) && Intrinsics.areEqual(value$foundation_release.getComposingAnnotations(), this.mainBuffer.getComposingAnnotations$foundation_release())) {
                return;
            }
            TextFieldCharSequence value$foundation_release2 = getValue$foundation_release();
            String textFieldBuffer = this.mainBuffer.toString();
            long m1195getSelectiond9O1mEE = this.mainBuffer.m1195getSelectiond9O1mEE();
            TextRange m1193getCompositionMzsxiRA$foundation_release = this.mainBuffer.m1193getCompositionMzsxiRA$foundation_release();
            Pair<TextHighlightType, TextRange> highlight$foundation_release = this.mainBuffer.getHighlight$foundation_release();
            m1207finalizeComposingAnnotationsitr0ztk2 = TextFieldStateKt.m1207finalizeComposingAnnotationsitr0ztk(this.mainBuffer.m1193getCompositionMzsxiRA$foundation_release(), this.mainBuffer.getComposingAnnotations$foundation_release());
            updateValueAndNotifyListeners(value$foundation_release2, new TextFieldCharSequence(textFieldBuffer, m1195getSelectiond9O1mEE, m1193getCompositionMzsxiRA$foundation_release, highlight$foundation_release, m1207finalizeComposingAnnotationsitr0ztk2, null), z);
            return;
        }
        boolean z2 = false;
        boolean z3 = this.mainBuffer.getChangeTracker$foundation_release().getChangeCount() != 0;
        long m1195getSelectiond9O1mEE2 = this.mainBuffer.m1195getSelectiond9O1mEE();
        TextRange m1193getCompositionMzsxiRA$foundation_release2 = this.mainBuffer.m1193getCompositionMzsxiRA$foundation_release();
        Pair<TextHighlightType, TextRange> highlight$foundation_release2 = this.mainBuffer.getHighlight$foundation_release();
        m1207finalizeComposingAnnotationsitr0ztk = TextFieldStateKt.m1207finalizeComposingAnnotationsitr0ztk(this.mainBuffer.m1193getCompositionMzsxiRA$foundation_release(), this.mainBuffer.getComposingAnnotations$foundation_release());
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence(this.mainBuffer.toString(), m1195getSelectiond9O1mEE2, m1193getCompositionMzsxiRA$foundation_release2, highlight$foundation_release2, m1207finalizeComposingAnnotationsitr0ztk, null);
        if (inputTransformation == null) {
            if (z3 && z) {
                z2 = true;
            }
            updateValueAndNotifyListeners(value$foundation_release, textFieldCharSequence, z2);
            recordEditForUndo(value$foundation_release, textFieldCharSequence, this.mainBuffer.getChangeTracker$foundation_release(), textFieldEditUndoBehavior);
            return;
        }
        TextFieldBuffer textFieldBuffer2 = new TextFieldBuffer(textFieldCharSequence, this.mainBuffer.getChangeTracker$foundation_release(), value$foundation_release, null, 8, null);
        inputTransformation.transformInput(textFieldBuffer2);
        boolean contentEquals = StringsKt.contentEquals(textFieldBuffer2.asCharSequence(), textFieldCharSequence);
        boolean z4 = !contentEquals;
        boolean m6140equalsimpl0 = TextRange.m6140equalsimpl0(textFieldBuffer2.m1195getSelectiond9O1mEE(), textFieldCharSequence.m1203getSelectiond9O1mEE());
        boolean z5 = !m6140equalsimpl0;
        if (!contentEquals || !m6140equalsimpl0) {
            syncMainBufferToTemporaryBuffer$foundation_release(textFieldBuffer2, z4, z5);
        } else {
            updateValueAndNotifyListeners(value$foundation_release, TextFieldBuffer.m1192toTextFieldCharSequenceI88jaVs$foundation_release$default(textFieldBuffer2, 0L, textFieldCharSequence.m1202getCompositionMzsxiRA(), null, 5, null), z);
        }
        recordEditForUndo(value$foundation_release, getValue$foundation_release(), textFieldBuffer2.getChanges(), textFieldEditUndoBehavior);
    }

    public final void updateValueAndNotifyListeners(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
        setValue(textFieldCharSequence2);
        finishEditing();
        MutableVector<NotifyImeListener> mutableVector = this.notifyImeListeners;
        NotifyImeListener[] notifyImeListenerArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            notifyImeListenerArr[i].onChange(textFieldCharSequence, textFieldCharSequence2, (!z || textFieldCharSequence.contentEquals(textFieldCharSequence2) || textFieldCharSequence.m1202getCompositionMzsxiRA() == null) ? false : true);
        }
    }

    private final void recordEditForUndo(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, TextFieldBuffer.ChangeList changeList, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        int i = WhenMappings.$EnumSwitchMapping$0[textFieldEditUndoBehavior.ordinal()];
        if (i == 1) {
            this.textUndoManager.clearHistory();
        } else if (i == 2) {
            TextUndoManagerKt.recordChanges(this.textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, true);
        } else if (i != 3) {
        } else {
            TextUndoManagerKt.recordChanges(this.textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, false);
        }
    }

    public final void addNotifyImeListener$foundation_release(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.add(notifyImeListener);
    }

    public final void removeNotifyImeListener$foundation_release(NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.remove(notifyImeListener);
    }

    public final void syncMainBufferToTemporaryBuffer$foundation_release(TextFieldBuffer textFieldBuffer, boolean z, boolean z2) {
        TextFieldCharSequence m1192toTextFieldCharSequenceI88jaVs$foundation_release$default = TextFieldBuffer.m1192toTextFieldCharSequenceI88jaVs$foundation_release$default(this.mainBuffer, 0L, null, null, 7, null);
        if (z) {
            this.mainBuffer = new TextFieldBuffer(new TextFieldCharSequence(textFieldBuffer.toString(), textFieldBuffer.m1195getSelectiond9O1mEE(), null, null, null, 28, null), null, null, null, 14, null);
        } else if (z2) {
            this.mainBuffer.m1197setSelection5zctL8(TextRangeKt.TextRange(TextRange.m6147getStartimpl(textFieldBuffer.m1195getSelectiond9O1mEE()), TextRange.m6142getEndimpl(textFieldBuffer.m1195getSelectiond9O1mEE())));
        }
        if (z || z2 || !Intrinsics.areEqual(m1192toTextFieldCharSequenceI88jaVs$foundation_release$default.m1202getCompositionMzsxiRA(), textFieldBuffer.m1193getCompositionMzsxiRA$foundation_release())) {
            this.mainBuffer.commitComposition$foundation_release();
        }
        updateValueAndNotifyListeners(m1192toTextFieldCharSequenceI88jaVs$foundation_release$default, TextFieldBuffer.m1192toTextFieldCharSequenceI88jaVs$foundation_release$default(this.mainBuffer, 0L, null, null, 7, null), true);
    }

    /* compiled from: TextFieldState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextFieldState;", "", "()V", "restore", "value", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextFieldState, Object> {
        public static final int $stable = 0;
        public static final Saver INSTANCE = new Saver();

        private Saver() {
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public Object save(SaverScope saverScope, TextFieldState textFieldState) {
            return CollectionsKt.listOf(textFieldState.getText().toString(), Integer.valueOf(TextRange.m6147getStartimpl(textFieldState.m1205getSelectiond9O1mEE())), Integer.valueOf(TextRange.m6142getEndimpl(textFieldState.m1205getSelectiond9O1mEE())), TextUndoManager.Companion.Saver.INSTANCE.save(saverScope, textFieldState.getTextUndoManager$foundation_release()));
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
