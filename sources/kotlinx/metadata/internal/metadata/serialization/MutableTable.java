package kotlinx.metadata.internal.metadata.serialization;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder;
import kotlinx.metadata.internal.protobuf.MessageLite;
/* compiled from: MutableTable.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u00010\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\u0014\b\u0002\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\u00022\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\f\u001a\u00028\u0002H$¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00022\u0006\u0010\u0011\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0016J\r\u0010\u0017\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0018R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/metadata/internal/metadata/serialization/MutableTable;", "Element", "Lkotlinx/metadata/internal/protobuf/GeneratedMessageLite$Builder;", "Table", "Lkotlinx/metadata/internal/protobuf/GeneratedMessageLite;", "TableBuilder", "", "<init>", "()V", "interner", "Lkotlinx/metadata/internal/metadata/serialization/Interner;", "Lkotlinx/metadata/internal/metadata/serialization/TableElementWrapper;", "createTableBuilder", "()Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;", "addElement", "", "builder", "element", "(Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;)V", "get", "", "type", "(Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;)I", "serialize", "()Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite;", TtmlNode.TAG_METADATA}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public abstract class MutableTable<Element extends GeneratedMessageLite.Builder<?, Element>, Table extends GeneratedMessageLite, TableBuilder extends GeneratedMessageLite.Builder<Table, TableBuilder>> {
    private final Interner<TableElementWrapper<Element>> interner = new Interner<>(null, 1, null);

    protected abstract void addElement(TableBuilder tablebuilder, Element element);

    protected abstract TableBuilder createTableBuilder();

    public final int get(Element type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.interner.intern(new TableElementWrapper<>(type));
    }

    public final Table serialize() {
        if (this.interner.isEmpty()) {
            return null;
        }
        TableBuilder createTableBuilder = createTableBuilder();
        for (TableElementWrapper<Element> tableElementWrapper : this.interner.getAllInternedObjects()) {
            addElement(createTableBuilder, tableElementWrapper.getBuilder());
        }
        MessageLite build = createTableBuilder.build();
        Intrinsics.checkNotNull(build, "null cannot be cast to non-null type Table of org.jetbrains.kotlin.metadata.serialization.MutableTable");
        return (Table) build;
    }
}
