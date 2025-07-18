package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: PagingLiveData.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u0001\"\b\b\u0000\u0010\n*\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u001a4\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u0001\"\b\b\u0000\u0010\n*\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e\u001a4\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u0001\"\b\b\u0000\u0010\n*\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\"A\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\b\b\u0001\u0010\u0003*\u00020\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"liveData", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Value", "Key", "", "Landroidx/paging/Pager;", "getLiveData", "(Landroidx/paging/Pager;)Landroidx/lifecycle/LiveData;", "cachedIn", ExifInterface.GPS_DIRECTION_TRUE, "lifecycle", "Landroidx/lifecycle/Lifecycle;", "viewModel", "Landroidx/lifecycle/ViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "paging-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingLiveData {
    public static final <Key, Value> LiveData<PagingData<Value>> getLiveData(Pager<Key, Value> pager) {
        Intrinsics.checkNotNullParameter(pager, "<this>");
        return FlowLiveDataConversions.asLiveData$default(pager.getFlow(), (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> liveData, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(liveData), LifecycleKt.getCoroutineScope(lifecycle)), (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> liveData, ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(liveData), ViewModelKt.getViewModelScope(viewModel)), (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> liveData, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(liveData), scope), (CoroutineContext) null, 0L, 3, (Object) null);
    }
}
