package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PageEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: PagingData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0017*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0017BE\b\u0000\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0000¢\u0006\u0002\b\u0016R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/paging/PagingData;", ExifInterface.GPS_DIRECTION_TRUE, "", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "uiReceiver", "Landroidx/paging/UiReceiver;", "hintReceiver", "Landroidx/paging/HintReceiver;", "cachedPageEvent", "Lkotlin/Function0;", "Landroidx/paging/PageEvent$Insert;", "<init>", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/UiReceiver;Landroidx/paging/HintReceiver;Lkotlin/jvm/functions/Function0;)V", "getFlow$paging_common", "()Lkotlinx/coroutines/flow/Flow;", "getUiReceiver$paging_common", "()Landroidx/paging/UiReceiver;", "getHintReceiver$paging_common", "()Landroidx/paging/HintReceiver;", "cachedEvent", "cachedEvent$paging_common", "Companion", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingData<T> {
    private final Function0<PageEvent.Insert<T>> cachedPageEvent;
    private final Flow<PageEvent<T>> flow;
    private final HintReceiver hintReceiver;
    private final UiReceiver uiReceiver;
    public static final Companion Companion = new Companion(null);
    private static final UiReceiver NOOP_UI_RECEIVER = new UiReceiver() { // from class: androidx.paging.PagingData$Companion$NOOP_UI_RECEIVER$1
        @Override // androidx.paging.UiReceiver
        public void refresh() {
        }

        @Override // androidx.paging.UiReceiver
        public void retry() {
        }
    };
    private static final HintReceiver NOOP_HINT_RECEIVER = new HintReceiver() { // from class: androidx.paging.PagingData$Companion$NOOP_HINT_RECEIVER$1
        @Override // androidx.paging.HintReceiver
        public void accessHint(ViewportHint viewportHint) {
            Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        }
    };

    @JvmStatic
    public static final <T> PagingData<T> empty() {
        return Companion.empty();
    }

    @JvmStatic
    public static final <T> PagingData<T> empty(LoadStates loadStates) {
        return Companion.empty(loadStates);
    }

    @JvmStatic
    public static final <T> PagingData<T> empty(LoadStates loadStates, LoadStates loadStates2) {
        return Companion.empty(loadStates, loadStates2);
    }

    @JvmStatic
    public static final <T> PagingData<T> from(List<? extends T> list) {
        return Companion.from(list);
    }

    @JvmStatic
    public static final <T> PagingData<T> from(List<? extends T> list, int i) {
        return Companion.from(list, i);
    }

    @JvmStatic
    public static final <T> PagingData<T> from(List<? extends T> list, int i, int i2) {
        return Companion.from(list, i, i2);
    }

    @JvmStatic
    public static final <T> PagingData<T> from(List<? extends T> list, LoadStates loadStates) {
        return Companion.from(list, loadStates);
    }

    @JvmStatic
    public static final <T> PagingData<T> from(List<? extends T> list, LoadStates loadStates, LoadStates loadStates2) {
        return Companion.from(list, loadStates, loadStates2);
    }

    @JvmStatic
    public static final <T> PagingData<T> from(List<? extends T> list, LoadStates loadStates, LoadStates loadStates2, int i) {
        return Companion.from(list, loadStates, loadStates2, i);
    }

    @JvmStatic
    public static final <T> PagingData<T> from(List<? extends T> list, LoadStates loadStates, LoadStates loadStates2, int i, int i2) {
        return Companion.from(list, loadStates, loadStates2, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PagingData(Flow<? extends PageEvent<T>> flow, UiReceiver uiReceiver, HintReceiver hintReceiver, Function0<PageEvent.Insert<T>> cachedPageEvent) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(uiReceiver, "uiReceiver");
        Intrinsics.checkNotNullParameter(hintReceiver, "hintReceiver");
        Intrinsics.checkNotNullParameter(cachedPageEvent, "cachedPageEvent");
        this.flow = flow;
        this.uiReceiver = uiReceiver;
        this.hintReceiver = hintReceiver;
        this.cachedPageEvent = cachedPageEvent;
    }

    public final Flow<PageEvent<T>> getFlow$paging_common() {
        return this.flow;
    }

    public final UiReceiver getUiReceiver$paging_common() {
        return this.uiReceiver;
    }

    public final HintReceiver getHintReceiver$paging_common() {
        return this.hintReceiver;
    }

    public /* synthetic */ PagingData(Flow flow, UiReceiver uiReceiver, HintReceiver hintReceiver, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(flow, uiReceiver, hintReceiver, (i & 8) != 0 ? new Function0() { // from class: androidx.paging.PagingData.1
            @Override // kotlin.jvm.functions.Function0
            public final Void invoke() {
                return null;
            }
        } : anonymousClass1);
    }

    /* compiled from: PagingData.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0001\u0010\u000e*\u00020\u0001H\u0007J,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0001\u0010\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007J:\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0001\u0010\u000e*\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0007JN\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0001\u0010\u000e*\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00142\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Landroidx/paging/PagingData$Companion;", "", "<init>", "()V", "NOOP_UI_RECEIVER", "Landroidx/paging/UiReceiver;", "getNOOP_UI_RECEIVER$paging_common", "()Landroidx/paging/UiReceiver;", "NOOP_HINT_RECEIVER", "Landroidx/paging/HintReceiver;", "getNOOP_HINT_RECEIVER$paging_common", "()Landroidx/paging/HintReceiver;", "empty", "Landroidx/paging/PagingData;", ExifInterface.GPS_DIRECTION_TRUE, "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "from", "data", "", "placeholdersBefore", "", "placeholdersAfter", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final <T> PagingData<T> empty(LoadStates sourceLoadStates) {
            Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
            return empty$default(this, sourceLoadStates, null, 2, null);
        }

        @JvmStatic
        public final <T> PagingData<T> from(List<? extends T> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return from$default(this, data, 0, 0, 6, null);
        }

        @JvmStatic
        public final <T> PagingData<T> from(List<? extends T> data, int i) {
            Intrinsics.checkNotNullParameter(data, "data");
            return from$default(this, data, i, 0, 4, null);
        }

        @JvmStatic
        public final <T> PagingData<T> from(List<? extends T> data, LoadStates sourceLoadStates) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
            return from$default(this, data, sourceLoadStates, null, 0, 0, 28, null);
        }

        @JvmStatic
        public final <T> PagingData<T> from(List<? extends T> data, LoadStates sourceLoadStates, LoadStates loadStates) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
            return from$default(this, data, sourceLoadStates, loadStates, 0, 0, 24, null);
        }

        @JvmStatic
        public final <T> PagingData<T> from(List<? extends T> data, LoadStates sourceLoadStates, LoadStates loadStates, int i) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
            return from$default(this, data, sourceLoadStates, loadStates, i, 0, 16, null);
        }

        private Companion() {
        }

        public final UiReceiver getNOOP_UI_RECEIVER$paging_common() {
            return PagingData.NOOP_UI_RECEIVER;
        }

        public final HintReceiver getNOOP_HINT_RECEIVER$paging_common() {
            return PagingData.NOOP_HINT_RECEIVER;
        }

        @JvmStatic
        public final <T> PagingData<T> empty() {
            return new PagingData<>(FlowKt.flowOf(new PageEvent.StaticList(CollectionsKt.emptyList(), null, null, 0, 0, 24, null)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), new Function0() { // from class: androidx.paging.PagingData$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    PageEvent.Insert Refresh;
                    Refresh = PageEvent.Insert.Companion.Refresh(CollectionsKt.listOf(new TransformablePage(0, CollectionsKt.emptyList())), 0, 0, LoadStates.Companion.getIDLE(), null);
                    return Refresh;
                }
            });
        }

        public static /* synthetic */ PagingData empty$default(Companion companion, LoadStates loadStates, LoadStates loadStates2, int i, Object obj) {
            if ((i & 2) != 0) {
                loadStates2 = null;
            }
            return companion.empty(loadStates, loadStates2);
        }

        @JvmStatic
        public final <T> PagingData<T> empty(final LoadStates sourceLoadStates, final LoadStates loadStates) {
            Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
            return new PagingData<>(FlowKt.flowOf(new PageEvent.StaticList(CollectionsKt.emptyList(), sourceLoadStates, loadStates, 0, 0, 24, null)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), new Function0() { // from class: androidx.paging.PagingData$Companion$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    PageEvent.Insert Refresh;
                    Refresh = PageEvent.Insert.Companion.Refresh(CollectionsKt.listOf(new TransformablePage(0, CollectionsKt.emptyList())), 0, 0, LoadStates.this, loadStates);
                    return Refresh;
                }
            });
        }

        public static /* synthetic */ PagingData from$default(Companion companion, List list, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return companion.from(list, i, i2);
        }

        @JvmStatic
        public final <T> PagingData<T> from(final List<? extends T> data, final int i, final int i2) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new PagingData<>(FlowKt.flowOf(new PageEvent.StaticList(data, null, null, i, i2)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), new Function0() { // from class: androidx.paging.PagingData$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    PageEvent.Insert Refresh;
                    Refresh = PageEvent.Insert.Companion.Refresh(CollectionsKt.listOf(new TransformablePage(0, data)), i, i2, LoadStates.Companion.getIDLE(), null);
                    return Refresh;
                }
            });
        }

        public static /* synthetic */ PagingData from$default(Companion companion, List list, LoadStates loadStates, LoadStates loadStates2, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                loadStates2 = null;
            }
            return companion.from(list, loadStates, loadStates2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
        }

        @JvmStatic
        public final <T> PagingData<T> from(final List<? extends T> data, final LoadStates sourceLoadStates, final LoadStates loadStates, final int i, final int i2) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
            return new PagingData<>(FlowKt.flowOf(new PageEvent.StaticList(data, sourceLoadStates, loadStates, i, i2)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), new Function0() { // from class: androidx.paging.PagingData$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    PageEvent.Insert Refresh;
                    Refresh = PageEvent.Insert.Companion.Refresh(CollectionsKt.listOf(new TransformablePage(0, data)), i, i2, sourceLoadStates, loadStates);
                    return Refresh;
                }
            });
        }
    }

    public final PageEvent.Insert<T> cachedEvent$paging_common() {
        return this.cachedPageEvent.invoke();
    }
}
