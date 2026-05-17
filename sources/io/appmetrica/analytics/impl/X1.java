package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class X1 extends MessageNano {
    public static volatile X1[] d;

    /* renamed from: a  reason: collision with root package name */
    public W1[] f852a;
    public V1 b;
    public String[] c;

    public X1() {
        a();
    }

    public static X1[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new X1[0];
                }
            }
        }
        return d;
    }

    public final X1 a() {
        this.f852a = W1.b();
        this.b = null;
        this.c = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        W1[] w1Arr = this.f852a;
        int i = 0;
        if (w1Arr != null && w1Arr.length > 0) {
            int i2 = 0;
            while (true) {
                W1[] w1Arr2 = this.f852a;
                if (i2 >= w1Arr2.length) {
                    break;
                }
                W1 w1 = w1Arr2[i2];
                if (w1 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, w1);
                }
                i2++;
            }
        }
        V1 v1 = this.b;
        if (v1 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, v1);
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
        W1[] w1Arr = this.f852a;
        int i = 0;
        if (w1Arr != null && w1Arr.length > 0) {
            int i2 = 0;
            while (true) {
                W1[] w1Arr2 = this.f852a;
                if (i2 >= w1Arr2.length) {
                    break;
                }
                W1 w1 = w1Arr2[i2];
                if (w1 != null) {
                    codedOutputByteBufferNano.writeMessage(1, w1);
                }
                i2++;
            }
        }
        V1 v1 = this.b;
        if (v1 != null) {
            codedOutputByteBufferNano.writeMessage(2, v1);
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
    public final X1 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                W1[] w1Arr = this.f852a;
                int length = w1Arr == null ? 0 : w1Arr.length;
                int i = repeatedFieldArrayLength + length;
                W1[] w1Arr2 = new W1[i];
                if (length != 0) {
                    System.arraycopy(w1Arr, 0, w1Arr2, 0, length);
                }
                while (length < i - 1) {
                    W1 w1 = new W1();
                    w1Arr2[length] = w1;
                    codedInputByteBufferNano.readMessage(w1);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                W1 w12 = new W1();
                w1Arr2[length] = w12;
                codedInputByteBufferNano.readMessage(w12);
                this.f852a = w1Arr2;
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new V1();
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

    public static X1 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new X1().mergeFrom(codedInputByteBufferNano);
    }

    public static X1 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (X1) MessageNano.mergeFrom(new X1(), bArr);
    }
}
