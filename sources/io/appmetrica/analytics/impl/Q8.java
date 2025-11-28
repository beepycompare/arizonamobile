package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Q8 extends MessageNano {
    public static volatile Q8[] b;

    /* renamed from: a  reason: collision with root package name */
    public P8[] f648a;

    public Q8() {
        a();
    }

    public static Q8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Q8[0];
                }
            }
        }
        return b;
    }

    public final Q8 a() {
        this.f648a = P8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        P8[] p8Arr = this.f648a;
        if (p8Arr != null && p8Arr.length > 0) {
            int i = 0;
            while (true) {
                P8[] p8Arr2 = this.f648a;
                if (i >= p8Arr2.length) {
                    break;
                }
                P8 p8 = p8Arr2[i];
                if (p8 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, p8) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        P8[] p8Arr = this.f648a;
        if (p8Arr != null && p8Arr.length > 0) {
            int i = 0;
            while (true) {
                P8[] p8Arr2 = this.f648a;
                if (i >= p8Arr2.length) {
                    break;
                }
                P8 p8 = p8Arr2[i];
                if (p8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, p8);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Q8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                P8[] p8Arr = this.f648a;
                int length = p8Arr == null ? 0 : p8Arr.length;
                int i = repeatedFieldArrayLength + length;
                P8[] p8Arr2 = new P8[i];
                if (length != 0) {
                    System.arraycopy(p8Arr, 0, p8Arr2, 0, length);
                }
                while (length < i - 1) {
                    P8 p8 = new P8();
                    p8Arr2[length] = p8;
                    codedInputByteBufferNano.readMessage(p8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                P8 p82 = new P8();
                p8Arr2[length] = p82;
                codedInputByteBufferNano.readMessage(p82);
                this.f648a = p8Arr2;
            }
        }
        return this;
    }

    public static Q8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Q8().mergeFrom(codedInputByteBufferNano);
    }

    public static Q8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Q8) MessageNano.mergeFrom(new Q8(), bArr);
    }
}
