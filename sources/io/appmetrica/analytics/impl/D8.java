package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class D8 extends MessageNano {
    public static volatile D8[] f;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f392a;
    public byte[] b;
    public H8 c;
    public E8[] d;
    public int e;

    public D8() {
        a();
    }

    public static D8[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new D8[0];
                }
            }
        }
        return f;
    }

    public final D8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f392a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = E8.b();
        this.e = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f392a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f392a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        H8 h8 = this.c;
        if (h8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, h8);
        }
        E8[] e8Arr = this.d;
        if (e8Arr != null && e8Arr.length > 0) {
            int i = 0;
            while (true) {
                E8[] e8Arr2 = this.d;
                if (i >= e8Arr2.length) {
                    break;
                }
                E8 e8 = e8Arr2[i];
                if (e8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, e8);
                }
                i++;
            }
        }
        int i2 = this.e;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(5, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f392a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f392a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        H8 h8 = this.c;
        if (h8 != null) {
            codedOutputByteBufferNano.writeMessage(3, h8);
        }
        E8[] e8Arr = this.d;
        if (e8Arr != null && e8Arr.length > 0) {
            int i = 0;
            while (true) {
                E8[] e8Arr2 = this.d;
                if (i >= e8Arr2.length) {
                    break;
                }
                E8 e8 = e8Arr2[i];
                if (e8 != null) {
                    codedOutputByteBufferNano.writeMessage(4, e8);
                }
                i++;
            }
        }
        int i2 = this.e;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final D8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f392a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new H8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                E8[] e8Arr = this.d;
                int length = e8Arr == null ? 0 : e8Arr.length;
                int i = repeatedFieldArrayLength + length;
                E8[] e8Arr2 = new E8[i];
                if (length != 0) {
                    System.arraycopy(e8Arr, 0, e8Arr2, 0, length);
                }
                while (length < i - 1) {
                    E8 e8 = new E8();
                    e8Arr2[length] = e8;
                    codedInputByteBufferNano.readMessage(e8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                E8 e82 = new E8();
                e8Arr2[length] = e82;
                codedInputByteBufferNano.readMessage(e82);
                this.d = e8Arr2;
            } else if (readTag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.e = codedInputByteBufferNano.readUInt32();
            }
        }
        return this;
    }

    public static D8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new D8().mergeFrom(codedInputByteBufferNano);
    }

    public static D8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (D8) MessageNano.mergeFrom(new D8(), bArr);
    }
}
