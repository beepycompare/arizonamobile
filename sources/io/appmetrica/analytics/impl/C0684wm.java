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
/* renamed from: io.appmetrica.analytics.impl.wm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0684wm extends MessageNano {
    public static final int D = -1;
    public static final int E = 0;
    public static final int F = 1;
    public static volatile C0684wm[] G;
    public C0634um A;
    public C0584sm[] B;
    public C0535qm C;

    /* renamed from: a  reason: collision with root package name */
    public String f1296a;
    public long b;
    public String[] c;
    public String d;
    public String e;
    public String[] f;
    public String[] g;
    public C0510pm[] h;
    public C0559rm i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String[] o;
    public C0659vm p;
    public boolean q;
    public String r;
    public long s;
    public long t;
    public boolean u;
    public C0609tm v;
    public int w;
    public int x;
    public C0485om y;
    public C0460nm z;

    public C0684wm() {
        a();
    }

    public static C0684wm[] b() {
        if (G == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (G == null) {
                    G = new C0684wm[0];
                }
            }
        }
        return G;
    }

    public final C0684wm a() {
        this.f1296a = "";
        this.b = 0L;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.c = strArr;
        this.d = "";
        this.e = "";
        this.f = strArr;
        this.g = strArr;
        this.h = C0510pm.b();
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
        this.B = C0584sm.b();
        this.C = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1296a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1296a);
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
        C0510pm[] c0510pmArr = this.h;
        if (c0510pmArr != null && c0510pmArr.length > 0) {
            int i11 = 0;
            while (true) {
                C0510pm[] c0510pmArr2 = this.h;
                if (i11 >= c0510pmArr2.length) {
                    break;
                }
                C0510pm c0510pm = c0510pmArr2[i11];
                if (c0510pm != null) {
                    computeInt64Size += CodedOutputByteBufferNano.computeMessageSize(8, c0510pm);
                }
                i11++;
            }
        }
        C0559rm c0559rm = this.i;
        if (c0559rm != null) {
            computeInt64Size += CodedOutputByteBufferNano.computeMessageSize(9, c0559rm);
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
        C0659vm c0659vm = this.p;
        if (c0659vm != null) {
            computeBoolSize += CodedOutputByteBufferNano.computeMessageSize(16, c0659vm);
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
        C0609tm c0609tm = this.v;
        if (c0609tm != null) {
            computeInt64Size2 += CodedOutputByteBufferNano.computeMessageSize(24, c0609tm);
        }
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(26, this.x) + CodedOutputByteBufferNano.computeInt32Size(25, this.w) + computeInt64Size2;
        C0485om c0485om = this.y;
        if (c0485om != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(27, c0485om);
        }
        C0460nm c0460nm = this.z;
        if (c0460nm != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(29, c0460nm);
        }
        C0634um c0634um = this.A;
        if (c0634um != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(30, c0634um);
        }
        C0584sm[] c0584smArr = this.B;
        if (c0584smArr != null && c0584smArr.length > 0) {
            while (true) {
                C0584sm[] c0584smArr2 = this.B;
                if (i >= c0584smArr2.length) {
                    break;
                }
                C0584sm c0584sm = c0584smArr2[i];
                if (c0584sm != null) {
                    computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(31, c0584sm);
                }
                i++;
            }
        }
        C0535qm c0535qm = this.C;
        return c0535qm != null ? CodedOutputByteBufferNano.computeMessageSize(32, c0535qm) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1296a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1296a);
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
        C0510pm[] c0510pmArr = this.h;
        if (c0510pmArr != null && c0510pmArr.length > 0) {
            int i5 = 0;
            while (true) {
                C0510pm[] c0510pmArr2 = this.h;
                if (i5 >= c0510pmArr2.length) {
                    break;
                }
                C0510pm c0510pm = c0510pmArr2[i5];
                if (c0510pm != null) {
                    codedOutputByteBufferNano.writeMessage(8, c0510pm);
                }
                i5++;
            }
        }
        C0559rm c0559rm = this.i;
        if (c0559rm != null) {
            codedOutputByteBufferNano.writeMessage(9, c0559rm);
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
        C0659vm c0659vm = this.p;
        if (c0659vm != null) {
            codedOutputByteBufferNano.writeMessage(16, c0659vm);
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
        C0609tm c0609tm = this.v;
        if (c0609tm != null) {
            codedOutputByteBufferNano.writeMessage(24, c0609tm);
        }
        codedOutputByteBufferNano.writeInt32(25, this.w);
        codedOutputByteBufferNano.writeInt32(26, this.x);
        C0485om c0485om = this.y;
        if (c0485om != null) {
            codedOutputByteBufferNano.writeMessage(27, c0485om);
        }
        C0460nm c0460nm = this.z;
        if (c0460nm != null) {
            codedOutputByteBufferNano.writeMessage(29, c0460nm);
        }
        C0634um c0634um = this.A;
        if (c0634um != null) {
            codedOutputByteBufferNano.writeMessage(30, c0634um);
        }
        C0584sm[] c0584smArr = this.B;
        if (c0584smArr != null && c0584smArr.length > 0) {
            while (true) {
                C0584sm[] c0584smArr2 = this.B;
                if (i >= c0584smArr2.length) {
                    break;
                }
                C0584sm c0584sm = c0584smArr2[i];
                if (c0584sm != null) {
                    codedOutputByteBufferNano.writeMessage(31, c0584sm);
                }
                i++;
            }
        }
        C0535qm c0535qm = this.C;
        if (c0535qm != null) {
            codedOutputByteBufferNano.writeMessage(32, c0535qm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C0684wm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0684wm().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0684wm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    this.f1296a = codedInputByteBufferNano.readString();
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
                    C0510pm[] c0510pmArr = this.h;
                    int length4 = c0510pmArr == null ? 0 : c0510pmArr.length;
                    int i4 = repeatedFieldArrayLength4 + length4;
                    C0510pm[] c0510pmArr2 = new C0510pm[i4];
                    if (length4 != 0) {
                        System.arraycopy(c0510pmArr, 0, c0510pmArr2, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        C0510pm c0510pm = new C0510pm();
                        c0510pmArr2[length4] = c0510pm;
                        codedInputByteBufferNano.readMessage(c0510pm);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    C0510pm c0510pm2 = new C0510pm();
                    c0510pmArr2[length4] = c0510pm2;
                    codedInputByteBufferNano.readMessage(c0510pm2);
                    this.h = c0510pmArr2;
                    break;
                case 74:
                    if (this.i == null) {
                        this.i = new C0559rm();
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
                        this.p = new C0659vm();
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
                        this.v = new C0609tm();
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
                        this.y = new C0485om();
                    }
                    codedInputByteBufferNano.readMessage(this.y);
                    break;
                case 234:
                    if (this.z == null) {
                        this.z = new C0460nm();
                    }
                    codedInputByteBufferNano.readMessage(this.z);
                    break;
                case 242:
                    if (this.A == null) {
                        this.A = new C0634um();
                    }
                    codedInputByteBufferNano.readMessage(this.A);
                    break;
                case 250:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 250);
                    C0584sm[] c0584smArr = this.B;
                    int length6 = c0584smArr == null ? 0 : c0584smArr.length;
                    int i6 = repeatedFieldArrayLength6 + length6;
                    C0584sm[] c0584smArr2 = new C0584sm[i6];
                    if (length6 != 0) {
                        System.arraycopy(c0584smArr, 0, c0584smArr2, 0, length6);
                    }
                    while (length6 < i6 - 1) {
                        C0584sm c0584sm = new C0584sm();
                        c0584smArr2[length6] = c0584sm;
                        codedInputByteBufferNano.readMessage(c0584sm);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    C0584sm c0584sm2 = new C0584sm();
                    c0584smArr2[length6] = c0584sm2;
                    codedInputByteBufferNano.readMessage(c0584sm2);
                    this.B = c0584smArr2;
                    break;
                case 258:
                    if (this.C == null) {
                        this.C = new C0535qm();
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

    public static C0684wm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0684wm) MessageNano.mergeFrom(new C0684wm(), bArr);
    }
}
