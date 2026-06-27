package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b!\u0018\u0000 ~2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0001~BM\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u00106\u001a\u00020\u000fH\u0002J\n\u00107\u001a\u0004\u0018\u00010%H\u0016J\f\u00108\u001a\u00020\u0017*\u000209H\u0016JS\u0010:\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0004¢\u0006\u0002\b;J\u0017\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0004¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\u0006\u0010G\u001a\u00020\u0017J\b\u0010H\u001a\u00020\u0017H\u0016J\u0006\u0010I\u001a\u00020\u0017J\b\u0010J\u001a\u00020\u0017H\u0004J\u0010\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u000fH\u0002J\b\u0010M\u001a\u00020\u0017H\u0002J\b\u0010N\u001a\u00020\u0017H\u0002J\b\u0010O\u001a\u00020\u0017H\u0002J'\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020R2\u0006\u0010E\u001a\u00020F2\u0006\u0010S\u001a\u00020?H\u0016¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001a\u00020\u0017H\u0016J\u0015\u0010W\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020X¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020XH$¢\u0006\u0004\b\\\u0010ZJ\u0017\u0010]\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020XH$¢\u0006\u0004\b^\u0010ZJ\b\u0010_\u001a\u00020\u0017H\u0014J\u0015\u0010`\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020X¢\u0006\u0004\ba\u0010ZJ\n\u0010d\u001a\u00020\u0017*\u000209J\u000f\u0010e\u001a\u0004\u0018\u00010\u0017H\u0004¢\u0006\u0002\u0010fJ\u0010\u0010i\u001a\u00020\u00172\u0006\u0010C\u001a\u00020jH\u0004J\u0010\u0010i\u001a\u00020\u00172\u0006\u0010C\u001a\u00020kH\u0004J\u001f\u0010i\u001a\u00020\u00172\u0006\u0010l\u001a\u0002002\u0006\u0010m\u001a\u00020\u000fH\u0004¢\u0006\u0004\bn\u0010oJ\u001f\u0010p\u001a\u00020\u00172\u0006\u0010l\u001a\u0002002\u0006\u0010m\u001a\u00020\u000fH\u0004¢\u0006\u0004\bq\u0010oJ\u0010\u0010r\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u000fH\u0004J\u001c\u0010s\u001a\u00020\u0017*\u00020t2\u0006\u0010l\u001a\u000200H\u0084@¢\u0006\u0004\bu\u0010vJ\b\u0010w\u001a\u00020\u000fH\u0002J\u0012\u0010w\u001a\u00020\u000f2\b\u0010C\u001a\u0004\u0018\u00010kH\u0002J\u0010\u0010w\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020jH\u0002J\b\u0010x\u001a\u00020\u0017H\u0002J\b\u0010y\u001a\u00020\u0017H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u000fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020*0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0004\n\u0002\u00101R\u0010\u00102\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010b\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bc\u0010\u001cR\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010z\u001a\u00020{X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}¨\u0006\u007f"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputModifierNode;", "Landroidx/compose/foundation/GestureConnection;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "getEnabled", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "localIndicationNodeFactory", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "gestureNode", "Landroidx/compose/ui/node/DelegatableNode;", "indicationNode", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "currentKeyPressInteractions", "Landroidx/collection/MutableLongObjectMap;", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "J", "indirectPointerPressInteraction", "indirectPointerEventPressPosition", "userProvidedInteractionSource", "lazilyCreateIndication", "shouldLazilyCreateIndication", "createPointerInputNodeIfNeeded", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "updateCommon", "updateCommon-O2vRcR0", "getExtendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/unit/IntSize;", "getExtendedTouchPadding-hWWAJMo", "(J)J", "onIndirectPointerEvent", "event", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "onAttach", "onObservedReadsChanged", "onDetach", "disposeInteractions", "onFocusChange", "isFocused", "recreateIndicationIfNeeded", "initializeIndicationAndInteractionSourceIfNeeded", "initializeGestureCoordination", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onKeyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyDownEvent", "onClickKeyDownEvent-ZmokQxo", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "onCancelKeyInput", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "resetPointerInputHandler", "()Lkotlin/Unit;", "delayJob", "Lkotlinx/coroutines/Job;", "handlePressInteractionStart", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", TypedValues.CycleType.S_WAVE_OFFSET, "indirectPointer", "handlePressInteractionStart-3MmeM6k", "(JZ)V", "handlePressInteractionRelease", "handlePressInteractionRelease-3MmeM6k", "handlePressInteractionCancel", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "handlePressInteraction-d-4ec7I", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delayPressInteraction", "emitHoverEnter", "emitHoverExit", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "TraverseKey", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode, SemanticsModifierNode, TraversableNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, IndirectPointerInputModifierNode, GestureConnection {
    private long centerOffset;
    private final MutableLongObjectMap<PressInteraction.Press> currentKeyPressInteractions;
    private Job delayJob;
    private boolean enabled;
    private final FocusableNode focusableNode;
    private DelegatableNode gestureNode;
    private HoverInteraction.Enter hoverInteraction;
    private DelegatableNode indicationNode;
    private IndicationNodeFactory indicationNodeFactory;
    private Offset indirectPointerEventPressPosition;
    private PressInteraction.Press indirectPointerPressInteraction;
    private MutableInteractionSource interactionSource;
    private boolean lazilyCreateIndication;
    private IndicationNodeFactory localIndicationNodeFactory;
    private Function0<Unit> onClick;
    private String onClickLabel;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private PressInteraction.Press pressInteraction;
    private Role role;
    private final boolean shouldAutoInvalidate;
    private final Object traverseKey;
    private boolean useLocalIndication;
    private MutableInteractionSource userProvidedInteractionSource;
    public static final TraverseKey TraverseKey = new TraverseKey(null);
    public static final int $stable = 8;

    public /* synthetic */ AbstractClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z, z2, str, role, function0);
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    public SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded() {
        return null;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    protected void onCancelKeyInput() {
    }

    /* renamed from: onClickKeyDownEvent-ZmokQxo  reason: not valid java name */
    protected abstract boolean mo254onClickKeyDownEventZmokQxo(KeyEvent keyEvent);

    /* renamed from: onClickKeyUpEvent-ZmokQxo  reason: not valid java name */
    protected abstract boolean mo255onClickKeyUpEventZmokQxo(KeyEvent keyEvent);

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo  reason: not valid java name */
    public final boolean mo258onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    private AbstractClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0<Unit> function0) {
        this.interactionSource = mutableInteractionSource;
        this.indicationNodeFactory = indicationNodeFactory;
        this.useLocalIndication = z;
        this.onClickLabel = str;
        this.role = role;
        this.enabled = z2;
        this.onClick = function0;
        this.focusableNode = new FocusableNode(this.interactionSource, Focusability.Companion.m5039getSystemDefinedLCbbffg(), new AbstractClickableNode$focusableNode$1(this), null);
        this.currentKeyPressInteractions = LongObjectMapKt.mutableLongObjectMapOf();
        this.centerOffset = Offset.Companion.m5119getZeroF1C5BW0();
        this.userProvidedInteractionSource = this.interactionSource;
        this.lazilyCreateIndication = shouldLazilyCreateIndication();
        this.traverseKey = TraverseKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    private final boolean shouldLazilyCreateIndication() {
        return this.userProvidedInteractionSource == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
        if (r2.indicationNode == null) goto L32;
     */
    /* renamed from: updateCommon-O2vRcR0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m259updateCommonO2vRcR0(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0<Unit> function0) {
        boolean z3;
        boolean z4 = true;
        if (Intrinsics.areEqual(this.userProvidedInteractionSource, mutableInteractionSource)) {
            z3 = false;
        } else {
            disposeInteractions();
            this.userProvidedInteractionSource = mutableInteractionSource;
            this.interactionSource = mutableInteractionSource;
            z3 = true;
        }
        if (!Intrinsics.areEqual(this.indicationNodeFactory, indicationNodeFactory)) {
            this.indicationNodeFactory = indicationNodeFactory;
            z3 = true;
        }
        if (this.useLocalIndication != z) {
            this.useLocalIndication = z;
            if (z) {
                onObservedReadsChanged();
            }
            z3 = true;
        }
        if (this.enabled != z2) {
            FocusableNode focusableNode = this.focusableNode;
            if (z2) {
                delegate(focusableNode);
            } else {
                undelegate(focusableNode);
                disposeInteractions();
            }
            SemanticsModifierNodeKt.invalidateSemantics(this);
            this.enabled = z2;
        }
        if (!Intrinsics.areEqual(this.onClickLabel, str)) {
            this.onClickLabel = str;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (!Intrinsics.areEqual(this.role, role)) {
            this.role = role;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        this.onClick = function0;
        if (this.lazilyCreateIndication != shouldLazilyCreateIndication()) {
            boolean shouldLazilyCreateIndication = shouldLazilyCreateIndication();
            this.lazilyCreateIndication = shouldLazilyCreateIndication;
            if (!shouldLazilyCreateIndication) {
            }
        }
        z4 = z3;
        if (z4) {
            recreateIndicationIfNeeded();
        }
        this.focusableNode.update(this.interactionSource);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getExtendedTouchPadding-hWWAJMo  reason: not valid java name */
    public final long m250getExtendedTouchPaddinghWWAJMo(long j) {
        long mo435toSizeXkaWNTQ = DelegatableNodeKt.requireDensity(this).mo435toSizeXkaWNTQ(((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).mo7050getMinimumTouchTargetSizeMYxV2XQ());
        return Size.m5163constructorimpl((Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (mo435toSizeXkaWNTQ & 4294967295L)) - ((int) (j & 4294967295L))) / 2.0f) & 4294967295L) | (Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (mo435toSizeXkaWNTQ >> 32)) - ((int) (j >> 32))) / 2.0f) << 32));
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onIndirectPointerEvent(IndirectPointerEvent indirectPointerEvent, PointerEventPass pointerEventPass) {
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled) {
            initializeGestureCoordination();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        onObservedReadsChanged();
        if (!this.lazilyCreateIndication) {
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        if (this.enabled) {
            delegate(this.focusableNode);
        }
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        if (this.useLocalIndication) {
            ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.AbstractClickableNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AbstractClickableNode.onObservedReadsChanged$lambda$0(AbstractClickableNode.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onObservedReadsChanged$lambda$0(AbstractClickableNode abstractClickableNode) {
        Indication indication = (Indication) CompositionLocalConsumerModifierNodeKt.currentValueOf(abstractClickableNode, IndicationKt.getLocalIndication());
        if (!(indication instanceof IndicationNodeFactory)) {
            InlineClassHelperKt.throwIllegalArgumentException(ClickableKt.access$unsupportedIndicationExceptionMessage(indication));
        }
        IndicationNodeFactory indicationNodeFactory = abstractClickableNode.localIndicationNodeFactory;
        IndicationNodeFactory indicationNodeFactory2 = (IndicationNodeFactory) indication;
        abstractClickableNode.localIndicationNodeFactory = indicationNodeFactory2;
        if (indicationNodeFactory != null && !Intrinsics.areEqual(indicationNodeFactory2, indicationNodeFactory)) {
            abstractClickableNode.recreateIndicationIfNeeded();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        disposeInteractions();
        if (this.userProvidedInteractionSource == null) {
            this.interactionSource = null;
        }
        DelegatableNode delegatableNode = this.indicationNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.indicationNode = null;
        DelegatableNode delegatableNode2 = this.gestureNode;
        if (delegatableNode2 != null) {
            undelegate(delegatableNode2);
        }
        this.gestureNode = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void disposeInteractions() {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            PressInteraction.Press press = this.pressInteraction;
            if (press != null) {
                mutableInteractionSource.tryEmit(new PressInteraction.Cancel(press));
            }
            PressInteraction.Press press2 = this.indirectPointerPressInteraction;
            if (press2 != null) {
                mutableInteractionSource.tryEmit(new PressInteraction.Cancel(press2));
            }
            HoverInteraction.Enter enter = this.hoverInteraction;
            if (enter != null) {
                mutableInteractionSource.tryEmit(new HoverInteraction.Exit(enter));
            }
            MutableLongObjectMap<PressInteraction.Press> mutableLongObjectMap = this.currentKeyPressInteractions;
            Object[] objArr = mutableLongObjectMap.values;
            long[] jArr = mutableLongObjectMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                mutableInteractionSource.tryEmit(new PressInteraction.Cancel((PressInteraction.Press) objArr[(i << 3) + i3]));
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        this.pressInteraction = null;
        this.indirectPointerPressInteraction = null;
        this.indirectPointerEventPressPosition = null;
        this.hoverInteraction = null;
        this.currentKeyPressInteractions.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFocusChange(boolean z) {
        if (z) {
            initializeIndicationAndInteractionSourceIfNeeded();
            return;
        }
        if (this.interactionSource != null) {
            MutableLongObjectMap<PressInteraction.Press> mutableLongObjectMap = this.currentKeyPressInteractions;
            Object[] objArr = mutableLongObjectMap.values;
            long[] jArr = mutableLongObjectMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onFocusChange$1$1(this, (PressInteraction.Press) objArr[(i << 3) + i3], null), 3, null);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            PressInteraction.Press press = this.indirectPointerPressInteraction;
            if (press != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onFocusChange$2$1(this, press, null), 3, null);
            }
        }
        this.currentKeyPressInteractions.clear();
        this.indirectPointerPressInteraction = null;
        onCancelKeyInput();
    }

    private final void recreateIndicationIfNeeded() {
        DelegatableNode delegatableNode = this.indicationNode;
        if (delegatableNode == null && this.lazilyCreateIndication) {
            return;
        }
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.indicationNode = null;
        initializeIndicationAndInteractionSourceIfNeeded();
    }

    private final void initializeIndicationAndInteractionSourceIfNeeded() {
        if (this.indicationNode != null) {
            return;
        }
        IndicationNodeFactory indicationNodeFactory = this.useLocalIndication ? this.localIndicationNodeFactory : this.indicationNodeFactory;
        if (indicationNodeFactory != null) {
            if (this.interactionSource == null) {
                this.interactionSource = InteractionSourceKt.MutableInteractionSource();
            }
            this.focusableNode.update(this.interactionSource);
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            Intrinsics.checkNotNull(mutableInteractionSource);
            DelegatableNode create = indicationNodeFactory.create(mutableInteractionSource);
            delegate(create);
            this.indicationNode = create;
        }
    }

    private final void initializeGestureCoordination() {
        if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled && this.gestureNode == null) {
            this.gestureNode = delegate(GestureNodeKt.gestureNode(this));
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void mo257onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded;
        long m8337getCenterozmzZPI = IntSizeKt.m8337getCenterozmzZPI(j);
        this.centerOffset = Offset.m5095constructorimpl((Float.floatToRawIntBits(IntOffset.m8288getXimpl(m8337getCenterozmzZPI)) << 32) | (Float.floatToRawIntBits(IntOffset.m8289getYimpl(m8337getCenterozmzZPI)) & 4294967295L));
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled) {
            initializeGestureCoordination();
            if (pointerEventPass == PointerEventPass.Main) {
                int m6618getType7fucELk = pointerEvent.m6618getType7fucELk();
                if (PointerEventType.m6625equalsimpl0(m6618getType7fucELk, PointerEventType.Companion.m6629getEnter7fucELk())) {
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$1(this, null), 3, null);
                } else if (PointerEventType.m6625equalsimpl0(m6618getType7fucELk, PointerEventType.Companion.m6630getExit7fucELk())) {
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$2(this, null), 3, null);
                }
            }
        }
        if (this.pointerInputNode == null && (createPointerInputNodeIfNeeded = createPointerInputNodeIfNeeded()) != null) {
            this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(createPointerInputNodeIfNeeded);
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.mo257onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        HoverInteraction.Enter enter;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null && (enter = this.hoverInteraction) != null) {
            mutableInteractionSource.tryEmit(new HoverInteraction.Exit(enter));
        }
        this.hoverInteraction = null;
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.onCancelPointerInput();
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo  reason: not valid java name */
    public final boolean mo256onKeyEventZmokQxo(KeyEvent keyEvent) {
        boolean z;
        initializeIndicationAndInteractionSourceIfNeeded();
        long m6517getKeyZmokQxo = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
        if (this.enabled && ClickableKt.m317access$isPressZmokQxo(keyEvent)) {
            if (this.currentKeyPressInteractions.containsKey(m6517getKeyZmokQxo)) {
                z = false;
            } else {
                PressInteraction.Press press = new PressInteraction.Press(this.centerOffset, null);
                this.currentKeyPressInteractions.set(m6517getKeyZmokQxo, press);
                if (this.interactionSource != null) {
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, press, null), 3, null);
                }
                z = true;
            }
            return mo254onClickKeyDownEventZmokQxo(keyEvent) || z;
        }
        if (this.enabled && ClickableKt.m316access$isClickZmokQxo(keyEvent)) {
            PressInteraction.Press remove = this.currentKeyPressInteractions.remove(m6517getKeyZmokQxo);
            if (remove != null) {
                if (this.interactionSource != null) {
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$2(this, remove, null), 3, null);
                }
                mo255onClickKeyUpEventZmokQxo(keyEvent);
            }
            if (remove != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Role role = this.role;
        if (role != null) {
            Intrinsics.checkNotNull(role);
            SemanticsPropertiesKt.m7397setRolekuIjeqM(semanticsPropertyReceiver, role.m7377unboximpl());
        }
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, this.onClickLabel, new Function0() { // from class: androidx.compose.foundation.AbstractClickableNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(AbstractClickableNode.applySemantics$lambda$0(AbstractClickableNode.this));
            }
        });
        if (this.enabled) {
            this.focusableNode.applySemantics(semanticsPropertyReceiver);
        } else {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        applyAdditionalSemantics(semanticsPropertyReceiver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean applySemantics$lambda$0(AbstractClickableNode abstractClickableNode) {
        abstractClickableNode.onClick.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Unit resetPointerInputHandler() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.resetPointerInputHandler();
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void handlePressInteractionStart(IndirectPointerInputChange indirectPointerInputChange) {
        Job launch$default;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            PressInteraction.Press press = new PressInteraction.Press(indirectPointerInputChange.m6190getPositionF1C5BW0(), null);
            if (delayPressInteraction(indirectPointerInputChange)) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$1(mutableInteractionSource, press, this, null), 3, null);
                this.delayJob = launch$default;
                return;
            }
            this.indirectPointerPressInteraction = press;
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$2(mutableInteractionSource, press, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void handlePressInteractionStart(PointerInputChange pointerInputChange) {
        Job launch$default;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            PressInteraction.Press press = new PressInteraction.Press(pointerInputChange.m6685getPositionF1C5BW0(), null);
            if (delayPressInteraction(pointerInputChange)) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$2$1(mutableInteractionSource, press, this, null), 3, null);
                this.delayJob = launch$default;
                return;
            }
            this.pressInteraction = press;
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$2$2(mutableInteractionSource, press, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: handlePressInteractionStart-3MmeM6k  reason: not valid java name */
    public final void m253handlePressInteractionStart3MmeM6k(long j, boolean z) {
        boolean delayPressInteraction;
        Job launch$default;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            PressInteraction.Press press = new PressInteraction.Press(j, null);
            if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled) {
                delayPressInteraction = delayPressInteraction((PointerInputChange) null);
            } else {
                delayPressInteraction = delayPressInteraction();
            }
            if (delayPressInteraction) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$3$1(mutableInteractionSource, press, z, this, null), 3, null);
                this.delayJob = launch$default;
                return;
            }
            if (z) {
                this.indirectPointerPressInteraction = press;
            } else {
                this.pressInteraction = press;
            }
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$3$2(mutableInteractionSource, press, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: handlePressInteractionRelease-3MmeM6k  reason: not valid java name */
    public final void m252handlePressInteractionRelease3MmeM6k(long j, boolean z) {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            Job job = this.delayJob;
            if (job != null && job.isActive()) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$1(job, j, mutableInteractionSource, null), 3, null);
            } else {
                PressInteraction.Press press = z ? this.indirectPointerPressInteraction : this.pressInteraction;
                if (press != null) {
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$2$1(press, mutableInteractionSource, null), 3, null);
                }
            }
            if (z) {
                this.indirectPointerPressInteraction = null;
            } else {
                this.pressInteraction = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void handlePressInteractionCancel(boolean z) {
        final MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            Job job = this.delayJob;
            if (job != null && job.isActive()) {
                Job job2 = this.delayJob;
                if (job2 != null) {
                    Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
            } else {
                PressInteraction.Press press = z ? this.indirectPointerPressInteraction : this.pressInteraction;
                if (press != null) {
                    final PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                    Job job3 = (Job) getCoroutineScope().getCoroutineContext().get(Job.Key);
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionCancel$1$1$1(mutableInteractionSource, cancel, job3 != null ? job3.invokeOnCompletion(new Function1() { // from class: androidx.compose.foundation.AbstractClickableNode$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit handlePressInteractionCancel$lambda$0$0$0;
                            handlePressInteractionCancel$lambda$0$0$0 = AbstractClickableNode.handlePressInteractionCancel$lambda$0$0$0(MutableInteractionSource.this, cancel, (Throwable) obj);
                            return handlePressInteractionCancel$lambda$0$0$0;
                        }
                    }) : null, null), 3, null);
                }
            }
            if (z) {
                this.indirectPointerPressInteraction = null;
            } else {
                this.pressInteraction = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handlePressInteractionCancel$lambda$0$0$0(MutableInteractionSource mutableInteractionSource, PressInteraction.Cancel cancel, Throwable th) {
        mutableInteractionSource.tryEmit(cancel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: handlePressInteraction-d-4ec7I  reason: not valid java name */
    public final Object m251handlePressInteractiond4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
        Object coroutineScope;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        return (mutableInteractionSource == null || (coroutineScope = CoroutineScopeKt.coroutineScope(new AbstractClickableNode$handlePressInteraction$2$1(pressGestureScope, j, mutableInteractionSource, this, null), continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : coroutineScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean delayPressInteraction() {
        return ClickableKt.hasScrollableContainer(this) || Clickable_androidKt.isComposeRootInScrollableContainer(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean delayPressInteraction(PointerInputChange pointerInputChange) {
        boolean hasInterestedParent;
        if (pointerInputChange == null) {
            hasInterestedParent = GestureNodeKt.getParentGestureConnection(this) != null;
        } else {
            hasInterestedParent = ClickableKt.hasInterestedParent(this, pointerInputChange);
        }
        return hasInterestedParent || Clickable_androidKt.isComposeRootInScrollableContainer(this);
    }

    private final boolean delayPressInteraction(IndirectPointerInputChange indirectPointerInputChange) {
        return ClickableKt.hasInterestedParent(this, indirectPointerInputChange) || Clickable_androidKt.isComposeRootInScrollableContainer(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitHoverEnter() {
        if (this.hoverInteraction == null) {
            HoverInteraction.Enter enter = new HoverInteraction.Enter();
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverEnter$1$1(mutableInteractionSource, enter, null), 3, null);
            }
            this.hoverInteraction = enter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitHoverExit() {
        HoverInteraction.Enter enter = this.hoverInteraction;
        if (enter != null) {
            HoverInteraction.Exit exit = new HoverInteraction.Exit(enter);
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverExit$1$1$1(mutableInteractionSource, exit, null), 3, null);
            }
            this.hoverInteraction = null;
        }
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* compiled from: Clickable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode$TraverseKey;", "", "<init>", "()V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class TraverseKey {
        public /* synthetic */ TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TraverseKey() {
        }
    }
}
