package io.appmetrica.analytics.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class Y5 extends MessageNano {
    public static final int l = 0;
    public static final int m = 1;
    public static volatile Y5[] n;
    public static byte[] o;
    public static volatile boolean p;

    /* renamed from: a  reason: collision with root package name */
    public C0159c6 f859a;
    public S5 b;
    public String c;
    public int d;
    public C0107a6[] e;
    public String f;
    public int g;
    public X5 h;
    public byte[] i;
    public byte[] j;
    public U5[] k;

    public Y5() {
        if (!p) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (!p) {
                    o = InternalNano.bytesDefaultValue("JVM");
                    p = true;
                }
            }
        }
        a();
    }

    public static Y5[] b() {
        if (n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (n == null) {
                    n = new Y5[0];
                }
            }
        }
        return n;
    }

    public final Y5 a() {
        this.f859a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = C0107a6.b();
        this.f = "";
        this.g = 0;
        this.h = null;
        this.i = (byte[]) o.clone();
        this.j = WireFormatNano.EMPTY_BYTES;
        this.k = U5.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0159c6 c0159c6 = this.f859a;
        if (c0159c6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0159c6);
        }
        S5 s5 = this.b;
        if (s5 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, s5);
        }
        if (!this.c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        C0107a6[] c0107a6Arr = this.e;
        int i2 = 0;
        if (c0107a6Arr != null && c0107a6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0107a6[] c0107a6Arr2 = this.e;
                if (i3 >= c0107a6Arr2.length) {
                    break;
                }
                C0107a6 c0107a6 = c0107a6Arr2[i3];
                if (c0107a6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0107a6);
                }
                i3++;
            }
        }
        if (!this.f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f);
        }
        int i4 = this.g;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i4);
        }
        X5 x5 = this.h;
        if (x5 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, x5);
        }
        if (!Arrays.equals(this.i, o)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.j);
        }
        U5[] u5Arr = this.k;
        if (u5Arr != null && u5Arr.length > 0) {
            while (true) {
                U5[] u5Arr2 = this.k;
                if (i2 >= u5Arr2.length) {
                    break;
                }
                U5 u5 = u5Arr2[i2];
                if (u5 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(11, u5) + computeSerializedSize;
                }
                i2++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0159c6 c0159c6 = this.f859a;
        if (c0159c6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0159c6);
        }
        S5 s5 = this.b;
        if (s5 != null) {
            codedOutputByteBufferNano.writeMessage(2, s5);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        C0107a6[] c0107a6Arr = this.e;
        int i2 = 0;
        if (c0107a6Arr != null && c0107a6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0107a6[] c0107a6Arr2 = this.e;
                if (i3 >= c0107a6Arr2.length) {
                    break;
                }
                C0107a6 c0107a6 = c0107a6Arr2[i3];
                if (c0107a6 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0107a6);
                }
                i3++;
            }
        }
        if (!this.f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f);
        }
        int i4 = this.g;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i4);
        }
        X5 x5 = this.h;
        if (x5 != null) {
            codedOutputByteBufferNano.writeMessage(8, x5);
        }
        if (!Arrays.equals(this.i, o)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(10, this.j);
        }
        U5[] u5Arr = this.k;
        if (u5Arr != null && u5Arr.length > 0) {
            while (true) {
                U5[] u5Arr2 = this.k;
                if (i2 >= u5Arr2.length) {
                    break;
                }
                U5 u5 = u5Arr2[i2];
                if (u5 != null) {
                    codedOutputByteBufferNano.writeMessage(11, u5);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Y5 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Y5().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Y5 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    if (this.f859a == null) {
                        this.f859a = new C0159c6();
                    }
                    codedInputByteBufferNano.readMessage(this.f859a);
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new S5();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                    break;
                case 26:
                    this.c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != -1 && readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.d = readInt32;
                        break;
                    }
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    C0107a6[] c0107a6Arr = this.e;
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
                    this.e = c0107a6Arr2;
                    break;
                case 50:
                    this.f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1) {
                        break;
                    } else {
                        this.g = readInt322;
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (this.h == null) {
                        this.h = new X5();
                    }
                    codedInputByteBufferNano.readMessage(this.h);
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readBytes();
                    break;
                case 82:
                    this.j = codedInputByteBufferNano.readBytes();
                    break;
                case 90:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    U5[] u5Arr = this.k;
                    int length2 = u5Arr == null ? 0 : u5Arr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    U5[] u5Arr2 = new U5[i2];
                    if (length2 != 0) {
                        System.arraycopy(u5Arr, 0, u5Arr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        U5 u5 = new U5();
                        u5Arr2[length2] = u5;
                        codedInputByteBufferNano.readMessage(u5);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    U5 u52 = new U5();
                    u5Arr2[length2] = u52;
                    codedInputByteBufferNano.readMessage(u52);
                    this.k = u5Arr2;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    public static Y5 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Y5) MessageNano.mergeFrom(new Y5(), bArr);
    }
}
