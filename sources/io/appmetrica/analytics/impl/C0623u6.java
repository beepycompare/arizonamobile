package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.u6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0623u6 extends MessageNano {
    public static volatile C0623u6[] f;

    /* renamed from: a  reason: collision with root package name */
    public String f1069a;
    public String b;
    public C0573s6[] c;
    public C0623u6 d;
    public C0623u6[] e;

    public C0623u6() {
        a();
    }

    public static C0623u6[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C0623u6[0];
                }
            }
        }
        return f;
    }

    public final C0623u6 a() {
        this.f1069a = "";
        this.b = "";
        this.c = C0573s6.b();
        this.d = null;
        this.e = b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeStringSize = CodedOutputByteBufferNano.computeStringSize(1, this.f1069a) + super.computeSerializedSize();
        if (!this.b.equals("")) {
            computeStringSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        C0573s6[] c0573s6Arr = this.c;
        int i = 0;
        if (c0573s6Arr != null && c0573s6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0573s6[] c0573s6Arr2 = this.c;
                if (i2 >= c0573s6Arr2.length) {
                    break;
                }
                C0573s6 c0573s6 = c0573s6Arr2[i2];
                if (c0573s6 != null) {
                    computeStringSize += CodedOutputByteBufferNano.computeMessageSize(3, c0573s6);
                }
                i2++;
            }
        }
        C0623u6 c0623u6 = this.d;
        if (c0623u6 != null) {
            computeStringSize += CodedOutputByteBufferNano.computeMessageSize(4, c0623u6);
        }
        C0623u6[] c0623u6Arr = this.e;
        if (c0623u6Arr != null && c0623u6Arr.length > 0) {
            while (true) {
                C0623u6[] c0623u6Arr2 = this.e;
                if (i >= c0623u6Arr2.length) {
                    break;
                }
                C0623u6 c0623u62 = c0623u6Arr2[i];
                if (c0623u62 != null) {
                    computeStringSize = CodedOutputByteBufferNano.computeMessageSize(5, c0623u62) + computeStringSize;
                }
                i++;
            }
        }
        return computeStringSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f1069a);
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        C0573s6[] c0573s6Arr = this.c;
        int i = 0;
        if (c0573s6Arr != null && c0573s6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0573s6[] c0573s6Arr2 = this.c;
                if (i2 >= c0573s6Arr2.length) {
                    break;
                }
                C0573s6 c0573s6 = c0573s6Arr2[i2];
                if (c0573s6 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c0573s6);
                }
                i2++;
            }
        }
        C0623u6 c0623u6 = this.d;
        if (c0623u6 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0623u6);
        }
        C0623u6[] c0623u6Arr = this.e;
        if (c0623u6Arr != null && c0623u6Arr.length > 0) {
            while (true) {
                C0623u6[] c0623u6Arr2 = this.e;
                if (i >= c0623u6Arr2.length) {
                    break;
                }
                C0623u6 c0623u62 = c0623u6Arr2[i];
                if (c0623u62 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0623u62);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0623u6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1069a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C0573s6[] c0573s6Arr = this.c;
                int length = c0573s6Arr == null ? 0 : c0573s6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0573s6[] c0573s6Arr2 = new C0573s6[i];
                if (length != 0) {
                    System.arraycopy(c0573s6Arr, 0, c0573s6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0573s6 c0573s6 = new C0573s6();
                    c0573s6Arr2[length] = c0573s6;
                    codedInputByteBufferNano.readMessage(c0573s6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0573s6 c0573s62 = new C0573s6();
                c0573s6Arr2[length] = c0573s62;
                codedInputByteBufferNano.readMessage(c0573s62);
                this.c = c0573s6Arr2;
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new C0623u6();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                C0623u6[] c0623u6Arr = this.e;
                int length2 = c0623u6Arr == null ? 0 : c0623u6Arr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                C0623u6[] c0623u6Arr2 = new C0623u6[i2];
                if (length2 != 0) {
                    System.arraycopy(c0623u6Arr, 0, c0623u6Arr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    C0623u6 c0623u6 = new C0623u6();
                    c0623u6Arr2[length2] = c0623u6;
                    codedInputByteBufferNano.readMessage(c0623u6);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C0623u6 c0623u62 = new C0623u6();
                c0623u6Arr2[length2] = c0623u62;
                codedInputByteBufferNano.readMessage(c0623u62);
                this.e = c0623u6Arr2;
            }
        }
        return this;
    }

    public static C0623u6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0623u6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0623u6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0623u6) MessageNano.mergeFrom(new C0623u6(), bArr);
    }
}
