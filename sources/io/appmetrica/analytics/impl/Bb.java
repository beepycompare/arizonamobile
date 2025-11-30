package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Bb extends MessageNano {
    public static volatile Bb[] f;

    /* renamed from: a  reason: collision with root package name */
    public String f409a;
    public String b;
    public boolean c;
    public String d;
    public String e;

    public Bb() {
        a();
    }

    public static Bb[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new Bb[0];
                }
            }
        }
        return f;
    }

    public final Bb a() {
        this.f409a = "";
        this.b = "";
        this.c = false;
        this.d = "";
        this.e = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f409a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f409a);
        }
        if (!this.b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.b);
        }
        boolean z = this.c;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(22, z);
        }
        if (!this.d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(25, this.d);
        }
        return !this.e.equals("") ? CodedOutputByteBufferNano.computeStringSize(26, this.e) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f409a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f409a);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.b);
        }
        boolean z = this.c;
        if (z) {
            codedOutputByteBufferNano.writeBool(22, z);
        }
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(25, this.d);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(26, this.e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Bb mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f409a = codedInputByteBufferNano.readString();
            } else if (readTag == 154) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag == 176) {
                this.c = codedInputByteBufferNano.readBool();
            } else if (readTag == 202) {
                this.d = codedInputByteBufferNano.readString();
            } else if (readTag != 210) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.e = codedInputByteBufferNano.readString();
            }
        }
        return this;
    }

    public static Bb b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Bb().mergeFrom(codedInputByteBufferNano);
    }

    public static Bb a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Bb) MessageNano.mergeFrom(new Bb(), bArr);
    }
}
