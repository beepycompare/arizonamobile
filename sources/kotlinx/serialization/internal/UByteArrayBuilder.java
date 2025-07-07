package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;
/* compiled from: PrimitiveArraysSerializers.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0010¢\u0006\u0002\b\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0006\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@RX\u0090\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/internal/UByteArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlin/UByteArray;", "bufferWithData", "<init>", "([BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "buffer", "[B", "value", "", "position", "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", "", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "append", "c", "Lkotlin/UByte;", "append-7apg3OU$kotlinx_serialization_core", "(B)V", "build", "build-TcUX1vc$kotlinx_serialization_core", "()[B", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
/* loaded from: classes5.dex */
public final class UByteArrayBuilder extends PrimitiveArrayBuilder<UByteArray> {
    private byte[] buffer;
    private int position;

    public /* synthetic */ UByteArrayBuilder(byte[] bArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ UByteArray build$kotlinx_serialization_core() {
        return UByteArray.m8514boximpl(m10118buildTcUX1vc$kotlinx_serialization_core());
    }

    private UByteArrayBuilder(byte[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = UByteArray.m8522getSizeimpl(bufferWithData);
        ensureCapacity$kotlinx_serialization_core(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void ensureCapacity$kotlinx_serialization_core(int i) {
        if (UByteArray.m8522getSizeimpl(this.buffer) < i) {
            byte[] bArr = this.buffer;
            byte[] copyOf = Arrays.copyOf(bArr, RangesKt.coerceAtLeast(i, UByteArray.m8522getSizeimpl(bArr) * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.buffer = UByteArray.m8516constructorimpl(copyOf);
        }
    }

    /* renamed from: append-7apg3OU$kotlinx_serialization_core  reason: not valid java name */
    public final void m10117append7apg3OU$kotlinx_serialization_core(byte b) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        byte[] bArr = this.buffer;
        int position$kotlinx_serialization_core = getPosition$kotlinx_serialization_core();
        this.position = position$kotlinx_serialization_core + 1;
        UByteArray.m8526setVurrAj0(bArr, position$kotlinx_serialization_core, b);
    }

    /* renamed from: build-TcUX1vc$kotlinx_serialization_core  reason: not valid java name */
    public byte[] m10118buildTcUX1vc$kotlinx_serialization_core() {
        byte[] copyOf = Arrays.copyOf(this.buffer, getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return UByteArray.m8516constructorimpl(copyOf);
    }
}
