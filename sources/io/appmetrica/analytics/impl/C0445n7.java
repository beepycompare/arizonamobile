package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.n7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0445n7 extends MessageNano {
    public static volatile C0445n7[] k;

    /* renamed from: a  reason: collision with root package name */
    public int f1135a;
    public double b;
    public double c;
    public int d;
    public int e;
    public int f;
    public int g;
    public long h;
    public String i;
    public String j;

    public C0445n7() {
        a();
    }

    public static C0445n7[] b() {
        if (k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (k == null) {
                    k = new C0445n7[0];
                }
            }
        }
        return k;
    }

    public final C0445n7 a() {
        this.f1135a = -1;
        this.b = -1.0d;
        this.c = -1.0d;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1L;
        this.i = "";
        this.j = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f1135a;
        if (i != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(-1.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.b);
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(-1.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.c);
        }
        int i2 = this.d;
        if (i2 != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
        }
        int i3 = this.e;
        if (i3 != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        int i4 = this.f;
        if (i4 != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i4);
        }
        int i5 = this.g;
        if (i5 != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i5);
        }
        long j = this.h;
        if (j != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j);
        }
        if (!this.i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.i);
        }
        return !this.j.equals("") ? CodedOutputByteBufferNano.computeStringSize(10, this.j) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f1135a;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(-1.0d)) {
            codedOutputByteBufferNano.writeDouble(2, this.b);
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(-1.0d)) {
            codedOutputByteBufferNano.writeDouble(3, this.c);
        }
        int i2 = this.d;
        if (i2 != -1) {
            codedOutputByteBufferNano.writeInt32(4, i2);
        }
        int i3 = this.e;
        if (i3 != -1) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        int i4 = this.f;
        if (i4 != -1) {
            codedOutputByteBufferNano.writeInt32(6, i4);
        }
        int i5 = this.g;
        if (i5 != -1) {
            codedOutputByteBufferNano.writeInt32(7, i5);
        }
        long j = this.h;
        if (j != -1) {
            codedOutputByteBufferNano.writeInt64(8, j);
        }
        if (!this.i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.i);
        }
        if (!this.j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C0445n7 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0445n7().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0445n7 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != -1 && readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f1135a = readInt32;
                        break;
                    }
                case 17:
                    this.b = codedInputByteBufferNano.readDouble();
                    break;
                case 25:
                    this.c = codedInputByteBufferNano.readDouble();
                    break;
                case 32:
                    this.d = codedInputByteBufferNano.readInt32();
                    break;
                case 40:
                    this.e = codedInputByteBufferNano.readInt32();
                    break;
                case 48:
                    this.f = codedInputByteBufferNano.readInt32();
                    break;
                case 56:
                    this.g = codedInputByteBufferNano.readInt32();
                    break;
                case 64:
                    this.h = codedInputByteBufferNano.readInt64();
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.j = codedInputByteBufferNano.readString();
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

    public static C0445n7 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0445n7) MessageNano.mergeFrom(new C0445n7(), bArr);
    }
}
