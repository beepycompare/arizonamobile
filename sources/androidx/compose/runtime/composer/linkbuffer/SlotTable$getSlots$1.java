package androidx.compose.runtime.composer.linkbuffer;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0011\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H\u0096\u0002¨\u0006\u0005"}, d2 = {"androidx/compose/runtime/composer/linkbuffer/SlotTable$getSlots$1", "", "", "iterator", "", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTable$getSlots$1 implements Iterable<Object>, KMappedMarker {
    final /* synthetic */ SlotTable this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SlotTable$getSlots$1(SlotTable slotTable) {
        this.this$0 = slotTable;
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return SequencesKt.iterator(new SlotTable$getSlots$1$iterator$1(this.this$0, null));
    }
}
