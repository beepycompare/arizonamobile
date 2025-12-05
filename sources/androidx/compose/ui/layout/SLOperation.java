package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SubcomposeLayout.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0083@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/layout/SLOperation;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
final class SLOperation {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int CancelPausedPrecomposition = m6958constructorimpl(0);
    private static final int ReuseForceSyncDeactivation = m6958constructorimpl(1);
    private static final int ReuseScheduleOutOfFrameDeactivation = m6958constructorimpl(2);
    private static final int ReuseSyncDeactivation = m6958constructorimpl(3);
    private static final int ReuseDeactivationViaHost = m6958constructorimpl(4);
    private static final int TookFromPrecomposeMap = m6958constructorimpl(5);
    private static final int Subcompose = m6958constructorimpl(6);
    private static final int SubcomposeNew = m6958constructorimpl(7);
    private static final int SubcomposePausable = m6958constructorimpl(8);
    private static final int SubcomposeForceReuse = m6958constructorimpl(9);
    private static final int DeactivateOutOfFrame = m6958constructorimpl(10);
    private static final int DeactivateOutOfFrameCancelled = m6958constructorimpl(11);
    private static final int SlotToReusedFromOnDeactivate = m6958constructorimpl(12);
    private static final int SlotToReusedFromOnReuse = m6958constructorimpl(13);
    private static final int Reused = m6958constructorimpl(14);
    private static final int ResumePaused = m6958constructorimpl(15);
    private static final int PausePaused = m6958constructorimpl(16);
    private static final int ApplyPaused = m6958constructorimpl(17);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SLOperation m6957boximpl(int i) {
        return new SLOperation(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6958constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6959equalsimpl(int i, Object obj) {
        return (obj instanceof SLOperation) && i == ((SLOperation) obj).m6963unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6960equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6961hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6962toStringimpl(int i) {
        return "SLOperation(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m6959equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6961hashCodeimpl(this.value);
    }

    public String toString() {
        return m6962toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6963unboximpl() {
        return this.value;
    }

    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007R\u0013\u0010!\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b$\u0010\u0007R\u0013\u0010%\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b&\u0010\u0007R\u0013\u0010'\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b(\u0010\u0007R\u0013\u0010)\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b*\u0010\u0007¨\u0006+"}, d2 = {"Landroidx/compose/ui/layout/SLOperation$Companion;", "", "<init>", "()V", "CancelPausedPrecomposition", "Landroidx/compose/ui/layout/SLOperation;", "getCancelPausedPrecomposition-NjRlDlw", "()I", "I", "ReuseForceSyncDeactivation", "getReuseForceSyncDeactivation-NjRlDlw", "ReuseScheduleOutOfFrameDeactivation", "getReuseScheduleOutOfFrameDeactivation-NjRlDlw", "ReuseSyncDeactivation", "getReuseSyncDeactivation-NjRlDlw", "ReuseDeactivationViaHost", "getReuseDeactivationViaHost-NjRlDlw", "TookFromPrecomposeMap", "getTookFromPrecomposeMap-NjRlDlw", "Subcompose", "getSubcompose-NjRlDlw", "SubcomposeNew", "getSubcomposeNew-NjRlDlw", "SubcomposePausable", "getSubcomposePausable-NjRlDlw", "SubcomposeForceReuse", "getSubcomposeForceReuse-NjRlDlw", "DeactivateOutOfFrame", "getDeactivateOutOfFrame-NjRlDlw", "DeactivateOutOfFrameCancelled", "getDeactivateOutOfFrameCancelled-NjRlDlw", "SlotToReusedFromOnDeactivate", "getSlotToReusedFromOnDeactivate-NjRlDlw", "SlotToReusedFromOnReuse", "getSlotToReusedFromOnReuse-NjRlDlw", "Reused", "getReused-NjRlDlw", "ResumePaused", "getResumePaused-NjRlDlw", "PausePaused", "getPausePaused-NjRlDlw", "ApplyPaused", "getApplyPaused-NjRlDlw", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getCancelPausedPrecomposition-NjRlDlw  reason: not valid java name */
        public final int m6965getCancelPausedPrecompositionNjRlDlw() {
            return SLOperation.CancelPausedPrecomposition;
        }

        /* renamed from: getReuseForceSyncDeactivation-NjRlDlw  reason: not valid java name */
        public final int m6971getReuseForceSyncDeactivationNjRlDlw() {
            return SLOperation.ReuseForceSyncDeactivation;
        }

        /* renamed from: getReuseScheduleOutOfFrameDeactivation-NjRlDlw  reason: not valid java name */
        public final int m6972getReuseScheduleOutOfFrameDeactivationNjRlDlw() {
            return SLOperation.ReuseScheduleOutOfFrameDeactivation;
        }

        /* renamed from: getReuseSyncDeactivation-NjRlDlw  reason: not valid java name */
        public final int m6973getReuseSyncDeactivationNjRlDlw() {
            return SLOperation.ReuseSyncDeactivation;
        }

        /* renamed from: getReuseDeactivationViaHost-NjRlDlw  reason: not valid java name */
        public final int m6970getReuseDeactivationViaHostNjRlDlw() {
            return SLOperation.ReuseDeactivationViaHost;
        }

        /* renamed from: getTookFromPrecomposeMap-NjRlDlw  reason: not valid java name */
        public final int m6981getTookFromPrecomposeMapNjRlDlw() {
            return SLOperation.TookFromPrecomposeMap;
        }

        /* renamed from: getSubcompose-NjRlDlw  reason: not valid java name */
        public final int m6977getSubcomposeNjRlDlw() {
            return SLOperation.Subcompose;
        }

        /* renamed from: getSubcomposeNew-NjRlDlw  reason: not valid java name */
        public final int m6979getSubcomposeNewNjRlDlw() {
            return SLOperation.SubcomposeNew;
        }

        /* renamed from: getSubcomposePausable-NjRlDlw  reason: not valid java name */
        public final int m6980getSubcomposePausableNjRlDlw() {
            return SLOperation.SubcomposePausable;
        }

        /* renamed from: getSubcomposeForceReuse-NjRlDlw  reason: not valid java name */
        public final int m6978getSubcomposeForceReuseNjRlDlw() {
            return SLOperation.SubcomposeForceReuse;
        }

        /* renamed from: getDeactivateOutOfFrame-NjRlDlw  reason: not valid java name */
        public final int m6966getDeactivateOutOfFrameNjRlDlw() {
            return SLOperation.DeactivateOutOfFrame;
        }

        /* renamed from: getDeactivateOutOfFrameCancelled-NjRlDlw  reason: not valid java name */
        public final int m6967getDeactivateOutOfFrameCancelledNjRlDlw() {
            return SLOperation.DeactivateOutOfFrameCancelled;
        }

        /* renamed from: getSlotToReusedFromOnDeactivate-NjRlDlw  reason: not valid java name */
        public final int m6975getSlotToReusedFromOnDeactivateNjRlDlw() {
            return SLOperation.SlotToReusedFromOnDeactivate;
        }

        /* renamed from: getSlotToReusedFromOnReuse-NjRlDlw  reason: not valid java name */
        public final int m6976getSlotToReusedFromOnReuseNjRlDlw() {
            return SLOperation.SlotToReusedFromOnReuse;
        }

        /* renamed from: getReused-NjRlDlw  reason: not valid java name */
        public final int m6974getReusedNjRlDlw() {
            return SLOperation.Reused;
        }

        /* renamed from: getResumePaused-NjRlDlw  reason: not valid java name */
        public final int m6969getResumePausedNjRlDlw() {
            return SLOperation.ResumePaused;
        }

        /* renamed from: getPausePaused-NjRlDlw  reason: not valid java name */
        public final int m6968getPausePausedNjRlDlw() {
            return SLOperation.PausePaused;
        }

        /* renamed from: getApplyPaused-NjRlDlw  reason: not valid java name */
        public final int m6964getApplyPausedNjRlDlw() {
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
