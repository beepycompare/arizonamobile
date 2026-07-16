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
public final class G8 extends MessageNano {
    public static volatile G8[] h;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f563a;
    public byte[] b;
    public C0736y8 c;
    public E8 d;
    public F8 e;
    public F8 f;
    public H8[] g;

    public G8() {
        a();
    }

    public static G8[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new G8[0];
                }
            }
        }
        return h;
    }

    public final G8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f563a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = H8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f563a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f563a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        C0736y8 c0736y8 = this.c;
        if (c0736y8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0736y8);
        }
        E8 e8 = this.d;
        if (e8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, e8);
        }
        F8 f8 = this.e;
        if (f8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, f8);
        }
        F8 f82 = this.f;
        if (f82 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, f82);
        }
        H8[] h8Arr = this.g;
        if (h8Arr != null && h8Arr.length > 0) {
            int i = 0;
            while (true) {
                H8[] h8Arr2 = this.g;
                if (i >= h8Arr2.length) {
                    break;
                }
                H8 h8 = h8Arr2[i];
                if (h8 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, h8) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f563a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f563a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        C0736y8 c0736y8 = this.c;
        if (c0736y8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0736y8);
        }
        E8 e8 = this.d;
        if (e8 != null) {
            codedOutputByteBufferNano.writeMessage(4, e8);
        }
        F8 f8 = this.e;
        if (f8 != null) {
            codedOutputByteBufferNano.writeMessage(5, f8);
        }
        F8 f82 = this.f;
        if (f82 != null) {
            codedOutputByteBufferNano.writeMessage(6, f82);
        }
        H8[] h8Arr = this.g;
        if (h8Arr != null && h8Arr.length > 0) {
            int i = 0;
            while (true) {
                H8[] h8Arr2 = this.g;
                if (i >= h8Arr2.length) {
                    break;
                }
                H8 h8 = h8Arr2[i];
                if (h8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, h8);
                }
                i++;
            }
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
                this.f563a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0736y8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new E8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag == 42) {
                if (this.e == null) {
                    this.e = new F8();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (readTag == 50) {
                if (this.f == null) {
                    this.f = new F8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            } else if (readTag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                H8[] h8Arr = this.g;
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
                this.g = h8Arr2;
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
