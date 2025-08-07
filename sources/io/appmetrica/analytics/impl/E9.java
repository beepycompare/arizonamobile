package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class E9 extends MessageNano {
    public static final int f = -1;
    public static final int g = 0;
    public static final int h = 1;
    public static volatile E9[] i;

    /* renamed from: a  reason: collision with root package name */
    public B9[] f414a;
    public C0679w9 b;
    public C0604t9[] c;
    public C9[] d;
    public String[] e;

    public E9() {
        a();
    }

    public static E9[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new E9[0];
                }
            }
        }
        return i;
    }

    public final E9 a() {
        this.f414a = B9.b();
        this.b = null;
        this.c = C0604t9.b();
        this.d = C9.b();
        this.e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        B9[] b9Arr = this.f414a;
        int i2 = 0;
        if (b9Arr != null && b9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                B9[] b9Arr2 = this.f414a;
                if (i3 >= b9Arr2.length) {
                    break;
                }
                B9 b9 = b9Arr2[i3];
                if (b9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, b9);
                }
                i3++;
            }
        }
        C0679w9 c0679w9 = this.b;
        if (c0679w9 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0679w9);
        }
        C0604t9[] c0604t9Arr = this.c;
        if (c0604t9Arr != null && c0604t9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0604t9[] c0604t9Arr2 = this.c;
                if (i4 >= c0604t9Arr2.length) {
                    break;
                }
                C0604t9 c0604t9 = c0604t9Arr2[i4];
                if (c0604t9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, c0604t9) + computeSerializedSize;
                }
                i4++;
            }
        }
        C9[] c9Arr = this.d;
        if (c9Arr != null && c9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C9[] c9Arr2 = this.d;
                if (i5 >= c9Arr2.length) {
                    break;
                }
                C9 c9 = c9Arr2[i5];
                if (c9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, c9);
                }
                i5++;
            }
        }
        String[] strArr = this.e;
        if (strArr == null || strArr.length <= 0) {
            return computeSerializedSize;
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            String[] strArr2 = this.e;
            if (i2 >= strArr2.length) {
                return computeSerializedSize + i6 + i7;
            }
            String str = strArr2[i2];
            if (str != null) {
                i7++;
                i6 = CodedOutputByteBufferNano.computeStringSizeNoTag(str) + i6;
            }
            i2++;
        }
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        B9[] b9Arr = this.f414a;
        int i2 = 0;
        if (b9Arr != null && b9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                B9[] b9Arr2 = this.f414a;
                if (i3 >= b9Arr2.length) {
                    break;
                }
                B9 b9 = b9Arr2[i3];
                if (b9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, b9);
                }
                i3++;
            }
        }
        C0679w9 c0679w9 = this.b;
        if (c0679w9 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0679w9);
        }
        C0604t9[] c0604t9Arr = this.c;
        if (c0604t9Arr != null && c0604t9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0604t9[] c0604t9Arr2 = this.c;
                if (i4 >= c0604t9Arr2.length) {
                    break;
                }
                C0604t9 c0604t9 = c0604t9Arr2[i4];
                if (c0604t9 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c0604t9);
                }
                i4++;
            }
        }
        C9[] c9Arr = this.d;
        if (c9Arr != null && c9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C9[] c9Arr2 = this.d;
                if (i5 >= c9Arr2.length) {
                    break;
                }
                C9 c9 = c9Arr2[i5];
                if (c9 != null) {
                    codedOutputByteBufferNano.writeMessage(10, c9);
                }
                i5++;
            }
        }
        String[] strArr = this.e;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.e;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(11, str);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final E9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                B9[] b9Arr = this.f414a;
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
                this.f414a = b9Arr2;
            } else if (readTag == 34) {
                if (this.b == null) {
                    this.b = new C0679w9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C0604t9[] c0604t9Arr = this.c;
                int length2 = c0604t9Arr == null ? 0 : c0604t9Arr.length;
                int i3 = repeatedFieldArrayLength2 + length2;
                C0604t9[] c0604t9Arr2 = new C0604t9[i3];
                if (length2 != 0) {
                    System.arraycopy(c0604t9Arr, 0, c0604t9Arr2, 0, length2);
                }
                while (length2 < i3 - 1) {
                    C0604t9 c0604t9 = new C0604t9();
                    c0604t9Arr2[length2] = c0604t9;
                    codedInputByteBufferNano.readMessage(c0604t9);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C0604t9 c0604t92 = new C0604t9();
                c0604t9Arr2[length2] = c0604t92;
                codedInputByteBufferNano.readMessage(c0604t92);
                this.c = c0604t9Arr2;
            } else if (readTag == 82) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                C9[] c9Arr = this.d;
                int length3 = c9Arr == null ? 0 : c9Arr.length;
                int i4 = repeatedFieldArrayLength3 + length3;
                C9[] c9Arr2 = new C9[i4];
                if (length3 != 0) {
                    System.arraycopy(c9Arr, 0, c9Arr2, 0, length3);
                }
                while (length3 < i4 - 1) {
                    C9 c9 = new C9();
                    c9Arr2[length3] = c9;
                    codedInputByteBufferNano.readMessage(c9);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                C9 c92 = new C9();
                c9Arr2[length3] = c92;
                codedInputByteBufferNano.readMessage(c92);
                this.d = c9Arr2;
            } else if (readTag != 90) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                String[] strArr = this.e;
                int length4 = strArr == null ? 0 : strArr.length;
                int i5 = repeatedFieldArrayLength4 + length4;
                String[] strArr2 = new String[i5];
                if (length4 != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length4);
                }
                while (length4 < i5 - 1) {
                    strArr2[length4] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length4++;
                }
                strArr2[length4] = codedInputByteBufferNano.readString();
                this.e = strArr2;
            }
        }
        return this;
    }

    public static E9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new E9().mergeFrom(codedInputByteBufferNano);
    }

    public static E9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (E9) MessageNano.mergeFrom(new E9(), bArr);
    }
}
