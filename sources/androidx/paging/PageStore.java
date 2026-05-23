package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PagingDataEvent;
import androidx.paging.ViewportHint;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* compiled from: PageStore.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 ;*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001;B+\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0017\b\u0016\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\n\u0010\u000eJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001c\u001a\u00020\b¢\u0006\u0002\u0010 J\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"J\u0015\u0010#\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0002\u0010 J\u0018\u0010&\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005H\u0002J\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*J\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020\bJ\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000(2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002J\u0010\u00101\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0002J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000(2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0002J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010:\u001a\u00020\bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010$\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0013¨\u0006<"}, d2 = {"Landroidx/paging/PageStore;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PlaceholderPaddedList;", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersBefore", "", "placeholdersAfter", "<init>", "(Ljava/util/List;II)V", "insertEvent", "Landroidx/paging/PageEvent$Insert;", "(Landroidx/paging/PageEvent$Insert;)V", "", "value", "dataCount", "getDataCount", "()I", "originalPageOffsetFirst", "getOriginalPageOffsetFirst", "originalPageOffsetLast", "getOriginalPageOffsetLast", "getPlaceholdersBefore", "getPlaceholdersAfter", "checkIndex", "", FirebaseAnalytics.Param.INDEX, "toString", "", "get", "(I)Ljava/lang/Object;", "snapshot", "Landroidx/paging/ItemSnapshotList;", "getItem", "size", "getSize", "fullCount", "processEvent", "Landroidx/paging/PagingDataEvent;", "pageEvent", "Landroidx/paging/PageEvent;", "initializeHint", "Landroidx/paging/ViewportHint$Initial;", "createAccessHintForIndex", "Landroidx/paging/ViewportHint$Access;", "insertPage", "insert", "dropPagesWithOffsets", "pageOffsetsToDrop", "Lkotlin/ranges/IntRange;", "dropPages", "drop", "Landroidx/paging/PageEvent$Drop;", "equals", "", "other", "hashCode", "Companion", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PageStore<T> implements PlaceholderPaddedList<T> {
    public static final Companion Companion = new Companion(null);
    private static final PageStore<Object> INITIAL = new PageStore<>(PageEvent.Insert.Companion.Refresh$default(PageEvent.Insert.Companion, CollectionsKt.listOf(TransformablePage.Companion.empty()), 0, 0, new LoadStates(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.NotLoading.Companion.getComplete$paging_common(), LoadState.NotLoading.Companion.getComplete$paging_common()), null, 16, null));
    private int dataCount;
    private final List<TransformablePage<T>> pages;
    private int placeholdersAfter;
    private int placeholdersBefore;

    /* compiled from: PageStore.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PageStore(List<TransformablePage<T>> pages, int i, int i2) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.pages = CollectionsKt.toMutableList((Collection) pages);
        this.dataCount = fullCount(pages);
        this.placeholdersBefore = i;
        this.placeholdersAfter = i2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PageStore(PageEvent.Insert<T> insertEvent) {
        this(insertEvent.getPages(), insertEvent.getPlaceholdersBefore(), insertEvent.getPlaceholdersAfter());
        Intrinsics.checkNotNullParameter(insertEvent, "insertEvent");
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int getDataCount() {
        return this.dataCount;
    }

    private final int getOriginalPageOffsetFirst() {
        Integer minOrNull = ArraysKt.minOrNull(((TransformablePage) CollectionsKt.first((List<? extends Object>) this.pages)).getOriginalPageOffsets());
        Intrinsics.checkNotNull(minOrNull);
        return minOrNull.intValue();
    }

    private final int getOriginalPageOffsetLast() {
        Integer maxOrNull = ArraysKt.maxOrNull(((TransformablePage) CollectionsKt.last((List<? extends Object>) this.pages)).getOriginalPageOffsets());
        Intrinsics.checkNotNull(maxOrNull);
        return maxOrNull.intValue();
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    private final void checkIndex(int i) {
        if (i < 0 || i >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + getSize());
        }
    }

    public String toString() {
        int dataCount = getDataCount();
        ArrayList arrayList = new ArrayList(dataCount);
        for (int i = 0; i < dataCount; i++) {
            arrayList.add(getItem(i));
        }
        return "[(" + getPlaceholdersBefore() + " placeholders), " + CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null) + ", (" + getPlaceholdersAfter() + " placeholders)]";
    }

    public final T get(int i) {
        checkIndex(i);
        int placeholdersBefore = i - getPlaceholdersBefore();
        if (placeholdersBefore < 0 || placeholdersBefore >= getDataCount()) {
            return null;
        }
        return getItem(placeholdersBefore);
    }

    public final ItemSnapshotList<T> snapshot() {
        int placeholdersBefore = getPlaceholdersBefore();
        int placeholdersAfter = getPlaceholdersAfter();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.pages.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((TransformablePage) it.next()).getData());
        }
        return new ItemSnapshotList<>(placeholdersBefore, placeholdersAfter, arrayList);
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public T getItem(int i) {
        int size = this.pages.size();
        int i2 = 0;
        while (i2 < size) {
            int size2 = this.pages.get(i2).getData().size();
            if (size2 > i) {
                break;
            }
            i -= size2;
            i2++;
        }
        return this.pages.get(i2).getData().get(i);
    }

    @Override // androidx.paging.PlaceholderPaddedList
    public int getSize() {
        return getPlaceholdersBefore() + getDataCount() + getPlaceholdersAfter();
    }

    private final int fullCount(List<TransformablePage<T>> list) {
        Iterator<T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((TransformablePage) it.next()).getData().size();
        }
        return i;
    }

    public final PagingDataEvent<T> processEvent(PageEvent<T> pageEvent) {
        Intrinsics.checkNotNullParameter(pageEvent, "pageEvent");
        if (pageEvent instanceof PageEvent.Insert) {
            return insertPage((PageEvent.Insert) pageEvent);
        }
        if (pageEvent instanceof PageEvent.Drop) {
            return dropPages((PageEvent.Drop) pageEvent);
        }
        throw new IllegalStateException("Paging received an event to process StaticList or LoadStateUpdate while\nprocessing Inserts and Drops. If you see this exception, it is most\nlikely a bug in the library. Please file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
    }

    public final ViewportHint.Initial initializeHint() {
        int dataCount = getDataCount() / 2;
        return new ViewportHint.Initial(dataCount, dataCount, getOriginalPageOffsetFirst(), getOriginalPageOffsetLast());
    }

    public final ViewportHint.Access createAccessHintForIndex(int i) {
        int i2 = 0;
        int placeholdersBefore = i - getPlaceholdersBefore();
        while (placeholdersBefore >= this.pages.get(i2).getData().size() && i2 < CollectionsKt.getLastIndex(this.pages)) {
            placeholdersBefore -= this.pages.get(i2).getData().size();
            i2++;
        }
        return this.pages.get(i2).viewportHintFor(placeholdersBefore, i - getPlaceholdersBefore(), ((getSize() - i) - getPlaceholdersAfter()) - 1, getOriginalPageOffsetFirst(), getOriginalPageOffsetLast());
    }

    private final PagingDataEvent<T> insertPage(PageEvent.Insert<T> insert) {
        int fullCount = fullCount(insert.getPages());
        int i = WhenMappings.$EnumSwitchMapping$0[insert.getLoadType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                int placeholdersBefore = getPlaceholdersBefore();
                this.pages.addAll(0, insert.getPages());
                this.dataCount = getDataCount() + fullCount;
                this.placeholdersBefore = insert.getPlaceholdersBefore();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = insert.getPages().iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(arrayList, ((TransformablePage) it.next()).getData());
                }
                return new PagingDataEvent.Prepend(arrayList, getPlaceholdersBefore(), placeholdersBefore);
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                int placeholdersAfter = getPlaceholdersAfter();
                int dataCount = getDataCount();
                List<TransformablePage<T>> list = this.pages;
                list.addAll(list.size(), insert.getPages());
                this.dataCount = getDataCount() + fullCount;
                this.placeholdersAfter = insert.getPlaceholdersAfter();
                int placeholdersBefore2 = getPlaceholdersBefore() + dataCount;
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it2 = insert.getPages().iterator();
                while (it2.hasNext()) {
                    CollectionsKt.addAll(arrayList2, ((TransformablePage) it2.next()).getData());
                }
                return new PagingDataEvent.Append(placeholdersBefore2, arrayList2, getPlaceholdersAfter(), placeholdersAfter);
            }
        }
        throw new IllegalStateException("Paging received a refresh event in the middle of an actively loading generation\nof PagingData. If you see this exception, it is most likely a bug in the library.\nPlease file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
    }

    private final int dropPagesWithOffsets(IntRange intRange) {
        Iterator<TransformablePage<T>> it = this.pages.iterator();
        int i = 0;
        while (it.hasNext()) {
            TransformablePage<T> next = it.next();
            int[] originalPageOffsets = next.getOriginalPageOffsets();
            int length = originalPageOffsets.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (intRange.contains(originalPageOffsets[i2])) {
                    i += next.getData().size();
                    it.remove();
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i;
    }

    private final PagingDataEvent<T> dropPages(PageEvent.Drop<T> drop) {
        int dropPagesWithOffsets = dropPagesWithOffsets(new IntRange(drop.getMinPageOffset(), drop.getMaxPageOffset()));
        this.dataCount = getDataCount() - dropPagesWithOffsets;
        if (drop.getLoadType() == LoadType.PREPEND) {
            int placeholdersBefore = getPlaceholdersBefore();
            this.placeholdersBefore = drop.getPlaceholdersRemaining();
            return new PagingDataEvent.DropPrepend(dropPagesWithOffsets, getPlaceholdersBefore(), placeholdersBefore);
        }
        int placeholdersAfter = getPlaceholdersAfter();
        this.placeholdersAfter = drop.getPlaceholdersRemaining();
        return new PagingDataEvent.DropAppend(getPlaceholdersBefore() + getDataCount(), dropPagesWithOffsets, drop.getPlaceholdersRemaining(), placeholdersAfter);
    }

    /* compiled from: PageStore.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\tH\u0000¢\u0006\u0002\b\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/paging/PageStore$Companion;", "", "<init>", "()V", "INITIAL", "Landroidx/paging/PageStore;", "initial", ExifInterface.GPS_DIRECTION_TRUE, NotificationCompat.CATEGORY_EVENT, "Landroidx/paging/PageEvent$Insert;", "initial$paging_common", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> PageStore<T> initial$paging_common(PageEvent.Insert<T> insert) {
            if (insert == null) {
                PageStore<T> pageStore = PageStore.INITIAL;
                Intrinsics.checkNotNull(pageStore, "null cannot be cast to non-null type androidx.paging.PageStore<T of androidx.paging.PageStore.Companion.initial>");
                return pageStore;
            }
            return new PageStore<>(insert);
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PageStore)) {
            PageStore pageStore = (PageStore) obj;
            return getOriginalPageOffsetFirst() == pageStore.getOriginalPageOffsetFirst() && getOriginalPageOffsetLast() == pageStore.getOriginalPageOffsetLast() && getPlaceholdersBefore() == pageStore.getPlaceholdersBefore() && getPlaceholdersAfter() == pageStore.getPlaceholdersAfter() && Intrinsics.areEqual(this.pages, pageStore.pages);
        }
        return false;
    }

    public int hashCode() {
        return (getOriginalPageOffsetFirst() * 31) + (getOriginalPageOffsetLast() * 31) + (getPlaceholdersBefore() * 31) + (getPlaceholdersAfter() * 31) + (this.pages.hashCode() * 31);
    }
}
