package kotlinx.serialization.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
/* compiled from: PrimitiveArraysSerializers.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\bB¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t*\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u0005*\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0094\u0080\u0004J)\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0094\u0080\u0004¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lkotlinx/serialization/internal/UIntArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UIntArray;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlin/UInt;", "Lkotlinx/serialization/internal/UIntArrayBuilder;", "<init>", "()V", "collectionSize", "", "collectionSize--ajY-9A", "([I)I", "toBuilder", "toBuilder--ajY-9A", "([I)Lkotlinx/serialization/internal/UIntArrayBuilder;", "empty", "empty--hP7Qyg", "()[I", "readElement", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", FirebaseAnalytics.Param.INDEX, "builder", "checkIndex", "", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", FirebaseAnalytics.Param.CONTENT, "size", "writeContent-CPlH8fI", "(Lkotlinx/serialization/encoding/CompositeEncoder;[II)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
/* loaded from: classes5.dex */
public final class UIntArraySerializer extends PrimitiveArraySerializer<UInt, UIntArray, UIntArrayBuilder> implements KSerializer<UIntArray> {
    public static final UIntArraySerializer INSTANCE = new UIntArraySerializer();

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ int collectionSize(Object obj) {
        return m10876collectionSizeajY9A(((UIntArray) obj).m9371unboximpl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ UIntArray empty() {
        return UIntArray.m9355boximpl(m10877emptyhP7Qyg());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ Object toBuilder(Object obj) {
        return m10878toBuilderajY9A(((UIntArray) obj).m9371unboximpl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ void writeContent(CompositeEncoder compositeEncoder, UIntArray uIntArray, int i) {
        m10879writeContentCPlH8fI(compositeEncoder, uIntArray.m9371unboximpl(), i);
    }

    private UIntArraySerializer() {
        super(BuiltinSerializersKt.serializer(UInt.Companion));
    }

    /* renamed from: collectionSize--ajY-9A  reason: not valid java name */
    protected int m10876collectionSizeajY9A(int[] collectionSize) {
        Intrinsics.checkNotNullParameter(collectionSize, "$this$collectionSize");
        return UIntArray.m9363getSizeimpl(collectionSize);
    }

    /* renamed from: toBuilder--ajY-9A  reason: not valid java name */
    protected UIntArrayBuilder m10878toBuilderajY9A(int[] toBuilder) {
        Intrinsics.checkNotNullParameter(toBuilder, "$this$toBuilder");
        return new UIntArrayBuilder(toBuilder, null);
    }

    /* renamed from: empty--hP7Qyg  reason: not valid java name */
    protected int[] m10877emptyhP7Qyg() {
        return UIntArray.m9356constructorimpl(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void readElement(CompositeDecoder decoder, int i, UIntArrayBuilder builder, boolean z) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.m10874appendWZ4Q5Ns$kotlinx_serialization_core(UInt.m9302constructorimpl(decoder.decodeInlineElement(getDescriptor(), i).decodeInt()));
    }

    /* renamed from: writeContent-CPlH8fI  reason: not valid java name */
    protected void m10879writeContentCPlH8fI(CompositeEncoder encoder, int[] content, int i) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeInlineElement(getDescriptor(), i2).encodeInt(UIntArray.m9362getpVg5ArA(content, i2));
        }
    }
}
