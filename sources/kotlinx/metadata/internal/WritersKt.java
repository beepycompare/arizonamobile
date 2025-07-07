package kotlinx.metadata.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.Attributes;
import kotlinx.metadata.InconsistentKotlinMetadataException;
import kotlinx.metadata.KmAnnotation;
import kotlinx.metadata.KmClassifier;
import kotlinx.metadata.KmConstantValue;
import kotlinx.metadata.KmConstructor;
import kotlinx.metadata.KmContract;
import kotlinx.metadata.KmEffect;
import kotlinx.metadata.KmEffectExpression;
import kotlinx.metadata.KmEffectInvocationKind;
import kotlinx.metadata.KmEffectType;
import kotlinx.metadata.KmFlexibleTypeUpperBound;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.KmPropertyAccessorAttributes;
import kotlinx.metadata.KmType;
import kotlinx.metadata.KmTypeAlias;
import kotlinx.metadata.KmTypeParameter;
import kotlinx.metadata.KmTypeProjection;
import kotlinx.metadata.KmValueParameter;
import kotlinx.metadata.KmVariance;
import kotlinx.metadata.KmVersion;
import kotlinx.metadata.KmVersionRequirement;
import kotlinx.metadata.KmVersionRequirementLevel;
import kotlinx.metadata.KmVersionRequirementVersionKind;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.deserialization.VersionRequirement;
import kotlinx.metadata.internal.metadata.serialization.MutableVersionRequirementTable;
/* compiled from: Writers.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0003\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0003\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0012\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a\u0014\u0010!\u001a\u00020\"*\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0002\u001a\u0014\u0010%\u001a\u00020&*\u00020\u00022\u0006\u0010'\u001a\u00020(H\u0002\u001a\u0014\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010+\u001a\u00020,H\u0002\u001a\u001b\u0010-\u001a\u0004\u0018\u00010.*\u00020\u00022\u0006\u0010/\u001a\u000200H\u0002¢\u0006\u0002\u00101¨\u00062"}, d2 = {"writeConstructor", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Constructor$Builder;", "Lkotlinx/metadata/internal/WriteContext;", "kmConstructor", "Lkotlinx/metadata/KmConstructor;", "writeContract", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Contract;", "contract", "Lkotlinx/metadata/KmContract;", "writeEffect", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Effect;", "effect", "Lkotlinx/metadata/KmEffect;", "writeEffectExpression", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Expression;", "effectExpression", "Lkotlinx/metadata/KmEffectExpression;", "writeFunction", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Function$Builder;", "kmFunction", "Lkotlinx/metadata/KmFunction;", "writeProperty", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Property$Builder;", "kmProperty", "Lkotlinx/metadata/KmProperty;", "writeType", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Type$Builder;", "kmType", "Lkotlinx/metadata/KmType;", "writeTypeAlias", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias$Builder;", "typeAlias", "Lkotlinx/metadata/KmTypeAlias;", "writeTypeParameter", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter$Builder;", "kmTypeParameter", "Lkotlinx/metadata/KmTypeParameter;", "writeTypeProjection", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Type$Argument$Builder;", "argument", "Lkotlinx/metadata/KmTypeProjection;", "writeValueParameter", "Lkotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter$Builder;", "kmValueParameter", "Lkotlinx/metadata/KmValueParameter;", "writeVersionRequirement", "", "kmVersionRequirement", "Lkotlinx/metadata/KmVersionRequirement;", "(Lkotlinx/metadata/internal/WriteContext;Lkotlinx/metadata/KmVersionRequirement;)Ljava/lang/Integer;", "kotlinx-metadata"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WritersKt {

    /* compiled from: Writers.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[KmVersionRequirementVersionKind.values().length];
            try {
                iArr[KmVersionRequirementVersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KmVersionRequirementVersionKind.COMPILER_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KmVersionRequirementVersionKind.API_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KmVersionRequirementVersionKind.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[KmVersionRequirementLevel.values().length];
            try {
                iArr2[KmVersionRequirementLevel.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[KmVersionRequirementLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[KmVersionRequirementLevel.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[KmEffectType.values().length];
            try {
                iArr3[KmEffectType.RETURNS_CONSTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[KmEffectType.CALLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[KmEffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[KmEffectInvocationKind.values().length];
            try {
                iArr4[KmEffectInvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[KmEffectInvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[KmEffectInvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProtoBuf.TypeParameter.Builder writeTypeParameter(WriteContext writeContext, KmTypeParameter kmTypeParameter) {
        ProtoBuf.TypeParameter.Builder newBuilder = ProtoBuf.TypeParameter.newBuilder();
        for (KmType kmType : kmTypeParameter.getUpperBounds()) {
            newBuilder.addUpperBound(writeType(writeContext, kmType).build());
        }
        for (MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlinx_metadata()) {
            Intrinsics.checkNotNull(newBuilder);
            metadataExtensions.writeTypeParameterExtensions(kmTypeParameter, newBuilder, writeContext);
        }
        newBuilder.setName(writeContext.get(kmTypeParameter.getName()));
        newBuilder.setId(kmTypeParameter.getId());
        boolean isReified = Attributes.isReified(kmTypeParameter);
        if (isReified != ProtoBuf.TypeParameter.getDefaultInstance().getReified()) {
            newBuilder.setReified(isReified);
        }
        if (kmTypeParameter.getVariance() == KmVariance.IN) {
            newBuilder.setVariance(ProtoBuf.TypeParameter.Variance.IN);
        } else if (kmTypeParameter.getVariance() == KmVariance.OUT) {
            newBuilder.setVariance(ProtoBuf.TypeParameter.Variance.OUT);
        }
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder;
    }

    private static final ProtoBuf.Type.Argument.Builder writeTypeProjection(WriteContext writeContext, KmTypeProjection kmTypeProjection) {
        ProtoBuf.Type.Argument.Builder newBuilder = ProtoBuf.Type.Argument.newBuilder();
        if (Intrinsics.areEqual(kmTypeProjection, KmTypeProjection.STAR)) {
            newBuilder.setProjection(ProtoBuf.Type.Argument.Projection.STAR);
        } else {
            KmVariance component1 = kmTypeProjection.component1();
            KmType component2 = kmTypeProjection.component2();
            if (component1 == null || component2 == null) {
                throw new InconsistentKotlinMetadataException("Variance and type must be set for non-star type projection", null, 2, null);
            }
            if (component1 == KmVariance.IN) {
                newBuilder.setProjection(ProtoBuf.Type.Argument.Projection.IN);
            } else if (component1 == KmVariance.OUT) {
                newBuilder.setProjection(ProtoBuf.Type.Argument.Projection.OUT);
            }
            newBuilder.setType(writeType(writeContext, component2).build());
        }
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProtoBuf.Type.Builder writeType(WriteContext writeContext, KmType kmType) {
        ProtoBuf.Type.Builder newBuilder = ProtoBuf.Type.newBuilder();
        KmClassifier classifier = kmType.getClassifier();
        if (classifier instanceof KmClassifier.Class) {
            newBuilder.setClassName(writeContext.getClassName$kotlinx_metadata(((KmClassifier.Class) classifier).getName()));
        } else if (classifier instanceof KmClassifier.TypeAlias) {
            newBuilder.setTypeAliasName(writeContext.getClassName$kotlinx_metadata(((KmClassifier.TypeAlias) classifier).getName()));
        } else if (classifier instanceof KmClassifier.TypeParameter) {
            newBuilder.setTypeParameter(((KmClassifier.TypeParameter) classifier).getId());
        }
        for (KmTypeProjection kmTypeProjection : kmType.getArguments()) {
            newBuilder.addArgument(writeTypeProjection(writeContext, kmTypeProjection));
        }
        KmType abbreviatedType = kmType.getAbbreviatedType();
        if (abbreviatedType != null) {
            newBuilder.setAbbreviatedType(writeType(writeContext, abbreviatedType).build());
        }
        KmType outerType = kmType.getOuterType();
        if (outerType != null) {
            newBuilder.setOuterType(writeType(writeContext, outerType).build());
        }
        KmFlexibleTypeUpperBound flexibleTypeUpperBound = kmType.getFlexibleTypeUpperBound();
        if (flexibleTypeUpperBound != null) {
            ProtoBuf.Type.Builder writeType = writeType(writeContext, flexibleTypeUpperBound.getType());
            String typeFlexibilityId = flexibleTypeUpperBound.getTypeFlexibilityId();
            if (typeFlexibilityId != null) {
                newBuilder.setFlexibleTypeCapabilitiesId(writeContext.get(typeFlexibilityId));
            }
            newBuilder.setFlexibleUpperBound(writeType.build());
        }
        for (MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlinx_metadata()) {
            Intrinsics.checkNotNull(newBuilder);
            metadataExtensions.writeTypeExtensions(kmType, newBuilder, writeContext);
        }
        if (Attributes.isNullable(kmType)) {
            newBuilder.setNullable(true);
        }
        int flags = kmType.getFlags() >> 1;
        if (flags != ProtoBuf.Type.getDefaultInstance().getFlags()) {
            newBuilder.setFlags(flags);
        }
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProtoBuf.Constructor.Builder writeConstructor(WriteContext writeContext, KmConstructor kmConstructor) {
        ProtoBuf.Constructor.Builder newBuilder = ProtoBuf.Constructor.newBuilder();
        for (KmValueParameter kmValueParameter : kmConstructor.getValueParameters()) {
            newBuilder.addValueParameter(writeValueParameter(writeContext, kmValueParameter).build());
        }
        ArrayList arrayList = new ArrayList();
        for (KmVersionRequirement kmVersionRequirement : kmConstructor.getVersionRequirements()) {
            Integer writeVersionRequirement = writeVersionRequirement(writeContext, kmVersionRequirement);
            if (writeVersionRequirement != null) {
                arrayList.add(writeVersionRequirement);
            }
        }
        newBuilder.addAllVersionRequirement(arrayList);
        for (MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlinx_metadata()) {
            Intrinsics.checkNotNull(newBuilder);
            metadataExtensions.writeConstructorExtensions(kmConstructor, newBuilder, writeContext);
        }
        if (kmConstructor.getFlags() != ProtoBuf.Constructor.getDefaultInstance().getFlags()) {
            newBuilder.setFlags(kmConstructor.getFlags());
        }
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProtoBuf.Function.Builder writeFunction(WriteContext writeContext, KmFunction kmFunction) {
        ProtoBuf.Function.Builder newBuilder = ProtoBuf.Function.newBuilder();
        List<KmTypeParameter> typeParameters = kmFunction.getTypeParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        for (KmTypeParameter kmTypeParameter : typeParameters) {
            arrayList.add(writeTypeParameter(writeContext, kmTypeParameter).build());
        }
        newBuilder.addAllTypeParameter(arrayList);
        KmType receiverParameterType = kmFunction.getReceiverParameterType();
        if (receiverParameterType != null) {
            newBuilder.setReceiverType(writeType(writeContext, receiverParameterType).build());
        }
        List<KmType> contextReceiverTypes = kmFunction.getContextReceiverTypes();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(contextReceiverTypes, 10));
        for (KmType kmType : contextReceiverTypes) {
            arrayList2.add(writeType(writeContext, kmType).build());
        }
        newBuilder.addAllContextReceiverType(arrayList2);
        List<KmValueParameter> valueParameters = kmFunction.getValueParameters();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(valueParameters, 10));
        for (KmValueParameter kmValueParameter : valueParameters) {
            arrayList3.add(writeValueParameter(writeContext, kmValueParameter).build());
        }
        newBuilder.addAllValueParameter(arrayList3);
        newBuilder.setReturnType(writeType(writeContext, kmFunction.getReturnType()).build());
        ArrayList arrayList4 = new ArrayList();
        for (KmVersionRequirement kmVersionRequirement : kmFunction.getVersionRequirements()) {
            Integer writeVersionRequirement = writeVersionRequirement(writeContext, kmVersionRequirement);
            if (writeVersionRequirement != null) {
                arrayList4.add(writeVersionRequirement);
            }
        }
        newBuilder.addAllVersionRequirement(arrayList4);
        KmContract contract = kmFunction.getContract();
        if (contract != null) {
            newBuilder.setContract(writeContract(writeContext, contract));
        }
        for (MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlinx_metadata()) {
            Intrinsics.checkNotNull(newBuilder);
            metadataExtensions.writeFunctionExtensions(kmFunction, newBuilder, writeContext);
        }
        newBuilder.setName(writeContext.get(kmFunction.getName()));
        if (kmFunction.getFlags() != ProtoBuf.Function.getDefaultInstance().getFlags()) {
            newBuilder.setFlags(kmFunction.getFlags());
        }
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder;
    }

    public static final ProtoBuf.Property.Builder writeProperty(WriteContext writeContext, KmProperty kmProperty) {
        Intrinsics.checkNotNullParameter(writeContext, "<this>");
        Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        ProtoBuf.Property.Builder newBuilder = ProtoBuf.Property.newBuilder();
        for (KmTypeParameter kmTypeParameter : kmProperty.getTypeParameters()) {
            newBuilder.addTypeParameter(writeTypeParameter(writeContext, kmTypeParameter).build());
        }
        KmType receiverParameterType = kmProperty.getReceiverParameterType();
        if (receiverParameterType != null) {
            newBuilder.setReceiverType(writeType(writeContext, receiverParameterType).build());
        }
        List<KmType> contextReceiverTypes = kmProperty.getContextReceiverTypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(contextReceiverTypes, 10));
        for (KmType kmType : contextReceiverTypes) {
            arrayList.add(writeType(writeContext, kmType).build());
        }
        newBuilder.addAllContextReceiverType(arrayList);
        KmValueParameter setterParameter = kmProperty.getSetterParameter();
        if (setterParameter != null) {
            newBuilder.setSetterValueParameter(writeValueParameter(writeContext, setterParameter).build());
        }
        newBuilder.setReturnType(writeType(writeContext, kmProperty.getReturnType()).build());
        ArrayList arrayList2 = new ArrayList();
        for (KmVersionRequirement kmVersionRequirement : kmProperty.getVersionRequirements()) {
            Integer writeVersionRequirement = writeVersionRequirement(writeContext, kmVersionRequirement);
            if (writeVersionRequirement != null) {
                arrayList2.add(writeVersionRequirement);
            }
        }
        newBuilder.addAllVersionRequirement(arrayList2);
        for (MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlinx_metadata()) {
            Intrinsics.checkNotNull(newBuilder);
            metadataExtensions.writePropertyExtensions(kmProperty, newBuilder, writeContext);
        }
        newBuilder.setName(writeContext.get(kmProperty.getName()));
        if (kmProperty.getFlags() != ProtoBuf.Property.getDefaultInstance().getFlags()) {
            newBuilder.setFlags(kmProperty.getFlags());
        }
        newBuilder.setGetterFlags(kmProperty.getGetter().getFlags$kotlinx_metadata());
        if (kmProperty.getSetter() != null) {
            KmPropertyAccessorAttributes setter = kmProperty.getSetter();
            Intrinsics.checkNotNull(setter);
            newBuilder.setSetterFlags(setter.getFlags$kotlinx_metadata());
        }
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder;
    }

    private static final ProtoBuf.ValueParameter.Builder writeValueParameter(WriteContext writeContext, KmValueParameter kmValueParameter) {
        ProtoBuf.ValueParameter.Builder newBuilder = ProtoBuf.ValueParameter.newBuilder();
        newBuilder.setType(writeType(writeContext, kmValueParameter.getType()).build());
        KmType varargElementType = kmValueParameter.getVarargElementType();
        if (varargElementType != null) {
            newBuilder.setVarargElementType(writeType(writeContext, varargElementType).build());
        }
        for (MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlinx_metadata()) {
            Intrinsics.checkNotNull(newBuilder);
            metadataExtensions.writeValueParameterExtensions(kmValueParameter, newBuilder, writeContext);
        }
        if (kmValueParameter.getFlags() != ProtoBuf.ValueParameter.getDefaultInstance().getFlags()) {
            newBuilder.setFlags(kmValueParameter.getFlags());
        }
        newBuilder.setName(writeContext.get(kmValueParameter.getName()));
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProtoBuf.TypeAlias.Builder writeTypeAlias(WriteContext writeContext, KmTypeAlias kmTypeAlias) {
        ProtoBuf.TypeAlias.Builder newBuilder = ProtoBuf.TypeAlias.newBuilder();
        List<KmTypeParameter> typeParameters = kmTypeAlias.getTypeParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        for (KmTypeParameter kmTypeParameter : typeParameters) {
            arrayList.add(writeTypeParameter(writeContext, kmTypeParameter).build());
        }
        newBuilder.addAllTypeParameter(arrayList);
        newBuilder.setUnderlyingType(writeType(writeContext, kmTypeAlias.getUnderlyingType()).build());
        newBuilder.setExpandedType(writeType(writeContext, kmTypeAlias.getExpandedType()).build());
        List<KmAnnotation> annotations = kmTypeAlias.getAnnotations();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(annotations, 10));
        for (KmAnnotation kmAnnotation : annotations) {
            arrayList2.add(WriteUtilsKt.writeAnnotation(kmAnnotation, writeContext.getStrings()).build());
        }
        newBuilder.addAllAnnotation(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (KmVersionRequirement kmVersionRequirement : kmTypeAlias.getVersionRequirements()) {
            Integer writeVersionRequirement = writeVersionRequirement(writeContext, kmVersionRequirement);
            if (writeVersionRequirement != null) {
                arrayList3.add(writeVersionRequirement);
            }
        }
        newBuilder.addAllVersionRequirement(arrayList3);
        for (MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlinx_metadata()) {
            Intrinsics.checkNotNull(newBuilder);
            metadataExtensions.writeTypeAliasExtensions(kmTypeAlias, newBuilder, writeContext);
        }
        if (kmTypeAlias.getFlags() != ProtoBuf.TypeAlias.getDefaultInstance().getFlags()) {
            newBuilder.setFlags(kmTypeAlias.getFlags());
        }
        newBuilder.setName(writeContext.get(kmTypeAlias.getName()));
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer writeVersionRequirement(WriteContext writeContext, KmVersionRequirement kmVersionRequirement) {
        ProtoBuf.VersionRequirement.VersionKind versionKind;
        ProtoBuf.VersionRequirement.Level level;
        KmVersionRequirementVersionKind kind = kmVersionRequirement.getKind();
        KmVersionRequirementLevel level2 = kmVersionRequirement.getLevel();
        Integer errorCode = kmVersionRequirement.getErrorCode();
        String message = kmVersionRequirement.getMessage();
        final ProtoBuf.VersionRequirement.Builder newBuilder = ProtoBuf.VersionRequirement.newBuilder();
        int i = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        if (i == 1) {
            versionKind = ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION;
        } else if (i == 2) {
            versionKind = ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION;
        } else if (i != 3) {
            if (i == 4) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        } else {
            versionKind = ProtoBuf.VersionRequirement.VersionKind.API_VERSION;
        }
        if (versionKind != newBuilder.getDefaultInstanceForType().getVersionKind()) {
            newBuilder.setVersionKind(versionKind);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$1[level2.ordinal()];
        if (i2 == 1) {
            level = ProtoBuf.VersionRequirement.Level.WARNING;
        } else if (i2 == 2) {
            level = ProtoBuf.VersionRequirement.Level.ERROR;
        } else if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            level = ProtoBuf.VersionRequirement.Level.HIDDEN;
        }
        if (level != newBuilder.getDefaultInstanceForType().getLevel()) {
            newBuilder.setLevel(level);
        }
        if (errorCode != null) {
            newBuilder.setErrorCode(errorCode.intValue());
        }
        if (message != null) {
            newBuilder.setMessage(writeContext.get(message));
        }
        KmVersion version = kmVersionRequirement.getVersion();
        new VersionRequirement.Version(version.component1(), version.component2(), version.component3()).encode(new Function1<Integer, Unit>() { // from class: kotlinx.metadata.internal.WritersKt$writeVersionRequirement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                ProtoBuf.VersionRequirement.Builder builder = ProtoBuf.VersionRequirement.Builder.this;
                Intrinsics.checkNotNull(builder);
                builder.setVersion(i3);
            }
        }, new Function1<Integer, Unit>() { // from class: kotlinx.metadata.internal.WritersKt$writeVersionRequirement$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                ProtoBuf.VersionRequirement.Builder builder = ProtoBuf.VersionRequirement.Builder.this;
                Intrinsics.checkNotNull(builder);
                builder.setVersionFull(i3);
            }
        });
        MutableVersionRequirementTable versionRequirements$kotlinx_metadata = writeContext.getVersionRequirements$kotlinx_metadata();
        Intrinsics.checkNotNull(newBuilder);
        return Integer.valueOf(versionRequirements$kotlinx_metadata.get(newBuilder));
    }

    private static final ProtoBuf.Contract writeContract(WriteContext writeContext, KmContract kmContract) {
        ProtoBuf.Contract.Builder newBuilder = ProtoBuf.Contract.newBuilder();
        List<KmEffect> effects = kmContract.getEffects();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(effects, 10));
        for (KmEffect kmEffect : effects) {
            arrayList.add(writeEffect(writeContext, kmEffect));
        }
        newBuilder.addAllEffect(arrayList);
        ProtoBuf.Contract build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private static final ProtoBuf.Effect writeEffect(WriteContext writeContext, KmEffect kmEffect) {
        ProtoBuf.Effect.Builder newBuilder = ProtoBuf.Effect.newBuilder();
        List<KmEffectExpression> constructorArguments = kmEffect.getConstructorArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(constructorArguments, 10));
        for (KmEffectExpression kmEffectExpression : constructorArguments) {
            arrayList.add(writeEffectExpression(writeContext, kmEffectExpression));
        }
        newBuilder.addAllEffectConstructorArgument(arrayList);
        KmEffectExpression conclusion = kmEffect.getConclusion();
        if (conclusion != null) {
            newBuilder.setConclusionOfConditionalEffect(writeEffectExpression(writeContext, conclusion));
        }
        int i = WhenMappings.$EnumSwitchMapping$2[kmEffect.getType().ordinal()];
        if (i == 1) {
            newBuilder.setEffectType(ProtoBuf.Effect.EffectType.RETURNS_CONSTANT);
        } else if (i == 2) {
            newBuilder.setEffectType(ProtoBuf.Effect.EffectType.CALLS);
        } else if (i == 3) {
            newBuilder.setEffectType(ProtoBuf.Effect.EffectType.RETURNS_NOT_NULL);
        }
        KmEffectInvocationKind invocationKind = kmEffect.getInvocationKind();
        int i2 = invocationKind == null ? -1 : WhenMappings.$EnumSwitchMapping$3[invocationKind.ordinal()];
        if (i2 == 1) {
            newBuilder.setKind(ProtoBuf.Effect.InvocationKind.AT_MOST_ONCE);
        } else if (i2 == 2) {
            newBuilder.setKind(ProtoBuf.Effect.InvocationKind.EXACTLY_ONCE);
        } else if (i2 == 3) {
            newBuilder.setKind(ProtoBuf.Effect.InvocationKind.AT_LEAST_ONCE);
        }
        ProtoBuf.Effect build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private static final ProtoBuf.Expression writeEffectExpression(WriteContext writeContext, KmEffectExpression kmEffectExpression) {
        ProtoBuf.Expression.Builder newBuilder = ProtoBuf.Expression.newBuilder();
        if (kmEffectExpression.getFlags() != ProtoBuf.Expression.getDefaultInstance().getFlags()) {
            newBuilder.setFlags(kmEffectExpression.getFlags());
        }
        Integer parameterIndex = kmEffectExpression.getParameterIndex();
        if (parameterIndex != null) {
            newBuilder.setValueParameterReference(parameterIndex.intValue());
        }
        KmConstantValue constantValue = kmEffectExpression.getConstantValue();
        if (constantValue != null) {
            Object value = constantValue.getValue();
            if (Intrinsics.areEqual(value, (Object) true)) {
                newBuilder.setConstantValue(ProtoBuf.Expression.ConstantValue.TRUE);
            } else if (Intrinsics.areEqual(value, (Object) false)) {
                newBuilder.setConstantValue(ProtoBuf.Expression.ConstantValue.FALSE);
            } else if (value == null) {
                newBuilder.setConstantValue(ProtoBuf.Expression.ConstantValue.NULL);
            } else {
                throw new IllegalArgumentException("Only true, false or null constant values are allowed for effects (was=" + value + ')');
            }
        }
        KmType isInstanceType = kmEffectExpression.isInstanceType();
        if (isInstanceType != null) {
            newBuilder.setIsInstanceType(writeType(writeContext, isInstanceType).build());
        }
        List<KmEffectExpression> andArguments = kmEffectExpression.getAndArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(andArguments, 10));
        for (KmEffectExpression kmEffectExpression2 : andArguments) {
            arrayList.add(writeEffectExpression(writeContext, kmEffectExpression2));
        }
        newBuilder.addAllAndArgument(arrayList);
        List<KmEffectExpression> orArguments = kmEffectExpression.getOrArguments();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(orArguments, 10));
        for (KmEffectExpression kmEffectExpression3 : orArguments) {
            arrayList2.add(writeEffectExpression(writeContext, kmEffectExpression3));
        }
        newBuilder.addAllOrArgument(arrayList2);
        ProtoBuf.Expression build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}
