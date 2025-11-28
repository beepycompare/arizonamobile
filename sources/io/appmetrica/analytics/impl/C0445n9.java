package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.n9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0445n9 extends MessageNano {
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
    public static volatile C0445n9[] q;

    /* renamed from: a  reason: collision with root package name */
    public long f1023a;
    public C0420m9 b;
    public C0395l9[] c;

    public C0445n9() {
        a();
    }

    public static C0445n9[] b() {
        if (q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (q == null) {
                    q = new C0445n9[0];
                }
            }
        }
        return q;
    }

    public final C0445n9 a() {
        this.f1023a = 0L;
        this.b = null;
        this.c = C0395l9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeUInt64Size = CodedOutputByteBufferNano.computeUInt64Size(1, this.f1023a) + super.computeSerializedSize();
        C0420m9 c0420m9 = this.b;
        if (c0420m9 != null) {
            computeUInt64Size += CodedOutputByteBufferNano.computeMessageSize(2, c0420m9);
        }
        C0395l9[] c0395l9Arr = this.c;
        if (c0395l9Arr != null && c0395l9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0395l9[] c0395l9Arr2 = this.c;
                if (i2 >= c0395l9Arr2.length) {
                    break;
                }
                C0395l9 c0395l9 = c0395l9Arr2[i2];
                if (c0395l9 != null) {
                    computeUInt64Size = CodedOutputByteBufferNano.computeMessageSize(3, c0395l9) + computeUInt64Size;
                }
                i2++;
            }
        }
        return computeUInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f1023a);
        C0420m9 c0420m9 = this.b;
        if (c0420m9 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0420m9);
        }
        C0395l9[] c0395l9Arr = this.c;
        if (c0395l9Arr != null && c0395l9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0395l9[] c0395l9Arr2 = this.c;
                if (i2 >= c0395l9Arr2.length) {
                    break;
                }
                C0395l9 c0395l9 = c0395l9Arr2[i2];
                if (c0395l9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c0395l9);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0445n9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1023a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0420m9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C0395l9[] c0395l9Arr = this.c;
                int length = c0395l9Arr == null ? 0 : c0395l9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                C0395l9[] c0395l9Arr2 = new C0395l9[i2];
                if (length != 0) {
                    System.arraycopy(c0395l9Arr, 0, c0395l9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    C0395l9 c0395l9 = new C0395l9();
                    c0395l9Arr2[length] = c0395l9;
                    codedInputByteBufferNano.readMessage(c0395l9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0395l9 c0395l92 = new C0395l9();
                c0395l9Arr2[length] = c0395l92;
                codedInputByteBufferNano.readMessage(c0395l92);
                this.c = c0395l9Arr2;
            }
        }
        return this;
    }

    public static C0445n9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0445n9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0445n9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0445n9) MessageNano.mergeFrom(new C0445n9(), bArr);
    }
}
