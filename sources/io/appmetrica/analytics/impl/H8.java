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
public final class H8 extends MessageNano {
    public static volatile H8[] h;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f468a;
    public byte[] b;
    public C0752z8 c;
    public F8 d;
    public G8 e;
    public G8 f;
    public I8[] g;

    public H8() {
        a();
    }

    public static H8[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new H8[0];
                }
            }
        }
        return h;
    }

    public final H8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f468a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = I8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f468a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f468a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        C0752z8 c0752z8 = this.c;
        if (c0752z8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0752z8);
        }
        F8 f8 = this.d;
        if (f8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, f8);
        }
        G8 g8 = this.e;
        if (g8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, g8);
        }
        G8 g82 = this.f;
        if (g82 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, g82);
        }
        I8[] i8Arr = this.g;
        if (i8Arr != null && i8Arr.length > 0) {
            int i = 0;
            while (true) {
                I8[] i8Arr2 = this.g;
                if (i >= i8Arr2.length) {
                    break;
                }
                I8 i8 = i8Arr2[i];
                if (i8 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, i8) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f468a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f468a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        C0752z8 c0752z8 = this.c;
        if (c0752z8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0752z8);
        }
        F8 f8 = this.d;
        if (f8 != null) {
            codedOutputByteBufferNano.writeMessage(4, f8);
        }
        G8 g8 = this.e;
        if (g8 != null) {
            codedOutputByteBufferNano.writeMessage(5, g8);
        }
        G8 g82 = this.f;
        if (g82 != null) {
            codedOutputByteBufferNano.writeMessage(6, g82);
        }
        I8[] i8Arr = this.g;
        if (i8Arr != null && i8Arr.length > 0) {
            int i = 0;
            while (true) {
                I8[] i8Arr2 = this.g;
                if (i >= i8Arr2.length) {
                    break;
                }
                I8 i8 = i8Arr2[i];
                if (i8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, i8);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final H8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f468a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0752z8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new F8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag == 42) {
                if (this.e == null) {
                    this.e = new G8();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (readTag == 50) {
                if (this.f == null) {
                    this.f = new G8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            } else if (readTag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                I8[] i8Arr = this.g;
                int length = i8Arr == null ? 0 : i8Arr.length;
                int i = repeatedFieldArrayLength + length;
                I8[] i8Arr2 = new I8[i];
                if (length != 0) {
                    System.arraycopy(i8Arr, 0, i8Arr2, 0, length);
                }
                while (length < i - 1) {
                    I8 i8 = new I8();
                    i8Arr2[length] = i8;
                    codedInputByteBufferNano.readMessage(i8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                I8 i82 = new I8();
                i8Arr2[length] = i82;
                codedInputByteBufferNano.readMessage(i82);
                this.g = i8Arr2;
            }
        }
        return this;
    }

    public static H8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new H8().mergeFrom(codedInputByteBufferNano);
    }

    public static H8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (H8) MessageNano.mergeFrom(new H8(), bArr);
    }
}
