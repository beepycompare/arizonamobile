package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class E8 extends MessageNano {
    public static volatile E8[] c;

    /* renamed from: a  reason: collision with root package name */
    public D8[] f524a;
    public int b;

    public E8() {
        a();
    }

    public static E8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new E8[0];
                }
            }
        }
        return c;
    }

    public final E8 a() {
        this.f524a = D8.b();
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        D8[] d8Arr = this.f524a;
        if (d8Arr != null && d8Arr.length > 0) {
            int i = 0;
            while (true) {
                D8[] d8Arr2 = this.f524a;
                if (i >= d8Arr2.length) {
                    break;
                }
                D8 d8 = d8Arr2[i];
                if (d8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, d8);
                }
                i++;
            }
        }
        int i2 = this.b;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(2, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        D8[] d8Arr = this.f524a;
        if (d8Arr != null && d8Arr.length > 0) {
            int i = 0;
            while (true) {
                D8[] d8Arr2 = this.f524a;
                if (i >= d8Arr2.length) {
                    break;
                }
                D8 d8 = d8Arr2[i];
                if (d8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, d8);
                }
                i++;
            }
        }
        int i2 = this.b;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final E8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                D8[] d8Arr = this.f524a;
                int length = d8Arr == null ? 0 : d8Arr.length;
                int i = repeatedFieldArrayLength + length;
                D8[] d8Arr2 = new D8[i];
                if (length != 0) {
                    System.arraycopy(d8Arr, 0, d8Arr2, 0, length);
                }
                while (length < i - 1) {
                    D8 d8 = new D8();
                    d8Arr2[length] = d8;
                    codedInputByteBufferNano.readMessage(d8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                D8 d82 = new D8();
                d8Arr2[length] = d82;
                codedInputByteBufferNano.readMessage(d82);
                this.f524a = d8Arr2;
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readUInt32();
            }
        }
        return this;
    }

    public static E8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new E8().mergeFrom(codedInputByteBufferNano);
    }

    public static E8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (E8) MessageNano.mergeFrom(new E8(), bArr);
    }
}
