package kotlinx.metadata.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.metadata.KmAnnotation;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmConstructor;
import kotlinx.metadata.KmExtensionType;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.KmType;
import kotlinx.metadata.KmTypeAlias;
import kotlinx.metadata.KmTypeParameter;
import kotlinx.metadata.KmValueParameter;
import kotlinx.metadata.internal.ReadContext;
import kotlinx.metadata.internal.ReadUtilsKt;
import kotlinx.metadata.internal.ReadersKt;
import kotlinx.metadata.internal.WriteContext;
import kotlinx.metadata.internal.WriteUtilsKt;
import kotlinx.metadata.internal.WritersKt;
import kotlinx.metadata.internal.common.KmModuleFragment;
import kotlinx.metadata.internal.common.KmModuleFragmentExtensionVisitor;
import kotlinx.metadata.internal.extensions.KmClassExtension;
import kotlinx.metadata.internal.extensions.KmConstructorExtension;
import kotlinx.metadata.internal.extensions.KmFunctionExtension;
import kotlinx.metadata.internal.extensions.KmModuleFragmentExtension;
import kotlinx.metadata.internal.extensions.KmPackageExtension;
import kotlinx.metadata.internal.extensions.KmPropertyExtension;
import kotlinx.metadata.internal.extensions.KmTypeAliasExtension;
import kotlinx.metadata.internal.extensions.KmTypeExtension;
import kotlinx.metadata.internal.extensions.KmTypeParameterExtension;
import kotlinx.metadata.internal.extensions.KmValueParameterExtension;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.deserialization.ProtoBufUtilKt;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmMemberSignature;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.jvm.JvmFieldSignature;
import kotlinx.metadata.jvm.JvmMemberSignatureKt;
import kotlinx.metadata.jvm.JvmMethodSignature;
/* compiled from: JvmMetadataExtensions.kt */
@Metadata(d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u0002012\u0006\u0010\u001b\u001a\u0002022\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u00103\u001a\u00020\u00182\u0006\u00104\u001a\u0002052\u0006\u0010\u001b\u001a\u0002062\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u00107\u001a\u00020\u00182\u0006\u00108\u001a\u0002092\u0006\u0010\u001b\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020>2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020A2\u0006\u0010\u001b\u001a\u00020B2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010C\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020D2\u0006\u0010\u001d\u001a\u00020EH\u0016J \u0010F\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020G2\u0006\u0010\u001d\u001a\u00020EH\u0016J \u0010H\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020I2\u0006\u0010\u001d\u001a\u00020EH\u0016J \u0010J\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020K2\u0006\u0010\u001d\u001a\u00020EH\u0016J \u0010L\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020M2\u0006\u0010\u001d\u001a\u00020EH\u0016J \u0010N\u001a\u00020\u00182\u0006\u00100\u001a\u0002012\u0006\u0010\u001b\u001a\u00020O2\u0006\u0010\u001d\u001a\u00020EH\u0016J \u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u0002052\u0006\u0010\u001b\u001a\u00020R2\u0006\u0010\u001d\u001a\u00020EH\u0016J \u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u0002092\u0006\u0010\u001b\u001a\u00020U2\u0006\u0010\u001d\u001a\u00020EH\u0016J \u0010V\u001a\u00020\u00182\u0006\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020W2\u0006\u0010\u001d\u001a\u00020EH\u0016J \u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020A2\u0006\u0010\u001b\u001a\u00020Z2\u0006\u0010\u001d\u001a\u00020EH\u0016J\u0014\u0010[\u001a\u00020\\*\u00020]2\u0006\u0010\u001d\u001a\u00020EH\u0002¨\u0006^"}, d2 = {"Lkotlinx/metadata/jvm/internal/JvmMetadataExtensions;", "Lkotlinx/metadata/internal/extensions/MetadataExtensions;", "()V", "createClassExtension", "Lkotlinx/metadata/internal/extensions/KmClassExtension;", "createConstructorExtension", "Lkotlinx/metadata/internal/extensions/KmConstructorExtension;", "createFunctionExtension", "Lkotlinx/metadata/internal/extensions/KmFunctionExtension;", "createModuleFragmentExtensions", "Lkotlinx/metadata/internal/extensions/KmModuleFragmentExtension;", "createPackageExtension", "Lkotlinx/metadata/internal/extensions/KmPackageExtension;", "createPropertyExtension", "Lkotlinx/metadata/internal/extensions/KmPropertyExtension;", "createTypeAliasExtension", "Lkotlinx/metadata/internal/extensions/KmTypeAliasExtension;", "createTypeExtension", "Lkotlinx/metadata/internal/extensions/KmTypeExtension;", "createTypeParameterExtension", "Lkotlinx/metadata/internal/extensions/KmTypeParameterExtension;", "createValueParameterExtension", "Lkotlinx/metadata/internal/extensions/KmValueParameterExtension;", "readClassExtensions", "", "kmClass", "Lkotlinx/metadata/KmClass;", "proto", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Class;", "c", "Lkotlinx/metadata/internal/ReadContext;", "readConstructorExtensions", "kmConstructor", "Lkotlinx/metadata/KmConstructor;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Constructor;", "readFunctionExtensions", "kmFunction", "Lkotlinx/metadata/KmFunction;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Function;", "readModuleFragmentExtensions", "kmModuleFragment", "Lkotlinx/metadata/internal/common/KmModuleFragment;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment;", "readPackageExtensions", "kmPackage", "Lkotlinx/metadata/KmPackage;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Package;", "readPropertyExtensions", "kmProperty", "Lkotlinx/metadata/KmProperty;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Property;", "readTypeAliasExtensions", "kmTypeAlias", "Lkotlinx/metadata/KmTypeAlias;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias;", "readTypeExtensions", "kmType", "Lkotlinx/metadata/KmType;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Type;", "readTypeParameterExtensions", "kmTypeParameter", "Lkotlinx/metadata/KmTypeParameter;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter;", "readValueParameterExtensions", "kmValueParameter", "Lkotlinx/metadata/KmValueParameter;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter;", "writeClassExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Class$Builder;", "Lkotlinx/metadata/internal/WriteContext;", "writeConstructorExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Constructor$Builder;", "writeFunctionExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Function$Builder;", "writeModuleFragmentExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment$Builder;", "writePackageExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Package$Builder;", "writePropertyExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Property$Builder;", "writeTypeAliasExtensions", "typeAlias", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias$Builder;", "writeTypeExtensions", "type", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Type$Builder;", "writeTypeParameterExtensions", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter$Builder;", "writeValueParameterExtensions", "valueParameter", "Lkotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter$Builder;", "toJvmMethodSignature", "Lkotlinx/metadata/internal/metadata/jvm/JvmProtoBuf$JvmMethodSignature;", "Lkotlinx/metadata/jvm/JvmMemberSignature;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmMetadataExtensions implements MetadataExtensions {
    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public KmTypeAliasExtension createTypeAliasExtension() {
        return null;
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public KmValueParameterExtension createValueParameterExtension() {
        return null;
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void readModuleFragmentExtensions(KmModuleFragment kmModuleFragment, ProtoBuf.PackageFragment proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmModuleFragment, "kmModuleFragment");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void readTypeAliasExtensions(KmTypeAlias kmTypeAlias, ProtoBuf.TypeAlias proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmTypeAlias, "kmTypeAlias");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void readValueParameterExtensions(KmValueParameter kmValueParameter, ProtoBuf.ValueParameter proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmValueParameter, "kmValueParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void writeModuleFragmentExtensions(KmModuleFragment kmModuleFragment, ProtoBuf.PackageFragment.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmModuleFragment, "kmModuleFragment");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void writeTypeAliasExtensions(KmTypeAlias typeAlias, ProtoBuf.TypeAlias.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(typeAlias, "typeAlias");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void writeValueParameterExtensions(KmValueParameter valueParameter, ProtoBuf.ValueParameter.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(valueParameter, "valueParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void readClassExtensions(KmClass kmClass, ProtoBuf.Class proto, ReadContext c) {
        String str;
        Intrinsics.checkNotNullParameter(kmClass, "kmClass");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmClassExtension jvm = JvmExtensionNodesKt.getJvm(kmClass);
        ProtoBuf.Class r0 = proto;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> anonymousObjectOriginName = JvmProtoBuf.anonymousObjectOriginName;
        Intrinsics.checkNotNullExpressionValue(anonymousObjectOriginName, "anonymousObjectOriginName");
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(r0, anonymousObjectOriginName);
        if (num != null) {
            jvm.setAnonymousObjectOriginName(c.get(num.intValue()));
        }
        for (ProtoBuf.Property property : (List) proto.getExtension(JvmProtoBuf.classLocalVariable)) {
            List<KmProperty> localDelegatedProperties = jvm.getLocalDelegatedProperties();
            Intrinsics.checkNotNull(property);
            localDelegatedProperties.add(ReadersKt.toKmProperty(property, c));
        }
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName = JvmProtoBuf.classModuleName;
        Intrinsics.checkNotNullExpressionValue(classModuleName, "classModuleName");
        Integer num2 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r0, classModuleName);
        if (num2 == null || (str = c.get(num2.intValue())) == null) {
            str = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        }
        jvm.setModuleName(str);
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> jvmClassFlags = JvmProtoBuf.jvmClassFlags;
        Intrinsics.checkNotNullExpressionValue(jvmClassFlags, "jvmClassFlags");
        Integer num3 = (Integer) ProtoBufUtilKt.getExtensionOrNull(r0, jvmClassFlags);
        if (num3 != null) {
            jvm.setJvmFlags(num3.intValue());
        }
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void readPackageExtensions(KmPackage kmPackage, ProtoBuf.Package proto, ReadContext c) {
        String str;
        Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmPackageExtension jvm = JvmExtensionNodesKt.getJvm(kmPackage);
        for (ProtoBuf.Property property : (List) proto.getExtension(JvmProtoBuf.packageLocalVariable)) {
            List<KmProperty> localDelegatedProperties = jvm.getLocalDelegatedProperties();
            Intrinsics.checkNotNull(property);
            localDelegatedProperties.add(ReadersKt.toKmProperty(property, c));
        }
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName = JvmProtoBuf.packageModuleName;
        Intrinsics.checkNotNullExpressionValue(packageModuleName, "packageModuleName");
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(proto, packageModuleName);
        if (num == null || (str = c.get(num.intValue())) == null) {
            str = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        }
        jvm.setModuleName(str);
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void readFunctionExtensions(KmFunction kmFunction, ProtoBuf.Function proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmFunction, "kmFunction");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmFunctionExtension jvm = JvmExtensionNodesKt.getJvm(kmFunction);
        JvmMemberSignature.Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature(proto, c.getStrings(), c.getTypes());
        jvm.setSignature(jvmMethodSignature != null ? JvmMemberSignatureKt.wrapAsPublic(jvmMethodSignature) : null);
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, Integer> lambdaClassOriginName = JvmProtoBuf.lambdaClassOriginName;
        Intrinsics.checkNotNullExpressionValue(lambdaClassOriginName, "lambdaClassOriginName");
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(proto, lambdaClassOriginName);
        if (num != null) {
            jvm.setLambdaClassOriginName(c.get(num.intValue()));
        }
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void readPropertyExtensions(KmProperty kmProperty, ProtoBuf.Property proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmPropertyExtension jvm = JvmExtensionNodesKt.getJvm(kmProperty);
        JvmMemberSignature.Field jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, proto, c.getStrings(), c.getTypes(), false, 8, null);
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
        JvmProtoBuf.JvmMethodSignature getter = (jvmPropertySignature == null || !jvmPropertySignature.hasGetter()) ? null : jvmPropertySignature.getGetter();
        JvmProtoBuf.JvmMethodSignature setter = (jvmPropertySignature == null || !jvmPropertySignature.hasSetter()) ? null : jvmPropertySignature.getSetter();
        Object extension = proto.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkNotNullExpressionValue(extension, "getExtension(...)");
        jvm.setJvmFlags(((Number) extension).intValue());
        jvm.setFieldSignature(jvmFieldSignature$default != null ? JvmMemberSignatureKt.wrapAsPublic(jvmFieldSignature$default) : null);
        jvm.setGetterSignature(getter != null ? new JvmMethodSignature(c.get(getter.getName()), c.get(getter.getDesc())) : null);
        jvm.setSetterSignature(setter != null ? new JvmMethodSignature(c.get(setter.getName()), c.get(setter.getDesc())) : null);
        JvmProtoBuf.JvmMethodSignature syntheticMethod = (jvmPropertySignature == null || !jvmPropertySignature.hasSyntheticMethod()) ? null : jvmPropertySignature.getSyntheticMethod();
        jvm.setSyntheticMethodForAnnotations(syntheticMethod != null ? new JvmMethodSignature(c.get(syntheticMethod.getName()), c.get(syntheticMethod.getDesc())) : null);
        JvmProtoBuf.JvmMethodSignature delegateMethod = (jvmPropertySignature == null || !jvmPropertySignature.hasDelegateMethod()) ? null : jvmPropertySignature.getDelegateMethod();
        jvm.setSyntheticMethodForDelegate(delegateMethod != null ? new JvmMethodSignature(c.get(delegateMethod.getName()), c.get(delegateMethod.getDesc())) : null);
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void readConstructorExtensions(KmConstructor kmConstructor, ProtoBuf.Constructor proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmConstructor, "kmConstructor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmConstructorExtension jvm = JvmExtensionNodesKt.getJvm(kmConstructor);
        JvmMemberSignature.Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature(proto, c.getStrings(), c.getTypes());
        jvm.setSignature(jvmConstructorSignature != null ? JvmMemberSignatureKt.wrapAsPublic(jvmConstructorSignature) : null);
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void readTypeParameterExtensions(KmTypeParameter kmTypeParameter, ProtoBuf.TypeParameter proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmTypeParameter, "kmTypeParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmTypeParameterExtension jvm = JvmExtensionNodesKt.getJvm(kmTypeParameter);
        for (ProtoBuf.Annotation annotation : (List) proto.getExtension(JvmProtoBuf.typeParameterAnnotation)) {
            List<KmAnnotation> annotations = jvm.getAnnotations();
            Intrinsics.checkNotNull(annotation);
            annotations.add(ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void readTypeExtensions(KmType kmType, ProtoBuf.Type proto, ReadContext c) {
        Intrinsics.checkNotNullParameter(kmType, "kmType");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmTypeExtension jvm = JvmExtensionNodesKt.getJvm(kmType);
        Object extension = proto.getExtension(JvmProtoBuf.isRaw);
        Intrinsics.checkNotNullExpressionValue(extension, "getExtension(...)");
        jvm.setRaw(((Boolean) extension).booleanValue());
        for (ProtoBuf.Annotation annotation : (List) proto.getExtension(JvmProtoBuf.typeAnnotation)) {
            List<KmAnnotation> annotations = jvm.getAnnotations();
            Intrinsics.checkNotNull(annotation);
            annotations.add(ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void writeClassExtensions(KmClass kmClass, ProtoBuf.Class.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmClass, "kmClass");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmClassExtension jvm = JvmExtensionNodesKt.getJvm(kmClass);
        String anonymousObjectOriginName = jvm.getAnonymousObjectOriginName();
        if (anonymousObjectOriginName != null) {
            proto.setExtension(JvmProtoBuf.anonymousObjectOriginName, Integer.valueOf(c.get(anonymousObjectOriginName)));
        }
        for (KmProperty kmProperty : jvm.getLocalDelegatedProperties()) {
            proto.addExtension(JvmProtoBuf.classLocalVariable, WritersKt.writeProperty(c, kmProperty).build());
        }
        String moduleName = jvm.getModuleName();
        if (moduleName != null && !Intrinsics.areEqual(moduleName, JvmProtoBufUtil.DEFAULT_MODULE_NAME)) {
            proto.setExtension(JvmProtoBuf.classModuleName, Integer.valueOf(c.get(moduleName)));
        }
        if (jvm.getJvmFlags() != 0) {
            proto.setExtension(JvmProtoBuf.jvmClassFlags, Integer.valueOf(jvm.getJvmFlags()));
        }
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void writePackageExtensions(KmPackage kmPackage, ProtoBuf.Package.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmPackageExtension jvm = JvmExtensionNodesKt.getJvm(kmPackage);
        for (KmProperty kmProperty : jvm.getLocalDelegatedProperties()) {
            proto.addExtension(JvmProtoBuf.packageLocalVariable, WritersKt.writeProperty(c, kmProperty).build());
        }
        String moduleName = jvm.getModuleName();
        if (moduleName == null || Intrinsics.areEqual(moduleName, JvmProtoBufUtil.DEFAULT_MODULE_NAME)) {
            return;
        }
        proto.setExtension(JvmProtoBuf.packageModuleName, Integer.valueOf(c.get(moduleName)));
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void writeFunctionExtensions(KmFunction kmFunction, ProtoBuf.Function.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmFunction, "kmFunction");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmFunctionExtension jvm = JvmExtensionNodesKt.getJvm(kmFunction);
        JvmMethodSignature signature = jvm.getSignature();
        if (signature != null) {
            proto.setExtension(JvmProtoBuf.methodSignature, toJvmMethodSignature(signature, c));
        }
        String lambdaClassOriginName = jvm.getLambdaClassOriginName();
        if (lambdaClassOriginName != null) {
            proto.setExtension(JvmProtoBuf.lambdaClassOriginName, Integer.valueOf(c.get(lambdaClassOriginName)));
        }
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void writePropertyExtensions(KmProperty kmProperty, ProtoBuf.Property.Builder proto, WriteContext c) {
        boolean z;
        Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmPropertyExtension jvm = JvmExtensionNodesKt.getJvm(kmProperty);
        JvmProtoBuf.JvmPropertySignature.Builder newBuilder = JvmProtoBuf.JvmPropertySignature.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder(...)");
        boolean z2 = true;
        if (jvm.getFieldSignature() != null) {
            JvmProtoBuf.JvmFieldSignature.Builder newBuilder2 = JvmProtoBuf.JvmFieldSignature.newBuilder();
            JvmFieldSignature fieldSignature = jvm.getFieldSignature();
            Intrinsics.checkNotNull(fieldSignature);
            newBuilder2.setName(c.get(fieldSignature.getName()));
            JvmFieldSignature fieldSignature2 = jvm.getFieldSignature();
            Intrinsics.checkNotNull(fieldSignature2);
            newBuilder2.setDesc(c.get(fieldSignature2.getDescriptor()));
            newBuilder.setField(newBuilder2.build());
            z = true;
        } else {
            z = false;
        }
        if (jvm.getGetterSignature() != null) {
            JvmMethodSignature getterSignature = jvm.getGetterSignature();
            Intrinsics.checkNotNull(getterSignature);
            newBuilder.setGetter(toJvmMethodSignature(getterSignature, c));
            z = true;
        }
        if (jvm.getSetterSignature() != null) {
            JvmMethodSignature setterSignature = jvm.getSetterSignature();
            Intrinsics.checkNotNull(setterSignature);
            newBuilder.setSetter(toJvmMethodSignature(setterSignature, c));
        } else {
            z2 = z;
        }
        if (z2 && jvm.getSyntheticMethodForAnnotations() != null) {
            JvmMethodSignature syntheticMethodForAnnotations = jvm.getSyntheticMethodForAnnotations();
            Intrinsics.checkNotNull(syntheticMethodForAnnotations);
            newBuilder.setSyntheticMethod(toJvmMethodSignature(syntheticMethodForAnnotations, c));
        }
        if (z2 && jvm.getSyntheticMethodForDelegate() != null) {
            JvmMethodSignature syntheticMethodForDelegate = jvm.getSyntheticMethodForDelegate();
            Intrinsics.checkNotNull(syntheticMethodForDelegate);
            newBuilder.setDelegateMethod(toJvmMethodSignature(syntheticMethodForDelegate, c));
        }
        int jvmFlags = jvm.getJvmFlags();
        Integer num = (Integer) ProtoBuf.Property.getDefaultInstance().getExtension(JvmProtoBuf.flags);
        if (num == null || jvmFlags != num.intValue()) {
            proto.setExtension(JvmProtoBuf.flags, Integer.valueOf(jvm.getJvmFlags()));
        }
        if (z2) {
            proto.setExtension(JvmProtoBuf.propertySignature, newBuilder.build());
        }
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void writeConstructorExtensions(KmConstructor kmConstructor, ProtoBuf.Constructor.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmConstructor, "kmConstructor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmMethodSignature signature = JvmExtensionNodesKt.getJvm(kmConstructor).getSignature();
        if (signature != null) {
            proto.setExtension(JvmProtoBuf.constructorSignature, toJvmMethodSignature(signature, c));
        }
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void writeTypeParameterExtensions(KmTypeParameter kmTypeParameter, ProtoBuf.TypeParameter.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(kmTypeParameter, "kmTypeParameter");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        for (KmAnnotation kmAnnotation : JvmExtensionNodesKt.getJvm(kmTypeParameter).getAnnotations()) {
            proto.addExtension(JvmProtoBuf.typeParameterAnnotation, WriteUtilsKt.writeAnnotation(kmAnnotation, c.getStrings()).build());
        }
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public void writeTypeExtensions(KmType type, ProtoBuf.Type.Builder proto, WriteContext c) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(c, "c");
        JvmTypeExtension jvm = JvmExtensionNodesKt.getJvm(type);
        if (jvm.isRaw()) {
            proto.setExtension(JvmProtoBuf.isRaw, true);
        }
        for (KmAnnotation kmAnnotation : jvm.getAnnotations()) {
            proto.addExtension(JvmProtoBuf.typeAnnotation, WriteUtilsKt.writeAnnotation(kmAnnotation, c.getStrings()).build());
        }
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public KmClassExtension createClassExtension() {
        return new JvmClassExtension();
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public KmPackageExtension createPackageExtension() {
        return new JvmPackageExtension();
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public KmModuleFragmentExtension createModuleFragmentExtensions() {
        return new KmModuleFragmentExtension() { // from class: kotlinx.metadata.jvm.internal.JvmMetadataExtensions$createModuleFragmentExtensions$1
            private final KmExtensionType type = new KmExtensionType(Reflection.getOrCreateKotlinClass(KmModuleFragmentExtension.class));

            @Override // kotlinx.metadata.internal.extensions.KmExtension
            public void accept(KmModuleFragmentExtensionVisitor visitor) {
                Intrinsics.checkNotNullParameter(visitor, "visitor");
            }

            @Override // kotlinx.metadata.KmExtensionVisitor
            public KmExtensionType getType() {
                return this.type;
            }
        };
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public KmFunctionExtension createFunctionExtension() {
        return new JvmFunctionExtension();
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public KmPropertyExtension createPropertyExtension() {
        return new JvmPropertyExtension();
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public KmConstructorExtension createConstructorExtension() {
        return new JvmConstructorExtension();
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public KmTypeParameterExtension createTypeParameterExtension() {
        return new JvmTypeParameterExtension();
    }

    @Override // kotlinx.metadata.internal.extensions.MetadataExtensions
    public KmTypeExtension createTypeExtension() {
        return new JvmTypeExtension();
    }

    private final JvmProtoBuf.JvmMethodSignature toJvmMethodSignature(kotlinx.metadata.jvm.JvmMemberSignature jvmMemberSignature, WriteContext writeContext) {
        JvmProtoBuf.JvmMethodSignature.Builder newBuilder = JvmProtoBuf.JvmMethodSignature.newBuilder();
        newBuilder.setName(writeContext.get(jvmMemberSignature.getName()));
        newBuilder.setDesc(writeContext.get(jvmMemberSignature.getDescriptor()));
        JvmProtoBuf.JvmMethodSignature build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}
