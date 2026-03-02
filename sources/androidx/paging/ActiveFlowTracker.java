package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* compiled from: CachedPagingData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/paging/ActiveFlowTracker;", "", "onNewCachedEventFlow", "", "cachedPageEventFlow", "Landroidx/paging/CachedPageEventFlow;", "onStart", "flowType", "Landroidx/paging/ActiveFlowTracker$FlowType;", "(Landroidx/paging/ActiveFlowTracker$FlowType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onComplete", "FlowType", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ActiveFlowTracker {
    Object onComplete(FlowType flowType, Continuation<? super Unit> continuation);

    void onNewCachedEventFlow(CachedPageEventFlow<?> cachedPageEventFlow);

    Object onStart(FlowType flowType, Continuation<? super Unit> continuation);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: CachedPagingData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/ActiveFlowTracker$FlowType;", "", "<init>", "(Ljava/lang/String;I)V", "PAGED_DATA_FLOW", "PAGE_EVENT_FLOW", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class FlowType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FlowType[] $VALUES;
        public static final FlowType PAGED_DATA_FLOW = new FlowType("PAGED_DATA_FLOW", 0);
        public static final FlowType PAGE_EVENT_FLOW = new FlowType("PAGE_EVENT_FLOW", 1);

        private static final /* synthetic */ FlowType[] $values() {
            return new FlowType[]{PAGED_DATA_FLOW, PAGE_EVENT_FLOW};
        }

        public static EnumEntries<FlowType> getEntries() {
            return $ENTRIES;
        }

        public static FlowType valueOf(String str) {
            return (FlowType) Enum.valueOf(FlowType.class, str);
        }

        public static FlowType[] values() {
            return (FlowType[]) $VALUES.clone();
        }

        private FlowType(String str, int i) {
        }

        static {
            FlowType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
