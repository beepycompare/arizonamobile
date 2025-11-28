package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class E3 extends MessageNano {
    public static volatile E3[] b;

    /* renamed from: a  reason: collision with root package name */
    public D3[] f450a;

    public E3() {
        a();
    }

    public static E3[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new E3[0];
                }
            }
        }
        return b;
    }

    public final E3 a() {
        this.f450a = D3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        D3[] d3Arr = this.f450a;
        if (d3Arr != null && d3Arr.length > 0) {
            int i = 0;
            while (true) {
                D3[] d3Arr2 = this.f450a;
                if (i >= d3Arr2.length) {
                    break;
                }
                D3 d3 = d3Arr2[i];
                if (d3 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, d3) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        D3[] d3Arr = this.f450a;
        if (d3Arr != null && d3Arr.length > 0) {
            int i = 0;
            while (true) {
                D3[] d3Arr2 = this.f450a;
                if (i >= d3Arr2.length) {
                    break;
                }
                D3 d3 = d3Arr2[i];
                if (d3 != null) {
                    codedOutputByteBufferNano.writeMessage(1, d3);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final E3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                D3[] d3Arr = this.f450a;
                int length = d3Arr == null ? 0 : d3Arr.length;
                int i = repeatedFieldArrayLength + length;
                D3[] d3Arr2 = new D3[i];
                if (length != 0) {
                    System.arraycopy(d3Arr, 0, d3Arr2, 0, length);
                }
                while (length < i - 1) {
                    D3 d3 = new D3();
                    d3Arr2[length] = d3;
                    codedInputByteBufferNano.readMessage(d3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                D3 d32 = new D3();
                d3Arr2[length] = d32;
                codedInputByteBufferNano.readMessage(d32);
                this.f450a = d3Arr2;
            }
        }
        return this;
    }

    public static E3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new E3().mergeFrom(codedInputByteBufferNano);
    }

    public static E3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (E3) MessageNano.mergeFrom(new E3(), bArr);
    }
}
