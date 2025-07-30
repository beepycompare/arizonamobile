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
/* renamed from: io.appmetrica.analytics.impl.r6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0550r6 extends MessageNano {
    public static final int k = 0;
    public static final int l = 1;
    public static volatile C0550r6[] m;
    public static byte[] n;
    public static volatile boolean o;

    /* renamed from: a  reason: collision with root package name */
    public C0700x6 f1033a;
    public C0451n6 b;
    public String c;
    public int d;
    public C0650v6[] e;
    public int f;
    public C0526q6 g;
    public byte[] h;
    public byte[] i;
    public C0501p6[] j;

    public C0550r6() {
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

    public static C0550r6[] b() {
        if (m == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (m == null) {
                    m = new C0550r6[0];
                }
            }
        }
        return m;
    }

    public final C0550r6 a() {
        this.f1033a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = C0650v6.b();
        this.f = 0;
        this.g = null;
        this.h = (byte[]) n.clone();
        this.i = WireFormatNano.EMPTY_BYTES;
        this.j = C0501p6.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0700x6 c0700x6 = this.f1033a;
        if (c0700x6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0700x6);
        }
        C0451n6 c0451n6 = this.b;
        if (c0451n6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0451n6);
        }
        if (!this.c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        C0650v6[] c0650v6Arr = this.e;
        int i2 = 0;
        if (c0650v6Arr != null && c0650v6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0650v6[] c0650v6Arr2 = this.e;
                if (i3 >= c0650v6Arr2.length) {
                    break;
                }
                C0650v6 c0650v6 = c0650v6Arr2[i3];
                if (c0650v6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0650v6);
                }
                i3++;
            }
        }
        int i4 = this.f;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i4);
        }
        C0526q6 c0526q6 = this.g;
        if (c0526q6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, c0526q6);
        }
        if (!Arrays.equals(this.h, n)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.h);
        }
        if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        C0501p6[] c0501p6Arr = this.j;
        if (c0501p6Arr != null && c0501p6Arr.length > 0) {
            while (true) {
                C0501p6[] c0501p6Arr2 = this.j;
                if (i2 >= c0501p6Arr2.length) {
                    break;
                }
                C0501p6 c0501p6 = c0501p6Arr2[i2];
                if (c0501p6 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(10, c0501p6) + computeSerializedSize;
                }
                i2++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0700x6 c0700x6 = this.f1033a;
        if (c0700x6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0700x6);
        }
        C0451n6 c0451n6 = this.b;
        if (c0451n6 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0451n6);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        C0650v6[] c0650v6Arr = this.e;
        int i2 = 0;
        if (c0650v6Arr != null && c0650v6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0650v6[] c0650v6Arr2 = this.e;
                if (i3 >= c0650v6Arr2.length) {
                    break;
                }
                C0650v6 c0650v6 = c0650v6Arr2[i3];
                if (c0650v6 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0650v6);
                }
                i3++;
            }
        }
        int i4 = this.f;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i4);
        }
        C0526q6 c0526q6 = this.g;
        if (c0526q6 != null) {
            codedOutputByteBufferNano.writeMessage(7, c0526q6);
        }
        if (!Arrays.equals(this.h, n)) {
            codedOutputByteBufferNano.writeBytes(8, this.h);
        }
        if (!Arrays.equals(this.i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        C0501p6[] c0501p6Arr = this.j;
        if (c0501p6Arr != null && c0501p6Arr.length > 0) {
            while (true) {
                C0501p6[] c0501p6Arr2 = this.j;
                if (i2 >= c0501p6Arr2.length) {
                    break;
                }
                C0501p6 c0501p6 = c0501p6Arr2[i2];
                if (c0501p6 != null) {
                    codedOutputByteBufferNano.writeMessage(10, c0501p6);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C0550r6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0550r6().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0550r6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    if (this.f1033a == null) {
                        this.f1033a = new C0700x6();
                    }
                    codedInputByteBufferNano.readMessage(this.f1033a);
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new C0451n6();
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
                    C0650v6[] c0650v6Arr = this.e;
                    int length = c0650v6Arr == null ? 0 : c0650v6Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C0650v6[] c0650v6Arr2 = new C0650v6[i];
                    if (length != 0) {
                        System.arraycopy(c0650v6Arr, 0, c0650v6Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C0650v6 c0650v6 = new C0650v6();
                        c0650v6Arr2[length] = c0650v6;
                        codedInputByteBufferNano.readMessage(c0650v6);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C0650v6 c0650v62 = new C0650v6();
                    c0650v6Arr2[length] = c0650v62;
                    codedInputByteBufferNano.readMessage(c0650v62);
                    this.e = c0650v6Arr2;
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
                        this.g = new C0526q6();
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
                    C0501p6[] c0501p6Arr = this.j;
                    int length2 = c0501p6Arr == null ? 0 : c0501p6Arr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    C0501p6[] c0501p6Arr2 = new C0501p6[i2];
                    if (length2 != 0) {
                        System.arraycopy(c0501p6Arr, 0, c0501p6Arr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        C0501p6 c0501p6 = new C0501p6();
                        c0501p6Arr2[length2] = c0501p6;
                        codedInputByteBufferNano.readMessage(c0501p6);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    C0501p6 c0501p62 = new C0501p6();
                    c0501p6Arr2[length2] = c0501p62;
                    codedInputByteBufferNano.readMessage(c0501p62);
                    this.j = c0501p6Arr2;
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

    public static C0550r6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0550r6) MessageNano.mergeFrom(new C0550r6(), bArr);
    }
}
