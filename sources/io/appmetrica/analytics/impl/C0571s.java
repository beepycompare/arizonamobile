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
/* renamed from: io.appmetrica.analytics.impl.s  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0571s extends MessageNano {
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 3;
    public static final int p = 4;
    public static final int q = 5;
    public static final int r = 6;
    public static final int s = 7;
    public static volatile C0571s[] t;
    public static byte[] u;
    public static volatile boolean v;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1190a;
    public r b;
    public byte[] c;
    public int d;
    public byte[] e;
    public byte[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;

    public C0571s() {
        if (!v) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (!v) {
                    u = InternalNano.bytesDefaultValue("manual");
                    v = true;
                }
            }
        }
        a();
    }

    public static C0571s[] b() {
        if (t == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (t == null) {
                    t = new C0571s[0];
                }
            }
        }
        return t;
    }

    public final C0571s a() {
        this.f1190a = (byte[]) u.clone();
        this.b = null;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.c = bArr;
        this.d = 0;
        this.e = bArr;
        this.f = bArr;
        this.g = bArr;
        this.h = bArr;
        this.i = bArr;
        this.j = bArr;
        this.k = bArr;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.f1190a, u)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f1190a);
        }
        r rVar = this.b;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, rVar);
        }
        byte[] bArr = this.c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        }
        int i = this.d;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        if (!Arrays.equals(this.e, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.e);
        }
        if (!Arrays.equals(this.f, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f);
        }
        if (!Arrays.equals(this.g, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, this.g);
        }
        if (!Arrays.equals(this.h, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.h);
        }
        if (!Arrays.equals(this.i, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        if (!Arrays.equals(this.j, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.j);
        }
        return !Arrays.equals(this.k, bArr2) ? CodedOutputByteBufferNano.computeBytesSize(11, this.k) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f1190a, u)) {
            codedOutputByteBufferNano.writeBytes(1, this.f1190a);
        }
        r rVar = this.b;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(2, rVar);
        }
        byte[] bArr = this.c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.c);
        }
        int i = this.d;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        if (!Arrays.equals(this.e, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.e);
        }
        if (!Arrays.equals(this.f, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.f);
        }
        if (!Arrays.equals(this.g, bArr2)) {
            codedOutputByteBufferNano.writeBytes(7, this.g);
        }
        if (!Arrays.equals(this.h, bArr2)) {
            codedOutputByteBufferNano.writeBytes(8, this.h);
        }
        if (!Arrays.equals(this.i, bArr2)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        if (!Arrays.equals(this.j, bArr2)) {
            codedOutputByteBufferNano.writeBytes(10, this.j);
        }
        if (!Arrays.equals(this.k, bArr2)) {
            codedOutputByteBufferNano.writeBytes(11, this.k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C0571s b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0571s().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0571s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    this.f1190a = codedInputByteBufferNano.readBytes();
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new r();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                    break;
                case 26:
                    this.c = codedInputByteBufferNano.readBytes();
                    break;
                case 32:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    switch (readInt32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            this.d = readInt32;
                            continue;
                    }
                case 42:
                    this.e = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    this.f = codedInputByteBufferNano.readBytes();
                    break;
                case 58:
                    this.g = codedInputByteBufferNano.readBytes();
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    this.h = codedInputByteBufferNano.readBytes();
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readBytes();
                    break;
                case 82:
                    this.j = codedInputByteBufferNano.readBytes();
                    break;
                case 90:
                    this.k = codedInputByteBufferNano.readBytes();
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

    public static C0571s a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0571s) MessageNano.mergeFrom(new C0571s(), bArr);
    }
}
