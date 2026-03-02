package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SnapshotPagedList.jvmAndAndroid.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Landroidx/paging/SnapshotPagedList;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PagedList;", "pagedList", "<init>", "(Landroidx/paging/PagedList;)V", "isImmutable", "", "()Z", "lastKey", "getLastKey", "()Ljava/lang/Object;", "isDetached", "detach", "", "dispatchCurrentLoadState", "callback", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "loadAroundInternal", FirebaseAnalytics.Param.INDEX, "", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SnapshotPagedList<T> extends PagedList<T> {
    private final boolean isDetached;
    private final boolean isImmutable;
    private final PagedList<T> pagedList;

    @Override // androidx.paging.PagedList
    public void detach() {
    }

    @Override // androidx.paging.PagedList
    public void dispatchCurrentLoadState(Function2<? super LoadType, ? super LoadState, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // androidx.paging.PagedList
    public void loadAroundInternal(int i) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotPagedList(PagedList<T> pagedList) {
        super(pagedList.getPagingSource(), pagedList.getCoroutineScope$paging_common(), pagedList.getNotifyDispatcher$paging_common(), pagedList.getStorage$paging_common().snapshot(), pagedList.getConfig());
        Intrinsics.checkNotNullParameter(pagedList, "pagedList");
        this.pagedList = pagedList;
        this.isImmutable = true;
        this.isDetached = true;
    }

    @Override // androidx.paging.PagedList
    public boolean isImmutable() {
        return this.isImmutable;
    }

    @Override // androidx.paging.PagedList
    public Object getLastKey() {
        return this.pagedList.getLastKey();
    }

    @Override // androidx.paging.PagedList
    public boolean isDetached() {
        return this.isDetached;
    }
}
