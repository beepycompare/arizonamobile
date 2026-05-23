package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PagingSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PagingState.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B=\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0015\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u001aJ8\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00020\b2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00160\u001d¢\u0006\u0002\u0010!J\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\u0016J\r\u0010$\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010%J\r\u0010&\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010%J\b\u0010'\u001a\u00020(H\u0016JY\u0010)\u001a\u0002H*\"\u0004\b\u0002\u0010*2\u0006\u0010\u0007\u001a\u00020\b26\u0010+\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H*0,H\u0080\bø\u0001\u0000¢\u0006\u0004\b/\u00100R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00061"}, d2 = {"Landroidx/paging/PagingState;", "Key", "", "Value", "pages", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "anchorPosition", "", "config", "Landroidx/paging/PagingConfig;", "leadingPlaceholderCount", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Landroidx/paging/PagingConfig;I)V", "getPages", "()Ljava/util/List;", "getAnchorPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConfig", "()Landroidx/paging/PagingConfig;", "equals", "", "other", "hashCode", "closestItemToPosition", "(I)Ljava/lang/Object;", "closestItemAroundPosition", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "closestPageToPosition", "isEmpty", "firstItemOrNull", "()Ljava/lang/Object;", "lastItemOrNull", "toString", "", "anchorPositionToPagedIndices", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "pageIndex", FirebaseAnalytics.Param.INDEX, "anchorPositionToPagedIndices$paging_common", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingState<Key, Value> {
    private final Integer anchorPosition;
    private final PagingConfig config;
    private final int leadingPlaceholderCount;
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;

    public PagingState(List<PagingSource.LoadResult.Page<Key, Value>> pages, Integer num, PagingConfig config, int i) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(config, "config");
        this.pages = pages;
        this.anchorPosition = num;
        this.config = config;
        this.leadingPlaceholderCount = i;
    }

    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages() {
        return this.pages;
    }

    public final Integer getAnchorPosition() {
        return this.anchorPosition;
    }

    public final PagingConfig getConfig() {
        return this.config;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PagingState) {
            PagingState pagingState = (PagingState) obj;
            return Intrinsics.areEqual(this.pages, pagingState.pages) && Intrinsics.areEqual(this.anchorPosition, pagingState.anchorPosition) && Intrinsics.areEqual(this.config, pagingState.config) && this.leadingPlaceholderCount == pagingState.leadingPlaceholderCount;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.pages.hashCode();
        Integer num = this.anchorPosition;
        return hashCode + (num != null ? num.hashCode() : 0) + this.config.hashCode() + Integer.hashCode(this.leadingPlaceholderCount);
    }

    public final Value closestItemToPosition(int i) {
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                int i2 = i - this.leadingPlaceholderCount;
                int i3 = 0;
                while (i3 < CollectionsKt.getLastIndex(getPages()) && i2 > CollectionsKt.getLastIndex(getPages().get(i3).getData())) {
                    i2 -= getPages().get(i3).getData().size();
                    i3++;
                }
                Iterator<T> it2 = this.pages.iterator();
                while (it2.hasNext()) {
                    PagingSource.LoadResult.Page page = (PagingSource.LoadResult.Page) it2.next();
                    if (!page.getData().isEmpty()) {
                        List<PagingSource.LoadResult.Page<Key, Value>> list2 = this.pages;
                        ListIterator<PagingSource.LoadResult.Page<Key, Value>> listIterator = list2.listIterator(list2.size());
                        while (listIterator.hasPrevious()) {
                            PagingSource.LoadResult.Page<Key, Value> previous = listIterator.previous();
                            if (!previous.getData().isEmpty()) {
                                if (i2 < 0) {
                                    return (Value) CollectionsKt.first((List<? extends Object>) page.getData());
                                }
                                if (i3 == CollectionsKt.getLastIndex(this.pages) && i2 > CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) CollectionsKt.last((List<? extends Object>) this.pages)).getData())) {
                                    return (Value) CollectionsKt.last((List<? extends Object>) previous.getData());
                                }
                                return this.pages.get(i3).getData().get(i2);
                            }
                        }
                        throw new NoSuchElementException("List contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [Value, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v9, types: [Value, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00ff -> B:43:0x0115). Please submit an issue!!! */
    public final Value closestItemAroundPosition(int i, Function1<? super Value, Boolean> predicate) {
        int i2;
        int i3;
        PagingSource.LoadResult.Page<Key, Value> page;
        PagingSource.LoadResult.Page<Key, Value> page2;
        int i4;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                    int i5 = i - this.leadingPlaceholderCount;
                    int i6 = 0;
                    while (i6 < CollectionsKt.getLastIndex(getPages()) && i5 > CollectionsKt.getLastIndex(getPages().get(i6).getData())) {
                        i5 -= getPages().get(i6).getData().size();
                        i6++;
                    }
                    Iterator<PagingSource.LoadResult.Page<Key, Value>> it2 = this.pages.iterator();
                    int i7 = 0;
                    while (true) {
                        i2 = -1;
                        if (!it2.hasNext()) {
                            i7 = -1;
                            break;
                        } else if (!it2.next().getData().isEmpty()) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                    List<PagingSource.LoadResult.Page<Key, Value>> list2 = this.pages;
                    ListIterator<PagingSource.LoadResult.Page<Key, Value>> listIterator = list2.listIterator(list2.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            i3 = -1;
                            break;
                        } else if (!listIterator.previous().getData().isEmpty()) {
                            i3 = listIterator.nextIndex();
                            break;
                        }
                    }
                    List<PagingSource.LoadResult.Page<Key, Value>> list3 = this.pages;
                    if (i5 < 0) {
                        z2 = false;
                        page = null;
                        i4 = i7;
                        i6 = -1;
                        z = true;
                        page2 = list3.get(i7);
                        i2 = 0;
                        i5 = -1;
                    } else if (i6 == CollectionsKt.getLastIndex(list3) && i5 > CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) CollectionsKt.last((List<? extends Object>) this.pages)).getData())) {
                        PagingSource.LoadResult.Page<Key, Value> page3 = this.pages.get(i3);
                        int i8 = i3;
                        page = page3;
                        i5 = CollectionsKt.getLastIndex(page3.getData());
                        i6 = i8;
                        z = false;
                        page2 = null;
                        i4 = -1;
                        z2 = true;
                    } else {
                        page = this.pages.get(i6);
                        page2 = this.pages.get(i6);
                        i2 = i5;
                        i4 = i6;
                        z = false;
                        z2 = false;
                    }
                    while (true) {
                        if (z && z2) {
                            return null;
                        }
                        if (!z) {
                            while (i5 < 0) {
                                i6--;
                                if (i6 < 0) {
                                    break;
                                }
                                page = this.pages.get(i6);
                                i5 = CollectionsKt.getLastIndex(page.getData());
                            }
                            if (i6 < 0) {
                                z = true;
                            } else {
                                Intrinsics.checkNotNull(page);
                                Value value = page.getData().get(i5);
                                if (predicate.invoke(value).booleanValue()) {
                                    return value;
                                }
                                i5--;
                            }
                        }
                        if (!z2) {
                            while (true) {
                                Intrinsics.checkNotNull(page2);
                                if (i2 <= CollectionsKt.getLastIndex(page2.getData()) || (i4 = i4 + 1) > CollectionsKt.getLastIndex(this.pages)) {
                                    break;
                                }
                                page2 = this.pages.get(i4);
                                i2 = page2.getData().isEmpty() ? Integer.MAX_VALUE : 0;
                            }
                            if (i4 > CollectionsKt.getLastIndex(this.pages)) {
                                break;
                            }
                            Value value2 = page2.getData().get(i2);
                            if (predicate.invoke(value2).booleanValue()) {
                                return value2;
                            }
                            i2++;
                        }
                    }
                }
            }
        }
        return null;
    }

    public final PagingSource.LoadResult.Page<Key, Value> closestPageToPosition(int i) {
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                int i2 = i - this.leadingPlaceholderCount;
                int i3 = 0;
                while (i3 < CollectionsKt.getLastIndex(getPages()) && i2 > CollectionsKt.getLastIndex(getPages().get(i3).getData())) {
                    i2 -= getPages().get(i3).getData().size();
                    i3++;
                }
                List<PagingSource.LoadResult.Page<Key, Value>> list2 = this.pages;
                if (i2 < 0) {
                    return (PagingSource.LoadResult.Page) CollectionsKt.first((List<? extends Object>) list2);
                }
                return list2.get(i3);
            }
        }
        return null;
    }

    public final boolean isEmpty() {
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final Value firstItemOrNull() {
        Object obj;
        List<Value> data;
        Iterator<T> it = this.pages.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!((PagingSource.LoadResult.Page) obj).getData().isEmpty()) {
                break;
            }
        }
        PagingSource.LoadResult.Page page = (PagingSource.LoadResult.Page) obj;
        if (page == null || (data = page.getData()) == null) {
            return null;
        }
        return (Value) CollectionsKt.firstOrNull((List<? extends Object>) data);
    }

    public final Value lastItemOrNull() {
        PagingSource.LoadResult.Page<Key, Value> page;
        List<Value> data;
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        ListIterator<PagingSource.LoadResult.Page<Key, Value>> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                page = null;
                break;
            }
            page = listIterator.previous();
            if (!page.getData().isEmpty()) {
                break;
            }
        }
        PagingSource.LoadResult.Page<Key, Value> page2 = page;
        if (page2 == null || (data = page2.getData()) == null) {
            return null;
        }
        return (Value) CollectionsKt.lastOrNull((List<? extends Object>) data);
    }

    public String toString() {
        return "PagingState(pages=" + this.pages + ", anchorPosition=" + this.anchorPosition + ", config=" + this.config + ", leadingPlaceholderCount=" + this.leadingPlaceholderCount + ')';
    }

    public final <T> T anchorPositionToPagedIndices$paging_common(int i, Function2<? super Integer, ? super Integer, ? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = i - this.leadingPlaceholderCount;
        int i3 = 0;
        while (i3 < CollectionsKt.getLastIndex(getPages()) && i2 > CollectionsKt.getLastIndex(getPages().get(i3).getData())) {
            i2 -= getPages().get(i3).getData().size();
            i3++;
        }
        return block.invoke(Integer.valueOf(i3), Integer.valueOf(i2));
    }
}
