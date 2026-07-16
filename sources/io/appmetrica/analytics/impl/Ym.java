package io.appmetrica.analytics.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Ym extends MessageNano {
    public static final int D = -1;
    public static final int E = 0;
    public static final int F = 1;
    public static volatile Ym[] G;
    public Wm A;
    public Um[] B;
    public Sm C;

    /* renamed from: a  reason: collision with root package name */
    public String f864a;
    public long b;
    public String[] c;
    public String d;
    public String e;
    public String[] f;
    public String[] g;
    public Rm[] h;
    public Tm i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String[] o;
    public Xm p;
    public boolean q;
    public String r;
    public long s;
    public long t;
    public boolean u;
    public Vm v;
    public int w;
    public int x;
    public Qm y;
    public Pm z;

    public Ym() {
        a();
    }

    public static Ym[] b() {
        if (G == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (G == null) {
                    G = new Ym[0];
                }
            }
        }
        return G;
    }

    public final Ym a() {
        this.f864a = "";
        this.b = 0L;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.c = strArr;
        this.d = "";
        this.e = "";
        this.f = strArr;
        this.g = strArr;
        this.h = Rm.b();
        this.i = null;
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = false;
        this.n = "";
        this.o = strArr;
        this.p = null;
        this.q = false;
        this.r = "";
        this.s = 0L;
        this.t = 0L;
        this.u = false;
        this.v = null;
        this.w = 600;
        this.x = 1;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = Um.b();
        this.C = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f864a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f864a);
        }
        int computeInt64Size = CodedOutputByteBufferNano.computeInt64Size(2, this.b) + computeSerializedSize;
        String[] strArr = this.c;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i4++;
                    i3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i2++;
            }
            computeInt64Size = computeInt64Size + i3 + i4;
        }
        if (!this.d.equals("")) {
            computeInt64Size += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        if (!this.e.equals("")) {
            computeInt64Size += CodedOutputByteBufferNano.computeStringSize(5, this.e);
        }
        String[] strArr3 = this.f;
        if (strArr3 != null && strArr3.length > 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                String[] strArr4 = this.f;
                if (i5 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i5];
                if (str2 != null) {
                    i7++;
                    i6 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i5++;
            }
            computeInt64Size = computeInt64Size + i6 + i7;
        }
        String[] strArr5 = this.g;
        if (strArr5 != null && strArr5.length > 0) {
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                String[] strArr6 = this.g;
                if (i8 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i8];
                if (str3 != null) {
                    i10++;
                    i9 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                }
                i8++;
            }
            computeInt64Size = computeInt64Size + i9 + i10;
        }
        Rm[] rmArr = this.h;
        if (rmArr != null && rmArr.length > 0) {
            int i11 = 0;
            while (true) {
                Rm[] rmArr2 = this.h;
                if (i11 >= rmArr2.length) {
                    break;
                }
                Rm rm = rmArr2[i11];
                if (rm != null) {
                    computeInt64Size += CodedOutputByteBufferNano.computeMessageSize(8, rm);
                }
                i11++;
            }
        }
        Tm tm = this.i;
        if (tm != null) {
            computeInt64Size += CodedOutputByteBufferNano.computeMessageSize(9, tm);
        }
        if (!this.j.equals("")) {
            computeInt64Size += CodedOutputByteBufferNano.computeStringSize(10, this.j);
        }
        if (!this.k.equals("")) {
            computeInt64Size += CodedOutputByteBufferNano.computeStringSize(11, this.k);
        }
        if (!this.l.equals("")) {
            computeInt64Size += CodedOutputByteBufferNano.computeStringSize(12, this.l);
        }
        int computeBoolSize = CodedOutputByteBufferNano.computeBoolSize(13, this.m) + computeInt64Size;
        if (!this.n.equals("")) {
            computeBoolSize += CodedOutputByteBufferNano.computeStringSize(14, this.n);
        }
        String[] strArr7 = this.o;
        if (strArr7 != null && strArr7.length > 0) {
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                String[] strArr8 = this.o;
                if (i12 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i12];
                if (str4 != null) {
                    i14++;
                    i13 += CodedOutputByteBufferNano.computeStringSizeNoTag(str4);
                }
                i12++;
            }
            computeBoolSize = computeBoolSize + i13 + i14;
        }
        Xm xm = this.p;
        if (xm != null) {
            computeBoolSize += CodedOutputByteBufferNano.computeMessageSize(16, xm);
        }
        boolean z = this.q;
        if (z) {
            computeBoolSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
        }
        if (!this.r.equals("")) {
            computeBoolSize += CodedOutputByteBufferNano.computeStringSize(20, this.r);
        }
        int computeInt64Size2 = CodedOutputByteBufferNano.computeInt64Size(22, this.t) + CodedOutputByteBufferNano.computeInt64Size(21, this.s) + computeBoolSize;
        boolean z2 = this.u;
        if (z2) {
            computeInt64Size2 += CodedOutputByteBufferNano.computeBoolSize(23, z2);
        }
        Vm vm = this.v;
        if (vm != null) {
            computeInt64Size2 += CodedOutputByteBufferNano.computeMessageSize(24, vm);
        }
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(26, this.x) + CodedOutputByteBufferNano.computeInt32Size(25, this.w) + computeInt64Size2;
        Qm qm = this.y;
        if (qm != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(27, qm);
        }
        Pm pm = this.z;
        if (pm != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(29, pm);
        }
        Wm wm = this.A;
        if (wm != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(30, wm);
        }
        Um[] umArr = this.B;
        if (umArr != null && umArr.length > 0) {
            while (true) {
                Um[] umArr2 = this.B;
                if (i >= umArr2.length) {
                    break;
                }
                Um um = umArr2[i];
                if (um != null) {
                    computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(31, um);
                }
                i++;
            }
        }
        Sm sm = this.C;
        return sm != null ? CodedOutputByteBufferNano.computeMessageSize(32, sm) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f864a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f864a);
        }
        codedOutputByteBufferNano.writeInt64(2, this.b);
        String[] strArr = this.c;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i2++;
            }
        }
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.e);
        }
        String[] strArr3 = this.f;
        if (strArr3 != null && strArr3.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr4 = this.f;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(6, str2);
                }
                i3++;
            }
        }
        String[] strArr5 = this.g;
        if (strArr5 != null && strArr5.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr6 = this.g;
                if (i4 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i4];
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(7, str3);
                }
                i4++;
            }
        }
        Rm[] rmArr = this.h;
        if (rmArr != null && rmArr.length > 0) {
            int i5 = 0;
            while (true) {
                Rm[] rmArr2 = this.h;
                if (i5 >= rmArr2.length) {
                    break;
                }
                Rm rm = rmArr2[i5];
                if (rm != null) {
                    codedOutputByteBufferNano.writeMessage(8, rm);
                }
                i5++;
            }
        }
        Tm tm = this.i;
        if (tm != null) {
            codedOutputByteBufferNano.writeMessage(9, tm);
        }
        if (!this.j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.j);
        }
        if (!this.k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.k);
        }
        if (!this.l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.l);
        }
        codedOutputByteBufferNano.writeBool(13, this.m);
        if (!this.n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.n);
        }
        String[] strArr7 = this.o;
        if (strArr7 != null && strArr7.length > 0) {
            int i6 = 0;
            while (true) {
                String[] strArr8 = this.o;
                if (i6 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i6];
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(15, str4);
                }
                i6++;
            }
        }
        Xm xm = this.p;
        if (xm != null) {
            codedOutputByteBufferNano.writeMessage(16, xm);
        }
        boolean z = this.q;
        if (z) {
            codedOutputByteBufferNano.writeBool(17, z);
        }
        if (!this.r.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.r);
        }
        codedOutputByteBufferNano.writeInt64(21, this.s);
        codedOutputByteBufferNano.writeInt64(22, this.t);
        boolean z2 = this.u;
        if (z2) {
            codedOutputByteBufferNano.writeBool(23, z2);
        }
        Vm vm = this.v;
        if (vm != null) {
            codedOutputByteBufferNano.writeMessage(24, vm);
        }
        codedOutputByteBufferNano.writeInt32(25, this.w);
        codedOutputByteBufferNano.writeInt32(26, this.x);
        Qm qm = this.y;
        if (qm != null) {
            codedOutputByteBufferNano.writeMessage(27, qm);
        }
        Pm pm = this.z;
        if (pm != null) {
            codedOutputByteBufferNano.writeMessage(29, pm);
        }
        Wm wm = this.A;
        if (wm != null) {
            codedOutputByteBufferNano.writeMessage(30, wm);
        }
        Um[] umArr = this.B;
        if (umArr != null && umArr.length > 0) {
            while (true) {
                Um[] umArr2 = this.B;
                if (i >= umArr2.length) {
                    break;
                }
                Um um = umArr2[i];
                if (um != null) {
                    codedOutputByteBufferNano.writeMessage(31, um);
                }
                i++;
            }
        }
        Sm sm = this.C;
        if (sm != null) {
            codedOutputByteBufferNano.writeMessage(32, sm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Ym b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Ym().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Ym mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    this.f864a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.b = codedInputByteBufferNano.readInt64();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    String[] strArr = this.c;
                    int length = strArr == null ? 0 : strArr.length;
                    int i = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.c = strArr2;
                    break;
                case 34:
                    this.d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    String[] strArr3 = this.f;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    String[] strArr4 = new String[i2];
                    if (length2 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.f = strArr4;
                    break;
                case 58:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    String[] strArr5 = this.g;
                    int length3 = strArr5 == null ? 0 : strArr5.length;
                    int i3 = repeatedFieldArrayLength3 + length3;
                    String[] strArr6 = new String[i3];
                    if (length3 != 0) {
                        System.arraycopy(strArr5, 0, strArr6, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        strArr6[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr6[length3] = codedInputByteBufferNano.readString();
                    this.g = strArr6;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    Rm[] rmArr = this.h;
                    int length4 = rmArr == null ? 0 : rmArr.length;
                    int i4 = repeatedFieldArrayLength4 + length4;
                    Rm[] rmArr2 = new Rm[i4];
                    if (length4 != 0) {
                        System.arraycopy(rmArr, 0, rmArr2, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        Rm rm = new Rm();
                        rmArr2[length4] = rm;
                        codedInputByteBufferNano.readMessage(rm);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    Rm rm2 = new Rm();
                    rmArr2[length4] = rm2;
                    codedInputByteBufferNano.readMessage(rm2);
                    this.h = rmArr2;
                    break;
                case 74:
                    if (this.i == null) {
                        this.i = new Tm();
                    }
                    codedInputByteBufferNano.readMessage(this.i);
                    break;
                case 82:
                    this.j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.l = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.m = codedInputByteBufferNano.readBool();
                    break;
                case 114:
                    this.n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    String[] strArr7 = this.o;
                    int length5 = strArr7 == null ? 0 : strArr7.length;
                    int i5 = repeatedFieldArrayLength5 + length5;
                    String[] strArr8 = new String[i5];
                    if (length5 != 0) {
                        System.arraycopy(strArr7, 0, strArr8, 0, length5);
                    }
                    while (length5 < i5 - 1) {
                        strArr8[length5] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    strArr8[length5] = codedInputByteBufferNano.readString();
                    this.o = strArr8;
                    break;
                case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                    if (this.p == null) {
                        this.p = new Xm();
                    }
                    codedInputByteBufferNano.readMessage(this.p);
                    break;
                case TsExtractor.TS_STREAM_TYPE_DTS_HD /* 136 */:
                    this.q = codedInputByteBufferNano.readBool();
                    break;
                case 162:
                    this.r = codedInputByteBufferNano.readString();
                    break;
                case 168:
                    this.s = codedInputByteBufferNano.readInt64();
                    break;
                case 176:
                    this.t = codedInputByteBufferNano.readInt64();
                    break;
                case 184:
                    this.u = codedInputByteBufferNano.readBool();
                    break;
                case DownloaderService.STATUS_WAITING_TO_RETRY /* 194 */:
                    if (this.v == null) {
                        this.v = new Vm();
                    }
                    codedInputByteBufferNano.readMessage(this.v);
                    break;
                case 200:
                    this.w = codedInputByteBufferNano.readInt32();
                    break;
                case 208:
                    this.x = codedInputByteBufferNano.readInt32();
                    break;
                case 218:
                    if (this.y == null) {
                        this.y = new Qm();
                    }
                    codedInputByteBufferNano.readMessage(this.y);
                    break;
                case 234:
                    if (this.z == null) {
                        this.z = new Pm();
                    }
                    codedInputByteBufferNano.readMessage(this.z);
                    break;
                case 242:
                    if (this.A == null) {
                        this.A = new Wm();
                    }
                    codedInputByteBufferNano.readMessage(this.A);
                    break;
                case 250:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 250);
                    Um[] umArr = this.B;
                    int length6 = umArr == null ? 0 : umArr.length;
                    int i6 = repeatedFieldArrayLength6 + length6;
                    Um[] umArr2 = new Um[i6];
                    if (length6 != 0) {
                        System.arraycopy(umArr, 0, umArr2, 0, length6);
                    }
                    while (length6 < i6 - 1) {
                        Um um = new Um();
                        umArr2[length6] = um;
                        codedInputByteBufferNano.readMessage(um);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    Um um2 = new Um();
                    umArr2[length6] = um2;
                    codedInputByteBufferNano.readMessage(um2);
                    this.B = umArr2;
                    break;
                case 258:
                    if (this.C == null) {
                        this.C = new Sm();
                    }
                    codedInputByteBufferNano.readMessage(this.C);
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

    public static Ym a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Ym) MessageNano.mergeFrom(new Ym(), bArr);
    }
}
