package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.h8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0295h8 extends MessageNano {
    public static volatile C0295h8[] f;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1026a;
    public byte[] b;
    public C0397l8 c;
    public C0321i8[] d;
    public int e;

    public C0295h8() {
        a();
    }

    public static C0295h8[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C0295h8[0];
                }
            }
        }
        return f;
    }

    public final C0295h8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f1026a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = C0321i8.b();
        this.e = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f1026a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f1026a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        C0397l8 c0397l8 = this.c;
        if (c0397l8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0397l8);
        }
        C0321i8[] c0321i8Arr = this.d;
        if (c0321i8Arr != null && c0321i8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0321i8[] c0321i8Arr2 = this.d;
                if (i >= c0321i8Arr2.length) {
                    break;
                }
                C0321i8 c0321i8 = c0321i8Arr2[i];
                if (c0321i8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0321i8);
                }
                i++;
            }
        }
        int i2 = this.e;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(5, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f1026a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f1026a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        C0397l8 c0397l8 = this.c;
        if (c0397l8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0397l8);
        }
        C0321i8[] c0321i8Arr = this.d;
        if (c0321i8Arr != null && c0321i8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0321i8[] c0321i8Arr2 = this.d;
                if (i >= c0321i8Arr2.length) {
                    break;
                }
                C0321i8 c0321i8 = c0321i8Arr2[i];
                if (c0321i8 != null) {
                    codedOutputByteBufferNano.writeMessage(4, c0321i8);
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
    public final C0295h8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1026a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0397l8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                C0321i8[] c0321i8Arr = this.d;
                int length = c0321i8Arr == null ? 0 : c0321i8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0321i8[] c0321i8Arr2 = new C0321i8[i];
                if (length != 0) {
                    System.arraycopy(c0321i8Arr, 0, c0321i8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0321i8 c0321i8 = new C0321i8();
                    c0321i8Arr2[length] = c0321i8;
                    codedInputByteBufferNano.readMessage(c0321i8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0321i8 c0321i82 = new C0321i8();
                c0321i8Arr2[length] = c0321i82;
                codedInputByteBufferNano.readMessage(c0321i82);
                this.d = c0321i8Arr2;
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

    public static C0295h8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0295h8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0295h8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0295h8) MessageNano.mergeFrom(new C0295h8(), bArr);
    }
}
