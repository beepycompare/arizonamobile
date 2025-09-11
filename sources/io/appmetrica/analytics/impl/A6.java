package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class A6 extends MessageNano {
    public static volatile A6[] f;

    /* renamed from: a  reason: collision with root package name */
    public String f345a;
    public String b;
    public C0727y6[] c;
    public A6 d;
    public A6[] e;

    public A6() {
        a();
    }

    public static A6[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new A6[0];
                }
            }
        }
        return f;
    }

    public final A6 a() {
        this.f345a = "";
        this.b = "";
        this.c = C0727y6.b();
        this.d = null;
        this.e = b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeStringSize = CodedOutputByteBufferNano.computeStringSize(1, this.f345a) + super.computeSerializedSize();
        if (!this.b.equals("")) {
            computeStringSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        C0727y6[] c0727y6Arr = this.c;
        int i = 0;
        if (c0727y6Arr != null && c0727y6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0727y6[] c0727y6Arr2 = this.c;
                if (i2 >= c0727y6Arr2.length) {
                    break;
                }
                C0727y6 c0727y6 = c0727y6Arr2[i2];
                if (c0727y6 != null) {
                    computeStringSize += CodedOutputByteBufferNano.computeMessageSize(3, c0727y6);
                }
                i2++;
            }
        }
        A6 a6 = this.d;
        if (a6 != null) {
            computeStringSize += CodedOutputByteBufferNano.computeMessageSize(4, a6);
        }
        A6[] a6Arr = this.e;
        if (a6Arr != null && a6Arr.length > 0) {
            while (true) {
                A6[] a6Arr2 = this.e;
                if (i >= a6Arr2.length) {
                    break;
                }
                A6 a62 = a6Arr2[i];
                if (a62 != null) {
                    computeStringSize = CodedOutputByteBufferNano.computeMessageSize(5, a62) + computeStringSize;
                }
                i++;
            }
        }
        return computeStringSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f345a);
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        C0727y6[] c0727y6Arr = this.c;
        int i = 0;
        if (c0727y6Arr != null && c0727y6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0727y6[] c0727y6Arr2 = this.c;
                if (i2 >= c0727y6Arr2.length) {
                    break;
                }
                C0727y6 c0727y6 = c0727y6Arr2[i2];
                if (c0727y6 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c0727y6);
                }
                i2++;
            }
        }
        A6 a6 = this.d;
        if (a6 != null) {
            codedOutputByteBufferNano.writeMessage(4, a6);
        }
        A6[] a6Arr = this.e;
        if (a6Arr != null && a6Arr.length > 0) {
            while (true) {
                A6[] a6Arr2 = this.e;
                if (i >= a6Arr2.length) {
                    break;
                }
                A6 a62 = a6Arr2[i];
                if (a62 != null) {
                    codedOutputByteBufferNano.writeMessage(5, a62);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final A6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f345a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C0727y6[] c0727y6Arr = this.c;
                int length = c0727y6Arr == null ? 0 : c0727y6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0727y6[] c0727y6Arr2 = new C0727y6[i];
                if (length != 0) {
                    System.arraycopy(c0727y6Arr, 0, c0727y6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0727y6 c0727y6 = new C0727y6();
                    c0727y6Arr2[length] = c0727y6;
                    codedInputByteBufferNano.readMessage(c0727y6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0727y6 c0727y62 = new C0727y6();
                c0727y6Arr2[length] = c0727y62;
                codedInputByteBufferNano.readMessage(c0727y62);
                this.c = c0727y6Arr2;
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new A6();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                A6[] a6Arr = this.e;
                int length2 = a6Arr == null ? 0 : a6Arr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                A6[] a6Arr2 = new A6[i2];
                if (length2 != 0) {
                    System.arraycopy(a6Arr, 0, a6Arr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    A6 a6 = new A6();
                    a6Arr2[length2] = a6;
                    codedInputByteBufferNano.readMessage(a6);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                A6 a62 = new A6();
                a6Arr2[length2] = a62;
                codedInputByteBufferNano.readMessage(a62);
                this.e = a6Arr2;
            }
        }
        return this;
    }

    public static A6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new A6().mergeFrom(codedInputByteBufferNano);
    }

    public static A6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (A6) MessageNano.mergeFrom(new A6(), bArr);
    }
}
