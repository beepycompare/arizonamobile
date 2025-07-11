package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.s6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0573s6 extends MessageNano {
    public static volatile C0573s6[] g;

    /* renamed from: a  reason: collision with root package name */
    public String f1039a;
    public String b;
    public int c;
    public String d;
    public boolean e;
    public int f;

    public C0573s6() {
        a();
    }

    public static C0573s6[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0573s6[0];
                }
            }
        }
        return g;
    }

    public final C0573s6 a() {
        this.f1039a = "";
        this.b = "";
        this.c = -1;
        this.d = "";
        this.e = false;
        this.f = -1;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1039a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1039a);
        }
        if (!this.b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        int i = this.c;
        if (i != -1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(3, i);
        }
        if (!this.d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        boolean z = this.e;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
        }
        int i2 = this.f;
        return i2 != -1 ? CodedOutputByteBufferNano.computeSInt32Size(6, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1039a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1039a);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        int i = this.c;
        if (i != -1) {
            codedOutputByteBufferNano.writeSInt32(3, i);
        }
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        boolean z = this.e;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        int i2 = this.f;
        if (i2 != -1) {
            codedOutputByteBufferNano.writeSInt32(6, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0573s6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1039a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.c = codedInputByteBufferNano.readSInt32();
            } else if (readTag == 34) {
                this.d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.e = codedInputByteBufferNano.readBool();
            } else if (readTag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f = codedInputByteBufferNano.readSInt32();
            }
        }
        return this;
    }

    public static C0573s6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0573s6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0573s6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0573s6) MessageNano.mergeFrom(new C0573s6(), bArr);
    }
}
