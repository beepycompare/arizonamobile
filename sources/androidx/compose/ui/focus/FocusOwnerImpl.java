package androidx.compose.ui.focus;

import android.os.Trace;
import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: FocusOwnerImpl.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\b\u001aJ!\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0015H\u0016J/\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b)\u0010*J\u001a\u0010#\u001a\u00020\u00152\b\b\u0002\u0010+\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0017\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010*J\u001f\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0015H\u0016¢\u0006\u0004\b/\u00100J7\u00101\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u00192\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001504H\u0016¢\u0006\u0004\b5\u00106J%\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00150;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00152\u0006\u00108\u001a\u000209H\u0016¢\u0006\u0004\b?\u0010@J\u001e\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020C2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00150;H\u0016J\u0010\u0010D\u001a\u00020\u00152\u0006\u0010B\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020!H\u0016J\b\u0010G\u001a\u00020!H\u0016J\u0010\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\tH\u0016J\u0010\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020!H\u0016Jd\u0010L\u001a\u00020!\"\n\b\u0000\u0010M\u0018\u0001*\u00020N*\u00020N2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002HM0P2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u00020!042\f\u0010R\u001a\b\u0012\u0004\u0012\u00020!0;2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u00020!04H\u0082\b¢\u0006\u0004\bT\u0010UJ0\u0010V\u001a\u0004\u0018\u0001HM\"\n\b\u0000\u0010M\u0018\u0001*\u00020W*\u00020N2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002HM0PH\u0082\b¢\u0006\u0004\bX\u0010YJ\n\u0010Z\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010[\u001a\u00020\u0015H\u0016J\b\u0010\\\u001a\u00020\u0015H\u0016J\n\u0010]\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010o\u001a\u0004\u0018\u00010p*\u00020NH\u0002J\u0017\u0010q\u001a\u00020\u00152\u0006\u00108\u001a\u000209H\u0002¢\u0006\u0004\br\u0010@R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010^\u001a\u00020_8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR*\u0010h\u001a\u0004\u0018\u00010\t2\b\u0010g\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u000b\"\u0004\bj\u0010\rR$\u0010k\u001a\u00020\u00152\u0006\u0010g\u001a\u00020\u0015@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006s"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "platformFocusOwner", "Landroidx/compose/ui/focus/PlatformFocusOwner;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/focus/PlatformFocusOwner;Landroidx/compose/ui/node/Owner;)V", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "requestOwnerFocus", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-7o62pno", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "releaseFocus", "", "clearOwnerFocus", "clearFocus", "force", "refreshFocusEvents", "clearFocus-I7lrPNg", "(ZZZI)Z", "resetFocus", "resetFocus-3ESFkO8", "(I)Z", "forced", "moveFocus", "moveFocus-3ESFkO8", "wrapAroundForOneDimensionalFocus", "moveFocus-aToIllA", "(IZ)Z", "focusSearch", "focusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "dispatchKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onFocusedItem", "Lkotlin/Function0;", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchInterceptedSoftKeyboardEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "dispatchIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "dispatchIndirectPointerCancel", "focusTargetAvailable", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "scheduleInvalidationForOwner", "traverseAncestorsIncludingSelf", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "nearestAncestorIncludingSelf", "", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "getFocusRect", "hasFocusableContent", "hasNonInteropFocusableContent", "findFocusTargetNode", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "listeners", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/focus/FocusListener;", "getListeners", "()Landroidx/collection/MutableObjectList;", "value", "activeFocusTargetNode", "getActiveFocusTargetNode", "setActiveFocusTargetNode", "isFocusCaptured", "()Z", "setFocusCaptured", "(Z)V", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private FocusTargetNode activeFocusTargetNode;
    private final FocusInvalidationManager focusInvalidationManager;
    private boolean isFocusCaptured;
    private MutableLongSet keysCurrentlyDown;
    private final Owner owner;
    private final PlatformFocusOwner platformFocusOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode(Focusability.Companion.m5038getNeverLCbbffg(), false, null, null, 14, null);
    private final Modifier modifier = new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object obj) {
            return obj == this;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode focusTargetNode) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public FocusTargetNode create() {
            return FocusOwnerImpl.this.getRootFocusNode$ui();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("RootFocusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return FocusOwnerImpl.this.getRootFocusNode$ui().hashCode();
        }
    };
    private final MutableObjectList<FocusListener> listeners = new MutableObjectList<>(1);

    /* compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FocusOwnerImpl(PlatformFocusOwner platformFocusOwner, Owner owner) {
        this.platformFocusOwner = platformFocusOwner;
        this.owner = owner;
        this.focusInvalidationManager = new FocusInvalidationManager(this, owner);
    }

    public final FocusTargetNode getRootFocusNode$ui() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: requestOwnerFocus-7o62pno */
    public boolean mo4999requestOwnerFocus7o62pno(FocusDirection focusDirection, Rect rect) {
        return this.platformFocusOwner.mo5045requestOwnerFocus7o62pno(focusDirection, rect);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: takeFocus-aToIllA */
    public boolean mo5001takeFocusaToIllA(final int i, Rect rect) {
        Boolean mo4997focusSearchULY8qGw = mo4997focusSearchULY8qGw(i, rect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(i));
            }
        });
        if (mo4997focusSearchULY8qGw != null) {
            return mo4997focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
        if (!ComposeUiFlags.isOptimizedFocusEventDispatchEnabled || getActiveFocusTargetNode() == null) {
            return;
        }
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        setActiveFocusTargetNode(null);
        if (activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void clearOwnerFocus() {
        this.platformFocusOwner.clearOwnerFocus();
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean z) {
        mo4994clearFocusI7lrPNg(z, true, true, FocusDirection.Companion.m4984getExitdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: clearFocus-I7lrPNg */
    public boolean mo4994clearFocusI7lrPNg(boolean z, boolean z2, boolean z3, int i) {
        boolean clearFocus;
        if (!z) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m5021performCustomClearFocusMxy_nc0(this.rootFocusNode, i).ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                clearFocus = false;
            } else if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                clearFocus = clearFocus(z, z2);
            }
        } else {
            clearFocus = clearFocus(z, z2);
        }
        if (clearFocus && z3) {
            clearOwnerFocus();
        }
        return clearFocus;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: resetFocus-3ESFkO8 */
    public boolean mo5000resetFocus3ESFkO8(final int i) {
        if (mo4994clearFocusI7lrPNg(false, true, false, i)) {
            Boolean mo4997focusSearchULY8qGw = mo4997focusSearchULY8qGw(i, null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$resetFocus$successfulReset$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode focusTargetNode) {
                    return Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(i));
                }
            });
            boolean booleanValue = mo4997focusSearchULY8qGw != null ? mo4997focusSearchULY8qGw.booleanValue() : false;
            if (!booleanValue) {
                clearOwnerFocus();
            }
            return booleanValue;
        }
        return false;
    }

    static /* synthetic */ boolean clearFocus$default(FocusOwnerImpl focusOwnerImpl, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return focusOwnerImpl.clearFocus(z, z2);
    }

    private final boolean clearFocus(boolean z, boolean z2) {
        NodeChain nodes$ui;
        if (getActiveFocusTargetNode() == null) {
            return true;
        }
        if (!isFocusCaptured() || z) {
            FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
            setActiveFocusTargetNode(null);
            if (z2 && activeFocusTargetNode != null) {
                activeFocusTargetNode.dispatchFocusCallbacks$ui(isFocusCaptured() ? FocusStateImpl.Captured : FocusStateImpl.Active, FocusStateImpl.Inactive);
                FocusTargetNode focusTargetNode = activeFocusTargetNode;
                int m7135constructorimpl = NodeKind.m7135constructorimpl(1024);
                if (!focusTargetNode.getNode().isAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent$ui = focusTargetNode.getNode().getParent$ui();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                while (requireLayoutNode != null) {
                    if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                        while (parent$ui != null) {
                            if ((parent$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                Modifier.Node node = parent$ui;
                                MutableVector mutableVector = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        ((FocusTargetNode) node).dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                                    } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        int i = 0;
                                        for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                            if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    node = delegate$ui;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node != null) {
                                                        if (mutableVector != null) {
                                                            mutableVector.add(node);
                                                        }
                                                        node = null;
                                                    }
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegate$ui);
                                                    }
                                                }
                                            }
                                        }
                                        if (i == 1) {
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector);
                                }
                            }
                            parent$ui = parent$ui.getParent$ui();
                        }
                    }
                    requireLayoutNode = requireLayoutNode.getParent$ui();
                    parent$ui = (requireLayoutNode == null || (nodes$ui = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
                }
            }
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo4992moveFocus3ESFkO8(int i) {
        return mo4998moveFocusaToIllA(i, true);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.Boolean] */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: moveFocus-aToIllA */
    public boolean mo4998moveFocusaToIllA(final int i, boolean z) {
        FocusTargetNode activeFocusTargetNode;
        if ((ComposeUiFlags.isViewFocusFixEnabled || (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled && (activeFocusTargetNode = getActiveFocusTargetNode()) != null && activeFocusTargetNode.isInteropViewHost())) && this.platformFocusOwner.mo5044moveFocusInChildren3ESFkO8(i)) {
            return true;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = false;
        FocusTargetNode activeFocusTargetNode2 = getActiveFocusTargetNode();
        Boolean mo4997focusSearchULY8qGw = mo4997focusSearchULY8qGw(i, this.platformFocusOwner.getEmbeddedViewFocusRect(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Boolean] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.element = Boolean.valueOf(focusTargetNode.mo5012requestFocus3ESFkO8(i));
                return objectRef.element;
            }
        });
        if (!Intrinsics.areEqual((Object) mo4997focusSearchULY8qGw, (Object) true) || activeFocusTargetNode2 == getActiveFocusTargetNode()) {
            if (mo4997focusSearchULY8qGw != null && objectRef.element != 0) {
                if (mo4997focusSearchULY8qGw.booleanValue() && ((Boolean) objectRef.element).booleanValue()) {
                    return true;
                }
                if (FocusOwnerImplKt.m5005is1dFocusSearch3ESFkO8(i) && z) {
                    return mo4994clearFocusI7lrPNg(false, true, false, i) && mo5001takeFocusaToIllA(i, null);
                } else if (!ComposeUiFlags.isViewFocusFixEnabled && !ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
                    return this.platformFocusOwner.mo5044moveFocusInChildren3ESFkO8(i);
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x00b2, code lost:
        continue;
     */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: focusSearch-ULY8qGw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean mo4997focusSearchULY8qGw(int i, Rect rect, final Function1<? super FocusTargetNode, Boolean> function1) {
        final FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            FocusRequester m5027customFocusSearchOMvw8 = FocusTraversalKt.m5027customFocusSearchOMvw8(findFocusTargetNode, i, this.owner.getLayoutDirection());
            if (Intrinsics.areEqual(m5027customFocusSearchOMvw8, FocusRequester.Companion.getCancel())) {
                return null;
            }
            if (Intrinsics.areEqual(m5027customFocusSearchOMvw8, FocusRequester.Companion.getRedirect$ui())) {
                FocusTargetNode findFocusTargetNode2 = findFocusTargetNode();
                if (findFocusTargetNode2 != null) {
                    return function1.invoke(findFocusTargetNode2);
                }
                return null;
            } else if (!Intrinsics.areEqual(m5027customFocusSearchOMvw8, FocusRequester.Companion.getDefault())) {
                if (m5027customFocusSearchOMvw8 == FocusRequester.Companion.getDefault()) {
                    throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
                }
                if (m5027customFocusSearchOMvw8 == FocusRequester.Companion.getCancel()) {
                    throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
                }
                boolean z = false;
                if (m5027customFocusSearchOMvw8.getFocusRequesterNodes$ui().getSize() == 0) {
                    System.out.println((Object) "FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
                } else {
                    MutableVector<FocusRequesterModifierNode> focusRequesterNodes$ui = m5027customFocusSearchOMvw8.getFocusRequesterNodes$ui();
                    FocusRequesterModifierNode[] focusRequesterModifierNodeArr = focusRequesterNodes$ui.content;
                    int size = focusRequesterNodes$ui.getSize();
                    boolean z2 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        FocusRequesterModifierNode focusRequesterModifierNode = focusRequesterModifierNodeArr[i2];
                        int m7135constructorimpl = NodeKind.m7135constructorimpl(1024);
                        if (!focusRequesterModifierNode.getNode().isAttached()) {
                            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                        }
                        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
                        Modifier.Node child$ui = focusRequesterModifierNode.getNode().getChild$ui();
                        if (child$ui == null) {
                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusRequesterModifierNode.getNode(), false);
                        } else {
                            mutableVector.add(child$ui);
                        }
                        while (true) {
                            if (mutableVector.getSize() != 0) {
                                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                                if ((node.getAggregateChildKindSet$ui() & m7135constructorimpl) == 0) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
                                } else {
                                    while (true) {
                                        if (node == null) {
                                            break;
                                        } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0) {
                                            MutableVector mutableVector2 = null;
                                            while (node != null) {
                                                if (node instanceof FocusTargetNode) {
                                                    if (function1.invoke((FocusTargetNode) node).booleanValue()) {
                                                        z2 = true;
                                                        break;
                                                    }
                                                } else if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                                    int i3 = 0;
                                                    for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                                        if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                                            i3++;
                                                            if (i3 == 1) {
                                                                node = delegate$ui;
                                                            } else {
                                                                if (mutableVector2 == null) {
                                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                                }
                                                                if (node != null) {
                                                                    if (mutableVector2 != null) {
                                                                        mutableVector2.add(node);
                                                                    }
                                                                    node = null;
                                                                }
                                                                if (mutableVector2 != null) {
                                                                    mutableVector2.add(delegate$ui);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (i3 == 1) {
                                                    }
                                                }
                                                node = DelegatableNodeKt.pop(mutableVector2);
                                            }
                                            continue;
                                        } else {
                                            node = node.getChild$ui();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z = z2;
                }
                return Boolean.valueOf(z);
            }
        } else {
            findFocusTargetNode = null;
        }
        return FocusTraversalKt.m5028focusSearch0X8WOeE(this.rootFocusNode, i, this.owner.getLayoutDirection(), rect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                boolean booleanValue;
                if (Intrinsics.areEqual(focusTargetNode, FocusTargetNode.this)) {
                    booleanValue = false;
                } else if (Intrinsics.areEqual(focusTargetNode, this.getRootFocusNode$ui())) {
                    throw new IllegalStateException("Focus search landed at the root.".toString());
                } else {
                    booleanValue = function1.invoke(focusTargetNode).booleanValue();
                }
                return Boolean.valueOf(booleanValue);
            }
        });
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-YhN2O0w */
    public boolean mo4996dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0<Boolean> function0) {
        Modifier.Node node;
        Modifier.Node node2;
        NodeChain nodes$ui;
        Modifier.Node node3;
        NodeChain nodes$ui2;
        NodeChain nodes$ui3;
        boolean z;
        Trace.beginSection("FocusOwnerImpl:dispatchKeyEvent");
        try {
            if (this.focusInvalidationManager.hasPendingInvalidation()) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
                return false;
            } else if (m5004validateKeyEventZmokQxo(keyEvent)) {
                FocusTargetNode findFocusTargetNode = findFocusTargetNode();
                if (findFocusTargetNode == null || (node2 = lastLocalKeyInputNode(findFocusTargetNode)) == null) {
                    if (findFocusTargetNode != null) {
                        FocusTargetNode focusTargetNode = findFocusTargetNode;
                        int m7135constructorimpl = NodeKind.m7135constructorimpl(8192);
                        if (!focusTargetNode.getNode().isAttached()) {
                            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                        }
                        Modifier.Node node4 = focusTargetNode.getNode();
                        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                        loop10: while (true) {
                            if (requireLayoutNode == null) {
                                node3 = null;
                                break;
                            }
                            if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                                while (node4 != null) {
                                    if ((node4.getKindSet$ui() & m7135constructorimpl) != 0) {
                                        MutableVector mutableVector = null;
                                        node3 = node4;
                                        while (node3 != null) {
                                            if (node3 instanceof KeyInputModifierNode) {
                                                break loop10;
                                            }
                                            if ((node3.getKindSet$ui() & m7135constructorimpl) != 0 && (node3 instanceof DelegatingNode)) {
                                                int i = 0;
                                                for (Modifier.Node delegate$ui = ((DelegatingNode) node3).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                                    if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                                        i++;
                                                        if (i == 1) {
                                                            Unit unit = Unit.INSTANCE;
                                                            node3 = delegate$ui;
                                                        } else {
                                                            if (mutableVector == null) {
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            }
                                                            if (node3 != null) {
                                                                if (mutableVector != null) {
                                                                    Boolean.valueOf(mutableVector.add(node3));
                                                                }
                                                                node3 = null;
                                                            }
                                                            if (mutableVector != null) {
                                                                Boolean.valueOf(mutableVector.add(delegate$ui));
                                                            }
                                                        }
                                                    }
                                                }
                                                if (i == 1) {
                                                }
                                            }
                                            node3 = DelegatableNodeKt.pop(mutableVector);
                                        }
                                        continue;
                                    }
                                    node4 = node4.getParent$ui();
                                }
                            }
                            requireLayoutNode = requireLayoutNode.getParent$ui();
                            node4 = (requireLayoutNode == null || (nodes$ui2 = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui2.getTail$ui();
                        }
                        KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) node3;
                        if (keyInputModifierNode != null) {
                            node2 = keyInputModifierNode.getNode();
                        }
                    }
                    FocusTargetNode focusTargetNode2 = this.rootFocusNode;
                    int m7135constructorimpl2 = NodeKind.m7135constructorimpl(8192);
                    if (!focusTargetNode2.getNode().isAttached()) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    Modifier.Node parent$ui = focusTargetNode2.getNode().getParent$ui();
                    LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
                    loop14: while (true) {
                        if (requireLayoutNode2 == null) {
                            node = null;
                            break;
                        }
                        if ((requireLayoutNode2.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl2) != 0) {
                            while (parent$ui != null) {
                                if ((parent$ui.getKindSet$ui() & m7135constructorimpl2) != 0) {
                                    MutableVector mutableVector2 = null;
                                    node = parent$ui;
                                    while (node != null) {
                                        if (node instanceof KeyInputModifierNode) {
                                            break loop14;
                                        }
                                        if ((node.getKindSet$ui() & m7135constructorimpl2) != 0 && (node instanceof DelegatingNode)) {
                                            int i2 = 0;
                                            for (Modifier.Node delegate$ui2 = ((DelegatingNode) node).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                                if ((delegate$ui2.getKindSet$ui() & m7135constructorimpl2) != 0) {
                                                    i2++;
                                                    if (i2 == 1) {
                                                        Unit unit2 = Unit.INSTANCE;
                                                        node = delegate$ui2;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                        }
                                                        if (node != null) {
                                                            if (mutableVector2 != null) {
                                                                Boolean.valueOf(mutableVector2.add(node));
                                                            }
                                                            node = null;
                                                        }
                                                        if (mutableVector2 != null) {
                                                            Boolean.valueOf(mutableVector2.add(delegate$ui2));
                                                        }
                                                    }
                                                }
                                            }
                                            if (i2 == 1) {
                                            }
                                        }
                                        node = DelegatableNodeKt.pop(mutableVector2);
                                    }
                                    continue;
                                }
                                parent$ui = parent$ui.getParent$ui();
                            }
                        }
                        requireLayoutNode2 = requireLayoutNode2.getParent$ui();
                        parent$ui = (requireLayoutNode2 == null || (nodes$ui = requireLayoutNode2.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
                    }
                    KeyInputModifierNode keyInputModifierNode2 = (KeyInputModifierNode) node;
                    node2 = keyInputModifierNode2 != null ? keyInputModifierNode2.getNode() : null;
                }
                if (node2 != null) {
                    Modifier.Node node5 = node2;
                    int m7135constructorimpl3 = NodeKind.m7135constructorimpl(8192);
                    if (!node5.getNode().isAttached()) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    Modifier.Node parent$ui2 = node5.getNode().getParent$ui();
                    LayoutNode requireLayoutNode3 = DelegatableNodeKt.requireLayoutNode(node5);
                    ArrayList arrayList = null;
                    while (requireLayoutNode3 != null) {
                        if ((requireLayoutNode3.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl3) != 0) {
                            while (parent$ui2 != null) {
                                if ((parent$ui2.getKindSet$ui() & m7135constructorimpl3) != 0) {
                                    Modifier.Node node6 = parent$ui2;
                                    MutableVector mutableVector3 = null;
                                    while (node6 != null) {
                                        if (node6 instanceof KeyInputModifierNode) {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(node6);
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        if (z && (node6.getKindSet$ui() & m7135constructorimpl3) != 0 && (node6 instanceof DelegatingNode)) {
                                            int i3 = 0;
                                            for (Modifier.Node delegate$ui3 = ((DelegatingNode) node6).getDelegate$ui(); delegate$ui3 != null; delegate$ui3 = delegate$ui3.getChild$ui()) {
                                                if ((delegate$ui3.getKindSet$ui() & m7135constructorimpl3) != 0) {
                                                    i3++;
                                                    if (i3 == 1) {
                                                        Unit unit3 = Unit.INSTANCE;
                                                        node6 = delegate$ui3;
                                                    } else {
                                                        if (mutableVector3 == null) {
                                                            mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                        }
                                                        if (node6 != null) {
                                                            if (mutableVector3 != null) {
                                                                Boolean.valueOf(mutableVector3.add(node6));
                                                            }
                                                            node6 = null;
                                                        }
                                                        if (mutableVector3 != null) {
                                                            Boolean.valueOf(mutableVector3.add(delegate$ui3));
                                                        }
                                                    }
                                                }
                                            }
                                            if (i3 == 1) {
                                            }
                                        }
                                        node6 = DelegatableNodeKt.pop(mutableVector3);
                                    }
                                }
                                parent$ui2 = parent$ui2.getParent$ui();
                            }
                        }
                        requireLayoutNode3 = requireLayoutNode3.getParent$ui();
                        parent$ui2 = (requireLayoutNode3 == null || (nodes$ui3 = requireLayoutNode3.getNodes$ui()) == null) ? null : nodes$ui3.getTail$ui();
                    }
                    if (arrayList != null) {
                        int size = arrayList.size() - 1;
                        if (size >= 0) {
                            while (true) {
                                int i4 = size - 1;
                                if (((KeyInputModifierNode) arrayList.get(size)).mo258onPreKeyEventZmokQxo(keyEvent)) {
                                    return true;
                                }
                                if (i4 < 0) {
                                    break;
                                }
                                size = i4;
                            }
                        }
                        Unit unit4 = Unit.INSTANCE;
                    }
                    Modifier.Node node7 = node5.getNode();
                    MutableVector mutableVector4 = null;
                    while (node7 != null) {
                        if (node7 instanceof KeyInputModifierNode) {
                            if (((KeyInputModifierNode) node7).mo258onPreKeyEventZmokQxo(keyEvent)) {
                                return true;
                            }
                        } else if ((node7.getKindSet$ui() & m7135constructorimpl3) != 0 && (node7 instanceof DelegatingNode)) {
                            int i5 = 0;
                            for (Modifier.Node delegate$ui4 = ((DelegatingNode) node7).getDelegate$ui(); delegate$ui4 != null; delegate$ui4 = delegate$ui4.getChild$ui()) {
                                if ((delegate$ui4.getKindSet$ui() & m7135constructorimpl3) != 0) {
                                    i5++;
                                    if (i5 == 1) {
                                        Unit unit5 = Unit.INSTANCE;
                                        node7 = delegate$ui4;
                                    } else {
                                        if (mutableVector4 == null) {
                                            mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node7 != null) {
                                            if (mutableVector4 != null) {
                                                Boolean.valueOf(mutableVector4.add(node7));
                                            }
                                            node7 = null;
                                        }
                                        if (mutableVector4 != null) {
                                            Boolean.valueOf(mutableVector4.add(delegate$ui4));
                                        }
                                    }
                                }
                            }
                            if (i5 == 1) {
                            }
                        }
                        node7 = DelegatableNodeKt.pop(mutableVector4);
                    }
                    if (function0.invoke().booleanValue()) {
                        return true;
                    }
                    Modifier.Node node8 = node5.getNode();
                    MutableVector mutableVector5 = null;
                    while (node8 != null) {
                        if (node8 instanceof KeyInputModifierNode) {
                            if (((KeyInputModifierNode) node8).mo256onKeyEventZmokQxo(keyEvent)) {
                                return true;
                            }
                        } else if ((node8.getKindSet$ui() & m7135constructorimpl3) != 0 && (node8 instanceof DelegatingNode)) {
                            int i6 = 0;
                            for (Modifier.Node delegate$ui5 = ((DelegatingNode) node8).getDelegate$ui(); delegate$ui5 != null; delegate$ui5 = delegate$ui5.getChild$ui()) {
                                if ((delegate$ui5.getKindSet$ui() & m7135constructorimpl3) != 0) {
                                    i6++;
                                    if (i6 == 1) {
                                        Unit unit6 = Unit.INSTANCE;
                                        node8 = delegate$ui5;
                                    } else {
                                        if (mutableVector5 == null) {
                                            mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node8 != null) {
                                            if (mutableVector5 != null) {
                                                Boolean.valueOf(mutableVector5.add(node8));
                                            }
                                            node8 = null;
                                        }
                                        if (mutableVector5 != null) {
                                            Boolean.valueOf(mutableVector5.add(delegate$ui5));
                                        }
                                    }
                                }
                            }
                            if (i6 == 1) {
                            }
                        }
                        node8 = DelegatableNodeKt.pop(mutableVector5);
                    }
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        for (int i7 = 0; i7 < size2; i7++) {
                            if (((KeyInputModifierNode) arrayList.get(i7)).mo256onKeyEventZmokQxo(keyEvent)) {
                                return true;
                            }
                        }
                        Unit unit7 = Unit.INSTANCE;
                    }
                    Unit unit8 = Unit.INSTANCE;
                }
                return false;
            } else {
                return false;
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo4995dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        NodeChain nodes$ui;
        boolean z;
        Modifier.Node node;
        NodeChain nodes$ui2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            FocusTargetNode focusTargetNode = findActiveFocusNode;
            int m7135constructorimpl = NodeKind.m7135constructorimpl(131072);
            if (!focusTargetNode.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node2 = focusTargetNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    node = null;
                    break;
                }
                if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                    while (node2 != null) {
                        if ((node2.getKindSet$ui() & m7135constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            node = node2;
                            while (node != null) {
                                if (node instanceof SoftKeyboardInterceptionModifierNode) {
                                    break loop0;
                                }
                                if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                        if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Unit unit = Unit.INSTANCE;
                                                node = delegate$ui;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector != null) {
                                                        Boolean.valueOf(mutableVector.add(node));
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector != null) {
                                                    Boolean.valueOf(mutableVector.add(delegate$ui));
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        node2 = node2.getParent$ui();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui();
                node2 = (requireLayoutNode == null || (nodes$ui2 = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui2.getTail$ui();
            }
            softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) node;
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode != null) {
            SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode2 = softKeyboardInterceptionModifierNode;
            int m7135constructorimpl2 = NodeKind.m7135constructorimpl(131072);
            if (!softKeyboardInterceptionModifierNode2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui = softKeyboardInterceptionModifierNode2.getNode().getParent$ui();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(softKeyboardInterceptionModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl2) != 0) {
                    while (parent$ui != null) {
                        if ((parent$ui.getKindSet$ui() & m7135constructorimpl2) != 0) {
                            Modifier.Node node3 = parent$ui;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof SoftKeyboardInterceptionModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node3);
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z && (node3.getKindSet$ui() & m7135constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui2 = ((DelegatingNode) node3).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                        if ((delegate$ui2.getKindSet$ui() & m7135constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                Unit unit2 = Unit.INSTANCE;
                                                node3 = delegate$ui2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node3 != null) {
                                                    if (mutableVector2 != null) {
                                                        Boolean.valueOf(mutableVector2.add(node3));
                                                    }
                                                    node3 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    Boolean.valueOf(mutableVector2.add(delegate$ui2));
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent$ui = parent$ui.getParent$ui();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui();
                parent$ui = (requireLayoutNode2 == null || (nodes$ui = requireLayoutNode2.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
            }
            if (arrayList != null) {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (((SoftKeyboardInterceptionModifierNode) arrayList.get(size)).mo6193onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                            return true;
                        }
                        if (i3 < 0) {
                            break;
                        }
                        size = i3;
                    }
                }
                Unit unit3 = Unit.INSTANCE;
            }
            Modifier.Node node4 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node4 != null) {
                if (node4 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node4).mo6193onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node4.getKindSet$ui() & m7135constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                    int i4 = 0;
                    for (Modifier.Node delegate$ui3 = ((DelegatingNode) node4).getDelegate$ui(); delegate$ui3 != null; delegate$ui3 = delegate$ui3.getChild$ui()) {
                        if ((delegate$ui3.getKindSet$ui() & m7135constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                Unit unit4 = Unit.INSTANCE;
                                node4 = delegate$ui3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != null) {
                                    if (mutableVector3 != null) {
                                        Boolean.valueOf(mutableVector3.add(node4));
                                    }
                                    node4 = null;
                                }
                                if (mutableVector3 != null) {
                                    Boolean.valueOf(mutableVector3.add(delegate$ui3));
                                }
                            }
                        }
                    }
                    if (i4 == 1) {
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector3);
            }
            Modifier.Node node5 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node5 != null) {
                if (node5 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node5).mo6192onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node5.getKindSet$ui() & m7135constructorimpl2) != 0 && (node5 instanceof DelegatingNode)) {
                    int i5 = 0;
                    for (Modifier.Node delegate$ui4 = ((DelegatingNode) node5).getDelegate$ui(); delegate$ui4 != null; delegate$ui4 = delegate$ui4.getChild$ui()) {
                        if ((delegate$ui4.getKindSet$ui() & m7135constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                Unit unit5 = Unit.INSTANCE;
                                node5 = delegate$ui4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node5 != null) {
                                    if (mutableVector4 != null) {
                                        Boolean.valueOf(mutableVector4.add(node5));
                                    }
                                    node5 = null;
                                }
                                if (mutableVector4 != null) {
                                    Boolean.valueOf(mutableVector4.add(delegate$ui4));
                                }
                            }
                        }
                    }
                    if (i5 == 1) {
                    }
                }
                node5 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(i6)).mo6192onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                }
                Unit unit6 = Unit.INSTANCE;
            }
            Unit unit7 = Unit.INSTANCE;
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent rotaryScrollEvent, Function0<Boolean> function0) {
        RotaryInputModifierNode rotaryInputModifierNode;
        NodeChain nodes$ui;
        boolean z;
        Modifier.Node node;
        NodeChain nodes$ui2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = findFocusTargetNode;
            int m7135constructorimpl = NodeKind.m7135constructorimpl(16384);
            if (!focusTargetNode.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node2 = focusTargetNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    node = null;
                    break;
                }
                if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                    while (node2 != null) {
                        if ((node2.getKindSet$ui() & m7135constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            node = node2;
                            while (node != null) {
                                if (node instanceof RotaryInputModifierNode) {
                                    break loop0;
                                }
                                if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                        if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Unit unit = Unit.INSTANCE;
                                                node = delegate$ui;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector != null) {
                                                        Boolean.valueOf(mutableVector.add(node));
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector != null) {
                                                    Boolean.valueOf(mutableVector.add(delegate$ui));
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        node2 = node2.getParent$ui();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui();
                node2 = (requireLayoutNode == null || (nodes$ui2 = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui2.getTail$ui();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) node;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            RotaryInputModifierNode rotaryInputModifierNode2 = rotaryInputModifierNode;
            int m7135constructorimpl2 = NodeKind.m7135constructorimpl(16384);
            if (!rotaryInputModifierNode2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui = rotaryInputModifierNode2.getNode().getParent$ui();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl2) != 0) {
                    while (parent$ui != null) {
                        if ((parent$ui.getKindSet$ui() & m7135constructorimpl2) != 0) {
                            Modifier.Node node3 = parent$ui;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node3);
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z && (node3.getKindSet$ui() & m7135constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui2 = ((DelegatingNode) node3).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                        if ((delegate$ui2.getKindSet$ui() & m7135constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                Unit unit2 = Unit.INSTANCE;
                                                node3 = delegate$ui2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node3 != null) {
                                                    if (mutableVector2 != null) {
                                                        Boolean.valueOf(mutableVector2.add(node3));
                                                    }
                                                    node3 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    Boolean.valueOf(mutableVector2.add(delegate$ui2));
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent$ui = parent$ui.getParent$ui();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui();
                parent$ui = (requireLayoutNode2 == null || (nodes$ui = requireLayoutNode2.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
            }
            if (arrayList != null) {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (((RotaryInputModifierNode) arrayList.get(size)).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                            return true;
                        }
                        if (i3 < 0) {
                            break;
                        }
                        size = i3;
                    }
                }
                Unit unit3 = Unit.INSTANCE;
            }
            Modifier.Node node4 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node4 != null) {
                if (node4 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node4).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                } else if ((node4.getKindSet$ui() & m7135constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                    int i4 = 0;
                    for (Modifier.Node delegate$ui3 = ((DelegatingNode) node4).getDelegate$ui(); delegate$ui3 != null; delegate$ui3 = delegate$ui3.getChild$ui()) {
                        if ((delegate$ui3.getKindSet$ui() & m7135constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                Unit unit4 = Unit.INSTANCE;
                                node4 = delegate$ui3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != null) {
                                    if (mutableVector3 != null) {
                                        Boolean.valueOf(mutableVector3.add(node4));
                                    }
                                    node4 = null;
                                }
                                if (mutableVector3 != null) {
                                    Boolean.valueOf(mutableVector3.add(delegate$ui3));
                                }
                            }
                        }
                    }
                    if (i4 == 1) {
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector3);
            }
            if (function0.invoke().booleanValue()) {
                return true;
            }
            Modifier.Node node5 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node5 != null) {
                if (node5 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node5).onRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                } else if ((node5.getKindSet$ui() & m7135constructorimpl2) != 0 && (node5 instanceof DelegatingNode)) {
                    int i5 = 0;
                    for (Modifier.Node delegate$ui4 = ((DelegatingNode) node5).getDelegate$ui(); delegate$ui4 != null; delegate$ui4 = delegate$ui4.getChild$ui()) {
                        if ((delegate$ui4.getKindSet$ui() & m7135constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                Unit unit5 = Unit.INSTANCE;
                                node5 = delegate$ui4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node5 != null) {
                                    if (mutableVector4 != null) {
                                        Boolean.valueOf(mutableVector4.add(node5));
                                    }
                                    node5 = null;
                                }
                                if (mutableVector4 != null) {
                                    Boolean.valueOf(mutableVector4.add(delegate$ui4));
                                }
                            }
                        }
                    }
                    if (i5 == 1) {
                    }
                }
                node5 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((RotaryInputModifierNode) arrayList.get(i6)).onRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                }
                Unit unit6 = Unit.INSTANCE;
            }
            Unit unit7 = Unit.INSTANCE;
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchIndirectPointerEvent(IndirectPointerEvent indirectPointerEvent) {
        IndirectPointerInputModifierNode indirectPointerInputModifierNode;
        int i;
        int i2;
        NodeChain nodes$ui;
        boolean z;
        Modifier.Node node;
        NodeChain nodes$ui2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching indirect pointer event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        if (activeFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = activeFocusTargetNode;
            int m7135constructorimpl = NodeKind.m7135constructorimpl(2097152);
            if (!focusTargetNode.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node2 = focusTargetNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    node = null;
                    break;
                }
                if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                    while (node2 != null) {
                        if ((node2.getKindSet$ui() & m7135constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            node = node2;
                            while (node != null) {
                                if (node instanceof IndirectPointerInputModifierNode) {
                                    break loop0;
                                }
                                if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                        if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                node = delegate$ui;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        node2 = node2.getParent$ui();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui();
                node2 = (requireLayoutNode == null || (nodes$ui2 = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui2.getTail$ui();
            }
            indirectPointerInputModifierNode = (IndirectPointerInputModifierNode) node;
        } else {
            indirectPointerInputModifierNode = null;
        }
        if (indirectPointerInputModifierNode != null) {
            IndirectPointerInputModifierNode indirectPointerInputModifierNode2 = indirectPointerInputModifierNode;
            int m7135constructorimpl2 = NodeKind.m7135constructorimpl(2097152);
            if (!indirectPointerInputModifierNode2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui = indirectPointerInputModifierNode2.getNode().getParent$ui();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(indirectPointerInputModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl2) != 0) {
                    while (parent$ui != null) {
                        if ((parent$ui.getKindSet$ui() & m7135constructorimpl2) != 0) {
                            Modifier.Node node3 = parent$ui;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof IndirectPointerInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node3);
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z && (node3.getKindSet$ui() & m7135constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node delegate$ui2 = ((DelegatingNode) node3).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                        if ((delegate$ui2.getKindSet$ui() & m7135constructorimpl2) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                node3 = delegate$ui2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node3 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node3);
                                                    }
                                                    node3 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui2);
                                                }
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent$ui = parent$ui.getParent$ui();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui();
                parent$ui = (requireLayoutNode2 == null || (nodes$ui = requireLayoutNode2.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i5 = i2 - 1;
                    ((IndirectPointerInputModifierNode) arrayList.get(i2)).onIndirectPointerEvent(indirectPointerEvent, PointerEventPass.Initial);
                    if (i5 < 0) {
                        break;
                    }
                    i2 = i5;
                }
            }
            indirectPointerInputModifierNode.onIndirectPointerEvent(indirectPointerEvent, PointerEventPass.Initial);
            indirectPointerInputModifierNode.onIndirectPointerEvent(indirectPointerEvent, PointerEventPass.Main);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((IndirectPointerInputModifierNode) arrayList.get(i6)).onIndirectPointerEvent(indirectPointerEvent, PointerEventPass.Main);
                }
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i7 = i - 1;
                    ((IndirectPointerInputModifierNode) arrayList.get(i)).onIndirectPointerEvent(indirectPointerEvent, PointerEventPass.Final);
                    if (i7 < 0) {
                        break;
                    }
                    i = i7;
                }
            }
            indirectPointerInputModifierNode.onIndirectPointerEvent(indirectPointerEvent, PointerEventPass.Final);
        }
        List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
        int size2 = changes.size();
        for (int i8 = 0; i8 < size2; i8++) {
            if (changes.get(i8).isConsumed()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void dispatchIndirectPointerCancel() {
        IndirectPointerInputModifierNode indirectPointerInputModifierNode;
        NodeChain nodes$ui;
        boolean z;
        Modifier.Node node;
        NodeChain nodes$ui2;
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        if (activeFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = activeFocusTargetNode;
            int m7135constructorimpl = NodeKind.m7135constructorimpl(2097152);
            if (!focusTargetNode.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node2 = focusTargetNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    node = null;
                    break;
                }
                if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                    while (node2 != null) {
                        if ((node2.getKindSet$ui() & m7135constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            node = node2;
                            while (node != null) {
                                if (node instanceof IndirectPointerInputModifierNode) {
                                    break loop0;
                                }
                                if ((node.getKindSet$ui() & m7135constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                        if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        node2 = node2.getParent$ui();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui();
                node2 = (requireLayoutNode == null || (nodes$ui2 = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui2.getTail$ui();
            }
            indirectPointerInputModifierNode = (IndirectPointerInputModifierNode) node;
        } else {
            indirectPointerInputModifierNode = null;
        }
        if (indirectPointerInputModifierNode != null) {
            IndirectPointerInputModifierNode indirectPointerInputModifierNode2 = indirectPointerInputModifierNode;
            int m7135constructorimpl2 = NodeKind.m7135constructorimpl(2097152);
            if (!indirectPointerInputModifierNode2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui = indirectPointerInputModifierNode2.getNode().getParent$ui();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(indirectPointerInputModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & m7135constructorimpl2) != 0) {
                    while (parent$ui != null) {
                        if ((parent$ui.getKindSet$ui() & m7135constructorimpl2) != 0) {
                            Modifier.Node node3 = parent$ui;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof IndirectPointerInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node3);
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z && (node3.getKindSet$ui() & m7135constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui2 = ((DelegatingNode) node3).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                                        if ((delegate$ui2.getKindSet$ui() & m7135constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node3 = delegate$ui2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node3 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node3);
                                                    }
                                                    node3 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui2);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent$ui = parent$ui.getParent$ui();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui();
                parent$ui = (requireLayoutNode2 == null || (nodes$ui = requireLayoutNode2.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
            }
            indirectPointerInputModifierNode.onCancelIndirectPointerInput();
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((IndirectPointerInputModifierNode) arrayList.get(i3)).onCancelIndirectPointerInput();
                }
            }
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void focusTargetAvailable() {
        this.platformFocusOwner.focusTargetAvailable();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode focusTargetNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusTargetNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode focusEventModifierNode) {
        this.focusInvalidationManager.scheduleInvalidation(focusEventModifierNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidationForOwner() {
        this.focusInvalidationManager.scheduleInvalidation();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            return FocusTraversalKt.focusRect(findFocusTargetNode);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean hasFocusableContent() {
        if (this.rootFocusNode.isAttached()) {
            FocusTargetNode focusTargetNode = this.rootFocusNode;
            int m7135constructorimpl = NodeKind.m7135constructorimpl(1024);
            if (!focusTargetNode.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
            }
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui = focusTargetNode.getNode().getChild$ui();
            if (child$ui == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode(), false);
            } else {
                mutableVector.add(child$ui);
            }
            while (mutableVector.getSize() != 0) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                    for (Modifier.Node node2 = node; node2 != null && node2.isAttached(); node2 = node2.getChild$ui()) {
                        if ((node2.getKindSet$ui() & m7135constructorimpl) != 0) {
                            Modifier.Node node3 = node2;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) node3;
                                    if (focusTargetNode2.isAttached() && focusTargetNode2.fetchFocusProperties$ui().getCanFocus()) {
                                        return true;
                                    }
                                } else if ((node3.getKindSet$ui() & m7135constructorimpl) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) node3).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                        if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node3 = delegate$ui;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node3 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node3);
                                                    }
                                                    node3 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
                        }
                    }
                }
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
            }
            return false;
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean hasNonInteropFocusableContent() {
        if (this.rootFocusNode.isAttached()) {
            FocusTargetNode focusTargetNode = this.rootFocusNode;
            int m7135constructorimpl = NodeKind.m7135constructorimpl(1024);
            if (!focusTargetNode.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
            }
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui = focusTargetNode.getNode().getChild$ui();
            if (child$ui == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode(), false);
            } else {
                mutableVector.add(child$ui);
            }
            while (mutableVector.getSize() != 0) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
                    for (Modifier.Node node2 = node; node2 != null && node2.isAttached(); node2 = node2.getChild$ui()) {
                        if ((node2.getKindSet$ui() & m7135constructorimpl) != 0) {
                            Modifier.Node node3 = node2;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) node3;
                                    if (focusTargetNode2.isAttached()) {
                                        FocusProperties fetchFocusProperties$ui = focusTargetNode2.fetchFocusProperties$ui();
                                        if (focusTargetNode2.isAttached() && !focusTargetNode2.isInteropViewHost() && fetchFocusProperties$ui.getCanFocus()) {
                                            return true;
                                        }
                                    }
                                } else if ((node3.getKindSet$ui() & m7135constructorimpl) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui = ((DelegatingNode) node3).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                        if ((delegate$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node3 = delegate$ui;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node3 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node3);
                                                    }
                                                    node3 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
                        }
                    }
                }
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
            }
            return false;
        }
        return false;
    }

    private final FocusTargetNode findFocusTargetNode() {
        return FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public MutableObjectList<FocusListener> getListeners() {
        return this.listeners;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTargetNode getActiveFocusTargetNode() {
        FocusTargetNode focusTargetNode = this.activeFocusTargetNode;
        if (focusTargetNode == null || !focusTargetNode.isAttached()) {
            return null;
        }
        return this.activeFocusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setActiveFocusTargetNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.activeFocusTargetNode;
        this.activeFocusTargetNode = focusTargetNode;
        if (focusTargetNode == null || focusTargetNode2 != focusTargetNode) {
            setFocusCaptured(false);
        }
        MutableObjectList<FocusListener> listeners = getListeners();
        Object[] objArr = listeners.content;
        int i = listeners._size;
        for (int i2 = 0; i2 < i; i2++) {
            ((FocusListener) objArr[i2]).onFocusChanged(focusTargetNode2, focusTargetNode);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean isFocusCaptured() {
        return this.isFocusCaptured;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setFocusCaptured(boolean z) {
        if (!((z && getActiveFocusTargetNode() == null) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot capture focus when the active focus target node is unset");
        }
        this.isFocusCaptured = z;
    }

    /* renamed from: validateKeyEvent-ZmokQxo  reason: not valid java name */
    private final boolean m5004validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long m6517getKeyZmokQxo = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
        int m6518getTypeZmokQxo = KeyEvent_androidKt.m6518getTypeZmokQxo(keyEvent);
        if (KeyEventType.m6510equalsimpl0(m6518getTypeZmokQxo, KeyEventType.Companion.m6514getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(m6517getKeyZmokQxo);
        } else if (KeyEventType.m6510equalsimpl0(m6518getTypeZmokQxo, KeyEventType.Companion.m6515getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(m6517getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(m6517getKeyZmokQxo);
            }
        }
        return true;
    }

    /* renamed from: traverseAncestorsIncludingSelf-QFhIj7k  reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m5003traverseAncestorsIncludingSelfQFhIj7k(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        int i2;
        int i3;
        NodeChain nodes$ui;
        boolean z;
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui = delegatableNode.getNode().getParent$ui();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (true) {
            if (requireLayoutNode == null) {
                break;
            }
            if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & i) != 0) {
                while (parent$ui != null) {
                    if ((parent$ui.getKindSet$ui() & i) != 0) {
                        Modifier.Node node = parent$ui;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (node instanceof Object) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(node);
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z && (node.getKindSet$ui() & i) != 0 && (node instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node delegate$ui = ((DelegatingNode) node).getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & i) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            node = delegate$ui;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent$ui = parent$ui.getParent$ui();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui();
            parent$ui = (requireLayoutNode == null || (nodes$ui = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
        }
        if (arrayList != null && arrayList.size() - 1 >= 0) {
            while (true) {
                int i5 = i3 - 1;
                function1.invoke((Object) arrayList.get(i3));
                if (i5 < 0) {
                    break;
                }
                i3 = i5;
            }
        }
        Modifier.Node node2 = delegatableNode.getNode();
        MutableVector mutableVector2 = null;
        while (node2 != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node2 instanceof Object) {
                function1.invoke(node2);
            } else if ((node2.getKindSet$ui() & i) != 0 && (node2 instanceof DelegatingNode)) {
                int i6 = 0;
                for (Modifier.Node delegate$ui2 = ((DelegatingNode) node2).getDelegate$ui(); delegate$ui2 != null; delegate$ui2 = delegate$ui2.getChild$ui()) {
                    if ((delegate$ui2.getKindSet$ui() & i) != 0) {
                        i6++;
                        if (i6 == 1) {
                            node2 = delegate$ui2;
                        } else {
                            if (mutableVector2 == null) {
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node2 != null) {
                                if (mutableVector2 != null) {
                                    mutableVector2.add(node2);
                                }
                                node2 = null;
                            }
                            if (mutableVector2 != null) {
                                mutableVector2.add(delegate$ui2);
                            }
                        }
                    }
                }
                if (i6 == 1) {
                }
            }
            node2 = DelegatableNodeKt.pop(mutableVector2);
        }
        function0.invoke();
        Modifier.Node node3 = delegatableNode.getNode();
        MutableVector mutableVector3 = null;
        while (node3 != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node3 instanceof Object) {
                function12.invoke(node3);
            } else if ((node3.getKindSet$ui() & i) != 0 && (node3 instanceof DelegatingNode)) {
                int i7 = 0;
                for (Modifier.Node delegate$ui3 = ((DelegatingNode) node3).getDelegate$ui(); delegate$ui3 != null; delegate$ui3 = delegate$ui3.getChild$ui()) {
                    if ((delegate$ui3.getKindSet$ui() & i) != 0) {
                        i7++;
                        if (i7 == 1) {
                            node3 = delegate$ui3;
                        } else {
                            if (mutableVector3 == null) {
                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node3 != null) {
                                if (mutableVector3 != null) {
                                    mutableVector3.add(node3);
                                }
                                node3 = null;
                            }
                            if (mutableVector3 != null) {
                                mutableVector3.add(delegate$ui3);
                            }
                        }
                    }
                }
                if (i7 == 1) {
                }
            }
            node3 = DelegatableNodeKt.pop(mutableVector3);
        }
        if (arrayList != null) {
            int size = arrayList.size();
            for (i2 = 0; i2 < size; i2++) {
                function12.invoke((Object) arrayList.get(i2));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* renamed from: nearestAncestorIncludingSelf-64DMado  reason: not valid java name */
    private final /* synthetic */ <T> T m5002nearestAncestorIncludingSelf64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes$ui;
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet$ui() & i) != 0) {
                        T t = (T) node;
                        MutableVector mutableVector = null;
                        while (t != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (t instanceof Object) {
                                return t;
                            }
                            T t2 = t;
                            if ((((Modifier.Node) t).getKindSet$ui() & i) != 0 && (t instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui = t.getDelegate$ui(); delegate$ui != null; delegate$ui = delegate$ui.getChild$ui()) {
                                    if ((delegate$ui.getKindSet$ui() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            t = (T) delegate$ui;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            T t3 = t;
                                            if (t != null) {
                                                if (mutableVector != 0) {
                                                    mutableVector.add(t);
                                                }
                                                t = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            t = (T) DelegatableNodeKt.pop(mutableVector);
                        }
                        continue;
                    }
                    node = node.getParent$ui();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui();
            node = (requireLayoutNode == null || (nodes$ui = requireLayoutNode.getNodes$ui()) == null) ? null : nodes$ui.getTail$ui();
        }
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int m7135constructorimpl = NodeKind.m7135constructorimpl(1024) | NodeKind.m7135constructorimpl(8192);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet$ui() & m7135constructorimpl) != 0) {
            for (Modifier.Node child$ui = node.getChild$ui(); child$ui != null; child$ui = child$ui.getChild$ui()) {
                if ((child$ui.getKindSet$ui() & m7135constructorimpl) != 0) {
                    if ((NodeKind.m7135constructorimpl(1024) & child$ui.getKindSet$ui()) != 0) {
                        return node2;
                    }
                    node2 = child$ui;
                }
            }
        }
        return node2;
    }
}
