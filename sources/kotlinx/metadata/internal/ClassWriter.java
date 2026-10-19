package kotlinx.metadata.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmConstructor;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.KmType;
import kotlinx.metadata.KmTypeAlias;
import kotlinx.metadata.KmTypeParameter;
import kotlinx.metadata.KmVersionRequirement;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.serialization.StringTable;
/* compiled from: Writers.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lkotlinx/metadata/internal/ClassWriter;", "", "stringTable", "Lkotlinx/metadata/internal/metadata/serialization/StringTable;", "contextExtensions", "", "Lkotlinx/metadata/internal/WriteContextExtension;", "(Lorg/jetbrains/kotlin/metadata/serialization/StringTable;Ljava/util/List;)V", "c", "Lkotlinx/metadata/internal/WriteContext;", "getC", "()Lkotlinx/metadata/internal/WriteContext;", "t", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Class$Builder;", "getT", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Class$Builder;", "writeClass", "", "kmClass", "Lkotlinx/metadata/KmClass;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ClassWriter {
    private final WriteContext c;
    private final ProtoBuf.Class.Builder t;

    public ClassWriter(StringTable stringTable, List<? extends WriteContextExtension> contextExtensions) {
        Intrinsics.checkNotNullParameter(stringTable, "stringTable");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        ProtoBuf.Class.Builder newBuilder = ProtoBuf.Class.newBuilder();
        Intrinsics.checkNotNull(newBuilder);
        this.t = newBuilder;
        this.c = new WriteContext(stringTable, contextExtensions);
    }

    public /* synthetic */ ClassWriter(StringTable stringTable, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stringTable, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final ProtoBuf.Class.Builder getT() {
        return this.t;
    }

    public final WriteContext getC() {
        return this.c;
    }

    public final void writeClass(KmClass kmClass) {
        Integer writeVersionRequirement;
        ProtoBuf.Type.Builder writeType;
        ProtoBuf.Type.Builder writeType2;
        ProtoBuf.TypeAlias.Builder writeTypeAlias;
        ProtoBuf.Function.Builder writeFunction;
        ProtoBuf.Constructor.Builder writeConstructor;
        ProtoBuf.Type.Builder writeType3;
        ProtoBuf.TypeParameter.Builder writeTypeParameter;
        Intrinsics.checkNotNullParameter(kmClass, "kmClass");
        if (kmClass.getFlags() != ProtoBuf.Class.getDefaultInstance().getFlags()) {
            this.t.setFlags(kmClass.getFlags());
        }
        this.t.setFqName(this.c.getClassName$kotlinx_metadata(kmClass.getName()));
        ProtoBuf.Class.Builder builder = this.t;
        List<KmTypeParameter> typeParameters = kmClass.getTypeParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        for (KmTypeParameter kmTypeParameter : typeParameters) {
            writeTypeParameter = WritersKt.writeTypeParameter(this.c, kmTypeParameter);
            arrayList.add(writeTypeParameter.build());
        }
        builder.addAllTypeParameter(arrayList);
        ProtoBuf.Class.Builder builder2 = this.t;
        List<KmType> supertypes = kmClass.getSupertypes();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes, 10));
        for (KmType kmType : supertypes) {
            writeType3 = WritersKt.writeType(this.c, kmType);
            arrayList2.add(writeType3.build());
        }
        builder2.addAllSupertype(arrayList2);
        ProtoBuf.Class.Builder builder3 = this.t;
        List<KmConstructor> constructors = kmClass.getConstructors();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(constructors, 10));
        for (KmConstructor kmConstructor : constructors) {
            writeConstructor = WritersKt.writeConstructor(this.c, kmConstructor);
            arrayList3.add(writeConstructor.build());
        }
        builder3.addAllConstructor(arrayList3);
        ProtoBuf.Class.Builder builder4 = this.t;
        List<KmFunction> functions = kmClass.getFunctions();
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(functions, 10));
        for (KmFunction kmFunction : functions) {
            writeFunction = WritersKt.writeFunction(this.c, kmFunction);
            arrayList4.add(writeFunction.build());
        }
        builder4.addAllFunction(arrayList4);
        ProtoBuf.Class.Builder builder5 = this.t;
        List<KmProperty> properties = kmClass.getProperties();
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(properties, 10));
        for (KmProperty kmProperty : properties) {
            arrayList5.add(WritersKt.writeProperty(this.c, kmProperty).build());
        }
        builder5.addAllProperty(arrayList5);
        ProtoBuf.Class.Builder builder6 = this.t;
        List<KmTypeAlias> typeAliases = kmClass.getTypeAliases();
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeAliases, 10));
        for (KmTypeAlias kmTypeAlias : typeAliases) {
            writeTypeAlias = WritersKt.writeTypeAlias(this.c, kmTypeAlias);
            arrayList6.add(writeTypeAlias.build());
        }
        builder6.addAllTypeAlias(arrayList6);
        String companionObject = kmClass.getCompanionObject();
        if (companionObject != null) {
            this.t.setCompanionObjectName(this.c.get(companionObject));
        }
        for (String str : kmClass.getNestedClasses()) {
            this.t.addNestedClassName(this.c.get(str));
        }
        for (String str2 : kmClass.getEnumEntries()) {
            ProtoBuf.Class.Builder builder7 = this.t;
            ProtoBuf.EnumEntry.Builder newBuilder = ProtoBuf.EnumEntry.newBuilder();
            newBuilder.setName(this.c.get(str2));
            builder7.addEnumEntry(newBuilder);
        }
        ProtoBuf.Class.Builder builder8 = this.t;
        List<String> sealedSubclasses = kmClass.getSealedSubclasses();
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sealedSubclasses, 10));
        for (String str3 : sealedSubclasses) {
            arrayList7.add(Integer.valueOf(this.c.getClassName$kotlinx_metadata(str3)));
        }
        builder8.addAllSealedSubclassFqName(arrayList7);
        String inlineClassUnderlyingPropertyName = kmClass.getInlineClassUnderlyingPropertyName();
        if (inlineClassUnderlyingPropertyName != null) {
            this.t.setInlineClassUnderlyingPropertyName(this.c.get(inlineClassUnderlyingPropertyName));
        }
        KmType inlineClassUnderlyingType = kmClass.getInlineClassUnderlyingType();
        if (inlineClassUnderlyingType != null) {
            ProtoBuf.Class.Builder builder9 = this.t;
            writeType2 = WritersKt.writeType(this.c, inlineClassUnderlyingType);
            builder9.setInlineClassUnderlyingType(writeType2.build());
        }
        ProtoBuf.Class.Builder builder10 = this.t;
        List<KmType> contextReceiverTypes = kmClass.getContextReceiverTypes();
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(contextReceiverTypes, 10));
        for (KmType kmType2 : contextReceiverTypes) {
            writeType = WritersKt.writeType(this.c, kmType2);
            arrayList8.add(writeType.build());
        }
        builder10.addAllContextReceiverType(arrayList8);
        ProtoBuf.Class.Builder builder11 = this.t;
        ArrayList arrayList9 = new ArrayList();
        for (KmVersionRequirement kmVersionRequirement : kmClass.getVersionRequirements()) {
            writeVersionRequirement = WritersKt.writeVersionRequirement(this.c, kmVersionRequirement);
            if (writeVersionRequirement != null) {
                arrayList9.add(writeVersionRequirement);
            }
        }
        builder11.addAllVersionRequirement(arrayList9);
        for (MetadataExtensions metadataExtensions : this.c.getExtensions$kotlinx_metadata()) {
            metadataExtensions.writeClassExtensions(kmClass, this.t, this.c);
        }
        ProtoBuf.VersionRequirementTable serialize = this.c.getVersionRequirements$kotlinx_metadata().serialize();
        if (serialize != null) {
            this.t.setVersionRequirementTable(serialize);
        }
    }
}
