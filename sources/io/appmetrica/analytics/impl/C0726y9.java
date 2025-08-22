package io.appmetrica.analytics.impl;

import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.y9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0726y9 extends MessageNano {
    public static volatile C0726y9[] n;

    /* renamed from: a  reason: collision with root package name */
    public String f1155a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public boolean g;
    public int h;
    public String i;
    public String j;
    public int k;
    public C0701x9[] l;
    public String m;

    public C0726y9() {
        a();
    }

    public static C0726y9[] b() {
        if (n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (n == null) {
                    n = new C0726y9[0];
                }
            }
        }
        return n;
    }

    public final C0726y9 a() {
        this.f1155a = "";
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = "";
        this.f = "";
        this.g = false;
        this.h = 0;
        this.i = "";
        this.j = "";
        this.k = 0;
        this.l = C0701x9.b();
        this.m = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1155a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1155a);
        }
        if (!this.b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        if (!this.c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.c);
        }
        int i = this.d;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        if (!this.e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.e);
        }
        if (!this.f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f);
        }
        boolean z = this.g;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
        }
        int i2 = this.h;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i2);
        }
        if (!this.i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.i);
        }
        if (!this.j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.j);
        }
        int i3 = this.k;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(22, i3);
        }
        C0701x9[] c0701x9Arr = this.l;
        if (c0701x9Arr != null && c0701x9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0701x9[] c0701x9Arr2 = this.l;
                if (i4 >= c0701x9Arr2.length) {
                    break;
                }
                C0701x9 c0701x9 = c0701x9Arr2[i4];
                if (c0701x9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, c0701x9);
                }
                i4++;
            }
        }
        return !this.m.equals("") ? CodedOutputByteBufferNano.computeStringSize(24, this.m) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1155a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1155a);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.c);
        }
        int i = this.d;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.e);
        }
        if (!this.f.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f);
        }
        boolean z = this.g;
        if (z) {
            codedOutputByteBufferNano.writeBool(17, z);
        }
        int i2 = this.h;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i2);
        }
        if (!this.i.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.i);
        }
        if (!this.j.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.j);
        }
        int i3 = this.k;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(22, i3);
        }
        C0701x9[] c0701x9Arr = this.l;
        if (c0701x9Arr != null && c0701x9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C0701x9[] c0701x9Arr2 = this.l;
                if (i4 >= c0701x9Arr2.length) {
                    break;
                }
                C0701x9 c0701x9 = c0701x9Arr2[i4];
                if (c0701x9 != null) {
                    codedOutputByteBufferNano.writeMessage(23, c0701x9);
                }
                i4++;
            }
        }
        if (!this.m.equals("")) {
            codedOutputByteBufferNano.writeString(24, this.m);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C0726y9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0726y9().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0726y9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    this.f1155a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.b = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.c = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.d = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.e = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.f = codedInputByteBufferNano.readString();
                    break;
                case TsExtractor.TS_STREAM_TYPE_DTS_HD /* 136 */:
                    this.g = codedInputByteBufferNano.readBool();
                    break;
                case 144:
                    this.h = codedInputByteBufferNano.readUInt32();
                    break;
                case 154:
                    this.i = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.j = codedInputByteBufferNano.readString();
                    break;
                case 176:
                    this.k = codedInputByteBufferNano.readUInt32();
                    break;
                case 186:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 186);
                    C0701x9[] c0701x9Arr = this.l;
                    int length = c0701x9Arr == null ? 0 : c0701x9Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C0701x9[] c0701x9Arr2 = new C0701x9[i];
                    if (length != 0) {
                        System.arraycopy(c0701x9Arr, 0, c0701x9Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C0701x9 c0701x9 = new C0701x9();
                        c0701x9Arr2[length] = c0701x9;
                        codedInputByteBufferNano.readMessage(c0701x9);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C0701x9 c0701x92 = new C0701x9();
                    c0701x9Arr2[length] = c0701x92;
                    codedInputByteBufferNano.readMessage(c0701x92);
                    this.l = c0701x9Arr2;
                    break;
                case DownloaderService.STATUS_WAITING_TO_RETRY /* 194 */:
                    this.m = codedInputByteBufferNano.readString();
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

    public static C0726y9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0726y9) MessageNano.mergeFrom(new C0726y9(), bArr);
    }
}
