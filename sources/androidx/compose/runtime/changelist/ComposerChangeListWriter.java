package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotReader;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.IntRef;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ComposerChangeListWriter.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001J\u001e\u0010)\u001a\u00020%2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010+2\u0006\u0010,\u001a\u00020-J(\u0010.\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204J\u0006\u00106\u001a\u00020%J\u0016\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020-2\u0006\u0010&\u001a\u00020'J\"\u00109\u001a\u00020%2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020%0;2\u0006\u0010=\u001a\u00020<J\u0006\u0010>\u001a\u00020%J\u0006\u0010?\u001a\u00020%J\u0006\u0010@\u001a\u00020%J\u0016\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\u0012J\u000e\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020%J\u0010\u0010H\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010I\u001a\u00020%H\u0002J\u0006\u0010J\u001a\u00020%J\u001a\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-J\u0016\u0010M\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u00103\u001a\u00020NJ\u001e\u0010M\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u00103\u001a\u00020N2\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020\u0012J\u0010\u0010S\u001a\u00020%2\b\u0010T\u001a\u0004\u0018\u00010\u0001J\u001e\u0010U\u001a\u00020%2\u0006\u00103\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\u0012J\u000e\u0010W\u001a\u00020%2\u0006\u0010X\u001a\u00020\u0012J\u000e\u0010Y\u001a\u00020%2\u0006\u0010X\u001a\u00020\u0012J\u0006\u0010Z\u001a\u00020%J\b\u0010[\u001a\u00020%H\u0002J\b\u0010\\\u001a\u00020%H\u0002J\b\u0010]\u001a\u00020%H\u0002J\u0012\u0010^\u001a\u00020%2\b\b\u0002\u0010_\u001a\u00020\fH\u0002J \u0010`\u001a\u00020%2\u0006\u00105\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\u0012H\u0002J\b\u0010a\u001a\u00020%H\u0002J\u0012\u0010b\u001a\u00020%2\b\b\u0002\u0010c\u001a\u00020\fH\u0002J\u0018\u0010d\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010e\u001a\u00020%J\u0006\u0010f\u001a\u00020%J\u001e\u0010g\u001a\u00020%2\u0006\u0010=\u001a\u00020h2\u0006\u00101\u001a\u0002022\u0006\u0010i\u001a\u000204J\u000e\u0010j\u001a\u00020%2\u0006\u0010(\u001a\u00020kJ\u000e\u0010l\u001a\u00020%2\u0006\u0010E\u001a\u00020FJ\u0006\u0010m\u001a\u00020%J\u0016\u0010n\u001a\u00020%2\u0006\u0010B\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\u0012J\u0006\u0010o\u001a\u00020%J\u0006\u0010p\u001a\u00020%J\u0014\u0010q\u001a\u00020%2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020%0sJ\u0006\u0010t\u001a\u00020%J\u000e\u0010u\u001a\u00020%2\u0006\u0010E\u001a\u00020FJ\u000e\u0010v\u001a\u00020%2\u0006\u0010V\u001a\u00020\u0012J \u0010w\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010x\u001a\u00020\u0012J\u0010\u0010y\u001a\u00020%2\b\u0010z\u001a\u0004\u0018\u00010\u0001J@\u0010{\u001a\u00020%\"\u0004\b\u0000\u0010|\"\u0004\b\u0001\u0010}2\u0006\u0010(\u001a\u0002H}2\u001e\u0010~\u001a\u001a\u0012\u0004\u0012\u0002H|\u0012\u0004\u0012\u0002H}\u0012\u0004\u0012\u00020%0\u007f¢\u0006\u0003\b\u0080\u0001¢\u0006\u0003\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010\u00012\u0006\u0010x\u001a\u00020\u0012J\u0011\u0010\u0083\u0001\u001a\u00020%2\b\u0010T\u001a\u0004\u0018\u00010\u0001J!\u0010\u0084\u0001\u001a\u00020%2\u0007\u0010\u0085\u0001\u001a\u00020\u00052\f\u0010~\u001a\b\u0012\u0004\u0012\u00020%0sH\u0086\bJ\u0018\u0010\u0086\u0001\u001a\u00020%2\f\u0010~\u001a\b\u0012\u0004\u0012\u00020%0sH\u0086\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0088\u0001"}, d2 = {"Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "", "composer", "Landroidx/compose/runtime/ComposerImpl;", "changeList", "Landroidx/compose/runtime/changelist/ChangeList;", "(Landroidx/compose/runtime/ComposerImpl;Landroidx/compose/runtime/changelist/ChangeList;)V", "getChangeList", "()Landroidx/compose/runtime/changelist/ChangeList;", "setChangeList", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "implicitRootStart", "", "getImplicitRootStart", "()Z", "setImplicitRootStart", "(Z)V", "moveCount", "", "moveFrom", "moveTo", "pastParent", "getPastParent", "pendingDownNodes", "Landroidx/compose/runtime/Stack;", "Ljava/util/ArrayList;", "pendingUps", "reader", "Landroidx/compose/runtime/SlotReader;", "getReader", "()Landroidx/compose/runtime/SlotReader;", "removeFrom", "startedGroup", "startedGroups", "Landroidx/compose/runtime/IntStack;", "writersReaderDelta", "appendValue", "", "anchor", "Landroidx/compose/runtime/Anchor;", "value", "copyNodesToNewAnchorLocation", "nodes", "", "effectiveNodeIndex", "Landroidx/compose/runtime/internal/IntRef;", "copySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "from", "Landroidx/compose/runtime/MovableContentStateReference;", TypedValues.TransitionType.S_TO, "deactivateCurrentGroup", "determineMovableContentNodeIndex", "effectiveNodeIndexOut", "endCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "endCurrentGroup", "endMovableContentPlacement", "endNodeMovement", "endNodeMovementAndDeleteNode", "nodeIndex", "group", "endResumingScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "endRoot", "ensureGroupStarted", "ensureRootStarted", "finalizeComposition", "includeOperationsIn", "other", "insertSlots", "Landroidx/compose/runtime/SlotTable;", "fixups", "Landroidx/compose/runtime/changelist/FixupList;", "moveCurrentGroup", TypedValues.CycleType.S_WAVE_OFFSET, "moveDown", "node", "moveNode", "count", "moveReaderRelativeTo", FirebaseAnalytics.Param.LOCATION, "moveReaderToAbsolute", "moveUp", "pushApplierOperationPreamble", "pushPendingUpsAndDowns", "pushSlotEditingOperationPreamble", "pushSlotTableOperationPreamble", "useParentSlot", "realizeMoveNode", "realizeNodeMovementOperations", "realizeOperationLocation", "forParent", "realizeRemoveNode", "recordSlotEditing", "releaseMovableContent", "releaseMovableGroupAtCurrent", "Landroidx/compose/runtime/ControlledComposition;", TypedValues.Custom.S_REFERENCE, "remember", "Landroidx/compose/runtime/RememberObserverHolder;", "rememberPausingScope", "removeCurrentGroup", "removeNode", "resetSlots", "resetTransientState", "sideEffect", "effect", "Lkotlin/Function0;", "skipToEndOfCurrentGroup", "startResumingScope", "trimValues", "updateAnchoredValue", "groupSlotIndex", "updateAuxData", "data", "updateNode", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "updateValue", "useNode", "withChangeList", "newChangeList", "withoutImplicitRootStart", "Companion", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerChangeListWriter {
    private static final int invalidGroupLocation = -2;
    private ChangeList changeList;
    private final ComposerImpl composer;
    private int moveCount;
    private int pendingUps;
    private boolean startedGroup;
    private int writersReaderDelta;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final IntStack startedGroups = new IntStack();
    private boolean implicitRootStart = true;
    private ArrayList<T> pendingDownNodes = Stack.m3505constructorimpl$default(null, 1, null);
    private int removeFrom = -1;
    private int moveFrom = -1;
    private int moveTo = -1;

    public ComposerChangeListWriter(ComposerImpl composerImpl, ChangeList changeList) {
        this.composer = composerImpl;
        this.changeList = changeList;
    }

    public final ChangeList getChangeList() {
        return this.changeList;
    }

    public final void setChangeList(ChangeList changeList) {
        this.changeList = changeList;
    }

    private final SlotReader getReader() {
        return this.composer.getReader$runtime_release();
    }

    public final boolean getImplicitRootStart() {
        return this.implicitRootStart;
    }

    public final void setImplicitRootStart(boolean z) {
        this.implicitRootStart = z;
    }

    private final void pushApplierOperationPreamble() {
        pushPendingUpsAndDowns();
    }

    private final void pushSlotEditingOperationPreamble() {
        realizeOperationLocation$default(this, false, 1, null);
        recordSlotEditing();
    }

    static /* synthetic */ void pushSlotTableOperationPreamble$default(ComposerChangeListWriter composerChangeListWriter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerChangeListWriter.pushSlotTableOperationPreamble(z);
    }

    private final void pushSlotTableOperationPreamble(boolean z) {
        realizeOperationLocation(z);
    }

    public final void moveReaderRelativeTo(int i) {
        this.writersReaderDelta += i - getReader().getCurrentGroup();
    }

    public final void moveReaderToAbsolute(int i) {
        this.writersReaderDelta = i;
    }

    public final void recordSlotEditing() {
        SlotReader reader;
        int parent;
        if (getReader().getSize() <= 0 || this.startedGroups.peekOr(-2) == (parent = (reader = getReader()).getParent())) {
            return;
        }
        ensureRootStarted();
        if (parent > 0) {
            Anchor anchor = reader.anchor(parent);
            this.startedGroups.push(parent);
            ensureGroupStarted(anchor);
        }
    }

    private final void ensureRootStarted() {
        if (this.startedGroup || !this.implicitRootStart) {
            return;
        }
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushEnsureRootStarted();
        this.startedGroup = true;
    }

    private final void ensureGroupStarted(Anchor anchor) {
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushEnsureGroupStarted(anchor);
        this.startedGroup = true;
    }

    static /* synthetic */ void realizeOperationLocation$default(ComposerChangeListWriter composerChangeListWriter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerChangeListWriter.realizeOperationLocation(z);
    }

    private final void realizeOperationLocation(boolean z) {
        int parent = z ? getReader().getParent() : getReader().getCurrentGroup();
        int i = parent - this.writersReaderDelta;
        if (!(i >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Tried to seek backward");
        }
        if (i > 0) {
            this.changeList.pushAdvanceSlotsBy(i);
            this.writersReaderDelta = parent;
        }
    }

    public final boolean getPastParent() {
        return getReader().getParent() - this.writersReaderDelta < 0;
    }

    public final void withChangeList(ChangeList changeList, Function0<Unit> function0) {
        ChangeList changeList2 = getChangeList();
        try {
            setChangeList(changeList);
            function0.invoke();
        } finally {
            setChangeList(changeList2);
        }
    }

    public final void withoutImplicitRootStart(Function0<Unit> function0) {
        boolean implicitRootStart = getImplicitRootStart();
        try {
            setImplicitRootStart(false);
            function0.invoke();
        } finally {
            setImplicitRootStart(implicitRootStart);
        }
    }

    public final void remember(RememberObserverHolder rememberObserverHolder) {
        this.changeList.pushRemember(rememberObserverHolder);
    }

    public final void rememberPausingScope(RecomposeScopeImpl recomposeScopeImpl) {
        this.changeList.pushRememberPausingScope(recomposeScopeImpl);
    }

    public final void startResumingScope(RecomposeScopeImpl recomposeScopeImpl) {
        this.changeList.pushStartResumingScope(recomposeScopeImpl);
    }

    public final void endResumingScope(RecomposeScopeImpl recomposeScopeImpl) {
        this.changeList.pushEndResumingScope(recomposeScopeImpl);
    }

    public final void updateValue(Object obj, int i) {
        pushSlotTableOperationPreamble(true);
        this.changeList.pushUpdateValue(obj, i);
    }

    public final void updateAnchoredValue(Object obj, Anchor anchor, int i) {
        this.changeList.pushUpdateAnchoredValue(obj, anchor, i);
    }

    public final void appendValue(Anchor anchor, Object obj) {
        this.changeList.pushAppendValue(anchor, obj);
    }

    public final void trimValues(int i) {
        if (i > 0) {
            pushSlotEditingOperationPreamble();
            this.changeList.pushTrimValues(i);
        }
    }

    public final void resetSlots() {
        this.changeList.pushResetSlots();
    }

    public final void updateAuxData(Object obj) {
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushUpdateAuxData(obj);
    }

    public final void endRoot() {
        if (this.startedGroup) {
            pushSlotTableOperationPreamble$default(this, false, 1, null);
            pushSlotTableOperationPreamble$default(this, false, 1, null);
            this.changeList.pushEndCurrentGroup();
            this.startedGroup = false;
        }
    }

    public final void endCurrentGroup() {
        int parent = getReader().getParent();
        if (!(this.startedGroups.peekOr(-1) <= parent)) {
            ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup");
        }
        if (this.startedGroups.peekOr(-1) == parent) {
            pushSlotTableOperationPreamble$default(this, false, 1, null);
            this.startedGroups.pop();
            this.changeList.pushEndCurrentGroup();
        }
    }

    public final void skipToEndOfCurrentGroup() {
        this.changeList.pushSkipToEndOfCurrentGroup();
    }

    public final void removeCurrentGroup() {
        pushSlotEditingOperationPreamble();
        this.changeList.pushRemoveCurrentGroup();
        this.writersReaderDelta += getReader().getGroupSize();
    }

    public final void insertSlots(Anchor anchor, SlotTable slotTable) {
        pushPendingUpsAndDowns();
        pushSlotEditingOperationPreamble();
        realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(anchor, slotTable);
    }

    public final void insertSlots(Anchor anchor, SlotTable slotTable, FixupList fixupList) {
        pushPendingUpsAndDowns();
        pushSlotEditingOperationPreamble();
        realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(anchor, slotTable, fixupList);
    }

    public final void moveCurrentGroup(int i) {
        pushSlotEditingOperationPreamble();
        this.changeList.pushMoveCurrentGroup(i);
    }

    public final void endCompositionScope(Function1<? super Composition, Unit> function1, Composition composition) {
        this.changeList.pushEndCompositionScope(function1, composition);
    }

    public final void useNode(Object obj) {
        pushApplierOperationPreamble();
        this.changeList.pushUseNode(obj);
    }

    public final <T, V> void updateNode(V v, Function2<? super T, ? super V, Unit> function2) {
        pushApplierOperationPreamble();
        this.changeList.pushUpdateNode(v, function2);
    }

    public final void removeNode(int i, int i2) {
        if (i2 > 0) {
            if (!(i >= 0)) {
                ComposerKt.composeImmediateRuntimeError("Invalid remove index " + i);
            }
            if (this.removeFrom == i) {
                this.moveCount += i2;
                return;
            }
            realizeNodeMovementOperations();
            this.removeFrom = i;
            this.moveCount = i2;
        }
    }

    public final void moveNode(int i, int i2, int i3) {
        if (i3 > 0) {
            int i4 = this.moveCount;
            if (i4 > 0 && this.moveFrom == i - i4 && this.moveTo == i2 - i4) {
                this.moveCount = i4 + i3;
                return;
            }
            realizeNodeMovementOperations();
            this.moveFrom = i;
            this.moveTo = i2;
            this.moveCount = i3;
        }
    }

    public final void releaseMovableContent() {
        pushPendingUpsAndDowns();
        if (this.startedGroup) {
            skipToEndOfCurrentGroup();
            endRoot();
        }
    }

    public final void endNodeMovement() {
        realizeNodeMovementOperations();
    }

    public final void endNodeMovementAndDeleteNode(int i, int i2) {
        endNodeMovement();
        pushPendingUpsAndDowns();
        int nodeCount = getReader().isNode(i2) ? 1 : getReader().nodeCount(i2);
        if (nodeCount > 0) {
            removeNode(i, nodeCount);
        }
    }

    private final void realizeNodeMovementOperations() {
        int i = this.moveCount;
        if (i > 0) {
            int i2 = this.removeFrom;
            if (i2 >= 0) {
                realizeRemoveNode(i2, i);
                this.removeFrom = -1;
            } else {
                realizeMoveNode(this.moveTo, this.moveFrom, i);
                this.moveFrom = -1;
                this.moveTo = -1;
            }
            this.moveCount = 0;
        }
    }

    private final void realizeRemoveNode(int i, int i2) {
        pushApplierOperationPreamble();
        this.changeList.pushRemoveNode(i, i2);
    }

    private final void realizeMoveNode(int i, int i2, int i3) {
        pushApplierOperationPreamble();
        this.changeList.pushMoveNode(i, i2, i3);
    }

    public final void moveUp() {
        realizeNodeMovementOperations();
        if (Stack.m3511isNotEmptyimpl(this.pendingDownNodes)) {
            Stack.m3514popimpl(this.pendingDownNodes);
        } else {
            this.pendingUps++;
        }
    }

    public final void moveDown(Object obj) {
        realizeNodeMovementOperations();
        Stack.m3515pushimpl(this.pendingDownNodes, obj);
    }

    private final void pushPendingUpsAndDowns() {
        int i = this.pendingUps;
        if (i > 0) {
            this.changeList.pushUps(i);
            this.pendingUps = 0;
        }
        if (Stack.m3511isNotEmptyimpl(this.pendingDownNodes)) {
            this.changeList.pushDowns(Stack.m3516toArrayimpl(this.pendingDownNodes));
            Stack.m3503clearimpl(this.pendingDownNodes);
        }
    }

    public final void sideEffect(Function0<Unit> function0) {
        this.changeList.pushSideEffect(function0);
    }

    public final void determineMovableContentNodeIndex(IntRef intRef, Anchor anchor) {
        pushPendingUpsAndDowns();
        this.changeList.pushDetermineMovableContentNodeIndex(intRef, anchor);
    }

    public final void copyNodesToNewAnchorLocation(List<? extends Object> list, IntRef intRef) {
        this.changeList.pushCopyNodesToNewAnchorLocation(list, intRef);
    }

    public final void copySlotTableToAnchorLocation(MovableContentState movableContentState, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        this.changeList.pushCopySlotTableToAnchorLocation(movableContentState, compositionContext, movableContentStateReference, movableContentStateReference2);
    }

    public final void releaseMovableGroupAtCurrent(ControlledComposition controlledComposition, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference) {
        this.changeList.pushReleaseMovableGroupAtCurrent(controlledComposition, compositionContext, movableContentStateReference);
    }

    public final void endMovableContentPlacement() {
        this.changeList.pushEndMovableContentPlacement();
        this.writersReaderDelta = 0;
    }

    public static /* synthetic */ void includeOperationsIn$default(ComposerChangeListWriter composerChangeListWriter, ChangeList changeList, IntRef intRef, int i, Object obj) {
        if ((i & 2) != 0) {
            intRef = null;
        }
        composerChangeListWriter.includeOperationsIn(changeList, intRef);
    }

    public final void includeOperationsIn(ChangeList changeList, IntRef intRef) {
        this.changeList.pushExecuteOperationsIn(changeList, intRef);
    }

    public final void finalizeComposition() {
        pushPendingUpsAndDowns();
        if (this.startedGroups.tos == 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup()");
    }

    public final void resetTransientState() {
        this.startedGroup = false;
        this.startedGroups.clear();
        this.writersReaderDelta = 0;
    }

    public final void deactivateCurrentGroup() {
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushDeactivateCurrentGroup();
    }

    /* compiled from: ComposerChangeListWriter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/changelist/ComposerChangeListWriter$Companion;", "", "()V", "invalidGroupLocation", "", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
