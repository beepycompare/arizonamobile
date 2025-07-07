package kotlinx.metadata.internal;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmConstructor;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.KmPropertyAccessorAttributes;
import kotlinx.metadata.KmType;
import kotlinx.metadata.KmValueParameter;
import kotlinx.metadata.MemberKind;
import kotlinx.metadata.Modality;
import kotlinx.metadata.Visibility;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
/* compiled from: FlagDelegatesImpl.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00100\u000f\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a.\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\u000f\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\u001a\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a.\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u001c0\u000f\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¨\u0006\u001d"}, d2 = {"annotationsOn", "Lkotlinx/metadata/internal/BooleanFlagDelegate;", "Node", DownloaderServiceMarshaller.PARAMS_FLAGS, "Lkotlin/reflect/KMutableProperty1;", "", "classBooleanFlag", "Lkotlinx/metadata/KmClass;", "flag", "Lkotlinx/metadata/internal/FlagImpl;", "constructorBooleanFlag", "Lkotlinx/metadata/KmConstructor;", "functionBooleanFlag", "Lkotlinx/metadata/KmFunction;", "memberKindDelegate", "Lkotlinx/metadata/internal/EnumFlagDelegate;", "Lkotlinx/metadata/MemberKind;", "modalityDelegate", "Lkotlinx/metadata/Modality;", "propertyAccessorBooleanFlag", "Lkotlinx/metadata/KmPropertyAccessorAttributes;", "propertyBooleanFlag", "Lkotlinx/metadata/KmProperty;", "typeBooleanFlag", "Lkotlinx/metadata/KmType;", "valueParameterBooleanFlag", "Lkotlinx/metadata/KmValueParameter;", "visibilityDelegate", "Lkotlinx/metadata/Visibility;", "kotlinx-metadata"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlagDelegatesImplKt {
    public static final <Node> EnumFlagDelegate<Node, Visibility> visibilityDelegate(KMutableProperty1<Node, Integer> flags) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Flags.FlagField<ProtoBuf.Visibility> VISIBILITY = Flags.VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(VISIBILITY, "VISIBILITY");
        EnumEntries<Visibility> entries = Visibility.getEntries();
        EnumEntries<Visibility> entries2 = Visibility.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries2, 10));
        for (Visibility visibility : entries2) {
            arrayList.add(visibility.getFlag$kotlinx_metadata());
        }
        return new EnumFlagDelegate<>(flags, VISIBILITY, entries, arrayList);
    }

    public static final <Node> EnumFlagDelegate<Node, Modality> modalityDelegate(KMutableProperty1<Node, Integer> flags) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Flags.FlagField<ProtoBuf.Modality> MODALITY = Flags.MODALITY;
        Intrinsics.checkNotNullExpressionValue(MODALITY, "MODALITY");
        EnumEntries<Modality> entries = Modality.getEntries();
        EnumEntries<Modality> entries2 = Modality.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries2, 10));
        for (Modality modality : entries2) {
            arrayList.add(modality.getFlag$kotlinx_metadata());
        }
        return new EnumFlagDelegate<>(flags, MODALITY, entries, arrayList);
    }

    public static final <Node> EnumFlagDelegate<Node, MemberKind> memberKindDelegate(KMutableProperty1<Node, Integer> flags) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Flags.FlagField<ProtoBuf.MemberKind> MEMBER_KIND = Flags.MEMBER_KIND;
        Intrinsics.checkNotNullExpressionValue(MEMBER_KIND, "MEMBER_KIND");
        EnumEntries<MemberKind> entries = MemberKind.getEntries();
        EnumEntries<MemberKind> entries2 = MemberKind.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries2, 10));
        for (MemberKind memberKind : entries2) {
            arrayList.add(memberKind.getFlag$kotlinx_metadata());
        }
        return new EnumFlagDelegate<>(flags, MEMBER_KIND, entries, arrayList);
    }

    public static final BooleanFlagDelegate<KmClass> classBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1() { // from class: kotlinx.metadata.internal.FlagDelegatesImplKt$classBooleanFlag$1
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmClass) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmClass.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmClass) obj).setFlags(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmFunction> functionBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1() { // from class: kotlinx.metadata.internal.FlagDelegatesImplKt$functionBooleanFlag$1
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmFunction) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmFunction.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmFunction) obj).setFlags(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmConstructor> constructorBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1() { // from class: kotlinx.metadata.internal.FlagDelegatesImplKt$constructorBooleanFlag$1
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmConstructor) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmConstructor.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmConstructor) obj).setFlags(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmProperty> propertyBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1() { // from class: kotlinx.metadata.internal.FlagDelegatesImplKt$propertyBooleanFlag$1
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmProperty) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmProperty.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmProperty) obj).setFlags(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmPropertyAccessorAttributes> propertyAccessorBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1() { // from class: kotlinx.metadata.internal.FlagDelegatesImplKt$propertyAccessorBooleanFlag$1
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmPropertyAccessorAttributes) obj).getFlags$kotlinx_metadata());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmPropertyAccessorAttributes.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags$kotlinx_metadata()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmPropertyAccessorAttributes) obj).setFlags$kotlinx_metadata(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmType> typeBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1() { // from class: kotlinx.metadata.internal.FlagDelegatesImplKt$typeBooleanFlag$1
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmType) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmType.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmType) obj).setFlags(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final BooleanFlagDelegate<KmValueParameter> valueParameterBooleanFlag(FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return new BooleanFlagDelegate<>(new MutablePropertyReference1() { // from class: kotlinx.metadata.internal.FlagDelegatesImplKt$valueParameterBooleanFlag$1
            @Override // kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Integer.valueOf(((KmValueParameter) obj).getFlags());
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public String getName() {
                return DownloaderServiceMarshaller.PARAMS_FLAGS;
            }

            @Override // kotlin.jvm.internal.CallableReference
            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(KmValueParameter.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public String getSignature() {
                return "getFlags()I";
            }

            @Override // kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((KmValueParameter) obj).setFlags(((Number) obj2).intValue());
            }
        }, flag);
    }

    public static final <Node> BooleanFlagDelegate<Node> annotationsOn(KMutableProperty1<Node, Integer> flags) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Flags.BooleanFlagField HAS_ANNOTATIONS = Flags.HAS_ANNOTATIONS;
        Intrinsics.checkNotNullExpressionValue(HAS_ANNOTATIONS, "HAS_ANNOTATIONS");
        return new BooleanFlagDelegate<>(flags, new FlagImpl(HAS_ANNOTATIONS));
    }
}
