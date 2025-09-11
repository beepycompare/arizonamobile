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
/* renamed from: io.appmetrica.analytics.impl.w6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0677w6 extends MessageNano {
    public static final int l = 0;
    public static final int m = 1;
    public static volatile C0677w6[] n;
    public static byte[] o;
    public static volatile boolean p;

    /* renamed from: a  reason: collision with root package name */
    public A6 f1135a;
    public C0528q6 b;
    public String c;
    public int d;
    public C0727y6[] e;
    public String f;
    public int g;
    public C0652v6 h;
    public byte[] i;
    public byte[] j;
    public C0577s6[] k;

    public C0677w6() {
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

    public static C0677w6[] b() {
        if (n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (n == null) {
                    n = new C0677w6[0];
                }
            }
        }
        return n;
    }

    public final C0677w6 a() {
        this.f1135a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = C0727y6.b();
        this.f = "";
        this.g = 0;
        this.h = null;
        this.i = (byte[]) o.clone();
        this.j = WireFormatNano.EMPTY_BYTES;
        this.k = C0577s6.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        A6 a6 = this.f1135a;
        if (a6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, a6);
        }
        C0528q6 c0528q6 = this.b;
        if (c0528q6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0528q6);
        }
        if (!this.c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        C0727y6[] c0727y6Arr = this.e;
        int i2 = 0;
        if (c0727y6Arr != null && c0727y6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0727y6[] c0727y6Arr2 = this.e;
                if (i3 >= c0727y6Arr2.length) {
                    break;
                }
                C0727y6 c0727y6 = c0727y6Arr2[i3];
                if (c0727y6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0727y6);
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
        C0652v6 c0652v6 = this.h;
        if (c0652v6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, c0652v6);
        }
        if (!Arrays.equals(this.i, o)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.j);
        }
        C0577s6[] c0577s6Arr = this.k;
        if (c0577s6Arr != null && c0577s6Arr.length > 0) {
            while (true) {
                C0577s6[] c0577s6Arr2 = this.k;
                if (i2 >= c0577s6Arr2.length) {
                    break;
                }
                C0577s6 c0577s6 = c0577s6Arr2[i2];
                if (c0577s6 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(11, c0577s6) + computeSerializedSize;
                }
                i2++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        A6 a6 = this.f1135a;
        if (a6 != null) {
            codedOutputByteBufferNano.writeMessage(1, a6);
        }
        C0528q6 c0528q6 = this.b;
        if (c0528q6 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0528q6);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        C0727y6[] c0727y6Arr = this.e;
        int i2 = 0;
        if (c0727y6Arr != null && c0727y6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0727y6[] c0727y6Arr2 = this.e;
                if (i3 >= c0727y6Arr2.length) {
                    break;
                }
                C0727y6 c0727y6 = c0727y6Arr2[i3];
                if (c0727y6 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0727y6);
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
        C0652v6 c0652v6 = this.h;
        if (c0652v6 != null) {
            codedOutputByteBufferNano.writeMessage(8, c0652v6);
        }
        if (!Arrays.equals(this.i, o)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(10, this.j);
        }
        C0577s6[] c0577s6Arr = this.k;
        if (c0577s6Arr != null && c0577s6Arr.length > 0) {
            while (true) {
                C0577s6[] c0577s6Arr2 = this.k;
                if (i2 >= c0577s6Arr2.length) {
                    break;
                }
                C0577s6 c0577s6 = c0577s6Arr2[i2];
                if (c0577s6 != null) {
                    codedOutputByteBufferNano.writeMessage(11, c0577s6);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C0677w6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0677w6().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0677w6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    if (this.f1135a == null) {
                        this.f1135a = new A6();
                    }
                    codedInputByteBufferNano.readMessage(this.f1135a);
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new C0528q6();
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
                    C0727y6[] c0727y6Arr = this.e;
                    int length = c0727y6Arr == null ? 0 : c0727y6Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C0727y6[] c0727y6Arr2 = new C0727y6[i];
                    if (length != 0) {
                        System.arraycopy(c0727y6Arr, 0, c0727y6Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C0727y6 c0727y6 = new C0727y6();
                        c0727y6Arr2[length] = c0727y6;
                        codedInputByteBufferNano.readMessage(c0727y6);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C0727y6 c0727y62 = new C0727y6();
                    c0727y6Arr2[length] = c0727y62;
                    codedInputByteBufferNano.readMessage(c0727y62);
                    this.e = c0727y6Arr2;
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
                        this.h = new C0652v6();
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
                    C0577s6[] c0577s6Arr = this.k;
                    int length2 = c0577s6Arr == null ? 0 : c0577s6Arr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    C0577s6[] c0577s6Arr2 = new C0577s6[i2];
                    if (length2 != 0) {
                        System.arraycopy(c0577s6Arr, 0, c0577s6Arr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        C0577s6 c0577s6 = new C0577s6();
                        c0577s6Arr2[length2] = c0577s6;
                        codedInputByteBufferNano.readMessage(c0577s6);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    C0577s6 c0577s62 = new C0577s6();
                    c0577s6Arr2[length2] = c0577s62;
                    codedInputByteBufferNano.readMessage(c0577s62);
                    this.k = c0577s6Arr2;
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

    public static C0677w6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0677w6) MessageNano.mergeFrom(new C0677w6(), bArr);
    }
}
