package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PageEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CachedPageEventFlow.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bJ \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e0\rH\u0086@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eH\u0086@¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/paging/FlattenedPageController;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "list", "Landroidx/paging/FlattenedPageEventStorage;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "maxEventIndex", "", "getCachedEvent", "Landroidx/paging/PageEvent$Insert;", "getStateAsEvents", "", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "record", "", NotificationCompat.CATEGORY_EVENT, "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FlattenedPageController<T> {
    private final FlattenedPageEventStorage<T> list = new FlattenedPageEventStorage<>();
    private final Mutex lock = MutexKt.Mutex$default(false, 1, null);
    private int maxEventIndex = -1;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object record(IndexedValue<? extends PageEvent<T>> indexedValue, Continuation<? super Unit> continuation) {
        FlattenedPageController$record$1 flattenedPageController$record$1;
        int i;
        Mutex mutex;
        FlattenedPageController<T> flattenedPageController;
        try {
            if (continuation instanceof FlattenedPageController$record$1) {
                flattenedPageController$record$1 = (FlattenedPageController$record$1) continuation;
                if ((flattenedPageController$record$1.label & Integer.MIN_VALUE) != 0) {
                    flattenedPageController$record$1.label -= Integer.MIN_VALUE;
                    Object obj = flattenedPageController$record$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flattenedPageController$record$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.lock;
                        flattenedPageController$record$1.L$0 = this;
                        flattenedPageController$record$1.L$1 = indexedValue;
                        flattenedPageController$record$1.L$2 = mutex;
                        flattenedPageController$record$1.label = 1;
                        if (mutex.lock(null, flattenedPageController$record$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flattenedPageController = this;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        flattenedPageController = (FlattenedPageController) flattenedPageController$record$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = (Mutex) flattenedPageController$record$1.L$2;
                        indexedValue = (IndexedValue) flattenedPageController$record$1.L$1;
                    }
                    flattenedPageController.maxEventIndex = indexedValue.getIndex();
                    flattenedPageController.list.add(indexedValue.getValue());
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            flattenedPageController.maxEventIndex = indexedValue.getIndex();
            flattenedPageController.list.add(indexedValue.getValue());
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
        flattenedPageController$record$1 = new FlattenedPageController$record$1(this, continuation);
        Object obj2 = flattenedPageController$record$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flattenedPageController$record$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077 A[Catch: all -> 0x0095, TryCatch #0 {all -> 0x0095, blocks: (B:18:0x004f, B:19:0x0071, B:21:0x0077, B:23:0x007f, B:24:0x0082, B:25:0x008f), top: B:31:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getStateAsEvents(Continuation<? super List<? extends IndexedValue<? extends PageEvent<T>>>> continuation) {
        FlattenedPageController$getStateAsEvents$1 flattenedPageController$getStateAsEvents$1;
        int i;
        FlattenedPageController<T> flattenedPageController;
        Mutex mutex;
        try {
            if (continuation instanceof FlattenedPageController$getStateAsEvents$1) {
                flattenedPageController$getStateAsEvents$1 = (FlattenedPageController$getStateAsEvents$1) continuation;
                if ((flattenedPageController$getStateAsEvents$1.label & Integer.MIN_VALUE) != 0) {
                    flattenedPageController$getStateAsEvents$1.label -= Integer.MIN_VALUE;
                    Object obj = flattenedPageController$getStateAsEvents$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flattenedPageController$getStateAsEvents$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex2 = this.lock;
                        flattenedPageController$getStateAsEvents$1.L$0 = this;
                        flattenedPageController$getStateAsEvents$1.L$1 = mutex2;
                        flattenedPageController$getStateAsEvents$1.label = 1;
                        if (mutex2.lock(null, flattenedPageController$getStateAsEvents$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flattenedPageController = this;
                        mutex = mutex2;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        mutex = (Mutex) flattenedPageController$getStateAsEvents$1.L$1;
                        flattenedPageController = (FlattenedPageController) flattenedPageController$getStateAsEvents$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    List<PageEvent<T>> asEvents = flattenedPageController.list.getAsEvents();
                    int size = (flattenedPageController.maxEventIndex - asEvents.size()) + 1;
                    List<PageEvent<T>> list = asEvents;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    int i2 = 0;
                    for (T t : list) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        arrayList.add(new IndexedValue(i2 + size, (PageEvent) t));
                        i2 = i3;
                    }
                    return arrayList;
                }
            }
            List<PageEvent<T>> asEvents2 = flattenedPageController.list.getAsEvents();
            int size2 = (flattenedPageController.maxEventIndex - asEvents2.size()) + 1;
            List<PageEvent<T>> list2 = asEvents2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            int i22 = 0;
            while (r9.hasNext()) {
            }
            return arrayList2;
        } finally {
            mutex.unlock(null);
        }
        flattenedPageController$getStateAsEvents$1 = new FlattenedPageController$getStateAsEvents$1(this, continuation);
        Object obj2 = flattenedPageController$getStateAsEvents$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flattenedPageController$getStateAsEvents$1.label;
        if (i != 0) {
        }
    }

    public final PageEvent.Insert<T> getCachedEvent() {
        PageEvent pageEvent = (PageEvent) CollectionsKt.firstOrNull((List<? extends Object>) this.list.getAsEvents());
        if (pageEvent != null && (pageEvent instanceof PageEvent.Insert)) {
            PageEvent.Insert<T> insert = (PageEvent.Insert) pageEvent;
            if (insert.getLoadType() == LoadType.REFRESH) {
                return insert;
            }
        }
        return null;
    }
}
