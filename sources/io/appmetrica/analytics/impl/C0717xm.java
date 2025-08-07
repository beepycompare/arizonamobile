package io.appmetrica.analytics.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.xm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0717xm extends MessageNano {
    public static final int E = -1;
    public static final int F = 0;
    public static final int G = 1;
    public static volatile C0717xm[] H;
    public C0468nm A;
    public C0667vm B;
    public C0617tm[] C;
    public C0567rm D;

    /* renamed from: a  reason: collision with root package name */
    public String f1141a;
    public long b;
    public String[] c;
    public String d;
    public String e;
    public String[] f;
    public String[] g;
    public C0543qm[] h;
    public C0592sm i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String[] o;
    public C0692wm p;
    public boolean q;
    public String r;
    public long s;
    public long t;
    public boolean u;
    public C0642um v;
    public int w;
    public int x;
    public C0518pm y;
    public C0493om z;

    public C0717xm() {
        a();
    }

    public static C0717xm[] b() {
        if (H == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (H == null) {
                    H = new C0717xm[0];
                }
            }
        }
        return H;
    }

    public final C0717xm a() {
        this.f1141a = "";
        this.b = 0L;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.c = strArr;
        this.d = "";
        this.e = "";
        this.f = strArr;
        this.g = strArr;
        this.h = C0543qm.b();
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
        this.B = null;
        this.C = C0617tm.b();
        this.D = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1141a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1141a);
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
        C0543qm[] c0543qmArr = this.h;
        if (c0543qmArr != null && c0543qmArr.length > 0) {
            int i11 = 0;
            while (true) {
                C0543qm[] c0543qmArr2 = this.h;
                if (i11 >= c0543qmArr2.length) {
                    break;
                }
                C0543qm c0543qm = c0543qmArr2[i11];
                if (c0543qm != null) {
                    computeInt64Size += CodedOutputByteBufferNano.computeMessageSize(8, c0543qm);
                }
                i11++;
            }
        }
        C0592sm c0592sm = this.i;
        if (c0592sm != null) {
            computeInt64Size += CodedOutputByteBufferNano.computeMessageSize(9, c0592sm);
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
        C0692wm c0692wm = this.p;
        if (c0692wm != null) {
            computeBoolSize += CodedOutputByteBufferNano.computeMessageSize(16, c0692wm);
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
        C0642um c0642um = this.v;
        if (c0642um != null) {
            computeInt64Size2 += CodedOutputByteBufferNano.computeMessageSize(24, c0642um);
        }
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(26, this.x) + CodedOutputByteBufferNano.computeInt32Size(25, this.w) + computeInt64Size2;
        C0518pm c0518pm = this.y;
        if (c0518pm != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(27, c0518pm);
        }
        C0493om c0493om = this.z;
        if (c0493om != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(28, c0493om);
        }
        C0468nm c0468nm = this.A;
        if (c0468nm != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(29, c0468nm);
        }
        C0667vm c0667vm = this.B;
        if (c0667vm != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(30, c0667vm);
        }
        C0617tm[] c0617tmArr = this.C;
        if (c0617tmArr != null && c0617tmArr.length > 0) {
            while (true) {
                C0617tm[] c0617tmArr2 = this.C;
                if (i >= c0617tmArr2.length) {
                    break;
                }
                C0617tm c0617tm = c0617tmArr2[i];
                if (c0617tm != null) {
                    computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(31, c0617tm);
                }
                i++;
            }
        }
        C0567rm c0567rm = this.D;
        return c0567rm != null ? CodedOutputByteBufferNano.computeMessageSize(32, c0567rm) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1141a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1141a);
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
        C0543qm[] c0543qmArr = this.h;
        if (c0543qmArr != null && c0543qmArr.length > 0) {
            int i5 = 0;
            while (true) {
                C0543qm[] c0543qmArr2 = this.h;
                if (i5 >= c0543qmArr2.length) {
                    break;
                }
                C0543qm c0543qm = c0543qmArr2[i5];
                if (c0543qm != null) {
                    codedOutputByteBufferNano.writeMessage(8, c0543qm);
                }
                i5++;
            }
        }
        C0592sm c0592sm = this.i;
        if (c0592sm != null) {
            codedOutputByteBufferNano.writeMessage(9, c0592sm);
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
        C0692wm c0692wm = this.p;
        if (c0692wm != null) {
            codedOutputByteBufferNano.writeMessage(16, c0692wm);
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
        C0642um c0642um = this.v;
        if (c0642um != null) {
            codedOutputByteBufferNano.writeMessage(24, c0642um);
        }
        codedOutputByteBufferNano.writeInt32(25, this.w);
        codedOutputByteBufferNano.writeInt32(26, this.x);
        C0518pm c0518pm = this.y;
        if (c0518pm != null) {
            codedOutputByteBufferNano.writeMessage(27, c0518pm);
        }
        C0493om c0493om = this.z;
        if (c0493om != null) {
            codedOutputByteBufferNano.writeMessage(28, c0493om);
        }
        C0468nm c0468nm = this.A;
        if (c0468nm != null) {
            codedOutputByteBufferNano.writeMessage(29, c0468nm);
        }
        C0667vm c0667vm = this.B;
        if (c0667vm != null) {
            codedOutputByteBufferNano.writeMessage(30, c0667vm);
        }
        C0617tm[] c0617tmArr = this.C;
        if (c0617tmArr != null && c0617tmArr.length > 0) {
            while (true) {
                C0617tm[] c0617tmArr2 = this.C;
                if (i >= c0617tmArr2.length) {
                    break;
                }
                C0617tm c0617tm = c0617tmArr2[i];
                if (c0617tm != null) {
                    codedOutputByteBufferNano.writeMessage(31, c0617tm);
                }
                i++;
            }
        }
        C0567rm c0567rm = this.D;
        if (c0567rm != null) {
            codedOutputByteBufferNano.writeMessage(32, c0567rm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C0717xm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0717xm().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0717xm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    this.f1141a = codedInputByteBufferNano.readString();
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
                    C0543qm[] c0543qmArr = this.h;
                    int length4 = c0543qmArr == null ? 0 : c0543qmArr.length;
                    int i4 = repeatedFieldArrayLength4 + length4;
                    C0543qm[] c0543qmArr2 = new C0543qm[i4];
                    if (length4 != 0) {
                        System.arraycopy(c0543qmArr, 0, c0543qmArr2, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        C0543qm c0543qm = new C0543qm();
                        c0543qmArr2[length4] = c0543qm;
                        codedInputByteBufferNano.readMessage(c0543qm);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    C0543qm c0543qm2 = new C0543qm();
                    c0543qmArr2[length4] = c0543qm2;
                    codedInputByteBufferNano.readMessage(c0543qm2);
                    this.h = c0543qmArr2;
                    break;
                case 74:
                    if (this.i == null) {
                        this.i = new C0592sm();
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
                        this.p = new C0692wm();
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
                        this.v = new C0642um();
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
                        this.y = new C0518pm();
                    }
                    codedInputByteBufferNano.readMessage(this.y);
                    break;
                case 226:
                    if (this.z == null) {
                        this.z = new C0493om();
                    }
                    codedInputByteBufferNano.readMessage(this.z);
                    break;
                case 234:
                    if (this.A == null) {
                        this.A = new C0468nm();
                    }
                    codedInputByteBufferNano.readMessage(this.A);
                    break;
                case 242:
                    if (this.B == null) {
                        this.B = new C0667vm();
                    }
                    codedInputByteBufferNano.readMessage(this.B);
                    break;
                case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                    C0617tm[] c0617tmArr = this.C;
                    int length6 = c0617tmArr == null ? 0 : c0617tmArr.length;
                    int i6 = repeatedFieldArrayLength6 + length6;
                    C0617tm[] c0617tmArr2 = new C0617tm[i6];
                    if (length6 != 0) {
                        System.arraycopy(c0617tmArr, 0, c0617tmArr2, 0, length6);
                    }
                    while (length6 < i6 - 1) {
                        C0617tm c0617tm = new C0617tm();
                        c0617tmArr2[length6] = c0617tm;
                        codedInputByteBufferNano.readMessage(c0617tm);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    C0617tm c0617tm2 = new C0617tm();
                    c0617tmArr2[length6] = c0617tm2;
                    codedInputByteBufferNano.readMessage(c0617tm2);
                    this.C = c0617tmArr2;
                    break;
                case 258:
                    if (this.D == null) {
                        this.D = new C0567rm();
                    }
                    codedInputByteBufferNano.readMessage(this.D);
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

    public static C0717xm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0717xm) MessageNano.mergeFrom(new C0717xm(), bArr);
    }
}
