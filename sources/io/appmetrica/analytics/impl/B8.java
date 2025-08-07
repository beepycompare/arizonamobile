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
public final class B8 extends MessageNano {
    public static volatile B8[] f;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f353a;
    public byte[] b;
    public F8 c;
    public C8[] d;
    public int e;

    public B8() {
        a();
    }

    public static B8[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new B8[0];
                }
            }
        }
        return f;
    }

    public final B8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f353a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = C8.b();
        this.e = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f353a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f353a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        F8 f8 = this.c;
        if (f8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, f8);
        }
        C8[] c8Arr = this.d;
        if (c8Arr != null && c8Arr.length > 0) {
            int i = 0;
            while (true) {
                C8[] c8Arr2 = this.d;
                if (i >= c8Arr2.length) {
                    break;
                }
                C8 c8 = c8Arr2[i];
                if (c8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c8);
                }
                i++;
            }
        }
        int i2 = this.e;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(5, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f353a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f353a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        F8 f8 = this.c;
        if (f8 != null) {
            codedOutputByteBufferNano.writeMessage(3, f8);
        }
        C8[] c8Arr = this.d;
        if (c8Arr != null && c8Arr.length > 0) {
            int i = 0;
            while (true) {
                C8[] c8Arr2 = this.d;
                if (i >= c8Arr2.length) {
                    break;
                }
                C8 c8 = c8Arr2[i];
                if (c8 != null) {
                    codedOutputByteBufferNano.writeMessage(4, c8);
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
    public final B8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f353a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new F8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                C8[] c8Arr = this.d;
                int length = c8Arr == null ? 0 : c8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C8[] c8Arr2 = new C8[i];
                if (length != 0) {
                    System.arraycopy(c8Arr, 0, c8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C8 c8 = new C8();
                    c8Arr2[length] = c8;
                    codedInputByteBufferNano.readMessage(c8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C8 c82 = new C8();
                c8Arr2[length] = c82;
                codedInputByteBufferNano.readMessage(c82);
                this.d = c8Arr2;
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

    public static B8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new B8().mergeFrom(codedInputByteBufferNano);
    }

    public static B8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (B8) MessageNano.mergeFrom(new B8(), bArr);
    }
}
