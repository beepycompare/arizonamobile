package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.datetime.internal.format.FieldFormatDirective;
import kotlinx.datetime.internal.format.FieldSpec;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.StringFormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.TimeZoneParserOperation;
/* compiled from: DateTimeComponents.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/format/TimeZoneIdDirective;", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "Lkotlinx/datetime/format/DateTimeComponentsContents;", "<init>", "()V", "field", "Lkotlinx/datetime/internal/format/FieldSpec;", "", "getField", "()Lkotlinx/datetime/internal/format/FieldSpec;", "builderRepresentation", "getBuilderRepresentation", "()Ljava/lang/String;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeZoneIdDirective implements FieldFormatDirective<DateTimeComponentsContents> {
    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public FieldSpec<DateTimeComponentsContents, ?> getField() {
        return DateTimeComponentsKt.getTimeZoneField();
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public String getBuilderRepresentation() {
        return "timeZoneId()";
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public FormatterStructure<DateTimeComponentsContents> formatter() {
        return new StringFormatterStructure(new TimeZoneIdDirective$formatter$1(getField().getAccessor()));
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public ParserStructure<DateTimeComponentsContents> parser() {
        return new ParserStructure<>(CollectionsKt.listOf(new TimeZoneParserOperation(DateTimeComponentsKt.getTimeZoneField().getAccessor())), CollectionsKt.emptyList());
    }
}
