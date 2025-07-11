package kotlinx.datetime.internal.format.parser;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.UtilKt;
/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u0011*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0011B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/internal/format/parser/TimeZoneParserOperation;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "setter", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "", "<init>", "(Lkotlinx/datetime/internal/format/parser/AssignableField;)V", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", "", "startIndex", "", "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "Companion", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeZoneParserOperation<Output> implements ParserOperation<Output> {
    public static final Companion Companion = new Companion(null);
    private final AssignableField<Output, String> setter;

    /* JADX WARN: Multi-variable type inference failed */
    public TimeZoneParserOperation(AssignableField<? super Output, String> setter) {
        Intrinsics.checkNotNullParameter(setter, "setter");
        this.setter = setter;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k */
    public Object mo10120consumeFANa98k(Output output, CharSequence input, int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        int validateTimeZone = Companion.validateTimeZone(input, i);
        if (validateTimeZone > i) {
            ParserOperationKt.setWithoutReassigning(this.setter, output, input.subSequence(i, validateTimeZone).toString(), i, validateTimeZone);
            return ParseResult.Companion.m10131OkQi1bsqg(validateTimeZone);
        }
        return ParseResult.Companion.m10130ErrorRg3Co2E(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.TimeZoneParserOperation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String consume_FANa98k$lambda$0;
                consume_FANa98k$lambda$0 = TimeZoneParserOperation.consume_FANa98k$lambda$0();
                return consume_FANa98k$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String consume_FANa98k$lambda$0() {
        return "Invalid timezone format";
    }

    /* compiled from: ParserOperation.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082\bJ\u001b\u0010\t\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/internal/format/parser/TimeZoneParserOperation$Companion;", "", "<init>", "()V", "onTrue", "", "action", "Lkotlin/Function0;", "", "onFalse", "validateTimeZone", "", "input", "", "startIndex", "State", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* compiled from: ParserOperation.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[State.values().length];
                try {
                    iArr[State.START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[State.AFTER_PREFIX.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[State.AFTER_SIGN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[State.AFTER_INIT_SIGN.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[State.AFTER_HOUR.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[State.AFTER_INIT_HOUR.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[State.AFTER_MINUTE.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[State.AFTER_COLON_MINUTE.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[State.IN_PART.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[State.AFTER_SLASH.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[State.END.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: ParserOperation.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/internal/format/parser/TimeZoneParserOperation$Companion$State;", "", "<init>", "(Ljava/lang/String;I)V", "START", "AFTER_PREFIX", "AFTER_SIGN", "AFTER_INIT_SIGN", "AFTER_HOUR", "AFTER_INIT_HOUR", "AFTER_MINUTE", "AFTER_COLON_MINUTE", "IN_PART", "AFTER_SLASH", "END", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class State {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ State[] $VALUES;
            public static final State START = new State("START", 0);
            public static final State AFTER_PREFIX = new State("AFTER_PREFIX", 1);
            public static final State AFTER_SIGN = new State("AFTER_SIGN", 2);
            public static final State AFTER_INIT_SIGN = new State("AFTER_INIT_SIGN", 3);
            public static final State AFTER_HOUR = new State("AFTER_HOUR", 4);
            public static final State AFTER_INIT_HOUR = new State("AFTER_INIT_HOUR", 5);
            public static final State AFTER_MINUTE = new State("AFTER_MINUTE", 6);
            public static final State AFTER_COLON_MINUTE = new State("AFTER_COLON_MINUTE", 7);
            public static final State IN_PART = new State("IN_PART", 8);
            public static final State AFTER_SLASH = new State("AFTER_SLASH", 9);
            public static final State END = new State("END", 10);

            private static final /* synthetic */ State[] $values() {
                return new State[]{START, AFTER_PREFIX, AFTER_SIGN, AFTER_INIT_SIGN, AFTER_HOUR, AFTER_INIT_HOUR, AFTER_MINUTE, AFTER_COLON_MINUTE, IN_PART, AFTER_SLASH, END};
            }

            public static EnumEntries<State> getEntries() {
                return $ENTRIES;
            }

            private State(String str, int i) {
            }

            static {
                State[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }

            public static State valueOf(String str) {
                return (State) Enum.valueOf(State.class, str);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }
        }

        private Companion() {
        }

        private final boolean onTrue(boolean z, Function0<Unit> function0) {
            if (z) {
                function0.invoke();
                return true;
            }
            return false;
        }

        private final boolean onFalse(boolean z, Function0<Unit> function0) {
            if (z) {
                return true;
            }
            function0.invoke();
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int validateTimeZone(CharSequence charSequence, int i) {
            int i2;
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = i;
            State state = State.START;
            while (true) {
                i2 = 0;
                if (intRef.element < charSequence.length()) {
                    switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                        case 1:
                            if (!validateTimeZone$validatePrefix(charSequence, intRef, CollectionsKt.listOf((Object[]) new String[]{"UTC", "GMT", "UT"}))) {
                                if (!validateTimeZone$validateSign(charSequence, intRef)) {
                                    if (!validateTimeZone$validateTimeZoneInitial(charSequence, intRef)) {
                                        break;
                                    } else {
                                        state = State.IN_PART;
                                        break;
                                    }
                                } else {
                                    state = State.AFTER_INIT_SIGN;
                                    break;
                                }
                            } else {
                                state = State.AFTER_PREFIX;
                                break;
                            }
                        case 2:
                            if (!validateTimeZone$validateSign(charSequence, intRef)) {
                                state = State.IN_PART;
                                break;
                            } else {
                                state = State.AFTER_SIGN;
                                break;
                            }
                        case 3:
                            if (!validateTimeZone$validateTimeComponent(intRef, charSequence, 2)) {
                                state = State.IN_PART;
                                break;
                            } else {
                                state = State.AFTER_HOUR;
                                break;
                            }
                        case 4:
                            if (!validateTimeZone$validateTimeComponent(intRef, charSequence, 2)) {
                                if (!validateTimeZone$validateTimeComponent(intRef, charSequence, 1)) {
                                    break;
                                } else {
                                    state = State.END;
                                    break;
                                }
                            } else {
                                state = State.AFTER_INIT_HOUR;
                                break;
                            }
                        case 5:
                            if (!validateTimeZone$validateTimeComponentWithColon(charSequence, intRef)) {
                                state = State.IN_PART;
                                break;
                            } else {
                                state = State.AFTER_COLON_MINUTE;
                                break;
                            }
                        case 6:
                            if (!validateTimeZone$validateTimeComponentWithColon(charSequence, intRef)) {
                                if (!validateTimeZone$validateTimeComponent(intRef, charSequence, 2)) {
                                    break;
                                } else {
                                    state = State.AFTER_MINUTE;
                                    break;
                                }
                            } else {
                                state = State.AFTER_COLON_MINUTE;
                                break;
                            }
                        case 7:
                            if (!validateTimeZone$validateTimeComponent(intRef, charSequence, 2)) {
                                break;
                            } else {
                                state = State.END;
                                break;
                            }
                        case 8:
                            if (!validateTimeZone$validateTimeComponentWithColon(charSequence, intRef)) {
                                break;
                            } else {
                                state = State.END;
                                break;
                            }
                        case 9:
                            if (!validateTimeZone$validateTimeZoneChar(charSequence, intRef)) {
                                if (!validateTimeZone$validateSlash(charSequence, intRef)) {
                                    break;
                                } else {
                                    state = State.AFTER_SLASH;
                                    break;
                                }
                            } else {
                                state = State.IN_PART;
                                break;
                            }
                        case 10:
                            if (!validateTimeZone$validateTimeZoneInitial(charSequence, intRef)) {
                                break;
                            } else {
                                state = State.IN_PART;
                                break;
                            }
                        case 11:
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
            }
            int i3 = intRef.element;
            if (state == State.AFTER_SLASH || state == State.AFTER_INIT_SIGN) {
                i2 = 1;
            }
            return i3 - i2;
        }

        private static final boolean validateTimeZone$validatePrefix(CharSequence charSequence, Ref.IntRef intRef, List<String> list) {
            String str;
            Object obj;
            Iterator<T> it = list.iterator();
            while (true) {
                str = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                CharSequence charSequence2 = charSequence;
                if (StringsKt.startsWith$default(charSequence2, (CharSequence) ((String) obj), intRef.element, false, 4, (Object) null)) {
                    break;
                }
                charSequence = charSequence2;
            }
            String str2 = (String) obj;
            if (str2 != null) {
                intRef.element += str2.length();
                str = str2;
            }
            return str != null;
        }

        private static final boolean validateTimeZone$validateSign(CharSequence charSequence, Ref.IntRef intRef) {
            Companion companion = TimeZoneParserOperation.Companion;
            if (CollectionsKt.listOf((Object[]) new Character[]{'+', '-'}).contains(Character.valueOf(charSequence.charAt(intRef.element)))) {
                intRef.element++;
                return true;
            }
            return false;
        }

        private static final boolean validateTimeZone$validateTimeComponent(Ref.IntRef intRef, CharSequence charSequence, int i) {
            boolean z;
            boolean z2;
            Companion companion = TimeZoneParserOperation.Companion;
            IntRange until = RangesKt.until(intRef.element, intRef.element + i);
            if (!(until instanceof Collection) || !((Collection) until).isEmpty()) {
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    Character orNull = StringsKt.getOrNull(charSequence, ((IntIterator) it).nextInt());
                    if (orNull != null) {
                        z = UtilKt.isAsciiDigit(orNull.charValue());
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                intRef.element += i;
                return true;
            }
            return false;
        }

        private static final boolean validateTimeZone$validateTimeComponentWithColon(CharSequence charSequence, Ref.IntRef intRef) {
            Companion companion = TimeZoneParserOperation.Companion;
            if (charSequence.charAt(intRef.element) == ':') {
                intRef.element++;
                Companion companion2 = TimeZoneParserOperation.Companion;
                if (validateTimeZone$validateTimeComponent(intRef, charSequence, 2)) {
                    return true;
                }
                intRef.element--;
            }
            return false;
        }

        private static final boolean validateTimeZone$isTimeZoneInitial(char c) {
            return UtilKt.isAsciiLetter(c) || c == '.' || c == '_';
        }

        private static final boolean validateTimeZone$isTimeZoneChar(char c) {
            return validateTimeZone$isTimeZoneInitial(c) || UtilKt.isAsciiDigit(c) || c == '-' || c == '+';
        }

        private static final boolean validateTimeZone$validateTimeZoneInitial(CharSequence charSequence, Ref.IntRef intRef) {
            Companion companion = TimeZoneParserOperation.Companion;
            if (validateTimeZone$isTimeZoneInitial(charSequence.charAt(intRef.element))) {
                intRef.element++;
                return true;
            }
            return false;
        }

        private static final boolean validateTimeZone$validateTimeZoneChar(CharSequence charSequence, Ref.IntRef intRef) {
            Companion companion = TimeZoneParserOperation.Companion;
            if (validateTimeZone$isTimeZoneChar(charSequence.charAt(intRef.element))) {
                intRef.element++;
                return true;
            }
            return false;
        }

        private static final boolean validateTimeZone$validateSlash(CharSequence charSequence, Ref.IntRef intRef) {
            Companion companion = TimeZoneParserOperation.Companion;
            if (charSequence.charAt(intRef.element) == '/') {
                intRef.element++;
                return true;
            }
            return false;
        }
    }
}
