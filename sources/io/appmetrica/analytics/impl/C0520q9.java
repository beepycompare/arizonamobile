package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.q9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0520q9 extends MessageNano {
    public static final int g = -1;
    public static final int h = 0;
    public static final int i = 1;
    public static volatile C0520q9[] j;

    /* renamed from: a  reason: collision with root package name */
    public C0445n9[] f1070a;
    public C0318i9 b;
    public C0240f9[] c;
    public C0470o9[] d;
    public String[] e;
    public byte[][] f;

    public C0520q9() {
        a();
    }

    public static C0520q9[] b() {
        if (j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (j == null) {
                    j = new C0520q9[0];
                }
            }
        }
        return j;
    }

    public final C0520q9 a() {
        this.f1070a = C0445n9.b();
        this.b = null;
        this.c = C0240f9.b();
        this.d = C0470o9.b();
        this.e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f = WireFormatNano.EMPTY_BYTES_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0445n9[] c0445n9Arr = this.f1070a;
        int i2 = 0;
        if (c0445n9Arr != null && c0445n9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0445n9[] c0445n9Arr2 = this.f1070a;
                if (i3 >= c0445n9Arr2.length) {
                    break;
                }
                C0445n9 c0445n9 = c0445n9Arr2[i3];
                if (c0445n9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0445n9);
                }
                i3++;
            }
        }
        C0318i9 c0318i9 = this.b;
        if (c0318i9 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0318i9);
        }
        C0240f9[] c0240f9Arr = this.c;
        if (c0240f9Arr != null && c0240f9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0240f9[] c0240f9Arr2 = this.c;
                if (i4 >= c0240f9Arr2.length) {
                    break;
                }
                C0240f9 c0240f9 = c0240f9Arr2[i4];
                if (c0240f9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, c0240f9) + computeSerializedSize;
                }
                i4++;
            }
        }
        C0470o9[] c0470o9Arr = this.d;
        if (c0470o9Arr != null && c0470o9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C0470o9[] c0470o9Arr2 = this.d;
                if (i5 >= c0470o9Arr2.length) {
                    break;
                }
                C0470o9 c0470o9 = c0470o9Arr2[i5];
                if (c0470o9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(10, c0470o9) + computeSerializedSize;
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
        C0445n9[] c0445n9Arr = this.f1070a;
        int i2 = 0;
        if (c0445n9Arr != null && c0445n9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0445n9[] c0445n9Arr2 = this.f1070a;
                if (i3 >= c0445n9Arr2.length) {
                    break;
                }
                C0445n9 c0445n9 = c0445n9Arr2[i3];
                if (c0445n9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c0445n9);
                }
                i3++;
            }
        }
        C0318i9 c0318i9 = this.b;
        if (c0318i9 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0318i9);
        }
        C0240f9[] c0240f9Arr = this.c;
        if (c0240f9Arr != null && c0240f9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0240f9[] c0240f9Arr2 = this.c;
                if (i4 >= c0240f9Arr2.length) {
                    break;
                }
                C0240f9 c0240f9 = c0240f9Arr2[i4];
                if (c0240f9 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c0240f9);
                }
                i4++;
            }
        }
        C0470o9[] c0470o9Arr = this.d;
        if (c0470o9Arr != null && c0470o9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C0470o9[] c0470o9Arr2 = this.d;
                if (i5 >= c0470o9Arr2.length) {
                    break;
                }
                C0470o9 c0470o9 = c0470o9Arr2[i5];
                if (c0470o9 != null) {
                    codedOutputByteBufferNano.writeMessage(10, c0470o9);
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
    public final C0520q9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C0445n9[] c0445n9Arr = this.f1070a;
                int length = c0445n9Arr == null ? 0 : c0445n9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                C0445n9[] c0445n9Arr2 = new C0445n9[i2];
                if (length != 0) {
                    System.arraycopy(c0445n9Arr, 0, c0445n9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    C0445n9 c0445n9 = new C0445n9();
                    c0445n9Arr2[length] = c0445n9;
                    codedInputByteBufferNano.readMessage(c0445n9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0445n9 c0445n92 = new C0445n9();
                c0445n9Arr2[length] = c0445n92;
                codedInputByteBufferNano.readMessage(c0445n92);
                this.f1070a = c0445n9Arr2;
            } else if (readTag == 34) {
                if (this.b == null) {
                    this.b = new C0318i9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C0240f9[] c0240f9Arr = this.c;
                int length2 = c0240f9Arr == null ? 0 : c0240f9Arr.length;
                int i3 = repeatedFieldArrayLength2 + length2;
                C0240f9[] c0240f9Arr2 = new C0240f9[i3];
                if (length2 != 0) {
                    System.arraycopy(c0240f9Arr, 0, c0240f9Arr2, 0, length2);
                }
                while (length2 < i3 - 1) {
                    C0240f9 c0240f9 = new C0240f9();
                    c0240f9Arr2[length2] = c0240f9;
                    codedInputByteBufferNano.readMessage(c0240f9);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C0240f9 c0240f92 = new C0240f9();
                c0240f9Arr2[length2] = c0240f92;
                codedInputByteBufferNano.readMessage(c0240f92);
                this.c = c0240f9Arr2;
            } else if (readTag == 82) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                C0470o9[] c0470o9Arr = this.d;
                int length3 = c0470o9Arr == null ? 0 : c0470o9Arr.length;
                int i4 = repeatedFieldArrayLength3 + length3;
                C0470o9[] c0470o9Arr2 = new C0470o9[i4];
                if (length3 != 0) {
                    System.arraycopy(c0470o9Arr, 0, c0470o9Arr2, 0, length3);
                }
                while (length3 < i4 - 1) {
                    C0470o9 c0470o9 = new C0470o9();
                    c0470o9Arr2[length3] = c0470o9;
                    codedInputByteBufferNano.readMessage(c0470o9);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                C0470o9 c0470o92 = new C0470o9();
                c0470o9Arr2[length3] = c0470o92;
                codedInputByteBufferNano.readMessage(c0470o92);
                this.d = c0470o9Arr2;
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

    public static C0520q9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0520q9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0520q9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0520q9) MessageNano.mergeFrom(new C0520q9(), bArr);
    }
}
