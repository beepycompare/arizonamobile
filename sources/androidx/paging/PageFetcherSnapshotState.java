package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PagingSource;
import androidx.paging.ViewportHint;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: PageFetcherSnapshotState.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0001KB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001103J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001103J!\u00105\u001a\u0004\u0018\u00018\u00002\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\u00107J+\u00108\u001a\b\u0012\u0004\u0012\u00028\u000109*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b:J;\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n2\b\u0010>\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0002\u0010?J\u0014\u0010@\u001a\u00020A2\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00010CJ\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010C2\u0006\u0010'\u001a\u00020(2\u0006\u0010E\u001a\u00020+J#\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0000¢\u0006\u0002\bJR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u001cR\u000e\u0010!\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110$X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020+0\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001e\u0010/\u001a\u00020.2\u0006\u0010\u0012\u001a\u00020.@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006L"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "<init>", "(Landroidx/paging/PagingConfig;)V", "_pages", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "pages", "", "getPages$paging_common", "()Ljava/util/List;", "pageKeys", "", "", "value", "initialPageIndex", "getInitialPageIndex$paging_common", "()I", "storageCount", "getStorageCount$paging_common", "_placeholdersBefore", "placeholdersBefore", "getPlaceholdersBefore$paging_common", "setPlaceholdersBefore$paging_common", "(I)V", "_placeholdersAfter", "placeholdersAfter", "getPlaceholdersAfter$paging_common", "setPlaceholdersAfter$paging_common", "prependGenerationId", "appendGenerationId", "prependGenerationIdCh", "Lkotlinx/coroutines/channels/Channel;", "appendGenerationIdCh", "generationId", "loadType", "Landroidx/paging/LoadType;", "generationId$paging_common", "failedHintsByLoadType", "Landroidx/paging/ViewportHint;", "getFailedHintsByLoadType$paging_common", "()Ljava/util/Map;", "Landroidx/paging/MutableLoadStateCollection;", "sourceLoadStates", "getSourceLoadStates$paging_common", "()Landroidx/paging/MutableLoadStateCollection;", "consumePrependGenerationIdAsFlow", "Lkotlinx/coroutines/flow/Flow;", "consumeAppendGenerationIdAsFlow", "getLoadKey", "page", "(Landroidx/paging/PagingSource$LoadResult$Page;)Ljava/lang/Object;", "toPageEvent", "Landroidx/paging/PageEvent;", "toPageEvent$paging_common", "insert", "", "loadId", "loadKey", "(ILandroidx/paging/LoadType;Landroidx/paging/PagingSource$LoadResult$Page;Ljava/lang/Object;)Z", "drop", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/paging/PageEvent$Drop;", "dropEventOrNull", "hint", "currentPagingState", "Landroidx/paging/PagingState;", "viewportHint", "Landroidx/paging/ViewportHint$Access;", "currentPagingState$paging_common", "Holder", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PageFetcherSnapshotState<Key, Value> {
    private final List<PagingSource.LoadResult.Page<Key, Value>> _pages;
    private int _placeholdersAfter;
    private int _placeholdersBefore;
    private int appendGenerationId;
    private final Channel<Integer> appendGenerationIdCh;
    private final PagingConfig config;
    private final Map<LoadType, ViewportHint> failedHintsByLoadType;
    private int initialPageIndex;
    private final Map<Integer, Key> pageKeys;
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;
    private int prependGenerationId;
    private final Channel<Integer> prependGenerationIdCh;
    private MutableLoadStateCollection sourceLoadStates;

    /* compiled from: PageFetcherSnapshotState.kt */
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

    public /* synthetic */ PageFetcherSnapshotState(PagingConfig pagingConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig);
    }

    private PageFetcherSnapshotState(PagingConfig pagingConfig) {
        this.config = pagingConfig;
        ArrayList arrayList = new ArrayList();
        this._pages = arrayList;
        this.pages = arrayList;
        this.pageKeys = new LinkedHashMap();
        this.prependGenerationIdCh = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.appendGenerationIdCh = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.failedHintsByLoadType = new LinkedHashMap();
        MutableLoadStateCollection mutableLoadStateCollection = new MutableLoadStateCollection();
        mutableLoadStateCollection.set(LoadType.REFRESH, LoadState.Loading.INSTANCE);
        this.sourceLoadStates = mutableLoadStateCollection;
    }

    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages$paging_common() {
        return this.pages;
    }

    public final int getInitialPageIndex$paging_common() {
        return this.initialPageIndex;
    }

    public final int getStorageCount$paging_common() {
        Iterator<T> it = this.pages.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((PagingSource.LoadResult.Page) it.next()).getData().size();
        }
        return i;
    }

    public final int getPlaceholdersBefore$paging_common() {
        if (this.config.enablePlaceholders) {
            return this._placeholdersBefore;
        }
        return 0;
    }

    public final void setPlaceholdersBefore$paging_common(int i) {
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        this._placeholdersBefore = i;
    }

    public final int getPlaceholdersAfter$paging_common() {
        if (this.config.enablePlaceholders) {
            return this._placeholdersAfter;
        }
        return 0;
    }

    public final void setPlaceholdersAfter$paging_common(int i) {
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        this._placeholdersAfter = i;
    }

    public final int generationId$paging_common(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                return this.appendGenerationId;
            }
            return this.prependGenerationId;
        }
        throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
    }

    public final Map<LoadType, ViewportHint> getFailedHintsByLoadType$paging_common() {
        return this.failedHintsByLoadType;
    }

    public final MutableLoadStateCollection getSourceLoadStates$paging_common() {
        return this.sourceLoadStates;
    }

    public final Flow<Integer> consumePrependGenerationIdAsFlow() {
        return FlowKt.onStart(FlowKt.consumeAsFlow(this.prependGenerationIdCh), new PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1(this, null));
    }

    public final Flow<Integer> consumeAppendGenerationIdAsFlow() {
        return FlowKt.onStart(FlowKt.consumeAsFlow(this.appendGenerationIdCh), new PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1(this, null));
    }

    public final Key getLoadKey(PagingSource.LoadResult.Page<Key, Value> page) {
        Intrinsics.checkNotNullParameter(page, "page");
        int hashCode = page.hashCode();
        if (!this.pageKeys.containsKey(Integer.valueOf(hashCode))) {
            throw new IllegalArgumentException("Load key not found for Page " + page + ". This likely indicates an error in the library. Please file a bug in the Buganizer.");
        }
        return this.pageKeys.get(Integer.valueOf(hashCode));
    }

    public final PageEvent<Value> toPageEvent$paging_common(PagingSource.LoadResult.Page<Key, Value> page, LoadType loadType) {
        Intrinsics.checkNotNullParameter(page, "<this>");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        int i2 = 0;
        if (i != 1) {
            if (i == 2) {
                i2 = 0 - this.initialPageIndex;
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                i2 = (this.pages.size() - this.initialPageIndex) - 1;
            }
        }
        List listOf = CollectionsKt.listOf(new TransformablePage(i2, page.getData()));
        int i3 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                return PageEvent.Insert.Companion.Append(listOf, getPlaceholdersAfter$paging_common(), this.sourceLoadStates.snapshot(), null);
            }
            return PageEvent.Insert.Companion.Prepend(listOf, getPlaceholdersBefore$paging_common(), this.sourceLoadStates.snapshot(), null);
        }
        return PageEvent.Insert.Companion.Refresh(listOf, getPlaceholdersBefore$paging_common(), getPlaceholdersAfter$paging_common(), this.sourceLoadStates.snapshot(), null);
    }

    public final boolean insert(int i, LoadType loadType, PagingSource.LoadResult.Page<Key, Value> page, Key key) {
        int itemsBefore;
        int itemsAfter;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(page, "page");
        int i2 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.pages.isEmpty()) {
                    throw new IllegalStateException("should've received an init before append".toString());
                }
                if (i != this.appendGenerationId) {
                    return false;
                }
                this._pages.add(page);
                this.pageKeys.put(Integer.valueOf(page.hashCode()), key);
                if (page.getItemsAfter() == Integer.MIN_VALUE) {
                    itemsAfter = RangesKt.coerceAtLeast(getPlaceholdersAfter$paging_common() - page.getData().size(), 0);
                } else {
                    itemsAfter = page.getItemsAfter();
                }
                setPlaceholdersAfter$paging_common(itemsAfter);
                this.failedHintsByLoadType.remove(LoadType.APPEND);
            } else if (this.pages.isEmpty()) {
                throw new IllegalStateException("should've received an init before prepend".toString());
            } else {
                if (i != this.prependGenerationId) {
                    return false;
                }
                this._pages.add(0, page);
                this.pageKeys.put(Integer.valueOf(page.hashCode()), key);
                this.initialPageIndex++;
                if (page.getItemsBefore() == Integer.MIN_VALUE) {
                    itemsBefore = RangesKt.coerceAtLeast(getPlaceholdersBefore$paging_common() - page.getData().size(), 0);
                } else {
                    itemsBefore = page.getItemsBefore();
                }
                setPlaceholdersBefore$paging_common(itemsBefore);
                this.failedHintsByLoadType.remove(LoadType.PREPEND);
            }
        } else if (!this.pages.isEmpty()) {
            throw new IllegalStateException("cannot receive multiple init calls".toString());
        } else {
            if (i != 0) {
                throw new IllegalStateException("init loadId must be the initial value, 0".toString());
            }
            this._pages.add(page);
            this.pageKeys.put(Integer.valueOf(page.hashCode()), key);
            this.initialPageIndex = 0;
            setPlaceholdersAfter$paging_common(page.getItemsAfter());
            setPlaceholdersBefore$paging_common(page.getItemsBefore());
            Unit unit = Unit.INSTANCE;
        }
        return true;
    }

    public final void drop(PageEvent.Drop<Value> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPageCount() > this.pages.size()) {
            throw new IllegalStateException(("invalid drop count. have " + this.pages.size() + " but wanted to drop " + event.getPageCount()).toString());
        }
        this.failedHintsByLoadType.remove(event.getLoadType());
        this.sourceLoadStates.set(event.getLoadType(), LoadState.NotLoading.Companion.getIncomplete$paging_common());
        int i = WhenMappings.$EnumSwitchMapping$0[event.getLoadType().ordinal()];
        if (i != 2) {
            if (i == 3) {
                int pageCount = event.getPageCount();
                for (int i2 = 0; i2 < pageCount; i2++) {
                    this.pageKeys.remove(Integer.valueOf(this._pages.remove(this.pages.size() - 1).hashCode()));
                }
                setPlaceholdersAfter$paging_common(event.getPlaceholdersRemaining());
                int i3 = this.appendGenerationId + 1;
                this.appendGenerationId = i3;
                this.appendGenerationIdCh.mo9057trySendJP2dKIU(Integer.valueOf(i3));
                return;
            }
            throw new IllegalArgumentException("cannot drop " + event.getLoadType());
        }
        int pageCount2 = event.getPageCount();
        for (int i4 = 0; i4 < pageCount2; i4++) {
            this.pageKeys.remove(Integer.valueOf(this._pages.remove(0).hashCode()));
        }
        this.initialPageIndex -= event.getPageCount();
        setPlaceholdersBefore$paging_common(event.getPlaceholdersRemaining());
        int i5 = this.prependGenerationId + 1;
        this.prependGenerationId = i5;
        this.prependGenerationIdCh.mo9057trySendJP2dKIU(Integer.valueOf(i5));
    }

    public final PageEvent.Drop<Value> dropEventOrNull(LoadType loadType, ViewportHint hint) {
        int lastIndex;
        int lastIndex2;
        int size;
        int presentedItemsAfter;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(hint, "hint");
        if (this.config.maxSize != Integer.MAX_VALUE && this.pages.size() > 2 && getStorageCount$paging_common() > this.config.maxSize) {
            if (loadType == LoadType.REFRESH) {
                throw new IllegalArgumentException(("Drop LoadType must be PREPEND or APPEND, but got " + loadType).toString());
            }
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.pages.size() && getStorageCount$paging_common() - i3 > this.config.maxSize) {
                int i4 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
                List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
                if (i4 == 2) {
                    size = list.get(i2).getData().size();
                } else {
                    size = list.get(CollectionsKt.getLastIndex(list) - i2).getData().size();
                }
                if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 2) {
                    presentedItemsAfter = hint.getPresentedItemsBefore();
                } else {
                    presentedItemsAfter = hint.getPresentedItemsAfter();
                }
                if ((presentedItemsAfter - i3) - size < this.config.prefetchDistance) {
                    break;
                }
                i3 += size;
                i2++;
            }
            if (i2 == 0) {
                return null;
            }
            if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 2) {
                lastIndex = -this.initialPageIndex;
            } else {
                lastIndex = (CollectionsKt.getLastIndex(this.pages) - this.initialPageIndex) - (i2 - 1);
            }
            if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 2) {
                lastIndex2 = (i2 - 1) - this.initialPageIndex;
            } else {
                lastIndex2 = CollectionsKt.getLastIndex(this.pages) - this.initialPageIndex;
            }
            if (this.config.enablePlaceholders) {
                i = (loadType == LoadType.PREPEND ? getPlaceholdersBefore$paging_common() : getPlaceholdersAfter$paging_common()) + i3;
            }
            return new PageEvent.Drop<>(loadType, lastIndex, lastIndex2, i);
        }
        return null;
    }

    public final PagingState<Key, Value> currentPagingState$paging_common(ViewportHint.Access access) {
        Integer num;
        int size;
        List list = CollectionsKt.toList(this.pages);
        if (access != null) {
            int placeholdersBefore$paging_common = getPlaceholdersBefore$paging_common();
            int i = -this.initialPageIndex;
            int lastIndex = CollectionsKt.getLastIndex(this.pages) - this.initialPageIndex;
            int pageOffset = access.getPageOffset();
            for (int i2 = i; i2 < pageOffset; i2++) {
                if (i2 > lastIndex) {
                    size = this.config.pageSize;
                } else {
                    size = this.pages.get(this.initialPageIndex + i2).getData().size();
                }
                placeholdersBefore$paging_common += size;
            }
            int indexInPage = placeholdersBefore$paging_common + access.getIndexInPage();
            if (access.getPageOffset() < i) {
                indexInPage -= this.config.pageSize;
            }
            num = Integer.valueOf(indexInPage);
        } else {
            num = null;
        }
        return new PagingState<>(list, num, this.config, getPlaceholdersBefore$paging_common());
    }

    /* compiled from: PageFetcherSnapshotState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JC\u0010\f\u001a\u0002H\r\"\u0004\b\u0004\u0010\r2-\u0010\u000e\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\r0\u000fH\u0086H¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState$Holder;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "<init>", "(Landroidx/paging/PagingConfig;)V", "lock", "Lkotlinx/coroutines/sync/Mutex;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/paging/PageFetcherSnapshotState;", "withLock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Holder<Key, Value> {
        private final PagingConfig config;
        private final Mutex lock;
        private final PageFetcherSnapshotState<Key, Value> state;

        public Holder(PagingConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
            this.lock = MutexKt.Mutex$default(false, 1, null);
            this.state = new PageFetcherSnapshotState<>(config, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object withLock(Function1<? super PageFetcherSnapshotState<Key, Value>, ? extends T> function1, Continuation<? super T> continuation) {
            PageFetcherSnapshotState$Holder$withLock$1 pageFetcherSnapshotState$Holder$withLock$1;
            int i;
            Mutex mutex;
            try {
                if (continuation instanceof PageFetcherSnapshotState$Holder$withLock$1) {
                    pageFetcherSnapshotState$Holder$withLock$1 = (PageFetcherSnapshotState$Holder$withLock$1) continuation;
                    if ((pageFetcherSnapshotState$Holder$withLock$1.label & Integer.MIN_VALUE) != 0) {
                        pageFetcherSnapshotState$Holder$withLock$1.label -= Integer.MIN_VALUE;
                        Object obj = pageFetcherSnapshotState$Holder$withLock$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = pageFetcherSnapshotState$Holder$withLock$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            mutex = this.lock;
                            pageFetcherSnapshotState$Holder$withLock$1.L$0 = function1;
                            pageFetcherSnapshotState$Holder$withLock$1.L$1 = mutex;
                            pageFetcherSnapshotState$Holder$withLock$1.label = 1;
                            if (mutex.lock(null, pageFetcherSnapshotState$Holder$withLock$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                            mutex = (Mutex) pageFetcherSnapshotState$Holder$withLock$1.L$1;
                            function1 = (Function1) pageFetcherSnapshotState$Holder$withLock$1.L$0;
                        }
                        return function1.invoke(this.state);
                    }
                }
                return function1.invoke(this.state);
            } finally {
                mutex.unlock(null);
            }
            pageFetcherSnapshotState$Holder$withLock$1 = new PageFetcherSnapshotState$Holder$withLock$1(this, continuation);
            Object obj2 = pageFetcherSnapshotState$Holder$withLock$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = pageFetcherSnapshotState$Holder$withLock$1.label;
            if (i != 0) {
            }
        }

        private final <T> Object withLock$$forInline(Function1<? super PageFetcherSnapshotState<Key, Value>, ? extends T> function1, Continuation<? super T> continuation) {
            Mutex mutex = this.lock;
            mutex.lock(null, continuation);
            try {
                return function1.invoke(this.state);
            } finally {
                mutex.unlock(null);
            }
        }
    }
}
