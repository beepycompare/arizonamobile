package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.c6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0159c6 extends MessageNano {
    public static volatile C0159c6[] f;

    /* renamed from: a  reason: collision with root package name */
    public String f922a;
    public String b;
    public C0107a6[] c;
    public C0159c6 d;
    public C0159c6[] e;

    public C0159c6() {
        a();
    }

    public static C0159c6[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C0159c6[0];
                }
            }
        }
        return f;
    }

    public final C0159c6 a() {
        this.f922a = "";
        this.b = "";
        this.c = C0107a6.b();
        this.d = null;
        this.e = b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeStringSize = CodedOutputByteBufferNano.computeStringSize(1, this.f922a) + super.computeSerializedSize();
        if (!this.b.equals("")) {
            computeStringSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        C0107a6[] c0107a6Arr = this.c;
        int i = 0;
        if (c0107a6Arr != null && c0107a6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0107a6[] c0107a6Arr2 = this.c;
                if (i2 >= c0107a6Arr2.length) {
                    break;
                }
                C0107a6 c0107a6 = c0107a6Arr2[i2];
                if (c0107a6 != null) {
                    computeStringSize += CodedOutputByteBufferNano.computeMessageSize(3, c0107a6);
                }
                i2++;
            }
        }
        C0159c6 c0159c6 = this.d;
        if (c0159c6 != null) {
            computeStringSize += CodedOutputByteBufferNano.computeMessageSize(4, c0159c6);
        }
        C0159c6[] c0159c6Arr = this.e;
        if (c0159c6Arr != null && c0159c6Arr.length > 0) {
            while (true) {
                C0159c6[] c0159c6Arr2 = this.e;
                if (i >= c0159c6Arr2.length) {
                    break;
                }
                C0159c6 c0159c62 = c0159c6Arr2[i];
                if (c0159c62 != null) {
                    computeStringSize = CodedOutputByteBufferNano.computeMessageSize(5, c0159c62) + computeStringSize;
                }
                i++;
            }
        }
        return computeStringSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f922a);
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        C0107a6[] c0107a6Arr = this.c;
        int i = 0;
        if (c0107a6Arr != null && c0107a6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0107a6[] c0107a6Arr2 = this.c;
                if (i2 >= c0107a6Arr2.length) {
                    break;
                }
                C0107a6 c0107a6 = c0107a6Arr2[i2];
                if (c0107a6 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c0107a6);
                }
                i2++;
            }
        }
        C0159c6 c0159c6 = this.d;
        if (c0159c6 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0159c6);
        }
        C0159c6[] c0159c6Arr = this.e;
        if (c0159c6Arr != null && c0159c6Arr.length > 0) {
            while (true) {
                C0159c6[] c0159c6Arr2 = this.e;
                if (i >= c0159c6Arr2.length) {
                    break;
                }
                C0159c6 c0159c62 = c0159c6Arr2[i];
                if (c0159c62 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0159c62);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0159c6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f922a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C0107a6[] c0107a6Arr = this.c;
                int length = c0107a6Arr == null ? 0 : c0107a6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0107a6[] c0107a6Arr2 = new C0107a6[i];
                if (length != 0) {
                    System.arraycopy(c0107a6Arr, 0, c0107a6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0107a6 c0107a6 = new C0107a6();
                    c0107a6Arr2[length] = c0107a6;
                    codedInputByteBufferNano.readMessage(c0107a6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0107a6 c0107a62 = new C0107a6();
                c0107a6Arr2[length] = c0107a62;
                codedInputByteBufferNano.readMessage(c0107a62);
                this.c = c0107a6Arr2;
            } else if (readTag == 34) {
                if (this.d == null) {
                    this.d = new C0159c6();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (readTag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                C0159c6[] c0159c6Arr = this.e;
                int length2 = c0159c6Arr == null ? 0 : c0159c6Arr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                C0159c6[] c0159c6Arr2 = new C0159c6[i2];
                if (length2 != 0) {
                    System.arraycopy(c0159c6Arr, 0, c0159c6Arr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    C0159c6 c0159c6 = new C0159c6();
                    c0159c6Arr2[length2] = c0159c6;
                    codedInputByteBufferNano.readMessage(c0159c6);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C0159c6 c0159c62 = new C0159c6();
                c0159c6Arr2[length2] = c0159c62;
                codedInputByteBufferNano.readMessage(c0159c62);
                this.e = c0159c6Arr2;
            }
        }
        return this;
    }

    public static C0159c6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0159c6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0159c6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0159c6) MessageNano.mergeFrom(new C0159c6(), bArr);
    }
}
