package androidx.compose.ui.focus;

import android.os.Trace;
import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.indirect.IndirectTouchEvent;
import androidx.compose.ui.input.indirect.IndirectTouchInputModifierNode;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
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
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: FocusOwnerImpl.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\b\u001aJ!\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0015H\u0016J/\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b&\u0010'J\u001a\u0010#\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0017\u0010)\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b*\u0010+J7\u0010,\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u00192\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150/H\u0016¢\u0006\u0004\b0\u00101J%\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001506H\u0016¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00152\u0006\u00103\u001a\u000204H\u0016¢\u0006\u0004\b:\u0010;J\u001e\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020>2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001506H\u0016J\u001e\u0010?\u001a\u00020\u00152\u0006\u0010=\u001a\u00020@2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001506H\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\tH\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0016Jd\u0010E\u001a\u00020!\"\n\b\u0000\u0010F\u0018\u0001*\u00020G*\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HF0I2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u00020!0/2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020!062\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u00020!0/H\u0082\b¢\u0006\u0004\bM\u0010NJ0\u0010O\u001a\u0004\u0018\u0001HF\"\n\b\u0000\u0010F\u0018\u0001*\u00020P*\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HF0IH\u0082\b¢\u0006\u0004\bQ\u0010RJ\n\u0010S\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010T\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010f\u001a\u0004\u0018\u00010g*\u00020GH\u0002J\u0017\u0010h\u001a\u00020\u00152\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0004\bi\u0010;R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010U\u001a\u00020V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0ZX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R(\u0010_\u001a\u0004\u0018\u00010\t2\b\u0010^\u001a\u0004\u0018\u00010\t@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000b\"\u0004\ba\u0010\rR$\u0010b\u001a\u00020\u00152\u0006\u0010^\u001a\u00020\u0015@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006j"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "platformFocusOwner", "Landroidx/compose/ui/focus/PlatformFocusOwner;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/focus/PlatformFocusOwner;Landroidx/compose/ui/node/Owner;)V", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "requestOwnerFocus", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-7o62pno", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "releaseFocus", "", "clearOwnerFocus", "clearFocus", "force", "refreshFocusEvents", "clearFocus-I7lrPNg", "(ZZZI)Z", "forced", "moveFocus", "moveFocus-3ESFkO8", "(I)Z", "focusSearch", "focusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "dispatchKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onFocusedItem", "Lkotlin/Function0;", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchInterceptedSoftKeyboardEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchRotaryEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "dispatchIndirectTouchEvent", "Landroidx/compose/ui/input/indirect/IndirectTouchEvent;", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "scheduleInvalidationForOwner", "traverseAncestorsIncludingSelf", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "nearestAncestorIncludingSelf", "", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "getFocusRect", "findFocusTargetNode", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "listeners", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/focus/FocusListener;", "getListeners", "()Landroidx/collection/MutableObjectList;", "value", "activeFocusTargetNode", "getActiveFocusTargetNode", "setActiveFocusTargetNode", "isFocusCaptured", "()Z", "setFocusCaptured", "(Z)V", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private FocusTargetNode activeFocusTargetNode;
    private final FocusInvalidationManager focusInvalidationManager;
    private boolean isFocusCaptured;
    private MutableLongSet keysCurrentlyDown;
    private final Owner owner;
    private final PlatformFocusOwner platformFocusOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode(Focusability.Companion.m4228getNeverLCbbffg(), null, null, 6, null);
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
            return FocusOwnerImpl.this.getRootFocusNode$ui_release();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("RootFocusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return FocusOwnerImpl.this.getRootFocusNode$ui_release().hashCode();
        }
    };
    private final MutableObjectList<FocusListener> listeners = new MutableObjectList<>(1);

    /* compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
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

    public final FocusTargetNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: requestOwnerFocus-7o62pno */
    public boolean mo4192requestOwnerFocus7o62pno(FocusDirection focusDirection, Rect rect) {
        return this.platformFocusOwner.mo4235requestOwnerFocus7o62pno(focusDirection, rect);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: takeFocus-aToIllA */
    public boolean mo4193takeFocusaToIllA(final int i, Rect rect) {
        Boolean mo4191focusSearchULY8qGw = mo4191focusSearchULY8qGw(i, rect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo4204requestFocus3ESFkO8(i));
            }
        });
        if (mo4191focusSearchULY8qGw != null) {
            return mo4191focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void clearOwnerFocus() {
        this.platformFocusOwner.clearOwnerFocus();
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean z) {
        mo4188clearFocusI7lrPNg(z, true, true, FocusDirection.Companion.m4178getExitdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: clearFocus-I7lrPNg */
    public boolean mo4188clearFocusI7lrPNg(boolean z, boolean z2, boolean z3, int i) {
        boolean clearFocus;
        if (!z) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m4211performCustomClearFocusMxy_nc0(this.rootFocusNode, i).ordinal()];
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

    static /* synthetic */ boolean clearFocus$default(FocusOwnerImpl focusOwnerImpl, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return focusOwnerImpl.clearFocus(z, z2);
    }

    private final boolean clearFocus(boolean z, boolean z2) {
        NodeChain nodes$ui_release;
        if (getActiveFocusTargetNode() == null) {
            return true;
        }
        if (!isFocusCaptured() || z) {
            FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
            setActiveFocusTargetNode(null);
            if (z2 && activeFocusTargetNode != null) {
                activeFocusTargetNode.dispatchFocusCallbacks$ui_release(isFocusCaptured() ? FocusStateImpl.Captured : FocusStateImpl.Active, FocusStateImpl.Inactive);
                FocusTargetNode focusTargetNode = activeFocusTargetNode;
                int m6245constructorimpl = NodeKind.m6245constructorimpl(1024);
                if (!focusTargetNode.getNode().isAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                while (requireLayoutNode != null) {
                    if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6245constructorimpl) != 0) {
                        while (parent$ui_release != null) {
                            if ((parent$ui_release.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                                MutableVector mutableVector = null;
                                Modifier.Node node = parent$ui_release;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        ((FocusTargetNode) node).dispatchFocusCallbacks$ui_release(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                                    } else if ((node.getKindSet$ui_release() & m6245constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        int i = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    node = delegate$ui_release;
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
                                                        mutableVector.add(delegate$ui_release);
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
                            parent$ui_release = parent$ui_release.getParent$ui_release();
                        }
                    }
                    requireLayoutNode = requireLayoutNode.getParent$ui_release();
                    parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.Boolean] */
    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo4186moveFocus3ESFkO8(final int i) {
        if (ComposeUiFlags.isViewFocusFixEnabled && this.platformFocusOwner.mo4234moveFocusInChildren3ESFkO8(i)) {
            return true;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = false;
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        Boolean mo4191focusSearchULY8qGw = mo4191focusSearchULY8qGw(i, this.platformFocusOwner.getEmbeddedViewFocusRect(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Boolean] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.element = Boolean.valueOf(focusTargetNode.mo4204requestFocus3ESFkO8(i));
                return objectRef.element;
            }
        });
        if (!Intrinsics.areEqual((Object) mo4191focusSearchULY8qGw, (Object) true) || activeFocusTargetNode == getActiveFocusTargetNode()) {
            if (mo4191focusSearchULY8qGw != null && objectRef.element != 0) {
                if (mo4191focusSearchULY8qGw.booleanValue() && ((Boolean) objectRef.element).booleanValue()) {
                    return true;
                }
                if (FocusOwnerImplKt.m4197is1dFocusSearch3ESFkO8(i)) {
                    return mo4188clearFocusI7lrPNg(false, true, false, i) && mo4193takeFocusaToIllA(i, null);
                } else if (!ComposeUiFlags.isViewFocusFixEnabled && this.platformFocusOwner.mo4234moveFocusInChildren3ESFkO8(i)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: focusSearch-ULY8qGw */
    public Boolean mo4191focusSearchULY8qGw(int i, Rect rect, final Function1<? super FocusTargetNode, Boolean> function1) {
        final FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            FocusRequester m4217customFocusSearchOMvw8 = FocusTraversalKt.m4217customFocusSearchOMvw8(findFocusTargetNode, i, this.owner.getLayoutDirection());
            if (Intrinsics.areEqual(m4217customFocusSearchOMvw8, FocusRequester.Companion.getCancel())) {
                return null;
            }
            if (Intrinsics.areEqual(m4217customFocusSearchOMvw8, FocusRequester.Companion.getRedirect$ui_release())) {
                FocusTargetNode findFocusTargetNode2 = findFocusTargetNode();
                if (findFocusTargetNode2 != null) {
                    return function1.invoke(findFocusTargetNode2);
                }
                return null;
            } else if (!Intrinsics.areEqual(m4217customFocusSearchOMvw8, FocusRequester.Companion.getDefault())) {
                return Boolean.valueOf(m4217customFocusSearchOMvw8.findFocusTargetNode$ui_release(function1));
            }
        } else {
            findFocusTargetNode = null;
        }
        return FocusTraversalKt.m4218focusSearch0X8WOeE(this.rootFocusNode, i, this.owner.getLayoutDirection(), rect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
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
                } else if (Intrinsics.areEqual(focusTargetNode, this.getRootFocusNode$ui_release())) {
                    throw new IllegalStateException("Focus search landed at the root.".toString());
                } else {
                    booleanValue = function1.invoke(focusTargetNode).booleanValue();
                }
                return Boolean.valueOf(booleanValue);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v21, types: [T, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v31, types: [T, java.lang.Object, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v40, types: [T, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v50, types: [T, java.lang.Object, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v68 */
    /* JADX WARN: Type inference failed for: r4v69 */
    /* JADX WARN: Type inference failed for: r4v70 */
    /* JADX WARN: Type inference failed for: r4v71 */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-YhN2O0w */
    public boolean mo4190dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0<Boolean> function0) {
        Modifier.Node node;
        Modifier.Node node2;
        NodeChain nodes$ui_release;
        Modifier.Node node3;
        NodeChain nodes$ui_release2;
        NodeChain nodes$ui_release3;
        Trace.beginSection("FocusOwnerImpl:dispatchKeyEvent");
        try {
            if (this.focusInvalidationManager.hasPendingInvalidation()) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
                return false;
            } else if (m4196validateKeyEventZmokQxo(keyEvent)) {
                FocusTargetNode findFocusTargetNode = findFocusTargetNode();
                if (findFocusTargetNode == null || (node2 = lastLocalKeyInputNode(findFocusTargetNode)) == null) {
                    if (findFocusTargetNode != null) {
                        FocusTargetNode focusTargetNode = findFocusTargetNode;
                        int m6245constructorimpl = NodeKind.m6245constructorimpl(8192);
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
                            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6245constructorimpl) != 0) {
                                while (node4 != null) {
                                    if ((node4.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                                        MutableVector mutableVector = null;
                                        node3 = node4;
                                        while (node3 != null) {
                                            if (node3 instanceof KeyInputModifierNode) {
                                                break loop10;
                                            }
                                            if ((node3.getKindSet$ui_release() & m6245constructorimpl) != 0 && (node3 instanceof DelegatingNode)) {
                                                int i = 0;
                                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                                    if ((delegate$ui_release.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                                                        i++;
                                                        if (i == 1) {
                                                            Unit unit = Unit.INSTANCE;
                                                            node3 = delegate$ui_release;
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
                                                                Boolean.valueOf(mutableVector.add(delegate$ui_release));
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
                                    node4 = node4.getParent$ui_release();
                                }
                            }
                            requireLayoutNode = requireLayoutNode.getParent$ui_release();
                            node4 = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
                        }
                        KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) node3;
                        if (keyInputModifierNode != null) {
                            node2 = keyInputModifierNode.getNode();
                        }
                    }
                    FocusTargetNode focusTargetNode2 = this.rootFocusNode;
                    int m6245constructorimpl2 = NodeKind.m6245constructorimpl(8192);
                    if (!focusTargetNode2.getNode().isAttached()) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    Modifier.Node parent$ui_release = focusTargetNode2.getNode().getParent$ui_release();
                    LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
                    loop14: while (true) {
                        if (requireLayoutNode2 == null) {
                            node = null;
                            break;
                        }
                        if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6245constructorimpl2) != 0) {
                            while (parent$ui_release != null) {
                                if ((parent$ui_release.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                                    MutableVector mutableVector2 = null;
                                    node = parent$ui_release;
                                    while (node != null) {
                                        if (node instanceof KeyInputModifierNode) {
                                            break loop14;
                                        }
                                        if ((node.getKindSet$ui_release() & m6245constructorimpl2) != 0 && (node instanceof DelegatingNode)) {
                                            int i2 = 0;
                                            for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                                if ((delegate$ui_release2.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                                                    i2++;
                                                    if (i2 == 1) {
                                                        Unit unit2 = Unit.INSTANCE;
                                                        node = delegate$ui_release2;
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
                                                            Boolean.valueOf(mutableVector2.add(delegate$ui_release2));
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
                                parent$ui_release = parent$ui_release.getParent$ui_release();
                            }
                        }
                        requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                        parent$ui_release = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                    }
                    KeyInputModifierNode keyInputModifierNode2 = (KeyInputModifierNode) node;
                    node2 = keyInputModifierNode2 != null ? keyInputModifierNode2.getNode() : null;
                }
                if (node2 != null) {
                    Modifier.Node node5 = node2;
                    int m6245constructorimpl3 = NodeKind.m6245constructorimpl(8192);
                    if (!node5.getNode().isAttached()) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    Modifier.Node parent$ui_release2 = node5.getNode().getParent$ui_release();
                    LayoutNode requireLayoutNode3 = DelegatableNodeKt.requireLayoutNode(node5);
                    ArrayList arrayList = null;
                    while (requireLayoutNode3 != null) {
                        if ((requireLayoutNode3.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6245constructorimpl3) != 0) {
                            while (parent$ui_release2 != null) {
                                if ((parent$ui_release2.getKindSet$ui_release() & m6245constructorimpl3) != 0) {
                                    Modifier.Node node6 = parent$ui_release2;
                                    MutableVector mutableVector3 = null;
                                    while (node6 != null) {
                                        if (node6 instanceof KeyInputModifierNode) {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(node6);
                                        } else if ((node6.getKindSet$ui_release() & m6245constructorimpl3) != 0 && (node6 instanceof DelegatingNode)) {
                                            int i3 = 0;
                                            for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node6).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                                                if ((delegate$ui_release3.getKindSet$ui_release() & m6245constructorimpl3) != 0) {
                                                    i3++;
                                                    if (i3 == 1) {
                                                        Unit unit3 = Unit.INSTANCE;
                                                        node6 = delegate$ui_release3;
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
                                                            Boolean.valueOf(mutableVector3.add(delegate$ui_release3));
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
                                parent$ui_release2 = parent$ui_release2.getParent$ui_release();
                            }
                        }
                        requireLayoutNode3 = requireLayoutNode3.getParent$ui_release();
                        parent$ui_release2 = (requireLayoutNode3 == null || (nodes$ui_release3 = requireLayoutNode3.getNodes$ui_release()) == null) ? null : nodes$ui_release3.getTail$ui_release();
                    }
                    if (arrayList != null) {
                        int size = arrayList.size() - 1;
                        if (size >= 0) {
                            while (true) {
                                int i4 = size - 1;
                                if (((KeyInputModifierNode) arrayList.get(size)).mo228onPreKeyEventZmokQxo(keyEvent)) {
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
                    ?? node7 = node5.getNode();
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = node7;
                    while (objectRef2.element != 0) {
                        if (objectRef2.element instanceof KeyInputModifierNode) {
                            if (((KeyInputModifierNode) objectRef2.element).mo228onPreKeyEventZmokQxo(keyEvent)) {
                                return true;
                            }
                        } else if ((((Modifier.Node) objectRef2.element).getKindSet$ui_release() & m6245constructorimpl3) != 0 && (objectRef2.element instanceof DelegatingNode)) {
                            int i5 = 0;
                            for (?? r4 = ((DelegatingNode) objectRef2.element).getDelegate$ui_release(); r4 != 0; r4 = r4.getChild$ui_release()) {
                                if ((r4.getKindSet$ui_release() & m6245constructorimpl3) != 0) {
                                    i5++;
                                    if (i5 == 1) {
                                        objectRef2.element = r4;
                                        Unit unit5 = Unit.INSTANCE;
                                    } else {
                                        MutableVector mutableVector4 = (MutableVector) objectRef.element;
                                        T t = mutableVector4;
                                        if (mutableVector4 == null) {
                                            t = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        objectRef.element = t;
                                        Modifier.Node node8 = (Modifier.Node) objectRef2.element;
                                        if (node8 != null) {
                                            MutableVector mutableVector5 = (MutableVector) objectRef.element;
                                            if (mutableVector5 != null) {
                                                Boolean.valueOf(mutableVector5.add(node8));
                                            }
                                            objectRef2.element = null;
                                        }
                                        MutableVector mutableVector6 = (MutableVector) objectRef.element;
                                        if (mutableVector6 != null) {
                                            Boolean.valueOf(mutableVector6.add(r4));
                                        }
                                    }
                                }
                            }
                            if (i5 == 1) {
                            }
                        }
                        objectRef2.element = DelegatableNodeKt.pop((MutableVector) objectRef.element);
                    }
                    if (function0.invoke().booleanValue()) {
                        return true;
                    }
                    ?? node9 = node5.getNode();
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                    objectRef4.element = node9;
                    while (objectRef4.element != 0) {
                        if (objectRef4.element instanceof KeyInputModifierNode) {
                            if (((KeyInputModifierNode) objectRef4.element).mo226onKeyEventZmokQxo(keyEvent)) {
                                return true;
                            }
                        } else if ((((Modifier.Node) objectRef4.element).getKindSet$ui_release() & m6245constructorimpl3) != 0 && (objectRef4.element instanceof DelegatingNode)) {
                            int i6 = 0;
                            for (?? r42 = ((DelegatingNode) objectRef4.element).getDelegate$ui_release(); r42 != 0; r42 = r42.getChild$ui_release()) {
                                if ((r42.getKindSet$ui_release() & m6245constructorimpl3) != 0) {
                                    i6++;
                                    if (i6 == 1) {
                                        objectRef4.element = r42;
                                        Unit unit6 = Unit.INSTANCE;
                                    } else {
                                        MutableVector mutableVector7 = (MutableVector) objectRef3.element;
                                        T t2 = mutableVector7;
                                        if (mutableVector7 == null) {
                                            t2 = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        objectRef3.element = t2;
                                        Modifier.Node node10 = (Modifier.Node) objectRef4.element;
                                        if (node10 != null) {
                                            MutableVector mutableVector8 = (MutableVector) objectRef3.element;
                                            if (mutableVector8 != null) {
                                                Boolean.valueOf(mutableVector8.add(node10));
                                            }
                                            objectRef4.element = null;
                                        }
                                        MutableVector mutableVector9 = (MutableVector) objectRef3.element;
                                        if (mutableVector9 != null) {
                                            Boolean.valueOf(mutableVector9.add(r42));
                                        }
                                    }
                                }
                            }
                            if (i6 == 1) {
                            }
                        }
                        objectRef4.element = DelegatableNodeKt.pop((MutableVector) objectRef3.element);
                    }
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        for (int i7 = 0; i7 < size2; i7++) {
                            if (((KeyInputModifierNode) arrayList.get(i7)).mo226onKeyEventZmokQxo(keyEvent)) {
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
    public boolean mo4189dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        int i;
        NodeChain nodes$ui_release;
        Modifier.Node node;
        NodeChain nodes$ui_release2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            FocusTargetNode focusTargetNode = findActiveFocusNode;
            int m6245constructorimpl = NodeKind.m6245constructorimpl(131072);
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
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6245constructorimpl) != 0) {
                    while (node2 != null) {
                        if ((node2.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            node = node2;
                            while (node != null) {
                                if (node instanceof SoftKeyboardInterceptionModifierNode) {
                                    break loop0;
                                }
                                if ((node.getKindSet$ui_release() & m6245constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node = delegate$ui_release;
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
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        node2 = node2.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node2 = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
            }
            softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) node;
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode != null) {
            SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode2 = softKeyboardInterceptionModifierNode;
            int m6245constructorimpl2 = NodeKind.m6245constructorimpl(131072);
            if (!softKeyboardInterceptionModifierNode2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui_release = softKeyboardInterceptionModifierNode2.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(softKeyboardInterceptionModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6245constructorimpl2) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                            Modifier.Node node3 = parent$ui_release;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof SoftKeyboardInterceptionModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node3);
                                } else if ((node3.getKindSet$ui_release() & m6245constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                        if ((delegate$ui_release2.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                node3 = delegate$ui_release2;
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
                                                    mutableVector2.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent$ui_release = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i4 = i - 1;
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(i)).mo5370onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                    if (i4 < 0) {
                        break;
                    }
                    i = i4;
                }
            }
            Modifier.Node node4 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node4 != null) {
                if (node4 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node4).mo5370onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node4.getKindSet$ui_release() & m6245constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                    int i5 = 0;
                    for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                        if ((delegate$ui_release3.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node4 = delegate$ui_release3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(node4);
                                    }
                                    node4 = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(delegate$ui_release3);
                                }
                            }
                        }
                    }
                    if (i5 == 1) {
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector3);
            }
            Modifier.Node node5 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node5 != null) {
                if (node5 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node5).mo5369onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node5.getKindSet$ui_release() & m6245constructorimpl2) != 0 && (node5 instanceof DelegatingNode)) {
                    int i6 = 0;
                    for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) node5).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                        if ((delegate$ui_release4.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                            i6++;
                            if (i6 == 1) {
                                node5 = delegate$ui_release4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node5 != null) {
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(node5);
                                    }
                                    node5 = null;
                                }
                                if (mutableVector4 != null) {
                                    mutableVector4.add(delegate$ui_release4);
                                }
                            }
                        }
                    }
                    if (i6 == 1) {
                    }
                }
                node5 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(i7)).mo5369onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent rotaryScrollEvent, Function0<Boolean> function0) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int i;
        NodeChain nodes$ui_release;
        Modifier.Node node;
        NodeChain nodes$ui_release2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = findFocusTargetNode;
            int m6245constructorimpl = NodeKind.m6245constructorimpl(16384);
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
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6245constructorimpl) != 0) {
                    while (node2 != null) {
                        if ((node2.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            node = node2;
                            while (node != null) {
                                if (node instanceof RotaryInputModifierNode) {
                                    break loop0;
                                }
                                if ((node.getKindSet$ui_release() & m6245constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node = delegate$ui_release;
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
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        node2 = node2.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node2 = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) node;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            RotaryInputModifierNode rotaryInputModifierNode2 = rotaryInputModifierNode;
            int m6245constructorimpl2 = NodeKind.m6245constructorimpl(16384);
            if (!rotaryInputModifierNode2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui_release = rotaryInputModifierNode2.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6245constructorimpl2) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                            Modifier.Node node3 = parent$ui_release;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node3);
                                } else if ((node3.getKindSet$ui_release() & m6245constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                        if ((delegate$ui_release2.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                node3 = delegate$ui_release2;
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
                                                    mutableVector2.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent$ui_release = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i4 = i - 1;
                    if (((RotaryInputModifierNode) arrayList.get(i)).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                    if (i4 < 0) {
                        break;
                    }
                    i = i4;
                }
            }
            Modifier.Node node4 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node4 != null) {
                if (node4 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node4).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                } else if ((node4.getKindSet$ui_release() & m6245constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                    int i5 = 0;
                    for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                        if ((delegate$ui_release3.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node4 = delegate$ui_release3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(node4);
                                    }
                                    node4 = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(delegate$ui_release3);
                                }
                            }
                        }
                    }
                    if (i5 == 1) {
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
                } else if ((node5.getKindSet$ui_release() & m6245constructorimpl2) != 0 && (node5 instanceof DelegatingNode)) {
                    int i6 = 0;
                    for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) node5).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                        if ((delegate$ui_release4.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                            i6++;
                            if (i6 == 1) {
                                node5 = delegate$ui_release4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node5 != null) {
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(node5);
                                    }
                                    node5 = null;
                                }
                                if (mutableVector4 != null) {
                                    mutableVector4.add(delegate$ui_release4);
                                }
                            }
                        }
                    }
                    if (i6 == 1) {
                    }
                }
                node5 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    if (((RotaryInputModifierNode) arrayList.get(i7)).onRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchIndirectTouchEvent(IndirectTouchEvent indirectTouchEvent, Function0<Boolean> function0) {
        IndirectTouchInputModifierNode indirectTouchInputModifierNode;
        int i;
        NodeChain nodes$ui_release;
        Modifier.Node node;
        NodeChain nodes$ui_release2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching indirect touch event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = findFocusTargetNode;
            int m6245constructorimpl = NodeKind.m6245constructorimpl(2097152);
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
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6245constructorimpl) != 0) {
                    while (node2 != null) {
                        if ((node2.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            node = node2;
                            while (node != null) {
                                if (node instanceof IndirectTouchInputModifierNode) {
                                    break loop0;
                                }
                                if ((node.getKindSet$ui_release() & m6245constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node = delegate$ui_release;
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
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        node2 = node2.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node2 = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
            }
            indirectTouchInputModifierNode = (IndirectTouchInputModifierNode) node;
        } else {
            indirectTouchInputModifierNode = null;
        }
        if (indirectTouchInputModifierNode != null) {
            IndirectTouchInputModifierNode indirectTouchInputModifierNode2 = indirectTouchInputModifierNode;
            int m6245constructorimpl2 = NodeKind.m6245constructorimpl(2097152);
            if (!indirectTouchInputModifierNode2.getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui_release = indirectTouchInputModifierNode2.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(indirectTouchInputModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6245constructorimpl2) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                            Modifier.Node node3 = parent$ui_release;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof IndirectTouchInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node3);
                                } else if ((node3.getKindSet$ui_release() & m6245constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                        if ((delegate$ui_release2.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                node3 = delegate$ui_release2;
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
                                                    mutableVector2.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent$ui_release = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i4 = i - 1;
                    if (((IndirectTouchInputModifierNode) arrayList.get(i)).onPreIndirectTouchEvent(indirectTouchEvent)) {
                        return true;
                    }
                    if (i4 < 0) {
                        break;
                    }
                    i = i4;
                }
            }
            Modifier.Node node4 = indirectTouchInputModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node4 != null) {
                if (node4 instanceof IndirectTouchInputModifierNode) {
                    if (((IndirectTouchInputModifierNode) node4).onPreIndirectTouchEvent(indirectTouchEvent)) {
                        return true;
                    }
                } else if ((node4.getKindSet$ui_release() & m6245constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                    int i5 = 0;
                    for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                        if ((delegate$ui_release3.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node4 = delegate$ui_release3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(node4);
                                    }
                                    node4 = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(delegate$ui_release3);
                                }
                            }
                        }
                    }
                    if (i5 == 1) {
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector3);
            }
            if (function0.invoke().booleanValue()) {
                return true;
            }
            Modifier.Node node5 = indirectTouchInputModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node5 != null) {
                if (node5 instanceof IndirectTouchInputModifierNode) {
                    if (((IndirectTouchInputModifierNode) node5).onIndirectTouchEvent(indirectTouchEvent)) {
                        return true;
                    }
                } else if ((node5.getKindSet$ui_release() & m6245constructorimpl2) != 0 && (node5 instanceof DelegatingNode)) {
                    int i6 = 0;
                    for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) node5).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                        if ((delegate$ui_release4.getKindSet$ui_release() & m6245constructorimpl2) != 0) {
                            i6++;
                            if (i6 == 1) {
                                node5 = delegate$ui_release4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node5 != null) {
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(node5);
                                    }
                                    node5 = null;
                                }
                                if (mutableVector4 != null) {
                                    mutableVector4.add(delegate$ui_release4);
                                }
                            }
                        }
                    }
                    if (i6 == 1) {
                    }
                }
                node5 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    if (((IndirectTouchInputModifierNode) arrayList.get(i7)).onIndirectTouchEvent(indirectTouchEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
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
        return this.activeFocusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setActiveFocusTargetNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.activeFocusTargetNode;
        this.activeFocusTargetNode = focusTargetNode;
        if (focusTargetNode == null || focusTargetNode2 != focusTargetNode) {
            setFocusCaptured(false);
        }
        if (ComposeUiFlags.isSemanticAutofillEnabled) {
            MutableObjectList<FocusListener> listeners = getListeners();
            Object[] objArr = listeners.content;
            int i = listeners._size;
            for (int i2 = 0; i2 < i; i2++) {
                ((FocusListener) objArr[i2]).onFocusChanged(focusTargetNode2, focusTargetNode);
            }
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
    private final boolean m4196validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long m5682getKeyZmokQxo = KeyEvent_androidKt.m5682getKeyZmokQxo(keyEvent);
        int m5683getTypeZmokQxo = KeyEvent_androidKt.m5683getTypeZmokQxo(keyEvent);
        if (KeyEventType.m5675equalsimpl0(m5683getTypeZmokQxo, KeyEventType.Companion.m5679getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(m5682getKeyZmokQxo);
        } else if (KeyEventType.m5675equalsimpl0(m5683getTypeZmokQxo, KeyEventType.Companion.m5680getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(m5682getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(m5682getKeyZmokQxo);
            }
        }
        return true;
    }

    /* renamed from: traverseAncestorsIncludingSelf-QFhIj7k  reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m4195traverseAncestorsIncludingSelfQFhIj7k(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        int i2;
        int i3;
        NodeChain nodes$ui_release;
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (true) {
            if (requireLayoutNode == null) {
                break;
            }
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                        Modifier.Node node = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (node instanceof Object) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(node);
                            } else if ((node.getKindSet$ui_release() & i) != 0 && (node instanceof DelegatingNode)) {
                                int i4 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            node = delegate$ui_release;
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
                                                mutableVector.add(delegate$ui_release);
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
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
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
            } else if ((node2.getKindSet$ui_release() & i) != 0 && (node2 instanceof DelegatingNode)) {
                int i6 = 0;
                for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                    if ((delegate$ui_release2.getKindSet$ui_release() & i) != 0) {
                        i6++;
                        if (i6 == 1) {
                            node2 = delegate$ui_release2;
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
                                mutableVector2.add(delegate$ui_release2);
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
            } else if ((node3.getKindSet$ui_release() & i) != 0 && (node3 instanceof DelegatingNode)) {
                int i7 = 0;
                for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                    if ((delegate$ui_release3.getKindSet$ui_release() & i) != 0) {
                        i7++;
                        if (i7 == 1) {
                            node3 = delegate$ui_release3;
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
                                mutableVector3.add(delegate$ui_release3);
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
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* renamed from: nearestAncestorIncludingSelf-64DMado  reason: not valid java name */
    private final /* synthetic */ <T> T m4194nearestAncestorIncludingSelf64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes$ui_release;
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet$ui_release() & i) != 0) {
                        T t = (T) node;
                        MutableVector mutableVector = null;
                        while (t != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (t instanceof Object) {
                                return t;
                            }
                            T t2 = t;
                            if ((((Modifier.Node) t).getKindSet$ui_release() & i) != 0 && (t instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = t.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            t = (T) delegate$ui_release;
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
                                                mutableVector.add(delegate$ui_release);
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
                    node = node.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            node = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int m6245constructorimpl = NodeKind.m6245constructorimpl(1024) | NodeKind.m6245constructorimpl(8192);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet$ui_release() & m6245constructorimpl) != 0) {
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & m6245constructorimpl) != 0) {
                    if ((NodeKind.m6245constructorimpl(1024) & child$ui_release.getKindSet$ui_release()) != 0) {
                        return node2;
                    }
                    node2 = child$ui_release;
                }
            }
        }
        return node2;
    }
}
