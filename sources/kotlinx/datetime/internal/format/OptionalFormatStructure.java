package kotlinx.datetime.internal.format;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.OptionalFormatStructure;
import kotlinx.datetime.internal.format.formatter.ConditionalFormatter;
import kotlinx.datetime.internal.format.formatter.ConstantStringFormatterStructure;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.UnconditionalModification;
/* compiled from: FormatStructure.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001aB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R$\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkotlinx/datetime/internal/format/OptionalFormatStructure;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "onZero", "", "format", "Lkotlinx/datetime/internal/format/FormatStructure;", "(Ljava/lang/String;Lkotlinx/datetime/internal/format/FormatStructure;)V", "fields", "", "Lkotlinx/datetime/internal/format/OptionalFormatStructure$PropertyWithDefault;", "", "getFormat", "()Lkotlinx/datetime/internal/format/FormatStructure;", "getOnZero", "()Ljava/lang/String;", "equals", "", "other", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "hashCode", "", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "toString", "PropertyWithDefault", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OptionalFormatStructure<T> implements NonConcatenatedFormatStructure<T> {
    private final List<PropertyWithDefault<T, ? extends Object>> fields;
    private final FormatStructure<T> format;
    private final String onZero;

    /* JADX WARN: Multi-variable type inference failed */
    public OptionalFormatStructure(String onZero, FormatStructure<? super T> format) {
        List basicFormats;
        Intrinsics.checkNotNullParameter(onZero, "onZero");
        Intrinsics.checkNotNullParameter(format, "format");
        this.onZero = onZero;
        this.format = format;
        basicFormats = FormatStructureKt.basicFormats(format);
        List<FieldFormatDirective> list = basicFormats;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (FieldFormatDirective fieldFormatDirective : list) {
            arrayList.add(fieldFormatDirective.getField());
        }
        List<FieldSpec> distinct = CollectionsKt.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(distinct, 10));
        for (FieldSpec fieldSpec : distinct) {
            arrayList2.add(PropertyWithDefault.Companion.fromField(fieldSpec));
        }
        this.fields = arrayList2;
    }

    public final String getOnZero() {
        return this.onZero;
    }

    public final FormatStructure<T> getFormat() {
        return this.format;
    }

    public String toString() {
        return "Optional(" + this.onZero + ", " + this.format + ')';
    }

    public boolean equals(Object obj) {
        if (obj instanceof OptionalFormatStructure) {
            OptionalFormatStructure optionalFormatStructure = (OptionalFormatStructure) obj;
            return Intrinsics.areEqual(this.onZero, optionalFormatStructure.onZero) && Intrinsics.areEqual(this.format, optionalFormatStructure.format);
        }
        return false;
    }

    public int hashCode() {
        return (this.onZero.hashCode() * 31) + this.format.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure<T> parser() {
        List listOf;
        List emptyList = CollectionsKt.emptyList();
        ParserStructure[] parserStructureArr = new ParserStructure[2];
        parserStructureArr[0] = this.format.parser();
        ParserStructure[] parserStructureArr2 = new ParserStructure[2];
        parserStructureArr2[0] = new ConstantFormatStructure(this.onZero).parser();
        if (this.fields.isEmpty()) {
            listOf = CollectionsKt.emptyList();
        } else {
            listOf = CollectionsKt.listOf(new UnconditionalModification(new Function1<T, Unit>(this) { // from class: kotlinx.datetime.internal.format.OptionalFormatStructure$parser$1
                final /* synthetic */ OptionalFormatStructure<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2((OptionalFormatStructure$parser$1<T>) obj);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(T t) {
                    List<OptionalFormatStructure.PropertyWithDefault> list;
                    list = ((OptionalFormatStructure) this.this$0).fields;
                    for (OptionalFormatStructure.PropertyWithDefault propertyWithDefault : list) {
                        propertyWithDefault.accessor.trySetWithoutReassigning(t, propertyWithDefault.defaultValue);
                    }
                }
            }));
        }
        parserStructureArr2[1] = new ParserStructure(listOf, CollectionsKt.emptyList());
        parserStructureArr[1] = ParserKt.concat(CollectionsKt.listOf((Object[]) parserStructureArr2));
        return new ParserStructure<>(emptyList, CollectionsKt.listOf((Object[]) parserStructureArr));
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure<T> formatter() {
        FormatterStructure<T> formatter = this.format.formatter();
        List<PropertyWithDefault<T, ? extends Object>> list = this.fields;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            PropertyWithDefault propertyWithDefault = (PropertyWithDefault) it.next();
            arrayList.add(new ComparisonPredicate(propertyWithDefault.defaultValue, new OptionalFormatStructure$PropertyWithDefault$isDefaultComparisonPredicate$1(propertyWithDefault.accessor)));
        }
        Predicate conjunctionPredicate = PredicateKt.conjunctionPredicate(arrayList);
        if (conjunctionPredicate instanceof Truth) {
            return new ConstantStringFormatterStructure(this.onZero);
        }
        return new ConditionalFormatter(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(new OptionalFormatStructure$formatter$1(conjunctionPredicate), new ConstantStringFormatterStructure(this.onZero)), TuplesKt.to(new OptionalFormatStructure$formatter$2(Truth.INSTANCE), formatter)}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FormatStructure.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f*\u0006\b\u0001\u0010\u0001 \u0000*\u0004\b\u0002\u0010\u00022\u00020\u0003:\u0001\u000fB#\b\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0002¢\u0006\u0002\u0010\u0007J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0086\b¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000eH\u0086\bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00028\u0002X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/internal/format/OptionalFormatStructure$PropertyWithDefault;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "", "accessor", "Lkotlinx/datetime/internal/format/Accessor;", "defaultValue", "(Lkotlinx/datetime/internal/format/Accessor;Ljava/lang/Object;)V", "Ljava/lang/Object;", "assignDefault", "", TypedValues.AttributesType.S_TARGET, "(Ljava/lang/Object;)V", "isDefaultComparisonPredicate", "Lkotlinx/datetime/internal/format/ComparisonPredicate;", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PropertyWithDefault<T, E> {
        public static final Companion Companion = new Companion(null);
        private final Accessor<T, E> accessor;
        private final E defaultValue;

        public /* synthetic */ PropertyWithDefault(Accessor accessor, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(accessor, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private PropertyWithDefault(Accessor<? super T, E> accessor, E e) {
            this.accessor = accessor;
            this.defaultValue = e;
        }

        /* compiled from: FormatStructure.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\b¨\u0006\t"}, d2 = {"Lkotlinx/datetime/internal/format/OptionalFormatStructure$PropertyWithDefault$Companion;", "", "()V", "fromField", "Lkotlinx/datetime/internal/format/OptionalFormatStructure$PropertyWithDefault;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "field", "Lkotlinx/datetime/internal/format/FieldSpec;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final <T, E> PropertyWithDefault<T, E> fromField(FieldSpec<? super T, E> field) {
                Intrinsics.checkNotNullParameter(field, "field");
                E defaultValue = field.getDefaultValue();
                if (defaultValue == null) {
                    throw new IllegalArgumentException(("The field '" + field.getName() + "' does not define a default value").toString());
                }
                return new PropertyWithDefault<>(field.getAccessor(), defaultValue, null);
            }
        }

        public final void assignDefault(T t) {
            this.accessor.trySetWithoutReassigning(t, this.defaultValue);
        }

        public final ComparisonPredicate<T, E> isDefaultComparisonPredicate() {
            return new ComparisonPredicate<>(this.defaultValue, new OptionalFormatStructure$PropertyWithDefault$isDefaultComparisonPredicate$1(this.accessor));
        }
    }
}
