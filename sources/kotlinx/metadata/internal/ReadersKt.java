package kotlinx.metadata.internal;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.Iterator;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.InconsistentKotlinMetadataException;
import kotlinx.metadata.KmAnnotation;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmClassifier;
import kotlinx.metadata.KmConstantValue;
import kotlinx.metadata.KmConstructor;
import kotlinx.metadata.KmContract;
import kotlinx.metadata.KmDeclarationContainer;
import kotlinx.metadata.KmEffect;
import kotlinx.metadata.KmEffectExpression;
import kotlinx.metadata.KmEffectInvocationKind;
import kotlinx.metadata.KmEffectType;
import kotlinx.metadata.KmFlexibleTypeUpperBound;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmLambda;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.KmProperty;
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
import kotlinx.metadata.internal.common.KmModuleFragment;
import kotlinx.metadata.internal.extensions.MetadataExtensions;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
import kotlinx.metadata.internal.metadata.deserialization.NameResolver;
import kotlinx.metadata.internal.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlinx.metadata.internal.metadata.deserialization.TypeTable;
import kotlinx.metadata.internal.metadata.deserialization.VersionRequirement;
import kotlinx.metadata.internal.metadata.deserialization.VersionRequirementTable;
/* compiled from: Readers.kt */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0011\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a,\u0010\u0015\u001a\u00020\u0016*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u001a\u0014\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0014\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003\u001a&\u0010$\u001a\u00020%*\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003\u001a\u0014\u0010+\u001a\u00020,*\u00020-2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003\u001a\u0014\u0010.\u001a\u00020/*\u0002002\u0006\u00101\u001a\u00020\u000fH\u0002\u001a\u001c\u00102\u001a\u000203*\u0002002\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\"\u00104\u001a\u000205*\u0002062\u0006\u0010\u0017\u001a\u00020\u00182\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u001a,\u00107\u001a\u000208*\u0002092\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u001a\u0012\u0010:\u001a\u00020;*\u00020\u00112\u0006\u00101\u001a\u00020\u000f\u001a\u0014\u0010<\u001a\u00020=*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0014\u0010>\u001a\u00020?*\u00020@2\u0006\u00101\u001a\u00020\u000fH\u0002\u001a\u0014\u0010A\u001a\u00020B*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0014\u0010C\u001a\u00020D*\u00020E2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a>\u0010F\u001a\u00020G*\u00020H2\f\u0010I\u001a\b\u0012\u0004\u0012\u0002000\u001c2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020@0\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006L"}, d2 = {"typeFlags", "", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Type;", "getTypeFlags", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;)I", "typeParameterFlags", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter;", "getTypeParameterFlags", "(Lorg/jetbrains/kotlin/metadata/ProtoBuf$TypeParameter;)I", "getDefaultPropertyAccessorFlags", DownloaderServiceMarshaller.PARAMS_FLAGS, "readVersionRequirement", "Lkotlinx/metadata/KmVersionRequirement;", "id", "c", "Lkotlinx/metadata/internal/ReadContext;", "getPropertyGetterFlags", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Property;", "getPropertySetterFlags", "loadInlineClassUnderlyingType", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Class;", "toKmClass", "Lkotlinx/metadata/KmClass;", "strings", "Lkotlinx/metadata/internal/metadata/deserialization/NameResolver;", "ignoreUnknownVersionRequirements", "", "contextExtensions", "", "Lkotlinx/metadata/internal/ReadContextExtension;", "toKmConstructor", "Lkotlinx/metadata/KmConstructor;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Constructor;", "toKmContract", "Lkotlinx/metadata/KmContract;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Contract;", "toKmEffect", "Lkotlinx/metadata/KmEffect;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Effect;", "type", "Lkotlinx/metadata/KmEffectType;", "kind", "Lkotlinx/metadata/KmEffectInvocationKind;", "toKmEffectExpression", "Lkotlinx/metadata/KmEffectExpression;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Expression;", "toKmFunction", "Lkotlinx/metadata/KmFunction;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Function;", "outer", "toKmLambda", "Lkotlinx/metadata/KmLambda;", "toKmModuleFragment", "Lkotlinx/metadata/internal/common/KmModuleFragment;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment;", "toKmPackage", "Lkotlinx/metadata/KmPackage;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$Package;", "toKmProperty", "Lkotlinx/metadata/KmProperty;", "toKmType", "Lkotlinx/metadata/KmType;", "toKmTypeAlias", "Lkotlinx/metadata/KmTypeAlias;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias;", "toKmTypeParameter", "Lkotlinx/metadata/KmTypeParameter;", "toKmValueParameter", "Lkotlinx/metadata/KmValueParameter;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter;", "visitDeclarations", "", "Lkotlinx/metadata/KmDeclarationContainer;", "protoFunctions", "protoProperties", "protoTypeAliases", "kotlinx-metadata"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReadersKt {

    /* compiled from: Readers.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            int[] iArr = new int[ProtoBuf.TypeParameter.Variance.values().length];
            try {
                iArr[ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ProtoBuf.Type.Argument.Projection.values().length];
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ProtoBuf.VersionRequirement.VersionKind.values().length];
            try {
                iArr3[ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ProtoBuf.VersionRequirement.VersionKind.API_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[DeprecationLevel.values().length];
            try {
                iArr4[DeprecationLevel.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[DeprecationLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[DeprecationLevel.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[ProtoBuf.Effect.EffectType.values().length];
            try {
                iArr5[ProtoBuf.Effect.EffectType.RETURNS_CONSTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr5[ProtoBuf.Effect.EffectType.CALLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr5[ProtoBuf.Effect.EffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[ProtoBuf.Effect.InvocationKind.values().length];
            try {
                iArr6[ProtoBuf.Effect.InvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr6[ProtoBuf.Effect.InvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr6[ProtoBuf.Effect.InvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[ProtoBuf.Expression.ConstantValue.values().length];
            try {
                iArr7[ProtoBuf.Expression.ConstantValue.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr7[ProtoBuf.Expression.ConstantValue.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr7[ProtoBuf.Expression.ConstantValue.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            $EnumSwitchMapping$6 = iArr7;
        }
    }

    public static /* synthetic */ KmClass toKmClass$default(ProtoBuf.Class r0, NameResolver nameResolver, boolean z, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return toKmClass(r0, nameResolver, z, list);
    }

    public static final KmClass toKmClass(ProtoBuf.Class r10, NameResolver strings, boolean z, List<? extends ReadContextExtension> contextExtensions) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        KmClass kmClass = new KmClass();
        ProtoBuf.TypeTable typeTable = r10.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable versionRequirementTable = r10.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
        ReadContext readContext = new ReadContext(strings, typeTable2, companion.create(versionRequirementTable), z, null, contextExtensions, 16, null);
        List<ProtoBuf.TypeParameter> typeParameterList = r10.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        ReadContext withTypeParameters$kotlinx_metadata = readContext.withTypeParameters$kotlinx_metadata(typeParameterList);
        kmClass.setFlags(r10.getFlags());
        kmClass.setName(withTypeParameters$kotlinx_metadata.className$kotlinx_metadata(r10.getFqName()));
        List<ProtoBuf.TypeParameter> typeParameterList2 = r10.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        List<KmTypeParameter> typeParameters = kmClass.getTypeParameters();
        for (ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            Intrinsics.checkNotNull(typeParameter);
            typeParameters.add(toKmTypeParameter(typeParameter, withTypeParameters$kotlinx_metadata));
        }
        List<KmType> supertypes = kmClass.getSupertypes();
        for (ProtoBuf.Type type : ProtoTypeTableUtilKt.supertypes(r10, withTypeParameters$kotlinx_metadata.getTypes())) {
            supertypes.add(toKmType(type, withTypeParameters$kotlinx_metadata));
        }
        List<ProtoBuf.Constructor> constructorList = r10.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(constructorList, "getConstructorList(...)");
        List<KmConstructor> constructors = kmClass.getConstructors();
        for (ProtoBuf.Constructor constructor : constructorList) {
            Intrinsics.checkNotNull(constructor);
            constructors.add(toKmConstructor(constructor, withTypeParameters$kotlinx_metadata));
        }
        List<ProtoBuf.Function> functionList = r10.getFunctionList();
        Intrinsics.checkNotNullExpressionValue(functionList, "getFunctionList(...)");
        List<ProtoBuf.Property> propertyList = r10.getPropertyList();
        Intrinsics.checkNotNullExpressionValue(propertyList, "getPropertyList(...)");
        List<ProtoBuf.TypeAlias> typeAliasList = r10.getTypeAliasList();
        Intrinsics.checkNotNullExpressionValue(typeAliasList, "getTypeAliasList(...)");
        visitDeclarations(kmClass, functionList, propertyList, typeAliasList, withTypeParameters$kotlinx_metadata);
        if (r10.hasCompanionObjectName()) {
            kmClass.setCompanionObject(withTypeParameters$kotlinx_metadata.get(r10.getCompanionObjectName()));
        }
        List<Integer> nestedClassNameList = r10.getNestedClassNameList();
        Intrinsics.checkNotNullExpressionValue(nestedClassNameList, "getNestedClassNameList(...)");
        List<String> nestedClasses = kmClass.getNestedClasses();
        for (Integer num : nestedClassNameList) {
            Intrinsics.checkNotNull(num);
            nestedClasses.add(withTypeParameters$kotlinx_metadata.get(num.intValue()));
        }
        Iterator<ProtoBuf.EnumEntry> it = r10.getEnumEntryList().iterator();
        while (true) {
            if (it.hasNext()) {
                ProtoBuf.EnumEntry next = it.next();
                if (!next.hasName()) {
                    throw new InconsistentKotlinMetadataException("No name for EnumEntry", null, 2, null);
                }
                kmClass.getEnumEntries().add(withTypeParameters$kotlinx_metadata.get(next.getName()));
            } else {
                List<Integer> sealedSubclassFqNameList = r10.getSealedSubclassFqNameList();
                Intrinsics.checkNotNullExpressionValue(sealedSubclassFqNameList, "getSealedSubclassFqNameList(...)");
                List<String> sealedSubclasses = kmClass.getSealedSubclasses();
                for (Integer num2 : sealedSubclassFqNameList) {
                    Intrinsics.checkNotNull(num2);
                    sealedSubclasses.add(withTypeParameters$kotlinx_metadata.className$kotlinx_metadata(num2.intValue()));
                }
                if (r10.hasInlineClassUnderlyingPropertyName()) {
                    kmClass.setInlineClassUnderlyingPropertyName(withTypeParameters$kotlinx_metadata.get(r10.getInlineClassUnderlyingPropertyName()));
                }
                ProtoBuf.Type loadInlineClassUnderlyingType = loadInlineClassUnderlyingType(r10, withTypeParameters$kotlinx_metadata);
                kmClass.setInlineClassUnderlyingType(loadInlineClassUnderlyingType != null ? toKmType(loadInlineClassUnderlyingType, withTypeParameters$kotlinx_metadata) : null);
                List<KmType> contextReceiverTypes = kmClass.getContextReceiverTypes();
                for (ProtoBuf.Type type2 : ProtoTypeTableUtilKt.contextReceiverTypes(r10, withTypeParameters$kotlinx_metadata.getTypes())) {
                    contextReceiverTypes.add(toKmType(type2, withTypeParameters$kotlinx_metadata));
                }
                List<Integer> versionRequirementList = r10.getVersionRequirementList();
                Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
                List<KmVersionRequirement> versionRequirements = kmClass.getVersionRequirements();
                for (Integer num3 : versionRequirementList) {
                    Intrinsics.checkNotNull(num3);
                    versionRequirements.add(readVersionRequirement(num3.intValue(), withTypeParameters$kotlinx_metadata));
                }
                for (MetadataExtensions metadataExtensions : withTypeParameters$kotlinx_metadata.getExtensions$kotlinx_metadata()) {
                    metadataExtensions.readClassExtensions(kmClass, r10, withTypeParameters$kotlinx_metadata);
                }
                return kmClass;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
        if (r2 == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final ProtoBuf.Type loadInlineClassUnderlyingType(ProtoBuf.Class r7, ReadContext readContext) {
        ProtoBuf.Type inlineClassUnderlyingType = ProtoTypeTableUtilKt.inlineClassUnderlyingType(r7, readContext.getTypes());
        if (inlineClassUnderlyingType != null) {
            return inlineClassUnderlyingType;
        }
        if (r7.hasInlineClassUnderlyingPropertyName()) {
            List<ProtoBuf.Property> propertyList = r7.getPropertyList();
            Intrinsics.checkNotNullExpressionValue(propertyList, "getPropertyList(...)");
            Iterator<T> it = propertyList.iterator();
            boolean z = false;
            Object obj = null;
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    ProtoBuf.Property property = (ProtoBuf.Property) next;
                    Intrinsics.checkNotNull(property);
                    if (ProtoTypeTableUtilKt.receiverType(property, readContext.getTypes()) == null && Intrinsics.areEqual(readContext.get(property.getName()), readContext.get(r7.getInlineClassUnderlyingPropertyName()))) {
                        if (z) {
                            break;
                        }
                        z = true;
                        obj = next;
                    }
                }
            }
            obj = null;
            ProtoBuf.Property property2 = (ProtoBuf.Property) obj;
            if (property2 != null) {
                return ProtoTypeTableUtilKt.returnType(property2, readContext.getTypes());
            }
            return null;
        }
        return null;
    }

    public static /* synthetic */ KmPackage toKmPackage$default(ProtoBuf.Package r0, NameResolver nameResolver, boolean z, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return toKmPackage(r0, nameResolver, z, list);
    }

    public static final KmPackage toKmPackage(ProtoBuf.Package r10, NameResolver strings, boolean z, List<? extends ReadContextExtension> contextExtensions) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        KmPackage kmPackage = new KmPackage();
        ProtoBuf.TypeTable typeTable = r10.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable versionRequirementTable = r10.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
        ReadContext readContext = new ReadContext(strings, typeTable2, companion.create(versionRequirementTable), z, null, contextExtensions, 16, null);
        List<ProtoBuf.Function> functionList = r10.getFunctionList();
        Intrinsics.checkNotNullExpressionValue(functionList, "getFunctionList(...)");
        List<ProtoBuf.Property> propertyList = r10.getPropertyList();
        Intrinsics.checkNotNullExpressionValue(propertyList, "getPropertyList(...)");
        List<ProtoBuf.TypeAlias> typeAliasList = r10.getTypeAliasList();
        Intrinsics.checkNotNullExpressionValue(typeAliasList, "getTypeAliasList(...)");
        visitDeclarations(kmPackage, functionList, propertyList, typeAliasList, readContext);
        for (MetadataExtensions metadataExtensions : readContext.getExtensions$kotlinx_metadata()) {
            metadataExtensions.readPackageExtensions(kmPackage, r10, readContext);
        }
        return kmPackage;
    }

    public static /* synthetic */ KmModuleFragment toKmModuleFragment$default(ProtoBuf.PackageFragment packageFragment, NameResolver nameResolver, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return toKmModuleFragment(packageFragment, nameResolver, list);
    }

    public static final KmModuleFragment toKmModuleFragment(ProtoBuf.PackageFragment packageFragment, NameResolver strings, List<? extends ReadContextExtension> contextExtensions) {
        Intrinsics.checkNotNullParameter(packageFragment, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        KmModuleFragment kmModuleFragment = new KmModuleFragment();
        ProtoBuf.TypeTable build = ProtoBuf.TypeTable.newBuilder().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        ReadContext readContext = new ReadContext(strings, new TypeTable(build), VersionRequirementTable.Companion.getEMPTY(), false, null, contextExtensions, 16, null);
        ProtoBuf.Package r11 = packageFragment.getPackage();
        Intrinsics.checkNotNullExpressionValue(r11, "getPackage(...)");
        kmModuleFragment.setPkg(toKmPackage(r11, strings, false, contextExtensions));
        List<ProtoBuf.Class> class_List = packageFragment.getClass_List();
        Intrinsics.checkNotNullExpressionValue(class_List, "getClass_List(...)");
        List<KmClass> classes = kmModuleFragment.getClasses();
        for (ProtoBuf.Class r4 : class_List) {
            Intrinsics.checkNotNull(r4);
            classes.add(toKmClass(r4, strings, false, contextExtensions));
        }
        for (MetadataExtensions metadataExtensions : readContext.getExtensions$kotlinx_metadata()) {
            metadataExtensions.readModuleFragmentExtensions(kmModuleFragment, packageFragment, readContext);
        }
        return kmModuleFragment;
    }

    private static final void visitDeclarations(KmDeclarationContainer kmDeclarationContainer, List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3, ReadContext readContext) {
        List<KmFunction> functions = kmDeclarationContainer.getFunctions();
        for (ProtoBuf.Function function : list) {
            functions.add(toKmFunction(function, readContext));
        }
        List<KmProperty> properties = kmDeclarationContainer.getProperties();
        for (ProtoBuf.Property property : list2) {
            properties.add(toKmProperty(property, readContext));
        }
        List<KmTypeAlias> typeAliases = kmDeclarationContainer.getTypeAliases();
        for (ProtoBuf.TypeAlias typeAlias : list3) {
            typeAliases.add(toKmTypeAlias(typeAlias, readContext));
        }
    }

    public static /* synthetic */ KmLambda toKmLambda$default(ProtoBuf.Function function, NameResolver nameResolver, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return toKmLambda(function, nameResolver, z);
    }

    public static final KmLambda toKmLambda(ProtoBuf.Function function, NameResolver strings, boolean z) {
        Intrinsics.checkNotNullParameter(function, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        KmLambda kmLambda = new KmLambda();
        ProtoBuf.TypeTable typeTable = function.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
        kmLambda.setFunction(toKmFunction(function, new ReadContext(strings, new TypeTable(typeTable), VersionRequirementTable.Companion.getEMPTY(), z, null, null, 48, null)));
        return kmLambda;
    }

    private static final KmConstructor toKmConstructor(ProtoBuf.Constructor constructor, ReadContext readContext) {
        KmConstructor kmConstructor = new KmConstructor(constructor.getFlags());
        List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        List<KmValueParameter> valueParameters = kmConstructor.getValueParameters();
        for (ProtoBuf.ValueParameter valueParameter : valueParameterList) {
            Intrinsics.checkNotNull(valueParameter);
            valueParameters.add(toKmValueParameter(valueParameter, readContext));
        }
        List<Integer> versionRequirementList = constructor.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
        List<KmVersionRequirement> versionRequirements = kmConstructor.getVersionRequirements();
        for (Integer num : versionRequirementList) {
            Intrinsics.checkNotNull(num);
            versionRequirements.add(readVersionRequirement(num.intValue(), readContext));
        }
        for (MetadataExtensions metadataExtensions : readContext.getExtensions$kotlinx_metadata()) {
            metadataExtensions.readConstructorExtensions(kmConstructor, constructor, readContext);
        }
        return kmConstructor;
    }

    private static final KmFunction toKmFunction(ProtoBuf.Function function, ReadContext readContext) {
        KmFunction kmFunction = new KmFunction(function.getFlags(), readContext.get(function.getName()));
        List<ProtoBuf.TypeParameter> typeParameterList = function.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        ReadContext withTypeParameters$kotlinx_metadata = readContext.withTypeParameters$kotlinx_metadata(typeParameterList);
        List<ProtoBuf.TypeParameter> typeParameterList2 = function.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        List<KmTypeParameter> typeParameters = kmFunction.getTypeParameters();
        for (ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            Intrinsics.checkNotNull(typeParameter);
            typeParameters.add(toKmTypeParameter(typeParameter, withTypeParameters$kotlinx_metadata));
        }
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(function, withTypeParameters$kotlinx_metadata.getTypes());
        kmFunction.setReceiverParameterType(receiverType != null ? toKmType(receiverType, withTypeParameters$kotlinx_metadata) : null);
        List<KmType> contextReceiverTypes = kmFunction.getContextReceiverTypes();
        for (ProtoBuf.Type type : ProtoTypeTableUtilKt.contextReceiverTypes(function, withTypeParameters$kotlinx_metadata.getTypes())) {
            contextReceiverTypes.add(toKmType(type, withTypeParameters$kotlinx_metadata));
        }
        List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        List<KmValueParameter> valueParameters = kmFunction.getValueParameters();
        for (ProtoBuf.ValueParameter valueParameter : valueParameterList) {
            Intrinsics.checkNotNull(valueParameter);
            valueParameters.add(toKmValueParameter(valueParameter, withTypeParameters$kotlinx_metadata));
        }
        kmFunction.setReturnType(toKmType(ProtoTypeTableUtilKt.returnType(function, withTypeParameters$kotlinx_metadata.getTypes()), withTypeParameters$kotlinx_metadata));
        if (function.hasContract()) {
            ProtoBuf.Contract contract = function.getContract();
            Intrinsics.checkNotNullExpressionValue(contract, "getContract(...)");
            kmFunction.setContract(toKmContract(contract, withTypeParameters$kotlinx_metadata));
        }
        List<Integer> versionRequirementList = function.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
        List<KmVersionRequirement> versionRequirements = kmFunction.getVersionRequirements();
        for (Integer num : versionRequirementList) {
            Intrinsics.checkNotNull(num);
            versionRequirements.add(readVersionRequirement(num.intValue(), withTypeParameters$kotlinx_metadata));
        }
        for (MetadataExtensions metadataExtensions : withTypeParameters$kotlinx_metadata.getExtensions$kotlinx_metadata()) {
            metadataExtensions.readFunctionExtensions(kmFunction, function, withTypeParameters$kotlinx_metadata);
        }
        return kmFunction;
    }

    public static final KmProperty toKmProperty(ProtoBuf.Property property, ReadContext outer) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(outer, "outer");
        KmProperty kmProperty = new KmProperty(property.getFlags(), outer.get(property.getName()), getPropertyGetterFlags(property), getPropertySetterFlags(property));
        List<ProtoBuf.TypeParameter> typeParameterList = property.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        ReadContext withTypeParameters$kotlinx_metadata = outer.withTypeParameters$kotlinx_metadata(typeParameterList);
        List<ProtoBuf.TypeParameter> typeParameterList2 = property.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        List<KmTypeParameter> typeParameters = kmProperty.getTypeParameters();
        for (ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            Intrinsics.checkNotNull(typeParameter);
            typeParameters.add(toKmTypeParameter(typeParameter, withTypeParameters$kotlinx_metadata));
        }
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(property, withTypeParameters$kotlinx_metadata.getTypes());
        kmProperty.setReceiverParameterType(receiverType != null ? toKmType(receiverType, withTypeParameters$kotlinx_metadata) : null);
        List<KmType> contextReceiverTypes = kmProperty.getContextReceiverTypes();
        for (ProtoBuf.Type type : ProtoTypeTableUtilKt.contextReceiverTypes(property, withTypeParameters$kotlinx_metadata.getTypes())) {
            contextReceiverTypes.add(toKmType(type, withTypeParameters$kotlinx_metadata));
        }
        if (property.hasSetterValueParameter()) {
            ProtoBuf.ValueParameter setterValueParameter = property.getSetterValueParameter();
            Intrinsics.checkNotNullExpressionValue(setterValueParameter, "getSetterValueParameter(...)");
            kmProperty.setSetterParameter(toKmValueParameter(setterValueParameter, withTypeParameters$kotlinx_metadata));
        }
        kmProperty.setReturnType(toKmType(ProtoTypeTableUtilKt.returnType(property, withTypeParameters$kotlinx_metadata.getTypes()), withTypeParameters$kotlinx_metadata));
        List<Integer> versionRequirementList = property.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
        List<KmVersionRequirement> versionRequirements = kmProperty.getVersionRequirements();
        for (Integer num : versionRequirementList) {
            Intrinsics.checkNotNull(num);
            versionRequirements.add(readVersionRequirement(num.intValue(), withTypeParameters$kotlinx_metadata));
        }
        for (MetadataExtensions metadataExtensions : withTypeParameters$kotlinx_metadata.getExtensions$kotlinx_metadata()) {
            metadataExtensions.readPropertyExtensions(kmProperty, property, withTypeParameters$kotlinx_metadata);
        }
        return kmProperty;
    }

    private static final KmTypeAlias toKmTypeAlias(ProtoBuf.TypeAlias typeAlias, ReadContext readContext) {
        KmTypeAlias kmTypeAlias = new KmTypeAlias(typeAlias.getFlags(), readContext.get(typeAlias.getName()));
        List<ProtoBuf.TypeParameter> typeParameterList = typeAlias.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        ReadContext withTypeParameters$kotlinx_metadata = readContext.withTypeParameters$kotlinx_metadata(typeParameterList);
        List<ProtoBuf.TypeParameter> typeParameterList2 = typeAlias.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        List<KmTypeParameter> typeParameters = kmTypeAlias.getTypeParameters();
        for (ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            Intrinsics.checkNotNull(typeParameter);
            typeParameters.add(toKmTypeParameter(typeParameter, withTypeParameters$kotlinx_metadata));
        }
        kmTypeAlias.setUnderlyingType(toKmType(ProtoTypeTableUtilKt.underlyingType(typeAlias, withTypeParameters$kotlinx_metadata.getTypes()), withTypeParameters$kotlinx_metadata));
        kmTypeAlias.setExpandedType(toKmType(ProtoTypeTableUtilKt.expandedType(typeAlias, withTypeParameters$kotlinx_metadata.getTypes()), withTypeParameters$kotlinx_metadata));
        List<ProtoBuf.Annotation> annotationList = typeAlias.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        List<KmAnnotation> annotations = kmTypeAlias.getAnnotations();
        for (ProtoBuf.Annotation annotation : annotationList) {
            Intrinsics.checkNotNull(annotation);
            annotations.add(ReadUtilsKt.readAnnotation(annotation, withTypeParameters$kotlinx_metadata.getStrings()));
        }
        List<Integer> versionRequirementList = typeAlias.getVersionRequirementList();
        Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
        List<KmVersionRequirement> versionRequirements = kmTypeAlias.getVersionRequirements();
        for (Integer num : versionRequirementList) {
            Intrinsics.checkNotNull(num);
            versionRequirements.add(readVersionRequirement(num.intValue(), withTypeParameters$kotlinx_metadata));
        }
        for (MetadataExtensions metadataExtensions : withTypeParameters$kotlinx_metadata.getExtensions$kotlinx_metadata()) {
            metadataExtensions.readTypeAliasExtensions(kmTypeAlias, typeAlias, withTypeParameters$kotlinx_metadata);
        }
        return kmTypeAlias;
    }

    private static final KmValueParameter toKmValueParameter(ProtoBuf.ValueParameter valueParameter, ReadContext readContext) {
        KmValueParameter kmValueParameter = new KmValueParameter(valueParameter.getFlags(), readContext.get(valueParameter.getName()));
        kmValueParameter.setType(toKmType(ProtoTypeTableUtilKt.type(valueParameter, readContext.getTypes()), readContext));
        ProtoBuf.Type varargElementType = ProtoTypeTableUtilKt.varargElementType(valueParameter, readContext.getTypes());
        kmValueParameter.setVarargElementType(varargElementType != null ? toKmType(varargElementType, readContext) : null);
        for (MetadataExtensions metadataExtensions : readContext.getExtensions$kotlinx_metadata()) {
            metadataExtensions.readValueParameterExtensions(kmValueParameter, valueParameter, readContext);
        }
        return kmValueParameter;
    }

    private static final KmTypeParameter toKmTypeParameter(ProtoBuf.TypeParameter typeParameter, ReadContext readContext) {
        KmVariance kmVariance;
        ProtoBuf.TypeParameter.Variance variance = typeParameter.getVariance();
        if (variance == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        int i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == 1) {
            kmVariance = KmVariance.IN;
        } else if (i == 2) {
            kmVariance = KmVariance.OUT;
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            kmVariance = KmVariance.INVARIANT;
        }
        KmTypeParameter kmTypeParameter = new KmTypeParameter(getTypeParameterFlags(typeParameter), readContext.get(typeParameter.getName()), typeParameter.getId(), kmVariance);
        List<KmType> upperBounds = kmTypeParameter.getUpperBounds();
        for (ProtoBuf.Type type : ProtoTypeTableUtilKt.upperBounds(typeParameter, readContext.getTypes())) {
            upperBounds.add(toKmType(type, readContext));
        }
        for (MetadataExtensions metadataExtensions : readContext.getExtensions$kotlinx_metadata()) {
            metadataExtensions.readTypeParameterExtensions(kmTypeParameter, typeParameter, readContext);
        }
        return kmTypeParameter;
    }

    private static final KmType toKmType(ProtoBuf.Type type, ReadContext readContext) {
        KmClassifier.TypeParameter typeParameter;
        KmType kmType;
        KmVariance kmVariance;
        KmType kmType2 = new KmType(getTypeFlags(type));
        KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = null;
        kmFlexibleTypeUpperBound = null;
        if (type.hasClassName()) {
            typeParameter = new KmClassifier.Class(readContext.className$kotlinx_metadata(type.getClassName()));
        } else if (type.hasTypeAliasName()) {
            typeParameter = new KmClassifier.TypeAlias(readContext.className$kotlinx_metadata(type.getTypeAliasName()));
        } else if (type.hasTypeParameter()) {
            typeParameter = new KmClassifier.TypeParameter(type.getTypeParameter());
        } else if (type.hasTypeParameterName()) {
            Integer typeParameterId$kotlinx_metadata = readContext.getTypeParameterId$kotlinx_metadata(type.getTypeParameterName());
            if (typeParameterId$kotlinx_metadata == null) {
                throw new InconsistentKotlinMetadataException("No type parameter id for " + readContext.get(type.getTypeParameterName()), null, 2, null);
            }
            typeParameter = new KmClassifier.TypeParameter(typeParameterId$kotlinx_metadata.intValue());
        } else {
            throw new InconsistentKotlinMetadataException("No classifier (class, type alias or type parameter) recorded for Type", null, 2, null);
        }
        kmType2.setClassifier(typeParameter);
        for (ProtoBuf.Type.Argument argument : type.getArgumentList()) {
            ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
            if (projection == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            int i = WhenMappings.$EnumSwitchMapping$1[projection.ordinal()];
            if (i == 1) {
                kmVariance = KmVariance.IN;
            } else if (i == 2) {
                kmVariance = KmVariance.OUT;
            } else if (i == 3) {
                kmVariance = KmVariance.INVARIANT;
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                kmVariance = null;
            }
            if (kmVariance != null) {
                Intrinsics.checkNotNull(argument);
                ProtoBuf.Type type2 = ProtoTypeTableUtilKt.type(argument, readContext.getTypes());
                if (type2 == null) {
                    throw new InconsistentKotlinMetadataException("No type argument for non-STAR projection in Type", null, 2, null);
                }
                kmType2.getArguments().add(new KmTypeProjection(kmVariance, toKmType(type2, readContext)));
            } else {
                kmType2.getArguments().add(KmTypeProjection.STAR);
            }
        }
        ProtoBuf.Type abbreviatedType = ProtoTypeTableUtilKt.abbreviatedType(type, readContext.getTypes());
        kmType2.setAbbreviatedType(abbreviatedType != null ? toKmType(abbreviatedType, readContext) : null);
        ProtoBuf.Type outerType = ProtoTypeTableUtilKt.outerType(type, readContext.getTypes());
        kmType2.setOuterType(outerType != null ? toKmType(outerType, readContext) : null);
        ProtoBuf.Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(type, readContext.getTypes());
        if (flexibleUpperBound != null && (kmType = toKmType(flexibleUpperBound, readContext)) != null) {
            kmFlexibleTypeUpperBound = new KmFlexibleTypeUpperBound(kmType, type.hasFlexibleTypeCapabilitiesId() ? readContext.get(type.getFlexibleTypeCapabilitiesId()) : null);
        }
        kmType2.setFlexibleTypeUpperBound(kmFlexibleTypeUpperBound);
        for (MetadataExtensions metadataExtensions : readContext.getExtensions$kotlinx_metadata()) {
            metadataExtensions.readTypeExtensions(kmType2, type, readContext);
        }
        return kmType2;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final KmVersionRequirement readVersionRequirement(int i, ReadContext readContext) {
        KmVersionRequirementVersionKind kmVersionRequirementVersionKind;
        KmVersionRequirementLevel kmVersionRequirementLevel;
        KmVersionRequirement kmVersionRequirement = new KmVersionRequirement();
        VersionRequirement create = VersionRequirement.Companion.create(i, readContext.getStrings(), readContext.getVersionRequirements$kotlinx_metadata());
        if (create != null || readContext.getIgnoreUnknownVersionRequirements$kotlinx_metadata()) {
            ProtoBuf.VersionRequirement.VersionKind kind = create != null ? create.getKind() : null;
            int i2 = kind == null ? -1 : WhenMappings.$EnumSwitchMapping$2[kind.ordinal()];
            if (i2 == -1) {
                kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.UNKNOWN;
            } else if (i2 == 1) {
                kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.LANGUAGE_VERSION;
            } else if (i2 == 2) {
                kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.COMPILER_VERSION;
            } else if (i2 == 3) {
                kmVersionRequirementVersionKind = KmVersionRequirementVersionKind.API_VERSION;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            DeprecationLevel level = create != null ? create.getLevel() : null;
            int i3 = level == null ? -1 : WhenMappings.$EnumSwitchMapping$3[level.ordinal()];
            if (i3 != -1) {
                if (i3 == 1) {
                    kmVersionRequirementLevel = KmVersionRequirementLevel.WARNING;
                } else if (i3 == 2) {
                    kmVersionRequirementLevel = KmVersionRequirementLevel.ERROR;
                } else if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                kmVersionRequirement.setKind(kmVersionRequirementVersionKind);
                kmVersionRequirement.setLevel(kmVersionRequirementLevel);
                kmVersionRequirement.setErrorCode(create == null ? create.getErrorCode() : null);
                kmVersionRequirement.setMessage(create != null ? create.getMessage() : null);
                if (create != null || (r8 = create.getVersion()) == null) {
                    VersionRequirement.Version version = VersionRequirement.Version.INFINITY;
                }
                kmVersionRequirement.setVersion(new KmVersion(version.component1(), version.component2(), version.component3()));
                return kmVersionRequirement;
            }
            kmVersionRequirementLevel = KmVersionRequirementLevel.HIDDEN;
            kmVersionRequirement.setKind(kmVersionRequirementVersionKind);
            kmVersionRequirement.setLevel(kmVersionRequirementLevel);
            kmVersionRequirement.setErrorCode(create == null ? create.getErrorCode() : null);
            kmVersionRequirement.setMessage(create != null ? create.getMessage() : null);
            if (create != null) {
            }
            VersionRequirement.Version version2 = VersionRequirement.Version.INFINITY;
            kmVersionRequirement.setVersion(new KmVersion(version2.component1(), version2.component2(), version2.component3()));
            return kmVersionRequirement;
        }
        throw new InconsistentKotlinMetadataException("No VersionRequirement with the given id in the table", null, 2, null);
    }

    private static final KmContract toKmContract(ProtoBuf.Contract contract, ReadContext readContext) {
        KmEffectType kmEffectType;
        KmEffectInvocationKind kmEffectInvocationKind;
        KmContract kmContract = new KmContract();
        for (ProtoBuf.Effect effect : contract.getEffectList()) {
            if (effect.hasEffectType()) {
                ProtoBuf.Effect.EffectType effectType = effect.getEffectType();
                if (effectType == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                int i = WhenMappings.$EnumSwitchMapping$4[effectType.ordinal()];
                if (i == 1) {
                    kmEffectType = KmEffectType.RETURNS_CONSTANT;
                } else if (i == 2) {
                    kmEffectType = KmEffectType.CALLS;
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    kmEffectType = KmEffectType.RETURNS_NOT_NULL;
                }
                if (effect.hasKind()) {
                    ProtoBuf.Effect.InvocationKind kind = effect.getKind();
                    if (kind == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    int i2 = WhenMappings.$EnumSwitchMapping$5[kind.ordinal()];
                    if (i2 == 1) {
                        kmEffectInvocationKind = KmEffectInvocationKind.AT_MOST_ONCE;
                    } else if (i2 == 2) {
                        kmEffectInvocationKind = KmEffectInvocationKind.EXACTLY_ONCE;
                    } else if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        kmEffectInvocationKind = KmEffectInvocationKind.AT_LEAST_ONCE;
                    }
                } else {
                    kmEffectInvocationKind = null;
                }
                List<KmEffect> effects = kmContract.getEffects();
                Intrinsics.checkNotNull(effect);
                effects.add(toKmEffect(effect, kmEffectType, kmEffectInvocationKind, readContext));
            }
        }
        return kmContract;
    }

    private static final KmEffect toKmEffect(ProtoBuf.Effect effect, KmEffectType kmEffectType, KmEffectInvocationKind kmEffectInvocationKind, ReadContext readContext) {
        KmEffect kmEffect = new KmEffect(kmEffectType, kmEffectInvocationKind);
        List<ProtoBuf.Expression> effectConstructorArgumentList = effect.getEffectConstructorArgumentList();
        Intrinsics.checkNotNullExpressionValue(effectConstructorArgumentList, "getEffectConstructorArgumentList(...)");
        List<KmEffectExpression> constructorArguments = kmEffect.getConstructorArguments();
        for (ProtoBuf.Expression expression : effectConstructorArgumentList) {
            Intrinsics.checkNotNull(expression);
            constructorArguments.add(toKmEffectExpression(expression, readContext));
        }
        if (effect.hasConclusionOfConditionalEffect()) {
            ProtoBuf.Expression conclusionOfConditionalEffect = effect.getConclusionOfConditionalEffect();
            Intrinsics.checkNotNullExpressionValue(conclusionOfConditionalEffect, "getConclusionOfConditionalEffect(...)");
            kmEffect.setConclusion(toKmEffectExpression(conclusionOfConditionalEffect, readContext));
        }
        return kmEffect;
    }

    private static final KmEffectExpression toKmEffectExpression(ProtoBuf.Expression expression, ReadContext readContext) {
        Boolean bool;
        KmEffectExpression kmEffectExpression = new KmEffectExpression();
        kmEffectExpression.setFlags(expression.getFlags());
        kmEffectExpression.setParameterIndex(expression.hasValueParameterReference() ? Integer.valueOf(expression.getValueParameterReference()) : null);
        if (expression.hasConstantValue()) {
            ProtoBuf.Expression.ConstantValue constantValue = expression.getConstantValue();
            if (constantValue != null) {
                int i = WhenMappings.$EnumSwitchMapping$6[constantValue.ordinal()];
                if (i == 1) {
                    bool = true;
                } else if (i == 2) {
                    bool = false;
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    bool = null;
                }
                kmEffectExpression.setConstantValue(new KmConstantValue(bool));
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        ProtoBuf.Type isInstanceType = ProtoTypeTableUtilKt.isInstanceType(expression, readContext.getTypes());
        kmEffectExpression.setInstanceType(isInstanceType != null ? toKmType(isInstanceType, readContext) : null);
        List<ProtoBuf.Expression> andArgumentList = expression.getAndArgumentList();
        Intrinsics.checkNotNullExpressionValue(andArgumentList, "getAndArgumentList(...)");
        List<KmEffectExpression> andArguments = kmEffectExpression.getAndArguments();
        for (ProtoBuf.Expression expression2 : andArgumentList) {
            Intrinsics.checkNotNull(expression2);
            andArguments.add(toKmEffectExpression(expression2, readContext));
        }
        List<ProtoBuf.Expression> orArgumentList = expression.getOrArgumentList();
        Intrinsics.checkNotNullExpressionValue(orArgumentList, "getOrArgumentList(...)");
        List<KmEffectExpression> orArguments = kmEffectExpression.getOrArguments();
        for (ProtoBuf.Expression expression3 : orArgumentList) {
            Intrinsics.checkNotNull(expression3);
            orArguments.add(toKmEffectExpression(expression3, readContext));
        }
        return kmEffectExpression;
    }

    private static final int getTypeFlags(ProtoBuf.Type type) {
        return (type.getNullable() ? 1 : 0) + (type.getFlags() << 1);
    }

    private static final int getTypeParameterFlags(ProtoBuf.TypeParameter typeParameter) {
        return typeParameter.getReified() ? 1 : 0;
    }

    public static final int getPropertyGetterFlags(ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        return property.hasGetterFlags() ? property.getGetterFlags() : getDefaultPropertyAccessorFlags(property.getFlags());
    }

    public static final int getPropertySetterFlags(ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        return property.hasSetterFlags() ? property.getSetterFlags() : getDefaultPropertyAccessorFlags(property.getFlags());
    }

    public static final int getDefaultPropertyAccessorFlags(int i) {
        Boolean bool = Flags.HAS_ANNOTATIONS.get(i);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return Flags.getAccessorFlags(bool.booleanValue(), Flags.VISIBILITY.get(i), Flags.MODALITY.get(i), false, false, false);
    }
}
