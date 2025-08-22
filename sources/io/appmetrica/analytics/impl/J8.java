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
public final class J8 extends MessageNano {
    public static volatile J8[] h;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f512a;
    public byte[] b;
    public B8 c;
    public H8 d;
    public I8 e;
    public I8 f;
    public K8[] g;

    public J8() {
        a();
    }

    public static J8[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new J8[0];
                }
            }
        }
        return h;
    }

    public final J8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f512a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = K8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f512a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f512a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        B8 b8 = this.c;
        if (b8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, b8);
        }
        H8 h8 = this.d;
        if (h8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, h8);
        }
        I8 i8 = this.e;
        if (i8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, i8);
        }
        I8 i82 = this.f;
        if (i82 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, i82);
        }
        K8[] k8Arr = this.g;
        if (k8Arr != null && k8Arr.length > 0) {
            int i = 0;
            while (true) {
                K8[] k8Arr2 = this.g;
                if (i >= k8Arr2.length) {
                    break;
                }
                K8 k8 = k8Arr2[i];
                if (k8 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, k8) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f512a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f512a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        B8 b8 = this.c;
        if (b8 != null) {
            codedOutputByteBufferNano.writeMessage(3, b8);
        }
        H8 h8 = this.d;
        if (h8 != null) {
            codedOutputByteBufferNano.writeMessage(4, h8);
        }
        I8 i8 = this.e;
        if (i8 != null) {
            codedOutputByteBufferNano.writeMessage(5, i8);
        }
        I8 i82 = this.f;
        if (i82 != null) {
            codedOutputByteBufferNano.writeMessage(6, i82);
        }
        K8[] k8Arr = this.g;
        if (k8Arr != null && k8Arr.length > 0) {
            int i = 0;
            while (true) {
                K8[] k8Arr2 = this.g;
                if (i >= k8Arr2.length) {
                    break;
                }
                K8 k8 = k8Arr2[i];
                if (k8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, k8);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final J8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f512a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new B8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new H8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag == 42) {
                if (this.e == null) {
                    this.e = new I8();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (readTag == 50) {
                if (this.f == null) {
                    this.f = new I8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            } else if (readTag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                K8[] k8Arr = this.g;
                int length = k8Arr == null ? 0 : k8Arr.length;
                int i = repeatedFieldArrayLength + length;
                K8[] k8Arr2 = new K8[i];
                if (length != 0) {
                    System.arraycopy(k8Arr, 0, k8Arr2, 0, length);
                }
                while (length < i - 1) {
                    K8 k8 = new K8();
                    k8Arr2[length] = k8;
                    codedInputByteBufferNano.readMessage(k8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                K8 k82 = new K8();
                k8Arr2[length] = k82;
                codedInputByteBufferNano.readMessage(k82);
                this.g = k8Arr2;
            }
        }
        return this;
    }

    public static J8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new J8().mergeFrom(codedInputByteBufferNano);
    }

    public static J8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (J8) MessageNano.mergeFrom(new J8(), bArr);
    }
}
