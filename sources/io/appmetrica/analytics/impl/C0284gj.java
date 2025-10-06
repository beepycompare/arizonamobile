package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.gj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0284gj extends MessageNano {
    public static volatile C0284gj[] d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f900a;
    public C0258fj b;
    public C0232ej c;

    public C0284gj() {
        a();
    }

    public static C0284gj[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C0284gj[0];
                }
            }
        }
        return d;
    }

    public final C0284gj a() {
        this.f900a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f900a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        C0258fj c0258fj = this.b;
        if (c0258fj != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0258fj);
        }
        C0232ej c0232ej = this.c;
        return c0232ej != null ? CodedOutputByteBufferNano.computeMessageSize(3, c0232ej) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f900a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        C0258fj c0258fj = this.b;
        if (c0258fj != null) {
            codedOutputByteBufferNano.writeMessage(2, c0258fj);
        }
        C0232ej c0232ej = this.c;
        if (c0232ej != null) {
            codedOutputByteBufferNano.writeMessage(3, c0232ej);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0284gj mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f900a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0258fj();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new C0232ej();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static C0284gj b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0284gj().mergeFrom(codedInputByteBufferNano);
    }

    public static C0284gj a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0284gj) MessageNano.mergeFrom(new C0284gj(), bArr);
    }
}
