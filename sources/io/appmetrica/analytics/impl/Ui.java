package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Ui extends MessageNano {
    public static volatile Ui[] d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f661a;
    public Ti b;
    public Si c;

    public Ui() {
        a();
    }

    public static Ui[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new Ui[0];
                }
            }
        }
        return d;
    }

    public final Ui a() {
        this.f661a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f661a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        Ti ti = this.b;
        if (ti != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, ti);
        }
        Si si = this.c;
        return si != null ? CodedOutputByteBufferNano.computeMessageSize(3, si) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f661a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        Ti ti = this.b;
        if (ti != null) {
            codedOutputByteBufferNano.writeMessage(2, ti);
        }
        Si si = this.c;
        if (si != null) {
            codedOutputByteBufferNano.writeMessage(3, si);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Ui mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f661a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new Ti();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new Si();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static Ui b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Ui().mergeFrom(codedInputByteBufferNano);
    }

    public static Ui a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Ui) MessageNano.mergeFrom(new Ui(), bArr);
    }
}
