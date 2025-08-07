package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.d2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0197d2 extends MessageNano {
    public static volatile C0197d2[] d;

    /* renamed from: a  reason: collision with root package name */
    public C0171c2[] f809a;
    public C0145b2 b;
    public String[] c;

    public C0197d2() {
        a();
    }

    public static C0197d2[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0197d2[0];
                }
            }
        }
        return d;
    }

    public final C0197d2 a() {
        this.f809a = C0171c2.b();
        this.b = null;
        this.c = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0171c2[] c0171c2Arr = this.f809a;
        int i = 0;
        if (c0171c2Arr != null && c0171c2Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0171c2[] c0171c2Arr2 = this.f809a;
                if (i2 >= c0171c2Arr2.length) {
                    break;
                }
                C0171c2 c0171c2 = c0171c2Arr2[i2];
                if (c0171c2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0171c2);
                }
                i2++;
            }
        }
        C0145b2 c0145b2 = this.b;
        if (c0145b2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0145b2);
        }
        String[] strArr = this.c;
        if (strArr == null || strArr.length <= 0) {
            return computeSerializedSize;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            String[] strArr2 = this.c;
            if (i >= strArr2.length) {
                return computeSerializedSize + i3 + i4;
            }
            String str = strArr2[i];
            if (str != null) {
                i4++;
                i3 = CodedOutputByteBufferNano.computeStringSizeNoTag(str) + i3;
            }
            i++;
        }
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0171c2[] c0171c2Arr = this.f809a;
        int i = 0;
        if (c0171c2Arr != null && c0171c2Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C0171c2[] c0171c2Arr2 = this.f809a;
                if (i2 >= c0171c2Arr2.length) {
                    break;
                }
                C0171c2 c0171c2 = c0171c2Arr2[i2];
                if (c0171c2 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0171c2);
                }
                i2++;
            }
        }
        C0145b2 c0145b2 = this.b;
        if (c0145b2 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0145b2);
        }
        String[] strArr = this.c;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.c;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0197d2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                C0171c2[] c0171c2Arr = this.f809a;
                int length = c0171c2Arr == null ? 0 : c0171c2Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0171c2[] c0171c2Arr2 = new C0171c2[i];
                if (length != 0) {
                    System.arraycopy(c0171c2Arr, 0, c0171c2Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0171c2 c0171c2 = new C0171c2();
                    c0171c2Arr2[length] = c0171c2;
                    codedInputByteBufferNano.readMessage(c0171c2);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0171c2 c0171c22 = new C0171c2();
                c0171c2Arr2[length] = c0171c22;
                codedInputByteBufferNano.readMessage(c0171c22);
                this.f809a = c0171c2Arr2;
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0145b2();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                String[] strArr = this.c;
                int length2 = strArr == null ? 0 : strArr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                String[] strArr2 = new String[i2];
                if (length2 != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    strArr2[length2] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                strArr2[length2] = codedInputByteBufferNano.readString();
                this.c = strArr2;
            }
        }
        return this;
    }

    public static C0197d2 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0197d2().mergeFrom(codedInputByteBufferNano);
    }

    public static C0197d2 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0197d2) MessageNano.mergeFrom(new C0197d2(), bArr);
    }
}
