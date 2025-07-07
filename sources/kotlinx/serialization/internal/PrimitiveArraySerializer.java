package kotlinx.serialization.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayBuilder;
/* compiled from: CollectionSerializers.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B\u0017\b\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000e\u001a\u00020\u000f*\u00028\u0002H\u0004¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00028\u0001*\u00028\u0002H\u0004¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0004¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018*\u00028\u0001H\u0004¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u001dJ\r\u0010\u001e\u001a\u00028\u0002H\u0004¢\u0006\u0002\u0010\u001fJ\r\u0010 \u001a\u00028\u0001H$¢\u0006\u0002\u0010!J-\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00028\u00022\u0006\u0010%\u001a\u00020&H$¢\u0006\u0002\u0010'J%\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00020\u000fH$¢\u0006\u0002\u0010,J\u001b\u0010-\u001a\u00020\u00142\u0006\u0010)\u001a\u00020.2\u0006\u0010/\u001a\u00028\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00028\u00012\u0006\u0010#\u001a\u000202¢\u0006\u0002\u00103R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u00064"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Element", "Array", "Builder", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "primitiveSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builderSize", "", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)I", "toResult", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)Ljava/lang/Object;", "checkCapacity", "", "size", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "insert", FirebaseAnalytics.Param.INDEX, "element", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;ILjava/lang/Object;)V", "builder", "()Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "empty", "()Ljava/lang/Object;", "readElement", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/PrimitiveArrayBuilder;Z)V", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", FirebaseAnalytics.Param.CONTENT, "(Lkotlinx/serialization/encoding/CompositeEncoder;Ljava/lang/Object;I)V", "serialize", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PrimitiveArraySerializer<Element, Array, Builder extends PrimitiveArrayBuilder<Array>> extends CollectionLikeSerializer<Element, Array, Builder> {
    private final SerialDescriptor descriptor;

    protected abstract Array empty();

    protected abstract void readElement(CompositeDecoder compositeDecoder, int i, Builder builder, boolean z);

    protected abstract void writeContent(CompositeEncoder compositeEncoder, Array array, int i);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ int builderSize(Object obj) {
        return builderSize((PrimitiveArraySerializer<Element, Array, Builder>) ((PrimitiveArrayBuilder) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ void checkCapacity(Object obj, int i) {
        checkCapacity((PrimitiveArraySerializer<Element, Array, Builder>) ((PrimitiveArrayBuilder) obj), i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public /* bridge */ /* synthetic */ void insert(Object obj, int i, Object obj2) {
        insert((PrimitiveArraySerializer<Element, Array, Builder>) ((PrimitiveArrayBuilder) obj), i, (int) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ Object toResult(Object obj) {
        return toResult((PrimitiveArraySerializer<Element, Array, Builder>) ((PrimitiveArrayBuilder) obj));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveArraySerializer(KSerializer<Element> primitiveSerializer) {
        super(primitiveSerializer, null);
        Intrinsics.checkNotNullParameter(primitiveSerializer, "primitiveSerializer");
        this.descriptor = new PrimitiveArrayDescriptor(primitiveSerializer.getDescriptor());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    protected final int builderSize(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.getPosition$kotlinx_serialization_core();
    }

    protected final Array toResult(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return (Array) builder.build$kotlinx_serialization_core();
    }

    protected final void checkCapacity(Builder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.ensureCapacity$kotlinx_serialization_core(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Iterator<Element> collectionIterator(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    protected final void insert(Builder builder, int i, Element element) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Builder builder() {
        return (Builder) toBuilder(empty());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer, kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Array array) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int collectionSize = collectionSize(array);
        SerialDescriptor serialDescriptor = this.descriptor;
        CompositeEncoder beginCollection = encoder.beginCollection(serialDescriptor, collectionSize);
        writeContent(beginCollection, array, collectionSize);
        beginCollection.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer, kotlinx.serialization.DeserializationStrategy
    public final Array deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return merge(decoder, null);
    }
}
