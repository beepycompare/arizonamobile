package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.g9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0269g9 extends MessageNano {
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
    public static volatile C0269g9[] q;

    /* renamed from: a  reason: collision with root package name */
    public long f1015a;
    public C0243f9 b;
    public C0217e9[] c;

    public C0269g9() {
        a();
    }

    public static C0269g9[] b() {
        if (q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (q == null) {
                    q = new C0269g9[0];
                }
            }
        }
        return q;
    }

    public final C0269g9 a() {
        this.f1015a = 0L;
        this.b = null;
        this.c = C0217e9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeUInt64Size = CodedOutputByteBufferNano.computeUInt64Size(1, this.f1015a) + super.computeSerializedSize();
        C0243f9 c0243f9 = this.b;
        if (c0243f9 != null) {
            computeUInt64Size += CodedOutputByteBufferNano.computeMessageSize(2, c0243f9);
        }
        C0217e9[] c0217e9Arr = this.c;
        if (c0217e9Arr != null && c0217e9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0217e9[] c0217e9Arr2 = this.c;
                if (i2 >= c0217e9Arr2.length) {
                    break;
                }
                C0217e9 c0217e9 = c0217e9Arr2[i2];
                if (c0217e9 != null) {
                    computeUInt64Size = CodedOutputByteBufferNano.computeMessageSize(3, c0217e9) + computeUInt64Size;
                }
                i2++;
            }
        }
        return computeUInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f1015a);
        C0243f9 c0243f9 = this.b;
        if (c0243f9 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0243f9);
        }
        C0217e9[] c0217e9Arr = this.c;
        if (c0217e9Arr != null && c0217e9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0217e9[] c0217e9Arr2 = this.c;
                if (i2 >= c0217e9Arr2.length) {
                    break;
                }
                C0217e9 c0217e9 = c0217e9Arr2[i2];
                if (c0217e9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c0217e9);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0269g9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1015a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0243f9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C0217e9[] c0217e9Arr = this.c;
                int length = c0217e9Arr == null ? 0 : c0217e9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                C0217e9[] c0217e9Arr2 = new C0217e9[i2];
                if (length != 0) {
                    System.arraycopy(c0217e9Arr, 0, c0217e9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    C0217e9 c0217e9 = new C0217e9();
                    c0217e9Arr2[length] = c0217e9;
                    codedInputByteBufferNano.readMessage(c0217e9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0217e9 c0217e92 = new C0217e9();
                c0217e9Arr2[length] = c0217e92;
                codedInputByteBufferNano.readMessage(c0217e92);
                this.c = c0217e9Arr2;
            }
        }
        return this;
    }

    public static C0269g9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0269g9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0269g9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0269g9) MessageNano.mergeFrom(new C0269g9(), bArr);
    }
}
