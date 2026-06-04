package kotlin.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringBuilder.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001ae\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0087\u0088\bb6\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u001c\b\t\u0012\u0018\b\u000bB\u0014\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\b\r\u0012\u0002\b\f\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8\u0010b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010\u0005\u001a;\u0010\u0013\u001a\u00020\u00142\u001b\u0010\u0015\u001a\u0017\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0087\u0088\u0004b\u0002\b\u0011ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aQ\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u001b\u0010\u0015\u001a\u0017\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0087\u0088\u0004b\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001db\u0002\b\u0011ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a7\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u001f\"\u0004\u0018\u00010\u0014H\u0087\u0080\bb\u0002\b\u0012¢\u0006\u0002\u0010 \u001a7\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u001f\"\u0004\u0018\u00010\u0004H\u0087\u0080\bb\u0002\b\u0012¢\u0006\u0002\u0010!\u001as\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0087\u0088\bb6\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b('\u0012\u001c\b\t\u0012\u0018\b\u000bB\u0014\b\n\u0012\b\b\u000b\u0012\u0004\b\b((\u0012\u0006\b\r\u0012\u0002\b\f\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8)b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010&\u001a1\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010+\u001a;\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010-H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010.\u001a;\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0014H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010/\u001a;\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010\u0005\u001a9\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001e\u001a\u00020#H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u00100\u001a9\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001e\u001a\u000201H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u00102\u001a9\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001e\u001a\u000203H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u00104\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"append", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "obj", "", "(Ljava/lang/StringBuilder;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "Lkotlin/Deprecated;", "message", "Use append(value: Any?) instead", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "append(value = obj)", "imports", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "WARNING", "Lkotlin/internal/InlineOnly;", "Lkotlin/IgnorableReturnValue;", "buildString", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.1", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "str", "", TypedValues.CycleType.S_WAVE_OFFSET, "len", "(Ljava/lang/StringBuilder;[CII)Ljava/lang/StringBuilder;", "Use appendRange instead.", "this.appendRange(str, offset, offset + len)", "ERROR", "appendLine", "(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "1.4", "", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[C)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;C)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Z)Ljava/lang/StringBuilder;", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes5.dex */
public class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    @IgnorableReturnValue
    private static final StringBuilder append(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        return sb.append(obj);
    }

    private static final String buildString(Function1<? super StringBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder();
        builderAction.invoke(sb);
        return sb.toString();
    }

    private static final String buildString(int i, Function1<? super StringBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder(i);
        builderAction.invoke(sb);
        return sb.toString();
    }

    @IgnorableReturnValue
    public static final StringBuilder append(StringBuilder sb, String... value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (String str : value) {
            sb.append(str);
        }
        return sb;
    }

    @IgnorableReturnValue
    public static final StringBuilder append(StringBuilder sb, Object... value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (Object obj : value) {
            sb.append(obj);
        }
        return sb;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use appendRange instead.", replaceWith = @ReplaceWith(expression = "this.appendRange(str, offset, offset + len)", imports = {}))
    @IgnorableReturnValue
    private static final StringBuilder append(StringBuilder sb, char[] str, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        throw new NotImplementedError(null, 1, null);
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        return sb.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        return sb.append(charSequence).append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, String str) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        return sb.append(str).append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        return sb.append(obj).append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, char[] value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        return sb.append(value).append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, char c) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        return sb.append(c).append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, boolean z) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        return sb.append(z).append('\n');
    }
}
