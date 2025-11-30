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
public final class W5 extends MessageNano {
    public static final int k = 0;
    public static final int l = 1;
    public static volatile W5[] m;
    public static byte[] n;
    public static volatile boolean o;

    /* renamed from: a  reason: collision with root package name */
    public C0160c6 f735a;
    public S5 b;
    public String c;
    public int d;
    public C0108a6[] e;
    public int f;
    public V5 g;
    public byte[] h;
    public byte[] i;
    public U5[] j;

    public W5() {
        if (!o) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (!o) {
                    n = InternalNano.bytesDefaultValue("JVM");
                    o = true;
                }
            }
        }
        a();
    }

    public static W5[] b() {
        if (m == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (m == null) {
                    m = new W5[0];
                }
            }
        }
        return m;
    }

    public final W5 a() {
        this.f735a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = C0108a6.b();
        this.f = 0;
        this.g = null;
        this.h = (byte[]) n.clone();
        this.i = WireFormatNano.EMPTY_BYTES;
        this.j = U5.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0160c6 c0160c6 = this.f735a;
        if (c0160c6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0160c6);
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
        C0108a6[] c0108a6Arr = this.e;
        int i2 = 0;
        if (c0108a6Arr != null && c0108a6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0108a6[] c0108a6Arr2 = this.e;
                if (i3 >= c0108a6Arr2.length) {
                    break;
                }
                C0108a6 c0108a6 = c0108a6Arr2[i3];
                if (c0108a6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0108a6);
                }
                i3++;
            }
        }
        int i4 = this.f;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i4);
        }
        V5 v5 = this.g;
        if (v5 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, v5);
        }
        if (!Arrays.equals(this.h, n)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.h);
        }
        if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        U5[] u5Arr = this.j;
        if (u5Arr != null && u5Arr.length > 0) {
            while (true) {
                U5[] u5Arr2 = this.j;
                if (i2 >= u5Arr2.length) {
                    break;
                }
                U5 u5 = u5Arr2[i2];
                if (u5 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(10, u5) + computeSerializedSize;
                }
                i2++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0160c6 c0160c6 = this.f735a;
        if (c0160c6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0160c6);
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
        C0108a6[] c0108a6Arr = this.e;
        int i2 = 0;
        if (c0108a6Arr != null && c0108a6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0108a6[] c0108a6Arr2 = this.e;
                if (i3 >= c0108a6Arr2.length) {
                    break;
                }
                C0108a6 c0108a6 = c0108a6Arr2[i3];
                if (c0108a6 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0108a6);
                }
                i3++;
            }
        }
        int i4 = this.f;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i4);
        }
        V5 v5 = this.g;
        if (v5 != null) {
            codedOutputByteBufferNano.writeMessage(7, v5);
        }
        if (!Arrays.equals(this.h, n)) {
            codedOutputByteBufferNano.writeBytes(8, this.h);
        }
        if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        U5[] u5Arr = this.j;
        if (u5Arr != null && u5Arr.length > 0) {
            while (true) {
                U5[] u5Arr2 = this.j;
                if (i2 >= u5Arr2.length) {
                    break;
                }
                U5 u5 = u5Arr2[i2];
                if (u5 != null) {
                    codedOutputByteBufferNano.writeMessage(10, u5);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static W5 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new W5().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final W5 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    if (this.f735a == null) {
                        this.f735a = new C0160c6();
                    }
                    codedInputByteBufferNano.readMessage(this.f735a);
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
                    C0108a6[] c0108a6Arr = this.e;
                    int length = c0108a6Arr == null ? 0 : c0108a6Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C0108a6[] c0108a6Arr2 = new C0108a6[i];
                    if (length != 0) {
                        System.arraycopy(c0108a6Arr, 0, c0108a6Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C0108a6 c0108a6 = new C0108a6();
                        c0108a6Arr2[length] = c0108a6;
                        codedInputByteBufferNano.readMessage(c0108a6);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C0108a6 c0108a62 = new C0108a6();
                    c0108a6Arr2[length] = c0108a62;
                    codedInputByteBufferNano.readMessage(c0108a62);
                    this.e = c0108a6Arr2;
                    break;
                case 48:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1) {
                        break;
                    } else {
                        this.f = readInt322;
                        break;
                    }
                case 58:
                    if (this.g == null) {
                        this.g = new V5();
                    }
                    codedInputByteBufferNano.readMessage(this.g);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    this.h = codedInputByteBufferNano.readBytes();
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readBytes();
                    break;
                case 82:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    U5[] u5Arr = this.j;
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
                    this.j = u5Arr2;
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

    public static W5 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (W5) MessageNano.mergeFrom(new W5(), bArr);
    }
}
