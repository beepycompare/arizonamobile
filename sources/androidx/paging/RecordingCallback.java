package androidx.paging;

import androidx.paging.PagedList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
/* compiled from: RecordingCallback.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/paging/RecordingCallback;", "Landroidx/paging/PagedList$Callback;", "()V", "list", "", "", "dispatchRecordingTo", "", "other", "onChanged", "position", "count", "onInserted", "onRemoved", "Companion", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecordingCallback extends PagedList.Callback {
    private static final int Changed = 0;
    public static final Companion Companion = new Companion(null);
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private final List<Integer> list = new ArrayList();

    @Override // androidx.paging.PagedList.Callback
    public void onChanged(int i, int i2) {
        this.list.add(0);
        this.list.add(Integer.valueOf(i));
        this.list.add(Integer.valueOf(i2));
    }

    @Override // androidx.paging.PagedList.Callback
    public void onInserted(int i, int i2) {
        this.list.add(1);
        this.list.add(Integer.valueOf(i));
        this.list.add(Integer.valueOf(i2));
    }

    @Override // androidx.paging.PagedList.Callback
    public void onRemoved(int i, int i2) {
        this.list.add(2);
        this.list.add(Integer.valueOf(i));
        this.list.add(Integer.valueOf(i2));
    }

    public final void dispatchRecordingTo(PagedList.Callback other) {
        Intrinsics.checkNotNullParameter(other, "other");
        IntProgression step = RangesKt.step(RangesKt.until(0, this.list.size()), 3);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                int intValue = this.list.get(first).intValue();
                if (intValue == 0) {
                    other.onChanged(this.list.get(first + 1).intValue(), this.list.get(first + 2).intValue());
                } else if (intValue == 1) {
                    other.onInserted(this.list.get(first + 1).intValue(), this.list.get(first + 2).intValue());
                } else if (intValue == 2) {
                    other.onRemoved(this.list.get(first + 1).intValue(), this.list.get(first + 2).intValue());
                } else {
                    throw new IllegalStateException("Unexpected recording value");
                }
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        this.list.clear();
    }

    /* compiled from: RecordingCallback.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/paging/RecordingCallback$Companion;", "", "()V", "Changed", "", "Inserted", "Removed", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
