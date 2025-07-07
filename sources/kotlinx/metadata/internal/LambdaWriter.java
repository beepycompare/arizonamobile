package kotlinx.metadata.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmLambda;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.serialization.StringTable;
/* compiled from: Writers.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlinx/metadata/internal/LambdaWriter;", "", "stringTable", "Lkotlinx/metadata/internal/metadata/serialization/StringTable;", "(Lorg/jetbrains/kotlin/metadata/serialization/StringTable;)V", "c", "Lkotlinx/metadata/internal/WriteContext;", "getC", "()Lkotlinx/metadata/internal/WriteContext;", "t", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Function$Builder;", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function$Builder;", "setT", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function$Builder;)V", "writeLambda", "", "kmLambda", "Lkotlinx/metadata/KmLambda;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class LambdaWriter {
    private final WriteContext c;
    private ProtoBuf.Function.Builder t;

    public LambdaWriter(StringTable stringTable) {
        Intrinsics.checkNotNullParameter(stringTable, "stringTable");
        this.c = new WriteContext(stringTable, null, 2, null);
    }

    public final ProtoBuf.Function.Builder getT() {
        return this.t;
    }

    public final void setT(ProtoBuf.Function.Builder builder) {
        this.t = builder;
    }

    public final WriteContext getC() {
        return this.c;
    }

    public final void writeLambda(KmLambda kmLambda) {
        ProtoBuf.Function.Builder writeFunction;
        Intrinsics.checkNotNullParameter(kmLambda, "kmLambda");
        writeFunction = WritersKt.writeFunction(this.c, kmLambda.getFunction());
        this.t = writeFunction;
    }
}
