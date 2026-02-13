package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.b6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0138b6 extends MessageNano {
    public static volatile C0138b6[] f;

    /* renamed from: a  reason: collision with root package name */
    public String f913a;
    public String b;
    public Z5[] c;
    public C0138b6 d;
    public C0138b6[] e;

    public C0138b6() {
        a();
    }

    public static C0138b6[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C0138b6[0];
                }
            }
        }
        return f;
    }

    public final C0138b6 a() {
        this.f913a = "";
        this.b = "";
        this.c = Z5.b();
        this.d = null;
        this.e = b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeStringSize = CodedOutputByteBufferNano.computeStringSize(1, this.f913a) + super.computeSerializedSize();
        if (!this.b.equals("")) {
            computeStringSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        Z5[] z5Arr = this.c;
        int i = 0;
        if (z5Arr != null && z5Arr.length > 0) {
            int i2 = 0;
            while (true) {
                Z5[] z5Arr2 = this.c;
                if (i2 >= z5Arr2.length) {
                    break;
                }
                Z5 z5 = z5Arr2[i2];
                if (z5 != null) {
                    computeStringSize += CodedOutputByteBufferNano.computeMessageSize(3, z5);
                }
                i2++;
            }
        }
        C0138b6 c0138b6 = this.d;
        if (c0138b6 != null) {
            computeStringSize += CodedOutputByteBufferNano.computeMessageSize(4, c0138b6);
        }
        C0138b6[] c0138b6Arr = this.e;
        if (c0138b6Arr != null && c0138b6Arr.length > 0) {
            while (true) {
                C0138b6[] c0138b6Arr2 = this.e;
                if (i >= c0138b6Arr2.length) {
                    break;
                }
                C0138b6 c0138b62 = c0138b6Arr2[i];
                if (c0138b62 != null) {
                    computeStringSize = CodedOutputByteBufferNano.computeMessageSize(5, c0138b62) + computeStringSize;
                }
                i++;
            }
        }
        return computeStringSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f913a);
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        Z5[] z5Arr = this.c;
        int i = 0;
        if (z5Arr != null && z5Arr.length > 0) {
            int i2 = 0;
            while (true) {
                Z5[] z5Arr2 = this.c;
                if (i2 >= z5Arr2.length) {
                    break;
                }
                Z5 z5 = z5Arr2[i2];
                if (z5 != null) {
                    codedOutputByteBufferNano.writeMessage(3, z5);
                }
                i2++;
            }
        }
        C0138b6 c0138b6 = this.d;
        if (c0138b6 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0138b6);
        }
        C0138b6[] c0138b6Arr = this.e;
        if (c0138b6Arr != null && c0138b6Arr.length > 0) {
            while (true) {
                C0138b6[] c0138b6Arr2 = this.e;
                if (i >= c0138b6Arr2.length) {
                    break;
                }
                C0138b6 c0138b62 = c0138b6Arr2[i];
                if (c0138b62 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0138b62);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0138b6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f913a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                Z5[] z5Arr = this.c;
                int length = z5Arr == null ? 0 : z5Arr.length;
                int i = repeatedFieldArrayLength + length;
                Z5[] z5Arr2 = new Z5[i];
                if (length != 0) {
                    System.arraycopy(z5Arr, 0, z5Arr2, 0, length);
                }
                while (length < i - 1) {
                    Z5 z5 = new Z5();
                    z5Arr2[length] = z5;
                    codedInputByteBufferNano.readMessage(z5);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Z5 z52 = new Z5();
                z5Arr2[length] = z52;
                codedInputByteBufferNano.readMessage(z52);
                this.c = z5Arr2;
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new C0138b6();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                C0138b6[] c0138b6Arr = this.e;
                int length2 = c0138b6Arr == null ? 0 : c0138b6Arr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                C0138b6[] c0138b6Arr2 = new C0138b6[i2];
                if (length2 != 0) {
                    System.arraycopy(c0138b6Arr, 0, c0138b6Arr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    C0138b6 c0138b6 = new C0138b6();
                    c0138b6Arr2[length2] = c0138b6;
                    codedInputByteBufferNano.readMessage(c0138b6);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C0138b6 c0138b62 = new C0138b6();
                c0138b6Arr2[length2] = c0138b62;
                codedInputByteBufferNano.readMessage(c0138b62);
                this.e = c0138b6Arr2;
            }
        }
        return this;
    }

    public static C0138b6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0138b6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0138b6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0138b6) MessageNano.mergeFrom(new C0138b6(), bArr);
    }
}
