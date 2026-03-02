package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: CachedPageEventFlow.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014J\u0016\u0010\u0015\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002J\u0016\u0010\u0017\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002J\u0016\u0010\u0019\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0002J\u0016\u0010\u001b\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0002J\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/paging/FlattenedPageEventStorage;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "placeholdersBefore", "", "placeholdersAfter", "pages", "Lkotlin/collections/ArrayDeque;", "Landroidx/paging/TransformablePage;", "sourceStates", "Landroidx/paging/MutableLoadStateCollection;", "mediatorStates", "Landroidx/paging/LoadStates;", "receivedFirstEvent", "", "add", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/paging/PageEvent;", "handlePageDrop", "Landroidx/paging/PageEvent$Drop;", "handleInsert", "Landroidx/paging/PageEvent$Insert;", "handleLoadStateUpdate", "Landroidx/paging/PageEvent$LoadStateUpdate;", "handleStaticList", "Landroidx/paging/PageEvent$StaticList;", "getAsEvents", "", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FlattenedPageEventStorage<T> {
    private LoadStates mediatorStates;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private boolean receivedFirstEvent;
    private final ArrayDeque<TransformablePage<T>> pages = new ArrayDeque<>();
    private final MutableLoadStateCollection sourceStates = new MutableLoadStateCollection();

    /* compiled from: CachedPageEventFlow.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void add(PageEvent<T> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.receivedFirstEvent = true;
        if (event instanceof PageEvent.Insert) {
            handleInsert((PageEvent.Insert) event);
        } else if (event instanceof PageEvent.Drop) {
            handlePageDrop((PageEvent.Drop) event);
        } else if (event instanceof PageEvent.LoadStateUpdate) {
            handleLoadStateUpdate((PageEvent.LoadStateUpdate) event);
        } else if (!(event instanceof PageEvent.StaticList)) {
            throw new NoWhenBranchMatchedException();
        } else {
            handleStaticList((PageEvent.StaticList) event);
        }
    }

    private final void handlePageDrop(PageEvent.Drop<T> drop) {
        this.sourceStates.set(drop.getLoadType(), LoadState.NotLoading.Companion.getIncomplete$paging_common());
        int i = WhenMappings.$EnumSwitchMapping$0[drop.getLoadType().ordinal()];
        int i2 = 0;
        if (i == 1) {
            this.placeholdersBefore = drop.getPlaceholdersRemaining();
            int pageCount = drop.getPageCount();
            while (i2 < pageCount) {
                this.pages.removeFirst();
                i2++;
            }
        } else if (i == 2) {
            this.placeholdersAfter = drop.getPlaceholdersRemaining();
            int pageCount2 = drop.getPageCount();
            while (i2 < pageCount2) {
                this.pages.removeLast();
                i2++;
            }
        } else {
            throw new IllegalArgumentException("Page drop type must be prepend or append");
        }
    }

    private final void handleInsert(PageEvent.Insert<T> insert) {
        this.sourceStates.set(insert.getSourceLoadStates());
        this.mediatorStates = insert.getMediatorLoadStates();
        int i = WhenMappings.$EnumSwitchMapping$0[insert.getLoadType().ordinal()];
        if (i == 1) {
            this.placeholdersBefore = insert.getPlaceholdersBefore();
            Iterator<Integer> it = RangesKt.downTo(insert.getPages().size() - 1, 0).iterator();
            while (it.hasNext()) {
                this.pages.addFirst(insert.getPages().get(((IntIterator) it).nextInt()));
            }
        } else if (i == 2) {
            this.placeholdersAfter = insert.getPlaceholdersAfter();
            this.pages.addAll(insert.getPages());
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.pages.clear();
            this.placeholdersAfter = insert.getPlaceholdersAfter();
            this.placeholdersBefore = insert.getPlaceholdersBefore();
            this.pages.addAll(insert.getPages());
        }
    }

    private final void handleLoadStateUpdate(PageEvent.LoadStateUpdate<T> loadStateUpdate) {
        this.sourceStates.set(loadStateUpdate.getSource());
        this.mediatorStates = loadStateUpdate.getMediator();
    }

    private final void handleStaticList(PageEvent.StaticList<T> staticList) {
        if (staticList.getSourceLoadStates() != null) {
            this.sourceStates.set(staticList.getSourceLoadStates());
        }
        if (staticList.getMediatorLoadStates() != null) {
            this.mediatorStates = staticList.getMediatorLoadStates();
        }
        this.pages.clear();
        this.placeholdersAfter = 0;
        this.placeholdersBefore = 0;
        this.pages.add(new TransformablePage<>(0, staticList.getData()));
    }

    public final List<PageEvent<T>> getAsEvents() {
        if (!this.receivedFirstEvent) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        LoadStates snapshot = this.sourceStates.snapshot();
        if (!this.pages.isEmpty()) {
            arrayList.add(PageEvent.Insert.Companion.Refresh(CollectionsKt.toList(this.pages), this.placeholdersBefore, this.placeholdersAfter, snapshot, this.mediatorStates));
            return arrayList;
        }
        arrayList.add(new PageEvent.LoadStateUpdate(snapshot, this.mediatorStates));
        return arrayList;
    }
}
