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
/* renamed from: io.appmetrica.analytics.impl.q6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0524q6 extends MessageNano {
    public static final int l = 0;
    public static final int m = 1;
    public static volatile C0524q6[] n;
    public static byte[] o;
    public static volatile boolean p;

    /* renamed from: a  reason: collision with root package name */
    public C0623u6 f1002a;
    public C0374k6 b;
    public String c;
    public int d;
    public C0573s6[] e;
    public String f;
    public int g;
    public C0499p6 h;
    public byte[] i;
    public byte[] j;
    public C0424m6[] k;

    public C0524q6() {
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

    public static C0524q6[] b() {
        if (n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (n == null) {
                    n = new C0524q6[0];
                }
            }
        }
        return n;
    }

    public final C0524q6 a() {
        this.f1002a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = C0573s6.b();
        this.f = "";
        this.g = 0;
        this.h = null;
        this.i = (byte[]) o.clone();
        this.j = WireFormatNano.EMPTY_BYTES;
        this.k = C0424m6.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0623u6 c0623u6 = this.f1002a;
        if (c0623u6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0623u6);
        }
        C0374k6 c0374k6 = this.b;
        if (c0374k6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0374k6);
        }
        if (!this.c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        C0573s6[] c0573s6Arr = this.e;
        int i2 = 0;
        if (c0573s6Arr != null && c0573s6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0573s6[] c0573s6Arr2 = this.e;
                if (i3 >= c0573s6Arr2.length) {
                    break;
                }
                C0573s6 c0573s6 = c0573s6Arr2[i3];
                if (c0573s6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0573s6);
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
        C0499p6 c0499p6 = this.h;
        if (c0499p6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, c0499p6);
        }
        if (!Arrays.equals(this.i, o)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.j);
        }
        C0424m6[] c0424m6Arr = this.k;
        if (c0424m6Arr != null && c0424m6Arr.length > 0) {
            while (true) {
                C0424m6[] c0424m6Arr2 = this.k;
                if (i2 >= c0424m6Arr2.length) {
                    break;
                }
                C0424m6 c0424m6 = c0424m6Arr2[i2];
                if (c0424m6 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(11, c0424m6) + computeSerializedSize;
                }
                i2++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0623u6 c0623u6 = this.f1002a;
        if (c0623u6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0623u6);
        }
        C0374k6 c0374k6 = this.b;
        if (c0374k6 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0374k6);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        C0573s6[] c0573s6Arr = this.e;
        int i2 = 0;
        if (c0573s6Arr != null && c0573s6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0573s6[] c0573s6Arr2 = this.e;
                if (i3 >= c0573s6Arr2.length) {
                    break;
                }
                C0573s6 c0573s6 = c0573s6Arr2[i3];
                if (c0573s6 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0573s6);
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
        C0499p6 c0499p6 = this.h;
        if (c0499p6 != null) {
            codedOutputByteBufferNano.writeMessage(8, c0499p6);
        }
        if (!Arrays.equals(this.i, o)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(10, this.j);
        }
        C0424m6[] c0424m6Arr = this.k;
        if (c0424m6Arr != null && c0424m6Arr.length > 0) {
            while (true) {
                C0424m6[] c0424m6Arr2 = this.k;
                if (i2 >= c0424m6Arr2.length) {
                    break;
                }
                C0424m6 c0424m6 = c0424m6Arr2[i2];
                if (c0424m6 != null) {
                    codedOutputByteBufferNano.writeMessage(11, c0424m6);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C0524q6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0524q6().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0524q6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    if (this.f1002a == null) {
                        this.f1002a = new C0623u6();
                    }
                    codedInputByteBufferNano.readMessage(this.f1002a);
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new C0374k6();
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
                    C0573s6[] c0573s6Arr = this.e;
                    int length = c0573s6Arr == null ? 0 : c0573s6Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C0573s6[] c0573s6Arr2 = new C0573s6[i];
                    if (length != 0) {
                        System.arraycopy(c0573s6Arr, 0, c0573s6Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C0573s6 c0573s6 = new C0573s6();
                        c0573s6Arr2[length] = c0573s6;
                        codedInputByteBufferNano.readMessage(c0573s6);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C0573s6 c0573s62 = new C0573s6();
                    c0573s6Arr2[length] = c0573s62;
                    codedInputByteBufferNano.readMessage(c0573s62);
                    this.e = c0573s6Arr2;
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
                        this.h = new C0499p6();
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
                    C0424m6[] c0424m6Arr = this.k;
                    int length2 = c0424m6Arr == null ? 0 : c0424m6Arr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    C0424m6[] c0424m6Arr2 = new C0424m6[i2];
                    if (length2 != 0) {
                        System.arraycopy(c0424m6Arr, 0, c0424m6Arr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        C0424m6 c0424m6 = new C0424m6();
                        c0424m6Arr2[length2] = c0424m6;
                        codedInputByteBufferNano.readMessage(c0424m6);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    C0424m6 c0424m62 = new C0424m6();
                    c0424m6Arr2[length2] = c0424m62;
                    codedInputByteBufferNano.readMessage(c0424m62);
                    this.k = c0424m6Arr2;
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

    public static C0524q6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0524q6) MessageNano.mergeFrom(new C0524q6(), bArr);
    }
}
