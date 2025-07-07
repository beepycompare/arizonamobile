package kotlinx.metadata.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.internal.common.KmModuleFragment;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.serialization.StringTable;
/* compiled from: Writers.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lkotlinx/metadata/internal/ModuleFragmentWriter;", "", "stringTable", "Lkotlinx/metadata/internal/metadata/serialization/StringTable;", "contextExtensions", "", "Lkotlinx/metadata/internal/WriteContextExtension;", "(Lorg/jetbrains/kotlin/metadata/serialization/StringTable;Ljava/util/List;)V", "c", "Lkotlinx/metadata/internal/WriteContext;", "getC", "()Lkotlinx/metadata/internal/WriteContext;", "t", "Lkotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment$Builder;", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$PackageFragment$Builder;", "writeModuleFragment", "", "kmPackageFragment", "Lkotlinx/metadata/internal/common/KmModuleFragment;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ModuleFragmentWriter {
    private final WriteContext c;
    private final ProtoBuf.PackageFragment.Builder t;

    public ModuleFragmentWriter(StringTable stringTable, List<? extends WriteContextExtension> contextExtensions) {
        Intrinsics.checkNotNullParameter(stringTable, "stringTable");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        ProtoBuf.PackageFragment.Builder newBuilder = ProtoBuf.PackageFragment.newBuilder();
        Intrinsics.checkNotNull(newBuilder);
        this.t = newBuilder;
        this.c = new WriteContext(stringTable, contextExtensions);
    }

    public /* synthetic */ ModuleFragmentWriter(StringTable stringTable, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stringTable, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    protected final ProtoBuf.PackageFragment.Builder getT() {
        return this.t;
    }

    protected final WriteContext getC() {
        return this.c;
    }

    public void writeModuleFragment(KmModuleFragment kmPackageFragment) {
        Intrinsics.checkNotNullParameter(kmPackageFragment, "kmPackageFragment");
        KmPackage pkg = kmPackageFragment.getPkg();
        if (pkg != null) {
            PackageWriter packageWriter = new PackageWriter(this.c.getStrings(), this.c.getContextExtensions());
            packageWriter.writePackage(pkg);
            this.t.setPackage(packageWriter.getT());
        }
        for (KmClass kmClass : kmPackageFragment.getClasses()) {
            ClassWriter classWriter = new ClassWriter(this.c.getStrings(), this.c.getContextExtensions());
            classWriter.writeClass(kmClass);
            this.t.addClass_(classWriter.getT());
        }
        for (MetadataExtensions metadataExtensions : this.c.getExtensions$kotlinx_metadata()) {
            metadataExtensions.writeModuleFragmentExtensions(kmPackageFragment, this.t, this.c);
        }
    }
}
