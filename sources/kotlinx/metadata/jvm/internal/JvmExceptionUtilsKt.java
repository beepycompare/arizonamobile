package kotlinx.metadata.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.InconsistentKotlinMetadataException;
/* compiled from: JvmExceptionUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a%\u0010\u0005\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\tH\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"wrapIntoMetadataExceptionWhenNeeded", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "wrapWriteIntoIAE", "requireNotEmpty", "", "", "Lkotlin/Metadata;", "(Lkotlin/Metadata;)[Ljava/lang/String;", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmExceptionUtilsKt {
    public static final String[] requireNotEmpty(Metadata metadata) {
        Intrinsics.checkNotNullParameter(metadata, "<this>");
        String[] d1 = metadata.d1();
        if (d1.length == 0) {
            d1 = null;
        }
        if (d1 != null) {
            return d1;
        }
        throw new InconsistentKotlinMetadataException("Metadata is missing: kotlin.Metadata.data1 must not be an empty array", null, 2, null);
    }

    public static final <T> T wrapIntoMetadataExceptionWhenNeeded(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke();
        } finally {
        }
    }

    public static final <T> T wrapWriteIntoIAE(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke();
        } finally {
        }
    }
}
