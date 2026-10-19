package kotlinx.metadata.internal.metadata.jvm.deserialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.deserialization.NameResolver;
/* compiled from: BinaryModuleData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/metadata/internal/metadata/jvm/deserialization/BinaryModuleData;", "", "annotations", "", "", "optionalAnnotations", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Class;", "nameResolver", "Lkotlinx/metadata/internal/metadata/deserialization/NameResolver;", "<init>", "(Ljava/util/List;Ljava/util/List;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;)V", "getAnnotations", "()Ljava/util/List;", "getOptionalAnnotations", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "metadata.jvm"}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class BinaryModuleData {
    private final List<String> annotations;
    private final NameResolver nameResolver;
    private final List<ProtoBuf.Class> optionalAnnotations;

    public BinaryModuleData(List<String> annotations, List<ProtoBuf.Class> optionalAnnotations, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(optionalAnnotations, "optionalAnnotations");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        this.annotations = annotations;
        this.optionalAnnotations = optionalAnnotations;
        this.nameResolver = nameResolver;
    }

    public final List<String> getAnnotations() {
        return this.annotations;
    }

    public final List<ProtoBuf.Class> getOptionalAnnotations() {
        return this.optionalAnnotations;
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }
}
