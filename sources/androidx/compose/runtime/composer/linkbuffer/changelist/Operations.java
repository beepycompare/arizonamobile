package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.composer.DebugStringFormattable;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.composer.linkbuffer.changelist.Operation;
import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: Operations.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001c\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0002WXB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000bH\u0007J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\u0011\u0010&\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u000fH\u0082\bJ\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0011\u0010(\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u000fH\u0082\bJ\u0018\u0010)\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0002J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000bJ\u0010\u0010+\u001a\u00020,2\u0006\u0010!\u001a\u00020\u000bH\u0002J7\u0010*\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000b2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001f0.¢\u0006\u0002\b0H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001J\u000e\u00101\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000bJ\u0010\u00102\u001a\u00020,2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0011\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000fH\u0082\bJ\u0006\u00105\u001a\u00020\u001fJ\u000e\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u0000J&\u00108\u001a\u00020\u001f2\u001b\u00109\u001a\u0017\u0012\b\u0012\u00060:R\u00020\u0000\u0012\u0004\u0012\u00020\u001f0.¢\u0006\u0002\b0H\u0086\bJ&\u0010;\u001a\u00020\u001f2\u001b\u0010<\u001a\u0017\u0012\b\u0012\u00060:R\u00020\u0000\u0012\u0004\u0012\u00020\u001f0.¢\u0006\u0002\b0H\u0086\bJ,\u0010=\u001a\u00020\u001f2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EJ\f\u0010F\u001a\u00020,*\u00020,H\u0002J\t\u0010G\u001a\u00020\u000bH\u0082\bJ\u0015\u0010H\u001a\u00020\u000f2\n\u0010I\u001a\u00060\u000fj\u0002`JH\u0082\bJ\u001c\u0010K\u001a\u00020\u000f2\n\u0010I\u001a\u0006\u0012\u0002\b\u00030LH\u0082\b¢\u0006\u0004\bM\u0010NJ\b\u0010O\u001a\u00020,H\u0017J\u0010\u0010P\u001a\u00020,2\u0006\u0010Q\u001a\u00020,H\u0016J\u0018\u0010R\u001a\u00020,*\u00060:R\u00020\u00002\u0006\u0010Q\u001a\u00020,H\u0002J\u0016\u0010S\u001a\u00020,*\u0004\u0018\u00010\u00142\u0006\u0010Q\u001a\u00020,H\u0002J \u0010T\u001a\u00020,\"\u0004\b\u0000\u0010U*\b\u0012\u0004\u0012\u0002HU0V2\u0006\u0010Q\u001a\u00020,H\u0002R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\r\u0012\u0004\b\f\u0010\u0003R\u0012\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006Y"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;", "Landroidx/compose/runtime/composer/DebugStringFormattable;", "<init>", "()V", "value", "", "requiresApplication", "getRequiresApplication", "()Z", "opCodes", "", "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operation;", "getOpCodes$runtime$annotations", "[Landroidx/compose/runtime/composer/linkbuffer/changelist/Operation;", "opCodesSize", "", "intArgs", "", "intArgsSize", "objectArgs", "", "[Ljava/lang/Object;", "objectArgsSize", "pushedIntMask", "pushedObjectMask", "size", "getSize", "()I", "isEmpty", "isNotEmpty", "clear", "", "pushOp", "operation", "determineNewSize", "currentSize", "requiredSize", "resizeOpCodes", "ensureIntArgsSizeAtLeast", "resizeIntArgs", "ensureObjectArgsSizeAtLeast", "resizeObjectArgs", Constants.PUSH, "exceptionMessageForOperationPushNoScope", "", "args", "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations$WriteScope;", "Lkotlin/ExtensionFunctionType;", "ensureAllArgumentsPushedFor", "exceptionMessageForOperationPushWithScope", "createExpectedArgMask", "paramCount", "pop", "popInto", "other", "drain", "sink", "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations$OpIterator;", "forEach", "action", "executeAndFlushAllPendingOperations", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "indent", "peekOperation", "topIntIndexOf", "parameter", "Landroidx/compose/runtime/composer/linkbuffer/changelist/IntParameter;", "topObjectIndexOf", "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operation$ObjectParameter;", "topObjectIndexOf-gvac4VY", "(I)I", "toString", "toDebugString", "linePrefix", "currentOpToDebugString", "formatOpArgumentToString", "toCollectionString", ExifInterface.GPS_DIRECTION_TRUE, "", "WriteScope", "OpIterator", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Operations extends DebugStringFormattable {
    public static final int $stable = 8;
    public int intArgsSize;
    public int objectArgsSize;
    public int opCodesSize;
    private int pushedIntMask;
    private int pushedObjectMask;
    private boolean requiresApplication;
    public Operation[] opCodes = new Operation[16];
    public int[] intArgs = new int[16];
    public Object[] objectArgs = new Object[16];

    private final int createExpectedArgMask(int i) {
        return (i == 0 ? 0 : -1) >>> (32 - i);
    }

    public static /* synthetic */ void getOpCodes$runtime$annotations() {
    }

    public final boolean getRequiresApplication() {
        return this.requiresApplication;
    }

    public final int getSize() {
        return this.opCodesSize;
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final boolean isNotEmpty() {
        return getSize() != 0;
    }

    public final void clear() {
        this.opCodesSize = 0;
        this.intArgsSize = 0;
        ArraysKt.fill(this.objectArgs, (Object) null, 0, this.objectArgsSize);
        this.objectArgsSize = 0;
        this.requiresApplication = false;
    }

    public final void pushOp(Operation operation) {
        if (this.opCodesSize == this.opCodes.length) {
            resizeOpCodes();
        }
        int ints = this.intArgsSize + operation.getInts();
        int length = this.intArgs.length;
        if (ints > length) {
            resizeIntArgs(length, ints);
        }
        int objects = this.objectArgsSize + operation.getObjects();
        int length2 = this.objectArgs.length;
        if (objects > length2) {
            resizeObjectArgs(length2, objects);
        }
        Operation[] operationArr = this.opCodes;
        int i = this.opCodesSize;
        this.opCodesSize = i + 1;
        operationArr[i] = operation;
        this.intArgsSize += operation.getInts();
        this.objectArgsSize += operation.getObjects();
        if (operation.isExternallyVisible()) {
            this.requiresApplication = true;
        }
    }

    private final int determineNewSize(int i, int i2) {
        return RangesKt.coerceAtLeast(i + RangesKt.coerceAtMost(i, 1024), i2);
    }

    private final void resizeOpCodes() {
        int coerceAtMost = RangesKt.coerceAtMost(this.opCodesSize, 1024);
        int i = this.opCodesSize;
        Operation[] operationArr = new Operation[coerceAtMost + i];
        System.arraycopy(this.opCodes, 0, operationArr, 0, i);
        this.opCodes = operationArr;
    }

    private final void ensureIntArgsSizeAtLeast(int i) {
        int length = this.intArgs.length;
        if (i > length) {
            resizeIntArgs(length, i);
        }
    }

    private final void resizeIntArgs(int i, int i2) {
        int[] iArr = new int[determineNewSize(i, i2)];
        ArraysKt.copyInto(this.intArgs, iArr, 0, 0, i);
        this.intArgs = iArr;
    }

    private final void ensureObjectArgsSizeAtLeast(int i) {
        int length = this.objectArgs.length;
        if (i > length) {
            resizeObjectArgs(length, i);
        }
    }

    private final void resizeObjectArgs(int i, int i2) {
        Object[] objArr = new Object[determineNewSize(i, i2)];
        System.arraycopy(this.objectArgs, 0, objArr, 0, i);
        this.objectArgs = objArr;
    }

    public final void push(Operation operation) {
        pushOp(operation);
    }

    private final String exceptionMessageForOperationPushNoScope(Operation operation) {
        return "Cannot push " + operation + " without arguments because it expects " + operation.getInts() + " ints and " + operation.getObjects() + " objects.";
    }

    public final void push(Operation operation, Function1<? super WriteScope, Unit> function1) {
        pushOp(operation);
        function1.invoke(WriteScope.m4666boximpl(WriteScope.m4667constructorimpl(this)));
        ensureAllArgumentsPushedFor(operation);
    }

    public final void ensureAllArgumentsPushedFor(Operation operation) {
        int i = this.pushedIntMask;
        int ints = operation.getInts();
        if (i == ((ints == 0 ? 0 : -1) >>> (32 - ints))) {
            operation.getObjects();
        }
    }

    private final String exceptionMessageForOperationPushWithScope(Operation operation) {
        StringBuilder sb = new StringBuilder();
        int ints = operation.getInts();
        int i = 0;
        for (int i2 = 0; i2 < ints; i2++) {
            if (((1 << i2) & this.pushedIntMask) == 0) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(operation.intParamName(i2));
                i++;
            }
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        int objects = operation.getObjects();
        int i3 = 0;
        for (int i4 = 0; i4 < objects; i4++) {
            if (((1 << i4) & this.pushedObjectMask) == 0) {
                if (i > 0) {
                    sb3.append(", ");
                }
                sb3.append(operation.mo4619objectParamNamegvac4VY(Operation.ObjectParameter.m4642constructorimpl(i4)));
                i3++;
            }
        }
        return "Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + sb2 + ") and " + i3 + " object arguments (" + sb3.toString() + ").";
    }

    public final void pop() {
        Operation[] operationArr = this.opCodes;
        int i = this.opCodesSize - 1;
        this.opCodesSize = i;
        Operation operation = operationArr[i];
        operationArr[i] = null;
        int objects = operation.getObjects();
        for (int i2 = 0; i2 < objects; i2++) {
            Object[] objArr = this.objectArgs;
            int i3 = this.objectArgsSize - 1;
            this.objectArgsSize = i3;
            objArr[i3] = null;
        }
        this.intArgsSize -= operation.getInts();
    }

    public final void popInto(Operations operations) {
        Operation[] operationArr = this.opCodes;
        int i = this.opCodesSize - 1;
        this.opCodesSize = i;
        Operation operation = operationArr[i];
        operationArr[i] = null;
        operations.pushOp(operation);
        Object[] objArr = this.objectArgs;
        Object[] objArr2 = operations.objectArgs;
        int objects = operations.objectArgsSize - operation.getObjects();
        int objects2 = this.objectArgsSize - operation.getObjects();
        System.arraycopy(objArr, objects2, objArr2, objects, this.objectArgsSize - objects2);
        ArraysKt.fill(this.objectArgs, (Object) null, this.objectArgsSize - operation.getObjects(), this.objectArgsSize);
        ArraysKt.copyInto(this.intArgs, operations.intArgs, operations.intArgsSize - operation.getInts(), this.intArgsSize - operation.getInts(), this.intArgsSize);
        this.objectArgsSize -= operation.getObjects();
        this.intArgsSize -= operation.getInts();
    }

    public final void forEach(Function1<? super OpIterator, Unit> function1) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            do {
                function1.invoke(opIterator);
            } while (opIterator.next());
        }
    }

    private final String indent(String str) {
        return str + "    ";
    }

    private final Operation peekOperation() {
        return this.opCodes[this.opCodesSize - 1];
    }

    private final int topIntIndexOf(int i) {
        return (this.intArgsSize - this.opCodes[this.opCodesSize - 1].getInts()) + i;
    }

    /* renamed from: topObjectIndexOf-gvac4VY  reason: not valid java name */
    private final int m4665topObjectIndexOfgvac4VY(int i) {
        return (this.objectArgsSize - this.opCodes[this.opCodesSize - 1].getObjects()) + i;
    }

    /* compiled from: Operations.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\rH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001a\u00020\u000b2\n\u0010\u0013\u001a\u00060\rj\u0002`\u000e2\n\u0010\u0014\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J8\u0010\u0018\u001a\u00020\u000b2\n\u0010\u0019\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u001a\u001a\u00020\r2\n\u0010\u001b\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u001c\u001a\u00020\rH\u0086\b¢\u0006\u0004\b\u001d\u0010\u001eJL\u0010\u0018\u001a\u00020\u000b2\n\u0010\u0019\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u001a\u001a\u00020\r2\n\u0010\u001b\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u001c\u001a\u00020\r2\n\u0010\u001f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010 \u001a\u00020\rH\u0086\b¢\u0006\u0004\b\u001d\u0010!J)\u0010\"\u001a\u00020\u000b\"\u0004\b\u0000\u0010#2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H#0$2\u0006\u0010\u000f\u001a\u0002H#¢\u0006\u0004\b%\u0010&JE\u0010'\u001a\u00020\u000b\"\u0004\b\u0000\u0010#\"\u0004\b\u0001\u0010(2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H#0$2\u0006\u0010\u001a\u001a\u0002H#2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H(0$2\u0006\u0010\u001c\u001a\u0002H(¢\u0006\u0004\b)\u0010*Ja\u0010'\u001a\u00020\u000b\"\u0004\b\u0000\u0010#\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010+2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H#0$2\u0006\u0010\u001a\u001a\u0002H#2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H(0$2\u0006\u0010\u001c\u001a\u0002H(2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H+0$2\u0006\u0010 \u001a\u0002H+¢\u0006\u0004\b,\u0010-J}\u0010'\u001a\u00020\u000b\"\u0004\b\u0000\u0010#\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010+\"\u0004\b\u0003\u0010.2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H#0$2\u0006\u0010\u001a\u001a\u0002H#2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H(0$2\u0006\u0010\u001c\u001a\u0002H(2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H+0$2\u0006\u0010 \u001a\u0002H+2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.0$2\u0006\u00100\u001a\u0002H.¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u000b¢\u0006\u0004\b4\u00105J\u0014\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020\rHÖ\u0081\u0004J\n\u0010:\u001a\u00020;HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006<"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations$WriteScope;", "", "stack", "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;", "constructor-impl", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;)Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;", "operation", "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operation;", "getOperation-impl", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;)Landroidx/compose/runtime/composer/linkbuffer/changelist/Operation;", "setInt", "", "parameter", "", "Landroidx/compose/runtime/composer/linkbuffer/changelist/IntParameter;", "value", "setInt-impl", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;II)V", "setLong", "highParameter", "lowParameter", "", "setLong-impl", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;IIJ)V", "setInts", "parameter1", "value1", "parameter2", "value2", "setInts-impl", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;IIII)V", "parameter3", "value3", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;IIIIII)V", "setObject", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operation$ObjectParameter;", "setObject-aWHcuVo", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;ILjava/lang/Object;)V", "setObjects", "U", "setObjects-EykTJF8", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;ILjava/lang/Object;ILjava/lang/Object;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "setObjects-Gn0XI2A", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)V", ExifInterface.LONGITUDE_WEST, "parameter4", "value4", "setObjects-UOUgNZM", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)V", "requireApplication", "requireApplication-impl", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;)V", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    /* loaded from: classes.dex */
    public static final class WriteScope {
        private final Operations stack;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ WriteScope m4666boximpl(Operations operations) {
            return new WriteScope(operations);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static Operations m4667constructorimpl(Operations operations) {
            return operations;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m4668equalsimpl(Operations operations, Object obj) {
            return (obj instanceof WriteScope) && Intrinsics.areEqual(operations, ((WriteScope) obj).m4682unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m4669equalsimpl0(Operations operations, Operations operations2) {
            return Intrinsics.areEqual(operations, operations2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m4671hashCodeimpl(Operations operations) {
            return operations.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m4681toStringimpl(Operations operations) {
            return "WriteScope(stack=" + operations + ')';
        }

        public boolean equals(Object obj) {
            return m4668equalsimpl(this.stack, obj);
        }

        public int hashCode() {
            return m4671hashCodeimpl(this.stack);
        }

        public String toString() {
            return m4681toStringimpl(this.stack);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ Operations m4682unboximpl() {
            return this.stack;
        }

        private /* synthetic */ WriteScope(Operations operations) {
            this.stack = operations;
        }

        /* renamed from: setInt-impl  reason: not valid java name */
        public static final void m4673setIntimpl(Operations operations, int i, int i2) {
            operations.intArgs[(operations.intArgsSize - operations.opCodes[operations.opCodesSize - 1].getInts()) + i] = i2;
        }

        /* renamed from: setInts-impl  reason: not valid java name */
        public static final void m4674setIntsimpl(Operations operations, int i, int i2, int i3, int i4) {
            int ints = operations.intArgsSize - operations.opCodes[operations.opCodesSize - 1].getInts();
            int[] iArr = operations.intArgs;
            iArr[i + ints] = i2;
            iArr[ints + i3] = i4;
        }

        /* renamed from: setInts-impl  reason: not valid java name */
        public static final void m4675setIntsimpl(Operations operations, int i, int i2, int i3, int i4, int i5, int i6) {
            int ints = operations.intArgsSize - operations.opCodes[operations.opCodesSize - 1].getInts();
            int[] iArr = operations.intArgs;
            iArr[i + ints] = i2;
            iArr[i3 + ints] = i4;
            iArr[ints + i5] = i6;
        }

        /* renamed from: setObject-aWHcuVo  reason: not valid java name */
        public static final <T> void m4677setObjectaWHcuVo(Operations operations, int i, T t) {
            operations.objectArgs[(operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].getObjects()) + i] = t;
        }

        /* renamed from: setObjects-EykTJF8  reason: not valid java name */
        public static final <T, U> void m4678setObjectsEykTJF8(Operations operations, int i, T t, int i2, U u) {
            int objects = operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].getObjects();
            Object[] objArr = operations.objectArgs;
            objArr[i + objects] = t;
            objArr[objects + i2] = u;
        }

        /* renamed from: setObjects-Gn0XI2A  reason: not valid java name */
        public static final <T, U, V> void m4679setObjectsGn0XI2A(Operations operations, int i, T t, int i2, U u, int i3, V v) {
            int objects = operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].getObjects();
            Object[] objArr = operations.objectArgs;
            objArr[i + objects] = t;
            objArr[i2 + objects] = u;
            objArr[objects + i3] = v;
        }

        /* renamed from: setObjects-UOUgNZM  reason: not valid java name */
        public static final <T, U, V, W> void m4680setObjectsUOUgNZM(Operations operations, int i, T t, int i2, U u, int i3, V v, int i4, W w) {
            int objects = operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].getObjects();
            Object[] objArr = operations.objectArgs;
            objArr[i + objects] = t;
            objArr[i2 + objects] = u;
            objArr[i3 + objects] = v;
            objArr[objects + i4] = w;
        }

        /* renamed from: requireApplication-impl  reason: not valid java name */
        public static final void m4672requireApplicationimpl(Operations operations) {
            operations.requiresApplication = true;
        }

        /* renamed from: getOperation-impl  reason: not valid java name */
        public static final Operation m4670getOperationimpl(Operations operations) {
            return operations.opCodes[operations.opCodesSize - 1];
        }

        /* renamed from: setLong-impl  reason: not valid java name */
        public static final void m4676setLongimpl(Operations operations, int i, int i2, long j) {
            operations.intArgs[(operations.intArgsSize - operations.opCodes[operations.opCodesSize - 1].getInts()) + i] = (int) (j >>> 32);
            operations.intArgs[(operations.intArgsSize - operations.opCodes[operations.opCodesSize - 1].getInts()) + i2] = (int) j;
        }
    }

    /* compiled from: Operations.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u000e\u001a\u00020\u00052\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u0010H\u0016J#\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations$OpIterator;", "Landroidx/compose/runtime/composer/linkbuffer/changelist/OperationArgContainer;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/changelist/Operations;)V", "opIdx", "", "intIdx", "objIdx", "next", "", "operation", "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operation;", "getOperation", "()Landroidx/compose/runtime/composer/linkbuffer/changelist/Operation;", "getInt", "parameter", "Landroidx/compose/runtime/composer/linkbuffer/changelist/IntParameter;", "getObject", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/composer/linkbuffer/changelist/Operation$ObjectParameter;", "getObject-gvac4VY", "(I)Ljava/lang/Object;", "currentOperationDebugString", "", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class OpIterator implements OperationArgContainer {
        private int intIdx;
        private int objIdx;
        private int opIdx;

        public OpIterator() {
        }

        public final boolean next() {
            if (this.opIdx >= Operations.this.opCodesSize) {
                return false;
            }
            Operation operation = getOperation();
            this.intIdx += operation.getInts();
            this.objIdx += operation.getObjects();
            int i = this.opIdx + 1;
            this.opIdx = i;
            return i < Operations.this.opCodesSize;
        }

        public final Operation getOperation() {
            return Operations.this.opCodes[this.opIdx];
        }

        @Override // androidx.compose.runtime.composer.linkbuffer.changelist.OperationArgContainer
        public int getInt(int i) {
            return Operations.this.intArgs[this.intIdx + i];
        }

        @Override // androidx.compose.runtime.composer.linkbuffer.changelist.OperationArgContainer
        /* renamed from: getObject-gvac4VY */
        public <T> T mo4664getObjectgvac4VY(int i) {
            return (T) Operations.this.objectArgs[this.objIdx + i];
        }

        public final String currentOperationDebugString() {
            Operations operations = Operations.this;
            return "operation[" + this.opIdx + "] = " + operations.currentOpToDebugString(this, "");
        }
    }

    @Deprecated(message = "toString() will return the default implementation from Any. Did you mean to use toDebugString()?", replaceWith = @ReplaceWith(expression = "toDebugString()", imports = {}))
    public String toString() {
        return super.toString();
    }

    @Override // androidx.compose.runtime.composer.DebugStringFormattable
    public String toDebugString(String str) {
        StringBuilder sb = new StringBuilder();
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            int i = 0;
            while (true) {
                sb.append(str);
                int i2 = i + 1;
                sb.append(i);
                sb.append(". ");
                sb.append(currentOpToDebugString(opIterator, str)).append('\n');
                if (!opIterator.next()) {
                    break;
                }
                i = i2;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String currentOpToDebugString(OpIterator opIterator, String str) {
        Operation operation = opIterator.getOperation();
        if (operation.getInts() == 0 && operation.getObjects() == 0) {
            return operation.getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(operation.getName());
        sb.append('(');
        String indent = indent(str);
        int ints = operation.getInts();
        boolean z = true;
        for (int i = 0; i < ints; i++) {
            String intParamName = operation.intParamName(i);
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append('\n');
            sb.append(indent);
            sb.append(intParamName);
            sb.append(" = ");
            sb.append(opIterator.getInt(i));
        }
        int objects = operation.getObjects();
        for (int i2 = 0; i2 < objects; i2++) {
            int m4642constructorimpl = Operation.ObjectParameter.m4642constructorimpl(i2);
            String mo4619objectParamNamegvac4VY = operation.mo4619objectParamNamegvac4VY(m4642constructorimpl);
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append('\n');
            sb.append(indent);
            sb.append(mo4619objectParamNamegvac4VY);
            sb.append(" = ");
            sb.append(formatOpArgumentToString(opIterator.mo4664getObjectgvac4VY(m4642constructorimpl), indent));
        }
        sb.append('\n');
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatOpArgumentToString(Object obj, String str) {
        if (obj == null) {
            return AbstractJsonLexerKt.NULL;
        }
        return obj instanceof Object[] ? toCollectionString(ArraysKt.asIterable((Object[]) obj), str) : obj instanceof int[] ? toCollectionString(ArraysKt.asIterable((int[]) obj), str) : obj instanceof long[] ? toCollectionString(ArraysKt.asIterable((long[]) obj), str) : obj instanceof float[] ? toCollectionString(ArraysKt.asIterable((float[]) obj), str) : obj instanceof double[] ? toCollectionString(ArraysKt.asIterable((double[]) obj), str) : obj instanceof Iterable ? toCollectionString((Iterable) obj, str) : obj instanceof DebugStringFormattable ? ((DebugStringFormattable) obj).toDebugString(str) : obj.toString();
    }

    private final <T> String toCollectionString(Iterable<? extends T> iterable, final String str) {
        return CollectionsKt.joinToString$default(iterable, ", ", "[", "]", 0, null, new Function1() { // from class: androidx.compose.runtime.composer.linkbuffer.changelist.Operations$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence formatOpArgumentToString;
                formatOpArgumentToString = Operations.this.formatOpArgumentToString(obj, str);
                return formatOpArgumentToString;
            }
        }, 24, null);
    }

    public final void drain(Function1<? super OpIterator, Unit> function1) {
        if (!isNotEmpty()) {
            clear();
        }
        OpIterator opIterator = new OpIterator();
        do {
            function1.invoke(opIterator);
        } while (opIterator.next());
        clear();
    }

    public final void executeAndFlushAllPendingOperations(Applier<?> applier, SlotTableEditor slotTableEditor, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            while (true) {
                Applier<?> applier2 = applier;
                SlotTableEditor slotTableEditor2 = slotTableEditor;
                RememberManager rememberManager2 = rememberManager;
                OperationErrorContext operationErrorContext2 = operationErrorContext;
                opIterator.getOperation().executeWithComposeStackTrace(opIterator, applier2, slotTableEditor2, rememberManager2, operationErrorContext2);
                if (!opIterator.next()) {
                    break;
                }
                applier = applier2;
                slotTableEditor = slotTableEditor2;
                rememberManager = rememberManager2;
                operationErrorContext = operationErrorContext2;
            }
        }
        clear();
    }
}
