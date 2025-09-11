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
public final class M8 extends MessageNano {
    public static volatile M8[] h;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f574a;
    public byte[] b;
    public E8 c;
    public K8 d;
    public L8 e;
    public L8 f;
    public N8[] g;

    public M8() {
        a();
    }

    public static M8[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new M8[0];
                }
            }
        }
        return h;
    }

    public final M8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f574a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = N8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f574a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f574a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        E8 e8 = this.c;
        if (e8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, e8);
        }
        K8 k8 = this.d;
        if (k8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, k8);
        }
        L8 l8 = this.e;
        if (l8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, l8);
        }
        L8 l82 = this.f;
        if (l82 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, l82);
        }
        N8[] n8Arr = this.g;
        if (n8Arr != null && n8Arr.length > 0) {
            int i = 0;
            while (true) {
                N8[] n8Arr2 = this.g;
                if (i >= n8Arr2.length) {
                    break;
                }
                N8 n8 = n8Arr2[i];
                if (n8 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, n8) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f574a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f574a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        E8 e8 = this.c;
        if (e8 != null) {
            codedOutputByteBufferNano.writeMessage(3, e8);
        }
        K8 k8 = this.d;
        if (k8 != null) {
            codedOutputByteBufferNano.writeMessage(4, k8);
        }
        L8 l8 = this.e;
        if (l8 != null) {
            codedOutputByteBufferNano.writeMessage(5, l8);
        }
        L8 l82 = this.f;
        if (l82 != null) {
            codedOutputByteBufferNano.writeMessage(6, l82);
        }
        N8[] n8Arr = this.g;
        if (n8Arr != null && n8Arr.length > 0) {
            int i = 0;
            while (true) {
                N8[] n8Arr2 = this.g;
                if (i >= n8Arr2.length) {
                    break;
                }
                N8 n8 = n8Arr2[i];
                if (n8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, n8);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final M8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f574a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new E8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new K8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag == 42) {
                if (this.e == null) {
                    this.e = new L8();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (readTag == 50) {
                if (this.f == null) {
                    this.f = new L8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            } else if (readTag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                N8[] n8Arr = this.g;
                int length = n8Arr == null ? 0 : n8Arr.length;
                int i = repeatedFieldArrayLength + length;
                N8[] n8Arr2 = new N8[i];
                if (length != 0) {
                    System.arraycopy(n8Arr, 0, n8Arr2, 0, length);
                }
                while (length < i - 1) {
                    N8 n8 = new N8();
                    n8Arr2[length] = n8;
                    codedInputByteBufferNano.readMessage(n8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                N8 n82 = new N8();
                n8Arr2[length] = n82;
                codedInputByteBufferNano.readMessage(n82);
                this.g = n8Arr2;
            }
        }
        return this;
    }

    public static M8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new M8().mergeFrom(codedInputByteBufferNano);
    }

    public static M8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (M8) MessageNano.mergeFrom(new M8(), bArr);
    }
}
