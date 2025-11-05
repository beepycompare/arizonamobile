package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.t8  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0593t8 extends MessageNano {
    public static volatile C0593t8[] h;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1129a;
    public byte[] b;
    public C0394l8 c;
    public C0543r8 d;
    public C0568s8 e;
    public C0568s8 f;
    public C0618u8[] g;

    public C0593t8() {
        a();
    }

    public static C0593t8[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new C0593t8[0];
                }
            }
        }
        return h;
    }

    public final C0593t8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f1129a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = C0618u8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f1129a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f1129a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        C0394l8 c0394l8 = this.c;
        if (c0394l8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0394l8);
        }
        C0543r8 c0543r8 = this.d;
        if (c0543r8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0543r8);
        }
        C0568s8 c0568s8 = this.e;
        if (c0568s8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0568s8);
        }
        C0568s8 c0568s82 = this.f;
        if (c0568s82 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, c0568s82);
        }
        C0618u8[] c0618u8Arr = this.g;
        if (c0618u8Arr != null && c0618u8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0618u8[] c0618u8Arr2 = this.g;
                if (i >= c0618u8Arr2.length) {
                    break;
                }
                C0618u8 c0618u8 = c0618u8Arr2[i];
                if (c0618u8 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, c0618u8) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f1129a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f1129a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        C0394l8 c0394l8 = this.c;
        if (c0394l8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0394l8);
        }
        C0543r8 c0543r8 = this.d;
        if (c0543r8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0543r8);
        }
        C0568s8 c0568s8 = this.e;
        if (c0568s8 != null) {
            codedOutputByteBufferNano.writeMessage(5, c0568s8);
        }
        C0568s8 c0568s82 = this.f;
        if (c0568s82 != null) {
            codedOutputByteBufferNano.writeMessage(6, c0568s82);
        }
        C0618u8[] c0618u8Arr = this.g;
        if (c0618u8Arr != null && c0618u8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0618u8[] c0618u8Arr2 = this.g;
                if (i >= c0618u8Arr2.length) {
                    break;
                }
                C0618u8 c0618u8 = c0618u8Arr2[i];
                if (c0618u8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c0618u8);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0593t8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1129a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0394l8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new C0543r8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag == 42) {
                if (this.e == null) {
                    this.e = new C0568s8();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (readTag == 50) {
                if (this.f == null) {
                    this.f = new C0568s8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            } else if (readTag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C0618u8[] c0618u8Arr = this.g;
                int length = c0618u8Arr == null ? 0 : c0618u8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0618u8[] c0618u8Arr2 = new C0618u8[i];
                if (length != 0) {
                    System.arraycopy(c0618u8Arr, 0, c0618u8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0618u8 c0618u8 = new C0618u8();
                    c0618u8Arr2[length] = c0618u8;
                    codedInputByteBufferNano.readMessage(c0618u8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0618u8 c0618u82 = new C0618u8();
                c0618u8Arr2[length] = c0618u82;
                codedInputByteBufferNano.readMessage(c0618u82);
                this.g = c0618u8Arr2;
            }
        }
        return this;
    }

    public static C0593t8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0593t8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0593t8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0593t8) MessageNano.mergeFrom(new C0593t8(), bArr);
    }
}
