package kotlinx.datetime.internal.format;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.datetime.internal.format.formatter.ConstantStringFormatterStructure;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ConstantNumberConsumer;
import kotlinx.datetime.internal.format.parser.NumberSpanParserOperation;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.PlainStringParserOperation;
/* compiled from: FormatStructure.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lkotlinx/datetime/internal/format/ConstantFormatStructure;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", TypedValues.Custom.S_STRING, "", "<init>", "(Ljava/lang/String;)V", "getString", "()Ljava/lang/String;", "toString", "equals", "", "other", "", "hashCode", "", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConstantFormatStructure<T> implements NonConcatenatedFormatStructure<T> {
    private final String string;

    public ConstantFormatStructure(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.string = string;
    }

    public final String getString() {
        return this.string;
    }

    public String toString() {
        return "ConstantFormatStructure(" + this.string + ')';
    }

    public boolean equals(Object obj) {
        return (obj instanceof ConstantFormatStructure) && Intrinsics.areEqual(this.string, ((ConstantFormatStructure) obj).string);
    }

    public int hashCode() {
        return this.string.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure<T> parser() {
        String str;
        List build;
        if (this.string.length() == 0) {
            build = CollectionsKt.emptyList();
        } else {
            List createListBuilder = CollectionsKt.createListBuilder();
            String str2 = "";
            if (UtilKt.isAsciiDigit(this.string.charAt(0))) {
                String str3 = this.string;
                int length = str3.length();
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (!UtilKt.isAsciiDigit(str3.charAt(i))) {
                        str3 = str3.substring(0, i);
                        Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
                        break;
                    } else {
                        i++;
                    }
                }
                createListBuilder.add(new NumberSpanParserOperation(CollectionsKt.listOf(new ConstantNumberConsumer(str3))));
                String str4 = this.string;
                int length2 = str4.length();
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        str = "";
                        break;
                    } else if (!UtilKt.isAsciiDigit(str4.charAt(i2))) {
                        str = str4.substring(i2);
                        Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                        break;
                    } else {
                        i2++;
                    }
                }
            } else {
                str = this.string;
            }
            String str5 = str;
            if (str5.length() > 0) {
                if (!UtilKt.isAsciiDigit(str.charAt(str.length() - 1))) {
                    createListBuilder.add(new PlainStringParserOperation(str));
                } else {
                    int lastIndex = StringsKt.getLastIndex(str5);
                    while (true) {
                        if (-1 >= lastIndex) {
                            break;
                        } else if (!UtilKt.isAsciiDigit(str.charAt(lastIndex))) {
                            str2 = str.substring(0, lastIndex + 1);
                            Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                            break;
                        } else {
                            lastIndex--;
                        }
                    }
                    createListBuilder.add(new PlainStringParserOperation(str2));
                    int lastIndex2 = StringsKt.getLastIndex(str5);
                    while (true) {
                        if (-1 >= lastIndex2) {
                            break;
                        } else if (!UtilKt.isAsciiDigit(str.charAt(lastIndex2))) {
                            str = str.substring(lastIndex2 + 1);
                            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                            break;
                        } else {
                            lastIndex2--;
                        }
                    }
                    createListBuilder.add(new NumberSpanParserOperation(CollectionsKt.listOf(new ConstantNumberConsumer(str))));
                }
            }
            build = CollectionsKt.build(createListBuilder);
        }
        return new ParserStructure<>(build, CollectionsKt.emptyList());
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure<T> formatter() {
        return new ConstantStringFormatterStructure(this.string);
    }
}
