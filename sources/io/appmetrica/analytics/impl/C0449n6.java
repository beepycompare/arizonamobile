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
/* renamed from: io.appmetrica.analytics.impl.n6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0449n6 extends MessageNano {
    public static final int l = 0;
    public static final int m = 1;
    public static volatile C0449n6[] n;
    public static byte[] o;
    public static volatile boolean p;

    /* renamed from: a  reason: collision with root package name */
    public C0552r6 f1109a;
    public C0294h6 b;
    public String c;
    public int d;
    public C0501p6[] e;
    public String f;
    public int g;
    public C0423m6 h;
    public byte[] i;
    public byte[] j;
    public C0345j6[] k;

    public C0449n6() {
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

    public static C0449n6[] b() {
        if (n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (n == null) {
                    n = new C0449n6[0];
                }
            }
        }
        return n;
    }

    public final C0449n6 a() {
        this.f1109a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = C0501p6.b();
        this.f = "";
        this.g = 0;
        this.h = null;
        this.i = (byte[]) o.clone();
        this.j = WireFormatNano.EMPTY_BYTES;
        this.k = C0345j6.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0552r6 c0552r6 = this.f1109a;
        if (c0552r6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0552r6);
        }
        C0294h6 c0294h6 = this.b;
        if (c0294h6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0294h6);
        }
        if (!this.c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        C0501p6[] c0501p6Arr = this.e;
        int i2 = 0;
        if (c0501p6Arr != null && c0501p6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0501p6[] c0501p6Arr2 = this.e;
                if (i3 >= c0501p6Arr2.length) {
                    break;
                }
                C0501p6 c0501p6 = c0501p6Arr2[i3];
                if (c0501p6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0501p6);
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
        C0423m6 c0423m6 = this.h;
        if (c0423m6 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, c0423m6);
        }
        if (!Arrays.equals(this.i, o)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.j);
        }
        C0345j6[] c0345j6Arr = this.k;
        if (c0345j6Arr != null && c0345j6Arr.length > 0) {
            while (true) {
                C0345j6[] c0345j6Arr2 = this.k;
                if (i2 >= c0345j6Arr2.length) {
                    break;
                }
                C0345j6 c0345j6 = c0345j6Arr2[i2];
                if (c0345j6 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(11, c0345j6) + computeSerializedSize;
                }
                i2++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0552r6 c0552r6 = this.f1109a;
        if (c0552r6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0552r6);
        }
        C0294h6 c0294h6 = this.b;
        if (c0294h6 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0294h6);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        C0501p6[] c0501p6Arr = this.e;
        int i2 = 0;
        if (c0501p6Arr != null && c0501p6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C0501p6[] c0501p6Arr2 = this.e;
                if (i3 >= c0501p6Arr2.length) {
                    break;
                }
                C0501p6 c0501p6 = c0501p6Arr2[i3];
                if (c0501p6 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c0501p6);
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
        C0423m6 c0423m6 = this.h;
        if (c0423m6 != null) {
            codedOutputByteBufferNano.writeMessage(8, c0423m6);
        }
        if (!Arrays.equals(this.i, o)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(10, this.j);
        }
        C0345j6[] c0345j6Arr = this.k;
        if (c0345j6Arr != null && c0345j6Arr.length > 0) {
            while (true) {
                C0345j6[] c0345j6Arr2 = this.k;
                if (i2 >= c0345j6Arr2.length) {
                    break;
                }
                C0345j6 c0345j6 = c0345j6Arr2[i2];
                if (c0345j6 != null) {
                    codedOutputByteBufferNano.writeMessage(11, c0345j6);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C0449n6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0449n6().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0449n6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    if (this.f1109a == null) {
                        this.f1109a = new C0552r6();
                    }
                    codedInputByteBufferNano.readMessage(this.f1109a);
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new C0294h6();
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
                    C0501p6[] c0501p6Arr = this.e;
                    int length = c0501p6Arr == null ? 0 : c0501p6Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C0501p6[] c0501p6Arr2 = new C0501p6[i];
                    if (length != 0) {
                        System.arraycopy(c0501p6Arr, 0, c0501p6Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C0501p6 c0501p6 = new C0501p6();
                        c0501p6Arr2[length] = c0501p6;
                        codedInputByteBufferNano.readMessage(c0501p6);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C0501p6 c0501p62 = new C0501p6();
                    c0501p6Arr2[length] = c0501p62;
                    codedInputByteBufferNano.readMessage(c0501p62);
                    this.e = c0501p6Arr2;
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
                        this.h = new C0423m6();
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
                    C0345j6[] c0345j6Arr = this.k;
                    int length2 = c0345j6Arr == null ? 0 : c0345j6Arr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    C0345j6[] c0345j6Arr2 = new C0345j6[i2];
                    if (length2 != 0) {
                        System.arraycopy(c0345j6Arr, 0, c0345j6Arr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        C0345j6 c0345j6 = new C0345j6();
                        c0345j6Arr2[length2] = c0345j6;
                        codedInputByteBufferNano.readMessage(c0345j6);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    C0345j6 c0345j62 = new C0345j6();
                    c0345j6Arr2[length2] = c0345j62;
                    codedInputByteBufferNano.readMessage(c0345j62);
                    this.k = c0345j6Arr2;
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

    public static C0449n6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0449n6) MessageNano.mergeFrom(new C0449n6(), bArr);
    }
}
