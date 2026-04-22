package kotlin.time;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Duration.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\bB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007Jw\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0010H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\t\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Lkotlin/time/LongParser;", "", "overflowLimit", "", "allowSign", "", "<init>", "(JZ)V", "overflowThreshold", "lastDigitMax", "parse", "value", "", "startIndex", "", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "endIndex", "sign", "hasOverflow", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LongParser {
    private final boolean allowSign;
    private final long lastDigitMax;
    private final long overflowLimit;
    private final long overflowThreshold;
    public static final Companion Companion = new Companion(null);
    private static final LongParser iso = new LongParser(4611686018427387903L, true);

    /* renamed from: default  reason: not valid java name */
    private static final LongParser f154default = new LongParser(Long.MAX_VALUE, false);

    private LongParser(long j, boolean z) {
        this.overflowLimit = j;
        this.allowSign = z;
        this.overflowThreshold = j / 10;
        this.lastDigitMax = j % 10;
    }

    public final long parse(String value, int i, Function3<? super Integer, ? super Integer, ? super Boolean, Unit> callback) {
        int i2;
        long j;
        char charAt;
        char charAt2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.allowSign) {
            char charAt3 = value.charAt(i);
            if (charAt3 == '+') {
                i++;
            } else if (charAt3 == '-') {
                i++;
                i2 = -1;
                while (i < value.length() && value.charAt(i) == '0') {
                    i++;
                }
                j = 0;
                while (i < value.length() && '0' <= (charAt = value.charAt(i)) && charAt < ':') {
                    int i3 = charAt - '0';
                    if (j <= this.overflowThreshold || (j == this.overflowThreshold && i3 > this.lastDigitMax)) {
                        while (i < value.length() && '0' <= (charAt2 = value.charAt(i)) && charAt2 < ':') {
                            i++;
                        }
                        callback.invoke(Integer.valueOf(i), Integer.valueOf(i2), true);
                        return this.overflowLimit;
                    }
                    j = i3 + (j << 3) + (j << 1);
                    i++;
                }
                callback.invoke(Integer.valueOf(i), Integer.valueOf(i2), false);
                return j;
            }
        }
        i2 = 1;
        while (i < value.length()) {
            i++;
        }
        j = 0;
        while (i < value.length()) {
            int i32 = charAt - '0';
            if (j <= this.overflowThreshold) {
            }
            while (i < value.length()) {
                i++;
            }
            callback.invoke(Integer.valueOf(i), Integer.valueOf(i2), true);
            return this.overflowLimit;
        }
        callback.invoke(Integer.valueOf(i), Integer.valueOf(i2), false);
        return j;
    }

    /* compiled from: Duration.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/time/LongParser$Companion;", "", "<init>", "()V", "iso", "Lkotlin/time/LongParser;", "getIso", "()Lkotlin/time/LongParser;", "default", "getDefault", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LongParser getIso() {
            return LongParser.iso;
        }

        public final LongParser getDefault() {
            return LongParser.f154default;
        }
    }
}
