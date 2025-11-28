package androidx.compose.ui.focus;

import android.os.Trace;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: FocusTargetNode.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001KBe\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012:\b\u0002\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u001f\u001a\u00020\u0015H\u0017J\u0017\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\b\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u00020\u000fH\u0016J\b\u00104\u001a\u00020\u000fH\u0016J\r\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7JK\u00108\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u000f0\u00112\u001d\u0010;\u001a\u0019\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0002\b=H\u0082\b¢\u0006\u0004\b>\u0010?J,\u0010@\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u000f0\u0011H\u0080\b¢\u0006\u0004\bA\u0010BJ,\u0010C\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u000f0\u0011H\u0080\b¢\u0006\u0004\bD\u0010BJ\r\u0010E\u001a\u00020\u000fH\u0000¢\u0006\u0002\bFJ\u001d\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nH\u0000¢\u0006\u0002\bJR@\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR&\u0010\u0006\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010&\"\u0004\b-\u0010(R\u0013\u0010.\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006L"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "focusability", "Landroidx/compose/ui/focus/Focusability;", "onFocusChange", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusState;", "Lkotlin/ParameterName;", "name", "previous", "current", "", "onDispatchEventsCompleted", "Lkotlin/Function1;", "<init>", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "isProcessingCustomExit", "", "isProcessingCustomEnter", "committedFocusState", "Landroidx/compose/ui/focus/FocusStateImpl;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "focusState", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "requestFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "requestFocus-3ESFkO8", "(I)Z", "value", "getFocusability-LCbbffg", "()I", "setFocusability-josRg5g", "(I)V", "I", "previouslyFocusedChildHash", "", "getPreviouslyFocusedChildHash", "setPreviouslyFocusedChildHash", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "onObservedReadsChanged", "onReset", "onDetach", "fetchFocusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "fetchFocusProperties$ui_release", "fetchCustomEnterOrExit", "block", "Landroidx/compose/ui/focus/FocusRequester;", "enterOrExit", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "Lkotlin/ExtensionFunctionType;", "fetchCustomEnterOrExit-ULY8qGw", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "fetchCustomEnter", "fetchCustomEnter-aToIllA$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "fetchCustomExit", "fetchCustomExit-aToIllA$ui_release", "invalidateFocus", "invalidateFocus$ui_release", "dispatchFocusCallbacks", "previousState", DownloaderClientMarshaller.PARAM_NEW_STATE, "dispatchFocusCallbacks$ui_release", "FocusTargetElement", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTargetNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusTargetModifierNode, ObserverModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;
    private FocusStateImpl committedFocusState;
    private int focusability;
    private boolean isProcessingCustomEnter;
    private boolean isProcessingCustomExit;
    private final Function1<FocusTargetNode, Unit> onDispatchEventsCompleted;
    private final Function2<FocusState, FocusState, Unit> onFocusChange;
    private int previouslyFocusedChildHash;
    private final boolean shouldAutoInvalidate;

    /* compiled from: FocusTargetNode.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public /* synthetic */ FocusTargetNode(int i, Function2 function2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function2, function1);
    }

    public /* synthetic */ FocusTargetNode(int i, Function2 function2, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Focusability.Companion.m4970getAlwaysLCbbffg() : i, (i2 & 2) != 0 ? null : function2, (i2 & 4) != 0 ? null : function1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FocusTargetNode(int i, Function2<? super FocusState, ? super FocusState, Unit> function2, Function1<? super FocusTargetNode, Unit> function1) {
        this.onFocusChange = function2;
        this.onDispatchEventsCompleted = function1;
        this.focusability = i;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    public FocusStateImpl getFocusState() {
        FocusOwner focusOwner;
        FocusTargetNode activeFocusTargetNode;
        NodeChain nodes$ui_release;
        if (isAttached() && (activeFocusTargetNode = (focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner()).getActiveFocusTargetNode()) != null) {
            if (this == activeFocusTargetNode) {
                return focusOwner.isFocusCaptured() ? FocusStateImpl.Captured : FocusStateImpl.Active;
            }
            if (activeFocusTargetNode.isAttached()) {
                FocusTargetNode focusTargetNode = activeFocusTargetNode;
                int m6989constructorimpl = NodeKind.m6989constructorimpl(1024);
                if (!focusTargetNode.getNode().isAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                while (requireLayoutNode != null) {
                    if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m6989constructorimpl) != 0) {
                        while (parent$ui_release != null) {
                            if ((parent$ui_release.getKindSet$ui_release() & m6989constructorimpl) != 0) {
                                Modifier.Node node = parent$ui_release;
                                MutableVector mutableVector = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        if (this == node) {
                                            return FocusStateImpl.ActiveParent;
                                        }
                                    } else if ((node.getKindSet$ui_release() & m6989constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release();
                                        int i = 0;
                                        node = node;
                                        while (delegate$ui_release != null) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m6989constructorimpl) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    node = delegate$ui_release;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node != 0) {
                                                        if (mutableVector != null) {
                                                            mutableVector.add(node);
                                                        }
                                                        node = 0;
                                                    }
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegate$ui_release);
                                                    }
                                                }
                                            }
                                            delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                            node = node;
                                        }
                                        if (i == 1) {
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector);
                                }
                                continue;
                            }
                            parent$ui_release = parent$ui_release.getParent$ui_release();
                        }
                    }
                    requireLayoutNode = requireLayoutNode.getParent$ui_release();
                    parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                }
            }
            return FocusStateImpl.Inactive;
        }
        return FocusStateImpl.Inactive;
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the version accepting FocusDirection", replaceWith = @ReplaceWith(expression = "this.requestFocus()", imports = {}))
    public /* synthetic */ boolean requestFocus() {
        return mo4947requestFocus3ESFkO8(FocusDirection.Companion.m4920getEnterdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    /* renamed from: requestFocus-3ESFkO8 */
    public boolean mo4947requestFocus3ESFkO8(int i) {
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            boolean z = false;
            if (fetchFocusProperties$ui_release().getCanFocus()) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m4957performCustomRequestFocusMxy_nc0(this, i).ordinal()];
                if (i2 == 1) {
                    z = FocusTransactionsKt.performRequestFocus(this);
                } else if (i2 == 2) {
                    z = true;
                } else if (i2 != 3 && i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                return z;
            }
            return false;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    /* renamed from: getFocusability-LCbbffg */
    public int mo4946getFocusabilityLCbbffg() {
        return this.focusability;
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    /* renamed from: setFocusability-josRg5g */
    public void mo4948setFocusabilityjosRg5g(int i) {
        if (Focusability.m4966equalsimpl0(this.focusability, i)) {
            return;
        }
        this.focusability = i;
        if (isAttached() && this == DelegatableNodeKt.requireOwner(this).getFocusOwner().getActiveFocusTargetNode() && !Focusability.m4963canFocusimpl$ui_release(this.focusability, this)) {
            FocusTransactionsKt.clearFocus(this, true, true);
        }
    }

    public final int getPreviouslyFocusedChildHash() {
        return this.previouslyFocusedChildHash;
    }

    public final void setPreviouslyFocusedChildHash(int i) {
        this.previouslyFocusedChildHash = i;
    }

    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return (BeyondBoundsLayout) getCurrent(androidx.compose.ui.layout.BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        invalidateFocus$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        if (ComposeUiFlags.isClearFocusOnResetEnabled && getFocusState().isFocused()) {
            DelegatableNodeKt.requireOwner(this).getFocusOwner().mo4931clearFocusI7lrPNg(true, true, true, FocusDirection.Companion.m4921getExitdhqQ8s());
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        int i = WhenMappings.$EnumSwitchMapping$1[getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
            focusOwner.mo4931clearFocusI7lrPNg(true, true, false, FocusDirection.Companion.m4921getExitdhqQ8s());
            focusOwner.scheduleInvalidationForOwner();
        } else if (i != 3 && i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        this.committedFocusState = null;
    }

    public final FocusProperties fetchFocusProperties$ui_release() {
        NodeChain nodes$ui_release;
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        focusPropertiesImpl.setCanFocus(Focusability.m4963canFocusimpl$ui_release(mo4946getFocusabilityLCbbffg(), this));
        FocusTargetNode focusTargetNode = this;
        int m6989constructorimpl = NodeKind.m6989constructorimpl(2048);
        int m6989constructorimpl2 = NodeKind.m6989constructorimpl(1024);
        Modifier.Node node = focusTargetNode.getNode();
        int i = m6989constructorimpl | m6989constructorimpl2;
        if (!focusTargetNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = focusTargetNode.getNode();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet$ui_release() & i) != 0) {
                        if (node2 != node && (node2.getKindSet$ui_release() & m6989constructorimpl2) != 0) {
                            break loop0;
                        } else if ((node2.getKindSet$ui_release() & m6989constructorimpl) != 0) {
                            Modifier.Node node3 = node2;
                            MutableVector mutableVector = null;
                            while (node3 != null) {
                                if (node3 instanceof FocusPropertiesModifierNode) {
                                    ((FocusPropertiesModifierNode) node3).applyFocusProperties(focusPropertiesImpl);
                                } else if ((node3.getKindSet$ui_release() & m6989constructorimpl) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & m6989constructorimpl) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node3 = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node3 != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node3);
                                                    }
                                                    node3 = null;
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
                                node3 = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                    }
                    node2 = node2.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            node2 = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return focusPropertiesImpl;
    }

    /* renamed from: fetchCustomEnterOrExit-ULY8qGw  reason: not valid java name */
    private final void m4951fetchCustomEnterOrExitULY8qGw(int i, Function1<? super FocusRequester, Unit> function1, Function2<? super FocusProperties, ? super FocusEnterExitScope, Unit> function2) {
        FocusProperties fetchFocusProperties$ui_release = fetchFocusProperties$ui_release();
        CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
        function2.invoke(fetchFocusProperties$ui_release, cancelIndicatingFocusBoundaryScope);
        FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
        if (cancelIndicatingFocusBoundaryScope.isCanceled()) {
            function1.invoke(FocusRequester.Companion.getCancel());
        } else if (activeFocusTargetNode == activeFocusTargetNode2 || activeFocusTargetNode2 == null) {
        } else {
            function1.invoke(FocusRequester.Companion.getRedirect$ui_release());
        }
    }

    /* renamed from: fetchCustomEnter-aToIllA$ui_release  reason: not valid java name */
    public final void m4952fetchCustomEnteraToIllA$ui_release(int i, Function1<? super FocusRequester, Unit> function1) {
        if (this.isProcessingCustomEnter) {
            return;
        }
        this.isProcessingCustomEnter = true;
        try {
            FocusProperties fetchFocusProperties$ui_release = fetchFocusProperties$ui_release();
            CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
            FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
            fetchFocusProperties$ui_release.getOnEnter().invoke(cancelIndicatingFocusBoundaryScope);
            FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
            if (cancelIndicatingFocusBoundaryScope.isCanceled()) {
                function1.invoke(FocusRequester.Companion.getCancel());
            } else if (activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null) {
                function1.invoke(FocusRequester.Companion.getRedirect$ui_release());
            }
        } finally {
            this.isProcessingCustomEnter = false;
        }
    }

    /* renamed from: fetchCustomExit-aToIllA$ui_release  reason: not valid java name */
    public final void m4953fetchCustomExitaToIllA$ui_release(int i, Function1<? super FocusRequester, Unit> function1) {
        if (this.isProcessingCustomExit) {
            return;
        }
        this.isProcessingCustomExit = true;
        try {
            FocusProperties fetchFocusProperties$ui_release = fetchFocusProperties$ui_release();
            CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
            FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
            fetchFocusProperties$ui_release.getOnExit().invoke(cancelIndicatingFocusBoundaryScope);
            FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
            if (cancelIndicatingFocusBoundaryScope.isCanceled()) {
                function1.invoke(FocusRequester.Companion.getCancel());
            } else if (activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null) {
                function1.invoke(FocusRequester.Companion.getRedirect$ui_release());
            }
        } finally {
            this.isProcessingCustomExit = false;
        }
    }

    public final void invalidateFocus$ui_release() {
        FocusProperties focusProperties;
        int i = WhenMappings.$EnumSwitchMapping$1[getFocusState().ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3 && i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetNode$invalidateFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.ui.focus.FocusProperties, T] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                objectRef.element = this.fetchFocusProperties$ui_release();
            }
        });
        if (objectRef.element == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
            focusProperties = null;
        } else {
            focusProperties = (FocusProperties) objectRef.element;
        }
        if (focusProperties.getCanFocus()) {
            return;
        }
        DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
    }

    public final void dispatchFocusCallbacks$ui_release(FocusState focusState, FocusState focusState2) {
        NodeChain nodes$ui_release;
        Function2<FocusState, FocusState, Unit> function2;
        FocusTargetNode focusTargetNode = this;
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
        if (!Intrinsics.areEqual(focusState, focusState2) && (function2 = this.onFocusChange) != null) {
            function2.invoke(focusState, focusState2);
        }
        int m6989constructorimpl = NodeKind.m6989constructorimpl(4096);
        int m6989constructorimpl2 = NodeKind.m6989constructorimpl(1024);
        Modifier.Node node = focusTargetNode.getNode();
        int i = m6989constructorimpl | m6989constructorimpl2;
        if (!focusTargetNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = focusTargetNode.getNode();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet$ui_release() & i) != 0) {
                        if (node2 != node && (node2.getKindSet$ui_release() & m6989constructorimpl2) != 0) {
                            break loop0;
                        } else if ((node2.getKindSet$ui_release() & m6989constructorimpl) != 0) {
                            Modifier.Node node3 = node2;
                            MutableVector mutableVector = null;
                            while (node3 != null) {
                                if (!(node3 instanceof FocusEventModifierNode)) {
                                    if ((node3.getKindSet$ui_release() & m6989constructorimpl) != 0 && (node3 instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m6989constructorimpl) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    node3 = delegate$ui_release;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node3 != null) {
                                                        if (mutableVector != null) {
                                                            mutableVector.add(node3);
                                                        }
                                                        node3 = null;
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
                                } else {
                                    FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) node3;
                                    if (activeFocusTargetNode == focusOwner.getActiveFocusTargetNode()) {
                                        focusEventModifierNode.onFocusEvent(focusState2);
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                    }
                    node2 = node2.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            node2 = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        Function1<FocusTargetNode, Unit> function1 = this.onDispatchEventsCompleted;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    /* compiled from: FocusTargetNode.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\f\u0010\t\u001a\u00020\u0007*\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "<init>", "()V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class FocusTargetElement extends ModifierNodeElement<FocusTargetNode> {
        public static final int $stable = 0;
        public static final FocusTargetElement INSTANCE = new FocusTargetElement();

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object obj) {
            return obj == this;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode focusTargetNode) {
        }

        private FocusTargetElement() {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public FocusTargetNode create() {
            return new FocusTargetNode(0, null, null, 7, null);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("focusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return "focusTarget".hashCode();
        }
    }
}
