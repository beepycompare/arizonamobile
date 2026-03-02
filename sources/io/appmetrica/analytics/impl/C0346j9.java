package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.j9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0346j9 extends MessageNano {
    public static final int g = -1;
    public static final int h = 0;
    public static final int i = 1;
    public static volatile C0346j9[] j;

    /* renamed from: a  reason: collision with root package name */
    public C0269g9[] f1060a;
    public C0140b9 b;
    public Y8[] c;
    public C0295h9[] d;
    public String[] e;
    public byte[][] f;

    public C0346j9() {
        a();
    }

    public static C0346j9[] b() {
        if (j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (j == null) {
                    j = new C0346j9[0];
                }
            }
        }
        return j;
    }

    public final C0346j9 a() {
        this.f1060a = C0269g9.b();
        this.b = null;
        this.c = Y8.b();
        this.d = C0295h9.b();
        this.e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f = WireFormatNano.EMPTY_BYTES_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0269g9[] c0269g9Arr = this.f1060a;
        int i2 = 0;
        if (c0269g9Arr != null && c0269g9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0269g9[] c0269g9Arr2 = this.f1060a;
                if (i3 >= c0269g9Arr2.length) {
                    break;
                }
                C0269g9 c0269g9 = c0269g9Arr2[i3];
                if (c0269g9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0269g9);
                }
                i3++;
            }
        }
        C0140b9 c0140b9 = this.b;
        if (c0140b9 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0140b9);
        }
        Y8[] y8Arr = this.c;
        if (y8Arr != null && y8Arr.length > 0) {
            int i4 = 0;
            while (true) {
                Y8[] y8Arr2 = this.c;
                if (i4 >= y8Arr2.length) {
                    break;
                }
                Y8 y8 = y8Arr2[i4];
                if (y8 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, y8) + computeSerializedSize;
                }
                i4++;
            }
        }
        C0295h9[] c0295h9Arr = this.d;
        if (c0295h9Arr != null && c0295h9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C0295h9[] c0295h9Arr2 = this.d;
                if (i5 >= c0295h9Arr2.length) {
                    break;
                }
                C0295h9 c0295h9 = c0295h9Arr2[i5];
                if (c0295h9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(10, c0295h9) + computeSerializedSize;
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
        C0269g9[] c0269g9Arr = this.f1060a;
        int i2 = 0;
        if (c0269g9Arr != null && c0269g9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0269g9[] c0269g9Arr2 = this.f1060a;
                if (i3 >= c0269g9Arr2.length) {
                    break;
                }
                C0269g9 c0269g9 = c0269g9Arr2[i3];
                if (c0269g9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c0269g9);
                }
                i3++;
            }
        }
        C0140b9 c0140b9 = this.b;
        if (c0140b9 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0140b9);
        }
        Y8[] y8Arr = this.c;
        if (y8Arr != null && y8Arr.length > 0) {
            int i4 = 0;
            while (true) {
                Y8[] y8Arr2 = this.c;
                if (i4 >= y8Arr2.length) {
                    break;
                }
                Y8 y8 = y8Arr2[i4];
                if (y8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, y8);
                }
                i4++;
            }
        }
        C0295h9[] c0295h9Arr = this.d;
        if (c0295h9Arr != null && c0295h9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C0295h9[] c0295h9Arr2 = this.d;
                if (i5 >= c0295h9Arr2.length) {
                    break;
                }
                C0295h9 c0295h9 = c0295h9Arr2[i5];
                if (c0295h9 != null) {
                    codedOutputByteBufferNano.writeMessage(10, c0295h9);
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
    public final C0346j9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C0269g9[] c0269g9Arr = this.f1060a;
                int length = c0269g9Arr == null ? 0 : c0269g9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                C0269g9[] c0269g9Arr2 = new C0269g9[i2];
                if (length != 0) {
                    System.arraycopy(c0269g9Arr, 0, c0269g9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    C0269g9 c0269g9 = new C0269g9();
                    c0269g9Arr2[length] = c0269g9;
                    codedInputByteBufferNano.readMessage(c0269g9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0269g9 c0269g92 = new C0269g9();
                c0269g9Arr2[length] = c0269g92;
                codedInputByteBufferNano.readMessage(c0269g92);
                this.f1060a = c0269g9Arr2;
            } else if (readTag == 34) {
                if (this.b == null) {
                    this.b = new C0140b9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                Y8[] y8Arr = this.c;
                int length2 = y8Arr == null ? 0 : y8Arr.length;
                int i3 = repeatedFieldArrayLength2 + length2;
                Y8[] y8Arr2 = new Y8[i3];
                if (length2 != 0) {
                    System.arraycopy(y8Arr, 0, y8Arr2, 0, length2);
                }
                while (length2 < i3 - 1) {
                    Y8 y8 = new Y8();
                    y8Arr2[length2] = y8;
                    codedInputByteBufferNano.readMessage(y8);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                Y8 y82 = new Y8();
                y8Arr2[length2] = y82;
                codedInputByteBufferNano.readMessage(y82);
                this.c = y8Arr2;
            } else if (readTag == 82) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                C0295h9[] c0295h9Arr = this.d;
                int length3 = c0295h9Arr == null ? 0 : c0295h9Arr.length;
                int i4 = repeatedFieldArrayLength3 + length3;
                C0295h9[] c0295h9Arr2 = new C0295h9[i4];
                if (length3 != 0) {
                    System.arraycopy(c0295h9Arr, 0, c0295h9Arr2, 0, length3);
                }
                while (length3 < i4 - 1) {
                    C0295h9 c0295h9 = new C0295h9();
                    c0295h9Arr2[length3] = c0295h9;
                    codedInputByteBufferNano.readMessage(c0295h9);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                C0295h9 c0295h92 = new C0295h9();
                c0295h9Arr2[length3] = c0295h92;
                codedInputByteBufferNano.readMessage(c0295h92);
                this.d = c0295h9Arr2;
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

    public static C0346j9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0346j9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0346j9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0346j9) MessageNano.mergeFrom(new C0346j9(), bArr);
    }
}
