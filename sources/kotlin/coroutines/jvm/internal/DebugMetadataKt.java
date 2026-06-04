package kotlin.coroutines.jvm.internal;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DebugMetadata.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a5\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003b\u0002\b\t¢\u0006\u0002\b\u0003\u001a\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0002H\u0082\u0080\u0004\u001a\u000e\u0010\f\u001a\u00020\r*\u00020\u0002H\u0082\u0080\u0004\u001a;\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f*\u00020\u0002H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000eb\u0002\b\t¢\u0006\u0002\u0010\u0011\u001a \u0010\u0014\u001a\u00020\r*\u00020\u0002H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015b\u0002\b\t\"\u000f\u0010\u0012\u001a\u00020\rX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0013\u001a\u00020\rX\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getStackTraceElement", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3", "Lkotlin/jvm/JvmName;", "name", "Lkotlin/PublishedApi;", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "getLabel", "", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "COROUTINES_DEBUG_METADATA_VERSION_1_3", "COROUTINES_DEBUG_METADATA_VERSION_2_2", "getNextLineNumber", "2.2", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DebugMetadataKt {
    private static final int COROUTINES_DEBUG_METADATA_VERSION_1_3 = 1;
    private static final int COROUTINES_DEBUG_METADATA_VERSION_2_2 = 2;

    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation != null && debugMetadataAnnotation.v() >= 1) {
            int label = getLabel(baseContinuationImpl);
            int i = label < 0 ? -1 : debugMetadataAnnotation.l()[label];
            String moduleName = ModuleNameRetriever.INSTANCE.getModuleName(baseContinuationImpl);
            return new StackTraceElement(moduleName == null ? debugMetadataAnnotation.c() : moduleName + '/' + debugMetadataAnnotation.c(), debugMetadataAnnotation.m(), debugMetadataAnnotation.f(), i);
        }
        return null;
    }

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(BaseContinuationImpl baseContinuationImpl) {
        if (baseContinuationImpl instanceof TailCallBaseContinuationImpl) {
            return 0;
        }
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField(Constants.ScionAnalytics.PARAM_LABEL);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation != null && debugMetadataAnnotation.v() >= 1) {
            ArrayList arrayList = new ArrayList();
            int label = getLabel(baseContinuationImpl);
            int[] i = debugMetadataAnnotation.i();
            int length = i.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (i[i2] == label) {
                    arrayList.add(debugMetadataAnnotation.s()[i2]);
                    arrayList.add(debugMetadataAnnotation.n()[i2]);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return null;
    }

    public static final int getNextLineNumber(BaseContinuationImpl baseContinuationImpl) {
        int label;
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation != null && debugMetadataAnnotation.v() >= 2 && (label = getLabel(baseContinuationImpl)) >= 0 && label < debugMetadataAnnotation.nl().length) {
            return debugMetadataAnnotation.nl()[label];
        }
        return -1;
    }
}
