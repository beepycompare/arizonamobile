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
/* loaded from: classes3.dex */
public final class Am extends MessageNano {
    public static final int D = -1;
    public static final int E = 0;
    public static final int F = 1;
    public static volatile Am[] G;
    public C0732ym A;
    public C0682wm[] B;
    public C0632um C;

    /* renamed from: a  reason: collision with root package name */
    public String f400a;
    public long b;
    public String[] c;
    public String d;
    public String e;
    public String[] f;
    public String[] g;
    public C0607tm[] h;
    public C0657vm i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String[] o;
    public C0757zm p;
    public boolean q;
    public String r;
    public long s;
    public long t;
    public boolean u;
    public C0707xm v;
    public int w;
    public int x;
    public C0582sm y;
    public C0557rm z;

    public Am() {
        a();
    }

    public static Am[] b() {
        if (G == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (G == null) {
                    G = new Am[0];
                }
            }
        }
        return G;
    }

    public final Am a() {
        this.f400a = "";
        this.b = 0L;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.c = strArr;
        this.d = "";
        this.e = "";
        this.f = strArr;
        this.g = strArr;
        this.h = C0607tm.b();
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
        this.B = C0682wm.b();
        this.C = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f400a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400a);
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
        C0607tm[] c0607tmArr = this.h;
        if (c0607tmArr != null && c0607tmArr.length > 0) {
            int i11 = 0;
            while (true) {
                C0607tm[] c0607tmArr2 = this.h;
                if (i11 >= c0607tmArr2.length) {
                    break;
                }
                C0607tm c0607tm = c0607tmArr2[i11];
                if (c0607tm != null) {
                    computeInt64Size += CodedOutputByteBufferNano.computeMessageSize(8, c0607tm);
                }
                i11++;
            }
        }
        C0657vm c0657vm = this.i;
        if (c0657vm != null) {
            computeInt64Size += CodedOutputByteBufferNano.computeMessageSize(9, c0657vm);
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
        C0757zm c0757zm = this.p;
        if (c0757zm != null) {
            computeBoolSize += CodedOutputByteBufferNano.computeMessageSize(16, c0757zm);
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
        C0707xm c0707xm = this.v;
        if (c0707xm != null) {
            computeInt64Size2 += CodedOutputByteBufferNano.computeMessageSize(24, c0707xm);
        }
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(26, this.x) + CodedOutputByteBufferNano.computeInt32Size(25, this.w) + computeInt64Size2;
        C0582sm c0582sm = this.y;
        if (c0582sm != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(27, c0582sm);
        }
        C0557rm c0557rm = this.z;
        if (c0557rm != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(29, c0557rm);
        }
        C0732ym c0732ym = this.A;
        if (c0732ym != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(30, c0732ym);
        }
        C0682wm[] c0682wmArr = this.B;
        if (c0682wmArr != null && c0682wmArr.length > 0) {
            while (true) {
                C0682wm[] c0682wmArr2 = this.B;
                if (i >= c0682wmArr2.length) {
                    break;
                }
                C0682wm c0682wm = c0682wmArr2[i];
                if (c0682wm != null) {
                    computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(31, c0682wm);
                }
                i++;
            }
        }
        C0632um c0632um = this.C;
        return c0632um != null ? CodedOutputByteBufferNano.computeMessageSize(32, c0632um) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400a);
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
        C0607tm[] c0607tmArr = this.h;
        if (c0607tmArr != null && c0607tmArr.length > 0) {
            int i5 = 0;
            while (true) {
                C0607tm[] c0607tmArr2 = this.h;
                if (i5 >= c0607tmArr2.length) {
                    break;
                }
                C0607tm c0607tm = c0607tmArr2[i5];
                if (c0607tm != null) {
                    codedOutputByteBufferNano.writeMessage(8, c0607tm);
                }
                i5++;
            }
        }
        C0657vm c0657vm = this.i;
        if (c0657vm != null) {
            codedOutputByteBufferNano.writeMessage(9, c0657vm);
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
        C0757zm c0757zm = this.p;
        if (c0757zm != null) {
            codedOutputByteBufferNano.writeMessage(16, c0757zm);
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
        C0707xm c0707xm = this.v;
        if (c0707xm != null) {
            codedOutputByteBufferNano.writeMessage(24, c0707xm);
        }
        codedOutputByteBufferNano.writeInt32(25, this.w);
        codedOutputByteBufferNano.writeInt32(26, this.x);
        C0582sm c0582sm = this.y;
        if (c0582sm != null) {
            codedOutputByteBufferNano.writeMessage(27, c0582sm);
        }
        C0557rm c0557rm = this.z;
        if (c0557rm != null) {
            codedOutputByteBufferNano.writeMessage(29, c0557rm);
        }
        C0732ym c0732ym = this.A;
        if (c0732ym != null) {
            codedOutputByteBufferNano.writeMessage(30, c0732ym);
        }
        C0682wm[] c0682wmArr = this.B;
        if (c0682wmArr != null && c0682wmArr.length > 0) {
            while (true) {
                C0682wm[] c0682wmArr2 = this.B;
                if (i >= c0682wmArr2.length) {
                    break;
                }
                C0682wm c0682wm = c0682wmArr2[i];
                if (c0682wm != null) {
                    codedOutputByteBufferNano.writeMessage(31, c0682wm);
                }
                i++;
            }
        }
        C0632um c0632um = this.C;
        if (c0632um != null) {
            codedOutputByteBufferNano.writeMessage(32, c0632um);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Am b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Am().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Am mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    this.f400a = codedInputByteBufferNano.readString();
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
                    C0607tm[] c0607tmArr = this.h;
                    int length4 = c0607tmArr == null ? 0 : c0607tmArr.length;
                    int i4 = repeatedFieldArrayLength4 + length4;
                    C0607tm[] c0607tmArr2 = new C0607tm[i4];
                    if (length4 != 0) {
                        System.arraycopy(c0607tmArr, 0, c0607tmArr2, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        C0607tm c0607tm = new C0607tm();
                        c0607tmArr2[length4] = c0607tm;
                        codedInputByteBufferNano.readMessage(c0607tm);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    C0607tm c0607tm2 = new C0607tm();
                    c0607tmArr2[length4] = c0607tm2;
                    codedInputByteBufferNano.readMessage(c0607tm2);
                    this.h = c0607tmArr2;
                    break;
                case 74:
                    if (this.i == null) {
                        this.i = new C0657vm();
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
                        this.p = new C0757zm();
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
                        this.v = new C0707xm();
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
                        this.y = new C0582sm();
                    }
                    codedInputByteBufferNano.readMessage(this.y);
                    break;
                case 234:
                    if (this.z == null) {
                        this.z = new C0557rm();
                    }
                    codedInputByteBufferNano.readMessage(this.z);
                    break;
                case 242:
                    if (this.A == null) {
                        this.A = new C0732ym();
                    }
                    codedInputByteBufferNano.readMessage(this.A);
                    break;
                case 250:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 250);
                    C0682wm[] c0682wmArr = this.B;
                    int length6 = c0682wmArr == null ? 0 : c0682wmArr.length;
                    int i6 = repeatedFieldArrayLength6 + length6;
                    C0682wm[] c0682wmArr2 = new C0682wm[i6];
                    if (length6 != 0) {
                        System.arraycopy(c0682wmArr, 0, c0682wmArr2, 0, length6);
                    }
                    while (length6 < i6 - 1) {
                        C0682wm c0682wm = new C0682wm();
                        c0682wmArr2[length6] = c0682wm;
                        codedInputByteBufferNano.readMessage(c0682wm);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    C0682wm c0682wm2 = new C0682wm();
                    c0682wmArr2[length6] = c0682wm2;
                    codedInputByteBufferNano.readMessage(c0682wm2);
                    this.B = c0682wmArr2;
                    break;
                case 258:
                    if (this.C == null) {
                        this.C = new C0632um();
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

    public static Am a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Am) MessageNano.mergeFrom(new Am(), bArr);
    }
}
