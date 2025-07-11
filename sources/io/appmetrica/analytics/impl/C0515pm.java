package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.pm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0515pm extends MessageNano {
    public static volatile C0515pm[] g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f995a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;

    public C0515pm() {
        a();
    }

    public static C0515pm[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0515pm[0];
                }
            }
        }
        return g;
    }

    public final C0515pm a() {
        this.f995a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = -1;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeBoolSize = CodedOutputByteBufferNano.computeBoolSize(4, this.d) + CodedOutputByteBufferNano.computeBoolSize(3, this.c) + CodedOutputByteBufferNano.computeBoolSize(2, this.b) + CodedOutputByteBufferNano.computeBoolSize(1, this.f995a) + super.computeSerializedSize();
        boolean z = this.e;
        if (z) {
            computeBoolSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
        }
        int i = this.f;
        return i != -1 ? CodedOutputByteBufferNano.computeInt32Size(6, i) + computeBoolSize : computeBoolSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeBool(1, this.f995a);
        codedOutputByteBufferNano.writeBool(2, this.b);
        codedOutputByteBufferNano.writeBool(3, this.c);
        codedOutputByteBufferNano.writeBool(4, this.d);
        boolean z = this.e;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        int i = this.f;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(6, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0515pm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f995a = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.b = codedInputByteBufferNano.readBool();
            } else if (readTag == 24) {
                this.c = codedInputByteBufferNano.readBool();
            } else if (readTag == 32) {
                this.d = codedInputByteBufferNano.readBool();
            } else if (readTag == 40) {
                this.e = codedInputByteBufferNano.readBool();
            } else if (readTag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == -1 || readInt32 == 0 || readInt32 == 1) {
                    this.f = readInt32;
                }
            }
        }
        return this;
    }

    public static C0515pm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0515pm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0515pm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0515pm) MessageNano.mergeFrom(new C0515pm(), bArr);
    }
}
