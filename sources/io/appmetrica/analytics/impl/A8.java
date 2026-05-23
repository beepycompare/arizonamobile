package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class A8 extends MessageNano {
    public static volatile A8[] f;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f453a;
    public byte[] b;
    public E8 c;
    public B8[] d;
    public int e;

    public A8() {
        a();
    }

    public static A8[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new A8[0];
                }
            }
        }
        return f;
    }

    public final A8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f453a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = B8.b();
        this.e = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f453a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f453a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        E8 e8 = this.c;
        if (e8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, e8);
        }
        B8[] b8Arr = this.d;
        if (b8Arr != null && b8Arr.length > 0) {
            int i = 0;
            while (true) {
                B8[] b8Arr2 = this.d;
                if (i >= b8Arr2.length) {
                    break;
                }
                B8 b8 = b8Arr2[i];
                if (b8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, b8);
                }
                i++;
            }
        }
        int i2 = this.e;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(5, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f453a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f453a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        E8 e8 = this.c;
        if (e8 != null) {
            codedOutputByteBufferNano.writeMessage(3, e8);
        }
        B8[] b8Arr = this.d;
        if (b8Arr != null && b8Arr.length > 0) {
            int i = 0;
            while (true) {
                B8[] b8Arr2 = this.d;
                if (i >= b8Arr2.length) {
                    break;
                }
                B8 b8 = b8Arr2[i];
                if (b8 != null) {
                    codedOutputByteBufferNano.writeMessage(4, b8);
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
    public final A8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f453a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new E8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                B8[] b8Arr = this.d;
                int length = b8Arr == null ? 0 : b8Arr.length;
                int i = repeatedFieldArrayLength + length;
                B8[] b8Arr2 = new B8[i];
                if (length != 0) {
                    System.arraycopy(b8Arr, 0, b8Arr2, 0, length);
                }
                while (length < i - 1) {
                    B8 b8 = new B8();
                    b8Arr2[length] = b8;
                    codedInputByteBufferNano.readMessage(b8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                B8 b82 = new B8();
                b8Arr2[length] = b82;
                codedInputByteBufferNano.readMessage(b82);
                this.d = b8Arr2;
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

    public static A8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new A8().mergeFrom(codedInputByteBufferNano);
    }

    public static A8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (A8) MessageNano.mergeFrom(new A8(), bArr);
    }
}
