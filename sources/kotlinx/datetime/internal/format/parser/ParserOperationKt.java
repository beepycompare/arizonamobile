package kotlinx.datetime.internal.format.parser;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u001a]\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\u0010\f\u001a]\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0001\"\u0004\b\u0000\u0010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\u0010\u0011\u001a@\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001aI\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\b2\u0006\u0010\u0019\u001a\u0002H\u00172\u0006\u0010\u001a\u001a\u0002H\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"SignedIntParser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "Output", "minDigits", "", "maxDigits", "spacePadding", "setter", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "name", "", "plusOnExceedsWidth", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;Ljava/lang/Integer;)Lkotlinx/datetime/internal/format/parser/ParserStructure;", "spaceAndZeroPaddedUnsignedInt", "Target", "withMinus", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;Z)Lkotlinx/datetime/internal/format/parser/ParserStructure;", "ReducedIntParser", "digits", TtmlNode.RUBY_BASE, "setWithoutReassigning", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "Object", "Type", "receiver", "value", "position", "nextIndex", "(Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/Object;Ljava/lang/Object;II)Ljava/lang/Object;", "kotlinx-datetime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ParserOperationKt {
    public static final /* synthetic */ Object access$setWithoutReassigning(AssignableField assignableField, Object obj, Object obj2, int i, int i2) {
        return setWithoutReassigning(assignableField, obj, obj2, i, i2);
    }

    public static final <Output> ParserStructure<Output> SignedIntParser(Integer num, Integer num2, Integer num3, AssignableField<? super Output, Integer> setter, String name, Integer num4) {
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        List mutableListOf = CollectionsKt.mutableListOf(spaceAndZeroPaddedUnsignedInt(num, num2, num3, setter, name, true));
        if (num4 != null) {
            mutableListOf.add(spaceAndZeroPaddedUnsignedInt$default(num, num4, num3, setter, name, false, 32, null));
            mutableListOf.add(new ParserStructure(CollectionsKt.listOf((Object[]) new ParserOperation[]{new PlainStringParserOperation("+"), new NumberSpanParserOperation(CollectionsKt.listOf(new UnsignedIntConsumer(Integer.valueOf(num4.intValue() + 1), num2, setter, name, false)))}), CollectionsKt.emptyList()));
        } else {
            mutableListOf.add(spaceAndZeroPaddedUnsignedInt$default(num, num2, num3, setter, name, false, 32, null));
        }
        return new ParserStructure<>(CollectionsKt.emptyList(), mutableListOf);
    }

    public static /* synthetic */ ParserStructure spaceAndZeroPaddedUnsignedInt$default(Integer num, Integer num2, Integer num3, AssignableField assignableField, String str, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        return spaceAndZeroPaddedUnsignedInt(num, num2, num3, assignableField, str, z);
    }

    public static final <Target> ParserStructure<Target> spaceAndZeroPaddedUnsignedInt(Integer num, Integer num2, Integer num3, AssignableField<? super Target, Integer> setter, String name, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        int intValue = (num != null ? num.intValue() : 1) + (z ? 1 : 0);
        if (num2 != null) {
            i = num2.intValue();
            if (z) {
                i++;
            }
        } else {
            i = Integer.MAX_VALUE;
        }
        int intValue2 = num3 != null ? num3.intValue() : 0;
        int min = Math.min(i, intValue2);
        if (intValue >= min) {
            return spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths(z, setter, name, intValue, i);
        }
        ParserStructure<Target> spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths = spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths(z, setter, name, intValue, intValue);
        while (intValue < min) {
            intValue++;
            spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths = new ParserStructure<>(CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new ParserStructure[]{spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths(z, setter, name, intValue, intValue), ParserKt.concat(CollectionsKt.listOf((Object[]) new ParserStructure[]{new ParserStructure(CollectionsKt.listOf(new PlainStringParserOperation(" ")), CollectionsKt.emptyList()), spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths}))}));
        }
        if (intValue2 > i) {
            return ParserKt.concat(CollectionsKt.listOf((Object[]) new ParserStructure[]{new ParserStructure(CollectionsKt.listOf(new PlainStringParserOperation(StringsKt.repeat(" ", intValue2 - i))), CollectionsKt.emptyList()), spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths}));
        }
        return intValue2 == i ? spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths : new ParserStructure<>(CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new ParserStructure[]{spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths(z, setter, name, intValue2 + 1, i), spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths}));
    }

    private static final <Target> ParserStructure<Target> spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths(boolean z, AssignableField<? super Target, Integer> assignableField, String str, int i, int i2) {
        if (i2 < (z ? 1 : 0) + 1) {
            throw new IllegalStateException("Check failed.");
        }
        List createListBuilder = CollectionsKt.createListBuilder();
        if (z) {
            createListBuilder.add(new PlainStringParserOperation(Constants.FILENAME_SEQUENCE_SEPARATOR));
        }
        createListBuilder.add(new NumberSpanParserOperation(CollectionsKt.listOf(new UnsignedIntConsumer(Integer.valueOf(i - (z ? 1 : 0)), Integer.valueOf(i2 - (z ? 1 : 0)), assignableField, str, z))));
        return new ParserStructure<>(CollectionsKt.build(createListBuilder), CollectionsKt.emptyList());
    }

    public static final <Output> ParserStructure<Output> ReducedIntParser(int i, int i2, AssignableField<? super Output, Integer> setter, String name) {
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        return new ParserStructure<>(CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new ParserStructure[]{new ParserStructure(CollectionsKt.listOf(new NumberSpanParserOperation(CollectionsKt.listOf(new ReducedIntConsumer(i, setter, name, i2)))), CollectionsKt.emptyList()), new ParserStructure(CollectionsKt.listOf((Object[]) new ParserOperation[]{new PlainStringParserOperation("+"), new NumberSpanParserOperation(CollectionsKt.listOf(new UnsignedIntConsumer(null, null, setter, name, false)))}), CollectionsKt.emptyList()), new ParserStructure(CollectionsKt.listOf((Object[]) new ParserOperation[]{new PlainStringParserOperation(Constants.FILENAME_SEQUENCE_SEPARATOR), new NumberSpanParserOperation(CollectionsKt.listOf(new UnsignedIntConsumer(null, null, setter, name, true)))}), CollectionsKt.emptyList())}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <Object, Type> Object setWithoutReassigning(final AssignableField<? super Object, Type> assignableField, Object object, final Type type, int i, int i2) {
        final Type trySetWithoutReassigning = assignableField.trySetWithoutReassigning(object, type);
        if (trySetWithoutReassigning == null) {
            return ParseResult.Companion.m10131OkQi1bsqg(i2);
        }
        return ParseResult.Companion.m10130ErrorRg3Co2E(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.ParserOperationKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String withoutReassigning$lambda$2;
                withoutReassigning$lambda$2 = ParserOperationKt.setWithoutReassigning$lambda$2(trySetWithoutReassigning, type, assignableField);
                return withoutReassigning$lambda$2;
            }
        });
    }

    public static final String setWithoutReassigning$lambda$2(Object obj, Object obj2, AssignableField assignableField) {
        return "Attempting to assign conflicting values '" + obj + "' and '" + obj2 + "' to field '" + assignableField.getName() + '\'';
    }
}
