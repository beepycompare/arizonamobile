package kotlinx.metadata.internal.metadata.deserialization;

import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.protobuf.Internal;
/* loaded from: classes5.dex */
public class Flags {
    public static final FlagField<ProtoBuf.Class.Kind> CLASS_KIND;
    public static final BooleanFlagField DECLARES_DEFAULT_VALUE;
    public static final BooleanFlagField DEFINITELY_NOT_NULL_TYPE;
    public static final BooleanFlagField HAS_ANNOTATIONS;
    public static final BooleanFlagField HAS_CONSTANT;
    public static final BooleanFlagField HAS_ENUM_ENTRIES;
    public static final BooleanFlagField HAS_GETTER;
    public static final BooleanFlagField HAS_SETTER;
    public static final BooleanFlagField IS_CONST;
    public static final BooleanFlagField IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final BooleanFlagField IS_CROSSINLINE;
    public static final BooleanFlagField IS_DATA;
    public static final BooleanFlagField IS_DELEGATED;
    public static final BooleanFlagField IS_EXPECT_CLASS;
    public static final BooleanFlagField IS_EXPECT_FUNCTION;
    public static final BooleanFlagField IS_EXPECT_PROPERTY;
    public static final BooleanFlagField IS_EXTERNAL_ACCESSOR;
    public static final BooleanFlagField IS_EXTERNAL_CLASS;
    public static final BooleanFlagField IS_EXTERNAL_FUNCTION;
    public static final BooleanFlagField IS_EXTERNAL_PROPERTY;
    public static final BooleanFlagField IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final BooleanFlagField IS_FUN_INTERFACE;
    public static final BooleanFlagField IS_INFIX;
    public static final BooleanFlagField IS_INLINE;
    public static final BooleanFlagField IS_INLINE_ACCESSOR;
    public static final BooleanFlagField IS_INNER;
    public static final BooleanFlagField IS_LATEINIT;
    public static final BooleanFlagField IS_NEGATED;
    public static final BooleanFlagField IS_NOINLINE;
    public static final BooleanFlagField IS_NOT_DEFAULT;
    public static final BooleanFlagField IS_NULL_CHECK_PREDICATE;
    public static final BooleanFlagField IS_OPERATOR;
    public static final BooleanFlagField IS_SECONDARY;
    public static final BooleanFlagField IS_SUSPEND;
    public static final BooleanFlagField IS_TAILREC;
    public static final BooleanFlagField IS_UNSIGNED;
    public static final BooleanFlagField IS_VALUE_CLASS;
    public static final BooleanFlagField IS_VAR;
    public static final FlagField<ProtoBuf.MemberKind> MEMBER_KIND;
    public static final FlagField<ProtoBuf.Modality> MODALITY;
    public static final BooleanFlagField SUSPEND_TYPE;
    public static final FlagField<ProtoBuf.Visibility> VISIBILITY;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            if (i == 2) {
                objArr[0] = "kind";
            } else if (i != 5) {
                if (i != 6) {
                    if (i != 8) {
                        if (i != 9) {
                            if (i != 11) {
                                objArr[0] = "visibility";
                            }
                        }
                    }
                }
                objArr[0] = "memberKind";
            }
            objArr[1] = "kotlinx/metadata/internal/metadata/deserialization/Flags";
            switch (i) {
                case 3:
                    objArr[2] = "getConstructorFlags";
                    break;
                case 4:
                case 5:
                case 6:
                    objArr[2] = "getFunctionFlags";
                    break;
                case 7:
                case 8:
                case 9:
                    objArr[2] = "getPropertyFlags";
                    break;
                case 10:
                case 11:
                    objArr[2] = "getAccessorFlags";
                    break;
                default:
                    objArr[2] = "getClassFlags";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
        objArr[0] = "modality";
        objArr[1] = "kotlinx/metadata/internal/metadata/deserialization/Flags";
        switch (i) {
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    protected Flags() {
    }

    static {
        BooleanFlagField booleanFirst = FlagField.booleanFirst();
        SUSPEND_TYPE = booleanFirst;
        DEFINITELY_NOT_NULL_TYPE = FlagField.booleanAfter(booleanFirst);
        BooleanFlagField booleanFirst2 = FlagField.booleanFirst();
        HAS_ANNOTATIONS = booleanFirst2;
        FlagField<ProtoBuf.Visibility> after = FlagField.after(booleanFirst2, ProtoBuf.Visibility.values());
        VISIBILITY = after;
        FlagField<ProtoBuf.Modality> after2 = FlagField.after(after, ProtoBuf.Modality.values());
        MODALITY = after2;
        FlagField<ProtoBuf.Class.Kind> after3 = FlagField.after(after2, ProtoBuf.Class.Kind.values());
        CLASS_KIND = after3;
        BooleanFlagField booleanAfter = FlagField.booleanAfter(after3);
        IS_INNER = booleanAfter;
        BooleanFlagField booleanAfter2 = FlagField.booleanAfter(booleanAfter);
        IS_DATA = booleanAfter2;
        BooleanFlagField booleanAfter3 = FlagField.booleanAfter(booleanAfter2);
        IS_EXTERNAL_CLASS = booleanAfter3;
        BooleanFlagField booleanAfter4 = FlagField.booleanAfter(booleanAfter3);
        IS_EXPECT_CLASS = booleanAfter4;
        BooleanFlagField booleanAfter5 = FlagField.booleanAfter(booleanAfter4);
        IS_VALUE_CLASS = booleanAfter5;
        BooleanFlagField booleanAfter6 = FlagField.booleanAfter(booleanAfter5);
        IS_FUN_INTERFACE = booleanAfter6;
        HAS_ENUM_ENTRIES = FlagField.booleanAfter(booleanAfter6);
        BooleanFlagField booleanAfter7 = FlagField.booleanAfter(after);
        IS_SECONDARY = booleanAfter7;
        IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(booleanAfter7);
        FlagField<ProtoBuf.MemberKind> after4 = FlagField.after(after2, ProtoBuf.MemberKind.values());
        MEMBER_KIND = after4;
        BooleanFlagField booleanAfter8 = FlagField.booleanAfter(after4);
        IS_OPERATOR = booleanAfter8;
        BooleanFlagField booleanAfter9 = FlagField.booleanAfter(booleanAfter8);
        IS_INFIX = booleanAfter9;
        BooleanFlagField booleanAfter10 = FlagField.booleanAfter(booleanAfter9);
        IS_INLINE = booleanAfter10;
        BooleanFlagField booleanAfter11 = FlagField.booleanAfter(booleanAfter10);
        IS_TAILREC = booleanAfter11;
        BooleanFlagField booleanAfter12 = FlagField.booleanAfter(booleanAfter11);
        IS_EXTERNAL_FUNCTION = booleanAfter12;
        BooleanFlagField booleanAfter13 = FlagField.booleanAfter(booleanAfter12);
        IS_SUSPEND = booleanAfter13;
        BooleanFlagField booleanAfter14 = FlagField.booleanAfter(booleanAfter13);
        IS_EXPECT_FUNCTION = booleanAfter14;
        IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = FlagField.booleanAfter(booleanAfter14);
        BooleanFlagField booleanAfter15 = FlagField.booleanAfter(after4);
        IS_VAR = booleanAfter15;
        BooleanFlagField booleanAfter16 = FlagField.booleanAfter(booleanAfter15);
        HAS_GETTER = booleanAfter16;
        BooleanFlagField booleanAfter17 = FlagField.booleanAfter(booleanAfter16);
        HAS_SETTER = booleanAfter17;
        BooleanFlagField booleanAfter18 = FlagField.booleanAfter(booleanAfter17);
        IS_CONST = booleanAfter18;
        BooleanFlagField booleanAfter19 = FlagField.booleanAfter(booleanAfter18);
        IS_LATEINIT = booleanAfter19;
        BooleanFlagField booleanAfter20 = FlagField.booleanAfter(booleanAfter19);
        HAS_CONSTANT = booleanAfter20;
        BooleanFlagField booleanAfter21 = FlagField.booleanAfter(booleanAfter20);
        IS_EXTERNAL_PROPERTY = booleanAfter21;
        BooleanFlagField booleanAfter22 = FlagField.booleanAfter(booleanAfter21);
        IS_DELEGATED = booleanAfter22;
        IS_EXPECT_PROPERTY = FlagField.booleanAfter(booleanAfter22);
        BooleanFlagField booleanAfter23 = FlagField.booleanAfter(booleanFirst2);
        DECLARES_DEFAULT_VALUE = booleanAfter23;
        BooleanFlagField booleanAfter24 = FlagField.booleanAfter(booleanAfter23);
        IS_CROSSINLINE = booleanAfter24;
        IS_NOINLINE = FlagField.booleanAfter(booleanAfter24);
        BooleanFlagField booleanAfter25 = FlagField.booleanAfter(after2);
        IS_NOT_DEFAULT = booleanAfter25;
        BooleanFlagField booleanAfter26 = FlagField.booleanAfter(booleanAfter25);
        IS_EXTERNAL_ACCESSOR = booleanAfter26;
        IS_INLINE_ACCESSOR = FlagField.booleanAfter(booleanAfter26);
        BooleanFlagField booleanFirst3 = FlagField.booleanFirst();
        IS_NEGATED = booleanFirst3;
        IS_NULL_CHECK_PREDICATE = FlagField.booleanAfter(booleanFirst3);
        IS_UNSIGNED = FlagField.booleanFirst();
    }

    public static int getTypeFlags(boolean z, boolean z2) {
        return SUSPEND_TYPE.toFlags(Boolean.valueOf(z)) | DEFINITELY_NOT_NULL_TYPE.toFlags(Boolean.valueOf(z2));
    }

    public static int getClassFlags(boolean z, ProtoBuf.Visibility visibility, ProtoBuf.Modality modality, ProtoBuf.Class.Kind kind, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        if (visibility == null) {
            $$$reportNull$$$0(0);
        }
        if (modality == null) {
            $$$reportNull$$$0(1);
        }
        if (kind == null) {
            $$$reportNull$$$0(2);
        }
        return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(z)) | MODALITY.toFlags(modality) | VISIBILITY.toFlags(visibility) | CLASS_KIND.toFlags(kind) | IS_INNER.toFlags(Boolean.valueOf(z2)) | IS_DATA.toFlags(Boolean.valueOf(z3)) | IS_EXTERNAL_CLASS.toFlags(Boolean.valueOf(z4)) | IS_EXPECT_CLASS.toFlags(Boolean.valueOf(z5)) | IS_VALUE_CLASS.toFlags(Boolean.valueOf(z6)) | IS_FUN_INTERFACE.toFlags(Boolean.valueOf(z7)) | HAS_ENUM_ENTRIES.toFlags(Boolean.valueOf(z8));
    }

    public static int getConstructorFlags(boolean z, ProtoBuf.Visibility visibility, boolean z2, boolean z3) {
        if (visibility == null) {
            $$$reportNull$$$0(3);
        }
        return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(z)) | VISIBILITY.toFlags(visibility) | IS_SECONDARY.toFlags(Boolean.valueOf(z2)) | IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.toFlags(Boolean.valueOf(!z3));
    }

