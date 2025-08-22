package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class G9 extends MessageNano {
    public static final int f = -1;
    public static final int g = 0;
    public static final int h = 1;
    public static volatile G9[] i;

    /* renamed from: a  reason: collision with root package name */
    public D9[] f453a;
    public C0726y9 b;
    public C0651v9[] c;
    public E9[] d;
    public String[] e;

    public G9() {
        a();
    }

    public static G9[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new G9[0];
                }
            }
        }
        return i;
    }

    public final G9 a() {
        this.f453a = D9.b();
        this.b = null;
        this.c = C0651v9.b();
        this.d = E9.b();
        this.e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        D9[] d9Arr = this.f453a;
        int i2 = 0;
        if (d9Arr != null && d9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                D9[] d9Arr2 = this.f453a;
                if (i3 >= d9Arr2.length) {
                    break;
                }
                D9 d9 = d9Arr2[i3];
                if (d9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, d9);
                }
                i3++;
            }
        }
        C0726y9 c0726y9 = this.b;
        if (c0726y9 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0726y9);
        }
        C0651v9[] c0651v9Arr = this.c;
        if (c0651v9Arr != null && c0651v9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0651v9[] c0651v9Arr2 = this.c;
                if (i4 >= c0651v9Arr2.length) {
                    break;
                }
                C0651v9 c0651v9 = c0651v9Arr2[i4];
                if (c0651v9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, c0651v9) + computeSerializedSize;
                }
                i4++;
            }
        }
        E9[] e9Arr = this.d;
        if (e9Arr != null && e9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                E9[] e9Arr2 = this.d;
                if (i5 >= e9Arr2.length) {
                    break;
                }
                E9 e9 = e9Arr2[i5];
                if (e9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, e9);
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
        D9[] d9Arr = this.f453a;
        int i2 = 0;
        if (d9Arr != null && d9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                D9[] d9Arr2 = this.f453a;
                if (i3 >= d9Arr2.length) {
                    break;
                }
                D9 d9 = d9Arr2[i3];
                if (d9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, d9);
                }
                i3++;
            }
        }
        C0726y9 c0726y9 = this.b;
        if (c0726y9 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0726y9);
        }
        C0651v9[] c0651v9Arr = this.c;
        if (c0651v9Arr != null && c0651v9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0651v9[] c0651v9Arr2 = this.c;
                if (i4 >= c0651v9Arr2.length) {
                    break;
                }
                C0651v9 c0651v9 = c0651v9Arr2[i4];
                if (c0651v9 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c0651v9);
                }
                i4++;
            }
        }
        E9[] e9Arr = this.d;
        if (e9Arr != null && e9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                E9[] e9Arr2 = this.d;
                if (i5 >= e9Arr2.length) {
                    break;
                }
                E9 e9 = e9Arr2[i5];
                if (e9 != null) {
                    codedOutputByteBufferNano.writeMessage(10, e9);
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
    public final G9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                D9[] d9Arr = this.f453a;
                int length = d9Arr == null ? 0 : d9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                D9[] d9Arr2 = new D9[i2];
                if (length != 0) {
                    System.arraycopy(d9Arr, 0, d9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    D9 d9 = new D9();
                    d9Arr2[length] = d9;
                    codedInputByteBufferNano.readMessage(d9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                D9 d92 = new D9();
                d9Arr2[length] = d92;
                codedInputByteBufferNano.readMessage(d92);
                this.f453a = d9Arr2;
            } else if (readTag == 34) {
                if (this.b == null) {
                    this.b = new C0726y9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C0651v9[] c0651v9Arr = this.c;
                int length2 = c0651v9Arr == null ? 0 : c0651v9Arr.length;
                int i3 = repeatedFieldArrayLength2 + length2;
                C0651v9[] c0651v9Arr2 = new C0651v9[i3];
                if (length2 != 0) {
                    System.arraycopy(c0651v9Arr, 0, c0651v9Arr2, 0, length2);
                }
                while (length2 < i3 - 1) {
                    C0651v9 c0651v9 = new C0651v9();
                    c0651v9Arr2[length2] = c0651v9;
                    codedInputByteBufferNano.readMessage(c0651v9);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C0651v9 c0651v92 = new C0651v9();
                c0651v9Arr2[length2] = c0651v92;
                codedInputByteBufferNano.readMessage(c0651v92);
                this.c = c0651v9Arr2;
            } else if (readTag == 82) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                E9[] e9Arr = this.d;
                int length3 = e9Arr == null ? 0 : e9Arr.length;
                int i4 = repeatedFieldArrayLength3 + length3;
                E9[] e9Arr2 = new E9[i4];
                if (length3 != 0) {
                    System.arraycopy(e9Arr, 0, e9Arr2, 0, length3);
                }
                while (length3 < i4 - 1) {
                    E9 e9 = new E9();
                    e9Arr2[length3] = e9;
                    codedInputByteBufferNano.readMessage(e9);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                E9 e92 = new E9();
                e9Arr2[length3] = e92;
                codedInputByteBufferNano.readMessage(e92);
                this.d = e9Arr2;
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

    public static G9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new G9().mergeFrom(codedInputByteBufferNano);
    }

    public static G9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (G9) MessageNano.mergeFrom(new G9(), bArr);
    }
}
