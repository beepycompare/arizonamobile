package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.r6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0551r6 extends MessageNano {
    public static volatile C0551r6[] f;

    /* renamed from: a  reason: collision with root package name */
    public String f1180a;
    public String b;
    public C0500p6[] c;
    public C0551r6 d;
    public C0551r6[] e;

    public C0551r6() {
        a();
    }

    public static C0551r6[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C0551r6[0];
                }
            }
        }
        return f;
    }

    public final C0551r6 a() {
        this.f1180a = "";
        this.b = "";
        this.c = C0500p6.b();
        this.d = null;
        this.e = b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeStringSize = CodedOutputByteBufferNano.computeStringSize(1, this.f1180a) + super.computeSerializedSize();
        if (!this.b.equals("")) {
            computeStringSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        C0500p6[] c0500p6Arr = this.c;
        int i = 0;
        if (c0500p6Arr != null && c0500p6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0500p6[] c0500p6Arr2 = this.c;
                if (i2 >= c0500p6Arr2.length) {
                    break;
                }
                C0500p6 c0500p6 = c0500p6Arr2[i2];
                if (c0500p6 != null) {
                    computeStringSize += CodedOutputByteBufferNano.computeMessageSize(3, c0500p6);
                }
                i2++;
            }
        }
        C0551r6 c0551r6 = this.d;
        if (c0551r6 != null) {
            computeStringSize += CodedOutputByteBufferNano.computeMessageSize(4, c0551r6);
        }
        C0551r6[] c0551r6Arr = this.e;
        if (c0551r6Arr != null && c0551r6Arr.length > 0) {
            while (true) {
                C0551r6[] c0551r6Arr2 = this.e;
                if (i >= c0551r6Arr2.length) {
                    break;
                }
                C0551r6 c0551r62 = c0551r6Arr2[i];
                if (c0551r62 != null) {
                    computeStringSize = CodedOutputByteBufferNano.computeMessageSize(5, c0551r62) + computeStringSize;
                }
                i++;
            }
        }
        return computeStringSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f1180a);
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        C0500p6[] c0500p6Arr = this.c;
        int i = 0;
        if (c0500p6Arr != null && c0500p6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0500p6[] c0500p6Arr2 = this.c;
                if (i2 >= c0500p6Arr2.length) {
                    break;
                }
                C0500p6 c0500p6 = c0500p6Arr2[i2];
                if (c0500p6 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c0500p6);
                }
                i2++;
            }
        }
        C0551r6 c0551r6 = this.d;
        if (c0551r6 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0551r6);
        }
        C0551r6[] c0551r6Arr = this.e;
        if (c0551r6Arr != null && c0551r6Arr.length > 0) {
            while (true) {
                C0551r6[] c0551r6Arr2 = this.e;
                if (i >= c0551r6Arr2.length) {
                    break;
                }
                C0551r6 c0551r62 = c0551r6Arr2[i];
                if (c0551r62 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0551r62);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0551r6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1180a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C0500p6[] c0500p6Arr = this.c;
                int length = c0500p6Arr == null ? 0 : c0500p6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0500p6[] c0500p6Arr2 = new C0500p6[i];
                if (length != 0) {
                    System.arraycopy(c0500p6Arr, 0, c0500p6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0500p6 c0500p6 = new C0500p6();
                    c0500p6Arr2[length] = c0500p6;
                    codedInputByteBufferNano.readMessage(c0500p6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0500p6 c0500p62 = new C0500p6();
                c0500p6Arr2[length] = c0500p62;
                codedInputByteBufferNano.readMessage(c0500p62);
                this.c = c0500p6Arr2;
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new C0551r6();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                C0551r6[] c0551r6Arr = this.e;
                int length2 = c0551r6Arr == null ? 0 : c0551r6Arr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                C0551r6[] c0551r6Arr2 = new C0551r6[i2];
                if (length2 != 0) {
                    System.arraycopy(c0551r6Arr, 0, c0551r6Arr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    C0551r6 c0551r6 = new C0551r6();
                    c0551r6Arr2[length2] = c0551r6;
                    codedInputByteBufferNano.readMessage(c0551r6);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C0551r6 c0551r62 = new C0551r6();
                c0551r6Arr2[length2] = c0551r62;
                codedInputByteBufferNano.readMessage(c0551r62);
                this.e = c0551r6Arr2;
            }
        }
        return this;
    }

    public static C0551r6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0551r6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0551r6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0551r6) MessageNano.mergeFrom(new C0551r6(), bArr);
    }
}
