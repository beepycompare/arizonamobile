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
public final class E8 extends MessageNano {
    public static volatile E8[] h;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f405a;
    public byte[] b;
    public C0675w8 c;
    public C8 d;
    public D8 e;
    public D8 f;
    public F8[] g;

    public E8() {
        a();
    }

    public static E8[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new E8[0];
                }
            }
        }
        return h;
    }

    public final E8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f405a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = F8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f405a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f405a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        C0675w8 c0675w8 = this.c;
        if (c0675w8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0675w8);
        }
        C8 c8 = this.d;
        if (c8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c8);
        }
        D8 d8 = this.e;
        if (d8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, d8);
        }
        D8 d82 = this.f;
        if (d82 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, d82);
        }
        F8[] f8Arr = this.g;
        if (f8Arr != null && f8Arr.length > 0) {
            int i = 0;
            while (true) {
                F8[] f8Arr2 = this.g;
                if (i >= f8Arr2.length) {
                    break;
                }
                F8 f8 = f8Arr2[i];
                if (f8 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, f8) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f405a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f405a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        C0675w8 c0675w8 = this.c;
        if (c0675w8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0675w8);
        }
        C8 c8 = this.d;
        if (c8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c8);
        }
        D8 d8 = this.e;
        if (d8 != null) {
            codedOutputByteBufferNano.writeMessage(5, d8);
        }
        D8 d82 = this.f;
        if (d82 != null) {
            codedOutputByteBufferNano.writeMessage(6, d82);
        }
        F8[] f8Arr = this.g;
        if (f8Arr != null && f8Arr.length > 0) {
            int i = 0;
            while (true) {
                F8[] f8Arr2 = this.g;
                if (i >= f8Arr2.length) {
                    break;
                }
                F8 f8 = f8Arr2[i];
                if (f8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, f8);
                }
                i++;
            }
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
                this.f405a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0675w8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new C8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag == 42) {
                if (this.e == null) {
                    this.e = new D8();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (readTag == 50) {
                if (this.f == null) {
                    this.f = new D8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            } else if (readTag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                F8[] f8Arr = this.g;
                int length = f8Arr == null ? 0 : f8Arr.length;
                int i = repeatedFieldArrayLength + length;
                F8[] f8Arr2 = new F8[i];
                if (length != 0) {
                    System.arraycopy(f8Arr, 0, f8Arr2, 0, length);
                }
                while (length < i - 1) {
                    F8 f8 = new F8();
                    f8Arr2[length] = f8;
                    codedInputByteBufferNano.readMessage(f8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                F8 f82 = new F8();
                f8Arr2[length] = f82;
                codedInputByteBufferNano.readMessage(f82);
                this.g = f8Arr2;
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
