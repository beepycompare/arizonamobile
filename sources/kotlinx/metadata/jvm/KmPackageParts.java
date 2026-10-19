package kotlinx.metadata.jvm;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KotlinModuleMetadata.kt */
@UnstableMetadataApi
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/metadata/jvm/KmPackageParts;", "", "fileFacades", "", "", "multiFileClassParts", "", "(Ljava/util/List;Ljava/util/Map;)V", "getFileFacades", "()Ljava/util/List;", "getMultiFileClassParts", "()Ljava/util/Map;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmPackageParts {
    private final List<String> fileFacades;
    private final Map<String, String> multiFileClassParts;

    public KmPackageParts(List<String> fileFacades, Map<String, String> multiFileClassParts) {
        Intrinsics.checkNotNullParameter(fileFacades, "fileFacades");
        Intrinsics.checkNotNullParameter(multiFileClassParts, "multiFileClassParts");
        this.fileFacades = fileFacades;
        this.multiFileClassParts = multiFileClassParts;
    }

    public final List<String> getFileFacades() {
        return this.fileFacades;
    }

    public final Map<String, String> getMultiFileClassParts() {
        return this.multiFileClassParts;
    }
}
