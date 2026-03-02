package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.n8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0446n8 extends MessageNano {
    public static volatile C0446n8[] h;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1131a;
    public byte[] b;
    public C0242f8 c;
    public C0396l8 d;
    public C0421m8 e;
    public C0421m8 f;
    public C0471o8[] g;

    public C0446n8() {
        a();
    }

    public static C0446n8[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new C0446n8[0];
                }
            }
        }
        return h;
    }

    public final C0446n8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f1131a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = C0471o8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f1131a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f1131a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        C0242f8 c0242f8 = this.c;
        if (c0242f8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0242f8);
        }
        C0396l8 c0396l8 = this.d;
        if (c0396l8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0396l8);
        }
        C0421m8 c0421m8 = this.e;
        if (c0421m8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0421m8);
        }
        C0421m8 c0421m82 = this.f;
        if (c0421m82 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, c0421m82);
        }
        C0471o8[] c0471o8Arr = this.g;
        if (c0471o8Arr != null && c0471o8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0471o8[] c0471o8Arr2 = this.g;
                if (i >= c0471o8Arr2.length) {
                    break;
                }
                C0471o8 c0471o8 = c0471o8Arr2[i];
                if (c0471o8 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, c0471o8) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f1131a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f1131a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        C0242f8 c0242f8 = this.c;
        if (c0242f8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0242f8);
        }
        C0396l8 c0396l8 = this.d;
        if (c0396l8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0396l8);
        }
        C0421m8 c0421m8 = this.e;
        if (c0421m8 != null) {
            codedOutputByteBufferNano.writeMessage(5, c0421m8);
        }
        C0421m8 c0421m82 = this.f;
        if (c0421m82 != null) {
            codedOutputByteBufferNano.writeMessage(6, c0421m82);
        }
        C0471o8[] c0471o8Arr = this.g;
        if (c0471o8Arr != null && c0471o8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0471o8[] c0471o8Arr2 = this.g;
                if (i >= c0471o8Arr2.length) {
                    break;
                }
                C0471o8 c0471o8 = c0471o8Arr2[i];
                if (c0471o8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c0471o8);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0446n8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1131a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0242f8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new C0396l8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag == 42) {
                if (this.e == null) {
                    this.e = new C0421m8();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (readTag == 50) {
                if (this.f == null) {
                    this.f = new C0421m8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            } else if (readTag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C0471o8[] c0471o8Arr = this.g;
                int length = c0471o8Arr == null ? 0 : c0471o8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0471o8[] c0471o8Arr2 = new C0471o8[i];
                if (length != 0) {
                    System.arraycopy(c0471o8Arr, 0, c0471o8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0471o8 c0471o8 = new C0471o8();
                    c0471o8Arr2[length] = c0471o8;
                    codedInputByteBufferNano.readMessage(c0471o8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0471o8 c0471o82 = new C0471o8();
                c0471o8Arr2[length] = c0471o82;
                codedInputByteBufferNano.readMessage(c0471o82);
                this.g = c0471o8Arr2;
            }
        }
        return this;
    }

    public static C0446n8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0446n8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0446n8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0446n8) MessageNano.mergeFrom(new C0446n8(), bArr);
    }
}
