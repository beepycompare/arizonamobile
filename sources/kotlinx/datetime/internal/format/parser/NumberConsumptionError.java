package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NumberConsumer.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bJ\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "", "errorMessage", "", "Conflicting", "ExpectedInt", "TooFewDigits", "TooManyDigits", "WrongConstant", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NumberConsumptionError {
    String errorMessage();

    /* compiled from: NumberConsumer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lkotlinx/datetime/internal/format/parser/NumberConsumptionError$ExpectedInt;", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "()V", "errorMessage", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ExpectedInt implements NumberConsumptionError {
        public static final ExpectedInt INSTANCE = new ExpectedInt();

        private ExpectedInt() {
        }

        @Override // kotlinx.datetime.internal.format.parser.NumberConsumptionError
        public String errorMessage() {
            return "expected an Int value";
        }
    }

    /* compiled from: NumberConsumer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlinx/datetime/internal/format/parser/NumberConsumptionError$TooManyDigits;", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "maxDigits", "", "(I)V", "getMaxDigits", "()I", "errorMessage", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class TooManyDigits implements NumberConsumptionError {
        private final int maxDigits;

        public TooManyDigits(int i) {
            this.maxDigits = i;
        }

        public final int getMaxDigits() {
            return this.maxDigits;
        }

        @Override // kotlinx.datetime.internal.format.parser.NumberConsumptionError
        public String errorMessage() {
            return "expected at most " + this.maxDigits + " digits";
        }
    }

    /* compiled from: NumberConsumer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlinx/datetime/internal/format/parser/NumberConsumptionError$TooFewDigits;", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "minDigits", "", "(I)V", "getMinDigits", "()I", "errorMessage", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class TooFewDigits implements NumberConsumptionError {
        private final int minDigits;

        public TooFewDigits(int i) {
            this.minDigits = i;
        }

        public final int getMinDigits() {
            return this.minDigits;
        }

        @Override // kotlinx.datetime.internal.format.parser.NumberConsumptionError
        public String errorMessage() {
            return "expected at least " + this.minDigits + " digits";
        }
    }

    /* compiled from: NumberConsumer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlinx/datetime/internal/format/parser/NumberConsumptionError$WrongConstant;", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "expected", "", "(Ljava/lang/String;)V", "getExpected", "()Ljava/lang/String;", "errorMessage", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class WrongConstant implements NumberConsumptionError {
        private final String expected;

        public WrongConstant(String expected) {
            Intrinsics.checkNotNullParameter(expected, "expected");
            this.expected = expected;
        }

        public final String getExpected() {
            return this.expected;
        }

        @Override // kotlinx.datetime.internal.format.parser.NumberConsumptionError
        public String errorMessage() {
            return "expected '" + this.expected + '\'';
        }
    }

    /* compiled from: NumberConsumer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlinx/datetime/internal/format/parser/NumberConsumptionError$Conflicting;", "Lkotlinx/datetime/internal/format/parser/NumberConsumptionError;", "conflicting", "", "(Ljava/lang/Object;)V", "getConflicting", "()Ljava/lang/Object;", "errorMessage", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Conflicting implements NumberConsumptionError {
        private final Object conflicting;

        public Conflicting(Object conflicting) {
            Intrinsics.checkNotNullParameter(conflicting, "conflicting");
            this.conflicting = conflicting;
        }

        public final Object getConflicting() {
            return this.conflicting;
        }

        @Override // kotlinx.datetime.internal.format.parser.NumberConsumptionError
        public String errorMessage() {
            return "attempted to overwrite the existing value '" + this.conflicting + '\'';
        }
    }
}
