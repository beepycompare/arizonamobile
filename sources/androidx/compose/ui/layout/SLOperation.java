package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SubcomposeLayout.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0083@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/layout/SLOperation;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
final class SLOperation {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int CancelPausedPrecomposition = m6901constructorimpl(0);
    private static final int ReuseForceSyncDeactivation = m6901constructorimpl(1);
    private static final int ReuseScheduleOutOfFrameDeactivation = m6901constructorimpl(2);
    private static final int ReuseSyncDeactivation = m6901constructorimpl(3);
    private static final int ReuseDeactivationViaHost = m6901constructorimpl(4);
    private static final int TookFromPrecomposeMap = m6901constructorimpl(5);
    private static final int Subcompose = m6901constructorimpl(6);
    private static final int SubcomposeNew = m6901constructorimpl(7);
    private static final int SubcomposePausable = m6901constructorimpl(8);
    private static final int SubcomposeForceReuse = m6901constructorimpl(9);
    private static final int DeactivateOutOfFrame = m6901constructorimpl(10);
    private static final int DeactivateOutOfFrameCancelled = m6901constructorimpl(11);
    private static final int SlotToReusedFromOnDeactivate = m6901constructorimpl(12);
    private static final int SlotToReusedFromOnReuse = m6901constructorimpl(13);
    private static final int Reused = m6901constructorimpl(14);
    private static final int ResumePaused = m6901constructorimpl(15);
    private static final int PausePaused = m6901constructorimpl(16);
    private static final int ApplyPaused = m6901constructorimpl(17);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SLOperation m6900boximpl(int i) {
        return new SLOperation(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6901constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6902equalsimpl(int i, Object obj) {
        return (obj instanceof SLOperation) && i == ((SLOperation) obj).m6906unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6903equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6904hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6905toStringimpl(int i) {
        return "SLOperation(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m6902equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6904hashCodeimpl(this.value);
    }

    public String toString() {
        return m6905toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6906unboximpl() {
        return this.value;
    }

    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007R\u0013\u0010!\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b$\u0010\u0007R\u0013\u0010%\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b&\u0010\u0007R\u0013\u0010'\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b(\u0010\u0007R\u0013\u0010)\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b*\u0010\u0007¨\u0006+"}, d2 = {"Landroidx/compose/ui/layout/SLOperation$Companion;", "", "<init>", "()V", "CancelPausedPrecomposition", "Landroidx/compose/ui/layout/SLOperation;", "getCancelPausedPrecomposition-NjRlDlw", "()I", "I", "ReuseForceSyncDeactivation", "getReuseForceSyncDeactivation-NjRlDlw", "ReuseScheduleOutOfFrameDeactivation", "getReuseScheduleOutOfFrameDeactivation-NjRlDlw", "ReuseSyncDeactivation", "getReuseSyncDeactivation-NjRlDlw", "ReuseDeactivationViaHost", "getReuseDeactivationViaHost-NjRlDlw", "TookFromPrecomposeMap", "getTookFromPrecomposeMap-NjRlDlw", "Subcompose", "getSubcompose-NjRlDlw", "SubcomposeNew", "getSubcomposeNew-NjRlDlw", "SubcomposePausable", "getSubcomposePausable-NjRlDlw", "SubcomposeForceReuse", "getSubcomposeForceReuse-NjRlDlw", "DeactivateOutOfFrame", "getDeactivateOutOfFrame-NjRlDlw", "DeactivateOutOfFrameCancelled", "getDeactivateOutOfFrameCancelled-NjRlDlw", "SlotToReusedFromOnDeactivate", "getSlotToReusedFromOnDeactivate-NjRlDlw", "SlotToReusedFromOnReuse", "getSlotToReusedFromOnReuse-NjRlDlw", "Reused", "getReused-NjRlDlw", "ResumePaused", "getResumePaused-NjRlDlw", "PausePaused", "getPausePaused-NjRlDlw", "ApplyPaused", "getApplyPaused-NjRlDlw", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getCancelPausedPrecomposition-NjRlDlw  reason: not valid java name */
        public final int m6908getCancelPausedPrecompositionNjRlDlw() {
            return SLOperation.CancelPausedPrecomposition;
        }

        /* renamed from: getReuseForceSyncDeactivation-NjRlDlw  reason: not valid java name */
        public final int m6914getReuseForceSyncDeactivationNjRlDlw() {
            return SLOperation.ReuseForceSyncDeactivation;
        }

        /* renamed from: getReuseScheduleOutOfFrameDeactivation-NjRlDlw  reason: not valid java name */
        public final int m6915getReuseScheduleOutOfFrameDeactivationNjRlDlw() {
            return SLOperation.ReuseScheduleOutOfFrameDeactivation;
        }

        /* renamed from: getReuseSyncDeactivation-NjRlDlw  reason: not valid java name */
        public final int m6916getReuseSyncDeactivationNjRlDlw() {
            return SLOperation.ReuseSyncDeactivation;
        }

        /* renamed from: getReuseDeactivationViaHost-NjRlDlw  reason: not valid java name */
        public final int m6913getReuseDeactivationViaHostNjRlDlw() {
            return SLOperation.ReuseDeactivationViaHost;
        }

        /* renamed from: getTookFromPrecomposeMap-NjRlDlw  reason: not valid java name */
        public final int m6924getTookFromPrecomposeMapNjRlDlw() {
            return SLOperation.TookFromPrecomposeMap;
        }

        /* renamed from: getSubcompose-NjRlDlw  reason: not valid java name */
        public final int m6920getSubcomposeNjRlDlw() {
            return SLOperation.Subcompose;
        }

        /* renamed from: getSubcomposeNew-NjRlDlw  reason: not valid java name */
        public final int m6922getSubcomposeNewNjRlDlw() {
            return SLOperation.SubcomposeNew;
        }

        /* renamed from: getSubcomposePausable-NjRlDlw  reason: not valid java name */
        public final int m6923getSubcomposePausableNjRlDlw() {
            return SLOperation.SubcomposePausable;
        }

        /* renamed from: getSubcomposeForceReuse-NjRlDlw  reason: not valid java name */
        public final int m6921getSubcomposeForceReuseNjRlDlw() {
            return SLOperation.SubcomposeForceReuse;
        }

        /* renamed from: getDeactivateOutOfFrame-NjRlDlw  reason: not valid java name */
        public final int m6909getDeactivateOutOfFrameNjRlDlw() {
            return SLOperation.DeactivateOutOfFrame;
        }

        /* renamed from: getDeactivateOutOfFrameCancelled-NjRlDlw  reason: not valid java name */
        public final int m6910getDeactivateOutOfFrameCancelledNjRlDlw() {
            return SLOperation.DeactivateOutOfFrameCancelled;
        }

        /* renamed from: getSlotToReusedFromOnDeactivate-NjRlDlw  reason: not valid java name */
        public final int m6918getSlotToReusedFromOnDeactivateNjRlDlw() {
            return SLOperation.SlotToReusedFromOnDeactivate;
        }

        /* renamed from: getSlotToReusedFromOnReuse-NjRlDlw  reason: not valid java name */
        public final int m6919getSlotToReusedFromOnReuseNjRlDlw() {
            return SLOperation.SlotToReusedFromOnReuse;
        }

        /* renamed from: getReused-NjRlDlw  reason: not valid java name */
        public final int m6917getReusedNjRlDlw() {
            return SLOperation.Reused;
        }

        /* renamed from: getResumePaused-NjRlDlw  reason: not valid java name */
        public final int m6912getResumePausedNjRlDlw() {
            return SLOperation.ResumePaused;
        }

        /* renamed from: getPausePaused-NjRlDlw  reason: not valid java name */
        public final int m6911getPausePausedNjRlDlw() {
            return SLOperation.PausePaused;
        }

        /* renamed from: getApplyPaused-NjRlDlw  reason: not valid java name */
        public final int m6907getApplyPausedNjRlDlw() {
            return SLOperation.ApplyPaused;
        }
    }

    private /* synthetic */ SLOperation(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
