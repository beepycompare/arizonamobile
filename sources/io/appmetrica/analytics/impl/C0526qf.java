package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.qf  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0526qf extends MessageNano {
    public static volatile C0526qf[] f;

    /* renamed from: a  reason: collision with root package name */
    public String f1074a;
    public String b;
    public boolean c;
    public boolean d;
    public int e;

    public C0526qf() {
        a();
    }

    public static C0526qf[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C0526qf[0];
                }
            }
        }
        return f;
    }

    public final C0526qf a() {
        this.f1074a = "";
        this.b = "";
        this.c = false;
        this.d = false;
        this.e = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1074a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1074a);
        }
        if (!this.b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        boolean z = this.c;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
        }
        boolean z2 = this.d;
        if (z2) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z2);
        }
        return CodedOutputByteBufferNano.computeInt32Size(5, this.e) + computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1074a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1074a);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        boolean z = this.c;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        boolean z2 = this.d;
        if (z2) {
            codedOutputByteBufferNano.writeBool(4, z2);
        }
        codedOutputByteBufferNano.writeInt32(5, this.e);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0526qf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1074a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.c = codedInputByteBufferNano.readBool();
            } else if (readTag == 32) {
                this.d = codedInputByteBufferNano.readBool();
            } else if (readTag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.e = readInt32;
                }
            }
        }
        return this;
    }

    public static C0526qf b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0526qf().mergeFrom(codedInputByteBufferNano);
    }

    public static C0526qf a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0526qf) MessageNano.mergeFrom(new C0526qf(), bArr);
    }
}
