package androidx.compose.runtime.tooling;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotReader;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComposeStackTraceBuilder.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a9\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\u0010\t\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\nH\u0000\u001a$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a3\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e2#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0010H\u0000\u001a\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u0007*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"buildTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "Landroidx/compose/runtime/SlotWriter;", "child", "", "group", "", "parent", "(Landroidx/compose/runtime/SlotWriter;Ljava/lang/Object;ILjava/lang/Integer;)Ljava/util/List;", "Landroidx/compose/runtime/SlotReader;", "traceForGroup", "findLocation", "Landroidx/compose/runtime/tooling/ObjectLocation;", "Landroidx/compose/runtime/SlotTable;", "filter", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "findSubcompositionContextGroup", "context", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/CompositionContext;)Ljava/lang/Integer;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposeStackTraceBuilderKt {
    public static /* synthetic */ List buildTrace$default(SlotWriter slotWriter, Object obj, int i, Integer num, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        if ((i2 & 2) != 0) {
            i = slotWriter.getCurrentGroup();
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        return buildTrace(slotWriter, obj, i, num);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0071 -> B:22:0x0049). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<ComposeStackTraceFrame> buildTrace(SlotWriter slotWriter, Object obj, int i, Integer num) {
        int parent;
        int parent2;
        int groupKey;
        Object empty;
        if (!slotWriter.getClosed() && slotWriter.getSize$runtime() != 0) {
            WriterTraceBuilder writerTraceBuilder = new WriterTraceBuilder(slotWriter);
            if (num != null) {
                parent = num.intValue();
            } else {
                parent = slotWriter.getParent() < 0 ? slotWriter.parent(i) : slotWriter.getParent();
            }
            if (obj == null) {
                obj = Integer.valueOf(slotWriter.groupSlotIndex(i));
            }
            if (slotWriter.isValid(i)) {
                groupKey = slotWriter.groupKey(i);
                while (i >= 0) {
                    if (slotWriter.hasObjectKey(i)) {
                        empty = slotWriter.groupObjectKey(i);
                    } else {
                        empty = Composer.Companion.getEmpty();
                    }
                    writerTraceBuilder.processEdge(groupKey, empty, slotWriter.sourceInformationOf$runtime(i), obj);
                    obj = slotWriter.anchor(i);
                    if (parent >= 0) {
                        parent2 = slotWriter.parent(parent);
                        groupKey = slotWriter.groupKey(parent);
                        int i2 = parent;
                        parent = parent2;
                        i = i2;
                        while (i >= 0) {
                        }
                    } else {
                        i = parent;
                    }
                }
                return writerTraceBuilder.trace();
            }
            parent2 = parent >= 0 ? slotWriter.parent(parent) : parent;
            groupKey = slotWriter.groupKey(parent);
            int i22 = parent;
            parent = parent2;
            i = i22;
            while (i >= 0) {
            }
            return writerTraceBuilder.trace();
        }
        return CollectionsKt.emptyList();
    }

    public static final List<ComposeStackTraceFrame> buildTrace(SlotReader slotReader) {
        Object empty;
        if (!slotReader.getClosed() && slotReader.getSize() != 0) {
            ReaderTraceBuilder readerTraceBuilder = new ReaderTraceBuilder(slotReader);
            int parent = slotReader.getParent();
            Object valueOf = Integer.valueOf(slotReader.getSlot());
            while (parent >= 0) {
                if (slotReader.hasObjectKey(parent)) {
                    empty = slotReader.groupObjectKey(parent);
                } else {
                    empty = Composer.Companion.getEmpty();
                }
                readerTraceBuilder.processEdge(slotReader.groupKey(parent), empty, slotReader.getTable$runtime().sourceInformationOf(parent), valueOf);
                valueOf = slotReader.anchor(parent);
                parent = slotReader.parent(parent);
            }
            return readerTraceBuilder.trace();
        }
        return CollectionsKt.emptyList();
    }

    public static final List<ComposeStackTraceFrame> traceForGroup(SlotReader slotReader, int i, Object obj) {
        Object empty;
        ReaderTraceBuilder readerTraceBuilder = new ReaderTraceBuilder(slotReader);
        int parent = slotReader.parent(i);
        Anchor anchor = slotReader.anchor(i);
        while (i >= 0) {
            if (slotReader.hasObjectKey(i)) {
                empty = slotReader.groupObjectKey(i);
            } else {
                empty = Composer.Companion.getEmpty();
            }
            readerTraceBuilder.processEdge(slotReader.groupKey(i), empty, slotReader.getTable$runtime().sourceInformationOf(i), obj);
            if (parent >= 0) {
                Anchor anchor2 = anchor;
                anchor = slotReader.anchor(parent);
                i = parent;
                parent = slotReader.parent(parent);
                obj = anchor2;
            } else {
                i = parent;
                obj = anchor;
            }
        }
        return readerTraceBuilder.trace();
    }

    private static final Integer findSubcompositionContextGroup$lambda$0$scanGroup(SlotReader slotReader, CompositionContext compositionContext, int i, int i2) {
        Integer findSubcompositionContextGroup$lambda$0$scanGroup;
        while (true) {
            if (i >= i2) {
                return null;
            }
            int groupSize = slotReader.groupSize(i) + i;
            if (slotReader.hasMark(i) && slotReader.groupKey(i) == 206 && Intrinsics.areEqual(slotReader.groupObjectKey(i), ComposerKt.getReference())) {
                Object groupGet = slotReader.groupGet(i, 0);
                RememberObserverHolder rememberObserverHolder = groupGet instanceof RememberObserverHolder ? (RememberObserverHolder) groupGet : null;
                RememberObserver wrapped = rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null;
                ComposerImpl.CompositionContextHolder compositionContextHolder = wrapped instanceof ComposerImpl.CompositionContextHolder ? wrapped : null;
                if (compositionContextHolder != null && Intrinsics.areEqual(compositionContextHolder.getRef(), compositionContext)) {
                    return Integer.valueOf(i);
                }
            }
            if (slotReader.containsMark(i) && (findSubcompositionContextGroup$lambda$0$scanGroup = findSubcompositionContextGroup$lambda$0$scanGroup(slotReader, compositionContext, i + 1, groupSize)) != null) {
                return Integer.valueOf(findSubcompositionContextGroup$lambda$0$scanGroup.intValue());
            }
            i = groupSize;
        }
    }

    public static final ObjectLocation findLocation(SlotTable slotTable, Function1<Object, Boolean> function1) {
        SlotReader openReader = slotTable.openReader();
        for (int i = 0; i < slotTable.getGroupsSize(); i++) {
            try {
                if (openReader.isNode(i) && function1.invoke(openReader.node(i)).booleanValue()) {
                    return new ObjectLocation(i, null);
                }
                int slotSize = openReader.slotSize(i);
                for (int i2 = 0; i2 < slotSize; i2++) {
                    if (function1.invoke(openReader.groupGet(i, i2)).booleanValue()) {
                        return new ObjectLocation(i, Integer.valueOf(i2));
                    }
                }
            } finally {
                openReader.close();
            }
        }
        Unit unit = Unit.INSTANCE;
        return null;
    }

    public static final Integer findSubcompositionContextGroup(SlotTable slotTable, CompositionContext compositionContext) {
        SlotReader openReader = slotTable.openReader();
        try {
            return findSubcompositionContextGroup$lambda$0$scanGroup(openReader, compositionContext, 0, openReader.getSize());
        } finally {
            openReader.close();
        }
    }
}
