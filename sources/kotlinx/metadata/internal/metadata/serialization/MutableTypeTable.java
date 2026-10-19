package kotlinx.metadata.internal.metadata.serialization;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.ProtoBuf;
/* compiled from: MutableTable.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lkotlinx/metadata/internal/metadata/serialization/MutableTypeTable;", "Lkotlinx/metadata/internal/metadata/serialization/MutableTable;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Type$Builder;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeTable;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeTable$Builder;", "<init>", "()V", "createTableBuilder", "addElement", "", "builder", "element", TtmlNode.TAG_METADATA}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class MutableTypeTable extends MutableTable<ProtoBuf.Type.Builder, ProtoBuf.TypeTable, ProtoBuf.TypeTable.Builder> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.metadata.internal.metadata.serialization.MutableTable
    public ProtoBuf.TypeTable.Builder createTableBuilder() {
        ProtoBuf.TypeTable.Builder newBuilder = ProtoBuf.TypeTable.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder(...)");
        return newBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.metadata.internal.metadata.serialization.MutableTable
    public void addElement(ProtoBuf.TypeTable.Builder builder, ProtoBuf.Type.Builder element) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(element, "element");
        builder.addType(element);
    }
}
