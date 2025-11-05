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
/* renamed from: io.appmetrica.analytics.impl.e6  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0211e6 extends MessageNano {
    public static final int l = 0;
    public static final int m = 1;
    public static volatile C0211e6[] n;
    public static byte[] o;
    public static volatile boolean p;

    /* renamed from: a  reason: collision with root package name */
    public C0315i6 f858a;
    public Y5 b;
    public String c;
    public int d;
    public C0263g6[] e;
    public String f;
    public int g;
    public C0186d6 h;
    public byte[] i;
    public byte[] j;
    public C0108a6[] k;

    public C0211e6() {
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

    public static C0211e6[] b() {
        if (n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (n == null) {
                    n = new C0211e6[0];
                }
            }
        }
        return n;
    }

    public final C0211e6 a() {
        this.f858a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = C0263g6.b();
        this.f = "";
        this.g = 0;
        this.h = null;
        this.i = (byte[]) o.clone();
        this.j = WireFormatNano.EMPTY_BYTES;
        this.k = C0108a6.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0315i6 c0315i6 = this.f858a;
        if (c0315i6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0315i6);
        }
        Y5 y5 = this.b;
        if (y5 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, y5);
        }
        if (!this.c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        C0263g6[] c0263g6Arr = this.e;
        int i2 = 0;
        if (c0263g6Arr != null && c0263g6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0263g6[] c0263g6Arr2 = this.e;
                if (i3 >= c0263g6Arr2.length) {
                    break;
                }
                C0263g6 c0263g6 = c0263g6Arr2[i3];
                if (c0263g6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0263g6);
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
        C0186d6 c0186d6 = this.h;
        if (c0186d6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, c0186d6);
        }
        if (!Arrays.equals(this.i, o)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.j);
        }
        C0108a6[] c0108a6Arr = this.k;
        if (c0108a6Arr != null && c0108a6Arr.length > 0) {
            while (true) {
                C0108a6[] c0108a6Arr2 = this.k;
                if (i2 >= c0108a6Arr2.length) {
                    break;
                }
                C0108a6 c0108a6 = c0108a6Arr2[i2];
                if (c0108a6 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(11, c0108a6) + computeSerializedSize;
                }
                i2++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0315i6 c0315i6 = this.f858a;
        if (c0315i6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0315i6);
        }
        Y5 y5 = this.b;
        if (y5 != null) {
            codedOutputByteBufferNano.writeMessage(2, y5);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        C0263g6[] c0263g6Arr = this.e;
        int i2 = 0;
        if (c0263g6Arr != null && c0263g6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0263g6[] c0263g6Arr2 = this.e;
                if (i3 >= c0263g6Arr2.length) {
                    break;
                }
                C0263g6 c0263g6 = c0263g6Arr2[i3];
                if (c0263g6 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0263g6);
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
        C0186d6 c0186d6 = this.h;
        if (c0186d6 != null) {
            codedOutputByteBufferNano.writeMessage(8, c0186d6);
        }
        if (!Arrays.equals(this.i, o)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(10, this.j);
        }
        C0108a6[] c0108a6Arr = this.k;
        if (c0108a6Arr != null && c0108a6Arr.length > 0) {
            while (true) {
                C0108a6[] c0108a6Arr2 = this.k;
                if (i2 >= c0108a6Arr2.length) {
                    break;
                }
                C0108a6 c0108a6 = c0108a6Arr2[i2];
                if (c0108a6 != null) {
                    codedOutputByteBufferNano.writeMessage(11, c0108a6);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C0211e6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0211e6().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0211e6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    if (this.f858a == null) {
                        this.f858a = new C0315i6();
                    }
                    codedInputByteBufferNano.readMessage(this.f858a);
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new Y5();
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
                    C0263g6[] c0263g6Arr = this.e;
                    int length = c0263g6Arr == null ? 0 : c0263g6Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C0263g6[] c0263g6Arr2 = new C0263g6[i];
                    if (length != 0) {
                        System.arraycopy(c0263g6Arr, 0, c0263g6Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C0263g6 c0263g6 = new C0263g6();
                        c0263g6Arr2[length] = c0263g6;
                        codedInputByteBufferNano.readMessage(c0263g6);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C0263g6 c0263g62 = new C0263g6();
                    c0263g6Arr2[length] = c0263g62;
                    codedInputByteBufferNano.readMessage(c0263g62);
                    this.e = c0263g6Arr2;
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
                        this.h = new C0186d6();
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
                    C0108a6[] c0108a6Arr = this.k;
                    int length2 = c0108a6Arr == null ? 0 : c0108a6Arr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    C0108a6[] c0108a6Arr2 = new C0108a6[i2];
                    if (length2 != 0) {
                        System.arraycopy(c0108a6Arr, 0, c0108a6Arr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        C0108a6 c0108a6 = new C0108a6();
                        c0108a6Arr2[length2] = c0108a6;
                        codedInputByteBufferNano.readMessage(c0108a6);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    C0108a6 c0108a62 = new C0108a6();
                    c0108a6Arr2[length2] = c0108a62;
                    codedInputByteBufferNano.readMessage(c0108a62);
                    this.k = c0108a6Arr2;
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

    public static C0211e6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0211e6) MessageNano.mergeFrom(new C0211e6(), bArr);
    }
}
