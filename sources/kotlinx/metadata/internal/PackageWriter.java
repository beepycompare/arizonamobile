package kotlinx.metadata.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.KmTypeAlias;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.serialization.StringTable;
/* compiled from: Writers.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lkotlinx/metadata/internal/PackageWriter;", "", "stringTable", "Lkotlinx/metadata/internal/metadata/serialization/StringTable;", "contextExtensions", "", "Lkotlinx/metadata/internal/WriteContextExtension;", "(Lorg/jetbrains/kotlin/metadata/serialization/StringTable;Ljava/util/List;)V", "c", "Lkotlinx/metadata/internal/WriteContext;", "getC", "()Lkotlinx/metadata/internal/WriteContext;", "t", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Package$Builder;", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Package$Builder;", "writePackage", "", "kmPackage", "Lkotlinx/metadata/KmPackage;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class PackageWriter {
    private final WriteContext c;
    private final ProtoBuf.Package.Builder t;

    public PackageWriter(StringTable stringTable, List<? extends WriteContextExtension> contextExtensions) {
        Intrinsics.checkNotNullParameter(stringTable, "stringTable");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        ProtoBuf.Package.Builder newBuilder = ProtoBuf.Package.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder(...)");
        this.t = newBuilder;
        this.c = new WriteContext(stringTable, contextExtensions);
    }

    public /* synthetic */ PackageWriter(StringTable stringTable, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stringTable, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final ProtoBuf.Package.Builder getT() {
        return this.t;
    }

    public final WriteContext getC() {
        return this.c;
    }

    public final void writePackage(KmPackage kmPackage) {
        ProtoBuf.TypeAlias.Builder writeTypeAlias;
        ProtoBuf.Function.Builder writeFunction;
        Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
        ProtoBuf.Package.Builder builder = this.t;
        List<KmFunction> functions = kmPackage.getFunctions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(functions, 10));
        for (KmFunction kmFunction : functions) {
            writeFunction = WritersKt.writeFunction(this.c, kmFunction);
            arrayList.add(writeFunction.build());
        }
        builder.addAllFunction(arrayList);
        ProtoBuf.Package.Builder builder2 = this.t;
        List<KmProperty> properties = kmPackage.getProperties();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(properties, 10));
        for (KmProperty kmProperty : properties) {
            arrayList2.add(WritersKt.writeProperty(this.c, kmProperty).build());
        }
        builder2.addAllProperty(arrayList2);
        ProtoBuf.Package.Builder builder3 = this.t;
        List<KmTypeAlias> typeAliases = kmPackage.getTypeAliases();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeAliases, 10));
        for (KmTypeAlias kmTypeAlias : typeAliases) {
            writeTypeAlias = WritersKt.writeTypeAlias(this.c, kmTypeAlias);
            arrayList3.add(writeTypeAlias.build());
        }
        builder3.addAllTypeAlias(arrayList3);
        for (MetadataExtensions metadataExtensions : this.c.getExtensions$kotlinx_metadata()) {
            metadataExtensions.writePackageExtensions(kmPackage, this.t, this.c);
        }
        ProtoBuf.VersionRequirementTable serialize = this.c.getVersionRequirements$kotlinx_metadata().serialize();
        if (serialize != null) {
            this.t.setVersionRequirementTable(serialize);
        }
    }
}
