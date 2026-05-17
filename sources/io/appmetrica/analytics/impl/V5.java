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
public final class V5 extends MessageNano {
    public static final int k = 0;
    public static final int l = 1;
    public static volatile V5[] m;
    public static byte[] n;
    public static volatile boolean o;

    /* renamed from: a  reason: collision with root package name */
    public C0137b6 f828a;
    public R5 b;
    public String c;
    public int d;
    public Z5[] e;
    public int f;
    public U5 g;
    public byte[] h;
    public byte[] i;
    public T5[] j;

    public V5() {
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

    public static V5[] b() {
        if (m == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (m == null) {
                    m = new V5[0];
                }
            }
        }
        return m;
    }

    public final V5 a() {
        this.f828a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = Z5.b();
        this.f = 0;
        this.g = null;
        this.h = (byte[]) n.clone();
        this.i = WireFormatNano.EMPTY_BYTES;
        this.j = T5.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0137b6 c0137b6 = this.f828a;
        if (c0137b6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0137b6);
        }
        R5 r5 = this.b;
        if (r5 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, r5);
        }
        if (!this.c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        Z5[] z5Arr = this.e;
        int i2 = 0;
        if (z5Arr != null && z5Arr.length > 0) {
            int i3 = 0;
            while (true) {
                Z5[] z5Arr2 = this.e;
                if (i3 >= z5Arr2.length) {
                    break;
                }
                Z5 z5 = z5Arr2[i3];
                if (z5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, z5);
                }
                i3++;
            }
        }
        int i4 = this.f;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i4);
        }
        U5 u5 = this.g;
        if (u5 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, u5);
        }
        if (!Arrays.equals(this.h, n)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.h);
        }
        if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        T5[] t5Arr = this.j;
        if (t5Arr != null && t5Arr.length > 0) {
            while (true) {
                T5[] t5Arr2 = this.j;
                if (i2 >= t5Arr2.length) {
                    break;
                }
                T5 t5 = t5Arr2[i2];
                if (t5 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(10, t5) + computeSerializedSize;
                }
                i2++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0137b6 c0137b6 = this.f828a;
        if (c0137b6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0137b6);
        }
        R5 r5 = this.b;
        if (r5 != null) {
            codedOutputByteBufferNano.writeMessage(2, r5);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        Z5[] z5Arr = this.e;
        int i2 = 0;
        if (z5Arr != null && z5Arr.length > 0) {
            int i3 = 0;
            while (true) {
                Z5[] z5Arr2 = this.e;
                if (i3 >= z5Arr2.length) {
                    break;
                }
                Z5 z5 = z5Arr2[i3];
                if (z5 != null) {
                    codedOutputByteBufferNano.writeMessage(5, z5);
                }
                i3++;
            }
        }
        int i4 = this.f;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i4);
        }
        U5 u5 = this.g;
        if (u5 != null) {
            codedOutputByteBufferNano.writeMessage(7, u5);
        }
        if (!Arrays.equals(this.h, n)) {
            codedOutputByteBufferNano.writeBytes(8, this.h);
        }
        if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        T5[] t5Arr = this.j;
        if (t5Arr != null && t5Arr.length > 0) {
            while (true) {
                T5[] t5Arr2 = this.j;
                if (i2 >= t5Arr2.length) {
                    break;
                }
                T5 t5 = t5Arr2[i2];
                if (t5 != null) {
                    codedOutputByteBufferNano.writeMessage(10, t5);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static V5 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new V5().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final V5 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    if (this.f828a == null) {
                        this.f828a = new C0137b6();
                    }
                    codedInputByteBufferNano.readMessage(this.f828a);
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new R5();
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
                    Z5[] z5Arr = this.e;
                    int length = z5Arr == null ? 0 : z5Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    Z5[] z5Arr2 = new Z5[i];
                    if (length != 0) {
                        System.arraycopy(z5Arr, 0, z5Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        Z5 z5 = new Z5();
                        z5Arr2[length] = z5;
                        codedInputByteBufferNano.readMessage(z5);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    Z5 z52 = new Z5();
                    z5Arr2[length] = z52;
                    codedInputByteBufferNano.readMessage(z52);
                    this.e = z5Arr2;
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
                        this.g = new U5();
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
                    T5[] t5Arr = this.j;
                    int length2 = t5Arr == null ? 0 : t5Arr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    T5[] t5Arr2 = new T5[i2];
                    if (length2 != 0) {
                        System.arraycopy(t5Arr, 0, t5Arr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        T5 t5 = new T5();
                        t5Arr2[length2] = t5;
                        codedInputByteBufferNano.readMessage(t5);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    T5 t52 = new T5();
                    t5Arr2[length2] = t52;
                    codedInputByteBufferNano.readMessage(t52);
                    this.j = t5Arr2;
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

    public static V5 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (V5) MessageNano.mergeFrom(new V5(), bArr);
    }
}
