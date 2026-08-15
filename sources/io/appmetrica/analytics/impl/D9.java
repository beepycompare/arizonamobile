package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class D9 extends MessageNano {
    public static final int g = -1;
    public static final int h = 0;
    public static final int i = 1;
    public static volatile D9[] j;

    /* renamed from: a  reason: collision with root package name */
    public A9[] f512a;
    public C0658v9 b;
    public C0580s9[] c;
    public B9[] d;
    public String[] e;
    public byte[][] f;

    public D9() {
        a();
    }

    public static D9[] b() {
        if (j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (j == null) {
                    j = new D9[0];
                }
            }
        }
        return j;
    }

    public final D9 a() {
        this.f512a = A9.b();
        this.b = null;
        this.c = C0580s9.b();
        this.d = B9.b();
        this.e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f = WireFormatNano.EMPTY_BYTES_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        A9[] a9Arr = this.f512a;
        int i2 = 0;
        if (a9Arr != null && a9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                A9[] a9Arr2 = this.f512a;
                if (i3 >= a9Arr2.length) {
                    break;
                }
                A9 a9 = a9Arr2[i3];
                if (a9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, a9);
                }
                i3++;
            }
        }
        C0658v9 c0658v9 = this.b;
        if (c0658v9 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0658v9);
        }
        C0580s9[] c0580s9Arr = this.c;
        if (c0580s9Arr != null && c0580s9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0580s9[] c0580s9Arr2 = this.c;
                if (i4 >= c0580s9Arr2.length) {
                    break;
                }
                C0580s9 c0580s9 = c0580s9Arr2[i4];
                if (c0580s9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, c0580s9) + computeSerializedSize;
                }
                i4++;
            }
        }
        B9[] b9Arr = this.d;
        if (b9Arr != null && b9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                B9[] b9Arr2 = this.d;
                if (i5 >= b9Arr2.length) {
                    break;
                }
                B9 b9 = b9Arr2[i5];
                if (b9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(10, b9) + computeSerializedSize;
                }
                i5++;
            }
        }
        String[] strArr = this.e;
        if (strArr != null && strArr.length > 0) {
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                String[] strArr2 = this.e;
                if (i6 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i6];
                if (str != null) {
                    i8++;
                    i7 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i6++;
            }
            computeSerializedSize = computeSerializedSize + i7 + i8;
        }
        byte[][] bArr = this.f;
        if (bArr == null || bArr.length <= 0) {
            return computeSerializedSize;
        }
        int i9 = 0;
        int i10 = 0;
        while (true) {
            byte[][] bArr2 = this.f;
            if (i2 >= bArr2.length) {
                return computeSerializedSize + i9 + i10;
            }
            byte[] bArr3 = bArr2[i2];
            if (bArr3 != null) {
                i10++;
                i9 = CodedOutputByteBufferNano.computeBytesSizeNoTag(bArr3) + i9;
            }
            i2++;
        }
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        A9[] a9Arr = this.f512a;
        int i2 = 0;
        if (a9Arr != null && a9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                A9[] a9Arr2 = this.f512a;
                if (i3 >= a9Arr2.length) {
                    break;
                }
                A9 a9 = a9Arr2[i3];
                if (a9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, a9);
                }
                i3++;
            }
        }
        C0658v9 c0658v9 = this.b;
        if (c0658v9 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0658v9);
        }
        C0580s9[] c0580s9Arr = this.c;
        if (c0580s9Arr != null && c0580s9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0580s9[] c0580s9Arr2 = this.c;
                if (i4 >= c0580s9Arr2.length) {
                    break;
                }
                C0580s9 c0580s9 = c0580s9Arr2[i4];
                if (c0580s9 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c0580s9);
                }
                i4++;
            }
        }
        B9[] b9Arr = this.d;
        if (b9Arr != null && b9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                B9[] b9Arr2 = this.d;
                if (i5 >= b9Arr2.length) {
                    break;
                }
                B9 b9 = b9Arr2[i5];
                if (b9 != null) {
                    codedOutputByteBufferNano.writeMessage(10, b9);
                }
                i5++;
            }
        }
        String[] strArr = this.e;
        if (strArr != null && strArr.length > 0) {
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.e;
                if (i6 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i6];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(11, str);
                }
                i6++;
            }
        }
        byte[][] bArr = this.f;
        if (bArr != null && bArr.length > 0) {
            while (true) {
                byte[][] bArr2 = this.f;
                if (i2 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i2];
                if (bArr3 != null) {
                    codedOutputByteBufferNano.writeBytes(12, bArr3);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final D9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                A9[] a9Arr = this.f512a;
                int length = a9Arr == null ? 0 : a9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                A9[] a9Arr2 = new A9[i2];
                if (length != 0) {
                    System.arraycopy(a9Arr, 0, a9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    A9 a9 = new A9();
                    a9Arr2[length] = a9;
                    codedInputByteBufferNano.readMessage(a9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                A9 a92 = new A9();
                a9Arr2[length] = a92;
                codedInputByteBufferNano.readMessage(a92);
                this.f512a = a9Arr2;
            } else if (readTag == 34) {
                if (this.b == null) {
                    this.b = new C0658v9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C0580s9[] c0580s9Arr = this.c;
                int length2 = c0580s9Arr == null ? 0 : c0580s9Arr.length;
                int i3 = repeatedFieldArrayLength2 + length2;
                C0580s9[] c0580s9Arr2 = new C0580s9[i3];
                if (length2 != 0) {
                    System.arraycopy(c0580s9Arr, 0, c0580s9Arr2, 0, length2);
                }
                while (length2 < i3 - 1) {
                    C0580s9 c0580s9 = new C0580s9();
                    c0580s9Arr2[length2] = c0580s9;
                    codedInputByteBufferNano.readMessage(c0580s9);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C0580s9 c0580s92 = new C0580s9();
                c0580s9Arr2[length2] = c0580s92;
                codedInputByteBufferNano.readMessage(c0580s92);
                this.c = c0580s9Arr2;
            } else if (readTag == 82) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                B9[] b9Arr = this.d;
                int length3 = b9Arr == null ? 0 : b9Arr.length;
                int i4 = repeatedFieldArrayLength3 + length3;
                B9[] b9Arr2 = new B9[i4];
                if (length3 != 0) {
                    System.arraycopy(b9Arr, 0, b9Arr2, 0, length3);
                }
                while (length3 < i4 - 1) {
                    B9 b9 = new B9();
                    b9Arr2[length3] = b9;
                    codedInputByteBufferNano.readMessage(b9);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                B9 b92 = new B9();
                b9Arr2[length3] = b92;
                codedInputByteBufferNano.readMessage(b92);
                this.d = b9Arr2;
            } else if (readTag == 90) {
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
            } else if (readTag != 98) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                byte[][] bArr = this.f;
                int length5 = bArr == null ? 0 : bArr.length;
                int i6 = repeatedFieldArrayLength5 + length5;
                byte[][] bArr2 = new byte[i6];
                if (length5 != 0) {
                    System.arraycopy(bArr, 0, bArr2, 0, length5);
                }
                while (length5 < i6 - 1) {
                    bArr2[length5] = codedInputByteBufferNano.readBytes();
                    codedInputByteBufferNano.readTag();
                    length5++;
                }
                bArr2[length5] = codedInputByteBufferNano.readBytes();
                this.f = bArr2;
            }
        }
        return this;
    }

    public static D9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new D9().mergeFrom(codedInputByteBufferNano);
    }

    public static D9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (D9) MessageNano.mergeFrom(new D9(), bArr);
    }
}
