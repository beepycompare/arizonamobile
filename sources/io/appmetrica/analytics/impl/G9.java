package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class G9 extends MessageNano {
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
    public static volatile G9[] q;

    /* renamed from: a  reason: collision with root package name */
    public long f458a;
    public F9 b;
    public E9[] c;

    public G9() {
        a();
    }

    public static G9[] b() {
        if (q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (q == null) {
                    q = new G9[0];
                }
            }
        }
        return q;
    }

    public final G9 a() {
        this.f458a = 0L;
        this.b = null;
        this.c = E9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeUInt64Size = CodedOutputByteBufferNano.computeUInt64Size(1, this.f458a) + super.computeSerializedSize();
        F9 f9 = this.b;
        if (f9 != null) {
            computeUInt64Size += CodedOutputByteBufferNano.computeMessageSize(2, f9);
        }
        E9[] e9Arr = this.c;
        if (e9Arr != null && e9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                E9[] e9Arr2 = this.c;
                if (i2 >= e9Arr2.length) {
                    break;
                }
                E9 e9 = e9Arr2[i2];
                if (e9 != null) {
                    computeUInt64Size = CodedOutputByteBufferNano.computeMessageSize(3, e9) + computeUInt64Size;
                }
                i2++;
            }
        }
        return computeUInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f458a);
        F9 f9 = this.b;
        if (f9 != null) {
            codedOutputByteBufferNano.writeMessage(2, f9);
        }
        E9[] e9Arr = this.c;
        if (e9Arr != null && e9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                E9[] e9Arr2 = this.c;
                if (i2 >= e9Arr2.length) {
                    break;
                }
                E9 e9 = e9Arr2[i2];
                if (e9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, e9);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final G9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f458a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new F9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                E9[] e9Arr = this.c;
                int length = e9Arr == null ? 0 : e9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                E9[] e9Arr2 = new E9[i2];
                if (length != 0) {
                    System.arraycopy(e9Arr, 0, e9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    E9 e9 = new E9();
                    e9Arr2[length] = e9;
                    codedInputByteBufferNano.readMessage(e9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                E9 e92 = new E9();
                e9Arr2[length] = e92;
                codedInputByteBufferNano.readMessage(e92);
                this.c = e9Arr2;
            }
        }
        return this;
    }

    public static G9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new G9().mergeFrom(codedInputByteBufferNano);
    }

    public static G9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (G9) MessageNano.mergeFrom(new G9(), bArr);
    }
}
