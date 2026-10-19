package kotlinx.metadata.internal.metadata.serialization;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder;
/* compiled from: MutableTable.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0096\u0002R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/metadata/internal/metadata/serialization/TableElementWrapper;", "Element", "Lkotlinx/metadata/internal/protobuf/GeneratedMessageLite$Builder;", "", "builder", "<init>", "(Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;)V", "getBuilder", "()Lorg/jetbrains/kotlin/protobuf/GeneratedMessageLite$Builder;", "Lkotlinx/metadata/internal/protobuf/GeneratedMessageLite$Builder;", "bytes", "", "hashCode", "", "equals", "", "other", TtmlNode.TAG_METADATA}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
final class TableElementWrapper<Element extends GeneratedMessageLite.Builder<?, Element>> {
    private final Element builder;
    private final byte[] bytes;
    private final int hashCode;

    public TableElementWrapper(Element builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        byte[] byteArray = builder.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        this.bytes = byteArray;
        this.hashCode = Arrays.hashCode(byteArray);
    }

    public final Element getBuilder() {
        return this.builder;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        return (obj instanceof TableElementWrapper) && Arrays.equals(this.bytes, ((TableElementWrapper) obj).bytes);
    }
}
