package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UShortArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;
/* compiled from: PrimitiveArraysSerializers.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0010¢\u0006\u0002\b\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0006\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@RX\u0090\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/internal/UShortArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlin/UShortArray;", "bufferWithData", "<init>", "([SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "buffer", "[S", "value", "", "position", "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", "", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "append", "c", "Lkotlin/UShort;", "append-xj2QHRw$kotlinx_serialization_core", "(S)V", "build", "build-amswpOA$kotlinx_serialization_core", "()[S", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
/* loaded from: classes5.dex */
public final class UShortArrayBuilder extends PrimitiveArrayBuilder<UShortArray> {
    private short[] buffer;
    private int position;

    public /* synthetic */ UShortArrayBuilder(short[] sArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(sArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ UShortArray build$kotlinx_serialization_core() {
        return UShortArray.m8808boximpl(m10207buildamswpOA$kotlinx_serialization_core());
    }

    private UShortArrayBuilder(short[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = UShortArray.m8816getSizeimpl(bufferWithData);
        ensureCapacity$kotlinx_serialization_core(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void ensureCapacity$kotlinx_serialization_core(int i) {
        if (UShortArray.m8816getSizeimpl(this.buffer) < i) {
            short[] sArr = this.buffer;
            short[] copyOf = Arrays.copyOf(sArr, RangesKt.coerceAtLeast(i, UShortArray.m8816getSizeimpl(sArr) * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.buffer = UShortArray.m8810constructorimpl(copyOf);
        }
    }

    /* renamed from: append-xj2QHRw$kotlinx_serialization_core  reason: not valid java name */
    public final void m10206appendxj2QHRw$kotlinx_serialization_core(short s) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        short[] sArr = this.buffer;
        int position$kotlinx_serialization_core = getPosition$kotlinx_serialization_core();
        this.position = position$kotlinx_serialization_core + 1;
        UShortArray.m8820set01HTLdE(sArr, position$kotlinx_serialization_core, s);
    }

    /* renamed from: build-amswpOA$kotlinx_serialization_core  reason: not valid java name */
    public short[] m10207buildamswpOA$kotlinx_serialization_core() {
        short[] copyOf = Arrays.copyOf(this.buffer, getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return UShortArray.m8810constructorimpl(copyOf);
    }
}