    public static int getFunctionFlags(boolean z, ProtoBuf.Visibility visibility, ProtoBuf.Modality modality, ProtoBuf.MemberKind memberKind, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        if (visibility == null) {
            $$$reportNull$$$0(4);
        }
        if (modality == null) {
            $$$reportNull$$$0(5);
        }
        if (memberKind == null) {
            $$$reportNull$$$0(6);
        }
        return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(z)) | VISIBILITY.toFlags(visibility) | MODALITY.toFlags(modality) | MEMBER_KIND.toFlags(memberKind) | IS_OPERATOR.toFlags(Boolean.valueOf(z2)) | IS_INFIX.toFlags(Boolean.valueOf(z3)) | IS_INLINE.toFlags(Boolean.valueOf(z4)) | IS_TAILREC.toFlags(Boolean.valueOf(z5)) | IS_EXTERNAL_FUNCTION.toFlags(Boolean.valueOf(z6)) | IS_SUSPEND.toFlags(Boolean.valueOf(z7)) | IS_EXPECT_FUNCTION.toFlags(Boolean.valueOf(z8)) | IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.toFlags(Boolean.valueOf(!z9));
    }

    public static int getPropertyFlags(boolean z, ProtoBuf.Visibility visibility, ProtoBuf.Modality modality, ProtoBuf.MemberKind memberKind, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        if (visibility == null) {
            $$$reportNull$$$0(7);
        }
        if (modality == null) {
            $$$reportNull$$$0(8);
        }
        if (memberKind == null) {
            $$$reportNull$$$0(9);
        }
        return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(z)) | VISIBILITY.toFlags(visibility) | MODALITY.toFlags(modality) | MEMBER_KIND.toFlags(memberKind) | IS_VAR.toFlags(Boolean.valueOf(z2)) | HAS_GETTER.toFlags(Boolean.valueOf(z3)) | HAS_SETTER.toFlags(Boolean.valueOf(z4)) | IS_CONST.toFlags(Boolean.valueOf(z6)) | IS_LATEINIT.toFlags(Boolean.valueOf(z7)) | HAS_CONSTANT.toFlags(Boolean.valueOf(z5)) | IS_EXTERNAL_PROPERTY.toFlags(Boolean.valueOf(z8)) | IS_DELEGATED.toFlags(Boolean.valueOf(z9)) | IS_EXPECT_PROPERTY.toFlags(Boolean.valueOf(z10));
    }

    public static int getAccessorFlags(boolean z, ProtoBuf.Visibility visibility, ProtoBuf.Modality modality, boolean z2, boolean z3, boolean z4) {
        if (visibility == null) {
            $$$reportNull$$$0(10);
        }
        if (modality == null) {
            $$$reportNull$$$0(11);
        }
        return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(z)) | MODALITY.toFlags(modality) | VISIBILITY.toFlags(visibility) | IS_NOT_DEFAULT.toFlags(Boolean.valueOf(z2)) | IS_EXTERNAL_ACCESSOR.toFlags(Boolean.valueOf(z3)) | IS_INLINE_ACCESSOR.toFlags(Boolean.valueOf(z4));
    }

    public static int getContractExpressionFlags(boolean z, boolean z2) {
        return IS_NEGATED.toFlags(Boolean.valueOf(z)) | IS_NULL_CHECK_PREDICATE.toFlags(Boolean.valueOf(z2));
    }

    public static int getValueParameterFlags(boolean z, boolean z2, boolean z3, boolean z4) {
        return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(z)) | DECLARES_DEFAULT_VALUE.toFlags(Boolean.valueOf(z2)) | IS_CROSSINLINE.toFlags(Boolean.valueOf(z3)) | IS_NOINLINE.toFlags(Boolean.valueOf(z4));
    }

    public static int getTypeAliasFlags(boolean z, ProtoBuf.Visibility visibility) {
        return HAS_ANNOTATIONS.toFlags(Boolean.valueOf(z)) | VISIBILITY.toFlags(visibility);
    }

    /* loaded from: classes5.dex */
    public static abstract class FlagField<E> {
        public final int bitWidth;
        public final int offset;

        public abstract E get(int i);

        public abstract int toFlags(E e);

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlinx/metadata/internal/protobuf/Internal$EnumLite;>(Lkotlinx/metadata/internal/metadata/deserialization/Flags$FlagField<*>;[TE;)Lkotlinx/metadata/internal/metadata/deserialization/Flags$FlagField<TE;>; */
        public static FlagField after(FlagField flagField, Internal.EnumLite[] enumLiteArr) {
            return new EnumLiteFlagField(flagField.offset + flagField.bitWidth, enumLiteArr);
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlinx/metadata/internal/protobuf/Internal$EnumLite;>([TE;)Lkotlinx/metadata/internal/metadata/deserialization/Flags$FlagField<TE;>; */
        public static FlagField first(Internal.EnumLite[] enumLiteArr) {
            return new EnumLiteFlagField(0, enumLiteArr);
        }

        public static BooleanFlagField booleanFirst() {
            return new BooleanFlagField(0);
        }

        public static BooleanFlagField booleanAfter(FlagField<?> flagField) {
            return new BooleanFlagField(flagField.offset + flagField.bitWidth);
        }

        private FlagField(int i, int i2) {
            this.offset = i;
            this.bitWidth = i2;
        }
    }

    /* loaded from: classes5.dex */
    public static class BooleanFlagField extends FlagField<Boolean> {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlinx/metadata/internal/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        public BooleanFlagField(int i) {
            super(i, 1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.metadata.internal.metadata.deserialization.Flags.FlagField
        public Boolean get(int i) {
            Boolean valueOf = Boolean.valueOf((i & (1 << this.offset)) != 0);
            if (valueOf == null) {
                $$$reportNull$$$0(0);
            }
            return valueOf;
        }

        @Override // kotlinx.metadata.internal.metadata.deserialization.Flags.FlagField
        public int toFlags(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.offset;
            }
            return 0;
        }

        public int invert(int i) {
            return i ^ (1 << this.offset);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class EnumLiteFlagField<E extends Internal.EnumLite> extends FlagField<E> {
        private final E[] values;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlinx/metadata/internal/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.metadata.internal.metadata.deserialization.Flags.FlagField
        public /* bridge */ /* synthetic */ int toFlags(Object obj) {
            return toFlags((EnumLiteFlagField<E>) ((Internal.EnumLite) obj));
        }

        public EnumLiteFlagField(int i, E[] eArr) {
            super(i, bitWidth(eArr));
            this.values = eArr;
        }

        private static <E> int bitWidth(E[] eArr) {
            if (eArr == null) {
                $$$reportNull$$$0(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & length) != 0) {
                    return i + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // kotlinx.metadata.internal.metadata.deserialization.Flags.FlagField
        public E get(int i) {
            E[] eArr;
            int i2 = (i & (((1 << this.bitWidth) - 1) << this.offset)) >> this.offset;
            for (E e : this.values) {
                if (e.getNumber() == i2) {
                    return e;
                }
            }
            return null;
        }

        public int toFlags(E e) {
            return e.getNumber() << this.offset;
        }
    }
}
