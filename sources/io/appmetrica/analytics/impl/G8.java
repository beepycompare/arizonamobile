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
public final class G8 extends MessageNano {
    public static volatile G8[] f;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f458a;
    public byte[] b;
    public K8 c;
    public H8[] d;
    public int e;

    public G8() {
        a();
    }

    public static G8[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new G8[0];
                }
            }
        }
        return f;
    }

    public final G8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f458a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = H8.b();
        this.e = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f458a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f458a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        K8 k8 = this.c;
        if (k8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, k8);
        }
        H8[] h8Arr = this.d;
        if (h8Arr != null && h8Arr.length > 0) {
            int i = 0;
            while (true) {
                H8[] h8Arr2 = this.d;
                if (i >= h8Arr2.length) {
                    break;
                }
                H8 h8 = h8Arr2[i];
                if (h8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, h8);
                }
                i++;
            }
        }
        int i2 = this.e;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(5, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f458a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f458a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        K8 k8 = this.c;
        if (k8 != null) {
            codedOutputByteBufferNano.writeMessage(3, k8);
        }
        H8[] h8Arr = this.d;
        if (h8Arr != null && h8Arr.length > 0) {
            int i = 0;
            while (true) {
                H8[] h8Arr2 = this.d;
                if (i >= h8Arr2.length) {
                    break;
                }
                H8 h8 = h8Arr2[i];
                if (h8 != null) {
                    codedOutputByteBufferNano.writeMessage(4, h8);
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
    public final G8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f458a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new K8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                H8[] h8Arr = this.d;
                int length = h8Arr == null ? 0 : h8Arr.length;
                int i = repeatedFieldArrayLength + length;
                H8[] h8Arr2 = new H8[i];
                if (length != 0) {
                    System.arraycopy(h8Arr, 0, h8Arr2, 0, length);
                }
                while (length < i - 1) {
                    H8 h8 = new H8();
                    h8Arr2[length] = h8;
                    codedInputByteBufferNano.readMessage(h8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                H8 h82 = new H8();
                h8Arr2[length] = h82;
                codedInputByteBufferNano.readMessage(h82);
                this.d = h8Arr2;
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

    public static G8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new G8().mergeFrom(codedInputByteBufferNano);
    }

    public static G8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (G8) MessageNano.mergeFrom(new G8(), bArr);
    }
}
