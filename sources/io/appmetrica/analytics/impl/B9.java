package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class B9 extends MessageNano {
    public static final int f = -1;
    public static final int g = 0;
    public static final int h = 1;
    public static volatile B9[] i;

    /* renamed from: a  reason: collision with root package name */
    public C0734y9[] f351a;
    public C0609t9 b;
    public C0535q9[] c;
    public C0759z9[] d;
    public String[] e;

    public B9() {
        a();
    }

    public static B9[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new B9[0];
                }
            }
        }
        return i;
    }

    public final B9 a() {
        this.f351a = C0734y9.b();
        this.b = null;
        this.c = C0535q9.b();
        this.d = C0759z9.b();
        this.e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0734y9[] c0734y9Arr = this.f351a;
        int i2 = 0;
        if (c0734y9Arr != null && c0734y9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0734y9[] c0734y9Arr2 = this.f351a;
                if (i3 >= c0734y9Arr2.length) {
                    break;
                }
                C0734y9 c0734y9 = c0734y9Arr2[i3];
                if (c0734y9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0734y9);
                }
                i3++;
            }
        }
        C0609t9 c0609t9 = this.b;
        if (c0609t9 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0609t9);
        }
        C0535q9[] c0535q9Arr = this.c;
        if (c0535q9Arr != null && c0535q9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0535q9[] c0535q9Arr2 = this.c;
                if (i4 >= c0535q9Arr2.length) {
                    break;
                }
                C0535q9 c0535q9 = c0535q9Arr2[i4];
                if (c0535q9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, c0535q9) + computeSerializedSize;
                }
                i4++;
            }
        }
        C0759z9[] c0759z9Arr = this.d;
        if (c0759z9Arr != null && c0759z9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C0759z9[] c0759z9Arr2 = this.d;
                if (i5 >= c0759z9Arr2.length) {
                    break;
                }
                C0759z9 c0759z9 = c0759z9Arr2[i5];
                if (c0759z9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, c0759z9);
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
        C0734y9[] c0734y9Arr = this.f351a;
        int i2 = 0;
        if (c0734y9Arr != null && c0734y9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0734y9[] c0734y9Arr2 = this.f351a;
                if (i3 >= c0734y9Arr2.length) {
                    break;
                }
                C0734y9 c0734y9 = c0734y9Arr2[i3];
                if (c0734y9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c0734y9);
                }
                i3++;
            }
        }
        C0609t9 c0609t9 = this.b;
        if (c0609t9 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0609t9);
        }
        C0535q9[] c0535q9Arr = this.c;
        if (c0535q9Arr != null && c0535q9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0535q9[] c0535q9Arr2 = this.c;
                if (i4 >= c0535q9Arr2.length) {
                    break;
                }
                C0535q9 c0535q9 = c0535q9Arr2[i4];
                if (c0535q9 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c0535q9);
                }
                i4++;
            }
        }
        C0759z9[] c0759z9Arr = this.d;
        if (c0759z9Arr != null && c0759z9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C0759z9[] c0759z9Arr2 = this.d;
                if (i5 >= c0759z9Arr2.length) {
                    break;
                }
                C0759z9 c0759z9 = c0759z9Arr2[i5];
                if (c0759z9 != null) {
                    codedOutputByteBufferNano.writeMessage(10, c0759z9);
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
    public final B9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C0734y9[] c0734y9Arr = this.f351a;
                int length = c0734y9Arr == null ? 0 : c0734y9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                C0734y9[] c0734y9Arr2 = new C0734y9[i2];
                if (length != 0) {
                    System.arraycopy(c0734y9Arr, 0, c0734y9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    C0734y9 c0734y9 = new C0734y9();
                    c0734y9Arr2[length] = c0734y9;
                    codedInputByteBufferNano.readMessage(c0734y9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0734y9 c0734y92 = new C0734y9();
                c0734y9Arr2[length] = c0734y92;
                codedInputByteBufferNano.readMessage(c0734y92);
                this.f351a = c0734y9Arr2;
            } else if (readTag == 34) {
                if (this.b == null) {
                    this.b = new C0609t9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C0535q9[] c0535q9Arr = this.c;
                int length2 = c0535q9Arr == null ? 0 : c0535q9Arr.length;
                int i3 = repeatedFieldArrayLength2 + length2;
                C0535q9[] c0535q9Arr2 = new C0535q9[i3];
                if (length2 != 0) {
                    System.arraycopy(c0535q9Arr, 0, c0535q9Arr2, 0, length2);
                }
                while (length2 < i3 - 1) {
                    C0535q9 c0535q9 = new C0535q9();
                    c0535q9Arr2[length2] = c0535q9;
                    codedInputByteBufferNano.readMessage(c0535q9);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C0535q9 c0535q92 = new C0535q9();
                c0535q9Arr2[length2] = c0535q92;
                codedInputByteBufferNano.readMessage(c0535q92);
                this.c = c0535q9Arr2;
            } else if (readTag == 82) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                C0759z9[] c0759z9Arr = this.d;
                int length3 = c0759z9Arr == null ? 0 : c0759z9Arr.length;
                int i4 = repeatedFieldArrayLength3 + length3;
                C0759z9[] c0759z9Arr2 = new C0759z9[i4];
                if (length3 != 0) {
                    System.arraycopy(c0759z9Arr, 0, c0759z9Arr2, 0, length3);
                }
                while (length3 < i4 - 1) {
                    C0759z9 c0759z9 = new C0759z9();
                    c0759z9Arr2[length3] = c0759z9;
                    codedInputByteBufferNano.readMessage(c0759z9);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                C0759z9 c0759z92 = new C0759z9();
                c0759z9Arr2[length3] = c0759z92;
                codedInputByteBufferNano.readMessage(c0759z92);
                this.d = c0759z9Arr2;
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

    public static B9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new B9().mergeFrom(codedInputByteBufferNano);
    }

    public static B9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (B9) MessageNano.mergeFrom(new B9(), bArr);
    }
}
