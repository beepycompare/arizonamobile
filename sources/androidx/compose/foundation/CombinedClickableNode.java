package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetector_androidKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001^B\u007f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0016J'\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016¢\u0006\u0004\b=\u0010>J\u0018\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020A2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020$H\u0002J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020-H\u0002J\u0018\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020$H\u0002J\u0018\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020-H\u0002J\u001f\u0010G\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u0010;\u001a\u00020<H\u0002¢\u0006\u0004\bH\u0010IJ\u0010\u0010G\u001a\u00020\u00052\u0006\u0010J\u001a\u00020AH\u0002J\b\u0010K\u001a\u00020\u0005H\u0002J\u0010\u0010L\u001a\u00020\u00052\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010L\u001a\u00020\u00052\u0006\u0010J\u001a\u00020AH\u0002J\b\u0010M\u001a\u00020\u0005H\u0016J\b\u0010N\u001a\u00020\u0005H\u0016J\u0010\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u000bH\u0002J{\u0010Q\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\bRJ\f\u0010S\u001a\u00020\u0005*\u00020TH\u0016J\u0017\u0010U\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020VH\u0014¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020VH\u0014¢\u0006\u0004\bZ\u0010XJ\b\u0010[\u001a\u00020\u0005H\u0014J\b\u0010\\\u001a\u00020\u0005H\u0016J\b\u0010]\u001a\u00020\u0005H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u000bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Landroidx/compose/foundation/CombinedClickableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "hapticFeedbackEnabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "enabled", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHapticFeedbackEnabled", "()Z", "setHapticFeedbackEnabled", "(Z)V", "longKeyPressJobs", "Landroidx/collection/MutableLongObjectMap;", "Lkotlinx/coroutines/Job;", "doubleKeyClickStates", "Landroidx/compose/foundation/CombinedClickableNode$DoubleKeyClickState;", "isSuspendingPointerInputEnabled", "isSuspendingPointerInputEnabled$annotations", "()V", "downEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "longPressJob", "tapJob", "isSecondTap", "longPressTriggered", "firstTapUpTime", "", "ignoreNextUp", "indirectDownEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "indirectLongPressJob", "indirectTapJob", "indirectIsSecondTap", "indirectLongPressTriggered", "indirectFirstTapUpTime", "indirectIgnoreNextUp", "createPointerInputNodeIfNeeded", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onIndirectPointerEvent", "event", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "handleDownEvent", "down", "handleUpEvent", "uptimeMillis", "downChange", "handleNonUpEventIfNeeded", "handleNonUpEventIfNeeded-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "indirectPointerEvent", "handleDeepPress", "checkForCancellation", "onCancelPointerInput", "onCancelIndirectPointerInput", "cancelInput", "indirectPointer", "update", "update-2tQrsxU", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "onClickKeyDownEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onClickKeyDownEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "onCancelKeyInput", "onReset", "resetKeyPressState", "DoubleKeyClickState", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CombinedClickableNode extends AbstractClickableNode implements CompositionLocalConsumerModifierNode {
    private final MutableLongObjectMap<DoubleKeyClickState> doubleKeyClickStates;
    private PointerInputChange downEvent;
    private long firstTapUpTime;
    private boolean hapticFeedbackEnabled;
    private boolean ignoreNextUp;
    private IndirectPointerInputChange indirectDownEvent;
    private long indirectFirstTapUpTime;
    private boolean indirectIgnoreNextUp;
    private boolean indirectIsSecondTap;
    private Job indirectLongPressJob;
    private boolean indirectLongPressTriggered;
    private Job indirectTapJob;
    private boolean isSecondTap;
    private final boolean isSuspendingPointerInputEnabled;
    private final MutableLongObjectMap<Job> longKeyPressJobs;
    private Job longPressJob;
    private boolean longPressTriggered;
    private Function0<Unit> onDoubleClick;
    private Function0<Unit> onLongClick;
    private String onLongClickLabel;
    private Job tapJob;

    public /* synthetic */ CombinedClickableNode(Function0 function0, String str, Function0 function02, Function0 function03, boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, boolean z3, String str2, Role role, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, function02, function03, z, mutableInteractionSource, indicationNodeFactory, z2, z3, str2, role);
    }

    private static /* synthetic */ void isSuspendingPointerInputEnabled$annotations() {
    }

    private CombinedClickableNode(Function0<Unit> function0, String str, Function0<Unit> function02, Function0<Unit> function03, boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, boolean z3, String str2, Role role) {
        super(mutableInteractionSource, indicationNodeFactory, z2, z3, str2, role, function0, null);
        this.onLongClickLabel = str;
        this.onLongClick = function02;
        this.onDoubleClick = function03;
        this.hapticFeedbackEnabled = z;
        this.longKeyPressJobs = LongObjectMapKt.mutableLongObjectMapOf();
        this.doubleKeyClickStates = LongObjectMapKt.mutableLongObjectMapOf();
        this.isSuspendingPointerInputEnabled = !ComposeFoundationFlags.isNonSuspendingPointerInputInCombinedClickableEnabled;
        this.firstTapUpTime = -1L;
        this.indirectFirstTapUpTime = -1L;
    }

    public final boolean getHapticFeedbackEnabled() {
        return this.hapticFeedbackEnabled;
    }

    public final void setHapticFeedbackEnabled(boolean z) {
        this.hapticFeedbackEnabled = z;
    }

    /* compiled from: Clickable.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/CombinedClickableNode$DoubleKeyClickState;", "", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "doubleTapMinTimeMillisElapsed", "", "getDoubleTapMinTimeMillisElapsed", "()Z", "setDoubleTapMinTimeMillisElapsed", "(Z)V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DoubleKeyClickState {
        public static final int $stable = 8;
        private boolean doubleTapMinTimeMillisElapsed;
        private final Job job;

        public DoubleKeyClickState(Job job) {
            this.job = job;
        }

        public final Job getJob() {
            return this.job;
        }

        public final boolean getDoubleTapMinTimeMillisElapsed() {
            return this.doubleTapMinTimeMillisElapsed;
        }

        public final void setDoubleTapMinTimeMillisElapsed(boolean z) {
            this.doubleTapMinTimeMillisElapsed = z;
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded() {
        if (this.isSuspendingPointerInputEnabled) {
            return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new CombinedClickableNode$createPointerInputNodeIfNeeded$1(this));
        }
        return null;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo257onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        super.mo257onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        if (this.isSuspendingPointerInputEnabled) {
            return;
        }
        if (pointerEventPass == PointerEventPass.Main) {
            if (this.downEvent == null) {
                if (TapGestureDetectorKt.isChangedToDown$default(pointerEvent, true, false, 2, null)) {
                    handleDownEvent(pointerEvent.getChanges().get(0));
                    return;
                }
                return;
            }
            if (TapGestureDetector_androidKt.isDeepPress(pointerEvent)) {
                handleDeepPress();
            }
            if (this.longPressTriggered) {
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                for (int i = 0; i < size; i++) {
                    if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i))) {
                        List<PointerInputChange> changes2 = pointerEvent.getChanges();
                        int size2 = changes2.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            changes2.get(i2).consume();
                        }
                        return;
                    }
                }
                PointerInputChange pointerInputChange = pointerEvent.getChanges().get(0);
                pointerInputChange.consume();
                long uptimeMillis = pointerInputChange.getUptimeMillis();
                PointerInputChange pointerInputChange2 = this.downEvent;
                Intrinsics.checkNotNull(pointerInputChange2);
                handleUpEvent(uptimeMillis, pointerInputChange2);
                return;
            }
            List<PointerInputChange> changes3 = pointerEvent.getChanges();
            int size3 = changes3.size();
            for (int i3 = 0; i3 < size3; i3++) {
                if (!PointerEventKt.changedToUp(changes3.get(i3))) {
                    m339handleNonUpEventIfNeededO0kMr_c(pointerEvent, j);
                    return;
                }
            }
            PointerInputChange pointerInputChange3 = pointerEvent.getChanges().get(0);
            pointerInputChange3.consume();
            long uptimeMillis2 = pointerInputChange3.getUptimeMillis();
            PointerInputChange pointerInputChange4 = this.downEvent;
            Intrinsics.checkNotNull(pointerInputChange4);
            handleUpEvent(uptimeMillis2, pointerInputChange4);
        } else if (pointerEventPass == PointerEventPass.Final) {
            checkForCancellation(pointerEvent);
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onIndirectPointerEvent(IndirectPointerEvent indirectPointerEvent, PointerEventPass pointerEventPass) {
        boolean changedToUp;
        boolean changedToUpIgnoreConsumed;
        super.onIndirectPointerEvent(indirectPointerEvent, pointerEventPass);
        if (pointerEventPass == PointerEventPass.Main) {
            if (this.indirectDownEvent == null) {
                List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
                int size = changes.size();
                for (int i = 0; i < size; i++) {
                    if (IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(changes.get(i))) {
                        handleDownEvent(indirectPointerEvent.getChanges().get(0));
                        return;
                    }
                }
            } else if (this.indirectLongPressTriggered) {
                List<IndirectPointerInputChange> changes2 = indirectPointerEvent.getChanges();
                int size2 = changes2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    changedToUpIgnoreConsumed = ClickableKt.changedToUpIgnoreConsumed(changes2.get(i2));
                    if (!changedToUpIgnoreConsumed) {
                        List<IndirectPointerInputChange> changes3 = indirectPointerEvent.getChanges();
                        int size3 = changes3.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            changes3.get(i3).consume();
                        }
                        return;
                    }
                }
                IndirectPointerInputChange indirectPointerInputChange = indirectPointerEvent.getChanges().get(0);
                indirectPointerInputChange.consume();
                long uptimeMillis = indirectPointerInputChange.getUptimeMillis();
                IndirectPointerInputChange indirectPointerInputChange2 = this.indirectDownEvent;
                Intrinsics.checkNotNull(indirectPointerInputChange2);
                handleUpEvent(uptimeMillis, indirectPointerInputChange2);
            } else {
                List<IndirectPointerInputChange> changes4 = indirectPointerEvent.getChanges();
                int size4 = changes4.size();
                for (int i4 = 0; i4 < size4; i4++) {
                    changedToUp = ClickableKt.changedToUp(changes4.get(i4));
                    if (!changedToUp) {
                        handleNonUpEventIfNeeded(indirectPointerEvent);
                        return;
                    }
                }
                IndirectPointerInputChange indirectPointerInputChange3 = indirectPointerEvent.getChanges().get(0);
                indirectPointerInputChange3.consume();
                long uptimeMillis2 = indirectPointerInputChange3.getUptimeMillis();
                IndirectPointerInputChange indirectPointerInputChange4 = this.indirectDownEvent;
                Intrinsics.checkNotNull(indirectPointerInputChange4);
                handleUpEvent(uptimeMillis2, indirectPointerInputChange4);
            }
        } else if (pointerEventPass == PointerEventPass.Final) {
            checkForCancellation(indirectPointerEvent);
        }
    }

    private final void handleDownEvent(PointerInputChange pointerInputChange) {
        Job launch$default;
        pointerInputChange.consume();
        this.downEvent = pointerInputChange;
        if (getEnabled()) {
            Job job = this.tapJob;
            if (job != null && job.isActive()) {
                if (pointerInputChange.getUptimeMillis() - this.firstTapUpTime < ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getDoubleTapMinTimeMillis()) {
                    this.ignoreNextUp = true;
                    return;
                }
                this.isSecondTap = true;
                Job job2 = this.tapJob;
                if (job2 != null) {
                    Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                this.tapJob = null;
            }
            this.longPressTriggered = false;
            if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled) {
                handlePressInteractionStart(pointerInputChange);
            } else {
                m253handlePressInteractionStart3MmeM6k(pointerInputChange.m6685getPositionF1C5BW0(), false);
            }
            if (this.onLongClick != null) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$handleDownEvent$1(this, null), 3, null);
                this.longPressJob = launch$default;
            }
        }
    }

    private final void handleDownEvent(IndirectPointerInputChange indirectPointerInputChange) {
        Job launch$default;
        indirectPointerInputChange.consume();
        this.indirectDownEvent = indirectPointerInputChange;
        if (getEnabled()) {
            Job job = this.indirectTapJob;
            if (job != null && job.isActive()) {
                if (indirectPointerInputChange.getUptimeMillis() - this.indirectFirstTapUpTime < ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getDoubleTapMinTimeMillis()) {
                    this.indirectIgnoreNextUp = true;
                    return;
                }
                this.indirectIsSecondTap = true;
                Job job2 = this.indirectTapJob;
                if (job2 != null) {
                    Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                this.indirectTapJob = null;
            }
            this.indirectLongPressTriggered = false;
            if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled) {
                handlePressInteractionStart(indirectPointerInputChange);
            } else {
                m253handlePressInteractionStart3MmeM6k(indirectPointerInputChange.m6190getPositionF1C5BW0(), true);
            }
            if (this.onLongClick != null) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$handleDownEvent$2(this, null), 3, null);
                this.indirectLongPressJob = launch$default;
            }
        }
    }

    private final void handleUpEvent(long j, PointerInputChange pointerInputChange) {
        Job launch$default;
        if (getEnabled() && !this.ignoreNextUp) {
            m252handlePressInteractionRelease3MmeM6k(pointerInputChange.m6685getPositionF1C5BW0(), false);
            this.firstTapUpTime = j;
            if (!this.longPressTriggered) {
                boolean z = this.isSecondTap;
                Function0<Unit> function0 = this.onDoubleClick;
                if (z) {
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else if (function0 != null) {
                    launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$handleUpEvent$1(this, null), 3, null);
                    this.tapJob = launch$default;
                } else {
                    getOnClick().invoke();
                }
            }
        }
        this.downEvent = null;
        this.ignoreNextUp = false;
        this.isSecondTap = false;
        Job job = this.longPressJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.longPressJob = null;
        this.longPressTriggered = false;
    }

    private final void handleUpEvent(long j, IndirectPointerInputChange indirectPointerInputChange) {
        Job launch$default;
        if (getEnabled() && !this.indirectIgnoreNextUp) {
            m252handlePressInteractionRelease3MmeM6k(indirectPointerInputChange.m6190getPositionF1C5BW0(), true);
            this.indirectFirstTapUpTime = j;
            if (!this.indirectLongPressTriggered) {
                boolean z = this.indirectIsSecondTap;
                Function0<Unit> function0 = this.onDoubleClick;
                if (z) {
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else if (function0 != null) {
                    launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$handleUpEvent$2(this, null), 3, null);
                    this.indirectTapJob = launch$default;
                } else {
                    getOnClick().invoke();
                }
            }
        }
        this.indirectDownEvent = null;
        this.indirectIgnoreNextUp = false;
        this.indirectIsSecondTap = false;
        Job job = this.indirectLongPressJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.indirectLongPressJob = null;
        this.indirectLongPressTriggered = false;
    }

    /* renamed from: handleNonUpEventIfNeeded-O0kMr_c  reason: not valid java name */
    private final void m339handleNonUpEventIfNeededO0kMr_c(PointerEvent pointerEvent, long j) {
        long j2 = m250getExtendedTouchPaddinghWWAJMo(j);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (pointerInputChange.isConsumed() || PointerEventKt.m6621isOutOfBoundsjwHxaWs(pointerInputChange, j, j2)) {
                cancelInput(false);
                return;
            }
        }
    }

    private final void handleNonUpEventIfNeeded(IndirectPointerEvent indirectPointerEvent) {
        float touchSlop = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getTouchSlop();
        List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            IndirectPointerInputChange indirectPointerInputChange = changes.get(i);
            long m6190getPositionF1C5BW0 = indirectPointerInputChange.m6190getPositionF1C5BW0();
            IndirectPointerInputChange indirectPointerInputChange2 = this.indirectDownEvent;
            Intrinsics.checkNotNull(indirectPointerInputChange2);
            boolean z = Math.abs(Offset.m5101getDistanceimpl(Offset.m5107minusMKHz9U(m6190getPositionF1C5BW0, indirectPointerInputChange2.m6190getPositionF1C5BW0()))) > touchSlop;
            if (indirectPointerInputChange.isConsumed() || z) {
                cancelInput(true);
                return;
            }
        }
    }

    private final void handleDeepPress() {
        if (this.longPressTriggered || !getEnabled() || this.onLongClick == null) {
            return;
        }
        Job job = this.longPressJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.longPressJob = null;
        Function0<Unit> function0 = this.onLongClick;
        if (function0 != null) {
            function0.invoke();
        }
        if (this.hapticFeedbackEnabled) {
            ((HapticFeedback) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalHapticFeedback())).mo6117performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m6130getLongPress5zf0vsI());
        }
        this.longPressTriggered = true;
    }

    private final void checkForCancellation(PointerEvent pointerEvent) {
        if (this.downEvent == null || this.longPressTriggered) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (pointerInputChange.isConsumed() && !Intrinsics.areEqual(pointerInputChange, this.downEvent)) {
                cancelInput(false);
                return;
            }
        }
    }

    private final void checkForCancellation(IndirectPointerEvent indirectPointerEvent) {
        if (this.indirectDownEvent == null || this.indirectLongPressTriggered) {
            return;
        }
        List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            IndirectPointerInputChange indirectPointerInputChange = changes.get(i);
            if (indirectPointerInputChange.isConsumed() && !Intrinsics.areEqual(indirectPointerInputChange, this.indirectDownEvent)) {
                cancelInput(true);
                return;
            }
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        super.onCancelPointerInput();
        cancelInput(false);
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onCancelIndirectPointerInput() {
        cancelInput(true);
    }

    private final void cancelInput(boolean z) {
        if (z) {
            this.indirectDownEvent = null;
            Job job = this.indirectLongPressJob;
            if (job != null) {
                Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.indirectLongPressJob = null;
            Job job2 = this.indirectTapJob;
            if (job2 != null) {
                Job.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.indirectTapJob = null;
            this.indirectIsSecondTap = false;
            this.indirectLongPressTriggered = false;
            this.indirectFirstTapUpTime = -1L;
            this.indirectIgnoreNextUp = false;
        } else {
            this.downEvent = null;
            Job job3 = this.longPressJob;
            if (job3 != null) {
                Job.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            this.longPressJob = null;
            Job job4 = this.tapJob;
            if (job4 != null) {
                Job.cancel$default(job4, (CancellationException) null, 1, (Object) null);
            }
            this.tapJob = null;
            this.isSecondTap = false;
            this.longPressTriggered = false;
            this.firstTapUpTime = -1L;
            this.ignoreNextUp = false;
        }
        handlePressInteractionCancel(z);
    }

    /* renamed from: update-2tQrsxU  reason: not valid java name */
    public final void m340update2tQrsxU(Function0<Unit> function0, String str, Function0<Unit> function02, Function0<Unit> function03, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str2, Role role) {
        boolean z3;
        if (!Intrinsics.areEqual(this.onLongClickLabel, str)) {
            this.onLongClickLabel = str;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if ((this.onLongClick == null) != (function02 == null)) {
            disposeInteractions();
            SemanticsModifierNodeKt.invalidateSemantics(this);
            z3 = true;
        } else {
            z3 = false;
        }
        this.onLongClick = function02;
        if ((this.onDoubleClick == null) != (function03 == null)) {
            z3 = true;
        }
        this.onDoubleClick = function03;
        if (getEnabled() != z2) {
            z3 = true;
        }
        m259updateCommonO2vRcR0(mutableInteractionSource, indicationNodeFactory, z, z2, str2, role, function0);
        if (z3) {
            resetPointerInputHandler();
            cancelInput(false);
            cancelInput(true);
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (this.onLongClick != null) {
            SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.onLongClickLabel, new Function0() { // from class: androidx.compose.foundation.CombinedClickableNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(CombinedClickableNode.applyAdditionalSemantics$lambda$0(CombinedClickableNode.this));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean applyAdditionalSemantics$lambda$0(CombinedClickableNode combinedClickableNode) {
        Function0<Unit> function0 = combinedClickableNode.onLongClick;
        if (function0 != null) {
            function0.invoke();
            return true;
        }
        return true;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* renamed from: onClickKeyDownEvent-ZmokQxo */
    protected boolean mo254onClickKeyDownEventZmokQxo(KeyEvent keyEvent) {
        boolean z;
        Job launch$default;
        long m6517getKeyZmokQxo = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
        if (this.onLongClick == null || this.longKeyPressJobs.get(m6517getKeyZmokQxo) != null) {
            z = false;
        } else {
            MutableLongObjectMap<Job> mutableLongObjectMap = this.longKeyPressJobs;
            launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$onClickKeyDownEvent$1(this, null), 3, null);
            mutableLongObjectMap.set(m6517getKeyZmokQxo, launch$default);
            z = true;
        }
        DoubleKeyClickState doubleKeyClickState = this.doubleKeyClickStates.get(m6517getKeyZmokQxo);
        if (doubleKeyClickState != null) {
            if (doubleKeyClickState.getJob().isActive()) {
                Job.cancel$default(doubleKeyClickState.getJob(), (CancellationException) null, 1, (Object) null);
                if (!doubleKeyClickState.getDoubleTapMinTimeMillisElapsed()) {
                    getOnClick().invoke();
                    this.doubleKeyClickStates.remove(m6517getKeyZmokQxo);
                    return z;
                }
            } else {
                this.doubleKeyClickStates.remove(m6517getKeyZmokQxo);
            }
        }
        return z;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* renamed from: onClickKeyUpEvent-ZmokQxo */
    protected boolean mo255onClickKeyUpEventZmokQxo(KeyEvent keyEvent) {
        Function0<Unit> function0;
        Job launch$default;
        long m6517getKeyZmokQxo = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
        boolean z = false;
        if (this.longKeyPressJobs.get(m6517getKeyZmokQxo) != null) {
            Job job = this.longKeyPressJobs.get(m6517getKeyZmokQxo);
            if (job != null) {
                if (job.isActive()) {
                    Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
                } else {
                    z = true;
                }
            }
            this.longKeyPressJobs.remove(m6517getKeyZmokQxo);
        }
        if (this.onDoubleClick != null) {
            if (this.doubleKeyClickStates.get(m6517getKeyZmokQxo) != null) {
                if (!z && (function0 = this.onDoubleClick) != null) {
                    function0.invoke();
                }
                this.doubleKeyClickStates.remove(m6517getKeyZmokQxo);
            } else if (!z) {
                MutableLongObjectMap<DoubleKeyClickState> mutableLongObjectMap = this.doubleKeyClickStates;
                launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$onClickKeyUpEvent$2(this, m6517getKeyZmokQxo, null), 3, null);
                mutableLongObjectMap.set(m6517getKeyZmokQxo, new DoubleKeyClickState(launch$default));
            }
        } else if (!z) {
            getOnClick().invoke();
        }
        return true;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    protected void onCancelKeyInput() {
        resetKeyPressState();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        resetKeyPressState();
    }

    private final void resetKeyPressState() {
        long j;
        long j2;
        long j3;
        MutableLongObjectMap<Job> mutableLongObjectMap = this.longKeyPressJobs;
        MutableLongObjectMap<Job> mutableLongObjectMap2 = mutableLongObjectMap;
        Object[] objArr = mutableLongObjectMap2.values;
        long[] jArr = mutableLongObjectMap2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            j = 128;
            j2 = 255;
            while (true) {
                long j4 = jArr[i];
                j3 = -9187201950435737472L;
                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((j4 & 255) < 128) {
                            Job.cancel$default((Job) objArr[(i << 3) + i3], (CancellationException) null, 1, (Object) null);
                        }
                        j4 >>= 8;
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
        } else {
            j = 128;
            j2 = 255;
            j3 = -9187201950435737472L;
        }
        mutableLongObjectMap.clear();
        MutableLongObjectMap<DoubleKeyClickState> mutableLongObjectMap3 = this.doubleKeyClickStates;
        MutableLongObjectMap<DoubleKeyClickState> mutableLongObjectMap4 = mutableLongObjectMap3;
        Object[] objArr2 = mutableLongObjectMap4.values;
        long[] jArr2 = mutableLongObjectMap4.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i4 = 0;
            while (true) {
                long j5 = jArr2[i4];
                if ((((~j5) << 7) & j5 & j3) != j3) {
                    int i5 = 8 - ((~(i4 - length2)) >>> 31);
                    for (int i6 = 0; i6 < i5; i6++) {
                        if ((j5 & j2) < j) {
                            Job.cancel$default(((DoubleKeyClickState) objArr2[(i4 << 3) + i6]).getJob(), (CancellationException) null, 1, (Object) null);
                        }
                        j5 >>= 8;
                    }
                    if (i5 != 8) {
                        break;
                    }
                }
                if (i4 == length2) {
                    break;
                }
                i4++;
            }
        }
        mutableLongObjectMap3.clear();
    }
}
