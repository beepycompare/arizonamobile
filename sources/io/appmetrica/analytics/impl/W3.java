package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class W3 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile W3[] g;

    /* renamed from: a  reason: collision with root package name */
    public T3 f717a;
    public T3[] b;

    public W3() {
        a();
    }

    public static W3[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new W3[0];
                }
            }
        }
        return g;
    }

    public final W3 a() {
        this.f717a = null;
        this.b = T3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        T3 t3 = this.f717a;
        if (t3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, t3);
        }
        T3[] t3Arr = this.b;
        if (t3Arr != null && t3Arr.length > 0) {
            int i = 0;
            while (true) {
                T3[] t3Arr2 = this.b;
                if (i >= t3Arr2.length) {
                    break;
                }
                T3 t32 = t3Arr2[i];
                if (t32 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, t32) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        T3 t3 = this.f717a;
        if (t3 != null) {
            codedOutputByteBufferNano.writeMessage(1, t3);
        }
        T3[] t3Arr = this.b;
        if (t3Arr != null && t3Arr.length > 0) {
            int i = 0;
            while (true) {
                T3[] t3Arr2 = this.b;
                if (i >= t3Arr2.length) {
                    break;
                }
                T3 t32 = t3Arr2[i];
                if (t32 != null) {
                    codedOutputByteBufferNano.writeMessage(2, t32);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final W3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f717a == null) {
                    this.f717a = new T3();
                }
                codedInputByteBufferNano.readMessage(this.f717a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                T3[] t3Arr = this.b;
                int length = t3Arr == null ? 0 : t3Arr.length;
                int i = repeatedFieldArrayLength + length;
                T3[] t3Arr2 = new T3[i];
                if (length != 0) {
                    System.arraycopy(t3Arr, 0, t3Arr2, 0, length);
                }
                while (length < i - 1) {
                    T3 t3 = new T3();
                    t3Arr2[length] = t3;
                    codedInputByteBufferNano.readMessage(t3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                T3 t32 = new T3();
                t3Arr2[length] = t32;
                codedInputByteBufferNano.readMessage(t32);
                this.b = t3Arr2;
            }
        }
        return this;
    }

    public static W3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new W3().mergeFrom(codedInputByteBufferNano);
    }

    public static W3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (W3) MessageNano.mergeFrom(new W3(), bArr);
    }
}
