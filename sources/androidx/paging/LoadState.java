package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LoadState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Landroidx/paging/LoadState;", "", "endOfPaginationReached", "", "<init>", "(Z)V", "getEndOfPaginationReached", "()Z", "NotLoading", "Loading", "Error", "Landroidx/paging/LoadState$Error;", "Landroidx/paging/LoadState$Loading;", "Landroidx/paging/LoadState$NotLoading;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class LoadState {
    private final boolean endOfPaginationReached;

    public /* synthetic */ LoadState(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    private LoadState(boolean z) {
        this.endOfPaginationReached = z;
    }

    public final boolean getEndOfPaginationReached() {
        return this.endOfPaginationReached;
    }

    /* compiled from: LoadState.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Landroidx/paging/LoadState$NotLoading;", "Landroidx/paging/LoadState;", "endOfPaginationReached", "", "<init>", "(Z)V", "toString", "", "equals", "other", "", "hashCode", "", "Companion", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class NotLoading extends LoadState {
        public static final Companion Companion = new Companion(null);
        private static final NotLoading Complete = new NotLoading(true);
        private static final NotLoading Incomplete = new NotLoading(false);

        public NotLoading(boolean z) {
            super(z, null);
        }

        public String toString() {
            return "NotLoading(endOfPaginationReached=" + getEndOfPaginationReached() + ')';
        }

        public boolean equals(Object obj) {
            return (obj instanceof NotLoading) && getEndOfPaginationReached() == ((NotLoading) obj).getEndOfPaginationReached();
        }

        public int hashCode() {
            return Boolean.hashCode(getEndOfPaginationReached());
        }

        /* compiled from: LoadState.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/paging/LoadState$NotLoading$Companion;", "", "<init>", "()V", "Complete", "Landroidx/paging/LoadState$NotLoading;", "getComplete$paging_common", "()Landroidx/paging/LoadState$NotLoading;", "Incomplete", "getIncomplete$paging_common", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final NotLoading getComplete$paging_common() {
                return NotLoading.Complete;
            }

            public final NotLoading getIncomplete$paging_common() {
                return NotLoading.Incomplete;
            }
        }
    }

    /* compiled from: LoadState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/paging/LoadState$Loading;", "Landroidx/paging/LoadState;", "<init>", "()V", "toString", "", "equals", "", "other", "", "hashCode", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Loading extends LoadState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(false, null);
        }

        public String toString() {
            return "Loading(endOfPaginationReached=" + getEndOfPaginationReached() + ')';
        }

        public boolean equals(Object obj) {
            return (obj instanceof Loading) && getEndOfPaginationReached() == ((Loading) obj).getEndOfPaginationReached();
        }

        public int hashCode() {
            return Boolean.hashCode(getEndOfPaginationReached());
        }
    }

    /* compiled from: LoadState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/paging/LoadState$Error;", "Landroidx/paging/LoadState;", "error", "", "<init>", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "equals", "", "other", "", "hashCode", "", "toString", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Error extends LoadState {
        private final Throwable error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable error) {
            super(false, null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final Throwable getError() {
            return this.error;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Error) {
                Error error = (Error) obj;
                return getEndOfPaginationReached() == error.getEndOfPaginationReached() && Intrinsics.areEqual(this.error, error.error);
            }
            return false;
        }

        public int hashCode() {
            return Boolean.hashCode(getEndOfPaginationReached()) + this.error.hashCode();
        }

        public String toString() {
            return "Error(endOfPaginationReached=" + getEndOfPaginationReached() + ", error=" + this.error + ')';
        }
    }
}
