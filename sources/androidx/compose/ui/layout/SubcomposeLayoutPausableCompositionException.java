package androidx.compose.ui.layout;

import androidx.collection.IntList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubcomposeLayout.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutPausableCompositionException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "operations", "Landroidx/collection/IntList;", "slotId", "", "cause", "", "<init>", "(Landroidx/collection/IntList;Ljava/lang/Object;Ljava/lang/Throwable;)V", "operationsList", "", "", "message", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SubcomposeLayoutPausableCompositionException extends IllegalStateException {
    private final IntList operations;
    private final Object slotId;

    public static /* synthetic */ void getMessage$annotations() {
    }

    public SubcomposeLayoutPausableCompositionException(IntList intList, Object obj, Throwable th) {
        super(th);
        this.operations = intList;
        this.slotId = obj;
    }

    private final List<String> operationsList() {
        String str;
        List createListBuilder = CollectionsKt.createListBuilder();
        for (int i = this.operations._size - 1; i >= 0; i--) {
            int i2 = this.operations.get(i);
            int m6901constructorimpl = SLOperation.m6901constructorimpl(i2);
            if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6908getCancelPausedPrecompositionNjRlDlw())) {
                str = "CancelPausedPrecomposition";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6914getReuseForceSyncDeactivationNjRlDlw())) {
                str = "ReuseForceSyncDeactivation";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6915getReuseScheduleOutOfFrameDeactivationNjRlDlw())) {
                str = "ReuseScheduleOutOfFrameDeactivation";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6916getReuseSyncDeactivationNjRlDlw())) {
                str = "ReuseSyncDeactivation";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6913getReuseDeactivationViaHostNjRlDlw())) {
                str = "ReuseDeactivationViaHost";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6924getTookFromPrecomposeMapNjRlDlw())) {
                str = "TookFromPrecomposeMap";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6920getSubcomposeNjRlDlw())) {
                str = "Subcompose";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6922getSubcomposeNewNjRlDlw())) {
                str = "SubcomposeNew";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6923getSubcomposePausableNjRlDlw())) {
                str = "SubcomposePausable";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6921getSubcomposeForceReuseNjRlDlw())) {
                str = "SubcomposeForceReuse";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6909getDeactivateOutOfFrameNjRlDlw())) {
                str = "DeactivateOutOfFrame";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6910getDeactivateOutOfFrameCancelledNjRlDlw())) {
                str = "DeactivateOutOfFrameCancelled";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6918getSlotToReusedFromOnDeactivateNjRlDlw())) {
                str = "SlotToReusedFromOnDeactivate";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6919getSlotToReusedFromOnReuseNjRlDlw())) {
                str = "SlotToReusedFromOnReuse";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6917getReusedNjRlDlw())) {
                str = "Reused";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6912getResumePausedNjRlDlw())) {
                str = "ResumePaused";
            } else if (SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6911getPausePausedNjRlDlw())) {
                str = "PausePaused";
            } else {
                str = SLOperation.m6903equalsimpl0(m6901constructorimpl, SLOperation.Companion.m6907getApplyPausedNjRlDlw()) ? "ApplyPaused" : "Unexpected " + i2;
            }
            createListBuilder.add(i + ": " + str);
        }
        return CollectionsKt.build(createListBuilder);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return StringsKt.trimMargin$default("\n            |slotid=" + this.slotId + ". Last operations:\n            |" + CollectionsKt.joinToString$default(operationsList(), "\n", null, null, 0, null, null, 62, null) + "\n            ", null, 1, null);
    }
}
