package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.h9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0292h9 extends MessageNano {
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
    public static volatile C0292h9[] q;

    /* renamed from: a  reason: collision with root package name */
    public long f921a;
    public C0266g9 b;
    public C0240f9[] c;

    public C0292h9() {
        a();
    }

    public static C0292h9[] b() {
        if (q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (q == null) {
                    q = new C0292h9[0];
                }
            }
        }
        return q;
    }

    public final C0292h9 a() {
        this.f921a = 0L;
        this.b = null;
        this.c = C0240f9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeUInt64Size = CodedOutputByteBufferNano.computeUInt64Size(1, this.f921a) + super.computeSerializedSize();
        C0266g9 c0266g9 = this.b;
        if (c0266g9 != null) {
            computeUInt64Size += CodedOutputByteBufferNano.computeMessageSize(2, c0266g9);
        }
        C0240f9[] c0240f9Arr = this.c;
        if (c0240f9Arr != null && c0240f9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0240f9[] c0240f9Arr2 = this.c;
                if (i2 >= c0240f9Arr2.length) {
                    break;
                }
                C0240f9 c0240f9 = c0240f9Arr2[i2];
                if (c0240f9 != null) {
                    computeUInt64Size = CodedOutputByteBufferNano.computeMessageSize(3, c0240f9) + computeUInt64Size;
                }
                i2++;
            }
        }
        return computeUInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f921a);
        C0266g9 c0266g9 = this.b;
        if (c0266g9 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0266g9);
        }
        C0240f9[] c0240f9Arr = this.c;
        if (c0240f9Arr != null && c0240f9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0240f9[] c0240f9Arr2 = this.c;
                if (i2 >= c0240f9Arr2.length) {
                    break;
                }
                C0240f9 c0240f9 = c0240f9Arr2[i2];
                if (c0240f9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c0240f9);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0292h9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f921a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0266g9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C0240f9[] c0240f9Arr = this.c;
                int length = c0240f9Arr == null ? 0 : c0240f9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                C0240f9[] c0240f9Arr2 = new C0240f9[i2];
                if (length != 0) {
                    System.arraycopy(c0240f9Arr, 0, c0240f9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    C0240f9 c0240f9 = new C0240f9();
                    c0240f9Arr2[length] = c0240f9;
                    codedInputByteBufferNano.readMessage(c0240f9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0240f9 c0240f92 = new C0240f9();
                c0240f9Arr2[length] = c0240f92;
                codedInputByteBufferNano.readMessage(c0240f92);
                this.c = c0240f9Arr2;
            }
        }
        return this;
    }

    public static C0292h9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0292h9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0292h9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0292h9) MessageNano.mergeFrom(new C0292h9(), bArr);
    }
}
