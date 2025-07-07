package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.paging.PagingDataEvent;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: AsyncPagingDataDiffer.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/paging/AsyncPagingDataDiffer$presenter$1", "Landroidx/paging/PagingDataPresenter;", "presentPagingDataEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/paging/PagingDataEvent;", "(Landroidx/paging/PagingDataEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AsyncPagingDataDiffer$presenter$1<T> extends PagingDataPresenter<T> {
    final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncPagingDataDiffer$presenter$1(AsyncPagingDataDiffer<T> asyncPagingDataDiffer, CoroutineContext coroutineContext) {
        super(coroutineContext, null, 2, null);
        this.this$0 = asyncPagingDataDiffer;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    @Override // androidx.paging.PagingDataPresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object presentPagingDataEvent(PagingDataEvent<T> pagingDataEvent, Continuation<? super Unit> continuation) {
        AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1 asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1;
        int i;
        ListUpdateCallback listUpdateCallback;
        ListUpdateCallback listUpdateCallback2;
        ListUpdateCallback listUpdateCallback3;
        ListUpdateCallback listUpdateCallback4;
        ListUpdateCallback listUpdateCallback5;
        ListUpdateCallback listUpdateCallback6;
        ListUpdateCallback listUpdateCallback7;
        ListUpdateCallback listUpdateCallback8;
        ListUpdateCallback listUpdateCallback9;
        ListUpdateCallback listUpdateCallback10;
        ListUpdateCallback listUpdateCallback11;
        ListUpdateCallback listUpdateCallback12;
        ListUpdateCallback listUpdateCallback13;
        ListUpdateCallback listUpdateCallback14;
        AtomicReference atomicReference;
        AsyncPagingDataDiffer<T> asyncPagingDataDiffer;
        CoroutineContext coroutineContext;
        AsyncPagingDataDiffer$presenter$1<T> asyncPagingDataDiffer$presenter$1;
        PagingDataEvent.Refresh refresh;
        ListUpdateCallback listUpdateCallback15;
        ListUpdateCallback listUpdateCallback16;
        AtomicReference atomicReference2;
        AtomicReference atomicReference3;
        ListUpdateCallback listUpdateCallback17;
        int i2;
        if (continuation instanceof AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1) {
            asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1 = (AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1) continuation;
            if ((asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.label & Integer.MIN_VALUE) != 0) {
                asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.label -= Integer.MIN_VALUE;
                Object obj = asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (pagingDataEvent instanceof PagingDataEvent.Refresh) {
                        AsyncPagingDataDiffer<T> asyncPagingDataDiffer2 = this.this$0;
                        PagingDataEvent.Refresh refresh2 = (PagingDataEvent.Refresh) pagingDataEvent;
                        if (refresh2.getPreviousList().getSize() == 0) {
                            if (refresh2.getNewList().getSize() > 0) {
                                listUpdateCallback16 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer2).updateCallback;
                                listUpdateCallback16.onInserted(0, refresh2.getNewList().getSize());
                            }
                        } else if (refresh2.getNewList().getSize() != 0) {
                            atomicReference = ((AsyncPagingDataDiffer) asyncPagingDataDiffer2).previousPresenter;
                            atomicReference.set(refresh2.getPreviousList());
                            try {
                                coroutineContext = ((AsyncPagingDataDiffer) asyncPagingDataDiffer2).workerDispatcher;
                                asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.L$0 = this;
                                asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.L$1 = pagingDataEvent;
                                asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.L$2 = asyncPagingDataDiffer2;
                                asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.L$3 = refresh2;
                                asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.label = 1;
                                Object withContext = BuildersKt.withContext(coroutineContext, new AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1(refresh2, asyncPagingDataDiffer2, null), asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1);
                                if (withContext == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                asyncPagingDataDiffer$presenter$1 = this;
                                asyncPagingDataDiffer = asyncPagingDataDiffer2;
                                obj = withContext;
                                refresh = refresh2;
                            } catch (Throwable th) {
                                th = th;
                                asyncPagingDataDiffer = asyncPagingDataDiffer2;
                                atomicReference2 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer).previousPresenter;
                                atomicReference2.set(null);
                                throw th;
                            }
                        } else if (refresh2.getPreviousList().getSize() > 0) {
                            listUpdateCallback15 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer2).updateCallback;
                            listUpdateCallback15.onRemoved(0, refresh2.getPreviousList().getSize());
                        }
                    } else if (pagingDataEvent instanceof PagingDataEvent.Prepend) {
                        AsyncPagingDataDiffer<T> asyncPagingDataDiffer3 = this.this$0;
                        PagingDataEvent.Prepend prepend = (PagingDataEvent.Prepend) pagingDataEvent;
                        int size = prepend.getInserted().size();
                        int min = Math.min(prepend.getOldPlaceholdersBefore(), size);
                        int oldPlaceholdersBefore = prepend.getOldPlaceholdersBefore() - min;
                        int i3 = size - min;
                        if (min > 0) {
                            listUpdateCallback14 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer3).updateCallback;
                            listUpdateCallback14.onChanged(oldPlaceholdersBefore, min, null);
                        }
                        if (i3 > 0) {
                            listUpdateCallback13 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer3).updateCallback;
                            listUpdateCallback13.onInserted(0, i3);
                        }
                        int newPlaceholdersBefore = (prepend.getNewPlaceholdersBefore() - prepend.getOldPlaceholdersBefore()) + min;
                        if (newPlaceholdersBefore > 0) {
                            listUpdateCallback12 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer3).updateCallback;
                            listUpdateCallback12.onInserted(0, newPlaceholdersBefore);
                        } else if (newPlaceholdersBefore < 0) {
                            listUpdateCallback11 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer3).updateCallback;
                            listUpdateCallback11.onRemoved(0, -newPlaceholdersBefore);
                        }
                    } else if (pagingDataEvent instanceof PagingDataEvent.Append) {
                        AsyncPagingDataDiffer<T> asyncPagingDataDiffer4 = this.this$0;
                        PagingDataEvent.Append append = (PagingDataEvent.Append) pagingDataEvent;
                        int size2 = append.getInserted().size();
                        int min2 = Math.min(append.getOldPlaceholdersAfter(), size2);
                        int startIndex = append.getStartIndex();
                        int i4 = size2 - min2;
                        int i5 = startIndex + min2;
                        if (min2 > 0) {
                            listUpdateCallback10 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer4).updateCallback;
                            listUpdateCallback10.onChanged(startIndex, min2, null);
                        }
                        if (i4 > 0) {
                            listUpdateCallback9 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer4).updateCallback;
                            listUpdateCallback9.onInserted(i5, i4);
                        }
                        int newPlaceholdersAfter = (append.getNewPlaceholdersAfter() - append.getOldPlaceholdersAfter()) + min2;
                        int startIndex2 = append.getStartIndex() + size2 + append.getNewPlaceholdersAfter();
                        if (newPlaceholdersAfter > 0) {
                            listUpdateCallback8 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer4).updateCallback;
                            listUpdateCallback8.onInserted(startIndex2 - newPlaceholdersAfter, newPlaceholdersAfter);
                        } else if (newPlaceholdersAfter < 0) {
                            listUpdateCallback7 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer4).updateCallback;
                            listUpdateCallback7.onRemoved(startIndex2, -newPlaceholdersAfter);
                        }
                    } else if (pagingDataEvent instanceof PagingDataEvent.DropPrepend) {
                        AsyncPagingDataDiffer<T> asyncPagingDataDiffer5 = this.this$0;
                        PagingDataEvent.DropPrepend dropPrepend = (PagingDataEvent.DropPrepend) pagingDataEvent;
                        int newPlaceholdersBefore2 = (dropPrepend.getNewPlaceholdersBefore() - dropPrepend.getDropCount()) - dropPrepend.getOldPlaceholdersBefore();
                        if (newPlaceholdersBefore2 > 0) {
                            listUpdateCallback6 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer5).updateCallback;
                            listUpdateCallback6.onInserted(0, newPlaceholdersBefore2);
                        } else if (newPlaceholdersBefore2 < 0) {
                            listUpdateCallback4 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer5).updateCallback;
                            listUpdateCallback4.onRemoved(0, -newPlaceholdersBefore2);
                        }
                        int max = Math.max(0, dropPrepend.getOldPlaceholdersBefore() + newPlaceholdersBefore2);
                        int newPlaceholdersBefore3 = dropPrepend.getNewPlaceholdersBefore() - max;
                        if (newPlaceholdersBefore3 > 0) {
                            listUpdateCallback5 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer5).updateCallback;
                            listUpdateCallback5.onChanged(max, newPlaceholdersBefore3, null);
                        }
                    } else if (pagingDataEvent instanceof PagingDataEvent.DropAppend) {
                        AsyncPagingDataDiffer<T> asyncPagingDataDiffer6 = this.this$0;
                        PagingDataEvent.DropAppend dropAppend = (PagingDataEvent.DropAppend) pagingDataEvent;
                        int newPlaceholdersAfter2 = (dropAppend.getNewPlaceholdersAfter() - dropAppend.getDropCount()) - dropAppend.getOldPlaceholdersAfter();
                        int startIndex3 = dropAppend.getStartIndex() + dropAppend.getNewPlaceholdersAfter();
                        if (newPlaceholdersAfter2 > 0) {
                            listUpdateCallback3 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer6).updateCallback;
                            listUpdateCallback3.onInserted(startIndex3 - newPlaceholdersAfter2, newPlaceholdersAfter2);
                        } else if (newPlaceholdersAfter2 < 0) {
                            listUpdateCallback = ((AsyncPagingDataDiffer) asyncPagingDataDiffer6).updateCallback;
                            listUpdateCallback.onRemoved(startIndex3, -newPlaceholdersAfter2);
                        }
                        int newPlaceholdersAfter3 = (dropAppend.getNewPlaceholdersAfter() - dropAppend.getOldPlaceholdersAfter()) + (newPlaceholdersAfter2 < 0 ? Math.min(dropAppend.getOldPlaceholdersAfter(), -newPlaceholdersAfter2) : 0);
                        if (newPlaceholdersAfter3 > 0) {
                            listUpdateCallback2 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer6).updateCallback;
                            listUpdateCallback2.onChanged(dropAppend.getStartIndex(), newPlaceholdersAfter3, null);
                        }
                    }
                    return Unit.INSTANCE;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    refresh = (PagingDataEvent.Refresh) asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.L$3;
                    asyncPagingDataDiffer = (AsyncPagingDataDiffer) asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.L$2;
                    PagingDataEvent pagingDataEvent2 = (PagingDataEvent) asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.L$1;
                    asyncPagingDataDiffer$presenter$1 = (AsyncPagingDataDiffer$presenter$1) asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        atomicReference2 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer).previousPresenter;
                        atomicReference2.set(null);
                        throw th;
                    }
                }
                PlaceholderPaddedDiffResult placeholderPaddedDiffResult = (PlaceholderPaddedDiffResult) obj;
                atomicReference3 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer).previousPresenter;
                atomicReference3.set(null);
                PlaceholderPaddedList<T> previousList = refresh.getPreviousList();
                listUpdateCallback17 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer).updateCallback;
                PlaceholderPaddedListDiffHelperKt.dispatchDiff(previousList, listUpdateCallback17, refresh.getNewList(), placeholderPaddedDiffResult);
                PlaceholderPaddedList<T> previousList2 = refresh.getPreviousList();
                PlaceholderPaddedList<T> newList = refresh.getNewList();
                i2 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer).lastAccessedIndex;
                int transformAnchorIndex = PlaceholderPaddedListDiffHelperKt.transformAnchorIndex(previousList2, placeholderPaddedDiffResult, newList, i2);
                ((AsyncPagingDataDiffer) asyncPagingDataDiffer).lastAccessedIndex = transformAnchorIndex;
                asyncPagingDataDiffer$presenter$1.get(transformAnchorIndex);
                return Unit.INSTANCE;
            }
        }
        asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1 = new AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1(this, continuation);
        Object obj2 = asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = asyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1.label;
        if (i != 0) {
        }
        PlaceholderPaddedDiffResult placeholderPaddedDiffResult2 = (PlaceholderPaddedDiffResult) obj2;
        atomicReference3 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer).previousPresenter;
        atomicReference3.set(null);
        PlaceholderPaddedList<T> previousList3 = refresh.getPreviousList();
        listUpdateCallback17 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer).updateCallback;
        PlaceholderPaddedListDiffHelperKt.dispatchDiff(previousList3, listUpdateCallback17, refresh.getNewList(), placeholderPaddedDiffResult2);
        PlaceholderPaddedList<T> previousList22 = refresh.getPreviousList();
        PlaceholderPaddedList<T> newList2 = refresh.getNewList();
        i2 = ((AsyncPagingDataDiffer) asyncPagingDataDiffer).lastAccessedIndex;
        int transformAnchorIndex2 = PlaceholderPaddedListDiffHelperKt.transformAnchorIndex(previousList22, placeholderPaddedDiffResult2, newList2, i2);
        ((AsyncPagingDataDiffer) asyncPagingDataDiffer).lastAccessedIndex = transformAnchorIndex2;
        asyncPagingDataDiffer$presenter$1.get(transformAnchorIndex2);
        return Unit.INSTANCE;
    }
}
