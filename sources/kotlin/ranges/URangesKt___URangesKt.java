package kotlin.ranges;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.NativeProtocol;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;
import okhttp3.internal.ws.WebSocketProtocol;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _URanges.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a!\u0010\u0000\u001a\u00020\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a!\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a!\u0010\u000b\u001a\u00020\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\t\u001a\u001e\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u001e\u0010\f\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a%\u0010\r\u001a\u00020\u0001*\u00020\u000eH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\u0010\u000f\u001a%\u0010\r\u001a\u00020\u0007*\u00020\u0012H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\u0010\u0013\u001a)\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0015\u001a)\u0010\r\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0016\u001a\"\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u000eH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011\u001a\"\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0012H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011\u001a&\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a&\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00122\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a/\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0087\u008a\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\b\u001b\u001a/\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0087\u008a\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\b\u001c\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b\u001f\u0010 \u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b!\u0010\"\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b#\u0010$\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0007H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b%\u0010&\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020'H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b(\u0010)\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020'H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b*\u0010+\u001a+\u0010,\u001a\u00020\u0002*\u00020\u001e2\u0006\u0010-\u001a\u00020\u001eH\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b.\u0010/\u001a+\u0010,\u001a\u00020\u0002*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b0\u00101\u001a+\u0010,\u001a\u00020\b*\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b2\u00103\u001a+\u0010,\u001a\u00020\u0002*\u00020'2\u0006\u0010-\u001a\u00020'H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b4\u00105\u001a\u001c\u00106\u001a\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a\u001c\u00106\u001a\u00020\b*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a$\u00107\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u000208H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a$\u00107\u001a\u00020\b*\u00020\b2\u0006\u00107\u001a\u000209H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a+\u0010:\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010-\u001a\u00020\u001eH\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b;\u0010<\u001a+\u0010:\u001a\u00020\u000e*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b=\u0010>\u001a+\u0010:\u001a\u00020\u0012*\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b?\u0010@\u001a+\u0010:\u001a\u00020\u000e*\u00020'2\u0006\u0010-\u001a\u00020'H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bA\u0010B\u001a+\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010D\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bE\u0010F\u001a+\u0010C\u001a\u00020\u0007*\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bG\u0010H\u001a+\u0010C\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010D\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bI\u0010J\u001a+\u0010C\u001a\u00020'*\u00020'2\u0006\u0010D\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bK\u0010L\u001a+\u0010M\u001a\u00020\u0001*\u00020\u00012\u0006\u0010N\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bO\u0010F\u001a+\u0010M\u001a\u00020\u0007*\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bP\u0010H\u001a+\u0010M\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bQ\u0010J\u001a+\u0010M\u001a\u00020'*\u00020'2\u0006\u0010N\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bR\u0010L\u001a3\u0010S\u001a\u00020\u0001*\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bT\u0010U\u001a3\u0010S\u001a\u00020\u0007*\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bV\u0010W\u001a3\u0010S\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bX\u0010Y\u001a3\u0010S\u001a\u00020'*\u00020'2\u0006\u0010D\u001a\u00020'2\u0006\u0010N\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bZ\u0010[\u001a1\u0010S\u001a\u00020\u0001*\u00020\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00010]H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b^\u0010_\u001a1\u0010S\u001a\u00020\u0007*\u00020\u00072\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00070]H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b`\u0010a¨\u0006b"}, d2 = {"first", "Lkotlin/UInt;", "Lkotlin/ranges/UIntProgression;", "(Lkotlin/ranges/UIntProgression;)I", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.7", "Lkotlin/ULong;", "Lkotlin/ranges/ULongProgression;", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "Lkotlin/ranges/UIntRange;", "(Lkotlin/ranges/UIntRange;)I", "1.5", "Lkotlin/internal/InlineOnly;", "Lkotlin/ranges/ULongRange;", "(Lkotlin/ranges/ULongRange;)J", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "contains", "", "element", "contains-biwQdVI", "contains-GYNo2lE", "value", "Lkotlin/UByte;", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "Lkotlin/UShort;", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", TypedValues.TransitionType.S_TO, "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "coerceAtLeast", "minimumValue", "coerceAtLeast-J1ME1BU", "(II)I", "coerceAtLeast-eb3DHEI", "(JJ)J", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-Kr8caGY", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-WZ9TVnA", "(III)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-VKSA0NQ", "(SSS)S", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/ranges/URangesKt")
/* loaded from: classes5.dex */
public class URangesKt___URangesKt {
    public static final int first(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
        }
        return uIntProgression.m11162getFirstpVg5ArA();
    }

    public static final long first(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
        }
        return uLongProgression.m11171getFirstsVKNKU();
    }

    public static final UInt firstOrNull(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m9993boximpl(uIntProgression.m11162getFirstpVg5ArA());
    }

    public static final ULong firstOrNull(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m10072boximpl(uLongProgression.m11171getFirstsVKNKU());
    }

    public static final int last(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
        }
        return uIntProgression.m11163getLastpVg5ArA();
    }

    public static final long last(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
        }
        return uLongProgression.m11172getLastsVKNKU();
    }

    public static final UInt lastOrNull(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m9993boximpl(uIntProgression.m11163getLastpVg5ArA());
    }

    public static final ULong lastOrNull(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m10072boximpl(uLongProgression.m11172getLastsVKNKU());
    }

    private static final int random(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return URangesKt.random(uIntRange, Random.Default);
    }

    private static final long random(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return URangesKt.random(uLongRange, Random.Default);
    }

    public static final int random(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final UInt randomOrNull(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return URangesKt.randomOrNull(uIntRange, Random.Default);
    }

    private static final ULong randomOrNull(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return URangesKt.randomOrNull(uLongRange, Random.Default);
    }

    public static final UInt randomOrNull(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.m9993boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    public static final ULong randomOrNull(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.m10072boximpl(URandomKt.nextULong(random, uLongRange));
    }

    /* renamed from: contains-biwQdVI  reason: not valid java name */
    private static final boolean m11199containsbiwQdVI(UIntRange contains, UInt uInt) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return uInt != null && contains.m11167containsWZ4Q5Ns(uInt.m10051unboximpl());
    }

    /* renamed from: contains-GYNo2lE  reason: not valid java name */
    private static final boolean m11195containsGYNo2lE(ULongRange contains, ULong uLong) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return uLong != null && contains.m11176containsVKZWuLQ(uLong.m10130unboximpl());
    }

    /* renamed from: contains-68kG9v0  reason: not valid java name */
    public static final boolean m11194contains68kG9v0(UIntRange contains, byte b) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m11167containsWZ4Q5Ns(UInt.m9999constructorimpl(b & 255));
    }

    /* renamed from: contains-ULb-yJY  reason: not valid java name */
    public static final boolean m11197containsULbyJY(ULongRange contains, byte b) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m11176containsVKZWuLQ(ULong.m10078constructorimpl(b & 255));
    }

    /* renamed from: contains-Gab390E  reason: not valid java name */
    public static final boolean m11196containsGab390E(ULongRange contains, int i) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m11176containsVKZWuLQ(ULong.m10078constructorimpl(i & 4294967295L));
    }

    /* renamed from: contains-fz5IDCE  reason: not valid java name */
    public static final boolean m11200containsfz5IDCE(UIntRange contains, long j) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return ULong.m10078constructorimpl(j >>> 32) == 0 && contains.m11167containsWZ4Q5Ns(UInt.m9999constructorimpl((int) j));
    }

    /* renamed from: contains-ZsK3CEQ  reason: not valid java name */
    public static final boolean m11198containsZsK3CEQ(UIntRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m11167containsWZ4Q5Ns(UInt.m9999constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: contains-uhHAxoY  reason: not valid java name */
    public static final boolean m11201containsuhHAxoY(ULongRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m11176containsVKZWuLQ(ULong.m10078constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: downTo-Kr8caGY  reason: not valid java name */
    public static final UIntProgression m11204downToKr8caGY(byte b, byte b2) {
        return UIntProgression.Companion.m11164fromClosedRangeNkh28Cs(UInt.m9999constructorimpl(b & 255), UInt.m9999constructorimpl(b2 & 255), -1);
    }

    /* renamed from: downTo-J1ME1BU  reason: not valid java name */
    public static final UIntProgression m11203downToJ1ME1BU(int i, int i2) {
        return UIntProgression.Companion.m11164fromClosedRangeNkh28Cs(i, i2, -1);
    }

    /* renamed from: downTo-eb3DHEI  reason: not valid java name */
    public static final ULongProgression m11205downToeb3DHEI(long j, long j2) {
        return ULongProgression.Companion.m11173fromClosedRange7ftBX0g(j, j2, -1L);
    }

    /* renamed from: downTo-5PvTz6A  reason: not valid java name */
    public static final UIntProgression m11202downTo5PvTz6A(short s, short s2) {
        return UIntProgression.Companion.m11164fromClosedRangeNkh28Cs(UInt.m9999constructorimpl(s & UShort.MAX_VALUE), UInt.m9999constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    public static final UIntProgression reversed(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        return UIntProgression.Companion.m11164fromClosedRangeNkh28Cs(uIntProgression.m11163getLastpVg5ArA(), uIntProgression.m11162getFirstpVg5ArA(), -uIntProgression.getStep());
    }

    public static final ULongProgression reversed(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        return ULongProgression.Companion.m11173fromClosedRange7ftBX0g(uLongProgression.m11172getLastsVKNKU(), uLongProgression.m11171getFirstsVKNKU(), -uLongProgression.getStep());
    }

    public static final UIntProgression step(UIntProgression uIntProgression, int i) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.Companion;
        int m11162getFirstpVg5ArA = uIntProgression.m11162getFirstpVg5ArA();
        int m11163getLastpVg5ArA = uIntProgression.m11163getLastpVg5ArA();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m11164fromClosedRangeNkh28Cs(m11162getFirstpVg5ArA, m11163getLastpVg5ArA, i);
    }

    public static final ULongProgression step(ULongProgression uLongProgression, long j) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.Companion;
        long m11171getFirstsVKNKU = uLongProgression.m11171getFirstsVKNKU();
        long m11172getLastsVKNKU = uLongProgression.m11172getLastsVKNKU();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m11173fromClosedRange7ftBX0g(m11171getFirstsVKNKU, m11172getLastsVKNKU, j);
    }

    /* renamed from: until-Kr8caGY  reason: not valid java name */
    public static final UIntRange m11208untilKr8caGY(byte b, byte b2) {
        int i = b2 & 255;
        return Intrinsics.compare(i, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m9999constructorimpl(b & 255), UInt.m9999constructorimpl(UInt.m9999constructorimpl(i) - 1), null);
    }

    /* renamed from: until-J1ME1BU  reason: not valid java name */
    public static final UIntRange m11207untilJ1ME1BU(int i, int i2) {
        int compare;
        compare = Integer.compare(i2 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
        return compare <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(i, UInt.m9999constructorimpl(i2 - 1), null);
    }

    /* renamed from: until-eb3DHEI  reason: not valid java name */
    public static final ULongRange m11209untileb3DHEI(long j, long j2) {
        int compare;
        compare = Long.compare(j2 ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE);
        return compare <= 0 ? ULongRange.Companion.getEMPTY() : new ULongRange(j, ULong.m10078constructorimpl(j2 - ULong.m10078constructorimpl(1L)), null);
    }

    /* renamed from: until-5PvTz6A  reason: not valid java name */
    public static final UIntRange m11206until5PvTz6A(short s, short s2) {
        int i = s2 & UShort.MAX_VALUE;
        return Intrinsics.compare(i, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m9999constructorimpl(s & UShort.MAX_VALUE), UInt.m9999constructorimpl(UInt.m9999constructorimpl(i) - 1), null);
    }

    /* renamed from: coerceAtLeast-J1ME1BU  reason: not valid java name */
    public static final int m11181coerceAtLeastJ1ME1BU(int i, int i2) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        return compare < 0 ? i2 : i;
    }

    /* renamed from: coerceAtLeast-eb3DHEI  reason: not valid java name */
    public static final long m11183coerceAtLeasteb3DHEI(long j, long j2) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        return compare < 0 ? j2 : j;
    }

    /* renamed from: coerceAtLeast-Kr8caGY  reason: not valid java name */
    public static final byte m11182coerceAtLeastKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) < 0 ? b2 : b;
    }

    /* renamed from: coerceAtLeast-5PvTz6A  reason: not valid java name */
    public static final short m11180coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0 ? s2 : s;
    }

    /* renamed from: coerceAtMost-J1ME1BU  reason: not valid java name */
    public static final int m11185coerceAtMostJ1ME1BU(int i, int i2) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        return compare > 0 ? i2 : i;
    }

    /* renamed from: coerceAtMost-eb3DHEI  reason: not valid java name */
    public static final long m11187coerceAtMosteb3DHEI(long j, long j2) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        return compare > 0 ? j2 : j;
    }

    /* renamed from: coerceAtMost-Kr8caGY  reason: not valid java name */
    public static final byte m11186coerceAtMostKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) > 0 ? b2 : b;
    }

    /* renamed from: coerceAtMost-5PvTz6A  reason: not valid java name */
    public static final short m11184coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0 ? s2 : s;
    }

    /* renamed from: coerceIn-WZ9TVnA  reason: not valid java name */
    public static final int m11190coerceInWZ9TVnA(int i, int i2, int i3) {
        int compare;
        int compare2;
        int compare3;
        compare = Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
        if (compare > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UInt.m10045toStringimpl(i3)) + " is less than minimum " + ((Object) UInt.m10045toStringimpl(i2)) + '.');
        }
        compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        if (compare2 < 0) {
            return i2;
        }
        compare3 = Integer.compare(i ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
        return compare3 > 0 ? i3 : i;
    }

    /* renamed from: coerceIn-sambcqE  reason: not valid java name */
    public static final long m11192coerceInsambcqE(long j, long j2, long j3) {
        int compare;
        int compare2;
        int compare3;
        compare = Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
        if (compare > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) ULong.m10124toStringimpl(j3)) + " is less than minimum " + ((Object) ULong.m10124toStringimpl(j2)) + '.');
        }
        compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        if (compare2 < 0) {
            return j2;
        }
        compare3 = Long.compare(j ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
        return compare3 > 0 ? j3 : j;
    }

    /* renamed from: coerceIn-b33U2AM  reason: not valid java name */
    public static final byte m11191coerceInb33U2AM(byte b, byte b2, byte b3) {
        int i = b2 & 255;
        int i2 = b3 & 255;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = b & 255;
            return Intrinsics.compare(i3, i) < 0 ? b2 : Intrinsics.compare(i3, i2) > 0 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UByte.m9960toStringimpl(b3)) + " is less than minimum " + ((Object) UByte.m9960toStringimpl(b2)) + '.');
    }

    /* renamed from: coerceIn-VKSA0NQ  reason: not valid java name */
    public static final short m11189coerceInVKSA0NQ(short s, short s2, short s3) {
        int i = s2 & UShort.MAX_VALUE;
        int i2 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = 65535 & s;
            return Intrinsics.compare(i3, i) < 0 ? s2 : Intrinsics.compare(i3, i2) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UShort.m10229toStringimpl(s3)) + " is less than minimum " + ((Object) UShort.m10229toStringimpl(s2)) + '.');
    }

    /* renamed from: coerceIn-wuiCnnA  reason: not valid java name */
    public static final int m11193coerceInwuiCnnA(int i, ClosedRange<UInt> range) {
        int compare;
        int compare2;
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt.coerceIn(UInt.m9993boximpl(i), (ClosedFloatingPointRange<UInt>) range)).m10051unboximpl();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        compare = Integer.compare(i ^ Integer.MIN_VALUE, range.getStart().m10051unboximpl() ^ Integer.MIN_VALUE);
        if (compare < 0) {
            return range.getStart().m10051unboximpl();
        }
        compare2 = Integer.compare(i ^ Integer.MIN_VALUE, range.getEndInclusive().m10051unboximpl() ^ Integer.MIN_VALUE);
        return compare2 > 0 ? range.getEndInclusive().m10051unboximpl() : i;
    }

    /* renamed from: coerceIn-JPwROB0  reason: not valid java name */
    public static final long m11188coerceInJPwROB0(long j, ClosedRange<ULong> range) {
        int compare;
        int compare2;
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt.coerceIn(ULong.m10072boximpl(j), (ClosedFloatingPointRange<ULong>) range)).m10130unboximpl();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        compare = Long.compare(j ^ Long.MIN_VALUE, range.getStart().m10130unboximpl() ^ Long.MIN_VALUE);
        if (compare < 0) {
            return range.getStart().m10130unboximpl();
        }
        compare2 = Long.compare(j ^ Long.MIN_VALUE, range.getEndInclusive().m10130unboximpl() ^ Long.MIN_VALUE);
        return compare2 > 0 ? range.getEndInclusive().m10130unboximpl() : j;
    }
}
