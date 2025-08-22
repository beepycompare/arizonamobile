package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class D9 extends MessageNano {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    public static final int j = 6;
    public static final int k = 7;
    public static final int l = 8;
    public static final int m = 9;
    public static final int n = 10;
    public static final int o = 11;
    public static final int p = 12;
    public static volatile D9[] q;

    /* renamed from: a  reason: collision with root package name */
    public long f393a;
    public C9 b;
    public B9[] c;

    public D9() {
        a();
    }

    public static D9[] b() {
        if (q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (q == null) {
                    q = new D9[0];
                }
            }
        }
        return q;
    }

    public final D9 a() {
        this.f393a = 0L;
        this.b = null;
        this.c = B9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeUInt64Size = CodedOutputByteBufferNano.computeUInt64Size(1, this.f393a) + super.computeSerializedSize();
        C9 c9 = this.b;
        if (c9 != null) {
            computeUInt64Size += CodedOutputByteBufferNano.computeMessageSize(2, c9);
        }
        B9[] b9Arr = this.c;
        if (b9Arr != null && b9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                B9[] b9Arr2 = this.c;
                if (i2 >= b9Arr2.length) {
                    break;
                }
                B9 b9 = b9Arr2[i2];
                if (b9 != null) {
                    computeUInt64Size = CodedOutputByteBufferNano.computeMessageSize(3, b9) + computeUInt64Size;
                }
                i2++;
            }
        }
        return computeUInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f393a);
        C9 c9 = this.b;
        if (c9 != null) {
            codedOutputByteBufferNano.writeMessage(2, c9);
        }
        B9[] b9Arr = this.c;
        if (b9Arr != null && b9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                B9[] b9Arr2 = this.c;
                if (i2 >= b9Arr2.length) {
                    break;
                }
                B9 b9 = b9Arr2[i2];
                if (b9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, b9);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final D9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f393a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                B9[] b9Arr = this.c;
                int length = b9Arr == null ? 0 : b9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                B9[] b9Arr2 = new B9[i2];
                if (length != 0) {
                    System.arraycopy(b9Arr, 0, b9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    B9 b9 = new B9();
                    b9Arr2[length] = b9;
                    codedInputByteBufferNano.readMessage(b9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                B9 b92 = new B9();
                b9Arr2[length] = b92;
                codedInputByteBufferNano.readMessage(b92);
                this.c = b9Arr2;
            }
        }
        return this;
    }

    public static D9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new D9().mergeFrom(codedInputByteBufferNano);
    }

    public static D9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (D9) MessageNano.mergeFrom(new D9(), bArr);
    }
}
