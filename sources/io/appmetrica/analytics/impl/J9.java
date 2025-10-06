package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class J9 extends MessageNano {
    public static final int g = -1;
    public static final int h = 0;
    public static final int i = 1;
    public static volatile J9[] j;

    /* renamed from: a  reason: collision with root package name */
    public G9[] f515a;
    public B9 b;
    public C0731y9[] c;
    public H9[] d;
    public String[] e;
    public byte[][] f;

    public J9() {
        a();
    }

    public static J9[] b() {
        if (j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (j == null) {
                    j = new J9[0];
                }
            }
        }
        return j;
    }

    public final J9 a() {
        this.f515a = G9.b();
        this.b = null;
        this.c = C0731y9.b();
        this.d = H9.b();
        this.e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f = WireFormatNano.EMPTY_BYTES_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        G9[] g9Arr = this.f515a;
        int i2 = 0;
        if (g9Arr != null && g9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                G9[] g9Arr2 = this.f515a;
                if (i3 >= g9Arr2.length) {
                    break;
                }
                G9 g9 = g9Arr2[i3];
                if (g9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, g9);
                }
                i3++;
            }
        }
        B9 b9 = this.b;
        if (b9 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, b9);
        }
        C0731y9[] c0731y9Arr = this.c;
        if (c0731y9Arr != null && c0731y9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0731y9[] c0731y9Arr2 = this.c;
                if (i4 >= c0731y9Arr2.length) {
                    break;
                }
                C0731y9 c0731y9 = c0731y9Arr2[i4];
                if (c0731y9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, c0731y9) + computeSerializedSize;
                }
                i4++;
            }
        }
        H9[] h9Arr = this.d;
        if (h9Arr != null && h9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                H9[] h9Arr2 = this.d;
                if (i5 >= h9Arr2.length) {
                    break;
                }
                H9 h9 = h9Arr2[i5];
                if (h9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(10, h9) + computeSerializedSize;
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
        G9[] g9Arr = this.f515a;
        int i2 = 0;
        if (g9Arr != null && g9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                G9[] g9Arr2 = this.f515a;
                if (i3 >= g9Arr2.length) {
                    break;
                }
                G9 g9 = g9Arr2[i3];
                if (g9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, g9);
                }
                i3++;
            }
        }
        B9 b9 = this.b;
        if (b9 != null) {
            codedOutputByteBufferNano.writeMessage(4, b9);
        }
        C0731y9[] c0731y9Arr = this.c;
        if (c0731y9Arr != null && c0731y9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0731y9[] c0731y9Arr2 = this.c;
                if (i4 >= c0731y9Arr2.length) {
                    break;
                }
                C0731y9 c0731y9 = c0731y9Arr2[i4];
                if (c0731y9 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c0731y9);
                }
                i4++;
            }
        }
        H9[] h9Arr = this.d;
        if (h9Arr != null && h9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                H9[] h9Arr2 = this.d;
                if (i5 >= h9Arr2.length) {
                    break;
                }
                H9 h9 = h9Arr2[i5];
                if (h9 != null) {
                    codedOutputByteBufferNano.writeMessage(10, h9);
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
    public final J9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                G9[] g9Arr = this.f515a;
                int length = g9Arr == null ? 0 : g9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                G9[] g9Arr2 = new G9[i2];
                if (length != 0) {
                    System.arraycopy(g9Arr, 0, g9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    G9 g9 = new G9();
                    g9Arr2[length] = g9;
                    codedInputByteBufferNano.readMessage(g9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                G9 g92 = new G9();
                g9Arr2[length] = g92;
                codedInputByteBufferNano.readMessage(g92);
                this.f515a = g9Arr2;
            } else if (readTag == 34) {
                if (this.b == null) {
                    this.b = new B9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C0731y9[] c0731y9Arr = this.c;
                int length2 = c0731y9Arr == null ? 0 : c0731y9Arr.length;
                int i3 = repeatedFieldArrayLength2 + length2;
                C0731y9[] c0731y9Arr2 = new C0731y9[i3];
                if (length2 != 0) {
                    System.arraycopy(c0731y9Arr, 0, c0731y9Arr2, 0, length2);
                }
                while (length2 < i3 - 1) {
                    C0731y9 c0731y9 = new C0731y9();
                    c0731y9Arr2[length2] = c0731y9;
                    codedInputByteBufferNano.readMessage(c0731y9);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C0731y9 c0731y92 = new C0731y9();
                c0731y9Arr2[length2] = c0731y92;
                codedInputByteBufferNano.readMessage(c0731y92);
                this.c = c0731y9Arr2;
            } else if (readTag == 82) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                H9[] h9Arr = this.d;
                int length3 = h9Arr == null ? 0 : h9Arr.length;
                int i4 = repeatedFieldArrayLength3 + length3;
                H9[] h9Arr2 = new H9[i4];
                if (length3 != 0) {
                    System.arraycopy(h9Arr, 0, h9Arr2, 0, length3);
                }
                while (length3 < i4 - 1) {
                    H9 h9 = new H9();
                    h9Arr2[length3] = h9;
                    codedInputByteBufferNano.readMessage(h9);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                H9 h92 = new H9();
                h9Arr2[length3] = h92;
                codedInputByteBufferNano.readMessage(h92);
                this.d = h9Arr2;
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

    public static J9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new J9().mergeFrom(codedInputByteBufferNano);
    }

    public static J9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (J9) MessageNano.mergeFrom(new J9(), bArr);
    }
}
