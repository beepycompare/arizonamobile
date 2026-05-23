package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.LinkComposer;
import androidx.compose.runtime.LinkRememberObserverHolder;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsSpec;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchor;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReader;
import androidx.compose.runtime.internal.IntRef;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComposerChangeListWriter.kt */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\u0006\u0010,\u001a\u00020)J\u001c\u0010-\u001a\u00020)2\n\u0010.\u001a\u00060&j\u0002`'2\b\b\u0002\u0010/\u001a\u00020\u0011J\u0017\u00101\u001a\u00020)2\f\u00102\u001a\b\u0012\u0004\u0012\u00020)03H\u0086\bJ#\u00104\u001a\u00020)2\n\u00105\u001a\u00060&j\u0002`'2\f\u00102\u001a\b\u0012\u0004\u0012\u00020)03H\u0086\bJ\u001f\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020 2\f\u00102\u001a\b\u0012\u0004\u0012\u00020)03H\u0082\bJ\u001f\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u00052\f\u00102\u001a\b\u0012\u0004\u0012\u00020)03H\u0086\bJ\u0017\u0010:\u001a\u00020)2\f\u00102\u001a\b\u0012\u0004\u0012\u00020)03H\u0086\bJ\u000e\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020)2\u0006\u0010?\u001a\u00020@J\u000e\u0010B\u001a\u00020)2\u0006\u0010?\u001a\u00020@J\u0016\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GJ\u0018\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020\u00172\b\u0010<\u001a\u0004\u0018\u00010\u0001J\u0010\u0010J\u001a\u00020)2\b\u0010<\u001a\u0004\u0018\u00010\u0001J\u001a\u0010K\u001a\u00020)2\n\u0010L\u001a\u00060\u0017j\u0002`M2\u0006\u0010N\u001a\u00020\u0017J\u0006\u0010O\u001a\u00020)J\u0010\u0010P\u001a\u00020)2\b\u0010Q\u001a\u0004\u0018\u00010\u0001J\u0006\u0010R\u001a\u00020)J\u001a\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u00020U2\n\u0010V\u001a\u00060&j\u0002`'J\"\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u00020U2\n\u0010V\u001a\u00060&j\u0002`'2\u0006\u0010W\u001a\u00020XJ\u000e\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020\u0017J\"\u0010[\u001a\u00020)2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020)0]2\u0006\u0010_\u001a\u00020^J\u0010\u0010`\u001a\u00020)2\b\u0010a\u001a\u0004\u0018\u00010\u0001J>\u0010b\u001a\u00020)\"\u0004\b\u0000\u0010c\"\u0004\b\u0001\u0010d2\u0006\u0010<\u001a\u0002Hd2\u001d\u00102\u001a\u0019\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u0002Hd\u0012\u0004\u0012\u00020)0e¢\u0006\u0002\bf¢\u0006\u0002\u0010gJ\u0016\u0010h\u001a\u00020)2\u0006\u0010i\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u0017J\u001e\u0010j\u001a\u00020)2\u0006\u0010k\u001a\u00020\u00172\u0006\u0010l\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u0017J\u0006\u0010m\u001a\u00020)J\u001a\u0010n\u001a\u00020)2\u0006\u0010i\u001a\u00020\u00172\n\u0010o\u001a\u00060\u0017j\u0002`MJ\b\u0010p\u001a\u00020)H\u0002J\u0018\u0010q\u001a\u00020)2\u0006\u0010i\u001a\u00020\u00172\u0006\u0010r\u001a\u00020\u0017H\u0002J \u0010s\u001a\u00020)2\u0006\u0010t\u001a\u00020\u00172\u0006\u0010u\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u0017H\u0002J\u0006\u0010v\u001a\u00020)J\u0010\u0010w\u001a\u00020)2\b\u0010a\u001a\u0004\u0018\u00010\u0001J\b\u0010x\u001a\u00020)H\u0002J\u0014\u0010y\u001a\u00020)2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020)03J\u001a\u0010{\u001a\u00020)2\u0006\u0010|\u001a\u00020}2\n\u0010.\u001a\u00060&j\u0002`'J \u0010~\u001a\u00020)2\u000f\u0010\u007f\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020}J/\u0010\u0082\u0001\u001a\u00020)2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0007\u0010u\u001a\u00030\u0087\u00012\u0007\u0010t\u001a\u00030\u0087\u0001J$\u0010\u0088\u0001\u001a\u00020)2\u0007\u0010_\u001a\u00030\u0089\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u008a\u0001\u001a\u00030\u0087\u0001J\u0007\u0010\u008b\u0001\u001a\u00020)J\u0013\u0010\u008c\u0001\u001a\u00020)2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001J\u001d\u0010\u008d\u0001\u001a\u00020)2\u0007\u0010\u008e\u0001\u001a\u00020\u00052\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010}J\u0007\u0010\u008f\u0001\u001a\u00020)J\u0007\u0010\u0090\u0001\u001a\u00020)J\u0007\u0010\u0091\u0001\u001a\u00020)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0012\u0010%\u001a\u00060&j\u0002`'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b0\u0010\u0013¨\u0006\u0092\u0001"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriter;", "", "composer", "Landroidx/compose/runtime/LinkComposer;", "changeList", "Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;", "<init>", "(Landroidx/compose/runtime/LinkComposer;Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;)V", "getChangeList", "()Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;", "setChangeList", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/ChangeList;)V", "reader", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "getReader", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "implicitRootStart", "", "getImplicitRootStart", "()Z", "setImplicitRootStart", "(Z)V", "pendingUps", "", "pendingDownNodes", "Landroidx/compose/runtime/Stack;", "Ljava/util/ArrayList;", "removeFromNodeIndex", "moveFromNodeIndex", "moveToNodeIndex", "moveCount", "addressMode", "Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriterAddressMode;", "getAddressMode$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriterAddressMode;", "setAddressMode$runtime", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriterAddressMode;)V", "editorCurrentPosition", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "pushApplierOperationPreamble", "", "pushSlotOperationPreamble", "pushSlotOperationPreambleUnconditionally", "startComposition", "seekTo", "handle", "resetRelativeAddressing", "isInAnchorMode", "inAnchorMode", "block", "Lkotlin/Function0;", "inRelativeAddressMode", "relativeStart", "inMode", "newMode", "withChangeList", "newChangeList", "withoutImplicitRootStart", "remember", "value", "Landroidx/compose/runtime/RememberObserverHolder;", "rememberPausingScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "startResumingScope", "endResumingScope", "updateRememberOrdering", "holder", "Landroidx/compose/runtime/LinkRememberObserverHolder;", TtmlNode.ANNOTATION_POSITION_AFTER, "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "updateValue", "slotIndex", "appendValue", "removeTailGroupsAndValues", "firstTailGroupToRemove", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "count", "resetSlots", "updateAuxData", "data", "removeGroup", "insertSlots", "sourceTable", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "source", "fixups", "Landroidx/compose/runtime/composer/linkbuffer/changelist/FixupList;", "moveGroup", TypedValues.CycleType.S_WAVE_OFFSET, "endCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "useNode", "node", "updateNode", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeNode", "nodeIndex", "moveNode", "fromNodeIndex", "toNodeIndex", "endNodeMovement", "endNodeMovementAndDeleteNode", "group", "realizeNodeMovementOperations", "realizeRemoveNode", "removeCount", "realizeMoveNode", TypedValues.TransitionType.S_TO, "from", "moveUp", "moveDown", "pushPendingUpsAndDowns", "sideEffect", "effect", "determineMovableContentNodeIndex", "effectiveNodeIndexOut", "Landroidx/compose/runtime/internal/IntRef;", "copyNodesToNewAnchorLocation", "nodes", "", "effectiveNodeIndex", "copySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/MovableContentStateReference;", "releaseMovableGroup", "Landroidx/compose/runtime/ControlledComposition;", TypedValues.Custom.S_REFERENCE, "endMovableContentPlacement", "disposeResolvedMovableState", "includeOperationsIn", "other", "finalizeComposition", "resetTransientState", "deactivateCurrentGroup", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerChangeListWriter {
    public static final int $stable = 8;
    private ChangeList changeList;
    private final LinkComposer composer;
    private int pendingUps;
    private boolean implicitRootStart = true;
    private final ArrayList<Object> pendingDownNodes = Stack.m4452constructorimpl$default(null, 1, null);
    private int removeFromNodeIndex = -1;
    private int moveFromNodeIndex = -1;
    private int moveToNodeIndex = -1;
    private int moveCount = -1;
    private ComposerChangeListWriterAddressMode addressMode = ComposerChangeListWriterAddressMode.AbsoluteAddressing;
    private long editorCurrentPosition = -1;

    /* compiled from: ComposerChangeListWriter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ComposerChangeListWriterAddressMode.values().length];
            try {
                iArr[ComposerChangeListWriterAddressMode.AbsoluteAddressing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ComposerChangeListWriterAddressMode.AnchorAddressing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ComposerChangeListWriterAddressMode.RelativeAddressing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ComposerChangeListWriter(LinkComposer linkComposer, ChangeList changeList) {
        this.composer = linkComposer;
        this.changeList = changeList;
    }

    public static final /* synthetic */ long access$getEditorCurrentPosition$p(ComposerChangeListWriter composerChangeListWriter) {
        return composerChangeListWriter.editorCurrentPosition;
    }

    public static final /* synthetic */ void access$setEditorCurrentPosition$p(ComposerChangeListWriter composerChangeListWriter, long j) {
        composerChangeListWriter.editorCurrentPosition = j;
    }

    public final ChangeList getChangeList() {
        return this.changeList;
    }

    public final void setChangeList(ChangeList changeList) {
        this.changeList = changeList;
    }

    private final SlotTableReader getReader() {
        return this.composer.getReader$runtime();
    }

    public final boolean getImplicitRootStart() {
        return this.implicitRootStart;
    }

    public final void setImplicitRootStart(boolean z) {
        this.implicitRootStart = z;
    }

    public final ComposerChangeListWriterAddressMode getAddressMode$runtime() {
        return this.addressMode;
    }

    public final void setAddressMode$runtime(ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode) {
        this.addressMode = composerChangeListWriterAddressMode;
    }

    private final void pushApplierOperationPreamble() {
        pushPendingUpsAndDowns();
    }

    private final void pushSlotOperationPreamble() {
        long handle = getReader().handle();
        if (this.editorCurrentPosition != handle) {
            seekTo$default(this, handle, false, 2, null);
        }
    }

    private final void pushSlotOperationPreambleUnconditionally() {
        seekTo$default(this, getReader().handle(), false, 2, null);
    }

    public final void startComposition() {
        Stack.m4450clearimpl(this.pendingDownNodes);
        this.pendingUps = 0;
        this.removeFromNodeIndex = -1;
        this.moveFromNodeIndex = -1;
        this.moveToNodeIndex = -1;
        this.addressMode = ComposerChangeListWriterAddressMode.AbsoluteAddressing;
        this.editorCurrentPosition = -1L;
    }

    public static /* synthetic */ void seekTo$default(ComposerChangeListWriter composerChangeListWriter, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        composerChangeListWriter.seekTo(j, z);
    }

    public final void seekTo(long j, boolean z) {
        int parentOf;
        int i = WhenMappings.$EnumSwitchMapping$0[this.addressMode.ordinal()];
        if (i == 1) {
            this.changeList.pushSeekToGroupHandle(j);
        } else if (i == 2) {
            this.changeList.pushSeekToAnchor(getReader().getTable().getAddressSpace(), j);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            int group = GroupHandleKt.getGroup(j);
            if (group == -1) {
                parentOf = GroupHandleKt.getContext(j);
            } else {
                parentOf = getReader().parentOf(group);
            }
            if (!(parentOf == GroupHandleKt.getGroup(this.editorCurrentPosition))) {
                ComposerKt.composeImmediateRuntimeError("Relative addressing only supports navigating to a child of the current group");
            }
            this.changeList.pushStartGroup();
            int firstChildOf = getReader().firstChildOf(parentOf);
            while (firstChildOf != group) {
                this.changeList.pushSkipGroup();
                firstChildOf = getReader().nextSiblingOf(firstChildOf);
            }
            if (z) {
                this.addressMode = ComposerChangeListWriterAddressMode.AbsoluteAddressing;
            }
        }
        this.editorCurrentPosition = j;
    }

    public final boolean isInAnchorMode() {
        return this.addressMode == ComposerChangeListWriterAddressMode.AnchorAddressing;
    }

    public final void inAnchorMode(Function0<Unit> function0) {
        this.editorCurrentPosition = -1L;
        ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode = ComposerChangeListWriterAddressMode.AnchorAddressing;
        ComposerChangeListWriterAddressMode addressMode$runtime = getAddressMode$runtime();
        long j = this.editorCurrentPosition;
        setAddressMode$runtime(composerChangeListWriterAddressMode);
        try {
            function0.invoke();
        } finally {
            setAddressMode$runtime(addressMode$runtime);
            this.editorCurrentPosition = addressMode$runtime == ComposerChangeListWriterAddressMode.RelativeAddressing ? j : -1L;
        }
    }

    public final void inRelativeAddressMode(long j, Function0<Unit> function0) {
        this.editorCurrentPosition = j;
        ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode = ComposerChangeListWriterAddressMode.RelativeAddressing;
        ComposerChangeListWriterAddressMode addressMode$runtime = getAddressMode$runtime();
        long j2 = this.editorCurrentPosition;
        setAddressMode$runtime(composerChangeListWriterAddressMode);
        try {
            function0.invoke();
        } finally {
            setAddressMode$runtime(addressMode$runtime);
            if (addressMode$runtime != ComposerChangeListWriterAddressMode.RelativeAddressing) {
                j2 = -1;
            }
            this.editorCurrentPosition = j2;
        }
    }

    private final void inMode(ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode, Function0<Unit> function0) {
        ComposerChangeListWriterAddressMode addressMode$runtime = getAddressMode$runtime();
        long j = this.editorCurrentPosition;
        setAddressMode$runtime(composerChangeListWriterAddressMode);
        try {
            function0.invoke();
        } finally {
            setAddressMode$runtime(addressMode$runtime);
            if (addressMode$runtime != ComposerChangeListWriterAddressMode.RelativeAddressing) {
                j = -1;
            }
            this.editorCurrentPosition = j;
        }
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
        pushSlotOperationPreamble();
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

    public final void updateRememberOrdering(LinkRememberObserverHolder linkRememberObserverHolder, LinkAnchor linkAnchor) {
        if (Intrinsics.areEqual(linkRememberObserverHolder.getAfter(), linkAnchor)) {
            return;
        }
        this.changeList.pushUpdateRememberObserverHolderOrdering(linkRememberObserverHolder, linkAnchor);
    }

    public final void updateValue(int i, Object obj) {
        pushSlotOperationPreamble();
        this.changeList.pushUpdateRelativeValue(i, obj);
    }

    public final void appendValue(Object obj) {
        pushSlotOperationPreamble();
        this.changeList.pushAppendValue(obj);
    }

    public final void removeTailGroupsAndValues(int i, int i2) {
        if (i >= 0 || i2 > 0) {
            pushSlotOperationPreamble();
            this.changeList.pushRemoveTailGroupsAndValues(i, i2);
        }
    }

    public final void resetSlots() {
        this.changeList.pushResetSlots();
        this.editorCurrentPosition = -1L;
    }

    public final void updateAuxData(Object obj) {
        pushSlotOperationPreamble();
        this.changeList.pushUpdateAuxData(obj);
    }

    public final void removeGroup() {
        pushSlotOperationPreamble();
        this.changeList.pushRemoveGroup();
    }

    public final void insertSlots(SlotTable slotTable, long j) {
        if (!(j != -1)) {
            ComposerKt.composeImmediateRuntimeError("Tried moving from an unspecified position");
        }
        pushPendingUpsAndDowns();
        pushSlotOperationPreamble();
        realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(slotTable, j);
    }

    public final void insertSlots(SlotTable slotTable, long j, FixupList fixupList) {
        if (!(j != -1)) {
            ComposerKt.composeImmediateRuntimeError("Tried moving from an unspecified position");
        }
        pushPendingUpsAndDowns();
        pushSlotOperationPreamble();
        realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(slotTable, j, fixupList);
    }

    public final void moveGroup(int i) {
        if (!(i >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Offset must not be negative");
        }
        pushSlotOperationPreambleUnconditionally();
        this.changeList.pushMoveGroup(i);
        this.editorCurrentPosition = -1L;
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
            if (this.removeFromNodeIndex == i) {
                this.moveCount += i2;
                return;
            }
            realizeNodeMovementOperations();
            this.removeFromNodeIndex = i;
            this.moveCount = i2;
        }
    }

    public final void moveNode(int i, int i2, int i3) {
        if (i3 > 0) {
            int i4 = this.moveCount;
            if (i4 > 0 && this.moveFromNodeIndex == i && this.moveToNodeIndex == i2) {
                this.moveCount = i4 + i3;
                return;
            }
            realizeNodeMovementOperations();
            this.moveToNodeIndex = i2;
            this.moveFromNodeIndex = i;
            this.moveCount = i3;
        }
    }

    public final void endNodeMovement() {
        realizeNodeMovementOperations();
    }

    public final void endNodeMovementAndDeleteNode(int i, int i2) {
        endNodeMovement();
        pushPendingUpsAndDowns();
        int flagsOf = getReader().flagsOf(i2);
        removeNode(i, (flagsOf & 8388608) == 8388608 ? 1 : flagsOf & GroupFlagsSpec.CHILD_NODE_COUNT_MASK);
    }

    private final void realizeNodeMovementOperations() {
        int i = this.moveCount;
        if (i > 0) {
            int i2 = this.removeFromNodeIndex;
            if (i2 >= 0) {
                realizeRemoveNode(i2, i);
                this.removeFromNodeIndex = -1;
            } else {
                realizeMoveNode(this.moveToNodeIndex, this.moveFromNodeIndex, i);
                this.moveToNodeIndex = -1;
                this.moveFromNodeIndex = -1;
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
        if (Stack.m4458isNotEmptyimpl(this.pendingDownNodes)) {
            Stack.m4461popimpl(this.pendingDownNodes);
            return;
        }
        int i = this.pendingUps;
        this.pendingUps = i + 1;
        Integer.valueOf(i);
    }

    public final void moveDown(Object obj) {
        realizeNodeMovementOperations();
        Stack.m4462pushimpl(this.pendingDownNodes, obj);
    }

    private final void pushPendingUpsAndDowns() {
        int i = this.pendingUps;
        if (i > 0) {
            this.changeList.pushUps(i);
            this.pendingUps = 0;
        }
        if (Stack.m4458isNotEmptyimpl(this.pendingDownNodes)) {
            this.changeList.pushDowns(Stack.m4463toArrayimpl(this.pendingDownNodes));
            Stack.m4450clearimpl(this.pendingDownNodes);
        }
    }

    public final void sideEffect(Function0<Unit> function0) {
        this.changeList.pushSideEffect(function0);
    }

    public final void determineMovableContentNodeIndex(IntRef intRef, long j) {
        pushPendingUpsAndDowns();
        this.changeList.pushDetermineMovableContentNodeIndex(intRef, j);
        this.editorCurrentPosition = j;
    }

    public final void copyNodesToNewAnchorLocation(List<? extends Object> list, IntRef intRef) {
        this.changeList.pushCopyNodesToNewAnchorLocation(list, intRef);
    }

    public final void copySlotTableToAnchorLocation(MovableContentState movableContentState, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        this.changeList.pushCopySlotTableToAnchorLocation(movableContentState, compositionContext, movableContentStateReference, movableContentStateReference2);
    }

    public final void releaseMovableGroup(ControlledComposition controlledComposition, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference) {
        this.changeList.pushReleaseMovableGroup(controlledComposition, compositionContext, movableContentStateReference);
        this.editorCurrentPosition = -1L;
    }

    public final void endMovableContentPlacement() {
        this.changeList.pushEndMovableContentPlacement();
        this.pendingUps = 0;
    }

    public final void disposeResolvedMovableState(MovableContentState movableContentState) {
        if (movableContentState != null) {
            this.changeList.pushDisposeDisposeMovableContentState(movableContentState);
        }
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
        this.changeList.pushClearAllRecompositionRequiredGroups();
        this.editorCurrentPosition = -1L;
    }

    public final void resetTransientState() {
        this.implicitRootStart = true;
        this.pendingUps = 0;
        Stack.m4450clearimpl(this.pendingDownNodes);
        this.removeFromNodeIndex = -1;
        this.moveFromNodeIndex = -1;
        this.moveToNodeIndex = -1;
        this.moveCount = -1;
        this.editorCurrentPosition = -1L;
    }

    public final void deactivateCurrentGroup() {
        pushSlotOperationPreamble();
        this.changeList.pushDeactivateGroup();
    }
}
